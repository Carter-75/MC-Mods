package com.drone_army.entity.ai;

import com.drone_army.entity.CommandMode;
import com.drone_army.entity.ControlledMob;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.ai.pathing.PathNodeType;
import net.minecraft.util.math.BlockPos;

import java.util.EnumSet;

public class DroneFollowGoal extends Goal {
    private final PathAwareEntity mob;
    private LivingEntity owner;
    private final double speed;
    private final float minDistance;
    private final float maxDistance;
    private int updateCountdownTicks;

    public DroneFollowGoal(PathAwareEntity mob, double speed, float minDistance, float maxDistance) {
        this.mob = mob;
        this.speed = speed;
        this.minDistance = minDistance;
        this.maxDistance = maxDistance;
        this.setControls(EnumSet.of(Control.MOVE, Control.LOOK));
    }

    @Override
    public boolean canStart() {
        if (mob instanceof ControlledMob controlled) {
            if (controlled.getCommandMode() != CommandMode.FOLLOW) {
                return false;
            }
            if (!controlled.isControlled()) {
                return false;
            }
            LivingEntity owner = mob.getWorld().getPlayerByUuid(controlled.getOwnerUuid());
            if (owner == null) {
                return false;
            } else if (owner.isSpectator()
                    || mob.squaredDistanceTo(owner) < (double) (this.minDistance * this.minDistance)) {
                return false;
            } else {
                this.owner = owner;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean shouldContinue() {
        if (this.mob.getNavigation().isIdle()) {
            return false;
        } else if (this.mob instanceof ControlledMob controlled && controlled.getCommandMode() != CommandMode.FOLLOW) {
            return false;
        } else {
            return this.mob.squaredDistanceTo(this.owner) > (double) (this.maxDistance * this.maxDistance);
        }
    }

    @Override
    public void start() {
        this.updateCountdownTicks = 0;
    }

    @Override
    public void stop() {
        this.owner = null;
        this.mob.getNavigation().stop();
    }

    @Override
    public void tick() {
        this.mob.getLookControl().lookAt(this.owner, 10.0F, (float) this.mob.getMaxLookPitchChange());
        if (--this.updateCountdownTicks <= 0) {
            this.updateCountdownTicks = 10;
            if (!this.mob.isLeashed() && !this.mob.hasVehicle()) {
                if (this.mob.squaredDistanceTo(this.owner) >= 144.0D) {
                    this.tryTeleport();
                } else {
                    this.mob.getNavigation().startMovingTo(this.owner, this.speed);
                }
            }
        }
    }

    private void tryTeleport() {
        BlockPos blockPos = this.owner.getBlockPos();

        for (int i = 0; i < 10; ++i) {
            int j = this.getRandomInt(-3, 3);
            int k = this.getRandomInt(-1, 1);
            int l = this.getRandomInt(-3, 3);
            boolean bl = this.tryTeleportTo(blockPos.getX() + j, blockPos.getY() + k, blockPos.getZ() + l);
            if (bl) {
                return;
            }
        }
    }

    private boolean tryTeleportTo(int x, int y, int z) {
        if (Math.abs((double) x - this.owner.getX()) < 2.0D && Math.abs((double) z - this.owner.getZ()) < 2.0D) {
            return false;
        } else if (!this.canTeleportTo(new BlockPos(x, y, z))) {
            return false;
        } else {
            this.mob.refreshPositionAndAngles((double) x + 0.5D, (double) y, (double) z + 0.5D, this.mob.getYaw(),
                    this.mob.getPitch());
            this.mob.getNavigation().stop();
            return true;
        }
    }

    private boolean canTeleportTo(BlockPos pos) {
        PathNodeType pathNodeType = net.minecraft.entity.ai.pathing.LandPathNodeMaker
                .getLandNodeType(this.mob, pos.mutableCopy());
        if (pathNodeType != PathNodeType.WALKABLE) {
            return false;
        } else {
            return this.mob.getWorld().isSpaceEmpty(this.mob,
                    this.mob.getBoundingBox().offset(pos.subtract(this.mob.getBlockPos())));
        }
    }

    private int getRandomInt(int min, int max) {
        return this.mob.getRandom().nextInt(max - min + 1) + min;
    }
}
