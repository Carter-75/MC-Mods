/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.oe_0;
import org.valkyrienskies.core.impl.shadow.pk_0;
import org.valkyrienskies.core.impl.shadow.po_0;
import org.valkyrienskies.core.impl.shadow.px_0;
import org.valkyrienskies.core.impl.shadow.zR;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.ov
 */
public final class ov_0
extends oe_0 {
    private static final long b = 20141003L;
    private final double c;
    private final double d;

    private ov_0(double d2, double d3) {
        this(new zR(), d2, d3);
    }

    private ov_0(zR zR2, double d2, double d3) {
        super(zR2);
        if (d3 <= 0.0) {
            throw new pk_0(px_0.NOT_POSITIVE_SCALE, d3);
        }
        this.c = d2;
        this.d = d3;
    }

    private double j() {
        return this.c;
    }

    private double k() {
        return this.d;
    }

    public final double d(double d2) {
        return BY.i(-BY.w(d2 - this.c) / this.d) / (2.0 * this.d);
    }

    public final double e(double d2) {
        if (d2 <= this.c) {
            return BY.i((d2 - this.c) / this.d) / 2.0;
        }
        return 1.0 - BY.i((this.c - d2) / this.d) / 2.0;
    }

    public final double a(double d2) {
        if (d2 < 0.0 || d2 > 1.0) {
            throw new po_0(d2, (Number)0.0, 1.0);
        }
        if (d2 == 0.0) {
            return Double.NEGATIVE_INFINITY;
        }
        if (d2 == 1.0) {
            return Double.POSITIVE_INFINITY;
        }
        double d3 = d2 > 0.5 ? -Math.log(2.0 - d2 * 2.0) : Math.log(d2 * 2.0);
        return this.c + this.d * d3;
    }

    public final double c() {
        return this.c;
    }

    public final double d() {
        return 2.0 * this.d * this.d;
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

