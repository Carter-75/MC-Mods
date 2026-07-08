/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.ArrayList;
import java.util.List;
import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.zp_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.zn
 */
final class zn_0 {
    private zn_0() {
    }

    private static List<Integer> a(int n2) {
        int n3;
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        if (1 == (n2 = zp_0.a(n2, arrayList))) {
            return arrayList;
        }
        if (zp_0.b(n2)) {
            arrayList.add(n2);
            return arrayList;
        }
        int n4 = n2;
        int n5 = zp_0.b;
        int n6 = 2;
        int n7 = 1;
        block0: while (true) {
            int n8;
            int n9 = n6;
            for (n8 = 0; n8 < n7; ++n8) {
                long l2 = (long)n6 * (long)n6;
                n6 = (int)((l2 + (long)n5) % (long)n4);
            }
            n8 = 0;
            do {
                int n10;
                int n11 = BY.a(25, n7 - n8);
                int n12 = 1;
                for (n10 = -3; n10 < n11; ++n10) {
                    long l3 = (long)n6 * (long)n6;
                    long l4 = BY.a(n9 - (n6 = (int)((l3 + (long)n5) % (long)n4)));
                    if (0L == l4) {
                        n5 += zp_0.b;
                        n8 = -25;
                        n6 = 2;
                        n7 = 1;
                        break;
                    }
                    long l5 = l4 * (long)n12;
                    if ((n12 = (int)(l5 % (long)n4)) != 0) continue;
                    n3 = zn_0.a(BY.a((int)l4), n4);
                    break block0;
                }
                if (1 == (n10 = zn_0.a(BY.a(n12), n4))) continue;
                n3 = n10;
                break block0;
            } while ((n8 += 25) < n7);
            n7 = 2 * n7;
        }
        n4 = n3;
        arrayList.add(n4);
        arrayList.add(n2 / n4);
        return arrayList;
    }

    private static int b(int n2) {
        int n3 = zp_0.b;
        int n4 = 2;
        int n5 = 1;
        while (true) {
            int n6;
            int n7 = n4;
            for (n6 = 0; n6 < n5; ++n6) {
                long l2 = (long)n4 * (long)n4;
                n4 = (int)((l2 + (long)n3) % (long)n2);
            }
            n6 = 0;
            do {
                int n8;
                int n9 = BY.a(25, n5 - n6);
                int n10 = 1;
                for (n8 = -3; n8 < n9; ++n8) {
                    long l3 = (long)n4 * (long)n4;
                    long l4 = BY.a(n7 - (n4 = (int)((l3 + (long)n3) % (long)n2)));
                    if (0L == l4) {
                        n3 += zp_0.b;
                        n6 = -25;
                        n4 = 2;
                        n5 = 1;
                        break;
                    }
                    long l5 = l4 * (long)n10;
                    if ((n10 = (int)(l5 % (long)n2)) != 0) continue;
                    return zn_0.a(BY.a((int)l4), n2);
                }
                if (1 == (n8 = zn_0.a(BY.a(n10), n2))) continue;
                return n8;
            } while ((n6 += 25) < n5);
            n5 = 2 * n5;
        }
    }

    private static int a(int n2, int n3) {
        if (n2 == 0) {
            return n3;
        }
        if (n3 == 0) {
            return n2;
        }
        int n4 = Integer.numberOfTrailingZeros(n2);
        n2 >>= n4;
        int n5 = Integer.numberOfTrailingZeros(n3);
        n3 >>= n5;
        n4 = BY.a(n4, n5);
        while (n2 != n3) {
            n5 = n2 - n3;
            n3 = BY.a(n2, n3);
            n2 = BY.a(n5);
            n2 >>= Integer.numberOfTrailingZeros(n2);
        }
        return n2 << n4;
    }
}

