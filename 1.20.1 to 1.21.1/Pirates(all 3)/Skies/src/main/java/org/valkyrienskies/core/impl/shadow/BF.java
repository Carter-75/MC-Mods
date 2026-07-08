/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import org.valkyrienskies.core.impl.shadow.BC;
import org.valkyrienskies.core.impl.shadow.BD;
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

public final class BF
implements Serializable,
BJ {
    private static long a = 20120212L;
    private final int b;

    private BF(int n2) {
        this.b = n2;
    }

    public final double[] a(double[] dArray, int n2) {
        if (n2 == BK.FORWARD$4b20d4ed) {
            if (this.b == BC.ORTHOGONAL_DCT_I$3c19b5bb) {
                double d2 = BY.a(2.0 / (double)(dArray.length - 1));
                return BL.a(BF.a(dArray), d2);
            }
            return BF.a(dArray);
        }
        double d3 = 2.0 / (double)(dArray.length - 1);
        double d4 = this.b == BC.ORTHOGONAL_DCT_I$3c19b5bb ? BY.a(d3) : d3;
        return BL.a(BF.a(dArray), d4);
    }

    public final double[] a(lc_0 object, double d2, double d3, int n2, int n3) {
        object = kV.a((lc_0)object, d2, d3, n2);
        return this.a((double[])object, n3);
    }

    private static double[] a(double[] object) {
        double[] dArray = new double[((double[])object).length];
        int n2 = ((double[])object).length - 1;
        if (!BM.a((long)n2)) {
            throw new oV(px_0.NOT_POWER_OF_TWO_PLUS_ONE, ((double[])object).length);
        }
        if (n2 == 1) {
            dArray[0] = 0.5 * (object[0] + object[1]);
            dArray[1] = 0.5 * (object[0] - object[1]);
            return dArray;
        }
        double[] dArray2 = new double[n2];
        double[] dArray3 = dArray2;
        dArray2[0] = 0.5 * (object[0] + object[n2]);
        dArray3[n2 >> 1] = object[n2 >> 1];
        double d2 = 0.5 * (object[0] - object[n2]);
        for (int i2 = 1; i2 < n2 >> 1; ++i2) {
            double d3 = 0.5 * (object[i2] + object[n2 - i2]);
            double d4 = BY.n((double)i2 * Math.PI / (double)n2) * (object[i2] - object[n2 - i2]);
            double d5 = BY.o((double)i2 * Math.PI / (double)n2) * (object[i2] - object[n2 - i2]);
            dArray3[i2] = d3 - d4;
            dArray3[n2 - i2] = d3 + d4;
            d2 += d5;
        }
        BG bG = new BG(BD.STANDARD$1f30b0a8);
        nQ[] nQArray = bG.a(dArray3, BK.FORWARD$4b20d4ed);
        nQ nQ2 = nQArray[0];
        object = nQ2;
        dArray[0] = nQ2.d;
        dArray[1] = d2;
        for (int i3 = 1; i3 < n2 >> 1; ++i3) {
            nQ nQ3 = nQArray[i3];
            object = nQ3;
            dArray[2 * i3] = nQ3.d;
            nQ nQ4 = nQArray[i3];
            object = nQ4;
            dArray[2 * i3 + 1] = dArray[2 * i3 - 1] - nQ4.c;
        }
        nQ nQ5 = nQArray[n2 >> 1];
        object = nQ5;
        dArray[n2] = nQ5.d;
        return dArray;
    }
}

