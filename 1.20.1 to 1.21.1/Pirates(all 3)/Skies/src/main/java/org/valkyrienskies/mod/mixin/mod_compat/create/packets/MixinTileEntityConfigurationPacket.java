/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.sugar.Local
 *  com.simibubi.create.foundation.networking.BlockEntityConfigurationPacket
 *  net.minecraft.class_1297
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_2382
 *  net.minecraft.class_3222
 *  net.minecraft.class_3532
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Redirect
 */
package org.valkyrienskies.mod.mixin.mod_compat.create.packets;

import com.llamalad7.mixinextras.sugar.Local;
import com.simibubi.create.foundation.networking.BlockEntityConfigurationPacket;
import net.minecraft.class_1297;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_2382;
import net.minecraft.class_3222;
import net.minecraft.class_3532;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.valkyrienskies.mod.common.VSGameUtilsKt;

@Mixin(value={BlockEntityConfigurationPacket.class})
public abstract class MixinTileEntityConfigurationPacket {
    @Unique
    private class_1937 _clockworkLevel;

    @Redirect(method={"lambda$handle$0"}, at=@At(value="INVOKE", target="Lnet/minecraft/core/BlockPos;closerThan(Lnet/minecraft/core/Vec3i;D)Z"))
    private boolean redirectCloserThan(class_2338 instance, class_2382 vec3i, double v, @Local class_3222 player) {
        class_2338 blockPos = instance;
        if (VSGameUtilsKt.isBlockInShipyard(this._clockworkLevel, instance)) {
            double distance = VSGameUtilsKt.squaredDistanceToInclShips((class_1297)player, instance.method_10263(), instance.method_10264(), instance.method_10260());
            return distance < class_3532.method_33723((double)v);
        }
        return blockPos.method_19771(vec3i, v);
    }

    @Redirect(method={"lambda$handle$0"}, at=@At(value="INVOKE", target="Lnet/minecraft/world/level/Level;isLoaded(Lnet/minecraft/core/BlockPos;)Z"))
    private boolean injectCaptureLevel(class_1937 instance, class_2338 pos) {
        this._clockworkLevel = instance;
        return instance.method_8477(pos);
    }
}

