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

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0015\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0005\u0012\u0006\u0010\u0014\u001a\u00020\b\u0012\u0006\u0010\u0015\u001a\u00020\b\u0012\u0006\u0010\u0016\u001a\u00020\b\u0012\u0006\u0010\u0017\u001a\u00020\b\u0012\u0006\u0010\u0018\u001a\u00020\b\u0012\u0006\u0010\u0019\u001a\u00020\b\u0012\u0006\u0010\u001a\u001a\u00020\b\u0012\u0006\u0010\u001b\u001a\u00020\b\u00a2\u0006\u0004\b4\u00105J\u0010\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005H\u00c6\u0003\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bH\u00c6\u0003\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\bH\u00c6\u0003\u00a2\u0006\u0004\b\u000b\u0010\nJ\u0010\u0010\f\u001a\u00020\bH\u00c6\u0003\u00a2\u0006\u0004\b\f\u0010\nJ\u0010\u0010\r\u001a\u00020\bH\u00c6\u0003\u00a2\u0006\u0004\b\r\u0010\nJ\u0010\u0010\u000e\u001a\u00020\bH\u00c6\u0003\u00a2\u0006\u0004\b\u000e\u0010\nJ\u0010\u0010\u000f\u001a\u00020\bH\u00c6\u0003\u00a2\u0006\u0004\b\u000f\u0010\nJ\u0010\u0010\u0010\u001a\u00020\bH\u00c6\u0003\u00a2\u0006\u0004\b\u0010\u0010\nJ\u0010\u0010\u0011\u001a\u00020\bH\u00c6\u0003\u00a2\u0006\u0004\b\u0011\u0010\nJt\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\b2\b\b\u0002\u0010\u0015\u001a\u00020\b2\b\b\u0002\u0010\u0016\u001a\u00020\b2\b\b\u0002\u0010\u0017\u001a\u00020\b2\b\b\u0002\u0010\u0018\u001a\u00020\b2\b\b\u0002\u0010\u0019\u001a\u00020\b2\b\b\u0002\u0010\u001a\u001a\u00020\b2\b\b\u0002\u0010\u001b\u001a\u00020\bH\u00c6\u0001\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u001a\u0010!\u001a\u00020 2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u00d6\u0003\u00a2\u0006\u0004\b!\u0010\"J\u0010\u0010#\u001a\u00020\u0002H\u00d6\u0001\u00a2\u0006\u0004\b#\u0010\u0004J\u0010\u0010%\u001a\u00020$H\u00d6\u0001\u00a2\u0006\u0004\b%\u0010&R\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010'\u001a\u0004\b(\u0010\u0004R\u0017\u0010\u0013\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010)\u001a\u0004\b*\u0010\u0007R\u0017\u0010\u0014\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010+\u001a\u0004\b,\u0010\nR\u0017\u0010\u0015\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010+\u001a\u0004\b-\u0010\nR\u0017\u0010\u0016\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010+\u001a\u0004\b.\u0010\nR\u0017\u0010\u0017\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010+\u001a\u0004\b/\u0010\nR\u0017\u0010\u0018\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010+\u001a\u0004\b0\u0010\nR\u0017\u0010\u0019\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010+\u001a\u0004\b1\u0010\nR\u0017\u0010\u001a\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010+\u001a\u0004\b2\u0010\nR\u0017\u0010\u001b\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010+\u001a\u0004\b3\u0010\n\u00a8\u00066"}, d2={"Lorg/valkyrienskies/mod/common/networking/PacketEntityShipMotion;", "Lorg/valkyrienskies/core/impl/networking/simple/SimplePacket;", "", "component1", "()I", "", "component2", "()J", "", "component3", "()D", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "entityID", "shipID", "x", "y", "z", "xVel", "yVel", "zVel", "yRot", "xRot", "copy", "(IJDDDDDDDD)Lorg/valkyrienskies/mod/common/networking/PacketEntityShipMotion;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "I", "getEntityID", "J", "getShipID", "D", "getX", "getY", "getZ", "getXVel", "getYVel", "getZVel", "getYRot", "getXRot", "<init>", "(IJDDDDDDDD)V", "valkyrienskies-120"})
public final class PacketEntityShipMotion
implements SimplePacket {
    private final int entityID;
    private final long shipID;
    private final double x;
    private final double y;
    private final double z;
    private final double xVel;
    private final double yVel;
    private final double zVel;
    private final double yRot;
    private final double xRot;

    public PacketEntityShipMotion(int entityID, long shipID, double x, double y, double z, double xVel, double yVel, double zVel, double yRot, double xRot) {
        this.entityID = entityID;
        this.shipID = shipID;
        this.x = x;
        this.y = y;
        this.z = z;
        this.xVel = xVel;
        this.yVel = yVel;
        this.zVel = zVel;
        this.yRot = yRot;
        this.xRot = xRot;
    }

    public final int getEntityID() {
        return this.entityID;
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

    public final double getXVel() {
        return this.xVel;
    }

    public final double getYVel() {
        return this.yVel;
    }

    public final double getZVel() {
        return this.zVel;
    }

    public final double getYRot() {
        return this.yRot;
    }

    public final double getXRot() {
        return this.xRot;
    }

    public final int component1() {
        return this.entityID;
    }

    public final long component2() {
        return this.shipID;
    }

    public final double component3() {
        return this.x;
    }

    public final double component4() {
        return this.y;
    }

    public final double component5() {
        return this.z;
    }

    public final double component6() {
        return this.xVel;
    }

    public final double component7() {
        return this.yVel;
    }

    public final double component8() {
        return this.zVel;
    }

    public final double component9() {
        return this.yRot;
    }

    public final double component10() {
        return this.xRot;
    }

    @NotNull
    public final PacketEntityShipMotion copy(int entityID, long shipID, double x, double y, double z, double xVel, double yVel, double zVel, double yRot, double xRot) {
        return new PacketEntityShipMotion(entityID, shipID, x, y, z, xVel, yVel, zVel, yRot, xRot);
    }

    public static /* synthetic */ PacketEntityShipMotion copy$default(PacketEntityShipMotion packetEntityShipMotion, int n2, long l2, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, int n3, Object object) {
        if ((n3 & 1) != 0) {
            n2 = packetEntityShipMotion.entityID;
        }
        if ((n3 & 2) != 0) {
            l2 = packetEntityShipMotion.shipID;
        }
        if ((n3 & 4) != 0) {
            d2 = packetEntityShipMotion.x;
        }
        if ((n3 & 8) != 0) {
            d3 = packetEntityShipMotion.y;
        }
        if ((n3 & 0x10) != 0) {
            d4 = packetEntityShipMotion.z;
        }
        if ((n3 & 0x20) != 0) {
            d5 = packetEntityShipMotion.xVel;
        }
        if ((n3 & 0x40) != 0) {
            d6 = packetEntityShipMotion.yVel;
        }
        if ((n3 & 0x80) != 0) {
            d7 = packetEntityShipMotion.zVel;
        }
        if ((n3 & 0x100) != 0) {
            d8 = packetEntityShipMotion.yRot;
        }
        if ((n3 & 0x200) != 0) {
            d9 = packetEntityShipMotion.xRot;
        }
        return packetEntityShipMotion.copy(n2, l2, d2, d3, d4, d5, d6, d7, d8, d9);
    }

    @NotNull
    public String toString() {
        return "PacketEntityShipMotion(entityID=" + this.entityID + ", shipID=" + this.shipID + ", x=" + this.x + ", y=" + this.y + ", z=" + this.z + ", xVel=" + this.xVel + ", yVel=" + this.yVel + ", zVel=" + this.zVel + ", yRot=" + this.yRot + ", xRot=" + this.xRot + ")";
    }

    public int hashCode() {
        int result2 = Integer.hashCode(this.entityID);
        result2 = result2 * 31 + Long.hashCode(this.shipID);
        result2 = result2 * 31 + Double.hashCode(this.x);
        result2 = result2 * 31 + Double.hashCode(this.y);
        result2 = result2 * 31 + Double.hashCode(this.z);
        result2 = result2 * 31 + Double.hashCode(this.xVel);
        result2 = result2 * 31 + Double.hashCode(this.yVel);
        result2 = result2 * 31 + Double.hashCode(this.zVel);
        result2 = result2 * 31 + Double.hashCode(this.yRot);
        result2 = result2 * 31 + Double.hashCode(this.xRot);
        return result2;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PacketEntityShipMotion)) {
            return false;
        }
        PacketEntityShipMotion packetEntityShipMotion = (PacketEntityShipMotion)other;
        if (this.entityID != packetEntityShipMotion.entityID) {
            return false;
        }
        if (this.shipID != packetEntityShipMotion.shipID) {
            return false;
        }
        if (Double.compare(this.x, packetEntityShipMotion.x) != 0) {
            return false;
        }
        if (Double.compare(this.y, packetEntityShipMotion.y) != 0) {
            return false;
        }
        if (Double.compare(this.z, packetEntityShipMotion.z) != 0) {
            return false;
        }
        if (Double.compare(this.xVel, packetEntityShipMotion.xVel) != 0) {
            return false;
        }
        if (Double.compare(this.yVel, packetEntityShipMotion.yVel) != 0) {
            return false;
        }
        if (Double.compare(this.zVel, packetEntityShipMotion.zVel) != 0) {
            return false;
        }
        if (Double.compare(this.yRot, packetEntityShipMotion.yRot) != 0) {
            return false;
        }
        return Double.compare(this.xRot, packetEntityShipMotion.xRot) == 0;
    }
}

