/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Arrays;
import org.valkyrienskies.core.impl.shadow.ch_0;
import org.valkyrienskies.core.impl.shadow.kP;
import org.valkyrienskies.core.impl.shadow.mC;
import org.valkyrienskies.core.impl.shadow.oS;
import org.valkyrienskies.core.impl.shadow.pf_0;
import org.valkyrienskies.core.impl.shadow.po_0;

public class mD
implements kP {
    private static final int a = 16;
    private static final double[][] b = new double[][]{{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0}, {-3.0, 3.0, 0.0, 0.0, -2.0, -1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0}, {2.0, -2.0, 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, -3.0, 3.0, 0.0, 0.0, -2.0, -1.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 2.0, -2.0, 0.0, 0.0, 1.0, 1.0, 0.0, 0.0}, {-3.0, 0.0, 3.0, 0.0, 0.0, 0.0, 0.0, 0.0, -2.0, 0.0, -1.0, 0.0, 0.0, 0.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 0.0, -3.0, 0.0, 3.0, 0.0, 0.0, 0.0, 0.0, 0.0, -2.0, 0.0, -1.0, 0.0}, {9.0, -9.0, -9.0, 9.0, 6.0, 3.0, -6.0, -3.0, 6.0, -6.0, 3.0, -3.0, 4.0, 2.0, 2.0, 1.0}, {-6.0, 6.0, 6.0, -6.0, -3.0, -3.0, 3.0, 3.0, -4.0, 4.0, -2.0, 2.0, -2.0, -2.0, -1.0, -1.0}, {2.0, 0.0, -2.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 0.0, 2.0, 0.0, -2.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 0.0}, {-6.0, 6.0, 6.0, -6.0, -4.0, -2.0, 4.0, 2.0, -3.0, 3.0, -3.0, 3.0, -2.0, -1.0, -2.0, -1.0}, {4.0, -4.0, -4.0, 4.0, 2.0, 2.0, -2.0, -2.0, 2.0, -2.0, 2.0, -2.0, 1.0, 1.0, 1.0, 1.0}};
    private final double[] c;
    private final double[] d;
    private final mC[][] e;

    public mD(double[] dArray, double[] dArray2, double[][] dArray3, double[][] dArray4, double[][] dArray5, double[][] dArray6) {
        int n2 = dArray.length;
        int n3 = dArray2.length;
        if (n2 == 0 || n3 == 0 || dArray3.length == 0 || dArray3[0].length == 0) {
            throw new pf_0();
        }
        if (n2 != dArray3.length) {
            throw new oS(n2, dArray3.length);
        }
        if (n2 != dArray4.length) {
            throw new oS(n2, dArray4.length);
        }
        if (n2 != dArray5.length) {
            throw new oS(n2, dArray5.length);
        }
        if (n2 != dArray6.length) {
            throw new oS(n2, dArray6.length);
        }
        ch_0.a(dArray);
        ch_0.a(dArray2);
        this.c = (double[])dArray.clone();
        this.d = (double[])dArray2.clone();
        int n4 = n2 - 1;
        int n5 = n3 - 1;
        this.e = new mC[n4][n5];
        for (n2 = 0; n2 < n4; ++n2) {
            if (dArray3[n2].length != n3) {
                throw new oS(dArray3[n2].length, n3);
            }
            if (dArray4[n2].length != n3) {
                throw new oS(dArray4[n2].length, n3);
            }
            if (dArray5[n2].length != n3) {
                throw new oS(dArray5[n2].length, n3);
            }
            if (dArray6[n2].length != n3) {
                throw new oS(dArray6[n2].length, n3);
            }
            int n6 = n2 + 1;
            double d2 = this.c[n6] - this.c[n2];
            for (int i2 = 0; i2 < n5; ++i2) {
                int n7 = i2 + 1;
                double d3 = this.d[n7] - this.d[i2];
                double d4 = d2 * d3;
                double[] dArray7 = new double[]{dArray3[n2][i2], dArray3[n6][i2], dArray3[n2][n7], dArray3[n6][n7], dArray4[n2][i2] * d2, dArray4[n6][i2] * d2, dArray4[n2][n7] * d2, dArray4[n6][n7] * d2, dArray5[n2][i2] * d3, dArray5[n6][i2] * d3, dArray5[n2][n7] * d3, dArray5[n6][n7] * d3, dArray6[n2][i2] * d4, dArray6[n6][i2] * d4, dArray6[n2][n7] * d4, dArray6[n6][n7] * d4};
                this.e[n2][i2] = new mC(mD.a(dArray7));
            }
        }
    }

    public final double a(double d2, double d3) {
        int n2 = mD.a(d2, this.c);
        int n3 = mD.a(d3, this.d);
        double d4 = (d2 - this.c[n2]) / (this.c[n2 + 1] - this.c[n2]);
        double d5 = (d3 - this.d[n3]) / (this.d[n3 + 1] - this.d[n3]);
        return this.e[n2][n3].a(d4, d5);
    }

    public boolean b(double d2, double d3) {
        return !(d2 < this.c[0] || d2 > this.c[this.c.length - 1] || d3 < this.d[0]) && !(d3 > this.d[this.d.length - 1]);
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

