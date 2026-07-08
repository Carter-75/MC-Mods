/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation
 *  com.llamalad7.mixinextras.sugar.Local
 *  com.simibubi.create.content.logistics.funnel.FunnelBlock
 *  net.minecraft.class_1297
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_2374
 *  net.minecraft.class_243
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 */
package org.valkyrienskies.mod.mixin.mod_compat.create.block;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import com.simibubi.create.content.logistics.funnel.FunnelBlock;
import net.minecraft.class_1297;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_2374;
import net.minecraft.class_243;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.util.VectorConversionsMCKt;

@Mixin(value={FunnelBlock.class})
public class MixinFunnelBlock {
    @WrapOperation(method={"entityInside"}, at={@At(value="INVOKE", target="Lnet/minecraft/world/entity/Entity;position()Lnet/minecraft/world/phys/Vec3;")})
    public class_243 transformPos(class_1297 entity, Operation<class_243> original, @Local(argsOnly=true) class_1937 levelIn, @Local(argsOnly=true) class_2338 blockPos) {
        Ship ship = VSGameUtilsKt.getShipManagingPos(entity.method_37908(), blockPos);
        class_243 pos = (class_243)original.call(new Object[]{entity});
        if (ship != null) {
            pos = VectorConversionsMCKt.toMinecraft(ship.getWorldToShip().transformPosition(VSGameUtilsKt.getWorldCoordinates(levelIn, class_2338.method_49638((class_2374)pos), VectorConversionsMCKt.toJOML(pos))));
        }
        return pos;
    }
}

