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
import org.valkyrienskies.core.impl.shadow.po_0;

public final class lT
implements kS,
ln_0 {
    private final double a;
    private final double b;

    public lT() {
        this(0.0, 1.0);
    }

    public lT(double d2, double d3) {
        this.a = d2;
        this.b = d3;
    }

    public final double a(double d2) {
        return lT.a(d2, this.a, this.b);
    }

    @Deprecated
    public final lc_0 a() {
        return kV.a((ln_0)this).a();
    }

    static double a(double d2, double d3, double d4) {
        if (d2 < d3 || d2 > d4) {
            throw new po_0(d2, (Number)d3, d4);
        }
        return BY.k((d2 - d3) / (d4 - d2));
    }

    public final lg_0 a(lg_0 lg_02) {
        lg_0 lg_03 = lg_02;
        double d2 = lg_03.b[0];
        if (d2 < this.a || d2 > this.b) {
            throw new po_0(d2, (Number)this.a, this.b);
        }
        double[] dArray = new double[lg_02.D() + 1];
        double[] dArray2 = dArray;
        dArray[0] = BY.k((d2 - this.a) / (this.b - d2));
        if (Double.isInfinite(dArray2[0])) {
            if (dArray2.length > 1) {
                dArray2[1] = Double.POSITIVE_INFINITY;
            }
            for (int i2 = 2; i2 < dArray2.length; ++i2) {
                dArray2[i2] = dArray2[i2 - 2];
            }
        } else {
            double d3;
            double d4;
            double d5 = d4 = 1.0 / (d2 - this.a);
            double d6 = d3 = 1.0 / (this.b - d2);
            for (int i3 = 1; i3 < dArray2.length; ++i3) {
                dArray2[i3] = d5 + d6;
                d5 *= (double)(-i3) * d4;
                d6 *= (double)i3 * d3;
            }
        }
        return lg_02.a(dArray2);
    }

    static /* synthetic */ double b(double d2, double d3, double d4) {
        return lT.a(d2, d3, d4);
    }

    public static final class a
    implements kZ {
        public final double a(double d2, double ... dArray) {
            org.valkyrienskies.core.impl.shadow.lT$a.a(dArray);
            double d3 = dArray[1];
            double d4 = dArray[0];
            double d5 = d2;
            return lT.a(d5, d4, d3);
        }

        public final double[] b(double d2, double ... dArray) {
            org.valkyrienskies.core.impl.shadow.lT$a.a(dArray);
            double d3 = dArray[0];
            double d4 = dArray[1];
            return new double[]{1.0 / (d3 - d2), 1.0 / (d4 - d2)};
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

