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

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u00a2\u0006\u0004\b$\u0010%J\u0010\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005H\u00c6\u0003\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005H\u00c6\u0003\u00a2\u0006\u0004\b\b\u0010\u0007J\u0010\u0010\t\u001a\u00020\u0005H\u00c6\u0003\u00a2\u0006\u0004\b\t\u0010\u0007J\u0010\u0010\n\u001a\u00020\u0005H\u00c6\u0003\u00a2\u0006\u0004\b\n\u0010\u0007JB\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u0005H\u00c6\u0001\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u00d6\u0003\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017H\u00d6\u0001\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001b\u001a\u00020\u001aH\u00d6\u0001\u00a2\u0006\u0004\b\u001b\u0010\u001cR\u0017\u0010\u000b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u001d\u001a\u0004\b\u001e\u0010\u0004R\u0017\u0010\f\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u001f\u001a\u0004\b \u0010\u0007R\u0017\u0010\r\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u001f\u001a\u0004\b!\u0010\u0007R\u0017\u0010\u000e\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u001f\u001a\u0004\b\"\u0010\u0007R\u0017\u0010\u000f\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u001f\u001a\u0004\b#\u0010\u0007\u00a8\u0006&"}, d2={"Lorg/valkyrienskies/mod/common/networking/PacketPlayerShipMotion;", "Lorg/valkyrienskies/core/impl/networking/simple/SimplePacket;", "", "component1", "()J", "", "component2", "()D", "component3", "component4", "component5", "shipID", "x", "y", "z", "yRot", "copy", "(JDDDD)Lorg/valkyrienskies/mod/common/networking/PacketPlayerShipMotion;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "J", "getShipID", "D", "getX", "getY", "getZ", "getYRot", "<init>", "(JDDDD)V", "valkyrienskies-120"})
public final class PacketPlayerShipMotion
implements SimplePacket {
    private final long shipID;
    private final double x;
    private final double y;
    private final double z;
    private final double yRot;

    public PacketPlayerShipMotion(long shipID, double x, double y, double z, double yRot) {
        this.shipID = shipID;
        this.x = x;
        this.y = y;
        this.z = z;
        this.yRot = yRot;
    }

    public final long getShipID() {
        return this.shipID;
    }

    public final double getX() {
        return this.x;
    }

    public final double getY() {
        return this.y;
    }

    public final double getZ() {
        return this.z;
    }

    public final double getYRot() {
        return this.yRot;
    }

    public final long component1() {
        return this.shipID;
    }

    public final double component2() {
        return this.x;
    }

    public final double component3() {
        return this.y;
    }

    public final double component4() {
        return this.z;
    }

    public final double component5() {
        return this.yRot;
    }

    @NotNull
    public final PacketPlayerShipMotion copy(long shipID, double x, double y, double z, double yRot) {
        return new PacketPlayerShipMotion(shipID, x, y, z, yRot);
    }

    public static /* synthetic */ PacketPlayerShipMotion copy$default(PacketPlayerShipMotion packetPlayerShipMotion, long l2, double d2, double d3, double d4, double d5, int n2, Object object) {
        if ((n2 & 1) != 0) {
            l2 = packetPlayerShipMotion.shipID;
        }
        if ((n2 & 2) != 0) {
            d2 = packetPlayerShipMotion.x;
        }
        if ((n2 & 4) != 0) {
            d3 = packetPlayerShipMotion.y;
        }
        if ((n2 & 8) != 0) {
            d4 = packetPlayerShipMotion.z;
        }
        if ((n2 & 0x10) != 0) {
            d5 = packetPlayerShipMotion.yRot;
        }
        return packetPlayerShipMotion.copy(l2, d2, d3, d4, d5);
    }

    @NotNull
    public String toString() {
        return "PacketPlayerShipMotion(shipID=" + this.shipID + ", x=" + this.x + ", y=" + this.y + ", z=" + this.z + ", yRot=" + this.yRot + ")";
    }

    public int hashCode() {
        int result2 = Long.hashCode(this.shipID);
        result2 = result2 * 31 + Double.hashCode(this.x);
        result2 = result2 * 31 + Double.hashCode(this.y);
        result2 = result2 * 31 + Double.hashCode(this.z);
        result2 = result2 * 31 + Double.hashCode(this.yRot);
        return result2;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PacketPlayerShipMotion)) {
            return false;
        }
        PacketPlayerShipMotion packetPlayerShipMotion = (PacketPlayerShipMotion)other;
        if (this.shipID != packetPlayerShipMotion.shipID) {
            return false;
        }
        if (Double.compare(this.x, packetPlayerShipMotion.x) != 0) {
            return false;
        }
        if (Double.compare(this.y, packetPlayerShipMotion.y) != 0) {
            return false;
        }
        if (Double.compare(this.z, packetPlayerShipMotion.z) != 0) {
            return false;
        }
        return Double.compare(this.yRot, packetPlayerShipMotion.yRot) == 0;
    }
}

