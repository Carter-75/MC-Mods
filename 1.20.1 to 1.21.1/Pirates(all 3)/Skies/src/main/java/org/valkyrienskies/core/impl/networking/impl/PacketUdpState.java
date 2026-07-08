/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmName
 */
package org.valkyrienskies.core.impl.networking.impl;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import org.valkyrienskies.core.impl.networking.simple.SimplePacket;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\b\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005H\u00c6\u0003\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bH\u00c6\u0003\u00a2\u0006\u0004\b\t\u0010\nJ.\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\bH\u00c6\u0001\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u00d6\u0003\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002H\u00d6\u0001\u00a2\u0006\u0004\b\u0014\u0010\u0004J\u0010\u0010\u0016\u001a\u00020\u0015H\u00d6\u0001\u00a2\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\r\u001a\u00020\b8\u0007\u00a2\u0006\f\n\u0004\b\r\u0010\u0018\u001a\u0004\b\u0019\u0010\nR\u0017\u0010\u000b\u001a\u00020\u00028\u0007\u00a2\u0006\f\n\u0004\b\u000b\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004R\u0017\u0010\f\u001a\u00020\u00058\u0007\u00a2\u0006\f\n\u0004\b\f\u0010\u001c\u001a\u0004\b\u001d\u0010\u0007"}, d2={"Lorg/valkyrienskies/core/impl/networking/impl/PacketUdpState;", "Lorg/valkyrienskies/core/impl/networking/simple/SimplePacket;", "", "component1", "()I", "", "component2", "()Z", "", "component3", "()J", "port", "state", "id", "copy", "(IZJ)Lorg/valkyrienskies/core/impl/networking/impl/PacketUdpState;", "", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "J", "getId", "I", "getPort", "Z", "getState", "<init>", "(IZJ)V"})
public final class PacketUdpState
implements SimplePacket {
    private final int port;
    private final boolean state;
    private final long id;

    /*
     * WARNING - void declaration
     */
    public PacketUdpState(int port, boolean state, long id) {
        void var3_3;
        void var2_2;
        void var1_1;
        this.port = var1_1;
        this.state = var2_2;
        this.id = var3_3;
    }

    @JvmName(name="getPort")
    public final int getPort() {
        return this.port;
    }

    @JvmName(name="getState")
    public final boolean getState() {
        return this.state;
    }

    @JvmName(name="getId")
    public final long getId() {
        return this.id;
    }

    public final int component1() {
        return this.port;
    }

    public final boolean component2() {
        return this.state;
    }

    public final long component3() {
        return this.id;
    }

    /*
     * WARNING - void declaration
     */
    public final PacketUdpState copy(int port, boolean state, long id) {
        void var3_3;
        void var2_2;
        void var1_1;
        return new PacketUdpState((int)var1_1, (boolean)var2_2, (long)var3_3);
    }

    public static /* synthetic */ PacketUdpState copy$default(PacketUdpState packetUdpState, int n2, boolean bl, long l2, int n3, Object object) {
        if ((n3 & 1) != 0) {
            n2 = packetUdpState.port;
        }
        if ((n3 & 2) != 0) {
            bl = packetUdpState.state;
        }
        if ((n3 & 4) != 0) {
            l2 = packetUdpState.id;
        }
        return packetUdpState.copy(n2, bl, l2);
    }

    public final String toString() {
        return "PacketUdpState(port=" + this.port + ", state=" + this.state + ", id=" + this.id + ")";
    }

    public final int hashCode() {
        int n2 = Integer.hashCode(this.port);
        n2 = n2 * 31 + Boolean.hashCode(this.state);
        n2 = n2 * 31 + Long.hashCode(this.id);
        return n2;
    }

    public final boolean equals(Object other) {
        PacketUdpState packetUdpState;
        if (this == other) {
            return true;
        }
        if (!(other instanceof PacketUdpState)) {
            return false;
        }
        packetUdpState = packetUdpState;
        if (this.port != packetUdpState.port) {
            return false;
        }
        if (this.state != packetUdpState.state) {
            return false;
        }
        return this.id == packetUdpState.id;
    }
}

