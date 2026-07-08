/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.ci_0;
import org.valkyrienskies.core.impl.shadow.kW;
import org.valkyrienskies.core.impl.shadow.oS;
import org.valkyrienskies.core.impl.shadow.pn_0;

@Deprecated
public final class yF
implements kW {
    private final kW a;
    private final double[] b;
    private final double[] c;
    private final double d;
    private final double[] e;

    private yF(kW kW2, double[] dArray, double[] dArray2, double d2, double[] dArray3) {
        ci_0.a((Object)dArray);
        ci_0.a((Object)dArray2);
        ci_0.a((Object)dArray3);
        if (dArray.length != dArray2.length) {
            throw new oS(dArray.length, dArray2.length);
        }
        if (dArray.length != dArray3.length) {
            throw new oS(dArray.length, dArray3.length);
        }
        for (int i2 = 0; i2 < dArray.length; ++i2) {
            if (dArray2[i2] >= dArray[i2]) continue;
            throw new pn_0(dArray2[i2], (Number)dArray[i2], true);
        }
        this.a = kW2;
        this.b = (double[])dArray.clone();
        this.c = (double[])dArray2.clone();
        this.d = d2;
        this.e = (double[])dArray3.clone();
    }

    public final double a(double[] dArray) {
        for (int i2 = 0; i2 < this.e.length; ++i2) {
            if (!(dArray[i2] < this.b[i2]) && !(dArray[i2] > this.c[i2])) continue;
            double d2 = 0.0;
            while (i2 < this.e.length) {
                double d3 = dArray[i2] < this.b[i2] ? this.e[i2] * (this.b[i2] - dArray[i2]) : (dArray[i2] > this.c[i2] ? this.e[i2] * (dArray[i2] - this.c[i2]) : 0.0);
                d2 += BY.a(d3);
                ++i2;
            }
            return this.d + d2;
        }
        return this.a.a(dArray);
    }
}

