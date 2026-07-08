/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.valkyrienskies.core.impl.shadow.oS;
import org.valkyrienskies.core.impl.shadow.uE;
import org.valkyrienskies.core.impl.shadow.uM;
import org.valkyrienskies.core.impl.shadow.uQ;
import org.valkyrienskies.core.impl.shadow.vd_0;

public final class uF {
    final uM a;
    public final uE b;
    public double c;
    final double[] d;
    private final double[] f;
    List<a> e;

    public uF(uM uM2) {
        int n2 = uM2.a();
        this.a = uM2;
        this.b = new uE(0, n2);
        this.c = Double.NaN;
        this.d = new double[n2];
        this.f = new double[n2];
        this.e = new ArrayList<a>();
    }

    public final uM a() {
        return this.a;
    }

    public final int b() {
        if (this.e.isEmpty()) {
            uE uE2 = this.b;
            return uE2.b;
        }
        Object object = this.e.get(this.e.size() - 1);
        uE uE3 = ((a)object).b;
        object = uE3;
        object = uE3;
        return uE3.a + ((uE)object).b;
    }

    public final void a(double d2, double[] dArray, double[] dArray2) {
        this.b.a(dArray, this.d);
        this.a.a(d2, this.d, this.f);
        Iterator<a> iterator2 = this.e.iterator();
        while (iterator2.hasNext()) {
            a a2;
            a a3 = a2 = iterator2.next();
            a3 = a2;
            a2.b.a(dArray, a3.c);
            a a4 = a2;
            a3 = a4;
            a a5 = a2;
            a3 = a5;
            a3 = a2;
            a4.a.a(d2, this.d, this.f, a5.c, a3.d);
            a a6 = a2;
            a3 = a6;
            a3 = a2;
            a6.b.b(a3.d, dArray2);
        }
        this.b.b(this.f, dArray2);
    }

    public final int a(uQ.a a2) {
        int n2;
        if (this.e.isEmpty()) {
            this.e = new ArrayList<a>();
            n2 = this.a.a();
        } else {
            a a3 = this.e.get(this.e.size() - 1);
            Object object = a3;
            uE uE2 = a3.b;
            object = uE2;
            object = a3;
            object = ((a)object).b;
            n2 = uE2.a + ((uE)object).b;
        }
        this.e.add(new a(a2, n2));
        return this.e.size() - 1;
    }

    public final uE c() {
        return this.b;
    }

    public final uE[] d() {
        uE[] uEArray = new uE[this.e.size()];
        for (int i2 = 0; i2 < uEArray.length; ++i2) {
            a a2 = this.e.get(i2);
            uEArray[i2] = a2.b;
        }
        return uEArray;
    }

    public final void a(double d2) {
        this.c = d2;
    }

    public final double e() {
        return this.c;
    }

    public final void a(double[] dArray) {
        if (dArray.length != this.d.length) {
            throw new oS(dArray.length, this.d.length);
        }
        System.arraycopy(dArray, 0, this.d, 0, dArray.length);
    }

    public final double[] f() {
        return (double[])this.d.clone();
    }

    private double[] h() {
        return (double[])this.f.clone();
    }

    public final void a(int n2, double[] dArray) {
        Object object = this.e.get(n2);
        object = ((a)object).c;
        if (dArray.length != ((Object)object).length) {
            throw new oS(dArray.length, ((Object)object).length);
        }
        System.arraycopy(dArray, 0, object, 0, dArray.length);
    }

    public final double[] a(int n2) {
        a a2 = this.e.get(n2);
        return (double[])a2.c.clone();
    }

    private double[] b(int n2) {
        a a2 = this.e.get(n2);
        return (double[])a2.d.clone();
    }

    public final void b(double[] dArray) {
        if (dArray.length != this.b()) {
            throw new oS(dArray.length, this.b());
        }
        this.b.a(dArray, this.d);
        Iterator<a> iterator2 = this.e.iterator();
        while (iterator2.hasNext()) {
            a a2;
            a a3 = a2 = iterator2.next();
            a3 = a2;
            a2.b.a(dArray, a3.c);
        }
    }

    public final double[] g() {
        double[] dArray = new double[this.b()];
        this.b.b(this.d, dArray);
        Iterator<a> iterator2 = this.e.iterator();
        while (iterator2.hasNext()) {
            a a2;
            a a3 = a2 = iterator2.next();
            a3 = a2;
            a2.b.b(a3.c, dArray);
        }
        return dArray;
    }

    static final class a {
        final vd_0 a;
        final uE b;
        final double[] c;
        final double[] d;

        a(vd_0 vd_02, int n2) {
            int n3 = vd_02.a();
            this.a = vd_02;
            this.b = new uE(n2, n3);
            this.c = new double[n3];
            this.d = new double[n3];
        }

        static /* synthetic */ uE a(a a2) {
            return a2.b;
        }

        static /* synthetic */ double[] b(a a2) {
            return a2.c;
        }

        static /* synthetic */ double[] c(a a2) {
            return a2.d;
        }

        static /* synthetic */ vd_0 d(a a2) {
            return a2.a;
        }
    }
}

