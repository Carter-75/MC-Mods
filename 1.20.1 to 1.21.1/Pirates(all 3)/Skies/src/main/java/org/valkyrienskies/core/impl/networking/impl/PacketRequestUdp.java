/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.networking.impl;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.valkyrienskies.core.impl.networking.simple.SimplePacket;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005H\u00c6\u0003\u00a2\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005H\u00c6\u0001\u00a2\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u00d6\u0003\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002H\u00d6\u0001\u00a2\u0006\u0004\b\u0011\u0010\u0004J\u0010\u0010\u0013\u001a\u00020\u0012H\u00d6\u0001\u00a2\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\t\u001a\u00020\u00058\u0007\u00a2\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0007R\u0017\u0010\b\u001a\u00020\u00028\u0007\u00a2\u0006\f\n\u0004\b\b\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004"}, d2={"Lorg/valkyrienskies/core/impl/networking/impl/PacketRequestUdp;", "Lorg/valkyrienskies/core/impl/networking/simple/SimplePacket;", "", "component1", "()I", "", "component2", "()[B", "udpV", "secretKeyBytes", "copy", "(I[B)Lorg/valkyrienskies/core/impl/networking/impl/PacketRequestUdp;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "[B", "getSecretKeyBytes", "I", "getUdpV", "<init>", "(I[B)V"})
public final class PacketRequestUdp
implements SimplePacket {
    private final int udpV;
    private final byte[] secretKeyBytes;

    /*
     * WARNING - void declaration
     */
    public PacketRequestUdp(int udpV, byte[] secretKeyBytes) {
        void var2_2;
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)secretKeyBytes, (String)"");
        this.udpV = var1_1;
        this.secretKeyBytes = var2_2;
    }

    @JvmName(name="getUdpV")
    public final int getUdpV() {
        return this.udpV;
    }

    @JvmName(name="getSecretKeyBytes")
    public final byte[] getSecretKeyBytes() {
        return this.secretKeyBytes;
    }

    public final int component1() {
        return this.udpV;
    }

    public final byte[] component2() {
        return this.secretKeyBytes;
    }

    /*
     * WARNING - void declaration
     */
    public final PacketRequestUdp copy(int udpV, byte[] secretKeyBytes) {
        void var2_2;
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)secretKeyBytes, (String)"");
        return new PacketRequestUdp((int)var1_1, (byte[])var2_2);
    }

    public static /* synthetic */ PacketRequestUdp copy$default(PacketRequestUdp packetRequestUdp, int n2, byte[] byArray, int n3, Object object) {
        if ((n3 & 1) != 0) {
            n2 = packetRequestUdp.udpV;
        }
        if ((n3 & 2) != 0) {
            byArray = packetRequestUdp.secretKeyBytes;
        }
        return packetRequestUdp.copy(n2, byArray);
    }

    public final String toString() {
        return "PacketRequestUdp(udpV=" + this.udpV + ", secretKeyBytes=" + Arrays.toString(this.secretKeyBytes) + ")";
    }

    public final int hashCode() {
        int n2 = Integer.hashCode(this.udpV);
        n2 = n2 * 31 + Arrays.hashCode(this.secretKeyBytes);
        return n2;
    }

    public final boolean equals(Object other) {
        PacketRequestUdp packetRequestUdp;
        if (this == other) {
            return true;
        }
        if (!(other instanceof PacketRequestUdp)) {
            return false;
        }
        packetRequestUdp = packetRequestUdp;
        if (this.udpV != packetRequestUdp.udpV) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.secretKeyBytes, (Object)packetRequestUdp.secretKeyBytes);
    }
}

