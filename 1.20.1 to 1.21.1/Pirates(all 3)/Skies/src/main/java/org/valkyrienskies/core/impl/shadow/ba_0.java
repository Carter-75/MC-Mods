/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.ch_0;
import org.valkyrienskies.core.impl.shadow.oS;
import org.valkyrienskies.core.impl.shadow.oi_0;
import org.valkyrienskies.core.impl.shadow.po_0;
import org.valkyrienskies.core.impl.shadow.pr_0;
import org.valkyrienskies.core.impl.shadow.px_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Ba
 */
public final class ba_0 {
    public static double a(double[] dArray, long[] lArray) {
        if (dArray.length < 2) {
            throw new oS(dArray.length, 2);
        }
        if (dArray.length != lArray.length) {
            throw new oS(dArray.length, lArray.length);
        }
        ch_0.b(dArray);
        ch_0.a(lArray);
        double d2 = 0.0;
        double d3 = 0.0;
        for (int i2 = 0; i2 < lArray.length; ++i2) {
            d2 += dArray[i2];
            d3 += (double)lArray[i2];
        }
        double d4 = 1.0;
        boolean bl = false;
        if (BY.w(d2 - d3) > 1.0E-5) {
            d4 = d3 / d2;
            bl = true;
        }
        double d5 = 0.0;
        for (int i3 = 0; i3 < lArray.length; ++i3) {
            double d6;
            if (bl) {
                double d7 = d6 = (double)lArray[i3] - d4 * dArray[i3];
                d5 += d7 * d7 / (d4 * dArray[i3]);
                continue;
            }
            double d8 = d6 = (double)lArray[i3] - dArray[i3];
            d5 += d8 * d8 / dArray[i3];
        }
        return d5;
    }

    public final double b(double[] dArray, long[] lArray) {
        oi_0 oi_02 = new oi_0(null, (double)dArray.length - 1.0);
        return 1.0 - oi_02.e(ba_0.a(dArray, lArray));
    }

    public final boolean a(double[] dArray, long[] lArray, double d2) {
        if (d2 <= 0.0 || d2 > 0.5) {
            throw new po_0(px_0.OUT_OF_BOUND_SIGNIFICANCE_LEVEL, (Number)d2, 0, 0.5);
        }
        return this.b(dArray, lArray) < d2;
    }

    public final double a(long[][] lArray) {
        ba_0.c(lArray);
        int n2 = lArray.length;
        int n3 = lArray[0].length;
        double[] dArray = new double[n2];
        double[] dArray2 = new double[n3];
        double d2 = 0.0;
        for (int i2 = 0; i2 < n2; ++i2) {
            for (int i3 = 0; i3 < n3; ++i3) {
                int n4 = i2;
                dArray[n4] = dArray[n4] + (double)lArray[i2][i3];
                int n5 = i3;
                dArray2[n5] = dArray2[n5] + (double)lArray[i2][i3];
                d2 += (double)lArray[i2][i3];
            }
        }
        double d3 = 0.0;
        for (int i4 = 0; i4 < n2; ++i4) {
            for (int i5 = 0; i5 < n3; ++i5) {
                double d4 = dArray[i4] * dArray2[i5] / d2;
                d3 += ((double)lArray[i4][i5] - d4) * ((double)lArray[i4][i5] - d4) / d4;
            }
        }
        return d3;
    }

    public final double b(long[][] lArray) {
        ba_0.c(lArray);
        double d2 = ((double)lArray.length - 1.0) * ((double)lArray[0].length - 1.0);
        oi_0 oi_02 = new oi_0(d2);
        return 1.0 - oi_02.e(this.a(lArray));
    }

    public final boolean a(long[][] lArray, double d2) {
        if (d2 <= 0.0 || d2 > 0.5) {
            throw new po_0(px_0.OUT_OF_BOUND_SIGNIFICANCE_LEVEL, (Number)d2, 0, 0.5);
        }
        return this.b(lArray) < d2;
    }

    public static double a(long[] lArray, long[] lArray2) {
        if (lArray.length < 2) {
            throw new oS(lArray.length, 2);
        }
        if (lArray.length != lArray2.length) {
            throw new oS(lArray.length, lArray2.length);
        }
        ch_0.a(lArray);
        ch_0.a(lArray2);
        long l2 = 0L;
        long l3 = 0L;
        double d2 = 0.0;
        for (int i2 = 0; i2 < lArray.length; ++i2) {
            l2 += lArray[i2];
            l3 += lArray2[i2];
        }
        if (l2 == 0L || l3 == 0L) {
            throw new pr_0();
        }
        boolean bl = l2 != l3;
        if (bl) {
            d2 = BY.a((double)l2 / (double)l3);
        }
        double d3 = 0.0;
        for (int i3 = 0; i3 < lArray.length; ++i3) {
            if (lArray[i3] == 0L && lArray2[i3] == 0L) {
                throw new pr_0(px_0.OBSERVED_COUNTS_BOTTH_ZERO_FOR_ENTRY, i3);
            }
            double d4 = lArray[i3];
            double d5 = lArray2[i3];
            double d6 = bl ? d4 / d2 - d5 * d2 : d4 - d5;
            double d7 = d6;
            d3 += d7 * d7 / (d4 + d5);
        }
        return d3;
    }

    public final double b(long[] lArray, long[] lArray2) {
        oi_0 oi_02 = new oi_0(null, (double)lArray.length - 1.0);
        return 1.0 - oi_02.e(ba_0.a(lArray, lArray2));
    }

    public final boolean a(long[] lArray, long[] lArray2, double d2) {
        if (d2 <= 0.0 || d2 > 0.5) {
            throw new po_0(px_0.OUT_OF_BOUND_SIGNIFICANCE_LEVEL, (Number)d2, 0, 0.5);
        }
        return this.b(lArray, lArray2) < d2;
    }

    private static void c(long[][] lArray) {
        if (lArray.length < 2) {
            throw new oS(lArray.length, 2);
        }
        if (lArray[0].length < 2) {
            throw new oS(lArray[0].length, 2);
        }
        ch_0.a(lArray);
        ch_0.b(lArray);
    }
}

