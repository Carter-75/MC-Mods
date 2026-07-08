/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.wm_0;
import org.valkyrienskies.core.impl.shadow.ws_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.wq
 */
final class wq_0
extends wm_0 {
    private static final long n = 20111120L;

    public wq_0() {
    }

    private wq_0(wq_0 wq_02) {
        super(wq_02);
    }

    public final ws_0 a() {
        return new wq_0(this);
    }

    public final void a(double d2, double d3) {
        double d4 = d2 * 0.75;
        double d5 = d4 * (d2 * 4.0 - 5.0) + 1.0;
        double d6 = d4 * (5.0 - d2 * 6.0);
        double d7 = d4 * (d2 * 2.0 - 1.0);
        if (this.a != null && d2 <= 0.5) {
            double d8 = d2 * this.d / 8.0;
            double d9 = d2 * 4.0 * d2;
            double d10 = d8 * (8.0 - d2 * 15.0 + d9 * 2.0);
            double d11 = d8 * 3.0 * (d2 * 5.0 - d9);
            double d12 = d8 * 3.0 * d2;
            double d13 = d8 * (d2 * -3.0 + d9);
            for (int i2 = 0; i2 < this.g.length; ++i2) {
                double d14 = this.b[0][i2];
                double d15 = this.b[1][i2];
                double d16 = this.b[2][i2];
                double d17 = this.b[3][i2];
                this.g[i2] = this.a[i2] + d10 * d14 + d11 * d15 + d12 * d16 + d13 * d17;
                this.h[i2] = d5 * d14 + d6 * d15 + d4 * d16 + d7 * d17;
            }
            return;
        }
        double d18 = d3 / 8.0;
        double d19 = d2 * 4.0 * d2;
        double d20 = d18 * (1.0 - d2 * 7.0 + d19 * 2.0);
        double d21 = d18 * 3.0 * (d2 + 1.0 - d19);
        double d22 = d18 * 3.0 * (d2 + 1.0);
        double d23 = d18 * (d2 + 1.0 + d19);
        for (int i3 = 0; i3 < this.g.length; ++i3) {
            double d24 = this.b[0][i3];
            double d25 = this.b[1][i3];
            double d26 = this.b[2][i3];
            double d27 = this.b[3][i3];
            this.g[i3] = this.e[i3] - d20 * d24 - d21 * d25 - d22 * d26 - d23 * d27;
            this.h[i3] = d5 * d24 + d6 * d25 + d4 * d26 + d7 * d27;
        }
    }
}

