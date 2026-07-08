/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.zA;
import org.valkyrienskies.core.impl.shadow.zF;

public final class zM
implements zA {
    private static final double a = BY.a(3.0);
    private final zF b;

    private zM(zF zF2) {
        this.b = zF2;
    }

    public final double a() {
        return a * (2.0 * this.b.nextDouble() - 1.0);
    }
}

