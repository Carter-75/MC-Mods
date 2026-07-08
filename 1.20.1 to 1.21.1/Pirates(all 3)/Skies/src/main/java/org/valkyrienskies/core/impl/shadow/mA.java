/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.co_0;
import org.valkyrienskies.core.impl.shadow.mn_0;
import org.valkyrienskies.core.impl.shadow.mv_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public final class mA
extends mv_0 {
    private mA(double[] dArray, double[] dArray2) {
        super(dArray, dArray2);
    }

    public mA(co_0<double[], double[]> co_02) {
        co_0<double[], double[]> co_03 = co_02;
        co_0<double[], double[]> co_04 = co_03;
        co_04 = co_02;
        this((double[])co_03.a, (double[])co_04.b);
    }

    @Override
    public final double a(mn_0.1 var1_1) {
        int n2 = this.a();
        if (n2 == 1) {
            return this.b(0) * var1_1.a(0.0);
        }
        int n3 = n2 / 2;
        double d2 = 0.0;
        double d3 = 0.0;
        for (int i2 = 0; i2 < n3; ++i2) {
            double d4 = this.a(i2);
            double d5 = this.b(i2);
            double d6 = var1_1.a(d4);
            double d7 = var1_1.a(-d4);
            double d8 = d5 * (d6 + d7) - d3;
            double d9 = d2 + d8;
            d3 = d9 - d2 - d8;
            d2 = d9;
        }
        if (n2 % 2 != 0) {
            double d10;
            double d11 = this.b(n3);
            double d12 = d11 * var1_1.a(0.0) - d3;
            d2 = d10 = d2 + d12;
        }
        return d2;
    }
}

