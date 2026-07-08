/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.unimi.dsi.fastutil.ints.Int2ObjectMap
 *  it.unimi.dsi.fastutil.ints.Int2ObjectMaps
 *  it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap
 *  it.unimi.dsi.fastutil.objects.Object2IntMap
 *  it.unimi.dsi.fastutil.objects.Object2IntMaps
 *  it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.shadow;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMaps;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2IntMaps;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;
import org.valkyrienskies.core.api.physics.blockstates.LiquidState;
import org.valkyrienskies.core.api.physics.blockstates.SolidState;
import org.valkyrienskies.core.internal.physics.blockstates.VsiBlockState;

public final class CP {
    private int i = 1;
    private int j = 1;
    private int k = 1;
    public final Object2IntOpenHashMap<SolidState> a;
    public final Object2IntOpenHashMap<LiquidState> b;
    public final Object2IntOpenHashMap<VsiBlockState> c;
    private final Int2ObjectOpenHashMap<VsiBlockState> l;
    public final Int2ObjectMap<VsiBlockState> d;
    public final Object2IntMap<SolidState> e;
    public final Object2IntMap<LiquidState> f;
    public final Object2IntMap<VsiBlockState> g;
    public boolean h;

    @Inject
    public CP() {
        Object2IntOpenHashMap object2IntOpenHashMap;
        Object2IntOpenHashMap object2IntOpenHashMap2 = object2IntOpenHashMap = new Object2IntOpenHashMap();
        CP cP = this;
        object2IntOpenHashMap2.defaultReturnValue(-1);
        cP.a = object2IntOpenHashMap;
        object2IntOpenHashMap2 = object2IntOpenHashMap = new Object2IntOpenHashMap();
        cP = this;
        object2IntOpenHashMap2.defaultReturnValue(-1);
        cP.b = object2IntOpenHashMap;
        object2IntOpenHashMap2 = object2IntOpenHashMap = new Object2IntOpenHashMap();
        cP = this;
        object2IntOpenHashMap2.defaultReturnValue(-1);
        cP.c = object2IntOpenHashMap;
        this.l = new Int2ObjectOpenHashMap();
        Int2ObjectMap int2ObjectMap = Int2ObjectMaps.unmodifiable((Int2ObjectMap)((Int2ObjectMap)this.l));
        Intrinsics.checkNotNullExpressionValue((Object)int2ObjectMap, (String)"");
        this.d = int2ObjectMap;
        Object2IntMap object2IntMap = Object2IntMaps.unmodifiable((Object2IntMap)((Object2IntMap)this.a));
        Intrinsics.checkNotNullExpressionValue((Object)object2IntMap, (String)"");
        this.e = object2IntMap;
        Object2IntMap object2IntMap2 = Object2IntMaps.unmodifiable((Object2IntMap)((Object2IntMap)this.b));
        Intrinsics.checkNotNullExpressionValue((Object)object2IntMap2, (String)"");
        this.f = object2IntMap2;
        Object2IntMap object2IntMap3 = Object2IntMaps.unmodifiable((Object2IntMap)((Object2IntMap)this.c));
        Intrinsics.checkNotNullExpressionValue((Object)object2IntMap3, (String)"");
        this.g = object2IntMap3;
        this.l.put(0, (Object)new VsiBlockState(null, null));
        this.c.put((Object)new VsiBlockState(null, null), 0);
        this.a.put(null, 0);
        this.b.put(null, 0);
    }

    public final Int2ObjectMap<VsiBlockState> a() {
        return this.d;
    }

    public final Object2IntMap<SolidState> b() {
        return this.e;
    }

    public final Object2IntMap<LiquidState> c() {
        return this.f;
    }

    public final Object2IntMap<VsiBlockState> d() {
        return this.g;
    }

    public final boolean e() {
        return this.h;
    }

    public final void f() {
        this.h = true;
    }

    public final int a(SolidState solidState) {
        return this.a.getInt((Object)solidState);
    }

    public final int a(LiquidState liquidState) {
        return this.b.getInt((Object)liquidState);
    }

    public final int a(VsiBlockState vsiBlockState) {
        Intrinsics.checkNotNullParameter((Object)vsiBlockState, (String)"");
        return this.c.getInt((Object)vsiBlockState);
    }

    private boolean b(SolidState solidState) {
        Intrinsics.checkNotNullParameter((Object)solidState, (String)"");
        return this.a.containsKey((Object)solidState);
    }

    private boolean b(LiquidState liquidState) {
        Intrinsics.checkNotNullParameter((Object)liquidState, (String)"");
        return this.b.containsKey((Object)liquidState);
    }

    private boolean c(VsiBlockState vsiBlockState) {
        Intrinsics.checkNotNullParameter((Object)vsiBlockState, (String)"");
        return this.c.containsKey((Object)vsiBlockState);
    }

    private final void a(Object object) {
        if (this.h) {
            throw new IllegalStateException("Valkyrien Skies: tried registering state " + object + ", but the block state registry has already been frozen");
        }
    }

    private final int c(SolidState solidState) {
        this.a((Object)solidState);
        int n2 = this.i;
        int n3 = this.a.putIfAbsent((Object)solidState, n2);
        if (n3 == -1) {
            this.i = n2 + 1;
            return n2;
        }
        return n3;
    }

    private final int c(LiquidState liquidState) {
        this.a((Object)liquidState);
        int n2 = this.j;
        int n3 = this.b.putIfAbsent((Object)liquidState, n2);
        if (n3 == -1) {
            this.j = n2 + 1;
            return n2;
        }
        return n3;
    }

    public final int b(VsiBlockState vsiBlockState) {
        int n2;
        int n3;
        Object object;
        Intrinsics.checkNotNullParameter((Object)vsiBlockState, (String)"");
        this.a((Object)vsiBlockState);
        SolidState solidState = vsiBlockState.getSolidState();
        if (solidState != null) {
            object = solidState;
            SolidState solidState2 = object;
            object = this;
            ((CP)object).a((Object)solidState2);
            n3 = ((CP)object).i;
            n2 = ((CP)object).a.putIfAbsent((Object)solidState2, n3);
            if (n2 == -1) {
                ((CP)object).i = n3 + 1;
                v1 = n3;
            } else {
                v1 = n2;
            }
        }
        LiquidState liquidState = vsiBlockState.getLiquidState();
        if (liquidState != null) {
            Object object2 = object = liquidState;
            object = this;
            ((CP)object).a(object2);
            n3 = ((CP)object).j;
            n2 = ((CP)object).b.putIfAbsent(object2, n3);
            if (n2 == -1) {
                ((CP)object).j = n3 + 1;
                v3 = n3;
            } else {
                v3 = n2;
            }
        }
        int n4 = this.k;
        n2 = this.c.putIfAbsent((Object)vsiBlockState, n4);
        if (n2 == -1) {
            this.l.put(n4, (Object)vsiBlockState);
            this.k = n4 + 1;
            return n4;
        }
        return n2;
    }
}

