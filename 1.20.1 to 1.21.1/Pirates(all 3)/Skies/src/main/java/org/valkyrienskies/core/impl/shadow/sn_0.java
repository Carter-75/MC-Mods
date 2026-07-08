/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import org.valkyrienskies.core.impl.shadow.oX;
import org.valkyrienskies.core.impl.shadow.px_0;
import org.valkyrienskies.core.impl.shadow.qM;
import org.valkyrienskies.core.impl.shadow.rL;
import org.valkyrienskies.core.impl.shadow.rM;
import org.valkyrienskies.core.impl.shadow.rN;
import org.valkyrienskies.core.impl.shadow.rO;
import org.valkyrienskies.core.impl.shadow.rs_0;
import org.valkyrienskies.core.impl.shadow.sf_0;
import org.valkyrienskies.core.impl.shadow.sg_0;
import org.valkyrienskies.core.impl.shadow.si_0;
import org.valkyrienskies.core.impl.shadow.sl_0;
import org.valkyrienskies.core.impl.shadow.sm_0;
import org.valkyrienskies.core.impl.shadow.sp_0;
import org.valkyrienskies.core.impl.shadow.sq_0;
import org.valkyrienskies.core.impl.shadow.ss_0;
import org.valkyrienskies.core.impl.shadow.st_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.sn
 */
final class sn_0
implements rN<sq_0> {
    private final rM<sq_0> a;
    private final double b;
    private final Map<sm_0, rM<sq_0>> c;
    private final Map<rM<sq_0>, List<sm_0>> d;

    sn_0(rM<sq_0> rM2, double d2) {
        this.a = rM2;
        this.b = d2;
        this.c = new IdentityHashMap<sm_0, rM<sq_0>>();
        this.d = new IdentityHashMap<rM<sq_0>, List<sm_0>>();
    }

    @Override
    public final int a(rM<sq_0> rM2) {
        return rN.a.MINUS_SUB_PLUS$672d2271;
    }

    @Override
    public final void b(rM<sq_0> rM2) {
        this.d.put(rM2, new ArrayList());
        Object object = rM2;
        rO rO2 = (rO)((rM)object).e;
        object = rO2;
        if (rO2.a != null) {
            object = rO2;
            this.a((ss_0)((rO)object).a, false, rM2);
        }
        object = rO2;
        if (((rO)object).b != null) {
            object = rO2;
            this.a((ss_0)((rO)object).b, true, rM2);
        }
    }

    @Override
    public final void c(rM<sq_0> rM2) {
    }

    private void a(ss_0 iterator2, boolean bl, rM<sq_0> rM2) {
        Object object = iterator2;
        sl_0 sl_02 = (sl_0)((rL)object).a;
        object = iterator2;
        iterator2 = ((sg_0)((rL)object).b).b();
        iterator2 = iterator2.iterator();
        while (iterator2.hasNext()) {
            Object object2;
            object = object2 = iterator2.next();
            st_0 st_02 = new st_0(sl_02.e(new si_0(((sf_0)object).a)));
            object = object2;
            object = new st_0(sl_02.e(new si_0(((sf_0)object).b)));
            st_02.a(sl_02);
            ((st_0)object).a(sl_02);
            object2 = bl ? new sm_0((st_0)object, st_02, ((sf_0)object2).c(), sl_02.c()) : new sm_0(st_02, (st_0)object, ((sf_0)object2).c(), sl_02);
            this.c.put((sm_0)object2, rM2);
            this.d.get(rM2).add((sm_0)object2);
        }
    }

    private sm_0 a(sm_0 sm_02) {
        Object object = sm_02;
        object = ((sm_0)object).b;
        sp_0 sp_02 = ((st_0)object).a;
        double d2 = this.b;
        Object object2 = sp_02;
        Object object3 = this.a;
        ArrayList arrayList = new ArrayList();
        ((rM)object3).a((qM<sq_0>)object2, d2, arrayList);
        object2 = arrayList;
        double d3 = this.b;
        sm_0 sm_03 = null;
        object2 = object2.iterator();
        while (object2.hasNext()) {
            rM rM2 = (rM)object2.next();
            for (sm_0 sm_04 : this.d.get(rM2)) {
                double d4;
                if (sm_04 == sm_02) continue;
                object = sm_04;
                object3 = ((sm_0)object).a;
                if (((st_0)object3).b != null) continue;
                object = sm_04;
                object = ((sm_0)object).a;
                object = ((st_0)object).a;
                object3 = ((sp_0)object).c;
                object = sp_02;
                double d5 = rs_0.a(((sp_0)object).c, (rs_0)object3);
                if (!(d4 <= d3)) continue;
                d3 = d5;
                sm_03 = sm_04;
            }
        }
        if (sm_03 == null) {
            sp_0 sp_03;
            object = sm_02;
            object = ((sm_0)object).a;
            object = ((st_0)object).a;
            object2 = ((sp_0)object).c;
            object = sp_02;
            if (rs_0.a(sp_03.c, (rs_0)object2) <= this.b) {
                return sm_02;
            }
            throw new oX(px_0.OUTLINE_BOUNDARY_LOOP_OPEN, new Object[0]);
        }
        return sm_03;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final List<sm_0> a() {
        for (sm_0 sm_02 : this.c.keySet()) {
            Object object;
            Object object2;
            Object object3 = object2 = sm_02;
            object2 = this;
            Object object4 = object3;
            object4 = ((sm_0)object4).b;
            sp_0 sp_02 = ((st_0)object4).a;
            double d2 = ((sn_0)object2).b;
            Object object5 = sp_02;
            Object object6 = ((sn_0)object2).a;
            Object object7 = new ArrayList();
            ((rM)object6).a((qM<sq_0>)object5, d2, object7);
            object5 = object7;
            double d3 = ((sn_0)object2).b;
            object7 = null;
            object5 = object5.iterator();
            while (object5.hasNext()) {
                rM rM2 = (rM)object5.next();
                for (sm_0 sm_03 : ((sn_0)object2).d.get(rM2)) {
                    double d4;
                    if (sm_03 == object3) continue;
                    object4 = sm_03;
                    object6 = ((sm_0)object4).a;
                    if (((st_0)object6).b != null) continue;
                    object4 = sm_03;
                    object4 = ((sm_0)object4).a;
                    object4 = ((st_0)object4).a;
                    object6 = ((sp_0)object4).c;
                    object4 = sp_02;
                    double d5 = rs_0.a(((sp_0)object4).c, (rs_0)object6);
                    if (!(d4 <= d3)) continue;
                    d3 = d5;
                    object7 = sm_03;
                }
            }
            if (object7 == null) {
                sp_0 sp_03;
                object4 = object3;
                object4 = ((sm_0)object4).a;
                object4 = ((st_0)object4).a;
                object5 = ((sp_0)object4).c;
                object4 = sp_02;
                if (!(rs_0.a(sp_03.c, (rs_0)object5) <= ((sn_0)object2).b)) throw new oX(px_0.OUTLINE_BOUNDARY_LOOP_OPEN, new Object[0]);
                object = object3;
            } else {
                object = object7;
            }
            object3 = object;
            object2 = sm_02;
            object4 = object3;
            sm_02.b = ((sm_0)object4).a;
            ((sm_0)object2).b.a((sm_0)object2);
            object4 = object2;
            ((sm_0)object2).b.a(((sm_0)object4).d);
        }
        return new ArrayList<sm_0>(this.c.keySet());
    }
}

