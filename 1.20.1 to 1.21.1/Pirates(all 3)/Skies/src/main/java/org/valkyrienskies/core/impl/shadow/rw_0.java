/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.valkyrienskies.core.impl.shadow.rw
 */
package org.valkyrienskies.core.impl.shadow;

import java.awt.geom.AffineTransform;
import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.ch_0;
import org.valkyrienskies.core.impl.shadow.ci_0;
import org.valkyrienskies.core.impl.shadow.oV;
import org.valkyrienskies.core.impl.shadow.px_0;
import org.valkyrienskies.core.impl.shadow.qM;
import org.valkyrienskies.core.impl.shadow.qO;
import org.valkyrienskies.core.impl.shadow.qU;
import org.valkyrienskies.core.impl.shadow.qW;
import org.valkyrienskies.core.impl.shadow.qX;
import org.valkyrienskies.core.impl.shadow.qZ;
import org.valkyrienskies.core.impl.shadow.rA;
import org.valkyrienskies.core.impl.shadow.rB;
import org.valkyrienskies.core.impl.shadow.rK;
import org.valkyrienskies.core.impl.shadow.rL;
import org.valkyrienskies.core.impl.shadow.rU;
import org.valkyrienskies.core.impl.shadow.rV;
import org.valkyrienskies.core.impl.shadow.rv_0;
import org.valkyrienskies.core.impl.shadow.rw;
import org.valkyrienskies.core.impl.shadow.ry_0;
import org.valkyrienskies.core.impl.shadow.sb_0;
import org.valkyrienskies.core.impl.shadow.sc_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.rw
 */
public final class rw_0
implements rU<rv_0, qU>,
rV<rv_0> {
    private static final double e = 1.0E-10;
    private double f;
    double a;
    double b;
    double c;
    final double d;
    private rw_0 g;

    public rw_0(rB object, rB rB2, double d2) {
        rB rB3 = rB2;
        rB2 = object;
        object = this;
        ((rw_0)object).j();
        rB rB4 = rB3;
        rB rB5 = rB4;
        rB5 = rB2;
        double d3 = rB4.c - rB5.c;
        rB rB6 = rB3;
        rB5 = rB6;
        rB5 = rB2;
        double d4 = rB6.d - rB5.d;
        double d5 = BY.f(d3, d4);
        if (d5 == 0.0) {
            ((rw_0)object).f = 0.0;
            ((rw_0)object).a = 1.0;
            ((rw_0)object).b = 0.0;
            rB5 = rB2;
            ((rw_0)object).c = rB5.d;
        } else {
            ((rw_0)object).f = Math.PI + BY.b(-d4, -d3);
            ((rw_0)object).a = d3 / d5;
            ((rw_0)object).b = d4 / d5;
            rB rB7 = rB3;
            rB5 = rB7;
            rB rB8 = rB2;
            rB5 = rB8;
            rB rB9 = rB2;
            rB5 = rB9;
            rB5 = rB3;
            ((rw_0)object).c = ch_0.a(rB7.c, rB8.d, -rB9.c, rB5.d) / d5;
        }
        this.d = d2;
    }

    public rw_0(rB object, double d2, double d3) {
        double d4 = d2;
        rB rB2 = object;
        object = this;
        ((rw_0)object).j();
        ((rw_0)object).f = ci_0.b(d4, Math.PI);
        ((rw_0)object).a = BY.o(((rw_0)object).f);
        ((rw_0)object).b = BY.n(((rw_0)object).f);
        rB rB3 = rB2;
        rB rB4 = rB3;
        rB4 = rB2;
        ((rw_0)object).c = ch_0.a(((rw_0)object).a, rB3.d, -((rw_0)object).b, rB4.c);
        this.d = d3;
    }

    private rw_0(double d2, double d3, double d4, double d5, double d6) {
        this.f = d2;
        this.a = d3;
        this.b = d4;
        this.c = d5;
        this.d = d6;
        this.g = null;
    }

    @Deprecated
    private rw_0(rB rB2, rB rB3) {
        this(rB2, rB3, 1.0E-10);
    }

    @Deprecated
    private rw_0(rB rB2, double d2) {
        this(rB2, d2, 1.0E-10);
    }

    private rw_0(rw_0 rw_02) {
        this.f = ci_0.b(rw_02.f, Math.PI);
        this.a = rw_02.a;
        this.b = rw_02.b;
        this.c = rw_02.c;
        this.d = rw_02.d;
        this.g = null;
    }

    public final rw_0 a() {
        return new rw_0(this);
    }

    private void a(rB rB2, rB rB3) {
        this.j();
        rB rB4 = rB3;
        rB rB5 = rB4;
        rB5 = rB2;
        double d2 = rB4.c - rB5.c;
        rB rB6 = rB3;
        rB5 = rB6;
        rB5 = rB2;
        double d3 = rB6.d - rB5.d;
        double d4 = BY.f(d2, d3);
        if (d4 == 0.0) {
            this.f = 0.0;
            this.a = 1.0;
            this.b = 0.0;
            rB rB7 = rB2;
            this.c = rB7.d;
            return;
        }
        this.f = Math.PI + BY.b(-d3, -d2);
        this.a = d2 / d4;
        this.b = d3 / d4;
        rB rB8 = rB3;
        rB rB9 = rB8;
        rB rB10 = rB2;
        rB9 = rB10;
        rB rB11 = rB2;
        rB9 = rB11;
        rB9 = rB3;
        this.c = ch_0.a(rB8.c, rB10.d, -rB11.c, rB9.d) / d4;
    }

    private void a(rB rB2, double d2) {
        this.j();
        this.f = ci_0.b(d2, Math.PI);
        this.a = BY.o(this.f);
        this.b = BY.n(this.f);
        rB rB3 = rB2;
        rB rB4 = rB3;
        rB4 = rB2;
        this.c = ch_0.a(this.a, rB3.d, -this.b, rB4.c);
    }

    private void i() {
        this.j();
        this.f = this.f < Math.PI ? (this.f += Math.PI) : (this.f -= Math.PI);
        this.a = -this.a;
        this.b = -this.b;
        this.c = -this.c;
    }

    private void j() {
        if (this.g != null) {
            this.g.g = null;
        }
        this.g = null;
    }

    public final rw_0 c() {
        if (this.g == null) {
            this.g = new rw_0(this.f < Math.PI ? this.f + Math.PI : this.f - Math.PI, -this.a, -this.b, -this.c, this.d);
            this.g.g = this;
        }
        return this.g;
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    public final qZ a(rB rB2) {
        return this.e((qM<rv_0>)rB2);
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    public final rB a(qZ qZ2) {
        return this.f(qZ2);
    }

    public final qZ e(qM<rv_0> rB2) {
        rB rB3 = rB2 = (rB)rB2;
        rB rB4 = rB3;
        rB4 = rB2;
        return new qZ(ch_0.a(this.a, rB3.c, this.b, rB4.d));
    }

    public final rB f(qM<qU> qZ2) {
        qZ2 = qZ2;
        double d2 = qZ2.d;
        return new rB(ch_0.a(d2, this.a, -this.c, this.b), ch_0.a(d2, this.b, this.c, this.a));
    }

    public final rB a(rw_0 rw_02) {
        double d2;
        double d3 = ch_0.a(this.b, rw_02.a, -rw_02.b, this.a);
        if (BY.w(d2) < this.d) {
            return null;
        }
        return new rB(ch_0.a(this.a, rw_02.c, -rw_02.a, this.c) / d3, ch_0.a(this.b, rw_02.c, -rw_02.b, this.c) / d3);
    }

    @Override
    public final qM<rv_0> b(qM<rv_0> object) {
        rw_0 rw_02 = this;
        qZ qZ2 = rw_02.e((qM<rv_0>)object);
        object = rw_02;
        return rw_02.f(qZ2);
    }

    @Override
    public final double b() {
        return this.d;
    }

    public final rA d() {
        return new rA(this, new qW(this.d));
    }

    private ry_0 k() {
        return new ry_0(this.d);
    }

    public final double b(rw_0 rw_02) {
        return this.c + (ch_0.a(this.a, rw_02.a, this.b, rw_02.b) > 0.0 ? -rw_02.c : rw_02.c);
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    public final double b(rB rB2) {
        return this.a((qM<rv_0>)rB2);
    }

    @Override
    public final double a(qM<rv_0> rB2) {
        rB rB3 = rB2 = (rB)rB2;
        rB rB4 = rB3;
        rB4 = rB2;
        return ch_0.a(this.b, rB3.c, -this.a, rB4.d, 1.0, this.c);
    }

    @Override
    public final boolean a(rV<rv_0> rw_02) {
        rw_02 = rw_02;
        return ch_0.a(this.b, rw_02.b, this.a, rw_02.a) >= 0.0;
    }

    private rB a(qZ qZ2, double d2) {
        double d3 = qZ2.d;
        double d4 = d2 - this.c;
        return new rB(ch_0.a(d3, this.a, d4, this.b), ch_0.a(d3, this.b, -d4, this.a));
    }

    private boolean c(rB object) {
        rw_0 rw_02;
        rB rB2 = object;
        object = this;
        return BY.w(rw_02.a((qM<rv_0>)rB2)) < this.d;
    }

    private double d(rB object) {
        rB rB2 = object;
        object = this;
        return BY.w(((rw_0)object).a((qM<rv_0>)rB2));
    }

    private boolean g(rw_0 rw_02) {
        return BY.w(ch_0.a(this.b, rw_02.a, -this.a, rw_02.b)) < this.d;
    }

    private void e(rB rB2) {
        rB rB3 = rB2;
        rB rB4 = rB3;
        rB4 = rB2;
        this.c = ch_0.a(this.a, rB3.d, -this.b, rB4.c);
    }

    public final double h() {
        return ci_0.b(this.f, Math.PI);
    }

    private void a(double d2) {
        this.j();
        this.f = ci_0.b(d2, Math.PI);
        this.a = BY.o(this.f);
        this.b = BY.n(this.f);
    }

    private double l() {
        return this.c;
    }

    private void b(double d2) {
        this.j();
        this.c = d2;
    }

    @Deprecated
    private static sc_0<rv_0, qU> a(AffineTransform affineTransform) {
        double[] dArray = new double[6];
        affineTransform.getMatrix(dArray);
        return new a(dArray[0], dArray[1], dArray[2], dArray[3], dArray[4], dArray[5]);
    }

    public static sc_0<rv_0, qU> a(double d2, double d3, double d4, double d5, double d6, double d7) {
        return new a(d2, d3, d4, d5, d6, d7);
    }

    public final /* synthetic */ rK e() {
        rw_0 rw_02 = this;
        return new ry_0(rw_02.d);
    }

    public final /* synthetic */ rL f() {
        return this.d();
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

    static /* synthetic */ double c(rw_0 rw_02) {
        return rw_02.a;
    }

    static /* synthetic */ double d(rw_0 rw_02) {
        return rw_02.b;
    }

    static /* synthetic */ double e(rw_0 rw_02) {
        return rw_02.c;
    }

    static /* synthetic */ double f(rw_0 rw_02) {
        return rw_02.d;
    }

    /* synthetic */ rw_0(double d2, double d3, double d4, double d5, double d6, byte by) {
        this(d2, d3, d4, d5, d6);
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    static final class a
    implements sc_0<rv_0, qU> {
        private double a;
        private double b;
        private double c;
        private double d;
        private double e;
        private double f;
        private double g;
        private double h;
        private double i;

        a(double d2, double d3, double d4, double d5, double d6, double d7) {
            this.a = d2;
            this.b = d3;
            this.c = d4;
            this.d = d5;
            this.e = d6;
            this.f = d7;
            this.g = ch_0.a(d4, d7, -d5, d6);
            this.h = ch_0.a(d2, d7, -d3, d6);
            this.i = ch_0.a(d2, d5, -d3, d4);
            if (BY.w(this.i) < 1.0E-20) {
                throw new oV(px_0.NON_INVERTIBLE_TRANSFORM, new Object[0]);
            }
        }

        private rB b(qM<rv_0> rB2) {
            rB rB3 = rB2 = (rB)rB2;
            double d2 = rB2.c;
            rB3 = rB2;
            double d3 = rB3.d;
            return new rB(ch_0.a(this.a, d2, this.c, d3, this.e, 1.0), ch_0.a(this.b, d2, this.d, d3, this.f, 1.0));
        }

        private rw_0 b(rV<rv_0> rw2) {
            double d2;
            rw rw3 = rw2 = (rw)rw2;
            rw rw4 = rw3;
            rw rw5 = rw2;
            rw4 = rw5;
            rw4 = rw2;
            double d3 = ch_0.a(this.h, rw3.a, this.g, rw5.b, this.i, rw4.c);
            rw rw6 = rw2;
            rw4 = rw6;
            rw4 = rw2;
            double d4 = ch_0.a(this.a, rw6.a, this.c, rw4.b);
            rw rw7 = rw2;
            rw4 = rw7;
            rw4 = rw2;
            double d5 = d2 = ch_0.a(this.b, rw7.a, this.d, rw4.b);
            double d6 = d4;
            double d7 = 1.0 / BY.a(d5 * d5 + d6 * d6);
            rw4 = rw2;
            return new rw(Math.PI + BY.b(-d2, -d4), d7 * d4, d7 * d2, d7 * d3, rw4.d, 0);
        }

        @Override
        public final sb_0<qU> a(sb_0<qU> object, rV<rv_0> rw2, rV<rv_0> object2) {
            object = (qX)object.c();
            rw2 = rw2;
            rw rw3 = object2;
            object2 = rw3;
            object2 = object;
            qO<qU> qO2 = object2.a;
            object2 = rw2;
            qO2 = this.b(object2.f((qM)qO2));
            object2 = rw3;
            Object object3 = object2 = rw3.e((qM)qO2);
            Object object4 = object;
            object2 = object4;
            object2 = rw2;
            return new qX((qZ)object3, ((qX)object4).b, object2.d).a();
        }

        @Override
        public final /* synthetic */ rV a(rV object) {
            double d2;
            rV rV2 = object;
            object = this;
            rV rV3 = rV2 = (rw)rV2;
            rV rV4 = rV3;
            rV rV5 = rV2;
            rV4 = rV5;
            rV4 = rV2;
            double d3 = ch_0.a(((a)object).h, ((rw)rV3).a, ((a)object).g, ((rw)rV5).b, ((a)object).i, ((rw)rV4).c);
            rV rV6 = rV2;
            rV4 = rV6;
            rV4 = rV2;
            double d4 = ch_0.a(((a)object).a, ((rw)rV6).a, ((a)object).c, ((rw)rV4).b);
            rV rV7 = rV2;
            rV4 = rV7;
            rV4 = rV2;
            double d5 = d2 = ch_0.a(((a)object).b, ((rw)rV7).a, ((a)object).d, ((rw)rV4).b);
            double d6 = d4;
            double d7 = 1.0 / BY.a(d5 * d5 + d6 * d6);
            rV4 = rV2;
            return new rw(Math.PI + BY.b(-d2, -d4), d7 * d4, d7 * d2, d7 * d3, ((rw)rV4).d, 0);
        }

        @Override
        public final /* synthetic */ qM a(qM qM2) {
            return this.b(qM2);
        }
    }
}

