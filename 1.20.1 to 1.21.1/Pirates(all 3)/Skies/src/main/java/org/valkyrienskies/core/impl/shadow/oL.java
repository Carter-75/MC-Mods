/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.oe_0;
import org.valkyrienskies.core.impl.shadow.pm_0;
import org.valkyrienskies.core.impl.shadow.pn_0;
import org.valkyrienskies.core.impl.shadow.po_0;
import org.valkyrienskies.core.impl.shadow.pw_0;
import org.valkyrienskies.core.impl.shadow.px_0;
import org.valkyrienskies.core.impl.shadow.zR;

public final class oL
extends oe_0 {
    private static final long b = 20120112L;
    private final double c;
    private final double d;
    private final double e;
    private final double f;

    private oL(double d2, double d3, double d4) {
        this(new zR(), d2, d3, d4);
    }

    private oL(zR zR2, double d2, double d3, double d4) {
        super(zR2);
        if (d2 >= d4) {
            throw new pm_0(px_0.LOWER_BOUND_NOT_BELOW_UPPER_BOUND, (Number)d2, d4, false);
        }
        if (d3 < d2) {
            throw new pn_0((pw_0)px_0.NUMBER_TOO_SMALL, (Number)d3, d2, true);
        }
        if (d3 > d4) {
            throw new pm_0(px_0.NUMBER_TOO_LARGE, (Number)d3, d4, true);
        }
        this.c = d2;
        this.e = d3;
        this.d = d4;
        this.f = BY.e(BY.x(d2), BY.x(d4));
    }

    private double j() {
        return this.e;
    }

    protected final double a() {
        return this.f;
    }

    public final double d(double d2) {
        if (d2 < this.c) {
            return 0.0;
        }
        if (this.c <= d2 && d2 < this.e) {
            double d3 = 2.0 * (d2 - this.c);
            double d4 = (this.d - this.c) * (this.e - this.c);
            return d3 / d4;
        }
        if (d2 == this.e) {
            return 2.0 / (this.d - this.c);
        }
        if (this.e < d2 && d2 <= this.d) {
            double d5 = 2.0 * (this.d - d2);
            double d6 = (this.d - this.c) * (this.d - this.e);
            return d5 / d6;
        }
        return 0.0;
    }

    public final double e(double d2) {
        if (d2 < this.c) {
            return 0.0;
        }
        if (this.c <= d2 && d2 < this.e) {
            double d3 = (d2 - this.c) * (d2 - this.c);
            double d4 = (this.d - this.c) * (this.e - this.c);
            return d3 / d4;
        }
        if (d2 == this.e) {
            return (this.e - this.c) / (this.d - this.c);
        }
        if (this.e < d2 && d2 <= this.d) {
            double d5 = (this.d - d2) * (this.d - d2);
            double d6 = (this.d - this.c) * (this.d - this.e);
            return 1.0 - d5 / d6;
        }
        return 1.0;
    }

    public final double c() {
        return (this.c + this.d + this.e) / 3.0;
    }

    public final double d() {
        return (this.c * this.c + this.d * this.d + this.e * this.e - this.c * this.d - this.c * this.e - this.d * this.e) / 18.0;
    }

    public final double e() {
        return this.c;
    }

    public final double f() {
        return this.d;
    }

    public final boolean g() {
        return true;
    }

    public final boolean h() {
        return true;
    }

    public final boolean i() {
        return true;
    }

    public final double a(double d2) {
        if (d2 < 0.0 || d2 > 1.0) {
            throw new po_0(d2, (Number)0, 1);
        }
        if (d2 == 0.0) {
            return this.c;
        }
        if (d2 == 1.0) {
            return this.d;
        }
        if (d2 < (this.e - this.c) / (this.d - this.c)) {
            return this.c + BY.a(d2 * (this.d - this.c) * (this.e - this.c));
        }
        return this.d - BY.a((1.0 - d2) * (this.d - this.c) * (this.d - this.e));
    }
}

