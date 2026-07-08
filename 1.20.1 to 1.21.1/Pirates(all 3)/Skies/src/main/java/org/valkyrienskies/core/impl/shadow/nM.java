/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.nq_0;

public final class nM
extends nq_0 {
    private static double d = 1.0E-6;

    public nM() {
        super(1.0E-6);
    }

    private nM(double d2) {
        super(d2);
    }

    private nM(double d2, double d3) {
        super(d2, d3);
    }

    protected final double j() {
        double d2 = this.d();
        double d3 = this.e();
        double d4 = this.b(d2);
        double d5 = this.b(d3);
        if (d4 == 0.0) {
            return d2;
        }
        if (d5 == 0.0) {
            return d3;
        }
        this.c(d2, d3);
        double d6 = this.i();
        double d7 = this.g();
        double d8 = this.h();
        do {
            double d9;
            double d10;
            double d11;
            if ((d11 = this.b(d10 = d3 - d5 * (d3 - d2) / (d5 - d4))) == 0.0) {
                return d10;
            }
            d2 = d3;
            d4 = d5;
            d3 = d10;
            d5 = d11;
            if (!(BY.w(d9) <= d6)) continue;
            return d3;
        } while (!(BY.w(d3 - d2) < BY.e(d8 * BY.w(d3), d7)));
        return d3;
    }
}

