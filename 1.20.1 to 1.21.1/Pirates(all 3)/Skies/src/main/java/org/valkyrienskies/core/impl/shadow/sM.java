/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.ci_0;
import org.valkyrienskies.core.impl.shadow.cq_0;
import org.valkyrienskies.core.impl.shadow.oS;
import org.valkyrienskies.core.impl.shadow.pm_0;
import org.valkyrienskies.core.impl.shadow.sA;
import org.valkyrienskies.core.impl.shadow.sv_0;
import org.valkyrienskies.core.impl.shadow.sw_0;
import org.valkyrienskies.core.impl.shadow.sy_0;
import org.valkyrienskies.core.impl.shadow.tA;
import org.valkyrienskies.core.impl.shadow.td_0;
import org.valkyrienskies.core.impl.shadow.tq_0;
import org.valkyrienskies.core.impl.shadow.tu_0;

public final class sM
extends sv_0
implements Serializable {
    private static final long a = 20121229L;
    private final double[] b;

    public sM(int n2) {
        int n3 = n2;
        super(n3, n3);
        this.b = new double[n2];
    }

    public sM(double[] dArray) {
        this(dArray, true);
    }

    private sM(double[] dArray, boolean bl) {
        ci_0.a((Object)dArray);
        this.b = bl ? (double[])dArray.clone() : dArray;
    }

    public final sv_0 a(int n2, int n3) {
        if (n2 != n3) {
            throw new oS(n2, n3);
        }
        return new sM(n2);
    }

    public final sv_0 i() {
        return new sM(this.b);
    }

    private sM a(sM sM2) {
        td_0.a((tq_0)this, (tq_0)sM2);
        sM sM3 = this;
        int n2 = sM3.b.length;
        double[] dArray = new double[n2];
        for (int i2 = 0; i2 < n2; ++i2) {
            dArray[i2] = this.b[i2] + sM2.b[i2];
        }
        return new sM(dArray, false);
    }

    private sM b(sM sM2) {
        td_0.a(this, (tq_0)sM2);
        sM sM3 = this;
        int n2 = sM3.b.length;
        double[] dArray = new double[n2];
        for (int i2 = 0; i2 < n2; ++i2) {
            dArray[i2] = this.b[i2] - sM2.b[i2];
        }
        return new sM(dArray, false);
    }

    private sM c(sM sM2) {
        td_0.b(this, sM2);
        sM sM3 = this;
        int n2 = sM3.b.length;
        double[] dArray = new double[n2];
        for (int i2 = 0; i2 < n2; ++i2) {
            dArray[i2] = this.b[i2] * sM2.b[i2];
        }
        return new sM(dArray, false);
    }

    public final tq_0 c(tq_0 tq_02) {
        if (tq_02 instanceof sM) {
            return this.c((sM)tq_02);
        }
        td_0.b(this, tq_02);
        int n2 = tq_02.f();
        int n3 = tq_02.g();
        double[][] dArray = new double[n2][n3];
        for (int i2 = 0; i2 < n2; ++i2) {
            for (int i3 = 0; i3 < n3; ++i3) {
                dArray[i2][i3] = this.b[i2] * tq_02.b(i2, i3);
            }
        }
        return new sy_0(dArray, false);
    }

    public final double[][] a() {
        sM sM2 = this;
        int n2 = sM2.b.length;
        double[][] dArray = new double[n2][n2];
        for (int i2 = 0; i2 < n2; ++i2) {
            dArray[i2][i2] = this.b[i2];
        }
        return dArray;
    }

    private double[] j() {
        return this.b;
    }

    public final double b(int n2, int n3) {
        td_0.a((sv_0)this, n2, n3);
        if (n2 == n3) {
            return this.b[n2];
        }
        return 0.0;
    }

    public final void c(int n2, int n3, double d2) {
        if (n2 == n3) {
            td_0.a((sw_0)this, n2);
            this.b[n2] = d2;
            return;
        }
        sM.d(d2);
    }

    public final void a(int n2, int n3, double d2) {
        if (n2 == n3) {
            td_0.a((sw_0)this, n2);
            int n4 = n2;
            this.b[n4] = this.b[n4] + d2;
            return;
        }
        sM.d(d2);
    }

    public final void b(int n2, int n3, double d2) {
        if (n2 == n3) {
            td_0.a((sw_0)this, n2);
            int n4 = n2;
            this.b[n4] = this.b[n4] * d2;
        }
    }

    public final int f() {
        return this.b.length;
    }

    public final int g() {
        return this.b.length;
    }

    public final double[] a(double[] object) {
        sM sM2 = this.c(new sM((double[])object, false));
        object = sM2;
        return sM2.b;
    }

    public final double[] b(double[] dArray) {
        return ((sv_0)this).a(dArray);
    }

    public final tu_0 b(tu_0 object) {
        if (object instanceof sA) {
            object = (sA)object;
            object = ((sA)object).a;
        } else {
            object = ((tu_0)object).g();
        }
        Object object2 = object;
        object = this;
        return td_0.b(((sv_0)object).a((double[])object2));
    }

    private static void d(double d2) {
        if (!cq_0.b(0.0, d2, 1)) {
            throw new pm_0(BY.w(d2), (Number)0, true);
        }
    }

    private sM k() {
        return this.c(0.0);
    }

    public final sM c(double d2) {
        if (this.e(d2)) {
            throw new tA();
        }
        double[] dArray = new double[this.b.length];
        for (int i2 = 0; i2 < this.b.length; ++i2) {
            dArray[i2] = 1.0 / this.b[i2];
        }
        return new sM(dArray, false);
    }

    private boolean e(double d2) {
        for (int i2 = 0; i2 < this.b.length; ++i2) {
            if (!cq_0.b(this.b[i2], 0.0, d2)) continue;
            return true;
        }
        return false;
    }
}

