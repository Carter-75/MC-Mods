/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.ch_0;
import org.valkyrienskies.core.impl.shadow.lb_0;
import org.valkyrienskies.core.impl.shadow.na_0;
import org.valkyrienskies.core.impl.shadow.nf_0;
import org.valkyrienskies.core.impl.shadow.oS;
import org.valkyrienskies.core.impl.shadow.pf_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.nb
 */
public final class nb_0
implements nf_0 {
    private 1_0 b(double[] dArray, double[] dArray2, double[] dArray3, double[][][] dArray4) {
        if (dArray.length == 0 || dArray2.length == 0 || dArray3.length == 0 || dArray4.length == 0) {
            throw new pf_0();
        }
        if (dArray.length != dArray4.length) {
            throw new oS(dArray.length, dArray4.length);
        }
        ch_0.a(dArray);
        ch_0.a(dArray2);
        ch_0.a(dArray3);
        int n2 = dArray.length;
        int n3 = dArray2.length;
        int n4 = dArray3.length;
        double[][][] dArray5 = new double[n2][n3][n4];
        double[][][] dArray6 = new double[n2][n3][n4];
        double[][][] dArray7 = new double[n2][n3][n4];
        double[][][] dArray8 = new double[n2][n3][n4];
        double[][][] dArray9 = new double[n2][n3][n4];
        double[][][] dArray10 = new double[n2][n3][n4];
        double[][][] dArray11 = new double[n2][n3][n4];
        for (int i2 = 1; i2 < n2 - 1; ++i2) {
            if (dArray2.length != dArray4[i2].length) {
                throw new oS(dArray2.length, dArray4[i2].length);
            }
            int n5 = i2 + 1;
            int n6 = i2 - 1;
            double d2 = dArray[n5];
            double d3 = dArray[n6];
            double d4 = d2 - d3;
            for (int i3 = 1; i3 < n3 - 1; ++i3) {
                if (dArray3.length != dArray4[i2][i3].length) {
                    throw new oS(dArray3.length, dArray4[i2][i3].length);
                }
                int n7 = i3 + 1;
                int n8 = i3 - 1;
                double d5 = dArray2[n7];
                double d6 = dArray2[n8];
                double d7 = d5 - d6;
                double d8 = d4 * d7;
                for (int i4 = 1; i4 < n4 - 1; ++i4) {
                    int n9 = i4 + 1;
                    int n10 = i4 - 1;
                    double d9 = dArray3[n9];
                    double d10 = dArray3[n10];
                    double d11 = d9 - d10;
                    dArray5[i2][i3][i4] = (dArray4[n5][i3][i4] - dArray4[n6][i3][i4]) / d4;
                    dArray6[i2][i3][i4] = (dArray4[i2][n7][i4] - dArray4[i2][n8][i4]) / d7;
                    dArray7[i2][i3][i4] = (dArray4[i2][i3][n9] - dArray4[i2][i3][n10]) / d11;
                    double d12 = d4 * d11;
                    double d13 = d7 * d11;
                    dArray8[i2][i3][i4] = (dArray4[n5][n7][i4] - dArray4[n5][n8][i4] - dArray4[n6][n7][i4] + dArray4[n6][n8][i4]) / d8;
                    dArray9[i2][i3][i4] = (dArray4[n5][i3][n9] - dArray4[n5][i3][n10] - dArray4[n6][i3][n9] + dArray4[n6][i3][n10]) / d12;
                    dArray10[i2][i3][i4] = (dArray4[i2][n7][n9] - dArray4[i2][n7][n10] - dArray4[i2][n8][n9] + dArray4[i2][n8][n10]) / d13;
                    double d14 = d8 * d11;
                    dArray11[i2][i3][i4] = (dArray4[n5][n7][n9] - dArray4[n5][n8][n9] - dArray4[n6][n7][n9] + dArray4[n6][n8][n9] - dArray4[n5][n7][n10] + dArray4[n5][n8][n10] + dArray4[n6][n7][n10] - dArray4[n6][n8][n10]) / d14;
                }
            }
        }
        return new na_0(this, dArray, dArray2, dArray3, dArray4, dArray5, dArray6, dArray7, dArray8, dArray9, dArray10, dArray11, dArray, dArray2, dArray3){
            private /* synthetic */ double[] a;
            private /* synthetic */ double[] b;
            private /* synthetic */ double[] c;
            private /* synthetic */ nb_0 d;
            {
                this.d = nb_02;
                this.a = dArray12;
                this.b = dArray13;
                this.c = dArray14;
                super(dArray, dArray2, dArray3, dArray4, dArray5, dArray6, dArray7, dArray8, dArray9, dArray10, dArray11);
            }

            public final boolean b(double d2, double d3, double d4) {
                return !(d2 < this.a[1] || d2 > this.a[this.a.length - 2] || d3 < this.b[1] || d3 > this.b[this.b.length - 2] || d4 < this.c[1]) && !(d4 > this.c[this.c.length - 2]);
            }
        };
    }

    public final /* synthetic */ lb_0 a(double[] object, double[] dArray, double[] dArray2, double[][][] object2) {
        double[][][] dArray3 = object2;
        object2 = dArray2;
        dArray2 = dArray;
        dArray = object;
        object = this;
        if (((double[])dArray).length == 0 || dArray2.length == 0 || ((double[][][])object2).length == 0 || dArray3.length == 0) {
            throw new pf_0();
        }
        if (((double[])dArray).length != dArray3.length) {
            throw new oS(((double[])dArray).length, dArray3.length);
        }
        ch_0.a(dArray);
        ch_0.a(dArray2);
        ch_0.a((double[])object2);
        int n2 = ((double[])dArray).length;
        int n3 = dArray2.length;
        int n4 = ((double[][][])object2).length;
        double[][][] dArray4 = new double[n2][n3][n4];
        double[][][] dArray5 = new double[n2][n3][n4];
        double[][][] dArray6 = new double[n2][n3][n4];
        double[][][] dArray7 = new double[n2][n3][n4];
        double[][][] dArray8 = new double[n2][n3][n4];
        double[][][] dArray9 = new double[n2][n3][n4];
        double[][][] dArray10 = new double[n2][n3][n4];
        for (int i2 = 1; i2 < n2 - 1; ++i2) {
            if (dArray2.length != ((Object)dArray3[i2]).length) {
                throw new oS(dArray2.length, ((Object)dArray3[i2]).length);
            }
            int n5 = i2 + 1;
            int n6 = i2 - 1;
            double d2 = dArray[n5];
            double d3 = dArray[n6];
            double d4 = d2 - d3;
            for (int i3 = 1; i3 < n3 - 1; ++i3) {
                if (((double[][][])object2).length != ((Object)dArray3[i2][i3]).length) {
                    throw new oS(((double[][][])object2).length, ((Object)dArray3[i2][i3]).length);
                }
                int n7 = i3 + 1;
                int n8 = i3 - 1;
                double d5 = dArray2[n7];
                double d6 = dArray2[n8];
                double d7 = d5 - d6;
                double d8 = d4 * d7;
                for (int i4 = 1; i4 < n4 - 1; ++i4) {
                    int n9 = i4 + 1;
                    int n10 = i4 - 1;
                    double[][] dArray11 = object2[n9];
                    double[][] dArray12 = object2[n10];
                    reference var47_34 = dArray11 - dArray12;
                    dArray4[i2][i3][i4] = (double)((dArray3[n5][i3][i4] - dArray3[n6][i3][i4]) / d4);
                    dArray5[i2][i3][i4] = (double)((dArray3[i2][n7][i4] - dArray3[i2][n8][i4]) / d7);
                    dArray6[i2][i3][i4] = (double)((dArray3[i2][i3][n9] - dArray3[i2][i3][n10]) / var47_34);
                    double d9 = d4 * var47_34;
                    double d10 = d7 * var47_34;
                    dArray7[i2][i3][i4] = (double)((dArray3[n5][n7][i4] - dArray3[n5][n8][i4] - dArray3[n6][n7][i4] + dArray3[n6][n8][i4]) / d8);
                    dArray8[i2][i3][i4] = (double)((dArray3[n5][i3][n9] - dArray3[n5][i3][n10] - dArray3[n6][i3][n9] + dArray3[n6][i3][n10]) / d9);
                    dArray9[i2][i3][i4] = (double)((dArray3[i2][n7][n9] - dArray3[i2][n7][n10] - dArray3[i2][n8][n9] + dArray3[i2][n8][n10]) / d10);
                    double d11 = d8 * var47_34;
                    dArray10[i2][i3][i4] = (double)((dArray3[n5][n7][n9] - dArray3[n5][n8][n9] - dArray3[n6][n7][n9] + dArray3[n6][n8][n9] - dArray3[n5][n7][n10] + dArray3[n5][n8][n10] + dArray3[n6][n7][n10] - dArray3[n6][n8][n10]) / d11);
                }
            }
        }
        return new /* invalid duplicate definition of identical inner class */;
    }
}

