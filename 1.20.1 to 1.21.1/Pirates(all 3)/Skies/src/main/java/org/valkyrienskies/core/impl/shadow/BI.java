/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import org.valkyrienskies.core.impl.shadow.BD;
import org.valkyrienskies.core.impl.shadow.BE;
import org.valkyrienskies.core.impl.shadow.BG;
import org.valkyrienskies.core.impl.shadow.BJ;
import org.valkyrienskies.core.impl.shadow.BK;
import org.valkyrienskies.core.impl.shadow.BL;
import org.valkyrienskies.core.impl.shadow.BM;
import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.kV;
import org.valkyrienskies.core.impl.shadow.lc_0;
import org.valkyrienskies.core.impl.shadow.nQ;
import org.valkyrienskies.core.impl.shadow.oV;
import org.valkyrienskies.core.impl.shadow.px_0;

public final class BI
implements Serializable,
BJ {
    private static long a = 20120211L;
    private final int b;

    private BI(int n2) {
        this.b = n2;
    }

    public final double[] a(double[] dArray, int n2) {
        if (this.b == BE.ORTHOGONAL_DST_I$553793ab) {
            double d2 = BY.a(2.0 / (double)dArray.length);
            return BL.a(BI.a(dArray), d2);
        }
        if (n2 == BK.FORWARD$4b20d4ed) {
            return BI.a(dArray);
        }
        double d3 = 2.0 / (double)dArray.length;
        return BL.a(BI.a(dArray), d3);
    }

    public final double[] a(lc_0 object, double d2, double d3, int n2, int n3) {
        double[] dArray = kV.a((lc_0)object, d2, d3, n2);
        object = dArray;
        dArray[0] = 0.0;
        return this.a((double[])object, n3);
    }

    private static double[] a(double[] object) {
        double[] dArray = new double[((double[])object).length];
        if (!BM.a((long)((double[])object).length)) {
            throw new oV(px_0.NOT_POWER_OF_TWO_CONSIDER_PADDING, ((double[])object).length);
        }
        if (object[0] != 0.0) {
            throw new oV(px_0.FIRST_ELEMENT_NOT_ZERO, object[0]);
        }
        int n2 = ((double[])object).length;
        if (n2 == 1) {
            dArray[0] = 0.0;
            return dArray;
        }
        double[] dArray2 = new double[n2];
        double[] dArray3 = dArray2;
        dArray2[0] = 0.0;
        dArray3[n2 >> 1] = 2.0 * object[n2 >> 1];
        for (int i2 = 1; i2 < n2 >> 1; ++i2) {
            double d2 = BY.n((double)i2 * Math.PI / (double)n2) * (object[i2] + object[n2 - i2]);
            double d3 = 0.5 * (object[i2] - object[n2 - i2]);
            dArray3[i2] = d2 + d3;
            dArray3[n2 - i2] = d2 - d3;
        }
        BG bG = new BG(BD.STANDARD$1f30b0a8);
        nQ[] nQArray = bG.a(dArray3, BK.FORWARD$4b20d4ed);
        dArray[0] = 0.0;
        nQ nQ2 = nQArray[0];
        object = nQ2;
        dArray[1] = 0.5 * nQ2.d;
        for (int i3 = 1; i3 < n2 >> 1; ++i3) {
            nQ nQ3 = nQArray[i3];
            object = nQ3;
            dArray[2 * i3] = -nQ3.c;
            nQ nQ4 = nQArray[i3];
            object = nQ4;
            dArray[2 * i3 + 1] = nQ4.d + dArray[2 * i3 - 1];
        }
        return dArray;
    }
}

