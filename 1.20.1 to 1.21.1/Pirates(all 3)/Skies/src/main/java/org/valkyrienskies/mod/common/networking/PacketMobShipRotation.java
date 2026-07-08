/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 */
package org.valkyrienskies.mod.common.networking;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.valkyrienskies.core.impl.networking.simple.SimplePacket;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\b\u00a2\u0006\u0004\b\"\u0010#J\u0010\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005H\u00c6\u0003\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bH\u00c6\u0003\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\bH\u00c6\u0003\u00a2\u0006\u0004\b\u000b\u0010\nJ8\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\bH\u00c6\u0001\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u00d6\u0003\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0002H\u00d6\u0001\u00a2\u0006\u0004\b\u0017\u0010\u0004J\u0010\u0010\u0019\u001a\u00020\u0018H\u00d6\u0001\u00a2\u0006\u0004\b\u0019\u0010\u001aR\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u001b\u001a\u0004\b\u001c\u0010\u0004R\u0017\u0010\r\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u001d\u001a\u0004\b\u001e\u0010\u0007R\u0017\u0010\u000e\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u001f\u001a\u0004\b \u0010\nR\u0017\u0010\u000f\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u001f\u001a\u0004\b!\u0010\n\u00a8\u0006$"}, d2={"Lorg/valkyrienskies/mod/common/networking/PacketMobShipRotation;", "Lorg/valkyrienskies/core/impl/networking/simple/SimplePacket;", "", "component1", "()I", "", "component2", "()J", "", "component3", "()D", "component4", "entityID", "shipID", "yaw", "pitch", "copy", "(IJDD)Lorg/valkyrienskies/mod/common/networking/PacketMobShipRotation;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "I", "getEntityID", "J", "getShipID", "D", "getYaw", "getPitch", "<init>", "(IJDD)V", "valkyrienskies-120"})
public final class PacketMobShipRotation
implements SimplePacket {
    private final int entityID;
    private final long shipID;
    private final double yaw;
    private final double pitch;

    public PacketMobShipRotation(int entityID, long shipID, double yaw, double pitch) {
        this.entityID = entityID;
        this.shipID = shipID;
        this.yaw = yaw;
        this.pitch = pitch;
    }

    public final int getEntityID() {
        return this.entityID;
    }

    public final long getShipID() {
        return this.shipID;
    }

    public final double getYaw() {
        return this.yaw;
    }

    public final double getPitch() {
        return this.pitch;
    }

    public final int component1() {
        return this.entityID;
    }

    public final long component2() {
        return this.shipID;
    }

    public final double component3() {
        return this.yaw;
    }

    public final double component4() {
        return this.pitch;
    }

    @NotNull
    public final PacketMobShipRotation copy(int entityID, long shipID, double yaw, double pitch) {
        return new PacketMobShipRotation(entityID, shipID, yaw, pitch);
    }

    public static /* synthetic */ PacketMobShipRotation copy$default(PacketMobShipRotation packetMobShipRotation, int n2, long l2, double d2, double d3, int n3, Object object) {
        if ((n3 & 1) != 0) {
            n2 = packetMobShipRotation.entityID;
        }
        if ((n3 & 2) != 0) {
            l2 = packetMobShipRotation.shipID;
        }
        if ((n3 & 4) != 0) {
            d2 = packetMobShipRotation.yaw;
        }
        if ((n3 & 8) != 0) {
            d3 = packetMobShipRotation.pitch;
        }
        return packetMobShipRotation.copy(n2, l2, d2, d3);
    }

    @NotNull
    public String toString() {
        return "PacketMobShipRotation(entityID=" + this.entityID + ", shipID=" + this.shipID + ", yaw=" + this.yaw + ", pitch=" + this.pitch + ")";
    }

    public int hashCode() {
        int result2 = Integer.hashCode(this.entityID);
        result2 = result2 * 31 + Long.hashCode(this.shipID);
        result2 = result2 * 31 + Double.hashCode(this.yaw);
        result2 = result2 * 31 + Double.hashCode(this.pitch);
        return result2;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PacketMobShipRotation)) {
            return false;
        }
        PacketMobShipRotation packetMobShipRotation = (PacketMobShipRotation)other;
        if (this.entityID != packetMobShipRotation.entityID) {
            return false;
        }
        if (this.shipID != packetMobShipRotation.shipID) {
            return false;
        }
        if (Double.compare(this.yaw, packetMobShipRotation.yaw) != 0) {
            return false;
        }
        return Double.compare(this.pitch, packetMobShipRotation.pitch) == 0;
    }
}

