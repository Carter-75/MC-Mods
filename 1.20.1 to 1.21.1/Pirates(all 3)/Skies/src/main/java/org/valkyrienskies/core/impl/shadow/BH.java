/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import org.valkyrienskies.core.impl.shadow.BJ;
import org.valkyrienskies.core.impl.shadow.BK;
import org.valkyrienskies.core.impl.shadow.BL;
import org.valkyrienskies.core.impl.shadow.BM;
import org.valkyrienskies.core.impl.shadow.kV;
import org.valkyrienskies.core.impl.shadow.lc_0;
import org.valkyrienskies.core.impl.shadow.oV;
import org.valkyrienskies.core.impl.shadow.px_0;

public final class BH
implements Serializable,
BJ {
    private static long a = 20120211L;

    public final double[] a(double[] dArray, int n2) {
        if (n2 == BK.FORWARD$4b20d4ed) {
            return BH.a(dArray);
        }
        return BL.a(BH.a(dArray), 1.0 / (double)dArray.length);
    }

    public final double[] a(lc_0 lc_02, double d2, double d3, int n2, int n3) {
        return this.a(kV.a(lc_02, d2, d3, n2), n3);
    }

    private int[] a(int[] nArray) {
        int n2 = nArray.length;
        int n3 = n2 / 2;
        if (!BM.a((long)n2)) {
            throw new oV(px_0.NOT_POWER_OF_TWO, n2);
        }
        int[] nArray2 = new int[n2];
        nArray = (int[])nArray.clone();
        for (int i2 = 1; i2 < n2; i2 <<= 1) {
            int n4;
            int n5;
            int[] nArray3 = nArray;
            nArray = nArray2;
            nArray2 = nArray3;
            for (n5 = 0; n5 < n3; ++n5) {
                n4 = 2 * n5;
                nArray[n5] = nArray2[n4] + nArray2[n4 + 1];
            }
            for (n5 = n3; n5 < n2; ++n5) {
                n4 = 2 * n5;
                nArray[n5] = nArray2[n4 - n2] - nArray2[n4 - n2 + 1];
            }
        }
        return nArray;
    }

    private static double[] a(double[] dArray) {
        int n2 = dArray.length;
        int n3 = n2 / 2;
        if (!BM.a((long)n2)) {
            throw new oV(px_0.NOT_POWER_OF_TWO, n2);
        }
        double[] dArray2 = new double[n2];
        dArray = (double[])dArray.clone();
        for (int i2 = 1; i2 < n2; i2 <<= 1) {
            int n4;
            int n5;
            double[] dArray3 = dArray;
            dArray = dArray2;
            dArray2 = dArray3;
            for (n5 = 0; n5 < n3; ++n5) {
                n4 = 2 * n5;
                dArray[n5] = dArray2[n4] + dArray2[n4 + 1];
            }
            for (n5 = n3; n5 < n2; ++n5) {
                n4 = 2 * n5;
                dArray[n5] = dArray2[n4 - n2] - dArray2[n4 - n2 + 1];
            }
        }
        return dArray;
    }

    private static int[] b(int[] nArray) {
        int n2 = nArray.length;
        int n3 = n2 / 2;
        if (!BM.a((long)n2)) {
            throw new oV(px_0.NOT_POWER_OF_TWO, n2);
        }
        int[] nArray2 = new int[n2];
        nArray = (int[])nArray.clone();
        for (int i2 = 1; i2 < n2; i2 <<= 1) {
            int n4;
            int n5;
            int[] nArray3 = nArray;
            nArray = nArray2;
            nArray2 = nArray3;
            for (n5 = 0; n5 < n3; ++n5) {
                n4 = 2 * n5;
                nArray[n5] = nArray2[n4] + nArray2[n4 + 1];
            }
            for (n5 = n3; n5 < n2; ++n5) {
                n4 = 2 * n5;
                nArray[n5] = nArray2[n4 - n2] - nArray2[n4 - n2 + 1];
            }
        }
        return nArray;
    }
}

