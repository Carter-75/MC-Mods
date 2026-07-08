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
 * Renamed from org.valkyrienskies.core.impl.shadow.ur
 */
public final class ur_0
implements ut_0 {
    private final tW a;
    private final boolean b;

    private ur_0(boolean bl, tW tW2) {
        this.b = bl;
        this.a = tW2;
    }

    @Override
    public final double[][] a(uq_0 uq_02, Iterable<double[]> object) {
        int n2;
        Object object2 = uq_02;
        int n3 = ((uq_0)object2).b;
        object2 = uq_02;
        int n4 = ((uq_0)object2).c;
        us us2 = new us(uq_02);
        int n5 = 0;
        double[][] dArray = new double[n3][n4];
        object = object.iterator();
        while (object.hasNext()) {
            Object object3 = (double[])object.next();
            object3 = uc_0.a(object3, (Iterable<ue_0>)uq_02, this.a);
            us_0.a_0 a_02 = us2.a((ue_0)object3);
            object3 = a_02;
            object2 = a_02;
            int n6 = ((us.a)a_02).a;
            object2 = object3;
            n2 = object3.b;
            double[] dArray2 = dArray[n6];
            int n7 = n2;
            dArray2[n7] = dArray2[n7] + 1.0;
            ++n5;
        }
        if (this.b) {
            for (int i2 = 0; i2 < n3; ++i2) {
                n2 = 0;
                while (n2 < n4) {
                    double[] dArray3 = dArray[i2];
                    int n8 = n2++;
                    dArray3[n8] = dArray3[n8] / (double)n5;
                }
            }
        }
        return dArray;
    }
}

