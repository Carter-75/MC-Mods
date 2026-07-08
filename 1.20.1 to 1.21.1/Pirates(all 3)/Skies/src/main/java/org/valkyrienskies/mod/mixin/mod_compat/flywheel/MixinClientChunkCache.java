/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1937
 *  net.minecraft.class_1944
 *  net.minecraft.class_4076
 *  net.minecraft.class_631
 *  net.minecraft.class_638
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package org.valkyrienskies.mod.mixin.mod_compat.flywheel;

import net.minecraft.class_1937;
import net.minecraft.class_1944;
import net.minecraft.class_4076;
import net.minecraft.class_631;
import net.minecraft.class_638;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.valkyrienskies.core.api.ships.ClientShip;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.compat.LoadedMods;
import org.valkyrienskies.mod.compat.flywheel.FlywheelCompat;

@Mixin(value={class_631.class})
public class MixinClientChunkCache {
    @Shadow
    @Final
    class_638 field_16525;

    @Inject(method={"onLightUpdate"}, at={@At(value="HEAD")})
    private void vs_flywheel$onLightUpdate(class_1944 layer, class_4076 pos, CallbackInfo ci) {
        if (LoadedMods.getFlywheel() != LoadedMods.FlywheelVersion.V1) {
            return;
        }
        ClientShip ship = (ClientShip)VSGameUtilsKt.getShipManagingPos((class_1937)this.field_16525, pos.method_10263(), pos.method_10260());
        if (ship != null) {
            FlywheelCompat.INSTANCE.onLightUpdate(ship, pos);
        }
    }
}

