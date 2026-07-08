package mod.universalmobwar.goal;

import mod.universalmobwar.data.MobWarData;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Mob;

import java.util.EnumSet;

/**
 * Prevents infinite fights by applying escalating buffs to the attacker
 * and debuffs to the victim as combat drags on.
 */
public class StalemateBreakerGoal extends Goal {

    private final Mob mob;
    private static final long STAGE_1_THRESHOLD = 15000; // 15 seconds
    private static final long STAGE_2_THRESHOLD = 30000; // 30 seconds
    private static final long STAGE_3_THRESHOLD = 45000; // 45 seconds

    public StalemateBreakerGoal(Mob mob) {
        this.mob = mob;
        this.setFlags(EnumSet.noneOf(Goal.Flag.class)); // Runs in parallel with everything
    }

    @Override
    public boolean canUse() {
        LivingEntity target = mob.getTarget();
        return target instanceof Mob && target.isAlive();
    }

    @Override
    public void tick() {
        LivingEntity potentialTarget = mob.getTarget();
        if (!(potentialTarget instanceof Mob target) || !target.isAlive()) {
            return; // Players (and other non-mobs) should never trigger stalemate buffs
        }

        MobWarData data = MobWarData.get(mob);
        // Ensure we are tracking the current target
        if (data.getCurrentTarget() == null || !data.getCurrentTarget().equals(target.getUUID())) {
            data.setCurrentTarget(target.getUUID());
            MobWarData.save(mob, data);
            return;
        }

        long combatDuration = data.getTimeSinceTargetChange();

        // Stage 1: Berserk (15s+)
        if (combatDuration > STAGE_1_THRESHOLD) {
            if (!mob.hasEffect(MobEffects.STRENGTH)) {
                mob.addEffect(new MobEffectInstance(MobEffects.STRENGTH, 100, 1)); // Strength II
                mob.addEffect(new MobEffectInstance(MobEffects.SPEED, 100, 1));    // Speed II
            }
        }

        // Stage 2: Hyper-Lethality (30s+)
        if (combatDuration > STAGE_2_THRESHOLD) {
            if (!mob.hasEffect(MobEffects.STRENGTH) || mob.getEffect(MobEffects.STRENGTH).getAmplifier() < 3) {
                mob.addEffect(new MobEffectInstance(MobEffects.STRENGTH, 100, 3)); // Strength IV
                mob.addEffect(new MobEffectInstance(MobEffects.HASTE, 100, 2));    // Haste III
            }
        }

        // Stage 3: Sudden Death (45s+)
        if (combatDuration > STAGE_3_THRESHOLD) {
            if (!mob.hasEffect(MobEffects.STRENGTH) || mob.getEffect(MobEffects.STRENGTH).getAmplifier() < 9) {
                mob.addEffect(new MobEffectInstance(MobEffects.STRENGTH, 100, 9)); // Strength X (One shot territory)
            }
            // Wither the target
            if (mob.distanceToSqr(target) < 16) {
                target.addEffect(new MobEffectInstance(MobEffects.WITHER, 40, 6));
                target.addEffect(new MobEffectInstance(MobEffects.GLOWING, 40, 0)); // No hiding
            }
        }
    }
}
