/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import org.valkyrienskies.core.impl.shadow.ci_0;
import org.valkyrienskies.core.impl.shadow.oS;
import org.valkyrienskies.core.impl.shadow.oX;
import org.valkyrienskies.core.impl.shadow.pf_0;
import org.valkyrienskies.core.impl.shadow.pl_0;
import org.valkyrienskies.core.impl.shadow.px_0;
import org.valkyrienskies.core.impl.shadow.sv_0;
import org.valkyrienskies.core.impl.shadow.td_0;
import org.valkyrienskies.core.impl.shadow.tp_0;
import org.valkyrienskies.core.impl.shadow.tq_0;
import org.valkyrienskies.core.impl.shadow.tr_0;
import org.valkyrienskies.core.impl.shadow.tt_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.sy
 */
public class sy_0
extends sv_0
implements Serializable {
    private static final long b = -1067294169172445528L;
    public double[][] a;

    public sy_0() {
    }

    public sy_0(int n2, int n3) {
        super(n2, n3);
        this.a = new double[n2][n3];
    }

    public sy_0(double[][] object) {
        sy_0 sy_02 = this;
        double[][] dArray = object;
        object = sy_02;
        ((sv_0)sy_02).a(dArray, 0, 0);
    }

    public sy_0(double[][] object, boolean n2) {
        if (n2) {
            sy_0 sy_02 = this;
            double[][] dArray = object;
            object = sy_02;
            ((sv_0)sy_02).a(dArray, 0, 0);
            return;
        }
        if (object == null) {
            throw new pl_0();
        }
        n2 = ((double[][])object).length;
        if (!n2) {
            throw new pf_0(px_0.AT_LEAST_ONE_ROW);
        }
        int n3 = object[0].length;
        if (n3 == 0) {
            throw new pf_0(px_0.AT_LEAST_ONE_COLUMN);
        }
        for (int i2 = 1; i2 < n2; ++i2) {
            if (object[i2].length == n3) continue;
            throw new oS(object[i2].length, n3);
        }
        this.a = object;
    }

    public sy_0(double[] dArray) {
        int n2 = dArray.length;
        this.a = new double[n2][1];
        for (int i2 = 0; i2 < n2; ++i2) {
            this.a[i2][0] = dArray[i2];
        }
    }

    public final sv_0 a(int n2, int n3) {
        return new sy_0(n2, n3);
    }

    public final sv_0 i() {
        return new sy_0(this.k(), false);
    }

    private sy_0 b(sy_0 sy_02) {
        td_0.a((tq_0)this, (tq_0)sy_02);
        int n2 = ((tp_0)this).f();
        int n3 = ((tp_0)this).g();
        double[][] dArray = new double[n2][n3];
        for (int i2 = 0; i2 < n2; ++i2) {
            double[] dArray2 = this.a[i2];
            double[] dArray3 = sy_02.a[i2];
            double[] dArray4 = dArray[i2];
            for (int i3 = 0; i3 < n3; ++i3) {
                dArray4[i3] = dArray2[i3] + dArray3[i3];
            }
        }
        return new sy_0(dArray, false);
    }

    private sy_0 c(sy_0 sy_02) {
        td_0.a(this, (tq_0)sy_02);
        int n2 = ((tp_0)this).f();
        int n3 = ((tp_0)this).g();
        double[][] dArray = new double[n2][n3];
        for (int i2 = 0; i2 < n2; ++i2) {
            double[] dArray2 = this.a[i2];
            double[] dArray3 = sy_02.a[i2];
            double[] dArray4 = dArray[i2];
            for (int i3 = 0; i3 < n3; ++i3) {
                dArray4[i3] = dArray2[i3] - dArray3[i3];
            }
        }
        return new sy_0(dArray, false);
    }

    public final sy_0 a(sy_0 object) {
        td_0.b(this, (tq_0)object);
        int n2 = ((tp_0)this).f();
        int n3 = ((tp_0)object).g();
        int n4 = ((tp_0)this).g();
        double[][] dArray = new double[n2][n3];
        double[] dArray2 = new double[n4];
        object = ((sy_0)object).a;
        for (int i2 = 0; i2 < n3; ++i2) {
            int n5;
            for (n5 = 0; n5 < n4; ++n5) {
                dArray2[n5] = (double)object[n5][i2];
            }
            for (n5 = 0; n5 < n2; ++n5) {
                double[] dArray3 = this.a[n5];
                double d2 = 0.0;
                for (int i3 = 0; i3 < n4; ++i3) {
                    d2 += dArray3[i3] * dArray2[i3];
                }
                dArray[n5][i2] = d2;
            }
        }
        return new sy_0(dArray, false);
    }

    public final double[][] a() {
        return this.k();
    }

    public final double[][] j() {
        return this.a;
    }

    public final void a(double[][] dArray, int n2, int n3) {
        if (this.a == null) {
            if (n2 > 0) {
                throw new oX(px_0.FIRST_ROWS_NOT_INITIALIZED_YET, n2);
            }
            if (n3 > 0) {
                throw new oX(px_0.FIRST_COLUMNS_NOT_INITIALIZED_YET, n3);
            }
            ci_0.a(dArray);
            int n4 = dArray.length;
            if (n4 == 0) {
                throw new pf_0(px_0.AT_LEAST_ONE_ROW);
            }
            n4 = dArray[0].length;
            if (n4 == 0) {
                throw new pf_0(px_0.AT_LEAST_ONE_COLUMN);
            }
            this.a = new double[dArray.length][n4];
            for (int i2 = 0; i2 < this.a.length; ++i2) {
                if (dArray[i2].length != n4) {
                    throw new oS(dArray[i2].length, n4);
                }
                System.arraycopy(dArray[i2], 0, this.a[i2 + n2], n3, n4);
            }
            return;
        }
        super.a(dArray, n2, n3);
    }

    public final double b(int n2, int n3) {
        td_0.a((sv_0)this, n2, n3);
        return this.a[n2][n3];
    }

    public final void c(int n2, int n3, double d2) {
        td_0.a((sv_0)this, n2, n3);
        this.a[n2][n3] = d2;
    }

    public final void a(int n2, int n3, double d2) {
        td_0.a((sv_0)this, n2, n3);
        double[] dArray = this.a[n2];
        int n4 = n3;
        dArray[n4] = dArray[n4] + d2;
    }

    public final void b(int n2, int n3, double d2) {
        td_0.a((sv_0)this, n2, n3);
        double[] dArray = this.a[n2];
        int n4 = n3;
        dArray[n4] = dArray[n4] * d2;
    }

    public final int f() {
        if (this.a == null) {
            return 0;
        }
        return this.a.length;
    }

    public final int g() {
        if (this.a == null || this.a[0] == null) {
            return 0;
        }
        return this.a[0].length;
    }

    public final double[] a(double[] dArray) {
        int n2 = ((tp_0)this).f();
        int n3 = ((tp_0)this).g();
        if (dArray.length != n3) {
            throw new oS(dArray.length, n3);
        }
        double[] dArray2 = new double[n2];
        for (int i2 = 0; i2 < n2; ++i2) {
            double[] dArray3 = this.a[i2];
            double d2 = 0.0;
            for (int i3 = 0; i3 < n3; ++i3) {
                d2 += dArray3[i3] * dArray[i3];
            }
            dArray2[i2] = d2;
        }
        return dArray2;
    }

    public final double[] b(double[] dArray) {
        int n2 = ((tp_0)this).f();
        int n3 = ((tp_0)this).g();
        if (dArray.length != n2) {
            throw new oS(dArray.length, n2);
        }
        double[] dArray2 = new double[n3];
        for (int i2 = 0; i2 < n3; ++i2) {
            double d2 = 0.0;
            for (int i3 = 0; i3 < n2; ++i3) {
                d2 += this.a[i3][i2] * dArray[i3];
            }
            dArray2[i2] = d2;
        }
        return dArray2;
    }

    public final double a(tr_0 tr_02) {
        int n2 = ((tp_0)this).f();
        int n3 = ((tp_0)this).g();
        for (int i2 = 0; i2 < n2; ++i2) {
            double[] dArray = this.a[i2];
            for (int i3 = 0; i3 < n3; ++i3) {
                dArray[i3] = tr_02.a(i2, i3, dArray[i3]);
            }
        }
        return tr_02.b();
    }

    public final double a(tt_0 tt_02) {
        int n2 = ((tp_0)this).f();
        int n3 = ((tp_0)this).g();
        tt_02.a(0, n2 - 1, 0);
        for (int i2 = 0; i2 < n2; ++i2) {
            double[] dArray = this.a[i2];
            for (int i3 = 0; i3 < n3; ++i3) {
                tt_02.a(i2, i3, dArray[i3]);
            }
        }
        return tt_02.a();
    }

    public final double a(tr_0 tr_02, int n2, int n3, int n4, int n5) {
        td_0.a(this, n2, n3, n4, n5);
        ((tp_0)this).f();
        ((tp_0)this).g();
        while (n2 <= n3) {
            double[] dArray = this.a[n2];
            for (int i2 = n4; i2 <= n5; ++i2) {
                dArray[i2] = tr_02.a(n2, i2, dArray[i2]);
            }
            ++n2;
        }
        return tr_02.b();
    }

    public final double a(tt_0 tt_02, int n2, int n3, int n4, int n5) {
        td_0.a(this, n2, n3, n4, n5);
        ((tp_0)this).f();
        ((tp_0)this).g();
        tt_02.a(n2, n3, n4);
        while (n2 <= n3) {
            double[] dArray = this.a[n2];
            for (int i2 = n4; i2 <= n5; ++i2) {
                tt_02.a(n2, i2, dArray[i2]);
            }
            ++n2;
        }
        return tt_02.a();
    }

    public final double b(tr_0 tr_02) {
        int n2 = ((tp_0)this).f();
        int n3 = ((tp_0)this).g();
        for (int i2 = 0; i2 < n3; ++i2) {
            for (int i3 = 0; i3 < n2; ++i3) {
                double[] dArray = this.a[i3];
                double[] dArray2 = dArray;
                dArray[i2] = tr_02.a(i3, i2, dArray2[i2]);
            }
        }
        return tr_02.b();
    }

    public final double a(sv_0.1 var1_1) {
        int n2 = ((tp_0)this).f();
        int n3 = ((tp_0)this).g();
        var1_1.a(0, n2 - 1, 0);
        for (int i2 = 0; i2 < n3; ++i2) {
            for (int i3 = 0; i3 < n2; ++i3) {
                var1_1.a(i3, i2, this.a[i3][i2]);
            }
        }
        return var1_1.a();
    }

    public final double b(tr_0 tr_02, int n2, int n3, int n4, int n5) {
        td_0.a(this, n2, n3, n4, n5);
        ((tp_0)this).f();
        ((tp_0)this).g();
        while (n4 <= n5) {
            for (int i2 = n2; i2 <= n3; ++i2) {
                double[] dArray = this.a[i2];
                double[] dArray2 = dArray;
                dArray[n4] = tr_02.a(i2, n4, dArray2[n4]);
            }
            ++n4;
        }
        return tr_02.b();
    }

    public final double b(tt_0 tt_02, int n2, int n3, int n4, int n5) {
        td_0.a(this, n2, n3, n4, n5);
        ((tp_0)this).f();
        ((tp_0)this).g();
        tt_02.a(n2, n3, n4);
        while (n4 <= n5) {
            for (int i2 = n2; i2 <= n3; ++i2) {
                tt_02.a(i2, n4, this.a[i2][n4]);
            }
            ++n4;
        }
        return tt_02.a();
    }

    public double[][] k() {
        int n2 = ((tp_0)this).f();
        double[][] dArray = new double[n2][((tp_0)this).g()];
        for (int i2 = 0; i2 < n2; ++i2) {
            System.arraycopy(this.a[i2], 0, dArray[i2], 0, this.a[i2].length);
        }
        return dArray;
    }

    private void a(double[][] dArray) {
        ((sv_0)this).a(dArray, 0, 0);
    }
}

