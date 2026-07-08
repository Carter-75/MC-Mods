/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.valkyrienskies.core.impl.shadow.Ch
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.Ch;
import org.valkyrienskies.core.impl.shadow.ch_0;
import org.valkyrienskies.core.impl.shadow.co_0;
import org.valkyrienskies.core.impl.shadow.mn_0;
import org.valkyrienskies.core.impl.shadow.oS;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.mv
 */
public class mv_0 {
    private final double[] a;
    private final double[] b;

    public mv_0(double[] dArray, double[] dArray2) {
        if (dArray.length != dArray2.length) {
            throw new oS(dArray.length, dArray2.length);
        }
        Ch.a((double[])dArray, (int)ch_0.b.INCREASING$37efe540, (boolean)true, (boolean)true);
        this.a = (double[])dArray.clone();
        this.b = (double[])dArray2.clone();
    }

    public mv_0(co_0<double[], double[]> co_02) {
        co_0<double[], double[]> co_03 = co_02;
        co_0<double[], double[]> co_04 = co_03;
        co_04 = co_02;
        this((double[])co_03.a, (double[])co_04.b);
    }

    public double a(mn_0.1 var1_1) {
        double d2 = 0.0;
        double d3 = 0.0;
        for (int i2 = 0; i2 < this.a.length; ++i2) {
            double d4 = this.a[i2];
            double d5 = this.b[i2];
            double d6 = d5 * var1_1.a(d4) - d3;
            double d7 = d2 + d6;
            d3 = d7 - d2 - d6;
            d2 = d7;
        }
        return d2;
    }

    public final int a() {
        return this.a.length;
    }

    public final double a(int n2) {
        return this.a[n2];
    }

    public final double b(int n2) {
        return this.b[n2];
    }
}

