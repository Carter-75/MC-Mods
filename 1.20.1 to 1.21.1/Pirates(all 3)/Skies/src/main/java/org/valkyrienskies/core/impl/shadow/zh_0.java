/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.cb_0;
import org.valkyrienskies.core.impl.shadow.lc_0;
import org.valkyrienskies.core.impl.shadow.pc_0;
import org.valkyrienskies.core.impl.shadow.pp_0;
import org.valkyrienskies.core.impl.shadow.yH;
import org.valkyrienskies.core.impl.shadow.yf_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.zh
 */
@Deprecated
public final class zh_0 {
    private static final double d = 1.0E-21;
    private static final double e = 1.618034;
    private final double f;
    private final cb_0 g = new cb_0();
    public double a;
    public double b;
    public double c;
    private double h;
    private double i;
    private double j;

    public zh_0() {
        this(100.0, 50);
    }

    private zh_0(double d2, int n2) {
        this.f = 100.0;
        this.g.a(50);
    }

    public final void a(yH.a.1 var1_1, yf_0 yf_02, double d2, double d3) {
        double d4;
        double d5;
        this.g.d();
        boolean bl = yf_02 == yf_0.MINIMIZE;
        double d6 = this.a(var1_1, 0.0);
        double d7 = this.a(var1_1, 1.0);
        if (bl ? d6 < d7 : d6 > d7) {
            d2 = 1.0;
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
            double d16 = d3 + this.f * (d5 - d3);
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
        this.a = d2;
        this.h = d6;
        this.c = d3;
        this.j = d7;
        this.b = d5;
        this.i = d8;
        if (this.a > this.b) {
            d4 = this.a;
            this.a = this.b;
            this.b = d4;
            d4 = this.h;
            this.h = this.i;
            this.i = d4;
        }
    }

    private int d() {
        cb_0 cb_02 = this.g;
        return cb_02.a;
    }

    private int e() {
        cb_0 cb_02 = this.g;
        return cb_02.b;
    }

    public final double a() {
        return this.a;
    }

    private double f() {
        return this.h;
    }

    public final double b() {
        return this.b;
    }

    private double g() {
        return this.i;
    }

    public final double c() {
        return this.c;
    }

    private double h() {
        return this.j;
    }

    private double a(lc_0 lc_02, double d2) {
        try {
            this.g.c();
        }
        catch (pc_0 pc_02) {
            pc_0 pc_03 = pc_02;
            throw new pp_0(pc_03.a);
        }
        return lc_02.a(d2);
    }
}

