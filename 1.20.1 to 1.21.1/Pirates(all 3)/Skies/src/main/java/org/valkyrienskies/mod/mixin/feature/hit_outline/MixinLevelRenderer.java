/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.class_1297
 *  net.minecraft.class_1922
 *  net.minecraft.class_2338
 *  net.minecraft.class_2382
 *  net.minecraft.class_265
 *  net.minecraft.class_2680
 *  net.minecraft.class_3726
 *  net.minecraft.class_4587
 *  net.minecraft.class_4588
 *  net.minecraft.class_638
 *  net.minecraft.class_761
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.At$Shift
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package org.valkyrienskies.mod.mixin.feature.hit_outline;

import javax.annotation.Nullable;
import net.minecraft.class_1297;
import net.minecraft.class_1922;
import net.minecraft.class_2338;
import net.minecraft.class_2382;
import net.minecraft.class_265;
import net.minecraft.class_2680;
import net.minecraft.class_3726;
import net.minecraft.class_4587;
import net.minecraft.class_4588;
import net.minecraft.class_638;
import net.minecraft.class_761;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.valkyrienskies.core.api.ships.ClientShip;
import org.valkyrienskies.mod.common.VSClientGameUtils;
import org.valkyrienskies.mod.common.VSGameUtilsKt;

@Mixin(value={class_761.class})
public class MixinLevelRenderer {
    @Shadow
    @Nullable
    private class_638 field_4085;

    @Shadow
    private static void method_3291(class_4587 matrixStack, class_4588 vertexConsumer, class_265 voxelShape, double d2, double e2, double f2, float red, float green, float blue, float alpha) {
        throw new AssertionError();
    }

    @Inject(method={"renderHitOutline"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/renderer/LevelRenderer;renderShape(Lcom/mojang/blaze3d/vertex/PoseStack;Lcom/mojang/blaze3d/vertex/VertexConsumer;Lnet/minecraft/world/phys/shapes/VoxelShape;DDDFFFF)V", shift=At.Shift.BEFORE)}, cancellable=true)
    private void preRenderShape(class_4587 matrixStack, class_4588 vertexConsumer, class_1297 entity, double camX, double camY, double camZ, class_2338 pos, class_2680 state, CallbackInfo ci) {
        ClientShip ship = VSGameUtilsKt.getLoadedShipManagingPos(this.field_4085, (class_2382)pos);
        if (ship != null) {
            matrixStack.method_22903();
            VSClientGameUtils.transformRenderWithShip(ship.getRenderTransform(), matrixStack, pos, camX, camY, camZ);
            MixinLevelRenderer.method_3291(matrixStack, vertexConsumer, state.method_26172((class_1922)this.field_4085, pos, class_3726.method_16195((class_1297)entity)), 0.0, 0.0, 0.0, 0.0f, 0.0f, 0.0f, 0.4f);
            matrixStack.method_22909();
            ci.cancel();
        }
    }
}

