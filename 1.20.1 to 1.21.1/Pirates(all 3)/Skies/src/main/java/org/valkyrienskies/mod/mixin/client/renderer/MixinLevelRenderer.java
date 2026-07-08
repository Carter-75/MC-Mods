/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation
 *  net.minecraft.class_1297
 *  net.minecraft.class_1922
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_2382
 *  net.minecraft.class_243
 *  net.minecraft.class_265
 *  net.minecraft.class_2680
 *  net.minecraft.class_3726
 *  net.minecraft.class_4587
 *  net.minecraft.class_4588
 *  net.minecraft.class_638
 *  net.minecraft.class_761
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Constant
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.ModifyConstant
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package org.valkyrienskies.mod.mixin.client.renderer;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.class_1297;
import net.minecraft.class_1922;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_2382;
import net.minecraft.class_243;
import net.minecraft.class_265;
import net.minecraft.class_2680;
import net.minecraft.class_3726;
import net.minecraft.class_4587;
import net.minecraft.class_4588;
import net.minecraft.class_638;
import net.minecraft.class_761;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.valkyrienskies.core.api.ships.ClientShip;
import org.valkyrienskies.mod.common.VSClientGameUtils;
import org.valkyrienskies.mod.common.VSGameUtilsKt;

@Mixin(value={class_761.class})
public abstract class MixinLevelRenderer {
    @Shadow
    @Nullable
    private class_638 field_4085;
    @Unique
    private class_4587 matrixStack;
    @Unique
    private class_243 camera;

    @Shadow
    private static void method_3291(class_4587 matrixStack, class_4588 vertexConsumer, class_265 voxelShape, double d2, double e2, double f2, float red, float green, float blue, float alpha) {
        throw new AssertionError();
    }

    @ModifyConstant(method={"renderLevel"}, constant={@Constant(doubleValue=1024.0, ordinal=0)})
    private double disableBlockDamageDistanceCheck(double originalBlockDamageDistanceConstant) {
        return Double.MAX_VALUE;
    }

    @Inject(method={"renderHitOutline"}, at={@At(value="HEAD")}, cancellable=true)
    private void preRenderHitOutline(class_4587 matrixStack, class_4588 vertexConsumer, class_1297 entity, double camX, double camY, double camZ, class_2338 blockPos, class_2680 blockState, CallbackInfo ci) {
        ci.cancel();
        ClientShip ship = VSGameUtilsKt.getLoadedShipManagingPos(this.field_4085, (class_2382)blockPos);
        if (ship != null) {
            matrixStack.method_22903();
            VSClientGameUtils.transformRenderWithShip(ship.getRenderTransform(), matrixStack, blockPos, camX, camY, camZ);
            MixinLevelRenderer.method_3291(matrixStack, vertexConsumer, blockState.method_26172((class_1922)this.field_4085, blockPos, class_3726.method_16195((class_1297)entity)), 0.0, 0.0, 0.0, 0.0f, 0.0f, 0.0f, 0.4f);
            matrixStack.method_22909();
        } else {
            MixinLevelRenderer.method_3291(matrixStack, vertexConsumer, blockState.method_26172((class_1922)this.field_4085, blockPos, class_3726.method_16195((class_1297)entity)), (double)blockPos.method_10263() - camX, (double)blockPos.method_10264() - camY, (double)blockPos.method_10260() - camZ, 0.0f, 0.0f, 0.0f, 0.4f);
        }
    }

    @WrapOperation(method={"renderLevel"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/renderer/LevelRenderer;isChunkCompiled(Lnet/minecraft/core/BlockPos;)Z")})
    private boolean isInShipyardBorder(class_761 instance, class_2338 blockPos, Operation<Boolean> original) {
        if (((Boolean)original.call(new Object[]{instance, blockPos})).booleanValue()) {
            return true;
        }
        if (VSGameUtilsKt.isBlockInShipyard((class_1937)this.field_4085, blockPos)) {
            class_2338 blockPos1 = blockPos.method_10069(-1, -1, -1);
            class_2338 blockPos2 = blockPos.method_10069(1, 1, 1);
            for (class_2338 neighbor : class_2338.method_10097((class_2338)blockPos1, (class_2338)blockPos2)) {
                if (!((Boolean)original.call(new Object[]{instance, neighbor})).booleanValue()) continue;
                return true;
            }
        }
        return false;
    }
}

