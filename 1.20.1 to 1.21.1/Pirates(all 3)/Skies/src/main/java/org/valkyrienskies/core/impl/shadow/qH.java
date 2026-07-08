/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.ArrayList;
import org.valkyrienskies.core.impl.shadow.oV;
import org.valkyrienskies.core.impl.shadow.px_0;
import org.valkyrienskies.core.impl.shadow.qA;
import org.valkyrienskies.core.impl.shadow.qG;
import org.valkyrienskies.core.impl.shadow.qm_0;
import org.valkyrienskies.core.impl.shadow.qp_0;
import org.valkyrienskies.core.impl.shadow.qx_0;

public final class qH
implements qA {
    public final qm_0 a(qp_0 qp_02) {
        if (!(qp_02 instanceof qG)) {
            throw new oV(px_0.RANDOMKEY_MUTATION_WRONG_CLASS, qp_02.getClass().getSimpleName());
        }
        qp_02 = (qG)qp_02;
        ArrayList<Double> arrayList = qp_02;
        arrayList = ((qm_0)qp_02).a;
        int n2 = qx_0.a().nextInt(arrayList.size());
        arrayList = new ArrayList<Double>(arrayList);
        arrayList.set(n2, qx_0.a().nextDouble());
        return ((qm_0)qp_02).c();
    }
}

