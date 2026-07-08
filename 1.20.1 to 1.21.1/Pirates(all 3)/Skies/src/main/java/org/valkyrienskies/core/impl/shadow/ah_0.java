/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.AG;
import org.valkyrienskies.core.impl.shadow.AM;
import org.valkyrienskies.core.impl.shadow.ao_0;
import org.valkyrienskies.core.impl.shadow.oV;
import org.valkyrienskies.core.impl.shadow.px_0;
import org.valkyrienskies.core.impl.shadow.sD;
import org.valkyrienskies.core.impl.shadow.tq_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Ah
 */
public class ah_0 {
    private final tq_0 a;
    private final int b;

    public ah_0() {
        this.a = null;
        this.b = 0;
    }

    private ah_0(double[][] dArray, boolean bl) {
        this(new sD(dArray), true);
    }

    public ah_0(double[][] dArray) {
        this(dArray, true);
    }

    private ah_0(tq_0 tq_02, boolean bl) {
        tq_0 tq_03 = tq_02;
        int n2 = tq_03.f();
        int n3 = tq_03.g();
        if (n2 < 2 || n3 <= 0) {
            throw new oV(px_0.INSUFFICIENT_ROWS_AND_COLUMNS, n2, n3);
        }
        this.b = tq_02.f();
        this.a = this.a(tq_02, bl);
    }

    private ah_0(tq_0 tq_02) {
        this(tq_02, true);
    }

    public tq_0 a() {
        return this.a;
    }

    public int b() {
        return this.b;
    }

    private sD a(tq_0 tq_02, boolean bl) {
        int n2 = tq_02.g();
        AM aM = new AM(bl);
        int n3 = n2;
        sD sD2 = new sD(n3, n3);
        for (int i2 = 0; i2 < n2; ++i2) {
            for (int i3 = 0; i3 < i2; ++i3) {
                double d2 = ah_0.a(tq_02.g(i2), tq_02.g(i3), bl);
                sD2.c(i2, i3, d2);
                sD2.c(i3, i2, d2);
            }
            int n4 = i2;
            sD2.c(n4, n4, ((ao_0)aM).a(tq_02.g(i2)));
        }
        return sD2;
    }

    private tq_0 a(tq_0 tq_02) {
        return this.a(tq_02, true);
    }

    private tq_0 a(double[][] dArray, boolean bl) {
        return this.a(new sD(dArray), true);
    }

    private tq_0 a(double[][] dArray) {
        boolean bl = true;
        double[][] dArray2 = dArray;
        ah_0 ah_02 = this;
        return ah_02.a(new sD(dArray2), true);
    }

    private static double a(double[] dArray, double[] dArray2, boolean bl) {
        AG aG = new AG();
        double d2 = 0.0;
        int n2 = dArray.length;
        if (n2 != dArray2.length) {
            throw new oV(px_0.DIMENSIONS_MISMATCH_SIMPLE, n2, dArray2.length);
        }
        if (n2 < 2) {
            throw new oV(px_0.INSUFFICIENT_OBSERVED_POINTS_IN_SAMPLE, n2, 2);
        }
        double d3 = ((ao_0)aG).a(dArray);
        double d4 = ((ao_0)aG).a(dArray2);
        for (int i2 = 0; i2 < n2; ++i2) {
            double d5 = dArray[i2] - d3;
            double d6 = dArray2[i2] - d4;
            d2 += (d5 * d6 - d2) / (double)(i2 + 1);
        }
        if (bl) {
            return d2 * ((double)n2 / (double)(n2 - 1));
        }
        return d2;
    }

    private double a(double[] dArray, double[] dArray2) {
        return ah_0.a(dArray, dArray2, true);
    }

    private static void b(tq_0 tq_02) {
        int n2 = tq_02.f();
        int n3 = tq_02.g();
        if (n2 < 2 || n3 <= 0) {
            throw new oV(px_0.INSUFFICIENT_ROWS_AND_COLUMNS, n2, n3);
        }
    }
}

