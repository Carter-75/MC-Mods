/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.valkyrienskies.core.impl.shadow.sb
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;
import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.qM;
import org.valkyrienskies.core.impl.shadow.qN;
import org.valkyrienskies.core.impl.shadow.qO;
import org.valkyrienskies.core.impl.shadow.rL;
import org.valkyrienskies.core.impl.shadow.rM;
import org.valkyrienskies.core.impl.shadow.rN;
import org.valkyrienskies.core.impl.shadow.rO;
import org.valkyrienskies.core.impl.shadow.rP;
import org.valkyrienskies.core.impl.shadow.rQ;
import org.valkyrienskies.core.impl.shadow.rR;
import org.valkyrienskies.core.impl.shadow.rS;
import org.valkyrienskies.core.impl.shadow.rV;
import org.valkyrienskies.core.impl.shadow.rW;
import org.valkyrienskies.core.impl.shadow.rX;
import org.valkyrienskies.core.impl.shadow.rY;
import org.valkyrienskies.core.impl.shadow.rZ;
import org.valkyrienskies.core.impl.shadow.rv_0;
import org.valkyrienskies.core.impl.shadow.rw_0;
import org.valkyrienskies.core.impl.shadow.sa_0;
import org.valkyrienskies.core.impl.shadow.sb;
import org.valkyrienskies.core.impl.shadow.sb_0;
import org.valkyrienskies.core.impl.shadow.sc_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public abstract class rK<S extends qN, T extends qN>
implements rY<S> {
    private rM<S> b;
    public final double a;
    private double c;
    private qM<S> d;

    public rK(double d2) {
        this.b = new rM(Boolean.TRUE);
        this.a = d2;
    }

    public rK(rM<S> rM2, double d2) {
        this.b = rM2;
        this.a = d2;
    }

    public rK(Collection<sb_0<S>> collection, double d2) {
        this.a = d2;
        if (collection.size() == 0) {
            this.b = new rM(Boolean.TRUE);
            return;
        }
        TreeSet<sb_0<S>> treeSet = new TreeSet<sb_0<S>>(new Comparator<sb_0<S>>(this){
            private /* synthetic */ rK a;
            {
                this.a = rK2;
            }

            private static int a(sb_0<S> sb_02, sb_0<S> sb_03) {
                double d2;
                double d3 = sb_02.a();
                double d4 = sb_03.a();
                if (d2 < d3) {
                    return -1;
                }
                if (sb_02 == sb_03) {
                    return 0;
                }
                return 1;
            }

            @Override
            public final /* synthetic */ int compare(Object object, Object object2) {
                double d2;
                object2 = (sb_0)object2;
                object = (sb_0)object;
                double d3 = object.a();
                double d4 = object2.a();
                if (d2 < d3) {
                    return -1;
                }
                if (object == object2) {
                    return 0;
                }
                return 1;
            }
        });
        treeSet.addAll(collection);
        this.b = new rM();
        rK rK2 = this;
        rK2.a(rK2.b, treeSet);
        this.b.a(new rN<S>(this){
            private /* synthetic */ rK a;
            {
                this.a = rK2;
            }

            @Override
            public final int a(rM<S> rM2) {
                return rN.a.PLUS_SUB_MINUS$672d2271;
            }

            @Override
            public final void b(rM<S> rM2) {
            }

            @Override
            public final void c(rM<S> object) {
                Object object2;
                block3: {
                    block2: {
                        object2 = object;
                        if (((rM)object2).d == null) break block2;
                        rM rM2 = object;
                        object2 = rM2;
                        object2 = rM2.d;
                        if (rM2 != ((rM)object2).c) break block3;
                    }
                    rM rM3 = object;
                    object = Boolean.TRUE;
                    object2 = rM3;
                    rM3.e = object;
                    return;
                }
                Object object3 = object;
                object = Boolean.FALSE;
                object2 = object3;
                ((rM)object3).e = object;
            }
        });
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    public rK(rw_0[] rw_0Array, double d2) {
        this.a = d2;
        if (rw_0Array == null || rw_0Array.length == 0) {
            this.b = new rM(Boolean.FALSE);
            return;
        }
        this.b = rw_0Array[0].e().a(false);
        rM<rv_0> rM2 = this.b;
        Boolean bl = Boolean.TRUE;
        rM<rv_0> object2 = rM2;
        rM2.e = bl;
        for (rw_0 rw_02 : rw_0Array) {
            if (!rM2.a(rw_02)) continue;
            bl = null;
            rM<rv_0> rM3 = rM2;
            rM2.e = bl;
            rM<rv_0> rM4 = rM2;
            bl = Boolean.FALSE;
            rM rM5 = rM4.b;
            rM4.b.e = bl;
            rM<rv_0> rM6 = rM2;
            rM2 = rM6.c;
            bl = Boolean.TRUE;
            rM rM7 = rM2;
            rM2.e = bl;
        }
    }

    public abstract rK<S, T> a(rM<S> var1);

    public final double c() {
        return this.a;
    }

    private void a(rM<S> object, Collection<sb_0<S>> arrayList) {
        while (true) {
            Object object2;
            arrayList = arrayList.iterator();
            rV rV2 = null;
            while (rV2 == null && arrayList.hasNext()) {
                rV2 = ((sb)arrayList.next()).c();
                if (object.a(rV2.g())) continue;
                rV2 = null;
            }
            if (!arrayList.hasNext()) {
                return;
            }
            ArrayList<sb_0<S>> arrayList2 = new ArrayList<sb_0<S>>();
            ArrayList<Object> arrayList3 = new ArrayList<Object>();
            while (arrayList.hasNext()) {
                object2 = (sb)arrayList.next();
                sb_0.a a2 = object2.a(rV2);
                switch (3.a[a2.c() - 1]) {
                    case 1: {
                        arrayList2.add((sb_0<S>)object2);
                        break;
                    }
                    case 2: {
                        arrayList3.add(object2);
                        break;
                    }
                    case 3: {
                        object2 = a2;
                        arrayList2.add(object2.a);
                        object2 = a2;
                        arrayList3.add(object2.b);
                    }
                }
            }
            object2 = object;
            this.a(object2.b, arrayList2);
            object2 = object;
            arrayList = arrayList3;
            object = object2.c;
        }
    }

    private rK<S, T> b() {
        rK rK2 = this;
        return rK2.a(rK2.b.a());
    }

    @Override
    public final boolean d() {
        rK rK2 = this;
        return rK2.c(rK2.b);
    }

    @Override
    public final boolean c(rM<S> rM2) {
        rM<S> rM3 = rM2;
        if (rM3.a == null) {
            rM3 = rM2;
            return (Boolean)rM3.e == false;
        }
        rM3 = rM2;
        if (this.c(rM3.c)) {
            rM3 = rM2;
            if (this.c(rM3.b)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public final boolean e() {
        rK rK2 = this;
        return rK2.d(rK2.b);
    }

    @Override
    public final boolean d(rM<S> rM2) {
        rM<S> rM3 = rM2;
        if (rM3.a == null) {
            rM3 = rM2;
            return (Boolean)rM3.e;
        }
        rM3 = rM2;
        if (this.d(rM3.c)) {
            rM3 = rM2;
            if (this.d(rM3.b)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public final boolean a(rY<S> object) {
        Object object2 = this;
        rY<S> rY2 = object;
        object = new rZ();
        object2 = rY2.a(false).a(object2.a(false), new rZ.a((rZ)object, rY2, object2));
        ((rM)object2).a(((rZ)object).a);
        return rY2.b((rM)object2).d();
    }

    @Override
    public rQ<S> a(qM<S> object) {
        object = new rR(object);
        this.a(true).a((rN<S>)object);
        rM rM2 = ((rR)object).c;
        ((rR)v0).d = BY.h(((rR)object).d, (Boolean)rM2.e != false ? -1.0 : 1.0);
        return new rQ(((rR)object).a, ((rR)object).b, ((rR)object).d);
    }

    @Override
    private int a(qO<S> qO2) {
        return this.b((qM<S>)qO2);
    }

    @Override
    public final int b(qM<S> qM2) {
        rK rK2 = this;
        return rK2.a(rK2.b, qM2);
    }

    private int a(rM<S> rM2, qO<S> qO2) {
        return this.a(rM2, (qM<S>)qO2);
    }

    private int a(rM<S> rM2, qM<S> qM2) {
        rM2 = rM2.a(qM2, this.a);
        rM<S> rM3 = rM2;
        if (rM2.a == null) {
            rM3 = rM2;
            if (((Boolean)rM3.e).booleanValue()) {
                return rY.a.INSIDE$3ad793e5;
            }
            return rY.a.OUTSIDE$3ad793e5;
        }
        rM3 = rM2;
        int n2 = this.a(rM3.c, qM2);
        rM3 = rM2;
        int n3 = this.a(rM3.b, qM2);
        if (n2 == n3) {
            return n2;
        }
        return rY.a.BOUNDARY$3ad793e5;
    }

    @Override
    public final rM<S> a(boolean bl) {
        if (bl) {
            rM<S> rM2 = this.b;
            if (rM2.a != null) {
                rM2 = this.b;
                if (rM2.e == null) {
                    this.b.a(new rP());
                }
            }
        }
        return this.b;
    }

    @Override
    public final double f() {
        rS rS2 = new rS();
        this.a(true).a(rS2);
        return rS2.a;
    }

    @Override
    public final double g() {
        if (this.d == null) {
            this.a();
        }
        return this.c;
    }

    public final void a(double d2) {
        this.c = d2;
    }

    @Override
    public final qM<S> h() {
        if (this.d == null) {
            this.a();
        }
        return this.d;
    }

    private void b(qO<S> object) {
        qO<S> qO2 = object;
        object = this;
        this.d = qO2;
    }

    public final void c(qM<S> qM2) {
        this.d = qM2;
    }

    protected abstract void a();

    @Override
    @Deprecated
    public final int a(rV<S> rW2) {
        rW<S> rW3 = new rW<S>(this);
        rW3.a(this.b, rW2.f());
        rW2 = rW3;
        if (rW2.a) {
            rW2 = rW3;
            if (rW2.b) {
                return sa_0.BOTH$7c70dd6b;
            }
            return sa_0.PLUS$7c70dd6b;
        }
        rW2 = rW3;
        if (rW2.b) {
            return sa_0.MINUS$7c70dd6b;
        }
        return sa_0.HYPER$7c70dd6b;
    }

    @Override
    public final sb_0<S> a(sb_0<S> sb_02) {
        rK rK2 = this;
        return rK2.a(rK2.b, sb_02);
    }

    private sb_0<S> a(rM<S> object, sb_0<S> sb_02) {
        while (true) {
            Object object2 = object;
            if (((rM)object2).a == null) {
                object2 = object;
                if (((Boolean)((rM)object2).e).booleanValue()) {
                    return sb_02.e();
                }
                return null;
            }
            object2 = object;
            Object object3 = ((rM)object2).a.c();
            object2 = object3 = sb_02.a((rV)object3);
            if (((sb_0.a)object3).a != null) {
                object2 = object3;
                if (((sb_0.a)object2).b != null) {
                    rM<S> rM2 = object;
                    object2 = rM2;
                    object2 = object3;
                    sb_02 = this.a(rM2.b, ((sb_0.a)object2).a);
                    rM<S> rM3 = object;
                    object2 = rM3;
                    object2 = object3;
                    object = this.a(rM3.c, ((sb_0.a)object2).b);
                    if (sb_02 == null) {
                        return object;
                    }
                    if (object == null) {
                        return sb_02;
                    }
                    return sb_02.a((sb_0)object);
                }
                object2 = object;
                object = ((rM)object2).b;
                continue;
            }
            object2 = object3;
            if (((sb_0.a)object2).b != null) {
                object2 = object;
                object = ((rM)object2).c;
                continue;
            }
            rM<S> rM4 = object;
            object2 = rM4;
            object2 = object;
            sb_02 = this.a(((rM)object2).c, sb_02);
            object = rM4.b;
        }
    }

    public final rK<S, T> a(sc_0<S, T> object) {
        HashMap<rM<S>, rM<S>> hashMap = new HashMap<rM<S>, rM<S>>();
        rK rK2 = this;
        object = rK2.a(rK2.a(false), (sc_0<S, T>)((Object)object), (Map<rM<S>, rM<S>>)hashMap);
        for (Map.Entry entry : hashMap.entrySet()) {
            Object object2 = (rM)entry.getKey();
            if (((rM)object2).a == null) continue;
            object2 = (rM)entry.getKey();
            rO rO2 = (rO)((rM)object2).e;
            if (rO2 == null) continue;
            object2 = (rM)entry.getValue();
            rO rO3 = (rO)((rM)object2).e;
            object2 = rO2;
            for (rM rM2 : ((rO)object2).c) {
                object2 = rO3;
                ((rO)object2).c.a((rM)hashMap.get(rM2));
            }
        }
        return this.a(object);
    }

    private rM<S> a(rM<S> rM2, sc_0<S, T> rM3, Map<rM<S>, rM<S>> map2) {
        Object object = rM2;
        if (((rM)object).a == null) {
            object = rM2;
            rM3 = new rM(((rM)object).e);
        } else {
            object = rM2;
            sb_0 sb_02 = ((rM)object).a;
            sb_02 = ((rL)sb_02).a(rM3);
            object = rM2;
            rO rO2 = (rO)((rM)object).e;
            if (rO2 != null) {
                rL rL2;
                rL rL3;
                object = rO2;
                if (((rO)object).a == null) {
                    rL3 = null;
                } else {
                    object = rO2;
                    rL3 = ((rL)((rO)object).a).a(rM3);
                }
                rL rL4 = rL3;
                object = rO2;
                if (((rO)object).b == null) {
                    rL2 = null;
                } else {
                    object = rO2;
                    rL2 = ((rL)((rO)object).b).a(rM3);
                }
                rO2 = rL2;
                rO2 = new rO(rL4, rO2, new rX());
            }
            rM<S> rM4 = rM2;
            object = rM4;
            object = rM2;
            rM3 = new rM(sb_02, this.a(rM4.b, (sc_0<S, T>)((Object)rM3), map2), this.a(((rM)object).c, (sc_0<S, T>)((Object)rM3), map2), rO2);
        }
        map2.put(rM2, rM3);
        return rM3;
    }

    public final /* synthetic */ rK i() {
        rK rK2 = this;
        return rK2.a(rK2.b.a());
    }

    public /* synthetic */ rK b(rM rM2) {
        return this.a(rM2);
    }

    static final class 3 {
        static final /* synthetic */ int[] a;

        static {
            a = new int[sa_0.values$65ac40a5().length];
            try {
                3.a[sa_0.PLUS$7c70dd6b - 1] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                3.a[sa_0.MINUS$7c70dd6b - 1] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                3.a[sa_0.BOTH$7c70dd6b - 1] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
        }
    }
}

