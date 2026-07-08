/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation
 *  com.llamalad7.mixinextras.sugar.Local
 *  com.simibubi.create.foundation.blockEntity.behaviour.edgeInteraction.EdgeInteractionRenderer
 *  net.minecraft.class_1937
 *  net.minecraft.class_239
 *  net.minecraft.class_243
 *  net.minecraft.class_3965
 *  net.minecraft.class_638
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 */
package org.valkyrienskies.mod.mixin.mod_compat.create.client;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import com.simibubi.create.foundation.blockEntity.behaviour.edgeInteraction.EdgeInteractionRenderer;
import net.minecraft.class_1937;
import net.minecraft.class_239;
import net.minecraft.class_243;
import net.minecraft.class_3965;
import net.minecraft.class_638;
import org.joml.Vector3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.util.VectorConversionsMCKt;

@Mixin(value={EdgeInteractionRenderer.class})
public class MixinEdgeInteractionRenderer {
    @WrapOperation(method={"tick"}, at={@At(value="INVOKE", target="Lnet/minecraft/world/phys/HitResult;getLocation()Lnet/minecraft/world/phys/Vec3;")})
    private static class_243 injectGetLocation(class_239 instance, Operation<class_243> original, @Local(ordinal=0) class_638 world) {
        class_3965 hitResult = (class_3965)instance;
        class_243 originalResult = (class_243)original.call(new Object[]{instance});
        Ship ship = VSGameUtilsKt.getShipManagingPos((class_1937)world, hitResult.method_17777());
        if (ship != null) {
            Vector3d resultJoml = VectorConversionsMCKt.toJOML(originalResult);
            ship.getTransform().getWorldToShip().transformPosition(resultJoml);
            return VectorConversionsMCKt.toMinecraft(resultJoml);
        }
        return originalResult;
    }
}

