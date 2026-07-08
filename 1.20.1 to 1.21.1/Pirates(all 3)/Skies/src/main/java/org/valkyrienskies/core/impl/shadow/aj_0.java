/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.BA;
import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.ah_0;
import org.valkyrienskies.core.impl.shadow.oK;
import org.valkyrienskies.core.impl.shadow.oS;
import org.valkyrienskies.core.impl.shadow.oV;
import org.valkyrienskies.core.impl.shadow.pl_0;
import org.valkyrienskies.core.impl.shadow.px_0;
import org.valkyrienskies.core.impl.shadow.sD;
import org.valkyrienskies.core.impl.shadow.tq_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Aj
 */
public final class aj_0 {
    final tq_0 a;
    private final int b;

    public aj_0() {
        this.a = null;
        this.b = 0;
    }

    private aj_0(double[][] dArray) {
        this(new sD(dArray));
    }

    public aj_0(tq_0 tq_02) {
        this.b = tq_02.f();
        this.a = this.a(tq_02);
    }

    private aj_0(ah_0 ah_02) {
        tq_0 tq_02 = ah_02.a();
        if (tq_02 == null) {
            throw new pl_0(px_0.COVARIANCE_MATRIX, new Object[0]);
        }
        this.b = ah_02.b();
        this.a = aj_0.b(tq_02);
    }

    private aj_0(tq_0 tq_02, int n2) {
        this.b = n2;
        this.a = aj_0.b(tq_02);
    }

    public final tq_0 a() {
        return this.a;
    }

    private sD b() {
        int n2 = this.a.g();
        double[][] dArray = new double[n2][n2];
        for (int i2 = 0; i2 < n2; ++i2) {
            for (int i3 = 0; i3 < n2; ++i3) {
                double d2;
                double d3 = d2 = this.a.b(i2, i3);
                dArray[i2][i3] = BY.a((1.0 - d3 * d3) / (double)(this.b - 2));
            }
        }
        return new sD(dArray);
    }

    private sD c() {
        oK oK2 = new oK(this.b - 2);
        int n2 = this.a.g();
        double[][] dArray = new double[n2][n2];
        for (int i2 = 0; i2 < n2; ++i2) {
            for (int i3 = 0; i3 < n2; ++i3) {
                double d2;
                if (i2 == i3) {
                    dArray[i2][i3] = 0.0;
                    continue;
                }
                double d3 = d2 = this.a.b(i2, i3);
                double d4 = BY.w(d2 * BY.a((double)(this.b - 2) / (1.0 - d3 * d3)));
                dArray[i2][i3] = 2.0 * oK2.e(-d4);
            }
        }
        return new sD(dArray);
    }

    public final sD a(tq_0 tq_02) {
        int n2;
        aj_0.c(tq_02);
        int n3 = n2 = tq_02.g();
        sD sD2 = new sD(n3, n3);
        int n4 = 0;
        while (n4 < n2) {
            for (int i2 = 0; i2 < n4; ++i2) {
                double d2 = aj_0.a(tq_02.g(n4), tq_02.g(i2));
                sD2.c(n4, i2, d2);
                sD2.c(i2, n4, d2);
            }
            int n5 = n4++;
            sD2.c(n5, n5, 1.0);
        }
        return sD2;
    }

    private tq_0 a(double[][] dArray) {
        return this.a(new sD(dArray));
    }

    public static double a(double[] dArray, double[] dArray2) {
        BA bA = new BA();
        if (dArray.length != dArray2.length) {
            throw new oS(dArray.length, dArray2.length);
        }
        if (dArray.length < 2) {
            throw new oV(px_0.INSUFFICIENT_DIMENSION, dArray.length, 2);
        }
        for (int i2 = 0; i2 < dArray.length; ++i2) {
            bA.a(dArray[i2], dArray2[i2]);
        }
        return bA.e();
    }

    private static sD b(tq_0 tq_02) {
        int n2;
        int n3 = n2 = tq_02.g();
        sD sD2 = new sD(n3, n3);
        for (int i2 = 0; i2 < n2; ++i2) {
            int n4 = i2;
            double d2 = BY.a(tq_02.b(n4, n4));
            int n5 = i2;
            sD2.c(n5, n5, 1.0);
            for (int i3 = 0; i3 < i2; ++i3) {
                int n6 = i3;
                double d3 = tq_02.b(i2, i3) / (d2 * BY.a(tq_02.b(n6, n6)));
                sD2.c(i2, i3, d3);
                sD2.c(i3, i2, d3);
            }
        }
        return sD2;
    }

    private static void c(tq_0 tq_02) {
        int n2 = tq_02.f();
        int n3 = tq_02.g();
        if (n2 < 2 || n3 < 2) {
            throw new oV(px_0.INSUFFICIENT_ROWS_AND_COLUMNS, n2, n3);
        }
    }
}

