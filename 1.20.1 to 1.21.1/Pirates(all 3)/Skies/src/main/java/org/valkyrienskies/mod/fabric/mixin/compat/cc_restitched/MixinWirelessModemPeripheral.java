/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation
 *  dan200.computercraft.shared.peripheral.modem.wireless.WirelessModemPeripheral
 *  net.minecraft.class_243
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Pseudo
 *  org.spongepowered.asm.mixin.injection.At
 */
package org.valkyrienskies.mod.fabric.mixin.compat.cc_restitched;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import dan200.computercraft.shared.peripheral.modem.wireless.WirelessModemPeripheral;
import net.minecraft.class_243;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.valkyrienskies.mod.common.VSGameUtilsKt;

@Pseudo
@Mixin(value={WirelessModemPeripheral.class})
public abstract class MixinWirelessModemPeripheral {
    @WrapOperation(method={"getRange"}, at={@At(value="INVOKE", target="Ldan200/computercraft/shared/peripheral/modem/wireless/WirelessModemPeripheral;getPosition()Lnet/minecraft/world/phys/Vec3;")})
    public class_243 ValkyrienSkies$getPosition(WirelessModemPeripheral instance, Operation<class_243> original) {
        return VSGameUtilsKt.toWorldCoordinates(instance.getLevel(), (class_243)original.call(new Object[]{instance}));
    }
}

