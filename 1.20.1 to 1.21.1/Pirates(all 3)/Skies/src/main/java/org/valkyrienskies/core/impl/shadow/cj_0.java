/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import org.valkyrienskies.core.impl.shadow.ch_0;
import org.valkyrienskies.core.impl.shadow.cp_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Cj
 */
public final class cj_0
implements Serializable,
cp_0 {
    private static final long a = 20140713L;

    public final int a(double[] dArray, int n2, int n3) {
        int n4 = n3 - n2;
        int n5 = n2;
        double[] dArray2 = dArray;
        ch_0.a(dArray, n5, n4, false);
        int n6 = n2 + (--n3 - n2) / 2;
        double d2 = dArray[n2];
        double d3 = dArray[n6];
        double d4 = dArray[n3];
        if (d2 < d3) {
            if (d3 < d4) {
                return n6;
            }
            if (d2 < d4) {
                return n3;
            }
            return n2;
        }
        if (d2 < d4) {
            return n2;
        }
        if (d3 < d4) {
            return n3;
        }
        return n6;
    }
}

