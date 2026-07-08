/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.mod.common.networking;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.valkyrienskies.core.impl.networking.simple.SimplePacket;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u001c\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0006J&\u0010\b\u001a\u00020\u00002\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u00c6\u0001\u00a2\u0006\u0004\b\b\u0010\tJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u00d6\u0003\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0003H\u00d6\u0001\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0004H\u00d6\u0001\u00a2\u0006\u0004\b\u0011\u0010\u0012R#\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0013\u001a\u0004\b\u0014\u0010\u0006\u00a8\u0006\u0017"}, d2={"Lorg/valkyrienskies/mod/common/networking/PacketSyncVSEntityTypes;", "Lorg/valkyrienskies/core/impl/networking/simple/SimplePacket;", "", "", "", "component1", "()Ljava/util/Map;", "entity2Handler", "copy", "(Ljava/util/Map;)Lorg/valkyrienskies/mod/common/networking/PacketSyncVSEntityTypes;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "toString", "()Ljava/lang/String;", "Ljava/util/Map;", "getEntity2Handler", "<init>", "(Ljava/util/Map;)V", "valkyrienskies-120"})
public final class PacketSyncVSEntityTypes
implements SimplePacket {
    @NotNull
    private final Map<Integer, String> entity2Handler;

    public PacketSyncVSEntityTypes(@NotNull Map<Integer, String> entity2Handler) {
        Intrinsics.checkNotNullParameter(entity2Handler, (String)"entity2Handler");
        this.entity2Handler = entity2Handler;
    }

    @NotNull
    public final Map<Integer, String> getEntity2Handler() {
        return this.entity2Handler;
    }

    @NotNull
    public final Map<Integer, String> component1() {
        return this.entity2Handler;
    }

    @NotNull
    public final PacketSyncVSEntityTypes copy(@NotNull Map<Integer, String> entity2Handler) {
        Intrinsics.checkNotNullParameter(entity2Handler, (String)"entity2Handler");
        return new PacketSyncVSEntityTypes(entity2Handler);
    }

    public static /* synthetic */ PacketSyncVSEntityTypes copy$default(PacketSyncVSEntityTypes packetSyncVSEntityTypes, Map map2, int n2, Object object) {
        if ((n2 & 1) != 0) {
            map2 = packetSyncVSEntityTypes.entity2Handler;
        }
        return packetSyncVSEntityTypes.copy(map2);
    }

    @NotNull
    public String toString() {
        return "PacketSyncVSEntityTypes(entity2Handler=" + this.entity2Handler + ")";
    }

    public int hashCode() {
        return ((Object)this.entity2Handler).hashCode();
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PacketSyncVSEntityTypes)) {
            return false;
        }
        PacketSyncVSEntityTypes packetSyncVSEntityTypes = (PacketSyncVSEntityTypes)other;
        return Intrinsics.areEqual(this.entity2Handler, packetSyncVSEntityTypes.entity2Handler);
    }
}

