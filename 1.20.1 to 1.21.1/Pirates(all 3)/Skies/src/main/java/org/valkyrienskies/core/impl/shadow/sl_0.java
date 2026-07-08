/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.valkyrienskies.core.impl.shadow.sl
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.qM;
import org.valkyrienskies.core.impl.shadow.rK;
import org.valkyrienskies.core.impl.shadow.rL;
import org.valkyrienskies.core.impl.shadow.rU;
import org.valkyrienskies.core.impl.shadow.rV;
import org.valkyrienskies.core.impl.shadow.rk_0;
import org.valkyrienskies.core.impl.shadow.rs_0;
import org.valkyrienskies.core.impl.shadow.sb_0;
import org.valkyrienskies.core.impl.shadow.sc_0;
import org.valkyrienskies.core.impl.shadow.sf_0;
import org.valkyrienskies.core.impl.shadow.sg_0;
import org.valkyrienskies.core.impl.shadow.si_0;
import org.valkyrienskies.core.impl.shadow.sj_0;
import org.valkyrienskies.core.impl.shadow.sl;
import org.valkyrienskies.core.impl.shadow.sp_0;
import org.valkyrienskies.core.impl.shadow.sq_0;
import org.valkyrienskies.core.impl.shadow.sr_0;
import org.valkyrienskies.core.impl.shadow.ss_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.sl
 */
public final class sl_0
implements rU<sq_0, sj_0>,
rV<sq_0> {
    rs_0 a;
    rs_0 b;
    rs_0 c;
    final double d;

    public sl_0(rs_0 rs_02, double d2) {
        this.b(rs_02);
        this.d = d2;
    }

    public sl_0(sp_0 sp_02, sp_0 sp_03, double d2) {
        sp_0 sp_04 = sp_02;
        sp_02 = sp_04;
        sp_02 = sp_03;
        this.b(sp_04.c.b(sp_02.c));
        this.d = d2;
    }

    private sl_0(rs_0 rs_02, rs_0 rs_03, rs_0 rs_04, double d2) {
        this.a = rs_02;
        this.b = rs_03;
        this.c = rs_04;
        this.d = d2;
    }

    private sl_0(sl_0 sl_02) {
        this(sl_02.a, sl_02.b, sl_02.c, sl_02.d);
    }

    public final sl_0 a() {
        return new sl_0(this);
    }

    private void b(rs_0 rs_02) {
        this.a = rs_02.o();
        this.b = rs_02.p();
        this.c = rs_0.c(rs_02, this.b).o();
    }

    private void i() {
        this.c = this.c.q();
        this.a = this.a.q();
    }

    public final sl_0 c() {
        return new sl_0(this.a.q(), this.b, this.c.q(), this.d);
    }

    @Override
    public final qM<sq_0> b(qM<sq_0> qM2) {
        sl_0 sl_02 = this;
        return sl_02.e(sl_02.f(qM2));
    }

    @Override
    public final double b() {
        return this.d;
    }

    private si_0 f(qM<sq_0> sp_02) {
        sp_02 = sp_02;
        return new si_0(this.a(sp_02.c));
    }

    public final double a(rs_0 rs_02) {
        return Math.PI + BY.b(-rs_02.f(this.c), -rs_02.f(this.b));
    }

    public final sp_0 e(qM<sj_0> si_02) {
        si_02 = si_02;
        return new sp_0(this.a(si_02.b));
    }

    public final rs_0 a(double d2) {
        return new rs_0(BY.o(d2), this.b, BY.n(d2), this.c);
    }

    private rs_0 j() {
        return this.b;
    }

    private rs_0 k() {
        return this.c;
    }

    public final rs_0 d() {
        return this.a;
    }

    public final sf_0 a(sl_0 sl_02) {
        double d2 = this.a(sl_02.a);
        return new sf_0(d2 - 1.5707963267948966, d2 + 1.5707963267948966, this.d);
    }

    public final ss_0 h() {
        return new ss_0(this, new sg_0(this.d));
    }

    private sr_0 l() {
        return new sr_0(this.d);
    }

    @Override
    public final double a(qM<sq_0> object) {
        object = (sp_0)object;
        rs_0 rs_02 = ((sp_0)object).c;
        object = this;
        return rs_0.a(((sl_0)object).a, rs_02) - 1.5707963267948966;
    }

    private double c(rs_0 rs_02) {
        return rs_0.a(this.a, rs_02) - 1.5707963267948966;
    }

    @Override
    public final boolean a(rV<sq_0> sl_02) {
        sl_02 = sl_02;
        return rs_0.b(this.a, sl_02.a) >= 0.0;
    }

    private static sc_0<sq_0, sj_0> a(rk_0 rk_02) {
        return new a(rk_02);
    }

    public final /* synthetic */ rK e() {
        sl_0 sl_02 = this;
        return new sr_0(sl_02.d);
    }

    public final /* synthetic */ rL f() {
        return this.h();
    }

    @Override
    public final /* synthetic */ rV g() {
        return this.a();
    }

    @Override
    public final /* synthetic */ qM c(qM qM2) {
        return this.e(qM2);
    }

    @Override
    public final /* synthetic */ qM d(qM qM2) {
        return this.f(qM2);
    }

    static /* synthetic */ rs_0 b(sl_0 sl_02) {
        return sl_02.a;
    }

    static /* synthetic */ rs_0 c(sl_0 sl_02) {
        return sl_02.b;
    }

    static /* synthetic */ rs_0 d(sl_0 sl_02) {
        return sl_02.c;
    }

    static /* synthetic */ double e(sl_0 sl_02) {
        return sl_02.d;
    }

    /* synthetic */ sl_0(rs_0 rs_02, rs_0 rs_03, rs_0 rs_04, double d2, byte by) {
        this(rs_02, rs_03, rs_04, d2);
    }

    static final class 1 {
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    static final class a
    implements sc_0<sq_0, sj_0> {
        private final rk_0 a;

        a(rk_0 rk_02) {
            this.a = rk_02;
        }

        private sp_0 b(qM<sq_0> sp_02) {
            sp_02 = sp_02;
            return new sp_0(this.a.a(sp_02.c));
        }

        private sl_0 b(rV<sq_0> sl2) {
            sl sl3 = sl2 = (sl)sl2;
            sl sl4 = sl3;
            sl sl5 = sl2;
            sl4 = sl5;
            sl sl6 = sl2;
            sl4 = sl6;
            sl4 = sl2;
            return new sl(this.a.a(sl3.a), this.a.a(sl5.b), this.a.a(sl6.c), sl4.d, 0);
        }

        @Override
        public final sb_0<sj_0> a(sb_0<sj_0> sb_02, rV<sq_0> rV2, rV<sq_0> rV3) {
            return sb_02;
        }

        @Override
        public final /* synthetic */ rV a(rV object) {
            rV rV2 = object;
            object = this;
            rV rV3 = rV2 = (sl)rV2;
            rV rV4 = rV3;
            rV rV5 = rV2;
            rV4 = rV5;
            rV rV6 = rV2;
            rV4 = rV6;
            rV4 = rV2;
            return new sl(((a)object).a.a(((sl)rV3).a), ((a)object).a.a(((sl)rV5).b), ((a)object).a.a(((sl)rV6).c), ((sl)rV4).d, 0);
        }

        @Override
        public final /* synthetic */ qM a(qM object) {
            qM qM2 = object;
            object = this;
            object = (sp_0)qM2;
            return new sp_0(((a)object).a.a(((sp_0)object).c));
        }
    }
}

