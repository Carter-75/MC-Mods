/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_3609
 *  net.minecraft.class_3610
 *  net.minecraft.class_3616
 *  net.minecraft.class_5819
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package org.valkyrienskies.mod.mixin.feature.fire_between_ship_and_world;

import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_3609;
import net.minecraft.class_3610;
import net.minecraft.class_3616;
import net.minecraft.class_5819;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.valkyrienskies.mod.common.VSGameUtilsKt;

@Mixin(value={class_3616.class})
public abstract class LavaFluidMixin
extends class_3609 {
    @Unique
    private boolean isModifyingFireTick = false;

    @Inject(method={"randomTick"}, at={@At(value="TAIL")})
    public void fireTickMixin(class_1937 level, class_2338 pos, class_3610 state, class_5819 random, CallbackInfo ci) {
        if (this.isModifyingFireTick) {
            return;
        }
        this.isModifyingFireTick = true;
        double origX = pos.method_10263();
        double origY = pos.method_10264();
        double origZ = pos.method_10260();
        VSGameUtilsKt.transformToNearbyShipsAndWorld(level, origX, origY, origZ, 3.0, (x, y, z) -> this.method_15792(level, class_2338.method_49637((double)x, (double)y, (double)z), state, random));
        this.isModifyingFireTick = false;
    }
}

