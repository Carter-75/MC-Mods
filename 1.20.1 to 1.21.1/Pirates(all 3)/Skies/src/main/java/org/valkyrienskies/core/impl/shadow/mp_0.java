/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.mm_0;
import org.valkyrienskies.core.impl.shadow.pm_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.mp
 */
public final class mp_0
extends mm_0 {
    private static int a = 64;

    private mp_0(double d2, double d3, int n2, int n3) {
        super(d2, d3, n2, n3);
        if (n3 > 64) {
            throw new pm_0(n3, (Number)64, false);
        }
    }

    private mp_0(int n2, int n3) {
        super(n2, n3);
        if (n3 > 64) {
            throw new pm_0(n3, (Number)64, false);
        }
    }

    public mp_0() {
        super(3, 64);
    }

    private double a(int n2, double d2, double d3, double d4) {
        long l2 = 1L << n2 - 1;
        double d5 = 0.0;
        double d6 = d4 / (double)l2;
        double d7 = d3 + d6 * 0.5;
        for (long i2 = 0L; i2 < l2; ++i2) {
            d5 += this.a(d7);
            d7 += d6;
        }
        return 0.5 * (d2 + d5 * d6);
    }

    protected final double j() {
        double d2 = this.h();
        double d3 = this.i() - d2;
        double d4 = d2 + d3 * 0.5;
        double d5 = d3 * this.a(d4);
        while (true) {
            double d6;
            double d7;
            this.g();
            int n2 = this.f();
            double d8 = d3;
            double d9 = d2;
            double d10 = d5;
            int n3 = n2;
            mp_0 mp_02 = this;
            long l2 = 1L << n3 - 1;
            double d11 = 0.0;
            double d12 = d8 / (double)l2;
            double d13 = d9 + d12 * 0.5;
            for (long i2 = 0L; i2 < l2; ++i2) {
                d11 += mp_02.a(d13);
                d13 += d12;
            }
            double d14 = 0.5 * (d10 + d11 * d12);
            if (n2 >= this.c() && ((d7 = BY.w(d14 - d5)) <= (d6 = this.a() * (BY.w(d5) + BY.w(d14)) * 0.5) || d7 <= this.b())) {
                return d14;
            }
            d5 = d14;
        }
    }
}

