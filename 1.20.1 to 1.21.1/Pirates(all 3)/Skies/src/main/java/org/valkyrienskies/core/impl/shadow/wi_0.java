/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.wm_0;
import org.valkyrienskies.core.impl.shadow.ws_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.wi
 */
final class wi_0
extends wm_0 {
    private static final long n = 20111120L;

    public wi_0() {
    }

    private wi_0(wi_0 wi_02) {
        super(wi_02);
    }

    public final ws_0 a() {
        return new wi_0(this);
    }

    public final void a(double d2, double d3) {
        double d4 = d2 * 2.0;
        double d5 = 1.0 - d4;
        if (this.a != null && d2 <= 0.5) {
            double d6 = d2 * d3;
            double d7 = d2;
            double d8 = d7 * d7 * this.d;
            for (int i2 = 0; i2 < this.g.length; ++i2) {
                double d9 = this.b[0][i2];
                double d10 = this.b[1][i2];
                this.g[i2] = this.a[i2] + d6 * d9 + d8 * d10;
                this.h[i2] = d5 * d9 + d4 * d10;
            }
            return;
        }
        double d11 = d3 * d2;
        double d12 = d3 * (d2 + 1.0);
        for (int i3 = 0; i3 < this.g.length; ++i3) {
            double d13 = this.b[0][i3];
            double d14 = this.b[1][i3];
            this.g[i3] = this.e[i3] + d11 * d13 - d12 * d14;
            this.h[i3] = d5 * d13 + d4 * d14;
        }
    }
}

