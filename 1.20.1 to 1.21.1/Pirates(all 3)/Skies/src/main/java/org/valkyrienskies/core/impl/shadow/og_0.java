/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.oJ;
import org.valkyrienskies.core.impl.shadow.oc_0;
import org.valkyrienskies.core.impl.shadow.pj_0;
import org.valkyrienskies.core.impl.shadow.po_0;
import org.valkyrienskies.core.impl.shadow.px_0;
import org.valkyrienskies.core.impl.shadow.zF;
import org.valkyrienskies.core.impl.shadow.zR;
import org.valkyrienskies.core.impl.shadow.zW;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.og
 */
public final class og_0
extends oc_0 {
    private static final long b = 6751309484392813623L;
    private final int c;
    private final double d;

    private og_0(int n2, double d2) {
        this(new zR(), n2, d2);
    }

    public og_0(zF zF2, int n2, double d2) {
        super(zF2);
        if (n2 < 0) {
            throw new pj_0(px_0.NUMBER_OF_TRIALS, n2);
        }
        if (d2 < 0.0 || d2 > 1.0) {
            throw new po_0(d2, (Number)0, 1);
        }
        this.d = d2;
        this.c = n2;
    }

    private int g() {
        return this.c;
    }

    private double h() {
        return this.d;
    }

    public final double c(int n2) {
        double d2 = ((oc_0)this).b(n2);
        if (d2 == Double.NEGATIVE_INFINITY) {
            return 0.0;
        }
        return BY.i(d2);
    }

    public final double b(int n2) {
        if (this.c == 0) {
            if (n2 == 0) {
                return 0.0;
            }
            return Double.NEGATIVE_INFINITY;
        }
        double d2 = n2 < 0 || n2 > this.c ? Double.NEGATIVE_INFINITY : oJ.a(n2, this.c, this.d, 1.0 - this.d);
        return d2;
    }

    public final double d(int n2) {
        double d2 = n2 < 0 ? 0.0 : (n2 >= this.c ? 1.0 : 1.0 - zW.a(this.d, (double)n2 + 1.0, this.c - n2));
        return d2;
    }

    public final double b() {
        return (double)this.c * this.d;
    }

    public final double c() {
        double d2 = this.d;
        return (double)this.c * d2 * (1.0 - d2);
    }

    public final int d() {
        if (this.d < 1.0) {
            return 0;
        }
        return this.c;
    }

    public final int e() {
        if (this.d > 0.0) {
            return this.c;
        }
        return 0;
    }

    public final boolean f() {
        return true;
    }
}

