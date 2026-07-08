/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.kO;
import org.valkyrienskies.core.impl.shadow.uG;
import org.valkyrienskies.core.impl.shadow.uI;
import org.valkyrienskies.core.impl.shadow.uJ;
import org.valkyrienskies.core.impl.shadow.ww_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.wr
 */
public abstract class wr_0<T extends kO<T>>
implements ww_0<T> {
    public final uJ<T> a;
    public final uJ<T> b;
    private final uJ<T> d;
    private final uJ<T> e;
    public final boolean c;
    private uG<T> f;

    public wr_0(boolean bl, uJ<T> uJ2, uJ<T> uJ3, uJ<T> uJ4, uJ<T> uJ5, uG<T> uG2) {
        this.c = bl;
        this.a = uJ2;
        this.b = uJ3;
        this.d = uJ4;
        this.e = uJ5;
        this.f = uG2;
    }

    public final wr_0<T> a(uJ<T> uJ2, uJ<T> uJ3) {
        wr_0 wr_02 = this;
        return wr_02.a(wr_02.c, this.a, this.b, uJ2, uJ3, this.f);
    }

    protected abstract wr_0<T> a(boolean var1, uJ<T> var2, uJ<T> var3, uJ<T> var4, uJ<T> var5, uG<T> var6);

    public final uJ<T> a() {
        return this.a;
    }

    public final uJ<T> b() {
        return this.b;
    }

    @Override
    public final uJ<T> c() {
        return this.d;
    }

    @Override
    public final uJ<T> d() {
        return this.e;
    }

    @Override
    public final uJ<T> a(T t) {
        Object object = this.a;
        kO kO2 = (kO)t.b(((uI)object).a);
        object = this.b;
        kO kO3 = (kO)((uI)object).a.b(t);
        uJ<T> uJ2 = this.b;
        object = uJ2;
        object = this.a;
        object = (kO)kO2.d(uJ2.a.b(((uI)object).a));
        wr_0 wr_02 = this;
        uG<T> cfr_ignored_0 = wr_02.f;
        return wr_02.a(t, object, kO2, kO3);
    }

    @Override
    public final boolean e() {
        return this.c;
    }

    protected abstract uJ<T> a(T var1, T var2, T var3, T var4);
}

