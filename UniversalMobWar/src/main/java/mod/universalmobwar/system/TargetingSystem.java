package mod.universalmobwar.system;

import mod.universalmobwar.config.ModConfig;
import mod.universalmobwar.data.MobWarData;
import mod.universalmobwar.util.TargetingUtil;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.Mob;
import net.minecraft.server.level.ServerLevel;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

/**
 * TARGETING SYSTEM - Independent Module
 * 
 * Central system for mob-vs-mob combat targeting logic.
 * Manages which mobs can fight which other mobs.
 * 
 * This system works independently and can be enabled/disabled via:
 * - Config: targetingEnabled
 * - Gamerule: universalMobWarEnabled
 * 
 * Optional integration with:
 * - Alliance system (if allianceEnabled)
 * - Warlord system (respects minion protection)
 * 
 * Does NOT depend on: Scaling system
 * 
 * To use this system:
 * 1. Call isEnabled() to check if targeting should be active
 * 2. Call findTarget() to get a valid target for a mob
 * 3. Call isValidTarget() to verify a target is still valid
 * 4. Call updateTargetData() after setting a new target
 */
public class TargetingSystem {

    // ==========================================================================
    //                              CONFIGURATION
    // ==========================================================================
    
    // Cache for staggered update cooldowns (UUID -> next update tick)
    private static final Map<UUID, Integer> updateCooldowns = new ConcurrentHashMap<>();
    
    // Default follow range if not specified
    private static final double DEFAULT_FOLLOW_RANGE = 16.0;
    
    // ==========================================================================
    //                           STATUS METHODS
    // ==========================================================================
    
    /**
     * Check if targeting system is enabled (config + gamerule)
     */
    public static boolean isEnabled(ServerLevel world) {
        ModConfig config = ModConfig.getInstance();
        return config.isTargetingActive();
    }
    
    /**
     * Check if a mob should ignore same-species targets
     */
    public static boolean shouldIgnoreSameSpecies(ServerLevel world) {
        return ModConfig.getInstance().ignoreSameSpecies;
    }
    
    /**
     * Check if players should be targeted
     */
    public static boolean shouldTargetPlayers(ServerLevel world) {
        return ModConfig.getInstance().targetPlayers;
    }
    
    /**
     * Get range multiplier for target detection (converts percent to multiplier)
     */
    public static double getRangeMultiplier() {
        return ModConfig.getInstance().getRangeMultiplier();
    }
    
    // ==========================================================================
    //                           TARGET FINDING
    // ==========================================================================
    
    /**
     * Find a valid target for a mob
     * @param mob The mob looking for a target
     * @return A valid target or null if none found
     */
    public static LivingEntity findTarget(Mob mob) {
        if (!(mob.level() instanceof ServerLevel world)) return null;
        if (!isEnabled(world)) return null;
        if (!mob.isAlive()) return null;
        
        boolean ignoreSame = shouldIgnoreSameSpecies(world);
        boolean targetPlayers = shouldTargetPlayers(world);
        double rangeMultiplier = getRangeMultiplier();
        
        double followRange = getFollowRange(mob) * rangeMultiplier;
        
        // If alliance system is enabled, check for friends to help first
        if (AllianceSystem.isEnabled(world)) {
            LivingEntity friendToHelp = AllianceSystem.findFriendToHelp(mob, followRange);
            if (friendToHelp != null) {
                return friendToHelp;
            }
        }
        
        // Find nearest valid target using utility
        return TargetingUtil.findNearestValidTarget(mob, followRange, ignoreSame, targetPlayers);
    }
    
    /**
     * Check if a mob should update its target search (for staggering)
     * @param mob The mob to check
     * @return true if the mob should search for a target this tick
     */
    public static boolean shouldUpdateThisTick(Mob mob) {
        UUID uuid = mob.getUUID();
        int currentTick = (int)(mob.level().getGameTime() % Integer.MAX_VALUE);
        
        Integer nextUpdate = updateCooldowns.get(uuid);
        if (nextUpdate == null || currentTick >= nextUpdate) {
            // Stagger next update: 10 base ticks + UUID-based offset
            int offset = Math.abs(uuid.hashCode()) % 10;
            updateCooldowns.put(uuid, currentTick + 10 + offset);
            return true;
        }
        
        return false;
    }
    
    /**
     * Set a longer cooldown for mobs that found no target
     */
    public static void setLongCooldown(Mob mob) {
        UUID uuid = mob.getUUID();
        int currentTick = (int)(mob.level().getGameTime() % Integer.MAX_VALUE);
        // Wait 2 seconds before searching again
        updateCooldowns.put(uuid, currentTick + 40);
    }
    
    // ==========================================================================
    //                           TARGET VALIDATION
    // ==========================================================================
    
    /**
     * Check if a target is still valid for a mob
     * @param mob The attacker
     * @param target The potential target
     * @return true if the target is valid
     */
    public static boolean isValidTarget(Mob mob, LivingEntity target) {
        if (!(mob.level() instanceof ServerLevel world)) return false;
        if (!isEnabled(world)) return false;
        if (target == null || !target.isAlive()) return false;
        
        boolean ignoreSame = shouldIgnoreSameSpecies(world);
        boolean targetPlayers = shouldTargetPlayers(world);
        
        return TargetingUtil.isValidTarget(mob, target, ignoreSame, targetPlayers);
    }
    
    /**
     * Check if an existing target should be kept (priority logic)
     * @param mob The mob with the target
     * @return true if current target should be kept
     */
    public static boolean shouldKeepCurrentTarget(Mob mob) {
        LivingEntity currentTarget = mob.getTarget();
        if (currentTarget == null || !currentTarget.isAlive()) return false;
        
        MobWarData data = MobWarData.get(mob);
        if (data.getCurrentTarget() != null && data.getCurrentTarget().equals(currentTarget.getUUID())) {
            // Keep current target if we've been fighting them recently (5 seconds)
            return data.getTimeSinceTargetChange() < 5000;
        }
        
        return false;
    }
    
    // ==========================================================================
    //                           TARGET TRACKING
    // ==========================================================================
    
    /**
     * Update target tracking data after setting a new target
     * @param mob The mob
     * @param target The new target
     */
    public static void updateTargetData(Mob mob, LivingEntity target) {
        if (target == null) return;
        
        MobWarData data = MobWarData.get(mob);
        data.setCurrentTarget(target.getUUID());
        MobWarData.save(mob, data);
        
        // Update alliances if enabled
        if (mob.level() instanceof ServerLevel world && AllianceSystem.isEnabled(world)) {
            AllianceSystem.updateAlliances(mob, world);
        }
    }
    
    /**
     * Update alliance checks during combat (call periodically)
     * @param mob The mob in combat
     */
    public static void updateCombatAlliances(Mob mob) {
        if (!(mob.level() instanceof ServerLevel world)) return;
        if (!AllianceSystem.isEnabled(world)) return;
        
        AllianceSystem.updateAlliances(mob, world);
        AllianceSystem.cleanupExpiredAlliances(mob);
    }
    
    // ==========================================================================
    //                           HELPER METHODS
    // ==========================================================================
    
    /**
     * Get the follow range for a mob
     */
    public static double getFollowRange(Mob mob) {
        AttributeInstance inst = mob.getAttribute(Attributes.FOLLOW_RANGE);
        return inst != null ? inst.getValue() : DEFAULT_FOLLOW_RANGE;
    }
    
    /**
     * Clear cached data for a mob (call when mob dies/despawns)
     */
    public static void clearMobData(UUID mobUuid) {
        updateCooldowns.remove(mobUuid);
    }
}
