/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.simibubi.create.content.trains.entity.TrainRelocationPacket
 *  net.minecraft.class_1297
 *  net.minecraft.class_1937
 *  net.minecraft.class_2374
 *  net.minecraft.class_243
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Redirect
 */
package org.valkyrienskies.mod.mixin.mod_compat.create.packets;

import com.simibubi.create.content.trains.entity.TrainRelocationPacket;
import net.minecraft.class_1297;
import net.minecraft.class_1937;
import net.minecraft.class_2374;
import net.minecraft.class_243;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.mod.common.VSGameUtilsKt;

@Mixin(value={TrainRelocationPacket.class})
public abstract class MixinTrainRelocationPacket {
    @Unique
    private class_1937 level;

    @Redirect(method={"*"}, at=@At(value="INVOKE", target="Lnet/minecraft/world/phys/Vec3;closerThan(Lnet/minecraft/core/Position;D)Z"))
    private boolean redirectCloserThan(class_243 instance, class_2374 arg, double d2) {
        class_243 newVec3 = (class_243)arg;
        Ship ship = VSGameUtilsKt.getShipManagingPos(this.level, arg);
        if (ship != null) {
            newVec3 = VSGameUtilsKt.toWorldCoordinates(ship, (class_243)arg);
        }
        return instance.method_24802((class_2374)newVec3, d2);
    }

    @Redirect(method={"*"}, at=@At(value="INVOKE", target="Lnet/minecraft/world/level/Level;getEntity(I)Lnet/minecraft/world/entity/Entity;"))
    private class_1297 stealLevel(class_1937 instance, int i2) {
        this.level = instance;
        return this.level.method_8469(i2);
    }
}

