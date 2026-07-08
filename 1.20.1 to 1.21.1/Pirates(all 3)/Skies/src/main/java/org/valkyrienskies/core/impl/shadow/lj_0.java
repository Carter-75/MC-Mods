/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.kX;
import org.valkyrienskies.core.impl.shadow.lg_0;
import org.valkyrienskies.core.impl.shadow.ll_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.lj
 */
public final class lj_0
implements kX {
    private final ll_0 a;

    private lj_0(ll_0 ll_02) {
        this.a = ll_02;
    }

    public final double[][] a(double[] dArray) {
        Object object = new lg_0[dArray.length];
        for (int i2 = 0; i2 < dArray.length; ++i2) {
            object[i2] = new lg_0(dArray.length, 1, i2, dArray[i2]);
        }
        lg_0[] lg_0Array = this.a.a((lg_0[])object);
        object = new double[lg_0Array.length][dArray.length];
        int[] nArray = new int[dArray.length];
        for (int i3 = 0; i3 < lg_0Array.length; ++i3) {
            for (int i4 = 0; i4 < dArray.length; ++i4) {
                nArray[i4] = 1;
                object[i3][i4] = (lg_0)lg_0Array[i3].a(nArray);
                nArray[i4] = 0;
            }
        }
        return object;
    }
}

