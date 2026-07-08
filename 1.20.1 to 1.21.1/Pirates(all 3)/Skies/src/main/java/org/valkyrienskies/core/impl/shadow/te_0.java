/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.pn_0;
import org.valkyrienskies.core.impl.shadow.pu_0;
import org.valkyrienskies.core.impl.shadow.px_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.te
 */
public final class te_0
extends pn_0 {
    private static final long c = 1641613838113738061L;
    private final int d;
    private final double e;

    public te_0(double d2, int n2, double d3) {
        super(d2, (Number)d3, false);
        this.d = n2;
        this.e = d3;
        pu_0 pu_02 = this.a();
        pu_02.a(px_0.NOT_POSITIVE_DEFINITE_MATRIX, new Object[0]);
        pu_02.a(px_0.ARRAY_ELEMENT, d2, n2);
    }

    private int b() {
        return this.d;
    }

    private int c() {
        return this.d;
    }

    private double d() {
        return this.e;
    }
}

