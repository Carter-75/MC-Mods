/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.oe_0;
import org.valkyrienskies.core.impl.shadow.pk_0;
import org.valkyrienskies.core.impl.shadow.pm_0;
import org.valkyrienskies.core.impl.shadow.px_0;
import org.valkyrienskies.core.impl.shadow.zF;
import org.valkyrienskies.core.impl.shadow.zR;
import org.valkyrienskies.core.impl.shadow.zX;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.ox
 */
public final class ox_0
extends oe_0 {
    private static double b = 1.0E-9;
    private static final long c = 20120112L;
    private static final double d = BY.a(Math.PI * 2);
    private static final double e = BY.a(2.0);
    private final double f;
    private final double g;
    private final double h;
    private final double i;

    public ox_0() {
        this(0.0, 1.0);
    }

    private ox_0(double d2, double d3) {
        this(0.0, 1.0, 1.0E-9);
    }

    private ox_0(double d2, double d3, double d4) {
        this(new zR(), d2, d3, 1.0E-9);
    }

    private ox_0(zF zF2, double d2, double d3) {
        this(zF2, d2, d3, 1.0E-9);
    }

    private ox_0(zF zF2, double d2, double d3, double d4) {
        super(zF2);
        if (d3 <= 0.0) {
            throw new pk_0(px_0.SHAPE, d3);
        }
        this.f = d2;
        this.g = d3;
        this.h = BY.k(d3) + 0.5 * BY.k(Math.PI * 2);
        this.i = d4;
    }

    private double j() {
        return this.f;
    }

    private double k() {
        return this.g;
    }

    public final double d(double d2) {
        if (d2 <= 0.0) {
            return 0.0;
        }
        double d3 = BY.k(d2) - this.f;
        double d4 = d3 / this.g;
        return BY.i(d4 * -0.5 * d4) / (this.g * d * d2);
    }

    public final double c(double d2) {
        if (d2 <= 0.0) {
            return Double.NEGATIVE_INFINITY;
        }
        double d3 = BY.k(d2);
        double d4 = d3 - this.f;
        double d5 = d4 / this.g;
        return d5 * -0.5 * d5 - (this.h + d3);
    }

    public final double e(double d2) {
        double d3;
        if (d2 <= 0.0) {
            return 0.0;
        }
        double d4 = BY.k(d2) - this.f;
        if (BY.w(d3) > 40.0 * this.g) {
            if (d4 < 0.0) {
                return 0.0;
            }
            return 1.0;
        }
        return 0.5 + 0.5 * zX.a(d4 / (this.g * e));
    }

    @Deprecated
    public final double a(double d2, double d3) {
        return ((oe_0)this).b(d2, d3);
    }

    public final double b(double d2, double d3) {
        if (d2 > d3) {
            throw new pm_0(px_0.LOWER_ENDPOINT_ABOVE_UPPER_ENDPOINT, (Number)d2, d3, true);
        }
        if (d2 <= 0.0 || d3 <= 0.0) {
            return super.b(d2, d3);
        }
        double d4 = this.g * e;
        double d5 = (BY.k(d2) - this.f) / d4;
        double d6 = (BY.k(d3) - this.f) / d4;
        return 0.5 * zX.a(d5, d6);
    }

    protected final double a() {
        return this.i;
    }

    public final double c() {
        double d2;
        double d3 = d2 = this.g;
        return BY.i(this.f + d3 * d3 / 2.0);
    }

    public final double d() {
        double d2 = this.g;
        double d3 = d2 * d2;
        return BY.j(d3) * BY.i(2.0 * this.f + d3);
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
        double d2 = this.a.nextGaussian();
        return BY.i(this.f + this.g * d2);
    }
}

