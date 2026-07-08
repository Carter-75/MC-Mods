/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.ai.control.MoveControl$State
 *  net.minecraft.entity.ai.goal.Goal
 *  net.minecraft.entity.ai.goal.Goal$Control
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.entity.ai.TargetPredicate
 *  org.jetbrains.annotations.Nullable
 */
package backported.updates.content.common.level.entities.happyghast;

import backported.updates.content.common.level.entities.happyghast.HappyGhast;
import java.util.EnumSet;
import java.util.function.Predicate;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.control.MoveControl;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Vec3d;
import net.minecraft.entity.ai.TargetPredicate;
import org.jetbrains.annotations.Nullable;

public class HappyGhastTemptGoal
extends Goal {
    private static final TargetPredicate TEMP_TARGETING = TargetPredicate.createNonAttackable().setBaseMaxDistance(10.0).ignoreVisibility();
    private final TargetPredicate targetingConditions;
    protected final HappyGhast ghast;
    private final double speedModifier;
    private double px;
    private double py;
    private double pz;
    private double pRotX;
    private double pRotY;
    @Nullable
    protected PlayerEntity player;
    private int calmDown;
    private final Predicate<ItemStack> items;
    private final boolean canScare;
    private final double stopDistance;

    public HappyGhastTemptGoal(HappyGhast ghast, double speedModifier, Predicate<ItemStack> items, boolean canScare, double stopDistance) {
        this.ghast = ghast;
        this.speedModifier = speedModifier;
        this.items = items;
        this.canScare = canScare;
        this.stopDistance = stopDistance;
        this.setControls(EnumSet.of(Goal.Control.MOVE, Goal.Control.LOOK));
        this.targetingConditions = TEMP_TARGETING.copy().setPredicate(this::shouldFollow);
    }

    public boolean canStart() {
        if (this.calmDown > 0) {
            --this.calmDown;
            return false;
        }
        this.player = this.ghast.getWorld().getClosestPlayer(this.targetingConditions.setBaseMaxDistance(16.0), (LivingEntity)this.ghast);
        return this.player != null;
    }

    private boolean shouldFollow(LivingEntity entity) {
        return this.items.test(entity.getMainHandStack()) || this.items.test(entity.getOffHandStack());
    }

    public boolean shouldContinue() {
        if (this.canScare() && this.player != null) {
            if (this.ghast.squaredDistanceTo((Entity)this.player) < 36.0) {
                if (this.player.squaredDistanceTo(this.px, this.py, this.pz) > 0.01) {
                    return false;
                }
                if (Math.abs((double)this.player.getPitch() - this.pRotX) > 5.0 || Math.abs((double)this.player.getYaw() - this.pRotY) > 5.0) {
                    return false;
                }
            } else {
                this.px = this.player.getX();
                this.py = this.player.getY();
                this.pz = this.player.getZ();
            }
            this.pRotX = this.player.getPitch();
            this.pRotY = this.player.getYaw();
        }
        return this.canStart();
    }

    protected boolean canScare() {
        return this.canScare;
    }

    public void start() {
        if (this.player == null) {
            return;
        }
        this.px = this.player.getX();
        this.py = this.player.getY();
        this.pz = this.player.getZ();
    }

    public void stop() {
        this.player = null;
        this.ghast.getNavigation().stop();
        this.calmDown = HappyGhastTemptGoal.toGoalTicks((int)100);
    }

    public void tick() {
        if (this.player == null) {
            return;
        }
        this.ghast.getLookControl().lookAt((Entity)this.player, (float)(this.ghast.getMaxHeadRotation() + 20), (float)this.ghast.getMaxLookPitchChange());
        if (this.ghast.squaredDistanceTo((Entity)this.player) < this.stopDistance * this.stopDistance) {
            this.ghast.getMoveControl().state = MoveControl.State.WAIT;
        } else {
            Vec3d vec3 = this.player.getEyePos().subtract(this.ghast.getPos()).multiply(this.ghast.getRandom().nextDouble()).add(this.ghast.getPos());
            this.ghast.getMoveControl().moveTo(vec3.x, vec3.y, vec3.z, this.speedModifier);
        }
    }
}

