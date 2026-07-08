/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.ch_0;
import org.valkyrienskies.core.impl.shadow.kP;
import org.valkyrienskies.core.impl.shadow.lc_0;
import org.valkyrienskies.core.impl.shadow.mG;
import org.valkyrienskies.core.impl.shadow.mI;
import org.valkyrienskies.core.impl.shadow.mY;
import org.valkyrienskies.core.impl.shadow.nl_0;
import org.valkyrienskies.core.impl.shadow.oS;
import org.valkyrienskies.core.impl.shadow.pf_0;

@Deprecated
public class mH
implements mI {
    private final boolean a;

    public mH() {
        this(false);
    }

    public mH(boolean bl) {
        this.a = bl;
    }

    public mG b(double[] dArray, double[] dArray2, double[][] dArray3) {
        int n2;
        if (dArray.length == 0 || dArray2.length == 0 || dArray3.length == 0) {
            throw new pf_0();
        }
        if (dArray.length != dArray3.length) {
            throw new oS(dArray.length, dArray3.length);
        }
        ch_0.a(dArray);
        ch_0.a(dArray2);
        int n3 = dArray.length;
        int n4 = dArray2.length;
        double[][] dArray4 = new double[n4][n3];
        for (n2 = 0; n2 < n3; ++n2) {
            if (dArray3[n2].length != n4) {
                throw new oS(dArray3[n2].length, n4);
            }
            for (int i2 = 0; i2 < n4; ++i2) {
                dArray4[i2][n2] = dArray3[n2][i2];
            }
        }
        new mY();
        nl_0[] nl_0Array = new nl_0[n4];
        for (n2 = 0; n2 < n4; ++n2) {
            nl_0Array[n2] = mY.a(dArray, dArray4[n2]);
        }
        nl_0[] nl_0Array2 = new nl_0[n3];
        for (int i3 = 0; i3 < n3; ++i3) {
            nl_0Array2[i3] = mY.a(dArray2, dArray3[i3]);
        }
        double[][] dArray5 = new double[n3][n4];
        for (int i4 = 0; i4 < n4; ++i4) {
            lc_0 lc_02 = nl_0Array[i4].a();
            for (int i5 = 0; i5 < n3; ++i5) {
                dArray5[i5][i4] = lc_02.a(dArray[i5]);
            }
        }
        double[][] dArray6 = new double[n3][n4];
        for (int i6 = 0; i6 < n3; ++i6) {
            lc_0 lc_03 = nl_0Array2[i6].a();
            for (int i7 = 0; i7 < n4; ++i7) {
                dArray6[i6][i7] = lc_03.a(dArray2[i7]);
            }
        }
        double[][] dArray7 = new double[n3][n4];
        for (int i8 = 0; i8 < n3; ++i8) {
            int n5 = mH.a(i8, n3);
            int n6 = mH.a(i8);
            for (int i9 = 0; i9 < n4; ++i9) {
                int n7 = mH.a(i9, n4);
                int n8 = mH.a(i9);
                dArray7[i8][i9] = (dArray3[n5][n7] - dArray3[n5][n8] - dArray3[n6][n7] + dArray3[n6][n8]) / ((dArray[n5] - dArray[n6]) * (dArray2[n7] - dArray2[n8]));
            }
        }
        return new mG(dArray, dArray2, dArray3, dArray5, dArray6, dArray7, this.a);
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

    public /* synthetic */ kP a(double[] dArray, double[] dArray2, double[][] dArray3) {
        return this.b(dArray, dArray2, dArray3);
    }
}

