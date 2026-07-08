/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  net.minecraft.class_1263
 *  net.minecraft.class_1297
 *  net.minecraft.class_1657
 *  net.minecraft.class_243
 *  net.minecraft.class_3908
 *  net.minecraft.class_7265
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 */
package org.valkyrienskies.mod.fabric.mixin.entity;

import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import net.minecraft.class_1263;
import net.minecraft.class_1297;
import net.minecraft.class_1657;
import net.minecraft.class_243;
import net.minecraft.class_3908;
import net.minecraft.class_7265;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.valkyrienskies.mod.common.VSGameUtilsKt;

@Mixin(value={class_7265.class})
public interface MixinContainerEntity
extends class_1263,
class_3908 {
    @Shadow
    public boolean method_31481();

    @Shadow
    public class_243 method_19538();

    @WrapMethod(method={"isChestVehicleStillValid"})
    default public boolean isChestVehicleStillValid(class_1657 player, Operation<Boolean> original) {
        if (((Boolean)original.call(new Object[]{player})).booleanValue()) {
            return true;
        }
        return VSGameUtilsKt.squaredDistanceToInclShips((class_1297)player, this.method_19538().field_1352, this.method_19538().field_1351, this.method_19538().field_1350) <= 64.0;
    }
}

