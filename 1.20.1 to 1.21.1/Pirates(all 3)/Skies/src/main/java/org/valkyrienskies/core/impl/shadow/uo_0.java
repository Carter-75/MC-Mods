/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.pk_0;
import org.valkyrienskies.core.impl.shadow.pm_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.uo
 */
public final class uo_0 {
    private final double a;
    private final double b;

    public uo_0(double d2, double d3, long l2) {
        if (d2 <= 0.0) {
            throw new pk_0(d2);
        }
        if (d3 <= 0.0) {
            throw new pk_0(d3);
        }
        if (d3 >= d2) {
            throw new pm_0(d3, (Number)d2, false);
        }
        if (l2 <= 0L) {
            throw new pk_0(l2);
        }
        this.a = d2;
        this.b = -BY.k(d3 / d2) / (double)l2;
    }

    public final double a(long l2) {
        return this.a * BY.i((double)(-l2) * this.b);
    }
}

