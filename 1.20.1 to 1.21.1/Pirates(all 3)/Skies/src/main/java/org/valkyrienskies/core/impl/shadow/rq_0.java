/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.ArrayList;
import java.util.List;
import org.valkyrienskies.core.impl.shadow.cq_0;
import org.valkyrienskies.core.impl.shadow.qM;
import org.valkyrienskies.core.impl.shadow.qV;
import org.valkyrienskies.core.impl.shadow.qW;
import org.valkyrienskies.core.impl.shadow.qZ;
import org.valkyrienskies.core.impl.shadow.rY;
import org.valkyrienskies.core.impl.shadow.rc_0;
import org.valkyrienskies.core.impl.shadow.rf_0;
import org.valkyrienskies.core.impl.shadow.rn_0;
import org.valkyrienskies.core.impl.shadow.rs_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.rq
 */
public final class rq_0 {
    private static final double a = 1.0E-10;
    private final rf_0 b;
    private final qW c;

    public rq_0(rf_0 rf_02, qW qW2) {
        this.b = rf_02;
        this.c = qW2;
    }

    private rq_0(rs_0 rs_02, rs_0 rs_03, double d2) {
        this(new rf_0(rs_02, rs_03, 1.0E-10), rq_0.a(rs_02, rs_03, 1.0E-10));
    }

    private rq_0(rs_0 rs_02, rs_0 rs_03) {
        this(rs_02, rs_03, 1.0E-10);
    }

    private rq_0(rn_0 rn_02) {
        rn_0 rn_03 = rn_02;
        Object object = rn_03;
        rn_0 rn_04 = rn_02;
        object = rn_04;
        rn_0 rn_05 = rn_02;
        object = rn_05;
        object = rn_02;
        object = ((rn_0)object).c;
        this(rn_03.c, rq_0.a(rn_04.a, rn_05.b, ((rf_0)object).c));
    }

    private List<rn_0> a() {
        Object object = this.c.b();
        ArrayList<rn_0> arrayList = new ArrayList<rn_0>(object.size());
        object = object.iterator();
        while (object.hasNext()) {
            Object object2 = (qV)object.next();
            qV qV2 = object2;
            rs_0 rs_02 = this.b.b(new qZ(qV2.a));
            qV2 = object2;
            object2 = this.b.b(new qZ(qV2.b));
            arrayList.add(new rn_0(rs_02, (rs_0)object2, this.b));
        }
        return arrayList;
    }

    private rs_0 a(rq_0 rq_02, boolean bl) {
        Object object;
        double d2;
        double d3;
        rf_0 rf_02 = this.b;
        rf_0 rf_03 = rq_02.b;
        Object object2 = rf_02;
        rf_0 rf_04 = rf_03;
        object2 = rf_02;
        double d4 = d3 = rf_02.a.f(rf_04.a);
        double d5 = 1.0 - d4 * d4;
        if (d2 < cq_0.a) {
            object = ((rf_0)object2).b;
        } else {
            rs_0 rs_02 = rf_04.b.h(((rf_0)object2).b);
            double d6 = rs_02.f(((rf_0)object2).a);
            double d7 = rs_02.f(rf_04.a);
            object = object2 = new rs_0(1.0, ((rf_0)object2).b, (d6 - d7 * d3) / d5, ((rf_0)object2).a);
        }
        if ((object2 = rf_03.b((rs_0)object2) ? object2 : null) == null) {
            return null;
        }
        int n2 = this.c.b(this.b.a((qM<rc_0>)object2));
        int n3 = rq_02.c.b(rq_02.b.a((qM<rc_0>)object2));
        if (bl) {
            if (n2 != rY.a.OUTSIDE$3ad793e5 && n3 != rY.a.OUTSIDE$3ad793e5) {
                return object2;
            }
            return null;
        }
        if (n2 == rY.a.INSIDE$3ad793e5 && n3 == rY.a.INSIDE$3ad793e5) {
            return object2;
        }
        return null;
    }

    private static qW a(rs_0 qO2, rs_0 rs_02, double d2) {
        rf_0 rf_02 = new rf_0((rs_0)qO2, rs_02, d2);
        qZ qZ2 = rf_02.a((qM<rc_0>)qO2);
        qO2 = qZ2;
        qO2 = rf_02.a((qM<rc_0>)rs_02);
        return new qW(qZ2.d, ((qZ)qO2).d, d2);
    }
}

