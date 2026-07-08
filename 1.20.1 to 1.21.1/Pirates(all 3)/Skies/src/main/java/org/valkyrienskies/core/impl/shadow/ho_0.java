/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.shadow;

import kotlin.jvm.internal.Intrinsics;
import org.valkyrienskies.core.impl.shadow.GQ;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Ho
 */
public final class ho_0
implements GQ {
    private double a;
    private double b;

    public ho_0(double d2, double d3) {
        this.a = d2;
        this.b = d3;
    }

    @Override
    public final double a() {
        return this.a;
    }

    @Override
    public final void a(double d2) {
        this.a = d2;
    }

    @Override
    public final double h_() {
        return this.b;
    }

    @Override
    public final void b(double d2) {
        this.b = d2;
    }

    @Override
    public final void close() {
    }

    private double c() {
        ho_0 ho_02 = this;
        return ho_02.a;
    }

    private double d() {
        ho_0 ho_02 = this;
        return ho_02.b;
    }

    private static ho_0 a(double d2, double d3) {
        return new ho_0(d2, d3);
    }

    private static /* synthetic */ ho_0 a(ho_0 ho_02, double d2, double d3, int n2) {
        ho_0 ho_03;
        if ((n2 & 1) != 0) {
            ho_03 = ho_02;
            d2 = ho_03.a;
        }
        if ((n2 & 2) != 0) {
            ho_03 = ho_02;
            d3 = ho_03.b;
        }
        double d4 = d3;
        double d5 = d2;
        return new ho_0(d5, d4);
    }

    public final String toString() {
        ho_0 ho_02 = this;
        ho_0 ho_03 = ho_02;
        ho_03 = this;
        return "DummyCapsuleShapeReference(radius=" + ho_02.a + ", halfLength=" + ho_03.b + ')';
    }

    public final int hashCode() {
        ho_0 ho_02 = this;
        int n2 = Double.hashCode(ho_02.a);
        ho_0 ho_03 = this;
        int n3 = n2 * 31 + Double.hashCode(ho_03.b);
        return n3;
    }

    public final boolean equals(Object other) {
        ho_0 ho_02;
        if (this == other) {
            return true;
        }
        if (!(other instanceof ho_0)) {
            return false;
        }
        ho_02 = ho_02;
        ho_0 ho_03 = this;
        ho_0 ho_04 = ho_03;
        ho_04 = ho_02;
        if (!Intrinsics.areEqual((Object)ho_03.a, (Object)ho_04.a)) {
            return false;
        }
        ho_0 ho_05 = this;
        ho_04 = ho_05;
        ho_04 = ho_02;
        return Intrinsics.areEqual((Object)ho_05.b, (Object)ho_04.b);
    }
}

