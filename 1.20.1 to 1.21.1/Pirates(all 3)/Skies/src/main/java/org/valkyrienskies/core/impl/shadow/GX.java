/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.shadow;

import kotlin.jvm.internal.Intrinsics;
import org.joml.Matrix3dc;

public final class GX {
    public final double a;
    public final Matrix3dc b;

    public GX(double d2, Matrix3dc matrix3dc) {
        Intrinsics.checkNotNullParameter((Object)matrix3dc, (String)"");
        this.a = d2;
        this.b = matrix3dc;
    }

    public final double a() {
        return this.a;
    }

    public final Matrix3dc b() {
        return this.b;
    }

    private double c() {
        return this.a;
    }

    private Matrix3dc d() {
        return this.b;
    }

    private static GX a(double d2, Matrix3dc matrix3dc) {
        Intrinsics.checkNotNullParameter((Object)matrix3dc, (String)"");
        return new GX(d2, matrix3dc);
    }

    private static /* synthetic */ GX a(GX object, double d2, Matrix3dc matrix3dc, int n2) {
        if ((n2 & 1) != 0) {
            d2 = ((GX)object).a;
        }
        if ((n2 & 2) != 0) {
            matrix3dc = ((GX)object).b;
        }
        object = matrix3dc;
        double d3 = d2;
        Intrinsics.checkNotNullParameter((Object)object, (String)"");
        return new GX(d3, (Matrix3dc)object);
    }

    public final String toString() {
        return "PhysicsBodyInertiaData(invMass=" + this.a + ", invMOI=" + this.b + ')';
    }

    public final int hashCode() {
        int n2 = Double.hashCode(this.a);
        n2 = n2 * 31 + this.b.hashCode();
        return n2;
    }

    public final boolean equals(Object other) {
        GX gX;
        if (this == other) {
            return true;
        }
        if (!(other instanceof GX)) {
            return false;
        }
        gX = gX;
        if (!Intrinsics.areEqual((Object)this.a, (Object)gX.a)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.b, (Object)gX.b);
    }
}

