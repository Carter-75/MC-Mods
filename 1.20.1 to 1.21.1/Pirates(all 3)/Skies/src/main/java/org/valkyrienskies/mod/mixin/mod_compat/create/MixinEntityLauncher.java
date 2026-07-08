/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.simibubi.create.content.logistics.depot.EntityLauncher
 *  net.minecraft.class_1297
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_243
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.ModifyVariable
 *  org.spongepowered.asm.mixin.injection.Redirect
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package org.valkyrienskies.mod.mixin.mod_compat.create;

import com.simibubi.create.content.logistics.depot.EntityLauncher;
import net.minecraft.class_1297;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_243;
import org.joml.Vector3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.util.IEntityDraggingInformationProvider;
import org.valkyrienskies.mod.common.util.VectorConversionsMCKt;

@Mixin(value={EntityLauncher.class})
public abstract class MixinEntityLauncher {
    @Unique
    private class_2338 launcher;

    @Inject(method={"getGlobalPos"}, at={@At(value="HEAD")})
    private void harvestBlockPos(double t, class_2350 d2, class_2338 launcher, CallbackInfoReturnable<class_243> cir) {
        this.launcher = launcher;
    }

    @ModifyVariable(method={"getGlobalPos"}, at=@At(value="STORE"), name={"start"})
    private class_243 modStart(class_243 value) {
        return new class_243((double)this.launcher.method_10263() + 0.5, (double)this.launcher.method_10264() + 0.5, (double)this.launcher.method_10260() + 0.5);
    }

    @Redirect(method={"applyMotion"}, at=@At(value="INVOKE", target="Lnet/minecraft/world/entity/Entity;setDeltaMovement(DDD)V"))
    private void redirectSetDeltaMovement(class_1297 instance, double x, double y, double z) {
        instance.method_18799(this.outMotion(instance, new class_243(x, y, z)));
    }

    @Unique
    private class_243 outMotion(class_1297 entity, class_243 motion) {
        Object ship;
        IEntityDraggingInformationProvider dragProvider;
        if (entity instanceof IEntityDraggingInformationProvider && (dragProvider = (IEntityDraggingInformationProvider)entity).getDraggingInformation().isEntityBeingDraggedByAShip() && (ship = VSGameUtilsKt.getAllShips(entity.method_37908()).getById(dragProvider.getDraggingInformation().getLastShipStoodOn())) != null) {
            Vector3d tempVec = VectorConversionsMCKt.toJOML(motion);
            ship.getTransform().getShipToWorld().transformDirection(tempVec);
            motion = VectorConversionsMCKt.toMinecraft(tempVec);
        }
        return motion;
    }
}

