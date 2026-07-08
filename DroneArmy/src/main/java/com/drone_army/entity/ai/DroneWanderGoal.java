package com.drone_army.entity.ai;

import com.drone_army.entity.CommandMode;
import com.drone_army.entity.ControlledMob;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.ai.goal.WanderAroundFarGoal;

public class DroneWanderGoal extends WanderAroundFarGoal {
    private final ControlledMob controlled;

    public DroneWanderGoal(PathAwareEntity mob, double speed) {
        super(mob, speed);
        this.controlled = (ControlledMob) mob;
    }

    @Override
    public boolean canStart() {
        if (controlled.isControlled()) {
            CommandMode mode = controlled.getCommandMode();
            // Don't wander if holding position or following (FollowGoal handles movement)
            if (mode == CommandMode.HOLD_POSITION || mode == CommandMode.FOLLOW) {
                return false;
            }
        }
        return super.canStart();
    }

    @Override
    public boolean shouldContinue() {
        if (controlled.isControlled()) {
            CommandMode mode = controlled.getCommandMode();
            if (mode == CommandMode.HOLD_POSITION || mode == CommandMode.FOLLOW) {
                return false;
            }
        }
        return super.shouldContinue();
    }
}
