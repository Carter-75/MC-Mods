/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation
 *  com.simibubi.create.content.trains.entity.Carriage$DimensionalCarriageEntity
 *  com.simibubi.create.content.trains.entity.CarriageSounds
 *  net.minecraft.class_1937
 *  net.minecraft.class_243
 *  net.minecraft.class_310
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 */
package org.valkyrienskies.mod.mixin.mod_compat.create.client;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.simibubi.create.content.trains.entity.Carriage;
import com.simibubi.create.content.trains.entity.CarriageSounds;
import net.minecraft.class_1937;
import net.minecraft.class_243;
import net.minecraft.class_310;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.valkyrienskies.mod.common.VSGameUtilsKt;

@Mixin(value={CarriageSounds.class})
public class MixinCarriageSounds {
    @WrapOperation(method={"tick"}, at={@At(value="INVOKE", target="Lcom/simibubi/create/content/trains/entity/Carriage$DimensionalCarriageEntity;leadingAnchor()Lnet/minecraft/world/phys/Vec3;")})
    private class_243 leadingToWorldSpace(Carriage.DimensionalCarriageEntity carriage, Operation<class_243> original) {
        return VSGameUtilsKt.toWorldCoordinates((class_1937)class_310.method_1551().field_1687, (class_243)original.call(new Object[]{carriage}));
    }

    @WrapOperation(method={"tick"}, at={@At(value="INVOKE", target="Lcom/simibubi/create/content/trains/entity/Carriage$DimensionalCarriageEntity;trailingAnchor()Lnet/minecraft/world/phys/Vec3;")})
    private class_243 trailingToWorldSpace(Carriage.DimensionalCarriageEntity carriage, Operation<class_243> original) {
        return VSGameUtilsKt.toWorldCoordinates((class_1937)class_310.method_1551().field_1687, (class_243)original.call(new Object[]{carriage}));
    }
}

