/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.qM;
import org.valkyrienskies.core.impl.shadow.qN;
import org.valkyrienskies.core.impl.shadow.rL;
import org.valkyrienskies.core.impl.shadow.rM;
import org.valkyrienskies.core.impl.shadow.rN;
import org.valkyrienskies.core.impl.shadow.rO;
import org.valkyrienskies.core.impl.shadow.rQ;
import org.valkyrienskies.core.impl.shadow.rU;
import org.valkyrienskies.core.impl.shadow.rV;
import org.valkyrienskies.core.impl.shadow.rY;
import org.valkyrienskies.core.impl.shadow.sb_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
final class rR<S extends qN, T extends qN>
implements rN<S> {
    final qM<S> a;
    qM<S> b;
    rM<S> c;
    double d;

    rR(qM<S> qM2) {
        this.a = qM2;
        this.b = null;
        this.c = null;
        this.d = Double.POSITIVE_INFINITY;
    }

    @Override
    public final int a(rM<S> rM2) {
        rM<S> rM3;
        if (rM3.a.c().a(this.a) <= 0.0) {
            return rN.a.MINUS_SUB_PLUS$672d2271;
        }
        return rN.a.PLUS_SUB_MINUS$672d2271;
    }

    @Override
    public final void b(rM<S> object) {
        double d2;
        Object object2 = object;
        rV rV2 = ((rM)object2).a.c();
        double d3 = rV2.a(this.a);
        if (BY.w(d2) < this.d) {
            qM qM2 = rV2.b(this.a);
            Object object3 = object;
            qM qM3 = this;
            Object object4 = new ArrayList<rY<T>>(2);
            object2 = object3;
            object2 = object = (rO)((rM)object2).e;
            rR.a(((rO)object).b, object4);
            object2 = object;
            rR.a(((rO)object2).a, object4);
            object = object4;
            boolean bl = false;
            Iterator iterator2 = object.iterator();
            while (iterator2.hasNext()) {
                qM3 = (rY)iterator2.next();
                if (bl) continue;
                object4 = qM3;
                object3 = rV2;
                qM3 = qM2;
                if (!(object4.b((object3 = (rU)object3).d(qM3)) != rY.a.OUTSIDE$3ad793e5)) continue;
                this.b = qM2;
                this.d = BY.w(d3);
                bl = true;
            }
            if (!bl) {
                iterator2 = object.iterator();
                while (iterator2.hasNext()) {
                    double d4;
                    Object object5;
                    qM3 = (rY)iterator2.next();
                    object4 = qM3;
                    object3 = rV2;
                    qM3 = qM2;
                    object3 = (rU)object3;
                    Object object6 = object = object4.a(object3.d(qM3));
                    if (((rQ)object).a == null) {
                        object5 = null;
                    } else {
                        object6 = object;
                        object5 = object = object3.c(((rQ)object6).a);
                    }
                    if (object5 == null) continue;
                    double d5 = this.a.a((qM<S>)object);
                    if (!(d4 < this.d)) continue;
                    this.b = object;
                    this.d = d5;
                }
            }
        }
    }

    @Override
    public final void c(rM<S> rM2) {
        if (this.c == null) {
            this.c = rM2;
        }
    }

    public final rQ<S> a() {
        rM<S> rM2 = this.c;
        this.d = BY.h(this.d, (Boolean)rM2.e != false ? -1.0 : 1.0);
        return new rQ<S>(this.a, this.b, this.d);
    }

    private List<rY<T>> d(rM<S> object) {
        ArrayList<rY<T>> arrayList = new ArrayList<rY<T>>(2);
        Object object2 = object;
        object2 = object = (rO)((rM)object2).e;
        rR.a(((rO)object).b, arrayList);
        object2 = object;
        rR.a(((rO)object2).a, arrayList);
        return arrayList;
    }

    private static void a(sb_0<S> rY2, List<rY<T>> list) {
        if (rY2 != null) {
            rY2 = (rL)((Object)rY2);
            rY2 = ((rL)((Object)rY2)).b;
            if (rY2 != null) {
                list.add(rY2);
            }
        }
    }

    private static boolean a(qM<S> qM2, rV<S> object, rY<T> rY2) {
        return rY2.b((object = (rU)object).d(qM2)) != rY.a.OUTSIDE$3ad793e5;
    }

    private static qM<S> b(qM<S> object, rV<S> object2, rY<T> object3) {
        object2 = (rU)object2;
        object3 = object = object3.a(object2.d(object));
        if (((rQ)object).a == null) {
            return null;
        }
        object3 = object;
        return object2.c(((rQ)object3).a);
    }
}

