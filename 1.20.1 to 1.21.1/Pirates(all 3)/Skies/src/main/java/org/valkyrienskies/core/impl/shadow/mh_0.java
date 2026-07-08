/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Arrays;
import org.valkyrienskies.core.impl.shadow.ch_0;
import org.valkyrienskies.core.impl.shadow.lc_0;
import org.valkyrienskies.core.impl.shadow.oS;
import org.valkyrienskies.core.impl.shadow.pf_0;
import org.valkyrienskies.core.impl.shadow.pl_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.mh
 */
public final class mh_0
implements lc_0 {
    private final double[] a;
    private final double[] b;

    private mh_0(double[] dArray, double[] dArray2) {
        if (dArray == null || dArray2 == null) {
            throw new pl_0();
        }
        if (dArray.length == 0 || dArray2.length == 0) {
            throw new pf_0();
        }
        if (dArray2.length != dArray.length) {
            throw new oS(dArray2.length, dArray.length);
        }
        ch_0.a(dArray);
        this.a = ch_0.a(dArray, dArray.length);
        dArray = dArray2;
        this.b = ch_0.a(dArray2, dArray.length);
    }

    public final double a(double d2) {
        int n2 = Arrays.binarySearch(this.a, d2);
        double d3 = n2 < -1 ? this.b[-n2 - 2] : (n2 >= 0 ? this.b[n2] : this.b[0]);
        return d3;
    }
}

