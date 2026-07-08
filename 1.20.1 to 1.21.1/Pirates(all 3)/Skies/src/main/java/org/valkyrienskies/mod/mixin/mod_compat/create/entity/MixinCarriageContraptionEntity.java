/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation
 *  com.simibubi.create.content.trains.entity.CarriageContraptionEntity
 *  net.minecraft.class_1657
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_2374
 *  net.minecraft.class_243
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 *  org.spongepowered.asm.mixin.injection.callback.LocalCapture
 */
package org.valkyrienskies.mod.mixin.mod_compat.create.entity;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.simibubi.create.content.trains.entity.CarriageContraptionEntity;
import java.util.Collection;
import net.minecraft.class_1657;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_2374;
import net.minecraft.class_243;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.mod.common.VSGameUtilsKt;

@Mixin(value={CarriageContraptionEntity.class})
public abstract class MixinCarriageContraptionEntity {
    @Unique
    private class_1937 vs$world;

    @Inject(method={"control"}, at={@At(value="HEAD")}, locals=LocalCapture.CAPTURE_FAILHARD)
    private void injectCaptureLevel(class_2338 controlsLocalPos, Collection<Integer> heldControls, class_1657 player, CallbackInfoReturnable<Boolean> cir) {
        this.vs$world = player.method_37908();
    }

    @WrapOperation(method={"control"}, at={@At(value="INVOKE", target="Lnet/minecraft/world/phys/Vec3;closerThan(Lnet/minecraft/core/Position;D)Z")})
    private boolean wrapCloserThan(class_243 instance, class_2374 arg, double d2, Operation<Boolean> closerThan) {
        class_243 newVec3 = instance;
        if (VSGameUtilsKt.isBlockInShipyard(this.vs$world, class_2338.method_49637((double)instance.field_1352, (double)instance.field_1351, (double)instance.field_1350))) {
            Ship ship = VSGameUtilsKt.getShipManagingPos(this.vs$world, (class_2374)instance);
            newVec3 = VSGameUtilsKt.toWorldCoordinates(ship, instance);
        }
        return (Boolean)closerThan.call(new Object[]{newVec3, arg, d2});
    }
}

