/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation
 *  com.simibubi.create.content.kinetics.chainConveyor.ChainConveyorBlockEntity
 *  com.simibubi.create.content.kinetics.chainConveyor.ChainConveyorRenderer
 *  net.minecraft.class_2374
 *  net.minecraft.class_243
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 */
package org.valkyrienskies.mod.mixin.mod_compat.create.client;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.simibubi.create.content.kinetics.chainConveyor.ChainConveyorBlockEntity;
import com.simibubi.create.content.kinetics.chainConveyor.ChainConveyorRenderer;
import net.minecraft.class_2374;
import net.minecraft.class_243;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.valkyrienskies.core.api.ships.ClientShip;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.util.VectorConversionsMCKt;

@Mixin(value={ChainConveyorRenderer.class})
public abstract class MixinChainConveyorRenderer {
    @WrapOperation(method={"renderChains"}, at={@At(value="INVOKE", target="Lnet/minecraft/world/phys/Vec3;closerThan(Lnet/minecraft/core/Position;D)Z")})
    private boolean wrapCloserThan(class_243 instance, class_2374 position, double d2, Operation<Boolean> original, @NotNull ChainConveyorBlockEntity be) {
        Ship ship = VSGameUtilsKt.getShipManagingPos(be.method_10997(), be.method_11016());
        if (ship instanceof ClientShip) {
            ClientShip ship2 = (ClientShip)ship;
            Vector3d worldPos = ship2.getShipToWorld().transformPosition(position.method_10216(), position.method_10214(), position.method_10215(), new Vector3d());
            return (Boolean)original.call(new Object[]{instance, VectorConversionsMCKt.toMinecraft(worldPos), d2});
        }
        return (Boolean)original.call(new Object[]{instance, position, d2});
    }
}

