/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.nO;
import org.valkyrienskies.core.impl.shadow.uA;
import org.valkyrienskies.core.impl.shadow.uF;
import org.valkyrienskies.core.impl.shadow.vW;
import org.valkyrienskies.core.impl.shadow.vh_0;
import org.valkyrienskies.core.impl.shadow.vx_0;
import org.valkyrienskies.core.impl.shadow.wA;

public final class vV
extends vx_0 {
    private static final String f = "Gragg-Bulirsch-Stoer";
    private int g;
    private int[] m;
    private int[] n;
    private double[] o;
    private double[] p;
    private double[][] q;
    private boolean r;
    private int s;
    private int t;
    private double u;
    private double v;
    private double w;
    private double x;
    private double y;
    private double z;
    private double A;
    private boolean B;
    private int C;

    private vV(double d2, double d3, double d4, double d5) {
        super(f, d2, d3, d4, d5);
        this.a(true, -1, -1, -1.0);
        this.a(-1.0, -1.0, -1.0, -1.0);
        this.a(-1, -1.0, -1.0);
        this.a(true, -1);
    }

    private vV(double d2, double d3, double[] dArray, double[] dArray2) {
        super(f, d2, d3, dArray, dArray2);
        this.a(true, -1, -1, -1.0);
        this.a(-1.0, -1.0, -1.0, -1.0);
        this.a(-1, -1.0, -1.0);
        this.a(true, -1);
    }

    private void a(boolean bl, int n2, int n3, double d2) {
        this.r = true;
        this.t = 2;
        this.s = 1;
        this.u = 0.5;
    }

    private void a(double d2, double d3, double d4, double d5) {
        this.v = 0.65;
        this.w = 0.94;
        this.x = 0.02;
        this.y = 4.0;
    }

    private void a(int n2, double d2, double d3) {
        this.g = 18;
        this.z = 0.8;
        this.A = 0.9;
        this.n();
    }

    public final void a(wA wA2) {
        super.a(wA2);
        this.n();
    }

    public final void a(vh_0 vh_02, double d2, double d3, int n2, nO nO2) {
        super.a(vh_02, d2, d3, n2, nO2);
        this.n();
    }

    private void n() {
        int n2;
        int n3 = this.g / 2;
        if (this.m == null || this.m.length != n3) {
            this.m = new int[n3];
            this.n = new int[n3];
            this.q = new double[n3][];
            this.o = new double[n3];
            this.p = new double[n3];
        }
        for (n2 = 0; n2 < n3; ++n2) {
            this.m[n2] = 4 * n2 + 2;
        }
        this.n[0] = this.m[0] + 1;
        for (n2 = 1; n2 < n3; ++n2) {
            this.n[n2] = this.n[n2 - 1] + this.m[n2];
        }
        for (n2 = 0; n2 < n3; ++n2) {
            int n4 = n2;
            this.q[n4] = n4 > 0 ? new double[n2] : null;
            for (int i2 = 0; i2 < n2; ++i2) {
                double d2;
                double d3 = d2 = (double)this.m[n2] / (double)this.m[n2 - i2 - 1];
                this.q[n2][i2] = 1.0 / (d3 * d3 - 1.0);
            }
        }
    }

    private void a(boolean bl, int n2) {
        this.B = true;
        this.C = 4;
    }

    private void a(double[] dArray, double[] dArray2, double[] dArray3) {
        if (this.j == null) {
            for (int i2 = 0; i2 < dArray3.length; ++i2) {
                double d2 = BY.e(BY.w(dArray[i2]), BY.w(dArray2[i2]));
                dArray3[i2] = this.h + this.i * d2;
            }
            return;
        }
        for (int i3 = 0; i3 < dArray3.length; ++i3) {
            double d3 = BY.e(BY.w(dArray[i3]), BY.w(dArray2[i3]));
            dArray3[i3] = this.j[i3] + this.k[i3] * d3;
        }
    }

    private boolean a(double d2, double[] dArray, double d3, int n2, double[] dArray2, double[][] dArray3, double[] dArray4, double[] dArray5, double[] dArray6) {
        int n3;
        int n4 = this.m[n2];
        double d4 = d3 / (double)n4;
        double d5 = d4 * 2.0;
        double d6 = d2 + d4;
        for (n3 = 0; n3 < dArray.length; ++n3) {
            dArray6[n3] = dArray[n3];
            dArray5[n3] = dArray[n3] + d4 * dArray3[0][n3];
        }
        this.a(d6, dArray5, dArray3[1]);
        for (n3 = 1; n3 < n4; ++n3) {
            if (2 * n3 == n4) {
                System.arraycopy(dArray5, 0, dArray4, 0, dArray.length);
            }
            d6 += d4;
            for (int i2 = 0; i2 < dArray.length; ++i2) {
                double d7 = dArray5[i2];
                dArray5[i2] = dArray6[i2] + d5 * dArray3[n3][i2];
                dArray6[i2] = d7;
            }
            this.a(d6, dArray5, dArray3[n3 + 1]);
            if (!this.r || n3 > this.s || n2 >= this.t) continue;
            double d8 = 0.0;
            for (int i3 = 0; i3 < dArray2.length; ++i3) {
                double d9;
                double d10 = d9 = dArray3[0][i3] / dArray2[i3];
                d8 += d10 * d10;
            }
            double d11 = 0.0;
            for (int i4 = 0; i4 < dArray2.length; ++i4) {
                double d12;
                double d13 = d12 = (dArray3[n3 + 1][i4] - dArray3[0][i4]) / dArray2[i4];
                d11 += d13 * d13;
            }
            if (!(d11 > 4.0 * BY.e(1.0E-15, d8))) continue;
            return false;
        }
        for (n3 = 0; n3 < dArray.length; ++n3) {
            dArray5[n3] = 0.5 * (dArray6[n3] + dArray5[n3] + d4 * dArray3[n4][n3]);
        }
        return true;
    }

    private void a(int n2, int n3, double[][] dArray, double[] dArray2) {
        int n4;
        for (n4 = 1; n4 < n3; ++n4) {
            for (int i2 = 0; i2 < dArray2.length; ++i2) {
                dArray[n3 - n4 - 1][i2] = dArray[n3 - n4][i2] + this.q[n3 + n2][n4 - 1] * (dArray[n3 - n4][i2] - dArray[n3 - n4 - 1][i2]);
            }
        }
        for (n4 = 0; n4 < dArray2.length; ++n4) {
            dArray2[n4] = dArray[0][n4] + this.q[n3 + n2][n3 - 1] * (dArray[0][n4] - dArray2[n4]);
        }
    }

    public final void a(uF uF2, double d2) {
        uF uF3;
        ((uA)this).b(uF2, d2);
        this.a(uF2);
        uF uF4 = uF2;
        boolean bl = d2 > uF3.c;
        double[] dArray = uF2.g();
        double[] dArray2 = (double[])dArray.clone();
        double[] dArray3 = new double[dArray2.length];
        double[] dArray4 = new double[dArray2.length];
        double[] dArray5 = new double[dArray2.length];
        double[] dArray6 = new double[dArray2.length];
        double[][] dArrayArray = new double[this.m.length - 1][];
        double[][] dArrayArray2 = new double[this.m.length - 1][];
        for (int i2 = 0; i2 < this.m.length - 1; ++i2) {
            dArrayArray[i2] = new double[dArray2.length];
            dArrayArray2[i2] = new double[dArray2.length];
        }
        double[][][] dArrayArray3 = new double[this.m.length][][];
        for (int i3 = 0; i3 < this.m.length; ++i3) {
            dArrayArray3[i3] = new double[this.m[i3] + 1][];
            dArrayArray3[i3][0] = dArray3;
            for (int i4 = 0; i4 < this.m[i3]; ++i4) {
                dArrayArray3[i3][i4 + 1] = new double[dArray.length];
            }
        }
        if (dArray2 != dArray) {
            System.arraycopy(dArray, 0, dArray2, 0, dArray.length);
        }
        double[] dArray7 = new double[dArray.length];
        double[][] dArray8 = new double[1 + 2 * this.m.length][dArray.length];
        double[] dArray9 = new double[this.l];
        this.a(dArray2, dArray2, dArray9);
        double d3 = this.k == null ? this.i : this.k[0];
        double d4 = BY.m(BY.e(1.0E-10, d3));
        int n2 = BY.b(1, BY.a(this.m.length - 2, (int)BY.y(0.5 - d4 * 0.6)));
        uF4 = uF2;
        vW vW2 = new vW(dArray2, dArray3, dArray4, dArray7, dArray8, bl, uF4.b, uF2.d());
        uF4 = uF2;
        vW2.a(uF4.c);
        uF4 = uF2;
        this.a = uF4.c;
        double d5 = 0.0;
        double d6 = Double.MAX_VALUE;
        boolean bl2 = false;
        int n3 = 1;
        boolean bl3 = true;
        boolean bl4 = false;
        uF4 = uF2;
        this.a(uF4.c, dArray, d2);
        this.o[0] = 0.0;
        this.c = false;
        do {
            double d7;
            boolean bl5 = false;
            if (bl3) {
                vW2.c();
                if (!bl4) {
                    vV vV2 = this;
                    vV2.a(vV2.a, dArray2, dArray3);
                }
                if (n3 != 0) {
                    d5 = this.a(bl, 2 * n2 + 1, dArray9, this.a, dArray2, dArray3, dArray5, dArray6);
                }
                bl3 = false;
            }
            this.b = d5;
            if (bl && this.a + this.b > d2 || !bl && this.a + this.b < d2) {
                this.b = d2 - this.a;
            }
            double d8 = this.a + this.b;
            this.c = bl ? d8 >= d2 : d8 <= d2;
            int n4 = -1;
            boolean bl6 = true;
            block9: while (bl6) {
                boolean bl7;
                block66: {
                    int n5;
                    vV vV3;
                    double[][] dArray10 = dArrayArray3[++n4];
                    double[] dArray11 = dArray5;
                    double[] dArray12 = n4 == 0 ? dArray4 : dArrayArray2[n4 - 1];
                    double[] dArray13 = n4 == 0 ? dArray8[0] : dArrayArray[n4 - 1];
                    double[][] dArray14 = dArray10;
                    double[] dArray15 = dArray9;
                    int n6 = n4;
                    double d9 = this.b;
                    double[] dArray16 = dArray2;
                    double d10 = this.a;
                    int n7 = vV3.m[n6];
                    double d11 = d9 / (double)n7;
                    double d12 = d11 * 2.0;
                    double d13 = d10 + d11;
                    for (n5 = 0; n5 < dArray16.length; ++n5) {
                        dArray11[n5] = dArray16[n5];
                        dArray12[n5] = dArray16[n5] + d11 * dArray14[0][n5];
                    }
                    vV3.a(d13, dArray12, dArray14[1]);
                    for (n5 = 1; n5 < n7; ++n5) {
                        if (2 * n5 == n7) {
                            System.arraycopy(dArray12, 0, dArray13, 0, dArray16.length);
                        }
                        d13 += d11;
                        for (int i5 = 0; i5 < dArray16.length; ++i5) {
                            double d14 = dArray12[i5];
                            dArray12[i5] = dArray11[i5] + d12 * dArray14[n5][i5];
                            dArray11[i5] = d14;
                        }
                        vV3.a(d13, dArray12, dArray14[n5 + 1]);
                        if (!vV3.r || n5 > vV3.s || n6 >= vV3.t) continue;
                        double d15 = 0.0;
                        for (int i6 = 0; i6 < dArray15.length; ++i6) {
                            double d16;
                            double d17 = d16 = dArray14[0][i6] / dArray15[i6];
                            d15 += d17 * d17;
                        }
                        double d18 = 0.0;
                        for (int i7 = 0; i7 < dArray15.length; ++i7) {
                            double d19;
                            double d20 = d19 = (dArray14[n5 + 1][i7] - dArray14[0][i7]) / dArray15[i7];
                            d18 += d20 * d20;
                        }
                        if (!(d18 > 4.0 * BY.e(1.0E-15, d15))) continue;
                        bl7 = false;
                        break block66;
                    }
                    for (n5 = 0; n5 < dArray16.length; ++n5) {
                        dArray12[n5] = 0.5 * (dArray11[n5] + dArray12[n5] + d11 * dArray14[n7][n5]);
                    }
                    bl7 = true;
                }
                if (!bl7) {
                    vV vV4 = this;
                    d5 = BY.w(vV4.a(vV4.b * this.u, bl, false));
                    bl5 = true;
                    bl6 = false;
                    continue;
                }
                if (n4 <= 0) continue;
                this.a(0, n4, dArrayArray2, dArray4);
                this.a(dArray2, dArray4, dArray9);
                double d21 = 0.0;
                for (int i8 = 0; i8 < this.l; ++i8) {
                    double d22;
                    double d23 = d22 = BY.w(dArray4[i8] - dArrayArray2[0][i8]) / dArray9[i8];
                    d21 += d23 * d23;
                }
                if ((d21 = BY.a(d21 / (double)this.l)) > 1.0E15 || n4 > 1 && d21 > d6) {
                    vV vV5 = this;
                    d5 = BY.w(vV5.a(vV5.b * this.u, bl, false));
                    bl5 = true;
                    bl6 = false;
                    continue;
                }
                d6 = BY.e(d21 * 4.0, 1.0);
                double d24 = 1.0 / (double)(2 * n4 + 1);
                double d25 = this.w / BY.a(d21 / this.v, d24);
                d7 = BY.a(this.x, d24);
                d25 = BY.e(d7 / this.y, BY.d(1.0 / d7, d25));
                vV vV6 = this;
                this.p[n4] = BY.w(vV6.a(vV6.b * d25, bl, true));
                this.o[n4] = (double)this.n[n4] / this.p[n4];
                switch (n4 - n2) {
                    case -1: {
                        double d26;
                        if (n2 <= 1 || bl2) continue block9;
                        if (d21 <= 1.0) {
                            bl6 = false;
                            continue block9;
                        }
                        double d27 = d26 = (double)this.m[n2] * (double)this.m[n2 + 1] / (double)(this.m[0] * this.m[0]);
                        if (!(d21 > d27 * d27)) continue block9;
                        bl5 = true;
                        bl6 = false;
                        n2 = n4;
                        if (n2 > 1 && this.o[n2 - 1] < this.z * this.o[n2]) {
                            --n2;
                        }
                        d5 = this.p[n2];
                        continue block9;
                    }
                    case 0: {
                        double d26;
                        if (d21 <= 1.0) {
                            bl6 = false;
                            continue block9;
                        }
                        double d28 = d26 = (double)this.m[n4 + 1] / (double)this.m[0];
                        if (!(d21 > d28 * d28)) continue block9;
                        bl5 = true;
                        bl6 = false;
                        if (n2 > 1 && this.o[n2 - 1] < this.z * this.o[n2]) {
                            --n2;
                        }
                        d5 = this.p[n2];
                        continue block9;
                    }
                    case 1: {
                        if (d21 > 1.0) {
                            bl5 = true;
                            if (n2 > 1 && this.o[n2 - 1] < this.z * this.o[n2]) {
                                --n2;
                            }
                            d5 = this.p[n2];
                        }
                        bl6 = false;
                        continue block9;
                    }
                }
                if (n3 == 0 && !this.c || !(d21 <= 1.0)) continue;
                bl6 = false;
            }
            if (!bl5) {
                vV vV7 = this;
                vV7.a(vV7.a + this.b, dArray4, dArray7);
            }
            double d29 = this.m();
            if (!bl5) {
                int n8;
                for (n8 = 1; n8 <= n4; ++n8) {
                    this.a(0, n8, dArrayArray, dArray8[0]);
                }
                n8 = 2 * n4 - this.C + 3;
                for (int i9 = 0; i9 < n8; ++i9) {
                    int n9;
                    int n10 = i9 / 2;
                    d7 = BY.a(0.5 * (double)this.m[n10], i9);
                    int n11 = dArrayArray3[n10].length / 2;
                    for (n9 = 0; n9 < dArray.length; ++n9) {
                        dArray8[i9 + 1][n9] = d7 * dArrayArray3[n10][n11 + i9][n9];
                    }
                    for (n9 = 1; n9 <= n4 - n10; ++n9) {
                        d7 = BY.a(0.5 * (double)this.m[n9 + n10], i9);
                        n11 = dArrayArray3[n10 + n9].length / 2;
                        for (n3 = 0; n3 < dArray.length; ++n3) {
                            dArrayArray[n9 - 1][n3] = d7 * dArrayArray3[n10 + n9][n11 + i9][n3];
                        }
                        this.a(n10, n9, dArrayArray, dArray8[i9 + 1]);
                    }
                    n9 = 0;
                    while (n9 < dArray.length) {
                        double[] dArray17 = dArray8[i9 + 1];
                        int n12 = n9++;
                        dArray17[n12] = dArray17[n12] * this.b;
                    }
                    for (n9 = (i9 + 1) / 2; n9 <= n4; ++n9) {
                        for (n3 = dArrayArray3[n9].length - 1; n3 >= 2 * (i9 + 1); --n3) {
                            for (int i10 = 0; i10 < dArray.length; ++i10) {
                                double[] dArray18 = dArrayArray3[n9][n3];
                                int n13 = i10;
                                dArray18[n13] = dArray18[n13] - dArrayArray3[n9][n3 - 2][i10];
                            }
                        }
                    }
                }
                if (n8 >= 0) {
                    vW vW3 = vW2;
                    vW3.a(n8, this.b);
                    if (this.B) {
                        double[] dArray19 = dArray9;
                        vW vW4 = vW3;
                        double d30 = 0.0;
                        if (vW4.c >= 5) {
                            for (int i11 = 0; i11 < dArray19.length; ++i11) {
                                double d31;
                                double d32 = d31 = vW4.a[vW4.c][i11] / dArray19[i11];
                                d30 += d32 * d32;
                            }
                            d30 = BY.a(d30 / (double)dArray19.length) * vW4.b[vW4.c - 5];
                        }
                        double d33 = d30;
                        d29 = BY.w(this.b / BY.e(BY.a(d33, 1.0 / (double)(n8 + 4)), 0.01));
                        if (d33 > 10.0) {
                            d5 = d29;
                            bl5 = true;
                        }
                    }
                }
            }
            if (!bl5) {
                int n14;
                vW2.a(this.a + this.b);
                this.a = this.a(vW2, dArray4, dArray7, d2);
                vW2.a(this.a);
                System.arraycopy(dArray4, 0, dArray2, 0, dArray.length);
                System.arraycopy(dArray7, 0, dArray3, 0, dArray.length);
                bl4 = true;
                if (n4 == 1) {
                    n14 = 2;
                    if (bl2) {
                        n14 = 1;
                    }
                } else if (n4 <= n2) {
                    n14 = n4;
                    if (this.o[n4 - 1] < this.z * this.o[n4]) {
                        n14 = n4 - 1;
                    } else if (this.o[n4] < this.A * this.o[n4 - 1]) {
                        n14 = BY.a(n4 + 1, this.m.length - 2);
                    }
                } else {
                    n14 = n4 - 1;
                    if (n4 > 2 && this.o[n4 - 2] < this.z * this.o[n4 - 1]) {
                        n14 = n4 - 2;
                    }
                    if (this.o[n4] < this.A * this.o[n14]) {
                        n14 = BY.a(n4, this.m.length - 2);
                    }
                }
                if (bl2) {
                    n2 = BY.a(n14, n4);
                    d5 = BY.d(BY.w(this.b), this.p[n2]);
                } else {
                    if (n14 <= n4) {
                        d5 = this.p[n14];
                    } else if (n4 < n2 && this.o[n4] < this.A * this.o[n4 - 1]) {
                        vV vV8 = this;
                        d5 = vV8.a(vV8.p[n4] * (double)this.n[n14 + 1] / (double)this.n[n4], bl, false);
                    } else {
                        vV vV9 = this;
                        d5 = vV9.a(vV9.p[n4] * (double)this.n[n14] / (double)this.n[n4], bl, false);
                    }
                    n2 = n14;
                }
                bl3 = true;
            }
            d5 = BY.d(d5, d29);
            if (!bl) {
                d5 = -d5;
            }
            n3 = 0;
            if (bl5) {
                this.c = false;
                bl2 = true;
                continue;
            }
            bl2 = false;
        } while (!this.c);
        double d34 = this.a;
        uF4 = uF2;
        uF2.c = d34;
        uF2.b(dArray2);
        this.l();
    }
}

