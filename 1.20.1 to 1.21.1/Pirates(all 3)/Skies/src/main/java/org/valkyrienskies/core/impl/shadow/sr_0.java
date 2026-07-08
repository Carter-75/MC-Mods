/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.oY;
import org.valkyrienskies.core.impl.shadow.qM;
import org.valkyrienskies.core.impl.shadow.qR;
import org.valkyrienskies.core.impl.shadow.qT;
import org.valkyrienskies.core.impl.shadow.rK;
import org.valkyrienskies.core.impl.shadow.rM;
import org.valkyrienskies.core.impl.shadow.rN;
import org.valkyrienskies.core.impl.shadow.rQ;
import org.valkyrienskies.core.impl.shadow.rY;
import org.valkyrienskies.core.impl.shadow.rZ;
import org.valkyrienskies.core.impl.shadow.rk_0;
import org.valkyrienskies.core.impl.shadow.rl_0;
import org.valkyrienskies.core.impl.shadow.ro_0;
import org.valkyrienskies.core.impl.shadow.rs_0;
import org.valkyrienskies.core.impl.shadow.sb_0;
import org.valkyrienskies.core.impl.shadow.sj_0;
import org.valkyrienskies.core.impl.shadow.sl_0;
import org.valkyrienskies.core.impl.shadow.sm_0;
import org.valkyrienskies.core.impl.shadow.sn_0;
import org.valkyrienskies.core.impl.shadow.so_0;
import org.valkyrienskies.core.impl.shadow.sp_0;
import org.valkyrienskies.core.impl.shadow.sq_0;
import org.valkyrienskies.core.impl.shadow.st_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.sr
 */
public final class sr_0
extends rK<sq_0, sj_0> {
    private List<st_0> b;

    public sr_0(double d2) {
        super(d2);
    }

    private sr_0(rs_0 rs_02, double d2) {
        super(new rM<sq_0>(new sl_0(rs_02, d2).h(), new rM(Boolean.FALSE), new rM(Boolean.TRUE), null), d2);
    }

    private sr_0(rs_0 rs_02, rs_0 rs_03, double d2, int n2, double d3) {
        this(d3, sr_0.a(rs_02, rs_03, d2, n2));
    }

    public sr_0(rM<sq_0> rM2, double d2) {
        super(rM2, d2);
    }

    private sr_0(Collection<sb_0<sq_0>> collection, double d2) {
        super(collection, d2);
    }

    private sr_0(double d2, sp_0 ... sp_0Array) {
        super(sr_0.a(d2, sp_0Array), d2);
    }

    private static sp_0[] a(rs_0 serializable, rs_0 serializable2, double d2, int n2) {
        sp_0[] sp_0Array = new sp_0[n2];
        serializable2 = new rk_0(rs_0.c((rs_0)serializable, (rs_0)serializable2), d2, rl_0.VECTOR_OPERATOR$59e4743c);
        sp_0Array[0] = new sp_0(((rk_0)serializable2).a((rs_0)serializable));
        serializable = new rk_0((rs_0)serializable, Math.PI * 2 / (double)n2, rl_0.VECTOR_OPERATOR$59e4743c);
        for (int i2 = 1; i2 < n2; ++i2) {
            sp_0 sp_02 = sp_0Array[i2 - 1];
            sp_0Array[i2] = new sp_0(((rk_0)serializable).a(sp_02.c));
        }
        return sp_0Array;
    }

    private static rM<sq_0> a(double d2, sp_0 ... object) {
        int n2 = ((Object)object).length;
        if (n2 == 0) {
            return new rM<sq_0>(Boolean.TRUE);
        }
        st_0[] st_0Array = new st_0[n2];
        for (int i2 = 0; i2 < n2; ++i2) {
            st_0Array[i2] = new st_0((sp_0)object[i2]);
        }
        ArrayList<sm_0> arrayList = new ArrayList<sm_0>(n2);
        object = st_0Array[n2 - 1];
        for (int i3 = 0; i3 < n2; ++i3) {
            Object object2;
            Object object3;
            Object object4;
            st_0[] object5;
            Object object6;
            block7: {
                object6 = object;
                object = st_0Array[i3];
                object5 = object;
                object4 = object6;
                object4 = ((st_0)object4).d.iterator();
                while (object4.hasNext()) {
                    sl_0 sl_02 = object4.next();
                    for (sl_0 sl_03 : object5.d) {
                        if (sl_02 != sl_03) continue;
                        object3 = sl_02;
                        break block7;
                    }
                }
                object3 = object4 = null;
            }
            if (object3 == null) {
                Object object7 = object6;
                object2 = object7;
                object2 = object;
                object4 = new sl_0(((st_0)object7).a, ((st_0)object2).a, d2);
            }
            object2 = object6;
            sp_0 sp_02 = ((st_0)object2).a;
            object2 = sp_02;
            object2 = object;
            object2 = ((st_0)object2).a;
            arrayList.add(new sm_0((st_0)object6, (st_0)object, rs_0.a(sp_02.c, ((sp_0)object2).c), (sl_0)object4));
            object5 = st_0Array;
            int n3 = st_0Array.length;
            for (int i4 = 0; i4 < n3; ++i4) {
                st_0 st_02;
                st_0 st_03 = object5[i4];
                if (st_03 == object6 || st_03 == object) continue;
                object2 = st_03;
                if (!(BY.w(((sl_0)object4).a(st_02.a)) <= d2)) continue;
                st_03.a((sl_0)object4);
            }
        }
        rM<sq_0> rM2 = new rM<sq_0>();
        sr_0.a(d2, rM2, arrayList);
        return rM2;
    }

    private static void a(double d2, rM<sq_0> rM2, List<sm_0> object) {
        Object object2;
        sm_0 sm_02;
        block8: {
            block10: {
                block9: {
                    int n2 = 0;
                    sm_02 = null;
                    while (sm_02 == null && n2 < object.size()) {
                        sm_02 = object.get(n2++);
                        object2 = sm_02;
                        if (rM2.a(((sm_0)object2).d)) continue;
                        sm_02 = null;
                    }
                    if (sm_02 != null) break block8;
                    object2 = rM2;
                    rM rM3 = ((rM)object2).d;
                    if (rM3 == null) break block9;
                    object2 = rM3;
                    if (rM2 != ((rM)object2).c) break block10;
                }
                object = Boolean.TRUE;
                object2 = rM2;
                rM2.e = object;
                return;
            }
            object = Boolean.FALSE;
            object2 = rM2;
            rM2.e = object;
            return;
        }
        ArrayList<sm_0> arrayList = new ArrayList<sm_0>();
        ArrayList<sm_0> arrayList2 = new ArrayList<sm_0>();
        object = object.iterator();
        while (object.hasNext()) {
            object2 = object.next();
            if (object2 == sm_02) continue;
            rM<sq_0> rM4 = object2;
            object2 = sm_02;
            ((sm_0)((Object)rM4)).a(((sm_0)object2).d, arrayList, arrayList2);
        }
        if (!arrayList.isEmpty()) {
            object2 = rM2;
            sr_0.a(d2, ((rM)object2).b, arrayList);
        } else {
            object2 = rM2;
            object = Boolean.FALSE;
            object2 = ((rM)object2).b;
            ((rM)object2).b.e = object;
        }
        if (!arrayList2.isEmpty()) {
            object2 = rM2;
            sr_0.a(d2, ((rM)object2).c, arrayList2);
            return;
        }
        object2 = rM2;
        object = Boolean.TRUE;
        object2 = ((rM)object2).c;
        ((rM)object2).c.e = object;
    }

    private sr_0 e(rM<sq_0> rM2) {
        return new sr_0(rM2, this.c());
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public final void a() {
        block3: {
            block2: {
                var2_2 = var1_1 = this.a(true);
                if (var1_1.a != null) break block2;
                var2_2 = var1_1;
                if (var2_2.a != null) ** GOTO lbl-1000
                var2_2 = var1_1;
                if (((Boolean)var2_2.e).booleanValue()) {
                    this.a(12.566370614359172);
                    v0 = this;
                    v1 = new sp_0(0.0, 0.0);
                } else lbl-1000:
                // 2 sources

                {
                    this.a(0.0);
                    v0 = this;
                    v1 = sp_0.b;
                }
                break block3;
            }
            var2_2 = new so_0(this.c());
            var1_1.a(var2_2);
            var1_1 = var2_2;
            this.a(var1_1.a);
            v0 = this;
            var1_1 = var2_2;
            v1 = var1_1.b.f() == 0.0 ? sp_0.b : new sp_0(var1_1.b);
        }
        v0.c(v1);
    }

    public final List<st_0> b() {
        if (this.b == null) {
            Object object = this.a(false);
            if (((rM)object).a == null) {
                this.b = Collections.emptyList();
            } else {
                Object object2 = this.a(true);
                Object object3 = new sn_0((rM<sq_0>)object2, this.c());
                ((rM)object2).a((rN<sq_0>)object3);
                object2 = ((sn_0)object3).a();
                this.b = new ArrayList<st_0>();
                while (!object2.isEmpty()) {
                    object = object3 = (sm_0)object2.get(0);
                    st_0 st_02 = ((sm_0)object3).a;
                    this.b.add(st_02);
                    do {
                        object = object2.iterator();
                        while (object.hasNext()) {
                            if (object.next() != object3) continue;
                            object.remove();
                            break;
                        }
                        object = object3;
                        object = ((sm_0)object).b;
                        object = object3 = ((st_0)object).c;
                    } while (((sm_0)object3).a != st_02);
                }
            }
        }
        return Collections.unmodifiableList(this.b);
    }

    /*
     * WARNING - void declaration
     */
    private qR<sq_0, sp_0> j() {
        double d2;
        qR qR2;
        Object object;
        Object object3;
        if (this.d()) {
            return new qR((qM)sp_0.a, Double.NEGATIVE_INFINITY, (qM[])new sp_0[0]);
        }
        if (this.e()) {
            return new qR((qM)sp_0.a, Double.POSITIVE_INFINITY, (qM[])new sp_0[0]);
        }
        Object object4 = object3 = this.a(false);
        if (this.c(((rM)object4).c)) {
            object4 = object3;
            if (this.d(((rM)object4).b)) {
                object4 = object3;
                object4 = object3 = (sl_0)((rM)object4).a.c();
                return new qR((qM)new sp_0(((sl_0)object3).a).d(), 1.5707963267948966, (qM[])new sp_0[0]);
            }
        }
        object4 = object3;
        if (this.d(((rM)object4).c)) {
            object4 = object3;
            if (this.c(((rM)object4).b)) {
                object4 = object3;
                object4 = object3 = (sl_0)((rM)object3).a.c();
                return new qR((qM)new sp_0(((sl_0)object3).a), 1.5707963267948966, (qM[])new sp_0[0]);
            }
        }
        Iterator<rs_0> iterator2 = this;
        so_0 qR22 = new so_0(((rK)((Object)iterator2)).c());
        ((rK)((Object)iterator2)).a(true).a(qR22);
        object4 = qR22;
        object3 = ((so_0)object4).c;
        iterator2 = this.b();
        iterator2 = iterator2.iterator();
        while (iterator2.hasNext()) {
            rs_0[] rs_0Array = iterator2.next();
            object = rs_0Array;
            for (int i2 = 0; i2 == 0 || object != rs_0Array; ++i2) {
                object4 = object;
                object4 = ((st_0)object).a;
                object3.add((rs_0)((sp_0)object4).c);
                object4 = object;
                object4 = ((st_0)object).c;
                object = ((sm_0)object4).b;
            }
        }
        iterator2 = new ro_0();
        qT qT2 = new qT(this.c(), (ro_0)((Object)iterator2));
        sp_0[] sp_0Array = object3;
        iterator2 = qT2;
        if (sp_0Array == null || !sp_0Array.iterator().hasNext()) {
            qR2 = ((qT)((Object)iterator2)).b.a(new ArrayList());
        } else {
            object3 = sp_0Array;
            qM qM2 = (qM)object3.iterator().next();
            ArrayList<Object> arrayList = new ArrayList<Object>(qM2.a().a() + 1);
            object = new ArrayList(qM2.a().a() + 1);
            arrayList.add(qM2);
            ArrayList<Object> arrayList2 = arrayList;
            qR qR3 = ((qT)((Object)iterator2)).a(arrayList2, arrayList2.size(), object);
            while (true) {
                Object p;
                qR qR4;
                void var3_13;
                Object p2 = var3_13;
                Object object2 = object3;
                object4 = p2;
                p2 = ((qR)object4).a;
                qM qM3 = null;
                double d3 = -1.0;
                object2 = object2.iterator();
                while (object2.hasNext()) {
                    double d4;
                    qM qM4 = (qM)object2.next();
                    double d5 = qM4.a(p2);
                    if (!(d4 > d3)) continue;
                    qM3 = qM4;
                    d3 = d5;
                }
                object2 = qM3;
                if (var3_13.a(object2, ((qT)((Object)iterator2)).a)) {
                    qR2 = var3_13;
                    break;
                }
                object.clear();
                object.add(object2);
                p2 = var3_13;
                ArrayList<Object> arrayList3 = arrayList;
                qR qR5 = ((qT)((Object)iterator2)).a(arrayList3, arrayList3.size(), object);
                object4 = qR5;
                object4 = p2;
                if (qR4.b < ((qR)p).b) {
                    throw new oY();
                }
                arrayList.add(0, object2);
                object4 = qR5;
                arrayList.subList(((qR)object4).c.length, arrayList.size()).clear();
            }
        }
        Object object5 = qR2;
        object = (rs_0[])qR2.c();
        object4 = object5;
        double d6 = ((qR)object4).b;
        object4 = object5;
        double d7 = ((rs_0)((qR)object4).a).e();
        if (d2 < this.c()) {
            object3 = new qR((qM)sp_0.a, Double.POSITIVE_INFINITY, (qM[])new sp_0[0]);
            iterator2 = this;
            sr_0 sr_02 = (sr_0)new rZ<rs_0>().a((rY<rs_0>)((Object)iterator2));
            iterator2 = new so_0(((rK)((Object)iterator2)).c());
            sr_02.a(true).a((rN<rs_0>)((Object)iterator2));
            object4 = iterator2;
            for (rs_0 rs_02 : ((so_0)object4).c) {
                Object object6;
                Object object7;
                sp_0 sp_02 = new sp_0(rs_02);
                object4 = object5 = this.a(sp_02);
                object4 = object3;
                if (!(Math.PI - ((rQ)object7).b < ((qR)object6).b)) continue;
                Object object8 = object5;
                object4 = object8;
                qM[] qMArray = new sp_0[1];
                object4 = object5;
                qMArray[0] = (sp_0)((rQ)object4).a;
                object3 = new qR((qM)sp_02.d(), Math.PI - ((rQ)object8).b, qMArray);
            }
            return object3;
        }
        object3 = new sp_0[((rs_0[])object).length];
        for (int i3 = 0; i3 < ((rs_0[])object).length; ++i3) {
            object3[i3] = new sp_0(object[i3]);
        }
        object4 = object5;
        double d8 = d7;
        double d9 = d6;
        qR qR4 = new qR((qM)new sp_0((rs_0)((qR)object4).a), BY.s((1.0 + d8 * d8 - d9 * d9) / (d7 * 2.0)), (qM[])object3);
        return qR4;
    }

    private List<rs_0> k() {
        so_0 so_02 = new so_0(this.c());
        this.a(true).a(so_02);
        return so_02.c;
    }

    private List<rs_0> l() {
        Object object = (sr_0)new rZ<sq_0>().a(this);
        so_0 so_02 = new so_0(this.c());
        ((rK)object).a(true).a(so_02);
        object = so_02;
        return ((so_0)object).c;
    }

    @Override
    public final /* synthetic */ rK a(rM rM2) {
        return this.e(rM2);
    }

    @Override
    public final /* synthetic */ rK b(rM rM2) {
        return this.e(rM2);
    }
}

