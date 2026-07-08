/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import java.text.FieldPosition;
import java.util.ArrayList;
import java.util.Locale;
import org.valkyrienskies.core.impl.shadow.BS;
import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.ci_0;
import org.valkyrienskies.core.impl.shadow.oS;
import org.valkyrienskies.core.impl.shadow.pf_0;
import org.valkyrienskies.core.impl.shadow.pj_0;
import org.valkyrienskies.core.impl.shadow.pk_0;
import org.valkyrienskies.core.impl.shadow.px_0;
import org.valkyrienskies.core.impl.shadow.sA;
import org.valkyrienskies.core.impl.shadow.sK;
import org.valkyrienskies.core.impl.shadow.sL;
import org.valkyrienskies.core.impl.shadow.sw_0;
import org.valkyrienskies.core.impl.shadow.tc_0;
import org.valkyrienskies.core.impl.shadow.td_0;
import org.valkyrienskies.core.impl.shadow.th_0;
import org.valkyrienskies.core.impl.shadow.tp_0;
import org.valkyrienskies.core.impl.shadow.tq_0;
import org.valkyrienskies.core.impl.shadow.tr_0;
import org.valkyrienskies.core.impl.shadow.ts_0;
import org.valkyrienskies.core.impl.shadow.tt_0;
import org.valkyrienskies.core.impl.shadow.tu_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.sv
 */
public abstract class sv_0
extends tp_0
implements tq_0 {
    private static final ts_0 a;

    protected sv_0() {
    }

    protected sv_0(int n2, int n3) {
        if (n2 <= 0) {
            throw new pk_0(n2);
        }
        if (n3 <= 0) {
            throw new pk_0(n3);
        }
    }

    public tq_0 a(tq_0 tq_02) {
        td_0.a((tq_0)this, tq_02);
        int n2 = ((tp_0)this).f();
        int n3 = ((tp_0)this).g();
        sv_0 sv_02 = this.a(n2, n3);
        for (int i2 = 0; i2 < n2; ++i2) {
            for (int i3 = 0; i3 < n3; ++i3) {
                sv_02.c(i2, i3, this.b(i2, i3) + tq_02.b(i2, i3));
            }
        }
        return sv_02;
    }

    public tq_0 b(tq_0 tq_02) {
        td_0.a(this, tq_02);
        int n2 = ((tp_0)this).f();
        int n3 = ((tp_0)this).g();
        sv_0 sv_02 = this.a(n2, n3);
        for (int i2 = 0; i2 < n2; ++i2) {
            for (int i3 = 0; i3 < n3; ++i3) {
                sv_02.c(i2, i3, this.b(i2, i3) - tq_02.b(i2, i3));
            }
        }
        return sv_02;
    }

    public tq_0 a(double d2) {
        int n2 = ((tp_0)this).f();
        int n3 = ((tp_0)this).g();
        sv_0 sv_02 = this.a(n2, n3);
        for (int i2 = 0; i2 < n2; ++i2) {
            for (int i3 = 0; i3 < n3; ++i3) {
                sv_02.c(i2, i3, this.b(i2, i3) + d2);
            }
        }
        return sv_02;
    }

    public tq_0 b(double d2) {
        int n2 = ((tp_0)this).f();
        int n3 = ((tp_0)this).g();
        sv_0 sv_02 = this.a(n2, n3);
        for (int i2 = 0; i2 < n2; ++i2) {
            for (int i3 = 0; i3 < n3; ++i3) {
                sv_02.c(i2, i3, this.b(i2, i3) * d2);
            }
        }
        return sv_02;
    }

    public tq_0 c(tq_0 tq_02) {
        td_0.b(this, tq_02);
        int n2 = ((tp_0)this).f();
        int n3 = tq_02.g();
        int n4 = ((tp_0)this).g();
        sv_0 sv_02 = this.a(n2, n3);
        for (int i2 = 0; i2 < n2; ++i2) {
            for (int i3 = 0; i3 < n3; ++i3) {
                double d2 = 0.0;
                for (int i4 = 0; i4 < n4; ++i4) {
                    d2 += this.b(i2, i4) * tq_02.b(i4, i3);
                }
                sv_02.c(i2, i3, d2);
            }
        }
        return sv_02;
    }

    public final tq_0 d(tq_0 tq_02) {
        return tq_02.c(this);
    }

    public final tq_0 a(int n2) {
        int n3;
        if (n2 < 0) {
            throw new pj_0(px_0.NOT_POSITIVE_EXPONENT, n2);
        }
        if (!this.e()) {
            throw new th_0(((tp_0)this).f(), ((tp_0)this).g());
        }
        if (n2 == 0) {
            return td_0.a(((tp_0)this).f());
        }
        if (n2 == 1) {
            return this.i();
        }
        Object object = Integer.toBinaryString(--n2).toCharArray();
        Serializable serializable = new ArrayList<Integer>();
        int n4 = -1;
        for (int i2 = 0; i2 < ((char[])object).length; ++i2) {
            if (object[i2] != '1') continue;
            n3 = ((char[])object).length - i2 - 1;
            ((ArrayList)serializable).add(n3);
            if (n4 != -1) continue;
            n4 = n3;
        }
        tq_0[] tq_0Array = new tq_0[n4 + 1];
        tq_0[] tq_0Array2 = tq_0Array;
        tq_0Array[0] = this.i();
        for (n3 = 1; n3 <= n4; ++n3) {
            tq_0Array2[n3] = tq_0Array2[n3 - 1].c(tq_0Array2[n3 - 1]);
        }
        tq_0 tq_02 = this.i();
        object = ((ArrayList)serializable).iterator();
        while (object.hasNext()) {
            serializable = (Integer)object.next();
            tq_02 = tq_02.c(tq_0Array2[(Integer)serializable]);
        }
        return tq_02;
    }

    public double[][] a() {
        double[][] dArray = new double[((tp_0)this).f()][((tp_0)this).g()];
        for (int i2 = 0; i2 < dArray.length; ++i2) {
            double[] dArray2 = dArray[i2];
            for (int i3 = 0; i3 < dArray2.length; ++i3) {
                dArray2[i3] = this.b(i2, i3);
            }
        }
        return dArray;
    }

    public double b() {
        return this.a(new tt_0(this){
            private double a;
            private double b;
            private double c;
            private /* synthetic */ sv_0 d;
            {
                this.d = sv_02;
            }

            public final void a(int n2, int n3, int n4) {
                this.a = n3;
                this.b = 0.0;
                this.c = 0.0;
            }

            public final void a(int n2, int n3, double d2) {
                this.b += BY.w(d2);
                if ((double)n2 == this.a) {
                    this.c = BY.e(this.c, this.b);
                    this.b = 0.0;
                }
            }

            public final double a() {
                return this.c;
            }
        });
    }

    public double c() {
        return this.b(new tt_0(this){
            private double a;
            private /* synthetic */ sv_0 b;
            {
                this.b = sv_02;
            }

            public final void a(int n2, int n3, int n4) {
                this.a = 0.0;
            }

            public final void a(int n2, int n3, double d2) {
                double d3 = d2;
                this.a += d3 * d3;
            }

            public final double a() {
                return BY.a(this.a);
            }
        });
    }

    public tq_0 a(int n2, int n3, int n4, int n5) {
        td_0.a(this, n2, n3, n4, n5);
        sv_0 sv_02 = this.a(n3 - n2 + 1, n5 - n4 + 1);
        for (int i2 = n2; i2 <= n3; ++i2) {
            for (int i3 = n4; i3 <= n5; ++i3) {
                sv_02.c(i2 - n2, i3 - n4, this.b(i2, i3));
            }
        }
        return sv_02;
    }

    public final tq_0 a(int[] nArray, int[] nArray2) {
        td_0.a(this, nArray, nArray2);
        sv_0 sv_02 = this.a(nArray.length, nArray2.length);
        sv_02.a(new sK(this, nArray, nArray2){
            private /* synthetic */ int[] a;
            private /* synthetic */ int[] b;
            private /* synthetic */ sv_0 c;
            {
                this.c = sv_02;
                this.a = nArray;
                this.b = nArray2;
            }

            public final double a(int n2, int n3, double d2) {
                return this.c.b(this.a[n2], this.b[n3]);
            }
        });
        return sv_02;
    }

    public final void a(int n2, int n3, int n4, int n5, double[][] dArray) {
        td_0.a(this, 0, n3, n4, n5);
        n2 = n3 + 1;
        int n6 = n5 + 1 - n4;
        if (dArray.length < n2 || dArray[0].length < n6) {
            throw new tc_0(dArray.length, dArray[0].length, n2, n6);
        }
        for (int i2 = 1; i2 < n2; ++i2) {
            if (dArray[i2].length >= n6) continue;
            throw new tc_0(dArray.length, dArray[i2].length, n2, n6);
        }
        this.a(new sL(this, dArray){
            private int a;
            private int b;
            private /* synthetic */ double[][] c;
            private /* synthetic */ sv_0 d;
            {
                this.d = sv_02;
                this.c = dArray;
            }

            public final void a(int n2, int n3, int n4) {
                this.a = n2;
                this.b = n4;
            }

            public final void a(int n2, int n3, double d2) {
                this.c[n2 - this.a][n3 - this.b] = d2;
            }
        }, 0, n3, n4, n5);
    }

    public final void a(int[] nArray, int[] nArray2, double[][] dArray) {
        td_0.a(this, nArray, nArray2);
        int n2 = nArray2.length;
        if (dArray.length < nArray.length || dArray[0].length < n2) {
            throw new tc_0(dArray.length, dArray[0].length, nArray.length, nArray2.length);
        }
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            double[] dArray2 = dArray[i2];
            if (dArray2.length < n2) {
                throw new tc_0(dArray.length, dArray2.length, nArray.length, nArray2.length);
            }
            for (int i3 = 0; i3 < nArray2.length; ++i3) {
                dArray2[i3] = this.b(nArray[i2], nArray2[i3]);
            }
        }
    }

    public void a(double[][] dArray, int n2, int n3) {
        int n4;
        ci_0.a(dArray);
        int n5 = dArray.length;
        if (n5 == 0) {
            throw new pf_0(px_0.AT_LEAST_ONE_ROW);
        }
        int n6 = dArray[0].length;
        if (n6 == 0) {
            throw new pf_0(px_0.AT_LEAST_ONE_COLUMN);
        }
        for (n4 = 1; n4 < n5; ++n4) {
            if (dArray[n4].length == n6) continue;
            throw new oS(n6, dArray[n4].length);
        }
        td_0.a((sw_0)this, n2);
        td_0.b((sw_0)this, n3);
        td_0.a((sw_0)this, n5 + n2 - 1);
        td_0.b((sw_0)this, n6 + n3 - 1);
        for (n4 = 0; n4 < n5; ++n4) {
            for (int i2 = 0; i2 < n6; ++i2) {
                this.c(n2 + n4, n3 + i2, dArray[n4][i2]);
            }
        }
    }

    public tq_0 b(int n2) {
        td_0.a((sw_0)this, n2);
        int n3 = ((tp_0)this).g();
        sv_0 sv_02 = this.a(1, n3);
        for (int i2 = 0; i2 < n3; ++i2) {
            sv_02.c(0, i2, this.b(n2, i2));
        }
        return sv_02;
    }

    public void a(int n2, tq_0 tq_02) {
        td_0.a((sw_0)this, n2);
        int n3 = ((tp_0)this).g();
        if (tq_02.f() != 1 || tq_02.g() != n3) {
            throw new tc_0(tq_02.f(), tq_02.g(), 1, n3);
        }
        for (int i2 = 0; i2 < n3; ++i2) {
            this.c(n2, i2, tq_02.b(0, i2));
        }
    }

    public tq_0 c(int n2) {
        td_0.b((sw_0)this, n2);
        int n3 = ((tp_0)this).f();
        sv_0 sv_02 = this.a(n3, 1);
        for (int i2 = 0; i2 < n3; ++i2) {
            sv_02.c(i2, 0, this.b(i2, n2));
        }
        return sv_02;
    }

    public void b(int n2, tq_0 tq_02) {
        td_0.b((sw_0)this, n2);
        int n3 = ((tp_0)this).f();
        if (tq_02.f() != n3 || tq_02.g() != 1) {
            throw new tc_0(tq_02.f(), tq_02.g(), n3, 1);
        }
        for (int i2 = 0; i2 < n3; ++i2) {
            this.c(i2, n2, tq_02.b(i2, 0));
        }
    }

    public sA d(int n2) {
        return new sA(this.f(n2), false);
    }

    public void a(int n2, tu_0 tu_02) {
        td_0.a((sw_0)this, n2);
        int n3 = ((tp_0)this).g();
        if (tu_02.f() != n3) {
            throw new tc_0(1, tu_02.f(), 1, n3);
        }
        for (int i2 = 0; i2 < n3; ++i2) {
            this.c(n2, i2, tu_02.a(i2));
        }
    }

    public sA e(int n2) {
        return new sA(this.g(n2), false);
    }

    public void b(int n2, tu_0 tu_02) {
        td_0.b((sw_0)this, n2);
        int n3 = ((tp_0)this).f();
        if (tu_02.f() != n3) {
            throw new tc_0(tu_02.f(), 1, n3, 1);
        }
        for (int i2 = 0; i2 < n3; ++i2) {
            this.c(i2, n2, tu_02.a(i2));
        }
    }

    public double[] f(int n2) {
        td_0.a((sw_0)this, n2);
        int n3 = ((tp_0)this).g();
        double[] dArray = new double[n3];
        for (int i2 = 0; i2 < n3; ++i2) {
            dArray[i2] = this.b(n2, i2);
        }
        return dArray;
    }

    public void a(int n2, double[] dArray) {
        td_0.a((sw_0)this, n2);
        int n3 = ((tp_0)this).g();
        if (dArray.length != n3) {
            throw new tc_0(1, dArray.length, 1, n3);
        }
        for (int i2 = 0; i2 < n3; ++i2) {
            this.c(n2, i2, dArray[i2]);
        }
    }

    public double[] g(int n2) {
        td_0.b((sw_0)this, n2);
        int n3 = ((tp_0)this).f();
        double[] dArray = new double[n3];
        for (int i2 = 0; i2 < n3; ++i2) {
            dArray[i2] = this.b(i2, n2);
        }
        return dArray;
    }

    public void b(int n2, double[] dArray) {
        td_0.b((sw_0)this, n2);
        int n3 = ((tp_0)this).f();
        if (dArray.length != n3) {
            throw new tc_0(dArray.length, 1, n3, 1);
        }
        for (int i2 = 0; i2 < n3; ++i2) {
            this.c(i2, n2, dArray[i2]);
        }
    }

    public void a(int n2, int n3, double d2) {
        td_0.a(this, n2, n3);
        this.c(n2, n3, this.b(n2, n3) + d2);
    }

    public void b(int n2, int n3, double d2) {
        td_0.a(this, n2, n3);
        this.c(n2, n3, this.b(n2, n3) * d2);
    }

    public tq_0 d() {
        int n2 = ((tp_0)this).f();
        int n3 = ((tp_0)this).g();
        sv_0 sv_02 = this.a(n3, n2);
        this.b(new sL(this, sv_02){
            private /* synthetic */ tq_0 a;
            private /* synthetic */ sv_0 b;
            {
                this.b = sv_02;
                this.a = tq_02;
            }

            public final void a(int n2, int n3, double d2) {
                this.a.c(n3, n2, d2);
            }
        });
        return sv_02;
    }

    public final boolean e() {
        return ((tp_0)this).g() == ((tp_0)this).f();
    }

    public abstract int f();

    public abstract int g();

    public final double h() {
        int n2;
        int n3 = ((tp_0)this).f();
        if (n3 != (n2 = ((tp_0)this).g())) {
            throw new th_0(n3, n2);
        }
        double d2 = 0.0;
        n2 = 0;
        while (n2 < n3) {
            int n4 = n2++;
            d2 += this.b(n4, n4);
        }
        return d2;
    }

    public double[] a(double[] dArray) {
        int n2 = ((tp_0)this).f();
        int n3 = ((tp_0)this).g();
        if (dArray.length != n3) {
            throw new oS(dArray.length, n3);
        }
        double[] dArray2 = new double[n2];
        for (int i2 = 0; i2 < n2; ++i2) {
            double d2 = 0.0;
            for (int i3 = 0; i3 < n3; ++i3) {
                d2 += this.b(i2, i3) * dArray[i3];
            }
            dArray2[i2] = d2;
        }
        return dArray2;
    }

    public final sA a(tu_0 tu_02) {
        try {
            sA sA2 = (sA)((Object)tu_02);
            return new sA(this.a(sA2.a), false);
        }
        catch (ClassCastException classCastException) {
            int n2 = ((tp_0)this).f();
            int n3 = ((tp_0)this).g();
            if (tu_02.f() != n3) {
                throw new oS(tu_02.f(), n3);
            }
            double[] dArray = new double[n2];
            for (int i2 = 0; i2 < n2; ++i2) {
                double d2 = 0.0;
                for (int i3 = 0; i3 < n3; ++i3) {
                    d2 += this.b(i2, i3) * tu_02.a(i3);
                }
                dArray[i2] = d2;
            }
            return new sA(dArray, false);
        }
    }

    public double[] b(double[] dArray) {
        int n2 = ((tp_0)this).f();
        int n3 = ((tp_0)this).g();
        if (dArray.length != n2) {
            throw new oS(dArray.length, n2);
        }
        double[] dArray2 = new double[n3];
        for (int i2 = 0; i2 < n3; ++i2) {
            double d2 = 0.0;
            for (int i3 = 0; i3 < n2; ++i3) {
                d2 += this.b(i3, i2) * dArray[i3];
            }
            dArray2[i2] = d2;
        }
        return dArray2;
    }

    public tu_0 b(tu_0 tu_02) {
        try {
            sA sA2 = (sA)((Object)tu_02);
            return new sA(this.b(sA2.a), false);
        }
        catch (ClassCastException classCastException) {
            int n2 = ((tp_0)this).f();
            int n3 = ((tp_0)this).g();
            if (tu_02.f() != n2) {
                throw new oS(tu_02.f(), n2);
            }
            double[] dArray = new double[n3];
            for (int i2 = 0; i2 < n3; ++i2) {
                double d2 = 0.0;
                for (int i3 = 0; i3 < n2; ++i3) {
                    d2 += this.b(i3, i2) * tu_02.a(i3);
                }
                dArray[i2] = d2;
            }
            return new sA(dArray, false);
        }
    }

    public double a(tr_0 tr_02) {
        int n2 = ((tp_0)this).f();
        int n3 = ((tp_0)this).g();
        for (int i2 = 0; i2 < n2; ++i2) {
            for (int i3 = 0; i3 < n3; ++i3) {
                double d2 = this.b(i2, i3);
                double d3 = tr_02.a(i2, i3, d2);
                this.c(i2, i3, d3);
            }
        }
        return tr_02.b();
    }

    public double a(tt_0 tt_02) {
        int n2 = ((tp_0)this).f();
        int n3 = ((tp_0)this).g();
        tt_02.a(0, n2 - 1, 0);
        for (int i2 = 0; i2 < n2; ++i2) {
            for (int i3 = 0; i3 < n3; ++i3) {
                tt_02.a(i2, i3, this.b(i2, i3));
            }
        }
        return tt_02.a();
    }

    public double a(tr_0 tr_02, int n2, int n3, int n4, int n5) {
        td_0.a(this, n2, n3, n4, n5);
        ((tp_0)this).f();
        ((tp_0)this).g();
        while (n2 <= n3) {
            for (int i2 = n4; i2 <= n5; ++i2) {
                double d2 = this.b(n2, i2);
                double d3 = tr_02.a(n2, i2, d2);
                this.c(n2, i2, d3);
            }
            ++n2;
        }
        return tr_02.b();
    }

    public double a(tt_0 tt_02, int n2, int n3, int n4, int n5) {
        td_0.a(this, n2, n3, n4, n5);
        ((tp_0)this).f();
        ((tp_0)this).g();
        tt_02.a(n2, n3, n4);
        while (n2 <= n3) {
            for (int i2 = n4; i2 <= n5; ++i2) {
                tt_02.a(n2, i2, this.b(n2, i2));
            }
            ++n2;
        }
        return tt_02.a();
    }

    public double b(tr_0 tr_02) {
        int n2 = ((tp_0)this).f();
        int n3 = ((tp_0)this).g();
        for (int i2 = 0; i2 < n3; ++i2) {
            for (int i3 = 0; i3 < n2; ++i3) {
                double d2 = this.b(i3, i2);
                double d3 = tr_02.a(i3, i2, d2);
                this.c(i3, i2, d3);
            }
        }
        return tr_02.b();
    }

    public double a(1 var1_1) {
        int n2 = ((tp_0)this).f();
        int n3 = ((tp_0)this).g();
        var1_1.a(0, n2 - 1, 0);
        for (int i2 = 0; i2 < n3; ++i2) {
            for (int i3 = 0; i3 < n2; ++i3) {
                var1_1.a(i3, i2, this.b(i3, i2));
            }
        }
        return var1_1.a();
    }

    public double b(tr_0 tr_02, int n2, int n3, int n4, int n5) {
        td_0.a(this, n2, n3, n4, n5);
        ((tp_0)this).f();
        ((tp_0)this).g();
        while (n4 <= n5) {
            for (int i2 = n2; i2 <= n3; ++i2) {
                double d2 = this.b(i2, n4);
                double d3 = tr_02.a(i2, n4, d2);
                this.c(i2, n4, d3);
            }
            ++n4;
        }
        return tr_02.b();
    }

    public double b(tt_0 tt_02, int n2, int n3, int n4, int n5) {
        td_0.a(this, n2, n3, n4, n5);
        ((tp_0)this).f();
        ((tp_0)this).g();
        tt_02.a(n2, n3, n4);
        while (n4 <= n5) {
            for (int i2 = n2; i2 <= n3; ++i2) {
                tt_02.a(i2, n4, this.b(i2, n4));
            }
            ++n4;
        }
        return tt_02.a();
    }

    public double a(3 var1_1) {
        return this.a((tr_0)var1_1);
    }

    public double b(tt_0 tt_02) {
        return this.a(tt_02);
    }

    public double c(tr_0 tr_02, int n2, int n3, int n4, int n5) {
        return this.a(tr_02, n2, n3, n4, n5);
    }

    public double a(sL sL2, int n2, int n3, int n4, int n5) {
        return this.a((tt_0)sL2, n2, n3, n4, n5);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Object object = this.getClass().getName();
        object = ((String)object).substring(((String)object).lastIndexOf(46) + 1);
        stringBuilder.append((String)object);
        sv_0 sv_02 = this;
        object = a;
        FieldPosition fieldPosition = new FieldPosition(0);
        StringBuffer stringBuffer = new StringBuffer();
        fieldPosition.setBeginIndex(0);
        fieldPosition.setEndIndex(0);
        stringBuffer.append(((ts_0)object).a);
        int n2 = sv_02.f();
        for (int i2 = 0; i2 < n2; ++i2) {
            stringBuffer.append(((ts_0)object).c);
            for (int i3 = 0; i3 < sv_02.g(); ++i3) {
                if (i3 > 0) {
                    stringBuffer.append(((ts_0)object).f);
                }
                BS.a(sv_02.b(i2, i3), ((ts_0)object).g, stringBuffer, fieldPosition);
            }
            stringBuffer.append(((ts_0)object).d);
            if (i2 >= n2 - 1) continue;
            stringBuffer.append(((ts_0)object).e);
        }
        stringBuffer.append(((ts_0)object).b);
        stringBuilder.append(stringBuffer.toString());
        return stringBuilder.toString();
    }

    public boolean equals(Object object) {
        tq_0 tq_02;
        if (object == this) {
            return true;
        }
        if (!(object instanceof tq_0)) {
            return false;
        }
        tq_02 = tq_02;
        int n2 = ((tp_0)this).f();
        int n3 = ((tp_0)this).g();
        if (tq_02.g() != n3 || tq_02.f() != n2) {
            return false;
        }
        for (int i2 = 0; i2 < n2; ++i2) {
            for (int i3 = 0; i3 < n3; ++i3) {
                if (this.b(i2, i3) == tq_02.b(i2, i3)) continue;
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n2 = ((tp_0)this).f();
        int n3 = ((tp_0)this).g();
        int n4 = n2 + 217;
        n4 = n4 * 31 + n3;
        for (int i2 = 0; i2 < n2; ++i2) {
            for (int i3 = 0; i3 < n3; ++i3) {
                n4 = n4 * 31 + (11 * (i2 + 1) + 17 * (i3 + 1)) * ci_0.a(this.b(i2, i3));
            }
        }
        return n4;
    }

    public abstract sv_0 a(int var1, int var2);

    public abstract sv_0 i();

    public abstract double b(int var1, int var2);

    public abstract void c(int var1, int var2, double var3);

    static {
        ts_0 ts_02 = a = ts_0.a(Locale.US);
        sv_0.a.g.setMinimumFractionDigits(1);
    }
}

