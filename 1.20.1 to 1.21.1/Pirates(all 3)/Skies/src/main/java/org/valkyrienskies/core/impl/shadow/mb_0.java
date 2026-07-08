/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.valkyrienskies.core.impl.shadow.mb
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Arrays;
import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.kS;
import org.valkyrienskies.core.impl.shadow.kV;
import org.valkyrienskies.core.impl.shadow.kZ;
import org.valkyrienskies.core.impl.shadow.lc_0;
import org.valkyrienskies.core.impl.shadow.lg_0;
import org.valkyrienskies.core.impl.shadow.ln_0;
import org.valkyrienskies.core.impl.shadow.mb;
import org.valkyrienskies.core.impl.shadow.oS;
import org.valkyrienskies.core.impl.shadow.pl_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.mb
 */
public final class mb_0
implements kS,
ln_0 {
    private final double a;
    private final double b;

    public mb_0() {
        this(0.0, 1.0);
    }

    public mb_0(double d2, double d3) {
        this.a = d2;
        this.b = d3;
    }

    @Deprecated
    public final lc_0 a() {
        return kV.a((ln_0)this).a();
    }

    public final double a(double d2) {
        return mb_0.a(d2, this.a, this.b);
    }

    static double a(double d2, double d3, double d4) {
        return d3 + (d4 - d3) / (1.0 + BY.i(-d2));
    }

    public final lg_0 a(lg_0 lg_02) {
        double[] dArray = new double[lg_02.D() + 1];
        lg_0 lg_03 = lg_02;
        double d2 = BY.i(-lg_03.b[0]);
        if (Double.isInfinite(d2)) {
            dArray[0] = this.a;
            Arrays.fill(dArray, 1, dArray.length, 0.0);
        } else {
            double[] dArray2 = new double[dArray.length];
            double d3 = 1.0 / (d2 + 1.0);
            double d4 = this.b - this.a;
            for (int i2 = 0; i2 < dArray.length; ++i2) {
                double d5 = 0.0;
                dArray2[i2] = 1.0;
                for (int i3 = i2; i3 >= 0; --i3) {
                    d5 = d5 * d2 + dArray2[i3];
                    if (i3 > 1) {
                        dArray2[i3 - 1] = (double)(i2 - i3 + 2) * dArray2[i3 - 2] - (double)(i3 - 1) * dArray2[i3 - 1];
                        continue;
                    }
                    dArray2[0] = 0.0;
                }
                dArray[i2] = (d4 *= d3) * d5;
            }
            dArray[0] = dArray[0] + this.a;
        }
        return lg_02.a(dArray);
    }

    static /* synthetic */ double b(double d2, double d3, double d4) {
        return mb_0.a(d2, d3, d4);
    }

    public static final class a
    implements kZ {
        public final double a(double d2, double ... dArray) {
            org.valkyrienskies.core.impl.shadow.mb$a.a(dArray);
            double d3 = dArray[1];
            double d4 = dArray[0];
            double d5 = d2;
            return mb.a((double)d5, (double)d4, (double)d3);
        }

        public final double[] b(double d2, double ... dArray) {
            org.valkyrienskies.core.impl.shadow.mb$a.a(dArray);
            double d3 = 1.0 / (1.0 + BY.i(-d2));
            return new double[]{1.0 - d3, d3};
        }

        private static void a(double[] dArray) {
            if (dArray == null) {
                throw new pl_0();
            }
            if (dArray.length != 2) {
                throw new oS(dArray.length, 2);
            }
        }
    }
}

