/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import org.valkyrienskies.core.impl.shadow.AE;
import org.valkyrienskies.core.impl.shadow.AG;
import org.valkyrienskies.core.impl.shadow.AH;
import org.valkyrienskies.core.impl.shadow.AM;
import org.valkyrienskies.core.impl.shadow.AP;
import org.valkyrienskies.core.impl.shadow.AR;
import org.valkyrienskies.core.impl.shadow.AV;
import org.valkyrienskies.core.impl.shadow.AW;
import org.valkyrienskies.core.impl.shadow.AX;
import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.an_0;
import org.valkyrienskies.core.impl.shadow.at_0;
import org.valkyrienskies.core.impl.shadow.au_0;
import org.valkyrienskies.core.impl.shadow.av_0;
import org.valkyrienskies.core.impl.shadow.ci_0;
import org.valkyrienskies.core.impl.shadow.cq_0;
import org.valkyrienskies.core.impl.shadow.oX;
import org.valkyrienskies.core.impl.shadow.px_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Aw
 */
public class aw_0
implements Serializable,
at_0 {
    private static final long b = -2021321786743555871L;
    private long c = 0L;
    AH a = new AH();
    private AV d = new AV();
    private AX e = new AX();
    private AR f = new AR();
    private AP g = new AP();
    private AW h = new AW();
    private AE i = new AE(this.h);
    private AG j = new AG(this.a);
    private AM k = new AM(this.a);
    private av_0 l = this.d;
    private av_0 m = this.e;
    private av_0 n = this.f;
    private av_0 o = this.g;
    private av_0 p = this.h;
    private av_0 q = this.i;
    private av_0 r = this.j;
    private av_0 s = this.k;

    public aw_0() {
    }

    public aw_0(aw_0 aw_02) {
        aw_0.a(aw_02, this);
    }

    public at_0 h() {
        return new au_0(this.b(), this.g(), this.d(), this.a(), this.c(), this.f());
    }

    public void a(double d2) {
        this.l.a(d2);
        this.m.a(d2);
        this.n.a(d2);
        this.o.a(d2);
        this.p.a(d2);
        ((an_0)this.a).a(d2);
        if (this.r != this.j) {
            this.r.a(d2);
        }
        if (this.s != this.k) {
            this.s.a(d2);
        }
        if (this.q != this.i) {
            this.q.a(d2);
        }
        ++this.c;
    }

    public long d() {
        return this.c;
    }

    public double f() {
        return this.l.c();
    }

    public double i() {
        return this.m.c();
    }

    public double b() {
        return this.r.c();
    }

    public double e() {
        double d2 = Double.NaN;
        if (this.d() > 0L) {
            d2 = this.d() > 1L ? BY.a(this.g()) : 0.0;
        }
        return d2;
    }

    public double j() {
        long l2 = this.d();
        if (l2 > 0L) {
            return BY.a(this.i() / (double)l2);
        }
        return Double.NaN;
    }

    public double g() {
        return this.s.c();
    }

    public double k() {
        AM aM = new AM(this.a);
        boolean bl = false;
        AM aM2 = aM;
        aM.b = bl;
        return ((an_0)aM).c();
    }

    public double a() {
        return this.o.c();
    }

    public double c() {
        return this.n.c();
    }

    public double l() {
        return this.q.c();
    }

    public final double m() {
        return this.p.c();
    }

    public final double n() {
        return ((an_0)this.a).c();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String string = "\n";
        stringBuilder.append("SummaryStatistics:").append(string);
        stringBuilder.append("n: ").append(this.d()).append(string);
        stringBuilder.append("min: ").append(this.c()).append(string);
        stringBuilder.append("max: ").append(this.a()).append(string);
        stringBuilder.append("sum: ").append(this.f()).append(string);
        stringBuilder.append("mean: ").append(this.b()).append(string);
        stringBuilder.append("geometric mean: ").append(this.l()).append(string);
        stringBuilder.append("variance: ").append(this.g()).append(string);
        stringBuilder.append("population variance: ").append(this.k()).append(string);
        aw_0 aw_02 = this;
        stringBuilder.append("second moment: ").append(((an_0)aw_02.a).c()).append(string);
        stringBuilder.append("sum of squares: ").append(this.i()).append(string);
        stringBuilder.append("standard deviation: ").append(this.e()).append(string);
        stringBuilder.append("sum of logs: ").append(this.m()).append(string);
        return stringBuilder.toString();
    }

    public void o() {
        this.c = 0L;
        this.n.b();
        this.o.b();
        this.l.b();
        this.p.b();
        this.m.b();
        this.q.b();
        ((an_0)this.a).b();
        if (this.r != this.j) {
            this.r.b();
        }
        if (this.s != this.k) {
            this.s.b();
        }
    }

    public boolean equals(Object object) {
        aw_0 aw_02;
        if (object == this) {
            return true;
        }
        if (!(object instanceof aw_0)) {
            return false;
        }
        return cq_0.b((aw_02 = (aw_0)aw_02).l(), this.l()) && cq_0.b(aw_02.a(), this.a()) && cq_0.b(aw_02.b(), this.b()) && cq_0.b(aw_02.c(), this.c()) && cq_0.b(aw_02.d(), this.d()) && cq_0.b(aw_02.f(), this.f()) && cq_0.b(aw_02.i(), this.i()) && cq_0.b(aw_02.g(), this.g());
    }

    public int hashCode() {
        int n2 = 31 + ci_0.a(this.l());
        n2 = n2 * 31 + ci_0.a(this.l());
        n2 = n2 * 31 + ci_0.a(this.a());
        n2 = n2 * 31 + ci_0.a(this.b());
        n2 = n2 * 31 + ci_0.a(this.c());
        n2 = n2 * 31 + ci_0.a(this.d());
        n2 = n2 * 31 + ci_0.a(this.f());
        n2 = n2 * 31 + ci_0.a(this.i());
        n2 = n2 * 31 + ci_0.a(this.g());
        return n2;
    }

    public av_0 p() {
        return this.l;
    }

    public void a(av_0 av_02) {
        this.y();
        this.l = av_02;
    }

    public av_0 q() {
        return this.m;
    }

    public void b(av_0 av_02) {
        this.y();
        this.m = av_02;
    }

    public av_0 r() {
        return this.n;
    }

    public void c(av_0 av_02) {
        this.y();
        this.n = av_02;
    }

    public av_0 s() {
        return this.o;
    }

    public void d(av_0 av_02) {
        this.y();
        this.o = av_02;
    }

    public av_0 t() {
        return this.p;
    }

    public void e(av_0 av_02) {
        this.y();
        this.p = av_02;
        av_0 av_03 = av_02;
        av_02 = this.i;
        AE aE = av_02;
        if (((AE)av_02).g_() > 0L) {
            throw new oX(px_0.VALUES_ADDED_BEFORE_CONFIGURING_STATISTIC, aE.g_());
        }
        ((AE)av_02).a = av_03;
    }

    public av_0 u() {
        return this.q;
    }

    public void f(av_0 av_02) {
        this.y();
        this.q = av_02;
    }

    public av_0 v() {
        return this.r;
    }

    public void g(av_0 av_02) {
        this.y();
        this.r = av_02;
    }

    public av_0 w() {
        return this.s;
    }

    public void h(av_0 av_02) {
        this.y();
        this.s = av_02;
    }

    private void y() {
        if (this.c > 0L) {
            throw new oX(px_0.VALUES_ADDED_BEFORE_CONFIGURING_STATISTIC, this.c);
        }
    }

    public aw_0 x() {
        aw_0 aw_02 = new aw_0();
        aw_0.a(this, aw_02);
        return aw_02;
    }

    public static void a(aw_0 aw_02, aw_0 aw_03) {
        ci_0.a(aw_02);
        ci_0.a(aw_03);
        aw_03.o = aw_02.o.a();
        aw_03.n = aw_02.n.a();
        aw_03.l = aw_02.l.a();
        aw_03.p = aw_02.p.a();
        aw_03.m = aw_02.m.a();
        aw_03.a = aw_02.a.i();
        aw_03.c = aw_02.c;
        aw_03.s = aw_02.w() instanceof AM ? new AM(aw_03.a) : aw_02.s.a();
        aw_03.r = aw_02.r instanceof AG ? new AG(aw_03.a) : aw_02.r.a();
        aw_03.q = aw_02.u() instanceof AE ? new AE((AW)aw_03.p) : aw_02.q.a();
        if (aw_02.i == aw_02.q) {
            aw_03.i = (AE)aw_03.q;
        } else {
            AE.a(aw_02.i, aw_03.i);
        }
        if (aw_02.g == aw_02.o) {
            aw_03.g = (AP)aw_03.o;
        } else {
            AP.a(aw_02.g, aw_03.g);
        }
        if (aw_02.j == aw_02.r) {
            aw_03.j = (AG)aw_03.r;
        } else {
            AG.a(aw_02.j, aw_03.j);
        }
        if (aw_02.f == aw_02.n) {
            aw_03.f = (AR)aw_03.n;
        } else {
            AR.a(aw_02.f, aw_03.f);
        }
        if (aw_02.d == aw_02.l) {
            aw_03.d = (AV)aw_03.l;
        } else {
            AV.a(aw_02.d, aw_03.d);
        }
        if (aw_02.k == aw_02.s) {
            aw_03.k = (AM)aw_03.s;
        } else {
            AM.a(aw_02.k, aw_03.k);
        }
        if (aw_02.h == aw_02.p) {
            aw_03.h = (AW)aw_03.p;
        } else {
            AW.a(aw_02.h, aw_03.h);
        }
        if (aw_02.e == aw_02.m) {
            aw_03.e = (AX)aw_03.m;
            return;
        }
        AX.a(aw_02.e, aw_03.e);
    }
}

