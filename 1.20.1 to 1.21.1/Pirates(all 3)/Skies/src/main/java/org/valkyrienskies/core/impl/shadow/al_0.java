/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.pn_0;
import org.valkyrienskies.core.impl.shadow.pw_0;
import org.valkyrienskies.core.impl.shadow.px_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Al
 */
final class al_0 {
    double a;
    double b;
    double c;
    double d;
    private boolean e;

    al_0() {
        this(true);
    }

    al_0(boolean bl) {
        al_0 al_02 = this;
        al_02.b = 0.0;
        al_02.a = 0.0;
        this.c = 0.0;
        this.d = 0.0;
        this.e = bl;
    }

    public final void a(double d2, double d3) {
        this.c += 1.0;
        double d4 = d2 - this.a;
        double d5 = d3 - this.b;
        this.a += d4 / this.c;
        this.b += d5 / this.c;
        this.d += (this.c - 1.0) / this.c * d4 * d5;
    }

    public final void a(al_0 al_02) {
        double d2 = this.c;
        this.c += al_02.c;
        double d3 = al_02.a - this.a;
        double d4 = al_02.b - this.b;
        this.a += d3 * al_02.c / this.c;
        this.b += d4 * al_02.c / this.c;
        this.d += al_02.d + d2 * al_02.c / this.c * d3 * d4;
    }

    private double b() {
        return this.c;
    }

    public final double a() {
        if (this.c < 2.0) {
            throw new pn_0((pw_0)px_0.INSUFFICIENT_DIMENSION, (Number)this.c, 2, true);
        }
        if (this.e) {
            return this.d / (this.c - 1.0);
        }
        return this.d / this.c;
    }
}

