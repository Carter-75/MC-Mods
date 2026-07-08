/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.oe_0;
import org.valkyrienskies.core.impl.shadow.op_0;
import org.valkyrienskies.core.impl.shadow.zF;
import org.valkyrienskies.core.impl.shadow.zR;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.oi
 */
public final class oi_0
extends oe_0 {
    private static double b = 1.0E-9;
    private static final long c = -8352658048349159782L;
    private final op_0 d;
    private final double e;

    public oi_0(double d2) {
        this(d2, 1.0E-9);
    }

    private oi_0(double d2, double d3) {
        this(new zR(), d2, 1.0E-9);
    }

    public oi_0(zF zF2, double d2) {
        this(null, d2, 1.0E-9);
    }

    public oi_0(zF zF2, double d2, double d3) {
        super(zF2);
        this.d = new op_0(d2 / 2.0, 2.0);
        this.e = d3;
    }

    private double j() {
        op_0 op_02 = this.d;
        return op_02.b * 2.0;
    }

    public final double d(double d2) {
        return this.d.d(d2);
    }

    public final double c(double d2) {
        return ((oe_0)this.d).c(d2);
    }

    public final double e(double d2) {
        return this.d.e(d2);
    }

    protected final double a() {
        return this.e;
    }

    public final double c() {
        return this.j();
    }

    public final double d() {
        return 2.0 * this.j();
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

