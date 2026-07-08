/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import java.util.Arrays;
import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.ch_0;
import org.valkyrienskies.core.impl.shadow.po_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Bz
 */
public final class bz_0
implements Serializable {
    private static final int a = 0;
    private static final int b = 1;
    private static final int c = 2;
    private static final int d = 3;
    private static final int e = 4;
    private static final long f = 1L;
    private final double[] g;
    private final double[][] h;
    private final boolean i;
    private final int j;
    private final long k;
    private final boolean l;
    private final double[] m;

    private bz_0() {
        this.g = null;
        this.h = null;
        this.j = -1;
        this.k = -1L;
        this.l = false;
        this.i = false;
        this.m = null;
    }

    public bz_0(double[] dArray, double[][] dArray2, boolean bl, long l2, int n2, double d2, double d3, double d4, boolean bl2, boolean bl3) {
        this.g = dArray;
        this.h = dArray2;
        this.i = true;
        this.k = l2;
        this.j = n2;
        this.l = bl2;
        this.m = new double[5];
        Arrays.fill(this.m, Double.NaN);
        if (n2 > 0) {
            double d5;
            if (bl2) {
                double d6 = d2;
                d5 = d3 - d6 * d6 / (double)l2;
            } else {
                d5 = d3;
            }
            this.m[1] = d5;
        }
        this.m[0] = d4;
        this.m[3] = this.m[0] / (double)(l2 - (long)n2);
        this.m[2] = 1.0 - this.m[0] / this.m[1];
        if (!bl2) {
            this.m[4] = 1.0 - (1.0 - this.m[2]) * ((double)l2 / (double)(l2 - (long)n2));
            return;
        }
        this.m[4] = 1.0 - d4 * ((double)l2 - 1.0) / (this.m[1] * (double)(l2 - (long)n2));
    }

    private double a(int n2) {
        if (this.g == null) {
            return Double.NaN;
        }
        if (n2 < 0 || n2 >= this.g.length) {
            throw new po_0(n2, (Number)0, this.g.length - 1);
        }
        return this.g[n2];
    }

    private double[] a() {
        if (this.g == null) {
            return null;
        }
        double[] dArray = this.g;
        return ch_0.a(this.g, dArray.length);
    }

    private double b(int n2) {
        if (this.g == null) {
            return Double.NaN;
        }
        if (n2 < 0 || n2 >= this.g.length) {
            throw new po_0(n2, (Number)0, this.g.length - 1);
        }
        int n3 = n2;
        double d2 = this.b(n3, n3);
        if (!Double.isNaN(d2) && d2 > Double.MIN_VALUE) {
            return BY.a(d2);
        }
        return Double.NaN;
    }

    private double[] b() {
        if (this.g == null) {
            return null;
        }
        double[] dArray = new double[this.g.length];
        for (int i2 = 0; i2 < this.g.length; ++i2) {
            int n2 = i2;
            double d2 = this.b(n2, n2);
            dArray[i2] = !Double.isNaN(d2) && d2 > Double.MIN_VALUE ? BY.a(d2) : Double.NaN;
        }
        return dArray;
    }

    private double a(int n2, int n3) {
        if (this.g == null) {
            return Double.NaN;
        }
        if (n2 < 0 || n2 >= this.g.length) {
            throw new po_0(n2, (Number)0, this.g.length - 1);
        }
        if (n3 < 0 || n3 >= this.g.length) {
            throw new po_0(n3, (Number)0, this.g.length - 1);
        }
        return this.b(n2, n3);
    }

    private int c() {
        if (this.g == null) {
            return -1;
        }
        return this.g.length;
    }

    private long d() {
        return this.k;
    }

    private double e() {
        return this.m[1];
    }

    private double f() {
        return this.m[1] - this.m[0];
    }

    private double g() {
        return this.m[0];
    }

    private double h() {
        return this.m[3];
    }

    private double i() {
        return this.m[2];
    }

    private double j() {
        return this.m[4];
    }

    private boolean k() {
        return this.l;
    }

    private double b(int n2, int n3) {
        if (this.i) {
            if (this.h.length > 1) {
                if (n2 == n3) {
                    return this.h[n2][n2];
                }
                if (n2 >= this.h[n3].length) {
                    return this.h[n2][n3];
                }
                return this.h[n3][n2];
            }
            if (n2 > n3) {
                return this.h[0][(n2 + 1) * n2 / 2 + n3];
            }
            return this.h[0][(n3 + 1) * n3 / 2 + n2];
        }
        return this.h[n2][n3];
    }
}

