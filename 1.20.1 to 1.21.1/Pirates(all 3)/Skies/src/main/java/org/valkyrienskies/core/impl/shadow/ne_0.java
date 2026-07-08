/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.ch_0;
import org.valkyrienskies.core.impl.shadow.lb_0;
import org.valkyrienskies.core.impl.shadow.mG;
import org.valkyrienskies.core.impl.shadow.mH;
import org.valkyrienskies.core.impl.shadow.nd_0;
import org.valkyrienskies.core.impl.shadow.nf_0;
import org.valkyrienskies.core.impl.shadow.oS;
import org.valkyrienskies.core.impl.shadow.pf_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.ne
 */
@Deprecated
public final class ne_0
implements nf_0 {
    private nd_0 b(double[] dArray, double[] dArray2, double[] dArray3, double[][][] dArray4) {
        int n2;
        double d2;
        double d3;
        Object object;
        double d4;
        int n3;
        Object object2;
        int n4;
        if (dArray.length == 0 || dArray2.length == 0 || dArray3.length == 0 || dArray4.length == 0) {
            throw new pf_0();
        }
        if (dArray.length != dArray4.length) {
            throw new oS(dArray.length, dArray4.length);
        }
        ch_0.a(dArray);
        ch_0.a(dArray2);
        ch_0.a(dArray3);
        int n5 = dArray.length;
        int n6 = dArray2.length;
        int n7 = dArray3.length;
        double[][][] dArray5 = new double[n7][n5][n6];
        double[][][] dArray6 = new double[n6][n7][n5];
        for (int i2 = 0; i2 < n5; ++i2) {
            if (dArray4[i2].length != n6) {
                throw new oS(dArray4[i2].length, n6);
            }
            for (int i3 = 0; i3 < n6; ++i3) {
                if (dArray4[i2][i3].length != n7) {
                    throw new oS(dArray4[i2][i3].length, n7);
                }
                for (n4 = 0; n4 < n7; ++n4) {
                    double d5;
                    dArray5[n4][i2][i3] = d5 = dArray4[i2][i3][n4];
                    dArray6[i3][n4][i2] = d5;
                }
            }
        }
        mH mH2 = new mH(true);
        mG[] mGArray = new mG[n5];
        for (n4 = 0; n4 < n5; ++n4) {
            mGArray[n4] = mH2.b(dArray2, dArray3, dArray4[n4]);
        }
        mG[] mGArray2 = new mG[n6];
        for (int i4 = 0; i4 < n6; ++i4) {
            mGArray2[i4] = mH2.b(dArray3, dArray, dArray6[i4]);
        }
        mG[] mGArray3 = new mG[n7];
        for (int i5 = 0; i5 < n7; ++i5) {
            mGArray3[i5] = mH2.b(dArray, dArray2, dArray5[i5]);
        }
        double[][][] dArray7 = new double[n5][n6][n7];
        dArray5 = new double[n5][n6][n7];
        dArray6 = new double[n5][n6][n7];
        for (int i6 = 0; i6 < n7; ++i6) {
            object2 = mGArray3[i6];
            for (n3 = 0; n3 < n5; ++n3) {
                double d6 = dArray[n3];
                for (int i7 = 0; i7 < n6; ++i7) {
                    double d7 = d4 = dArray2[i7];
                    double d8 = d6;
                    object = object2;
                    dArray7[n3][i7][i6] = ((mG)object).a(0, d8, d7);
                    d3 = d4;
                    d2 = d6;
                    object = object2;
                    dArray5[n3][i7][i6] = ((mG)object).a(1, d2, d3);
                    d3 = d4;
                    d2 = d6;
                    object = object2;
                    dArray6[n3][i7][i6] = ((mG)object).a(4, d2, d3);
                }
            }
        }
        double[][][] dArray8 = new double[n5][n6][n7];
        object2 = new double[n5][n6][n7];
        for (n3 = 0; n3 < n5; ++n3) {
            mG mG2 = mGArray[n3];
            for (int i8 = 0; i8 < n6; ++i8) {
                double d9 = dArray2[i8];
                for (n2 = 0; n2 < n7; ++n2) {
                    double d10;
                    d3 = d10 = dArray3[n2];
                    d2 = d9;
                    object = mG2;
                    dArray8[n3][i8][n2] = ((mG)object).a(1, d2, d3);
                    d3 = d10;
                    d2 = d9;
                    object = mG2;
                    object2[n3][i8][n2] = ((mG)object).a(4, d2, d3);
                }
            }
        }
        double[][][] dArray9 = new double[n5][n6][n7];
        for (int i9 = 0; i9 < n6; ++i9) {
            mG mG3 = mGArray2[i9];
            for (int i10 = 0; i10 < n7; ++i10) {
                d4 = dArray3[i10];
                for (int i11 = 0; i11 < n5; ++i11) {
                    double d11;
                    d3 = d11 = dArray[i11];
                    d2 = d4;
                    object = mG3;
                    dArray9[i11][i9][i10] = ((mG)object).a(4, d2, d3);
                }
            }
        }
        double[][][] dArray10 = new double[n5][n6][n7];
        for (int i12 = 0; i12 < n5; ++i12) {
            int n8 = ne_0.a(i12, n5);
            int n9 = ne_0.a(i12);
            for (n2 = 0; n2 < n6; ++n2) {
                int n10 = ne_0.a(n2, n6);
                int n11 = ne_0.a(n2);
                for (int i13 = 0; i13 < n7; ++i13) {
                    int n12 = ne_0.a(i13, n7);
                    int n13 = ne_0.a(i13);
                    dArray10[i12][n2][i13] = (dArray4[n8][n10][n12] - dArray4[n8][n11][n12] - dArray4[n9][n10][n12] + dArray4[n9][n11][n12] - dArray4[n8][n10][n13] + dArray4[n8][n11][n13] + dArray4[n9][n10][n13] - dArray4[n9][n11][n13]) / ((dArray[n8] - dArray[n9]) * (dArray2[n10] - dArray2[n11]) * (dArray3[n12] - dArray3[n13]));
                }
            }
        }
        return new nd_0(dArray, dArray2, dArray3, dArray4, dArray7, dArray5, dArray8, dArray6, dArray9, (double[][][])object2, dArray10);
    }

    private static int a(int n2, int n3) {
        if (++n2 < n3) {
            return n2;
        }
        return n2 - 1;
    }

    private static int a(int n2) {
        if (--n2 >= 0) {
            return n2;
        }
        return 0;
    }

    public final /* synthetic */ lb_0 a(double[] object, double[] dArray, double[] dArray2, double[][][] object2) {
        int n2;
        Object object3;
        Object object4;
        Object object5;
        Object object6;
        int n3;
        Object object7;
        int n4;
        double[][][] dArray3 = object2;
        object2 = dArray2;
        dArray2 = dArray;
        dArray = object;
        object = this;
        if (dArray.length == 0 || dArray2.length == 0 || ((double[][][])object2).length == 0 || dArray3.length == 0) {
            throw new pf_0();
        }
        if (dArray.length != dArray3.length) {
            throw new oS(dArray.length, dArray3.length);
        }
        ch_0.a(dArray);
        ch_0.a(dArray2);
        ch_0.a((double[])object2);
        int n5 = dArray.length;
        int n6 = dArray2.length;
        int n7 = ((double[][][])object2).length;
        double[][][] dArray4 = new double[n7][n5][n6];
        double[][][] dArray5 = new double[n6][n7][n5];
        for (int i2 = 0; i2 < n5; ++i2) {
            if (dArray3[i2].length != n6) {
                throw new oS(dArray3[i2].length, n6);
            }
            for (int i3 = 0; i3 < n6; ++i3) {
                if (dArray3[i2][i3].length != n7) {
                    throw new oS(dArray3[i2][i3].length, n7);
                }
                for (n4 = 0; n4 < n7; ++n4) {
                    double d2;
                    dArray4[n4][i2][i3] = d2 = dArray3[i2][i3][n4];
                    dArray5[i3][n4][i2] = d2;
                }
            }
        }
        mH mH2 = new mH(true);
        mG[] mGArray = new mG[n5];
        for (n4 = 0; n4 < n5; ++n4) {
            mGArray[n4] = mH2.b(dArray2, (double[])object2, dArray3[n4]);
        }
        mG[] mGArray2 = new mG[n6];
        for (int i4 = 0; i4 < n6; ++i4) {
            mGArray2[i4] = mH2.b((double[])object2, dArray, dArray5[i4]);
        }
        mG[] mGArray3 = new mG[n7];
        for (int i5 = 0; i5 < n7; ++i5) {
            mGArray3[i5] = mH2.b(dArray, dArray2, dArray4[i5]);
        }
        double[][][] dArray6 = new double[n5][n6][n7];
        dArray4 = new double[n5][n6][n7];
        dArray5 = new double[n5][n6][n7];
        for (int i6 = 0; i6 < n7; ++i6) {
            object7 = mGArray3[i6];
            for (n3 = 0; n3 < n5; ++n3) {
                Object object8 = dArray[n3];
                for (int i7 = 0; i7 < n6; ++i7) {
                    Object object9 = object6 = dArray2[i7];
                    Object object10 = object8;
                    object5 = object7;
                    dArray6[n3][i7][i6] = ((mG)object5).a(0, (double)object10, (double)object9);
                    object4 = object6;
                    object3 = object8;
                    object5 = object7;
                    dArray4[n3][i7][i6] = ((mG)object5).a(1, (double)object3, (double)object4);
                    object4 = object6;
                    object3 = object8;
                    object5 = object7;
                    dArray5[n3][i7][i6] = ((mG)object5).a(4, (double)object3, (double)object4);
                }
            }
        }
        double[][][] dArray7 = new double[n5][n6][n7];
        object7 = new double[n5][n6][n7];
        for (n3 = 0; n3 < n5; ++n3) {
            mG mG2 = mGArray[n3];
            for (int i8 = 0; i8 < n6; ++i8) {
                Object object11 = dArray2[i8];
                for (n2 = 0; n2 < n7; ++n2) {
                    double[][] dArray8;
                    object4 = dArray8 = object2[n2];
                    object3 = object11;
                    object5 = mG2;
                    dArray7[n3][i8][n2] = ((mG)object5).a(1, (double)object3, (double)object4);
                    object4 = dArray8;
                    object3 = object11;
                    object5 = mG2;
                    object7[n3][i8][n2] = ((mG)object5).a(4, (double)object3, (double)object4);
                }
            }
        }
        double[][][] dArray9 = new double[n5][n6][n7];
        for (int i9 = 0; i9 < n6; ++i9) {
            mG mG3 = mGArray2[i9];
            for (int i10 = 0; i10 < n7; ++i10) {
                object6 = object2[i10];
                for (int i11 = 0; i11 < n5; ++i11) {
                    double d3 = dArray[i11];
                    object4 = d3;
                    object3 = object6;
                    object5 = mG3;
                    dArray9[i11][i9][i10] = ((mG)object5).a(4, (double)object3, (double)object4);
                }
            }
        }
        double[][][] dArray10 = new double[n5][n6][n7];
        for (int i12 = 0; i12 < n5; ++i12) {
            int n8 = ne_0.a(i12, n5);
            int n9 = ne_0.a(i12);
            for (n2 = 0; n2 < n6; ++n2) {
                int n10 = ne_0.a(n2, n6);
                int n11 = ne_0.a(n2);
                for (int i13 = 0; i13 < n7; ++i13) {
                    int n12 = ne_0.a(i13, n7);
                    int n13 = ne_0.a(i13);
                    dArray10[i12][n2][i13] = (dArray3[n8][n10][n12] - dArray3[n8][n11][n12] - dArray3[n9][n10][n12] + dArray3[n9][n11][n12] - dArray3[n8][n10][n13] + dArray3[n8][n11][n13] + dArray3[n9][n10][n13] - dArray3[n9][n11][n13]) / ((dArray[n8] - dArray[n9]) * (dArray2[n10] - dArray2[n11]) * (object2[n12] - object2[n13]));
                }
            }
        }
        return new nd_0(dArray, dArray2, (double[])object2, dArray3, dArray6, dArray4, dArray7, dArray5, dArray9, (double[][][])object7, dArray10);
    }
}

