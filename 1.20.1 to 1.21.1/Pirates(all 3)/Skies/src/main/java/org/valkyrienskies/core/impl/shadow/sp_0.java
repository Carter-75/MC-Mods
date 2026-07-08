/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.ci_0;
import org.valkyrienskies.core.impl.shadow.po_0;
import org.valkyrienskies.core.impl.shadow.qM;
import org.valkyrienskies.core.impl.shadow.qN;
import org.valkyrienskies.core.impl.shadow.rs_0;
import org.valkyrienskies.core.impl.shadow.sq_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.sp
 */
public final class sp_0
implements qM<sq_0> {
    private static sp_0 d;
    private static sp_0 e;
    public static final sp_0 a;
    private static sp_0 f;
    private static sp_0 g;
    private static sp_0 h;
    public static final sp_0 b;
    private static final long i = 20131218L;
    private final double j;
    private final double k;
    final rs_0 c;

    public sp_0(double d2, double d3) {
        double d4 = 0.0;
        double d5 = 0.0;
        if (d4 < 0.0 || d4 > Math.PI) {
            throw new po_0(d4, (Number)0, Math.PI);
        }
        double d6 = BY.o(d5);
        double d7 = BY.n(d5);
        double d8 = BY.o(d4);
        double d9 = BY.n(d4);
        this(0.0, 0.0, new rs_0(d6 * d9, d7 * d9, d8));
    }

    public sp_0(rs_0 rs_02) {
        rs_0 rs_03 = rs_02;
        rs_0 rs_04 = rs_03;
        rs_04 = rs_02;
        this(BY.b(rs_03.j, rs_04.i), rs_0.a(rs_0.f, rs_02), rs_02.o());
    }

    private sp_0(double d2, double d3, rs_0 rs_02) {
        this.j = d2;
        this.k = d3;
        this.c = rs_02;
    }

    private static rs_0 a(double d2, double d3) {
        if (d3 < 0.0 || d3 > Math.PI) {
            throw new po_0(d3, (Number)0, Math.PI);
        }
        double d4 = BY.o(d2);
        double d5 = BY.n(d2);
        double d6 = BY.o(d3);
        double d7 = BY.n(d3);
        return new rs_0(d4 * d7, d5 * d7, d6);
    }

    private double e() {
        return this.j;
    }

    private double f() {
        return this.k;
    }

    public final rs_0 c() {
        return this.c;
    }

    @Override
    public final qN a() {
        return sq_0.a.a();
    }

    @Override
    public final boolean b() {
        return Double.isNaN(this.j) || Double.isNaN(this.k);
    }

    public final sp_0 d() {
        return new sp_0(-this.j, Math.PI - this.k, this.c.q());
    }

    @Override
    public final double a(qM<sq_0> sp_02) {
        sp_0 sp_03 = sp_02;
        sp_02 = this;
        return rs_0.a(sp_02.c, sp_03.c);
    }

    private static double a(sp_0 sp_02, sp_0 sp_03) {
        return rs_0.a(sp_02.c, sp_03.c);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof sp_0) {
            sp_0 sp_02;
            if ((sp_02 = (sp_0)sp_02).b()) {
                return this.b();
            }
            return this.j == sp_02.j && this.k == sp_02.k;
        }
        return false;
    }

    public final int hashCode() {
        if (this.b()) {
            return 542;
        }
        return 134 * (37 * ci_0.a(this.j) + ci_0.a(this.k));
    }

    static {
        new sp_0(0.0, 1.5707963267948966, rs_0.b);
        new sp_0(1.5707963267948966, 1.5707963267948966, rs_0.d);
        a = new sp_0(0.0, 0.0, rs_0.f);
        new sp_0(Math.PI, 1.5707963267948966, rs_0.c);
        new sp_0(4.71238898038469, 1.5707963267948966, rs_0.e);
        new sp_0(0.0, Math.PI, rs_0.g);
        b = new sp_0(Double.NaN, Double.NaN, rs_0.h);
    }
}

