/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.cb_0;
import org.valkyrienskies.core.impl.shadow.cc_0;
import org.valkyrienskies.core.impl.shadow.ci_0;
import org.valkyrienskies.core.impl.shadow.lc_0;
import org.valkyrienskies.core.impl.shadow.mt_0;
import org.valkyrienskies.core.impl.shadow.nP;
import org.valkyrienskies.core.impl.shadow.pc_0;
import org.valkyrienskies.core.impl.shadow.pk_0;
import org.valkyrienskies.core.impl.shadow.pn_0;
import org.valkyrienskies.core.impl.shadow.pp_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.mm
 */
public abstract class mm_0
implements mt_0 {
    private static double a = 1.0E-15;
    private static double b = 1.0E-6;
    private static int c = 3;
    private static int d = Integer.MAX_VALUE;
    @Deprecated
    private cb_0 e;
    private cc_0.a f;
    private final double g;
    private final double h;
    private final int i;
    private cc_0.a j;
    private lc_0 k;
    private double l;
    private double m;

    protected mm_0(double d2, double d3, int n2, int n3) {
        this.h = d2;
        this.g = d3;
        if (n2 <= 0) {
            throw new pk_0(n2);
        }
        if (n3 <= n2) {
            throw new pn_0(n3, (Number)n2, false);
        }
        this.i = n2;
        this.f = cc_0.a.a().b(n3);
        cb_0.2 var1_2 = cb_0.a(this.f);
        this.e = var1_2;
        this.j = cc_0.a.a();
    }

    private mm_0(double d2, double d3) {
        this(d2, d3, 3, Integer.MAX_VALUE);
    }

    protected mm_0(int n2, int n3) {
        this(1.0E-6, 1.0E-15, n2, n3);
    }

    public final double a() {
        return this.h;
    }

    public final double b() {
        return this.g;
    }

    public final int c() {
        return this.i;
    }

    public final int d() {
        cc_0.a a2 = this.f;
        return a2.b;
    }

    public final int e() {
        cc_0.a a2 = this.j;
        return a2.e;
    }

    public final int f() {
        cc_0.a a2 = this.f;
        return a2.e;
    }

    protected final void g() {
        cc_0.a a2 = this.f;
        a2.d(1);
    }

    protected final double h() {
        return this.l;
    }

    protected final double i() {
        return this.m;
    }

    protected final double a(double d2) {
        try {
            cc_0.a a2 = this.j;
            a2.d(1);
        }
        catch (pc_0 pc_02) {
            pc_0 pc_03 = pc_02;
            throw new pp_0(pc_03.a);
        }
        return this.k.a(d2);
    }

    private void b(int n2, lc_0 lc_02, double d2, double d3) {
        ci_0.a(lc_02);
        nP.b(d2, d3);
        this.l = d2;
        this.m = d3;
        this.k = lc_02;
        this.j = this.j.b(n2).a(0);
        this.f = this.f.a(0);
    }

    public final double a(int n2, lc_0 lc_02, double d2, double d3) {
        double d4 = d3;
        double d5 = d2;
        lc_0 lc_03 = lc_02;
        int n3 = n2;
        mm_0 mm_02 = this;
        ci_0.a(lc_03);
        nP.b(d5, d4);
        mm_02.l = d5;
        mm_02.m = d4;
        mm_02.k = lc_03;
        mm_02.j = mm_02.j.b(n3).a(0);
        mm_02.f = mm_02.f.a(0);
        return this.j();
    }

    protected abstract double j();
}

