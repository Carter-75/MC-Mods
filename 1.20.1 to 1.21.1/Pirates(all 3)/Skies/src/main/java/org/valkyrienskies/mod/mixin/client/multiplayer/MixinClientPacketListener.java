/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation
 *  net.minecraft.class_1297
 *  net.minecraft.class_1937
 *  net.minecraft.class_2604
 *  net.minecraft.class_2678
 *  net.minecraft.class_310
 *  net.minecraft.class_634
 *  net.minecraft.class_638
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.At$Shift
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package org.valkyrienskies.mod.mixin.client.multiplayer;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.class_1297;
import net.minecraft.class_1937;
import net.minecraft.class_2604;
import net.minecraft.class_2678;
import net.minecraft.class_310;
import net.minecraft.class_634;
import net.minecraft.class_638;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.valkyrienskies.core.api.ships.ClientShip;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.mod.common.IShipObjectWorldClientCreator;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.ValkyrienSkiesMod;
import org.valkyrienskies.mod.common.entity.handling.WorldEntityHandler;

@Mixin(value={class_634.class})
public class MixinClientPacketListener {
    @Shadow
    private class_638 field_3699;

    @Inject(at={@At(value="INVOKE", target="Lnet/minecraft/network/protocol/PacketUtils;ensureRunningOnSameThread(Lnet/minecraft/network/protocol/Packet;Lnet/minecraft/network/PacketListener;Lnet/minecraft/util/thread/BlockableEventLoop;)V", shift=At.Shift.AFTER)}, method={"handleLogin"})
    private void beforeHandleLogin(class_2678 packet, CallbackInfo ci) {
        ((IShipObjectWorldClientCreator)class_310.method_1551()).createShipObjectWorldClient();
    }

    @Inject(method={"handleAddEntity"}, at={@At(value="INVOKE", shift=At.Shift.AFTER, target="Lnet/minecraft/network/protocol/PacketUtils;ensureRunningOnSameThread(Lnet/minecraft/network/protocol/Packet;Lnet/minecraft/network/PacketListener;Lnet/minecraft/util/thread/BlockableEventLoop;)V")}, cancellable=true)
    private void handleShipMountingEntity(class_2604 packet, CallbackInfo ci) {
        if (packet.method_11169().equals(ValkyrienSkiesMod.SHIP_MOUNTING_ENTITY_TYPE)) {
            ci.cancel();
            double d2 = packet.method_11175();
            double e2 = packet.method_11174();
            double f2 = packet.method_11176();
            class_1297 entity = ValkyrienSkiesMod.SHIP_MOUNTING_ENTITY_TYPE.method_5883((class_1937)this.field_3699);
            int i2 = packet.method_11167();
            entity.method_43391(d2, e2, f2);
            entity.method_24203(d2, e2, f2);
            entity.method_36457(packet.method_11171() * 360.0f / 256.0f);
            entity.method_36456(packet.method_11168() * 360.0f / 256.0f);
            entity.method_5838(i2);
            entity.method_5826(packet.method_11164());
            this.field_3699.method_2942(i2, entity);
        }
    }

    @WrapOperation(method={"handleTakeItemEntity"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/multiplayer/ClientLevel;getEntity(I)Lnet/minecraft/world/entity/Entity;")})
    private class_1297 setPositionBackToWorld(class_638 level, int i2, Operation<class_1297> getEntity) {
        class_1297 entity = (class_1297)getEntity.call(new Object[]{level, i2});
        Ship ship = VSGameUtilsKt.getShipManaging(entity);
        if (ship instanceof ClientShip) {
            ClientShip ship2 = (ClientShip)ship;
            WorldEntityHandler.INSTANCE.moveEntityFromShipyardToWorld(entity, ship2);
        }
        return entity;
    }

    @WrapOperation(method={"handleTeleportEntity"}, at={@At(value="INVOKE", target="Lnet/minecraft/world/entity/Entity;lerpTo(DDDFFIZ)V")})
    private void teleportingWithNoStep(class_1297 instance, double x, double y, double z, float yRot, float xRot, int lerpSteps, boolean teleport, Operation<Void> lerpTo) {
        if (VSGameUtilsKt.getLoadedShipManagingPos(instance.method_37908(), instance.method_23317(), instance.method_23318(), instance.method_23321()) != null) {
            instance.method_5814(x, y, z);
            lerpTo.call(new Object[]{instance, x, y, z, Float.valueOf(yRot), Float.valueOf(xRot), 1, teleport});
        } else {
            lerpTo.call(new Object[]{instance, x, y, z, Float.valueOf(yRot), Float.valueOf(xRot), lerpSteps, teleport});
        }
    }
}

