package mod.universalmobwar.goal;

import mod.universalmobwar.config.ModConfig;
import mod.universalmobwar.data.MobWarData;
import mod.universalmobwar.entity.MobWarlordEntity;
import mod.universalmobwar.system.AllianceSystem;
import mod.universalmobwar.system.TargetingSystem;
import mod.universalmobwar.system.WarlordSystem;
import mod.universalmobwar.util.TargetingUtil;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.target.TargetGoal;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.NeutralMob;
import net.minecraft.world.entity.Mob;
import net.minecraft.server.level.ServerLevel;

import java.util.UUID;
import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;

/**
 * TARGETING SYSTEM - Independent Module
 * 
 * Universal targeting AI goal for mobs to attack each other intelligently.
 * 
 * This system works independently and can be enabled/disabled via:
 * - Config: targetingEnabled
 * - Gamerule: universalMobWarEnabled
 * 
 * Can optionally integrate with:
 * - Alliance system (if allianceEnabled)
 * - Warlord system (respects minion protection)
 * 
 * Does NOT depend on: Scaling system
 */
public class UniversalTargetGoal extends TargetGoal {

	// ==========================================================================
	//                              CONFIGURATION
	// ==========================================================================
	
	private final Mob mob;
	private final BooleanSupplier modEnabledSupplier;
	private final BooleanSupplier ignoreSameSpeciesSupplier;
	private final BooleanSupplier targetPlayersSupplier;
	private final BooleanSupplier allianceEnabledSupplier;
	private final DoubleSupplier rangeMultiplierSupplier;
	private LivingEntity candidate;
	private long lastAllianceCheck = 0;
	private int updateCooldown = 0; // Staggered update system for performance
	private int allianceCheckInterval = 2000; // Dynamic alliance check interval
	private final long allianceCheckOffset; // UUID-based offset for staggering alliance updates

	// ==========================================================================
	//                         NEUTRAL MOB HELPERS
	// ==========================================================================

	private boolean allowNeutralAggression() {
		ModConfig config = ModConfig.getInstance();
		if (config.neutralMobsAlwaysAggressive) {
			return true;
		}
		return !(mob instanceof NeutralMob);
	}

	// ==========================================================================
	//                              CONSTRUCTOR
	// ==========================================================================
	
	public UniversalTargetGoal(
		Mob mob,
		BooleanSupplier modEnabledSupplier,
		BooleanSupplier ignoreSameSpeciesSupplier,
		BooleanSupplier targetPlayersSupplier,
		BooleanSupplier allianceEnabledSupplier,
		DoubleSupplier rangeMultiplierSupplier
	) {
		super(mob, false, false);
		this.mob = mob;
		this.modEnabledSupplier = modEnabledSupplier;
		this.ignoreSameSpeciesSupplier = ignoreSameSpeciesSupplier;
		this.targetPlayersSupplier = targetPlayersSupplier;
		this.allianceEnabledSupplier = allianceEnabledSupplier;
		this.rangeMultiplierSupplier = rangeMultiplierSupplier;
		// OPTIMIZATION: Calculate UUID-based offset for staggering alliance updates (0-2000ms)
		this.allianceCheckOffset = Math.abs(mob.getUUID().hashCode()) % 2000L;
	}

	// ==========================================================================
	//                           HELPER METHODS
	// ==========================================================================
	
	/**
	 * Check if targeting system is active
	 */
	private boolean isTargetingEnabled() {
		// First check config
		if (!ModConfig.getInstance().isTargetingActive()) return false;
		// Then check the gamerule supplier
		return modEnabledSupplier.getAsBoolean();
	}
	
	/**
	 * Check if alliance integration is active
	 */
	private boolean isAllianceIntegrationEnabled() {
		// Alliance system must be enabled in config AND via supplier
		return ModConfig.getInstance().isAllianceActive() && allianceEnabledSupplier.getAsBoolean();
	}
	
	/**
	 * Check if this mob is a warlord minion (for warlord integration)
	 * Uses WarlordSystem for centralized minion tracking.
	 */
	private UUID getMasterUuidIfMinion() {
		// Only check if warlord system is enabled
		if (!WarlordSystem.isEnabled()) return null;
		return WarlordSystem.getMasterUuid(mob.getUUID());
	}

	// ==========================================================================
	//                           GOAL METHODS
	// ==========================================================================

	@Override
	public boolean canUse() {
		// OPTIMIZATION: Stagger updates - not all mobs search every tick
		if (updateCooldown > 0) {
			updateCooldown--;
			// Still keep current target if valid
			LivingEntity currentTarget = mob.getTarget();
			if (currentTarget != null && currentTarget.isAlive()) {
				return false;
			}
			return false;
		}
		// Spread updates over 10 ticks using UUID-based offset
		updateCooldown = 10 + (Math.abs(mob.getUUID().hashCode()) % 10);

		// Check if targeting system is enabled
		if (!isTargetingEnabled()) return false;
		if (!(mob.level() instanceof ServerLevel)) return false;
		if (!mob.isAlive()) return false;
		if (!allowNeutralAggression()) {
			return false;
		}

		// WARLORD INTEGRATION: Check if this mob is a warlord minion
		// Uses WarlordSystem for centralized minion tracking
		UUID masterUuid = getMasterUuidIfMinion();
		if (masterUuid != null) {
			// This is a minion - clear any invalid targets
			LivingEntity currentTarget = mob.getTarget();
			if (currentTarget != null) {
				// Don't target the warlord master
				if (currentTarget instanceof MobWarlordEntity warlord && warlord.getUUID().equals(masterUuid)) {
					mob.setTarget(null);
					return false;
				}
				// Don't target fellow minions (same master) - use WarlordSystem
				if (currentTarget instanceof Mob targetMob) {
					if (WarlordSystem.isMinionOf(targetMob.getUUID(), masterUuid)) {
						mob.setTarget(null);
						return false;
					}
				}
			}
		}

		// Priority 1: If we already have a living target that's still valid, stick with it
		LivingEntity currentTarget = mob.getTarget();
		if (currentTarget != null && currentTarget.isAlive()) {
			MobWarData data = MobWarData.get(mob);
			// Prioritize current target if we've been fighting them recently
			if (data.getCurrentTarget() != null && data.getCurrentTarget().equals(currentTarget.getUUID())) {
				if (data.getTimeSinceTargetChange() < 5000) { // 5 seconds
					return false; // Keep current target
				}
			}
		}

		final boolean ignoreSame = ignoreSameSpeciesSupplier.getAsBoolean();
		final boolean targetPlayers = targetPlayersSupplier.getAsBoolean();
		final double rangeMultiplier = rangeMultiplierSupplier.getAsDouble();

		double followRange = 16.0;
		AttributeInstance inst = mob.getAttributeInstance(Attributes.FOLLOW_RANGE);
		if (inst != null) followRange = inst.getValue();
		followRange *= rangeMultiplier;

		// Priority 2: ALLIANCE INTEGRATION - Check if we should help an ally
		if (isAllianceIntegrationEnabled()) {
			LivingEntity friendToHelp = AllianceSystem.findFriendToHelp(mob, followRange);
			if (friendToHelp != null) {
				this.candidate = friendToHelp;
				return true;
			}
		}

		// Priority 3: Find nearest valid target
		this.candidate = TargetingUtil.findNearestValidTarget(mob, followRange, ignoreSame, targetPlayers);

		// OPTIMIZATION: Longer cooldown if no target found
		if (this.candidate == null) {
			updateCooldown = 40; // Wait 2 seconds before searching again
		}

		return this.candidate != null;
	}

	@Override
	public void start() {
		if (!allowNeutralAggression()) {
			this.candidate = null;
			return;
		}
		if (this.candidate != null) {
			// WARLORD INTEGRATION: Double-check if this mob is a warlord minion before setting target
			// Uses WarlordSystem for centralized minion tracking
			UUID masterUuid = getMasterUuidIfMinion();
			if (masterUuid != null) {
				// This is a minion - validate the candidate
				// Don't target the warlord master
				if (this.candidate instanceof MobWarlordEntity warlord && warlord.getUUID().equals(masterUuid)) {
					this.candidate = null;
					return;
				}
				// Don't target fellow minions (same master) - use WarlordSystem
				if (this.candidate instanceof Mob targetMob) {
					if (WarlordSystem.isMinionOf(targetMob.getUUID(), masterUuid)) {
						this.candidate = null;
						return;
					}
				}
			}
			mob.setTarget(this.candidate);
			// Track target change - use TargetingSystem helper
			TargetingSystem.updateTargetData(mob, this.candidate);
			// ALLIANCE INTEGRATION: Update alliances if enabled
			if (isAllianceIntegrationEnabled() && mob.level() instanceof ServerLevel serverWorld) {
				AllianceSystem.updateAlliances(mob, serverWorld);
			}
		}
		super.start();
	}

	@Override
	public boolean canContinueToUse() {
		if (!allowNeutralAggression()) {
			return false;
		}
		// Check if targeting system is still enabled
		if (!isTargetingEnabled()) return false;
		LivingEntity t = mob.getTarget();
		if (t == null || !t.isAlive()) return false;
		final boolean ignoreSame = ignoreSameSpeciesSupplier.getAsBoolean();
		final boolean targetPlayers = targetPlayersSupplier.getAsBoolean();
		
		// ALLIANCE INTEGRATION: Dynamic alliance check interval based on combat state with UUID offset
		if (isAllianceIntegrationEnabled()) {
			long currentTime = System.currentTimeMillis();
			long timeSinceLastCheck = currentTime - lastAllianceCheck;
			// OPTIMIZATION: Use offset to stagger alliance updates across all mobs
			if (timeSinceLastCheck > (allianceCheckInterval + allianceCheckOffset)) {
				if (mob.level() instanceof ServerLevel serverWorld) {
					// Check if in active combat (recently attacked)
					boolean inCombat = (currentTime - mob.getLastHurtMobTimestamp() < 3000);
					// Adjust interval: 2s in combat, 4s when calm
					allianceCheckInterval = inCombat ? 2000 : 4000;
					AllianceSystem.updateAlliances(mob, serverWorld);
					AllianceSystem.cleanupExpiredAlliances(mob);
				}
				lastAllianceCheck = currentTime;
			}
		}
		return TargetingUtil.isValidTarget(mob, t, ignoreSame, targetPlayers);
	}

	@Override
	public void stop() {
		this.candidate = null;
		// Don't clear target tracking - keep it for priority system
		super.stop();
	}
}
