/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.nP;
import org.valkyrienskies.core.impl.shadow.nq_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.nv
 */
public final class nv_0
extends nq_0 {
    private static final double d = 1.0E-6;

    public nv_0() {
        this(1.0E-6);
    }

    private nv_0(double d2) {
        super(1.0E-6);
    }

    private nv_0(double d2, double d3) {
        super(d2, d3);
    }

    protected final double j() {
        double d2;
        double d3;
        double d4 = this.d();
        double d5 = d3 = this.e();
        double d6 = d4;
        nP.b(d6, d5);
        double d7 = this.g();
        do {
            double d8;
            d5 = d3;
            d6 = d4;
            d2 = (d6 + d5) * 0.5;
            double d9 = this.b(d4);
            double d10 = this.b(d2);
            if (d8 * d9 > 0.0) {
                d4 = d2;
                continue;
            }
            d3 = d2;
        } while (!(BY.w(d3 - d4) <= d7));
        d5 = d3;
        d6 = d4;
        d2 = (d6 + d5) * 0.5;
        return d2;
    }
}

