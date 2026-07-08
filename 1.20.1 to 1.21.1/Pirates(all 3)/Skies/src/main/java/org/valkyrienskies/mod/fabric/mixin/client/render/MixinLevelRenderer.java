/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation
 *  net.minecraft.class_1920
 *  net.minecraft.class_2338
 *  net.minecraft.class_2382
 *  net.minecraft.class_243
 *  net.minecraft.class_2680
 *  net.minecraft.class_4184
 *  net.minecraft.class_4583
 *  net.minecraft.class_4587
 *  net.minecraft.class_4588
 *  net.minecraft.class_638
 *  net.minecraft.class_757
 *  net.minecraft.class_761
 *  net.minecraft.class_765
 *  net.minecraft.class_776
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 */
package org.valkyrienskies.mod.fabric.mixin.client.render;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.class_1920;
import net.minecraft.class_2338;
import net.minecraft.class_2382;
import net.minecraft.class_243;
import net.minecraft.class_2680;
import net.minecraft.class_4184;
import net.minecraft.class_4583;
import net.minecraft.class_4587;
import net.minecraft.class_4588;
import net.minecraft.class_638;
import net.minecraft.class_757;
import net.minecraft.class_761;
import net.minecraft.class_765;
import net.minecraft.class_776;
import org.joml.Matrix3f;
import org.joml.Matrix4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.valkyrienskies.core.api.ships.ClientShip;
import org.valkyrienskies.core.api.ships.properties.ShipTransform;
import org.valkyrienskies.mod.common.VSClientGameUtils;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.mixin.accessors.client.render.OverlayVertexConsumerAccessor;

@Mixin(value={class_761.class})
public abstract class MixinLevelRenderer {
    @Shadow
    private class_638 field_4085;

    @WrapOperation(method={"renderLevel"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/renderer/block/BlockRenderDispatcher;renderBreakingTexture(Lnet/minecraft/world/level/block/state/BlockState;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/BlockAndTintGetter;Lcom/mojang/blaze3d/vertex/PoseStack;Lcom/mojang/blaze3d/vertex/VertexConsumer;)V")})
    private void renderBlockDamage(class_776 blockRenderManager, class_2680 state, class_2338 blockPos, class_1920 blockRenderWorld, class_4587 matrix, class_4588 vertexConsumer, Operation<Void> renderBreakingTexture, class_4587 matrixStack, float methodTickDelta, long methodLimitTime, boolean methodRenderBlockOutline, class_4184 methodCamera, class_757 methodGameRenderer, class_765 methodLightmapTextureManager, Matrix4f methodMatrix4f) {
        ClientShip ship = VSGameUtilsKt.getLoadedShipManagingPos(this.field_4085, (class_2382)blockPos);
        if (ship != null) {
            matrixStack.method_22909();
            matrixStack.method_22903();
            ShipTransform renderTransform = ship.getRenderTransform();
            class_243 cameraPos = methodCamera.method_19326();
            VSClientGameUtils.transformRenderWithShip(renderTransform, matrixStack, blockPos, cameraPos.field_1352, cameraPos.field_1351, cameraPos.field_1350);
            Matrix3f newNormalMatrix = new Matrix3f(matrixStack.method_23760().method_23762());
            Matrix4f newModelMatrix = new Matrix4f(matrixStack.method_23760().method_23761());
            class_4583 newVertexConsumer = new class_4583(((OverlayVertexConsumerAccessor)vertexConsumer).getDelegate(), newModelMatrix, newNormalMatrix, 1.0f);
            renderBreakingTexture.call(new Object[]{blockRenderManager, state, blockPos, blockRenderWorld, matrix, newVertexConsumer});
        } else {
            renderBreakingTexture.call(new Object[]{blockRenderManager, state, blockPos, blockRenderWorld, matrix, vertexConsumer});
        }
    }
}

