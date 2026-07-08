/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import java.util.Arrays;
import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.ci_0;
import org.valkyrienskies.core.impl.shadow.cj_0;
import org.valkyrienskies.core.impl.shadow.cp_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Cg
 */
public final class cg_0
implements Serializable {
    private static final long b = 20140713L;
    private static final int c = 15;
    public final cp_0 a;

    public cg_0() {
        this.a = new cj_0();
    }

    public cg_0(cj_0 cj_02) {
        ci_0.a(cj_02);
        this.a = cj_02;
    }

    public final cp_0 a() {
        return this.a;
    }

    public final double a(double[] dArray, int[] nArray, int n2) {
        boolean bl;
        int n3 = 0;
        int n4 = dArray.length;
        int n5 = 0;
        boolean bl2 = bl = nArray != null;
        while (n4 - n3 > 15) {
            int n6;
            if (bl && n5 < nArray.length && nArray[n5] >= 0) {
                n6 = nArray[n5];
            } else {
                n6 = cg_0.a(dArray, n3, n4, this.a.a(dArray, n3, n4));
                if (bl && n5 < nArray.length) {
                    nArray[n5] = n6;
                }
            }
            if (n2 == n6) {
                return dArray[n2];
            }
            if (n2 < n6) {
                n4 = n6;
                n5 = BY.a(2 * n5 + 1, bl ? nArray.length : n4);
                continue;
            }
            n3 = n6 + 1;
            n5 = BY.a(2 * n5 + 2, bl ? nArray.length : n4);
        }
        Arrays.sort(dArray, n3, n4);
        return dArray[n2];
    }

    private static int a(double[] dArray, int n2, int n3, int n4) {
        double d2 = dArray[n4];
        dArray[n4] = dArray[n2];
        n4 = n2 + 1;
        int n5 = n3 - 1;
        while (n4 < n5) {
            while (n4 < n5 && dArray[n5] > d2) {
                --n5;
            }
            while (n4 < n5 && dArray[n4] < d2) {
                ++n4;
            }
            if (n4 >= n5) continue;
            double d3 = dArray[n4];
            dArray[n4++] = dArray[n5];
            dArray[n5--] = d3;
        }
        if (n4 >= n3 || dArray[n4] > d2) {
            --n4;
        }
        dArray[n2] = dArray[n4];
        dArray[n4] = d2;
        return n4;
    }
}

