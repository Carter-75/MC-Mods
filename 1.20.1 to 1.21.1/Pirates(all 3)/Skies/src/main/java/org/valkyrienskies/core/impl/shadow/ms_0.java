/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.mm_0;
import org.valkyrienskies.core.impl.shadow.pm_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.ms
 */
public final class ms_0
extends mm_0 {
    private static int a = 64;
    private double b;

    private ms_0(double d2, double d3, int n2, int n3) {
        super(d2, d3, n2, n3);
        if (n3 > 64) {
            throw new pm_0(n3, (Number)64, false);
        }
    }

    private ms_0(int n2, int n3) {
        super(n2, n3);
        if (n3 > 64) {
            throw new pm_0(n3, (Number)64, false);
        }
    }

    public ms_0() {
        super(3, 64);
    }

    final double a(mm_0 mm_02, int n2) {
        if (n2 == 0) {
            double d2 = mm_02.i();
            double d3 = mm_02.h();
            this.b = 0.5 * (d2 - d3) * (mm_02.a(d3) + mm_02.a(d2));
            return this.b;
        }
        long l2 = 1L << n2 - 1;
        double d4 = 0.0;
        double d5 = mm_02.i();
        double d6 = mm_02.h();
        double d7 = (d5 - d6) / (double)l2;
        double d8 = d6 + d7 * 0.5;
        for (long i2 = 0L; i2 < l2; ++i2) {
            d4 += mm_02.a(d8);
            d8 += d7;
        }
        this.b = 0.5 * (this.b + d4 * d7);
        return this.b;
    }

    protected final double j() {
        ms_0 ms_02 = this;
        double d2 = ms_02.a(ms_02, 0);
        this.g();
        while (true) {
            double d3;
            double d4;
            int n2 = this.f();
            ms_0 ms_03 = this;
            double d5 = ms_03.a(ms_03, n2);
            if (n2 >= this.c() && ((d4 = BY.w(d5 - d2)) <= (d3 = this.a() * (BY.w(d2) + BY.w(d5)) * 0.5) || d4 <= this.b())) {
                return d5;
            }
            d2 = d5;
            this.g();
        }
    }
}

