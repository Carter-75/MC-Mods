/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.valkyrienskies.core.impl.shadow.ni
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import java.util.Arrays;
import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.ci_0;
import org.valkyrienskies.core.impl.shadow.kS;
import org.valkyrienskies.core.impl.shadow.kZ;
import org.valkyrienskies.core.impl.shadow.lc_0;
import org.valkyrienskies.core.impl.shadow.lg_0;
import org.valkyrienskies.core.impl.shadow.ln_0;
import org.valkyrienskies.core.impl.shadow.ni;
import org.valkyrienskies.core.impl.shadow.pf_0;
import org.valkyrienskies.core.impl.shadow.px_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.ni
 */
public final class ni_0
implements Serializable,
kS,
ln_0 {
    private static final long b = -7726511984200295583L;
    public final double[] a;

    public ni_0(double[] dArray) {
        int n2;
        ci_0.a((Object)dArray);
        if (n2 == 0) {
            throw new pf_0(px_0.EMPTY_POLYNOMIALS_COEFFICIENTS_ARRAY);
        }
        for (n2 = dArray.length; n2 > 1 && dArray[n2 - 1] == 0.0; --n2) {
        }
        this.a = new double[n2];
        System.arraycopy(dArray, 0, this.a, 0, n2);
    }

    public final double a(double d2) {
        return ni_0.a(this.a, d2);
    }

    private int d() {
        return this.a.length - 1;
    }

    public final double[] b() {
        return (double[])this.a.clone();
    }

    protected static double a(double[] dArray, double d2) {
        ci_0.a((Object)dArray);
        int n2 = dArray.length;
        if (n2 == 0) {
            throw new pf_0(px_0.EMPTY_POLYNOMIALS_COEFFICIENTS_ARRAY);
        }
        double d3 = dArray[n2 - 1];
        n2 -= 2;
        while (n2 >= 0) {
            d3 = d2 * d3 + dArray[n2];
            --n2;
        }
        return d3;
    }

    public final lg_0 a(lg_0 lg_02) {
        ci_0.a((Object)this.a);
        int n2 = this.a.length;
        if (n2 == 0) {
            throw new pf_0(px_0.EMPTY_POLYNOMIALS_COEFFICIENTS_ARRAY);
        }
        lg_0 lg_03 = new lg_0(lg_02.C(), lg_02.D(), this.a[n2 - 1]);
        n2 -= 2;
        while (n2 >= 0) {
            lg_03 = lg_03.b(lg_02).h(this.a[n2]);
            --n2;
        }
        return lg_03;
    }

    public final ni_0 a(ni_0 ni_02) {
        int n2 = BY.a(this.a.length, ni_02.a.length);
        int n3 = BY.b(this.a.length, ni_02.a.length);
        double[] dArray = new double[n3];
        for (int i2 = 0; i2 < n2; ++i2) {
            dArray[i2] = this.a[i2] + ni_02.a[i2];
        }
        System.arraycopy(this.a.length < ni_02.a.length ? ni_02.a : this.a, n2, dArray, n2, n3 - n2);
        return new ni_0(dArray);
    }

    private ni_0 c(ni_0 ni_02) {
        int n2;
        int n3 = BY.a(this.a.length, ni_02.a.length);
        int n4 = BY.b(this.a.length, ni_02.a.length);
        double[] dArray = new double[n4];
        for (n2 = 0; n2 < n3; ++n2) {
            dArray[n2] = this.a[n2] - ni_02.a[n2];
        }
        if (this.a.length < ni_02.a.length) {
            for (n2 = n3; n2 < n4; ++n2) {
                dArray[n2] = -ni_02.a[n2];
            }
        } else {
            System.arraycopy(this.a, n3, dArray, n3, n4 - n3);
        }
        return new ni_0(dArray);
    }

    private ni_0 e() {
        double[] dArray = new double[this.a.length];
        for (int i2 = 0; i2 < this.a.length; ++i2) {
            dArray[i2] = -this.a[i2];
        }
        return new ni_0(dArray);
    }

    public final ni_0 b(ni_0 ni_02) {
        double[] dArray = new double[this.a.length + ni_02.a.length - 1];
        for (int i2 = 0; i2 < dArray.length; ++i2) {
            dArray[i2] = 0.0;
            for (int i3 = BY.b(0, i2 + 1 - ni_02.a.length); i3 < BY.a(this.a.length, i2 + 1); ++i3) {
                int n2 = i2;
                dArray[n2] = dArray[n2] + this.a[i3] * ni_02.a[i2 - i3];
            }
        }
        return new ni_0(dArray);
    }

    private static double[] a(double[] dArray) {
        ci_0.a((Object)dArray);
        int n2 = dArray.length;
        if (n2 == 0) {
            throw new pf_0(px_0.EMPTY_POLYNOMIALS_COEFFICIENTS_ARRAY);
        }
        if (n2 == 1) {
            return new double[]{0.0};
        }
        double[] dArray2 = new double[n2 - 1];
        --n2;
        while (n2 > 0) {
            dArray2[n2 - 1] = (double)n2 * dArray[n2];
            --n2;
        }
        return dArray2;
    }

    public final ni_0 c() {
        return new ni_0(ni_0.a(this.a));
    }

    public final lc_0 a() {
        return this.c();
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (this.a[0] == 0.0) {
            if (this.a.length == 1) {
                return "0";
            }
        } else {
            stringBuilder.append(ni_0.b(this.a[0]));
        }
        for (int i2 = 1; i2 < this.a.length; ++i2) {
            if (this.a[i2] == 0.0) continue;
            if (stringBuilder.length() > 0) {
                if (this.a[i2] < 0.0) {
                    stringBuilder.append(" - ");
                } else {
                    stringBuilder.append(" + ");
                }
            } else if (this.a[i2] < 0.0) {
                stringBuilder.append("-");
            }
            double d2 = BY.w(this.a[i2]);
            if (d2 - 1.0 != 0.0) {
                stringBuilder.append(ni_0.b(d2));
                stringBuilder.append(' ');
            }
            stringBuilder.append("x");
            if (i2 <= 1) continue;
            stringBuilder.append('^');
            stringBuilder.append(Integer.toString(i2));
        }
        return stringBuilder.toString();
    }

    private static String b(double d2) {
        String string = Double.toString(d2);
        if (string.endsWith(".0")) {
            return string.substring(0, string.length() - 2);
        }
        return string;
    }

    public final int hashCode() {
        int n2 = 31 + Arrays.hashCode(this.a);
        return n2;
    }

    public final boolean equals(Object obj) {
        ni_0 ni_02;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ni_0)) {
            return false;
        }
        ni_02 = ni_02;
        return Arrays.equals(this.a, ni_02.a);
    }

    public static final class a
    implements kZ {
        public final double[] b(double d2, double ... dArray) {
            double[] dArray2 = new double[dArray.length];
            double d3 = 1.0;
            for (int i2 = 0; i2 < dArray.length; ++i2) {
                dArray2[i2] = d3;
                d3 *= d2;
            }
            return dArray2;
        }

        public final double a(double d2, double ... dArray) {
            return ni.a((double[])dArray, (double)d2);
        }
    }
}

