/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation
 *  com.llamalad7.mixinextras.sugar.Local
 *  dev.engine_room.flywheel.api.visual.DynamicVisual$Context
 *  dev.engine_room.flywheel.lib.visual.AbstractBlockEntityVisual
 *  net.minecraft.class_2338
 *  net.minecraft.class_2374
 *  net.minecraft.class_243
 *  net.minecraft.class_2586
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Redirect
 */
package org.valkyrienskies.mod.mixin.mod_compat.flywheel;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import dev.engine_room.flywheel.api.visual.DynamicVisual;
import dev.engine_room.flywheel.lib.visual.AbstractBlockEntityVisual;
import net.minecraft.class_2338;
import net.minecraft.class_2374;
import net.minecraft.class_243;
import net.minecraft.class_2586;
import org.joml.FrustumIntersection;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.valkyrienskies.mod.common.VSGameUtilsKt;

@Mixin(value={AbstractBlockEntityVisual.class})
public class MixinAbstractBlockEntityVisual<T extends class_2586> {
    @Shadow
    @Final
    protected T blockEntity;

    @WrapOperation(method={"isVisible"}, at={@At(value="INVOKE", target="Lorg/joml/FrustumIntersection;testSphere(FFFF)Z")}, remap=false)
    private boolean testRedirected(FrustumIntersection instance, float x, float y, float z, float r, Operation<Boolean> original) {
        class_243 worldPos = VSGameUtilsKt.toWorldCoordinates(this.blockEntity.method_10997(), this.blockEntity.method_11016().method_46558());
        return (Boolean)original.call(new Object[]{instance, Float.valueOf((float)worldPos.field_1352), Float.valueOf((float)worldPos.field_1351), Float.valueOf((float)worldPos.field_1350), Float.valueOf(r)});
    }

    @Redirect(method={"doDistanceLimitThisFrame"}, at=@At(value="INVOKE", target="Lnet/minecraft/core/BlockPos;distToCenterSqr(Lnet/minecraft/core/Position;)D"))
    private double distInclShips(class_2338 blockPos, class_2374 position, @Local(argsOnly=true) DynamicVisual.Context context) {
        return VSGameUtilsKt.toWorldCoordinates(context.camera().method_19331().method_37908(), blockPos.method_46558()).method_1028(position.method_10216(), position.method_10214(), position.method_10215());
    }
}

