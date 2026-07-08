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
 * Renamed from org.valkyrienskies.core.impl.shadow.Bb
 */
public final class bb_0 {
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
            double d6 = bl ? BY.k((double)lArray[i3] / (d4 * dArray[i3])) : BY.k((double)lArray[i3] / dArray[i3]);
            d5 += (double)lArray[i3] * d6;
        }
        return d5 * 2.0;
    }

    public final double b(double[] dArray, long[] lArray) {
        oi_0 oi_02 = new oi_0(null, (double)dArray.length - 1.0);
        return 1.0 - oi_02.e(bb_0.a(dArray, lArray));
    }

    public final double c(double[] dArray, long[] lArray) {
        oi_0 oi_02 = new oi_0(null, (double)dArray.length - 2.0);
        return 1.0 - oi_02.e(bb_0.a(dArray, lArray));
    }

    public final boolean a(double[] dArray, long[] lArray, double d2) {
        if (d2 <= 0.0 || d2 > 0.5) {
            throw new po_0(px_0.OUT_OF_BOUND_SIGNIFICANCE_LEVEL, (Number)d2, 0, 0.5);
        }
        return this.b(dArray, lArray) < d2;
    }

    private static double a(long[][] lArray) {
        int n2;
        int n3;
        double d2 = 0.0;
        double d3 = 0.0;
        for (n3 = 0; n3 < lArray.length; ++n3) {
            for (n2 = 0; n2 < lArray[n3].length; ++n2) {
                d3 += (double)lArray[n3][n2];
            }
        }
        for (n3 = 0; n3 < lArray.length; ++n3) {
            for (n2 = 0; n2 < lArray[n3].length; ++n2) {
                double d4;
                if (lArray[n3][n2] == 0L) continue;
                double d5 = d4 = (double)lArray[n3][n2] / d3;
                d2 += d5 * BY.k(d5);
            }
        }
        return -d2;
    }

    private static double a(long[] lArray) {
        int n2;
        double d2 = 0.0;
        double d3 = 0.0;
        for (n2 = 0; n2 < lArray.length; ++n2) {
            d3 += (double)lArray[n2];
        }
        for (n2 = 0; n2 < lArray.length; ++n2) {
            double d4;
            if (lArray[n2] == 0L) continue;
            double d5 = d4 = (double)lArray[n2] / d3;
            d2 += d5 * BY.k(d5);
        }
        return -d2;
    }

    public final double a(long[] object, long[] lArray) {
        int n2;
        if (((long[])object).length < 2) {
            throw new oS(((long[])object).length, 2);
        }
        if (((long[])object).length != lArray.length) {
            throw new oS(((long[])object).length, lArray.length);
        }
        ch_0.a(object);
        ch_0.a(lArray);
        long l2 = 0L;
        long l3 = 0L;
        long[] lArray2 = new long[((long[])object).length];
        long[][] lArray3 = new long[2][((long[])object).length];
        for (int i2 = 0; i2 < ((long[])object).length; ++i2) {
            if (object[i2] == 0L && lArray[i2] == 0L) {
                throw new pr_0(px_0.OBSERVED_COUNTS_BOTTH_ZERO_FOR_ENTRY, i2);
            }
            l2 += object[i2];
            l3 += lArray[i2];
            lArray2[i2] = object[i2] + lArray[i2];
            lArray3[0][i2] = object[i2];
            lArray3[1][i2] = lArray[i2];
        }
        if (l2 == 0L || l3 == 0L) {
            throw new pr_0();
        }
        long[] lArray4 = new long[]{l2, l3};
        double d2 = (double)l2 + (double)l3;
        double d3 = bb_0.a(lArray4) + bb_0.a(lArray2);
        object = lArray3;
        double d4 = 0.0;
        double d5 = 0.0;
        for (n2 = 0; n2 < ((long[])object).length; ++n2) {
            for (int i3 = 0; i3 < ((long)object[n2]).length; ++i3) {
                d5 += (double)object[n2][i3];
            }
        }
        for (n2 = 0; n2 < ((long[])object).length; ++n2) {
            for (int i4 = 0; i4 < ((long)object[n2]).length; ++i4) {
                double d6;
                if (object[n2][i4] == 0L) continue;
                double d7 = d6 = (double)object[n2][i4] / d5;
                d4 += d7 * BY.k(d7);
            }
        }
        return d2 * 2.0 * (d3 - -d4);
    }

    public final double a(long l2, long l3, long l4, long l5) {
        double d2 = this.a(new long[]{l2, l3}, new long[]{l4, l5});
        double d3 = BY.a(d2);
        if ((double)l2 / (double)(l2 + l3) < (double)l4 / (double)(l4 + l5)) {
            d3 = -d3;
        }
        return d3;
    }

    public final double b(long[] lArray, long[] lArray2) {
        oi_0 oi_02 = new oi_0(null, (double)lArray.length - 1.0);
        return 1.0 - oi_02.e(this.a(lArray, lArray2));
    }

    public final boolean a(long[] lArray, long[] lArray2, double d2) {
        if (d2 <= 0.0 || d2 > 0.5) {
            throw new po_0(px_0.OUT_OF_BOUND_SIGNIFICANCE_LEVEL, (Number)d2, 0, 0.5);
        }
        return this.b(lArray, lArray2) < d2;
    }
}

