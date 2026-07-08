/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.oe_0;
import org.valkyrienskies.core.impl.shadow.po_0;
import org.valkyrienskies.core.impl.shadow.zR;
import org.valkyrienskies.core.impl.shadow.zX;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.ow
 */
public final class ow_0
extends oe_0 {
    private static final long b = 20130314L;
    private final double c;
    private final double d;
    private final double e;

    private ow_0(double d2, double d3) {
        this(new zR(), d2, d3);
    }

    private ow_0(zR zR2, double d2, double d3) {
        super(zR2);
        this.c = d2;
        this.d = d3;
        this.e = d3 * 0.5;
    }

    public final double d(double d2) {
        if (d2 < this.c) {
            return Double.NaN;
        }
        double d3 = d2 - this.c;
        double d4 = this.e / d3;
        return BY.a(d4 / Math.PI) * BY.i(-d4) / d3;
    }

    public final double c(double d2) {
        if (d2 < this.c) {
            return Double.NaN;
        }
        double d3 = d2 - this.c;
        double d4 = this.e / d3;
        return 0.5 * BY.k(d4 / Math.PI) - d4 - BY.k(d3);
    }

    public final double e(double d2) {
        if (d2 < this.c) {
            return Double.NaN;
        }
        return zX.b(BY.a(this.e / (d2 - this.c)));
    }

    public final double a(double d2) {
        double d3;
        if (d2 < 0.0 || d2 > 1.0) {
            throw new po_0(d2, (Number)0, 1);
        }
        double d4 = d2;
        double d5 = d3 = zX.c(1.0 - d4);
        return this.c + this.e / (d5 * d5);
    }

    private double j() {
        return this.d;
    }

    private double k() {
        return this.c;
    }

    public final double c() {
        return Double.POSITIVE_INFINITY;
    }

    public final double d() {
        return Double.POSITIVE_INFINITY;
    }

    public final double e() {
        return this.c;
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

