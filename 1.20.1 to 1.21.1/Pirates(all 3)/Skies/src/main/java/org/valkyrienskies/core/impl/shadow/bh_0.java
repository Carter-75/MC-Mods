/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.bp_0;
import org.valkyrienskies.core.impl.shadow.bq_0;
import org.valkyrienskies.core.impl.shadow.bs_0;
import org.valkyrienskies.core.impl.shadow.oE;
import org.valkyrienskies.core.impl.shadow.oS;
import org.valkyrienskies.core.impl.shadow.pf_0;
import org.valkyrienskies.core.impl.shadow.pl_0;
import org.valkyrienskies.core.impl.shadow.pm_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Bh
 */
public final class bh_0 {
    private bq_0 a;

    public bh_0() {
        this.a = new bq_0(bp_0.FIXED, bs_0.AVERAGE$139d6b26);
    }

    private bh_0(bp_0 bp_02, int n2) {
        this.a = new bq_0(bp_02, n2);
    }

    private static void a(double[] dArray, double[] dArray2) {
        if (dArray == null || dArray2 == null) {
            throw new pl_0();
        }
        if (dArray.length == 0 || dArray2.length == 0) {
            throw new pf_0();
        }
        if (dArray2.length != dArray.length) {
            throw new oS(dArray2.length, dArray.length);
        }
    }

    private static double[] b(double[] dArray, double[] dArray2) {
        double[] dArray3 = new double[dArray.length];
        for (int i2 = 0; i2 < dArray.length; ++i2) {
            dArray3[i2] = dArray2[i2] - dArray[i2];
        }
        return dArray3;
    }

    private static double[] a(double[] dArray) {
        if (dArray == null) {
            throw new pl_0();
        }
        if (dArray.length == 0) {
            throw new pf_0();
        }
        double[] dArray2 = new double[dArray.length];
        for (int i2 = 0; i2 < dArray.length; ++i2) {
            dArray2[i2] = BY.w(dArray[i2]);
        }
        return dArray2;
    }

    private double c(double[] dArray, double[] dArray2) {
        int n2;
        bh_0.a(dArray, dArray2);
        double[] dArray3 = dArray;
        double[] dArray4 = new double[dArray.length];
        for (int i2 = 0; i2 < dArray3.length; ++i2) {
            dArray4[i2] = dArray2[i2] - dArray3[i2];
        }
        dArray2 = dArray4;
        dArray3 = dArray4;
        if (dArray3 == null) {
            throw new pl_0();
        }
        if (dArray3.length == 0) {
            throw new pf_0();
        }
        double[] dArray5 = new double[dArray3.length];
        for (int i3 = 0; i3 < dArray3.length; ++i3) {
            dArray5[i3] = BY.w(dArray3[i3]);
        }
        dArray3 = dArray5;
        dArray3 = this.a.a(dArray3);
        double d2 = 0.0;
        for (n2 = 0; n2 < dArray2.length; ++n2) {
            if (!(dArray2[n2] > 0.0)) continue;
            d2 += dArray3[n2];
        }
        n2 = dArray.length;
        double d3 = (double)(n2 * (n2 + 1)) / 2.0 - d2;
        return BY.e(d2, d3);
    }

    private static double a(double d2, int n2) {
        int n3 = 1 << n2;
        int n4 = 0;
        for (int i2 = 0; i2 < n3; ++i2) {
            int n5 = 0;
            for (int i3 = 0; i3 < n2; ++i3) {
                if ((i2 >> i3 & 1) != 1) continue;
                n5 += i3 + 1;
            }
            if (!((double)n5 >= d2)) continue;
            ++n4;
        }
        return 2.0 * (double)n4 / (double)n3;
    }

    private static double b(double d2, int n2) {
        int n3 = n2;
        double d3 = (double)(n3 * (n3 + 1)) / 4.0;
        double d4 = d3 * ((double)(2 * n2 + 1) / 6.0);
        double d5 = (d2 - d3 - 0.5) / BY.a(d4);
        oE oE2 = new oE(null, 0.0, 1.0);
        return 2.0 * oE2.e(d5);
    }

    private double a(double[] dArray, double[] dArray2, boolean bl) {
        int n2;
        bh_0.a(dArray, dArray2);
        int n3 = dArray.length;
        double[] dArray3 = dArray;
        dArray = dArray2;
        double[] dArray4 = dArray3;
        bh_0 bh_02 = this;
        bh_0.a(dArray4, dArray);
        dArray2 = dArray4;
        double[] dArray5 = new double[dArray4.length];
        for (int i2 = 0; i2 < dArray2.length; ++i2) {
            dArray5[i2] = dArray[i2] - dArray2[i2];
        }
        dArray = dArray5;
        dArray2 = dArray5;
        if (dArray2 == null) {
            throw new pl_0();
        }
        if (dArray2.length == 0) {
            throw new pf_0();
        }
        double[] dArray6 = new double[dArray2.length];
        for (int i3 = 0; i3 < dArray2.length; ++i3) {
            dArray6[i3] = BY.w(dArray2[i3]);
        }
        double[] dArray7 = dArray6;
        double[] dArray8 = bh_02.a.a(dArray7);
        double d2 = 0.0;
        for (n2 = 0; n2 < dArray.length; ++n2) {
            if (!(dArray[n2] > 0.0)) continue;
            d2 += dArray8[n2];
        }
        n2 = dArray4.length;
        double d3 = (double)(n2 * (n2 + 1)) / 2.0 - d2;
        double d4 = BY.e(d2, d3);
        if (bl && n3 > 30) {
            throw new pm_0(n3, (Number)30, true);
        }
        if (bl) {
            int n4 = n3;
            double d5 = d4;
            int n5 = 1 << n4;
            int n6 = 0;
            for (int i4 = 0; i4 < n5; ++i4) {
                int n7 = 0;
                for (n2 = 0; n2 < n4; ++n2) {
                    if ((i4 >> n2 & 1) != 1) continue;
                    n7 += n2 + 1;
                }
                if (!((double)n7 >= d5)) continue;
                ++n6;
            }
            return 2.0 * (double)n6 / (double)n5;
        }
        int n8 = n3;
        double d6 = (double)(n8 * (n8 + 1)) / 2.0 - d4;
        int n9 = n3;
        double d7 = d6;
        int n10 = n9;
        double d8 = (double)(n10 * (n10 + 1)) / 4.0;
        d2 = d8 * ((double)(2 * n9 + 1) / 6.0);
        double d9 = (d7 - d8 - 0.5) / BY.a(d2);
        oE oE2 = new oE(null, 0.0, 1.0);
        return 2.0 * oE2.e(d9);
    }
}

