/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.valkyrienskies.core.impl.shadow.Cm
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import org.valkyrienskies.core.impl.shadow.Cm;
import org.valkyrienskies.core.impl.shadow.cm_0;
import org.valkyrienskies.core.impl.shadow.pm_0;
import org.valkyrienskies.core.impl.shadow.sD;
import org.valkyrienskies.core.impl.shadow.sv_0;
import org.valkyrienskies.core.impl.shadow.sw_0;
import org.valkyrienskies.core.impl.shadow.tF;
import org.valkyrienskies.core.impl.shadow.td_0;
import org.valkyrienskies.core.impl.shadow.tq_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.tk
 */
public final class tk_0
extends sv_0
implements Serializable,
tF {
    private static final long a = -5962461716457143437L;
    private final int b;
    private final int c;
    private final cm_0 d;

    public tk_0(int n2, int n3) {
        super(n2, n3);
        long l2 = n2;
        long l3 = n3;
        if (l2 * l3 >= Integer.MAX_VALUE) {
            throw new pm_0(l2 * l3, (Number)Integer.MAX_VALUE, false);
        }
        this.b = n2;
        this.c = n3;
        this.d = new Cm(0.0);
    }

    private tk_0(tk_0 tk_02) {
        this.b = tk_02.b;
        this.c = tk_02.c;
        this.d = new Cm(tk_02.d);
    }

    private tk_0 j() {
        return new tk_0(this);
    }

    private static tk_0 c(int n2, int n3) {
        return new tk_0(n2, n3);
    }

    public final int g() {
        return this.c;
    }

    private tk_0 a(tk_0 object) {
        td_0.a((tq_0)this, (tq_0)object);
        tk_0 tk_02 = new tk_0(this);
        object = ((tk_0)object).d.a();
        while (((cm_0.a)object).a()) {
            ((cm_0.a)object).d();
            int n2 = ((cm_0.a)object).b() / this.c;
            int n3 = ((cm_0.a)object).b() - n2 * this.c;
            ((sv_0)tk_02).c(n2, n3, ((sv_0)this).b(n2, n3) + ((cm_0.a)object).c());
        }
        return tk_02;
    }

    private tk_0 e(tq_0 tq_02) {
        try {
            Object object = (tk_0)tq_02;
            tk_0 tk_02 = this;
            td_0.a((tq_0)tk_02, (tq_0)object);
            tk_0 tk_03 = new tk_0(tk_02);
            object = ((tk_0)object).d.a();
            while (((cm_0.a)object).a()) {
                ((cm_0.a)object).d();
                int n2 = ((cm_0.a)object).b() / tk_02.c;
                int n3 = ((cm_0.a)object).b() - n2 * tk_02.c;
                ((sv_0)tk_03).c(n2, n3, ((sv_0)tk_02).b(n2, n3) - ((cm_0.a)object).c());
            }
            return tk_03;
        }
        catch (ClassCastException classCastException) {
            return (tk_0)super.b(tq_02);
        }
    }

    private tk_0 b(tk_0 object) {
        td_0.a((tq_0)this, (tq_0)object);
        tk_0 tk_02 = new tk_0(this);
        object = ((tk_0)object).d.a();
        while (((cm_0.a)object).a()) {
            ((cm_0.a)object).d();
            int n2 = ((cm_0.a)object).b() / this.c;
            int n3 = ((cm_0.a)object).b() - n2 * this.c;
            ((sv_0)tk_02).c(n2, n3, ((sv_0)this).b(n2, n3) - ((cm_0.a)object).c());
        }
        return tk_02;
    }

    public final tq_0 c(tq_0 tq_02) {
        try {
            tk_0 tk_02 = (tk_0)tq_02;
            tk_0 tk_03 = this;
            td_0.b(tk_03, tk_02);
            tk_0 tk_04 = tk_02;
            int n2 = tk_04.c;
            tk_0 tk_05 = new tk_0(tk_03.b, n2);
            cm_0.a a2 = tk_03.d.a();
            while (a2.a()) {
                a2.d();
                double d2 = a2.c();
                int n3 = a2.b();
                int n4 = n3 / tk_03.c;
                int n5 = n3 % tk_03.c;
                for (int i2 = 0; i2 < n2; ++i2) {
                    int n6 = tk_02.d(n5, i2);
                    if (!tk_02.d.b(n6)) continue;
                    int n7 = tk_05.d(n4, i2);
                    double d3 = tk_05.d.a(n7) + d2 * tk_02.d.a(n6);
                    if (d3 == 0.0) {
                        tk_05.d.c(n7);
                        continue;
                    }
                    tk_05.d.a(n7, d3);
                }
            }
            return tk_05;
        }
        catch (ClassCastException classCastException) {
            td_0.b(this, tq_02);
            int n8 = tq_02.g();
            sD sD2 = new sD(this.b, n8);
            cm_0.a a3 = this.d.a();
            while (a3.a()) {
                a3.d();
                double d4 = a3.c();
                int n9 = a3.b();
                int n10 = n9 / this.c;
                n9 %= this.c;
                int n11 = 0;
                while (n11 < n8) {
                    double d5 = d4 * tq_02.b(n9, n11);
                    int n12 = n11++;
                    int n13 = n10;
                    sD sD3 = sD2;
                    td_0.a((sv_0)sD3, n13, n12);
                    int n14 = n13 / 52;
                    int n15 = n12 / 52;
                    int n16 = (n13 - n14 * 52) * sD3.h(n15) + (n12 - n15 * 52);
                    double[] dArray = sD3.a[n14 * sD3.b + n15];
                    int n17 = n16;
                    dArray[n17] = dArray[n17] + d5;
                }
            }
            return sD2;
        }
    }

    private tk_0 c(tk_0 tk_02) {
        td_0.b(this, tk_02);
        tk_0 tk_03 = tk_02;
        int n2 = tk_03.c;
        tk_0 tk_04 = new tk_0(this.b, n2);
        cm_0.a a2 = this.d.a();
        while (a2.a()) {
            a2.d();
            double d2 = a2.c();
            int n3 = a2.b();
            int n4 = n3 / this.c;
            n3 %= this.c;
            for (int i2 = 0; i2 < n2; ++i2) {
                int n5 = tk_02.d(n3, i2);
                if (!tk_02.d.b(n5)) continue;
                int n6 = tk_04.d(n4, i2);
                double d3 = tk_04.d.a(n6) + d2 * tk_02.d.a(n5);
                if (d3 == 0.0) {
                    tk_04.d.c(n6);
                    continue;
                }
                tk_04.d.a(n6, d3);
            }
        }
        return tk_04;
    }

    public final double b(int n2, int n3) {
        td_0.a((sw_0)this, n2);
        td_0.b((sw_0)this, n3);
        return this.d.a(this.d(n2, n3));
    }

    public final int f() {
        return this.b;
    }

    public final void c(int n2, int n3, double d2) {
        td_0.a((sw_0)this, n2);
        td_0.b((sw_0)this, n3);
        if (d2 == 0.0) {
            this.d.c(this.d(n2, n3));
            return;
        }
        this.d.a(this.d(n2, n3), d2);
    }

    public final void a(int n2, int n3, double d2) {
        td_0.a((sw_0)this, n2);
        td_0.b((sw_0)this, n3);
        n2 = this.d(n2, n3);
        double d3 = this.d.a(n2) + d2;
        if (d3 == 0.0) {
            this.d.c(n2);
            return;
        }
        this.d.a(n2, d3);
    }

    public final void b(int n2, int n3, double d2) {
        td_0.a((sw_0)this, n2);
        td_0.b((sw_0)this, n3);
        n2 = this.d(n2, n3);
        double d3 = this.d.a(n2) * d2;
        if (d3 == 0.0) {
            this.d.c(n2);
            return;
        }
        this.d.a(n2, d3);
    }

    private int d(int n2, int n3) {
        return n2 * this.c + n3;
    }

    public final /* synthetic */ sv_0 i() {
        tk_0 tk_02 = this;
        return new tk_0(tk_02);
    }

    public final /* synthetic */ sv_0 a(int n2, int n3) {
        return new tk_0(n2, n3);
    }

    public final /* synthetic */ tq_0 b(tq_0 tq_02) {
        return this.e(tq_02);
    }
}

