/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.List;
import org.valkyrienskies.core.impl.shadow.oV;
import org.valkyrienskies.core.impl.shadow.px_0;
import org.valkyrienskies.core.impl.shadow.zp_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.zo
 */
public final class zo_0 {
    private zo_0() {
    }

    private static boolean a(int n2) {
        if (n2 < 2) {
            return false;
        }
        int[] nArray = zp_0.a;
        int n3 = zp_0.a.length;
        for (int i2 = 0; i2 < n3; ++i2) {
            int n4 = nArray[i2];
            if (0 != n2 % n4) continue;
            return n2 == n4;
        }
        return zp_0.b(n2);
    }

    private static int b(int n2) {
        if (n2 < 0) {
            throw new oV(px_0.NUMBER_TOO_SMALL, n2, 0);
        }
        if (n2 == 2) {
            return 2;
        }
        if ((n2 |= 1) == 1) {
            return 2;
        }
        if (zo_0.a(n2)) {
            return n2;
        }
        int n3 = n2 % 3;
        if (n3 == 0) {
            n2 += 2;
        } else if (1 == n3) {
            n2 += 4;
        }
        while (!zo_0.a(n2)) {
            if (zo_0.a(n2 += 2)) {
                return n2;
            }
            n2 += 4;
        }
        return n2;
    }

    private static List<Integer> c(int n2) {
        if (n2 < 2) {
            throw new oV(px_0.NUMBER_TOO_SMALL, n2, 2);
        }
        return zp_0.a(n2);
    }
}

