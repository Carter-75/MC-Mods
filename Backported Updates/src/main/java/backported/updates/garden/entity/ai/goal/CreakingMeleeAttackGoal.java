/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.mob.PathAwareEntity
 *  net.minecraft.entity.ai.goal.MeleeAttackGoal
 *  net.minecraft.entity.mob.HostileEntity
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3i
 *  net.minecraft.util.math.Vec3d
 */
package backported.updates.garden.entity.ai.goal;

import backported.updates.garden.entity.CreakingEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3i;
import net.minecraft.util.math.Vec3d;

public class CreakingMeleeAttackGoal
extends MeleeAttackGoal {
    protected final PathAwareEntity mob;

    public CreakingMeleeAttackGoal(PathAwareEntity mob, double speed, boolean pauseWhenMobIdle) {
        super(mob, speed, pauseWhenMobIdle);
        this.mob = mob;
    }

    public boolean isInMovableRange() {
        if (this.mob instanceof CreakingEntity && ((CreakingEntity)this.mob).boundHeart != null) {
            BlockPos pos1;
            Vec3d pos0 = this.mob.getPos();
            double range = pos0.distanceTo(Vec3d.of((Vec3i)(pos1 = ((CreakingEntity)this.mob).boundHeart)));
            return range < 30.0;
        }
        return false;
    }

    public boolean canStart() {
        if (this.isPlayerNotLookingAtEntity(this.mob.getTarget(), (HostileEntity)this.mob) && this.isInMovableRange()) {
            return super.canStart();
        }
        return false;
    }

    public boolean shouldContinue() {
        if (this.isPlayerNotLookingAtEntity(this.mob.getTarget(), (HostileEntity)this.mob)) {
            return super.shouldContinue();
        }
        return false;
    }

    private boolean isPlayerNotLookingAtEntity(LivingEntity player, HostileEntity entity) {
        float angleToEntity;
        if (player == null) {
            return true;
        }
        double deltaX = entity.getX() - player.getX();
        double deltaZ = entity.getZ() - player.getZ();
        float targetYaw = player.getYaw(1.0f);
        float angleDifference = Math.abs(targetYaw - (angleToEntity = (float)(Math.atan2(deltaZ, deltaX) * 57.29577951308232) - 90.0f));
        return !(angleDifference < 45.0f) && !(angleDifference > 315.0f);
    }
}

