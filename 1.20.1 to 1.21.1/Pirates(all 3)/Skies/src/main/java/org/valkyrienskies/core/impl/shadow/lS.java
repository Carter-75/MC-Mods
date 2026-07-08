/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.kS;
import org.valkyrienskies.core.impl.shadow.kV;
import org.valkyrienskies.core.impl.shadow.kZ;
import org.valkyrienskies.core.impl.shadow.lc_0;
import org.valkyrienskies.core.impl.shadow.lg_0;
import org.valkyrienskies.core.impl.shadow.ln_0;
import org.valkyrienskies.core.impl.shadow.oS;
import org.valkyrienskies.core.impl.shadow.pk_0;
import org.valkyrienskies.core.impl.shadow.pl_0;

public final class lS
implements kS,
ln_0 {
    private final double a;
    private final double b;
    private final double c;
    private final double d;
    private final double e;
    private final double f;

    public lS(double d2, double d3, double d4, double d5, double d6, double d7) {
        this.b = d2;
        this.f = d3;
        this.c = d4;
        this.e = 1.0;
        this.a = 0.0;
        this.d = 1.0;
    }

    public final double a(double d2) {
        return lS.b(this.f - d2, this.b, this.c, this.e, this.a, this.d);
    }

    @Deprecated
    public final lc_0 a() {
        return kV.a((ln_0)this).a();
    }

    private static double b(double d2, double d3, double d4, double d5, double d6, double d7) {
        return d6 + (d3 - d6) / BY.a(1.0 + d5 * BY.i(d4 * d2), d7);
    }

    public final lg_0 a(lg_0 lg_02) {
        return lg_02.G().h(this.f).j(this.c).K().j(this.e).h(1.0).k(this.d).H().j(this.b - this.a).h(this.a);
    }

    public static final class a
    implements kZ {
        public final double a(double d2, double ... dArray) {
            org.valkyrienskies.core.impl.shadow.lS$a.a(dArray);
            return lS.b(dArray[1] - d2, dArray[0], dArray[2], dArray[3], dArray[4], 1.0 / dArray[5]);
        }

        public final double[] b(double d2, double ... dArray) {
            org.valkyrienskies.core.impl.shadow.lS$a.a(dArray);
            double d3 = dArray[2];
            double d4 = dArray[3];
            double d5 = dArray[1] - d2;
            double d6 = 1.0 / dArray[5];
            double d7 = BY.i(d3 * d5);
            double d8 = d4 * d7;
            double d9 = d8 + 1.0;
            double d10 = (dArray[0] - dArray[4]) * d6 / BY.a(d9, d6);
            double d11 = -d10 / d9;
            double d12 = lS.b(d5, 1.0, d3, d4, 0.0, d6);
            double d13 = d11 * d3 * d8;
            double d14 = d11 * d5 * d8;
            double d15 = d11 * d7;
            double d16 = lS.b(d5, 0.0, d3, d4, 1.0, d6);
            double d17 = d10 * BY.k(d9) * d6;
            return new double[]{d12, d13, d14, d15, d16, d17};
        }

        private static void a(double[] dArray) {
            if (dArray == null) {
                throw new pl_0();
            }
            if (dArray.length != 6) {
                throw new oS(dArray.length, 6);
            }
            if (dArray[5] <= 0.0) {
                throw new pk_0(dArray[5]);
            }
        }
    }
}

