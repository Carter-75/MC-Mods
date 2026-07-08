/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.shadow;

import kotlin.jvm.internal.Intrinsics;
import org.valkyrienskies.core.impl.shadow.ib_0;

public final class HZ {
    public final ib_0 a;
    public final float b;
    public final float c;
    public final float d;
    public final int e;

    public HZ(ib_0 ib_02, float f2, float f3, float f4, int n2) {
        Intrinsics.checkNotNullParameter((Object)ib_02, (String)"");
        this.a = ib_02;
        this.b = f2;
        this.c = f3;
        this.d = f4;
        this.e = n2;
    }

    public final ib_0 a() {
        return this.a;
    }

    public final float b() {
        return this.b;
    }

    public final float c() {
        return this.c;
    }

    public final float d() {
        return this.d;
    }

    public final int e() {
        return this.e;
    }

    private ib_0 f() {
        return this.a;
    }

    private float g() {
        return this.b;
    }

    private float h() {
        return this.c;
    }

    private float i() {
        return this.d;
    }

    private int j() {
        return this.e;
    }

    private static HZ a(ib_0 ib_02, float f2, float f3, float f4, int n2) {
        Intrinsics.checkNotNullParameter((Object)ib_02, (String)"");
        return new HZ(ib_02, f2, f3, f4, n2);
    }

    private static /* synthetic */ HZ a(HZ object, ib_0 ib_02, float f2, float f3, float f4, int n2, int n3) {
        if ((n3 & 1) != 0) {
            ib_02 = ((HZ)object).a;
        }
        if ((n3 & 2) != 0) {
            f2 = ((HZ)object).b;
        }
        if ((n3 & 4) != 0) {
            f3 = ((HZ)object).c;
        }
        if ((n3 & 8) != 0) {
            f4 = ((HZ)object).d;
        }
        if ((n3 & 0x10) != 0) {
            n2 = ((HZ)object).e;
        }
        float f5 = f2;
        float f6 = f3;
        int n4 = n2;
        f3 = f4;
        f2 = f6;
        float f7 = f5;
        object = ib_02;
        Intrinsics.checkNotNullParameter((Object)object, (String)"");
        return new HZ((ib_0)object, f7, f2, f3, n4);
    }

    public final String toString() {
        return "Lod1SolidBlockState(collisionShape=" + this.a + ", elasticity=" + this.b + ", friction=" + this.c + ", hardness=" + this.d + ", lod1SolidBlockStateId=" + this.e + ')';
    }

    public final int hashCode() {
        int n2 = this.a.hashCode();
        n2 = n2 * 31 + Float.hashCode(this.b);
        n2 = n2 * 31 + Float.hashCode(this.c);
        n2 = n2 * 31 + Float.hashCode(this.d);
        n2 = n2 * 31 + Integer.hashCode(this.e);
        return n2;
    }

    public final boolean equals(Object other) {
        HZ hZ;
        if (this == other) {
            return true;
        }
        if (!(other instanceof HZ)) {
            return false;
        }
        hZ = hZ;
        if (!Intrinsics.areEqual((Object)this.a, (Object)hZ.a)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)Float.valueOf(this.b), (Object)Float.valueOf(hZ.b))) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)Float.valueOf(this.c), (Object)Float.valueOf(hZ.c))) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)Float.valueOf(this.d), (Object)Float.valueOf(hZ.d))) {
            return false;
        }
        return this.e == hZ.e;
    }
}

