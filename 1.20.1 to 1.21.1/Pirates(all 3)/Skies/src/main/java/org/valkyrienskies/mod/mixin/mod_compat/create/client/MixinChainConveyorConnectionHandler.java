/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.sugar.Local
 *  com.simibubi.create.content.kinetics.chainConveyor.ChainConveyorConnectionHandler
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package org.valkyrienskies.mod.mixin.mod_compat.create.client;

import com.llamalad7.mixinextras.sugar.Local;
import com.simibubi.create.content.kinetics.chainConveyor.ChainConveyorConnectionHandler;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.valkyrienskies.mod.common.VSGameUtilsKt;

@Mixin(value={ChainConveyorConnectionHandler.class})
public abstract class MixinChainConveyorConnectionHandler {
    @Shadow
    private static class_2338 firstPos;

    @Inject(method={"clientTick"}, at={@At(value="INVOKE", target="Lnet/minecraft/world/phys/Vec3;length()D")}, cancellable=true)
    private static void cancelDrawIfTooFar(CallbackInfo ci, @Local class_1937 level, @Local class_2338 pos) {
        if (VSGameUtilsKt.getShipManagingPos(level, firstPos) != VSGameUtilsKt.getShipManagingPos(level, pos)) {
            ci.cancel();
        }
    }
}

