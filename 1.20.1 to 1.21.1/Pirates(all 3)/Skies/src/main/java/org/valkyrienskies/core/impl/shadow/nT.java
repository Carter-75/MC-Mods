/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.nQ;
import org.valkyrienskies.core.impl.shadow.oV;
import org.valkyrienskies.core.impl.shadow.px_0;

public final class nT {
    private nT() {
    }

    private static nQ a(double d2, double d3) {
        if (d2 < 0.0) {
            throw new oV(px_0.NEGATIVE_COMPLEX_MODULE, d2);
        }
        return new nQ(d2 * BY.o(d3), d2 * BY.n(d3));
    }

    public static nQ[] a(double[] dArray) {
        nQ[] nQArray = new nQ[dArray.length];
        for (int i2 = 0; i2 < dArray.length; ++i2) {
            nQArray[i2] = new nQ(dArray[i2], 0.0);
        }
        return nQArray;
    }
}

