/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.mm_0;
import org.valkyrienskies.core.impl.shadow.ms_0;
import org.valkyrienskies.core.impl.shadow.pm_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.mq
 */
public final class mq_0
extends mm_0 {
    private static int a = 32;

    private mq_0(double d2, double d3, int n2, int n3) {
        super(d2, d3, n2, n3);
        if (n3 > 32) {
            throw new pm_0(n3, (Number)32, false);
        }
    }

    private mq_0(int n2, int n3) {
        super(n2, n3);
        if (n3 > 32) {
            throw new pm_0(n3, (Number)32, false);
        }
    }

    public mq_0() {
        super(3, 32);
    }

    protected final double j() {
        int n2 = this.d() + 1;
        double[] dArray = new double[n2];
        double[] dArray2 = new double[n2];
        ms_0 ms_02 = new ms_0();
        dArray2[0] = ms_02.a(this, 0);
        this.g();
        double d2 = dArray2[0];
        while (true) {
            double d3;
            double d4;
            int n3 = this.f();
            double[] dArray3 = dArray;
            dArray = dArray2;
            dArray2 = dArray3;
            dArray3[0] = ms_02.a(this, n3);
            this.g();
            for (int i2 = 1; i2 <= n3; ++i2) {
                double d5;
                double d6 = (1L << 2 * i2) - 1L;
                double d7 = d5 = dArray2[i2 - 1];
                dArray2[i2] = d7 + (d7 - dArray[i2 - 1]) / d6;
            }
            double d8 = dArray2[n3];
            if (n3 >= this.c() && ((d4 = BY.w(d8 - d2)) <= (d3 = this.a() * (BY.w(d2) + BY.w(d8)) * 0.5) || d4 <= this.b())) {
                return d8;
            }
            d2 = d8;
        }
    }
}

