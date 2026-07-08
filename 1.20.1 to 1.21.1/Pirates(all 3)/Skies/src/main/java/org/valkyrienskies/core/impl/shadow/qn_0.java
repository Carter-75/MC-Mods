/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.ArrayList;
import java.util.List;
import org.valkyrienskies.core.impl.shadow.px_0;
import org.valkyrienskies.core.impl.shadow.qm_0;
import org.valkyrienskies.core.impl.shadow.qp_0;
import org.valkyrienskies.core.impl.shadow.qx_0;
import org.valkyrienskies.core.impl.shadow.qy_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.qn
 */
public abstract class qn_0
extends qm_0<Integer> {
    private qn_0(List<Integer> list) {
        super(list);
    }

    private qn_0(Integer[] integerArray) {
        super(integerArray);
    }

    @Override
    protected final void a(List<Integer> object) {
        object = object.iterator();
        while (object.hasNext()) {
            int n2 = (Integer)object.next();
            if (n2 >= 0 && n2 <= 1) continue;
            throw new qy_0(px_0.INVALID_BINARY_DIGIT, n2);
        }
    }

    private static List<Integer> a(int n2) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>(n2);
        for (int i2 = 0; i2 < n2; ++i2) {
            arrayList.add(qx_0.a().nextInt(2));
        }
        return arrayList;
    }

    @Override
    protected final boolean a(qp_0 qp_02) {
        if (!(qp_02 instanceof qn_0)) {
            return false;
        }
        qp_02 = (qn_0)qp_02;
        if (this.b() != ((qm_0)qp_02).b()) {
            return false;
        }
        for (int i2 = 0; i2 < this.a().size(); ++i2) {
            if (((Integer)this.a().get(i2)).equals(((qm_0)qp_02).a().get(i2))) continue;
            return false;
        }
        return true;
    }
}

