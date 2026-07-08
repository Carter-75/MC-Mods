/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Comparator;
import org.valkyrienskies.core.impl.shadow.kW;
import org.valkyrienskies.core.impl.shadow.wQ;
import org.valkyrienskies.core.impl.shadow.xA;
import org.valkyrienskies.core.impl.shadow.xu_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.xx
 */
public final class xx_0
extends xu_0 {
    private static final double d = 2.0;
    private static final double e = 0.5;
    private final double f;
    private final double g;

    private xx_0(int n2) {
        this(n2, 1.0);
    }

    private xx_0(int n2, double d2) {
        this(n2, 1.0, 2.0, 0.5);
    }

    private xx_0(int n2, double d2, double d3) {
        this(n2, 1.0, d2, d3);
    }

    private xx_0(int n2, double d2, double d3, double d4) {
        super(n2, d2);
        this.f = d3;
        this.g = d4;
    }

    private xx_0(double[] dArray) {
        this(dArray, 2.0, 0.5);
    }

    private xx_0(double[] dArray, double d2, double d3) {
        super(dArray);
        this.f = 2.0;
        this.g = 0.5;
    }

    private xx_0(double[][] dArray) {
        this(dArray, 2.0, 0.5);
    }

    private xx_0(double[][] dArray, double d2, double d3) {
        super(dArray);
        this.f = 2.0;
        this.g = 0.5;
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    @Override
    public final void a(xA.1 object, xA.2 var2_2) {
        wQ[] wQArray = this.c();
        wQ[] wQArray2 = wQArray[0];
        wQ wQ2 = this.a((kW)object, wQArray, 1.0, var2_2);
        if (var2_2.compare(wQ2, wQArray2) < 0) {
            wQArray2 = this.c();
            if (var2_2.compare(wQ2, object = this.a((kW)object, wQArray, this.f, var2_2)) <= 0) {
                this.a(wQArray2);
            }
            return;
        }
        this.a((kW)object, wQArray, this.g, var2_2);
    }

    private wQ a(kW kW2, wQ[] wQArray, double d2, Comparator<wQ> comparator) {
        wQ wQ2 = wQArray[0];
        Object object = wQ2;
        object = wQ2;
        double[] dArray = (double[])wQ2.a;
        this.a(0, wQArray[0]);
        int n2 = this.a();
        for (int i2 = 1; i2 < this.b(); ++i2) {
            wQ wQ3 = wQArray[i2];
            object = wQ3;
            object = wQ3;
            object = (double[])wQ3.a;
            double[] dArray2 = new double[n2];
            for (int i3 = 0; i3 < n2; ++i3) {
                dArray2[i3] = dArray[i3] + d2 * (dArray[i3] - object[i3]);
            }
            this.a(i2, new wQ(dArray2, Double.NaN, false));
        }
        this.a(kW2, comparator);
        return this.a(0);
    }
}

