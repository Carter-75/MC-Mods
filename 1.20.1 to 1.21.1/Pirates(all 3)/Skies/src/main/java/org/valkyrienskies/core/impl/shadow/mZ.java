/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.lb_0;
import org.valkyrienskies.core.impl.shadow.po_0;

final class mZ
implements lb_0 {
    private static final short a = 4;
    private final double[][][] b = new double[4][4][4];

    mZ(double[] dArray) {
        for (int i2 = 0; i2 < 4; ++i2) {
            for (int i3 = 0; i3 < 4; ++i3) {
                for (int i4 = 0; i4 < 4; ++i4) {
                    this.b[i2][i3][i4] = dArray[i2 + 4 * (i3 + 4 * i4)];
                }
            }
        }
    }

    public final double a(double d2, double d3, double d4) {
        if (d2 < 0.0 || d2 > 1.0) {
            throw new po_0(d2, (Number)0, 1);
        }
        if (d3 < 0.0 || d3 > 1.0) {
            throw new po_0(d3, (Number)0, 1);
        }
        if (d4 < 0.0 || d4 > 1.0) {
            throw new po_0(d4, (Number)0, 1);
        }
        double d5 = d2;
        double d6 = d5 * d5;
        double d7 = d6 * d2;
        double[] dArray = new double[]{1.0, d2, d6, d7};
        double d8 = d3;
        double d9 = d8 * d8;
        double d10 = d9 * d3;
        double[] dArray2 = new double[]{1.0, d3, d9, d10};
        double d11 = d4;
        double d12 = d11 * d11;
        double d13 = d12 * d4;
        double[] dArray3 = new double[]{1.0, d4, d12, d13};
        double d14 = 0.0;
        for (int i2 = 0; i2 < 4; ++i2) {
            for (int i3 = 0; i3 < 4; ++i3) {
                for (int i4 = 0; i4 < 4; ++i4) {
                    d14 += this.b[i2][i3][i4] * dArray[i2] * dArray2[i3] * dArray3[i4];
                }
            }
        }
        return d14;
    }
}

