/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.AM;
import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.ao_0;
import org.valkyrienskies.core.impl.shadow.bx_0;
import org.valkyrienskies.core.impl.shadow.oS;
import org.valkyrienskies.core.impl.shadow.oT;
import org.valkyrienskies.core.impl.shadow.oV;
import org.valkyrienskies.core.impl.shadow.pf_0;
import org.valkyrienskies.core.impl.shadow.pl_0;
import org.valkyrienskies.core.impl.shadow.px_0;
import org.valkyrienskies.core.impl.shadow.sA;
import org.valkyrienskies.core.impl.shadow.sy_0;
import org.valkyrienskies.core.impl.shadow.th_0;
import org.valkyrienskies.core.impl.shadow.tq_0;
import org.valkyrienskies.core.impl.shadow.tu_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Bt
 */
public abstract class bt_0
implements bx_0 {
    private sy_0 a;
    private sA b;
    private boolean c = false;

    protected final tq_0 a() {
        return this.a;
    }

    protected final tu_0 b() {
        return this.b;
    }

    public final boolean c() {
        return this.c;
    }

    private void a(boolean bl) {
        this.c = bl;
    }

    public void a(double[] dArray, int n2, int n3) {
        if (dArray == null) {
            throw new pl_0();
        }
        if (dArray.length != n2 * (n3 + 1)) {
            throw new oS(dArray.length, n2 * (n3 + 1));
        }
        if (n2 <= n3) {
            throw new oT(px_0.INSUFFICIENT_OBSERVED_POINTS_IN_SAMPLE, n2, n3 + 1);
        }
        double[] dArray2 = new double[n2];
        n3 = this.c ? n3 : n3 + 1;
        double[][] dArray3 = new double[n2][n3];
        int n4 = 0;
        for (int i2 = 0; i2 < n2; ++i2) {
            int n5;
            dArray2[i2] = dArray[n4++];
            if (!this.c) {
                dArray3[i2][0] = 1.0;
            }
            int n6 = n5 = this.c ? 0 : 1;
            while (n5 < n3) {
                dArray3[i2][n5] = dArray[n4++];
                ++n5;
            }
        }
        this.a = new sy_0(dArray3);
        this.b = new sA(dArray2);
    }

    protected final void a(double[] dArray) {
        if (dArray == null) {
            throw new pl_0();
        }
        if (dArray.length == 0) {
            throw new pf_0();
        }
        this.b = new sA(dArray);
    }

    protected void a(double[][] dArray) {
        if (dArray == null) {
            throw new pl_0();
        }
        if (dArray.length == 0) {
            throw new pf_0();
        }
        if (this.c) {
            this.a = new sy_0(dArray, true);
            return;
        }
        int n2 = dArray[0].length;
        double[][] dArray2 = new double[dArray.length][n2 + 1];
        for (int i2 = 0; i2 < dArray.length; ++i2) {
            if (dArray[i2].length != n2) {
                throw new oS(dArray[i2].length, n2);
            }
            dArray2[i2][0] = 1.0;
            System.arraycopy(dArray[i2], 0, dArray2[i2], 1, n2);
        }
        this.a = new sy_0(dArray2, false);
    }

    protected static void a(double[][] dArray, double[] dArray2) {
        if (dArray == null || dArray2 == null) {
            throw new pl_0();
        }
        if (dArray.length != dArray2.length) {
            throw new oS(dArray2.length, dArray.length);
        }
        if (dArray.length == 0) {
            throw new pf_0();
        }
        if (dArray[0].length + 1 > dArray.length) {
            throw new oV(px_0.NOT_ENOUGH_DATA_FOR_NUMBER_OF_PREDICTORS, dArray.length, dArray[0].length);
        }
    }

    protected static void a(double[][] dArray, double[][] dArray2) {
        if (dArray.length != dArray2.length) {
            throw new oS(dArray.length, dArray2.length);
        }
        if (dArray2.length > 0 && dArray2.length != dArray2[0].length) {
            throw new th_0(dArray2.length, dArray2[0].length);
        }
    }

    public final double[] d() {
        tu_0 tu_02 = this.i();
        return tu_02.g();
    }

    public final double[] e() {
        tu_0 tu_02 = this.i();
        tu_02 = ((tu_0)((Object)this.b)).k((tu_0)((Object)this.a.a(tu_02)));
        return tu_02.g();
    }

    public final double[][] f() {
        return this.j().a();
    }

    public final double[] g() {
        Object object = this;
        object = ((bt_0)object).j().a();
        double d2 = this.k();
        int n2 = ((Object)object[0]).length;
        double[] dArray = new double[n2];
        for (int i2 = 0; i2 < n2; ++i2) {
            dArray[i2] = BY.a(d2 * object[i2][i2]);
        }
        return dArray;
    }

    public final double h() {
        bt_0 bt_02 = this;
        return ((ao_0)new AM()).a(((tu_0)((Object)bt_02.b)).g());
    }

    private double m() {
        return this.k();
    }

    private double n() {
        bt_0 bt_02 = this;
        return BY.a(bt_02.k());
    }

    protected abstract tu_0 i();

    protected abstract tq_0 j();

    private double o() {
        return ((ao_0)new AM()).a(((tu_0)((Object)this.b)).g());
    }

    protected double k() {
        tu_0 tu_02 = this.l();
        return tu_02.b(tu_02) / (double)(this.a.f() - this.a.g());
    }

    protected final tu_0 l() {
        tu_0 tu_02 = this.i();
        return ((tu_0)((Object)this.b)).k((tu_0)((Object)this.a.a(tu_02)));
    }
}

