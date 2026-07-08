/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.ArrayList;
import java.util.List;
import org.valkyrienskies.core.impl.shadow.oS;
import org.valkyrienskies.core.impl.shadow.oV;
import org.valkyrienskies.core.impl.shadow.po_0;
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
public final class qL<T>
implements qr_0 {
    private final double a;

    private qL(double d2) {
        if (d2 < 0.0 || d2 > 1.0) {
            throw new po_0(px_0.CROSSOVER_RATE, (Number)d2, 0.0, 1.0);
        }
        this.a = d2;
    }

    private double a() {
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
        object2 = ((qm_0)object2).a;
        ArrayList<Object> arrayList = new ArrayList<Object>(n2);
        ArrayList<Object> arrayList2 = new ArrayList<Object>(n2);
        zF zF2 = qx_0.a();
        for (int i2 = 0; i2 < n2; ++i2) {
            if (zF2.nextDouble() < ((qL)object).a) {
                arrayList.add(object2.get(i2));
                arrayList2.add(list.get(i2));
                continue;
            }
            arrayList.add(list.get(i2));
            arrayList2.add(object2.get(i2));
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
        object = ((qm_0)object).a;
        ArrayList<Object> arrayList = new ArrayList<Object>(n2);
        ArrayList<Object> arrayList2 = new ArrayList<Object>(n2);
        zF zF2 = qx_0.a();
        for (int i2 = 0; i2 < n2; ++i2) {
            if (zF2.nextDouble() < this.a) {
                arrayList.add(object.get(i2));
                arrayList2.add(list.get(i2));
                continue;
            }
            arrayList.add(list.get(i2));
            arrayList2.add(object.get(i2));
        }
        return new qq_0(qm_02.c(), qm_03.c());
    }
}

