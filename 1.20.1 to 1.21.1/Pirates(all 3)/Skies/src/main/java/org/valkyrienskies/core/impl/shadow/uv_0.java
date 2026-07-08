/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.valkyrienskies.core.impl.shadow.us
 *  org.valkyrienskies.core.impl.shadow.us$a
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.tW;
import org.valkyrienskies.core.impl.shadow.uc_0;
import org.valkyrienskies.core.impl.shadow.ue_0;
import org.valkyrienskies.core.impl.shadow.uq_0;
import org.valkyrienskies.core.impl.shadow.us;
import org.valkyrienskies.core.impl.shadow.us_0;
import org.valkyrienskies.core.impl.shadow.ut_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.uv
 */
public final class uv_0
implements ut_0 {
    private final tW a;

    private uv_0(tW tW2) {
        this.a = tW2;
    }

    @Override
    public final double[][] a(uq_0 uq_02, Iterable<double[]> object) {
        Object object2 = uq_02;
        int n2 = ((uq_0)object2).b;
        object2 = uq_02;
        int n3 = ((uq_0)object2).c;
        us us2 = new us(uq_02);
        int[][] nArray = new int[n2][n3];
        double[][] dArray = new double[n2][n3];
        object = object.iterator();
        while (object.hasNext()) {
            double[] dArray2 = (double[])object.next();
            ue_0 ue_02 = uc_0.a(dArray2, (Iterable<ue_0>)uq_02, this.a);
            us_0.a_0 a_02 = us2.a(ue_02);
            object2 = a_02;
            int n4 = ((us.a)a_02).a;
            object2 = a_02;
            int n5 = ((us.a)object2).b;
            int[] nArray2 = nArray[n4];
            int n6 = n5;
            nArray2[n6] = nArray2[n6] + 1;
            double[] dArray3 = dArray[n4];
            int n7 = n5;
            dArray3[n7] = dArray3[n7] + this.a.a(dArray2, ue_02.c());
        }
        for (int i2 = 0; i2 < n2; ++i2) {
            for (int i3 = 0; i3 < n3; ++i3) {
                int n8 = nArray[i2][i3];
                if (n8 == 0) continue;
                double[] dArray4 = dArray[i2];
                int n9 = i3;
                dArray4[n9] = dArray4[n9] / (double)n8;
            }
        }
        return dArray;
    }
}

