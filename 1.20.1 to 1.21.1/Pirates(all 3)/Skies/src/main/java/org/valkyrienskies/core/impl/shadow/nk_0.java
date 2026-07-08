/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.ci_0;
import org.valkyrienskies.core.impl.shadow.lg_0;
import org.valkyrienskies.core.impl.shadow.ln_0;
import org.valkyrienskies.core.impl.shadow.oS;
import org.valkyrienskies.core.impl.shadow.pf_0;
import org.valkyrienskies.core.impl.shadow.px_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.nk
 */
public final class nk_0
implements ln_0 {
    private double[] a;
    private final double[] b;
    private final double[] c;
    private boolean d;

    public nk_0(double[] dArray, double[] dArray2) {
        nk_0.a(dArray, dArray2);
        this.c = new double[dArray.length];
        this.b = new double[dArray2.length];
        System.arraycopy(dArray, 0, this.c, 0, dArray.length);
        System.arraycopy(dArray2, 0, this.b, 0, dArray2.length);
        this.d = false;
    }

    public final double a(double d2) {
        double d3 = d2;
        double[] dArray = this.b;
        double[] dArray2 = this.c;
        nk_0.a(this.c, dArray);
        int n2 = dArray.length;
        double d4 = dArray2[n2];
        --n2;
        while (n2 >= 0) {
            d4 = dArray2[n2] + (d3 - dArray[n2]) * d4;
            --n2;
        }
        return d4;
    }

    public final lg_0 a(lg_0 lg_02) {
        nk_0.a(this.c, this.b);
        int n2 = this.b.length;
        lg_0 lg_03 = new lg_0(lg_02.C(), lg_02.D(), this.c[n2]);
        --n2;
        while (n2 >= 0) {
            double d2 = this.b[n2];
            lg_0 lg_04 = lg_02;
            lg_03 = lg_04.h(-d2).b(lg_03).h(this.c[n2]);
            --n2;
        }
        return lg_03;
    }

    private int a() {
        return this.b.length;
    }

    private double[] b() {
        double[] dArray = new double[this.c.length];
        System.arraycopy(this.c, 0, dArray, 0, this.c.length);
        return dArray;
    }

    private double[] c() {
        double[] dArray = new double[this.b.length];
        System.arraycopy(this.b, 0, dArray, 0, this.b.length);
        return dArray;
    }

    private double[] d() {
        Object object;
        if (!this.d) {
            int n2;
            object = this;
            nk_0 nk_02 = object;
            int n3 = ((nk_0)object).b.length;
            ((nk_0)object).a = new double[n3 + 1];
            for (n2 = 0; n2 <= n3; ++n2) {
                ((nk_0)object).a[n2] = 0.0;
            }
            ((nk_0)object).a[0] = ((nk_0)object).c[n3];
            for (n2 = n3 - 1; n2 >= 0; --n2) {
                for (int i2 = n3 - n2; i2 > 0; --i2) {
                    ((nk_0)object).a[i2] = ((nk_0)object).a[i2 - 1] - ((nk_0)object).b[n2] * ((nk_0)object).a[i2];
                }
                ((nk_0)object).a[0] = ((nk_0)object).c[n2] - ((nk_0)object).b[n2] * ((nk_0)object).a[0];
            }
            ((nk_0)object).d = true;
        }
        object = new double[this.a.length];
        System.arraycopy(this.a, 0, object, 0, this.a.length);
        return object;
    }

    private static double a(double[] dArray, double[] dArray2, double d2) {
        nk_0.a(dArray, dArray2);
        int n2 = dArray2.length;
        double d3 = dArray[n2];
        --n2;
        while (n2 >= 0) {
            d3 = dArray[n2] + (d2 - dArray2[n2]) * d3;
            --n2;
        }
        return d3;
    }

    private void e() {
        int n2;
        nk_0 nk_02 = this;
        int n3 = nk_02.b.length;
        this.a = new double[n3 + 1];
        for (n2 = 0; n2 <= n3; ++n2) {
            this.a[n2] = 0.0;
        }
        this.a[0] = this.c[n3];
        for (n2 = n3 - 1; n2 >= 0; --n2) {
            for (int i2 = n3 - n2; i2 > 0; --i2) {
                this.a[i2] = this.a[i2 - 1] - this.b[n2] * this.a[i2];
            }
            this.a[0] = this.c[n2] - this.b[n2] * this.a[0];
        }
        this.d = true;
    }

    private static void a(double[] dArray, double[] dArray2) {
        ci_0.a((Object)dArray);
        ci_0.a((Object)dArray2);
        if (dArray.length == 0 || dArray2.length == 0) {
            throw new pf_0(px_0.EMPTY_POLYNOMIALS_COEFFICIENTS_ARRAY);
        }
        if (dArray.length != dArray2.length + 1) {
            throw new oS(px_0.ARRAY_SIZES_SHOULD_HAVE_DIFFERENCE_1, dArray.length, dArray2.length);
        }
    }
}

