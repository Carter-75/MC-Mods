/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.valkyrienskies.core.impl.shadow.oY;
import org.valkyrienskies.core.impl.shadow.qM;
import org.valkyrienskies.core.impl.shadow.qN;
import org.valkyrienskies.core.impl.shadow.qQ;
import org.valkyrienskies.core.impl.shadow.qR;
import org.valkyrienskies.core.impl.shadow.qS;
import org.valkyrienskies.core.impl.shadow.ro_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public final class qT<S extends qN, P extends qM<S>>
implements qQ<S, P> {
    public final double a;
    public final qS<S, P> b;

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    public qT(double d2, ro_0 ro_02) {
        this.a = d2;
        this.b = ro_02;
    }

    @Override
    public final qR<S, P> a(Iterable<P> object) {
        if (object == null || !object.iterator().hasNext()) {
            return this.b.a(new ArrayList());
        }
        Iterable<P> iterable = object;
        object = this;
        Serializable serializable = (qM)iterable.iterator().next();
        ArrayList<Object> arrayList = new ArrayList<Object>(serializable.a().a() + 1);
        ArrayList<Object> arrayList2 = new ArrayList<Object>(serializable.a().a() + 1);
        arrayList.add(serializable);
        ArrayList<Object> arrayList3 = arrayList;
        serializable = ((qT)object).a(arrayList3, arrayList3.size(), arrayList2);
        while (true) {
            Serializable serializable2;
            qR<S, E> qR2;
            Serializable serializable3 = serializable;
            Object object2 = iterable;
            Serializable serializable4 = serializable3;
            serializable3 = ((qR)serializable4).a;
            serializable4 = null;
            double d2 = -1.0;
            object2 = object2.iterator();
            while (object2.hasNext()) {
                double d3;
                qM qM2 = (qM)object2.next();
                double d4 = qM2.a(serializable3);
                if (!(d3 > d2)) continue;
                serializable4 = qM2;
                d2 = d4;
            }
            object2 = serializable4;
            if (((qR)serializable).a(object2, ((qT)object).a)) {
                return serializable;
            }
            arrayList2.clear();
            arrayList2.add(object2);
            serializable3 = serializable;
            ArrayList<Object> arrayList4 = arrayList;
            serializable4 = serializable = ((qT)object).a(arrayList4, arrayList4.size(), arrayList2);
            serializable4 = serializable3;
            if (qR2.b < ((qR)serializable2).b) {
                throw new oY();
            }
            arrayList.add(0, object2);
            serializable4 = serializable;
            arrayList.subList(((qR)serializable4).c.length, arrayList.size()).clear();
        }
    }

    private qR<S, P> b(Iterable<P> iterable) {
        Serializable serializable = (qM)iterable.iterator().next();
        ArrayList<qM<Object>> arrayList = new ArrayList<qM<Object>>(serializable.a().a() + 1);
        ArrayList<P> arrayList2 = new ArrayList<P>(serializable.a().a() + 1);
        arrayList.add((qM<Object>)serializable);
        ArrayList<qM<Object>> arrayList3 = arrayList;
        serializable = this.a(arrayList3, arrayList3.size(), arrayList2);
        P p;
        while (!((qR)serializable).a(p = qT.a(iterable, serializable), this.a)) {
            Serializable serializable2;
            qR qR2;
            arrayList2.clear();
            arrayList2.add(p);
            Serializable serializable3 = serializable;
            ArrayList<qM<Object>> arrayList4 = arrayList;
            serializable = this.a(arrayList4, arrayList4.size(), arrayList2);
            Serializable serializable4 = serializable;
            serializable4 = serializable3;
            if (qR2.b < ((qR)serializable2).b) {
                throw new oY();
            }
            arrayList.add(0, (qM<Object>)p);
            serializable4 = serializable;
            arrayList.subList(serializable4.c.length, arrayList.size()).clear();
        }
        return serializable;
    }

    public qR<S, P> a(List<P> list, int n2, List<P> list2) {
        qR<S, qM> qR2;
        qR<S, qM> qR3 = qR2 = this.b.a(list2);
        qR3 = qR2;
        if (qR2.c.length <= qR3.a.a().a()) {
            for (int i2 = 0; i2 < n2; ++i2) {
                qM qM2 = (qM)list.get(i2);
                if (qR2.a(qM2, this.a)) continue;
                list2.add(qM2);
                qR2 = this.a(list, i2, list2);
                List<P> list3 = list2;
                list3.remove(list3.size() - 1);
                for (int i3 = i2; i3 > 0; --i3) {
                    list.set(i3, list.get(i3 - 1));
                }
                list.set(0, qM2);
            }
        }
        return qR2;
    }

    private static P a(Iterable<P> object, qR<S, P> qR2) {
        qR2 = qR2.a;
        qM qM2 = null;
        double d2 = -1.0;
        object = object.iterator();
        while (object.hasNext()) {
            double d3;
            qM qM3 = (qM)object.next();
            double d4 = qM3.a(qR2);
            if (!(d3 > d2)) continue;
            qM2 = qM3;
            d2 = d4;
        }
        return qM2;
    }
}

