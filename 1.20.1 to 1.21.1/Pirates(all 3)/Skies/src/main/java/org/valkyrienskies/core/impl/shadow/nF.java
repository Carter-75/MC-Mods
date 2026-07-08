/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.nP;
import org.valkyrienskies.core.impl.shadow.nq_0;
import org.valkyrienskies.core.impl.shadow.pe_0;

public final class nF
extends nq_0 {
    private static final double d = 1.0E-6;

    public nF() {
        this(1.0E-6);
    }

    private nF(double d2) {
        super(1.0E-6);
    }

    private nF(double d2, double d3) {
        super(d2, d3);
    }

    protected final double j() {
        double d2;
        double d3;
        double d4;
        double d5 = this.d();
        double d6 = d4 = this.e();
        double d7 = d5;
        nP.b(d7, d6);
        double d8 = this.h();
        double d9 = this.g();
        double d10 = this.i();
        double d11 = d5;
        double d12 = this.b(d11);
        if (BY.w(d3) < d10) {
            return d11;
        }
        double d13 = d4;
        double d14 = this.b(d13);
        if (BY.w(d2) < d10) {
            return d13;
        }
        if (d12 * d14 > 0.0) {
            throw new pe_0(d11, d13, d12, d14);
        }
        double d15 = 0.5 * (d11 + d13);
        double d16 = this.b(d15);
        double d17 = Double.POSITIVE_INFINITY;
        while (true) {
            double d18;
            double d19;
            double d20;
            double d21;
            double d22;
            double d23 = (d15 - d13) / (d13 - d11);
            double d24 = d23 * (d16 - (d23 + 1.0) * d14 + d23 * d12);
            double d25 = d23;
            double d26 = (d23 * 2.0 + 1.0) * d16 - (d23 + 1.0) * (d23 + 1.0) * d14 + d25 * d25 * d12;
            double d27 = (d23 + 1.0) * d16;
            double d28 = d26;
            double d29 = d28 * d28 - d24 * 4.0 * d27;
            if (d22 >= 0.0) {
                d21 = d26 + BY.a(d29);
                d20 = d26 - BY.a(d29);
                d19 = BY.w(d21) > BY.w(d20) ? d21 : d20;
            } else {
                double d30 = d26;
                d19 = BY.a(d30 * d30 - d29);
            }
            if (d19 != 0.0) {
                for (d18 = d15 - d27 * 2.0 * (d15 - d13) / d19; d18 == d13 || d18 == d15; d18 += d9) {
                }
            } else {
                d18 = d5 + BY.a() * (d4 - d5);
                d17 = Double.POSITIVE_INFINITY;
            }
            d21 = this.b(d18);
            d20 = BY.e(d8 * BY.w(d18), d9);
            if (BY.w(d18 - d17) <= d20 || BY.w(d21) <= d10) {
                return d18;
            }
            d11 = d13;
            d12 = d14;
            d13 = d15;
            d14 = d16;
            d15 = d18;
            d16 = d21;
            d17 = d18;
        }
    }
}

