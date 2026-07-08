/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_638
 *  net.minecraft.class_6539
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.ModifyVariable
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package org.valkyrienskies.mod.mixin.feature.block_tint;

import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_638;
import net.minecraft.class_6539;
import org.joml.Vector3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.config.VSGameConfig;

@Mixin(value={class_638.class})
public abstract class MixinClientLevel {
    @ModifyVariable(method={"calculateBlockTint(Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/ColorResolver;)I"}, ordinal=0, at=@At(value="HEAD"), argsOnly=true)
    private class_2338 fixBlockPos(class_2338 old) {
        if (!VSGameConfig.CLIENT.getBlockTinting().getFixBlockTinting()) {
            return old;
        }
        Vector3d newPos = VSGameUtilsKt.toWorldCoordinates((class_1937)class_638.class.cast(this), new Vector3d(old.method_10263(), old.method_10264(), old.method_10260()));
        return class_2338.method_49637((double)newPos.x, (double)newPos.y, (double)newPos.z);
    }

    @Inject(method={"getBlockTint(Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/ColorResolver;)I"}, at={@At(value="HEAD")}, cancellable=true)
    public void getBlockTint(class_2338 blockPos, class_6539 colorResolver, CallbackInfoReturnable<Integer> cir) {
        if (VSGameConfig.CLIENT.getBlockTinting().getFixBlockTinting() && VSGameUtilsKt.isBlockInShipyard((class_1937)class_638.class.cast(this), blockPos)) {
            cir.setReturnValue((Object)((class_638)class_638.class.cast(this)).method_23780(blockPos, colorResolver));
        }
    }
}

