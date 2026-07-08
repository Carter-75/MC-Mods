/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.cq_0;
import org.valkyrienskies.core.impl.shadow.nP;
import org.valkyrienskies.core.impl.shadow.nq_0;
import org.valkyrienskies.core.impl.shadow.pe_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.nz
 */
public final class nz_0
extends nq_0 {
    private static final double d = 1.0E-6;

    public nz_0() {
        this(1.0E-6);
    }

    public nz_0(double d2) {
        super(d2);
    }

    private nz_0(double d2, double d3) {
        super(d2, d3);
    }

    private nz_0(double d2, double d3, double d4) {
        super(d2, d3, d4);
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
        double d12 = this.b(d7);
        if (BY.w(d4) <= d8) {
            return d7;
        }
        double d13 = this.b(d5);
        if (BY.w(d3) <= d8) {
            return d5;
        }
        if (d12 * d13 < 0.0) {
            return this.a(d5, d7, d13, d12);
        }
        double d14 = this.b(d6);
        if (BY.w(d2) <= d8) {
            return d6;
        }
        if (d12 * d14 < 0.0) {
            return this.a(d7, d6, d12, d14);
        }
        throw new pe_0(d5, d6, d13, d14);
    }

    private double a(double d2, double d3, double d4, double d5) {
        double d6;
        double d7 = d2;
        double d8 = d4;
        double d9 = d3;
        double d10 = d5;
        double d11 = d7;
        double d12 = d8;
        double d13 = d6 = d9 - d7;
        double d14 = this.g();
        double d15 = this.h();
        while (true) {
            double d16;
            if (BY.w(d12) < BY.w(d10)) {
                d7 = d9;
                d9 = d11;
                d11 = d7;
                d8 = d10;
                d10 = d12;
                d12 = d8;
            }
            double d17 = d15 * 2.0 * BY.w(d9) + d14;
            double d18 = 0.5 * (d11 - d9);
            if (BY.w(d18) <= d17 || cq_0.a(d10, 0.0)) {
                return d9;
            }
            if (BY.w(d13) < d17 || BY.w(d8) <= BY.w(d10)) {
                d13 = d6 = d18;
            } else {
                double d19;
                double d20;
                double d21 = d10 / d8;
                if (d7 == d11) {
                    d20 = d18 * 2.0 * d21;
                    d19 = 1.0 - d21;
                } else {
                    d19 = d8 / d12;
                    double d22 = d10 / d12;
                    d20 = d21 * (d18 * 2.0 * d19 * (d19 - d22) - (d9 - d7) * (d22 - 1.0));
                    d19 = (d19 - 1.0) * (d22 - 1.0) * (d21 - 1.0);
                }
                if (d20 > 0.0) {
                    d19 = -d19;
                } else {
                    d20 = -d20;
                }
                d21 = d13;
                d13 = d6;
                if (d20 >= d18 * 1.5 * d19 - BY.w(d17 * d19) || d20 >= BY.w(d21 * 0.5 * d19)) {
                    d13 = d6 = d18;
                } else {
                    d6 = d20 / d19;
                }
            }
            d7 = d9;
            d8 = d10;
            d9 = BY.w(d6) > d17 ? (d9 += d6) : (d18 > 0.0 ? (d9 += d17) : (d9 -= d17));
            d10 = this.b(d9);
            if (!(d16 > 0.0 && d12 > 0.0) && (!(d10 <= 0.0) || !(d12 <= 0.0))) continue;
            d11 = d7;
            d12 = d8;
            d13 = d6 = d9 - d7;
        }
    }
}

