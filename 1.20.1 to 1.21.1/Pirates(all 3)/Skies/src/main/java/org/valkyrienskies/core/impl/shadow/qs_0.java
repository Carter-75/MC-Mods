/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.valkyrienskies.core.impl.shadow.oS;
import org.valkyrienskies.core.impl.shadow.oV;
import org.valkyrienskies.core.impl.shadow.px_0;
import org.valkyrienskies.core.impl.shadow.qm_0;
import org.valkyrienskies.core.impl.shadow.qp_0;
import org.valkyrienskies.core.impl.shadow.qq_0;
import org.valkyrienskies.core.impl.shadow.qr_0;
import org.valkyrienskies.core.impl.shadow.qx_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.qs
 */
public final class qs_0<T>
implements qr_0 {
    private final boolean a;

    public qs_0() {
        this(false);
    }

    private qs_0(boolean bl) {
        this.a = false;
    }

    private boolean a() {
        return this.a;
    }

    @Override
    public final qq_0 a(qp_0 object, qp_0 qp_02) {
        if (!(object instanceof qm_0) || !(qp_02 instanceof qm_0)) {
            throw new oV(px_0.INVALID_FIXED_LENGTH_CHROMOSOME, new Object[0]);
        }
        qm_0 qm_02 = (qm_0)qp_02;
        qp_02 = (qm_0)object;
        object = this;
        int n2 = ((qm_0)qp_02).b();
        if (n2 != qm_02.b()) {
            throw new oS(qm_02.b(), n2);
        }
        Object object2 = qp_02;
        List list = ((qm_0)object2).a;
        object2 = qm_02;
        List list2 = ((qm_0)object2).a;
        object2 = qm_02;
        ArrayList arrayList = new ArrayList(((qm_0)object2).a);
        object2 = qp_02;
        object2 = new ArrayList(((qm_0)object2).a);
        HashSet hashSet = new HashSet(n2);
        ArrayList<Integer> arrayList2 = new ArrayList<Integer>(n2);
        int n3 = ((qs_0)object).a ? qx_0.a().nextInt(n2) : 0;
        int n4 = 1;
        while (hashSet.size() < n2) {
            arrayList2.add(n3);
            Object t = list2.get(n3);
            int n5 = list.indexOf(t);
            while (n5 != (Integer)arrayList2.get(0)) {
                arrayList2.add(n5);
                Object t2 = list2.get(n5);
                n5 = list.indexOf(t2);
            }
            if (n4++ % 2 != 0) {
                Iterator iterator2 = arrayList2.iterator();
                while (iterator2.hasNext()) {
                    int n6 = (Integer)iterator2.next();
                    Object e2 = arrayList.get(n6);
                    arrayList.set(n6, object2.get(n6));
                    object2.set(n6, e2);
                }
            }
            hashSet.addAll(arrayList2);
            n3 = ((Integer)arrayList2.get(0) + 1) % n2;
            while (hashSet.contains(n3) && hashSet.size() < n2) {
                if (++n3 < n2) continue;
                n3 = 0;
            }
            arrayList2.clear();
        }
        return new qq_0(((qm_0)qp_02).c(), qm_02.c());
    }

    private qq_0 a(qm_0<T> qm_02, qm_0<T> qm_03) {
        int n2 = qm_02.b();
        if (n2 != qm_03.b()) {
            throw new oS(qm_03.b(), n2);
        }
        Object object = qm_02;
        List list = ((qm_0)object).a;
        object = qm_03;
        List list2 = ((qm_0)object).a;
        object = qm_03;
        ArrayList arrayList = new ArrayList(((qm_0)object).a);
        object = qm_02;
        object = new ArrayList(((qm_0)object).a);
        HashSet hashSet = new HashSet(n2);
        ArrayList<Integer> arrayList2 = new ArrayList<Integer>(n2);
        int n3 = this.a ? qx_0.a().nextInt(n2) : 0;
        int n4 = 1;
        while (hashSet.size() < n2) {
            arrayList2.add(n3);
            Object t = list2.get(n3);
            int n5 = list.indexOf(t);
            while (n5 != (Integer)arrayList2.get(0)) {
                arrayList2.add(n5);
                Object t2 = list2.get(n5);
                n5 = list.indexOf(t2);
            }
            if (n4++ % 2 != 0) {
                Iterator iterator2 = arrayList2.iterator();
                while (iterator2.hasNext()) {
                    int n6 = (Integer)iterator2.next();
                    Object e2 = arrayList.get(n6);
                    arrayList.set(n6, object.get(n6));
                    object.set(n6, e2);
                }
            }
            hashSet.addAll(arrayList2);
            n3 = ((Integer)arrayList2.get(0) + 1) % n2;
            while (hashSet.contains(n3) && hashSet.size() < n2) {
                if (++n3 < n2) continue;
                n3 = 0;
            }
            arrayList2.clear();
        }
        return new qq_0(qm_02.c(), qm_03.c());
    }
}

