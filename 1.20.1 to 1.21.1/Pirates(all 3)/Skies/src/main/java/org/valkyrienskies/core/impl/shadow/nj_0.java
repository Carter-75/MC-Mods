/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.valkyrienskies.core.impl.shadow.Ch
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.Ch;
import org.valkyrienskies.core.impl.shadow.ch_0;
import org.valkyrienskies.core.impl.shadow.lc_0;
import org.valkyrienskies.core.impl.shadow.oS;
import org.valkyrienskies.core.impl.shadow.pn_0;
import org.valkyrienskies.core.impl.shadow.pw_0;
import org.valkyrienskies.core.impl.shadow.px_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.nj
 */
public final class nj_0
implements lc_0 {
    private double[] a;
    private final double[] b;
    private final double[] c;
    private boolean d;

    public nj_0(double[] dArray, double[] dArray2) {
        this.b = new double[dArray.length];
        this.c = new double[dArray2.length];
        System.arraycopy(dArray, 0, this.b, 0, dArray.length);
        System.arraycopy(dArray2, 0, this.c, 0, dArray2.length);
        this.d = false;
        if (!nj_0.a(dArray, dArray2, false)) {
            Ch.a((double[])this.b, (double[][])new double[][]{this.c});
            nj_0.a(this.b, this.c, true);
        }
    }

    public final double a(double d2) {
        return nj_0.b(this.b, this.c, d2);
    }

    private int a() {
        return this.b.length - 1;
    }

    private double[] b() {
        double[] dArray = new double[this.b.length];
        System.arraycopy(this.b, 0, dArray, 0, this.b.length);
        return dArray;
    }

    private double[] c() {
        double[] dArray = new double[this.c.length];
        System.arraycopy(this.c, 0, dArray, 0, this.c.length);
        return dArray;
    }

    private double[] d() {
        Object object;
        if (!this.d) {
            int n2;
            object = this;
            nj_0 nj_02 = object;
            int n3 = ((nj_0)object).b.length - 1 + 1;
            ((nj_0)object).a = new double[n3];
            for (int i2 = 0; i2 < n3; ++i2) {
                ((nj_0)object).a[i2] = 0.0;
            }
            double[] dArray = new double[n3 + 1];
            double[] dArray2 = dArray;
            dArray[0] = 1.0;
            for (int i3 = 0; i3 < n3; ++i3) {
                for (n2 = i3; n2 > 0; --n2) {
                    dArray2[n2] = dArray2[n2 - 1] - dArray2[n2] * ((nj_0)object).b[i3];
                }
                dArray2[0] = dArray2[0] * -((nj_0)object).b[i3];
                dArray2[i3 + 1] = 1.0;
            }
            double[] dArray3 = new double[n3];
            for (n2 = 0; n2 < n3; ++n2) {
                double d2 = 1.0;
                for (int i4 = 0; i4 < n3; ++i4) {
                    if (n2 == i4) continue;
                    d2 *= ((nj_0)object).b[n2] - ((nj_0)object).b[i4];
                }
                double d3 = ((nj_0)object).c[n2] / d2;
                dArray3[n3 - 1] = dArray2[n3];
                int n4 = n3 - 1;
                ((nj_0)object).a[n4] = ((nj_0)object).a[n4] + d3 * dArray3[n3 - 1];
                for (int i5 = n3 - 2; i5 >= 0; --i5) {
                    dArray3[i5] = dArray2[i5 + 1] + dArray3[i5 + 1] * ((nj_0)object).b[n2];
                    int n5 = i5;
                    ((nj_0)object).a[n5] = ((nj_0)object).a[n5] + d3 * dArray3[i5];
                }
            }
            ((nj_0)object).d = true;
        }
        object = new double[this.a.length];
        System.arraycopy(this.a, 0, object, 0, this.a.length);
        return object;
    }

    private static double a(double[] dArray, double[] dArray2, double d2) {
        if (nj_0.a(dArray, dArray2, false)) {
            return nj_0.b(dArray, dArray2, d2);
        }
        double[] dArray3 = new double[dArray.length];
        double[] dArray4 = new double[dArray2.length];
        System.arraycopy(dArray, 0, dArray3, 0, dArray.length);
        System.arraycopy(dArray2, 0, dArray4, 0, dArray2.length);
        Ch.a((double[])dArray3, (double[][])new double[][]{dArray4});
        nj_0.a(dArray3, dArray4, true);
        return nj_0.b(dArray3, dArray4, d2);
    }

    private static double b(double[] dArray, double[] dArray2, double d2) {
        int n2 = 0;
        int n3 = dArray.length;
        double[] dArray3 = new double[n3];
        double[] dArray4 = new double[n3];
        double d3 = Double.POSITIVE_INFINITY;
        for (int i2 = 0; i2 < n3; ++i2) {
            double d4;
            dArray3[i2] = dArray2[i2];
            dArray4[i2] = dArray2[i2];
            double d5 = BY.w(d2 - dArray[i2]);
            if (!(d4 < d3)) continue;
            n2 = i2;
            d3 = d5;
        }
        double d6 = dArray2[n2];
        for (int i3 = 1; i3 < n3; ++i3) {
            for (int i4 = 0; i4 < n3 - i3; ++i4) {
                double d7 = dArray[i4] - d2;
                double d8 = dArray[i3 + i4] - d2;
                double d9 = dArray[i4] - dArray[i3 + i4];
                double d10 = (dArray3[i4 + 1] - dArray4[i4]) / d9;
                dArray3[i4] = d7 * d10;
                dArray4[i4] = d8 * d10;
            }
            if ((double)n2 < 0.5 * (double)(n3 - i3 + 1)) {
                d6 += dArray3[n2];
                continue;
            }
            d6 += dArray4[--n2];
        }
        return d6;
    }

    private void e() {
        int n2;
        nj_0 nj_02 = this;
        int n3 = nj_02.b.length - 1 + 1;
        this.a = new double[n3];
        for (int i2 = 0; i2 < n3; ++i2) {
            this.a[i2] = 0.0;
        }
        double[] dArray = new double[n3 + 1];
        double[] dArray2 = dArray;
        dArray[0] = 1.0;
        for (int i3 = 0; i3 < n3; ++i3) {
            for (n2 = i3; n2 > 0; --n2) {
                dArray2[n2] = dArray2[n2 - 1] - dArray2[n2] * this.b[i3];
            }
            dArray2[0] = dArray2[0] * -this.b[i3];
            dArray2[i3 + 1] = 1.0;
        }
        double[] dArray3 = new double[n3];
        for (n2 = 0; n2 < n3; ++n2) {
            double d2 = 1.0;
            for (int i4 = 0; i4 < n3; ++i4) {
                if (n2 == i4) continue;
                d2 *= this.b[n2] - this.b[i4];
            }
            double d3 = this.c[n2] / d2;
            dArray3[n3 - 1] = dArray2[n3];
            int n4 = n3 - 1;
            this.a[n4] = this.a[n4] + d3 * dArray3[n3 - 1];
            for (int i5 = n3 - 2; i5 >= 0; --i5) {
                dArray3[i5] = dArray2[i5 + 1] + dArray3[i5 + 1] * this.b[n2];
                int n5 = i5;
                this.a[n5] = this.a[n5] + d3 * dArray3[i5];
            }
        }
        this.d = true;
    }

    public static boolean a(double[] dArray, double[] dArray2, boolean bl) {
        if (dArray.length != dArray2.length) {
            throw new oS(dArray.length, dArray2.length);
        }
        if (dArray.length < 2) {
            throw new pn_0((pw_0)px_0.WRONG_NUMBER_OF_POINTS, (Number)2, dArray.length, true);
        }
        return Ch.a((double[])dArray, (int)ch_0.b.INCREASING$37efe540, (boolean)true, (boolean)bl);
    }
}

