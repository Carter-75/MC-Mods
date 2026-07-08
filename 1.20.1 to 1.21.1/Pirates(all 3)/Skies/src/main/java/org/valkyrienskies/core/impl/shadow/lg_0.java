/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.valkyrienskies.core.impl.shadow.lg
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import java.util.Arrays;
import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.ch_0;
import org.valkyrienskies.core.impl.shadow.kM;
import org.valkyrienskies.core.impl.shadow.kN;
import org.valkyrienskies.core.impl.shadow.kO;
import org.valkyrienskies.core.impl.shadow.lf_0;
import org.valkyrienskies.core.impl.shadow.lg;
import org.valkyrienskies.core.impl.shadow.oS;
import org.valkyrienskies.core.impl.shadow.pm_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.lg
 */
public class lg_0
implements Serializable,
kO<lg_0> {
    private static final long c = 20120730L;
    public transient lf_0 a;
    public final double[] b;

    public lg_0(lf_0 lf_02) {
        this.a = lf_02;
        this.b = new double[lf_02.c()];
    }

    private lg_0(int n2, int n3) {
        this(lf_0.a(n2, n3));
    }

    public lg_0(int n2, int n3, double d2) {
        this(n2, n3);
        this.b[0] = d2;
    }

    public lg_0(int n2, int n3, int n4, double d2) {
        this(n2, 1, d2);
        if (n4 >= n2) {
            throw new pm_0(n4, (Number)n2, false);
        }
        this.b[lf_0.a((int)n4, (int)1).c()] = 1.0;
    }

    private lg_0(double d2, lg_0 object, double d3, lg_0 lg_02) {
        this(((lg_0)object).a);
        this.a.a(lg_02.a);
        boolean bl = false;
        double[] dArray = this.b;
        bl = false;
        object = lg_02.b;
        double d4 = d3;
        bl = false;
        double[] dArray2 = ((lg_0)object).b;
        double d5 = d2;
        lf_0 lf_02 = this.a;
        for (int i2 = 0; i2 < lf_02.c(); ++i2) {
            dArray[i2 + 0] = ch_0.a(d5, dArray2[i2 + 0], d4, (double)object[i2 + 0]);
        }
    }

    private lg_0(double d2, lg_0 object, double d3, lg_0 lg_02, double d4, lg_0 lg_03) {
        this(((lg_0)object).a);
        this.a.a(lg_02.a);
        this.a.a(lg_03.a);
        boolean bl = false;
        double[] dArray = this.b;
        bl = false;
        double[] dArray2 = lg_03.b;
        double d5 = d4;
        bl = false;
        object = lg_02.b;
        double d6 = d3;
        bl = false;
        double[] dArray3 = ((lg_0)object).b;
        double d7 = d2;
        lf_0 lf_02 = this.a;
        for (int i2 = 0; i2 < lf_02.c(); ++i2) {
            dArray[i2 + 0] = ch_0.a(d7, dArray3[i2 + 0], d6, (double)object[i2 + 0], d5, dArray2[i2 + 0]);
        }
    }

    private lg_0(double d2, lg_0 object, double d3, lg_0 object2, double d4, lg_0 lg_02, double d5, lg_0 lg_03) {
        this(((lg_0)object).a);
        this.a.a(((lg_0)object2).a);
        this.a.a(lg_02.a);
        this.a.a(lg_03.a);
        boolean bl = false;
        object2 = this.b;
        bl = false;
        double[] dArray = lg_03.b;
        double d6 = d5;
        bl = false;
        double[] dArray2 = lg_02.b;
        double d7 = d4;
        bl = false;
        object = ((lg_0)object2).b;
        double d8 = d3;
        bl = false;
        double[] dArray3 = ((lg_0)object).b;
        double d9 = d2;
        lf_0 lf_02 = this.a;
        for (int i2 = 0; i2 < lf_02.c(); ++i2) {
            object2[i2 + 0] = ch_0.a(d9, dArray3[i2 + 0], d8, (double)object[i2 + 0], d7, dArray2[i2 + 0], d6, dArray[i2 + 0]);
        }
    }

    public lg_0(int n2, int n3, double ... dArray) {
        this(n2, n3);
        if (dArray.length != this.b.length) {
            throw new oS(dArray.length, this.b.length);
        }
        System.arraycopy(dArray, 0, this.b, 0, this.b.length);
    }

    private lg_0(lg_0 lg_02) {
        this.a = lg_02.a;
        this.b = (double[])lg_02.b.clone();
    }

    public final int C() {
        lf_0 lf_02 = this.a;
        return lf_02.a;
    }

    public final int D() {
        lf_0 lf_02 = this.a;
        return lf_02.b;
    }

    private lg_0 l(double d2) {
        return new lg_0(this.C(), this.D(), d2);
    }

    @Override
    public final double d() {
        return this.b[0];
    }

    public final double E() {
        return this.b[0];
    }

    @Override
    public final double a(int ... nArray) {
        return this.b[this.a.a(nArray)];
    }

    public final double[] F() {
        return (double[])this.b.clone();
    }

    @Override
    public final lg_0 h(double d2) {
        lg_0 lg_02 = new lg_0(this);
        lg_02.b[0] = lg_02.b[0] + d2;
        return lg_02;
    }

    @Override
    public final lg_0 a(lg_0 lg_02) {
        this.a.a(lg_02.a);
        lg_0 lg_03 = new lg_0(this);
        this.a.a(this.b, 0, lg_02.b, 0, lg_03.b, 0);
        return lg_03;
    }

    public final lg_0 i(double d2) {
        return this.h(-d2);
    }

    @Override
    private lg_0 d(lg_0 lg_02) {
        this.a.a(lg_02.a);
        lg_0 lg_03 = new lg_0(this);
        this.a.b(this.b, 0, lg_02.b, 0, lg_03.b, 0);
        return lg_03;
    }

    @Override
    private lg_0 f(int n2) {
        return this.j(n2);
    }

    public final lg_0 j(double d2) {
        lg_0 lg_02 = new lg_0(this);
        int n2 = 0;
        while (n2 < lg_02.b.length) {
            int n3 = n2++;
            lg_02.b[n3] = lg_02.b[n3] * d2;
        }
        return lg_02;
    }

    @Override
    public final lg_0 b(lg_0 lg_02) {
        this.a.a(lg_02.a);
        lg_0 lg_03 = new lg_0(this.a);
        this.a.c(this.b, 0, lg_02.b, 0, lg_03.b, 0);
        return lg_03;
    }

    private lg_0 m(double d2) {
        lg_0 lg_02 = new lg_0(this);
        int n2 = 0;
        while (n2 < lg_02.b.length) {
            int n3 = n2++;
            lg_02.b[n3] = lg_02.b[n3] / d2;
        }
        return lg_02;
    }

    @Override
    private lg_0 e(lg_0 lg_02) {
        this.a.a(lg_02.a);
        lg_0 lg_03 = new lg_0(this.a);
        this.a.a(this.b, 0, lg_02.b, lg_03.b, 0);
        return lg_03;
    }

    private lg_0 n(double d2) {
        lg_0 lg_02 = new lg_0(this);
        lg_02.b[0] = BY.g(lg_02.b[0], d2);
        return lg_02;
    }

    @Override
    private lg_0 f(lg_0 lg_02) {
        this.a.a(lg_02.a);
        lg_0 lg_03 = new lg_0(this.a);
        boolean bl = false;
        double[] dArray = lg_03.b;
        bl = false;
        double[] dArray2 = lg_02.b;
        bl = false;
        double[] dArray3 = this.b;
        lf_0 lf_02 = this.a;
        double d2 = BY.g(dArray3[0], dArray2[0]);
        double d3 = BY.A((dArray3[0] - d2) / dArray2[0]);
        dArray[0] = d2;
        for (int i2 = 1; i2 < lf_02.c(); ++i2) {
            dArray[i2 + 0] = dArray3[i2 + 0] - d3 * dArray2[i2 + 0];
        }
        return lg_03;
    }

    public final lg_0 G() {
        lg_0 lg_02 = new lg_0(this.a);
        for (int i2 = 0; i2 < lg_02.b.length; ++i2) {
            lg_02.b[i2] = -this.b[i2];
        }
        return lg_02;
    }

    private lg_0 ab() {
        if (Double.doubleToLongBits(this.b[0]) < 0L) {
            return this.G();
        }
        return this;
    }

    private lg_0 ac() {
        lf_0 lf_02 = this.a;
        lf_0 lf_03 = lf_02;
        lf_03 = this.a;
        return new lg_0(lf_02.a, lf_03.b, BY.z(this.b[0]));
    }

    private lg_0 ad() {
        lf_0 lf_02 = this.a;
        lf_0 lf_03 = lf_02;
        lf_03 = this.a;
        return new lg_0(lf_02.a, lf_03.b, BY.y(this.b[0]));
    }

    private lg_0 ae() {
        lf_0 lf_02 = this.a;
        lf_0 lf_03 = lf_02;
        lf_03 = this.a;
        return new lg_0(lf_02.a, lf_03.b, BY.A(this.b[0]));
    }

    @Override
    public final long i() {
        return BY.B(this.b[0]);
    }

    private lg_0 af() {
        lf_0 lf_02 = this.a;
        lf_0 lf_03 = lf_02;
        lf_03 = this.a;
        return new lg_0(lf_02.a, lf_03.b, BY.h(this.b[0]));
    }

    @Override
    private lg_0 g(lg_0 lg_02) {
        long l2 = Double.doubleToLongBits(this.b[0]);
        long l3 = Double.doubleToLongBits(lg_02.b[0]);
        if (l2 >= 0L && l3 >= 0L || l2 < 0L && l3 < 0L) {
            return this;
        }
        return this.G();
    }

    private lg_0 o(double d2) {
        long l2 = Double.doubleToLongBits(this.b[0]);
        long l3 = Double.doubleToLongBits(d2);
        if (l2 >= 0L && l3 >= 0L || l2 < 0L && l3 < 0L) {
            return this;
        }
        return this.G();
    }

    private int ag() {
        return BY.C(this.b[0]);
    }

    @Override
    private lg_0 g(int n2) {
        lg_0 lg_02 = new lg_0(this.a);
        for (int i2 = 0; i2 < lg_02.b.length; ++i2) {
            lg_02.b[i2] = BY.b(this.b[i2], n2);
        }
        return lg_02;
    }

    @Override
    private lg_0 h(lg_0 object) {
        int n2;
        this.a.a(((lg_0)object).a);
        if (Double.isInfinite(this.b[0]) || Double.isInfinite(((lg_0)object).b[0])) {
            lf_0 lf_02 = this.a;
            object = lf_02;
            object = this.a;
            return new lg_0(lf_02.a, ((lf_0)object).a, Double.POSITIVE_INFINITY);
        }
        if (Double.isNaN(this.b[0]) || Double.isNaN(((lg_0)object).b[0])) {
            lf_0 lf_03 = this.a;
            object = lf_03;
            object = this.a;
            return new lg_0(lf_03.a, ((lf_0)object).a, Double.NaN);
        }
        int n3 = this.ag();
        if (n3 > (n2 = ((lg_0)object).ag()) + 27) {
            return this.ab();
        }
        if (n2 > n3 + 27) {
            return ((lg_0)object).ab();
        }
        n3 = (n3 + n2) / 2;
        lg_0 lg_02 = this.g(-n3);
        object = ((lg_0)object).g(-n3);
        lg_0 lg_03 = lg_02;
        Object object2 = object;
        object = lg_03.b(lg_03).a(((lg_0)object2).b((lg_0)object2));
        object = ((lg_0)object).e(2);
        return ((lg_0)object).g(n3);
    }

    private static lg_0 a(lg_0 lg_02, lg_0 lg_03) {
        return lg_02.h(lg_03);
    }

    @Override
    public final lg_0 a(double ... dArray) {
        if (dArray.length != this.D() + 1) {
            throw new oS(dArray.length, this.D() + 1);
        }
        lg_0 lg_02 = new lg_0(this.a);
        this.a.b(this.b, 0, dArray, lg_02.b, 0);
        return lg_02;
    }

    public final lg_0 H() {
        lg_0 lg_02 = new lg_0(this.a);
        this.a.a(this.b, 0, -1, lg_02.b, 0);
        return lg_02;
    }

    public final lg_0 I() {
        return this.e(2);
    }

    public final lg_0 J() {
        return this.e(3);
    }

    @Override
    public final lg_0 e(int n2) {
        lg_0 lg_02 = new lg_0(this.a);
        this.a.b(this.b, 0, n2, lg_02.b, 0);
        return lg_02;
    }

    @Override
    public final kM<lg_0> c() {
        return new kM<lg_0>(this){
            private /* synthetic */ lg_0 a;
            {
                this.a = lg_02;
            }

            private lg_0 d() {
                lf_0 lf_02 = this.a.a;
                lf_0 lf_03 = lf_02;
                lf_03 = this.a.a;
                return new lg_0(lf_02.a, lf_03.b, 0.0);
            }

            private lg_0 e() {
                lf_0 lf_02 = this.a.a;
                lf_0 lf_03 = lf_02;
                lf_03 = this.a.a;
                return new lg_0(lf_02.a, lf_03.b, 1.0);
            }

            @Override
            public final Class<? extends kN<lg_0>> c() {
                return lg_0.class;
            }

            @Override
            public final /* synthetic */ kN b() {
                1 var1_1 = this;
                lf_0 lf_02 = var1_1.a.a;
                lf_0 lf_03 = lf_02;
                lf_03 = var1_1.a.a;
                return new lg_0(lf_02.a, lf_03.b, 1.0);
            }

            @Override
            public final /* synthetic */ kN a() {
                1 var1_1 = this;
                lf_0 lf_02 = var1_1.a.a;
                lf_0 lf_03 = lf_02;
                lf_03 = var1_1.a.a;
                return new lg_0(lf_02.a, lf_03.b, 0.0);
            }
        };
    }

    private static lg_0 a(double d2, lg_0 object) {
        lg_0 lg_02 = new lg_0(((lg_0)object).a);
        boolean bl = false;
        object = lg_02.b;
        bl = false;
        double[] dArray = ((lg_0)object).b;
        double d3 = d2;
        lf_0 lf_02 = ((lg_0)object).a;
        double[] dArray2 = new double[1 + lf_02.b];
        if (d3 == 0.0) {
            if (dArray[0] == 0.0) {
                dArray2[0] = 1.0;
                double d4 = Double.POSITIVE_INFINITY;
                for (int i2 = 1; i2 < dArray2.length; ++i2) {
                    dArray2[i2] = d4 = -d4;
                }
            } else if (dArray[0] < 0.0) {
                Arrays.fill(dArray2, Double.NaN);
            }
        } else {
            dArray2[0] = BY.a(d3, dArray[0]);
            double d5 = BY.k(d3);
            for (int i3 = 1; i3 < dArray2.length; ++i3) {
                dArray2[i3] = d5 * dArray2[i3 - 1];
            }
        }
        lf_02.b(dArray, 0, dArray2, (double[])object, 0);
        return lg_02;
    }

    public final lg_0 k(double d2) {
        lg_0 lg_02 = new lg_0(this.a);
        boolean bl = false;
        double[] dArray = lg_02.b;
        double d3 = d2;
        bl = false;
        double[] dArray2 = this.b;
        lf_0 lf_02 = this.a;
        double[] dArray3 = new double[1 + lf_02.b];
        double d4 = BY.a(dArray2[0], d3 - (double)lf_02.b);
        for (int i2 = lf_02.b; i2 > 0; --i2) {
            dArray3[i2] = d4;
            d4 *= dArray2[0];
        }
        dArray3[0] = d4;
        double d5 = d3;
        for (int i3 = 1; i3 <= lf_02.b; ++i3) {
            int n2 = i3;
            dArray3[n2] = dArray3[n2] * d5;
            d5 *= d3 - (double)i3;
        }
        lf_02.b(dArray2, 0, dArray3, dArray, 0);
        return lg_02;
    }

    @Override
    private lg_0 h(int n2) {
        lg_0 lg_02 = new lg_0(this.a);
        this.a.a(this.b, 0, n2, lg_02.b, 0);
        return lg_02;
    }

    private lg_0 i(lg_0 lg_02) {
        this.a.a(lg_02.a);
        lg_0 lg_03 = new lg_0(this.a);
        boolean bl = false;
        double[] dArray = lg_03.b;
        bl = false;
        double[] dArray2 = lg_02.b;
        bl = false;
        double[] dArray3 = this.b;
        lf_0 lf_02 = this.a;
        double[] dArray4 = new double[lf_02.c()];
        lf_02.c(dArray3, 0, dArray4, 0);
        dArray3 = new double[lf_02.c()];
        lf_02.c(dArray4, 0, dArray2, 0, dArray3, 0);
        lf_02.a(dArray3, 0, dArray, 0);
        return lg_03;
    }

    public final lg_0 K() {
        lg_0 lg_02 = new lg_0(this.a);
        this.a.a(this.b, 0, lg_02.b, 0);
        return lg_02;
    }

    public final lg_0 L() {
        lg_0 lg_02 = new lg_0(this.a);
        boolean bl = false;
        double[] dArray = lg_02.b;
        bl = false;
        double[] dArray2 = this.b;
        lf_0 lf_02 = this.a;
        double[] dArray3 = new double[1 + lf_02.b];
        double[] dArray4 = dArray3;
        dArray3[0] = BY.j(dArray2[0]);
        Arrays.fill(dArray4, 1, 1 + lf_02.b, BY.i(dArray2[0]));
        lf_02.b(dArray2, 0, dArray4, dArray, 0);
        return lg_02;
    }

    public final lg_0 M() {
        lg_0 lg_02 = new lg_0(this.a);
        this.a.c(this.b, 0, lg_02.b, 0);
        return lg_02;
    }

    public final lg_0 N() {
        lg_0 lg_02 = new lg_0(this.a);
        boolean bl = false;
        double[] dArray = lg_02.b;
        bl = false;
        double[] dArray2 = this.b;
        lf_0 lf_02 = this.a;
        double[] dArray3 = new double[1 + lf_02.b];
        double[] dArray4 = dArray3;
        dArray3[0] = BY.l(dArray2[0]);
        if (lf_02.b > 0) {
            double d2;
            double d3 = d2 = 1.0 / (1.0 + dArray2[0]);
            for (int i2 = 1; i2 <= lf_02.b; ++i2) {
                dArray4[i2] = d3;
                d3 *= (double)(-i2) * d2;
            }
        }
        lf_02.b(dArray2, 0, dArray4, dArray, 0);
        return lg_02;
    }

    public final lg_0 O() {
        lg_0 lg_02 = new lg_0(this.a);
        boolean bl = false;
        double[] dArray = lg_02.b;
        bl = false;
        double[] dArray2 = this.b;
        lf_0 lf_02 = this.a;
        double[] dArray3 = new double[1 + lf_02.b];
        double[] dArray4 = dArray3;
        dArray3[0] = BY.m(dArray2[0]);
        if (lf_02.b > 0) {
            double d2 = 1.0 / dArray2[0];
            double d3 = d2 / BY.k(10.0);
            for (int i2 = 1; i2 <= lf_02.b; ++i2) {
                dArray4[i2] = d3;
                d3 *= (double)(-i2) * d2;
            }
        }
        lf_02.b(dArray2, 0, dArray4, dArray, 0);
        return lg_02;
    }

    public final lg_0 P() {
        lg_0 lg_02 = new lg_0(this.a);
        boolean bl = false;
        double[] dArray = lg_02.b;
        bl = false;
        double[] dArray2 = this.b;
        lf_0 lf_02 = this.a;
        double[] dArray3 = new double[1 + lf_02.b];
        double[] dArray4 = dArray3;
        dArray3[0] = BY.o(dArray2[0]);
        if (lf_02.b > 0) {
            dArray4[1] = -BY.n(dArray2[0]);
            for (int i2 = 2; i2 <= lf_02.b; ++i2) {
                dArray4[i2] = -dArray4[i2 - 2];
            }
        }
        lf_02.b(dArray2, 0, dArray4, dArray, 0);
        return lg_02;
    }

    public final lg_0 Q() {
        lg_0 lg_02 = new lg_0(this.a);
        boolean bl = false;
        double[] dArray = lg_02.b;
        bl = false;
        double[] dArray2 = this.b;
        lf_0 lf_02 = this.a;
        double[] dArray3 = new double[1 + lf_02.b];
        double[] dArray4 = dArray3;
        dArray3[0] = BY.n(dArray2[0]);
        if (lf_02.b > 0) {
            dArray4[1] = BY.o(dArray2[0]);
            for (int i2 = 2; i2 <= lf_02.b; ++i2) {
                dArray4[i2] = -dArray4[i2 - 2];
            }
        }
        lf_02.b(dArray2, 0, dArray4, dArray, 0);
        return lg_02;
    }

    public final lg_0 R() {
        double d2;
        lg_0 lg_02 = new lg_0(this.a);
        boolean bl = false;
        double[] dArray = lg_02.b;
        bl = false;
        double[] dArray2 = this.b;
        lf_0 lf_02 = this.a;
        double[] dArray3 = new double[1 + lf_02.b];
        dArray3[0] = d2 = BY.p(dArray2[0]);
        if (lf_02.b > 0) {
            double[] dArray4 = new double[lf_02.b + 2];
            double[] dArray5 = dArray4;
            dArray4[1] = 1.0;
            double d3 = d2;
            double d4 = d3 * d3;
            for (int i2 = 1; i2 <= lf_02.b; ++i2) {
                double d5 = 0.0;
                dArray5[i2 + 1] = (double)i2 * dArray5[i2];
                for (int i3 = i2 + 1; i3 >= 0; i3 -= 2) {
                    d5 = d5 * d4 + dArray5[i3];
                    if (i3 > 2) {
                        dArray5[i3 - 2] = (double)(i3 - 1) * dArray5[i3 - 1] + (double)(i3 - 3) * dArray5[i3 - 3];
                        continue;
                    }
                    if (i3 != 2) continue;
                    dArray5[0] = dArray5[1];
                }
                if ((i2 & 1) == 0) {
                    d5 *= d2;
                }
                dArray3[i2] = d5;
            }
        }
        lf_02.b(dArray2, 0, dArray3, dArray, 0);
        return lg_02;
    }

    public final lg_0 S() {
        lg_0 lg_02 = new lg_0(this.a);
        boolean bl = false;
        double[] dArray = lg_02.b;
        bl = false;
        double[] dArray2 = this.b;
        lf_0 lf_02 = this.a;
        double[] dArray3 = new double[1 + lf_02.b];
        double d2 = dArray2[0];
        dArray3[0] = BY.s(d2);
        if (lf_02.b > 0) {
            double[] dArray4 = new double[lf_02.b];
            double[] dArray5 = dArray4;
            dArray4[0] = -1.0;
            double d3 = d2;
            double d4 = d3 * d3;
            double d5 = 1.0 / (1.0 - d4);
            double d6 = BY.a(d5);
            dArray3[1] = d6 * dArray5[0];
            for (int i2 = 2; i2 <= lf_02.b; ++i2) {
                double d7 = 0.0;
                dArray5[i2 - 1] = (double)(i2 - 1) * dArray5[i2 - 2];
                for (int i3 = i2 - 1; i3 >= 0; i3 -= 2) {
                    d7 = d7 * d4 + dArray5[i3];
                    if (i3 > 2) {
                        dArray5[i3 - 2] = (double)(i3 - 1) * dArray5[i3 - 1] + (double)(2 * i2 - i3) * dArray5[i3 - 3];
                        continue;
                    }
                    if (i3 != 2) continue;
                    dArray5[0] = dArray5[1];
                }
                if ((i2 & 1) == 0) {
                    d7 *= d2;
                }
                dArray3[i2] = (d6 *= d5) * d7;
            }
        }
        lf_02.b(dArray2, 0, dArray3, dArray, 0);
        return lg_02;
    }

    public final lg_0 T() {
        lg_0 lg_02 = new lg_0(this.a);
        boolean bl = false;
        double[] dArray = lg_02.b;
        bl = false;
        double[] dArray2 = this.b;
        lf_0 lf_02 = this.a;
        double[] dArray3 = new double[1 + lf_02.b];
        double d2 = dArray2[0];
        dArray3[0] = BY.r(d2);
        if (lf_02.b > 0) {
            double[] dArray4 = new double[lf_02.b];
            double[] dArray5 = dArray4;
            dArray4[0] = 1.0;
            double d3 = d2;
            double d4 = d3 * d3;
            double d5 = 1.0 / (1.0 - d4);
            double d6 = BY.a(d5);
            dArray3[1] = d6 * dArray5[0];
            for (int i2 = 2; i2 <= lf_02.b; ++i2) {
                double d7 = 0.0;
                dArray5[i2 - 1] = (double)(i2 - 1) * dArray5[i2 - 2];
                for (int i3 = i2 - 1; i3 >= 0; i3 -= 2) {
                    d7 = d7 * d4 + dArray5[i3];
                    if (i3 > 2) {
                        dArray5[i3 - 2] = (double)(i3 - 1) * dArray5[i3 - 1] + (double)(2 * i2 - i3) * dArray5[i3 - 3];
                        continue;
                    }
                    if (i3 != 2) continue;
                    dArray5[0] = dArray5[1];
                }
                if ((i2 & 1) == 0) {
                    d7 *= d2;
                }
                dArray3[i2] = (d6 *= d5) * d7;
            }
        }
        lf_02.b(dArray2, 0, dArray3, dArray, 0);
        return lg_02;
    }

    public final lg_0 U() {
        lg_0 lg_02 = new lg_0(this.a);
        this.a.k(this.b, 0, lg_02.b, 0);
        return lg_02;
    }

    private lg_0 j(lg_0 lg_02) {
        this.a.a(lg_02.a);
        lg_0 lg_03 = new lg_0(this.a);
        boolean bl = false;
        double[] dArray = lg_03.b;
        bl = false;
        double[] dArray2 = lg_02.b;
        bl = false;
        double[] dArray3 = this.b;
        lf_0 lf_02 = this.a;
        double[] dArray4 = new double[lf_02.c()];
        lf_02.c(dArray2, 0, dArray2, 0, dArray4, 0);
        double[] dArray5 = new double[lf_02.c()];
        lf_02.c(dArray3, 0, dArray3, 0, dArray5, 0);
        lf_02.a(dArray4, 0, dArray5, 0, dArray5, 0);
        lf_02.b(dArray5, 0, 2, dArray4, 0);
        if (dArray2[0] >= 0.0) {
            lf_02.a(dArray4, 0, dArray2, 0, dArray5, 0);
            lf_02.a(dArray3, 0, dArray5, dArray4, 0);
            lf_02.k(dArray4, 0, dArray5, 0);
            for (int i2 = 0; i2 < dArray5.length; ++i2) {
                dArray[i2 + 0] = 2.0 * dArray5[i2];
            }
        } else {
            lf_02.b(dArray4, 0, dArray2, 0, dArray5, 0);
            lf_02.a(dArray3, 0, dArray5, dArray4, 0);
            lf_02.k(dArray4, 0, dArray5, 0);
            dArray[0] = (dArray5[0] <= 0.0 ? -Math.PI : Math.PI) - 2.0 * dArray5[0];
            for (int i3 = 1; i3 < dArray5.length; ++i3) {
                dArray[i3 + 0] = -2.0 * dArray5[i3];
            }
        }
        dArray[0] = BY.b(dArray3[0], dArray2[0]);
        return lg_03;
    }

    private static lg_0 b(lg_0 lg_02, lg_0 lg_03) {
        return lg_02.j(lg_03);
    }

    public final lg_0 V() {
        lg_0 lg_02 = new lg_0(this.a);
        boolean bl = false;
        double[] dArray = lg_02.b;
        bl = false;
        double[] dArray2 = this.b;
        lf_0 lf_02 = this.a;
        double[] dArray3 = new double[1 + lf_02.b];
        double[] dArray4 = dArray3;
        dArray3[0] = BY.b(dArray2[0]);
        if (lf_02.b > 0) {
            dArray4[1] = BY.c(dArray2[0]);
            for (int i2 = 2; i2 <= lf_02.b; ++i2) {
                dArray4[i2] = dArray4[i2 - 2];
            }
        }
        lf_02.b(dArray2, 0, dArray4, dArray, 0);
        return lg_02;
    }

    public final lg_0 W() {
        lg_0 lg_02 = new lg_0(this.a);
        boolean bl = false;
        double[] dArray = lg_02.b;
        bl = false;
        double[] dArray2 = this.b;
        lf_0 lf_02 = this.a;
        double[] dArray3 = new double[1 + lf_02.b];
        double[] dArray4 = dArray3;
        dArray3[0] = BY.c(dArray2[0]);
        if (lf_02.b > 0) {
            dArray4[1] = BY.b(dArray2[0]);
            for (int i2 = 2; i2 <= lf_02.b; ++i2) {
                dArray4[i2] = dArray4[i2 - 2];
            }
        }
        lf_02.b(dArray2, 0, dArray4, dArray, 0);
        return lg_02;
    }

    public final lg_0 X() {
        double d2;
        lg_0 lg_02 = new lg_0(this.a);
        boolean bl = false;
        double[] dArray = lg_02.b;
        bl = false;
        double[] dArray2 = this.b;
        lf_0 lf_02 = this.a;
        double[] dArray3 = new double[1 + lf_02.b];
        dArray3[0] = d2 = BY.d(dArray2[0]);
        if (lf_02.b > 0) {
            double[] dArray4 = new double[lf_02.b + 2];
            double[] dArray5 = dArray4;
            dArray4[1] = 1.0;
            double d3 = d2;
            double d4 = d3 * d3;
            for (int i2 = 1; i2 <= lf_02.b; ++i2) {
                double d5 = 0.0;
                dArray5[i2 + 1] = (double)(-i2) * dArray5[i2];
                for (int i3 = i2 + 1; i3 >= 0; i3 -= 2) {
                    d5 = d5 * d4 + dArray5[i3];
                    if (i3 > 2) {
                        dArray5[i3 - 2] = (double)(i3 - 1) * dArray5[i3 - 1] - (double)(i3 - 3) * dArray5[i3 - 3];
                        continue;
                    }
                    if (i3 != 2) continue;
                    dArray5[0] = dArray5[1];
                }
                if ((i2 & 1) == 0) {
                    d5 *= d2;
                }
                dArray3[i2] = d5;
            }
        }
        lf_02.b(dArray2, 0, dArray3, dArray, 0);
        return lg_02;
    }

    public final lg_0 Y() {
        lg_0 lg_02 = new lg_0(this.a);
        boolean bl = false;
        double[] dArray = lg_02.b;
        bl = false;
        double[] dArray2 = this.b;
        lf_0 lf_02 = this.a;
        double[] dArray3 = new double[1 + lf_02.b];
        double d2 = dArray2[0];
        dArray3[0] = BY.e(d2);
        if (lf_02.b > 0) {
            double[] dArray4 = new double[lf_02.b];
            double[] dArray5 = dArray4;
            dArray4[0] = 1.0;
            double d3 = d2;
            double d4 = d3 * d3;
            double d5 = 1.0 / (d4 - 1.0);
            double d6 = BY.a(d5);
            dArray3[1] = d6 * dArray5[0];
            for (int i2 = 2; i2 <= lf_02.b; ++i2) {
                double d7 = 0.0;
                dArray5[i2 - 1] = (double)(1 - i2) * dArray5[i2 - 2];
                for (int i3 = i2 - 1; i3 >= 0; i3 -= 2) {
                    d7 = d7 * d4 + dArray5[i3];
                    if (i3 > 2) {
                        dArray5[i3 - 2] = (double)(1 - i3) * dArray5[i3 - 1] + (double)(i3 - 2 * i2) * dArray5[i3 - 3];
                        continue;
                    }
                    if (i3 != 2) continue;
                    dArray5[0] = -dArray5[1];
                }
                if ((i2 & 1) == 0) {
                    d7 *= d2;
                }
                dArray3[i2] = (d6 *= d5) * d7;
            }
        }
        lf_02.b(dArray2, 0, dArray3, dArray, 0);
        return lg_02;
    }

    public final lg_0 Z() {
        lg_0 lg_02 = new lg_0(this.a);
        boolean bl = false;
        double[] dArray = lg_02.b;
        bl = false;
        double[] dArray2 = this.b;
        lf_0 lf_02 = this.a;
        double[] dArray3 = new double[1 + lf_02.b];
        double d2 = dArray2[0];
        dArray3[0] = BY.f(d2);
        if (lf_02.b > 0) {
            double[] dArray4 = new double[lf_02.b];
            double[] dArray5 = dArray4;
            dArray4[0] = 1.0;
            double d3 = d2;
            double d4 = d3 * d3;
            double d5 = 1.0 / (d4 + 1.0);
            double d6 = BY.a(d5);
            dArray3[1] = d6 * dArray5[0];
            for (int i2 = 2; i2 <= lf_02.b; ++i2) {
                double d7 = 0.0;
                dArray5[i2 - 1] = (double)(1 - i2) * dArray5[i2 - 2];
                for (int i3 = i2 - 1; i3 >= 0; i3 -= 2) {
                    d7 = d7 * d4 + dArray5[i3];
                    if (i3 > 2) {
                        dArray5[i3 - 2] = (double)(i3 - 1) * dArray5[i3 - 1] + (double)(i3 - 2 * i2) * dArray5[i3 - 3];
                        continue;
                    }
                    if (i3 != 2) continue;
                    dArray5[0] = dArray5[1];
                }
                if ((i2 & 1) == 0) {
                    d7 *= d2;
                }
                dArray3[i2] = (d6 *= d5) * d7;
            }
        }
        lf_02.b(dArray2, 0, dArray3, dArray, 0);
        return lg_02;
    }

    public final lg_0 aa() {
        lg_0 lg_02 = new lg_0(this.a);
        boolean bl = false;
        double[] dArray = lg_02.b;
        bl = false;
        double[] dArray2 = this.b;
        lf_0 lf_02 = this.a;
        double[] dArray3 = new double[1 + lf_02.b];
        double d2 = dArray2[0];
        dArray3[0] = BY.g(d2);
        if (lf_02.b > 0) {
            double d3;
            double[] dArray4 = new double[lf_02.b];
            double[] dArray5 = dArray4;
            dArray4[0] = 1.0;
            double d4 = d2;
            double d5 = d4 * d4;
            double d6 = d3 = 1.0 / (1.0 - d5);
            dArray3[1] = d6 * dArray5[0];
            for (int i2 = 2; i2 <= lf_02.b; ++i2) {
                double d7 = 0.0;
                dArray5[i2 - 1] = (double)i2 * dArray5[i2 - 2];
                for (int i3 = i2 - 1; i3 >= 0; i3 -= 2) {
                    d7 = d7 * d5 + dArray5[i3];
                    if (i3 > 2) {
                        dArray5[i3 - 2] = (double)(i3 - 1) * dArray5[i3 - 1] + (double)(2 * i2 - i3 + 1) * dArray5[i3 - 3];
                        continue;
                    }
                    if (i3 != 2) continue;
                    dArray5[0] = dArray5[1];
                }
                if ((i2 & 1) == 0) {
                    d7 *= d2;
                }
                dArray3[i2] = (d6 *= d3) * d7;
            }
        }
        lf_02.b(dArray2, 0, dArray3, dArray, 0);
        return lg_02;
    }

    private lg_0 ah() {
        lg_0 lg_02 = new lg_0(this.a);
        for (int i2 = 0; i2 < lg_02.b.length; ++i2) {
            lg_02.b[i2] = BY.v(this.b[i2]);
        }
        return lg_02;
    }

    private lg_0 ai() {
        lg_0 lg_02 = new lg_0(this.a);
        for (int i2 = 0; i2 < lg_02.b.length; ++i2) {
            lg_02.b[i2] = BY.u(this.b[i2]);
        }
        return lg_02;
    }

    @Override
    private double b(double ... dArray) {
        return this.a.a(this.b, 0, dArray);
    }

    private static lg_0 a(lg_0[] lg_0Array, lg_0[] lg_0Array2) {
        lg_0 lg_02;
        Object object = new double[lg_0Array.length];
        for (int i2 = 0; i2 < lg_0Array.length; ++i2) {
            lg_02 = lg_0Array[i2];
            object[i2] = lg_02.b[0];
        }
        double[] dArray = new double[lg_0Array2.length];
        for (int i3 = 0; i3 < lg_0Array2.length; ++i3) {
            lg_02 = lg_0Array2[i3];
            dArray[i3] = lg_02.b[0];
        }
        double d2 = ch_0.h((double[])object, dArray);
        object = lg_0Array[0].c().a();
        for (int i4 = 0; i4 < lg_0Array.length; ++i4) {
            object = ((lg_0)object).a(lg_0Array[i4].b(lg_0Array2[i4]));
        }
        double[] dArray2 = ((lg_0)object).F();
        double[] dArray3 = dArray2;
        dArray2[0] = d2;
        return new lg_0(((lg_0)object).C(), ((lg_0)object).D(), dArray3);
    }

    private static lg_0 a(double[] dArray, lg_0[] lg_0Array) {
        Object object = new double[lg_0Array.length];
        for (int i2 = 0; i2 < lg_0Array.length; ++i2) {
            lg_0 lg_02 = lg_0Array[i2];
            object[i2] = lg_02.b[0];
        }
        double d2 = ch_0.h(dArray, (double[])object);
        object = lg_0Array[0].c().a();
        for (int i3 = 0; i3 < dArray.length; ++i3) {
            object = ((lg_0)object).a(lg_0Array[i3].j(dArray[i3]));
        }
        double[] dArray2 = ((lg_0)object).F();
        double[] dArray3 = dArray2;
        dArray2[0] = d2;
        return new lg_0(((lg_0)object).C(), ((lg_0)object).D(), dArray3);
    }

    @Override
    private lg_0 a(lg_0 object, lg_0 lg_02, lg_0 lg_03, lg_0 lg_04) {
        lg_0 lg_05 = object;
        lg_0 lg_06 = lg_05;
        lg_0 lg_07 = lg_02;
        lg_06 = lg_07;
        lg_0 lg_08 = lg_03;
        lg_06 = lg_08;
        lg_06 = lg_04;
        double d2 = ch_0.a(lg_05.b[0], lg_07.b[0], lg_08.b[0], lg_06.b[0]);
        object = ((lg_0)object).b(lg_02).a(lg_03.b(lg_04));
        double[] dArray = ((lg_0)object).F();
        object = dArray;
        dArray[0] = d2;
        return new lg_0(this.C(), this.D(), (double[])object);
    }

    @Override
    private lg_0 a(double d2, lg_0 lg_02, double d3, lg_0 lg_03) {
        lg_0 lg_04 = lg_02;
        lg_0 lg_05 = lg_04;
        lg_05 = lg_03;
        double d4 = ch_0.a(d2, lg_04.b[0], d3, lg_05.b[0]);
        Object object = lg_02.j(d2).a(lg_03.j(d3));
        double[] dArray = ((lg_0)object).F();
        object = dArray;
        dArray[0] = d4;
        return new lg_0(this.C(), this.D(), (double[])object);
    }

    @Override
    private lg_0 a(lg_0 object, lg_0 lg_02, lg_0 lg_03, lg_0 lg_04, lg_0 lg_05, lg_0 lg_06) {
        lg_0 lg_07 = object;
        lg_0 lg_08 = lg_07;
        lg_0 lg_09 = lg_02;
        lg_08 = lg_09;
        lg_0 lg_010 = lg_03;
        lg_08 = lg_010;
        lg_0 lg_011 = lg_04;
        lg_08 = lg_011;
        lg_0 lg_012 = lg_05;
        lg_08 = lg_012;
        lg_08 = lg_06;
        double d2 = ch_0.a(lg_07.b[0], lg_09.b[0], lg_010.b[0], lg_011.b[0], lg_012.b[0], lg_08.b[0]);
        object = ((lg_0)object).b(lg_02).a(lg_03.b(lg_04)).a(lg_05.b(lg_06));
        double[] dArray = ((lg_0)object).F();
        object = dArray;
        dArray[0] = d2;
        return new lg_0(this.C(), this.D(), (double[])object);
    }

    @Override
    private lg_0 a(double d2, lg_0 lg_02, double d3, lg_0 lg_03, double d4, lg_0 lg_04) {
        lg_0 lg_05 = lg_02;
        lg_0 lg_06 = lg_05;
        lg_0 lg_07 = lg_03;
        lg_06 = lg_07;
        lg_06 = lg_04;
        double d5 = ch_0.a(d2, lg_05.b[0], d3, lg_07.b[0], d4, lg_06.b[0]);
        Object object = lg_02.j(d2).a(lg_03.j(d3)).a(lg_04.j(d4));
        double[] dArray = ((lg_0)object).F();
        object = dArray;
        dArray[0] = d5;
        return new lg_0(this.C(), this.D(), (double[])object);
    }

    @Override
    private lg_0 a(lg_0 object, lg_0 lg_02, lg_0 lg_03, lg_0 lg_04, lg_0 lg_05, lg_0 lg_06, lg_0 lg_07, lg_0 lg_08) {
        lg_0 lg_09 = object;
        lg_0 lg_010 = lg_09;
        lg_0 lg_011 = lg_02;
        lg_010 = lg_011;
        lg_0 lg_012 = lg_03;
        lg_010 = lg_012;
        lg_0 lg_013 = lg_04;
        lg_010 = lg_013;
        lg_0 lg_014 = lg_05;
        lg_010 = lg_014;
        lg_0 lg_015 = lg_06;
        lg_010 = lg_015;
        lg_0 lg_016 = lg_07;
        lg_010 = lg_016;
        lg_010 = lg_08;
        double d2 = ch_0.a(lg_09.b[0], lg_011.b[0], lg_012.b[0], lg_013.b[0], lg_014.b[0], lg_015.b[0], lg_016.b[0], lg_010.b[0]);
        object = ((lg_0)object).b(lg_02).a(lg_03.b(lg_04)).a(lg_05.b(lg_06)).a(lg_07.b(lg_08));
        double[] dArray = ((lg_0)object).F();
        object = dArray;
        dArray[0] = d2;
        return new lg_0(this.C(), this.D(), (double[])object);
    }

    @Override
    private lg_0 a(double d2, lg_0 lg_02, double d3, lg_0 lg_03, double d4, lg_0 lg_04, double d5, lg_0 lg_05) {
        lg_0 lg_06 = lg_02;
        lg_0 lg_07 = lg_06;
        lg_0 lg_08 = lg_03;
        lg_07 = lg_08;
        lg_0 lg_09 = lg_04;
        lg_07 = lg_09;
        lg_07 = lg_05;
        double d6 = ch_0.a(d2, lg_06.b[0], d3, lg_08.b[0], d4, lg_09.b[0], d5, lg_07.b[0]);
        Object object = lg_02.j(d2).a(lg_03.j(d3)).a(lg_04.j(d4)).a(lg_05.j(d5));
        double[] dArray = ((lg_0)object).F();
        object = dArray;
        dArray[0] = d6;
        return new lg_0(this.C(), this.D(), (double[])object);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof lg_0) {
            lg_0 lg_02;
            lg_02 = lg_02;
            return this.C() == lg_02.C() && this.D() == lg_02.D() && ch_0.i(this.b, lg_02.b);
        }
        return false;
    }

    public int hashCode() {
        double[] dArray = this.b;
        return 227 + 229 * this.C() + 233 * this.D() + 239 * Arrays.hashCode(this.b);
    }

    private a aj() {
        lf_0 lf_02 = this.a;
        lf_0 lf_03 = lf_02;
        lf_03 = this.a;
        return new a(lf_02.a, lf_03.b, this.b);
    }

    @Override
    public final /* synthetic */ kO a(double d2, kO kO2, double d3, kO kO3, double d4, kO kO4, double d5, kO kO5) {
        lg_0 lg_02 = (lg_0)kO2;
        lg_0 lg_03 = (lg_0)kO5;
        double d6 = d5;
        lg_0 lg_04 = (lg_0)kO4;
        double d7 = d4;
        kO2 = (lg_0)kO3;
        double d8 = d3;
        Object object = lg_02;
        double d9 = d2;
        lg_0 lg_05 = this;
        lg_0 lg_06 = object;
        kO3 = lg_06;
        kO kO6 = kO2;
        kO3 = kO6;
        lg_0 lg_07 = lg_04;
        kO3 = lg_07;
        kO3 = lg_03;
        double d10 = ch_0.a(d9, lg_06.b[0], d8, ((lg_0)kO6).b[0], d7, lg_07.b[0], d6, ((lg_0)kO3).b[0]);
        object = ((lg_0)object).j(d9).a(((lg_0)kO2).j(d8)).a(lg_04.j(d7)).a(lg_03.j(d6));
        double[] dArray = ((lg_0)object).F();
        object = dArray;
        dArray[0] = d10;
        return new lg_0(lg_05.C(), lg_05.D(), (double[])object);
    }

    @Override
    public final /* synthetic */ kO a(kO kO2, kO object, kO kO3, kO kO4, kO kO5, kO kO6, kO kO7, kO kO8) {
        lg_0 lg_02 = (lg_0)kO8;
        kO8 = (lg_0)kO7;
        kO7 = (lg_0)kO6;
        kO6 = (lg_0)kO5;
        kO5 = (lg_0)kO4;
        kO4 = (lg_0)kO3;
        kO3 = (lg_0)object;
        object = (lg_0)kO2;
        kO2 = this;
        kO kO9 = object;
        kO kO10 = kO9;
        kO kO11 = kO3;
        kO10 = kO11;
        kO kO12 = kO4;
        kO10 = kO12;
        kO kO13 = kO5;
        kO10 = kO13;
        kO kO14 = kO6;
        kO10 = kO14;
        kO kO15 = kO7;
        kO10 = kO15;
        kO kO16 = kO8;
        kO10 = kO16;
        kO10 = lg_02;
        double d2 = ch_0.a(((lg_0)kO9).b[0], ((lg_0)kO11).b[0], ((lg_0)kO12).b[0], ((lg_0)kO13).b[0], ((lg_0)kO14).b[0], ((lg_0)kO15).b[0], ((lg_0)kO16).b[0], ((lg_0)kO10).b[0]);
        object = ((lg_0)object).b((lg_0)kO3).a(((lg_0)kO4).b((lg_0)kO5)).a(((lg_0)kO6).b((lg_0)kO7)).a(((lg_0)kO8).b(lg_02));
        double[] dArray = ((lg_0)object).F();
        object = dArray;
        dArray[0] = d2;
        return new lg_0(((lg_0)kO2).C(), ((lg_0)kO2).D(), (double[])object);
    }

    @Override
    public final /* synthetic */ kO a(double d2, kO kO2, double d3, kO kO3, double d4, kO kO4) {
        lg_0 lg_02 = (lg_0)kO2;
        lg_0 lg_03 = (lg_0)kO4;
        double d5 = d4;
        kO2 = (lg_0)kO3;
        double d6 = d3;
        Object object = lg_02;
        double d7 = d2;
        lg_0 lg_04 = this;
        lg_0 lg_05 = object;
        kO<lg_0> kO5 = lg_05;
        kO kO6 = kO2;
        kO5 = kO6;
        kO5 = lg_03;
        double d8 = ch_0.a(d7, lg_05.b[0], d6, ((lg_0)kO6).b[0], d5, kO5.b[0]);
        object = ((lg_0)object).j(d7).a(((lg_0)kO2).j(d6)).a(lg_03.j(d5));
        double[] dArray = ((lg_0)object).F();
        object = dArray;
        dArray[0] = d8;
        return new lg_0(lg_04.C(), lg_04.D(), (double[])object);
    }

    @Override
    public final /* synthetic */ kO a(kO kO2, kO object, kO kO3, kO kO4, kO kO5, kO kO6) {
        lg_0 lg_02 = (lg_0)kO6;
        kO6 = (lg_0)kO5;
        kO5 = (lg_0)kO4;
        kO4 = (lg_0)kO3;
        kO3 = (lg_0)object;
        object = (lg_0)kO2;
        kO2 = this;
        kO kO7 = object;
        kO kO8 = kO7;
        kO kO9 = kO3;
        kO8 = kO9;
        kO kO10 = kO4;
        kO8 = kO10;
        kO kO11 = kO5;
        kO8 = kO11;
        kO kO12 = kO6;
        kO8 = kO12;
        kO8 = lg_02;
        double d2 = ch_0.a(((lg_0)kO7).b[0], ((lg_0)kO9).b[0], ((lg_0)kO10).b[0], ((lg_0)kO11).b[0], ((lg_0)kO12).b[0], ((lg_0)kO8).b[0]);
        object = ((lg_0)object).b((lg_0)kO3).a(((lg_0)kO4).b((lg_0)kO5)).a(((lg_0)kO6).b(lg_02));
        double[] dArray = ((lg_0)object).F();
        object = dArray;
        dArray[0] = d2;
        return new lg_0(((lg_0)kO2).C(), ((lg_0)kO2).D(), (double[])object);
    }

    @Override
    public final /* synthetic */ kO a(double d2, kO kO2, double d3, kO kO3) {
        lg_0 lg_02 = (lg_0)kO2;
        kO2 = (lg_0)kO3;
        double d4 = d3;
        Object object = lg_02;
        double d5 = d2;
        lg_0 lg_03 = this;
        lg_0 lg_04 = object;
        kO<lg_0> kO4 = lg_04;
        kO4 = kO2;
        double d6 = ch_0.a(d5, lg_04.b[0], d4, kO4.b[0]);
        object = ((lg_0)object).j(d5).a(((lg_0)kO2).j(d4));
        double[] dArray = ((lg_0)object).F();
        object = dArray;
        dArray[0] = d6;
        return new lg_0(lg_03.C(), lg_03.D(), (double[])object);
    }

    @Override
    public final /* synthetic */ kO a(kO kO2, kO object, Object object2, kO kO3) {
        lg_0 lg_02 = (lg_0)kO3;
        kO3 = (lg_0)object2;
        object2 = (lg_0)object;
        object = (lg_0)kO2;
        kO2 = this;
        kO kO4 = object;
        Object object3 = kO4;
        Object object4 = object2;
        object3 = object4;
        kO kO5 = kO3;
        object3 = kO5;
        object3 = lg_02;
        double d2 = ch_0.a(((lg_0)kO4).b[0], ((lg_0)object4).b[0], ((lg_0)kO5).b[0], ((lg_0)object3).b[0]);
        object = ((lg_0)object).b((lg_0)object2).a(((lg_0)kO3).b(lg_02));
        double[] dArray = ((lg_0)object).F();
        object = dArray;
        dArray[0] = d2;
        return new lg_0(((lg_0)kO2).C(), ((lg_0)kO2).D(), (double[])object);
    }

    @Override
    public final /* synthetic */ kO a(double[] dArray, Object[] objectArray) {
        objectArray = (lg_0[])objectArray;
        Object object = new double[objectArray.length];
        for (int i2 = 0; i2 < objectArray.length; ++i2) {
            Object object2 = objectArray[i2];
            object[i2] = ((lg_0)object2).b[0];
        }
        double d2 = ch_0.h(dArray, (double[])object);
        object = ((lg_0)objectArray[0]).c().a();
        for (int i3 = 0; i3 < dArray.length; ++i3) {
            object = ((lg_0)object).a(((lg_0)objectArray[i3]).j(dArray[i3]));
        }
        double[] dArray2 = ((lg_0)object).F();
        double[] dArray3 = dArray2;
        dArray2[0] = d2;
        return new lg_0(((lg_0)object).C(), ((lg_0)object).D(), dArray3);
    }

    @Override
    public final /* synthetic */ kO a(Object[] objectArray, Object[] objectArray2) {
        Object object;
        objectArray2 = (lg_0[])objectArray2;
        objectArray = (lg_0[])objectArray;
        Object object2 = new double[objectArray.length];
        for (int i2 = 0; i2 < objectArray.length; ++i2) {
            object = objectArray[i2];
            object2[i2] = ((lg_0)object).b[0];
        }
        double[] dArray = new double[objectArray2.length];
        for (int i3 = 0; i3 < objectArray2.length; ++i3) {
            object = objectArray2[i3];
            dArray[i3] = ((lg_0)object).b[0];
        }
        double d2 = ch_0.h((double[])object2, dArray);
        object2 = ((lg_0)objectArray[0]).c().a();
        for (int i4 = 0; i4 < objectArray.length; ++i4) {
            object2 = ((lg_0)object2).a(((lg_0)objectArray[i4]).b((lg_0)objectArray2[i4]));
        }
        double[] dArray2 = ((lg_0)object2).F();
        double[] dArray3 = dArray2;
        dArray2[0] = d2;
        return new lg_0(((lg_0)object2).C(), ((lg_0)object2).D(), dArray3);
    }

    @Override
    public final /* synthetic */ kO B() {
        return this.aa();
    }

    @Override
    public final /* synthetic */ kO A() {
        return this.Z();
    }

    @Override
    public final /* synthetic */ kO z() {
        return this.Y();
    }

    @Override
    public final /* synthetic */ kO y() {
        return this.X();
    }

    @Override
    public final /* synthetic */ kO x() {
        return this.W();
    }

    @Override
    public final /* synthetic */ kO w() {
        return this.V();
    }

    @Override
    public final /* synthetic */ kO h(Object object) {
        return this.j((lg_0)object);
    }

    @Override
    public final /* synthetic */ kO v() {
        return this.U();
    }

    @Override
    public final /* synthetic */ kO u() {
        return this.T();
    }

    @Override
    public final /* synthetic */ kO t() {
        return this.S();
    }

    @Override
    public final /* synthetic */ kO s() {
        return this.R();
    }

    @Override
    public final /* synthetic */ kO r() {
        return this.Q();
    }

    @Override
    public final /* synthetic */ kO q() {
        return this.P();
    }

    @Override
    public final /* synthetic */ kO p() {
        return this.N();
    }

    @Override
    public final /* synthetic */ kO o() {
        return this.M();
    }

    @Override
    public final /* synthetic */ kO n() {
        return this.L();
    }

    @Override
    public final /* synthetic */ kO m() {
        return this.K();
    }

    @Override
    public final /* synthetic */ kO a(kO kO2) {
        Object object = (lg_0)kO2;
        kO2 = this;
        ((lg_0)kO2).a.a(((lg_0)object).a);
        lg_0 lg_02 = new lg_0(((lg_0)kO2).a);
        boolean bl = false;
        double[] dArray = lg_02.b;
        bl = false;
        double[] dArray2 = ((lg_0)object).b;
        bl = false;
        object = ((lg_0)kO2).b;
        lf_0 lf_02 = ((lg_0)kO2).a;
        double[] dArray3 = new double[lf_02.c()];
        lf_02.c((double[])object, 0, dArray3, 0);
        object = new double[lf_02.c()];
        lf_02.c(dArray3, 0, dArray2, 0, (double[])object, 0);
        lf_02.a((double[])object, 0, dArray, 0);
        return lg_02;
    }

    @Override
    public final /* synthetic */ kO d(int n2) {
        int n3 = n2;
        lg_0 lg_02 = this;
        lg_0 lg_03 = new lg_0(lg_02.a);
        lg_02.a.a(lg_02.b, 0, n3, lg_03.b, 0);
        return lg_03;
    }

    @Override
    public final /* synthetic */ kO g(double d2) {
        return this.k(d2);
    }

    @Override
    public final /* synthetic */ kO c(int n2) {
        return this.e(n2);
    }

    @Override
    public final /* synthetic */ kO l() {
        lg_0 lg_02 = this;
        return lg_02.e(3);
    }

    @Override
    public final /* synthetic */ kO k() {
        lg_0 lg_02 = this;
        return lg_02.e(2);
    }

    @Override
    public final /* synthetic */ kN b() {
        return this.H();
    }

    @Override
    public final /* synthetic */ kO g(Object object) {
        return this.h((lg_0)object);
    }

    @Override
    public final /* synthetic */ kO b(int n2) {
        return this.g(n2);
    }

    @Override
    public final /* synthetic */ kO f(double d2) {
        double d3 = d2;
        lg_0 lg_02 = this;
        long l2 = Double.doubleToLongBits(lg_02.b[0]);
        long l3 = Double.doubleToLongBits(d3);
        if (l2 >= 0L && l3 >= 0L || l2 < 0L && l3 < 0L) {
            return lg_02;
        }
        return lg_02.G();
    }

    @Override
    public final /* synthetic */ kO f(Object object) {
        lg_0 lg_02 = (lg_0)object;
        object = this;
        long l2 = Double.doubleToLongBits(((lg_0)object).b[0]);
        long l3 = Double.doubleToLongBits(lg_02.b[0]);
        if (l2 >= 0L && l3 >= 0L || l2 < 0L && l3 < 0L) {
            return object;
        }
        return ((lg_0)object).G();
    }

    @Override
    public final /* synthetic */ kO j() {
        lg_0 lg_02 = this;
        lf_0 lf_02 = lg_02.a;
        lf_0 lf_03 = lf_02;
        lf_03 = lg_02.a;
        return new lg_0(lf_02.a, lf_03.b, BY.h(lg_02.b[0]));
    }

    @Override
    public final /* synthetic */ kO h() {
        lg_0 lg_02 = this;
        lf_0 lf_02 = lg_02.a;
        lf_0 lf_03 = lf_02;
        lf_03 = lg_02.a;
        return new lg_0(lf_02.a, lf_03.b, BY.A(lg_02.b[0]));
    }

    @Override
    public final /* synthetic */ kO g() {
        lg_0 lg_02 = this;
        lf_0 lf_02 = lg_02.a;
        lf_0 lf_03 = lf_02;
        lf_03 = lg_02.a;
        return new lg_0(lf_02.a, lf_03.b, BY.y(lg_02.b[0]));
    }

    @Override
    public final /* synthetic */ kO f() {
        lg_0 lg_02 = this;
        lf_0 lf_02 = lg_02.a;
        lf_0 lf_03 = lf_02;
        lf_03 = lg_02.a;
        return new lg_0(lf_02.a, lf_03.b, BY.z(lg_02.b[0]));
    }

    @Override
    public final /* synthetic */ kO e() {
        return this.ab();
    }

    @Override
    public final /* synthetic */ kO e(Object object) {
        Object object2 = (lg_0)object;
        object = this;
        ((lg_0)object).a.a(((lg_0)object2).a);
        lg_0 lg_02 = new lg_0(((lg_0)object).a);
        boolean bl = false;
        double[] dArray = lg_02.b;
        bl = false;
        double[] dArray2 = ((lg_0)object2).b;
        bl = false;
        object2 = ((lg_0)object).b;
        lf_0 lf_02 = ((lg_0)object).a;
        double d2 = BY.g((double)object2[0], dArray2[0]);
        double d3 = BY.A((double)((object2[0] - d2) / dArray2[0]));
        dArray[0] = d2;
        for (int i2 = 1; i2 < lf_02.c(); ++i2) {
            dArray[i2 + 0] = (double)(object2[i2 + 0] - d3 * dArray2[i2 + 0]);
        }
        return lg_02;
    }

    @Override
    public final /* synthetic */ kO e(double d2) {
        double d3 = d2;
        lg_0 lg_02 = this;
        lg_02 = new lg_0(lg_02);
        lg_02.b[0] = BY.g(lg_02.b[0], d3);
        return lg_02;
    }

    @Override
    public final /* synthetic */ kO d(double d2) {
        double d3 = d2;
        lg_0 lg_02 = this;
        lg_02 = new lg_0(lg_02);
        int n2 = 0;
        while (n2 < lg_02.b.length) {
            int n3 = n2++;
            lg_02.b[n3] = lg_02.b[n3] / d3;
        }
        return lg_02;
    }

    @Override
    public final /* synthetic */ kO c(double d2) {
        return this.j(d2);
    }

    @Override
    public final /* synthetic */ kO b(double d2) {
        double d3 = d2;
        lg_0 lg_02 = this;
        return lg_02.h(-d3);
    }

    @Override
    public final /* synthetic */ kO a(double d2) {
        return this.h(d2);
    }

    @Override
    public final /* synthetic */ kN d(Object object) {
        lg_0 lg_02 = (lg_0)object;
        object = this;
        ((lg_0)object).a.a(lg_02.a);
        lg_0 lg_03 = new lg_0(((lg_0)object).a);
        ((lg_0)object).a.a(((lg_0)object).b, 0, lg_02.b, lg_03.b, 0);
        return lg_03;
    }

    @Override
    public final /* synthetic */ kN c(Object object) {
        return this.b((lg_0)object);
    }

    @Override
    public final /* synthetic */ kN a(int n2) {
        int n3 = n2;
        lg_0 lg_02 = this;
        return lg_02.j(n3);
    }

    @Override
    public final /* synthetic */ kN a() {
        return this.G();
    }

    @Override
    public final /* synthetic */ kN b(Object object) {
        lg_0 lg_02 = (lg_0)object;
        object = this;
        ((lg_0)object).a.a(lg_02.a);
        lg_0 lg_03 = new lg_0((lg_0)object);
        ((lg_0)object).a.b(((lg_0)object).b, 0, lg_02.b, 0, lg_03.b, 0);
        return lg_03;
    }

    static final class a
    implements Serializable {
        private static final long a = 20120730L;
        private final int b;
        private final int c;
        private final double[] d;

        a(int n2, int n3, double[] dArray) {
            this.b = n2;
            this.c = n3;
            this.d = dArray;
        }

        private lg_0 a() {
            return new lg(this.b, this.c, this.d);
        }
    }
}

