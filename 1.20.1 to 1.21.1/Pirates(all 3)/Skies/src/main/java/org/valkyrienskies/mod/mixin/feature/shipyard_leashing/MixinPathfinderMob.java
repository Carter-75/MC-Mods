/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1314
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_2374
 *  net.minecraft.class_243
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Redirect
 */
package org.valkyrienskies.mod.mixin.feature.shipyard_leashing;

import net.minecraft.class_1297;
import net.minecraft.class_1314;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_2374;
import net.minecraft.class_243;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.mod.common.VSGameUtilsKt;

@Mixin(value={class_1314.class})
public abstract class MixinPathfinderMob {
    @Redirect(method={"tickLeash"}, at=@At(value="INVOKE", target="Lnet/minecraft/world/entity/Entity;blockPosition()Lnet/minecraft/core/BlockPos;"))
    class_2338 worldAwareRestrictPos(class_1297 entity) {
        Ship shipOther;
        class_2338 entityBlockPos = entity.method_24515();
        Ship shipThis = VSGameUtilsKt.getShipManaging((class_1297)class_1297.class.cast(this));
        if (shipThis != (shipOther = VSGameUtilsKt.getShipManaging(entity)) && shipOther != null) {
            entityBlockPos = class_2338.method_49638((class_2374)VSGameUtilsKt.toWorldCoordinates(shipOther, entity.method_19538()).method_1031(0.5, 0.5, 0.5));
        }
        return entityBlockPos;
    }

    @Redirect(method={"tickLeash"}, at=@At(value="INVOKE", target="Lnet/minecraft/world/entity/PathfinderMob;distanceTo(Lnet/minecraft/world/entity/Entity;)F"))
    float worldAwareDistanceTo(class_1314 instance, class_1297 entity) {
        return (float)VSGameUtilsKt.toWorldCoordinates(instance.method_37908(), instance.method_19538()).method_1022(VSGameUtilsKt.toWorldCoordinates(entity.method_37908(), entity.method_19538()));
    }

    @Redirect(method={"tickLeash"}, at=@At(value="INVOKE", target="Lnet/minecraft/world/entity/Entity;getX()D", ordinal=-1))
    double worldAwareLeashX(class_1297 instance) {
        return VSGameUtilsKt.toWorldCoordinates((class_1937)instance.method_37908(), (class_243)instance.method_19538()).field_1352;
    }

    @Redirect(method={"tickLeash"}, at=@At(value="INVOKE", target="Lnet/minecraft/world/entity/Entity;getY()D", ordinal=-1))
    double worldAwareLeashY(class_1297 instance) {
        return VSGameUtilsKt.toWorldCoordinates((class_1937)instance.method_37908(), (class_243)instance.method_19538()).field_1351;
    }

    @Redirect(method={"tickLeash"}, at=@At(value="INVOKE", target="Lnet/minecraft/world/entity/Entity;getZ()D", ordinal=-1))
    double worldAwareLeashZ(class_1297 instance) {
        return VSGameUtilsKt.toWorldCoordinates((class_1937)instance.method_37908(), (class_243)instance.method_19538()).field_1350;
    }
}

