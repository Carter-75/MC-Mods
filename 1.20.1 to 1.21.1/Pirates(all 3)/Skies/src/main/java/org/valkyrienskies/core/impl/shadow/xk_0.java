/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.kW;
import org.valkyrienskies.core.impl.shadow.kY;
import org.valkyrienskies.core.impl.shadow.oS;
import org.valkyrienskies.core.impl.shadow.tq_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.xk
 */
public final class xk_0
implements kW {
    private final kY a;
    private final double[] b;
    private final double[] c;
    private final tq_0 d;

    private xk_0(kY kY2, double[] dArray) {
        this.a = kY2;
        this.b = (double[])dArray.clone();
        this.c = null;
        this.d = null;
    }

    private xk_0(kY kY2, double[] dArray, double[] dArray2) {
        if (dArray.length != dArray2.length) {
            throw new oS(dArray.length, dArray2.length);
        }
        this.a = kY2;
        this.b = (double[])dArray.clone();
        this.c = (double[])dArray2.clone();
        this.d = null;
    }

    private xk_0(kY kY2, double[] dArray, tq_0 tq_02) {
        if (dArray.length != tq_02.g()) {
            throw new oS(dArray.length, tq_02.g());
        }
        this.a = kY2;
        this.b = (double[])dArray.clone();
        this.c = null;
        this.d = tq_02.i();
    }

    public final double a(double[] dArray) {
        if ((dArray = this.a.a(dArray)).length != this.b.length) {
            throw new oS(dArray.length, this.b.length);
        }
        for (int i2 = 0; i2 < dArray.length; ++i2) {
            int n2 = i2;
            dArray[n2] = dArray[n2] - this.b[i2];
        }
        double d2 = 0.0;
        if (this.c != null) {
            for (int i3 = 0; i3 < dArray.length; ++i3) {
                double d3 = dArray[i3];
                d2 += this.c[i3] * d3 * d3;
            }
        } else if (this.d != null) {
            double[] dArray2 = this.d.a(dArray);
            int n3 = dArray2.length;
            for (int i4 = 0; i4 < n3; ++i4) {
                double d4;
                double d5 = d4 = dArray2[i4];
                d2 += d5 * d5;
            }
        } else {
            double[] dArray3 = dArray;
            int n4 = dArray.length;
            for (int i5 = 0; i5 < n4; ++i5) {
                double d6;
                double d7 = d6 = dArray3[i5];
                d2 += d7 * d7;
            }
        }
        return d2;
    }
}

