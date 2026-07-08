/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.ArrayList;
import org.valkyrienskies.core.impl.shadow.oV;
import org.valkyrienskies.core.impl.shadow.px_0;
import org.valkyrienskies.core.impl.shadow.qA;
import org.valkyrienskies.core.impl.shadow.qm_0;
import org.valkyrienskies.core.impl.shadow.qn_0;
import org.valkyrienskies.core.impl.shadow.qp_0;
import org.valkyrienskies.core.impl.shadow.qx_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.qo
 */
public final class qo_0
implements qA {
    public final qm_0 a(qp_0 qm_02) {
        if (!(qm_02 instanceof qn_0)) {
            throw new oV(px_0.INVALID_BINARY_CHROMOSOME, new Object[0]);
        }
        qm_02 = (qn_0)qm_02;
        Object object = qm_02;
        object = new ArrayList(((qm_0)object).a);
        int n2 = qx_0.a().nextInt(qm_02.b());
        Object object2 = object;
        object = qm_02;
        object2.set(n2, (Integer)((qm_0)object).a.get(n2) == 0 ? 1 : 0);
        qm_02 = qm_02.c();
        return qm_02;
    }
}

