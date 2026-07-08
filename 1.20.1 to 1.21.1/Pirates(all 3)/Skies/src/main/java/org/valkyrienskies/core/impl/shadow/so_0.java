/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.ArrayList;
import java.util.List;
import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.oY;
import org.valkyrienskies.core.impl.shadow.rM;
import org.valkyrienskies.core.impl.shadow.rN;
import org.valkyrienskies.core.impl.shadow.rs_0;
import org.valkyrienskies.core.impl.shadow.sl_0;
import org.valkyrienskies.core.impl.shadow.sm_0;
import org.valkyrienskies.core.impl.shadow.sp_0;
import org.valkyrienskies.core.impl.shadow.sq_0;
import org.valkyrienskies.core.impl.shadow.sr_0;
import org.valkyrienskies.core.impl.shadow.st_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.so
 */
final class so_0
implements rN<sq_0> {
    private final double d;
    double a;
    rs_0 b;
    final List<rs_0> c;

    so_0(double d2) {
        this.d = d2;
        this.a = 0.0;
        this.b = rs_0.a;
        this.c = new ArrayList<rs_0>();
    }

    @Override
    public final int a(rM<sq_0> rM2) {
        return rN.a.MINUS_SUB_PLUS$672d2271;
    }

    @Override
    public final void b(rM<sq_0> rM2) {
    }

    @Override
    public final void c(rM<sq_0> object) {
        Object object2 = object;
        if (((Boolean)((rM)object2).e).booleanValue()) {
            object = new sr_0(((rM)object).a(Boolean.TRUE, Boolean.FALSE, null), this.d);
            if ((object = ((sr_0)object).b()).size() != 1) {
                throw new oY();
            }
            st_0 st_02 = object.get(0);
            int n2 = 0;
            double d2 = 0.0;
            object2 = st_02;
            sm_0 sm_02 = ((st_0)object2).c;
            while (true) {
                double d3;
                if (n2 != 0) {
                    object2 = sm_02;
                    if (((sm_0)object2).a == st_02) break;
                }
                object2 = sm_02;
                object2 = ((sm_0)object2).d;
                rs_0 rs_02 = ((sl_0)object2).a;
                object2 = sm_02;
                object2 = ((sm_0)object2).b;
                object2 = ((st_0)object2).c;
                object2 = ((sm_0)object2).d;
                rs_0 rs_03 = ((sl_0)object2).a;
                object2 = sm_02;
                object2 = ((sm_0)object2).b;
                object2 = ((st_0)object2).a;
                object2 = ((sp_0)object2).c;
                double d4 = BY.b(rs_0.b(rs_03, rs_0.c((rs_0)object2, rs_02)), -rs_0.b(rs_03, rs_02));
                if (d3 < 0.0) {
                    d4 += Math.PI * 2;
                }
                d2 += d4;
                ++n2;
                object2 = sm_02;
                object2 = ((sm_0)object2).b;
                sm_02 = ((st_0)object2).c;
            }
            double d5 = d2 - (double)(n2 - 2) * Math.PI;
            st_02 = object.get(0);
            n2 = 0;
            rs_0 rs_04 = rs_0.a;
            object2 = st_02;
            sm_0 sm_03 = ((st_0)object2).c;
            while (true) {
                if (n2 != 0) {
                    object2 = sm_03;
                    if (((sm_0)object2).a == st_02) break;
                }
                sm_02 = sm_03;
                object2 = sm_03;
                object2 = ((sm_0)object2).d;
                rs_04 = new rs_0(1.0, rs_04, sm_02.c, ((sl_0)object2).a);
                ++n2;
                object2 = sm_03;
                object2 = ((sm_0)object2).b;
                sm_03 = ((st_0)object2).c;
            }
            object = rs_04.o();
            this.c.add((rs_0)object);
            this.a += d5;
            this.b = new rs_0(1.0, this.b, d5, (rs_0)object);
        }
    }

    private static double a(st_0 st_02) {
        int n2 = 0;
        double d2 = 0.0;
        Object object = st_02;
        sm_0 sm_02 = ((st_0)object).c;
        while (true) {
            double d3;
            if (n2 != 0) {
                object = sm_02;
                if (((sm_0)object).a == st_02) break;
            }
            object = sm_02;
            object = ((sm_0)object).d;
            rs_0 rs_02 = ((sl_0)object).a;
            object = sm_02;
            object = ((sm_0)object).b;
            object = ((st_0)object).c;
            object = ((sm_0)object).d;
            rs_0 rs_03 = ((sl_0)object).a;
            object = sm_02;
            object = ((sm_0)object).b;
            object = ((st_0)object).a;
            object = ((sp_0)object).c;
            double d4 = BY.b(rs_0.b(rs_03, rs_0.c((rs_0)object, rs_02)), -rs_0.b(rs_03, rs_02));
            if (d3 < 0.0) {
                d4 += Math.PI * 2;
            }
            d2 += d4;
            ++n2;
            object = sm_02;
            object = ((sm_0)object).b;
            sm_02 = ((st_0)object).c;
        }
        return d2 - (double)(n2 - 2) * Math.PI;
    }

    private static rs_0 b(st_0 st_02) {
        int n2 = 0;
        rs_0 rs_02 = rs_0.a;
        Object object = st_02;
        sm_0 sm_02 = ((st_0)object).c;
        while (true) {
            if (n2 != 0) {
                object = sm_02;
                if (((sm_0)object).a == st_02) break;
            }
            sm_0 sm_03 = sm_02;
            object = sm_03;
            object = sm_02;
            object = ((sm_0)object).d;
            rs_02 = new rs_0(1.0, rs_02, sm_03.c, ((sl_0)object).a);
            ++n2;
            object = sm_02;
            object = ((sm_0)object).b;
            sm_02 = ((st_0)object).c;
        }
        return rs_02.o();
    }

    public final double a() {
        return this.a;
    }

    public final sp_0 b() {
        if (this.b.f() == 0.0) {
            return sp_0.b;
        }
        return new sp_0(this.b);
    }

    public final List<rs_0> c() {
        return this.c;
    }
}

