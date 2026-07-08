/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.mM;

public final class mN
extends mM {
    private static final int h = 2;

    private mN(int n2, double d2, double d3, double d4) {
        super(2, n2, d2, d3, d4);
        for (int i2 = 0; i2 < n2; ++i2) {
            double d5 = (double)i2 * (Math.PI * 2) / (double)n2;
            this.a(new double[]{BY.o(d5), BY.n(d5)}, false);
        }
    }

    private mN(mN mN2) {
        super(mN2);
    }

    private mN c() {
        return new mN(this);
    }

    public final /* synthetic */ mM a() {
        mN mN2 = this;
        return new mN(mN2);
    }
}

