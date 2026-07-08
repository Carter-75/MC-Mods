/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.ArrayList;
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
 */
public final class qC<T>
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
        int n4 = 1 + qx_0.a().nextInt(n3 - 2);
        for (n2 = 0; n2 < n4; ++n2) {
            arrayList.add(list.get(n2));
            arrayList2.add(object.get(n2));
        }
        for (n2 = n4; n2 < n3; ++n2) {
            arrayList.add(object.get(n2));
            arrayList2.add(list.get(n2));
        }
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
        int n4 = 1 + qx_0.a().nextInt(n3 - 2);
        for (n2 = 0; n2 < n4; ++n2) {
            arrayList.add(list.get(n2));
            arrayList2.add(object.get(n2));
        }
        for (n2 = n4; n2 < n3; ++n2) {
            arrayList.add(object.get(n2));
            arrayList2.add(list.get(n2));
        }
        return new qq_0(qm_02.c(), qm_03.c());
    }
}

