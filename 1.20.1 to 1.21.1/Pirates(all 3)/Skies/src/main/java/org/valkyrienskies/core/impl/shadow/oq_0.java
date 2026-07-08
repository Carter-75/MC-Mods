/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.oc_0;
import org.valkyrienskies.core.impl.shadow.po_0;
import org.valkyrienskies.core.impl.shadow.px_0;
import org.valkyrienskies.core.impl.shadow.zR;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.oq
 */
public final class oq_0
extends oc_0 {
    private static final long b = 20130507L;
    private final double c;
    private final double d;
    private final double e;

    private oq_0(double d2) {
        this(new zR(), d2);
    }

    private oq_0(zR zR2, double d2) {
        super(zR2);
        if (d2 <= 0.0 || d2 > 1.0) {
            throw new po_0(px_0.OUT_OF_RANGE_LEFT, (Number)d2, 0, 1);
        }
        this.c = d2;
        this.d = BY.k(d2);
        this.e = BY.l(-d2);
    }

    private double g() {
        return this.c;
    }

    public final double c(int n2) {
        if (n2 < 0) {
            return 0.0;
        }
        return BY.i(this.e * (double)n2) * this.c;
    }

    public final double b(int n2) {
        if (n2 < 0) {
            return Double.NEGATIVE_INFINITY;
        }
        return (double)n2 * this.e + this.d;
    }

    public final double d(int n2) {
        if (n2 < 0) {
            return 0.0;
        }
        return -BY.j(this.e * (double)(n2 + 1));
    }

    public final double b() {
        return (1.0 - this.c) / this.c;
    }

    public final double c() {
        return (1.0 - this.c) / (this.c * this.c);
    }

    public final int d() {
        return 0;
    }

    public final int e() {
        return Integer.MAX_VALUE;
    }

    public final boolean f() {
        return true;
    }

    public final int a(double d2) {
        if (d2 < 0.0 || d2 > 1.0) {
            throw new po_0(d2, (Number)0, 1);
        }
        if (d2 == 1.0) {
            return Integer.MAX_VALUE;
        }
        if (d2 == 0.0) {
            return 0;
        }
        return Math.max(0, (int)Math.ceil(BY.l(-d2) / this.e - 1.0));
    }
}

