/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.math.Vec2f
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.util.math.MathHelper
 *  org.jetbrains.annotations.Nullable
 */
package backported.updates.content.common.api.leash;

import backported_updates.mixin.access.EntityAccessor;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.MathHelper;
import org.jetbrains.annotations.Nullable;

public class InterpolationHandler {
    private final Entity entity;
    private final int interpolationSteps;
    private final InterpolationData data = new InterpolationData(0, Vec3d.ZERO, 0.0f, 0.0f);
    @Nullable
    private Vec3d previousTickPosition;
    @Nullable
    private Vec2f previousTickRot;

    public InterpolationHandler(Entity entity, int steps) {
        this.interpolationSteps = steps;
        this.entity = entity;
    }

    public void interpolateTo(Vec3d position, float y, float x) {
        if (this.interpolationSteps == 0) {
            this.entity.setPos(position.x, position.y, position.z);
            this.entity.setYaw(y);
            this.entity.setPitch(x);
            this.entity.resetPosition();
            ((EntityAccessor)this.entity).callRefreshPosition();
            this.cancel();
        } else {
            this.data.steps = this.interpolationSteps;
            this.data.position = position;
            this.data.yRot = y;
            this.data.xRot = x;
            this.previousTickPosition = this.entity.getPos();
            this.previousTickRot = new Vec2f(this.entity.getPitch(), this.entity.getYaw());
        }
    }

    public boolean hasActiveInterpolation() {
        return this.data.steps > 0;
    }

    public void interpolate() {
        if (!this.hasActiveInterpolation()) {
            this.cancel();
        } else {
            double progress = 1.0 / (double)this.data.steps;
            if (this.previousTickPosition != null) {
                Vec3d movement = this.entity.getPos().subtract(this.previousTickPosition);
                if (this.entity.getWorld().isSpaceEmpty(this.entity, ((EntityAccessor)this.entity).getDimensions().getBoxAt(this.data.position.add(movement)))) {
                    this.data.addDelta(movement);
                }
            }
            if (this.previousTickRot != null) {
                float yRot = this.entity.getYaw() - this.previousTickRot.y;
                float xRot = this.entity.getPitch() - this.previousTickRot.x;
                this.data.addRotation(yRot, xRot);
            }
            double x = MathHelper.lerp((double)progress, (double)this.entity.getX(), (double)this.data.position.x);
            double y = MathHelper.lerp((double)progress, (double)this.entity.getY(), (double)this.data.position.y);
            double z = MathHelper.lerp((double)progress, (double)this.entity.getZ(), (double)this.data.position.z);
            Vec3d position = new Vec3d(x, y, z);
            float yRot = MathHelper.lerpAngleDegrees((float)((float)progress), (float)this.entity.getYaw(), (float)this.data.yRot);
            float xRot = (float)MathHelper.lerp((double)progress, (double)this.entity.getPitch(), (double)this.data.xRot);
            this.entity.setPosition(position);
            ((EntityAccessor)this.entity).callSetAngles(yRot, xRot);
            this.data.decrease();
            this.previousTickPosition = position;
            this.previousTickRot = new Vec2f(this.entity.getPitch(), this.entity.getYaw());
        }
    }

    public void cancel() {
        this.data.steps = 0;
        this.previousTickPosition = null;
        this.previousTickRot = null;
    }

    static class InterpolationData {
        protected int steps;
        Vec3d position;
        float yRot;
        float xRot;

        InterpolationData(int steps, Vec3d position, float yRot, float xRot) {
            this.steps = steps;
            this.position = position;
            this.yRot = yRot;
            this.xRot = xRot;
        }

        public void decrease() {
            --this.steps;
        }

        public void addDelta(Vec3d vec3) {
            this.position = this.position.add(vec3);
        }

        public void addRotation(float yRot, float xRot) {
            this.yRot += yRot;
            this.xRot += xRot;
        }
    }
}

