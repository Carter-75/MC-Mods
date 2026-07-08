/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.mm_0;
import org.valkyrienskies.core.impl.shadow.ms_0;
import org.valkyrienskies.core.impl.shadow.pm_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.mr
 */
public final class mr_0
extends mm_0 {
    private static int a = 64;

    private mr_0(double d2, double d3, int n2, int n3) {
        super(d2, d3, n2, n3);
        if (n3 > 64) {
            throw new pm_0(n3, (Number)64, false);
        }
    }

    private mr_0(int n2, int n3) {
        super(n2, n3);
        if (n3 > 64) {
            throw new pm_0(n3, (Number)64, false);
        }
    }

    public mr_0() {
        super(3, 64);
    }

    protected final double j() {
        ms_0 ms_02 = new ms_0();
        if (this.c() == 1) {
            return (4.0 * ms_02.a(this, 1) - ms_02.a(this, 0)) / 3.0;
        }
        double d2 = 0.0;
        double d3 = ms_02.a(this, 0);
        while (true) {
            double d4;
            double d5;
            mr_0 mr_02 = this;
            double d6 = ms_02.a(mr_02, mr_02.f());
            this.g();
            double d7 = (d6 * 4.0 - d3) / 3.0;
            if (this.f() >= this.c() && ((d5 = BY.w(d7 - d2)) <= (d4 = this.a() * (BY.w(d2) + BY.w(d7)) * 0.5) || d5 <= this.b())) {
                return d7;
            }
            d2 = d7;
            d3 = d6;
        }
    }
}

