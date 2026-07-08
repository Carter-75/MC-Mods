/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.wm_0;
import org.valkyrienskies.core.impl.shadow.ws_0;

final class vP
extends wm_0 {
    private static final long n = 20111120L;

    public vP() {
    }

    private vP(vP vP2) {
        super(vP2);
    }

    public final ws_0 a() {
        return new vP(this);
    }

    public final void a(double d2, double d3) {
        if (this.a != null && d2 <= 0.5) {
            for (int i2 = 0; i2 < this.g.length; ++i2) {
                this.g[i2] = this.a[i2] + d2 * this.d * this.b[0][i2];
            }
            System.arraycopy(this.b[0], 0, this.h, 0, this.h.length);
            return;
        }
        for (int i3 = 0; i3 < this.g.length; ++i3) {
            this.g[i3] = this.e[i3] - d3 * this.b[0][i3];
        }
        System.arraycopy(this.b[0], 0, this.h, 0, this.h.length);
    }
}

