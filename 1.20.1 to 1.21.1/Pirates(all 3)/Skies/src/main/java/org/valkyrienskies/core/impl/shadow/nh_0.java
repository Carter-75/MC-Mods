/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.ch_0;
import org.valkyrienskies.core.impl.shadow.ci_0;
import org.valkyrienskies.core.impl.shadow.lc_0;
import org.valkyrienskies.core.impl.shadow.ng_0;
import org.valkyrienskies.core.impl.shadow.pn_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.nh
 */
public final class nh_0
implements ng_0 {
    private static int b = 5;
    private final ng_0 c;
    final double a;
    private final int d;

    private nh_0(ng_0 ng_02, double d2, int n2) {
        this.c = ng_02;
        this.a = d2;
        this.d = 5;
    }

    private nh_0(ng_0 ng_02, double d2) {
        this(ng_02, d2, 5);
    }

    public final lc_0 b(double[] dArray, double[] dArray2) {
        int n2;
        int n3;
        if (dArray.length < this.d) {
            throw new pn_0(dArray.length, (Number)this.d, true);
        }
        ch_0.a(dArray);
        double d2 = dArray[0];
        int n4 = dArray.length + (this.d << 1);
        double[] dArray3 = new double[n4];
        double[] dArray4 = new double[n4];
        for (n3 = 0; n3 < dArray.length; ++n3) {
            n2 = n3 + this.d;
            dArray3[n2] = ci_0.a(dArray[n3], this.a, d2);
            dArray4[n2] = dArray2[n3];
        }
        for (n3 = 0; n3 < this.d; ++n3) {
            n2 = dArray.length - this.d + n3;
            dArray3[n3] = ci_0.a(dArray[n2], this.a, d2) - this.a;
            dArray4[n3] = dArray2[n2];
            n2 = n4 - this.d + n3;
            dArray3[n2] = ci_0.a(dArray[n3], this.a, d2) + this.a;
            dArray4[n2] = dArray2[n3];
        }
        ch_0.a(dArray3, (double[][])new double[][]{dArray4});
        lc_0 lc_02 = this.c.b(dArray3, dArray4);
        return new lc_0(this, lc_02, d2){
            private /* synthetic */ lc_0 a;
            private /* synthetic */ double b;
            private /* synthetic */ nh_0 c;
            {
                this.c = nh_02;
                this.a = lc_02;
                this.b = d2;
            }

            public final double a(double d2) {
                nh_0 nh_02 = this.c;
                return this.a.a(ci_0.a(d2, nh_02.a, this.b));
            }
        };
    }

    static /* synthetic */ double a(nh_0 nh_02) {
        return nh_02.a;
    }
}

