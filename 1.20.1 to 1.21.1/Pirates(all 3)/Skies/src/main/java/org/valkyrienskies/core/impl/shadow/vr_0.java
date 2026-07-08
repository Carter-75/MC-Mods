/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.sv_0;
import org.valkyrienskies.core.impl.shadow.sy_0;
import org.valkyrienskies.core.impl.shadow.td_0;
import org.valkyrienskies.core.impl.shadow.tn_0;
import org.valkyrienskies.core.impl.shadow.tp_0;
import org.valkyrienskies.core.impl.shadow.tq_0;
import org.valkyrienskies.core.impl.shadow.uF;
import org.valkyrienskies.core.impl.shadow.uT;
import org.valkyrienskies.core.impl.shadow.vv_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.vr
 */
public abstract class vr_0
extends uT {
    private final vv_0 m;

    public vr_0(String string, int n2, int n3, double d2, double d3, double d4, double d5) {
        super(string, n2, n3, d2, d3, d4, d5);
        this.m = vv_0.a(n2);
    }

    public vr_0(String string, int n2, int n3, double d2, double d3, double[] dArray, double[] dArray2) {
        super(string, n2, n3, d2, d3, dArray, dArray2);
        this.m = vv_0.a(n2);
    }

    public abstract void a(uF var1, double var2);

    public final sy_0 a(double d2, double[] object, double[][] dArray, double[][] dArray2) {
        double[] dArray3 = object;
        double[][] dArray4 = dArray;
        dArray = dArray2;
        object = dArray4;
        double[] dArray5 = dArray3;
        double d3 = d2;
        Object object2 = this.m;
        dArray2 = new double[((vv_0)object2).b.length + 1][((vv_0)object2).b.length + 1];
        object2 = new double[((vv_0)object2).b.length + 1][((double)object[0]).length];
        double d4 = object[0];
        double[] dArray6 = dArray[0];
        for (int i2 = 1; i2 < ((double[])object).length; ++i2) {
            double d5 = dArray5[i2] - dArray5[0];
            double d6 = d5 / d3;
            double d7 = 1.0 / d3;
            double[] dArray7 = dArray2[2 * i2 - 2];
            Object object3 = 2 * i2 - 1 < dArray2.length ? dArray2[2 * i2 - 1] : null;
            for (int i3 = 0; i3 < dArray7.length; ++i3) {
                dArray7[i3] = d5 * (d7 *= d6);
                if (object3 == null) continue;
                int n2 = i3;
                object3[n2] = (double)(n2 + 2) * d7;
            }
            double d8 = object[i2];
            dArray7 = dArray[i2];
            object3 = object2[2 * i2 - 2];
            Object object4 = 2 * i2 - 1 < ((Object)object2).length ? object2[2 * i2 - 1] : null;
            for (int i4 = 0; i4 < ((double)d8).length; ++i4) {
                object3[i4] = d8[i4] - d4[i4] - d5 * dArray6[i4];
                if (object4 == null) continue;
                object4[i4] = dArray7[i4] - dArray6[i4];
            }
        }
        tn_0 tn_02 = new tn_0(new sy_0(dArray2, false));
        tq_0 tq_02 = tn_02.c().a(new sy_0((double[][])object2, false));
        sy_0 sy_02 = new sy_0(tq_02.f() - 1, tq_02.g());
        for (int i5 = 0; i5 < ((tp_0)sy_02).f(); ++i5) {
            for (int i6 = 0; i6 < ((tp_0)sy_02).g(); ++i6) {
                ((sv_0)sy_02).c(i5, i6, tq_02.b(i5, i6));
            }
        }
        return sy_02;
    }

    public final sy_0 a(sy_0 object) {
        Object object2 = object;
        object = this.m;
        object = ((vv_0)object).a;
        td_0.b((sv_0)object, (tq_0)object2);
        int n2 = ((tp_0)object).f();
        int n3 = ((tp_0)object2).g();
        int n4 = ((tp_0)object).g();
        double[][] dArray = new double[n2][n3];
        double[] dArray2 = new double[n4];
        object2 = ((sy_0)object2).a;
        for (int i2 = 0; i2 < n3; ++i2) {
            int n5;
            for (n5 = 0; n5 < n4; ++n5) {
                dArray2[n5] = (double)object2[n5][i2];
            }
            for (n5 = 0; n5 < n2; ++n5) {
                double[] dArray3 = ((sy_0)object).a[n5];
                double d2 = 0.0;
                for (int i3 = 0; i3 < n4; ++i3) {
                    d2 += dArray3[i3] * dArray2[i3];
                }
                dArray[n5][i2] = d2;
            }
        }
        return new sy_0(dArray, false);
    }

    public final void a(double[] object, double[] dArray, sy_0 object2) {
        Object object3 = object2;
        object2 = dArray;
        dArray = object;
        object = this.m;
        object3 = ((sy_0)object3).a;
        for (int i2 = 0; i2 < ((Object)object3).length; ++i2) {
            Object object4 = object3[i2];
            double d2 = object.b[i2];
            for (int i3 = 0; i3 < ((Object)object4).length; ++i3) {
                Object object5 = object4;
                int n2 = i3;
                object5[n2] = object5[n2] + d2 * (dArray[i3] - object2[i3]);
            }
        }
    }
}

