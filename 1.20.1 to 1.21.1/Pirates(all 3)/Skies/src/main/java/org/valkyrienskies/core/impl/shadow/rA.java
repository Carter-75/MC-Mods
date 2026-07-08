/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.ArrayList;
import java.util.List;
import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.ch_0;
import org.valkyrienskies.core.impl.shadow.qM;
import org.valkyrienskies.core.impl.shadow.qU;
import org.valkyrienskies.core.impl.shadow.qV;
import org.valkyrienskies.core.impl.shadow.qW;
import org.valkyrienskies.core.impl.shadow.qX;
import org.valkyrienskies.core.impl.shadow.qZ;
import org.valkyrienskies.core.impl.shadow.rB;
import org.valkyrienskies.core.impl.shadow.rL;
import org.valkyrienskies.core.impl.shadow.rM;
import org.valkyrienskies.core.impl.shadow.rV;
import org.valkyrienskies.core.impl.shadow.rY;
import org.valkyrienskies.core.impl.shadow.rv_0;
import org.valkyrienskies.core.impl.shadow.rw_0;
import org.valkyrienskies.core.impl.shadow.rz_0;
import org.valkyrienskies.core.impl.shadow.sb_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public final class rA
extends rL<rv_0, qU> {
    private static final double c = 1.0E-10;

    public rA(rV<rv_0> rV2, rY<qU> rY2) {
        super(rV2, rY2);
    }

    private rA(rB rB2, rB rB3, double d2) {
        super(new rw_0(rB2, rB3, 1.0E-10), rA.a(rB2, rB3, 1.0E-10));
    }

    @Deprecated
    private rA(rB rB2, rB rB3) {
        this(rB2, rB3, 1.0E-10);
    }

    private rA(rz_0 rz_02) {
        rz_0 rz_03 = rz_02;
        Object object = rz_03;
        rz_0 rz_04 = rz_02;
        object = rz_04;
        rz_0 rz_05 = rz_02;
        object = rz_05;
        object = rz_02;
        object = ((rz_0)object).i;
        super(rz_03.i, rA.a(rz_04.g, rz_05.h, ((rw_0)object).d));
    }

    private List<rz_0> f() {
        rw_0 rw_02 = (rw_0)this.c();
        Object object = ((qW)this.d()).b();
        ArrayList<rz_0> arrayList = new ArrayList<rz_0>(object.size());
        object = object.iterator();
        while (object.hasNext()) {
            Object object2 = (qV)object.next();
            qV qV2 = object2;
            rB rB2 = rw_02.f(new qZ(qV2.a));
            qV2 = object2;
            object2 = rw_02.f(new qZ(qV2.b));
            arrayList.add(new rz_0(rB2, (rB)object2, rw_02));
        }
        return arrayList;
    }

    private rB a(rA rA2, boolean bl) {
        rw_0 rw_02;
        rw_0 rw_03 = (rw_0)this.c();
        rB rB2 = rw_03.a(rw_02 = (rw_0)rA2.c());
        if (rB2 == null) {
            return null;
        }
        int n2 = this.d().b(rw_03.e((qM<rv_0>)rB2));
        int n3 = rA2.d().b(rw_02.e((qM<rv_0>)rB2));
        if (bl) {
            if (n2 != rY.a.OUTSIDE$3ad793e5 && n3 != rY.a.OUTSIDE$3ad793e5) {
                return rB2;
            }
            return null;
        }
        if (n2 == rY.a.INSIDE$3ad793e5 && n3 == rY.a.INSIDE$3ad793e5) {
            return rB2;
        }
        return null;
    }

    private static qW a(rB qO2, rB rB2, double d2) {
        rw_0 rw_02 = new rw_0((rB)qO2, rB2, d2);
        qZ qZ2 = rw_02.e((qM<rv_0>)qO2);
        qO2 = qZ2;
        qO2 = rw_02.e((qM<rv_0>)rB2);
        return new qW(qZ2.d, ((qZ)qO2).d, d2);
    }

    @Override
    public final rL<rv_0, qU> a(rV<rv_0> rV2, rY<qU> rY2) {
        return new rA(rV2, rY2);
    }

    @Override
    public final sb_0.a<rv_0> a(rV<rv_0> rM2) {
        rM<qU> rM3;
        rM<qU> rM4;
        rM rM5;
        rw_0 rw_02 = (rw_0)this.c();
        rM2 = (rw_0)((Object)rM2);
        rM<qU> rM6 = rw_02.a((rw_0)((Object)rM2));
        rw_0 rw_03 = rw_02;
        double d2 = rw_03.d;
        if (rM6 == null) {
            double d3;
            double d4 = ((rw_0)((Object)rM2)).c + (ch_0.a(((rw_0)((Object)rM2)).a, rw_02.a, ((rw_0)((Object)rM2)).b, rw_02.b) > 0.0 ? -rw_02.c : rw_02.c);
            if (d3 < -d2) {
                return new sb_0.a<rv_0>(null, this);
            }
            if (d4 > d2) {
                return new sb_0.a<rv_0>(this, null);
            }
            return new sb_0.a<rv_0>(null, null);
        }
        boolean bl = BY.n(rw_02.h() - ((rw_0)((Object)rM2)).h()) < 0.0;
        qZ qZ2 = rw_02.e((qM<rv_0>)((Object)rM6));
        rM2 = new qX(qZ2, !bl, d2).a();
        rM6 = new qX(qZ2, bl, d2).a();
        rM rM7 = rM5 = this.d().a(false).a(rM6);
        if (this.d().c(rM7.b)) {
            rM4 = new rM<qU>(Boolean.FALSE);
        } else {
            rM7 = rM5;
            rM4 = new rM(rM2, new rM(Boolean.FALSE), rM7.b, null);
        }
        rM2 = rM4;
        rM7 = rM5;
        if (this.d().c(rM7.c)) {
            rM3 = new rM<qU>(Boolean.FALSE);
        } else {
            rM7 = rM5;
            rM3 = new rM(rM6, new rM(Boolean.FALSE), rM7.c, null);
        }
        rM6 = rM3;
        return new sb_0.a<rv_0>(new rA(rw_02.a(), new qW(rM2, d2)), new rA(rw_02.a(), new qW(rM6, d2)));
    }
}

