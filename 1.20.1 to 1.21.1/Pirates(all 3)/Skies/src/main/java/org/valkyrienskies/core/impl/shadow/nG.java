/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.lg_0;
import org.valkyrienskies.core.impl.shadow.ln_0;
import org.valkyrienskies.core.impl.shadow.np_0;

public final class nG
extends np_0 {
    private static final double d = 1.0E-6;

    public nG() {
        this(1.0E-6);
    }

    private nG(double d2) {
        super(1.0E-6);
    }

    private double a(int n2, ln_0 ln_02, double d2, double d3) {
        double d4 = d3;
        double d5 = d2;
        return super.a(n2, ln_02, (d5 + d4) * 0.5);
    }

    protected final double j() {
        double d2 = this.f();
        double d3 = this.g();
        double d4 = d2;
        while (true) {
            double d5;
            lg_0 lg_02;
            lg_0 lg_03 = lg_02 = this.a(d4);
            double d6 = d4 - lg_03.b[0] / lg_02.a(new int[]{1});
            if (BY.w(d5 - d4) <= d3) {
                return d6;
            }
            d4 = d6;
        }
    }
}

