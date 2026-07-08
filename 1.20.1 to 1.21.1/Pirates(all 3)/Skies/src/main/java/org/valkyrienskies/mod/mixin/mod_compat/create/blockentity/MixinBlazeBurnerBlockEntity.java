/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation
 *  com.simibubi.create.content.processing.burner.BlazeBurnerBlockEntity
 *  com.simibubi.create.foundation.blockEntity.SmartBlockEntity
 *  net.minecraft.class_2338
 *  net.minecraft.class_2591
 *  net.minecraft.class_2680
 *  net.minecraft.class_746
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 */
package org.valkyrienskies.mod.mixin.mod_compat.create.blockentity;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.simibubi.create.content.processing.burner.BlazeBurnerBlockEntity;
import com.simibubi.create.foundation.blockEntity.SmartBlockEntity;
import net.minecraft.class_2338;
import net.minecraft.class_2591;
import net.minecraft.class_2680;
import net.minecraft.class_746;
import org.joml.Vector3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.mod.common.VSGameUtilsKt;

@Mixin(value={BlazeBurnerBlockEntity.class})
public abstract class MixinBlazeBurnerBlockEntity
extends SmartBlockEntity {
    @WrapOperation(method={"tickAnimation"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/player/LocalPlayer;getX()D")})
    private double getPlayerX(class_746 player, Operation<Double> original) {
        Ship ship = VSGameUtilsKt.getShipManagingPos(this.field_11863, this.field_11867);
        if (ship != null) {
            return ship.getTransform().getWorldToShip().transformPosition((double)player.method_23317(), (double)player.method_23318(), (double)player.method_23321(), (Vector3d)new Vector3d()).x;
        }
        return (Double)original.call(new Object[]{player});
    }

    @WrapOperation(method={"tickAnimation"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/player/LocalPlayer;getZ()D")})
    private double getPlayerZ(class_746 player, Operation<Double> original) {
        Ship ship = VSGameUtilsKt.getShipManagingPos(this.field_11863, this.field_11867);
        if (ship != null) {
            return ship.getTransform().getWorldToShip().transformPosition((double)player.method_23317(), (double)player.method_23318(), (double)player.method_23321(), (Vector3d)new Vector3d()).z;
        }
        return (Double)original.call(new Object[]{player});
    }

    private MixinBlazeBurnerBlockEntity(class_2591<?> type, class_2338 pos, class_2680 state) {
        super(type, pos, state);
    }
}

