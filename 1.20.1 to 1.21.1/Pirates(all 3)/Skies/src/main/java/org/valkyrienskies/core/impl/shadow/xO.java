/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.pm_0;
import org.valkyrienskies.core.impl.shadow.po_0;
import org.valkyrienskies.core.impl.shadow.wO;

public final class xO
implements wO {
    final double a;
    final double b;
    final double c;

    public xO(double d2, double d3, double d4) {
        if (d2 >= d3) {
            throw new pm_0(d2, (Number)d3, false);
        }
        if (d4 < d2 || d4 > d3) {
            throw new po_0(d4, (Number)d2, d3);
        }
        this.a = d2;
        this.b = d3;
        this.c = d4;
    }

    private xO(double d2, double d3) {
        this(d2, d3, 0.5 * (d2 + d3));
    }

    public final double a() {
        return this.a;
    }

    public final double b() {
        return this.b;
    }

    public final double c() {
        return this.c;
    }
}

