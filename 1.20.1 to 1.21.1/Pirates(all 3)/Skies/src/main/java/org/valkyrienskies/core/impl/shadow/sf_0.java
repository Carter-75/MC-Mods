/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.ci_0;
import org.valkyrienskies.core.impl.shadow.cq_0;
import org.valkyrienskies.core.impl.shadow.pm_0;
import org.valkyrienskies.core.impl.shadow.px_0;
import org.valkyrienskies.core.impl.shadow.rY;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.sf
 */
public final class sf_0 {
    public final double a;
    public final double b;
    private final double c;
    private final double d;

    public sf_0(double d2, double d3, double d4) {
        this.d = d4;
        if (cq_0.b(d2, d3, 0) || d3 - d2 >= Math.PI * 2) {
            this.a = 0.0;
            this.b = Math.PI * 2;
            this.c = Math.PI;
            return;
        }
        if (d2 <= d3) {
            this.a = ci_0.b(d2, Math.PI);
            this.b = this.a + (d3 - d2);
            this.c = 0.5 * (this.a + this.b);
            return;
        }
        throw new pm_0(px_0.ENDPOINTS_NOT_AN_INTERVAL, (Number)d2, d3, true);
    }

    public final double a() {
        return this.a;
    }

    public final double b() {
        return this.b;
    }

    public final double c() {
        return this.b - this.a;
    }

    private double d() {
        return this.c;
    }

    private double e() {
        return this.d;
    }

    private int a(double d2) {
        double d3 = ci_0.b(d2, this.c);
        if (d3 < this.a - this.d || d3 > this.b + this.d) {
            return rY.a.OUTSIDE$3ad793e5;
        }
        if (d3 > this.a + this.d && d3 < this.b - this.d) {
            return rY.a.INSIDE$3ad793e5;
        }
        if (this.c() >= Math.PI * 2 - this.d) {
            return rY.a.INSIDE$3ad793e5;
        }
        return rY.a.BOUNDARY$3ad793e5;
    }
}

