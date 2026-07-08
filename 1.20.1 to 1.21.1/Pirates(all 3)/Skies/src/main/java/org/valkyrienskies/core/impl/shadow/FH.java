/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.unimi.dsi.fastutil.longs.Long2ObjectMap
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.shadow;

import it.unimi.dsi.fastutil.longs.Long2ObjectMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.valkyrienskies.core.impl.shadow.FA;
import org.valkyrienskies.core.impl.shadow.il_0;

public final class FH {
    final Long2ObjectMap<? extends FA> a;
    private final Long2ObjectMap<? extends List<il_0>> c;
    final int b;

    public FH(Long2ObjectMap<? extends FA> long2ObjectMap, Long2ObjectMap<? extends List<? extends il_0>> long2ObjectMap2, int n2) {
        Intrinsics.checkNotNullParameter(long2ObjectMap, (String)"");
        Intrinsics.checkNotNullParameter(long2ObjectMap2, (String)"");
        this.a = long2ObjectMap;
        this.c = long2ObjectMap2;
        this.b = n2;
    }

    public final Long2ObjectMap<? extends FA> a() {
        return this.a;
    }

    private Long2ObjectMap<? extends List<il_0>> c() {
        return this.c;
    }

    public final int b() {
        return this.b;
    }

    private Long2ObjectMap<? extends FA> d() {
        return this.a;
    }

    private Long2ObjectMap<? extends List<il_0>> e() {
        return this.c;
    }

    private int f() {
        return this.b;
    }

    private static FH a(Long2ObjectMap<? extends FA> long2ObjectMap, Long2ObjectMap<? extends List<? extends il_0>> long2ObjectMap2, int n2) {
        Intrinsics.checkNotNullParameter(long2ObjectMap, (String)"");
        Intrinsics.checkNotNullParameter(long2ObjectMap2, (String)"");
        return new FH(long2ObjectMap, long2ObjectMap2, n2);
    }

    private static /* synthetic */ FH a(FH long2ObjectMap, Long2ObjectMap object, Long2ObjectMap long2ObjectMap2, int n2, int n3) {
        if ((n3 & 1) != 0) {
            object = long2ObjectMap.a;
        }
        if ((n3 & 2) != 0) {
            long2ObjectMap2 = long2ObjectMap.c;
        }
        if ((n3 & 4) != 0) {
            n2 = long2ObjectMap.b;
        }
        Long2ObjectMap<? extends FA> long2ObjectMap3 = object;
        int n4 = n2;
        object = long2ObjectMap2;
        long2ObjectMap = long2ObjectMap3;
        Intrinsics.checkNotNullParameter(long2ObjectMap3, (String)"");
        Intrinsics.checkNotNullParameter(object, (String)"");
        return new FH(long2ObjectMap, (Long2ObjectMap<? extends List<? extends il_0>>)object, n4);
    }

    public final String toString() {
        return "VSPhysicsFrame(shipDataMap=" + this.a + ", voxelUpdatesMap=" + this.c + ", physTickNumber=" + this.b + ")";
    }

    public final int hashCode() {
        int n2 = this.a.hashCode();
        n2 = n2 * 31 + this.c.hashCode();
        n2 = n2 * 31 + Integer.hashCode(this.b);
        return n2;
    }

    public final boolean equals(Object other) {
        FH fH;
        if (this == other) {
            return true;
        }
        if (!(other instanceof FH)) {
            return false;
        }
        fH = fH;
        if (!Intrinsics.areEqual(this.a, fH.a)) {
            return false;
        }
        if (!Intrinsics.areEqual(this.c, fH.c)) {
            return false;
        }
        return this.b == fH.b;
    }
}

