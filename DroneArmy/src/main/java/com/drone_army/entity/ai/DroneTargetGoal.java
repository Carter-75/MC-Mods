package com.drone_army.entity.ai;

import com.drone_army.entity.CommandMode;
import com.drone_army.entity.ControlledMob;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.ActiveTargetGoal;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;

public class DroneTargetGoal<T extends LivingEntity> extends ActiveTargetGoal<T> {
    private final ControlledMob controlled;

    public DroneTargetGoal(MobEntity mob, Class<T> targetClass, boolean checkVisibility) {
        super(mob, targetClass, checkVisibility);
        this.controlled = (ControlledMob) mob;
    }

    @Override
    public boolean canStart() {
        if (!controlled.isControlled()) {
            return super.canStart();
        }

        CommandMode mode = controlled.getCommandMode();

        // Logic based on mode
        switch (mode) {
            case FOLLOW:
            case HOLD_POSITION:
                // Passive modes, don't auto-target unless hurt (Retaliate handled by other
                // goals)
                return false;
            case AGGRESSIVE:
                // Target enemies. "Everything except Owner and Friendly"
                // super.canStart() checks target predicate.
                // We need to ensure we don't target owner or other drones.
                if (super.canStart()) {
                    return isValidTarget(this.targetEntity);
                }
                return false;
            case DEFEND:
                // Guard position/Owner.
                // Complex. For now, behave like Aggressive but smaller range?
                // Or "ActiveTarget" is hard for Defend.
                // Defend usually means "Attack if comes close".
                if (super.canStart()) {
                    return isValidTarget(this.targetEntity) && this.mob.squaredDistanceTo(this.targetEntity) < 100.0; // 10
                                                                                                                      // blocks
                }
                return false;
            case RETALIATE:
                // Handled by RevengeGoal (HurtByTarget)
                return false;
            default:
                return false;
        }
    }

    private boolean isValidTarget(LivingEntity target) {
        if (target == null)
            return false;
        if (target.getUuid().equals(controlled.getOwnerUuid()))
            return false; // Don't attack owner
        if (target instanceof ControlledMob cm && cm.isControlled()
                && cm.getOwnerUuid().equals(controlled.getOwnerUuid()))
            return false; // Don't attack friendly drones
        if (target instanceof PlayerEntity && target.getUuid().equals(controlled.getOwnerUuid()))
            return false;
        return true;
    }
}
