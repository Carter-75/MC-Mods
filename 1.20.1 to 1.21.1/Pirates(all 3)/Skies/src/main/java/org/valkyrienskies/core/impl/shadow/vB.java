/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.wm_0;
import org.valkyrienskies.core.impl.shadow.ws_0;

final class vB
extends wm_0 {
    private static final long n = 20111120L;

    public vB() {
    }

    private vB(vB vB2) {
        super(vB2);
    }

    public final ws_0 a() {
        return new vB(this);
    }

    public final void a(double d2, double d3) {
        double d4 = 1.0 - d2;
        double d5 = 1.0 - d2 * 2.0;
        double d6 = d4 * d5;
        double d7 = d2 * 2.0 * d4;
        double d8 = -d2 * d5;
        if (this.a != null && d2 <= 0.5) {
            double d9 = d2 * 4.0 * d2;
            double d10 = d2 * this.d / 6.0;
            double d11 = d10 * (6.0 - d2 * 9.0 + d9);
            double d12 = d10 * (d2 * 6.0 - d9);
            double d13 = d10 * (d2 * -3.0 + d9);
            for (int i2 = 0; i2 < this.g.length; ++i2) {
                double d14 = this.b[0][i2];
                double d15 = this.b[1][i2] + this.b[2][i2];
                double d16 = this.b[3][i2];
                this.g[i2] = this.a[i2] + d11 * d14 + d12 * d15 + d13 * d16;
                this.h[i2] = d6 * d14 + d7 * d15 + d8 * d16;
            }
            return;
        }
        double d17 = d2 * 4.0;
        double d18 = d3 / 6.0;
        double d19 = d18 * ((-d17 + 5.0) * d2 - 1.0);
        double d20 = d18 * ((d17 - 2.0) * d2 - 2.0);
        double d21 = d18 * ((-d17 - 1.0) * d2 - 1.0);
        for (int i3 = 0; i3 < this.g.length; ++i3) {
            double d22 = this.b[0][i3];
            double d23 = this.b[1][i3] + this.b[2][i3];
            double d24 = this.b[3][i3];
            this.g[i3] = this.e[i3] + d19 * d22 + d20 * d23 + d21 * d24;
            this.h[i3] = d6 * d22 + d7 * d23 + d8 * d24;
        }
    }
}

