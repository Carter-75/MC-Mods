/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.ci_0;
import org.valkyrienskies.core.impl.shadow.oS;
import org.valkyrienskies.core.impl.shadow.po_0;
import org.valkyrienskies.core.impl.shadow.zH;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.zw
 */
public final class zw_0
implements zH {
    private static final int[] a = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173};
    private static final int[] b = new int[]{1, 2, 3, 3, 8, 11, 12, 14, 7, 18, 12, 13, 17, 18, 29, 14, 18, 43, 41, 44, 40, 30, 47, 65, 71, 28, 40, 60, 79, 89, 56, 50, 52, 61, 108, 56, 66, 63, 60, 66};
    private final int c;
    private int d = 0;
    private final int[] e;
    private final int[] f;

    private zw_0(int n2) {
        this(n2, a, b);
    }

    private zw_0(int n2, int[] nArray, int[] nArray2) {
        ci_0.a((Object)nArray);
        if (n2 <= 0 || n2 > nArray.length) {
            throw new po_0(n2, (Number)1, a.length);
        }
        if (nArray2 != null && nArray2.length != nArray.length) {
            throw new oS(nArray2.length, nArray.length);
        }
        this.c = n2;
        this.e = (int[])nArray.clone();
        this.f = nArray2 == null ? null : (int[])nArray2.clone();
        this.d = 0;
    }

    public final double[] a() {
        double[] dArray = new double[this.c];
        for (int i2 = 0; i2 < this.c; ++i2) {
            int n2 = this.d;
            double d2 = 1.0 / (double)this.e[i2];
            while (n2 > 0) {
                int n3 = n2 % this.e[i2];
                int n4 = this.e[i2];
                int n5 = i2;
                zw_0 zw_02 = this;
                int n6 = zw_02.f != null ? zw_02.f[n5] * n3 % n4 : n3;
                int n7 = i2;
                dArray[n7] = dArray[n7] + d2 * (double)n6;
                n2 /= this.e[i2];
                d2 /= (double)this.e[i2];
            }
        }
        ++this.d;
        return dArray;
    }

    private int a(int n2, int n3, int n4) {
        if (this.f != null) {
            return this.f[n2] * n4 % n3;
        }
        return n4;
    }

    private double[] a(int n2) {
        this.d = n2;
        return this.a();
    }

    private int b() {
        return this.d;
    }
}

