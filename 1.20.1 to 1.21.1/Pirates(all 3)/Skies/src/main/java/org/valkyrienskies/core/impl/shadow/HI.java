/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.shadow;

import kotlin.jvm.internal.Intrinsics;
import org.valkyrienskies.core.impl.shadow.HJ;

public final class HI {
    public final int a;
    public final HJ b;

    public HI(int n2, HJ hJ) {
        Intrinsics.checkNotNullParameter((Object)hJ, (String)"");
        this.a = n2;
        this.b = hJ;
    }

    public final int a() {
        return this.a;
    }

    public final HJ b() {
        return this.b;
    }

    private int c() {
        return this.a;
    }

    private HJ d() {
        return this.b;
    }

    private static HI a(int n2, HJ hJ) {
        Intrinsics.checkNotNullParameter((Object)hJ, (String)"");
        return new HI(n2, hJ);
    }

    private static /* synthetic */ HI a(HI hI, int n2, HJ hJ, int n3) {
        if ((n3 & 1) != 0) {
            n2 = hI.a;
        }
        if ((n3 & 2) != 0) {
            hJ = hI.b;
        }
        HJ hJ2 = hJ;
        int n4 = n2;
        Intrinsics.checkNotNullParameter((Object)hJ2, (String)"");
        return new HI(n4, hJ2);
    }

    public final String toString() {
        return "JointAndId(jointId=" + this.a + ", jointData=" + this.b + ')';
    }

    public final int hashCode() {
        int n2 = Integer.hashCode(this.a);
        n2 = n2 * 31 + this.b.hashCode();
        return n2;
    }

    public final boolean equals(Object other) {
        HI hI;
        if (this == other) {
            return true;
        }
        if (!(other instanceof HI)) {
            return false;
        }
        hI = hI;
        if (this.a != hI.a) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.b, (Object)hI.b);
    }
}

