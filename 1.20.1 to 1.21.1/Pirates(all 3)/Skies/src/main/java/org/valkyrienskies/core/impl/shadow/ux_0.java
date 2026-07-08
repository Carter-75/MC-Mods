/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.valkyrienskies.core.impl.shadow.us
 *  org.valkyrienskies.core.impl.shadow.us$a
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.co_0;
import org.valkyrienskies.core.impl.shadow.tW;
import org.valkyrienskies.core.impl.shadow.uc_0;
import org.valkyrienskies.core.impl.shadow.ud_0;
import org.valkyrienskies.core.impl.shadow.ue_0;
import org.valkyrienskies.core.impl.shadow.uq_0;
import org.valkyrienskies.core.impl.shadow.us;
import org.valkyrienskies.core.impl.shadow.us_0;
import org.valkyrienskies.core.impl.shadow.ut_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.ux
 */
public final class ux_0
implements ut_0 {
    private final tW a;
    private final boolean b;

    private ux_0(boolean bl, tW tW2) {
        this.b = bl;
        this.a = tW2;
    }

    @Override
    public final double[][] a(uq_0 uq_02, Iterable<double[]> object) {
        Object object2 = uq_02;
        int n2 = ((uq_0)object2).b;
        object2 = uq_02;
        int n3 = ((uq_0)object2).c;
        object2 = uq_02;
        ud_0 ud_02 = ((uq_0)object2).a;
        us us2 = new us(uq_02);
        int[][] nArray = new int[n2][n3];
        double[][] dArray = new double[n2][n3];
        object = object.iterator();
        while (object.hasNext()) {
            Object object3 = (double[])object.next();
            co_0<ue_0, ue_0> co_02 = uc_0.b(object3, uq_02, this.a);
            object3 = co_02;
            object2 = co_02;
            ue_0 ue_02 = (ue_0)co_02.a;
            us_0.a_0 a_02 = us2.a(ue_02);
            object2 = a_02;
            int n4 = ((us.a)a_02).a;
            object2 = a_02;
            int n5 = ((us.a)object2).b;
            int[] nArray2 = nArray[n4];
            int n6 = n5;
            nArray2[n6] = nArray2[n6] + 1;
            ud_0 ud_03 = ud_02;
            object2 = ud_03;
            object2 = object3;
            if (ud_03.a(ue_02, (Iterable<ue_0>)null).contains(object3.b)) continue;
            double[] dArray2 = dArray[n4];
            int n7 = n5;
            dArray2[n7] = dArray2[n7] + 1.0;
        }
        if (this.b) {
            for (int i2 = 0; i2 < n2; ++i2) {
                for (int i3 = 0; i3 < n3; ++i3) {
                    double[] dArray3 = dArray[i2];
                    int n8 = i3;
                    dArray3[n8] = dArray3[n8] / (double)nArray[i2][i3];
                }
            }
        }
        return dArray;
    }
}

