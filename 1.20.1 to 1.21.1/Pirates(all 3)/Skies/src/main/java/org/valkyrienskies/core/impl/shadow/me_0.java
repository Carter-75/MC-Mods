/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.kS;
import org.valkyrienskies.core.impl.shadow.kV;
import org.valkyrienskies.core.impl.shadow.lc_0;
import org.valkyrienskies.core.impl.shadow.lg_0;
import org.valkyrienskies.core.impl.shadow.ln_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.me
 */
public final class me_0
implements kS,
ln_0 {
    private static final double a = 0.006;
    private final boolean b;

    public me_0() {
        this(false);
    }

    private me_0(boolean bl) {
        this.b = false;
    }

    public final double a(double d2) {
        double d3;
        double d4 = d3 = this.b ? d2 * Math.PI : d2;
        if (BY.w(d4) <= 0.006) {
            double d5 = d3;
            double d6 = d5 * d5;
            return ((d6 - 20.0) * d6 + 120.0) / 120.0;
        }
        return BY.n(d3) / d3;
    }

    @Deprecated
    public final lc_0 a() {
        return kV.a((ln_0)this).a();
    }

    public final lg_0 a(lg_0 lg_02) {
        lg_0 lg_03 = lg_02;
        double d2 = (this.b ? Math.PI : 1.0) * lg_03.b[0];
        double d3 = d2 * d2;
        double[] dArray = new double[lg_02.D() + 1];
        if (BY.w(d2) <= 0.006) {
            for (int i2 = 0; i2 < dArray.length; ++i2) {
                int n2 = i2 / 2;
                dArray[i2] = (i2 & 1) == 0 ? (double)((n2 & 1) == 0 ? 1 : -1) * (1.0 / (double)(i2 + 1) - d3 * (1.0 / (double)(2 * i2 + 6) - d3 / (double)(i2 * 24 + 120))) : ((n2 & 1) == 0 ? -d2 : d2) * (1.0 / (double)(i2 + 2) - d3 * (1.0 / (double)(i2 * 6 + 24) - d3 / (double)(i2 * 120 + 720)));
            }
        } else {
            double d4 = 1.0 / d2;
            double d5 = BY.o(d2);
            double d6 = BY.n(d2);
            dArray[0] = d4 * d6;
            double[] dArray2 = new double[dArray.length];
            double[] dArray3 = dArray2;
            dArray2[0] = 1.0;
            double d7 = d4;
            for (int i3 = 1; i3 < dArray.length; ++i3) {
                int n3;
                double d8 = 0.0;
                double d9 = 0.0;
                if ((i3 & 1) == 0) {
                    dArray3[i3] = 0.0;
                    n3 = i3;
                } else {
                    dArray3[i3] = dArray3[i3 - 1];
                    d9 = dArray3[i3];
                    n3 = i3 - 1;
                }
                while (n3 > 1) {
                    int n4 = n3;
                    dArray3[n4] = (double)(n4 - i3) * dArray3[n3] - dArray3[n3 - 1];
                    d8 = d8 * d3 + dArray3[n3];
                    dArray3[n3 - 1] = (double)(n3 - 1 - i3) * dArray3[n3 - 1] + dArray3[n3 - 2];
                    d9 = d9 * d3 + dArray3[n3 - 1];
                    n3 -= 2;
                }
                dArray3[0] = dArray3[0] * (double)(-i3);
                d8 = d8 * d3 + dArray3[0];
                dArray[i3] = (d7 *= d4) * (d8 * d6 + d9 * d2 * d5);
            }
        }
        if (this.b) {
            double d10 = Math.PI;
            int n5 = 1;
            while (n5 < dArray.length) {
                int n6 = n5++;
                dArray[n6] = dArray[n6] * d10;
                d10 *= Math.PI;
            }
        }
        return lg_02.a(dArray);
    }
}

