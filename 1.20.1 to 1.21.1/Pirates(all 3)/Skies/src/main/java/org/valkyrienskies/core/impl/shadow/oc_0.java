/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.oY;
import org.valkyrienskies.core.impl.shadow.ot_0;
import org.valkyrienskies.core.impl.shadow.pk_0;
import org.valkyrienskies.core.impl.shadow.pm_0;
import org.valkyrienskies.core.impl.shadow.po_0;
import org.valkyrienskies.core.impl.shadow.px_0;
import org.valkyrienskies.core.impl.shadow.zE;
import org.valkyrienskies.core.impl.shadow.zF;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.oc
 */
public abstract class oc_0
implements Serializable,
ot_0 {
    private static final long b = -1146319659338487221L;
    @Deprecated
    private zE c = new zE();
    protected final zF a;

    @Deprecated
    protected oc_0() {
        this.a = null;
    }

    protected oc_0(zF zF2) {
        this.a = zF2;
    }

    public final double a(int n2, int n3) {
        if (n3 < n2) {
            throw new pm_0(px_0.LOWER_ENDPOINT_ABOVE_UPPER_ENDPOINT, (Number)n2, n3, true);
        }
        return this.d(n3) - this.d(n2);
    }

    public int a(double d2) {
        if (d2 < 0.0 || d2 > 1.0) {
            throw new po_0(d2, (Number)0, 1);
        }
        int n2 = this.d();
        if (d2 == 0.0) {
            return n2;
        }
        if (n2 == Integer.MIN_VALUE) {
            if (this.e(n2) >= d2) {
                return n2;
            }
        } else {
            --n2;
        }
        int n3 = this.e();
        if (d2 == 1.0) {
            return n3;
        }
        double d3 = this.b();
        double d4 = BY.a(this.c());
        boolean bl = !Double.isInfinite(d3) && !Double.isNaN(d3) && !Double.isInfinite(d4) && !Double.isNaN(d4) && d4 != 0.0;
        if (bl) {
            double d5;
            double d6;
            double d7 = BY.a((1.0 - d2) / d2);
            double d8 = d3 - d7 * d4;
            if (d6 > (double)n2) {
                n2 = (int)BY.z(d8) - 1;
            }
            d7 = 1.0 / d7;
            d8 = d3 + d7 * d4;
            if (d5 < (double)n3) {
                n3 = (int)BY.z(d8) - 1;
            }
        }
        int n4 = n2;
        n2 = n3;
        int n5 = n4;
        double d9 = d2;
        oc_0 oc_02 = this;
        while (n5 + 1 < n2) {
            double d10;
            n3 = (n5 + n2) / 2;
            if (n3 < n5 || n3 > n2) {
                n3 = n5 + (n2 - n5) / 2;
            }
            double d11 = oc_02.e(n3);
            if (d10 >= d9) {
                n2 = n3;
                continue;
            }
            n5 = n3;
        }
        return n2;
    }

    private int a(double d2, int n2, int n3) {
        while (n2 + 1 < n3) {
            double d3;
            int n4 = (n2 + n3) / 2;
            if (n4 < n2 || n4 > n3) {
                n4 = n2 + (n3 - n2) / 2;
            }
            double d4 = this.e(n4);
            if (d3 >= d2) {
                n3 = n4;
                continue;
            }
            n2 = n4;
        }
        return n3;
    }

    public final void a(long l2) {
        this.a.setSeed(l2);
        this.c.a(l2);
    }

    public int a() {
        oc_0 oc_02 = this;
        return oc_02.a(oc_02.a.nextDouble());
    }

    public final int[] a(int n2) {
        if (n2 <= 0) {
            throw new pk_0(px_0.NUMBER_OF_SAMPLES, n2);
        }
        int[] nArray = new int[n2];
        for (int i2 = 0; i2 < n2; ++i2) {
            nArray[i2] = this.a();
        }
        return nArray;
    }

    private double e(int n2) {
        double d2 = this.d(n2);
        if (Double.isNaN(d2)) {
            throw new oY(px_0.DISCRETE_CUMULATIVE_PROBABILITY_RETURNED_NAN, n2);
        }
        return d2;
    }

    public double b(int n2) {
        return BY.k(this.c(n2));
    }
}

