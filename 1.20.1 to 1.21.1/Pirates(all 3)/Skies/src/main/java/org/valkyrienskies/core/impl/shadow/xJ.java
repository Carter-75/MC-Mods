/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.oR;
import org.valkyrienskies.core.impl.shadow.oY;
import org.valkyrienskies.core.impl.shadow.pb_0;
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
import org.valkyrienskies.core.impl.shadow.wI;
import org.valkyrienskies.core.impl.shadow.wK;
import org.valkyrienskies.core.impl.shadow.wR;
import org.valkyrienskies.core.impl.shadow.xI;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
@Deprecated
public final class xJ
extends xI {
    private final boolean a;

    private xJ(wK<wR> wK2) {
        this(true, wK2);
    }

    public xJ(boolean bl, wK<wR> wK2) {
        super(wK2);
        this.a = bl;
    }

    private wR o() {
        wK wK2 = this;
        if (((wI)((Object)wK2)).f() != null || ((wI)((Object)wK2)).g() != null) {
            throw new pb_0(px_0.CONSTRAINT, new Object[0]);
        }
        wK2 = this.j();
        if (wK2 == null) {
            throw new pl_0();
        }
        double[] dArray = this.d();
        int n2 = dArray.length;
        tq_0 tq_02 = this.b();
        double[] dArray2 = new double[n2];
        for (int i2 = 0; i2 < n2; ++i2) {
            int n3 = i2;
            dArray2[i2] = tq_02.b(n3, n3);
        }
        double[] dArray3 = this.e();
        int n4 = dArray3.length;
        Object object = null;
        boolean bl = false;
        while (!bl) {
            Object object2;
            this.l();
            double[] dArray4 = object;
            object = this.b(dArray3);
            double[] dArray5 = this.e((double[])object);
            tq_0 tq_03 = this.c(dArray3);
            object = new wR(dArray3, (double[])object);
            double[] dArray6 = new double[n4];
            int n5 = n4;
            double[][] dArray7 = new double[n5][n5];
            for (int i3 = 0; i3 < n2; ++i3) {
                int n6;
                object2 = tq_03.f(i3);
                double d2 = dArray2[i3];
                double d3 = dArray5[i3];
                double d4 = d2 * d3;
                for (n6 = 0; n6 < n4; ++n6) {
                    int n7 = n6;
                    dArray6[n7] = dArray6[n7] + d4 * object2[n6];
                }
                for (n6 = 0; n6 < n4; ++n6) {
                    double[] dArray8 = dArray7[n6];
                    double d5 = d2 * object2[n6];
                    for (int i4 = 0; i4 < n4; ++i4) {
                        int n8 = i4;
                        dArray8[n8] = dArray8[n8] + d5 * object2[i4];
                    }
                }
            }
            if (dArray4 != null && (bl = wK2.a(this.i(), dArray4, object))) {
                xJ xJ2 = this;
                xJ2.a(xJ2.d(dArray5));
                return object;
            }
            try {
                sD sD2 = new sD(dArray7);
                sG sG2 = this.a ? new tb_0(sD2).a() : new tn_0(sD2).c();
                object2 = sG2;
                double[] dArray9 = sG2.a((tu_0)((Object)new sA(dArray6, false))).g();
                for (int i5 = 0; i5 < n4; ++i5) {
                    int n9 = i5;
                    dArray3[n9] = dArray3[n9] + dArray9[i5];
                }
            }
            catch (tA tA2) {
                throw new oR(px_0.UNABLE_TO_SOLVE_SINGULAR_PROBLEM, new Object[0]);
            }
        }
        throw new oY();
    }

    private void p() {
        if (this.f() != null || this.g() != null) {
            throw new pb_0(px_0.CONSTRAINT, new Object[0]);
        }
    }

    @Override
    public final /* synthetic */ Object c() {
        return this.o();
    }
}

