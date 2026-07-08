/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.shadow;

import kotlin.jvm.internal.Intrinsics;
import org.valkyrienskies.core.impl.shadow.DT;

public final class DY {
    final DT a;
    final DT b;

    public DY(DT dT, DT dT2) {
        Intrinsics.checkNotNullParameter((Object)dT, (String)"");
        Intrinsics.checkNotNullParameter((Object)dT2, (String)"");
        this.a = dT;
        this.b = dT2;
    }

    public final DT a() {
        return this.a;
    }

    public final DT b() {
        return this.b;
    }

    public final DT c() {
        return this.a;
    }

    public final DT d() {
        return this.b;
    }

    private static DY a(DT dT, DT dT2) {
        Intrinsics.checkNotNullParameter((Object)dT, (String)"");
        Intrinsics.checkNotNullParameter((Object)dT2, (String)"");
        return new DY(dT, dT2);
    }

    private static /* synthetic */ DY a(DY object, DT dT, DT dT2, int n2) {
        if ((n2 & 1) != 0) {
            dT = ((DY)object).a;
        }
        if ((n2 & 2) != 0) {
            dT2 = ((DY)object).b;
        }
        DT dT3 = dT;
        dT = dT2;
        object = dT3;
        Intrinsics.checkNotNullParameter((Object)dT3, (String)"");
        Intrinsics.checkNotNullParameter((Object)dT, (String)"");
        return new DY((DT)object, dT);
    }

    public final String toString() {
        return "DimensionBlockConnGraphs(solidGraph=" + this.a + ", airGraph=" + this.b + ")";
    }

    public final int hashCode() {
        int n2 = this.a.hashCode();
        n2 = n2 * 31 + this.b.hashCode();
        return n2;
    }

    public final boolean equals(Object other) {
        DY dY;
        if (this == other) {
            return true;
        }
        if (!(other instanceof DY)) {
            return false;
        }
        dY = dY;
        if (!Intrinsics.areEqual((Object)this.a, (Object)dY.a)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.b, (Object)dY.b);
    }
}

