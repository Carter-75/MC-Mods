/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.wm_0;
import org.valkyrienskies.core.impl.shadow.ws_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.wa
 */
final class wa_0
extends wm_0 {
    private static final long n = 20111120L;

    public wa_0() {
    }

    private wa_0(wa_0 wa_02) {
        super(wa_02);
    }

    public final ws_0 a() {
        return new wa_0(this);
    }

    public final void a(double d2, double d3) {
        double d4 = 1.0 + d2 * (-7.5 + d2 * (16.0 - d2 * 10.0));
        double d5 = d2 * (28.6875 + d2 * (-91.125 + d2 * 67.5));
        double d6 = d2 * (-44.0 + d2 * (152.0 - d2 * 120.0));
        double d7 = d2 * (23.4375 + d2 * (-78.125 + d2 * 62.5));
        double d8 = d2 * 5.0 / 8.0 * (d2 * 2.0 - 1.0);
        if (this.a != null && d2 <= 0.5) {
            double d9 = this.d * d2;
            double d10 = d9 * (1.0 + d2 * (-3.75 + d2 * (5.333333333333333 - d2 * 2.5)));
            double d11 = d9 * (d2 * (14.34375 + d2 * (-30.375 + d2 * 135.0 / 8.0)));
            double d12 = d9 * (d2 * (-22.0 + d2 * (50.666666666666664 + d2 * -30.0)));
            double d13 = d9 * (d2 * (11.71875 + d2 * (-26.041666666666668 + d2 * 125.0 / 8.0)));
            double d14 = d9 * (d2 * (-0.3125 + d2 * 5.0 / 12.0));
            for (int i2 = 0; i2 < this.g.length; ++i2) {
                double d15 = this.b[0][i2];
                double d16 = this.b[2][i2];
                double d17 = this.b[3][i2];
                double d18 = this.b[4][i2];
                double d19 = this.b[5][i2];
                this.g[i2] = this.a[i2] + d10 * d15 + d11 * d16 + d12 * d17 + d13 * d18 + d14 * d19;
                this.h[i2] = d4 * d15 + d5 * d16 + d6 * d17 + d7 * d18 + d8 * d19;
            }
            return;
        }
        double d20 = d2;
        double d21 = d20 * d20;
        double d22 = this.d * (-0.08333333333333333 + d2 * (1.0 + d2 * (-3.75 + d2 * (5.333333333333333 + d2 * -5.0 / 2.0))));
        double d23 = this.d * (-0.84375 + d21 * (14.34375 + d2 * (-30.375 + d2 * 135.0 / 8.0)));
        double d24 = this.d * (1.3333333333333333 + d21 * (-22.0 + d2 * (50.666666666666664 + d2 * -30.0)));
        double d25 = this.d * (-1.3020833333333333 + d21 * (11.71875 + d2 * (-26.041666666666668 + d2 * 125.0 / 8.0)));
        double d26 = this.d * (-0.10416666666666667 + d21 * (-0.3125 + d2 * 5.0 / 12.0));
        for (int i3 = 0; i3 < this.g.length; ++i3) {
            double d27 = this.b[0][i3];
            double d28 = this.b[2][i3];
            double d29 = this.b[3][i3];
            double d30 = this.b[4][i3];
            double d31 = this.b[5][i3];
            this.g[i3] = this.e[i3] + d22 * d27 + d23 * d28 + d24 * d29 + d25 * d30 + d26 * d31;
            this.h[i3] = d4 * d27 + d5 * d28 + d6 * d29 + d7 * d30 + d8 * d31;
        }
    }
}

