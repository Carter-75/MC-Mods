/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation
 *  com.simibubi.create.content.logistics.chute.ChuteBlockEntity
 *  com.simibubi.create.foundation.blockEntity.SmartBlockEntity
 *  net.minecraft.class_2338
 *  net.minecraft.class_238
 *  net.minecraft.class_243
 *  net.minecraft.class_2591
 *  net.minecraft.class_2680
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 */
package org.valkyrienskies.mod.mixin.mod_compat.create.blockentity;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.simibubi.create.content.logistics.chute.ChuteBlockEntity;
import com.simibubi.create.foundation.blockEntity.SmartBlockEntity;
import net.minecraft.class_2338;
import net.minecraft.class_238;
import net.minecraft.class_243;
import net.minecraft.class_2591;
import net.minecraft.class_2680;
import org.joml.Vector3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.util.VectorConversionsMCKt;

@Mixin(value={ChuteBlockEntity.class})
public abstract class MixinChuteBlockEntity
extends SmartBlockEntity {
    public MixinChuteBlockEntity(class_2591<?> type, class_2338 pos, class_2680 state) {
        super(type, pos, state);
    }

    @WrapOperation(method={"findEntities"}, at={@At(value="INVOKE", target="Lnet/minecraft/world/phys/AABB;getCenter()Lnet/minecraft/world/phys/Vec3;")})
    private class_243 wrapStartingPos(class_238 aabb, Operation<class_243> original) {
        Ship ship = VSGameUtilsKt.getShipManagingPos(this.field_11863, this.method_11016());
        if (ship != null) {
            Vector3d shipPos = VectorConversionsMCKt.toJOML((class_243)original.call(new Object[]{aabb}));
            ship.getWorldToShip().transformPosition(shipPos);
            return VectorConversionsMCKt.toMinecraft(shipPos);
        }
        return (class_243)original.call(new Object[]{aabb});
    }
}

