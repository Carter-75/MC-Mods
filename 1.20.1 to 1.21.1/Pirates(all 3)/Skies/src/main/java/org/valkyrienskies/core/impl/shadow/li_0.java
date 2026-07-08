/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.kY;
import org.valkyrienskies.core.impl.shadow.lg_0;
import org.valkyrienskies.core.impl.shadow.lk_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.li
 */
public final class li_0
implements kY {
    private final lk_0 a;

    public li_0(lk_0 lk_02) {
        this.a = lk_02;
    }

    public final double[] a(double[] dArray) {
        Object[] objectArray = new lg_0[dArray.length];
        for (int i2 = 0; i2 < dArray.length; ++i2) {
            objectArray[i2] = new lg_0(dArray.length, 1, i2, dArray[i2]);
        }
        lg_0 lg_02 = this.a.a((lg_0[])objectArray);
        objectArray = new double[dArray.length];
        int[] nArray = new int[dArray.length];
        for (int i3 = 0; i3 < dArray.length; ++i3) {
            nArray[i3] = 1;
            objectArray[i3] = (lg_0)lg_02.a(nArray);
            nArray[i3] = 0;
        }
        return objectArray;
    }
}

