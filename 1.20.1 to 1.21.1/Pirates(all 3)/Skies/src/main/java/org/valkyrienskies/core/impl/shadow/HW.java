/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.shadow;

import kotlin.jvm.internal.Intrinsics;
import org.valkyrienskies.core.impl.shadow.HX;
import org.valkyrienskies.core.impl.shadow.HZ;

public final class HW {
    private final HZ a;
    private final HX b;
    private final int c;

    public HW(HZ hZ, HX hX, int n2) {
        Intrinsics.checkNotNullParameter((Object)hZ, (String)"");
        Intrinsics.checkNotNullParameter((Object)hX, (String)"");
        this.a = hZ;
        this.b = hX;
        this.c = n2;
    }

    private HZ a() {
        return this.a;
    }

    private HX b() {
        return this.b;
    }

    private int c() {
        return this.c;
    }

    private HZ d() {
        return this.a;
    }

    private HX e() {
        return this.b;
    }

    private int f() {
        return this.c;
    }

    private static HW a(HZ hZ, HX hX, int n2) {
        Intrinsics.checkNotNullParameter((Object)hZ, (String)"");
        Intrinsics.checkNotNullParameter((Object)hX, (String)"");
        return new HW(hZ, hX, n2);
    }

    private static /* synthetic */ HW a(HW object, HZ object2, HX hX, int n2, int n3) {
        if ((n3 & 1) != 0) {
            object2 = ((HW)object).a;
        }
        if ((n3 & 2) != 0) {
            hX = ((HW)object).b;
        }
        if ((n3 & 4) != 0) {
            n2 = ((HW)object).c;
        }
        HZ hZ = object2;
        int n4 = n2;
        object2 = hX;
        object = hZ;
        Intrinsics.checkNotNullParameter((Object)hZ, (String)"");
        Intrinsics.checkNotNullParameter((Object)object2, (String)"");
        return new HW((HZ)object, (HX)object2, n4);
    }

    public final String toString() {
        return "Lod1BlockState(lod1SolidBlockState=" + this.a + ", lod1LiquidBlockState=" + this.b + ", lod1BlockStateId=" + this.c + ')';
    }

    public final int hashCode() {
        int n2 = this.a.hashCode();
        n2 = n2 * 31 + this.b.hashCode();
        n2 = n2 * 31 + Integer.hashCode(this.c);
        return n2;
    }

    public final boolean equals(Object other) {
        HW hW;
        if (this == other) {
            return true;
        }
        if (!(other instanceof HW)) {
            return false;
        }
        hW = hW;
        if (!Intrinsics.areEqual((Object)this.a, (Object)hW.a)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.b, (Object)hW.b)) {
            return false;
        }
        return this.c == hW.c;
    }
}

