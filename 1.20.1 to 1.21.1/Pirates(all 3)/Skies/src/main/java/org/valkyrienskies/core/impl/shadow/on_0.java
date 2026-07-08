/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.BR;
import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.cs_0;
import org.valkyrienskies.core.impl.shadow.oe_0;
import org.valkyrienskies.core.impl.shadow.pk_0;
import org.valkyrienskies.core.impl.shadow.po_0;
import org.valkyrienskies.core.impl.shadow.px_0;
import org.valkyrienskies.core.impl.shadow.zF;
import org.valkyrienskies.core.impl.shadow.zR;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.on
 */
public final class on_0
extends oe_0 {
    private static double b = 1.0E-9;
    private static final long c = 2401296428283614780L;
    private static final double[] d;
    private final double e;
    private final double f;
    private final double g;

    private on_0(double d2) {
        this(d2, 1.0E-9);
    }

    private on_0(double d2, double d3) {
        this(new zR(), d2, 1.0E-9);
    }

    private on_0(zF zF2, double d2) {
        this(zF2, d2, 1.0E-9);
    }

    public on_0(zF zF2, double d2, double d3) {
        super(zF2);
        if (d2 <= 0.0) {
            throw new pk_0(px_0.MEAN, d2);
        }
        this.e = d2;
        this.f = BY.k(d2);
        this.g = d3;
    }

    private double j() {
        return this.e;
    }

    public final double d(double d2) {
        double d3 = ((oe_0)this).c(d2);
        if (d3 == Double.NEGATIVE_INFINITY) {
            return 0.0;
        }
        return BY.i(d3);
    }

    public final double c(double d2) {
        if (d2 < 0.0) {
            return Double.NEGATIVE_INFINITY;
        }
        return -d2 / this.e - this.f;
    }

    public final double e(double d2) {
        double d3 = d2 <= 0.0 ? 0.0 : 1.0 - BY.i(-d2 / this.e);
        return d3;
    }

    public final double a(double d2) {
        if (d2 < 0.0 || d2 > 1.0) {
            throw new po_0(d2, (Number)0.0, 1.0);
        }
        double d3 = d2 == 1.0 ? Double.POSITIVE_INFINITY : -this.e * BY.k(1.0 - d2);
        return d3;
    }

    public final double b() {
        double d2;
        double d3;
        double d4;
        double d5 = 0.0;
        for (d4 = this.a.nextDouble(); d4 < 0.5; d4 *= 2.0) {
            d5 += d[0];
        }
        double d6 = d4;
        d4 = d6 + (d6 - 1.0);
        if (d3 <= d[0]) {
            return this.e * (d5 + d4);
        }
        int n2 = 0;
        double d7 = d2 = this.a.nextDouble();
        do {
            double d8;
            ++n2;
            d2 = this.a.nextDouble();
            if (!(d8 < d7)) continue;
            d7 = d2;
        } while (d4 > d[n2]);
        return this.e * (d5 + d7 * d[0]);
    }

    protected final double a() {
        return this.g;
    }

    public final double c() {
        on_0 on_02 = this;
        return on_02.e;
    }

    public final double d() {
        on_0 on_02 = this;
        double d2 = on_02.e;
        return d2 * d2;
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

    static {
        double d2 = BY.k(2.0);
        double d3 = 0.0;
        int n2 = 1;
        cs_0 cs_02 = new cs_0(20);
        while (d3 < 1.0) {
            cs_02.a(d3 += BY.a(d2, n2) / (double)BR.a(n2));
            ++n2;
        }
        d = cs_02.b();
    }
}

