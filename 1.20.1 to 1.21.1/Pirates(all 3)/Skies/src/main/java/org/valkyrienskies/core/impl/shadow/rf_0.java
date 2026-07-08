/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.cq_0;
import org.valkyrienskies.core.impl.shadow.oV;
import org.valkyrienskies.core.impl.shadow.px_0;
import org.valkyrienskies.core.impl.shadow.qM;
import org.valkyrienskies.core.impl.shadow.qO;
import org.valkyrienskies.core.impl.shadow.qU;
import org.valkyrienskies.core.impl.shadow.qW;
import org.valkyrienskies.core.impl.shadow.qZ;
import org.valkyrienskies.core.impl.shadow.rU;
import org.valkyrienskies.core.impl.shadow.rc_0;
import org.valkyrienskies.core.impl.shadow.rq_0;
import org.valkyrienskies.core.impl.shadow.rs_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.rf
 */
public final class rf_0
implements rU<rc_0, qU> {
    private static final double d = 1.0E-10;
    rs_0 a;
    rs_0 b;
    final double c;

    public rf_0(rs_0 object, rs_0 rs_02, double d2) {
        rs_0 rs_03 = rs_02;
        rs_02 = object;
        object = this;
        rs_03 = rs_03.h(rs_02);
        double d3 = rs_03.f();
        if (d3 == 0.0) {
            throw new oV(px_0.ZERO_NORM, new Object[0]);
        }
        ((rf_0)object).a = new rs_0(1.0 / BY.a(d3), rs_03);
        rs_0 rs_04 = rs_02;
        ((rf_0)object).b = new rs_0(1.0, rs_04, -rs_04.f(rs_03) / d3, rs_03);
        this.c = d2;
    }

    private rf_0(rf_0 rf_02) {
        this.a = rf_02.a;
        this.b = rf_02.b;
        this.c = rf_02.c;
    }

    @Deprecated
    private rf_0(rs_0 rs_02, rs_0 rs_03) {
        this(rs_02, rs_03, 1.0E-10);
    }

    private void a(rs_0 rs_02, rs_0 rs_03) {
        double d2 = (rs_03 = rs_03.h(rs_02)).f();
        if (d2 == 0.0) {
            throw new oV(px_0.ZERO_NORM, new Object[0]);
        }
        this.a = new rs_0(1.0 / BY.a(d2), rs_03);
        rs_0 rs_04 = rs_02;
        this.b = new rs_0(1.0, rs_04, -rs_04.f(rs_03) / d2, rs_03);
    }

    public final double a() {
        return this.c;
    }

    private rf_0 c() {
        rf_0 rf_02 = new rf_0(this);
        new rf_0(this).a = rf_02.a.q();
        return rf_02;
    }

    public final rs_0 b() {
        return this.a;
    }

    private rs_0 d() {
        return this.b;
    }

    public final double a(rs_0 rs_02) {
        return rs_02.h(this.b).f(this.a);
    }

    private rs_0 a(double d2) {
        return new rs_0(1.0, this.b, d2, this.a);
    }

    private qZ a(qO<rc_0> qO2) {
        return this.a((qM<rc_0>)qO2);
    }

    private rs_0 b(qO<qU> qO2) {
        return this.b((qM<qU>)qO2);
    }

    public final qZ a(qM<rc_0> qM2) {
        return new qZ(this.a((rs_0)qM2));
    }

    public final rs_0 b(qM<qU> qZ2) {
        qZ2 = qZ2;
        return this.a(qZ2.d);
    }

    private boolean b(rf_0 rf_02) {
        double d2 = rs_0.a(this.a, rf_02.a);
        return (d2 < this.c || d2 > Math.PI - this.c) && this.b(rf_02.b);
    }

    public final boolean b(rs_0 rs_02) {
        return this.c(rs_02) < this.c;
    }

    private double c(rs_0 rs_02) {
        rs_0 rs_03 = rs_02 = rs_02.h(this.b);
        rs_02 = new rs_0(1.0, rs_03, -rs_03.f(this.a), this.a);
        return rs_02.e();
    }

    private double c(rf_0 rf_02) {
        double d2;
        rs_0 rs_02 = rs_0.c(this.a, rf_02.a);
        double d3 = rs_02.e();
        if (d2 < cq_0.b) {
            return this.c(rf_02.b);
        }
        double d4 = rf_02.b.h(this.b).f(rs_02) / d3;
        return BY.w(d4);
    }

    private rs_0 d(rf_0 rf_02) {
        double d2;
        double d3;
        double d4 = d3 = this.a.f(rf_02.a);
        double d5 = 1.0 - d4 * d4;
        if (d2 < cq_0.a) {
            return this.b;
        }
        rs_0 rs_02 = rf_02.b.h(this.b);
        double d6 = rs_02.f(this.a);
        double d7 = rs_02.f(rf_02.a);
        return new rs_0(1.0, this.b, (d6 - d7 * d3) / d5, this.a);
    }

    public final rs_0 a(rf_0 rf_02) {
        Object object;
        double d2;
        double d3;
        rf_0 rf_03 = rf_02;
        Object object2 = this;
        double d4 = d3 = ((rf_0)object2).a.f(rf_03.a);
        double d5 = 1.0 - d4 * d4;
        if (d2 < cq_0.a) {
            object = ((rf_0)object2).b;
        } else {
            rs_0 rs_02 = rf_03.b.h(((rf_0)object2).b);
            double d6 = rs_02.f(((rf_0)object2).a);
            double d7 = rs_02.f(rf_03.a);
            object = object2 = new rs_0(1.0, ((rf_0)object2).b, (d6 - d7 * d3) / d5, ((rf_0)object2).a);
        }
        if (rf_02.b((rs_0)object2)) {
            return object2;
        }
        return null;
    }

    private rq_0 e() {
        return new rq_0(this, new qW(this.c));
    }

    @Override
    public final /* synthetic */ qM c(qM qM2) {
        return this.b(qM2);
    }

    @Override
    public final /* synthetic */ qM d(qM qM2) {
        return this.a(qM2);
    }
}

