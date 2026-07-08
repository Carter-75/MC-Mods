/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.valkyrienskies.core.impl.shadow.kN;
import org.valkyrienskies.core.impl.shadow.qd_0;
import org.valkyrienskies.core.impl.shadow.sP;
import org.valkyrienskies.core.impl.shadow.sQ;
import org.valkyrienskies.core.impl.shadow.sv_0;
import org.valkyrienskies.core.impl.shadow.sx_0;
import org.valkyrienskies.core.impl.shadow.sy_0;
import org.valkyrienskies.core.impl.shadow.sz_0;
import org.valkyrienskies.core.impl.shadow.td_0;
import org.valkyrienskies.core.impl.shadow.tn_0;
import org.valkyrienskies.core.impl.shadow.tp_0;
import org.valkyrienskies.core.impl.shadow.tq_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.vv
 */
public final class vv_0 {
    private static final Map<Integer, vv_0> c = new HashMap<Integer, vv_0>();
    final sy_0 a;
    final double[] b;

    private vv_0(int n2) {
        int n3;
        kN[] kNArray;
        int n4 = --n2;
        kN[][] kNArray2 = new qd_0[n2][n4];
        for (int i2 = 1; i2 <= kNArray2.length; ++i2) {
            kNArray = kNArray2[i2 - 1];
            int n5 = n3 = -i2;
            for (int i3 = 1; i3 <= kNArray.length; ++i3) {
                kNArray[i3 - 1] = new qd_0(n5 * (i3 + 1));
                n5 *= n3;
            }
        }
        kNArray2 = new sx_0(kNArray2, false);
        sP.a a2 = new sP(kNArray2).a();
        kNArray = new qd_0[n2];
        Arrays.fill(kNArray, qd_0.b);
        kNArray = (qd_0[])a2.a(new sz_0(kNArray, false)).h();
        kNArray2 = (qd_0[][])kNArray2.c();
        for (n3 = kNArray2.length - 1; n3 > 0; --n3) {
            kNArray2[n3] = kNArray2[n3 - 1];
        }
        kNArray2[0] = new qd_0[n2];
        Arrays.fill(kNArray2[0], qd_0.c);
        sx_0 sx_02 = a2.a(new sx_0(kNArray2, false));
        this.a = td_0.a(sx_02);
        this.b = new double[n2];
        for (int i4 = 0; i4 < n2; ++i4) {
            this.b[i4] = ((qd_0)kNArray[i4]).doubleValue();
        }
    }

    public static vv_0 a(int n2) {
        Map<Integer, vv_0> map2 = c;
        synchronized (map2) {
            vv_0 vv_02 = c.get(n2);
            if (vv_02 == null) {
                vv_02 = new vv_0(n2);
                c.put(n2, vv_02);
            }
            return vv_02;
        }
    }

    @Deprecated
    private int a() {
        return this.b.length;
    }

    private static sQ<qd_0> b(int n2) {
        int n3 = n2;
        kN[][] kNArray = new qd_0[n3][n3];
        for (int i2 = 1; i2 <= kNArray.length; ++i2) {
            int n4;
            qd_0[] qd_0Array = kNArray[i2 - 1];
            int n5 = n4 = -i2;
            for (int i3 = 1; i3 <= qd_0Array.length; ++i3) {
                qd_0Array[i3 - 1] = new qd_0(n5 * (i3 + 1));
                n5 *= n4;
            }
        }
        return new sx_0(kNArray, false);
    }

    public final sy_0 a(double d2, double[] dArray, double[][] dArray2, double[][] dArray3) {
        double[][] dArray4 = new double[this.b.length + 1][this.b.length + 1];
        double[][] dArray5 = new double[this.b.length + 1][dArray2[0].length];
        double[] dArray6 = dArray2[0];
        double[] dArray7 = dArray3[0];
        for (int i2 = 1; i2 < dArray2.length; ++i2) {
            double d3 = dArray[i2] - dArray[0];
            double d4 = d3 / d2;
            double d5 = 1.0 / d2;
            double[] dArray8 = dArray4[2 * i2 - 2];
            double[] dArray9 = 2 * i2 - 1 < dArray4.length ? dArray4[2 * i2 - 1] : null;
            for (int i3 = 0; i3 < dArray8.length; ++i3) {
                dArray8[i3] = d3 * (d5 *= d4);
                if (dArray9 == null) continue;
                int n2 = i3;
                dArray9[n2] = (double)(n2 + 2) * d5;
            }
            double[] dArray10 = dArray2[i2];
            double[] dArray11 = dArray3[i2];
            double[] dArray12 = dArray5[2 * i2 - 2];
            double[] dArray13 = 2 * i2 - 1 < dArray5.length ? dArray5[2 * i2 - 1] : null;
            for (int i4 = 0; i4 < dArray10.length; ++i4) {
                dArray12[i4] = dArray10[i4] - dArray6[i4] - d3 * dArray7[i4];
                if (dArray13 == null) continue;
                dArray13[i4] = dArray11[i4] - dArray7[i4];
            }
        }
        tn_0 tn_02 = new tn_0(new sy_0(dArray4, false));
        tq_0 tq_02 = tn_02.c().a(new sy_0(dArray5, false));
        sy_0 sy_02 = new sy_0(tq_02.f() - 1, tq_02.g());
        for (int i5 = 0; i5 < ((tp_0)sy_02).f(); ++i5) {
            for (int i6 = 0; i6 < ((tp_0)sy_02).g(); ++i6) {
                ((sv_0)sy_02).c(i5, i6, tq_02.b(i5, i6));
            }
        }
        return sy_02;
    }

    public final sy_0 a(sy_0 sy_02) {
        return this.a.a(sy_02);
    }

    public final void a(double[] dArray, double[] dArray2, sy_0 object) {
        object = ((sy_0)object).a;
        for (int i2 = 0; i2 < ((Object)object).length; ++i2) {
            Object object2 = object[i2];
            double d2 = this.b[i2];
            for (int i3 = 0; i3 < ((Object)object2).length; ++i3) {
                Object object3 = object2;
                int n2 = i3;
                object3[n2] = object3[n2] + d2 * (dArray[i3] - dArray2[i3]);
            }
        }
    }
}

