/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  dan200.computercraft.shared.peripheral.speaker.SpeakerPosition
 *  net.minecraft.class_1937
 *  net.minecraft.class_2374
 *  net.minecraft.class_243
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Pseudo
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Redirect
 */
package org.valkyrienskies.mod.mixin.mod_compat.cc_tweaked;

import dan200.computercraft.shared.peripheral.speaker.SpeakerPosition;
import net.minecraft.class_1937;
import net.minecraft.class_2374;
import net.minecraft.class_243;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.mod.common.VSGameUtilsKt;

@Pseudo
@Mixin(value={SpeakerPosition.class}, priority=2000)
public abstract class MixinSpeakerPosition {
    @Shadow
    public abstract class_1937 level();

    @Redirect(method={"withinDistance"}, at=@At(value="INVOKE", target="Lnet/minecraft/world/phys/Vec3;distanceToSqr(Lnet/minecraft/world/phys/Vec3;)D"))
    public double withinDistance$distanceToSqr(class_243 position, class_243 other) {
        Ship ship = VSGameUtilsKt.getShipManagingPos(this.level(), (class_2374)position);
        if (ship != null) {
            return VSGameUtilsKt.squaredDistanceBetweenInclShips(this.level(), position.field_1352, position.field_1351, position.field_1350, other.field_1352, other.field_1351, other.field_1350);
        }
        return position.method_1025(other);
    }
}

