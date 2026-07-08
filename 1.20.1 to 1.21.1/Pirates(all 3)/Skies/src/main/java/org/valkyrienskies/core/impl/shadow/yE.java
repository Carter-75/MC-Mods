/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.ci_0;
import org.valkyrienskies.core.impl.shadow.kW;
import org.valkyrienskies.core.impl.shadow.lT;
import org.valkyrienskies.core.impl.shadow.mb_0;
import org.valkyrienskies.core.impl.shadow.oS;
import org.valkyrienskies.core.impl.shadow.pn_0;

@Deprecated
public final class yE
implements kW {
    private final kW a;
    private final c[] b;

    private yE(kW kW2, double[] dArray, double[] dArray2) {
        int n2;
        ci_0.a((Object)dArray);
        ci_0.a((Object)dArray2);
        if (dArray.length != dArray2.length) {
            throw new oS(dArray.length, dArray2.length);
        }
        for (n2 = 0; n2 < dArray.length; ++n2) {
            if (dArray2[n2] >= dArray[n2]) continue;
            throw new pn_0(dArray2[n2], (Number)dArray[n2], true);
        }
        this.a = kW2;
        this.b = new c[dArray.length];
        for (n2 = 0; n2 < this.b.length; ++n2) {
            if (Double.isInfinite(dArray[n2])) {
                if (Double.isInfinite(dArray2[n2])) {
                    this.b[n2] = new d();
                    continue;
                }
                this.b[n2] = new e(dArray2[n2]);
                continue;
            }
            this.b[n2] = Double.isInfinite(dArray2[n2]) ? new a(dArray[n2]) : new b(dArray[n2], dArray2[n2]);
        }
    }

    private double[] b(double[] dArray) {
        double[] dArray2 = new double[this.b.length];
        for (int i2 = 0; i2 < this.b.length; ++i2) {
            dArray2[i2] = this.b[i2].a(dArray[i2]);
        }
        return dArray2;
    }

    private double[] c(double[] dArray) {
        double[] dArray2 = new double[this.b.length];
        for (int i2 = 0; i2 < this.b.length; ++i2) {
            dArray2[i2] = this.b[i2].b(dArray[i2]);
        }
        return dArray2;
    }

    public final double a(double[] object) {
        yE yE2 = this;
        double[] dArray = object;
        object = yE2;
        double[] dArray2 = new double[yE2.b.length];
        for (int i2 = 0; i2 < object.b.length; ++i2) {
            dArray2[i2] = object.b[i2].a(dArray[i2]);
        }
        return this.a.a(dArray2);
    }

    static final class b
    implements c {
        private final mb_0 a;
        private final lT b;

        b(double d2, double d3) {
            this.a = new mb_0(d2, d3);
            this.b = new lT(d2, d3);
        }

        public final double a(double d2) {
            return this.a.a(d2);
        }

        public final double b(double d2) {
            return this.b.a(d2);
        }
    }

    static final class e
    implements c {
        private final double a;

        e(double d2) {
            this.a = d2;
        }

        public final double a(double d2) {
            return this.a - BY.i(-d2);
        }

        public final double b(double d2) {
            return -BY.k(this.a - d2);
        }
    }

    static final class a
    implements c {
        private final double a;

        a(double d2) {
            this.a = d2;
        }

        public final double a(double d2) {
            return this.a + BY.i(d2);
        }

        public final double b(double d2) {
            return BY.k(d2 - this.a);
        }
    }

    static final class d
    implements c {
        d() {
        }

        public final double a(double d2) {
            return d2;
        }

        public final double b(double d2) {
            return d2;
        }
    }

    static interface c {
        public double a(double var1);

        public double b(double var1);
    }
}

