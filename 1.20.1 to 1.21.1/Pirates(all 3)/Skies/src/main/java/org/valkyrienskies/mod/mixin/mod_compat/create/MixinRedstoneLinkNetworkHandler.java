/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.simibubi.create.content.redstone.link.IRedstoneLinkable
 *  com.simibubi.create.content.redstone.link.RedstoneLinkNetworkHandler
 *  net.minecraft.class_1936
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_2374
 *  net.minecraft.class_2382
 *  net.minecraft.class_243
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.Redirect
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package org.valkyrienskies.mod.mixin.mod_compat.create;

import com.simibubi.create.content.redstone.link.IRedstoneLinkable;
import com.simibubi.create.content.redstone.link.RedstoneLinkNetworkHandler;
import net.minecraft.class_1936;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_2374;
import net.minecraft.class_2382;
import net.minecraft.class_243;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.util.VectorConversionsMCKt;

@Mixin(value={RedstoneLinkNetworkHandler.class})
public abstract class MixinRedstoneLinkNetworkHandler {
    @Unique
    private static class_1937 harvestedWorld;

    @Redirect(method={"withinRange"}, at=@At(value="INVOKE", target="Lnet/minecraft/core/BlockPos;closerThan(Lnet/minecraft/core/Vec3i;D)Z"))
    private static boolean redirectCloserThan(class_2338 instance, class_2382 vec3i, double v) {
        Ship ship1 = VSGameUtilsKt.getShipManagingPos(harvestedWorld, instance);
        Ship ship2 = VSGameUtilsKt.getShipManagingPos(harvestedWorld, new class_2338(vec3i));
        class_243 pos1 = class_243.method_24954((class_2382)instance);
        class_243 pos2 = class_243.method_24954((class_2382)vec3i);
        if (ship1 != null) {
            pos1 = VectorConversionsMCKt.toMinecraft(ship1.getShipToWorld().transformPosition(VectorConversionsMCKt.toJOML(pos1)));
        }
        if (ship2 != null) {
            pos2 = VectorConversionsMCKt.toMinecraft(ship2.getShipToWorld().transformPosition(VectorConversionsMCKt.toJOML(pos2)));
        }
        return pos1.method_24802((class_2374)pos2, v);
    }

    @Inject(method={"updateNetworkOf"}, at={@At(value="HEAD")})
    private void harvestLevel(class_1936 world, IRedstoneLinkable actor, CallbackInfo ci) {
        harvestedWorld = (class_1937)world;
    }
}

