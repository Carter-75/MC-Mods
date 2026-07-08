/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.bj_0;
import org.valkyrienskies.core.impl.shadow.bl_0;
import org.valkyrienskies.core.impl.shadow.bm_0;
import org.valkyrienskies.core.impl.shadow.oo_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Bk
 */
public final class bk_0
implements bj_0 {
    public final bl_0 a(int n2, int n3, double d2) {
        bm_0.a(n2, n3, d2);
        double d3 = 0.0;
        double d4 = 0.0;
        double d5 = (1.0 - d2) / 2.0;
        oo_0 oo_02 = new oo_0(2 * (n2 - n3 + 1), 2 * n3);
        double d6 = oo_02.a(1.0 - d5);
        if (n3 > 0) {
            d3 = (double)n3 / ((double)n3 + (double)(n2 - n3 + 1) * d6);
        }
        oo_02 = new oo_0(2 * (n3 + 1), 2 * (n2 - n3));
        double d7 = oo_02.a(1.0 - d5);
        if (n3 > 0) {
            d4 = (double)(n3 + 1) * d7 / ((double)(n2 - n3) + (double)(n3 + 1) * d7);
        }
        return new bl_0(d3, d4, d2);
    }
}

