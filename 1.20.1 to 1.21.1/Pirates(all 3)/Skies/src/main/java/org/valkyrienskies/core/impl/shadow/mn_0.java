/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.lc_0;
import org.valkyrienskies.core.impl.shadow.mm_0;
import org.valkyrienskies.core.impl.shadow.mv_0;
import org.valkyrienskies.core.impl.shadow.mw_0;
import org.valkyrienskies.core.impl.shadow.pk_0;
import org.valkyrienskies.core.impl.shadow.px_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.mn
 */
public final class mn_0
extends mm_0 {
    private static final mw_0 a = new mw_0();
    private final int b;

    private mn_0(int n2, double d2, double d3, int n3, int n4) {
        super(d2, d3, n3, n4);
        if (n2 <= 0) {
            throw new pk_0(px_0.NUMBER_OF_POINTS, n2);
        }
        this.b = n2;
    }

    private mn_0(int n2, double d2, double d3) {
        this(n2, d2, d3, 3, Integer.MAX_VALUE);
    }

    private mn_0(int n2, int n3, int n4) {
        this(n2, 1.0E-6, 1.0E-15, n3, n4);
    }

    protected final double j() {
        double d2 = this.a(1);
        int n2 = 2;
        while (true) {
            double d3 = this.a(n2);
            double d4 = BY.w(d3 - d2);
            double d5 = BY.e(this.b(), this.a() * (BY.w(d2) + BY.w(d3)) * 0.5);
            if (this.f() + 1 >= this.c() && d4 <= d5) {
                return d3;
            }
            double d6 = BY.d(4.0, BY.a(d4 / d5, 0.5 / (double)this.b));
            n2 = BY.b((int)(d6 * (double)n2), n2 + 1);
            d2 = d3;
            this.g();
        }
    }

    private double a(int n2) {
        lc_0 lc_02 = new lc_0(this){
            private /* synthetic */ mn_0 a;
            {
                this.a = mn_02;
            }

            public final double a(double d2) {
                return this.a.a(d2);
            }
        };
        double d2 = this.h();
        double d3 = this.i();
        double d4 = (d3 - d2) / (double)n2;
        double d5 = 0.0;
        for (int i2 = 0; i2 < n2; ++i2) {
            double d6 = d2 + (double)i2 * d4;
            double d7 = d6 + d4;
            mv_0 mv_02 = a.a(this.b, d6, d7);
            d5 += mv_02.a(lc_02);
        }
        return d5;
    }
}

