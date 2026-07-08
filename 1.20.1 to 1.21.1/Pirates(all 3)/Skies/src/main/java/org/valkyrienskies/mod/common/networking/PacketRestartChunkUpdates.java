/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.mod.common.networking;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector2i;
import org.valkyrienskies.core.impl.networking.simple.SimplePacket;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J \u0010\u0007\u001a\u00020\u00002\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u00c6\u0001\u00a2\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u00d6\u0003\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eH\u00d6\u0001\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011H\u00d6\u0001\u00a2\u0006\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0015\u0010\u0005\u00a8\u0006\u0018"}, d2={"Lorg/valkyrienskies/mod/common/networking/PacketRestartChunkUpdates;", "Lorg/valkyrienskies/core/impl/networking/simple/SimplePacket;", "", "Lorg/joml/Vector2i;", "component1", "()Ljava/util/List;", "chunks", "copy", "(Ljava/util/List;)Lorg/valkyrienskies/mod/common/networking/PacketRestartChunkUpdates;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Ljava/util/List;", "getChunks", "<init>", "(Ljava/util/List;)V", "valkyrienskies-120"})
public final class PacketRestartChunkUpdates
implements SimplePacket {
    @NotNull
    private final List<Vector2i> chunks;

    public PacketRestartChunkUpdates(@NotNull List<? extends Vector2i> chunks) {
        Intrinsics.checkNotNullParameter(chunks, (String)"chunks");
        this.chunks = chunks;
    }

    @NotNull
    public final List<Vector2i> getChunks() {
        return this.chunks;
    }

    @NotNull
    public final List<Vector2i> component1() {
        return this.chunks;
    }

    @NotNull
    public final PacketRestartChunkUpdates copy(@NotNull List<? extends Vector2i> chunks) {
        Intrinsics.checkNotNullParameter(chunks, (String)"chunks");
        return new PacketRestartChunkUpdates(chunks);
    }

    public static /* synthetic */ PacketRestartChunkUpdates copy$default(PacketRestartChunkUpdates packetRestartChunkUpdates, List list, int n2, Object object) {
        if ((n2 & 1) != 0) {
            list = packetRestartChunkUpdates.chunks;
        }
        return packetRestartChunkUpdates.copy(list);
    }

    @NotNull
    public String toString() {
        return "PacketRestartChunkUpdates(chunks=" + this.chunks + ")";
    }

    public int hashCode() {
        return ((Object)this.chunks).hashCode();
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PacketRestartChunkUpdates)) {
            return false;
        }
        PacketRestartChunkUpdates packetRestartChunkUpdates = (PacketRestartChunkUpdates)other;
        return Intrinsics.areEqual(this.chunks, packetRestartChunkUpdates.chunks);
    }
}

