/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.cc_0;
import org.valkyrienskies.core.impl.shadow.ci_0;
import org.valkyrienskies.core.impl.shadow.lc_0;
import org.valkyrienskies.core.impl.shadow.nP;
import org.valkyrienskies.core.impl.shadow.nu_0;
import org.valkyrienskies.core.impl.shadow.pc_0;
import org.valkyrienskies.core.impl.shadow.pe_0;
import org.valkyrienskies.core.impl.shadow.pl_0;
import org.valkyrienskies.core.impl.shadow.pp_0;
import org.valkyrienskies.core.impl.shadow.px_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.ns
 */
public abstract class ns_0<FUNC extends lc_0>
implements nu_0<FUNC> {
    private static final double d = 1.0E-14;
    private static final double e = 1.0E-15;
    final double a;
    final double b;
    final double c;
    private cc_0.a f;
    private double g;
    private double h;
    private double i;
    private FUNC j;

    protected ns_0(double d2) {
        this(1.0E-14, d2, 1.0E-15);
    }

    protected ns_0(double d2, double d3) {
        this(d2, d3, 1.0E-15);
    }

    protected ns_0(double d2, double d3, double d4) {
        this.b = d3;
        this.c = d2;
        this.a = d4;
        this.f = cc_0.a.a();
    }

    @Override
    public final int b() {
        cc_0.a a2 = this.f;
        return a2.b;
    }

    @Override
    public final int c() {
        cc_0.a a2 = this.f;
        return a2.e;
    }

    public final double d() {
        return this.g;
    }

    public final double e() {
        return this.h;
    }

    public final double f() {
        return this.i;
    }

    @Override
    public final double g() {
        return this.b;
    }

    @Override
    public final double h() {
        return this.c;
    }

    @Override
    public final double i() {
        return this.a;
    }

    protected final double b(double d2) {
        this.k();
        return this.j.a(d2);
    }

    protected void a(int n2, FUNC FUNC, double d2, double d3, double d4) {
        ci_0.a(FUNC);
        this.g = d2;
        this.h = d3;
        this.i = d4;
        this.j = FUNC;
        this.f = this.f.b(n2).a(0);
    }

    @Override
    public double b(int n2, FUNC FUNC, double d2, double d3, double d4) {
        this.a(n2, FUNC, d2, d3, d4);
        return this.j();
    }

    @Override
    public double a(int n2, FUNC FUNC, double d2, double d3) {
        return this.b(n2, FUNC, d2, d3, d2 + 0.5 * (d3 - d2));
    }

    @Override
    public final double a(int n2, FUNC FUNC, double d2) {
        return this.b(n2, FUNC, Double.NaN, Double.NaN, d2);
    }

    protected abstract double j();

    protected final boolean a(double d2, double d3) {
        return nP.a(this.j, d2, d3);
    }

    protected static boolean a(double d2, double d3, double d4) {
        double d5;
        double d6 = d4;
        double d7 = d3;
        double d8 = d2;
        return d5 < d7 && d7 < d6;
    }

    protected static void b(double d2, double d3) {
        nP.b(d2, d3);
    }

    protected static void b(double d2, double d3, double d4) {
        nP.b(d2, d3, d4);
    }

    protected final void c(double d2, double d3) {
        double d4 = d3;
        double d5 = d2;
        FUNC FUNC = this.j;
        if (FUNC == null) {
            throw new pl_0(px_0.FUNCTION, new Object[0]);
        }
        nP.b(d5, d4);
        if (!nP.a(FUNC, d5, d4)) {
            throw new pe_0(d5, d4, FUNC.a(d5), FUNC.a(d4));
        }
    }

    protected final void k() {
        try {
            cc_0.a a2 = this.f;
            a2.d(1);
            return;
        }
        catch (pc_0 pc_02) {
            pc_0 pc_03 = pc_02;
            throw new pp_0(pc_03.a);
        }
    }
}

