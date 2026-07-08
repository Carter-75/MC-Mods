/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.pn_0;
import org.valkyrienskies.core.impl.shadow.pw_0;
import org.valkyrienskies.core.impl.shadow.px_0;
import org.valkyrienskies.core.impl.shadow.rY;

public final class qV {
    public final double a;
    public final double b;

    public qV(double d2, double d3) {
        if (d3 < d2) {
            throw new pn_0((pw_0)px_0.ENDPOINTS_NOT_AN_INTERVAL, (Number)d3, d2, true);
        }
        this.a = d2;
        this.b = d3;
    }

    public final double a() {
        return this.a;
    }

    @Deprecated
    private double e() {
        qV qV2 = this;
        return qV2.a;
    }

    public final double b() {
        return this.b;
    }

    @Deprecated
    private double f() {
        qV qV2 = this;
        return qV2.b;
    }

    public final double c() {
        return this.b - this.a;
    }

    @Deprecated
    private double g() {
        return this.c();
    }

    public final double d() {
        return 0.5 * (this.a + this.b);
    }

    @Deprecated
    private double h() {
        return this.d();
    }

    private int a(double d2, double d3) {
        if (d2 < this.a - d3 || d2 > this.b + d3) {
            return rY.a.OUTSIDE$3ad793e5;
        }
        if (d2 > this.a + d3 && d2 < this.b - d3) {
            return rY.a.INSIDE$3ad793e5;
        }
        return rY.a.BOUNDARY$3ad793e5;
    }
}

