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
 * Renamed from org.valkyrienskies.core.impl.shadow.Bn
 */
public final class bn_0
implements bj_0 {
    public final bl_0 a(int n2, int n3, double d2) {
        bm_0.a(n2, n3, d2);
        double d3 = (double)n3 / (double)n2;
        double d4 = (1.0 - d2) / 2.0;
        oE oE2 = new oE();
        double d5 = ((oe_0)oE2).a(1.0 - d4) * BY.a(1.0 / (double)n2 * d3 * (1.0 - d3));
        return new bl_0(d3 - d5, d3 + d5, d2);
    }
}

