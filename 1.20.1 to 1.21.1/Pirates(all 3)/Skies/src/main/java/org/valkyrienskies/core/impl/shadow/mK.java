/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.ArrayList;
import java.util.List;
import org.valkyrienskies.core.impl.shadow.ch_0;
import org.valkyrienskies.core.impl.shadow.ci_0;
import org.valkyrienskies.core.impl.shadow.kN;
import org.valkyrienskies.core.impl.shadow.pf_0;
import org.valkyrienskies.core.impl.shadow.pr_0;
import org.valkyrienskies.core.impl.shadow.px_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public final class mK<T extends kN<T>> {
    private final List<T> a = new ArrayList<T>();
    private final List<T[]> b = new ArrayList<T[]>();
    private final List<T[]> c = new ArrayList<T[]>();

    private void a(T t, T[] ... TArray) {
        ci_0.a(t);
        kN kN2 = (kN)t.c().b();
        for (int i2 = 0; i2 < TArray.length; ++i2) {
            kN[] kNArray = (kN[])TArray[i2].clone();
            if (i2 > 1) {
                kN2 = (kN)kN2.a(i2);
                kN kN3 = (kN)kN2.b();
                for (int i3 = 0; i3 < kNArray.length; ++i3) {
                    kNArray[i3] = kNArray[i3].c(kN3);
                }
            }
            int n2 = this.a.size();
            this.c.add(n2 - i2, kNArray);
            kN[] kNArray2 = kNArray;
            for (int i4 = i2; i4 < n2; ++i4) {
                kN[] kNArray3 = (kN[])this.c.get(n2 - (i4 + 1));
                if (t.equals(this.a.get(n2 - (i4 + 1)))) {
                    throw new pr_0(px_0.DUPLICATED_ABSCISSA_DIVISION_BY_ZERO, t);
                }
                kN kN4 = (kN)((kN)t.b(this.a.get(n2 - (i4 + 1)))).b();
                for (int i5 = 0; i5 < kNArray.length; ++i5) {
                    kNArray3[i5] = kN4.c(kNArray2[i5].b(kNArray3[i5]));
                }
                kNArray2 = kNArray3;
            }
            this.b.add((T[])kNArray2.clone());
            this.a.add(t);
        }
    }

    private T[] a(T t) {
        ci_0.a(t);
        if (this.a.isEmpty()) {
            throw new pf_0(px_0.EMPTY_INTERPOLATION_SAMPLE);
        }
        kN[] kNArray = (kN[])ch_0.a(t.c(), ((kN[])this.b.get(0)).length);
        kN kN2 = (kN)t.c().b();
        for (int i2 = 0; i2 < this.b.size(); ++i2) {
            kN[] kNArray2 = (kN[])this.b.get(i2);
            for (int i3 = 0; i3 < kNArray.length; ++i3) {
                kNArray[i3] = kNArray[i3].a(kNArray2[i3].c(kN2));
            }
            kN kN3 = (kN)t.b(this.a.get(i2));
            kN2 = kN2.c(kN3);
        }
        return kNArray;
    }

    private T[][] a(T t, int n2) {
        ci_0.a(t);
        if (this.a.isEmpty()) {
            throw new pf_0(px_0.EMPTY_INTERPOLATION_SAMPLE);
        }
        kN kN2 = (kN)t.c().a();
        kN[] kNArray = (kN[])t.c().b();
        kN[] kNArray2 = (kN[])ch_0.a(t.c(), n2 + 1);
        kN[] kNArray3 = kNArray2;
        kNArray2[0] = kN2;
        for (int i2 = 0; i2 < n2; ++i2) {
            kNArray3[i2 + 1] = kNArray3[i2].a(kNArray);
        }
        kN[][] kNArray4 = (kN[][])ch_0.a(t.c(), n2 + 1, ((kN[])this.b.get(0)).length);
        kN[] kNArray5 = (kN[])ch_0.a(t.c(), n2 + 1);
        kNArray = kNArray5;
        kNArray5[0] = (kN)t.c().b();
        for (int i3 = 0; i3 < this.b.size(); ++i3) {
            kN[] kNArray6 = (kN[])this.b.get(i3);
            kN kN3 = (kN)t.b(this.a.get(i3));
            for (int i4 = n2; i4 >= 0; --i4) {
                for (int i5 = 0; i5 < kNArray4[i4].length; ++i5) {
                    kNArray4[i4][i5] = kNArray4[i4][i5].a(kNArray6[i5].c(kNArray[i4]));
                }
                kNArray[i4] = kNArray[i4].c(kN3);
                if (i4 <= 0) continue;
                kNArray[i4] = kNArray[i4].a(kNArray3[i4].c(kNArray[i4 - 1]));
            }
        }
        return kNArray4;
    }
}

