/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Arrays;
import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.cq_0;
import org.valkyrienskies.core.impl.shadow.kS;
import org.valkyrienskies.core.impl.shadow.kV;
import org.valkyrienskies.core.impl.shadow.kZ;
import org.valkyrienskies.core.impl.shadow.lc_0;
import org.valkyrienskies.core.impl.shadow.lg_0;
import org.valkyrienskies.core.impl.shadow.ln_0;
import org.valkyrienskies.core.impl.shadow.oS;
import org.valkyrienskies.core.impl.shadow.pk_0;
import org.valkyrienskies.core.impl.shadow.pl_0;

public final class lL
implements kS,
ln_0 {
    private final double a;
    private final double b;
    private final double c;
    private final double d;

    public lL(double d2, double d3, double d4) {
        if (d4 <= 0.0) {
            throw new pk_0(d4);
        }
        this.d = d2;
        this.a = d3;
        this.b = 1.0 / d4;
        this.c = 0.5 * this.b * this.b;
    }

    private lL(double d2, double d3) {
        this(1.0 / (1.0 * BY.a(Math.PI * 2)), 0.0, 1.0);
    }

    public lL() {
        this(0.0, 1.0);
    }

    public final double a(double d2) {
        return lL.a(d2 - this.a, this.d, this.c);
    }

    @Deprecated
    public final lc_0 a() {
        return kV.a((ln_0)this).a();
    }

    static double a(double d2, double d3, double d4) {
        return d3 * BY.i(-d2 * d2 * d4);
    }

    public final lg_0 a(lg_0 lg_02) {
        double d2;
        lg_0 lg_03 = lg_02;
        double d3 = this.b * (lg_03.b[0] - this.a);
        double[] dArray = new double[lg_02.D() + 1];
        double[] dArray2 = new double[dArray.length];
        double[] dArray3 = dArray2;
        dArray2[0] = 1.0;
        double d4 = d3;
        double d5 = d4 * d4;
        double d6 = this.d * BY.i(d5 * -0.5);
        if (d2 <= cq_0.b) {
            Arrays.fill(dArray, 0.0);
        } else {
            dArray[0] = d6;
            for (int i2 = 1; i2 < dArray.length; ++i2) {
                double d7 = 0.0;
                dArray3[i2] = -dArray3[i2 - 1];
                for (int i3 = i2; i3 >= 0; i3 -= 2) {
                    d7 = d7 * d5 + dArray3[i3];
                    if (i3 > 2) {
                        dArray3[i3 - 2] = (double)(i3 - 1) * dArray3[i3 - 1] - dArray3[i3 - 3];
                        continue;
                    }
                    if (i3 != 2) continue;
                    dArray3[0] = dArray3[1];
                }
                if ((i2 & 1) == 1) {
                    d7 *= d3;
                }
                dArray[i2] = (d6 *= this.b) * d7;
            }
        }
        return lg_02.a(dArray);
    }

    static /* synthetic */ double b(double d2, double d3, double d4) {
        return lL.a(d2, d3, d4);
    }

    public static class a
    implements kZ {
        public double a(double d2, double ... dArray) {
            double d3;
            org.valkyrienskies.core.impl.shadow.lL$a.a(dArray);
            double d4 = d2 - dArray[1];
            double d5 = d3 = 1.0 / (2.0 * dArray[2] * dArray[2]);
            double d6 = dArray[0];
            double d7 = d4;
            return lL.a(d7, d6, d5);
        }

        public double[] b(double d2, double ... dArray) {
            double d3;
            org.valkyrienskies.core.impl.shadow.lL$a.a(dArray);
            double d4 = dArray[0];
            double d5 = d2 - dArray[1];
            double d6 = dArray[2];
            double d7 = d3 = 1.0 / (d6 * 2.0 * d6);
            double d8 = 1.0;
            double d9 = d5;
            double d10 = lL.a(d9, d8, d7);
            double d11 = d4 * d10 * 2.0 * d3 * d5;
            double d12 = d11 * d5 / d6;
            return new double[]{d10, d11, d12};
        }

        private static void a(double[] dArray) {
            if (dArray == null) {
                throw new pl_0();
            }
            if (dArray.length != 3) {
                throw new oS(dArray.length, 3);
            }
            if (dArray[2] <= 0.0) {
                throw new pk_0(dArray[2]);
            }
        }
    }
}

