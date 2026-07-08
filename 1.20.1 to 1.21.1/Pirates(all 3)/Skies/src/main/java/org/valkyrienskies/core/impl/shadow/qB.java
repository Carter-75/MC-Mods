/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.ArrayList;
import java.util.List;
import org.valkyrienskies.core.impl.shadow.oS;
import org.valkyrienskies.core.impl.shadow.oV;
import org.valkyrienskies.core.impl.shadow.pk_0;
import org.valkyrienskies.core.impl.shadow.pm_0;
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
public final class qB<T>
implements qr_0 {
    private final int a;

    private qB(int n2) {
        if (n2 <= 0) {
            throw new pk_0(n2);
        }
        this.a = n2;
    }

    private int a() {
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
        if (((qB)object).a >= n2) {
            throw new pm_0(((qB)object).a, (Number)n2, false);
        }
        Object object2 = qp_02;
        List list = ((qm_0)object2).a;
        object2 = qm_02;
        object2 = ((qm_0)object2).a;
        ArrayList arrayList = new ArrayList(n2);
        ArrayList arrayList2 = new ArrayList(n2);
        zF zF2 = qx_0.a();
        int n3 = ((qB)object).a;
        int n4 = 0;
        int n5 = 0;
        while (n5 < ((qB)object).a) {
            int n6 = n4 + 1 + zF2.nextInt(n2 - n4 - n3);
            while (n4 < n6) {
                arrayList.add(list.get(n4));
                arrayList2.add(object2.get(n4));
                ++n4;
            }
            ArrayList arrayList3 = arrayList;
            arrayList = arrayList2;
            arrayList2 = arrayList3;
            n4 = n6;
            ++n5;
            --n3;
        }
        for (n5 = n4; n5 < n2; ++n5) {
            arrayList.add(list.get(n5));
            arrayList2.add(object2.get(n5));
        }
        return new qq_0(((qm_0)qp_02).c(), qm_02.c());
    }

    private qq_0 a(qm_0<T> qm_02, qm_0<T> qm_03) {
        int n2 = qm_02.b();
        if (n2 != qm_03.b()) {
            throw new oS(qm_03.b(), n2);
        }
        if (this.a >= n2) {
            throw new pm_0(this.a, (Number)n2, false);
        }
        Object object = qm_02;
        List list = ((qm_0)object).a;
        object = qm_03;
        object = ((qm_0)object).a;
        ArrayList arrayList = new ArrayList(n2);
        ArrayList arrayList2 = new ArrayList(n2);
        zF zF2 = qx_0.a();
        int n3 = this.a;
        int n4 = 0;
        int n5 = 0;
        while (n5 < this.a) {
            int n6 = n4 + 1 + zF2.nextInt(n2 - n4 - n3);
            while (n4 < n6) {
                arrayList.add(list.get(n4));
                arrayList2.add(object.get(n4));
                ++n4;
            }
            ArrayList arrayList3 = arrayList;
            arrayList = arrayList2;
            arrayList2 = arrayList3;
            n4 = n6;
            ++n5;
            --n3;
        }
        for (n5 = n4; n5 < n2; ++n5) {
            arrayList.add(list.get(n5));
            arrayList2.add(object.get(n5));
        }
        return new qq_0(qm_02.c(), qm_03.c());
    }
}

