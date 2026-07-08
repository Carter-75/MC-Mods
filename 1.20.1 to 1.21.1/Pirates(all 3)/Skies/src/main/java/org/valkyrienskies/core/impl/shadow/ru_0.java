/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.List;
import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.qM;
import org.valkyrienskies.core.impl.shadow.qR;
import org.valkyrienskies.core.impl.shadow.qS;
import org.valkyrienskies.core.impl.shadow.qd_0;
import org.valkyrienskies.core.impl.shadow.rB;
import org.valkyrienskies.core.impl.shadow.rv_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.ru
 */
public final class ru_0
implements qS<rv_0, rB> {
    @Override
    public final qR<rv_0, rB> a(List<rB> object) {
        if (object.size() <= 0) {
            return new qR((qM)rB.a, Double.NEGATIVE_INFINITY, (qM[])new rB[0]);
        }
        rB rB2 = object.get(0);
        if (object.size() < 2) {
            return new qR((qM)rB2, 0.0, (qM[])new rB[]{rB2});
        }
        rB rB3 = object.get(1);
        if (object.size() < 3) {
            object = rB3;
            rB rB4 = rB2;
            return new qR((qM)new rB(0.5, rB2, 0.5, rB3), 0.5 * rB4.a((qM<rv_0>)object), (qM[])new rB[]{rB2, rB3});
        }
        object = object.get(2);
        qd_0[] qd_0Array = new qd_0[3];
        Object object2 = rB2;
        qd_0Array[0] = new qd_0(((rB)object2).c);
        object2 = rB3;
        qd_0Array[1] = new qd_0(((rB)object2).c);
        object2 = object;
        qd_0Array[2] = new qd_0(((rB)object2).c);
        Object object3 = qd_0Array;
        qd_0[] qd_0Array2 = new qd_0[3];
        object2 = rB2;
        qd_0Array2[0] = new qd_0(((rB)object2).d);
        object2 = rB3;
        qd_0Array2[1] = new qd_0(((rB)object2).d);
        object2 = object;
        qd_0Array2[2] = new qd_0(((rB)object2).d);
        object2 = qd_0Array2;
        Object object4 = new qd_0[]{object3[0].d(object3[0]).a(object2[0].d(object2[0])), object3[1].d(object3[1]).a(object2[1].d(object2[1])), object3[2].d(object3[2]).a(object2[2].d(object2[2]))};
        qd_0 qd_02 = ru_0.a((qd_0[])object3, (qd_0[])object2).c(2);
        qd_0 qd_03 = ru_0.a((qd_0[])object4, (qd_0[])object2);
        object4 = ru_0.a((qd_0[])object4, (qd_0[])object3);
        qd_03 = qd_03.c(qd_02);
        object4 = ((qd_0)object4).c(qd_02).f();
        object3 = object3[0].e(qd_03);
        object2 = object2[0].e((qd_0)object4);
        Object object5 = object3;
        Object object6 = object2;
        object3 = ((qd_0)object5).d((qd_0)object5).a(((qd_0)object6).d((qd_0)object6));
        return new qR((qM)new rB(qd_03.doubleValue(), ((qd_0)object4).doubleValue()), BY.a(((qd_0)object3).doubleValue()), (qM[])new rB[]{rB2, rB3, object});
    }

    private static qd_0 a(qd_0[] qd_0Array, qd_0[] qd_0Array2) {
        return qd_0Array2[0].d(qd_0Array[2].e(qd_0Array[1])).a(qd_0Array2[1].d(qd_0Array[0].e(qd_0Array[2]))).a(qd_0Array2[2].d(qd_0Array[1].e(qd_0Array[0])));
    }
}

