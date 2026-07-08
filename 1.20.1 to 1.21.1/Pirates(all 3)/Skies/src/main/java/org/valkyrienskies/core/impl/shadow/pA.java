/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.ci_0;
import org.valkyrienskies.core.impl.shadow.oS;
import org.valkyrienskies.core.impl.shadow.pB;
import org.valkyrienskies.core.impl.shadow.pC;
import org.valkyrienskies.core.impl.shadow.sA;
import org.valkyrienskies.core.impl.shadow.sE;
import org.valkyrienskies.core.impl.shadow.sy_0;
import org.valkyrienskies.core.impl.shadow.tc_0;
import org.valkyrienskies.core.impl.shadow.td_0;
import org.valkyrienskies.core.impl.shadow.th_0;
import org.valkyrienskies.core.impl.shadow.tq_0;
import org.valkyrienskies.core.impl.shadow.tu_0;

public final class pA {
    private final pC a;
    private final pB b;
    private tq_0 c;
    private tq_0 d;
    private tq_0 e;
    private tq_0 f;
    private tq_0 g;
    private tu_0 h;
    private tq_0 i;

    private pA(pC object, pB object2) {
        ci_0.a(object);
        ci_0.a(object2);
        this.a = object;
        this.b = object2;
        this.c = this.a.a();
        ci_0.a(this.c);
        this.d = this.c.d();
        this.e = this.a.b() == null ? new sy_0() : this.a.b();
        this.f = this.b.a();
        ci_0.a(this.f);
        this.g = this.f.d();
        object = this.a.c();
        ci_0.a(object);
        object2 = this.b.b();
        ci_0.a(object2);
        this.h = this.a.d() == null ? new sA(this.c.g()) : this.a.d();
        if (this.c.g() != this.h.f()) {
            throw new oS(this.c.g(), this.h.f());
        }
        this.i = this.a.e() == null ? object.i() : this.a.e();
        if (!this.c.e()) {
            throw new th_0(this.c.f(), this.c.g());
        }
        if (this.e != null && this.e.f() > 0 && this.e.g() > 0 && this.e.f() != this.c.f()) {
            throw new tc_0(this.e.f(), this.e.g(), this.c.f(), this.e.g());
        }
        td_0.a(this.c, (tq_0)object);
        if (this.f.g() != this.c.f()) {
            throw new tc_0(this.f.f(), this.f.g(), this.f.f(), this.c.f());
        }
        if (object2.f() != this.f.f()) {
            throw new tc_0(object2.f(), object2.g(), this.f.f(), object2.g());
        }
    }

    private int a() {
        return this.h.f();
    }

    private int b() {
        return this.f.f();
    }

    private double[] c() {
        return this.h.g();
    }

    private tu_0 d() {
        return this.h.j();
    }

    private double[][] e() {
        return this.i.a();
    }

    private tq_0 f() {
        return this.i.i();
    }

    private void g() {
        this.a((tu_0)null);
    }

    private void a(double[] dArray) {
        this.a((tu_0)((Object)new sA(dArray, false)));
    }

    private void a(tu_0 tu_02) {
        if (tu_02 != null && tu_02.f() != this.e.g()) {
            throw new oS(tu_02.f(), this.e.g());
        }
        this.h = this.c.a(this.h);
        if (tu_02 != null) {
            this.h = this.h.l((tu_0)((Object)this.e.a(tu_02)));
        }
        this.i = this.c.c(this.i).c(this.d).a(this.a.c());
    }

    private void b(double[] object) {
        Object object2 = new sA((double[])object, false);
        object = this;
        ci_0.a(object2);
        if (((tu_0)object2).f() != object.f.f()) {
            throw new oS(((tu_0)object2).f(), object.f.f());
        }
        tq_0 tq_02 = object.f.c(object.i).c(object.g).a(object.b.b());
        object2 = ((tu_0)object2).k((tu_0)((Object)object.f.a(object.h)));
        tq_02 = new sE(tq_02).a().a(object.f.c(object.i.d())).d();
        object.h = object.h.l((tu_0)((Object)tq_02.a((tu_0)object2)));
        object2 = td_0.a(tq_02.f());
        object.i = object2.b(tq_02.c(object.f)).c(object.i);
    }

    private void a(sA object) {
        ci_0.a(object);
        if (((tu_0)object).f() != this.f.f()) {
            throw new oS(((tu_0)object).f(), this.f.f());
        }
        tq_0 tq_02 = this.f.c(this.i).c(this.g).a(this.b.b());
        object = ((tu_0)object).k((tu_0)((Object)this.f.a(this.h)));
        tq_02 = new sE(tq_02).a().a(this.f.c(this.i.d())).d();
        this.h = this.h.l((tu_0)((Object)tq_02.a((tu_0)object)));
        object = td_0.a(tq_02.f());
        this.i = object.b(tq_02.c(this.f)).c(this.i);
    }
}

