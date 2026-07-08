/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.vF;
import org.valkyrienskies.core.impl.shadow.vL;
import org.valkyrienskies.core.impl.shadow.wm_0;

public final class vE
extends vL {
    private static final String f = "Dormand-Prince 5(4)";
    private static final double[] g = new double[]{0.2, 0.3, 0.8, 0.8888888888888888, 1.0, 1.0};
    private static final double[][] m = new double[][]{{0.2}, {0.075, 0.225}, {0.9777777777777777, -3.7333333333333334, 3.5555555555555554}, {2.9525986892242035, -11.595793324188385, 9.822892851699436, -0.2908093278463649}, {2.8462752525252526, -10.757575757575758, 8.906422717743473, 0.2784090909090909, -0.2735313036020583}, {0.09114583333333333, 0.0, 0.44923629829290207, 0.6510416666666666, -0.322376179245283, 0.13095238095238096}};
    private static final double[] n = new double[]{0.09114583333333333, 0.0, 0.44923629829290207, 0.6510416666666666, -0.322376179245283, 0.13095238095238096, 0.0};
    private static final double o = 0.0012326388888888888;
    private static final double p = -0.0042527702905061394;
    private static final double q = 0.03697916666666667;
    private static final double r = -0.05086379716981132;
    private static final double s = 0.0419047619047619;
    private static final double t = -0.025;

    private vE(double d2, double d3, double d4, double d5) {
        super(f, true, g, m, n, (wm_0)new vF(), d2, d3, d4, d5);
    }

    private vE(double d2, double d3, double[] dArray, double[] dArray2) {
        super(f, true, g, m, n, (wm_0)new vF(), d2, d3, dArray, dArray2);
    }

    public final int n() {
        return 5;
    }

    protected final double a(double[][] dArray, double[] dArray2, double[] dArray3, double d2) {
        double d3 = 0.0;
        for (int i2 = 0; i2 < this.l; ++i2) {
            double d4;
            double d5 = 0.0012326388888888888 * dArray[0][i2] + -0.0042527702905061394 * dArray[2][i2] + 0.03697916666666667 * dArray[3][i2] + -0.05086379716981132 * dArray[4][i2] + 0.0419047619047619 * dArray[5][i2] + -0.025 * dArray[6][i2];
            double d6 = BY.e(BY.w(dArray2[i2]), BY.w(dArray3[i2]));
            double d7 = this.j == null ? this.h + this.i * d6 : this.j[i2] + this.k[i2] * d6;
            double d8 = d4 = d2 * d5 / d7;
            d3 += d8 * d8;
        }
        return BY.a(d3 / (double)this.l);
    }
}

