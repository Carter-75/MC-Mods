/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import javax.inject.Provider;
import org.valkyrienskies.core.impl.game.ChunkAllocator;
import org.valkyrienskies.core.impl.shadow.DQ;
import org.valkyrienskies.core.impl.shadow.ek_2;
import org.valkyrienskies.core.impl.shadow.ew_2;

public final class DR
implements ek_2<DQ> {
    private final Provider<ChunkAllocator> a;

    private DR(Provider<ChunkAllocator> provider) {
        this.a = provider;
    }

    private DQ a() {
        ChunkAllocator chunkAllocator = this.a.get();
        return new DQ(chunkAllocator);
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    public static DR a(ew_2 ew_22) {
        return new DR(ew_22);
    }

    private static DQ a(ChunkAllocator chunkAllocator) {
        return new DQ(chunkAllocator);
    }

    @Override
    public final /* synthetic */ Object get() {
        Object object = this;
        object = ((DR)object).a.get();
        return new DQ((ChunkAllocator)object);
    }
}

