/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.shadow;

import javax.inject.Inject;
import javax.inject.Named;
import kotlin.jvm.internal.Intrinsics;
import org.valkyrienskies.core.impl.game.ChunkAllocator;
import org.valkyrienskies.core.impl.game.ChunkAllocatorProvider;

public final class DQ
implements ChunkAllocatorProvider {
    public final ChunkAllocator a;

    @Inject
    public DQ(@Named(value="primary") ChunkAllocator chunkAllocator) {
        Intrinsics.checkNotNullParameter((Object)chunkAllocator, (String)"");
        this.a = chunkAllocator;
    }

    public final ChunkAllocator a() {
        return this.a;
    }

    @Override
    public final ChunkAllocator forDimension(String dimensionId) {
        Intrinsics.checkNotNullParameter((Object)dimensionId, (String)"");
        return this.a;
    }
}

