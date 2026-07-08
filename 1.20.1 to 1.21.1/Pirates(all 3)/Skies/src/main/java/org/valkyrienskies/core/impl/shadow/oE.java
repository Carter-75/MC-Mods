/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.oe_0;
import org.valkyrienskies.core.impl.shadow.pk_0;
import org.valkyrienskies.core.impl.shadow.pm_0;
import org.valkyrienskies.core.impl.shadow.po_0;
import org.valkyrienskies.core.impl.shadow.px_0;
import org.valkyrienskies.core.impl.shadow.zF;
import org.valkyrienskies.core.impl.shadow.zR;
import org.valkyrienskies.core.impl.shadow.zX;

public final class oE
extends oe_0 {
    private static double b = 1.0E-9;
    private static final long c = 8589540077390120676L;
    private static final double d = BY.a(2.0);
    private final double e;
    private final double f;
    private final double g;
    private final double h;

    public oE() {
        this(0.0, 1.0);
    }

    private oE(double d2, double d3) {
        this(0.0, 1.0, 1.0E-9);
    }

    private oE(double d2, double d3, double d4) {
        this(new zR(), d2, d3, 1.0E-9);
    }

    public oE(zF zF2, double d2, double d3) {
        this(null, 0.0, 1.0, 1.0E-9);
    }

    public oE(zF zF2, double d2, double d3, double d4) {
        super(zF2);
        if (d3 <= 0.0) {
            throw new pk_0(px_0.STANDARD_DEVIATION, d3);
        }
        this.e = d2;
        this.f = d3;
        this.g = BY.k(d3) + 0.5 * BY.k(Math.PI * 2);
        this.h = d4;
    }

    private double j() {
        return this.e;
    }

    private double k() {
        return this.f;
    }

    public final double d(double d2) {
        return BY.i(((oe_0)this).c(d2));
    }

    public final double c(double d2) {
        double d3 = d2 - this.e;
        double d4 = d3 / this.f;
        return d4 * -0.5 * d4 - this.g;
    }

    public final double e(double d2) {
        double d3;
        double d4 = d2 - this.e;
        if (BY.w(d3) > 40.0 * this.f) {
            if (d4 < 0.0) {
                return 0.0;
            }
            return 1.0;
        }
        return 0.5 * zX.b(-d4 / (this.f * d));
    }

    public final double a(double d2) {
        if (d2 < 0.0 || d2 > 1.0) {
            throw new po_0(d2, (Number)0, 1);
        }
        return this.e + this.f * d * zX.c(d2 * 2.0 - 1.0);
    }

    @Deprecated
    public final double a(double d2, double d3) {
        return ((oe_0)this).b(d2, d3);
    }

    public final double b(double d2, double d3) {
        if (d2 > d3) {
            throw new pm_0(px_0.LOWER_ENDPOINT_ABOVE_UPPER_ENDPOINT, (Number)d2, d3, true);
        }
        double d4 = this.f * d;
        double d5 = (d2 - this.e) / d4;
        double d6 = (d3 - this.e) / d4;
        return 0.5 * zX.a(d5, d6);
    }

    protected final double a() {
        return this.h;
    }

    public final double c() {
        oE oE2 = this;
        return oE2.e;
    }

    public final double d() {
        oE oE2 = this;
        double d2 = oE2.f;
        return d2 * d2;
    }

    public final double e() {
        return Double.NEGATIVE_INFINITY;
    }

    public final double f() {
        return Double.POSITIVE_INFINITY;
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

    public final double b() {
        return this.f * this.a.nextGaussian() + this.e;
    }
}

