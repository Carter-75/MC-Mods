/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.zA;
import org.valkyrienskies.core.impl.shadow.zF;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.zv
 */
public final class zv_0
implements zA {
    private final zF a;

    private zv_0(zF zF2) {
        this.a = zF2;
    }

    public final double a() {
        return this.a.nextGaussian();
    }
}

