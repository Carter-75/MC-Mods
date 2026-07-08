/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.lS;
import org.valkyrienskies.core.impl.shadow.pk_0;
import org.valkyrienskies.core.impl.shadow.pm_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.up
 */
public final class up_0 {
    private final lS a;
    private final double b;

    public up_0(double d2, double d3, long l2) {
        if (d2 <= 0.0) {
            throw new pk_0(d2);
        }
        if (d3 >= 0.0) {
            throw new pm_0(d3, (Number)0, false);
        }
        if (l2 <= 1L) {
            throw new pk_0(l2);
        }
        double d4 = d2;
        double d5 = l2;
        double d6 = d3 * 4.0 / d2;
        this.a = new lS(d4, d5, d6, 1.0, 0.0, 1.0);
        double d7 = this.a.a(0.0);
        this.b = d4 / d7;
    }

    public final double a(long l2) {
        return this.b * this.a.a(l2);
    }
}

