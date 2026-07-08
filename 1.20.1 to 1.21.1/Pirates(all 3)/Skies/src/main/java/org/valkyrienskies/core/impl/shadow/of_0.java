/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.cq_0;
import org.valkyrienskies.core.impl.shadow.oe_0;
import org.valkyrienskies.core.impl.shadow.pn_0;
import org.valkyrienskies.core.impl.shadow.pw_0;
import org.valkyrienskies.core.impl.shadow.px_0;
import org.valkyrienskies.core.impl.shadow.zF;
import org.valkyrienskies.core.impl.shadow.zR;
import org.valkyrienskies.core.impl.shadow.zW;
import org.valkyrienskies.core.impl.shadow.zY;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.of
 */
public final class of_0
extends oe_0 {
    private static double b = 1.0E-9;
    private static final long c = -1221965979403477668L;
    private final double d;
    private final double e;
    private double f;
    private final double g;

    private of_0(double d2, double d3) {
        this(d2, d3, 1.0E-9);
    }

    private of_0(double d2, double d3, double d4) {
        this(new zR(), d2, d3, 1.0E-9);
    }

    private of_0(zF zF2, double d2, double d3) {
        this(zF2, d2, d3, 1.0E-9);
    }

    public of_0(zF zF2, double d2, double d3, double d4) {
        super(zF2);
        this.d = d2;
        this.e = d3;
        this.f = Double.NaN;
        this.g = d4;
    }

    private double j() {
        return this.d;
    }

    private double k() {
        return this.e;
    }

    private void l() {
        if (Double.isNaN(this.f)) {
            this.f = zY.a(this.d) + zY.a(this.e) - zY.a(this.d + this.e);
        }
    }

    public final double d(double d2) {
        double d3 = ((oe_0)this).c(d2);
        if (d3 == Double.NEGATIVE_INFINITY) {
            return 0.0;
        }
        return BY.i(d3);
    }

    public final double c(double d2) {
        this.l();
        if (d2 < 0.0 || d2 > 1.0) {
            return Double.NEGATIVE_INFINITY;
        }
        if (d2 == 0.0) {
            if (this.d < 1.0) {
                throw new pn_0((pw_0)px_0.CANNOT_COMPUTE_BETA_DENSITY_AT_0_FOR_SOME_ALPHA, (Number)this.d, 1, false);
            }
            return Double.NEGATIVE_INFINITY;
        }
        if (d2 == 1.0) {
            if (this.e < 1.0) {
                throw new pn_0((pw_0)px_0.CANNOT_COMPUTE_BETA_DENSITY_AT_1_FOR_SOME_BETA, (Number)this.e, 1, false);
            }
            return Double.NEGATIVE_INFINITY;
        }
        double d3 = BY.k(d2);
        double d4 = BY.l(-d2);
        return (this.d - 1.0) * d3 + (this.e - 1.0) * d4 - this.f;
    }

    public final double e(double d2) {
        if (d2 <= 0.0) {
            return 0.0;
        }
        if (d2 >= 1.0) {
            return 1.0;
        }
        return zW.a(d2, this.d, this.e);
    }

    protected final double a() {
        return this.g;
    }

    public final double c() {
        of_0 of_02 = this;
        double d2 = of_02.d;
        of_0 of_03 = this;
        return d2 / (d2 + of_03.e);
    }

    public final double d() {
        double d2;
        of_0 of_02 = this;
        double d3 = of_02.d;
        of_02 = this;
        double d4 = of_02.e;
        double d5 = d2 = d3 + d4;
        return d3 * d4 / (d5 * d5 * (d2 + 1.0));
    }

    public final double e() {
        return 0.0;
    }

    public final double f() {
        return 1.0;
    }

    public final boolean g() {
        return false;
    }

    public final boolean h() {
        return false;
    }

    public final boolean i() {
        return true;
    }

    /*
     * Enabled aggressive block sorting
     */
    public final double b() {
        double d2;
        double d3;
        double d4 = this.e;
        double d5 = this.d;
        zF zF2 = this.a;
        double d6 = BY.d(d5, d4);
        double d7 = BY.e(d5, d4);
        if (d6 > 1.0) {
            double d8;
            double d9;
            double d10;
            double d11;
            double d12 = d7;
            double d13 = d6;
            double d14 = d5;
            double d15 = d13 + d12;
            double d16 = BY.a((d15 - 2.0) / (d13 * 2.0 * d12 - d15));
            double d17 = d13 + 1.0 / d16;
            do {
                double d18 = zF2.nextDouble();
                double d19 = zF2.nextDouble();
                double d20 = d16 * (BY.k(d18) - BY.l(-d18));
                d9 = d13 * BY.i(d20);
                double d21 = d18;
                d11 = d17 * d20 - 1.3862944;
                double d22 = d13 + d11 - d9;
                double d23 = d21 * d21 * d19;
                if (d22 + 2.609438 >= d23 * 5.0 || d22 >= (d8 = BY.k(d23))) break;
                d10 = d15;
            } while (d11 + d10 * (BY.k(d10) - BY.k(d12 + d9)) < d8);
            d9 = BY.d(d9, Double.MAX_VALUE);
            if (cq_0.a(d13, d14)) {
                d3 = d9 / (d12 + d9);
                return d3;
            }
            double d24 = d12;
            return d24 / (d24 + d9);
        }
        double d25 = d6;
        double d26 = d7;
        double d27 = d5;
        double d28 = d26 + d25;
        double d29 = 1.0 / d25;
        double d30 = d26 + 1.0 - d25;
        double d31 = d30 * (0.0138889 + d25 * 0.0416667) / (d26 * d29 - 0.777778);
        double d32 = 0.25 + (0.5 + 0.25 / d30) * d25;
        while (true) {
            double d33;
            double d34 = zF2.nextDouble();
            double d35 = zF2.nextDouble();
            double d36 = d34 * d35;
            double d37 = d34 * d36;
            if (d34 < 0.5) {
                if (d35 * 0.25 + d37 - d36 >= d31) {
                    continue;
                }
            } else {
                if (d37 <= 0.25) {
                    d33 = d29 * (BY.k(d34) - BY.l(-d34));
                    d2 = d26 * BY.i(d33);
                    break;
                }
                if (d37 >= d32) continue;
            }
            d33 = d29 * (BY.k(d34) - BY.l(-d34));
            d2 = d26 * BY.i(d33);
            double d38 = d28;
            if (d38 * (BY.k(d38) - BY.k(d25 + d2) + d33) - 1.3862944 >= BY.k(d37)) break;
        }
        d2 = BY.d(d2, Double.MAX_VALUE);
        if (cq_0.a(d26, d27)) {
            return d2 / (d25 + d2);
        }
        double d39 = d25;
        d3 = d39 / (d39 + d2);
        return d3;
    }

    static final class a {
        private a() {
        }

        static double a(zF zF2, double d2, double d3) {
            double d4 = BY.d(d2, d3);
            double d5 = BY.e(d2, d3);
            if (d4 > 1.0) {
                return org.valkyrienskies.core.impl.shadow.of$a.a(zF2, d2, d4, d5);
            }
            return org.valkyrienskies.core.impl.shadow.of$a.b(zF2, d2, d5, d4);
        }

        private static double a(zF zF2, double d2, double d3, double d4) {
            double d5;
            double d6;
            double d7;
            double d8;
            double d9 = d3 + d4;
            double d10 = BY.a((d9 - 2.0) / (d3 * 2.0 * d4 - d9));
            double d11 = d3 + 1.0 / d10;
            do {
                double d12 = zF2.nextDouble();
                double d13 = zF2.nextDouble();
                double d14 = d10 * (BY.k(d12) - BY.l(-d12));
                d6 = d3 * BY.i(d14);
                double d15 = d12;
                d8 = d11 * d14 - 1.3862944;
                double d16 = d3 + d8 - d6;
                double d17 = d15 * d15 * d13;
                if (d16 + 2.609438 >= d17 * 5.0 || d16 >= (d5 = BY.k(d17))) break;
                d7 = d9;
            } while (d8 + d7 * (BY.k(d7) - BY.k(d4 + d6)) < d5);
            d6 = BY.d(d6, Double.MAX_VALUE);
            if (cq_0.a(d3, d2)) {
                return d6 / (d4 + d6);
            }
            double d18 = d4;
            return d18 / (d18 + d6);
        }

        private static double b(zF zF2, double d2, double d3, double d4) {
            double d5;
            double d6 = d3 + d4;
            double d7 = 1.0 / d4;
            double d8 = d3 + 1.0 - d4;
            double d9 = d8 * (0.0138889 + d4 * 0.0416667) / (d3 * d7 - 0.777778);
            double d10 = 0.25 + (0.5 + 0.25 / d8) * d4;
            while (true) {
                double d11;
                double d12 = zF2.nextDouble();
                double d13 = zF2.nextDouble();
                double d14 = d12 * d13;
                double d15 = d12 * d14;
                if (d12 < 0.5) {
                    if (d13 * 0.25 + d15 - d14 >= d9) {
                        continue;
                    }
                } else {
                    if (d15 <= 0.25) {
                        d11 = d7 * (BY.k(d12) - BY.l(-d12));
                        d5 = d3 * BY.i(d11);
                        break;
                    }
                    if (d15 >= d10) continue;
                }
                d11 = d7 * (BY.k(d12) - BY.l(-d12));
                d5 = d3 * BY.i(d11);
                double d16 = d6;
                if (d16 * (BY.k(d16) - BY.k(d4 + d5) + d11) - 1.3862944 >= BY.k(d15)) break;
            }
            d5 = BY.d(d5, Double.MAX_VALUE);
            if (cq_0.a(d3, d2)) {
                return d5 / (d4 + d5);
            }
            double d17 = d4;
            return d17 / (d17 + d5);
        }
    }
}

