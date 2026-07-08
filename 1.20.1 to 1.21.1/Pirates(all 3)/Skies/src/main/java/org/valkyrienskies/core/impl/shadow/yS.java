/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.oR;
import org.valkyrienskies.core.impl.shadow.oY;
import org.valkyrienskies.core.impl.shadow.pl_0;
import org.valkyrienskies.core.impl.shadow.px_0;
import org.valkyrienskies.core.impl.shadow.sA;
import org.valkyrienskies.core.impl.shadow.sD;
import org.valkyrienskies.core.impl.shadow.sG;
import org.valkyrienskies.core.impl.shadow.tA;
import org.valkyrienskies.core.impl.shadow.tb_0;
import org.valkyrienskies.core.impl.shadow.tn_0;
import org.valkyrienskies.core.impl.shadow.tq_0;
import org.valkyrienskies.core.impl.shadow.tu_0;
import org.valkyrienskies.core.impl.shadow.yP;
import org.valkyrienskies.core.impl.shadow.ya_0;
import org.valkyrienskies.core.impl.shadow.yq_0;
import org.valkyrienskies.core.impl.shadow.yu_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
@Deprecated
public final class yS
extends yP {
    private final boolean c;

    @Deprecated
    public yS() {
        this(true);
    }

    private yS(ya_0<yq_0> ya_02) {
        this(true, ya_02);
    }

    @Deprecated
    private yS(boolean bl) {
        this(true, new yu_0());
    }

    private yS(boolean bl, ya_0<yq_0> ya_02) {
        super(ya_02);
        this.c = bl;
    }

    @Override
    public final yq_0 h() {
        ya_0<yq_0> ya_02 = this.c();
        if (ya_02 == null) {
            throw new pl_0();
        }
        double[] dArray = this.f();
        int n2 = dArray.length;
        tq_0 tq_02 = this.e();
        double[] dArray2 = new double[n2];
        for (int i2 = 0; i2 < n2; ++i2) {
            int n3 = i2;
            dArray2[i2] = tq_02.b(n3, n3);
        }
        double[] dArray3 = this.d();
        int n4 = dArray3.length;
        Object object = null;
        int n5 = 0;
        boolean bl = false;
        while (!bl) {
            Object object2;
            ++n5;
            double[] dArray4 = object;
            object = this.a(dArray3);
            double[] dArray5 = this.d((double[])object);
            tq_0 tq_03 = this.b(dArray3);
            object = new yq_0(dArray3, (double[])object);
            double[] dArray6 = new double[n4];
            int n6 = n4;
            double[][] dArray7 = new double[n6][n6];
            for (int i3 = 0; i3 < n2; ++i3) {
                int n7;
                object2 = tq_03.f(i3);
                double d2 = dArray2[i3];
                double d3 = dArray5[i3];
                double d4 = d2 * d3;
                for (n7 = 0; n7 < n4; ++n7) {
                    int n8 = n7;
                    dArray6[n8] = dArray6[n8] + d4 * object2[n7];
                }
                for (n7 = 0; n7 < n4; ++n7) {
                    double[] dArray8 = dArray7[n7];
                    double d5 = d2 * object2[n7];
                    for (int i4 = 0; i4 < n4; ++i4) {
                        int n9 = i4;
                        dArray8[n9] = dArray8[n9] + d5 * object2[i4];
                    }
                }
            }
            try {
                sD sD2 = new sD(dArray7);
                sG sG2 = this.c ? new tb_0(sD2).a() : new tn_0(sD2).c();
                object2 = sG2;
                double[] dArray9 = sG2.a((tu_0)((Object)new sA(dArray6, false))).g();
                for (int i5 = 0; i5 < n4; ++i5) {
                    int n10 = i5;
                    dArray3[n10] = dArray3[n10] + dArray9[i5];
                }
            }
            catch (tA tA2) {
                throw new oR(px_0.UNABLE_TO_SOLVE_SINGULAR_PROBLEM, new Object[0]);
            }
            if (dArray4 == null || !(bl = ya_02.a(n5, (yq_0)dArray4, (yq_0)object))) continue;
            this.b = this.c(dArray5);
            this.a = ((yq_0)object).a();
            return object;
        }
        throw new oY();
    }
}

