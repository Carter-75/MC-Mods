/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.nJ;
import org.valkyrienskies.core.impl.shadow.ni_0;
import org.valkyrienskies.core.impl.shadow.ns_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.no
 */
public abstract class no_0
extends ns_0<ni_0>
implements nJ {
    private ni_0 d;

    protected no_0(double d2) {
        super(d2);
    }

    protected no_0(double d2, double d3) {
        super(d2, d3);
    }

    protected no_0(double d2, double d3, double d4) {
        super(d2, d3, d4);
    }

    @Override
    protected final void a(int n2, ni_0 ni_02, double d2, double d3, double d4) {
        super.a(n2, ni_02, d2, d3, d4);
        this.d = ni_02;
    }

    protected final double[] a() {
        return this.d.b();
    }
}

