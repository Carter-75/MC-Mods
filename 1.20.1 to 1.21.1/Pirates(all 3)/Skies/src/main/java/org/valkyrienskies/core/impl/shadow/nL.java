/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.nq_0;

public final class nL
extends nq_0 {
    private static final double d = 1.0E-6;

    public nL() {
        this(1.0E-6);
    }

    private nL(double d2) {
        super(1.0E-6);
    }

    private nL(double d2, double d3) {
        super(d2, d3);
    }

    protected final double j() {
        double d2 = this.d();
        double d3 = this.e();
        double d4 = d2;
        double d5 = this.b(d4);
        double d6 = d3;
        double d7 = this.b(d6);
        if (d5 == 0.0) {
            return d2;
        }
        if (d7 == 0.0) {
            return d3;
        }
        this.c(d2, d3);
        double d8 = this.g();
        double d9 = this.i();
        double d10 = this.h();
        double d11 = Double.POSITIVE_INFINITY;
        while (true) {
            double d12;
            double d13 = 0.5 * (d4 + d6);
            double d14 = this.b(d13);
            if (BY.w(d12) <= d9) {
                return d13;
            }
            double d15 = d14;
            double d16 = 1.0 - d5 * d7 / (d15 * d15);
            double d17 = BY.h(d7) * BY.h(d14) * (d13 - d4) / BY.a(d16);
            double d18 = d13 - d17;
            double d19 = this.b(d18);
            double d20 = BY.e(d10 * BY.w(d18), d8);
            if (BY.w(d18 - d11) <= d20) {
                return d18;
            }
            if (BY.w(d19) <= d9) {
                return d18;
            }
            if (d17 > 0.0) {
                if (BY.h(d5) + BY.h(d19) == 0.0) {
                    d6 = d18;
                    d7 = d19;
                } else {
                    d4 = d18;
                    d6 = d13;
                    d5 = d19;
                    d7 = d14;
                }
            } else if (BY.h(d7) + BY.h(d19) == 0.0) {
                d4 = d18;
                d5 = d19;
            } else {
                d4 = d13;
                d6 = d18;
                d5 = d14;
                d7 = d19;
            }
            d11 = d18;
        }
    }
}

