/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  net.minecraft.class_1937
 *  net.minecraft.class_243
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Pseudo
 */
package org.valkyrienskies.mod.mixin.mod_compat.echochest;

import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import net.minecraft.class_1937;
import net.minecraft.class_243;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.valkyrienskies.mod.mixin.mod_compat.echochest.MixinVibrationSystemAccessor;

@Pseudo
@Mixin(targets={"fuzs.echochest.world.level.block.entity.EchoChestBlockEntity"}, remap=false)
public class MixinEchoChestBlockEntity {
    @WrapMethod(method={"isOccluded"})
    private static boolean adjustOcclusionForWorldPosition(class_1937 level, class_243 pos1, class_243 pos2, Operation<Boolean> original) {
        return MixinVibrationSystemAccessor.isOccluded(level, pos1, pos2);
    }
}

