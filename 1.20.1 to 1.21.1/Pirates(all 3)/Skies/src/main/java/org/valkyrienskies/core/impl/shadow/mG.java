/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Arrays;
import org.valkyrienskies.core.impl.shadow.ch_0;
import org.valkyrienskies.core.impl.shadow.kP;
import org.valkyrienskies.core.impl.shadow.mF;
import org.valkyrienskies.core.impl.shadow.oS;
import org.valkyrienskies.core.impl.shadow.pf_0;
import org.valkyrienskies.core.impl.shadow.po_0;

@Deprecated
public final class mG
implements kP {
    private static final int a = 16;
    private static final double[][] b = new double[][]{{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0}, {-3.0, 3.0, 0.0, 0.0, -2.0, -1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0}, {2.0, -2.0, 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, -3.0, 3.0, 0.0, 0.0, -2.0, -1.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 2.0, -2.0, 0.0, 0.0, 1.0, 1.0, 0.0, 0.0}, {-3.0, 0.0, 3.0, 0.0, 0.0, 0.0, 0.0, 0.0, -2.0, 0.0, -1.0, 0.0, 0.0, 0.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 0.0, -3.0, 0.0, 3.0, 0.0, 0.0, 0.0, 0.0, 0.0, -2.0, 0.0, -1.0, 0.0}, {9.0, -9.0, -9.0, 9.0, 6.0, 3.0, -6.0, -3.0, 6.0, -6.0, 3.0, -3.0, 4.0, 2.0, 2.0, 1.0}, {-6.0, 6.0, 6.0, -6.0, -3.0, -3.0, 3.0, 3.0, -4.0, 4.0, -2.0, 2.0, -2.0, -2.0, -1.0, -1.0}, {2.0, 0.0, -2.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 0.0, 2.0, 0.0, -2.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 0.0}, {-6.0, 6.0, 6.0, -6.0, -4.0, -2.0, 4.0, 2.0, -3.0, 3.0, -3.0, 3.0, -2.0, -1.0, -2.0, -1.0}, {4.0, -4.0, -4.0, 4.0, 2.0, 2.0, -2.0, -2.0, 2.0, -2.0, 2.0, -2.0, 1.0, 1.0, 1.0, 1.0}};
    private final double[] c;
    private final double[] d;
    private final mF[][] e;
    private final kP[][][] f;

    private mG(double[] dArray, double[] dArray2, double[][] dArray3, double[][] dArray4, double[][] dArray5, double[][] dArray6) {
        this(dArray, dArray2, dArray3, dArray4, dArray5, dArray6, false);
    }

    public mG(double[] dArray, double[] dArray2, double[][] object, double[][] dArray3, double[][] dArray4, double[][] dArray5, boolean bl) {
        int n2;
        int n3 = dArray.length;
        int n4 = dArray2.length;
        if (n3 == 0 || n4 == 0 || ((double[][])object).length == 0 || object[0].length == 0) {
            throw new pf_0();
        }
        if (n3 != ((double[][])object).length) {
            throw new oS(n3, ((double[][])object).length);
        }
        if (n3 != dArray3.length) {
            throw new oS(n3, dArray3.length);
        }
        if (n3 != dArray4.length) {
            throw new oS(n3, dArray4.length);
        }
        if (n3 != dArray5.length) {
            throw new oS(n3, dArray5.length);
        }
        ch_0.a(dArray);
        ch_0.a(dArray2);
        this.c = (double[])dArray.clone();
        this.d = (double[])dArray2.clone();
        int n5 = n3 - 1;
        int n6 = n4 - 1;
        this.e = new mF[n5][n6];
        for (n3 = 0; n3 < n5; ++n3) {
            if (object[n3].length != n4) {
                throw new oS(object[n3].length, n4);
            }
            if (dArray3[n3].length != n4) {
                throw new oS(dArray3[n3].length, n4);
            }
            if (dArray4[n3].length != n4) {
                throw new oS(dArray4[n3].length, n4);
            }
            if (dArray5[n3].length != n4) {
                throw new oS(dArray5[n3].length, n4);
            }
            n2 = n3 + 1;
            for (int i2 = 0; i2 < n6; ++i2) {
                int n7 = i2 + 1;
                double[] dArray6 = new double[]{object[n3][i2], object[n2][i2], object[n3][n7], object[n2][n7], dArray3[n3][i2], dArray3[n2][i2], dArray3[n3][n7], dArray3[n2][n7], dArray4[n3][i2], dArray4[n2][i2], dArray4[n3][n7], dArray4[n2][n7], dArray5[n3][i2], dArray5[n2][i2], dArray5[n3][n7], dArray5[n2][n7]};
                this.e[n3][i2] = new mF(mG.a(dArray6), bl);
            }
        }
        if (bl) {
            this.f = new kP[5][n5][n6];
            for (n3 = 0; n3 < n5; ++n3) {
                for (n2 = 0; n2 < n6; ++n2) {
                    mF mF2;
                    mF mF3 = mF2 = this.e[n3][n2];
                    object = mF3;
                    this.f[0][n3][n2] = mF3.a;
                    mF mF4 = mF2;
                    object = mF4;
                    this.f[1][n3][n2] = mF4.b;
                    mF mF5 = mF2;
                    object = mF5;
                    this.f[2][n3][n2] = mF5.c;
                    mF mF6 = mF2;
                    object = mF6;
                    this.f[3][n3][n2] = mF6.d;
                    mF mF7 = mF2;
                    object = mF7;
                    this.f[4][n3][n2] = mF7.e;
                }
            }
            return;
        }
        this.f = null;
    }

    public final double a(double d2, double d3) {
        int n2 = mG.a(d2, this.c);
        int n3 = mG.a(d3, this.d);
        double d4 = (d2 - this.c[n2]) / (this.c[n2 + 1] - this.c[n2]);
        double d5 = (d3 - this.d[n3]) / (this.d[n3 + 1] - this.d[n3]);
        return this.e[n2][n3].a(d4, d5);
    }

    private boolean e(double d2, double d3) {
        return !(d2 < this.c[0] || d2 > this.c[this.c.length - 1] || d3 < this.d[0]) && !(d3 > this.d[this.d.length - 1]);
    }

    public final double b(double d2, double d3) {
        return this.a(0, d2, d3);
    }

    public final double c(double d2, double d3) {
        return this.a(1, d2, d3);
    }

    private double f(double d2, double d3) {
        return this.a(2, d2, d3);
    }

    private double g(double d2, double d3) {
        return this.a(3, d2, d3);
    }

    public final double d(double d2, double d3) {
        return this.a(4, d2, d3);
    }

    double a(int n2, double d2, double d3) {
        int n3 = mG.a(d2, this.c);
        int n4 = mG.a(d3, this.d);
        double d4 = (d2 - this.c[n3]) / (this.c[n3 + 1] - this.c[n3]);
        double d5 = (d3 - this.d[n4]) / (this.d[n4 + 1] - this.d[n4]);
        return this.f[n2][n3][n4].a(d4, d5);
    }

    private static int a(double d2, double[] dArray) {
        int n2 = Arrays.binarySearch(dArray, d2);
        if (n2 == -1 || n2 == -dArray.length - 1) {
            throw new po_0(d2, (Number)dArray[0], dArray[dArray.length - 1]);
        }
        if (n2 < 0) {
            return -n2 - 2;
        }
        int n3 = dArray.length - 1;
        if (n2 == n3) {
            return n3 - 1;
        }
        return n2;
    }

    private static double[] a(double[] dArray) {
        double[] dArray2 = new double[16];
        for (int i2 = 0; i2 < 16; ++i2) {
            double d2 = 0.0;
            double[] dArray3 = b[i2];
            for (int i3 = 0; i3 < 16; ++i3) {
                d2 += dArray3[i3] * dArray[i3];
            }
            dArray2[i2] = d2;
        }
        return dArray2;
    }
}

