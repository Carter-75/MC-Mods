/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.ch_0;
import org.valkyrienskies.core.impl.shadow.kP;
import org.valkyrienskies.core.impl.shadow.po_0;

final class mC
implements kP {
    private static final short a = 4;
    private final double[][] b = new double[4][4];

    mC(double[] dArray) {
        for (int i2 = 0; i2 < 4; ++i2) {
            double[] dArray2 = this.b[i2];
            for (int i3 = 0; i3 < 4; ++i3) {
                dArray2[i3] = dArray[(i3 << 2) + i2];
            }
        }
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
        double[][] dArray3 = this.b;
        double d10 = 0.0;
        for (int i2 = 0; i2 < 4; ++i2) {
            double d11 = ch_0.h(dArray3[i2], dArray2);
            d10 += d11 * dArray[i2];
        }
        return d10;
    }

    private static double a(double[] dArray, double[] dArray2, double[][] dArray3) {
        double d2 = 0.0;
        for (int i2 = 0; i2 < 4; ++i2) {
            double d3 = ch_0.h(dArray3[i2], dArray2);
            d2 += d3 * dArray[i2];
        }
        return d2;
    }
}

