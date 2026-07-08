/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Map;
import javax.inject.Provider;
import org.valkyrienskies.core.impl.game.ChunkAllocatorProvider;
import org.valkyrienskies.core.impl.shadow.DP;
import org.valkyrienskies.core.impl.shadow.DW;
import org.valkyrienskies.core.impl.shadow.DZ;
import org.valkyrienskies.core.impl.shadow.ea_0;
import org.valkyrienskies.core.impl.shadow.ek_2;
import org.valkyrienskies.core.impl.shadow.ew_2;

public final class DX
implements ek_2<DW> {
    private final Provider<Map<String, DP>> a;
    private final Provider<DZ> b;
    private final Provider<ChunkAllocatorProvider> c;

    private DX(Provider<Map<String, DP>> provider, Provider<DZ> provider2, Provider<ChunkAllocatorProvider> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    private DW a() {
        ChunkAllocatorProvider chunkAllocatorProvider = this.c.get();
        DZ dZ2 = this.b.get();
        Map<String, DP> map2 = this.a.get();
        return new DW(map2, dZ2, chunkAllocatorProvider);
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    public static DX a(ew_2 ew_22, ea_0 ea_02, ew_2 ew_23) {
        return new DX(ew_22, ea_02, ew_23);
    }

    private static DW a(Map<String, DP> map2, DZ dZ2, ChunkAllocatorProvider chunkAllocatorProvider) {
        return new DW(map2, dZ2, chunkAllocatorProvider);
    }

    @Override
    public final /* synthetic */ Object get() {
        Object object = this;
        ChunkAllocatorProvider chunkAllocatorProvider = ((DX)object).c.get();
        DZ dZ2 = ((DX)object).b.get();
        object = ((DX)object).a.get();
        return new DW((Map<String, DP>)object, dZ2, chunkAllocatorProvider);
    }
}

