/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.wm_0;
import org.valkyrienskies.core.impl.shadow.ws_0;

final class vU
extends wm_0 {
    private static final double n = 1.0 - BY.a(0.5);
    private static final double o = 1.0 + BY.a(0.5);
    private static final long p = 20111120L;

    public vU() {
    }

    private vU(vU vU2) {
        super(vU2);
    }

    public final ws_0 a() {
        return new vU(this);
    }

    public final void a(double d2, double d3) {
        double d4 = d2 * 2.0;
        double d5 = d4 * d4;
        double d6 = d2 * (d4 - 3.0) + 1.0;
        double d7 = d4 * (1.0 - d2);
        double d8 = d7 * n;
        double d9 = d7 * o;
        double d10 = d2 * (d4 - 1.0);
        if (this.a != null && d2 <= 0.5) {
            double d11 = d2 * this.d / 6.0;
            double d12 = d11 * (d2 * 6.0 - d5);
            double d13 = d11 * (6.0 - d2 * 9.0 + d5);
            double d14 = d12 * n;
            double d15 = d12 * o;
            double d16 = d11 * (d2 * -3.0 + d5);
            for (int i2 = 0; i2 < this.g.length; ++i2) {
                double d17 = this.b[0][i2];
                double d18 = this.b[1][i2];
                double d19 = this.b[2][i2];
                double d20 = this.b[3][i2];
                this.g[i2] = this.a[i2] + d13 * d17 + d14 * d18 + d15 * d19 + d16 * d20;
                this.h[i2] = d6 * d17 + d8 * d18 + d9 * d19 + d10 * d20;
            }
            return;
        }
        double d21 = d3 / 6.0;
        double d22 = d21 * (d4 + 2.0 - d5);
        double d23 = d21 * (1.0 - d2 * 5.0 + d5);
        double d24 = d22 * n;
        double d25 = d22 * o;
        double d26 = d21 * (d2 + 1.0 + d5);
        for (int i3 = 0; i3 < this.g.length; ++i3) {
            double d27 = this.b[0][i3];
            double d28 = this.b[1][i3];
            double d29 = this.b[2][i3];
            double d30 = this.b[3][i3];
            this.g[i3] = this.e[i3] - d23 * d27 - d24 * d28 - d25 * d29 - d26 * d30;
            this.h[i3] = d6 * d27 + d8 * d28 + d9 * d29 + d10 * d30;
        }
    }
}

