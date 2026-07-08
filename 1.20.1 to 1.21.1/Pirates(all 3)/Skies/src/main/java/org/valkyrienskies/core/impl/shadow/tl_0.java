/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.valkyrienskies.core.impl.shadow.Cm
 *  org.valkyrienskies.core.impl.shadow.tl
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import java.util.Iterator;
import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.Cm;
import org.valkyrienskies.core.impl.shadow.cm_0;
import org.valkyrienskies.core.impl.shadow.oU;
import org.valkyrienskies.core.impl.shadow.pj_0;
import org.valkyrienskies.core.impl.shadow.px_0;
import org.valkyrienskies.core.impl.shadow.tG;
import org.valkyrienskies.core.impl.shadow.tl;
import org.valkyrienskies.core.impl.shadow.tu_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.tl
 */
public final class tl_0
extends tG
implements Serializable {
    private static double a = 1.0E-12;
    private static final long b = 8772222695580707260L;
    private final cm_0 c;
    private final int d;
    private final double e;

    public tl_0() {
        this(0, 1.0E-12);
    }

    private tl_0(int n2) {
        this(n2, 1.0E-12);
    }

    private tl_0(int n2, double d2) {
        this.d = n2;
        this.c = new Cm(0.0);
        this.e = 1.0E-12;
    }

    private tl_0(tl_0 tl_02, int n2) {
        tl_0 tl_03 = tl_02;
        this.d = tl_03.d + n2;
        this.c = new Cm(tl_02.c);
        this.e = tl_02.e;
    }

    private tl_0(int n2, int n3) {
        this(n2, n3, 1.0E-12);
    }

    private tl_0(int n2, int n3, double d2) {
        this.d = n2;
        this.c = new Cm(n3, 0.0);
        this.e = 1.0E-12;
    }

    private tl_0(double[] dArray) {
        this(dArray, 1.0E-12);
    }

    private tl_0(double[] dArray, double d2) {
        this.d = dArray.length;
        this.c = new Cm(0.0);
        this.e = 1.0E-12;
        for (int i2 = 0; i2 < dArray.length; ++i2) {
            double d3 = dArray[i2];
            if (this.k(d3)) continue;
            this.c.a(i2, d3);
        }
    }

    private tl_0(Double[] doubleArray) {
        this(doubleArray, 1.0E-12);
    }

    private tl_0(Double[] doubleArray, double d2) {
        this.d = doubleArray.length;
        this.c = new Cm(0.0);
        this.e = 1.0E-12;
        for (int i2 = 0; i2 < doubleArray.length; ++i2) {
            double d3 = doubleArray[i2];
            if (this.k(d3)) continue;
            this.c.a(i2, d3);
        }
    }

    private tl_0(tl_0 tl_02) {
        tl_0 tl_03 = tl_02;
        this.d = tl_03.d;
        tl_03 = tl_02;
        this.c = new Cm(tl_03.c);
        this.e = tl_02.e;
    }

    private tl_0(tu_0 tu_02) {
        this.d = tu_02.f();
        this.c = new Cm(0.0);
        this.e = 1.0E-12;
        for (int i2 = 0; i2 < this.d; ++i2) {
            double d2 = tu_02.a(i2);
            if (this.k(d2)) continue;
            this.c.a(i2, d2);
        }
    }

    private cm_0 m() {
        return this.c;
    }

    private boolean k(double d2) {
        return BY.w(d2) < this.e;
    }

    @Override
    public final tu_0 l(tu_0 object) {
        this.b(object.f());
        if (object instanceof tl_0) {
            tl_0 tl_02 = (tl_0)object;
            object = this;
            Serializable serializable = tl_02;
            ((tu_0)object).b(serializable.d);
            cm_0 cm_02 = ((tl_0)object).c;
            serializable = cm_02;
            serializable = tl_02.c;
            boolean bl = ((Cm)cm_02).a > ((Cm)serializable).a;
            tl_0 tl_03 = bl ? ((tl_0)object).n() : tl_02.n();
            cm_0.a a2 = bl ? tl_02.c.a() : ((tl_0)object).c.a();
            Object object2 = object = bl ? ((tl_0)object).c : tl_02.c;
            while (a2.a()) {
                a2.d();
                int n2 = a2.b();
                if (object.b(n2)) {
                    tl_03.a(n2, object.a(n2) + a2.c());
                    continue;
                }
                tl_03.a(n2, a2.c());
            }
            return tl_03;
        }
        return super.l((tu_0)object);
    }

    private tl_0 b(tl_0 serializable) {
        Serializable serializable2 = serializable;
        this.b(serializable2.d);
        cm_0 cm_02 = this.c;
        serializable2 = cm_02;
        serializable2 = serializable.c;
        int n2 = ((Cm)cm_02).a > ((Cm)serializable2).a ? 1 : 0;
        tl_0 tl_02 = n2 != 0 ? this.n() : serializable.n();
        cm_0.a a2 = n2 != 0 ? serializable.c.a() : this.c.a();
        Serializable serializable3 = serializable = n2 != 0 ? this.c : serializable.c;
        while (a2.a()) {
            a2.d();
            n2 = a2.b();
            if (serializable.b(n2)) {
                tl_02.a(n2, serializable.a(n2) + a2.c());
                continue;
            }
            tl_02.a(n2, a2.c());
        }
        return tl_02;
    }

    private tl_0 c(tl_0 object) {
        tl_0 tl_02 = object;
        tl_02 = new tl_0(this, tl_02.d);
        object = ((tl_0)object).c.a();
        while (((cm_0.a)object).a()) {
            ((cm_0.a)object).d();
            tl_02.a(((cm_0.a)object).b() + this.d, ((cm_0.a)object).c());
        }
        return tl_02;
    }

    private tl_0 a(tu_0 tu_02) {
        if (tu_02 instanceof tl_0) {
            return this.c((tl_0)tu_02);
        }
        tl_0 tl_02 = new tl_0(this, tu_02.f());
        for (int i2 = 0; i2 < tu_02.f(); ++i2) {
            tl_02.a(i2 + this.d, tu_02.a(i2));
        }
        return tl_02;
    }

    private tl_0 l(double d2) {
        tl_0 tl_02 = new tl_0(this, 1);
        tl_02.a(this.d, d2);
        return tl_02;
    }

    private tl_0 n() {
        return new tl_0(this);
    }

    @Deprecated
    private double d(tl_0 tl_02) {
        return this.b(tl_02);
    }

    private tl_0 o(tu_0 tu_02) {
        this.b(tu_02.f());
        tl_0 tl_02 = new tl_0(this);
        tl_0 tl_03 = this;
        int n2 = tl_03.d;
        for (int i2 = 0; i2 < n2; ++i2) {
            tl_02.a(i2, this.a(i2) / tu_02.a(i2));
        }
        return tl_02;
    }

    private tl_0 p(tu_0 tu_02) {
        this.b(tu_02.f());
        tl_0 tl_02 = new tl_0(this);
        cm_0.a a2 = this.c.a();
        while (a2.a()) {
            a2.d();
            tl_02.a(a2.b(), a2.c() * tu_02.a(a2.b()));
        }
        return tl_02;
    }

    private tl_0 c(int n2, int n3) {
        this.c(n2);
        if (n3 < 0) {
            throw new pj_0(px_0.NUMBER_OF_ELEMENTS_SHOULD_BE_POSITIVE, n3);
        }
        this.c(n2 + n3 - 1);
        tl_0 tl_02 = new tl_0(n3);
        n3 = n2 + n3;
        cm_0.a a2 = this.c.a();
        while (a2.a()) {
            a2.d();
            int n4 = a2.b();
            if (n4 < n2 || n4 >= n3) continue;
            tl_02.a(n4 - n2, a2.c());
        }
        return tl_02;
    }

    @Override
    public final int f() {
        return this.d;
    }

    private double e(tl_0 tl_02) {
        double d2;
        int n2;
        Object object = tl_02;
        this.b(((tl_0)object).d);
        object = this.c.a();
        double d3 = 0.0;
        while (((cm_0.a)object).a()) {
            ((cm_0.a)object).d();
            n2 = ((cm_0.a)object).b();
            double d4 = d2 = ((cm_0.a)object).c() - tl_02.a(n2);
            d3 += d4 * d4;
        }
        object = tl_02;
        object = ((tl_0)object).c.a();
        while (((cm_0.a)object).a()) {
            ((cm_0.a)object).d();
            n2 = ((cm_0.a)object).b();
            if (this.c.b(n2)) continue;
            double d5 = d2 = ((cm_0.a)object).c();
            d3 += d5 * d5;
        }
        return BY.a(d3);
    }

    @Override
    public final double c(tu_0 tu_02) {
        this.b(tu_02.f());
        if (tu_02 instanceof tl_0) {
            return this.e((tl_0)tu_02);
        }
        return super.c(tu_02);
    }

    @Override
    public final double a(int n2) {
        this.c(n2);
        return this.c.a(n2);
    }

    private double f(tl_0 tl_02) {
        Object object = tl_02;
        this.b(((tl_0)object).d);
        double d2 = 0.0;
        object = this.c.a();
        while (((cm_0.a)object).a()) {
            ((cm_0.a)object).d();
            double d3 = BY.w(((cm_0.a)object).c() - tl_02.a(((cm_0.a)object).b()));
            d2 += d3;
        }
        object = tl_02;
        object = ((tl_0)object).c.a();
        while (((cm_0.a)object).a()) {
            ((cm_0.a)object).d();
            int n2 = ((cm_0.a)object).b();
            if (this.c.b(n2)) continue;
            double d4 = BY.w(((cm_0.a)object).c());
            d2 += BY.w(d4);
        }
        return d2;
    }

    @Override
    public final double d(tu_0 tu_02) {
        this.b(tu_02.f());
        if (tu_02 instanceof tl_0) {
            return this.f((tl_0)tu_02);
        }
        return super.d(tu_02);
    }

    private double g(tl_0 tl_02) {
        Object object = tl_02;
        this.b(((tl_0)object).d);
        double d2 = 0.0;
        object = this.c.a();
        while (((cm_0.a)object).a()) {
            double d3;
            ((cm_0.a)object).d();
            double d4 = BY.w(((cm_0.a)object).c() - tl_02.a(((cm_0.a)object).b()));
            if (!(d3 > d2)) continue;
            d2 = d4;
        }
        object = tl_02;
        object = ((tl_0)object).c.a();
        while (((cm_0.a)object).a()) {
            ((cm_0.a)object).d();
            int n2 = ((cm_0.a)object).b();
            if (this.c.b(n2) || !(((cm_0.a)object).c() > d2)) continue;
            d2 = ((cm_0.a)object).c();
        }
        return d2;
    }

    @Override
    public final double e(tu_0 tu_02) {
        this.b(tu_02.f());
        if (tu_02 instanceof tl_0) {
            return this.g((tl_0)tu_02);
        }
        return super.e(tu_02);
    }

    @Override
    public final boolean i() {
        boolean bl = false;
        cm_0.a a2 = this.c.a();
        while (a2.a()) {
            a2.d();
            double d2 = a2.c();
            if (Double.isNaN(d2)) {
                return false;
            }
            if (!Double.isInfinite(d2)) continue;
            bl = true;
        }
        return bl;
    }

    @Override
    public final boolean h() {
        cm_0.a a2 = this.c.a();
        while (a2.a()) {
            a2.d();
            if (!Double.isNaN(a2.c())) continue;
            return true;
        }
        return false;
    }

    private tl_0 m(double d2) {
        return this.n().n(d2);
    }

    private tl_0 n(double d2) {
        for (int i2 = 0; i2 < this.d; ++i2) {
            this.a(i2, this.a(i2) + d2);
        }
        return this;
    }

    @Override
    public final void a(int n2, double d2) {
        this.c(n2);
        if (!this.k(d2)) {
            this.c.a(n2, d2);
            return;
        }
        if (this.c.b(n2)) {
            this.c.c(n2);
        }
    }

    @Override
    public final void a(int n2, tu_0 tu_02) {
        this.c(0);
        this.c(0 + tu_02.f() - 1);
        for (n2 = 0; n2 < tu_02.f(); ++n2) {
            this.a(n2, tu_02.a(n2));
        }
    }

    @Override
    public final void f(double d2) {
        for (int i2 = 0; i2 < this.d; ++i2) {
            this.a(i2, 0.0);
        }
    }

    private tl_0 h(tl_0 object) {
        tl_0 tl_02 = object;
        this.b(tl_02.d);
        tl_0 tl_03 = this.n();
        tl_02 = object;
        object = tl_02.c.a();
        while (((cm_0.a)object).a()) {
            ((cm_0.a)object).d();
            int n2 = ((cm_0.a)object).b();
            if (this.c.b(n2)) {
                tl_03.a(n2, this.c.a(n2) - ((cm_0.a)object).c());
                continue;
            }
            tl_03.a(n2, -((cm_0.a)object).c());
        }
        return tl_03;
    }

    @Override
    public final tu_0 k(tu_0 tu_02) {
        this.b(tu_02.f());
        if (tu_02 instanceof tl_0) {
            return this.h((tl_0)tu_02);
        }
        return super.k(tu_02);
    }

    private tl_0 o() {
        double d2;
        tl_0 tl_02 = this.n();
        tl_0 tl_03 = tl_02;
        if (tl_03.k(d2 = tl_02.c())) {
            throw new oU(px_0.ZERO_NORM, new Object[0]);
        }
        cm_0.a a2 = tl_03.c.a();
        while (a2.a()) {
            a2.d();
            tl_03.c.a(a2.b(), a2.c() / d2);
        }
        return tl_02;
    }

    @Override
    public final void d_() {
        double d2 = this.c();
        if (this.k(d2)) {
            throw new oU(px_0.ZERO_NORM, new Object[0]);
        }
        cm_0.a a2 = this.c.a();
        while (a2.a()) {
            a2.d();
            this.c.a(a2.b(), a2.c() / d2);
        }
    }

    @Override
    public final double[] g() {
        double[] dArray = new double[this.d];
        cm_0.a a2 = this.c.a();
        while (a2.a()) {
            a2.d();
            dArray[a2.b()] = a2.c();
        }
        return dArray;
    }

    @Override
    public final int hashCode() {
        long l2;
        long l3 = l2 = Double.doubleToLongBits(this.e);
        int n2 = 31 + (int)(l3 ^ l3 >>> 32);
        n2 = n2 * 31 + this.d;
        cm_0.a a2 = this.c.a();
        while (a2.a()) {
            a2.d();
            long l4 = l2 = Double.doubleToLongBits(a2.c());
            n2 = n2 * 31 + (int)(l4 ^ l4 >> 32);
        }
        return n2;
    }

    @Override
    public final boolean equals(Object obj) {
        double d2;
        tl_0 tl_02;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof tl_0)) {
            return false;
        }
        tl_02 = tl_02;
        if (this.d != tl_02.d) {
            return false;
        }
        if (Double.doubleToLongBits(this.e) != Double.doubleToLongBits(tl_02.e)) {
            return false;
        }
        cm_0.a a2 = this.c.a();
        while (a2.a()) {
            a2.d();
            d2 = tl_02.a(a2.b());
            if (Double.doubleToLongBits(d2) == Double.doubleToLongBits(a2.c())) continue;
            return false;
        }
        a2 = tl_02.c.a();
        while (a2.a()) {
            a2.d();
            d2 = a2.c();
            if (Double.doubleToLongBits(d2) == Double.doubleToLongBits(this.a(a2.b()))) continue;
            return false;
        }
        return true;
    }

    private double p() {
        cm_0 cm_02 = this.c;
        Serializable serializable = cm_02;
        serializable = this;
        return (double)((Cm)cm_02).a / (double)((tl_0)serializable).d;
    }

    @Override
    public final Iterator<tu_0.a> e_() {
        return new b(this);
    }

    @Override
    public final /* synthetic */ tu_0 k() {
        double d2;
        tl_0 tl_02 = this;
        tl_0 tl_03 = tl_02 = tl_02.n();
        if (tl_03.k(d2 = tl_02.c())) {
            throw new oU(px_0.ZERO_NORM, new Object[0]);
        }
        cm_0.a a2 = tl_03.c.a();
        while (a2.a()) {
            a2.d();
            tl_03.c.a(a2.b(), a2.c() / d2);
        }
        return tl_02;
    }

    @Override
    public final /* synthetic */ tu_0 i(tu_0 tu_02) {
        return this.p(tu_02);
    }

    @Override
    public final /* synthetic */ tu_0 j(tu_0 tu_02) {
        return this.o(tu_02);
    }

    @Override
    public final /* synthetic */ tu_0 j() {
        return this.n();
    }

    @Override
    public final /* synthetic */ tu_0 a(double d2) {
        return this.n(d2);
    }

    @Override
    public final /* synthetic */ tu_0 g(double d2) {
        double d3 = d2;
        tl_0 tl_02 = this;
        return tl_02.n().n(d3);
    }

    @Override
    public final /* synthetic */ tu_0 a(int n2, int n3) {
        return this.c(n2, n3);
    }

    @Override
    public final /* synthetic */ tu_0 e(double d2) {
        return this.l(d2);
    }

    @Override
    public final /* synthetic */ tu_0 g(tu_0 tu_02) {
        return this.a(tu_02);
    }

    static /* synthetic */ cm_0 a(tl_0 tl_02) {
        return tl_02.c;
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    protected final class b
    implements Iterator<tu_0.a> {
        private final cm_0.a a;
        private final a b;
        private /* synthetic */ tl_0 c;

        protected b(tl_0 tl_02) {
            this.c = tl_02;
            this.a = tl.a((tl_0)tl_02).a();
            this.b = new a(tl_02, this.a);
        }

        @Override
        public final boolean hasNext() {
            return this.a.a();
        }

        private tu_0.a a() {
            this.a.d();
            return this.b;
        }

        @Override
        public final void remove() {
            throw new UnsupportedOperationException("Not supported");
        }

        @Override
        public final /* synthetic */ Object next() {
            return this.a();
        }
    }

    protected final class a
    extends tu_0.a {
        private final cm_0.a b;
        private /* synthetic */ tl_0 c;

        protected a(tl_0 tl_02, cm_0.a a2) {
            this.c = tl_02;
            super(tl_02);
            this.b = a2;
        }

        public final double a() {
            return this.b.c();
        }

        public final void a(double d2) {
            tl.a((tl_0)this.c).a(this.b.b(), d2);
        }

        public final int b() {
            return this.b.b();
        }
    }
}

