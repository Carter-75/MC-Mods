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
import org.valkyrienskies.core.impl.networking.impl.PhysEntityCreateData;
import org.valkyrienskies.core.impl.networking.simple.SimplePacket;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J \u0010\u0007\u001a\u00020\u00002\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u00c6\u0001\u00a2\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u00d6\u0003\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eH\u00d6\u0001\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011H\u00d6\u0001\u00a2\u0006\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0007\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0015\u0010\u0005"}, d2={"Lorg/valkyrienskies/core/impl/networking/impl/PacketPhysEntityCreate;", "Lorg/valkyrienskies/core/impl/networking/simple/SimplePacket;", "", "Lorg/valkyrienskies/core/impl/networking/impl/PhysEntityCreateData;", "component1", "()Ljava/util/List;", "toCreate", "copy", "(Ljava/util/List;)Lorg/valkyrienskies/core/impl/networking/impl/PacketPhysEntityCreate;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Ljava/util/List;", "getToCreate", "<init>", "(Ljava/util/List;)V"})
public final class PacketPhysEntityCreate
implements SimplePacket {
    private final List<PhysEntityCreateData> toCreate;

    /*
     * WARNING - void declaration
     */
    public PacketPhysEntityCreate(List<PhysEntityCreateData> toCreate) {
        void var1_1;
        Intrinsics.checkNotNullParameter(toCreate, (String)"");
        this.toCreate = var1_1;
    }

    @JvmName(name="getToCreate")
    public final List<PhysEntityCreateData> getToCreate() {
        return this.toCreate;
    }

    public final List<PhysEntityCreateData> component1() {
        return this.toCreate;
    }

    /*
     * WARNING - void declaration
     */
    public final PacketPhysEntityCreate copy(List<PhysEntityCreateData> toCreate) {
        void var1_1;
        Intrinsics.checkNotNullParameter(toCreate, (String)"");
        return new PacketPhysEntityCreate((List<PhysEntityCreateData>)var1_1);
    }

    public static /* synthetic */ PacketPhysEntityCreate copy$default(PacketPhysEntityCreate packetPhysEntityCreate, List list, int n2, Object object) {
        if ((n2 & 1) != 0) {
            list = packetPhysEntityCreate.toCreate;
        }
        return packetPhysEntityCreate.copy(list);
    }

    public final String toString() {
        return "PacketPhysEntityCreate(toCreate=" + this.toCreate + ")";
    }

    public final int hashCode() {
        return ((Object)this.toCreate).hashCode();
    }

    public final boolean equals(Object other) {
        PacketPhysEntityCreate packetPhysEntityCreate;
        if (this == other) {
            return true;
        }
        if (!(other instanceof PacketPhysEntityCreate)) {
            return false;
        }
        packetPhysEntityCreate = packetPhysEntityCreate;
        return Intrinsics.areEqual(this.toCreate, packetPhysEntityCreate.toCreate);
    }
}

