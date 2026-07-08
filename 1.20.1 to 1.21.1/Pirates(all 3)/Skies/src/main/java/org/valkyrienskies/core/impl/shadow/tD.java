/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.cn_0;
import org.valkyrienskies.core.impl.shadow.kM;
import org.valkyrienskies.core.impl.shadow.kN;
import org.valkyrienskies.core.impl.shadow.sQ;
import org.valkyrienskies.core.impl.shadow.su_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public final class tD<T extends kN<T>>
extends su_0<T> {
    private final cn_0<T> a;
    private final int b;
    private final int c;

    private tD(kM<T> kM2) {
        super(kM2);
        this.b = 0;
        this.c = 0;
        this.a = new cn_0<T>(kM2);
    }

    public tD(kM<T> kM2, int n2, int n3) {
        super(kM2, n2, n3);
        this.b = n2;
        this.c = n3;
        this.a = new cn_0<T>(kM2);
    }

    private tD(tD<T> tD2) {
        tD<T> tD3 = tD2;
        tD<T> tD4 = tD3;
        tD4 = tD2;
        super(tD2.a(), tD3.b, tD4.c);
        tD4 = tD2;
        this.b = tD4.b;
        tD4 = tD2;
        this.c = tD4.c;
        this.a = new cn_0<T>(tD2.a);
    }

    private tD(sQ<T> sQ2) {
        super(sQ2.a(), sQ2.f(), sQ2.g());
        this.b = sQ2.f();
        this.c = sQ2.g();
        this.a = new cn_0(this.a());
        for (int i2 = 0; i2 < this.b; ++i2) {
            for (int i3 = 0; i3 < this.c; ++i3) {
                ((su_0)this).a(i2, i3, sQ2.b(i2, i3));
            }
        }
    }

    @Override
    public final void b(int n2, int n3, T t) {
        this.h(n2);
        this.i(n3);
        n2 = this.c(n2, n3);
        kN kN2 = (kN)this.a.a(n2).a(t);
        if (((kN)this.a().a()).equals(kN2)) {
            this.a.c(n2);
            return;
        }
        this.a.a(n2, kN2);
    }

    @Override
    public final sQ<T> b() {
        return new tD<T>(this);
    }

    @Override
    public final sQ<T> a(int n2, int n3) {
        return new tD(this.a(), n2, n3);
    }

    @Override
    public final int g() {
        return this.c;
    }

    @Override
    public final T b(int n2, int n3) {
        this.h(n2);
        this.i(n3);
        return this.a.a(this.c(n2, n3));
    }

    @Override
    public final int f() {
        return this.b;
    }

    @Override
    public final void c(int n2, int n3, T t) {
        this.h(n2);
        this.i(n3);
        n2 = this.c(n2, n3);
        kN kN2 = (kN)this.a.a(n2).c(t);
        if (((kN)this.a().a()).equals(kN2)) {
            this.a.c(n2);
            return;
        }
        this.a.a(n2, kN2);
    }

    @Override
    public final void a(int n2, int n3, T t) {
        this.h(n2);
        this.i(n3);
        if (((kN)this.a().a()).equals(t)) {
            this.a.c(this.c(n2, n3));
            return;
        }
        this.a.a(this.c(n2, n3), t);
    }

    private int c(int n2, int n3) {
        return n2 * this.c + n3;
    }
}

