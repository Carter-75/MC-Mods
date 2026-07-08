/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.kS;
import org.valkyrienskies.core.impl.shadow.lc_0;
import org.valkyrienskies.core.impl.shadow.nA;
import org.valkyrienskies.core.impl.shadow.ns_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.nn
 */
@Deprecated
public abstract class nn_0
extends ns_0<kS>
implements nA {
    private lc_0 d;

    protected nn_0(double d2) {
        super(d2);
    }

    private nn_0(double d2, double d3, double d4) {
        super(d2, d3, d4);
    }

    protected final double a(double d2) {
        this.k();
        return this.d.a(d2);
    }

    @Override
    private void a(int n2, kS kS2, double d2, double d3, double d4) {
        super.a(n2, kS2, d2, d3, d4);
        this.d = kS2.a();
    }
}

