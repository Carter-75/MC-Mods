/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.shadow;

import kotlin.jvm.internal.Intrinsics;
import org.joml.Vector3dc;
import org.valkyrienskies.core.impl.shadow.hd_0;

public final class IK
implements hd_0 {
    final int b;
    final double c;
    final Vector3dc d;

    public IK(int n2, double d2, Vector3dc vector3dc) {
        Intrinsics.checkNotNullParameter((Object)vector3dc, (String)"");
        this.b = n2;
        this.c = d2;
        this.d = vector3dc;
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

    private int d() {
        IK iK = this;
        return iK.b;
    }

    private double e() {
        IK iK = this;
        return iK.c;
    }

    private Vector3dc f() {
        IK iK = this;
        return iK.d;
    }

    private static IK a(int n2, double d2, Vector3dc vector3dc) {
        Intrinsics.checkNotNullParameter((Object)vector3dc, (String)"");
        return new IK(n2, d2, vector3dc);
    }

    private static /* synthetic */ IK a(IK iK, int n2, double d2, Vector3dc vector3dc, int n3) {
        IK iK2;
        if ((n3 & 1) != 0) {
            iK2 = iK;
            n2 = iK2.b;
        }
        if ((n3 & 2) != 0) {
            iK2 = iK;
            d2 = iK2.c;
        }
        if ((n3 & 4) != 0) {
            iK2 = iK;
            vector3dc = iK2.d;
        }
        Vector3dc vector3dc2 = vector3dc;
        double d3 = d2;
        int n4 = n2;
        Intrinsics.checkNotNullParameter((Object)vector3dc2, (String)"");
        return new IK(n4, d3, vector3dc2);
    }

    public final String toString() {
        IK iK = this;
        IK iK2 = iK;
        IK iK3 = this;
        iK2 = iK3;
        iK2 = this;
        return "RayCastResultImpl(hitBodyId=" + iK.b + ", distance=" + iK3.c + ", hitNormal=" + iK2.d + ')';
    }

    public final int hashCode() {
        IK iK = this;
        int n2 = Integer.hashCode(iK.b);
        IK iK2 = this;
        int n3 = n2 * 31 + Double.hashCode(iK2.c);
        IK iK3 = this;
        int n4 = n3 * 31 + iK3.d.hashCode();
        return n4;
    }

    public final boolean equals(Object other) {
        IK iK;
        if (this == other) {
            return true;
        }
        if (!(other instanceof IK)) {
            return false;
        }
        iK = iK;
        IK iK2 = this;
        IK iK3 = iK2;
        iK3 = iK;
        if (iK2.b != iK3.b) {
            return false;
        }
        IK iK4 = this;
        iK3 = iK4;
        iK3 = iK;
        if (!Intrinsics.areEqual((Object)iK4.c, (Object)iK3.c)) {
            return false;
        }
        IK iK5 = this;
        iK3 = iK5;
        iK3 = iK;
        return Intrinsics.areEqual((Object)iK5.d, (Object)iK3.d);
    }
}

