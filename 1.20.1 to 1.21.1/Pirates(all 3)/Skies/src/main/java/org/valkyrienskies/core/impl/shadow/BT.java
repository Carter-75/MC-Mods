/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.cq_0;
import org.valkyrienskies.core.impl.shadow.oR;
import org.valkyrienskies.core.impl.shadow.pc_0;
import org.valkyrienskies.core.impl.shadow.px_0;

public abstract class BT {
    private static final double a = 1.0E-8;

    protected abstract double b(int var1, double var2);

    protected abstract double a(int var1, double var2);

    private double a(double d2) {
        return this.a(d2, 1.0E-8, Integer.MAX_VALUE);
    }

    private double a(double d2, double d3) {
        return this.a(d2, d3, Integer.MAX_VALUE);
    }

    private double a(double d2, int n2) {
        return this.a(d2, 1.0E-8, n2);
    }

    public final double a(double d2, double d3, int n2) {
        int n3;
        double d4 = this.b(0, d2);
        if (cq_0.b(d4, 0.0, 1.0E-50)) {
            d4 = 1.0E-50;
        }
        double d5 = 0.0;
        double d6 = d4;
        double d7 = d4;
        for (n3 = 1; n3 < n2; ++n3) {
            double d8;
            double d9;
            double d10;
            double d11 = this.b(n3, d2);
            double d12 = d11 + (d10 = this.a(n3, d2)) * d5;
            if (cq_0.b(d12, 0.0, 1.0E-50)) {
                d12 = 1.0E-50;
            }
            if (cq_0.b(d9 = d11 + d10 / d6, 0.0, 1.0E-50)) {
                d9 = 1.0E-50;
            }
            if (Double.isInfinite(d7 = d4 * (d8 = d9 * (d12 = 1.0 / d12)))) {
                throw new oR(px_0.CONTINUED_FRACTION_INFINITY_DIVERGENCE, d2);
            }
            if (Double.isNaN(d7)) {
                throw new oR(px_0.CONTINUED_FRACTION_NAN_DIVERGENCE, d2);
            }
            if (BY.w(d8 - 1.0) < d3) break;
            d5 = d12;
            d6 = d9;
            d4 = d7;
        }
        if (n3 >= n2) {
            throw new pc_0(px_0.NON_CONVERGENT_CONTINUED_FRACTION, n2, d2);
        }
        return d7;
    }
}

