/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  net.minecraft.class_3218
 *  org.spongepowered.asm.mixin.Mixin
 *  rbasamoyai.ritchiesprojectilelib.RitchiesProjectileLib
 */
package org.valkyrienskies.mod.mixin.mod_compat.create_big_cannons;

import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import net.minecraft.class_3218;
import org.spongepowered.asm.mixin.Mixin;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import rbasamoyai.ritchiesprojectilelib.RitchiesProjectileLib;

@Mixin(value={RitchiesProjectileLib.class})
public class MixinRitchiesProjectileLib {
    @WrapMethod(method={"queueForceLoad"})
    private static void cancelIfShipyard(class_3218 level, int chunkX, int chunkZ, Operation<Void> original) {
        if (VSGameUtilsKt.getShipManagingPos(level, chunkX, chunkZ) != null) {
            return;
        }
        original.call(new Object[]{level, chunkX, chunkZ});
    }
}

