/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.shadow;

import kotlin.jvm.internal.Intrinsics;
import org.joml.Vector3dc;
import org.valkyrienskies.core.impl.shadow.he_0;

public final class IL
implements he_0 {
    final int b;
    final double c;
    final Vector3dc d;
    final Vector3dc e;
    final Vector3dc f;

    public IL(int n2, double d2, Vector3dc vector3dc, Vector3dc vector3dc2, Vector3dc vector3dc3) {
        Intrinsics.checkNotNullParameter((Object)vector3dc, (String)"");
        Intrinsics.checkNotNullParameter((Object)vector3dc2, (String)"");
        Intrinsics.checkNotNullParameter((Object)vector3dc3, (String)"");
        this.b = n2;
        this.c = d2;
        this.d = vector3dc;
        this.e = vector3dc2;
        this.f = vector3dc3;
    }

    @Override
    public final int a() {
        return this.b;
    }

    @Override
    public final double b() {
        return this.c;
    }

    @Override
    public final Vector3dc c() {
        return this.d;
    }

    @Override
    public final Vector3dc d() {
        return this.e;
    }

    @Override
    public final Vector3dc e() {
        return this.f;
    }

    private int f() {
        IL iL = this;
        return iL.b;
    }

    private double g() {
        IL iL = this;
        return iL.c;
    }

    private Vector3dc h() {
        IL iL = this;
        return iL.d;
    }

    private Vector3dc i() {
        IL iL = this;
        return iL.e;
    }

    private Vector3dc j() {
        IL iL = this;
        return iL.f;
    }

    private static IL a(int n2, double d2, Vector3dc vector3dc, Vector3dc vector3dc2, Vector3dc vector3dc3) {
        Intrinsics.checkNotNullParameter((Object)vector3dc, (String)"");
        Intrinsics.checkNotNullParameter((Object)vector3dc2, (String)"");
        Intrinsics.checkNotNullParameter((Object)vector3dc3, (String)"");
        return new IL(n2, d2, vector3dc, vector3dc2, vector3dc3);
    }

    private static /* synthetic */ IL a(IL iL, int n2, double d2, Vector3dc vector3dc, Vector3dc vector3dc2, Vector3dc vector3dc3, int n3) {
        IL iL2;
        if ((n3 & 1) != 0) {
            iL2 = iL;
            n2 = iL2.b;
        }
        if ((n3 & 2) != 0) {
            iL2 = iL;
            d2 = iL2.c;
        }
        if ((n3 & 4) != 0) {
            iL2 = iL;
            vector3dc = iL2.d;
        }
        if ((n3 & 8) != 0) {
            iL2 = iL;
            vector3dc2 = iL2.e;
        }
        if ((n3 & 0x10) != 0) {
            iL2 = iL;
            vector3dc3 = iL2.f;
        }
        Vector3dc vector3dc4 = vector3dc3;
        Vector3dc vector3dc5 = vector3dc2;
        Vector3dc vector3dc6 = vector3dc;
        double d3 = d2;
        int n4 = n2;
        Intrinsics.checkNotNullParameter((Object)vector3dc6, (String)"");
        Intrinsics.checkNotNullParameter((Object)vector3dc5, (String)"");
        Intrinsics.checkNotNullParameter((Object)vector3dc4, (String)"");
        return new IL(n4, d3, vector3dc6, vector3dc5, vector3dc4);
    }

    public final String toString() {
        IL iL = this;
        IL iL2 = iL;
        IL iL3 = this;
        iL2 = iL3;
        IL iL4 = this;
        iL2 = iL4;
        IL iL5 = this;
        iL2 = iL5;
        iL2 = this;
        return "RayCastResultWithVelocityImpl(hitBodyId=" + iL.b + ", distance=" + iL3.c + ", hitNormal=" + iL4.d + ", velocity=" + iL5.e + ", angularVelocity=" + iL2.f + ')';
    }

    public final int hashCode() {
        IL iL = this;
        int n2 = Integer.hashCode(iL.b);
        IL iL2 = this;
        int n3 = n2 * 31 + Double.hashCode(iL2.c);
        IL iL3 = this;
        int n4 = n3 * 31 + iL3.d.hashCode();
        IL iL4 = this;
        int n5 = n4 * 31 + iL4.e.hashCode();
        IL iL5 = this;
        int n6 = n5 * 31 + iL5.f.hashCode();
        return n6;
    }

    public final boolean equals(Object other) {
        IL iL;
        if (this == other) {
            return true;
        }
        if (!(other instanceof IL)) {
            return false;
        }
        iL = iL;
        IL iL2 = this;
        IL iL3 = iL2;
        iL3 = iL;
        if (iL2.b != iL3.b) {
            return false;
        }
        IL iL4 = this;
        iL3 = iL4;
        iL3 = iL;
        if (!Intrinsics.areEqual((Object)iL4.c, (Object)iL3.c)) {
            return false;
        }
        IL iL5 = this;
        iL3 = iL5;
        iL3 = iL;
        if (!Intrinsics.areEqual((Object)iL5.d, (Object)iL3.d)) {
            return false;
        }
        IL iL6 = this;
        iL3 = iL6;
        iL3 = iL;
        if (!Intrinsics.areEqual((Object)iL6.e, (Object)iL3.e)) {
            return false;
        }
        IL iL7 = this;
        iL3 = iL7;
        iL3 = iL;
        return Intrinsics.areEqual((Object)iL7.f, (Object)iL3.f);
    }
}

