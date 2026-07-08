/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.unimi.dsi.fastutil.longs.Long2ObjectMap
 *  it.unimi.dsi.fastutil.longs.Long2ObjectOpenHashMap
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.shadow;

import it.unimi.dsi.fastutil.longs.Long2ObjectMap;
import it.unimi.dsi.fastutil.longs.Long2ObjectOpenHashMap;
import kotlin.jvm.internal.Intrinsics;
import org.valkyrienskies.core.api.ships.properties.ChunkClaim;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Ds
 */
public final class ds_0<T> {
    private final Long2ObjectMap<T> a = (Long2ObjectMap)new Long2ObjectOpenHashMap();

    public final void a(ChunkClaim chunkClaim, T t) {
        Intrinsics.checkNotNullParameter((Object)chunkClaim, (String)"");
        long l2 = chunkClaim.toLong();
        if (this.a.containsKey(l2)) {
            ChunkClaim chunkClaim2 = chunkClaim;
            throw new IllegalArgumentException("Tried adding " + t + " at " + chunkClaim2 + ", but a value already exists at " + chunkClaim2);
        }
        this.a.put(l2, t);
    }

    public final void a(ChunkClaim chunkClaim) {
        Intrinsics.checkNotNullParameter((Object)chunkClaim, (String)"");
        long l2 = chunkClaim.toLong();
        if (this.a.remove(l2) == null) {
            throw new IllegalArgumentException("Tried to remove data at " + chunkClaim + ", but that claim wasn't in the chunk claim map!");
        }
    }

    private T b(ChunkClaim chunkClaim) {
        Intrinsics.checkNotNullParameter((Object)chunkClaim, (String)"");
        return (T)this.a.get(chunkClaim.toLong());
    }

    public final T a(int n2, int n3) {
        long l2 = ChunkClaim.Companion.getClaimThenToLong(n2, n3);
        return (T)this.a.get(l2);
    }
}

