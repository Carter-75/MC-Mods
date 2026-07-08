/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.oe_0;
import org.valkyrienskies.core.impl.shadow.pm_0;
import org.valkyrienskies.core.impl.shadow.po_0;
import org.valkyrienskies.core.impl.shadow.px_0;
import org.valkyrienskies.core.impl.shadow.zF;
import org.valkyrienskies.core.impl.shadow.zR;

public final class oN
extends oe_0 {
    @Deprecated
    private static double b = 1.0E-9;
    private static final long c = 20120109L;
    private final double d;
    private final double e;

    public oN() {
        this(0.0, 1.0);
    }

    public oN(double d2, double d3) {
        this(new zR(), d2, d3);
    }

    @Deprecated
    private oN(double d2, double d3, byte by) {
        this(new zR(), d2, d3);
    }

    @Deprecated
    private oN(zF zF2, double d2, double d3, byte by) {
        this(zF2, d2, d3);
    }

    public oN(zF zF2, double d2, double d3) {
        super(zF2);
        if (d2 >= d3) {
            throw new pm_0(px_0.LOWER_BOUND_NOT_BELOW_UPPER_BOUND, (Number)d2, d3, false);
        }
        this.d = d2;
        this.e = d3;
    }

    public final double d(double d2) {
        if (d2 < this.d || d2 > this.e) {
            return 0.0;
        }
        return 1.0 / (this.e - this.d);
    }

    public final double e(double d2) {
        if (d2 <= this.d) {
            return 0.0;
        }
        if (d2 >= this.e) {
            return 1.0;
        }
        return (d2 - this.d) / (this.e - this.d);
    }

    public final double a(double d2) {
        if (d2 < 0.0 || d2 > 1.0) {
            throw new po_0(d2, (Number)0, 1);
        }
        return d2 * (this.e - this.d) + this.d;
    }

    public final double c() {
        return 0.5 * (this.d + this.e);
    }

    public final double d() {
        double d2 = this.e - this.d;
        return d2 * d2 / 12.0;
    }

    public final double e() {
        return this.d;
    }

    public final double f() {
        return this.e;
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

    public final double b() {
        double d2 = this.a.nextDouble();
        return d2 * this.e + (1.0 - d2) * this.d;
    }
}

