/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.math.BigDecimal;
import org.valkyrienskies.core.impl.shadow.co_0;
import org.valkyrienskies.core.impl.shadow.mA;
import org.valkyrienskies.core.impl.shadow.mu_0;
import org.valkyrienskies.core.impl.shadow.mv_0;
import org.valkyrienskies.core.impl.shadow.mx_0;
import org.valkyrienskies.core.impl.shadow.my_0;
import org.valkyrienskies.core.impl.shadow.mz_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.mw
 */
public final class mw_0 {
    private final mu_0<Double> a = new mz_0();
    private final mu_0<BigDecimal> b = new my_0();
    private final mu_0<Double> c = new mx_0();

    private mv_0 a(int n2) {
        int n3 = n2;
        mu_0<Double> mu_02 = this.a;
        return new mv_0(mu_02.a(n3));
    }

    private mv_0 b(int n2, double d2, double d3) {
        int n3 = n2;
        mu_0<Double> mu_02 = this.a;
        return new mv_0(mw_0.a(mu_02.a(n3), d2, d3));
    }

    private mv_0 b(int n2) {
        int n3 = n2;
        mu_0<BigDecimal> mu_02 = this.b;
        return new mv_0(mu_02.a(n3));
    }

    public final mv_0 a(int n2, double d2, double d3) {
        int n3 = n2;
        mu_0<BigDecimal> mu_02 = this.b;
        return new mv_0(mw_0.a(mu_02.a(n3), d2, d3));
    }

    private mA c(int n2) {
        int n3 = n2;
        mu_0<Double> mu_02 = this.c;
        return new mA(mu_02.a(n3));
    }

    private static co_0<double[], double[]> a(mu_0<? extends Number> mu_02, int n2) {
        return mu_02.a(n2);
    }

    private static co_0<double[], double[]> a(co_0<double[], double[]> object, double d2, double d3) {
        co_0<double[], double[]> co_02 = object;
        double[] dArray = (double[])co_02.a;
        co_02 = object;
        object = (double[])co_02.b;
        double d4 = (d3 - d2) / 2.0;
        double d5 = d2 + d4;
        int n2 = 0;
        while (n2 < dArray.length) {
            dArray[n2] = dArray[n2] * d4 + d5;
            Object object2 = object;
            int n3 = n2++;
            object2[n3] = object2[n3] * d4;
        }
        return new co_0<double[], Object>(dArray, object);
    }
}

