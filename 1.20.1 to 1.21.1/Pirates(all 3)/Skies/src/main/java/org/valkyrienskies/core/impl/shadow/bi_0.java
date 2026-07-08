/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.bj_0;
import org.valkyrienskies.core.impl.shadow.bl_0;
import org.valkyrienskies.core.impl.shadow.bm_0;
import org.valkyrienskies.core.impl.shadow.oE;
import org.valkyrienskies.core.impl.shadow.oe_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Bi
 */
public final class bi_0
implements bj_0 {
    public final bl_0 a(int n2, int n3, double d2) {
        bm_0.a(n2, n3, d2);
        double d3 = (1.0 - d2) / 2.0;
        oE oE2 = new oE();
        double d4 = ((oe_0)oE2).a(1.0 - d3);
        double d5 = BY.a(d4, 2);
        double d6 = (double)n2 + d5;
        double d7 = 1.0 / d6 * ((double)n3 + d5 * 0.5);
        double d8 = d4 * BY.a(1.0 / d6 * d7 * (1.0 - d7));
        return new bl_0(d7 - d8, d7 + d8, d2);
    }
}

