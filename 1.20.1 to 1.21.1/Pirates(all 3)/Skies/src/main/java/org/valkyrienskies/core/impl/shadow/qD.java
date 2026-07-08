/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.oS;
import org.valkyrienskies.core.impl.shadow.oV;
import org.valkyrienskies.core.impl.shadow.px_0;
import org.valkyrienskies.core.impl.shadow.qm_0;
import org.valkyrienskies.core.impl.shadow.qp_0;
import org.valkyrienskies.core.impl.shadow.qq_0;
import org.valkyrienskies.core.impl.shadow.qr_0;
import org.valkyrienskies.core.impl.shadow.qx_0;
import org.valkyrienskies.core.impl.shadow.zF;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public final class qD<T>
implements qr_0 {
    @Override
    public final qq_0 a(qp_0 qp_02, qp_0 qp_03) {
        int n2;
        if (!(qp_02 instanceof qm_0) || !(qp_03 instanceof qm_0)) {
            throw new oV(px_0.INVALID_FIXED_LENGTH_CHROMOSOME, new Object[0]);
        }
        qp_03 = (qm_0)qp_03;
        int n3 = ((qm_0)(qp_02 = (qm_0)qp_02)).b();
        if (n3 != ((qm_0)qp_03).b()) {
            throw new oS(((qm_0)qp_03).b(), n3);
        }
        Object object = qp_02;
        List list = ((qm_0)object).a;
        object = qp_03;
        object = ((qm_0)object).a;
        ArrayList<Object> arrayList = new ArrayList<Object>(n3);
        ArrayList<Object> arrayList2 = new ArrayList<Object>(n3);
        HashSet<Object> hashSet = new HashSet<Object>(n3);
        HashSet<Object> hashSet2 = new HashSet<Object>(n3);
        zF zF2 = qx_0.a();
        int n4 = zF2.nextInt(n3);
        while (n4 == (n2 = zF2.nextInt(n3))) {
        }
        int n5 = BY.a(n4, n2);
        n4 = BY.b(n4, n2);
        arrayList.addAll(list.subList(n5, n4 + 1));
        hashSet.addAll(arrayList);
        arrayList2.addAll(object.subList(n5, n4 + 1));
        hashSet2.addAll(arrayList2);
        for (n2 = 1; n2 <= n3; ++n2) {
            int n6 = (n4 + n2) % n3;
            Object t = list.get(n6);
            Object e2 = object.get(n6);
            if (!hashSet.contains(e2)) {
                arrayList.add(e2);
                hashSet.add(e2);
            }
            if (hashSet2.contains(t)) continue;
            arrayList2.add(t);
            hashSet2.add(t);
        }
        Collections.rotate(arrayList, n5);
        Collections.rotate(arrayList2, n5);
        return new qq_0(((qm_0)qp_02).c(), ((qm_0)qp_03).c());
    }

    private static qq_0 a(qm_0<T> qm_02, qm_0<T> qm_03) {
        int n2;
        int n3 = qm_02.b();
        if (n3 != qm_03.b()) {
            throw new oS(qm_03.b(), n3);
        }
        Object object = qm_02;
        List list = ((qm_0)object).a;
        object = qm_03;
        object = ((qm_0)object).a;
        ArrayList<Object> arrayList = new ArrayList<Object>(n3);
        ArrayList<Object> arrayList2 = new ArrayList<Object>(n3);
        HashSet<Object> hashSet = new HashSet<Object>(n3);
        HashSet<Object> hashSet2 = new HashSet<Object>(n3);
        zF zF2 = qx_0.a();
        int n4 = zF2.nextInt(n3);
        while (n4 == (n2 = zF2.nextInt(n3))) {
        }
        int n5 = BY.a(n4, n2);
        n4 = BY.b(n4, n2);
        arrayList.addAll(list.subList(n5, n4 + 1));
        hashSet.addAll(arrayList);
        arrayList2.addAll(object.subList(n5, n4 + 1));
        hashSet2.addAll(arrayList2);
        for (n2 = 1; n2 <= n3; ++n2) {
            int n6 = (n4 + n2) % n3;
            Object t = list.get(n6);
            Object e2 = object.get(n6);
            if (!hashSet.contains(e2)) {
                arrayList.add(e2);
                hashSet.add(e2);
            }
            if (hashSet2.contains(t)) continue;
            arrayList2.add(t);
            hashSet2.add(t);
        }
        Collections.rotate(arrayList, n5);
        Collections.rotate(arrayList2, n5);
        return new qq_0(qm_02.c(), qm_03.c());
    }
}

