/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_2382
 *  net.minecraft.class_243
 *  net.minecraft.class_310
 *  net.minecraft.class_638
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 *  traben.entity_model_features.models.animation.EMFAnimationEntityContext
 *  traben.entity_model_features.models.animation.state.EMFEntityRenderState
 */
package org.valkyrienskies.mod.fabric.mixin.compat.emf;

import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_2382;
import net.minecraft.class_243;
import net.minecraft.class_310;
import net.minecraft.class_638;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import traben.entity_model_features.models.animation.EMFAnimationEntityContext;
import traben.entity_model_features.models.animation.state.EMFEntityRenderState;

@Mixin(value={EMFAnimationEntityContext.class})
public class MixinEMFAnimationEntityContext {
    @Shadow
    @Nullable
    private static EMFEntityRenderState emfState;

    @Inject(at={@At(value="HEAD")}, method={"distanceOfEntityFrom"}, cancellable=true)
    private static void distanceOfEntityFrom(class_2338 pos, CallbackInfoReturnable<Integer> cir) {
        if (emfState != null) {
            class_638 level = class_310.method_1551().field_1687;
            class_243 posW = VSGameUtilsKt.toWorldCoordinates((class_1937)level, class_243.method_24953((class_2382)pos));
            class_243 entityW = VSGameUtilsKt.toWorldCoordinates((class_1937)level, class_243.method_24953((class_2382)emfState.blockPos()));
            double dist = posW.method_1022(entityW);
            cir.setReturnValue((Object)((int)dist));
        }
    }
}

