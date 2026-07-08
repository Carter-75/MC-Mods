/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityType
 *  net.minecraft.entity.vehicle.BoatEntity
 *  net.minecraft.world.World
 *  net.minecraft.util.math.Vec3d
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package backported_updates.mixin.leash;

import backported.updates.content.common.api.leash.InterpolationHandler;
import backported.updates.content.common.api.leash.LeashExtension;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.world.World;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={BoatEntity.class})
public abstract class BoatMixin
extends Entity
implements LeashExtension {
    @Unique
    private final InterpolationHandler interpolation = new InterpolationHandler(this, 3);

    public BoatMixin(EntityType<?> entityType, World level) {
        super(entityType, level);
    }

    @Inject(method={"updateTrackedPositionAndAngles"}, at={@At(value="HEAD")}, cancellable=true)
    private void vb$lerpTo(double x, double y, double z, float yRot, float xRot, int steps, CallbackInfo ci) {
        this.interpolation.interpolateTo(new Vec3d(x, y, z), yRot, xRot);
        ci.cancel();
    }

    @Inject(method={"updatePositionAndRotation"}, at={@At(value="HEAD")}, cancellable=true)
    private void vb$tickLerp(CallbackInfo ci) {
        if (this.isLogicalSideForUpdatingMovement()) {
            this.interpolation.cancel();
            this.updateTrackedPosition(this.getX(), this.getY(), this.getZ());
        }
        this.interpolation.interpolate();
        ci.cancel();
    }
}

