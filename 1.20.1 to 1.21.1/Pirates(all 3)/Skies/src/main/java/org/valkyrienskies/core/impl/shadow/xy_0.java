/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Comparator;
import org.valkyrienskies.core.impl.shadow.co_0;
import org.valkyrienskies.core.impl.shadow.kW;
import org.valkyrienskies.core.impl.shadow.wQ;
import org.valkyrienskies.core.impl.shadow.xA;
import org.valkyrienskies.core.impl.shadow.xu_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.xy
 */
public final class xy_0
extends xu_0 {
    private static final double d = 1.0;
    private static final double e = 2.0;
    private static final double f = 0.5;
    private static final double g = 0.5;
    private final double h;
    private final double i;
    private final double j;
    private final double k;

    private xy_0(int n2) {
        this(n2, 1.0);
    }

    private xy_0(int n2, double d2) {
        this(n2, 1.0, 1.0, 2.0, 0.5, 0.5);
    }

    private xy_0(int n2, double d2, double d3, double d4, double d5, double d6) {
        super(n2, d2);
        this.h = d3;
        this.i = d4;
        this.j = d5;
        this.k = d6;
    }

    private xy_0(int n2, double d2, double d3, double d4, double d5) {
        this(n2, 1.0, d2, d3, d4, d5);
    }

    private xy_0(double[] dArray) {
        this(dArray, 1.0, 2.0, 0.5, 0.5);
    }

    private xy_0(double[] dArray, double d2, double d3, double d4, double d5) {
        super(dArray);
        this.h = 1.0;
        this.i = 2.0;
        this.j = 0.5;
        this.k = 0.5;
    }

    private xy_0(double[][] dArray) {
        this(dArray, 1.0, 2.0, 0.5, 0.5);
    }

    private xy_0(double[][] dArray, double d2, double d3, double d4, double d5) {
        super(dArray);
        this.h = 1.0;
        this.i = 2.0;
        this.j = 0.5;
        this.k = 0.5;
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     * Enabled aggressive block sorting
     */
    @Override
    public final void a(xA.1 var1_1, xA.2 var2_2) {
        wQ wQ2;
        int n2;
        Object object;
        int n3 = this.a();
        Object object2 = this.a(0);
        wQ wQ3 = this.a(n3 - 1);
        Object object3 = object = this.a(n3);
        object3 = object;
        double[] dArray = (double[])((co_0)object).a;
        double[] dArray2 = new double[n3];
        for (int i2 = 0; i2 < n3; ++i2) {
            wQ wQ4 = this.a(i2);
            object3 = wQ4;
            object3 = wQ4;
            object3 = (double[])wQ4.a;
            for (n2 = 0; n2 < n3; ++n2) {
                int n4 = n2;
                dArray2[n4] = dArray2[n4] + object3[n2];
            }
        }
        double d2 = 1.0 / (double)n3;
        n2 = 0;
        while (n2 < n3) {
            int n5 = n2++;
            dArray2[n5] = dArray2[n5] * d2;
        }
        double[] dArray3 = new double[n3];
        for (int i3 = 0; i3 < n3; ++i3) {
            dArray3[i3] = dArray2[i3] + this.h * (dArray2[i3] - dArray[i3]);
        }
        wQ wQ5 = new wQ(dArray3, var1_1.a(dArray3), false);
        if (var2_2.compare(object2, wQ5) <= 0 && var2_2.compare(wQ5, wQ3) < 0) {
            this.a(wQ5, (Comparator<wQ>)var2_2);
            return;
        }
        if (var2_2.compare(wQ5, object2) < 0) {
            object2 = new double[n3];
            for (int i4 = 0; i4 < n3; ++i4) {
                object2[i4] = dArray2[i4] + this.i * (dArray3[i4] - dArray2[i4]);
            }
            wQ wQ6 = new wQ((double[])object2, var1_1.a((double[])object2), false);
            if (var2_2.compare(wQ6, wQ5) < 0) {
                this.a(wQ6, (Comparator<wQ>)var2_2);
                return;
            }
            this.a(wQ5, (Comparator<wQ>)var2_2);
            return;
        }
        if (var2_2.compare(wQ5, object) < 0) {
            object2 = new double[n3];
            for (int i5 = 0; i5 < n3; ++i5) {
                object2[i5] = dArray2[i5] + this.j * (dArray3[i5] - dArray2[i5]);
            }
            wQ2 = new wQ((double[])object2, var1_1.a((double[])object2), false);
            if (var2_2.compare(wQ2, wQ5) <= 0) {
                this.a(wQ2, (Comparator<wQ>)var2_2);
                return;
            }
        } else {
            object2 = new double[n3];
            for (int i6 = 0; i6 < n3; ++i6) {
                object2[i6] = dArray2[i6] - this.j * (dArray2[i6] - dArray[i6]);
            }
            wQ2 = new wQ((double[])object2, var1_1.a((double[])object2), false);
            if (var2_2.compare(wQ2, object) < 0) {
                this.a(wQ2, (Comparator<wQ>)var2_2);
                return;
            }
        }
        wQ wQ7 = this.a(0);
        object3 = wQ7;
        object3 = wQ7;
        object2 = (double[])wQ7.a;
        int n6 = 1;
        while (true) {
            if (n6 > n3) {
                this.a((kW)var1_1, (Comparator<wQ>)var2_2);
                return;
            }
            object = this.a(n6).a();
            for (int i7 = 0; i7 < n3; ++i7) {
                object[i7] = object2[i7] + this.k * (object[i7] - object2[i7]);
            }
            this.a(n6, new wQ((double[])object, Double.NaN, false));
            ++n6;
        }
    }
}

