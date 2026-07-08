/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation
 *  com.llamalad7.mixinextras.sugar.Local
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_2374
 *  net.minecraft.class_243
 *  net.minecraft.class_3218
 *  net.minecraft.class_5707
 *  net.minecraft.class_5716
 *  net.minecraft.class_7269
 *  net.minecraft.class_8514$class_5719
 *  net.minecraft.class_8514$class_8517
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 */
package org.valkyrienskies.mod.mixin.feature.sculk;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import java.util.Optional;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_2374;
import net.minecraft.class_243;
import net.minecraft.class_3218;
import net.minecraft.class_5707;
import net.minecraft.class_5716;
import net.minecraft.class_7269;
import net.minecraft.class_8514;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.valkyrienskies.mod.common.VSGameUtilsKt;

@Mixin(value={class_8514.class_8517.class})
public interface MixinVibrationSystemTicker {
    @WrapOperation(method={"receiveVibration"}, at={@At(value="INVOKE", target="Lnet/minecraft/world/level/gameevent/vibrations/VibrationInfo;pos()Lnet/minecraft/world/phys/Vec3;")})
    private static class_243 destWorldPos(class_7269 instance, Operation<class_243> original, @Local(argsOnly=true) class_3218 serverLevel) {
        return VSGameUtilsKt.toWorldCoordinates((class_1937)serverLevel, (class_243)original.call(new Object[]{instance}));
    }

    @WrapOperation(method={"receiveVibration"}, at={@At(value="INVOKE", target="Lnet/minecraft/world/level/gameevent/vibrations/VibrationSystem$User;getPositionSource()Lnet/minecraft/world/level/gameevent/PositionSource;")})
    private static class_5716 destSourcePos(class_8514.class_5719 instance, Operation<class_5716> original, @Local(argsOnly=true) class_3218 serverLevel) {
        class_5716 trueResult = (class_5716)original.call(new Object[]{instance});
        Optional optPos = trueResult.method_32956((class_1937)serverLevel);
        if (optPos.isPresent()) {
            return new class_5707(class_2338.method_49638((class_2374)VSGameUtilsKt.toWorldCoordinates((class_1937)serverLevel, (class_243)optPos.get())));
        }
        return trueResult;
    }

    @WrapOperation(method={"tryReloadVibrationParticle"}, at={@At(value="INVOKE", target="Lnet/minecraft/world/level/gameevent/vibrations/VibrationSystem$User;getPositionSource()Lnet/minecraft/world/level/gameevent/PositionSource;")})
    private static class_5716 destReloadSourcePos(class_8514.class_5719 instance, Operation<class_5716> original, @Local(argsOnly=true) class_3218 serverLevel) {
        return MixinVibrationSystemTicker.destSourcePos(instance, original, serverLevel);
    }
}

