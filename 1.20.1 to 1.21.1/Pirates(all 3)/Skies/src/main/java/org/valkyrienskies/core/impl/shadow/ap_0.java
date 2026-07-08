/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import java.util.Collection;
import org.valkyrienskies.core.impl.shadow.an_0;
import org.valkyrienskies.core.impl.shadow.at_0;
import org.valkyrienskies.core.impl.shadow.au_0;
import org.valkyrienskies.core.impl.shadow.aw_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.Ap
 */
public final class ap_0
implements Serializable,
at_0 {
    private static final long a = -8207112444016386906L;
    private final aw_0 b;
    private final aw_0 c;

    public ap_0() {
        this(new aw_0());
    }

    private ap_0(aw_0 aw_02) {
        this(aw_02, new aw_0(aw_02));
    }

    private ap_0(aw_0 aw_02, aw_0 aw_03) {
        this.b = aw_02 == null ? new aw_0() : aw_02;
        this.c = aw_03 == null ? new aw_0() : aw_03;
    }

    @Override
    public final double a() {
        aw_0 aw_02 = this.c;
        synchronized (aw_02) {
            return this.c.a();
        }
    }

    @Override
    public final double b() {
        aw_0 aw_02 = this.c;
        synchronized (aw_02) {
            return this.c.b();
        }
    }

    @Override
    public final double c() {
        aw_0 aw_02 = this.c;
        synchronized (aw_02) {
            return this.c.c();
        }
    }

    @Override
    public final long d() {
        aw_0 aw_02 = this.c;
        synchronized (aw_02) {
            return this.c.d();
        }
    }

    @Override
    public final double e() {
        aw_0 aw_02 = this.c;
        synchronized (aw_02) {
            return this.c.e();
        }
    }

    @Override
    public final double f() {
        aw_0 aw_02 = this.c;
        synchronized (aw_02) {
            return this.c.f();
        }
    }

    @Override
    public final double g() {
        aw_0 aw_02 = this.c;
        synchronized (aw_02) {
            return this.c.g();
        }
    }

    private double h() {
        aw_0 aw_02 = this.c;
        synchronized (aw_02) {
            return this.c.m();
        }
    }

    private double i() {
        aw_0 aw_02 = this.c;
        synchronized (aw_02) {
            return this.c.l();
        }
    }

    private double j() {
        aw_0 aw_02 = this.c;
        synchronized (aw_02) {
            return this.c.i();
        }
    }

    private double k() {
        aw_0 aw_02 = this.c;
        synchronized (aw_02) {
            aw_0 aw_03 = this.c;
            return ((an_0)aw_03.a).c();
        }
    }

    private au_0 l() {
        aw_0 aw_02 = this.c;
        synchronized (aw_02) {
            return new au_0(this.b(), this.g(), this.d(), this.a(), this.c(), this.f());
        }
    }

    private a m() {
        a a2 = new a(this.c);
        aw_0.a(this.b, a2);
        return a2;
    }

    private static au_0 a(Collection<? extends at_0> object) {
        double d2;
        if (object == null) {
            return null;
        }
        if (!(object = object.iterator()).hasNext()) {
            return null;
        }
        at_0 at_02 = (at_0)object.next();
        long l2 = at_02.d();
        double d3 = at_02.c();
        double d4 = at_02.f();
        double d5 = at_02.a();
        double d6 = at_02.g();
        double d7 = d6 * ((double)l2 - 1.0);
        double d8 = at_02.b();
        while (object.hasNext()) {
            at_02 = (at_0)object.next();
            if (at_02.c() < d3 || Double.isNaN(d3)) {
                d3 = at_02.c();
            }
            if (at_02.a() > d5 || Double.isNaN(d5)) {
                d5 = at_02.a();
            }
            d2 = l2;
            double d9 = at_02.d();
            l2 = (long)((double)l2 + d9);
            double d10 = at_02.b() - d8;
            d8 = (d4 += at_02.f()) / (double)l2;
            double d11 = at_02.g() * (d9 - 1.0);
            double d12 = d10;
            d7 = d7 + d11 + d12 * d12 * d2 * d9 / (double)l2;
        }
        d2 = l2 == 0L ? Double.NaN : (l2 == 1L ? 0.0 : d7 / (double)(l2 - 1L));
        return new au_0(d8, d2, l2, d5, d3, d4);
    }

    static final class a
    extends aw_0 {
        private static final long b = 1L;
        private final aw_0 c;

        a(aw_0 aw_02) {
            this.c = aw_02;
        }

        public final void a(double d2) {
            super.a(d2);
            aw_0 aw_02 = this.c;
            synchronized (aw_02) {
                this.c.a(d2);
                return;
            }
        }

        public final boolean equals(Object object) {
            a a2;
            if (object == this) {
                return true;
            }
            if (!(object instanceof a)) {
                return false;
            }
            return super.equals(a2 = (a)a2) && this.c.equals(a2.c);
        }

        public final int hashCode() {
            return 123 + super.hashCode() + this.c.hashCode();
        }
    }
}

