/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.oe_0;
import org.valkyrienskies.core.impl.shadow.pk_0;
import org.valkyrienskies.core.impl.shadow.pn_0;
import org.valkyrienskies.core.impl.shadow.px_0;
import org.valkyrienskies.core.impl.shadow.zR;
import org.valkyrienskies.core.impl.shadow.zY;

public final class oD
extends oe_0 {
    private static double b = 1.0E-9;
    private static final long c = 20141003L;
    private final double d;
    private final double e;
    private final double f;

    private oD(double d2, double d3) {
        this(d2, d3, 1.0E-9);
    }

    private oD(double d2, double d3, double d4) {
        this(new zR(), d2, d3, 1.0E-9);
    }

    private oD(zR zR2, double d2, double d3, double d4) {
        super(zR2);
        if (d2 < 0.5) {
            throw new pn_0(d2, (Number)0.5, true);
        }
        if (d3 <= 0.0) {
            throw new pk_0(px_0.NOT_POSITIVE_SCALE, d3);
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

    protected final double a() {
        return this.f;
    }

    public final double d(double d2) {
        if (d2 <= 0.0) {
            return 0.0;
        }
        return 2.0 * BY.a(this.d, this.d) / (zY.d(this.d) * BY.a(this.e, this.d)) * BY.a(d2, 2.0 * this.d - 1.0) * BY.i(-this.d * d2 * d2 / this.e);
    }

    public final double e(double d2) {
        return zY.a(this.d, this.d * d2 * d2 / this.e);
    }

    public final double c() {
        return zY.d(this.d + 0.5) / zY.d(this.d) * BY.a(this.e / this.d);
    }

    public final double d() {
        double d2 = zY.d(this.d + 0.5) / zY.d(this.d);
        return this.e * (1.0 - 1.0 / this.d * d2 * d2);
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

