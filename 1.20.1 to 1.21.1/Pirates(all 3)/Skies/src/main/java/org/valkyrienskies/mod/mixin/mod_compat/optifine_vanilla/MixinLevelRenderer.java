/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1923
 *  net.minecraft.class_2338
 *  net.minecraft.class_2382
 *  net.minecraft.class_243
 *  net.minecraft.class_2586
 *  net.minecraft.class_4184
 *  net.minecraft.class_4587
 *  net.minecraft.class_4597
 *  net.minecraft.class_631
 *  net.minecraft.class_638
 *  net.minecraft.class_757
 *  net.minecraft.class_761
 *  net.minecraft.class_765
 *  net.minecraft.class_769
 *  net.minecraft.class_824
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.Redirect
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package org.valkyrienskies.mod.mixin.mod_compat.optifine_vanilla;

import net.minecraft.class_1923;
import net.minecraft.class_2338;
import net.minecraft.class_2382;
import net.minecraft.class_243;
import net.minecraft.class_2586;
import net.minecraft.class_4184;
import net.minecraft.class_4587;
import net.minecraft.class_4597;
import net.minecraft.class_631;
import net.minecraft.class_638;
import net.minecraft.class_757;
import net.minecraft.class_761;
import net.minecraft.class_765;
import net.minecraft.class_769;
import net.minecraft.class_824;
import org.joml.Matrix4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.valkyrienskies.core.api.ships.ClientShip;
import org.valkyrienskies.mod.common.VSClientGameUtils;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.mixinducks.client.world.ClientChunkCacheDuck;

@Mixin(value={class_761.class})
public abstract class MixinLevelRenderer {
    @Shadow
    private class_638 field_4085;
    @Shadow
    private class_769 field_4112;

    @Inject(method={"allChanged"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/renderer/ViewArea;repositionCamera(DD)V")})
    private void afterRefresh(CallbackInfo ci) {
        class_631 class_6312 = this.field_4085.method_2935();
        if (!(class_6312 instanceof ClientChunkCacheDuck)) {
            return;
        }
        ClientChunkCacheDuck chunks = (ClientChunkCacheDuck)class_6312;
        chunks.vs$getShipChunks().forEach((pos, chunk) -> {
            for (int y = this.field_4085.method_32891(); y < this.field_4085.method_31597(); ++y) {
                this.field_4112.method_16040(class_1923.method_8325((long)pos), y, class_1923.method_8332((long)pos), false);
            }
        });
    }

    @Redirect(method={"renderLevel"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/renderer/blockentity/BlockEntityRenderDispatcher;render(Lnet/minecraft/world/level/block/entity/BlockEntity;FLcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;)V"))
    private void renderShipChunkBlockEntity(class_824 blockEntityRenderDispatcher, class_2586 blockEntity, float tickDelta, class_4587 matrix, class_4597 vertexConsumerProvider, class_4587 methodMatrices, float methodTickDelta, long methodLimitTime, boolean methodRenderBlockOutline, class_4184 methodCamera, class_757 methodGameRenderer, class_765 methodLightmapTextureManager, Matrix4f methodMatrix4f) {
        class_2338 blockEntityPos = blockEntity.method_11016();
        ClientShip shipObject = VSGameUtilsKt.getLoadedShipManagingPos(this.field_4085, (class_2382)blockEntityPos);
        if (shipObject != null) {
            class_243 cam = methodCamera.method_19326();
            matrix.method_22909();
            matrix.method_22903();
            VSClientGameUtils.transformRenderWithShip(shipObject.getRenderTransform(), matrix, blockEntityPos, cam.method_10216(), cam.method_10214(), cam.method_10215());
        }
        blockEntityRenderDispatcher.method_3555(blockEntity, tickDelta, matrix, vertexConsumerProvider);
    }
}

