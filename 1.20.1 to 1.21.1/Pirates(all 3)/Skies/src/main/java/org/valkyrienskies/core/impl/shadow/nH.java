/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.kS;
import org.valkyrienskies.core.impl.shadow.nn_0;

@Deprecated
public final class nH
extends nn_0 {
    private static final double d = 1.0E-6;

    public nH() {
        this(1.0E-6);
    }

    private nH(double d2) {
        super(1.0E-6);
    }

    private double a(int n2, kS kS2, double d2, double d3) {
        double d4 = d3;
        double d5 = d2;
        return super.a(n2, kS2, (d5 + d4) * 0.5);
    }

    protected final double j() {
        double d2 = this.f();
        double d3 = this.g();
        double d4 = d2;
        while (true) {
            double d5;
            double d6 = d4 - this.b(d4) / this.a(d4);
            if (BY.w(d5 - d4) <= d3) {
                return d6;
            }
            d4 = d6;
        }
    }
}

