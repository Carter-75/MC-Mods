/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  at.petrak.hexcasting.api.player.Sentinel
 *  at.petrak.hexcasting.client.render.HexAdditionalRenderers
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation
 *  com.llamalad7.mixinextras.sugar.Local
 *  net.minecraft.class_243
 *  net.minecraft.class_4587
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Pseudo
 *  org.spongepowered.asm.mixin.injection.At
 */
package org.valkyrienskies.mod.mixin.mod_compat.hexcasting;

import at.petrak.hexcasting.api.player.Sentinel;
import at.petrak.hexcasting.client.render.HexAdditionalRenderers;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.class_243;
import net.minecraft.class_4587;
import org.joml.Vector3f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.valkyrienskies.core.api.ships.ClientShip;
import org.valkyrienskies.mod.common.VSClientGameUtils;
import org.valkyrienskies.mod.common.util.VectorConversionsMCKt;

@Pseudo
@Mixin(value={HexAdditionalRenderers.class})
public class MixinHexAdditionalRenderers {
    @WrapOperation(method={"renderSentinel"}, at={@At(value="INVOKE", target="Lcom/mojang/blaze3d/vertex/PoseStack;translate(DDD)V")})
    private static void valkyrienskies$renderOnShip(class_4587 instance, double d2, double e2, double f2, Operation<Void> original, @Local(argsOnly=true) Sentinel sentinel, @Local class_243 playerPos) {
        ClientShip ship = VSClientGameUtils.getClientShip(sentinel.position().field_1352, sentinel.position().field_1351, sentinel.position().field_1350);
        if (ship != null) {
            class_243 distance = VectorConversionsMCKt.toMinecraft(ship.getShipToWorld().transformPosition(VectorConversionsMCKt.toJOML(sentinel.position()))).method_1020(playerPos);
            original.call(new Object[]{instance, distance.field_1352, distance.field_1351, distance.field_1350});
        } else {
            original.call(new Object[]{instance, d2, e2, f2});
        }
    }

    @WrapOperation(method={"renderSentinel"}, at={@At(value="INVOKE", target="Lcom/mojang/blaze3d/vertex/PoseStack;scale(FFF)V")})
    private static void valkyrienskies$scaleWithShip(class_4587 instance, float f2, float g2, float h2, Operation<Void> original, @Local(argsOnly=true) Sentinel sentinel) {
        ClientShip ship = VSClientGameUtils.getClientShip(sentinel.position().field_1352, sentinel.position().field_1351, sentinel.position().field_1350);
        if (ship != null) {
            Vector3f scale = ship.getRenderTransform().getShipToWorldScaling().get(new Vector3f());
            original.call(new Object[]{instance, Float.valueOf(scale.x()), Float.valueOf(scale.y()), Float.valueOf(scale.z())});
        }
        original.call(new Object[]{instance, Float.valueOf(f2), Float.valueOf(g2), Float.valueOf(h2)});
    }
}

