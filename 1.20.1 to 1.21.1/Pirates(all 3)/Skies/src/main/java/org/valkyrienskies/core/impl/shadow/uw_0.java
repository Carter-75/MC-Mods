/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.valkyrienskies.core.impl.shadow.us
 *  org.valkyrienskies.core.impl.shadow.us$a
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.ArrayList;
import java.util.Collections;
import org.valkyrienskies.core.impl.shadow.pn_0;
import org.valkyrienskies.core.impl.shadow.tW;
import org.valkyrienskies.core.impl.shadow.uc_0;
import org.valkyrienskies.core.impl.shadow.ue_0;
import org.valkyrienskies.core.impl.shadow.uq_0;
import org.valkyrienskies.core.impl.shadow.us;
import org.valkyrienskies.core.impl.shadow.ut_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.uw
 */
public final class uw_0
implements ut_0 {
    private final int a;
    private final tW b;
    private final double c;

    private uw_0(int n2, tW tW2) {
        this.a = n2;
        this.b = tW2;
        double d2 = 0.0;
        for (int i2 = 0; i2 < n2; ++i2) {
            d2 += (double)(n2 - i2);
        }
        this.c = 1.0 / d2;
    }

    @Override
    public final double[][] a(uq_0 uq_02, Iterable<double[]> object) {
        Object object2 = uq_02;
        int n2 = ((uq_0)object2).b;
        object2 = uq_02;
        int n3 = ((uq_0)object2).c;
        int n4 = n2 * n3;
        if (n4 < this.a) {
            throw new pn_0(n4, (Number)this.a, true);
        }
        us us2 = new us(uq_02);
        double[][] dArray = new double[n2][n3];
        object = object.iterator();
        while (object.hasNext()) {
            Object object3 = (double[])object.next();
            object2 = uq_02;
            Object object4 = this.b;
            Object object5 = ((uq_0)object2).a;
            ArrayList<uc_0.a> arrayList = new ArrayList<uc_0.a>();
            object5 = object5.iterator();
            while (object5.hasNext()) {
                object2 = (ue_0)object5.next();
                double d2 = object4.a(((ue_0)object2).c(), (double[])object3);
                arrayList.add(new uc_0.a((ue_0)object2, d2));
            }
            Collections.sort(arrayList, uc_0.a.a);
            int n5 = arrayList.size();
            object2 = new ue_0[n5];
            for (int i2 = 0; i2 < n5; ++i2) {
                uc_0.a a2 = (uc_0.a)arrayList.get(i2);
                object3 = a2;
                object2[i2] = a2.b;
            }
            object3 = object2;
            for (n5 = 0; n5 < this.a; ++n5) {
                object2 = object4 = us2.a((ue_0)object3[n5]);
                int n6 = ((us.a)object4).a;
                object2 = object4;
                int n7 = ((us.a)object2).b;
                double[] dArray2 = dArray[n6];
                int n8 = n7;
                dArray2[n8] = dArray2[n8] + (double)(this.a - n5) * this.c;
            }
        }
        return dArray;
    }
}

