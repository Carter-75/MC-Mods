/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.kS;
import org.valkyrienskies.core.impl.shadow.kV;
import org.valkyrienskies.core.impl.shadow.lc_0;
import org.valkyrienskies.core.impl.shadow.lf_0;
import org.valkyrienskies.core.impl.shadow.lg_0;
import org.valkyrienskies.core.impl.shadow.ln_0;

public final class lQ
implements kS,
ln_0 {
    public final double a(double d2) {
        return BY.m(d2);
    }

    @Deprecated
    public final lc_0 a() {
        return kV.a((ln_0)this).a();
    }

    public final lg_0 a(lg_0 lg_02) {
        lg_0 lg_03 = new lg_0(lg_02.a);
        boolean bl = false;
        double[] dArray = lg_03.b;
        bl = false;
        double[] dArray2 = lg_02.b;
        lf_0 lf_02 = lg_02.a;
        double[] dArray3 = new double[1 + lf_02.b];
        double[] dArray4 = dArray3;
        dArray3[0] = BY.m(dArray2[0]);
        if (lf_02.b > 0) {
            double d2 = 1.0 / dArray2[0];
            double d3 = d2 / BY.k(10.0);
            for (int i2 = 1; i2 <= lf_02.b; ++i2) {
                dArray4[i2] = d3;
                d3 *= (double)(-i2) * d2;
            }
        }
        lf_02.b(dArray2, 0, dArray4, dArray, 0);
        return lg_03;
    }
}

