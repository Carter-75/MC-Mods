/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.oc_0;
import org.valkyrienskies.core.impl.shadow.pk_0;
import org.valkyrienskies.core.impl.shadow.px_0;
import org.valkyrienskies.core.impl.shadow.zF;
import org.valkyrienskies.core.impl.shadow.zR;

public final class oP
extends oc_0 {
    private static final long b = -140627372283420404L;
    private final int c;
    private final double d;
    private double e = Double.NaN;
    private boolean f = false;
    private double g = Double.NaN;
    private boolean h = false;
    private transient a i;

    private oP(int n2, double d2) {
        this(new zR(), n2, d2);
    }

    public oP(zF zF2, int n2, double d2) {
        super(zF2);
        if (n2 <= 0) {
            throw new pk_0(px_0.DIMENSION, n2);
        }
        if (d2 <= 0.0) {
            throw new pk_0(px_0.EXPONENT, d2);
        }
        this.c = n2;
        this.d = d2;
    }

    private int g() {
        return this.c;
    }

    private double h() {
        return this.d;
    }

    public final double c(int n2) {
        if (n2 <= 0 || n2 > this.c) {
            return 0.0;
        }
        return 1.0 / BY.a((double)n2, this.d) / oP.a(this.c, this.d);
    }

    public final double b(int n2) {
        if (n2 <= 0 || n2 > this.c) {
            return Double.NEGATIVE_INFINITY;
        }
        return -BY.k(n2) * this.d - BY.k(oP.a(this.c, this.d));
    }

    public final double d(int n2) {
        if (n2 <= 0) {
            return 0.0;
        }
        if (n2 >= this.c) {
            return 1.0;
        }
        return oP.a(n2, this.d) / oP.a(this.c, this.d);
    }

    public final double b() {
        if (!this.f) {
            oP oP2;
            oP oP3 = oP2 = this;
            int n2 = oP2.c;
            oP3 = oP2;
            double d2 = oP3.d;
            double d3 = oP.a(n2, d2 - 1.0);
            double d4 = oP.a(n2, d2);
            oP2.e = d3 / d4;
            this.f = true;
        }
        return this.e;
    }

    private double i() {
        oP oP2 = this;
        int n2 = oP2.c;
        oP2 = this;
        double d2 = oP2.d;
        double d3 = oP.a(n2, d2 - 1.0);
        double d4 = oP.a(n2, d2);
        return d3 / d4;
    }

    public final double c() {
        if (!this.h) {
            oP oP2;
            oP oP3 = oP2 = this;
            int n2 = oP2.c;
            oP3 = oP2;
            double d2 = oP3.d;
            double d3 = oP.a(n2, d2 - 2.0);
            double d4 = oP.a(n2, d2 - 1.0);
            double d5 = oP.a(n2, d2);
            double d6 = d4;
            double d7 = d5;
            oP2.g = d3 / d5 - d6 * d6 / (d7 * d7);
            this.h = true;
        }
        return this.g;
    }

    private double j() {
        oP oP2 = this;
        int n2 = oP2.c;
        oP2 = this;
        double d2 = oP2.d;
        double d3 = oP.a(n2, d2 - 2.0);
        double d4 = oP.a(n2, d2 - 1.0);
        double d5 = oP.a(n2, d2);
        double d6 = d4;
        double d7 = d5;
        return d3 / d5 - d6 * d6 / (d7 * d7);
    }

    private static double a(int n2, double d2) {
        double d3 = 0.0;
        while (n2 > 0) {
            d3 += 1.0 / BY.a((double)n2, d2);
            --n2;
        }
        return d3;
    }

    public final int d() {
        return 1;
    }

    public final int e() {
        oP oP2 = this;
        return oP2.c;
    }

    public final boolean f() {
        return true;
    }

    public final int a() {
        double d2;
        double d3;
        int n2;
        if (this.i == null) {
            this.i = new a(this.c, this.d);
        }
        zF zF2 = this.a;
        a a2 = this.i;
        do {
            if ((n2 = (int)((d3 = a2.c(d2 = a2.c + zF2.nextDouble() * (a2.b - a2.c))) + 0.5)) <= 0) {
                n2 = 1;
                continue;
            }
            if (n2 <= a2.a) continue;
            n2 = a2.a;
        } while (!((double)n2 - d3 <= a2.d) && !(d2 >= a2.a((double)n2 + 0.5) - a2.b(n2)));
        return n2;
    }

    static final class a {
        private final double e;
        final int a;
        final double b;
        final double c;
        final double d;

        a(int n2, double d2) {
            this.e = d2;
            this.a = n2;
            this.b = this.a(1.5) - 1.0;
            this.c = this.a((double)n2 + 0.5);
            a a2 = this;
            this.d = 2.0 - a2.c(a2.a(2.5) - this.b(2.0));
        }

        final int a(zF zF2) {
            double d2;
            double d3;
            int n2;
            do {
                if ((n2 = (int)((d3 = this.c(d2 = this.c + zF2.nextDouble() * (this.b - this.c))) + 0.5)) <= 0) {
                    n2 = 1;
                    continue;
                }
                if (n2 <= this.a) continue;
                n2 = this.a;
            } while (!((double)n2 - d3 <= this.d) && !(d2 >= this.a((double)n2 + 0.5) - this.b(n2)));
            return n2;
        }

        double a(double d2) {
            double d3 = BY.k(d2);
            return org.valkyrienskies.core.impl.shadow.oP$a.e((1.0 - this.e) * d3) * d3;
        }

        double b(double d2) {
            return BY.i(-this.e * BY.k(d2));
        }

        double c(double d2) {
            double d3;
            double d4 = d2 * (1.0 - this.e);
            if (d3 < -1.0) {
                d4 = -1.0;
            }
            return BY.i(org.valkyrienskies.core.impl.shadow.oP$a.d(d4) * d2);
        }

        private static double d(double d2) {
            if (BY.w(d2) > 1.0E-8) {
                return BY.l(d2) / d2;
            }
            return 1.0 - d2 * (0.5 - d2 * (0.3333333333333333 - d2 * 0.25));
        }

        private static double e(double d2) {
            if (BY.w(d2) > 1.0E-8) {
                return BY.j(d2) / d2;
            }
            return 1.0 + d2 * 0.5 * (1.0 + d2 * 0.3333333333333333 * (1.0 + d2 * 0.25));
        }
    }
}

