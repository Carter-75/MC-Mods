/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.nP;
import org.valkyrienskies.core.impl.shadow.nq_0;

public final class nE
extends nq_0 {
    private static final double d = 1.0E-6;

    public nE() {
        this(1.0E-6);
    }

    private nE(double d2) {
        super(1.0E-6);
    }

    private nE(double d2, double d3) {
        super(d2, d3);
    }

    protected final double j() {
        double d2;
        double d3;
        double d4;
        double d5 = this.d();
        double d6 = this.e();
        double d7 = this.f();
        double d8 = this.i();
        double d9 = d6;
        double d10 = d7;
        double d11 = d5;
        nP.b(d11, d10, d9);
        double d12 = this.b(d5);
        if (BY.w(d4) < d8) {
            return d5;
        }
        double d13 = this.b(d6);
        if (BY.w(d3) < d8) {
            return d6;
        }
        double d14 = this.b(d7);
        if (BY.w(d2) < d8) {
            return d7;
        }
        this.c(d5, d6);
        if (this.a(d5, d7)) {
            return this.a(d5, d7, d12, d14);
        }
        return this.a(d7, d6, d14, d13);
    }

    private double a(double d2, double d3, double d4, double d5) {
        double d6 = this.h();
        double d7 = this.g();
        double d8 = this.i();
        double d9 = d2;
        double d10 = d4;
        double d11 = d3;
        double d12 = d5;
        double d13 = 0.5 * (d9 + d11);
        double d14 = this.b(d13);
        double d15 = Double.POSITIVE_INFINITY;
        while (true) {
            double d16 = (d14 - d10) / (d13 - d9);
            double d17 = (d12 - d14) / (d11 - d13);
            double d18 = (d17 - d16) / (d11 - d9);
            double d19 = d16 + (d13 - d9) * d18;
            double d20 = d19 * d19 - d14 * 4.0 * d18;
            double d21 = d13 + d14 * -2.0 / (d19 + BY.a(d20));
            double d22 = d13 + d14 * -2.0 / (d19 - BY.a(d20));
            double d23 = nE.a(d9, d21, d11) ? d21 : d22;
            double d24 = this.b(d23);
            double d25 = BY.e(d6 * BY.w(d23), d7);
            if (BY.w(d23 - d15) <= d25 || BY.w(d24) <= d8) {
                return d23;
            }
            boolean bl = d23 < d13 && d13 - d9 > 0.95 * (d11 - d9) || d23 > d13 && d11 - d13 > 0.95 * (d11 - d9) || d23 == d13;
            if (!bl) {
                d9 = d23 < d13 ? d9 : d13;
                d10 = d23 < d13 ? d10 : d14;
                d11 = d23 > d13 ? d11 : d13;
                d12 = d23 > d13 ? d12 : d14;
                d13 = d23;
                d14 = d24;
                d15 = d23;
                continue;
            }
            double d26 = 0.5 * (d9 + d11);
            double d27 = this.b(d26);
            if (BY.h(d10) + BY.h(d27) == 0.0) {
                d11 = d26;
                d12 = d27;
            } else {
                d9 = d26;
                d10 = d27;
            }
            d13 = 0.5 * (d9 + d11);
            d14 = this.b(d13);
            d15 = Double.POSITIVE_INFINITY;
        }
    }
}

