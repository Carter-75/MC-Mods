/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.valkyrienskies.core.impl.shadow.uq
 *  org.valkyrienskies.core.impl.shadow.uq$a
 *  org.valkyrienskies.core.impl.shadow.uq$c
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.tW;
import org.valkyrienskies.core.impl.shadow.ud_0;
import org.valkyrienskies.core.impl.shadow.ue_0;
import org.valkyrienskies.core.impl.shadow.uq;
import org.valkyrienskies.core.impl.shadow.uq_0;
import org.valkyrienskies.core.impl.shadow.uu_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.uy
 */
public final class uy_0
implements uu_0 {
    private final boolean a;
    private final tW b;

    private uy_0(boolean bl, tW tW2) {
        this.a = bl;
        this.b = tW2;
    }

    public final double[][] a(uq_0 object) {
        if (this.a) {
            ue_0 ue_02;
            int n2;
            int n3;
            int n4;
            int n5;
            uq_0 uq_02 = object;
            object = this;
            Object object2 = uq_02;
            int n6 = ((uq)object2).b;
            object2 = uq_02;
            int n7 = ((uq)object2).c;
            double[][] dArray = new double[(n6 << 1) + 1][(n7 << 1) + 1];
            for (n5 = 0; n5 < n6; ++n5) {
                n4 = 2 * n5 + 1;
                for (n3 = 0; n3 < n7; ++n3) {
                    n2 = 2 * n3 + 1;
                    object2 = uq_02.a(n5, n3).c();
                    ue_02 = uq_02.a(n5, n3, uq.a.RIGHT$75c8caca, uq.c.CENTER$1c17da1c);
                    if (ue_02 != null) {
                        dArray[n4][n2 + 1] = ((uy_0)object).b.a((double[])object2, ue_02.c());
                    }
                    if ((ue_02 = uq_02.a(n5, n3, uq.a.CENTER$75c8caca, uq.c.DOWN$1c17da1c)) == null) continue;
                    dArray[n4 + 1][n2] = ((uy_0)object).b.a((double[])object2, ue_02.c());
                }
            }
            for (n5 = 0; n5 < n6; ++n5) {
                n4 = 2 * n5 + 1;
                for (n3 = 0; n3 < n7; ++n3) {
                    n2 = 2 * n3 + 1;
                    object2 = uq_02.a(n5, n3);
                    ue_02 = uq_02.a(n5, n3, uq.a.RIGHT$75c8caca, uq.c.CENTER$1c17da1c);
                    ue_0 ue_03 = uq_02.a(n5, n3, uq.a.CENTER$75c8caca, uq.c.DOWN$1c17da1c);
                    ue_0 ue_04 = uq_02.a(n5, n3, uq.a.RIGHT$75c8caca, uq.c.DOWN$1c17da1c);
                    double d2 = ue_04 == null ? 0.0 : ((uy_0)object).b.a(((ue_0)object2).c(), ue_04.c());
                    double d3 = ue_02 == null || ue_03 == null ? 0.0 : ((uy_0)object).b.a(ue_02.c(), ue_03.c());
                    dArray[n4 + 1][n2 + 1] = 0.5 * (d2 + d3);
                }
            }
            n5 = dArray.length - 1;
            dArray[0] = dArray[n5];
            n4 = dArray[0].length - 1;
            for (n3 = 0; n3 < n5; ++n3) {
                dArray[n3][0] = dArray[n3][n4];
            }
            return dArray;
        }
        uq_0 uq_03 = object;
        object = this;
        Iterable<ue_0> iterable = uq_03;
        int n8 = ((uq)iterable).b;
        iterable = uq_03;
        int n9 = ((uq)iterable).c;
        double[][] dArray = new double[n8][n9];
        iterable = uq_03;
        ud_0 ud_02 = ((uq)iterable).a;
        for (int i2 = 0; i2 < n8; ++i2) {
            for (int i3 = 0; i3 < n9; ++i3) {
                ue_0 ue_05 = uq_03.a(i2, i3);
                Object object3 = ue_05;
                iterable = ud_02;
                iterable = ((ud_0)iterable).a((ue_0)object3, (Iterable<ue_0>)null);
                object3 = ue_05.c();
                double d4 = 0.0;
                int n10 = 0;
                for (ue_0 ue_06 : iterable) {
                    ++n10;
                    d4 += ((uy_0)object).b.a((double[])object3, ue_06.c());
                }
                dArray[i2][i3] = d4 / (double)n10;
            }
        }
        return dArray;
    }

    private double[][] b(uq_0 uq_02) {
        ue_0 ue_02;
        Object object;
        int n2;
        int n3;
        int n4;
        int n5;
        uq_0 uq_03 = uq_02;
        int n6 = ((uq)uq_03).b;
        uq_03 = uq_02;
        int n7 = ((uq)uq_03).c;
        double[][] dArray = new double[(n6 << 1) + 1][(n7 << 1) + 1];
        for (n5 = 0; n5 < n6; ++n5) {
            n4 = 2 * n5 + 1;
            for (n3 = 0; n3 < n7; ++n3) {
                n2 = 2 * n3 + 1;
                object = uq_02.a(n5, n3).c();
                ue_02 = uq_02.a(n5, n3, uq.a.RIGHT$75c8caca, uq.c.CENTER$1c17da1c);
                if (ue_02 != null) {
                    dArray[n4][n2 + 1] = this.b.a((double[])object, ue_02.c());
                }
                if ((ue_02 = uq_02.a(n5, n3, uq.a.CENTER$75c8caca, uq.c.DOWN$1c17da1c)) == null) continue;
                dArray[n4 + 1][n2] = this.b.a((double[])object, ue_02.c());
            }
        }
        for (n5 = 0; n5 < n6; ++n5) {
            n4 = 2 * n5 + 1;
            for (n3 = 0; n3 < n7; ++n3) {
                n2 = 2 * n3 + 1;
                object = uq_02.a(n5, n3);
                ue_02 = uq_02.a(n5, n3, uq.a.RIGHT$75c8caca, uq.c.CENTER$1c17da1c);
                ue_0 ue_03 = uq_02.a(n5, n3, uq.a.CENTER$75c8caca, uq.c.DOWN$1c17da1c);
                ue_0 ue_04 = uq_02.a(n5, n3, uq.a.RIGHT$75c8caca, uq.c.DOWN$1c17da1c);
                double d2 = ue_04 == null ? 0.0 : this.b.a(((ue_0)object).c(), ue_04.c());
                double d3 = ue_02 == null || ue_03 == null ? 0.0 : this.b.a(ue_02.c(), ue_03.c());
                dArray[n4 + 1][n2 + 1] = 0.5 * (d2 + d3);
            }
        }
        n5 = dArray.length - 1;
        dArray[0] = dArray[n5];
        n4 = dArray[0].length - 1;
        for (n3 = 0; n3 < n5; ++n3) {
            dArray[n3][0] = dArray[n3][n4];
        }
        return dArray;
    }

    private double[][] c(uq_0 uq_02) {
        Object object = uq_02;
        int n2 = ((uq)object).b;
        object = uq_02;
        int n3 = ((uq)object).c;
        double[][] dArray = new double[n2][n3];
        object = uq_02;
        ud_0 ud_02 = ((uq)object).a;
        for (int i2 = 0; i2 < n2; ++i2) {
            for (int i3 = 0; i3 < n3; ++i3) {
                Object object2 = uq_02.a(i2, i3);
                ue_0 ue_02 = object2;
                object = ud_02;
                object = ((ud_0)object).a(ue_02, (Iterable<ue_0>)null);
                object2 = ((ue_0)object2).c();
                double d2 = 0.0;
                int n4 = 0;
                object = object.iterator();
                while (object.hasNext()) {
                    ue_0 ue_03 = (ue_0)object.next();
                    ++n4;
                    d2 += this.b.a((double[])object2, ue_03.c());
                }
                dArray[i2][i3] = d2 / (double)n4;
            }
        }
        return dArray;
    }
}

