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
import org.valkyrienskies.core.impl.shadow.pl_0;

public final class lM
implements kS,
ln_0 {
    private final double a;
    private final double b;
    private final double c;

    private lM(double d2, double d3, double d4) {
        this.a = d2;
        this.b = d3;
        this.c = d4;
    }

    public final double a(double d2) {
        double d3 = this.a;
        double d4 = this.b * d2 + this.c;
        return d3 * BY.o(d4);
    }

    @Deprecated
    public final lc_0 a() {
        return kV.a((ln_0)this).a();
    }

    private static double b(double d2, double d3) {
        return d3 * BY.o(d2);
    }

    public final lg_0 a(lg_0 lg_02) {
        lg_0 lg_03 = lg_02;
        double d2 = lg_03.b[0];
        double[] dArray = new double[lg_02.D() + 1];
        double d3 = this.b * d2 + this.c;
        dArray[0] = this.a * BY.o(d3);
        if (dArray.length > 1) {
            dArray[1] = -this.a * this.b * BY.n(d3);
            double d4 = -this.b * this.b;
            for (int i2 = 2; i2 < dArray.length; ++i2) {
                dArray[i2] = d4 * dArray[i2 - 2];
            }
        }
        return lg_02.a(dArray);
    }

    static /* synthetic */ double a(double d2, double d3) {
        double d4 = d3;
        double d5 = d2;
        return d4 * BY.o(d5);
    }

    public static final class a
    implements kZ {
        public final double a(double d2, double ... dArray) {
            org.valkyrienskies.core.impl.shadow.lM$a.a(dArray);
            return lM.a(d2 * dArray[1] + dArray[2], dArray[0]);
        }

        public final double[] b(double d2, double ... dArray) {
            org.valkyrienskies.core.impl.shadow.lM$a.a(dArray);
            double d3 = dArray[0];
            double d4 = dArray[1];
            double d5 = dArray[2];
            double d6 = d4 * d2 + d5;
            double d7 = lM.a(d6, 1.0);
            double d8 = -d3 * BY.n(d6);
            double d9 = d8 * d2;
            return new double[]{d7, d9, d8};
        }

        private static void a(double[] dArray) {
            if (dArray == null) {
                throw new pl_0();
            }
            if (dArray.length != 3) {
                throw new oS(dArray.length, 3);
            }
        }
    }
}

