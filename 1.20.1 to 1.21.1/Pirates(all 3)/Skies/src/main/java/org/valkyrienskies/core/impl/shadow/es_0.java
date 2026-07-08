/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Map;
import javax.inject.Provider;
import org.valkyrienskies.core.impl.game.ChunkAllocatorProvider;
import org.valkyrienskies.core.impl.game.ships.ShipData;
import org.valkyrienskies.core.impl.program.VSCoreInternal;
import org.valkyrienskies.core.impl.shadow.DN;
import org.valkyrienskies.core.impl.shadow.DP;
import org.valkyrienskies.core.impl.shadow.DW;
import org.valkyrienskies.core.impl.shadow.ek_2;
import org.valkyrienskies.core.impl.shadow.er_0;
import org.valkyrienskies.core.impl.shadow.ew_2;
import org.valkyrienskies.core.impl.shadow.ez_0;
import org.valkyrienskies.core.impl.shadow.fi_0;
import org.valkyrienskies.core.internal.ships.VsiMutableQueryableShipData;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Es
 */
public final class es_0
implements ek_2<er_0> {
    private final Provider<VsiMutableQueryableShipData<ShipData>> a;
    private final Provider<ChunkAllocatorProvider> b;
    private final Provider<ez_0> c;
    private final Provider<fi_0> d;
    private final Provider<DN> e;
    private final Provider<Map<String, DP>> f;
    private final Provider<DW> g;
    private final Provider<ShipData.Factory> h;
    private final Provider<VSCoreInternal> i;

    private es_0(Provider<VsiMutableQueryableShipData<ShipData>> provider, Provider<ChunkAllocatorProvider> provider2, Provider<ez_0> provider3, Provider<fi_0> provider4, Provider<DN> provider5, Provider<Map<String, DP>> provider6, Provider<DW> provider7, Provider<ShipData.Factory> provider8, Provider<VSCoreInternal> provider9) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
        this.h = provider8;
        this.i = provider9;
    }

    private er_0 a() {
        Provider<VSCoreInternal> provider = this.i;
        ShipData.Factory factory = this.h.get();
        DW dW = this.g.get();
        Map<String, DP> map2 = this.f.get();
        DN dN = this.e.get();
        fi_0 fi_02 = this.d.get();
        ez_0 ez_02 = this.c.get();
        ChunkAllocatorProvider chunkAllocatorProvider = this.b.get();
        VsiMutableQueryableShipData<ShipData> vsiMutableQueryableShipData = this.a.get();
        return new er_0(vsiMutableQueryableShipData, chunkAllocatorProvider, ez_02, fi_02, dN, map2, dW, factory, provider);
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    public static es_0 a(ew_2 ew_22, ew_2 ew_23, ew_2 ew_24, ew_2 ew_25, ew_2 ew_26, ew_2 ew_27, ew_2 ew_28, ew_2 ew_29, ew_2 ew_210) {
        return new es_0(ew_22, ew_23, ew_24, ew_25, ew_26, ew_27, ew_28, ew_29, ew_210);
    }

    private static er_0 a(VsiMutableQueryableShipData<ShipData> vsiMutableQueryableShipData, ChunkAllocatorProvider chunkAllocatorProvider, ez_0 ez_02, fi_0 fi_02, DN dN, Map<String, DP> map2, DW dW, ShipData.Factory factory, Provider<VSCoreInternal> provider) {
        return new er_0(vsiMutableQueryableShipData, chunkAllocatorProvider, ez_02, fi_02, dN, map2, dW, factory, provider);
    }

    @Override
    public final /* synthetic */ Object get() {
        Object object = this;
        Provider<VSCoreInternal> provider = ((es_0)object).i;
        ShipData.Factory factory = ((es_0)object).h.get();
        DW dW = ((es_0)object).g.get();
        Map<String, DP> map2 = ((es_0)object).f.get();
        DN dN = ((es_0)object).e.get();
        fi_0 fi_02 = ((es_0)object).d.get();
        ez_0 ez_02 = ((es_0)object).c.get();
        ChunkAllocatorProvider chunkAllocatorProvider = ((es_0)object).b.get();
        object = ((es_0)object).a.get();
        return new er_0((VsiMutableQueryableShipData<ShipData>)object, chunkAllocatorProvider, ez_02, fi_02, dN, map2, dW, factory, provider);
    }
}

