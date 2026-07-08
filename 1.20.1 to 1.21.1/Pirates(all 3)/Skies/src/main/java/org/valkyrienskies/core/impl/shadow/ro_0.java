/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Arrays;
import java.util.List;
import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.qM;
import org.valkyrienskies.core.impl.shadow.qO;
import org.valkyrienskies.core.impl.shadow.qR;
import org.valkyrienskies.core.impl.shadow.qS;
import org.valkyrienskies.core.impl.shadow.qd_0;
import org.valkyrienskies.core.impl.shadow.rB;
import org.valkyrienskies.core.impl.shadow.rc_0;
import org.valkyrienskies.core.impl.shadow.ri_0;
import org.valkyrienskies.core.impl.shadow.rs_0;
import org.valkyrienskies.core.impl.shadow.ru_0;
import org.valkyrienskies.core.impl.shadow.rv_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.ro
 */
public final class ro_0
implements qS<rc_0, rs_0> {
    @Override
    public final qR<rc_0, rs_0> a(List<rs_0> qR2) {
        if (qR2.size() <= 0) {
            return new qR((qM)rs_0.a, Double.NEGATIVE_INFINITY, (qM[])new rs_0[0]);
        }
        rs_0 rs_02 = qR2.get(0);
        if (qR2.size() < 2) {
            return new qR((qM)rs_02, 0.0, (qM[])new rs_0[]{rs_02});
        }
        rs_0 rs_03 = qR2.get(1);
        if (qR2.size() < 3) {
            rs_0 rs_04 = rs_03;
            rs_0 rs_05 = rs_02;
            return new qR((qM)new rs_0(0.5, rs_02, 0.5, rs_03), 0.5 * rs_05.a((qM<rc_0>)rs_04), (qM[])new rs_0[]{rs_02, rs_03});
        }
        rs_0 rs_06 = qR2.get(2);
        if (qR2.size() < 4) {
            qR2 = new ri_0(rs_02, rs_03, rs_06, 1.0E-10 * (rs_02.d() + rs_03.d() + rs_06.d()));
            rB[] rBArray = new rB[3];
            qO<rc_0> qO2 = rs_02;
            qR<rv_0, rB> qR3 = qR2;
            rBArray[0] = ((ri_0)((Object)qR3)).e(qO2);
            qO2 = rs_03;
            qR3 = qR2;
            rBArray[1] = ((ri_0)((Object)qR3)).e(qO2);
            qO2 = rs_06;
            qR3 = qR2;
            rBArray[2] = ((ri_0)((Object)qR3)).e(qO2);
            qR<rv_0, rB> qR4 = new ru_0().a(Arrays.asList(rBArray));
            qR<rv_0, rB> qR5 = qR2;
            qR3 = qR4;
            qO2 = (qO)qR3.a;
            qR3 = qR5;
            qR3 = qR4;
            return new qR((qM)((ri_0)((Object)qR5)).f(qO2), qR3.b, (qM[])new rs_0[]{rs_02, rs_03, rs_06});
        }
        qR2 = qR2.get(3);
        qd_0[] qd_0Array = new qd_0[4];
        Object object = rs_02;
        qd_0Array[0] = new qd_0(((rs_0)object).i);
        object = rs_03;
        qd_0Array[1] = new qd_0(((rs_0)object).i);
        object = rs_06;
        qd_0Array[2] = new qd_0(((rs_0)object).i);
        object = qR2;
        qd_0Array[3] = new qd_0(((rs_0)object).i);
        Object object2 = qd_0Array;
        qd_0[] qd_0Array2 = new qd_0[4];
        object = rs_02;
        qd_0Array2[0] = new qd_0(((rs_0)object).j);
        object = rs_03;
        qd_0Array2[1] = new qd_0(((rs_0)object).j);
        object = rs_06;
        qd_0Array2[2] = new qd_0(((rs_0)object).j);
        object = qR2;
        qd_0Array2[3] = new qd_0(((rs_0)object).j);
        Object object3 = qd_0Array2;
        qd_0[] qd_0Array3 = new qd_0[4];
        object = rs_02;
        qd_0Array3[0] = new qd_0(((rs_0)object).k);
        object = rs_03;
        qd_0Array3[1] = new qd_0(((rs_0)object).k);
        object = rs_06;
        qd_0Array3[2] = new qd_0(((rs_0)object).k);
        object = qR2;
        qd_0Array3[3] = new qd_0(((rs_0)object).k);
        object = qd_0Array3;
        Object object4 = new qd_0[]{object2[0].d(object2[0]).a(object3[0].d(object3[0])).a(object[0].d(object[0])), object2[1].d(object2[1]).a(object3[1].d(object3[1])).a(object[1].d(object[1])), object2[2].d(object2[2]).a(object3[2].d(object3[2])).a(object[2].d(object[2])), object2[3].d(object2[3]).a(object3[3].d(object3[3])).a(object[3].d(object[3]))};
        qd_0 qd_02 = ro_0.a((qd_0[])object2, (qd_0[])object3, (qd_0[])object).c(2);
        qd_0 qd_03 = ro_0.a((qd_0[])object4, (qd_0[])object3, (qd_0[])object);
        qd_0 qd_04 = ro_0.a((qd_0[])object4, (qd_0[])object2, (qd_0[])object);
        object4 = ro_0.a((qd_0[])object4, (qd_0[])object2, (qd_0[])object3);
        qd_03 = qd_03.c(qd_02);
        qd_04 = qd_04.c(qd_02).f();
        object4 = ((qd_0)object4).c(qd_02);
        object2 = object2[0].e(qd_03);
        object3 = object3[0].e(qd_04);
        object = object[0].e((qd_0)object4);
        Object object5 = object2;
        Object object6 = object3;
        Object object7 = object;
        object2 = ((qd_0)object5).d((qd_0)object5).a(((qd_0)object6).d((qd_0)object6)).a(((qd_0)object7).d((qd_0)object7));
        return new qR((qM)new rs_0(qd_03.doubleValue(), qd_04.doubleValue(), ((qd_0)object4).doubleValue()), BY.a(((qd_0)object2).doubleValue()), (qM[])new rs_0[]{rs_02, rs_03, rs_06, qR2});
    }

    private static qd_0 a(qd_0[] qd_0Array, qd_0[] qd_0Array2, qd_0[] qd_0Array3) {
        return qd_0Array2[0].d(qd_0Array3[1]).d(qd_0Array[2].e(qd_0Array[3])).a(qd_0Array2[0].d(qd_0Array3[2]).d(qd_0Array[3].e(qd_0Array[1]))).a(qd_0Array2[0].d(qd_0Array3[3]).d(qd_0Array[1].e(qd_0Array[2]))).a(qd_0Array2[1].d(qd_0Array3[0]).d(qd_0Array[3].e(qd_0Array[2]))).a(qd_0Array2[1].d(qd_0Array3[2]).d(qd_0Array[0].e(qd_0Array[3]))).a(qd_0Array2[1].d(qd_0Array3[3]).d(qd_0Array[2].e(qd_0Array[0]))).a(qd_0Array2[2].d(qd_0Array3[0]).d(qd_0Array[1].e(qd_0Array[3]))).a(qd_0Array2[2].d(qd_0Array3[1]).d(qd_0Array[3].e(qd_0Array[0]))).a(qd_0Array2[2].d(qd_0Array3[3]).d(qd_0Array[0].e(qd_0Array[1]))).a(qd_0Array2[3].d(qd_0Array3[0]).d(qd_0Array[2].e(qd_0Array[1]))).a(qd_0Array2[3].d(qd_0Array3[1]).d(qd_0Array[0].e(qd_0Array[2]))).a(qd_0Array2[3].d(qd_0Array3[2]).d(qd_0Array[1].e(qd_0Array[0])));
    }
}

