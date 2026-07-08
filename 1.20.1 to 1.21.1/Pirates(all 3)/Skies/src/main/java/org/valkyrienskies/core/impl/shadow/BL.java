/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Arrays;
import org.valkyrienskies.core.impl.shadow.nQ;
import org.valkyrienskies.core.impl.shadow.oS;
import org.valkyrienskies.core.impl.shadow.oV;
import org.valkyrienskies.core.impl.shadow.px_0;

public final class BL {
    private static final int[] a = new int[]{1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 131072, 262144, 524288, 0x100000, 0x200000, 0x400000, 0x800000, 0x1000000, 0x2000000, 0x4000000, 0x8000000, 0x10000000, 0x20000000, 0x40000000};

    private BL() {
    }

    public static double[] a(double[] dArray, double d2) {
        int n2 = 0;
        while (n2 < dArray.length) {
            int n3 = n2++;
            dArray[n3] = dArray[n3] * d2;
        }
        return dArray;
    }

    private static nQ[] a(nQ[] nQArray, double d2) {
        for (int i2 = 0; i2 < nQArray.length; ++i2) {
            nQ nQ2 = nQArray[i2];
            nQ nQ3 = nQ2;
            nQ3 = nQArray[i2];
            nQArray[i2] = new nQ(d2 * nQ2.d, d2 * nQ3.c);
        }
        return nQArray;
    }

    public static double[][] a(nQ[] nQArray) {
        double[][] dArray = new double[2][nQArray.length];
        double[] dArray2 = dArray[0];
        double[] dArray3 = dArray[1];
        for (int i2 = 0; i2 < nQArray.length; ++i2) {
            nQ nQ2;
            nQ nQ3 = nQ2 = nQArray[i2];
            dArray2[i2] = nQ3.d;
            nQ3 = nQ2;
            dArray3[i2] = nQ3.c;
        }
        return dArray;
    }

    public static nQ[] a(double[][] object) {
        if (((double[][])object).length != 2) {
            throw new oS(((double[][])object).length, 2);
        }
        double[] dArray = object[0];
        if (dArray.length != ((double[][])(object = (Object)object[1])).length) {
            throw new oS(((double[][])object).length, dArray.length);
        }
        int n2 = dArray.length;
        nQ[] nQArray = new nQ[n2];
        for (int i2 = 0; i2 < n2; ++i2) {
            nQArray[i2] = new nQ(dArray[i2], (double)object[i2]);
        }
        return nQArray;
    }

    private static int a(int n2) {
        int n3 = Arrays.binarySearch(a, n2);
        if (n3 < 0) {
            throw new oV(px_0.NOT_POWER_OF_TWO_CONSIDER_PADDING, n2);
        }
        return n3;
    }
}

