/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import org.valkyrienskies.core.impl.shadow.AA;
import org.valkyrienskies.core.impl.shadow.AE;
import org.valkyrienskies.core.impl.shadow.AF;
import org.valkyrienskies.core.impl.shadow.AG;
import org.valkyrienskies.core.impl.shadow.AJ;
import org.valkyrienskies.core.impl.shadow.AM;
import org.valkyrienskies.core.impl.shadow.AP;
import org.valkyrienskies.core.impl.shadow.AR;
import org.valkyrienskies.core.impl.shadow.AT;
import org.valkyrienskies.core.impl.shadow.AV;
import org.valkyrienskies.core.impl.shadow.AX;
import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.at_0;
import org.valkyrienskies.core.impl.shadow.ci_0;
import org.valkyrienskies.core.impl.shadow.cs_0;
import org.valkyrienskies.core.impl.shadow.oV;
import org.valkyrienskies.core.impl.shadow.oX;
import org.valkyrienskies.core.impl.shadow.px_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Aq
 */
public class aq_0
implements Serializable,
at_0 {
    private static int a = -1;
    private static final long b = 4133067267405273064L;
    private static final String c = "setQuantile";
    private int d = -1;
    private cs_0 e = new cs_0();
    private AA f = new AG();
    private AA g = new AE();
    private AA h = new AF();
    private AA i = new AP();
    private AA j = new AR();
    private AA k = new AT();
    private AA l = new AJ();
    private AA m = new AM();
    private AA n = new AX();
    private AA o = new AV();

    public aq_0() {
    }

    public aq_0(int n2) {
        this.a(n2);
    }

    private aq_0(double[] dArray) {
        if (dArray != null) {
            this.e = new cs_0(dArray);
        }
    }

    private aq_0(aq_0 aq_02) {
        aq_0.a(aq_02, this);
    }

    public void a(double d2) {
        block5: {
            block4: {
                if (this.d == -1) break block4;
                if (this.d() == (long)this.d) {
                    this.e.b(d2);
                    return;
                }
                if (this.d() >= (long)this.d) break block5;
            }
            this.e.a(d2);
        }
    }

    private void m() {
        try {
            this.e.c(1);
            return;
        }
        catch (oV oV2) {
            throw new oX(px_0.NO_DATA, new Object[0]);
        }
    }

    private double b(double d2) {
        return this.e.c(d2);
    }

    public final double b() {
        aq_0 aq_02 = this;
        return aq_02.a(aq_02.f);
    }

    private double n() {
        aq_0 aq_02 = this;
        return aq_02.a(aq_02.g);
    }

    public final double g() {
        aq_0 aq_02 = this;
        return aq_02.a(aq_02.m);
    }

    private double o() {
        return this.a(new AM(false));
    }

    public double e() {
        double d2 = Double.NaN;
        if (this.d() > 0L) {
            d2 = this.d() > 1L ? BY.a(this.g()) : 0.0;
        }
        return d2;
    }

    public double h() {
        long l2 = this.d();
        if (l2 > 0L) {
            aq_0 aq_02 = this;
            return BY.a(aq_02.a(aq_02.n) / (double)l2);
        }
        return Double.NaN;
    }

    private double p() {
        aq_0 aq_02 = this;
        return aq_02.a(aq_02.l);
    }

    private double q() {
        aq_0 aq_02 = this;
        return aq_02.a(aq_02.h);
    }

    public final double a() {
        aq_0 aq_02 = this;
        return aq_02.a(aq_02.i);
    }

    public final double c() {
        aq_0 aq_02 = this;
        return aq_02.a(aq_02.j);
    }

    public long d() {
        return this.e.a();
    }

    public final double f() {
        aq_0 aq_02 = this;
        return aq_02.a(aq_02.o);
    }

    private double r() {
        aq_0 aq_02 = this;
        return aq_02.a(aq_02.n);
    }

    public void i() {
        this.e.c();
    }

    public int j() {
        return this.d;
    }

    public void a(int n2) {
        if (n2 <= 0 && n2 != -1) {
            throw new oV(px_0.NOT_POSITIVE_WINDOW_SIZE, n2);
        }
        this.d = n2;
        if (n2 != -1 && n2 < this.e.a()) {
            this.e.b(this.e.a() - n2);
        }
    }

    public double[] k() {
        return this.e.b();
    }

    private double[] s() {
        double[] dArray = this.k();
        Arrays.sort(dArray);
        return dArray;
    }

    public double b(int n2) {
        return this.e.a(n2);
    }

    private double c(double d2) {
        if (this.k instanceof AT) {
            ((AT)this.k).a(50.0);
        } else {
            try {
                this.k.getClass().getMethod(c, Double.TYPE).invoke((Object)this.k, 50.0);
            }
            catch (NoSuchMethodException noSuchMethodException) {
                throw new oX(px_0.PERCENTILE_IMPLEMENTATION_UNSUPPORTED_METHOD, this.k.getClass().getName(), c);
            }
            catch (IllegalAccessException illegalAccessException) {
                throw new oX(px_0.PERCENTILE_IMPLEMENTATION_CANNOT_ACCESS_METHOD, c, this.k.getClass().getName());
            }
            catch (InvocationTargetException invocationTargetException) {
                throw new IllegalStateException(invocationTargetException.getCause());
            }
        }
        aq_0 aq_02 = this;
        return aq_02.a(aq_02.k);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String string = "\n";
        stringBuilder.append("DescriptiveStatistics:").append(string);
        stringBuilder.append("n: ").append(this.d()).append(string);
        stringBuilder.append("min: ").append(this.c()).append(string);
        stringBuilder.append("max: ").append(this.a()).append(string);
        stringBuilder.append("mean: ").append(this.b()).append(string);
        stringBuilder.append("std dev: ").append(this.e()).append(string);
        try {
            stringBuilder.append("median: ").append(this.c(50.0)).append(string);
        }
        catch (oX oX2) {
            stringBuilder.append("median: unavailable").append(string);
        }
        aq_0 aq_02 = this;
        stringBuilder.append("skewness: ").append(aq_02.a(aq_02.l)).append(string);
        aq_02 = this;
        stringBuilder.append("kurtosis: ").append(aq_02.a(aq_02.h)).append(string);
        return stringBuilder.toString();
    }

    public double a(AA aA) {
        return this.e.a(aA);
    }

    private synchronized AA t() {
        return this.f;
    }

    private synchronized void b(AA aA) {
        this.f = aA;
    }

    private synchronized AA u() {
        return this.g;
    }

    private synchronized void c(AA aA) {
        this.g = aA;
    }

    private synchronized AA v() {
        return this.h;
    }

    private synchronized void d(AA aA) {
        this.h = aA;
    }

    private synchronized AA w() {
        return this.i;
    }

    private synchronized void e(AA aA) {
        this.i = aA;
    }

    private synchronized AA x() {
        return this.j;
    }

    private synchronized void f(AA aA) {
        this.j = aA;
    }

    private synchronized AA y() {
        return this.k;
    }

    private synchronized void g(AA aA) {
        try {
            aA.getClass().getMethod(c, Double.TYPE).invoke((Object)aA, 50.0);
        }
        catch (NoSuchMethodException noSuchMethodException) {
            throw new oV(px_0.PERCENTILE_IMPLEMENTATION_UNSUPPORTED_METHOD, aA.getClass().getName(), c);
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new oV(px_0.PERCENTILE_IMPLEMENTATION_CANNOT_ACCESS_METHOD, c, aA.getClass().getName());
        }
        catch (InvocationTargetException invocationTargetException) {
            throw new IllegalArgumentException(invocationTargetException.getCause());
        }
        this.k = aA;
    }

    private synchronized AA z() {
        return this.l;
    }

    private synchronized void h(AA aA) {
        this.l = aA;
    }

    private synchronized AA A() {
        return this.m;
    }

    private synchronized void i(AA aA) {
        this.m = aA;
    }

    private synchronized AA B() {
        return this.n;
    }

    private synchronized void j(AA aA) {
        this.n = aA;
    }

    private synchronized AA C() {
        return this.o;
    }

    private synchronized void k(AA aA) {
        this.o = aA;
    }

    public aq_0 l() {
        aq_0 aq_02 = new aq_0();
        aq_0.a(this, aq_02);
        return aq_02;
    }

    public static void a(aq_0 aq_02, aq_0 aq_03) {
        ci_0.a(aq_02);
        ci_0.a(aq_03);
        aq_03.e = aq_02.e.d();
        aq_03.d = aq_02.d;
        aq_03.i = aq_02.i.d();
        aq_03.f = aq_02.f.d();
        aq_03.j = aq_02.j.d();
        aq_03.o = aq_02.o.d();
        aq_03.m = aq_02.m.d();
        aq_03.n = aq_02.n.d();
        aq_03.g = aq_02.g.d();
        aq_03.h = aq_02.h;
        aq_03.l = aq_02.l;
        aq_03.k = aq_02.k;
    }
}

