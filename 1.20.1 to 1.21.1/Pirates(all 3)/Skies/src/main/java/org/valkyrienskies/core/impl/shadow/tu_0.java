/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.valkyrienskies.core.impl.shadow.tu
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Iterator;
import java.util.NoSuchElementException;
import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.kV;
import org.valkyrienskies.core.impl.shadow.lH;
import org.valkyrienskies.core.impl.shadow.lX;
import org.valkyrienskies.core.impl.shadow.lc_0;
import org.valkyrienskies.core.impl.shadow.lw_0;
import org.valkyrienskies.core.impl.shadow.oS;
import org.valkyrienskies.core.impl.shadow.oU;
import org.valkyrienskies.core.impl.shadow.pb_0;
import org.valkyrienskies.core.impl.shadow.pn_0;
import org.valkyrienskies.core.impl.shadow.po_0;
import org.valkyrienskies.core.impl.shadow.pw_0;
import org.valkyrienskies.core.impl.shadow.px_0;
import org.valkyrienskies.core.impl.shadow.sv_0;
import org.valkyrienskies.core.impl.shadow.sy_0;
import org.valkyrienskies.core.impl.shadow.tG;
import org.valkyrienskies.core.impl.shadow.tk_0;
import org.valkyrienskies.core.impl.shadow.tq_0;
import org.valkyrienskies.core.impl.shadow.tu;
import org.valkyrienskies.core.impl.shadow.tv_0;
import org.valkyrienskies.core.impl.shadow.tx_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.tu
 */
public abstract class tu_0 {
    public abstract int f();

    public abstract double a(int var1);

    public abstract void a(int var1, double var2);

    public void b(int n2, double d2) {
        this.a(n2, this.a(n2) + d2);
    }

    public abstract tu_0 g(tu_0 var1);

    public abstract tu_0 e(double var1);

    public abstract tu_0 a(int var1, int var2);

    public abstract void a(int var1, tu_0 var2);

    public abstract boolean h();

    public abstract boolean i();

    protected void h(tu_0 tu_02) {
        this.b(tu_02.f());
    }

    protected void b(int n2) {
        int n3 = this.f();
        if (n3 != n2) {
            throw new oS(n3, n2);
        }
    }

    protected final void c(int n2) {
        if (n2 < 0 || n2 >= this.f()) {
            throw new po_0(px_0.INDEX, (Number)n2, 0, this.f() - 1);
        }
    }

    protected final void b(int n2, int n3) {
        int n4 = this.f();
        if (n2 < 0 || n2 >= n4) {
            throw new po_0(px_0.INDEX, (Number)n2, 0, n4 - 1);
        }
        if (n3 < 0 || n3 >= n4) {
            throw new po_0(px_0.INDEX, (Number)n3, 0, n4 - 1);
        }
        if (n3 < n2) {
            throw new pn_0((pw_0)px_0.INITIAL_ROW_AFTER_FINAL_ROW, (Number)n3, n2, false);
        }
    }

    public tu_0 l(tu_0 tu_02) {
        this.h(tu_02);
        tu_02 = tu_02.j();
        Iterator<a> iterator2 = this.l();
        while (iterator2.hasNext()) {
            a a2 = iterator2.next();
            int n2 = a2.b();
            tu_02.a(n2, a2.a() + tu_02.a(n2));
        }
        return tu_02;
    }

    public tu_0 k(tu_0 tu_02) {
        this.h(tu_02);
        tu_02 = tu_02.h(-1.0);
        Iterator<a> iterator2 = this.l();
        while (iterator2.hasNext()) {
            a a2 = iterator2.next();
            int n2 = a2.b();
            tu_02.a(n2, a2.a() + tu_02.a(n2));
        }
        return tu_02;
    }

    public tu_0 g(double d2) {
        return this.j().a(d2);
    }

    public tu_0 a(double d2) {
        if (d2 != 0.0) {
            return this.b(kV.a(new lw_0(), d2));
        }
        return this;
    }

    public abstract tu_0 j();

    public double b(tu_0 tu_02) {
        this.h(tu_02);
        double d2 = 0.0;
        int n2 = this.f();
        for (int i2 = 0; i2 < n2; ++i2) {
            d2 += this.a(i2) * tu_02.a(i2);
        }
        return d2;
    }

    public double m(tu_0 tu_02) {
        double d2 = this.c();
        double d3 = tu_02.c();
        if (d2 == 0.0 || d3 == 0.0) {
            throw new oU(px_0.ZERO_NORM, new Object[0]);
        }
        return this.b(tu_02) / (d2 * d3);
    }

    public abstract tu_0 j(tu_0 var1);

    public abstract tu_0 i(tu_0 var1);

    public double c(tu_0 tu_02) {
        this.h(tu_02);
        double d2 = 0.0;
        Iterator<a> iterator2 = this.l();
        while (iterator2.hasNext()) {
            double d3;
            a a2 = iterator2.next();
            double d4 = d3 = a2.a() - tu_02.a(a2.b());
            d2 += d4 * d4;
        }
        return BY.a(d2);
    }

    public double c() {
        double d2 = 0.0;
        Iterator<a> iterator2 = this.l();
        while (iterator2.hasNext()) {
            double d3;
            a a2 = iterator2.next();
            double d4 = d3 = a2.a();
            d2 += d4 * d4;
        }
        return BY.a(d2);
    }

    public double d() {
        double d2 = 0.0;
        Iterator<a> iterator2 = this.l();
        while (iterator2.hasNext()) {
            a a2 = iterator2.next();
            d2 += BY.w(a2.a());
        }
        return d2;
    }

    public double e() {
        double d2 = 0.0;
        Iterator<a> iterator2 = this.l();
        while (iterator2.hasNext()) {
            a a2 = iterator2.next();
            d2 = BY.e(d2, BY.w(a2.a()));
        }
        return d2;
    }

    public double d(tu_0 tu_02) {
        this.h(tu_02);
        double d2 = 0.0;
        Iterator<a> iterator2 = this.l();
        while (iterator2.hasNext()) {
            a a2 = iterator2.next();
            d2 += BY.w(a2.a() - tu_02.a(a2.b()));
        }
        return d2;
    }

    public double e(tu_0 tu_02) {
        this.h(tu_02);
        double d2 = 0.0;
        Iterator<a> iterator2 = this.l();
        while (iterator2.hasNext()) {
            a a2 = iterator2.next();
            d2 = BY.e(BY.w(a2.a() - tu_02.a(a2.b())), d2);
        }
        return d2;
    }

    private int m() {
        int n2 = -1;
        double d2 = Double.POSITIVE_INFINITY;
        Iterator<a> iterator2 = this.l();
        while (iterator2.hasNext()) {
            a a2;
            a a3 = iterator2.next();
            if (!(a2.a() <= d2)) continue;
            n2 = a3.b();
            d2 = a3.a();
        }
        return n2;
    }

    private double n() {
        Object object = this;
        int n2 = -1;
        double d2 = Double.POSITIVE_INFINITY;
        object = ((tu_0)object).l();
        while (object.hasNext()) {
            a a2;
            a a3 = (a)object.next();
            if (!(a2.a() <= d2)) continue;
            n2 = a3.b();
            d2 = a3.a();
        }
        int n3 = n2;
        if (n3 < 0) {
            return Double.NaN;
        }
        return this.a(n3);
    }

    private int o() {
        int n2 = -1;
        double d2 = Double.NEGATIVE_INFINITY;
        Iterator<a> iterator2 = this.l();
        while (iterator2.hasNext()) {
            a a2;
            a a3 = iterator2.next();
            if (!(a2.a() >= d2)) continue;
            n2 = a3.b();
            d2 = a3.a();
        }
        return n2;
    }

    private double p() {
        Object object = this;
        int n2 = -1;
        double d2 = Double.NEGATIVE_INFINITY;
        object = ((tu_0)object).l();
        while (object.hasNext()) {
            a a2;
            a a3 = (a)object.next();
            if (!(a2.a() >= d2)) continue;
            n2 = a3.b();
            d2 = a3.a();
        }
        int n3 = n2;
        if (n3 < 0) {
            return Double.NaN;
        }
        return this.a(n3);
    }

    public tu_0 h(double d2) {
        return this.j().c(d2);
    }

    public tu_0 c(double d2) {
        return this.b(kV.a(new lX(), d2));
    }

    public tu_0 i(double d2) {
        return this.j().b(d2);
    }

    public tu_0 b(double d2) {
        return this.a(-d2);
    }

    public tu_0 j(double d2) {
        return this.j().d(d2);
    }

    public tu_0 d(double d2) {
        return this.b(kV.a(new lH(), d2));
    }

    public tq_0 f(tu_0 tu_02) {
        int n2 = this.f();
        int n3 = tu_02.f();
        sv_0 sv_02 = tu_02 instanceof tG || this instanceof tG ? new tk_0(n2, n3) : new sy_0(n2, n3);
        for (int i2 = 0; i2 < n2; ++i2) {
            for (int i3 = 0; i3 < n3; ++i3) {
                sv_02.c(i2, i3, this.a(i2) * tu_02.a(i3));
            }
        }
        return sv_02;
    }

    private tu_0 a(tu_0 tu_02) {
        tu_0 tu_03 = tu_02;
        double d2 = tu_03.b(tu_03);
        if (d2 == 0.0) {
            throw new oU(px_0.ZERO_NORM, new Object[0]);
        }
        tu_0 tu_04 = tu_02;
        return tu_02.h(this.b(tu_02) / tu_04.b(tu_04));
    }

    public void f(double d2) {
        Iterator<a> iterator2 = this.l();
        while (iterator2.hasNext()) {
            a a2 = iterator2.next();
            a2.a(0.0);
        }
    }

    public double[] g() {
        int n2 = this.f();
        double[] dArray = new double[n2];
        for (int i2 = 0; i2 < n2; ++i2) {
            dArray[i2] = this.a(i2);
        }
        return dArray;
    }

    public tu_0 k() {
        double d2 = this.c();
        if (d2 == 0.0) {
            throw new oU(px_0.ZERO_NORM, new Object[0]);
        }
        return this.j(d2);
    }

    public void d_() {
        double d2 = this.c();
        if (d2 == 0.0) {
            throw new oU(px_0.ZERO_NORM, new Object[0]);
        }
        tu_0 tu_02 = this;
        tu_02.d(tu_02.c());
    }

    public Iterator<a> e_() {
        return new b(this);
    }

    public Iterator<a> l() {
        int n2 = this.f();
        return new Iterator<a>(this, n2){
            private int a = 0;
            private a b = new a(this.d);
            private /* synthetic */ int c;
            private /* synthetic */ tu_0 d;
            {
                this.d = tu_02;
                this.c = n2;
            }

            @Override
            public final boolean hasNext() {
                return this.a < this.c;
            }

            private a a() {
                if (this.a < this.c) {
                    int n2 = this.a++;
                    a a2 = this.b;
                    this.b.a = n2;
                    return this.b;
                }
                throw new NoSuchElementException();
            }

            @Override
            public final void remove() {
                throw new pb_0();
            }

            @Override
            public final /* synthetic */ Object next() {
                1 var1_1 = this;
                if (var1_1.a < var1_1.c) {
                    int n2 = var1_1.a++;
                    a a2 = var1_1.b;
                    var1_1.b.a = n2;
                    return var1_1.b;
                }
                throw new NoSuchElementException();
            }
        };
    }

    public tu_0 c(lc_0 lc_02) {
        return this.j().b(lc_02);
    }

    public tu_0 b(lc_0 lc_02) {
        Iterator<a> iterator2 = this.l();
        while (iterator2.hasNext()) {
            a a2 = iterator2.next();
            a2.a(lc_02.a(a2.a()));
        }
        return this;
    }

    public tu_0 b(double d2, double d3, tu_0 tu_02) {
        return this.j().a(d2, d3, tu_02);
    }

    public tu_0 a(double d2, double d3, tu_0 tu_02) {
        this.h(tu_02);
        for (int i2 = 0; i2 < this.f(); ++i2) {
            double d4 = this.a(i2);
            double d5 = tu_02.a(i2);
            this.a(i2, d2 * d4 + d3 * d5);
        }
        return this;
    }

    public double a(tx_0 tx_02) {
        int n2 = this.f();
        for (int i2 = 0; i2 < n2; ++i2) {
            this.a(i2);
        }
        return tx_02.c();
    }

    public double a(tx_0 tx_02, int n2, int n3) {
        this.b(n2, n3);
        this.f();
        while (n2 <= n3) {
            this.a(n2);
            ++n2;
        }
        return tx_02.c();
    }

    public double b(tx_0 tx_02) {
        return this.a(tx_02);
    }

    public double b(tx_0 tx_02, int n2, int n3) {
        return this.a(tx_02, n2, n3);
    }

    public double a(tv_0 tv_02) {
        int n2 = this.f();
        for (int i2 = 0; i2 < n2; ++i2) {
            this.a(i2);
            this.a(i2, tv_02.b());
        }
        return tv_02.c();
    }

    public double a(tv_0 tv_02, int n2, int n3) {
        this.b(n2, n3);
        this.f();
        while (n2 <= n3) {
            this.a(n2);
            this.a(n2, tv_02.b());
            ++n2;
        }
        return tv_02.c();
    }

    public double b(tv_0 tv_02) {
        return this.a(tv_02);
    }

    public double b(tv_0 tv_02, int n2, int n3) {
        return this.a(tv_02, n2, n3);
    }

    public boolean equals(Object other) {
        throw new pb_0();
    }

    public int hashCode() {
        throw new pb_0();
    }

    public static 2 n(final tu_0 tu_02) {
        return new tu(){

            public final tu_0 b(lc_0 lc_02) {
                throw new pb_0();
            }

            public final tu_0 c(lc_0 lc_02) {
                return tu_02.c(lc_02);
            }

            public final Iterator<a> l() {
                Iterator iterator2 = tu_02.l();
                return new Iterator<a>(this, iterator2){
                    private final a a;
                    private /* synthetic */ Iterator b;
                    private /* synthetic */ 2 c;
                    {
                        this.c = var1_1;
                        this.b = iterator2;
                        this.a = new a(this.c);
                    }

                    @Override
                    public final boolean hasNext() {
                        return this.b.hasNext();
                    }

                    private a a() {
                        int n2 = ((a)this.b.next()).b();
                        a a2 = this.a;
                        this.a.a = n2;
                        return this.a;
                    }

                    @Override
                    public final void remove() {
                        throw new pb_0();
                    }

                    @Override
                    public final /* synthetic */ Object next() {
                        1 var1_1 = this;
                        int n2 = ((a)var1_1.b.next()).b();
                        a a2 = var1_1.a;
                        var1_1.a.a = n2;
                        return var1_1.a;
                    }
                };
            }

            public final Iterator<a> e_() {
                Iterator iterator2 = tu_02.e_();
                return new Iterator<a>(this, iterator2){
                    private final a a;
                    private /* synthetic */ Iterator b;
                    private /* synthetic */ 2 c;
                    {
                        this.c = var1_1;
                        this.b = iterator2;
                        this.a = new a(this.c);
                    }

                    @Override
                    public final boolean hasNext() {
                        return this.b.hasNext();
                    }

                    private a a() {
                        int n2 = ((a)this.b.next()).b();
                        a a2 = this.a;
                        this.a.a = n2;
                        return this.a;
                    }

                    @Override
                    public final void remove() {
                        throw new pb_0();
                    }

                    @Override
                    public final /* synthetic */ Object next() {
                        2 var1_1 = this;
                        int n2 = ((a)var1_1.b.next()).b();
                        a a2 = var1_1.a;
                        var1_1.a.a = n2;
                        return var1_1.a;
                    }
                };
            }

            public final tu_0 j() {
                return tu_02.j();
            }

            public final tu_0 l(tu_0 tu_022) {
                return tu_02.l(tu_022);
            }

            public final tu_0 k(tu_0 tu_022) {
                return tu_02.k(tu_022);
            }

            public final tu_0 g(double d2) {
                return tu_02.g(d2);
            }

            public final tu_0 a(double d2) {
                throw new pb_0();
            }

            public final tu_0 i(double d2) {
                return tu_02.i(d2);
            }

            public final tu_0 b(double d2) {
                throw new pb_0();
            }

            public final tu_0 h(double d2) {
                return tu_02.h(d2);
            }

            public final tu_0 c(double d2) {
                throw new pb_0();
            }

            public final tu_0 j(double d2) {
                return tu_02.j(d2);
            }

            public final tu_0 d(double d2) {
                throw new pb_0();
            }

            public final tu_0 i(tu_0 tu_022) {
                return tu_02.i(tu_022);
            }

            public final tu_0 j(tu_0 tu_022) {
                return tu_02.j(tu_022);
            }

            public final double b(tu_0 tu_022) {
                return tu_02.b(tu_022);
            }

            public final double m(tu_0 tu_022) {
                return tu_02.m(tu_022);
            }

            public final double c() {
                return tu_02.c();
            }

            public final double d() {
                return tu_02.d();
            }

            public final double e() {
                return tu_02.e();
            }

            public final double c(tu_0 tu_022) {
                return tu_02.c(tu_022);
            }

            public final double d(tu_0 tu_022) {
                return tu_02.d(tu_022);
            }

            public final double e(tu_0 tu_022) {
                return tu_02.e(tu_022);
            }

            public final tu_0 k() {
                return tu_02.k();
            }

            public final void d_() {
                throw new pb_0();
            }

            public final tq_0 f(tu_0 tu_022) {
                return tu_02.f(tu_022);
            }

            public final double a(int n2) {
                return tu_02.a(n2);
            }

            public final void a(int n2, double d2) {
                throw new pb_0();
            }

            public final void b(int n2, double d2) {
                throw new pb_0();
            }

            public final int f() {
                return tu_02.f();
            }

            public final tu_0 g(tu_0 tu_022) {
                return tu_02.g(tu_022);
            }

            public final tu_0 e(double d2) {
                return tu_02.e(d2);
            }

            public final tu_0 a(int n2, int n3) {
                return tu_02.a(n2, n3);
            }

            public final void a(int n2, tu_0 tu_022) {
                throw new pb_0();
            }

            public final void f(double d2) {
                throw new pb_0();
            }

            public final double[] g() {
                return tu_02.g();
            }

            public final boolean h() {
                return tu_02.h();
            }

            public final boolean i() {
                return tu_02.i();
            }

            public final tu_0 b(double d2, double d3, tu_0 tu_022) {
                return tu_02.b(d2, d3, tu_022);
            }

            public final tu_0 a(double d2, double d3, tu_0 tu_022) {
                throw new pb_0();
            }

            final class a
            extends a {
                private /* synthetic */ 2 b;

                a(2 var1_1) {
                    this.b = var1_1;
                    super((tu_0)((Object)var1_1));
                }

                public final double a() {
                    return this.b.tu_02.a(this.b());
                }

                public final void a(double d2) {
                    throw new pb_0();
                }
            }
        };
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    protected final class b
    implements Iterator<a> {
        private final int a;
        private a b;
        private a c;
        private /* synthetic */ tu_0 d;

        protected b(tu_0 tu_02) {
            this.d = tu_02;
            this.a = tu_02.f();
            this.b = new a(tu_02);
            this.c = new a(tu_02);
            if (this.c.a() == 0.0) {
                b b2 = this;
                b2.a(b2.c);
            }
        }

        private void a(a a2) {
            int n2;
            if (a2 == null) {
                return;
            }
            do {
                a3.a = n2 = a2.b() + 1;
            } while (a2.b() < this.a && a2.a() == 0.0);
            if (a2.b() >= this.a) {
                n2 = -1;
                a a3 = a2;
                a2.a = n2;
            }
        }

        @Override
        public final boolean hasNext() {
            return this.c.b() >= 0;
        }

        private a a() {
            int n2 = this.c.b();
            if (n2 < 0) {
                throw new NoSuchElementException();
            }
            int n3 = n2;
            a a2 = this.b;
            this.b.a = n3;
            b b2 = this;
            b2.a(b2.c);
            return this.b;
        }

        @Override
        public final void remove() {
            throw new pb_0();
        }

        @Override
        public final /* synthetic */ Object next() {
            b b2 = this;
            int n2 = b2.c.b();
            if (n2 < 0) {
                throw new NoSuchElementException();
            }
            int n3 = n2;
            a a2 = b2.b;
            b2.b.a = n3;
            b b3 = b2;
            b3.a(b3.c);
            return b2.b;
        }
    }

    protected class a {
        int a;
        private /* synthetic */ tu_0 b;

        public a(tu_0 object) {
            this.b = object;
            int n2 = 0;
            object = this;
            this.a = n2;
        }

        public double a() {
            return this.b.a(this.b());
        }

        public void a(double d2) {
            this.b.a(this.b(), d2);
        }

        public int b() {
            return this.a;
        }

        public final void a(int n2) {
            this.a = n2;
        }
    }
}

