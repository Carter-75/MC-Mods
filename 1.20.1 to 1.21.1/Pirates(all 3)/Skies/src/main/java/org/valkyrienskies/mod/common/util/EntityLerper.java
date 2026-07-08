/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.class_1297
 *  net.minecraft.class_1937
 *  net.minecraft.class_3532
 */
package org.valkyrienskies.mod.common.util;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_1297;
import net.minecraft.class_1937;
import net.minecraft.class_3532;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3d;
import org.joml.Vector3dc;
import org.valkyrienskies.core.api.ships.ClientShip;
import org.valkyrienskies.core.api.ships.LoadedShip;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.util.EntityDraggingInformation;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J%\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0004\b\t\u0010\nJ%\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0004\b\u000b\u0010\nJ\u001d\u0010\u000f\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0011\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r\u00a2\u0006\u0004\b\u0011\u0010\u0010\u00a8\u0006\u0014"}, d2={"Lorg/valkyrienskies/mod/common/util/EntityLerper;", "", "Lorg/valkyrienskies/mod/common/util/EntityDraggingInformation;", "dragInfo", "Lorg/valkyrienskies/core/api/ships/Ship;", "refship", "Lnet/minecraft/class_1297;", "entity", "", "lerpStep", "(Lorg/valkyrienskies/mod/common/util/EntityDraggingInformation;Lorg/valkyrienskies/core/api/ships/Ship;Lnet/minecraft/class_1297;)V", "lerpHeadStep", "ship", "", "yaw", "yawToWorld", "(Lorg/valkyrienskies/core/api/ships/Ship;D)D", "yawToShip", "<init>", "()V", "valkyrienskies-120"})
public final class EntityLerper {
    @NotNull
    public static final EntityLerper INSTANCE = new EntityLerper();

    private EntityLerper() {
    }

    public final void lerpStep(@NotNull EntityDraggingInformation dragInfo, @NotNull Ship refship, @NotNull class_1297 entity) {
        Intrinsics.checkNotNullParameter((Object)dragInfo, (String)"dragInfo");
        Intrinsics.checkNotNullParameter((Object)refship, (String)"refship");
        Intrinsics.checkNotNullParameter((Object)entity, (String)"entity");
        if (!(refship instanceof ClientShip) || !dragInfo.isEntityBeingDraggedByAShip()) {
            return;
        }
        ClientShip ship = (ClientShip)refship;
        int n2 = dragInfo.getTicksSinceLastServerPacket();
        dragInfo.setTicksSinceLastServerPacket(n2 + 1);
        if (dragInfo.getTicksSinceLastServerPacket() > 19) {
            // empty if block
        }
        if (dragInfo.getLerpSteps() > 0) {
            if (dragInfo.getChangedShipLastTick()) {
                dragInfo.setChangedShipLastTick(false);
            }
            class_1937 class_19372 = entity.method_37908();
            Vector3dc vector3dc = dragInfo.getLerpPositionOnShip();
            Intrinsics.checkNotNull((Object)vector3dc);
            LoadedShip lerpship = VSGameUtilsKt.getLoadedShipManagingPos(class_19372, vector3dc);
            class_1937 class_19373 = entity.method_37908();
            Vector3dc vector3dc2 = dragInfo.getRelativePositionOnShip();
            Intrinsics.checkNotNull((Object)vector3dc2);
            LoadedShip posship = VSGameUtilsKt.getLoadedShipManagingPos(class_19373, vector3dc2);
            if (dragInfo.getLerpPositionOnShip() != null && lerpship != null && lerpship.getId() != ship.getId()) {
                Vector3d worldPos = lerpship.getTransform().getShipToWorld().transformPosition(new Vector3d(dragInfo.getLerpPositionOnShip()), new Vector3d());
                dragInfo.setLerpPositionOnShip(ship.getTransform().getWorldToShip().transformPosition(worldPos, new Vector3d()));
            }
            if (dragInfo.getRelativePositionOnShip() != null && posship != null && posship.getId() != ship.getId()) {
                Vector3d worldRelativePos = posship.getShipToWorld().transformPosition(new Vector3d(dragInfo.getRelativePositionOnShip()), new Vector3d());
                dragInfo.setRelativePositionOnShip(ship.getTransform().getWorldToShip().transformPosition(worldRelativePos, new Vector3d()));
            }
            Vector3dc vector3dc3 = dragInfo.getRelativePositionOnShip();
            if (vector3dc3 == null) {
                return;
            }
            double currentX = vector3dc3.x();
            Vector3dc vector3dc4 = dragInfo.getRelativePositionOnShip();
            Intrinsics.checkNotNull((Object)vector3dc4);
            double currentY = vector3dc4.y();
            Vector3dc vector3dc5 = dragInfo.getRelativePositionOnShip();
            Intrinsics.checkNotNull((Object)vector3dc5);
            double currentZ = vector3dc5.z();
            Vector3dc vector3dc6 = dragInfo.getLerpPositionOnShip();
            Intrinsics.checkNotNull((Object)vector3dc6);
            double lerpX = vector3dc6.x();
            Vector3dc vector3dc7 = dragInfo.getLerpPositionOnShip();
            Intrinsics.checkNotNull((Object)vector3dc7);
            double lerpY = vector3dc7.y();
            Vector3dc vector3dc8 = dragInfo.getLerpPositionOnShip();
            Intrinsics.checkNotNull((Object)vector3dc8);
            double lerpZ = vector3dc8.z();
            Double d2 = dragInfo.getRelativeYawOnShip();
            if (d2 == null) {
                return;
            }
            double currentYaw = d2;
            Double d3 = dragInfo.getLerpYawOnShip();
            if (d3 == null) {
                return;
            }
            double lerpYaw = d3;
            double newX = currentX + (lerpX - currentX) / (double)dragInfo.getLerpSteps();
            double newY = currentY + (lerpY - currentY) / (double)dragInfo.getLerpSteps();
            double newZ = currentZ + (lerpZ - currentZ) / (double)dragInfo.getLerpSteps();
            Vector3d newPos = VSGameUtilsKt.toWorldCoordinates(entity.method_37908(), newX, newY, newZ, new Vector3d());
            double currentYawWorld = this.yawToWorld(ship, currentYaw);
            double lerpYawWorld = this.yawToWorld(ship, lerpYaw);
            dragInfo.setRelativePositionOnShip(new Vector3d(newX, newY, newZ));
            entity.method_5814(newPos.x(), newPos.y(), newPos.z());
            double g2 = class_3532.method_15338((double)(lerpYawWorld - currentYawWorld));
            float newYaw = (float)(currentYawWorld + g2 / (double)dragInfo.getLerpSteps());
            entity.method_36456(newYaw);
            dragInfo.setRelativeYawOnShip(this.yawToShip(ship, newYaw));
            dragInfo.setLerpSteps(dragInfo.getLerpSteps() - 1);
        }
    }

    public final void lerpHeadStep(@NotNull EntityDraggingInformation dragInfo, @NotNull Ship refship, @NotNull class_1297 entity) {
        Intrinsics.checkNotNullParameter((Object)dragInfo, (String)"dragInfo");
        Intrinsics.checkNotNullParameter((Object)refship, (String)"refship");
        Intrinsics.checkNotNullParameter((Object)entity, (String)"entity");
        if (!(refship instanceof ClientShip)) {
            return;
        }
        ClientShip ship = (ClientShip)refship;
        if (dragInfo.getHeadLerpSteps() > 0) {
            Double d2 = dragInfo.getRelativeHeadYawOnShip();
            if (d2 == null) {
                return;
            }
            double currentHeadYaw = d2;
            Double d3 = dragInfo.getLerpHeadYawOnShip();
            if (d3 == null) {
                return;
            }
            double lerpHeadYaw = d3;
            double currentHeadYawWorld = this.yawToWorld(ship, currentHeadYaw);
            double lerpHeadYawWorld = this.yawToWorld(ship, lerpHeadYaw);
            double newHeadYaw = currentHeadYawWorld + class_3532.method_15338((double)(lerpHeadYawWorld - currentHeadYawWorld)) / (double)dragInfo.getHeadLerpSteps();
            float f2 = entity.method_36455();
            Double d4 = dragInfo.getLerpPitchOnShip();
            Intrinsics.checkNotNull((Object)d4);
            entity.method_36457(f2 + ((float)d4.doubleValue() - entity.method_36455()) / (float)dragInfo.getHeadLerpSteps());
            entity.method_5847((float)newHeadYaw);
            dragInfo.setRelativeHeadYawOnShip(this.yawToShip(ship, newHeadYaw));
            int n2 = dragInfo.getHeadLerpSteps();
            dragInfo.setHeadLerpSteps(n2 + -1);
        }
    }

    public final double yawToWorld(@NotNull Ship ship, double yaw) {
        Intrinsics.checkNotNullParameter((Object)ship, (String)"ship");
        Vector3dc entityYawOnly = new Vector3d(Math.sin(yaw), 0.0, Math.cos(yaw));
        Vector3d newLookIdeal = ship.getTransform().transformDirectionNoScalingFromShipToWorld(entityYawOnly, new Vector3d());
        double newYRot = Math.atan2(newLookIdeal.x(), newLookIdeal.z());
        return class_3532.method_15338((double)(newYRot * 180.0 / Math.PI));
    }

    public final double yawToShip(@NotNull Ship ship, double yaw) {
        Intrinsics.checkNotNullParameter((Object)ship, (String)"ship");
        Vector3dc entityYawOnly = new Vector3d(Math.sin(yaw * Math.PI / 180.0), 0.0, Math.cos(yaw * Math.PI / 180.0));
        Vector3d newLookIdeal = ship.getTransform().transformDirectionNoScalingFromWorldToShip(entityYawOnly, new Vector3d());
        double newYRot = Math.atan2(newLookIdeal.x(), newLookIdeal.z());
        return newYRot;
    }
}

