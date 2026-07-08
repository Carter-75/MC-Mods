/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Arrays;
import org.valkyrienskies.core.impl.shadow.oS;
import org.valkyrienskies.core.impl.shadow.zA;
import org.valkyrienskies.core.impl.shadow.zH;

public final class zL
implements zH {
    private final zA a;
    private final double[] b;
    private final double[] c;

    private zL(double[] dArray, double[] dArray2, zA zA2) {
        if (dArray.length != dArray2.length) {
            throw new oS(dArray.length, dArray2.length);
        }
        this.b = (double[])dArray.clone();
        this.c = (double[])dArray2.clone();
        this.a = zA2;
    }

    private zL(int n2, zA zA2) {
        this.b = new double[n2];
        this.c = new double[n2];
        Arrays.fill(this.c, 1.0);
        this.a = zA2;
    }

    public final double[] a() {
        double[] dArray = new double[this.b.length];
        for (int i2 = 0; i2 < dArray.length; ++i2) {
            dArray[i2] = this.b[i2] + this.c[i2] * this.a.a();
        }
        return dArray;
    }
}

