/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.networking.impl;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.valkyrienskies.core.impl.networking.simple.SimplePacket;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0010\u0010\u0007\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u0005\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0006J$\u0010\b\u001a\u00020\u00002\u0012\b\u0002\u0010\u0007\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0002H\u00c6\u0001\u00a2\u0006\u0004\b\b\u0010\tJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u00d6\u0003\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fH\u00d6\u0001\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012H\u00d6\u0001\u00a2\u0006\u0004\b\u0013\u0010\u0014R!\u0010\u0007\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u00028\u0007\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0015\u001a\u0004\b\u0016\u0010\u0006"}, d2={"Lorg/valkyrienskies/core/impl/networking/impl/PacketShipRemove;", "Lorg/valkyrienskies/core/impl/networking/simple/SimplePacket;", "", "", "Lorg/valkyrienskies/core/api/ships/properties/ShipId;", "component1", "()Ljava/util/List;", "toRemove", "copy", "(Ljava/util/List;)Lorg/valkyrienskies/core/impl/networking/impl/PacketShipRemove;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Ljava/util/List;", "getToRemove", "<init>", "(Ljava/util/List;)V"})
public final class PacketShipRemove
implements SimplePacket {
    private final List<Long> toRemove;

    /*
     * WARNING - void declaration
     */
    public PacketShipRemove(List<Long> toRemove) {
        void var1_1;
        Intrinsics.checkNotNullParameter(toRemove, (String)"");
        this.toRemove = var1_1;
    }

    @JvmName(name="getToRemove")
    public final List<Long> getToRemove() {
        return this.toRemove;
    }

    public final List<Long> component1() {
        return this.toRemove;
    }

    /*
     * WARNING - void declaration
     */
    public final PacketShipRemove copy(List<Long> toRemove) {
        void var1_1;
        Intrinsics.checkNotNullParameter(toRemove, (String)"");
        return new PacketShipRemove((List<Long>)var1_1);
    }

    public static /* synthetic */ PacketShipRemove copy$default(PacketShipRemove packetShipRemove, List list, int n2, Object object) {
        if ((n2 & 1) != 0) {
            list = packetShipRemove.toRemove;
        }
        return packetShipRemove.copy(list);
    }

    public final String toString() {
        return "PacketShipRemove(toRemove=" + this.toRemove + ")";
    }

    public final int hashCode() {
        return ((Object)this.toRemove).hashCode();
    }

    public final boolean equals(Object other) {
        PacketShipRemove packetShipRemove;
        if (this == other) {
            return true;
        }
        if (!(other instanceof PacketShipRemove)) {
            return false;
        }
        packetShipRemove = packetShipRemove;
        return Intrinsics.areEqual(this.toRemove, packetShipRemove.toRemove);
    }
}

