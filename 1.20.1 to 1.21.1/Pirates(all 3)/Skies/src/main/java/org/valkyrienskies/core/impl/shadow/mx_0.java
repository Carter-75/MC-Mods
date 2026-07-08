/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.co_0;
import org.valkyrienskies.core.impl.shadow.mu_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.mx
 */
public final class mx_0
extends mu_0<Double> {
    private static final double a = 1.772453850905516;
    private static final double b = 0.7511255444649425;
    private static final double c = 1.0622519320271968;

    @Override
    protected final co_0<Double[], Double[]> c(int n2) {
        double d2;
        if (n2 == 1) {
            return new co_0<Double[], Double[]>(new Double[]{0.0}, new Double[]{1.772453850905516});
        }
        int n3 = n2 - 1;
        Double[] doubleArray = this.b(n3);
        doubleArray = (Double[])doubleArray.a;
        Double[] doubleArray2 = new Double[n2];
        Double[] doubleArray3 = new Double[n2];
        double d3 = BY.a((double)(2 * n3));
        double d4 = BY.a((double)(2 * n2));
        int n4 = n2 / 2;
        for (int i2 = 0; i2 < n4; ++i2) {
            double d5;
            double d6 = i2 == 0 ? -d3 : doubleArray[i2 - 1];
            d2 = n4 == 1 ? -0.5 : doubleArray[i2];
            double d7 = 0.7511255444649425;
            double d8 = d6 * 1.0622519320271968;
            for (int i3 = 1; i3 < n2; ++i3) {
                double d9 = i3 + 1;
                double d10 = BY.a(2.0 / d9);
                double d11 = BY.a((double)i3 / d9);
                d5 = d10 * d6 * d8 - d11 * d7;
                d7 = d8;
                d8 = d5;
            }
            double d12 = 0.5 * (d6 + d2);
            double d13 = 0.7511255444649425;
            boolean bl = false;
            while (!bl) {
                bl = d2 - d6 <= Math.ulp(d12);
                d13 = 0.7511255444649425;
                double d14 = d12 * 1.0622519320271968;
                for (int i4 = 1; i4 < n2; ++i4) {
                    double d15 = i4 + 1;
                    double d16 = BY.a(2.0 / d15);
                    double d17 = BY.a((double)i4 / d15);
                    double d18 = d16 * d12 * d14 - d17 * d13;
                    d13 = d14;
                    d14 = d18;
                }
                if (bl) continue;
                if (d8 * d14 < 0.0) {
                    d2 = d12;
                } else {
                    d6 = d12;
                    d8 = d14;
                }
                d12 = 0.5 * (d6 + d2);
            }
            double d19 = d5 = d4 * d13;
            double d20 = 2.0 / (d19 * d19);
            doubleArray2[i2] = d12;
            doubleArray3[i2] = d20;
            int n5 = n3 - i2;
            doubleArray2[n5] = -d12;
            doubleArray3[n5] = d20;
        }
        if (n2 % 2 != 0) {
            double d21;
            double d22 = 0.7511255444649425;
            for (int i5 = 1; i5 < n2; i5 += 2) {
                d2 = i5 + 1;
                d22 = -BY.a((double)i5 / d2) * d22;
            }
            double d23 = d21 = d4 * d22;
            double d24 = 2.0 / (d23 * d23);
            doubleArray2[n4] = 0.0;
            doubleArray3[n4] = d24;
        }
        return new co_0<Double[], Double[]>(doubleArray2, doubleArray3);
    }
}

