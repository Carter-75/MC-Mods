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

public final class oF
extends oe_0 {
    private static double b = 1.0E-9;
    private static final long c = 20130424L;
    private final double d;
    private final double e;
    private final double f;

    public oF() {
        this(1.0, 1.0);
    }

    private oF(double d2, double d3) {
        this(1.0, 1.0, 1.0E-9);
    }

    private oF(double d2, double d3, double d4) {
        this(new zR(), d2, d3, 1.0E-9);
    }

    private oF(zF zF2, double d2, double d3) {
        this(zF2, d2, d3, 1.0E-9);
    }

    private oF(zF zF2, double d2, double d3, double d4) {
        super(zF2);
        if (d2 <= 0.0) {
            throw new pk_0(px_0.SCALE, d2);
        }
        if (d3 <= 0.0) {
            throw new pk_0(px_0.SHAPE, d3);
        }
        this.d = d2;
        this.e = d3;
        this.f = d4;
    }

    private double j() {
        return this.d;
    }

    private double k() {
        return this.e;
    }

    public final double d(double d2) {
        if (d2 < this.d) {
            return 0.0;
        }
        return BY.a(this.d, this.e) / BY.a(d2, this.e + 1.0) * this.e;
    }

    public final double c(double d2) {
        if (d2 < this.d) {
            return Double.NEGATIVE_INFINITY;
        }
        return BY.k(this.d) * this.e - BY.k(d2) * (this.e + 1.0) + BY.k(this.e);
    }

    public final double e(double d2) {
        if (d2 <= this.d) {
            return 0.0;
        }
        return 1.0 - BY.a(this.d / d2, this.e);
    }

    @Deprecated
    public final double a(double d2, double d3) {
        return this.b(d2, d3);
    }

    protected final double a() {
        return this.f;
    }

    public final double c() {
        if (this.e <= 1.0) {
            return Double.POSITIVE_INFINITY;
        }
        return this.e * this.d / (this.e - 1.0);
    }

    public final double d() {
        double d2;
        if (this.e <= 2.0) {
            return Double.POSITIVE_INFINITY;
        }
        double d3 = d2 = this.e - 1.0;
        return this.d * this.d * this.e / (d3 * d3) / (this.e - 2.0);
    }

    public final double e() {
        return this.d;
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
        double d2 = this.a.nextDouble();
        return this.d / BY.a(d2, 1.0 / this.e);
    }
}

