/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_14
 *  net.minecraft.class_1922
 *  net.minecraft.class_1950
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_7
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package org.valkyrienskies.mod.mixin.feature.ai.node_evaluator;

import net.minecraft.class_14;
import net.minecraft.class_1922;
import net.minecraft.class_1950;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_7;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.config.VSGameConfig;
import org.valkyrienskies.mod.mixin.feature.ai.node_evaluator.PathNavigationRegionAccessor;

@Mixin(value={class_14.class})
public class WalkNodeEvaluatorMixin {
    @Unique
    private static boolean isModifyingPathType = false;

    @Shadow
    protected static class_7 method_58(class_1922 blockGetter, class_2338 blockPos) {
        return null;
    }

    @Inject(method={"getBlockPathTypeRaw"}, at={@At(value="RETURN")}, cancellable=true)
    private static void getBlockPathTypeForShips(class_1922 blockGetter, class_2338 blockPos, CallbackInfoReturnable<class_7> cir) {
        if (isModifyingPathType || !VSGameConfig.SERVER.getAiOnShips()) {
            return;
        }
        isModifyingPathType = true;
        double origX = blockPos.method_10263();
        double origY = blockPos.method_10264();
        double origZ = blockPos.method_10260();
        if (blockGetter instanceof class_1950) {
            VSGameUtilsKt.transformToNearbyShipsAndWorld(((PathNavigationRegionAccessor)blockGetter).getLevel(), origX, origY, origZ, 2.0, (x, y, z) -> {
                class_2338 groundPos = class_2338.method_49637((double)x, (double)y, (double)z);
                class_7 pathType = WalkNodeEvaluatorMixin.method_58((class_1922)((PathNavigationRegionAccessor)blockGetter).getLevel(), groundPos);
                for (class_2350 dir : class_2350.values()) {
                    if (pathType != class_7.field_7 && pathType != class_7.field_22) break;
                    pathType = WalkNodeEvaluatorMixin.method_58((class_1922)((PathNavigationRegionAccessor)blockGetter).getLevel(), groundPos.method_10093(dir));
                }
                cir.setReturnValue((Object)pathType);
            });
        }
        isModifyingPathType = false;
    }
}

