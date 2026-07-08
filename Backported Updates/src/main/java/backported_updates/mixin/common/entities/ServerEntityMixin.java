/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.network.packet.Packet
 *  net.minecraft.network.packet.s2c.play.EntityS2CPacket$MoveRelative
 *  net.minecraft.network.packet.s2c.play.EntityS2CPacket$RotateAndMoveRelative
 *  net.minecraft.network.packet.s2c.play.EntityS2CPacket$Rotate
 *  net.minecraft.network.packet.s2c.play.EntitySetHeadYawS2CPacket
 *  net.minecraft.network.packet.s2c.play.EntityVelocityUpdateS2CPacket
 *  net.minecraft.network.packet.s2c.play.EntityPassengersSetS2CPacket
 *  net.minecraft.network.packet.s2c.play.EntityPositionS2CPacket
 *  net.minecraft.server.network.ServerPlayerEntity
 *  net.minecraft.server.network.EntityTrackerEntry
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.entity.TrackedPosition
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package backported_updates.mixin.common.entities;

import backported.updates.content.common.level.entities.happyghast.HappyGhast;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.Vec3d;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.EntityS2CPacket;
import net.minecraft.network.packet.s2c.play.EntitySetHeadYawS2CPacket;
import net.minecraft.network.packet.s2c.play.EntityVelocityUpdateS2CPacket;
import net.minecraft.network.packet.s2c.play.EntityPassengersSetS2CPacket;
import net.minecraft.network.packet.s2c.play.EntityPositionS2CPacket;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.network.EntityTrackerEntry;
import net.minecraft.util.math.MathHelper;
import net.minecraft.entity.TrackedPosition;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={EntityTrackerEntry.class})
public abstract class ServerEntityMixin {
    @Shadow
    private int trackingTick;
    @Shadow
    private int lastPitch;
    @Shadow
    private int lastYaw;
    @Shadow
    private int updatesWithoutVehicle;
    @Shadow
    private boolean hadVehicle;
    @Shadow
    private boolean lastOnGround;
    @Shadow
    @Final
    private Entity entity;
    @Shadow
    private int lastHeadYaw;
    @Shadow
    private Vec3d velocity;
    @Shadow
    @Final
    private int tickInterval;
    @Shadow
    @Final
    private boolean alwaysUpdateVelocity;
    @Shadow
    private List<Entity> lastPassengers;
    @Shadow
    @Final
    private TrackedPosition trackedPos;
    @Shadow
    @Final
    private Consumer<Packet<?>> receiver;

    @Shadow
    protected abstract void syncEntityData();

    @Shadow
    protected abstract void sendSyncPacket(Packet<?> var1);

    @Shadow
    private static Stream<Entity> streamChangedPassengers(List<Entity> initialPassengers, List<Entity> currentPassengers) {
        throw new AssertionError();
    }

    @Inject(method={"tick"}, at={@At(value="HEAD")}, cancellable=true)
    private void onSendChanges(CallbackInfo ci) {
        Entity class_12972 = this.entity;
        if (class_12972 instanceof HappyGhast) {
            HappyGhast ghast = (HappyGhast)class_12972;
            List passengers = this.entity.getPassengerList();
            if (!passengers.equals(this.lastPassengers)) {
                this.receiver.accept((Packet<?>)new EntityPassengersSetS2CPacket(this.entity));
                ServerEntityMixin.streamChangedPassengers(passengers, this.lastPassengers).forEach(entity -> {
                    if (entity instanceof ServerPlayerEntity) {
                        ServerPlayerEntity player = (ServerPlayerEntity)entity;
                        player.networkHandler.requestTeleport(player.getX(), player.getY(), player.getZ(), player.getYaw(), player.getPitch());
                    }
                });
                this.lastPassengers = passengers;
            }
            if (this.trackingTick % this.tickInterval == 0 || this.entity.velocityDirty || this.entity.getDataTracker().isDirty()) {
                byte yHeadRot;
                boolean shouldSendRotation;
                byte yRot = (byte)MathHelper.floor((float)(this.entity.getYaw() * 256.0f / 360.0f));
                byte xRot = (byte)MathHelper.floor((float)(this.entity.getPitch() * 256.0f / 360.0f));
                boolean bl = shouldSendRotation = Math.abs(yRot - this.lastYaw) >= 1 || Math.abs(xRot - this.lastPitch) >= 1;
                if (!this.entity.hasVehicle()) {
                    Vec3d movement;
                    double diff;
                    LivingEntity living;
                    Entity class_12973;
                    boolean deltaTooBig;
                    ++this.updatesWithoutVehicle;
                    Vec3d currentPosition = this.entity.getSyncedPos();
                    boolean positionChanged = this.trackedPos.subtract(currentPosition).lengthSquared() >= 7.62939453125E-6;
                    Packet<?> packet = null;
                    boolean pos = positionChanged || this.trackingTick % 60 == 0;
                    boolean sendPosition = false;
                    boolean sendRotation = false;
                    long x = this.trackedPos.getDeltaX(currentPosition);
                    long y = this.trackedPos.getDeltaY(currentPosition);
                    long z = this.trackedPos.getDeltaZ(currentPosition);
                    boolean bl2 = deltaTooBig = x < -32768L || x > 32767L || y < -32768L || y > 32767L || z < -32768L || z > 32767L;
                    if (ghast.getRequiresPrecisePosition() || deltaTooBig || this.updatesWithoutVehicle > 400 || this.hadVehicle || this.lastOnGround != this.entity.isOnGround()) {
                        this.lastOnGround = this.entity.isOnGround();
                        this.updatesWithoutVehicle = 0;
                        packet = new EntityPositionS2CPacket(this.entity);
                        sendPosition = true;
                        sendRotation = true;
                    } else if (!pos || !shouldSendRotation) {
                        if (pos) {
                            packet = new EntityS2CPacket.MoveRelative(this.entity.getId(), (short)x, (short)y, (short)z, this.entity.isOnGround());
                            sendPosition = true;
                        } else if (shouldSendRotation) {
                            packet = new EntityS2CPacket.Rotate(this.entity.getId(), yRot, xRot, this.entity.isOnGround());
                            sendRotation = true;
                        }
                    } else {
                        packet = new EntityS2CPacket.RotateAndMoveRelative(this.entity.getId(), (short)x, (short)y, (short)z, yRot, xRot, this.entity.isOnGround());
                        sendPosition = true;
                        sendRotation = true;
                    }
                    if ((this.alwaysUpdateVelocity || this.entity.velocityDirty || (class_12973 = this.entity) instanceof LivingEntity && (living = (LivingEntity)class_12973).isFallFlying()) && ((diff = (movement = this.entity.getVelocity()).squaredDistanceTo(this.velocity)) > 1.0E-7 || diff > 0.0 && movement.lengthSquared() == 0.0)) {
                        this.velocity = movement;
                        this.receiver.accept((Packet<?>)new EntityVelocityUpdateS2CPacket(this.entity.getId(), this.velocity));
                    }
                    if (packet != null) {
                        this.receiver.accept((Packet<?>)packet);
                    }
                    this.syncEntityData();
                    if (sendPosition) {
                        this.trackedPos.setPos(currentPosition);
                    }
                    if (sendRotation) {
                        this.lastYaw = yRot;
                        this.lastPitch = xRot;
                    }
                    this.hadVehicle = false;
                }
                if (Math.abs((yHeadRot = (byte)MathHelper.floor((float)(this.entity.getHeadYaw() * 256.0f / 360.0f))) - this.lastHeadYaw) >= 1) {
                    this.receiver.accept((Packet<?>)new EntitySetHeadYawS2CPacket(this.entity, yHeadRot));
                    this.lastHeadYaw = yHeadRot;
                }
                this.entity.velocityDirty = false;
            }
            ++this.trackingTick;
            if (this.entity.velocityModified) {
                this.entity.velocityModified = false;
                this.sendSyncPacket((Packet<?>)new EntityVelocityUpdateS2CPacket(this.entity));
            }
            ci.cancel();
        }
    }
}

