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

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.oh
 */
public final class oh_0
extends oe_0 {
    private static double b = 1.0E-9;
    private static final long c = 8589540077390120676L;
    private final double d;
    private final double e;
    private final double f;

    public oh_0() {
        this(0.0, 1.0);
    }

    private oh_0(double d2, double d3) {
        this(0.0, 1.0, 1.0E-9);
    }

    private oh_0(double d2, double d3, double d4) {
        this(new zR(), d2, d3, 1.0E-9);
    }

    private oh_0(zF zF2, double d2, double d3) {
        this(zF2, d2, d3, 1.0E-9);
    }

    public oh_0(zF zF2, double d2, double d3, double d4) {
        super(zF2);
        if (d3 <= 0.0) {
            throw new pk_0(px_0.SCALE, d3);
        }
        this.e = d3;
        this.d = d2;
        this.f = d4;
    }

    public final double e(double d2) {
        return 0.5 + BY.q((d2 - this.d) / this.e) / Math.PI;
    }

    private double j() {
        return this.d;
    }

    private double k() {
        return this.e;
    }

    public final double d(double d2) {
        double d3;
        double d4 = d3 = d2 - this.d;
        return 0.3183098861837907 * (this.e / (d4 * d4 + this.e * this.e));
    }

    public final double a(double d2) {
        if (d2 < 0.0 || d2 > 1.0) {
            throw new po_0(d2, (Number)0, 1);
        }
        double d3 = d2 == 0.0 ? Double.NEGATIVE_INFINITY : (d2 == 1.0 ? Double.POSITIVE_INFINITY : this.d + this.e * BY.p(Math.PI * (d2 - 0.5)));
        return d3;
    }

    protected final double a() {
        return this.f;
    }

    public final double c() {
        return Double.NaN;
    }

    public final double d() {
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

