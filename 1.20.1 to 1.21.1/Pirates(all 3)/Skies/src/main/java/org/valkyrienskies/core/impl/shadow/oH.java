/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.BR;
import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.oE;
import org.valkyrienskies.core.impl.shadow.oJ;
import org.valkyrienskies.core.impl.shadow.oc_0;
import org.valkyrienskies.core.impl.shadow.oe_0;
import org.valkyrienskies.core.impl.shadow.on_0;
import org.valkyrienskies.core.impl.shadow.pk_0;
import org.valkyrienskies.core.impl.shadow.px_0;
import org.valkyrienskies.core.impl.shadow.zF;
import org.valkyrienskies.core.impl.shadow.zR;
import org.valkyrienskies.core.impl.shadow.zY;

public final class oH
extends oc_0 {
    private static int b = 10000000;
    private static double c = 1.0E-12;
    private static final long d = -3349935121172596109L;
    private final oE e;
    private final on_0 f;
    private final double g;
    private final int h;
    private final double i;

    private oH(double d2) {
        this(d2, 1.0E-12, 10000000);
    }

    private oH(double d2, double d3, int n2) {
        this(new zR(), d2, d3, n2);
    }

    public oH(zF zF2, double d2, double d3, int n2) {
        super(zF2);
        if (d2 <= 0.0) {
            throw new pk_0(px_0.MEAN, d2);
        }
        this.g = d2;
        this.i = d3;
        this.h = n2;
        double d4 = d2;
        this.e = new oE(zF2, d4, BY.a(d4), 1.0E-9);
        this.f = new on_0(zF2, 1.0, 1.0E-9);
    }

    private oH(double d2, double d3) {
        this(d2, d3, 10000000);
    }

    private oH(double d2, int n2) {
        this(d2, 1.0E-12, n2);
    }

    private double g() {
        return this.g;
    }

    public final double c(int n2) {
        double d2 = ((oc_0)this).b(n2);
        if (d2 == Double.NEGATIVE_INFINITY) {
            return 0.0;
        }
        return BY.i(d2);
    }

    public final double b(int n2) {
        double d2 = n2 < 0 || n2 == Integer.MAX_VALUE ? Double.NEGATIVE_INFINITY : (n2 == 0 ? -this.g : -oJ.a(n2) - oJ.a(n2, this.g) - 0.5 * BY.k(Math.PI * 2) - 0.5 * BY.k(n2));
        return d2;
    }

    public final double d(int n2) {
        if (n2 < 0) {
            return 0.0;
        }
        if (n2 == Integer.MAX_VALUE) {
            return 1.0;
        }
        return zY.b((double)n2 + 1.0, this.g, this.i, this.h);
    }

    private double e(int n2) {
        return this.e.e((double)n2 + 0.5);
    }

    public final double b() {
        oH oH2 = this;
        return oH2.g;
    }

    public final double c() {
        oH oH2 = this;
        return oH2.g;
    }

    public final int d() {
        return 0;
    }

    public final int e() {
        return Integer.MAX_VALUE;
    }

    public final boolean f() {
        return true;
    }

    public final int a() {
        oH oH2 = this;
        return (int)BY.a(oH2.b(oH2.g), Integer.MAX_VALUE);
    }

    private long b(double d2) {
        double d3;
        long l2;
        block9: {
            if (d2 < 40.0) {
                double d4 = BY.i(-d2);
                long l3 = 0L;
                double d5 = 1.0;
                while ((double)l3 < d2 * 1000.0) {
                    double d6;
                    double d7 = this.a.nextDouble();
                    d5 *= d7;
                    if (d6 >= d4) {
                        ++l3;
                        continue;
                    }
                    return l3;
                }
                return l3;
            }
            double d8 = BY.y(d2);
            double d9 = d2 - d8;
            double d10 = BY.k(d8);
            double d11 = BR.c((int)d8);
            l2 = d9 < Double.MIN_VALUE ? 0L : this.b(d9);
            double d12 = BY.a(d8 * BY.k(d8 * 32.0 / Math.PI + 1.0));
            double d13 = d12 / 2.0;
            double d14 = d8 * 2.0 + d12;
            double d15 = BY.a(d14 * Math.PI) * BY.i(1.0 / (d8 * 8.0));
            double d16 = d14 / d12 * BY.i(-d12 * (d12 + 1.0) / d14);
            double d17 = d15 + d16 + 1.0;
            double d18 = d15 / d17;
            double d19 = d16 / d17;
            double d20 = 1.0 / (d8 * 8.0);
            while (true) {
                double d21;
                double d22;
                double d23;
                double d24 = this.a.nextDouble();
                if (d23 <= d18) {
                    double d25 = this.a.nextGaussian();
                    d22 = d25 * BY.a(d8 + d13) - 0.5;
                    if (d22 > d12 || d22 < -d8) continue;
                    d3 = d22 < 0.0 ? BY.y(d22) : BY.z(d22);
                    double d26 = ((oe_0)this.f).b();
                    double d27 = d25;
                    d21 = -d26 - d27 * d27 / 2.0 + d20;
                } else {
                    if (d24 > d18 + d19) {
                        d3 = d8;
                        break block9;
                    }
                    d22 = d12 + d14 / d12 * ((oe_0)this.f).b();
                    d3 = BY.z(d22);
                    d21 = -((oe_0)this.f).b() - d12 * (d22 + 1.0) / d14;
                }
                boolean bl = d22 < 0.0;
                double d28 = d3;
                double d29 = d28 * (d28 + 1.0) / (d8 * 2.0);
                if (d21 < -d29 && !bl) {
                    d3 = d8 + d3;
                    break block9;
                }
                double d30 = d29 * ((d3 * 2.0 + 1.0) / (d8 * 6.0) - 1.0);
                double d31 = d29;
                double d32 = d30 - d31 * d31 / (3.0 * (d8 + (double)bl * (d3 + 1.0)));
                if (d21 < d32) {
                    d3 = d8 + d3;
                    break block9;
                }
                if (!(d21 > d30) && d21 < d3 * d10 - BR.c((int)(d3 + d8)) + d11) break;
            }
            d3 = d8 + d3;
        }
        return l2 + (long)d3;
    }
}

