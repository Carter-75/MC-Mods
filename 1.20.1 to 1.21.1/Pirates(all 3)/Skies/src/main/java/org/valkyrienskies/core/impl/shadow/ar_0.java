/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import java.util.Arrays;
import org.valkyrienskies.core.impl.shadow.AE;
import org.valkyrienskies.core.impl.shadow.AG;
import org.valkyrienskies.core.impl.shadow.AN;
import org.valkyrienskies.core.impl.shadow.AP;
import org.valkyrienskies.core.impl.shadow.AR;
import org.valkyrienskies.core.impl.shadow.AV;
import org.valkyrienskies.core.impl.shadow.AW;
import org.valkyrienskies.core.impl.shadow.AX;
import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.as_0;
import org.valkyrienskies.core.impl.shadow.av_0;
import org.valkyrienskies.core.impl.shadow.ch_0;
import org.valkyrienskies.core.impl.shadow.ci_0;
import org.valkyrienskies.core.impl.shadow.cq_0;
import org.valkyrienskies.core.impl.shadow.oS;
import org.valkyrienskies.core.impl.shadow.oX;
import org.valkyrienskies.core.impl.shadow.px_0;
import org.valkyrienskies.core.impl.shadow.tq_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Ar
 */
public class ar_0
implements Serializable,
as_0 {
    private static final long a = 2271900808994826718L;
    private int b;
    private long c = 0L;
    private av_0[] d;
    private av_0[] e;
    private av_0[] f;
    private av_0[] g;
    private av_0[] h;
    private av_0[] i;
    private av_0[] j;
    private AN k;

    public ar_0(int n2, boolean bl) {
        this.b = n2;
        this.d = new av_0[n2];
        this.e = new av_0[n2];
        this.f = new av_0[n2];
        this.g = new av_0[n2];
        this.h = new av_0[n2];
        this.i = new av_0[n2];
        this.j = new av_0[n2];
        for (int i2 = 0; i2 < n2; ++i2) {
            this.d[i2] = new AV();
            this.e[i2] = new AX();
            this.f[i2] = new AR();
            this.g[i2] = new AP();
            this.h[i2] = new AW();
            this.i[i2] = new AE();
            this.j[i2] = new AG();
        }
        this.k = new AN(n2, bl);
    }

    public void a(double[] object) {
        this.a(((double[])object).length);
        for (int i2 = 0; i2 < this.b; ++i2) {
            double d2 = object[i2];
            this.d[i2].a(d2);
            this.e[i2].a(d2);
            this.f[i2].a(d2);
            this.g[i2].a(d2);
            this.h[i2].a(d2);
            this.i[i2].a(d2);
            this.j[i2].a(d2);
        }
        double[] dArray = object;
        object = this.k;
        if (dArray.length != object.a.length) {
            throw new oS(dArray.length, object.a.length);
        }
        int n2 = 0;
        for (int i3 = 0; i3 < dArray.length; ++i3) {
            int n3 = i3;
            object.a[n3] = object.a[n3] + dArray[i3];
            for (int i4 = 0; i4 <= i3; ++i4) {
                int n4 = n2++;
                object.b[n4] = object.b[n4] + dArray[i3] * dArray[i4];
            }
        }
        ++object.c;
        ++this.c;
    }

    public int a() {
        return this.b;
    }

    public long b() {
        return this.c;
    }

    private static double[] h(av_0[] av_0Array) {
        double[] dArray = new double[av_0Array.length];
        for (int i2 = 0; i2 < dArray.length; ++i2) {
            dArray[i2] = av_0Array[i2].c();
        }
        return dArray;
    }

    public double[] c() {
        return ar_0.h(this.d);
    }

    public double[] d() {
        return ar_0.h(this.e);
    }

    public double[] e() {
        return ar_0.h(this.h);
    }

    public double[] f() {
        return ar_0.h(this.j);
    }

    public double[] g() {
        double[] dArray = new double[this.b];
        if (this.b() < 1L) {
            Arrays.fill(dArray, Double.NaN);
        } else if (this.b() < 2L) {
            Arrays.fill(dArray, 0.0);
        } else {
            tq_0 tq_02 = this.k.a();
            for (int i2 = 0; i2 < this.b; ++i2) {
                int n2 = i2;
                dArray[i2] = BY.a(tq_02.b(n2, n2));
            }
        }
        return dArray;
    }

    public tq_0 h() {
        return this.k.a();
    }

    public double[] i() {
        return ar_0.h(this.g);
    }

    public double[] j() {
        return ar_0.h(this.f);
    }

    public double[] k() {
        return ar_0.h(this.i);
    }

    public String toString() {
        String string = System.getProperty("line.separator");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("MultivariateSummaryStatistics:" + string);
        stringBuilder.append("n: " + this.b() + string);
        ar_0.a(stringBuilder, this.j(), "min: ", ", ", string);
        ar_0.a(stringBuilder, this.i(), "max: ", ", ", string);
        ar_0.a(stringBuilder, this.f(), "mean: ", ", ", string);
        ar_0.a(stringBuilder, this.k(), "geometric mean: ", ", ", string);
        ar_0.a(stringBuilder, this.d(), "sum of squares: ", ", ", string);
        ar_0.a(stringBuilder, this.e(), "sum of logarithms: ", ", ", string);
        ar_0.a(stringBuilder, this.g(), "standard deviation: ", ", ", string);
        stringBuilder.append("covariance: " + this.h().toString() + string);
        return stringBuilder.toString();
    }

    private static void a(StringBuilder stringBuilder, double[] dArray, String string, String string2, String string3) {
        stringBuilder.append(string);
        for (int i2 = 0; i2 < dArray.length; ++i2) {
            if (i2 > 0) {
                stringBuilder.append(string2);
            }
            stringBuilder.append(dArray[i2]);
        }
        stringBuilder.append(string3);
    }

    public void l() {
        this.c = 0L;
        for (int i2 = 0; i2 < this.b; ++i2) {
            this.f[i2].b();
            this.g[i2].b();
            this.d[i2].b();
            this.h[i2].b();
            this.e[i2].b();
            this.i[i2].b();
            this.j[i2].b();
        }
        AN aN = this.k;
        this.k.c = 0L;
        Arrays.fill(aN.a, 0.0);
        Arrays.fill(aN.b, 0.0);
    }

    public boolean equals(Object object) {
        ar_0 ar_02;
        if (object == this) {
            return true;
        }
        if (!(object instanceof ar_0)) {
            return false;
        }
        return ch_0.j((ar_02 = (ar_0)ar_02).k(), this.k()) && ch_0.j(ar_02.i(), this.i()) && ch_0.j(ar_02.f(), this.f()) && ch_0.j(ar_02.j(), this.j()) && cq_0.b(ar_02.b(), this.b()) && ch_0.j(ar_02.c(), this.c()) && ch_0.j(ar_02.d(), this.d()) && ch_0.j(ar_02.e(), this.e()) && ar_02.h().equals(this.h());
    }

    public int hashCode() {
        double[] dArray = this.k();
        int n2 = 31 + Arrays.hashCode(dArray);
        double[] dArray2 = this.k();
        int n3 = n2 * 31 + Arrays.hashCode(dArray2);
        double[] dArray3 = this.i();
        int n4 = n3 * 31 + Arrays.hashCode(dArray3);
        double[] dArray4 = this.f();
        int n5 = n4 * 31 + Arrays.hashCode(dArray4);
        double[] dArray5 = this.j();
        int n6 = n5 * 31 + Arrays.hashCode(dArray5);
        n6 = n6 * 31 + ci_0.a(this.b());
        double[] dArray6 = this.c();
        int n7 = n6 * 31 + Arrays.hashCode(dArray6);
        double[] dArray7 = this.d();
        int n8 = n7 * 31 + Arrays.hashCode(dArray7);
        double[] dArray8 = this.e();
        int n9 = n8 * 31 + Arrays.hashCode(dArray8);
        n9 = n9 * 31 + this.h().hashCode();
        return n9;
    }

    private void a(av_0[] av_0Array, av_0[] av_0Array2) {
        ar_0 ar_02 = this;
        if (ar_02.c > 0L) {
            throw new oX(px_0.VALUES_ADDED_BEFORE_CONFIGURING_STATISTIC, ar_02.c);
        }
        this.a(av_0Array.length);
        System.arraycopy(av_0Array, 0, av_0Array2, 0, av_0Array.length);
    }

    public av_0[] m() {
        return (av_0[])this.d.clone();
    }

    public void a(av_0[] av_0Array) {
        this.a(av_0Array, this.d);
    }

    public av_0[] n() {
        return (av_0[])this.e.clone();
    }

    public void b(av_0[] av_0Array) {
        this.a(av_0Array, this.e);
    }

    public av_0[] o() {
        return (av_0[])this.f.clone();
    }

    public void c(av_0[] av_0Array) {
        this.a(av_0Array, this.f);
    }

    public av_0[] p() {
        return (av_0[])this.g.clone();
    }

    public void d(av_0[] av_0Array) {
        this.a(av_0Array, this.g);
    }

    public av_0[] q() {
        return (av_0[])this.h.clone();
    }

    public void e(av_0[] av_0Array) {
        this.a(av_0Array, this.h);
    }

    public av_0[] r() {
        return (av_0[])this.i.clone();
    }

    public void f(av_0[] av_0Array) {
        this.a(av_0Array, this.i);
    }

    public av_0[] s() {
        return (av_0[])this.j.clone();
    }

    public void g(av_0[] av_0Array) {
        this.a(av_0Array, this.j);
    }

    private void t() {
        if (this.c > 0L) {
            throw new oX(px_0.VALUES_ADDED_BEFORE_CONFIGURING_STATISTIC, this.c);
        }
    }

    private void a(int n2) {
        if (n2 != this.b) {
            throw new oS(n2, this.b);
        }
    }
}

