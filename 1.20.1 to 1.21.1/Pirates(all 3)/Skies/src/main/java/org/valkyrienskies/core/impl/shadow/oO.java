/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.oe_0;
import org.valkyrienskies.core.impl.shadow.pk_0;
import org.valkyrienskies.core.impl.shadow.po_0;
import org.valkyrienskies.core.impl.shadow.px_0;
import org.valkyrienskies.core.impl.shadow.zF;
import org.valkyrienskies.core.impl.shadow.zR;
import org.valkyrienskies.core.impl.shadow.zY;

public final class oO
extends oe_0 {
    private static double b = 1.0E-9;
    private static final long c = 8589540077390120676L;
    private final double d;
    private final double e;
    private final double f;
    private double g = Double.NaN;
    private boolean h = false;
    private double i = Double.NaN;
    private boolean j = false;

    private oO(double d2, double d3) {
        this(d2, d3, 1.0E-9);
    }

    private oO(double d2, double d3, double d4) {
        this(new zR(), d2, d3, 1.0E-9);
    }

    private oO(zF zF2, double d2, double d3) {
        this(zF2, d2, d3, 1.0E-9);
    }

    public oO(zF zF2, double d2, double d3, double d4) {
        super(zF2);
        if (d2 <= 0.0) {
            throw new pk_0(px_0.SHAPE, d2);
        }
        if (d3 <= 0.0) {
            throw new pk_0(px_0.SCALE, d3);
        }
        this.e = d3;
        this.d = d2;
        this.f = d4;
    }

    private double j() {
        return this.d;
    }

    private double k() {
        return this.e;
    }

    public final double d(double d2) {
        if (d2 < 0.0) {
            return 0.0;
        }
        double d3 = d2 / this.e;
        double d4 = BY.a(d3, this.d - 1.0);
        double d5 = d4 * d3;
        return this.d / this.e * d4 * BY.i(-d5);
    }

    public final double c(double d2) {
        if (d2 < 0.0) {
            return Double.NEGATIVE_INFINITY;
        }
        double d3 = d2 / this.e;
        double d4 = BY.k(d3) * (this.d - 1.0);
        double d5 = BY.i(d4) * d3;
        return BY.k(this.d / this.e) + d4 - d5;
    }

    public final double e(double d2) {
        double d3 = d2 <= 0.0 ? 0.0 : 1.0 - BY.i(-BY.a(d2 / this.e, this.d));
        return d3;
    }

    public final double a(double d2) {
        if (d2 < 0.0 || d2 > 1.0) {
            throw new po_0(d2, (Number)0.0, 1.0);
        }
        double d3 = d2 == 0.0 ? 0.0 : (d2 == 1.0 ? Double.POSITIVE_INFINITY : this.e * BY.a(-BY.l(-d2), 1.0 / this.d));
        return d3;
    }

    protected final double a() {
        return this.f;
    }

    public final double c() {
        if (!this.h) {
            oO oO2;
            oO oO3 = oO2 = this;
            double d2 = oO2.d;
            oO3 = oO2;
            double d3 = oO3.e;
            oO2.g = d3 * BY.i(zY.a(1.0 + 1.0 / d2));
            this.h = true;
        }
        return this.g;
    }

    private double l() {
        oO oO2 = this;
        double d2 = oO2.d;
        oO2 = this;
        double d3 = oO2.e;
        return d3 * BY.i(zY.a(1.0 + 1.0 / d2));
    }

    public final double d() {
        if (!this.j) {
            oO oO2;
            oO oO3 = oO2 = this;
            double d2 = oO2.d;
            oO3 = oO2;
            double d3 = oO3.e;
            double d4 = oO2.c();
            double d5 = d3;
            double d6 = d4;
            oO2.i = d5 * d5 * BY.i(zY.a(1.0 + 2.0 / d2)) - d6 * d6;
            this.j = true;
        }
        return this.i;
    }

    private double m() {
        oO oO2 = this;
        double d2 = oO2.d;
        oO2 = this;
        double d3 = oO2.e;
        double d4 = this.c();
        double d5 = d3;
        double d6 = d4;
        return d5 * d5 * BY.i(zY.a(1.0 + 2.0 / d2)) - d6 * d6;
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
}

