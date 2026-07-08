/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.ch_0;
import org.valkyrienskies.core.impl.shadow.cq_0;
import org.valkyrienskies.core.impl.shadow.oS;
import org.valkyrienskies.core.impl.shadow.od_0;
import org.valkyrienskies.core.impl.shadow.pb_0;
import org.valkyrienskies.core.impl.shadow.sN;
import org.valkyrienskies.core.impl.shadow.sy_0;
import org.valkyrienskies.core.impl.shadow.te_0;
import org.valkyrienskies.core.impl.shadow.tq_0;
import org.valkyrienskies.core.impl.shadow.tu_0;
import org.valkyrienskies.core.impl.shadow.zR;

public final class oB
extends od_0 {
    private final double[] b;
    private final sy_0 c;
    private final tq_0 d;
    private final double e;
    private final tq_0 f;

    public oB(double[] dArray, double[][] dArray2) {
        this(new zR(), dArray, dArray2);
    }

    private oB(zR zR2, double[] dArray, double[][] dArray2) {
        int n2;
        boolean bl;
        Object object;
        sN sN2;
        int n3;
        block9: {
            super(zR2, dArray.length);
            n3 = dArray.length;
            if (dArray2.length != n3) {
                throw new oS(dArray2.length, n3);
            }
            for (int i2 = 0; i2 < n3; ++i2) {
                if (n3 == dArray2[i2].length) continue;
                throw new oS(dArray2[i2].length, n3);
            }
            this.b = ch_0.a(dArray, dArray.length);
            this.c = new sy_0(dArray2);
            sN2 = new sN(this.c);
            object = sN2;
            sN sN3 = object;
            for (int i3 = 0; i3 < sN3.b.length; ++i3) {
                if (cq_0.b(sN3.b[i3], 0.0, 1.0E-12)) continue;
                bl = true;
                break block9;
            }
            bl = false;
        }
        if (bl) {
            throw new pb_0();
        }
        this.d = new sN.a(((sN)object).a, ((sN)object).b, ((sN)object).c, 0).b();
        object = sN2;
        double d2 = 1.0;
        dArray = ((sN)object).a;
        int n4 = ((sN)object).a.length;
        for (n2 = 0; n2 < n4; ++n2) {
            double d3 = dArray[n2];
            d2 *= d3;
        }
        this.e = d2;
        dArray = sN2.c();
        for (n4 = 0; n4 < dArray.length; ++n4) {
            if (!(dArray[n4] < 0.0)) continue;
            throw new te_0(dArray[n4], n4, 0.0);
        }
        int n5 = n3;
        sy_0 sy_02 = new sy_0(n5, n5);
        for (n2 = 0; n2 < n3; ++n2) {
            int n6 = n2;
            object = sN2;
            object = ((tu_0)((Object)((sN)object).c[n6].a())).g();
            sy_02.b(n2, (double[])object);
        }
        tq_0 tq_02 = sy_02.d();
        for (int i4 = 0; i4 < n3; ++i4) {
            double d4 = BY.a(dArray[i4]);
            for (int i5 = 0; i5 < n3; ++i5) {
                tq_02.b(i4, i5, d4);
            }
        }
        this.f = sy_02.c(tq_02);
    }

    public final double[] c() {
        double[] dArray = this.b;
        return ch_0.a(this.b, dArray.length);
    }

    private tq_0 d() {
        return this.c.i();
    }

    public final double a(double[] object) {
        int n2 = this.a();
        if (((double[])object).length != n2) {
            throw new oS(((double[])object).length, n2);
        }
        double d2 = BY.a(Math.PI * 2, -0.5 * (double)n2) * BY.a(this.e, -0.5);
        double[] dArray = object;
        object = this;
        double[] dArray2 = new double[dArray.length];
        for (int i2 = 0; i2 < dArray2.length; ++i2) {
            dArray2[i2] = dArray[i2] - ((oB)object).c()[i2];
        }
        double[] dArray3 = ((oB)object).d.b(dArray2);
        double d3 = 0.0;
        for (int i3 = 0; i3 < dArray3.length; ++i3) {
            d3 += dArray3[i3] * dArray2[i3];
        }
        return d2 * BY.i(d3 * -0.5);
    }

    private double[] e() {
        int n2 = this.a();
        double[] dArray = new double[n2];
        double[][] dArray2 = this.c.a();
        for (int i2 = 0; i2 < n2; ++i2) {
            dArray[i2] = BY.a(dArray2[i2][i2]);
        }
        return dArray;
    }

    public final double[] b() {
        int n2 = this.a();
        double[] dArray = new double[n2];
        for (int i2 = 0; i2 < n2; ++i2) {
            dArray[i2] = this.a.nextGaussian();
        }
        double[] dArray2 = this.f.a(dArray);
        for (int i3 = 0; i3 < n2; ++i3) {
            int n3 = i3;
            dArray2[n3] = dArray2[n3] + this.b[i3];
        }
        return dArray2;
    }

    private double b(double[] dArray) {
        double[] dArray2 = new double[dArray.length];
        for (int i2 = 0; i2 < dArray2.length; ++i2) {
            dArray2[i2] = dArray[i2] - this.c()[i2];
        }
        double[] dArray3 = this.d.b(dArray2);
        double d2 = 0.0;
        for (int i3 = 0; i3 < dArray3.length; ++i3) {
            d2 += dArray3[i3] * dArray2[i3];
        }
        return BY.i(d2 * -0.5);
    }
}

