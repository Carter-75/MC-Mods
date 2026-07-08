/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import java.util.Arrays;
import org.valkyrienskies.core.impl.shadow.AA;
import org.valkyrienskies.core.impl.shadow.BX;
import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.ci_0;
import org.valkyrienskies.core.impl.shadow.oV;
import org.valkyrienskies.core.impl.shadow.oX;
import org.valkyrienskies.core.impl.shadow.oY;
import org.valkyrienskies.core.impl.shadow.pk_0;
import org.valkyrienskies.core.impl.shadow.pn_0;
import org.valkyrienskies.core.impl.shadow.px_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Cs
 */
public final class cs_0
implements Serializable,
BX {
    @Deprecated
    private static int a = 1;
    @Deprecated
    private static int b = 0;
    private static final long c = -3485529955529426875L;
    private static final int d = 16;
    private static final double e = 2.0;
    private static final double f = 0.5;
    private double g = 2.5;
    private double h = 2.0;
    private a i = org.valkyrienskies.core.impl.shadow.Cs$a.MULTIPLICATIVE;
    private double[] j;
    private int k = 0;
    private int l = 0;

    public cs_0() {
        this(16);
    }

    public cs_0(int n2) {
        this(n2, 2.0);
    }

    public cs_0(double[] dArray) {
        this(16, 2.0, 2.5, org.valkyrienskies.core.impl.shadow.Cs$a.MULTIPLICATIVE, dArray);
    }

    @Deprecated
    private cs_0(int n2, float f2) {
        this(n2, (double)f2);
    }

    private cs_0(int n2, double d2) {
        this(n2, d2, d2 + 0.5);
    }

    @Deprecated
    private cs_0(int n2, float f2, float f3) {
        this(n2, (double)f2, (double)f3);
    }

    private cs_0(int n2, double d2, double d3) {
        this(n2, d2, d3, org.valkyrienskies.core.impl.shadow.Cs$a.MULTIPLICATIVE, null);
    }

    @Deprecated
    private cs_0(int n2, float f2, float f3, int n3) {
        this(n2, f2, f3, n3 == 1 ? org.valkyrienskies.core.impl.shadow.Cs$a.ADDITIVE : org.valkyrienskies.core.impl.shadow.Cs$a.MULTIPLICATIVE, null);
        int n4 = n3;
        cs_0 cs_02 = this;
        if (n4 != 0 && n4 != 1) {
            throw new oV(px_0.UNSUPPORTED_EXPANSION_MODE, n4, 0, "MULTIPLICATIVE_MODE", 1, "ADDITIVE_MODE");
        }
        cs_0 cs_03 = cs_02;
        synchronized (cs_03) {
            if (n4 == 0) {
                cs_02.a(org.valkyrienskies.core.impl.shadow.Cs$a.MULTIPLICATIVE);
            } else if (n4 == 1) {
                cs_02.a(org.valkyrienskies.core.impl.shadow.Cs$a.ADDITIVE);
            }
            return;
        }
    }

    private cs_0(int n2, double d2, double d3, a a2, double ... dArray) {
        if (n2 <= 0) {
            throw new pk_0(px_0.INITIAL_CAPACITY_NOT_POSITIVE, n2);
        }
        cs_0.a(d3, d2);
        this.h = d2;
        this.g = d3;
        this.i = a2;
        this.j = new double[n2];
        this.k = 0;
        this.l = 0;
        if (dArray != null && dArray.length > 0) {
            this.a(dArray);
        }
    }

    private cs_0(cs_0 cs_02) {
        ci_0.a(cs_02);
        cs_0.a(cs_02, this);
    }

    public final synchronized void a(double d2) {
        if (this.j.length <= this.l + this.k) {
            this.f();
        }
        this.j[this.l + this.k++] = d2;
    }

    public final synchronized void a(double[] dArray) {
        double[] dArray2 = new double[this.k + dArray.length + 1];
        System.arraycopy(this.j, this.l, dArray2, 0, this.k);
        System.arraycopy(dArray, 0, dArray2, this.k, dArray.length);
        this.j = dArray2;
        this.l = 0;
        this.k += dArray.length;
    }

    public final synchronized double b(double d2) {
        double d3 = this.j[this.l];
        if (this.l + (this.k + 1) > this.j.length) {
            this.f();
        }
        ++this.l;
        this.j[this.l + (this.k - 1)] = d2;
        if (this.q()) {
            this.e();
        }
        return d3;
    }

    public final synchronized double c(double d2) {
        if (this.k <= 0) {
            throw new oX(px_0.CANNOT_SUBSTITUTE_ELEMENT_FROM_EMPTY_ARRAY, new Object[0]);
        }
        int n2 = this.l + (this.k - 1);
        double d3 = this.j[n2];
        this.j[n2] = d2;
        return d3;
    }

    @Deprecated
    private void a(float f2, float f3) {
        cs_0.a(f2, f3);
    }

    private static void a(double d2, double d3) {
        if (d2 < d3) {
            pn_0 pn_02;
            pn_0 pn_03 = pn_02 = new pn_0(d2, (Number)1, true);
            pn_02.a.a(px_0.CONTRACTION_CRITERIA_SMALLER_THAN_EXPANSION_FACTOR, d2, d3);
            throw pn_02;
        }
        if (d2 <= 1.0) {
            pn_0 pn_04;
            pn_0 pn_05 = pn_04 = new pn_0(d2, (Number)1, false);
            pn_04.a.a(px_0.CONTRACTION_CRITERIA_SMALLER_THAN_ONE, d2);
            throw pn_04;
        }
        if (d3 <= 1.0) {
            pn_0 pn_06;
            pn_0 pn_07 = pn_06 = new pn_0(d2, (Number)1, false);
            pn_06.a.a(px_0.EXPANSION_FACTOR_SMALLER_THAN_ONE, d3);
            throw pn_06;
        }
    }

    public final synchronized void c() {
        this.k = 0;
        this.l = 0;
    }

    private synchronized void e() {
        double[] dArray = new double[this.k + 1];
        System.arraycopy(this.j, this.l, dArray, 0, this.k);
        this.j = dArray;
        this.l = 0;
    }

    public final synchronized void b(int n2) {
        this.a(n2, true);
    }

    public final synchronized void c(int n2) {
        this.a(1, false);
    }

    private synchronized void a(int n2, boolean bl) {
        if (n2 > this.k) {
            throw new oV(px_0.TOO_MANY_ELEMENTS_TO_DISCARD_FROM_ARRAY, n2, this.k);
        }
        if (n2 < 0) {
            throw new oV(px_0.CANNOT_DISCARD_NEGATIVE_NUMBER_OF_ELEMENTS, n2);
        }
        this.k -= n2;
        if (bl) {
            this.l += n2;
        }
        if (this.q()) {
            this.e();
        }
    }

    private synchronized void f() {
        int n2 = this.i == org.valkyrienskies.core.impl.shadow.Cs$a.MULTIPLICATIVE ? (int)BY.z((double)this.j.length * this.h) : (int)((long)this.j.length + BY.B(this.h));
        double[] dArray = new double[n2];
        System.arraycopy(this.j, 0, dArray, 0, this.j.length);
        this.j = dArray;
    }

    private synchronized void d(int n2) {
        double[] dArray = new double[n2];
        System.arraycopy(this.j, 0, dArray, 0, this.j.length);
        this.j = dArray;
    }

    @Deprecated
    private float g() {
        cs_0 cs_02 = this;
        return (float)cs_02.g;
    }

    private double h() {
        return this.g;
    }

    public final synchronized double a(int n2) {
        if (n2 >= this.k) {
            throw new ArrayIndexOutOfBoundsException(n2);
        }
        if (n2 >= 0) {
            return this.j[this.l + n2];
        }
        throw new ArrayIndexOutOfBoundsException(n2);
    }

    public final synchronized double[] b() {
        double[] dArray = new double[this.k];
        System.arraycopy(this.j, this.l, dArray, 0, this.k);
        return dArray;
    }

    @Deprecated
    private float i() {
        return (float)this.h;
    }

    @Deprecated
    private int j() {
        cs_0 cs_02 = this;
        synchronized (cs_02) {
            switch (this.i) {
                case MULTIPLICATIVE: {
                    return 0;
                }
                case ADDITIVE: {
                    return 1;
                }
            }
            throw new oY();
        }
    }

    @Deprecated
    private synchronized int k() {
        return this.j.length;
    }

    private int l() {
        return this.j.length;
    }

    public final synchronized int a() {
        return this.k;
    }

    @Deprecated
    private synchronized double[] m() {
        return this.j;
    }

    private double[] n() {
        return this.j;
    }

    private int o() {
        return this.l;
    }

    @Deprecated
    private void a(float f2) {
        cs_0 cs_02 = this;
        float f3 = (float)cs_02.h;
        float f4 = f2;
        cs_02 = this;
        cs_0.a(f4, f3);
        cs_02 = this;
        synchronized (cs_02) {
            this.g = f2;
            return;
        }
    }

    public final double a(AA aA) {
        int n2;
        int n3;
        double[] dArray;
        cs_0 cs_02 = this;
        synchronized (cs_02) {
            dArray = this.j;
            n3 = this.l;
            n2 = this.k;
        }
        return aA.a(dArray, n3, n2);
    }

    public final synchronized void a(int n2, double d2) {
        if (n2 < 0) {
            throw new ArrayIndexOutOfBoundsException(n2);
        }
        if (n2 + 1 > this.k) {
            this.k = n2 + 1;
        }
        if (this.l + n2 >= this.j.length) {
            cs_0 cs_02 = this;
            cs_02.d(cs_02.l + (n2 + 1));
        }
        this.j[this.l + n2] = d2;
    }

    @Deprecated
    private void b(float f2) {
        cs_0 cs_02 = this;
        cs_0.a(cs_02.g, f2);
        cs_02 = this;
        synchronized (cs_02) {
            this.h = f2;
            return;
        }
    }

    @Deprecated
    private void e(int n2) {
        if (n2 != 0 && n2 != 1) {
            throw new oV(px_0.UNSUPPORTED_EXPANSION_MODE, n2, 0, "MULTIPLICATIVE_MODE", 1, "ADDITIVE_MODE");
        }
        cs_0 cs_02 = this;
        synchronized (cs_02) {
            if (n2 == 0) {
                this.a(org.valkyrienskies.core.impl.shadow.Cs$a.MULTIPLICATIVE);
            } else if (n2 == 1) {
                this.a(org.valkyrienskies.core.impl.shadow.Cs$a.ADDITIVE);
            }
            return;
        }
    }

    @Deprecated
    private void a(a a2) {
        cs_0 cs_02 = this;
        synchronized (cs_02) {
            this.i = a2;
            return;
        }
    }

    @Deprecated
    private static void p() {
    }

    private synchronized void f(int n2) {
        if (n2 < 0) {
            throw new oV(px_0.INDEX_NOT_POSITIVE, n2);
        }
        int n3 = this.l + n2;
        if (n3 > this.j.length) {
            this.d(n3);
        }
        this.k = n2;
    }

    private synchronized boolean q() {
        if (this.i == org.valkyrienskies.core.impl.shadow.Cs$a.MULTIPLICATIVE) {
            return (double)((float)this.j.length / (float)this.k) > this.g;
        }
        return (double)(this.j.length - this.k) > this.g;
    }

    @Deprecated
    private synchronized int r() {
        return this.l;
    }

    private static void a(cs_0 cs_02, cs_0 cs_03) {
        ci_0.a(cs_02);
        ci_0.a(cs_03);
        cs_0 cs_04 = cs_02;
        synchronized (cs_04) {
            cs_0 cs_05 = cs_03;
            synchronized (cs_05) {
                cs_03.g = cs_02.g;
                cs_03.h = cs_02.h;
                cs_03.i = cs_02.i;
                cs_03.j = new double[cs_02.j.length];
                System.arraycopy(cs_02.j, 0, cs_03.j, 0, cs_03.j.length);
                cs_03.k = cs_02.k;
                cs_03.l = cs_02.l;
            }
            return;
        }
    }

    public final synchronized cs_0 d() {
        cs_0 cs_02 = new cs_0();
        cs_0.a(this, cs_02);
        return cs_02;
    }

    /*
     * WARNING - void declaration
     */
    public final boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof cs_0)) {
            return false;
        }
        cs_0 cs_02 = this;
        synchronized (cs_02) {
            Object object2 = object;
            synchronized (object2) {
                void var1_1;
                cs_0 cs_03 = (cs_0)var1_1;
                boolean bl = cs_03.g == this.g;
                bl = bl && cs_03.h == this.h;
                bl = bl && cs_03.i == this.i;
                bl = bl && cs_03.k == this.k;
                if (!(bl = bl && cs_03.l == this.l)) {
                    return false;
                }
                return Arrays.equals(this.j, cs_03.j);
            }
        }
    }

    public final synchronized int hashCode() {
        int[] nArray = new int[6];
        int[] nArray2 = nArray;
        nArray[0] = Double.valueOf(this.h).hashCode();
        nArray2[1] = Double.valueOf(this.g).hashCode();
        nArray2[2] = this.i.hashCode();
        nArray2[3] = Arrays.hashCode(this.j);
        nArray2[4] = this.k;
        nArray2[5] = this.l;
        return Arrays.hashCode(nArray2);
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    public static enum a {
        MULTIPLICATIVE,
        ADDITIVE;

    }
}

