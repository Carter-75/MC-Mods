/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.co_0;
import org.valkyrienskies.core.impl.shadow.mu_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.mz
 */
public final class mz_0
extends mu_0<Double> {
    @Override
    protected final co_0<Double[], Double[]> c(int n2) {
        if (n2 == 1) {
            return new co_0<Double[], Double[]>(new Double[]{0.0}, new Double[]{2.0});
        }
        Double[] doubleArray = this.b(n2 - 1);
        doubleArray = (Double[])doubleArray.a;
        Double[] doubleArray2 = new Double[n2];
        Double[] doubleArray3 = new Double[n2];
        int n3 = n2 / 2;
        for (int i2 = 0; i2 < n3; ++i2) {
            double d2 = i2 == 0 ? -1.0 : doubleArray[i2 - 1];
            double d3 = n3 == 1 ? 1.0 : doubleArray[i2];
            double d4 = 1.0;
            double d5 = d2;
            double d6 = 1.0;
            double d7 = d3;
            for (int i3 = 1; i3 < n2; ++i3) {
                int n4 = 2 * i3 + 1;
                int n5 = i3 + 1;
                double d8 = ((double)n4 * d2 * d5 - (double)i3 * d4) / (double)n5;
                double d9 = ((double)n4 * d3 * d7 - (double)i3 * d6) / (double)n5;
                d4 = d5;
                d5 = d8;
                d6 = d7;
                d7 = d9;
            }
            double d10 = 0.5 * (d2 + d3);
            double d11 = 1.0;
            double d12 = d10;
            boolean bl = false;
            while (!bl) {
                bl = d3 - d2 <= Math.ulp(d10);
                d11 = 1.0;
                d12 = d10;
                for (int i4 = 1; i4 < n2; ++i4) {
                    double d13 = ((double)(2 * i4 + 1) * d10 * d12 - (double)i4 * d11) / (double)(i4 + 1);
                    d11 = d12;
                    d12 = d13;
                }
                if (bl) continue;
                if (d5 * d12 <= 0.0) {
                    d3 = d10;
                } else {
                    d2 = d10;
                    d5 = d12;
                }
                d10 = 0.5 * (d2 + d3);
            }
            double d14 = (double)n2 * (d11 - d10 * d12);
            double d15 = d10;
            double d16 = d14;
            double d17 = 2.0 * (1.0 - d15 * d15) / (d16 * d16);
            doubleArray2[i2] = d10;
            doubleArray3[i2] = d17;
            int n6 = n2 - i2 - 1;
            doubleArray2[n6] = -d10;
            doubleArray3[n6] = d17;
        }
        if (n2 % 2 != 0) {
            double d18;
            double d19 = 1.0;
            for (int i5 = 1; i5 < n2; i5 += 2) {
                d19 = (double)(-i5) * d19 / (double)(i5 + 1);
            }
            double d20 = d18 = (double)n2 * d19;
            double d21 = 2.0 / (d20 * d20);
            doubleArray2[n3] = 0.0;
            doubleArray3[n3] = d21;
        }
        return new co_0<Double[], Double[]>(doubleArray2, doubleArray3);
    }
}

