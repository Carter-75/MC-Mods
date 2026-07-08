/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.kP;
import org.valkyrienskies.core.impl.shadow.po_0;

final class mF
implements kP {
    private static final short f = 4;
    private final double[][] g = new double[4][4];
    final 1 a;
    final 2 b;
    final 3 c;
    final 4 d;
    final 5 e;

    private mF(double[] dArray) {
        this(dArray, false);
    }

    mF(double[] object, boolean bl) {
        for (int i2 = 0; i2 < 4; ++i2) {
            for (int i3 = 0; i3 < 4; ++i3) {
                this.g[i2][i3] = object[(i2 << 2) + i3];
            }
        }
        if (bl) {
            double[][] dArray = new double[4][4];
            double[][] dArray2 = new double[4][4];
            object = new double[4][4];
            double[][] dArray3 = new double[4][4];
            double[][] dArray4 = new double[4][4];
            for (int i4 = 0; i4 < 4; ++i4) {
                for (int i5 = 0; i5 < 4; ++i5) {
                    double d2 = this.g[i4][i5];
                    dArray[i4][i5] = (double)i4 * d2;
                    int n2 = i5;
                    dArray2[i4][n2] = (double)n2 * d2;
                    object[i4][i5] = (double)(i4 - 1) * dArray[i4][i5];
                    int n3 = i5;
                    dArray3[i4][n3] = (double)(n3 - 1) * dArray2[i4][i5];
                    int n4 = i5;
                    dArray4[i4][n4] = (double)n4 * dArray[i4][i5];
                }
            }
            this.a = new kP(this, dArray){
                private /* synthetic */ double[][] a;
                private /* synthetic */ mF b;
                {
                    this.b = mF2;
                    this.a = dArray;
                }

                public final double a(double d2, double d3) {
                    double d4 = d2;
                    double d5 = d4 * d4;
                    Object object = new double[]{0.0, 1.0, d2, d5};
                    double d6 = d3;
                    double d7 = d6 * d6;
                    double d8 = d7 * d3;
                    double[] dArray = new double[]{1.0, d3, d7, d8};
                    double[][] dArray2 = this.a;
                    double[] dArray3 = dArray;
                    dArray = object;
                    object = this.b;
                    return mF.a(dArray, dArray3, dArray2);
                }
            };
            this.b = new kP(this, dArray2){
                private /* synthetic */ double[][] a;
                private /* synthetic */ mF b;
                {
                    this.b = mF2;
                    this.a = dArray;
                }

                public final double a(double d2, double d3) {
                    double d4 = d2;
                    double d5 = d4 * d4;
                    double d6 = d5 * d2;
                    Object object = new double[]{1.0, d2, d5, d6};
                    double d7 = d3;
                    double d8 = d7 * d7;
                    double[] dArray = new double[]{0.0, 1.0, d3, d8};
                    double[][] dArray2 = this.a;
                    double[] dArray3 = dArray;
                    dArray = object;
                    object = this.b;
                    return mF.a(dArray, dArray3, dArray2);
                }
            };
            this.c = new kP(this, (double[][])object){
                private /* synthetic */ double[][] a;
                private /* synthetic */ mF b;
                {
                    this.b = mF2;
                    this.a = dArray;
                }

                public final double a(double d2, double d3) {
                    Object object = new double[]{0.0, 0.0, 1.0, d2};
                    double d4 = d3;
                    double d5 = d4 * d4;
                    double d6 = d5 * d3;
                    double[] dArray = new double[]{1.0, d3, d5, d6};
                    double[][] dArray2 = this.a;
                    double[] dArray3 = dArray;
                    dArray = object;
                    object = this.b;
                    return mF.a(dArray, dArray3, dArray2);
                }
            };
            this.d = new kP(this, dArray3){
                private /* synthetic */ double[][] a;
                private /* synthetic */ mF b;
                {
                    this.b = mF2;
                    this.a = dArray;
                }

                public final double a(double d2, double d3) {
                    double d4 = d2;
                    double d5 = d4 * d4;
                    double d6 = d5 * d2;
                    Object object = new double[]{1.0, d2, d5, d6};
                    double[] dArray = new double[]{0.0, 0.0, 1.0, d3};
                    double[][] dArray2 = this.a;
                    double[] dArray3 = dArray;
                    dArray = object;
                    object = this.b;
                    return mF.a(dArray, dArray3, dArray2);
                }
            };
            this.e = new kP(this, dArray4){
                private /* synthetic */ double[][] a;
                private /* synthetic */ mF b;
                {
                    this.b = mF2;
                    this.a = dArray;
                }

                public final double a(double d2, double d3) {
                    double d4 = d2;
                    double d5 = d4 * d4;
                    Object object = new double[]{0.0, 1.0, d2, d5};
                    double d6 = d3;
                    double d7 = d6 * d6;
                    double[] dArray = new double[]{0.0, 1.0, d3, d7};
                    double[][] dArray2 = this.a;
                    double[] dArray3 = dArray;
                    dArray = object;
                    object = this.b;
                    return mF.a(dArray, dArray3, dArray2);
                }
            };
            return;
        }
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
    }

    public final double a(double d2, double d3) {
        if (d2 < 0.0 || d2 > 1.0) {
            throw new po_0(d2, (Number)0, 1);
        }
        if (d3 < 0.0 || d3 > 1.0) {
            throw new po_0(d3, (Number)0, 1);
        }
        double d4 = d2;
        double d5 = d4 * d4;
        double d6 = d5 * d2;
        double[] dArray = new double[]{1.0, d2, d5, d6};
        double d7 = d3;
        double d8 = d7 * d7;
        double d9 = d8 * d3;
        double[] dArray2 = new double[]{1.0, d3, d8, d9};
        return mF.a(dArray, dArray2, this.g);
    }

    static double a(double[] dArray, double[] dArray2, double[][] dArray3) {
        double d2 = 0.0;
        for (int i2 = 0; i2 < 4; ++i2) {
            for (int i3 = 0; i3 < 4; ++i3) {
                d2 += dArray3[i2][i3] * dArray[i2] * dArray2[i3];
            }
        }
        return d2;
    }

    public final kP a() {
        return this.a;
    }

    public final kP b() {
        return this.b;
    }

    public final kP c() {
        return this.c;
    }

    public final kP d() {
        return this.d;
    }

    public final kP e() {
        return this.e;
    }

    static /* synthetic */ double a(mF mF2, double[] dArray, double[] dArray2, double[][] dArray3) {
        return mF.a(dArray, dArray2, dArray3);
    }
}

