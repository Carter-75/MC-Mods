/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.oe_0;
import org.valkyrienskies.core.impl.shadow.pk_0;
import org.valkyrienskies.core.impl.shadow.px_0;
import org.valkyrienskies.core.impl.shadow.zF;
import org.valkyrienskies.core.impl.shadow.zR;
import org.valkyrienskies.core.impl.shadow.zY;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.op
 */
public final class op_0
extends oe_0 {
    private static double c = 1.0E-9;
    private static final long d = 20120524L;
    final double b;
    private final double e;
    private final double f;
    private final double g;
    private final double h;
    private final double i;
    private final double j;
    private final double k;
    private final double l;
    private final double m;

    public op_0(double d2, double d3) {
        this(d2, 2.0, 1.0E-9);
    }

    private op_0(double d2, double d3, double d4) {
        this(new zR(), d2, d3, 1.0E-9);
    }

    private op_0(zF zF2, double d2, double d3) {
        this(zF2, d2, d3, 1.0E-9);
    }

    public op_0(zF zF2, double d2, double d3, double d4) {
        super(zF2);
        if (d2 <= 0.0) {
            throw new pk_0(px_0.SHAPE, d2);
        }
        if (d3 <= 0.0) {
            throw new pk_0(px_0.SCALE, d3);
        }
        this.b = d2;
        this.e = d3;
        this.m = d4;
        this.f = d2 + 4.7421875 + 0.5;
        double d5 = Math.E / (Math.PI * 2 * this.f);
        this.i = d2 * BY.a(d5) / zY.b(d2);
        this.j = BY.k(d2) + 0.5 * BY.k(d5) - BY.k(zY.b(d2));
        this.g = this.i / d3 * BY.a(this.f, -d2) * BY.i(d2 + 4.7421875);
        this.h = this.j - BY.k(d3) - BY.k(this.f) * d2 + d2 + 4.7421875;
        this.k = d2 + 4.7421875 - BY.k(Double.MAX_VALUE);
        this.l = BY.k(Double.MAX_VALUE) / (d2 - 1.0);
    }

    @Deprecated
    private double k() {
        return this.b;
    }

    public final double j() {
        return this.b;
    }

    @Deprecated
    private double l() {
        return this.e;
    }

    private double m() {
        return this.e;
    }

    public final double d(double d2) {
        if (d2 < 0.0) {
            return 0.0;
        }
        double d3 = d2 / this.e;
        if (d3 <= this.k || BY.k(d3) >= this.l) {
            double d4 = (d3 - this.f) / this.f;
            double d5 = this.b * (BY.l(d4) - d4);
            double d6 = -d3 * 5.2421875 / this.f + 4.7421875 + d5;
            return this.i / d2 * BY.i(d6);
        }
        return this.g * BY.i(-d3) * BY.a(d3, this.b - 1.0);
    }

    public final double c(double d2) {
        if (d2 < 0.0) {
            return Double.NEGATIVE_INFINITY;
        }
        double d3 = d2 / this.e;
        if (d3 <= this.k || BY.k(d3) >= this.l) {
            double d4 = (d3 - this.f) / this.f;
            double d5 = this.b * (BY.l(d4) - d4);
            double d6 = -d3 * 5.2421875 / this.f + 4.7421875 + d5;
            return this.j - BY.k(d2) + d6;
        }
        return this.h - d3 + BY.k(d3) * (this.b - 1.0);
    }

    public final double e(double d2) {
        double d3 = d2 <= 0.0 ? 0.0 : zY.a(this.b, d2 / this.e);
        return d3;
    }

    protected final double a() {
        return this.m;
    }

    public final double c() {
        return this.b * this.e;
    }

    public final double d() {
        return this.b * this.e * this.e;
    }

    public final double e() {
        return 0.0;
    }

    public final double f() {
        return Double.POSITIVE_INFINITY;
    }

    public final boolean g() {
        return true;
    }

    public final boolean h() {
        return false;
    }

    public final boolean i() {
        return true;
    }

    public final double b() {
        double d2;
        if (this.b < 1.0) {
            double d3;
            while (true) {
                double d4;
                double d5;
                double d6 = this.a.nextDouble();
                double d7 = 1.0 + this.b / Math.E;
                double d8 = d7 * d6;
                if (d5 <= 1.0) {
                    d3 = BY.a(d8, 1.0 / this.b);
                    d4 = this.a.nextDouble();
                    if (d4 > BY.i(-d3)) continue;
                    return this.e * d3;
                }
                d3 = -1.0 * BY.k((d7 - d8) / this.b);
                d4 = this.a.nextDouble();
                if (!(d4 > BY.a(d3, this.b - 1.0))) break;
            }
            return this.e * d3;
        }
        double d9 = this.b - 0.3333333333333333;
        double d10 = 1.0 / (3.0 * BY.a(d9));
        while (true) {
            double d11;
            double d12;
            if ((d2 = (1.0 + d10 * (d12 = this.a.nextGaussian())) * (1.0 + d10 * d12) * (1.0 + d10 * d12)) <= 0.0) {
                continue;
            }
            double d13 = d12;
            double d14 = d13 * d13;
            double d15 = this.a.nextDouble();
            if (d11 < 1.0 - d14 * 0.0331 * d14) {
                return this.e * d9 * d2;
            }
            if (BY.k(d15) < d14 * 0.5 + d9 * (1.0 - d2 + BY.k(d2))) break;
        }
        return this.e * d9 * d2;
    }
}

