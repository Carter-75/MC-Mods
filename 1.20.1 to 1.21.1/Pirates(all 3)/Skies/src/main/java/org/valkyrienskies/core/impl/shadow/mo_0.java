/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.mm_0;
import org.valkyrienskies.core.impl.shadow.oV;
import org.valkyrienskies.core.impl.shadow.px_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.mo
 */
@Deprecated
public final class mo_0
extends mm_0 {
    private static final double[] a = new double[]{-1.0 / BY.a(3.0), 1.0 / BY.a(3.0)};
    private static final double[] b = new double[]{1.0, 1.0};
    private static final double[] c = new double[]{-BY.a(0.6), 0.0, BY.a(0.6)};
    private static final double[] d = new double[]{0.5555555555555556, 0.8888888888888888, 0.5555555555555556};
    private static final double[] e = new double[]{-BY.a((15.0 + 2.0 * BY.a(30.0)) / 35.0), -BY.a((15.0 - 2.0 * BY.a(30.0)) / 35.0), BY.a((15.0 - 2.0 * BY.a(30.0)) / 35.0), BY.a((15.0 + 2.0 * BY.a(30.0)) / 35.0)};
    private static final double[] f = new double[]{(90.0 - 5.0 * BY.a(30.0)) / 180.0, (90.0 + 5.0 * BY.a(30.0)) / 180.0, (90.0 + 5.0 * BY.a(30.0)) / 180.0, (90.0 - 5.0 * BY.a(30.0)) / 180.0};
    private static final double[] g = new double[]{-BY.a((35.0 + 2.0 * BY.a(70.0)) / 63.0), -BY.a((35.0 - 2.0 * BY.a(70.0)) / 63.0), 0.0, BY.a((35.0 - 2.0 * BY.a(70.0)) / 63.0), BY.a((35.0 + 2.0 * BY.a(70.0)) / 63.0)};
    private static final double[] h = new double[]{(322.0 - 13.0 * BY.a(70.0)) / 900.0, (322.0 + 13.0 * BY.a(70.0)) / 900.0, 0.5688888888888889, (322.0 + 13.0 * BY.a(70.0)) / 900.0, (322.0 - 13.0 * BY.a(70.0)) / 900.0};
    private final double[] i;
    private final double[] j;

    private mo_0(int n2, double d2, double d3, int n3, int n4) {
        super(d2, d3, n3, n4);
        switch (n2) {
            case 2: {
                this.i = a;
                this.j = b;
                return;
            }
            case 3: {
                this.i = c;
                this.j = d;
                return;
            }
            case 4: {
                this.i = e;
                this.j = f;
                return;
            }
            case 5: {
                this.i = g;
                this.j = h;
                return;
            }
        }
        throw new oV(px_0.N_POINTS_GAUSS_LEGENDRE_INTEGRATOR_NOT_SUPPORTED, n2, 2, 5);
    }

    private mo_0(int n2, double d2, double d3) {
        this(n2, d2, d3, 3, Integer.MAX_VALUE);
    }

    private mo_0(int n2, int n3, int n4) {
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
            double d6 = BY.d(4.0, BY.a(d4 / d5, 0.5 / (double)this.i.length));
            n2 = BY.b((int)(d6 * (double)n2), n2 + 1);
            d2 = d3;
            this.g();
        }
    }

    private double a(int n2) {
        double d2 = (this.i() - this.h()) / (double)n2;
        double d3 = d2 / 2.0;
        double d4 = this.h() + d3;
        double d5 = 0.0;
        for (int i2 = 0; i2 < n2; ++i2) {
            for (int i3 = 0; i3 < this.i.length; ++i3) {
                d5 += this.j[i3] * this.a(d4 + d3 * this.i[i3]);
            }
            d4 += d2;
        }
        return d3 * d5;
    }
}

