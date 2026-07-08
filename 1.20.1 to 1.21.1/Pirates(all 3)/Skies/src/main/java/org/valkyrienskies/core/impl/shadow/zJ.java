/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.pl_0;
import org.valkyrienskies.core.impl.shadow.po_0;
import org.valkyrienskies.core.impl.shadow.px_0;
import org.valkyrienskies.core.impl.shadow.zA;
import org.valkyrienskies.core.impl.shadow.zF;

public final class zJ
implements zA {
    private final zF a;
    private final double b;
    private final double c;
    private final double d;

    private zJ(zF zF2, double d2, double d3) {
        if (zF2 == null) {
            throw new pl_0();
        }
        if (!(d2 > 0.0) || !(d2 <= 2.0)) {
            throw new po_0(px_0.OUT_OF_RANGE_LEFT, (Number)d2, 0, 2);
        }
        if (!(d3 >= -1.0) || !(d3 <= 1.0)) {
            throw new po_0(px_0.OUT_OF_RANGE_SIMPLE, (Number)d3, -1, 1);
        }
        this.a = zF2;
        this.b = d2;
        this.c = d3;
        if (d2 < 2.0 && d3 != 0.0) {
            this.d = d3 * BY.p(d2 * Math.PI / 2.0);
            return;
        }
        this.d = 0.0;
    }

    public final double a() {
        double d2;
        double d3 = -BY.k(this.a.nextDouble());
        double d4 = Math.PI * (this.a.nextDouble() - 0.5);
        if (this.b == 2.0) {
            return BY.a(d3 * 2.0) * BY.n(d4);
        }
        if (this.c == 0.0) {
            d2 = this.b == 1.0 ? BY.p(d4) : BY.a(d3 * BY.o((1.0 - this.b) * d4), 1.0 / this.b - 1.0) * BY.n(this.b * d4) / BY.a(BY.o(d4), 1.0 / this.b);
        } else {
            double d5 = BY.o(d4);
            if (BY.w(this.b - 1.0) > 1.0E-8) {
                double d6 = this.b * d4;
                double d7 = d4 - d6;
                d2 = (BY.n(d6) + this.d * BY.o(d6)) / d5 * (BY.o(d7) + this.d * BY.n(d7)) / BY.a(d3 * d5, (1.0 - this.b) / this.b);
            } else {
                double d8 = 1.5707963267948966 + this.c * d4;
                d2 = 0.6366197723675814 * (d8 * BY.p(d4) - this.c * BY.k(d3 * 1.5707963267948966 * d5 / d8));
                if (this.b != 1.0) {
                    d2 += this.c * BY.p(Math.PI * this.b / 2.0);
                }
            }
        }
        return d2;
    }
}

