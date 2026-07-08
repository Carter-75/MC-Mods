/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.vL;
import org.valkyrienskies.core.impl.shadow.wa_0;
import org.valkyrienskies.core.impl.shadow.wm_0;

public final class vZ
extends vL {
    private static final String f = "Higham-Hall 5(4)";
    private static final double[] g = new double[]{0.2222222222222222, 0.3333333333333333, 0.5, 0.6, 1.0, 1.0};
    private static final double[][] m = new double[][]{{0.2222222222222222}, {0.08333333333333333, 0.25}, {0.125, 0.0, 0.375}, {0.182, -0.27, 0.624, 0.064}, {-0.55, 1.35, 2.4, -7.2, 5.0}, {0.08333333333333333, 0.0, 0.84375, -1.3333333333333333, 1.3020833333333333, 0.10416666666666667}};
    private static final double[] n = new double[]{0.08333333333333333, 0.0, 0.84375, -1.3333333333333333, 1.3020833333333333, 0.10416666666666667, 0.0};
    private static final double[] o = new double[]{-0.05, 0.0, 0.50625, -1.2, 0.78125, 0.0625, -0.1};

    private vZ(double d2, double d3, double d4, double d5) {
        super(f, false, g, m, n, (wm_0)new wa_0(), d2, d3, d4, d5);
    }

    private vZ(double d2, double d3, double[] dArray, double[] dArray2) {
        super(f, false, g, m, n, (wm_0)new wa_0(), d2, d3, dArray, dArray2);
    }

    public final int n() {
        return 5;
    }

    protected final double a(double[][] dArray, double[] dArray2, double[] dArray3, double d2) {
        double d3 = 0.0;
        for (int i2 = 0; i2 < this.l; ++i2) {
            double d4;
            double d5 = o[0] * dArray[0][i2];
            for (int i3 = 1; i3 < o.length; ++i3) {
                d5 += o[i3] * dArray[i3][i2];
            }
            double d6 = BY.e(BY.w(dArray2[i2]), BY.w(dArray3[i2]));
            double d7 = this.j == null ? this.h + this.i * d6 : this.j[i2] + this.k[i2] * d6;
            double d8 = d4 = d2 * d5 / d7;
            d3 += d8 * d8;
        }
        return BY.a(d3 / (double)this.l);
    }
}

