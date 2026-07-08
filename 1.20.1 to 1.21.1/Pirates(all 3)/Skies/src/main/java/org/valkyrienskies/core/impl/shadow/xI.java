/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.oS;
import org.valkyrienskies.core.impl.shadow.sA;
import org.valkyrienskies.core.impl.shadow.sG;
import org.valkyrienskies.core.impl.shadow.sM;
import org.valkyrienskies.core.impl.shadow.sN;
import org.valkyrienskies.core.impl.shadow.td_0;
import org.valkyrienskies.core.impl.shadow.tn_0;
import org.valkyrienskies.core.impl.shadow.tq_0;
import org.valkyrienskies.core.impl.shadow.tu_0;
import org.valkyrienskies.core.impl.shadow.wK;
import org.valkyrienskies.core.impl.shadow.wO;
import org.valkyrienskies.core.impl.shadow.wR;
import org.valkyrienskies.core.impl.shadow.xB;
import org.valkyrienskies.core.impl.shadow.xH;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
@Deprecated
public abstract class xI
extends xB {
    private tq_0 a;
    private double b;

    protected xI(wK<wR> wK2) {
        super(wK2);
    }

    protected final tq_0 c(double[] dArray) {
        return this.a.c(td_0.a(this.a(dArray)));
    }

    protected final double d(double[] object) {
        sA sA2 = new sA((double[])object);
        object = sA2;
        return BY.a(((tu_0)((Object)sA2)).b((tu_0)((Object)this.b().a((tu_0)object))));
    }

    private double o() {
        xI xI2 = this;
        return BY.a(xI2.b * xI2.b / (double)this.m());
    }

    private double p() {
        return this.b * this.b;
    }

    public final tq_0 n() {
        return this.a.i();
    }

    protected final void a(double d2) {
        this.b = d2;
    }

    private double[][] a(double[] object, double d2) {
        tq_0 tq_02 = this.c((double[])object);
        object = tq_02;
        object = tq_02.d().c((tq_0)object);
        sG sG2 = new tn_0((tq_0)object, d2).c();
        object = sG2;
        return sG2.b().a();
    }

    private double[] b(double[] object, double d2) {
        int n2 = ((double[])object).length;
        double[] dArray = new double[n2];
        xI xI2 = this;
        double d3 = d2;
        double[] dArray2 = object;
        object = xI2;
        tq_0 tq_02 = xI2.c(dArray2);
        object = tq_02;
        object = tq_02.d().c((tq_0)object);
        sG sG2 = new tn_0((tq_0)object, d3).c();
        object = sG2;
        object = sG2.b().a();
        for (int i2 = 0; i2 < n2; ++i2) {
            dArray[i2] = BY.a((double)object[i2][i2]);
        }
        return dArray;
    }

    @Override
    public final wR c(wO ... wOArray) {
        return super.c(wOArray);
    }

    protected final double[] e(double[] dArray) {
        double[] dArray2 = this.d();
        if (dArray.length != dArray2.length) {
            throw new oS(dArray2.length, dArray.length);
        }
        double[] dArray3 = new double[dArray2.length];
        for (int i2 = 0; i2 < dArray2.length; ++i2) {
            dArray3[i2] = dArray2[i2] - dArray[i2];
        }
        return dArray3;
    }

    @Override
    public final void b(wO ... object) {
        super.b((wO[])object);
        int n2 = ((wO[])object).length;
        for (int i2 = 0; i2 < n2; ++i2) {
            tq_0 tq_02;
            wO wO2 = object[i2];
            if (!(wO2 instanceof xH)) continue;
            object = ((xH)wO2).a();
            if (object instanceof sM) {
                n2 = object.f();
                sM sM2 = new sM(n2);
                int n3 = 0;
                while (n3 < n2) {
                    int n4 = n3;
                    int n5 = n3++;
                    sM2.c(n4, n4, BY.a(object.b(n5, n5)));
                }
                tq_02 = sM2;
            } else {
                sN sN2 = new sN((tq_0)object);
                tq_02 = sN2.e();
            }
            this.a = tq_02;
            return;
        }
    }

    private static tq_0 a(tq_0 tq_02) {
        if (tq_02 instanceof sM) {
            int n2 = tq_02.f();
            sM sM2 = new sM(n2);
            int n3 = 0;
            while (n3 < n2) {
                int n4 = n3;
                int n5 = n3++;
                sM2.c(n4, n4, BY.a(tq_02.b(n5, n5)));
            }
            return sM2;
        }
        sN sN2 = new sN(tq_02);
        return sN2.e();
    }

    @Override
    public final /* synthetic */ Object a(wO[] object) {
        wO[] wOArray = object;
        object = this;
        return super.c(wOArray);
    }
}

