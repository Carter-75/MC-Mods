/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.qM;
import org.valkyrienskies.core.impl.shadow.qZ;
import org.valkyrienskies.core.impl.shadow.rB;
import org.valkyrienskies.core.impl.shadow.rL;
import org.valkyrienskies.core.impl.shadow.rM;
import org.valkyrienskies.core.impl.shadow.rV;
import org.valkyrienskies.core.impl.shadow.rY;
import org.valkyrienskies.core.impl.shadow.rc_0;
import org.valkyrienskies.core.impl.shadow.rf_0;
import org.valkyrienskies.core.impl.shadow.ri_0;
import org.valkyrienskies.core.impl.shadow.rs_0;
import org.valkyrienskies.core.impl.shadow.rv_0;
import org.valkyrienskies.core.impl.shadow.rw_0;
import org.valkyrienskies.core.impl.shadow.ry_0;
import org.valkyrienskies.core.impl.shadow.sb_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.rr
 */
public final class rr_0
extends rL<rc_0, rv_0> {
    public rr_0(rV<rc_0> rV2, rY<rv_0> rY2) {
        super(rV2, rY2);
    }

    @Override
    public final rL<rc_0, rv_0> a(rV<rc_0> rV2, rY<rv_0> rY2) {
        return new rr_0(rV2, rY2);
    }

    @Override
    public final sb_0.a<rc_0> a(rV<rc_0> rM2) {
        rM<rv_0> rM3;
        rM<rv_0> rM4;
        ri_0 ri_02;
        rs_0 rs_02;
        Object object;
        Object object2;
        rf_0 rf_02;
        rs_0 rs_03;
        rM2 = (ri_0)((Object)rM2);
        ri_0 ri_03 = (ri_0)this.c();
        Object object3 = ri_03;
        rM<rv_0> rM5 = rM2;
        rs_0 rs_04 = rs_0.c(((ri_0)((Object)rM5)).e, ((ri_0)object3).e);
        if (rs_03.e() < ((ri_0)((Object)rM5)).f) {
            rf_02 = null;
        } else {
            rs_0 rs_05;
            double d2;
            object2 = new ri_0(rs_04, ((ri_0)((Object)rM5)).f);
            ri_0 ri_04 = object3;
            object3 = rM5;
            object = ((ri_0)object3).e;
            double d3 = ((rs_0)object).i;
            object = ((ri_0)object3).e;
            double d4 = ((rs_0)object).j;
            object = ((ri_0)object3).e;
            double d5 = ((rs_0)object).k;
            double d6 = ((ri_0)object3).a;
            object = ri_04.e;
            double d7 = ((rs_0)object).i;
            object = ri_04.e;
            double d8 = ((rs_0)object).j;
            object = ri_04.e;
            double d9 = ((rs_0)object).k;
            double d10 = ri_04.a;
            object = ((ri_0)object2).e;
            double d11 = ((rs_0)object).i;
            object = ((ri_0)object2).e;
            double d12 = ((rs_0)object).j;
            object = ((ri_0)object2).e;
            double d13 = ((rs_0)object).k;
            double d14 = ((ri_0)object2).a;
            double d15 = d8 * d13 - d12 * d9;
            double d16 = d9 * d11 - d13 * d7;
            double d17 = d7 * d12 - d11 * d8;
            double d18 = d3 * d15 + d4 * d16 + d5 * d17;
            if (BY.w(d2) < 1.0E-10) {
                rs_05 = null;
            } else {
                double d19 = 1.0 / d18;
                rs_05 = new rs_0((-d15 * d6 - (d5 * d12 - d13 * d4) * d10 - (d9 * d4 - d5 * d8) * d14) * d19, (-d16 * d6 - (d13 * d3 - d5 * d11) * d10 - (d5 * d7 - d9 * d3) * d14) * d19, (-d17 * d6 - (d4 * d11 - d12 * d3) * d10 - (d8 * d3 - d4 * d7) * d14) * d19);
            }
            Object object4 = object3 = rs_05;
            rf_02 = new rf_0((rs_0)object4, ((rs_0)object4).g(rs_04), ((ri_0)((Object)rM5)).f);
        }
        rM5 = rf_02;
        object = ri_03;
        double d20 = ((ri_0)object).f;
        if (rM5 == null) {
            double d21;
            object3 = ri_03;
            rM5 = rM2;
            double d22 = ((ri_0)((Object)rM5)).a + (((ri_0)((Object)rM5)).a((rV<rc_0>)object3) ? -((ri_0)object3).a : ((ri_0)object3).a);
            if (d21 < -d20) {
                return new sb_0.a<rc_0>(null, this);
            }
            if (d22 > d20) {
                return new sb_0.a<rc_0>(this, null);
            }
            return new sb_0.a<rc_0>(null, null);
        }
        object2 = ri_03.e((qM<rc_0>)((rf_0)((Object)rM5)).b(qZ.a));
        Object object5 = ri_03.e((qM<rc_0>)((rf_0)((Object)rM5)).b(qZ.b));
        ri_0 ri_05 = rM5;
        object = ri_05;
        object = ri_03;
        rM5 = rs_0.c(((rf_0)((Object)ri_05)).a, ((ri_0)object).e);
        object = rM2;
        if (rs_02.f(ri_02.e) < 0.0) {
            rM2 = object2;
            object2 = object5;
            object5 = rM2;
        }
        rM2 = new rw_0((rB)object2, (rB)object5, d20).d();
        rM5 = new rw_0((rB)object5, (rB)object2, d20).d();
        object = object3 = this.d().a(false).a(rM2);
        if (this.d().c(((rM)object).b)) {
            rM4 = new rM<rv_0>(Boolean.FALSE);
        } else {
            object = object3;
            rM4 = new rM(rM5, new rM(Boolean.FALSE), ((rM)object).b, null);
        }
        rM5 = rM4;
        object = object3;
        if (this.d().c(((rM)object).c)) {
            rM3 = new rM<rv_0>(Boolean.FALSE);
        } else {
            object = object3;
            rM3 = new rM(rM2, new rM(Boolean.FALSE), ((rM)object).c, null);
        }
        rM2 = rM3;
        return new sb_0.a<rc_0>(new rr_0(ri_03.a(), new ry_0(rM5, d20)), new rr_0(ri_03.a(), new ry_0(rM2, d20)));
    }
}

