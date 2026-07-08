/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.kS;
import org.valkyrienskies.core.impl.shadow.lc_0;
import org.valkyrienskies.core.impl.shadow.lg_0;
import org.valkyrienskies.core.impl.shadow.ln_0;

public final class lE
implements kS,
ln_0 {
    private final double a;

    public lE(double d2) {
        this.a = d2;
    }

    public final double a(double d2) {
        return this.a;
    }

    @Deprecated
    private static lE b() {
        return new lE(0.0);
    }

    public final lg_0 a(lg_0 lg_02) {
        return new lg_0(lg_02.C(), lg_02.D(), this.a);
    }

    @Deprecated
    public final /* synthetic */ lc_0 a() {
        return new lE(0.0);
    }
}

