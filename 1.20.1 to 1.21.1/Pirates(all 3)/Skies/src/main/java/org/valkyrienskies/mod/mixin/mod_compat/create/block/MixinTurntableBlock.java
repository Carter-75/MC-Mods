/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation
 *  com.llamalad7.mixinextras.sugar.Local
 *  com.simibubi.create.content.kinetics.turntable.TurntableBlock
 *  com.simibubi.create.content.kinetics.turntable.TurntableBlockEntity
 *  net.minecraft.class_1297
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_2382
 *  net.minecraft.class_243
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 */
package org.valkyrienskies.mod.mixin.mod_compat.create.block;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import com.simibubi.create.content.kinetics.turntable.TurntableBlock;
import com.simibubi.create.content.kinetics.turntable.TurntableBlockEntity;
import net.minecraft.class_1297;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_2382;
import net.minecraft.class_243;
import org.joml.Vector3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.util.VectorConversionsMCKt;

@Mixin(value={TurntableBlock.class})
public class MixinTurntableBlock {
    @WrapOperation(method={"entityInside"}, at={@At(value="INVOKE", target="Lnet/minecraft/world/entity/Entity;getY()D")})
    private double getYtoShip(class_1297 entity, Operation<Double> original, @Local(argsOnly=true) class_1937 worldIn, @Local(argsOnly=true) class_2338 pos) {
        Ship ship = VSGameUtilsKt.getShipManagingPos(worldIn, pos);
        if (ship != null) {
            return ship.getWorldToShip().transformPosition((Vector3d)VectorConversionsMCKt.toJOML((class_243)entity.method_19538())).y;
        }
        return (Double)original.call(new Object[]{entity});
    }

    @WrapOperation(method={"lambda$entityInside$0"}, at={@At(value="INVOKE", target="Lnet/createmod/catnip/math/VecHelper;getCenterOf(Lnet/minecraft/core/Vec3i;)Lnet/minecraft/world/phys/Vec3;")})
    private static class_243 positionToWorld(class_2382 pos, Operation<class_243> original, @Local(argsOnly=true) TurntableBlockEntity tbe) {
        class_243 result2 = (class_243)original.call(new Object[]{pos});
        if (VSGameUtilsKt.isBlockInShipyard(tbe.method_10997(), tbe.method_11016())) {
            return VSGameUtilsKt.toWorldCoordinates(tbe.method_10997(), result2);
        }
        return result2;
    }
}

