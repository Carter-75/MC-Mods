/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.wm_0;
import org.valkyrienskies.core.impl.shadow.ws_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.we
 */
final class we_0
extends wm_0 {
    private static final long n = 20140416L;
    private static final double o = BY.a(21.0);

    public we_0() {
    }

    private we_0(we_0 we_02) {
        super(we_02);
    }

    public final ws_0 a() {
        return new we_0(this);
    }

    public final void a(double d2, double d3) {
        double d4 = 1.0 + d2 * (-10.8 + d2 * (36.0 + d2 * (-47.0 + d2 * 21.0)));
        double d5 = d2 * (-13.866666666666667 + d2 * (106.66666666666667 + d2 * (-202.66666666666666 + d2 * 112.0)));
        double d6 = d2 * (12.96 + d2 * (-97.2 + d2 * (194.4 + d2 * -567.0 / 5.0)));
        double d7 = d2 * ((833.0 + 343.0 * o) / 150.0 + d2 * ((-637.0 - 357.0 * o) / 30.0 + d2 * ((392.0 + 287.0 * o) / 15.0 + d2 * (-49.0 - 49.0 * o) / 5.0)));
        double d8 = d2 * ((833.0 - 343.0 * o) / 150.0 + d2 * ((-637.0 + 357.0 * o) / 30.0 + d2 * ((392.0 - 287.0 * o) / 15.0 + d2 * (-49.0 + 49.0 * o) / 5.0)));
        double d9 = d2 * (0.6 + d2 * (-3.0 + d2 * 3.0));
        if (this.a != null && d2 <= 0.5) {
            double d10 = 1.0 + d2 * (-5.4 + d2 * (12.0 + d2 * (-11.75 + d2 * 21.0 / 5.0)));
            double d11 = d2 * (-6.933333333333334 + d2 * (35.55555555555556 + d2 * (-50.666666666666664 + d2 * 112.0 / 5.0)));
            double d12 = d2 * (6.48 + d2 * (-32.4 + d2 * (48.6 + d2 * -567.0 / 25.0)));
            double d13 = d2 * ((833.0 + 343.0 * o) / 300.0 + d2 * ((-637.0 - 357.0 * o) / 90.0 + d2 * ((392.0 + 287.0 * o) / 60.0 + d2 * (-49.0 - 49.0 * o) / 25.0)));
            double d14 = d2 * ((833.0 - 343.0 * o) / 300.0 + d2 * ((-637.0 + 357.0 * o) / 90.0 + d2 * ((392.0 - 287.0 * o) / 60.0 + d2 * (-49.0 + 49.0 * o) / 25.0)));
            double d15 = d2 * (0.3 + d2 * (-1.0 + d2 * 0.75));
            for (int i2 = 0; i2 < this.g.length; ++i2) {
                double d16 = this.b[0][i2];
                double d17 = this.b[1][i2];
                double d18 = this.b[2][i2];
                double d19 = this.b[3][i2];
                double d20 = this.b[4][i2];
                double d21 = this.b[5][i2];
                double d22 = this.b[6][i2];
                this.g[i2] = this.a[i2] + d2 * this.d * (d10 * d16 + d17 * 0.0 + d11 * d18 + d12 * d19 + d13 * d20 + d14 * d21 + d15 * d22);
                this.h[i2] = d4 * d16 + d17 * 0.0 + d5 * d18 + d6 * d19 + d7 * d20 + d8 * d21 + d9 * d22;
            }
            return;
        }
        double d23 = -0.05 + d2 * (0.95 + d2 * (-4.45 + d2 * (7.55 + d2 * -21.0 / 5.0)));
        double d24 = -0.35555555555555557 + d2 * (-0.35555555555555557 + d2 * (-7.288888888888889 + d2 * (28.266666666666666 + d2 * -112.0 / 5.0)));
        double d25 = d2;
        double d26 = d25 * (d25 * (6.48 + d2 * (-25.92 + d2 * 567.0 / 25.0)));
        double d27 = -0.2722222222222222 + d2 * (-0.2722222222222222 + d2 * ((2254.0 + 1029.0 * o) / 900.0 + d2 * ((-1372.0 - 847.0 * o) / 300.0 + d2 * (49.0 + 49.0 * o) / 25.0)));
        double d28 = -0.2722222222222222 + d2 * (-0.2722222222222222 + d2 * ((2254.0 - 1029.0 * o) / 900.0 + d2 * ((-1372.0 + 847.0 * o) / 300.0 + d2 * (49.0 - 49.0 * o) / 25.0)));
        double d29 = -0.05 + d2 * (-0.05 + d2 * (0.25 + d2 * -0.75));
        for (int i3 = 0; i3 < this.g.length; ++i3) {
            double d30 = this.b[0][i3];
            double d31 = this.b[1][i3];
            double d32 = this.b[2][i3];
            double d33 = this.b[3][i3];
            double d34 = this.b[4][i3];
            double d35 = this.b[5][i3];
            double d36 = this.b[6][i3];
            this.g[i3] = this.e[i3] + d3 * (d23 * d30 + d31 * 0.0 + d24 * d32 + d26 * d33 + d27 * d34 + d28 * d35 + d29 * d36);
            this.h[i3] = d4 * d30 + d31 * 0.0 + d5 * d32 + d6 * d33 + d7 * d34 + d8 * d35 + d9 * d36;
        }
    }
}

