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
import org.valkyrienskies.core.impl.shadow.zW;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.oo
 */
public final class oo_0
extends oe_0 {
    private static double b = 1.0E-9;
    private static final long c = -8516354193418641566L;
    private final double d;
    private final double e;
    private final double f;
    private double g = Double.NaN;
    private boolean h = false;

    public oo_0(double d2, double d3) {
        this(d2, d3, 1.0E-9);
    }

    private oo_0(double d2, double d3, double d4) {
        this(new zR(), d2, d3, 1.0E-9);
    }

    public oo_0(zF zF2, double d2, double d3) {
        this(null, d2, d3, 1.0E-9);
    }

    public oo_0(zF zF2, double d2, double d3, double d4) {
        super(zF2);
        if (d2 <= 0.0) {
            throw new pk_0(px_0.DEGREES_OF_FREEDOM, d2);
        }
        if (d3 <= 0.0) {
            throw new pk_0(px_0.DEGREES_OF_FREEDOM, d3);
        }
        this.d = d2;
        this.e = d3;
        this.f = d4;
    }

    public final double d(double d2) {
        return BY.i(((oe_0)this).c(d2));
    }

    public final double c(double d2) {
        double d3 = this.d / 2.0;
        double d4 = this.e / 2.0;
        double d5 = BY.k(d2);
        double d6 = BY.k(this.d);
        double d7 = BY.k(this.e);
        double d8 = BY.k(this.d * d2 + this.e);
        return d3 * d6 + d3 * d5 - d5 + d4 * d7 - d3 * d8 - d4 * d8 - zW.a(d3, d4);
    }

    public final double e(double d2) {
        double d3;
        if (d2 <= 0.0) {
            d3 = 0.0;
        } else {
            double d4 = this.d;
            double d5 = this.e;
            d3 = zW.a(d4 * d2 / (d5 + d4 * d2), d4 * 0.5, d5 * 0.5);
        }
        return d3;
    }

    private double j() {
        return this.d;
    }

    private double k() {
        return this.e;
    }

    protected final double a() {
        return this.f;
    }

    public final double c() {
        double d2;
        oo_0 oo_02 = this;
        double d3 = oo_02.e;
        if (d2 > 2.0) {
            double d4 = d3;
            return d4 / (d4 - 2.0);
        }
        return Double.NaN;
    }

    public final double d() {
        if (!this.h) {
            double d2;
            double d3;
            oo_0 oo_02;
            oo_0 oo_03 = oo_02 = this;
            double d4 = oo_02.e;
            if (d3 > 4.0) {
                double d5 = oo_02.d;
                double d6 = d4 - 2.0;
                double d7 = d4;
                double d8 = d6;
                d2 = 2.0 * (d7 * d7) * (d5 + d4 - 2.0) / (d5 * (d8 * d8) * (d4 - 4.0));
            } else {
                d2 = Double.NaN;
            }
            oo_02.g = d2;
            this.h = true;
        }
        return this.g;
    }

    private double l() {
        double d2;
        oo_0 oo_02 = this;
        double d3 = oo_02.e;
        if (d2 > 4.0) {
            oo_02 = this;
            double d4 = oo_02.d;
            double d5 = d3 - 2.0;
            double d6 = d3;
            double d7 = d5;
            return 2.0 * (d6 * d6) * (d4 + d3 - 2.0) / (d4 * (d7 * d7) * (d3 - 4.0));
        }
        return Double.NaN;
    }

    public final double e() {
        return 0.0;
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
}

