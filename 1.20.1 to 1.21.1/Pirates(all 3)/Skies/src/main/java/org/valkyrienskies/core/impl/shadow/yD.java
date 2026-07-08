/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Comparator;
import org.valkyrienskies.core.impl.shadow.kW;
import org.valkyrienskies.core.impl.shadow.yI;
import org.valkyrienskies.core.impl.shadow.yp_0;
import org.valkyrienskies.core.impl.shadow.yx_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
@Deprecated
public final class yD
extends yx_0 {
    private static final double d = 2.0;
    private static final double e = 0.5;
    private final double f;
    private final double g;

    private yD(int n2) {
        this(n2, 1.0);
    }

    private yD(int n2, double d2) {
        this(n2, 1.0, 2.0, 0.5);
    }

    private yD(int n2, double d2, double d3) {
        this(n2, 1.0, d2, d3);
    }

    private yD(int n2, double d2, double d3, double d4) {
        super(n2, d2);
        this.f = d3;
        this.g = d4;
    }

    private yD(double[] dArray) {
        this(dArray, 2.0, 0.5);
    }

    private yD(double[] dArray, double d2, double d3) {
        super(dArray);
        this.f = 2.0;
        this.g = 0.5;
    }

    private yD(double[][] dArray) {
        this(dArray, 2.0, 0.5);
    }

    private yD(double[][] dArray, double d2, double d3) {
        super(dArray);
        this.f = 2.0;
        this.g = 0.5;
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    @Override
    public final void a(yI.1 object, yI.2 var2_2) {
        yp_0[] yp_0Array = this.c();
        yp_0[] yp_0Array2 = yp_0Array[0];
        yp_0 yp_02 = this.a((kW)object, yp_0Array, 1.0, var2_2);
        if (var2_2.compare(yp_02, yp_0Array2) < 0) {
            yp_0Array2 = this.c();
            if (var2_2.compare(yp_02, object = this.a((kW)object, yp_0Array, this.f, var2_2)) <= 0) {
                this.a(yp_0Array2);
            }
            return;
        }
        this.a((kW)object, yp_0Array, this.g, var2_2);
    }

    private yp_0 a(kW kW2, yp_0[] yp_0Array, double d2, Comparator<yp_0> comparator) {
        yp_0 yp_02 = yp_0Array[0];
        Object object = yp_02;
        object = yp_02;
        double[] dArray = (double[])yp_02.a;
        this.a(0, yp_0Array[0]);
        int n2 = this.a();
        for (int i2 = 1; i2 < this.b(); ++i2) {
            yp_0 yp_03 = yp_0Array[i2];
            object = yp_03;
            object = yp_03;
            object = (double[])yp_03.a;
            double[] dArray2 = new double[n2];
            for (int i3 = 0; i3 < n2; ++i3) {
                dArray2[i3] = dArray[i3] + d2 * (dArray[i3] - object[i3]);
            }
            this.a(i2, new yp_0(dArray2, Double.NaN, false));
        }
        this.a(kW2, comparator);
        return this.a(0);
    }
}

