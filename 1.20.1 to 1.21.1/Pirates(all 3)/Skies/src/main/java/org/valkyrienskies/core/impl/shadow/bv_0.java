/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Arrays;
import org.valkyrienskies.core.impl.shadow.BB;
import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.bw_0;
import org.valkyrienskies.core.impl.shadow.bz_0;
import org.valkyrienskies.core.impl.shadow.ch_0;
import org.valkyrienskies.core.impl.shadow.cq_0;
import org.valkyrienskies.core.impl.shadow.px_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Bv
 */
public final class bv_0
implements BB {
    private final int a;
    private final double[] b;
    private final double[] c;
    private final double[] d;
    private final double[] e;
    private final double[] f;
    private final int[] g;
    private final double[] h;
    private long i = 0L;
    private double j = 0.0;
    private boolean k = false;
    private boolean l = false;
    private final boolean[] m;
    private final double[] n;
    private final double[] o;
    private double p = 0.0;
    private double q = 0.0;
    private boolean r;
    private final double s;

    private bv_0() {
        this(-1, false, Double.NaN);
    }

    private bv_0(int n2, boolean bl, double d2) {
        if (n2 <= 0) {
            throw new bw_0(px_0.NO_REGRESSORS, new Object[0]);
        }
        this.a = bl ? n2 + 1 : n2;
        this.r = bl;
        this.i = 0L;
        this.b = new double[this.a];
        this.c = new double[this.a];
        this.d = new double[this.a * (this.a - 1) / 2];
        this.e = new double[this.a];
        this.f = new double[this.a];
        this.g = new int[this.a];
        this.n = new double[this.a];
        this.o = new double[this.a];
        this.h = new double[this.a];
        this.m = new boolean[this.a];
        n2 = 0;
        while (n2 < this.a) {
            int n3 = n2++;
            this.g[n3] = n3;
        }
        if (d2 > 0.0) {
            this.s = d2;
            return;
        }
        this.s = -d2;
    }

    private bv_0(int n2, boolean bl) {
        this(n2, bl, cq_0.a);
    }

    public final boolean a() {
        return this.r;
    }

    public final long b() {
        return this.i;
    }

    public final void a(double[] dArray, double d2) {
        if (!this.r && dArray.length != this.a || this.r && dArray.length + 1 != this.a) {
            throw new bw_0(px_0.INVALID_REGRESSION_OBSERVATION, dArray.length, this.a);
        }
        if (!this.r) {
            this.a(ch_0.a(dArray, dArray.length), 1.0, d2);
        } else {
            double[] dArray2 = new double[dArray.length + 1];
            System.arraycopy(dArray, 0, dArray2, 1, dArray.length);
            dArray2[0] = 1.0;
            this.a(dArray2, 1.0, d2);
        }
        ++this.i;
    }

    public final void a(double[][] dArray, double[] dArray2) {
        if (dArray == null || dArray2 == null || dArray.length != dArray2.length) {
            throw new bw_0(px_0.DIMENSIONS_MISMATCH_SIMPLE, dArray == null ? 0 : dArray.length, dArray2 == null ? 0 : dArray2.length);
        }
        if (dArray.length == 0) {
            throw new bw_0(px_0.NO_DATA, new Object[0]);
        }
        if (dArray[0].length + 1 > dArray.length) {
            throw new bw_0(px_0.NOT_ENOUGH_DATA_FOR_NUMBER_OF_PREDICTORS, dArray.length, dArray[0].length);
        }
        for (int i2 = 0; i2 < dArray.length; ++i2) {
            double d2 = dArray2[i2];
            double[] dArray3 = dArray[i2];
            bv_0 bv_02 = this;
            if (!bv_02.r && dArray3.length != bv_02.a || bv_02.r && dArray3.length + 1 != bv_02.a) {
                throw new bw_0(px_0.INVALID_REGRESSION_OBSERVATION, dArray3.length, bv_02.a);
            }
            if (!bv_02.r) {
                bv_02.a(ch_0.a(dArray3, dArray3.length), 1.0, d2);
            } else {
                double[] dArray4 = new double[dArray3.length + 1];
                System.arraycopy(dArray3, 0, dArray4, 1, dArray3.length);
                dArray4[0] = 1.0;
                bv_02.a(dArray4, 1.0, d2);
            }
            ++bv_02.i;
        }
    }

    private void a(double[] dArray, double d2, double d3) {
        int n2 = 0;
        double d4 = d2;
        double d5 = d3;
        this.k = false;
        this.p = bv_0.a(d3, this.p);
        double d6 = d3;
        this.q = bv_0.a(this.q, d6 * d6);
        for (int i2 = 0; i2 < dArray.length; ++i2) {
            double d7;
            double d8;
            if (d4 == 0.0) {
                return;
            }
            double d9 = dArray[i2];
            if (d9 == 0.0) {
                n2 += this.a - i2 - 1;
                continue;
            }
            double d10 = this.b[i2];
            double d11 = d4 * d9;
            double d12 = d4;
            if (d10 != 0.0) {
                double d13;
                d8 = bv_0.a(d10, d11 * d9);
                double d14 = d11 * d9 / d10;
                if (BY.w(d13) > cq_0.a) {
                    d4 = d10 * d4 / d8;
                }
            } else {
                d8 = d11 * d9;
                d4 = 0.0;
            }
            this.b[i2] = d8;
            for (int i3 = i2 + 1; i3 < this.a; ++i3) {
                d7 = dArray[i3];
                dArray[i3] = bv_0.a(d7, -d9 * this.d[n2]);
                this.d[n2] = d10 != 0.0 ? bv_0.a(d10 * this.d[n2], d12 * d9 * d7) / d8 : d7 / d9;
                ++n2;
            }
            d7 = d5;
            d5 = bv_0.a(d7, -d9 * this.c[i2]);
            this.c[i2] = d10 != 0.0 ? bv_0.a(d10 * this.c[i2], d11 * d7) / d8 : d7 / d9;
        }
        this.j = bv_0.a(this.j, d4 * d5 * d5);
    }

    private static double a(double d2, double d3) {
        double d4;
        double d5 = BY.w(d2);
        if (d5 > (d4 = BY.w(d3))) {
            double d6 = d5 * cq_0.a;
            if (d4 > d6) {
                return d2 + d3;
            }
            return d2;
        }
        double d7 = d4 * cq_0.a;
        if (d5 > d7) {
            return d2 + d3;
        }
        return d3;
    }

    public final void c() {
        Arrays.fill(this.b, 0.0);
        Arrays.fill(this.c, 0.0);
        Arrays.fill(this.d, 0.0);
        Arrays.fill(this.e, 0.0);
        Arrays.fill(this.f, 0.0);
        Arrays.fill(this.h, 0.0);
        Arrays.fill(this.o, 0.0);
        Arrays.fill(this.n, 0.0);
        Arrays.fill(this.m, false);
        int n2 = 0;
        while (n2 < this.a) {
            int n3 = n2++;
            this.g[n3] = n3;
        }
        this.i = 0L;
        this.j = 0.0;
        this.p = 0.0;
        this.q = 0.0;
        this.k = false;
        this.l = false;
    }

    private void e() {
        int n2;
        double d2 = this.s;
        for (n2 = 0; n2 < this.a; ++n2) {
            this.h[n2] = BY.a(this.b[n2]);
        }
        this.e[0] = d2 * this.h[0];
        for (n2 = 1; n2 < this.a; ++n2) {
            int n3 = n2 - 1;
            double d3 = this.h[n2];
            for (int i2 = 0; i2 < n2; ++i2) {
                d3 += BY.w(this.d[n3]) * this.h[i2];
                n3 += this.a - i2 - 2;
            }
            this.e[n2] = d2 * d3;
        }
        this.l = true;
    }

    private double[] a(int n2) {
        int n3;
        if (n2 <= 0) {
            throw new bw_0(px_0.NO_REGRESSORS, new Object[0]);
        }
        if (n2 > this.a) {
            throw new bw_0(px_0.TOO_MANY_REGRESSORS, n2, this.a);
        }
        if (!this.l) {
            this.e();
        }
        double[] dArray = new double[n2];
        boolean bl = false;
        for (n3 = n2 - 1; n3 >= 0; --n3) {
            if (BY.a(this.b[n3]) < this.e[n3]) {
                dArray[n3] = 0.0;
                this.b[n3] = 0.0;
                bl = true;
                continue;
            }
            dArray[n3] = this.c[n3];
            int n4 = n3 * (this.a + this.a - n3 - 1) / 2;
            for (int i2 = n3 + 1; i2 < n2; ++i2) {
                dArray[n3] = bv_0.a(dArray[n3], -this.d[n4] * dArray[i2]);
                ++n4;
            }
        }
        if (bl) {
            for (n3 = 0; n3 < n2; ++n3) {
                if (!this.m[n3]) continue;
                dArray[n3] = Double.NaN;
            }
        }
        return dArray;
    }

    private void f() {
        int n2;
        for (n2 = 0; n2 < this.a; ++n2) {
            this.o[n2] = BY.a(this.b[n2]);
        }
        for (n2 = 0; n2 < this.a; ++n2) {
            int n3;
            double d2 = this.e[n2];
            int n4 = n2 - 1;
            for (n3 = 0; n3 < n2 - 1; ++n3) {
                if (BY.w(this.d[n4]) * this.o[n3] < d2) {
                    this.d[n4] = 0.0;
                }
                n4 += this.a - n3 - 2;
            }
            this.m[n2] = false;
            if (!(this.o[n2] < d2)) continue;
            this.m[n2] = true;
            if (n2 < this.a - 1) {
                Arrays.fill(this.n, 0.0);
                n3 = n2 * (this.a + this.a - n2 - 1) / 2;
                int n5 = n2 + 1;
                while (n5 < this.a) {
                    this.n[n5] = this.d[n3];
                    this.d[n3] = 0.0;
                    ++n5;
                    ++n3;
                }
                double d3 = this.c[n2];
                double d4 = this.b[n2];
                this.b[n2] = 0.0;
                this.c[n2] = 0.0;
                bv_0 bv_02 = this;
                bv_02.a(bv_02.n, d4, d3);
                continue;
            }
            this.j += this.b[n2] * this.c[n2] * this.c[n2];
        }
    }

    private void g() {
        double d2 = this.j;
        this.f[this.a - 1] = this.j;
        for (int i2 = this.a - 1; i2 > 0; --i2) {
            this.f[i2 - 1] = d2 += this.b[i2] * this.c[i2] * this.c[i2];
        }
        this.k = true;
    }

    private double[] b(int n2) {
        int n3;
        int n4;
        int n5;
        if (this.i <= (long)n2) {
            return null;
        }
        double d2 = 0.0;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (this.m[i2]) continue;
            d2 += 1.0;
        }
        double d3 = this.f[n2 - 1] / ((double)this.i - d2);
        int n6 = n2;
        double[] dArray = new double[n6 * (n6 - 1) / 2];
        int n7 = n2;
        double[] dArray2 = dArray;
        Object object = this;
        int n8 = n7;
        int n9 = n8 * (n8 - 1) / 2 - 1;
        Arrays.fill(dArray2, Double.NaN);
        for (int i3 = n7 - 1; i3 > 0; --i3) {
            if (!((bv_0)object).m[i3]) {
                int n10 = (i3 - 1) * (((bv_0)object).a + ((bv_0)object).a - i3) / 2;
                for (n5 = n7; n5 > i3; --n5) {
                    n4 = n10;
                    n3 = n9;
                    double d4 = 0.0;
                    for (int i4 = i3; i4 < n5 - 1; ++i4) {
                        n3 += n7 - i4 - 1;
                        if (!((bv_0)object).m[i4]) {
                            d4 += -((bv_0)object).d[n4] * dArray2[n3];
                        }
                        ++n4;
                    }
                    dArray2[n9] = d4 - ((bv_0)object).d[n4];
                    --n9;
                }
                continue;
            }
            n9 -= n7 - i3;
        }
        int n11 = n2;
        double[] dArray3 = new double[n11 * (n11 + 1) / 2];
        object = dArray3;
        Arrays.fill(dArray3, Double.NaN);
        n9 = 0;
        for (n4 = 0; n4 < n2; ++n4) {
            int n12 = n9;
            if (!this.m[n4]) {
                for (n3 = n4; n3 < n2; ++n3) {
                    if (!this.m[n3]) {
                        n7 = n9 + n3 - n4;
                        double d5 = n4 == n3 ? 1.0 / this.b[n3] : dArray[n7 - 1] / this.b[n3];
                        for (n5 = n3 + 1; n5 < n2; ++n5) {
                            if (!this.m[n5]) {
                                d5 += dArray[n7] * dArray[n12] / this.b[n5];
                            }
                            ++n7;
                            ++n12;
                        }
                        object[(n3 + 1) * n3 / 2 + n4] = d5 * d3;
                        continue;
                    }
                    n12 += n2 - n3 - 1;
                }
            }
            n9 += n2 - n4 - 1;
        }
        return object;
    }

    private void a(double[] dArray, int n2) {
        int n3 = n2;
        int n4 = n3 * (n3 - 1) / 2 - 1;
        Arrays.fill(dArray, Double.NaN);
        for (int i2 = n2 - 1; i2 > 0; --i2) {
            if (!this.m[i2]) {
                int n5 = (i2 - 1) * (this.a + this.a - i2) / 2;
                for (int i3 = n2; i3 > i2; --i3) {
                    int n6 = n5;
                    int n7 = n4;
                    double d2 = 0.0;
                    for (int i4 = i2; i4 < i3 - 1; ++i4) {
                        n7 += n2 - i4 - 1;
                        if (!this.m[i4]) {
                            d2 += -this.d[n6] * dArray[n7];
                        }
                        ++n6;
                    }
                    dArray[n4] = d2 - this.d[n6];
                    --n4;
                }
                continue;
            }
            n4 -= n2 - i2;
        }
    }

    private double[] c(int n2) {
        int n3;
        int n4;
        double[] dArray = new double[(this.a - n2 + 1) * (this.a - n2) / 2];
        int n5 = -n2;
        int n6 = -(n2 + 1);
        double[] dArray2 = new double[this.a - n2];
        double[] dArray3 = new double[this.a - n2 - 1];
        int n7 = (this.a - n2) * (this.a - n2 - 1) / 2;
        if (n2 < -1 || n2 >= this.a) {
            return null;
        }
        int n8 = this.a - 1;
        int n9 = this.d.length - (n8 - n2) * (n8 - n2 + 1) / 2;
        if (this.b[n2] > 0.0) {
            dArray2[n2 + n5] = 1.0 / BY.a(this.b[n2]);
        }
        for (n4 = n2 + 1; n4 < this.a; ++n4) {
            n8 = n9 + n4 - 1 - n2;
            double d2 = this.b[n4];
            for (n3 = n2; n3 < n4; ++n3) {
                d2 += this.b[n3] * this.d[n8] * this.d[n8];
                n8 += this.a - n3 - 2;
            }
            dArray2[n4 + n5] = d2 > 0.0 ? 1.0 / BY.a(d2) : 0.0;
        }
        double d3 = this.j;
        for (n4 = n2; n4 < this.a; ++n4) {
            d3 += this.b[n4] * this.c[n4] * this.c[n4];
        }
        if (d3 > 0.0) {
            d3 = 1.0 / BY.a(d3);
        }
        for (n4 = n2; n4 < this.a; ++n4) {
            int n10;
            double d4 = 0.0;
            Arrays.fill(dArray3, 0.0);
            n8 = n9 + n4 - n2 - 1;
            for (n3 = n2; n3 < n4; ++n3) {
                n10 = n8 + 1;
                for (int i2 = n4 + 1; i2 < this.a; ++i2) {
                    int n11 = i2 + n6;
                    dArray3[n11] = dArray3[n11] + this.b[n3] * this.d[n8] * this.d[n10];
                    ++n10;
                }
                d4 += this.b[n3] * this.d[n8] * this.c[n3];
                n8 += this.a - n3 - 2;
            }
            n10 = n8 + 1;
            for (n3 = n4 + 1; n3 < this.a; ++n3) {
                int n12 = n3 + n6;
                dArray3[n12] = dArray3[n12] + this.b[n4] * this.d[n10];
                ++n10;
                dArray[(n3 - 1 - n2) * (n3 - n2) / 2 + n4 - n2] = dArray3[n3 + n6] * dArray2[n4 + n5] * dArray2[n3 + n5];
            }
            dArray[n4 + n5 + n7] = (d4 += this.b[n4] * this.c[n4]) * dArray2[n4 + n5] * d3;
        }
        return dArray;
    }

    private void a(int n2, int n3) {
        int n4;
        int n5;
        int n6;
        boolean bl = false;
        if (n2 == n3) {
            return;
        }
        if (!this.k) {
            this.g();
        }
        if (n2 < n3) {
            n6 = n2;
            n5 = 1;
            n4 = n3 - n2;
        } else {
            n6 = n2 - 1;
            n5 = -1;
            n4 = n2 - n3;
        }
        int n7 = n6;
        for (int i2 = 0; i2 < n4; ++i2) {
            int n8;
            double d2;
            n2 = n7 * (this.a + this.a - n7 - 1) / 2;
            n3 = n2 + this.a - n7 - 1;
            int n9 = n7 + 1;
            double d3 = this.b[n7];
            double d4 = this.b[n9];
            if (d3 > this.s || d4 > this.s) {
                double d5;
                d2 = this.d[n2];
                if (BY.w(d5) * BY.a(d3) < this.e[n9]) {
                    d2 = 0.0;
                }
                if (d3 < this.s || BY.w(d2) < this.s) {
                    this.b[n7] = d4;
                    this.b[n9] = d3;
                    this.d[n2] = 0.0;
                    for (n8 = n7 + 2; n8 < this.a; ++n8) {
                        d2 = this.d[++n2];
                        this.d[n2] = this.d[n3];
                        this.d[n3] = d2;
                        ++n3;
                    }
                    d2 = this.c[n7];
                    this.c[n7] = this.c[n9];
                    this.c[n9] = d2;
                    bl = true;
                } else if (d4 < this.s) {
                    this.b[n7] = d3 * d2 * d2;
                    this.d[n2] = 1.0 / d2;
                    n8 = n2 + 1;
                    while (n8 < n2 + this.a - n7 - 1) {
                        int n10 = n8++;
                        this.d[n10] = this.d[n10] / d2;
                    }
                    int n11 = n7;
                    this.c[n11] = this.c[n11] / d2;
                    bl = true;
                }
                if (!bl) {
                    double d6;
                    double d7 = d4 + d3 * d2 * d2;
                    double d8 = d4 / d7;
                    double d9 = d2 * d3 / d7;
                    double d10 = d3 * d8;
                    this.b[n7] = d7;
                    this.b[n9] = d10;
                    this.d[n2] = d9;
                    for (n8 = n7 + 2; n8 < this.a; ++n8) {
                        d6 = this.d[++n2];
                        this.d[n2] = d8 * this.d[n3] + d9 * d6;
                        this.d[n3] = d6 - d2 * this.d[n3];
                        ++n3;
                    }
                    d6 = this.c[n7];
                    this.c[n7] = d8 * this.c[n9] + d9 * d6;
                    this.c[n9] = d6 - d2 * this.c[n9];
                }
            }
            if (n7 > 0) {
                n2 = n7;
                for (n8 = 0; n8 < n7; ++n8) {
                    d2 = this.d[n2];
                    this.d[n2] = this.d[n2 - 1];
                    this.d[n2 - 1] = d2;
                    n2 += this.a - n8 - 2;
                }
            }
            n2 = this.g[n7];
            this.g[n7] = this.g[n9];
            this.g[n9] = n2;
            d2 = this.e[n7];
            this.e[n7] = this.e[n9];
            this.e[n9] = d2;
            this.f[n7] = this.f[n9] + this.b[n9] * this.c[n9] * this.c[n9];
            n7 += n5;
        }
    }

    private int a(int[] nArray, int n2) {
        if (nArray.length <= 0 || nArray.length > this.a + 1) {
            return -1;
        }
        n2 = 0;
        block0: for (int i2 = 0; i2 < this.a; ++i2) {
            int n3 = this.g[i2];
            for (int i3 = 0; i3 < nArray.length; ++i3) {
                if (n3 != nArray[i3] || i2 <= n2) continue;
                int n4 = n2;
                i3 = i2;
                bv_0 bv_02 = this;
                boolean bl = false;
                if (i3 != n4) {
                    int n5;
                    int n6;
                    int n7;
                    if (!bv_02.k) {
                        bv_02.g();
                    }
                    if (i3 < n4) {
                        n7 = i3;
                        n6 = 1;
                        n5 = n4 - i3;
                    } else {
                        n7 = i3 - 1;
                        n6 = -1;
                        n5 = i3 - n4;
                    }
                    int n8 = n7;
                    for (int i4 = 0; i4 < n5; ++i4) {
                        int n9;
                        double d2;
                        i3 = n8 * (bv_02.a + bv_02.a - n8 - 1) / 2;
                        n4 = i3 + bv_02.a - n8 - 1;
                        n7 = n8 + 1;
                        double d3 = bv_02.b[n8];
                        double d4 = bv_02.b[n7];
                        if (d3 > bv_02.s || d4 > bv_02.s) {
                            double d5;
                            d2 = bv_02.d[i3];
                            if (BY.w(d5) * BY.a(d3) < bv_02.e[n7]) {
                                d2 = 0.0;
                            }
                            if (d3 < bv_02.s || BY.w(d2) < bv_02.s) {
                                bv_02.b[n8] = d4;
                                bv_02.b[n7] = d3;
                                bv_02.d[i3] = 0.0;
                                for (n9 = n8 + 2; n9 < bv_02.a; ++n9) {
                                    d2 = bv_02.d[++i3];
                                    bv_02.d[i3] = bv_02.d[n4];
                                    bv_02.d[n4] = d2;
                                    ++n4;
                                }
                                d2 = bv_02.c[n8];
                                bv_02.c[n8] = bv_02.c[n7];
                                bv_02.c[n7] = d2;
                                bl = true;
                            } else if (d4 < bv_02.s) {
                                bv_02.b[n8] = d3 * d2 * d2;
                                bv_02.d[i3] = 1.0 / d2;
                                n9 = i3 + 1;
                                while (n9 < i3 + bv_02.a - n8 - 1) {
                                    int n10 = n9++;
                                    bv_02.d[n10] = bv_02.d[n10] / d2;
                                }
                                int n11 = n8;
                                bv_02.c[n11] = bv_02.c[n11] / d2;
                                bl = true;
                            }
                            if (!bl) {
                                double d6;
                                double d7 = d4 + d3 * d2 * d2;
                                double d8 = d4 / d7;
                                double d9 = d2 * d3 / d7;
                                double d10 = d3 * d8;
                                bv_02.b[n8] = d7;
                                bv_02.b[n7] = d10;
                                bv_02.d[i3] = d9;
                                for (n9 = n8 + 2; n9 < bv_02.a; ++n9) {
                                    d6 = bv_02.d[++i3];
                                    bv_02.d[i3] = d8 * bv_02.d[n4] + d9 * d6;
                                    bv_02.d[n4] = d6 - d2 * bv_02.d[n4];
                                    ++n4;
                                }
                                d6 = bv_02.c[n8];
                                bv_02.c[n8] = d8 * bv_02.c[n7] + d9 * d6;
                                bv_02.c[n7] = d6 - d2 * bv_02.c[n7];
                            }
                        }
                        if (n8 > 0) {
                            i3 = n8;
                            for (n9 = 0; n9 < n8; ++n9) {
                                d2 = bv_02.d[i3];
                                bv_02.d[i3] = bv_02.d[i3 - 1];
                                bv_02.d[i3 - 1] = d2;
                                i3 += bv_02.a - n9 - 2;
                            }
                        }
                        i3 = bv_02.g[n8];
                        bv_02.g[n8] = bv_02.g[n7];
                        bv_02.g[n7] = i3;
                        d2 = bv_02.e[n8];
                        bv_02.e[n8] = bv_02.e[n7];
                        bv_02.e[n7] = d2;
                        bv_02.f[n8] = bv_02.f[n7] + bv_02.b[n7] * bv_02.c[n7] * bv_02.c[n7];
                        n8 += n6;
                    }
                }
                if (++n2 < nArray.length) continue block0;
                return 0;
            }
        }
        return 0;
    }

    private double a(double[] dArray) {
        double[] dArray2;
        double[] dArray3 = new double[this.a];
        if (dArray.length > this.a) {
            return Double.NaN;
        }
        if (this.r) {
            double[] dArray4 = new double[dArray.length + 1];
            dArray2 = dArray4;
            dArray4[0] = 1.0;
            System.arraycopy(dArray, 0, dArray2, 1, dArray.length);
        } else {
            dArray2 = dArray;
        }
        double d2 = 0.0;
        for (int i2 = 0; i2 < dArray2.length; ++i2) {
            if (BY.a(this.b[i2]) < this.e[i2]) {
                dArray3[i2] = 0.0;
                continue;
            }
            int n2 = i2 - 1;
            double d3 = dArray2[i2];
            for (int i3 = 0; i3 < i2; ++i3) {
                d3 = bv_0.a(d3, -dArray3[i3] * this.d[n2]);
                n2 += this.a - i3 - 2;
            }
            dArray3[i2] = d3;
            double d4 = d3;
            d2 = bv_0.a(d2, d4 * d4 / this.b[i2]);
        }
        return d2;
    }

    private int[] h() {
        int[] nArray = this.g;
        return ch_0.a(this.g, nArray.length);
    }

    public final bz_0 d() {
        int n2;
        int n3;
        int n4;
        bv_0 bv_02 = this;
        int n5 = bv_02.a;
        bv_0 bv_03 = bv_02;
        if (bv_02.i <= (long)n5) {
            throw new bw_0(px_0.NOT_ENOUGH_DATA_FOR_NUMBER_OF_PREDICTORS, bv_03.i, n5);
        }
        if (n5 > bv_03.a) {
            throw new bw_0(px_0.TOO_MANY_REGRESSORS, n5, bv_03.a);
        }
        bv_03.e();
        bv_03.f();
        double[] dArray = bv_03.a(n5);
        bv_03.g();
        double[] dArray2 = bv_03.b(n5);
        int n6 = 0;
        for (n4 = 0; n4 < bv_03.m.length; ++n4) {
            if (bv_03.m[n4]) continue;
            ++n6;
        }
        n4 = 0;
        for (int i2 = 0; i2 < n5; ++i2) {
            if (bv_03.g[i2] == i2) continue;
            n4 = 1;
            break;
        }
        if (n4 == 0) {
            return new bz_0(dArray, new double[][]{dArray2}, true, bv_03.i, n6, bv_03.p, bv_03.q, bv_03.j, bv_03.r, false);
        }
        double[] dArray3 = new double[dArray.length];
        double[] dArray4 = new double[dArray2.length];
        int[] nArray = new int[dArray.length];
        for (n3 = 0; n3 < bv_03.a; ++n3) {
            for (n2 = 0; n2 < n5; ++n2) {
                if (bv_03.g[n2] != n3) continue;
                dArray3[n3] = dArray[n2];
                nArray[n3] = n2;
            }
        }
        n3 = 0;
        for (int i3 = 0; i3 < dArray.length; ++i3) {
            n5 = nArray[i3];
            int n7 = 0;
            while (n7 <= i3) {
                n2 = nArray[n7];
                if (n5 > n2) {
                    int n8 = n5;
                    n2 = n8 * (n8 + 1) / 2 + n2;
                } else {
                    int n9 = n2;
                    n2 = n9 * (n9 + 1) / 2 + n5;
                }
                dArray4[n3] = dArray2[n2];
                ++n7;
                ++n3;
            }
        }
        return new bz_0(dArray3, new double[][]{dArray4}, true, bv_03.i, n6, bv_03.p, bv_03.q, bv_03.j, bv_03.r, false);
    }

    private bz_0 d(int n2) {
        int n3;
        int n4;
        int n5;
        if (this.i <= (long)n2) {
            throw new bw_0(px_0.NOT_ENOUGH_DATA_FOR_NUMBER_OF_PREDICTORS, this.i, n2);
        }
        if (n2 > this.a) {
            throw new bw_0(px_0.TOO_MANY_REGRESSORS, n2, this.a);
        }
        this.e();
        this.f();
        double[] dArray = this.a(n2);
        this.g();
        double[] dArray2 = this.b(n2);
        int n6 = 0;
        for (n5 = 0; n5 < this.m.length; ++n5) {
            if (this.m[n5]) continue;
            ++n6;
        }
        n5 = 0;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (this.g[i2] == i2) continue;
            n5 = 1;
            break;
        }
        if (n5 == 0) {
            return new bz_0(dArray, new double[][]{dArray2}, true, this.i, n6, this.p, this.q, this.j, this.r, false);
        }
        double[] dArray3 = new double[dArray.length];
        double[] dArray4 = new double[dArray2.length];
        int[] nArray = new int[dArray.length];
        for (n4 = 0; n4 < this.a; ++n4) {
            for (n3 = 0; n3 < n2; ++n3) {
                if (this.g[n3] != n4) continue;
                dArray3[n4] = dArray[n3];
                nArray[n4] = n3;
            }
        }
        n4 = 0;
        for (int i3 = 0; i3 < dArray.length; ++i3) {
            n2 = nArray[i3];
            int n7 = 0;
            while (n7 <= i3) {
                n3 = nArray[n7];
                if (n2 > n3) {
                    int n8 = n2;
                    n3 = n8 * (n8 + 1) / 2 + n3;
                } else {
                    int n9 = n3;
                    n3 = n9 * (n9 + 1) / 2 + n2;
                }
                dArray4[n4] = dArray2[n3];
                ++n7;
                ++n4;
            }
        }
        return new bz_0(dArray3, new double[][]{dArray4}, true, this.i, n6, this.p, this.q, this.j, this.r, false);
    }

    public final bz_0 a(int[] nArray) {
        int n2;
        int n3;
        int n4;
        int n5;
        int n6;
        int n7;
        int n8;
        int[] nArray2;
        int n9;
        if (nArray.length > this.a) {
            throw new bw_0(px_0.TOO_MANY_REGRESSORS, nArray.length, this.a);
        }
        if (this.i <= (long)this.a) {
            throw new bw_0(px_0.NOT_ENOUGH_DATA_FOR_NUMBER_OF_PREDICTORS, this.i, this.a);
        }
        Arrays.sort(nArray);
        int n10 = 0;
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            if (i2 >= this.a) {
                throw new bw_0(px_0.INDEX_LARGER_THAN_MAX, i2, this.a);
            }
            if (i2 <= 0 || nArray[i2] != nArray[i2 - 1]) continue;
            nArray[i2] = -1;
            ++n10;
        }
        if (n10 > 0) {
            n9 = 0;
            nArray2 = new int[nArray.length - n10];
            for (n10 = 0; n10 < nArray.length; ++n10) {
                if (nArray[n10] < 0) continue;
                nArray2[n9] = nArray[n10];
                ++n9;
            }
        } else {
            nArray2 = nArray;
        }
        boolean bl = false;
        Object[] objectArray = nArray2;
        bv_0 bv_02 = this;
        if (objectArray.length <= 0 || objectArray.length > bv_02.a + 1) {
            n8 = -1;
        } else {
            n9 = 0;
            block2: for (n7 = 0; n7 < bv_02.a; ++n7) {
                int n11 = bv_02.g[n7];
                for (n6 = 0; n6 < objectArray.length; ++n6) {
                    if (n11 != objectArray[n6] || n7 <= n9) continue;
                    n5 = n9;
                    n6 = n7;
                    bv_0 bv_03 = bv_02;
                    n4 = 0;
                    if (n6 != n5) {
                        int n12;
                        if (!bv_03.k) {
                            bv_03.g();
                        }
                        if (n6 < n5) {
                            n3 = n6;
                            n2 = 1;
                            n12 = n5 - n6;
                        } else {
                            n3 = n6 - 1;
                            n2 = -1;
                            n12 = n6 - n5;
                        }
                        int n13 = n3;
                        for (int i3 = 0; i3 < n12; ++i3) {
                            int n14;
                            double d2;
                            n6 = n13 * (bv_03.a + bv_03.a - n13 - 1) / 2;
                            n5 = n6 + bv_03.a - n13 - 1;
                            n3 = n13 + 1;
                            double d3 = bv_03.b[n13];
                            double d4 = bv_03.b[n3];
                            if (d3 > bv_03.s || d4 > bv_03.s) {
                                double d5;
                                d2 = bv_03.d[n6];
                                if (BY.w(d5) * BY.a(d3) < bv_03.e[n3]) {
                                    d2 = 0.0;
                                }
                                if (d3 < bv_03.s || BY.w(d2) < bv_03.s) {
                                    bv_03.b[n13] = d4;
                                    bv_03.b[n3] = d3;
                                    bv_03.d[n6] = 0.0;
                                    for (n14 = n13 + 2; n14 < bv_03.a; ++n14) {
                                        d2 = bv_03.d[++n6];
                                        bv_03.d[n6] = bv_03.d[n5];
                                        bv_03.d[n5] = d2;
                                        ++n5;
                                    }
                                    d2 = bv_03.c[n13];
                                    bv_03.c[n13] = bv_03.c[n3];
                                    bv_03.c[n3] = d2;
                                    n4 = 1;
                                } else if (d4 < bv_03.s) {
                                    bv_03.b[n13] = d3 * d2 * d2;
                                    bv_03.d[n6] = 1.0 / d2;
                                    n14 = n6 + 1;
                                    while (n14 < n6 + bv_03.a - n13 - 1) {
                                        int n15 = n14++;
                                        bv_03.d[n15] = bv_03.d[n15] / d2;
                                    }
                                    int n16 = n13;
                                    bv_03.c[n16] = bv_03.c[n16] / d2;
                                    n4 = 1;
                                }
                                if (n4 == 0) {
                                    double d6;
                                    double d7 = d4 + d3 * d2 * d2;
                                    double d8 = d4 / d7;
                                    double d9 = d2 * d3 / d7;
                                    double d10 = d3 * d8;
                                    bv_03.b[n13] = d7;
                                    bv_03.b[n3] = d10;
                                    bv_03.d[n6] = d9;
                                    for (n14 = n13 + 2; n14 < bv_03.a; ++n14) {
                                        d6 = bv_03.d[++n6];
                                        bv_03.d[n6] = d8 * bv_03.d[n5] + d9 * d6;
                                        bv_03.d[n5] = d6 - d2 * bv_03.d[n5];
                                        ++n5;
                                    }
                                    d6 = bv_03.c[n13];
                                    bv_03.c[n13] = d8 * bv_03.c[n3] + d9 * d6;
                                    bv_03.c[n3] = d6 - d2 * bv_03.c[n3];
                                }
                            }
                            if (n13 > 0) {
                                n6 = n13;
                                for (n14 = 0; n14 < n13; ++n14) {
                                    d2 = bv_03.d[n6];
                                    bv_03.d[n6] = bv_03.d[n6 - 1];
                                    bv_03.d[n6 - 1] = d2;
                                    n6 += bv_03.a - n14 - 2;
                                }
                            }
                            n6 = bv_03.g[n13];
                            bv_03.g[n13] = bv_03.g[n3];
                            bv_03.g[n3] = n6;
                            d2 = bv_03.e[n13];
                            bv_03.e[n13] = bv_03.e[n3];
                            bv_03.e[n3] = d2;
                            bv_03.f[n13] = bv_03.f[n3] + bv_03.b[n3] * bv_03.c[n3] * bv_03.c[n3];
                            n13 += n2;
                        }
                    }
                    if (++n9 < objectArray.length) continue block2;
                    break block2;
                }
            }
            n8 = 0;
        }
        this.e();
        this.f();
        double[] dArray = this.a(nArray2.length);
        this.g();
        objectArray = this.b(nArray2.length);
        int n17 = 0;
        for (n7 = 0; n7 < this.m.length; ++n7) {
            if (this.m[n7]) continue;
            ++n17;
        }
        n7 = 0;
        for (int i4 = 0; i4 < this.a; ++i4) {
            if (this.g[i4] == nArray2[i4]) continue;
            n7 = 1;
            break;
        }
        if (n7 == 0) {
            return new bz_0(dArray, new double[][]{objectArray}, true, this.i, n17, this.p, this.q, this.j, this.r, false);
        }
        double[] dArray2 = new double[dArray.length];
        int[] nArray3 = new int[dArray.length];
        for (n6 = 0; n6 < nArray2.length; ++n6) {
            for (n5 = 0; n5 < this.g.length; ++n5) {
                if (this.g[n5] != nArray2[n6]) continue;
                dArray2[n6] = dArray[n5];
                nArray3[n6] = n5;
            }
        }
        double[] dArray3 = new double[objectArray.length];
        n5 = 0;
        for (n2 = 0; n2 < dArray.length; ++n2) {
            n3 = nArray3[n2];
            n4 = 0;
            while (n4 <= n2) {
                int n18 = nArray3[n4];
                if (n3 > n18) {
                    int n19 = n3;
                    n18 = n19 * (n19 + 1) / 2 + n18;
                } else {
                    int n20 = n18;
                    n18 = n20 * (n20 + 1) / 2 + n3;
                }
                dArray3[n5] = objectArray[n18];
                ++n4;
                ++n5;
            }
        }
        return new bz_0(dArray2, new double[][]{dArray3}, true, this.i, n17, this.p, this.q, this.j, this.r, false);
    }
}

