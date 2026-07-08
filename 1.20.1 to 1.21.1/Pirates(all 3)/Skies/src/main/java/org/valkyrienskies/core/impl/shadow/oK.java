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
import org.valkyrienskies.core.impl.shadow.zY;

public final class oK
extends oe_0 {
    private static double b = 1.0E-9;
    private static final long c = -5852615386664158222L;
    private final double d;
    private final double e;
    private final double f;

    public oK(double d2) {
        this(d2, 1.0E-9);
    }

    private oK(double d2, double d3) {
        this(new zR(), d2, 1.0E-9);
    }

    public oK(zF zF2, double d2) {
        this(null, d2, 1.0E-9);
    }

    public oK(zF zF2, double d2, double d3) {
        super(zF2);
        if (d2 <= 0.0) {
            throw new pk_0(px_0.DEGREES_OF_FREEDOM, d2);
        }
        this.d = d2;
        this.e = d3;
        double d4 = d2;
        double d5 = (d4 + 1.0) / 2.0;
        this.f = zY.a(d5) - 0.5 * (BY.k(Math.PI) + BY.k(d4)) - zY.a(d4 / 2.0);
    }

    private double j() {
        return this.d;
    }

    public final double d(double d2) {
        return BY.i(((oe_0)this).c(d2));
    }

    public final double c(double d2) {
        double d3 = this.d;
        double d4 = (d3 + 1.0) / 2.0;
        double d5 = d2;
        return this.f - d4 * BY.k(1.0 + d5 * d5 / d3);
    }

    public final double e(double d2) {
        double d3;
        if (d2 == 0.0) {
            d3 = 0.5;
        } else {
            double d4 = d2;
            double d5 = zW.a(this.d / (this.d + d4 * d4), 0.5 * this.d, 0.5);
            d3 = d2 < 0.0 ? d5 * 0.5 : 1.0 - d5 * 0.5;
        }
        return d3;
    }

    protected final double a() {
        return this.e;
    }

    public final double c() {
        double d2;
        oK oK2 = this;
        double d3 = oK2.d;
        if (d2 > 1.0) {
            return 0.0;
        }
        return Double.NaN;
    }

    public final double d() {
        double d2;
        oK oK2 = this;
        double d3 = oK2.d;
        if (d2 > 2.0) {
            double d4 = d3;
            return d4 / (d4 - 2.0);
        }
        if (d3 > 1.0 && d3 <= 2.0) {
            return Double.POSITIVE_INFINITY;
        }
        return Double.NaN;
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
}

