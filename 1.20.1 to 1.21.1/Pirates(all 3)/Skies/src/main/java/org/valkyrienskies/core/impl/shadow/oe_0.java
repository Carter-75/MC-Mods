/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.lc_0;
import org.valkyrienskies.core.impl.shadow.nz_0;
import org.valkyrienskies.core.impl.shadow.oI;
import org.valkyrienskies.core.impl.shadow.pk_0;
import org.valkyrienskies.core.impl.shadow.pm_0;
import org.valkyrienskies.core.impl.shadow.po_0;
import org.valkyrienskies.core.impl.shadow.px_0;
import org.valkyrienskies.core.impl.shadow.zE;
import org.valkyrienskies.core.impl.shadow.zF;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.oe
 */
public abstract class oe_0
implements Serializable,
oI {
    private static double b = 1.0E-6;
    private static final long c = -38038050983108802L;
    @Deprecated
    private zE d = new zE();
    protected final zF a;
    private double e = 1.0E-6;

    @Deprecated
    protected oe_0() {
        this.a = null;
    }

    public oe_0(zF zF2) {
        this.a = zF2;
    }

    @Deprecated
    public double a(double d2, double d3) {
        return this.b(d2, d3);
    }

    public double b(double d2, double d3) {
        if (d2 > d3) {
            throw new pm_0(px_0.LOWER_ENDPOINT_ABOVE_UPPER_ENDPOINT, (Number)d2, d3, true);
        }
        return this.e(d3) - this.e(d2);
    }

    public double a(double d2) {
        boolean bl;
        if (d2 < 0.0 || d2 > 1.0) {
            throw new po_0(d2, (Number)0, 1);
        }
        double d3 = this.e();
        if (d2 == 0.0) {
            return d3;
        }
        double d4 = this.f();
        if (d2 == 1.0) {
            return d4;
        }
        double d5 = this.c();
        double d6 = BY.a(this.d());
        boolean bl2 = bl = !Double.isInfinite(d5) && !Double.isNaN(d5) && !Double.isInfinite(d6) && !Double.isNaN(d6);
        if (d3 == Double.NEGATIVE_INFINITY) {
            if (bl) {
                d3 = d5 - d6 * BY.a((1.0 - d2) / d2);
            } else {
                d3 = -1.0;
                while (this.e(d3) >= d2) {
                    d3 *= 2.0;
                }
            }
        }
        if (d4 == Double.POSITIVE_INFINITY) {
            if (bl) {
                d4 = d5 + d6 * BY.a(d2 / (1.0 - d2));
            } else {
                d4 = 1.0;
                while (this.e(d4) < d2) {
                    d4 *= 2.0;
                }
            }
        }
        lc_0 lc_02 = new lc_0(this, d2){
            private /* synthetic */ double a;
            private /* synthetic */ oe_0 b;
            {
                this.b = oe_02;
                this.a = d2;
            }

            public final double a(double d2) {
                return this.b.e(d2) - this.a;
            }
        };
        double d7 = this.a();
        double d8 = d4;
        double d9 = d3;
        nz_0 nz_02 = new nz_0(d7);
        double d10 = nz_02.a(Integer.MAX_VALUE, lc_02, d9, d8);
        return d10;
    }

    protected double a() {
        return this.e;
    }

    public void a(long l2) {
        this.a.setSeed(l2);
        this.d.a(l2);
    }

    public double b() {
        oe_0 oe_02 = this;
        return oe_02.a(oe_02.a.nextDouble());
    }

    public final double[] a(int n2) {
        if (n2 <= 0) {
            throw new pk_0(px_0.NUMBER_OF_SAMPLES, n2);
        }
        double[] dArray = new double[n2];
        for (int i2 = 0; i2 < n2; ++i2) {
            dArray[i2] = this.b();
        }
        return dArray;
    }

    public double b(double d2) {
        return 0.0;
    }

    public double c(double d2) {
        return BY.k(this.d(d2));
    }
}

