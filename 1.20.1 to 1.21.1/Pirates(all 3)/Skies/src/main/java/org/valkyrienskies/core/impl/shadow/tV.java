/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.ch_0;
import org.valkyrienskies.core.impl.shadow.tW;

public final class tV
implements tW {
    private static final long a = -4694868171115238296L;

    public final double a(double[] dArray, double[] dArray2) {
        double[] dArray3 = dArray;
        double[] dArray4 = dArray2;
        double[] dArray5 = dArray3;
        ch_0.a(dArray3, dArray4, true);
        double d2 = 0.0;
        for (int i2 = 0; i2 < dArray.length; ++i2) {
            d2 = BY.e(d2, BY.w(dArray[i2] - dArray2[i2]));
        }
        return d2;
    }
}

