package mod.universalmobwar.mixin;

import mod.universalmobwar.UniversalMobWarMod;
import mod.universalmobwar.util.SummonerTracker;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.Mob;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.level.ServerLevelAccessor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * Automatically tracks summoner-summoned relationships for ALL mobs.
 * Works for vanilla and modded mobs that use EntitySpawnReason.MOB_SUMMONED.
 */
@Mixin(Mob.class)
public abstract class UniversalSummonerTrackingMixin {
    
    /**
     * Intercepts mob initialization to detect and track summoned mobs.
     * This is called when any mob spawns, including:
     * - Evoker summoning Vexes
     * - Illusioner summoning duplicates
     * - Any modded mob summoning others
     */
    @Inject(method = "finalizeSpawn", at = @At("RETURN"))
    private void universalmobwar$trackSummonedMob(
        ServerLevelAccessor world, 
        DifficultyInstance difficulty, 
        EntitySpawnReason spawnReason, 
        SpawnGroupData entityData,
        CallbackInfoReturnable<SpawnGroupData> cir
    ) {
        UniversalMobWarMod.runSafely("UniversalSummonerTrackingMixin#trackSummonedMob", () -> {
            Mob self = (Mob)(Object)this;
            
            // Only track if this mob was summoned AND we're in a ServerLevel
            if ((spawnReason == EntitySpawnReason.MOB_SUMMONED || spawnReason == EntitySpawnReason.EVENT) 
                && world instanceof ServerLevel serverWorld) {
                // Try to find the summoner by looking for nearby mobs that could have summoned this one
                // Common summoners: Evoker, Illusioner, Warlord, etc.
                
                // Look for potential summoners within 16 blocks
                Mob closestSummoner = serverWorld.getEntitiesOfClass(
                    Mob.class,
                    self.getBoundingBox().inflate(16.0),
                    entity -> entity != self && 
                             entity.isAlive() &&
                             entity.distanceToSqr(self) < 256.0 && // Within 16 blocks
                             couldSummon(entity)
                ).stream()
                    .min((a, b) -> Double.compare(a.distanceToSqr(self), b.distanceToSqr(self)))
                    .orElse(null);
                
                if (closestSummoner != null) {
                    SummonerTracker.registerSummoned(self.getUUID(), closestSummoner.getUUID());
                }
            }
        });
    }
    
    /**
     * Checks if a mob could potentially summon other mobs.
     * This includes known vanilla summoners and is permissive for modded mobs.
     */
    private static boolean couldSummon(Entity entity) {
        String entityType = entity.getType().toString();
        
        // Known vanilla summoners
        if (entityType.contains("evoker") || 
            entityType.contains("illusioner") ||
            entityType.contains("warlord") ||
            entityType.contains("witch") ||
            entityType.contains("necromancer") || // Modded
            entityType.contains("summoner")) {    // Modded
            return true;
        }
        
        // For safety, assume any hostile mob with high max health could be a summoner
        // This catches modded bosses
        if (entity instanceof Mob mob) {
            return mob.getMaxHealth() > 100.0f; // Likely a boss or special mob
        }
        
        return false;
    }
}
