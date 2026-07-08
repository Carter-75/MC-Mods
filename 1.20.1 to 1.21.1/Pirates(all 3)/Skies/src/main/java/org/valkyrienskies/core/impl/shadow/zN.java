/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.zF;
import org.valkyrienskies.core.impl.shadow.zH;
import org.valkyrienskies.core.impl.shadow.zz_0;

public final class zN
implements zH {
    private final zF a;
    private final int b;

    private zN(int n2, zz_0 zz_02) {
        this.b = n2;
        this.a = zz_02;
    }

    public zN(int n2) {
        this(n2, new zz_0());
    }

    public final double[] a() {
        double[] dArray = new double[this.b];
        double d2 = 0.0;
        for (int i2 = 0; i2 < this.b; ++i2) {
            double d3;
            dArray[i2] = d3 = this.a.nextGaussian();
            double d4 = d3;
            d2 += d4 * d4;
        }
        double d5 = 1.0 / BY.a(d2);
        int n2 = 0;
        while (n2 < this.b) {
            int n3 = n2++;
            dArray[n3] = dArray[n3] * d5;
        }
        return dArray;
    }
}

