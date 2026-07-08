/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.ch_0;
import org.valkyrienskies.core.impl.shadow.tW;

public final class tU
implements tW {
    private static final long a = -6972277381587032228L;

    public final double a(double[] dArray, double[] dArray2) {
        double[] dArray3 = dArray2;
        double[] dArray4 = dArray;
        ch_0.a(dArray, dArray3, true);
        double d2 = 0.0;
        for (int i2 = 0; i2 < dArray.length; ++i2) {
            double d3 = BY.w(dArray[i2] - dArray2[i2]);
            double d4 = BY.w(dArray[i2]) + BY.w(dArray2[i2]);
            d2 += d3 == 0.0 && d4 == 0.0 ? 0.0 : d3 / d4;
        }
        return d2;
    }
}

