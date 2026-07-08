/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.cc_0;
import org.valkyrienskies.core.impl.shadow.lc_0;
import org.valkyrienskies.core.impl.shadow.pc_0;
import org.valkyrienskies.core.impl.shadow.pp_0;
import org.valkyrienskies.core.impl.shadow.xi_0;
import org.valkyrienskies.core.impl.shadow.xl_0;

public final class xL {
    private static final double i = 1.0E-21;
    private static final double j = 1.618034;
    public final double a;
    public cc_0.a b = cc_0.a.a().b(500);
    public double c;
    public double d;
    public double e;
    public double f;
    public double g;
    public double h;

    public xL() {
        this(100.0, 500);
    }

    private xL(double d2, int n2) {
        this.a = 100.0;
    }

    public final void a(xl_0.1 var1_1, xi_0 xi_02, double d2, double d3) {
        double d4;
        double d5;
        this.b = this.b.a(0);
        boolean bl = xi_02 == xi_0.MINIMIZE;
        double d6 = this.a(var1_1, 0.0);
        double d7 = this.a(var1_1, d3);
        if (bl ? d6 < d7 : d6 > d7) {
            d2 = d3;
            d3 = 0.0;
            d5 = d6;
            d6 = d7;
            d7 = d5;
        }
        d5 = d3 + 1.618034 * (d3 - d2);
        double d8 = this.a(var1_1, d5);
        while (bl ? d8 < d7 : d8 > d7) {
            double d9;
            double d10;
            d4 = (d3 - d2) * (d7 - d8);
            double d11 = (d3 - d5) * (d7 - d6);
            double d12 = d11 - d4;
            double d13 = BY.w(d10) < 1.0E-21 ? 2.0E-21 : d12 * 2.0;
            double d14 = d3;
            double d15 = d14 - ((d14 - d5) * d11 - (d3 - d2) * d4) / d13;
            double d16 = d3 + this.a * (d5 - d3);
            if ((d15 - d5) * (d3 - d15) > 0.0) {
                d9 = this.a(var1_1, d15);
                if (bl ? d9 < d8 : d9 > d8) {
                    d2 = d3;
                    d3 = d15;
                    d6 = d7;
                    d7 = d9;
                    break;
                }
                if (bl ? d9 > d7 : d9 < d7) {
                    d5 = d15;
                    d8 = d9;
                    break;
                }
                d15 = d5 + 1.618034 * (d5 - d3);
                d9 = this.a(var1_1, d15);
            } else if ((d15 - d16) * (d16 - d5) >= 0.0) {
                d15 = d16;
                d9 = this.a(var1_1, d15);
            } else if ((d15 - d16) * (d5 - d15) > 0.0) {
                d9 = this.a(var1_1, d15);
                if (bl ? d9 < d8 : d9 > d8) {
                    d3 = d5;
                    d5 = d15;
                    d15 = d5 + 1.618034 * (d5 - d3);
                    d7 = d8;
                    d8 = d9;
                    d9 = this.a(var1_1, d15);
                }
            } else {
                d15 = d5 + 1.618034 * (d5 - d3);
                d9 = this.a(var1_1, d15);
            }
            d2 = d3;
            d6 = d7;
            d3 = d5;
            d7 = d8;
            d5 = d15;
            d8 = d9;
        }
        this.c = d2;
        this.f = d6;
        this.e = d3;
        this.h = d7;
        this.d = d5;
        this.g = d8;
        if (this.c > this.d) {
            d4 = this.c;
            this.c = this.d;
            this.d = d4;
            d4 = this.f;
            this.f = this.g;
            this.g = d4;
        }
    }

    private int d() {
        cc_0.a a2 = this.b;
        return a2.b;
    }

    private int e() {
        cc_0.a a2 = this.b;
        return a2.e;
    }

    public final double a() {
        return this.c;
    }

    private double f() {
        return this.f;
    }

    public final double b() {
        return this.d;
    }

    private double g() {
        return this.g;
    }

    public final double c() {
        return this.e;
    }

    private double h() {
        return this.h;
    }

    public double a(lc_0 lc_02, double d2) {
        try {
            cc_0.a a2 = this.b;
            a2.d(1);
        }
        catch (pc_0 pc_02) {
            pc_0 pc_03 = pc_02;
            throw new pp_0(pc_03.a);
        }
        return lc_02.a(d2);
    }
}

