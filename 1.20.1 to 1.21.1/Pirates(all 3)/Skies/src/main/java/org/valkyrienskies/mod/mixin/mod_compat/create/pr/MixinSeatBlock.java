/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation
 *  com.simibubi.create.content.contraptions.actors.seat.SeatBlock
 *  com.simibubi.create.content.contraptions.actors.seat.SeatEntity
 *  net.minecraft.class_1297
 *  net.minecraft.class_1937
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_4970$class_2251
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 */
package org.valkyrienskies.mod.mixin.mod_compat.create.pr;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.simibubi.create.content.contraptions.actors.seat.SeatBlock;
import com.simibubi.create.content.contraptions.actors.seat.SeatEntity;
import net.minecraft.class_1297;
import net.minecraft.class_1937;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_4970;
import org.joml.Vector3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.util.EntityDraggingInformation;
import org.valkyrienskies.mod.common.util.IEntityDraggingInformationProvider;

@Mixin(value={SeatBlock.class})
public abstract class MixinSeatBlock
extends class_2248 {
    public MixinSeatBlock(class_4970.class_2251 properties) {
        super(properties);
    }

    @WrapOperation(method={"sitDown"}, at={@At(value="INVOKE", target="Lcom/simibubi/create/content/contraptions/actors/seat/SeatEntity;setPos(DDD)V")})
    private static void wrapSitDownSetPos(SeatEntity seatEntity, double origX, double origY, double origZ, Operation<Void> setPosOperation, class_1937 world, class_2338 pos, class_1297 entity) {
        setPosOperation.call(new Object[]{seatEntity, (double)pos.method_10263() + 0.5, (double)pos.method_10264(), (double)pos.method_10260() + 0.5});
    }

    @WrapOperation(method={"updateEntityAfterFallOn"}, at={@At(value="INVOKE", target="Lnet/minecraft/world/entity/Entity;blockPosition()Lnet/minecraft/core/BlockPos;")})
    private class_2338 wrapBlockPosInUpdateEntityAfterFallOn(class_1297 entity, Operation<class_2338> getBlockPosition) {
        Object ship;
        Long shipStandingOnId;
        EntityDraggingInformation draggingInformation = ((IEntityDraggingInformationProvider)entity).getDraggingInformation();
        if (draggingInformation.isEntityBeingDraggedByAShip() && (shipStandingOnId = draggingInformation.getLastShipStoodOn()) != null && (ship = VSGameUtilsKt.getShipObjectWorld(entity.method_37908()).getLoadedShips().getById(shipStandingOnId)) != null) {
            Vector3d posInShip = ship.getTransform().getWorldToShip().transformPosition(entity.method_23317(), entity.method_23318(), entity.method_23321(), new Vector3d());
            return class_2338.method_49637((double)posInShip.x(), (double)posInShip.y(), (double)posInShip.z());
        }
        return (class_2338)getBlockPosition.call(new Object[]{entity});
    }
}

