/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.bp_0;
import org.valkyrienskies.core.impl.shadow.bq_0;
import org.valkyrienskies.core.impl.shadow.bs_0;
import org.valkyrienskies.core.impl.shadow.oE;
import org.valkyrienskies.core.impl.shadow.pf_0;
import org.valkyrienskies.core.impl.shadow.pl_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Bd
 */
public final class bd_0 {
    private bq_0 a;

    public bd_0() {
        this.a = new bq_0(bp_0.FIXED, bs_0.AVERAGE$139d6b26);
    }

    private bd_0(bp_0 bp_02, int n2) {
        this.a = new bq_0(bp_02, n2);
    }

    private static void a(double[] dArray, double[] dArray2) {
        if (dArray == null || dArray2 == null) {
            throw new pl_0();
        }
        if (dArray.length == 0 || dArray2.length == 0) {
            throw new pf_0();
        }
    }

    private static double[] b(double[] dArray, double[] dArray2) {
        double[] dArray3 = new double[dArray.length + dArray2.length];
        System.arraycopy(dArray, 0, dArray3, 0, dArray.length);
        System.arraycopy(dArray2, 0, dArray3, dArray.length, dArray2.length);
        return dArray3;
    }

    private double c(double[] dArray, double[] dArray2) {
        bd_0.a(dArray, dArray2);
        double[] dArray3 = dArray2;
        double[] dArray4 = dArray;
        double[] dArray5 = new double[dArray.length + dArray3.length];
        System.arraycopy(dArray4, 0, dArray5, 0, dArray4.length);
        System.arraycopy(dArray3, 0, dArray5, dArray4.length, dArray3.length);
        dArray4 = dArray5;
        dArray4 = this.a.a(dArray4);
        double d2 = 0.0;
        for (int i2 = 0; i2 < dArray.length; ++i2) {
            d2 += dArray4[i2];
        }
        double d3 = d2 - (double)((long)dArray.length * (long)(dArray.length + 1) / 2L);
        double d4 = (double)((long)dArray.length * (long)dArray2.length) - d3;
        return BY.e(d3, d4);
    }

    private static double a(double d2, int n2, int n3) {
        long l2 = (long)n2 * (long)n3;
        double d3 = (double)l2 / 2.0;
        double d4 = (double)(l2 * (long)(n2 + n3 + 1)) / 12.0;
        double d5 = (d2 - d3) / BY.a(d4);
        oE oE2 = new oE(null, 0.0, 1.0);
        return 2.0 * oE2.e(d5);
    }

    private double d(double[] object, double[] dArray) {
        bd_0.a((double[])object, dArray);
        double[] dArray2 = dArray;
        double[] dArray3 = object;
        bd_0 bd_02 = this;
        bd_0.a(dArray3, dArray2);
        double[] dArray4 = dArray2;
        double[] dArray5 = dArray3;
        double[] dArray6 = new double[dArray3.length + dArray4.length];
        System.arraycopy(dArray5, 0, dArray6, 0, dArray5.length);
        System.arraycopy(dArray4, 0, dArray6, dArray5.length, dArray4.length);
        dArray6 = bd_02.a.a(dArray6);
        double d2 = 0.0;
        for (int i2 = 0; i2 < dArray3.length; ++i2) {
            d2 += dArray6[i2];
        }
        double d3 = d2 - (double)((long)dArray3.length * (long)(dArray3.length + 1) / 2L);
        double d4 = (double)((long)dArray3.length * (long)dArray2.length) - d3;
        double d5 = BY.e(d3, d4);
        double d6 = (double)((long)((double[])object).length * (long)dArray.length) - d5;
        int n2 = dArray.length;
        int n3 = ((double[])object).length;
        double d7 = d6;
        long l2 = (long)n3 * (long)n2;
        d3 = (double)l2 / 2.0;
        d4 = (double)(l2 * (long)(n3 + n2 + 1)) / 12.0;
        double d8 = (d7 - d3) / BY.a(d4);
        object = new oE(null, 0.0, 1.0);
        return 2.0 * ((oE)object).e(d8);
    }
}

