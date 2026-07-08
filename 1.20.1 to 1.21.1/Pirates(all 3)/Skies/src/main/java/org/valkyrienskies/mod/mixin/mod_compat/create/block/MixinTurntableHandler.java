/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation
 *  com.llamalad7.mixinextras.sugar.Share
 *  com.llamalad7.mixinextras.sugar.ref.LocalRef
 *  com.simibubi.create.content.kinetics.turntable.TurntableHandler
 *  net.minecraft.class_2338
 *  net.minecraft.class_243
 *  net.minecraft.class_310
 *  net.minecraft.class_746
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package org.valkyrienskies.mod.mixin.mod_compat.create.block;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Share;
import com.llamalad7.mixinextras.sugar.ref.LocalRef;
import com.simibubi.create.content.kinetics.turntable.TurntableHandler;
import net.minecraft.class_2338;
import net.minecraft.class_243;
import net.minecraft.class_310;
import net.minecraft.class_746;
import org.joml.Vector3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.util.VectorConversionsMCKt;

@Mixin(value={TurntableHandler.class})
public class MixinTurntableHandler {
    @Inject(method={"gameRenderTick"}, at={@At(value="HEAD")}, remap=false)
    private static void wrapRenderTick(CallbackInfo ci, @Share(value="ship") LocalRef<Ship> shipOn) {
        class_746 player = class_310.method_1551().field_1724;
        if (player != null) {
            shipOn.set((Object)VSGameUtilsKt.getShipManagingPos(player.method_37908(), player.method_23312()));
        }
    }

    @WrapOperation(method={"gameRenderTick"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/player/LocalPlayer;blockPosition()Lnet/minecraft/core/BlockPos;")})
    private static class_2338 wrapBlockPos(class_746 player, Operation<class_2338> original, @Share(value="ship") LocalRef<Ship> shipOn) {
        if (shipOn.get() != null) {
            return player.method_23312();
        }
        return (class_2338)original.call(new Object[]{player});
    }

    @WrapOperation(method={"gameRenderTick"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/player/LocalPlayer;position()Lnet/minecraft/world/phys/Vec3;")})
    private static class_243 wrapPosition(class_746 player, Operation<class_243> original, @Share(value="ship") LocalRef<Ship> shipOn) {
        Vector3d result2 = VectorConversionsMCKt.toJOML((class_243)original.call(new Object[]{player}));
        if (shipOn.get() != null) {
            ((Ship)shipOn.get()).getWorldToShip().transformPosition(result2);
        }
        return VectorConversionsMCKt.toMinecraft(result2);
    }
}

