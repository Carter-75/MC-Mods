/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.simibubi.create.content.trains.entity.TrainRelocator
 *  net.minecraft.class_1937
 *  net.minecraft.class_2374
 *  net.minecraft.class_243
 *  net.minecraft.class_310
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Redirect
 */
package org.valkyrienskies.mod.mixin.mod_compat.create.client;

import com.simibubi.create.content.trains.entity.TrainRelocator;
import net.minecraft.class_1937;
import net.minecraft.class_2374;
import net.minecraft.class_243;
import net.minecraft.class_310;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.mod.common.VSGameUtilsKt;

@Mixin(value={TrainRelocator.class})
public abstract class MixinTrainRelocator {
    @Redirect(method={"*"}, at=@At(value="INVOKE", target="Lnet/minecraft/world/phys/Vec3;closerThan(Lnet/minecraft/core/Position;D)Z"))
    private static boolean redirectCloserThan(class_243 instance, class_2374 arg, double d2) {
        class_243 newVec3 = (class_243)arg;
        class_1937 world = class_310.method_1551().field_1724.method_37908();
        Ship ship = VSGameUtilsKt.getShipManagingPos(world, arg);
        if (ship != null) {
            newVec3 = VSGameUtilsKt.toWorldCoordinates(ship, (class_243)arg);
        }
        return instance.method_24802((class_2374)newVec3, d2);
    }
}

