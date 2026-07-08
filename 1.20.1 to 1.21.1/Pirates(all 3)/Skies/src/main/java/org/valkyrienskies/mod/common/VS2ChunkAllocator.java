/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 */
package org.valkyrienskies.mod.common;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.valkyrienskies.mod.common.VSGameUtilsKt;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u001d\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2={"Lorg/valkyrienskies/mod/common/VS2ChunkAllocator;", "", "", "chunkX", "chunkZ", "", "isChunkInShipyardCompanion", "(II)Z", "<init>", "()V", "valkyrienskies-120"})
public final class VS2ChunkAllocator {
    @NotNull
    public static final VS2ChunkAllocator INSTANCE = new VS2ChunkAllocator();

    private VS2ChunkAllocator() {
    }

    public final boolean isChunkInShipyardCompanion(int chunkX, int chunkZ) {
        return VSGameUtilsKt.getVsCore().isChunkInShipyard(chunkX, chunkZ);
    }
}

