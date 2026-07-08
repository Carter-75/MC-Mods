/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.lg_0;
import org.valkyrienskies.core.impl.shadow.ln_0;
import org.valkyrienskies.core.impl.shadow.nN;
import org.valkyrienskies.core.impl.shadow.ns_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.np
 */
public abstract class np_0
extends ns_0<ln_0>
implements nN {
    private ln_0 d;

    protected np_0(double d2) {
        super(d2);
    }

    private np_0(double d2, double d3, double d4) {
        super(d2, d3, d4);
    }

    protected final lg_0 a(double d2) {
        this.k();
        return this.d.a(new lg_0(1, 1, 0, d2));
    }

    @Override
    private void a(int n2, ln_0 ln_02, double d2, double d3, double d4) {
        super.a(n2, ln_02, d2, d3, d4);
        this.d = ln_02;
    }
}

