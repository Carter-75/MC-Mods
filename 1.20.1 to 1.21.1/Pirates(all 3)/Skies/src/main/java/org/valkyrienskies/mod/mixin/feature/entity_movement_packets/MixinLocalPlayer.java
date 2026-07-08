/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation
 *  net.minecraft.class_1297
 *  net.minecraft.class_1299
 *  net.minecraft.class_1937
 *  net.minecraft.class_2596
 *  net.minecraft.class_2828
 *  net.minecraft.class_2828$class_2829
 *  net.minecraft.class_2828$class_2830
 *  net.minecraft.class_2828$class_2831
 *  net.minecraft.class_2828$class_5911
 *  net.minecraft.class_2833
 *  net.minecraft.class_310
 *  net.minecraft.class_634
 *  net.minecraft.class_746
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 */
package org.valkyrienskies.mod.mixin.feature.entity_movement_packets;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.class_1297;
import net.minecraft.class_1299;
import net.minecraft.class_1937;
import net.minecraft.class_2596;
import net.minecraft.class_2828;
import net.minecraft.class_2833;
import net.minecraft.class_310;
import net.minecraft.class_634;
import net.minecraft.class_746;
import org.joml.Vector3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.valkyrienskies.core.api.ships.ClientShip;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.ValkyrienSkiesMod;
import org.valkyrienskies.mod.common.networking.PacketEntityShipMotion;
import org.valkyrienskies.mod.common.networking.PacketPlayerShipMotion;
import org.valkyrienskies.mod.common.util.EntityLerper;
import org.valkyrienskies.mod.common.util.IEntityDraggingInformationProvider;
import org.valkyrienskies.mod.common.util.VectorConversionsMCKt;

@Mixin(value={class_746.class})
public abstract class MixinLocalPlayer
extends class_1297
implements IEntityDraggingInformationProvider {
    @Shadow
    public abstract float method_5705(float var1);

    public MixinLocalPlayer(class_1299<?> entityType, class_1937 level) {
        super(entityType, level);
    }

    @WrapOperation(method={"sendPosition"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/multiplayer/ClientPacketListener;send(Lnet/minecraft/network/protocol/Packet;)V")})
    private void wrapSendPosition(class_634 instance, class_2596<?> arg, Operation<Void> original) {
        Object realArg = arg;
        if (this.getDraggingInformation().isEntityBeingDraggedByAShip()) {
            ClientShip ship;
            if (this.getDraggingInformation().getLastShipStoodOn() != null && (ship = (ClientShip)VSGameUtilsKt.getShipObjectWorld(class_310.method_1551().field_1687).getAllShips().getById(this.getDraggingInformation().getLastShipStoodOn())) != null) {
                Vector3d relativePosition = ship.getWorldToShip().transformPosition(VectorConversionsMCKt.toJOML(this.method_30950(1.0f)), new Vector3d());
                double relativeYaw = EntityLerper.INSTANCE.yawToShip(ship, this.method_5705(1.0f));
                PacketPlayerShipMotion packet = new PacketPlayerShipMotion(ship.getId(), relativePosition.x(), relativePosition.y(), relativePosition.z(), relativeYaw);
                ValkyrienSkiesMod.getVsCore().getSimplePacketNetworking().sendToServer(packet);
            }
            if (realArg instanceof class_2828) {
                boolean isOnGround;
                class_2828 movePacket = (class_2828)realArg;
                boolean bl = isOnGround = movePacket.method_12273() || this.getDraggingInformation().isEntityBeingDraggedByAShip();
                realArg = movePacket.method_36171() && movePacket.method_36172() ? new class_2828.class_2830(movePacket.method_12269(0.0), movePacket.method_12268(0.0), movePacket.method_12274(0.0), movePacket.method_12271(0.0f), movePacket.method_12270(0.0f), isOnGround) : (movePacket.method_36171() ? new class_2828.class_2829(movePacket.method_12269(0.0), movePacket.method_12268(0.0), movePacket.method_12274(0.0), isOnGround) : (movePacket.method_36172() ? new class_2828.class_2831(movePacket.method_12271(0.0f), movePacket.method_12270(0.0f), isOnGround) : new class_2828.class_5911(isOnGround)));
            }
        }
        original.call(new Object[]{instance, realArg});
    }

    @WrapOperation(method={"tick"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/multiplayer/ClientPacketListener;send(Lnet/minecraft/network/protocol/Packet;)V")})
    private void wrapSendVehiclePosition(class_634 instance, class_2596<?> arg, Operation<Void> original) {
        if (arg instanceof class_2833) {
            ClientShip ship;
            IEntityDraggingInformationProvider dragProvider;
            class_2833 vehiclePacket = (class_2833)arg;
            class_1297 class_12972 = this.method_5668();
            if (class_12972 instanceof IEntityDraggingInformationProvider && (dragProvider = (IEntityDraggingInformationProvider)class_12972).getDraggingInformation().isEntityBeingDraggedByAShip() && dragProvider.getDraggingInformation().getLastShipStoodOn() != null && (ship = (ClientShip)VSGameUtilsKt.getShipObjectWorld(class_310.method_1551().field_1687).getAllShips().getById(dragProvider.getDraggingInformation().getLastShipStoodOn())) != null) {
                Vector3d relativePosition = ship.getWorldToShip().transformPosition(VectorConversionsMCKt.toJOML(this.method_5668().method_30950(1.0f)), new Vector3d());
                double relativeYaw = EntityLerper.INSTANCE.yawToShip(ship, this.method_5668().method_36454());
                PacketEntityShipMotion packet = new PacketEntityShipMotion(this.method_5668().method_5628(), ship.getId(), relativePosition.x(), relativePosition.y(), relativePosition.z(), 0.0, 0.0, 0.0, relativeYaw, 0.0);
                ValkyrienSkiesMod.getVsCore().getSimplePacketNetworking().sendToServer(packet);
            }
        }
        original.call(new Object[]{instance, arg});
    }
}

