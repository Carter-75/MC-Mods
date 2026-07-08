/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.lc_0;
import org.valkyrienskies.core.impl.shadow.wM;
import org.valkyrienskies.core.impl.shadow.wO;
import org.valkyrienskies.core.impl.shadow.xL;
import org.valkyrienskies.core.impl.shadow.xM;
import org.valkyrienskies.core.impl.shadow.xO;
import org.valkyrienskies.core.impl.shadow.xP;
import org.valkyrienskies.core.impl.shadow.xQ;
import org.valkyrienskies.core.impl.shadow.xS;
import org.valkyrienskies.core.impl.shadow.xi_0;
import org.valkyrienskies.core.impl.shadow.xp_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.xl
 */
public final class xl_0 {
    private static final double b = 1.0E-15;
    private static final double c = Double.MIN_VALUE;
    private final xM d;
    private final xL e = new xL();
    private final double f;
    final xp_0 a;

    public xl_0(xp_0 xp_02, double d2, double d3, double d4) {
        this.a = xp_02;
        this.d = new xM(1.0E-15, Double.MIN_VALUE, new xP(d2, d3));
        this.f = d4;
    }

    public final xS a(double[] object, double[] object2) {
        double d2;
        double d3;
        int n2 = ((double[])object).length;
        object = new lc_0(this, n2, (double[])object, (double[])object2){
            private /* synthetic */ int a;
            private /* synthetic */ double[] b;
            private /* synthetic */ double[] c;
            private /* synthetic */ xl_0 d;
            {
                this.d = xl_02;
                this.a = n2;
                this.b = dArray;
                this.c = dArray2;
            }

            public final double a(double d2) {
                double[] dArray = new double[this.a];
                for (int i2 = 0; i2 < this.a; ++i2) {
                    dArray[i2] = this.b[i2] + d2 * this.c[i2];
                }
                xl_0 xl_02 = this.d;
                double d3 = xl_02.a.b(dArray);
                return d3;
            }
        };
        xp_0 xp_02 = this.a;
        object2 = xp_02;
        object2 = xp_02.a;
        double d4 = this.f;
        double d5 = 0.0;
        Object object3 = object2;
        Object object4 = object;
        xL xL2 = this.e;
        this.e.b = xL2.b.a(0);
        boolean bl = object3 == xi_0.MINIMIZE;
        double d6 = xL2.a((lc_0)object4, 0.0);
        double d7 = xL2.a((lc_0)object4, d4);
        if (bl ? d6 < d7 : d6 > d7) {
            d5 = d4;
            d4 = 0.0;
            d3 = d6;
            d6 = d7;
            d7 = d3;
        }
        d3 = d4 + 1.618034 * (d4 - d5);
        double d8 = xL2.a((lc_0)object4, d3);
        while (bl ? d8 < d7 : d8 > d7) {
            double d9;
            double d10;
            d2 = (d4 - d5) * (d7 - d8);
            double d11 = (d4 - d3) * (d7 - d6);
            double d12 = d11 - d2;
            double d13 = BY.w(d10) < 1.0E-21 ? 2.0E-21 : d12 * 2.0;
            double d14 = d4;
            double d15 = d14 - ((d14 - d3) * d11 - (d4 - d5) * d2) / d13;
            double d16 = d4 + xL2.a * (d3 - d4);
            if ((d15 - d3) * (d4 - d15) > 0.0) {
                d9 = xL2.a((lc_0)object4, d15);
                if (bl ? d9 < d8 : d9 > d8) {
                    d5 = d4;
                    d4 = d15;
                    d6 = d7;
                    d7 = d9;
                    break;
                }
                if (bl ? d9 > d7 : d9 < d7) {
                    d3 = d15;
                    d8 = d9;
                    break;
                }
                d15 = d3 + 1.618034 * (d3 - d4);
                d9 = xL2.a((lc_0)object4, d15);
            } else if ((d15 - d16) * (d16 - d3) >= 0.0) {
                d15 = d16;
                d9 = xL2.a((lc_0)object4, d15);
            } else if ((d15 - d16) * (d3 - d15) > 0.0) {
                d9 = xL2.a((lc_0)object4, d15);
                if (bl ? d9 < d8 : d9 > d8) {
                    d4 = d3;
                    d3 = d15;
                    d15 = d3 + 1.618034 * (d3 - d4);
                    d7 = d8;
                    d8 = d9;
                    d9 = xL2.a((lc_0)object4, d15);
                }
            } else {
                d15 = d3 + 1.618034 * (d3 - d4);
                d9 = xL2.a((lc_0)object4, d15);
            }
            d5 = d4;
            d6 = d7;
            d4 = d3;
            d7 = d8;
            d3 = d15;
            d8 = d9;
        }
        xL2.c = d5;
        xL2.f = d6;
        xL2.e = d4;
        xL2.h = d7;
        xL2.d = d3;
        xL2.g = d8;
        if (xL2.c > xL2.d) {
            d2 = xL2.c;
            xL2.c = xL2.d;
            xL2.d = d2;
            d2 = xL2.f;
            xL2.f = xL2.g;
            xL2.g = d2;
        }
        wO[] wOArray = new wO[4];
        wOArray[0] = new wM(Integer.MAX_VALUE);
        wOArray[1] = new xQ(object);
        wOArray[2] = object2;
        xL xL3 = this.e;
        xL2 = xL3;
        xL xL4 = this.e;
        xL2 = xL4;
        xL2 = this.e;
        wOArray[3] = new xO(xL3.c, xL4.d, xL2.e);
        return this.d.c(wOArray);
    }

    static /* synthetic */ xp_0 a(xl_0 xl_02) {
        return xl_02.a;
    }
}

