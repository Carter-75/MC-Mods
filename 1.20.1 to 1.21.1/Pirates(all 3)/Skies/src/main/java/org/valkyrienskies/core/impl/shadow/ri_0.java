/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.oU;
import org.valkyrienskies.core.impl.shadow.px_0;
import org.valkyrienskies.core.impl.shadow.qM;
import org.valkyrienskies.core.impl.shadow.qO;
import org.valkyrienskies.core.impl.shadow.qZ;
import org.valkyrienskies.core.impl.shadow.rB;
import org.valkyrienskies.core.impl.shadow.rK;
import org.valkyrienskies.core.impl.shadow.rL;
import org.valkyrienskies.core.impl.shadow.rU;
import org.valkyrienskies.core.impl.shadow.rV;
import org.valkyrienskies.core.impl.shadow.rc_0;
import org.valkyrienskies.core.impl.shadow.rf_0;
import org.valkyrienskies.core.impl.shadow.rj_0;
import org.valkyrienskies.core.impl.shadow.rk_0;
import org.valkyrienskies.core.impl.shadow.rr_0;
import org.valkyrienskies.core.impl.shadow.rs_0;
import org.valkyrienskies.core.impl.shadow.rv_0;
import org.valkyrienskies.core.impl.shadow.ry_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.ri
 */
public final class ri_0
implements rU<rc_0, rv_0>,
rV<rc_0> {
    private static final double g = 1.0E-10;
    double a;
    rs_0 b;
    rs_0 c;
    rs_0 d;
    rs_0 e;
    final double f;

    public ri_0(rs_0 rs_02, double d2) {
        this.d(rs_02);
        this.f = d2;
        this.a = 0.0;
        this.h();
    }

    public ri_0(rs_0 rs_02, rs_0 rs_03, double d2) {
        this.d(rs_03);
        this.f = d2;
        this.a = -rs_02.f(this.e);
        this.h();
    }

    public ri_0(rs_0 rs_02, rs_0 rs_03, rs_0 rs_04, double d2) {
        this(rs_02, rs_03.h(rs_02).b(rs_04.h(rs_02)), d2);
    }

    @Deprecated
    private ri_0(rs_0 rs_02) {
        this(rs_02, 1.0E-10);
    }

    @Deprecated
    private ri_0(rs_0 rs_02, rs_0 rs_03) {
        this(rs_02, rs_03, 1.0E-10);
    }

    @Deprecated
    private ri_0(rs_0 rs_02, rs_0 rs_03, rs_0 rs_04) {
        this(rs_02, rs_03, rs_04, 1.0E-10);
    }

    private ri_0(ri_0 ri_02) {
        this.a = ri_02.a;
        this.b = ri_02.b;
        this.c = ri_02.c;
        this.d = ri_02.d;
        this.e = ri_02.e;
        this.f = ri_02.f;
    }

    public final ri_0 a() {
        return new ri_0(this);
    }

    private void a(rs_0 rs_02, rs_0 rs_03) {
        this.d(rs_03);
        this.a = -rs_02.f(this.e);
        this.h();
    }

    private void c(ri_0 ri_02) {
        this.a = ri_02.a;
        this.b = ri_02.b;
        this.c = ri_02.c;
        this.d = ri_02.d;
        this.e = ri_02.e;
    }

    private void d(rs_0 rs_02) {
        double d2;
        double d3 = rs_02.e();
        if (d2 < 1.0E-10) {
            throw new oU(px_0.ZERO_NORM, new Object[0]);
        }
        this.e = new rs_0(1.0 / d3, rs_02);
    }

    private void h() {
        this.b = new rs_0(-this.a, this.e);
        this.c = this.e.p();
        this.d = rs_0.c(this.e, this.c);
    }

    public final rs_0 c() {
        return this.b;
    }

    public final rs_0 d() {
        return this.e;
    }

    private rs_0 i() {
        return this.c;
    }

    private rs_0 j() {
        return this.d;
    }

    @Override
    public final qM<rc_0> b(qM<rc_0> object) {
        ri_0 ri_02 = this;
        rB rB2 = ri_02.e((qM<rc_0>)object);
        object = ri_02;
        return ri_02.f(rB2);
    }

    @Override
    public final double b() {
        return this.f;
    }

    private void k() {
        rs_0 rs_02 = this.c;
        this.c = this.d;
        this.d = rs_02;
        this.e = this.e.q();
        this.a = -this.a;
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    public final rB a(rs_0 rs_02) {
        return this.e((qM<rc_0>)rs_02);
    }

    public final rs_0 a(qO<rv_0> qO2) {
        return this.f(qO2);
    }

    public final rB e(qM<rc_0> rs_02) {
        rs_02 = rs_02;
        return new rB(rs_02.f(this.c), rs_02.f(this.d));
    }

    public final rs_0 f(qM<rv_0> rB2) {
        rB rB3 = rB2 = (rB)rB2;
        rB rB4 = rB3;
        rB4 = rB2;
        return new rs_0(rB3.c, this.c, rB4.d, this.d, -this.a, this.e);
    }

    private rs_0 a(rB rB2, double d2) {
        rB rB3 = rB2;
        rB rB4 = rB3;
        rB4 = rB2;
        return new rs_0(rB3.c, this.c, rB4.d, this.d, d2 - this.a, this.e);
    }

    private boolean d(ri_0 ri_02) {
        double d2;
        double d3 = rs_0.a(this.e, ri_02.e);
        return d2 < 1.0E-10 && BY.w(this.a - ri_02.a) < this.f || d3 > 3.141592653489793 && BY.w(this.a + ri_02.a) < this.f;
    }

    public final ri_0 a(rs_0 object, rk_0 rk_02) {
        rs_0 rs_02 = this.b.h((qO<rc_0>)object);
        object = new ri_0(((rs_0)object).g(rk_02.a(rs_02)), rk_02.a(this.e), this.f);
        v0.c = rk_02.a(this.c);
        ((ri_0)object).d = rk_02.a(this.d);
        return object;
    }

    public final ri_0 b(rs_0 object) {
        object = new ri_0(this.b.g((qO<rc_0>)object), this.e, this.f);
        v0.c = this.c;
        ((ri_0)object).d = this.d;
        return object;
    }

    public final rs_0 a(rf_0 object) {
        double d2;
        Object object2 = object;
        object2 = ((rf_0)object2).a;
        double d3 = this.e.f((qO<rc_0>)object2);
        if (BY.w(d2) < 1.0E-10) {
            return null;
        }
        object = ((rf_0)object).b(qZ.a);
        double d4 = -(this.a + this.e.f((qO<rc_0>)object)) / d3;
        return new rs_0(1.0, (rs_0)object, d4, (rs_0)object2);
    }

    public final rf_0 a(ri_0 ri_02) {
        rs_0 rs_02;
        double d2;
        rs_0 rs_03;
        rs_0 rs_04 = rs_0.c(this.e, ri_02.e);
        if (rs_03.e() < this.f) {
            return null;
        }
        ri_0 ri_03 = new ri_0(rs_04, this.f);
        ri_0 ri_04 = ri_02;
        ri_02 = this;
        rs_0 rs_05 = ri_02.e;
        double d3 = rs_05.i;
        rs_05 = ri_02.e;
        double d4 = rs_05.j;
        rs_05 = ri_02.e;
        double d5 = rs_05.k;
        double d6 = ri_02.a;
        rs_05 = ri_04.e;
        double d7 = rs_05.i;
        rs_05 = ri_04.e;
        double d8 = rs_05.j;
        rs_05 = ri_04.e;
        double d9 = rs_05.k;
        double d10 = ri_04.a;
        rs_05 = ri_03.e;
        double d11 = rs_05.i;
        rs_05 = ri_03.e;
        double d12 = rs_05.j;
        rs_05 = ri_03.e;
        double d13 = rs_05.k;
        double d14 = ri_03.a;
        double d15 = d8 * d13 - d12 * d9;
        double d16 = d9 * d11 - d13 * d7;
        double d17 = d7 * d12 - d11 * d8;
        double d18 = d3 * d15 + d4 * d16 + d5 * d17;
        if (BY.w(d2) < 1.0E-10) {
            rs_02 = null;
        } else {
            double d19 = 1.0 / d18;
            rs_02 = new rs_0((-d15 * d6 - (d5 * d12 - d13 * d4) * d10 - (d9 * d4 - d5 * d8) * d14) * d19, (-d16 * d6 - (d13 * d3 - d5 * d11) * d10 - (d5 * d7 - d9 * d3) * d14) * d19, (-d17 * d6 - (d4 * d11 - d12 * d3) * d10 - (d8 * d3 - d4 * d7) * d14) * d19);
        }
        ri_0 ri_05 = ri_02 = rs_02;
        return new rf_0((rs_0)((Object)ri_05), ((rs_0)((Object)ri_05)).g(rs_04), this.f);
    }

    private static rs_0 a(ri_0 ri_02, ri_0 ri_03, ri_0 ri_04) {
        double d2;
        rs_0 rs_02 = ri_02.e;
        double d3 = rs_02.i;
        rs_02 = ri_02.e;
        double d4 = rs_02.j;
        rs_02 = ri_02.e;
        double d5 = rs_02.k;
        double d6 = ri_02.a;
        rs_02 = ri_03.e;
        double d7 = rs_02.i;
        rs_02 = ri_03.e;
        double d8 = rs_02.j;
        rs_02 = ri_03.e;
        double d9 = rs_02.k;
        double d10 = ri_03.a;
        rs_02 = ri_04.e;
        double d11 = rs_02.i;
        rs_02 = ri_04.e;
        double d12 = rs_02.j;
        rs_02 = ri_04.e;
        double d13 = rs_02.k;
        double d14 = ri_04.a;
        double d15 = d8 * d13 - d12 * d9;
        double d16 = d9 * d11 - d13 * d7;
        double d17 = d7 * d12 - d11 * d8;
        double d18 = d3 * d15 + d4 * d16 + d5 * d17;
        if (BY.w(d2) < 1.0E-10) {
            return null;
        }
        double d19 = 1.0 / d18;
        return new rs_0((-d15 * d6 - (d5 * d12 - d13 * d4) * d10 - (d9 * d4 - d5 * d8) * d14) * d19, (-d16 * d6 - (d13 * d3 - d5 * d11) * d10 - (d5 * d7 - d9 * d3) * d14) * d19, (-d17 * d6 - (d4 * d11 - d12 * d3) * d10 - (d8 * d3 - d4 * d7) * d14) * d19);
    }

    private rr_0 l() {
        return new rr_0(this, new ry_0(this.f));
    }

    private rj_0 m() {
        return new rj_0(this.f);
    }

    public final boolean c(rs_0 object) {
        ri_0 ri_02;
        rs_0 rs_02 = object;
        object = this;
        return BY.w(ri_02.a((qM<rc_0>)rs_02)) < this.f;
    }

    public final double b(ri_0 ri_02) {
        return this.a + (this.a((rV<rc_0>)ri_02) ? -ri_02.a : ri_02.a);
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    private double e(rs_0 rs_02) {
        return this.a((qM<rc_0>)rs_02);
    }

    @Override
    public final double a(qM<rc_0> qM2) {
        return ((rs_0)qM2).f(this.e) + this.a;
    }

    @Override
    public final boolean a(rV<rc_0> rV2) {
        return ((ri_0)rV2).e.f(this.e) > 0.0;
    }

    public final /* synthetic */ rK e() {
        ri_0 ri_02 = this;
        return new rj_0(ri_02.f);
    }

    public final /* synthetic */ rL f() {
        ri_0 ri_02 = this;
        return new rr_0(ri_02, new ry_0(ri_02.f));
    }

    @Override
    public final /* synthetic */ rV g() {
        return this.a();
    }

    @Override
    public final /* synthetic */ qM c(qM qM2) {
        return this.f(qM2);
    }

    @Override
    public final /* synthetic */ qM d(qM qM2) {
        return this.e(qM2);
    }
}

