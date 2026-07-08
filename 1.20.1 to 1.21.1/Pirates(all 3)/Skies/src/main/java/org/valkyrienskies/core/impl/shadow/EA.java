/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import javax.inject.Provider;
import org.valkyrienskies.core.impl.game.ChunkAllocatorProvider;
import org.valkyrienskies.core.impl.shadow.CY;
import org.valkyrienskies.core.impl.shadow.EO;
import org.valkyrienskies.core.impl.shadow.ek_2;
import org.valkyrienskies.core.impl.shadow.ew_2;
import org.valkyrienskies.core.impl.shadow.ez_0;
import org.valkyrienskies.core.impl.shadow.fv_0;

public final class EA
implements ek_2<ez_0> {
    private final Provider<EO> a;
    private final Provider<CY> b;
    private final Provider<ChunkAllocatorProvider> c;
    private final Provider<fv_0> d;

    private EA(Provider<EO> provider, Provider<CY> provider2, Provider<ChunkAllocatorProvider> provider3, Provider<fv_0> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    private ez_0 a() {
        fv_0 fv_02 = this.d.get();
        ChunkAllocatorProvider chunkAllocatorProvider = this.c.get();
        CY cY = this.b.get();
        EO eO = this.a.get();
        return new ez_0(eO, cY, chunkAllocatorProvider, fv_02);
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    public static EA a(ew_2 ew_22, ew_2 ew_23, ew_2 ew_24, ew_2 ew_25) {
        return new EA(ew_22, ew_23, ew_24, ew_25);
    }

    private static ez_0 a(EO eO, CY cY, ChunkAllocatorProvider chunkAllocatorProvider, fv_0 fv_02) {
        return new ez_0(eO, cY, chunkAllocatorProvider, fv_02);
    }

    @Override
    public final /* synthetic */ Object get() {
        Object object = this;
        fv_0 fv_02 = ((EA)object).d.get();
        ChunkAllocatorProvider chunkAllocatorProvider = ((EA)object).c.get();
        CY cY = ((EA)object).b.get();
        object = ((EA)object).a.get();
        return new ez_0((EO)object, cY, chunkAllocatorProvider, fv_02);
    }
}

