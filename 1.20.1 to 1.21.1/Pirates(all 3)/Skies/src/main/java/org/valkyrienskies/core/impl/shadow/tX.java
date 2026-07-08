/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.ch_0;
import org.valkyrienskies.core.impl.shadow.tW;

public final class tX
implements tW {
    private static final long a = -5406732779747414922L;

    public final double a(double[] dArray, double[] dArray2) {
        double[] dArray3 = dArray2;
        double[] dArray4 = dArray;
        ch_0.a(dArray, dArray3, true);
        double d2 = 0.0;
        double d3 = 0.0;
        for (int i2 = 0; i2 < dArray.length; ++i2) {
            double d4 = dArray[i2] + d2 - dArray2[i2];
            d3 += BY.w(d4);
            d2 = d4;
        }
        return d3;
    }
}

