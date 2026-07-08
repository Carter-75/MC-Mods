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
 * Renamed from org.valkyrienskies.core.impl.shadow.or
 */
public final class or_0
extends oe_0 {
    private static final long b = 20141003L;
    private static final double c = 0.5778636748954609;
    private final double d;
    private final double e;

    private or_0(double d2, double d3) {
        this(new zR(), d2, d3);
    }

    private or_0(zR zR2, double d2, double d3) {
        super(zR2);
        if (d3 <= 0.0) {
            throw new pk_0(px_0.SCALE, d3);
        }
        this.e = d3;
        this.d = d2;
    }

    private double j() {
        return this.d;
    }

    private double k() {
        return this.e;
    }

    public final double d(double d2) {
        double d3 = (d2 - this.d) / this.e;
        double d4 = BY.i(-d3);
        return BY.i(-d3 - d4) / this.e;
    }

    public final double e(double d2) {
        double d3 = (d2 - this.d) / this.e;
        return BY.i(-BY.i(-d3));
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
        return this.d - BY.k(-BY.k(d2)) * this.e;
    }

    public final double c() {
        return this.d + 0.5778636748954609 * this.e;
    }

    public final double d() {
        return 1.6449340668482264 * (this.e * this.e);
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

