/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.bi_0;
import org.valkyrienskies.core.impl.shadow.bk_0;
import org.valkyrienskies.core.impl.shadow.bl_0;
import org.valkyrienskies.core.impl.shadow.bn_0;
import org.valkyrienskies.core.impl.shadow.bo_0;
import org.valkyrienskies.core.impl.shadow.pj_0;
import org.valkyrienskies.core.impl.shadow.pk_0;
import org.valkyrienskies.core.impl.shadow.pm_0;
import org.valkyrienskies.core.impl.shadow.po_0;
import org.valkyrienskies.core.impl.shadow.px_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Bm
 */
public final class bm_0 {
    private static final bi_0 a = new bi_0();
    private static final bk_0 b = new bk_0();
    private static final bn_0 c = new bn_0();
    private static final bo_0 d = new bo_0();

    private bm_0() {
    }

    private static bl_0 b(int n2, int n3, double d2) {
        return a.a(n2, n3, d2);
    }

    private static bl_0 c(int n2, int n3, double d2) {
        return b.a(n2, n3, d2);
    }

    private static bl_0 d(int n2, int n3, double d2) {
        return c.a(n2, n3, d2);
    }

    private static bl_0 e(int n2, int n3, double d2) {
        return d.a(n2, n3, d2);
    }

    static void a(int n2, int n3, double d2) {
        if (n2 <= 0) {
            throw new pk_0(px_0.NUMBER_OF_TRIALS, n2);
        }
        if (n3 < 0) {
            throw new pj_0(px_0.NEGATIVE_NUMBER_OF_SUCCESSES, n3);
        }
        if (n3 > n2) {
            throw new pm_0(px_0.NUMBER_OF_SUCCESS_LARGER_THAN_POPULATION_SIZE, (Number)n3, n2, true);
        }
        if (d2 <= 0.0 || d2 >= 1.0) {
            throw new po_0(px_0.OUT_OF_BOUNDS_CONFIDENCE_LEVEL, (Number)d2, 0, 1);
        }
    }
}

