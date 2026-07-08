/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.td_0;
import org.valkyrienskies.core.impl.shadow.te_0;
import org.valkyrienskies.core.impl.shadow.tq_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.ty
 */
public final class ty_0 {
    public final tq_0 a;
    public int b;

    private ty_0(tq_0 tq_02) {
        this(tq_02, 0.0);
    }

    public ty_0(tq_0 object, double d2) {
        int n2;
        int n3 = object.f();
        object = object.a();
        int n4 = n3;
        double[][] dArray = new double[n4][n4];
        int[] nArray = new int[n3];
        int n5 = 0;
        while (n5 < n3) {
            int n6 = n5++;
            nArray[n6] = n6;
        }
        n5 = 0;
        int n7 = 1;
        while (n7 != 0) {
            int n8;
            n2 = n5;
            for (n7 = n5 + 1; n7 < n3; ++n7) {
                int n9 = nArray[n7];
                int n10 = nArray[n2];
                if (!(object[n9][n9] > object[n10][n10])) continue;
                n2 = n7;
            }
            if (n2 != n5) {
                n7 = nArray[n5];
                nArray[n5] = nArray[n2];
                nArray[n2] = n7;
                double[] dArray2 = dArray[n5];
                dArray[n5] = dArray[n2];
                dArray[n2] = dArray2;
            }
            if (object[n7 = nArray[n5]][n7] <= d2) {
                if (n5 == 0) {
                    throw new te_0((double)object[n7][n7], n7, d2);
                }
                for (int i2 = n5; i2 < n3; ++i2) {
                    if (!(object[nArray[i2]][nArray[i2]] < -d2)) continue;
                    throw new te_0((double)object[nArray[i2]][nArray[i2]], i2, d2);
                }
                n8 = 0;
            } else {
                double d3;
                dArray[n5][n5] = d3 = BY.a((double)object[n7][n7]);
                double d4 = 1.0 / d3;
                double d5 = 1.0 / object[n7][n7];
                for (n2 = n5 + 1; n2 < n3; ++n2) {
                    double d6;
                    int n11 = nArray[n2];
                    dArray[n2][n5] = d6 = d4 * object[n11][n7];
                    Object object2 = object[n11];
                    int n9 = n11;
                    object2[n9] = object2[n9] - object[n11][n7] * object[n11][n7] * d5;
                    for (int i3 = n5 + 1; i3 < n2; ++i3) {
                        reference var24_20;
                        int n13 = nArray[i3];
                        object[n11][n13] = var24_20 = object[n11][n13] - d6 * dArray[i3][n5];
                        object[n13][n11] = var24_20;
                    }
                }
                n8 = ++n5 < n3 ? 1 : 0;
            }
            n7 = n8;
        }
        this.b = n5;
        this.a = td_0.a(n3, n5);
        for (n7 = 0; n7 < n3; ++n7) {
            for (n2 = 0; n2 < n5; ++n2) {
                this.a.c(nArray[n7], n2, dArray[n7][n2]);
            }
        }
    }

    public final tq_0 a() {
        return this.a;
    }

    public final int b() {
        return this.b;
    }
}

