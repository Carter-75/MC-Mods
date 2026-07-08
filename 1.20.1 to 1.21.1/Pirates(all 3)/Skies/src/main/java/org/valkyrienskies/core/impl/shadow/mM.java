/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.ch_0;
import org.valkyrienskies.core.impl.shadow.oS;
import org.valkyrienskies.core.impl.shadow.pc_0;
import org.valkyrienskies.core.impl.shadow.pj_0;
import org.valkyrienskies.core.impl.shadow.pk_0;
import org.valkyrienskies.core.impl.shadow.po_0;
import org.valkyrienskies.core.impl.shadow.zN;

public class mM {
    final List<a> a;
    final List<b> b;
    final int c;
    final int d;
    final double e;
    final double f;
    final double g;

    protected mM(int n2, int n3, double d2, double d3, double d4) {
        if (n2 <= 0) {
            throw new pk_0(n2);
        }
        if (n3 <= 0) {
            throw new pk_0(n3);
        }
        if (d2 < 0.0 || d2 > 1.0) {
            throw new po_0(d2, (Number)0, 1);
        }
        if (d3 < 0.0) {
            throw new pj_0(d3);
        }
        this.c = n2;
        this.d = n3;
        this.e = d2;
        this.f = d3;
        this.g = d4;
        this.a = new ArrayList<a>(n3);
        this.b = new ArrayList<b>(n3);
    }

    public mM(int n2, int n3, double d2, double d3, double d4, zN zN2) {
        this(n2, n3, d2, d3, d4);
        for (n2 = 0; n2 < n3; ++n2) {
            this.a(zN2.a(), false);
        }
    }

    protected mM(mM object) {
        this.c = ((mM)object).c;
        this.d = ((mM)object).d;
        this.e = ((mM)object).e;
        this.f = ((mM)object).f;
        this.g = ((mM)object).g;
        this.a = ((mM)object).a;
        this.b = new ArrayList<b>(this.d);
        object = ((mM)object).b.iterator();
        while (object.hasNext()) {
            b b2;
            b b3 = b2 = (b)object.next();
            b b4 = b3;
            b4 = b2;
            this.b.add(new b(b3.a, b4.b));
        }
    }

    public mM a() {
        return new mM(this);
    }

    public final int b() {
        return this.c;
    }

    private int c() {
        return this.d;
    }

    public final double a(double[] dArray, double[][] dArray2, double[] dArray3, double d2, double d3) {
        double d4;
        double d5;
        Object object;
        Object object2;
        double d6;
        double d7;
        int n2;
        if (d2 < 0.0) {
            throw new pj_0(d2);
        }
        Object object3 = this;
        for (n2 = 0; n2 < ((mM)object3).d; ++n2) {
            ((mM)object3).b.set(n2, new b(0.0, 0.0));
        }
        int n3 = dArray2.length;
        for (int i2 = 0; i2 < n3; ++i2) {
            double d8;
            double d9;
            double[] dArray4 = ch_0.a(dArray2[i2], dArray);
            object3 = dArray4;
            double d10 = ch_0.d(dArray4);
            if (BY.w(d9) < d3) {
                return dArray3[i2];
            }
            d7 = d8 = BY.a(d10, -d2);
            d6 = dArray3[i2];
            Object object4 = object3;
            object3 = this;
            for (int i3 = 0; i3 < ((mM)object3).d; ++i3) {
                b b2;
                double d11;
                double d12;
                object2 = ((mM)object3).a.get(i3);
                object = ((a)object2).a;
                Object object5 = object4;
                object2 = ((a)object2).a;
                d5 = ch_0.h(((a)object2).a, (double[])object5) / (ch_0.d((double[])object2) * ch_0.d((double[])object5));
                if (!(d12 > 0.0)) continue;
                double d13 = d5 * d7;
                if (!(d11 > ((mM)object3).f)) continue;
                object2 = ((mM)object3).b.get(i3);
                if (!(d13 > b2.a)) continue;
                ((mM)object3).b.set(i3, new b(d13, d6));
            }
        }
        object3 = this;
        n2 = 0;
        d6 = 0.0;
        d7 = 0.0;
        Iterator<b> iterator2 = ((mM)object3).b.iterator();
        while (iterator2.hasNext()) {
            object2 = object = iterator2.next();
            d5 = ((b)object).a;
            if (d5 != 0.0) {
                object2 = object;
                d6 += d5 * ((b)object2).b;
                d7 += d5;
                continue;
            }
            ++n2;
        }
        double d14 = (double)n2 / (double)((mM)object3).d;
        if (d4 <= ((mM)object3).e) {
            return d6 / d7;
        }
        return ((mM)object3).g;
    }

    protected final void a(double[] dArray, boolean bl) {
        if (this.a.size() >= this.d) {
            throw new pc_0(this.d);
        }
        if (dArray.length > this.c) {
            throw new oS(dArray.length, this.c);
        }
        this.a.add(new a(dArray));
        this.b.add(new b(0.0, 0.0));
    }

    private double d() {
        double d2;
        int n2 = 0;
        double d3 = 0.0;
        double d4 = 0.0;
        Iterator<b> iterator2 = this.b.iterator();
        while (iterator2.hasNext()) {
            b b2;
            b b3 = b2 = iterator2.next();
            double d5 = b2.a;
            if (d5 != 0.0) {
                b3 = b2;
                d3 += d5 * b3.b;
                d4 += d5;
                continue;
            }
            ++n2;
        }
        double d6 = (double)n2 / (double)this.d;
        if (d2 <= this.e) {
            return d3 / d4;
        }
        return this.g;
    }

    private void a(double[] dArray, double d2, double d3) {
        for (int i2 = 0; i2 < this.d; ++i2) {
            b b2;
            double d4;
            double d5;
            a a2 = this.a.get(i2);
            Object object = a2;
            object = a2.a;
            double d6 = ch_0.e(a2.a, dArray);
            if (!(d5 > 0.0)) continue;
            double d7 = d6 * d3;
            if (!(d4 > this.f)) continue;
            object = this.b.get(i2);
            if (!(d7 > b2.a)) continue;
            this.b.set(i2, new b(d7, d2));
        }
    }

    private void e() {
        for (int i2 = 0; i2 < this.d; ++i2) {
            this.b.set(i2, new b(0.0, 0.0));
        }
    }

    static final class b {
        final double a;
        final double b;

        b(double d2, double d3) {
            this.a = d2;
            this.b = d3;
        }

        public final double a() {
            return this.a;
        }

        public final double b() {
            return this.b;
        }
    }

    static final class a {
        final double[] a;

        a(double[] dArray) {
            this.a = dArray;
        }

        public final double[] a() {
            return this.a;
        }
    }
}

