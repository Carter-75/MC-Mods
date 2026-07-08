/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.kO;
import org.valkyrienskies.core.impl.shadow.la_0;
import org.valkyrienskies.core.impl.shadow.nr_0;
import org.valkyrienskies.core.impl.shadow.nw_0;
import org.valkyrienskies.core.impl.shadow.uI;
import org.valkyrienskies.core.impl.shadow.uJ;
import org.valkyrienskies.core.impl.shadow.vf_0;
import org.valkyrienskies.core.impl.shadow.vj_0;
import org.valkyrienskies.core.impl.shadow.wr_0;
import org.valkyrienskies.core.impl.shadow.ww_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.vk
 */
public final class vk_0<T extends kO<T>> {
    public final vj_0<T> a;
    private final double j;
    public final T b;
    private final int k;
    public T c;
    public T d;
    public boolean e;
    public boolean f;
    public T g;
    private T l;
    private boolean m;
    private boolean n;
    public int h;
    public final nw_0<T> i;

    public vk_0(vj_0<T> vj_02, double d2, T t, int n2, nw_0<T> nw_02) {
        this.a = vj_02;
        this.j = d2;
        this.b = (kO)t.e();
        this.k = n2;
        this.i = nw_02;
        this.c = null;
        this.d = null;
        this.e = true;
        this.f = false;
        this.g = null;
        this.l = null;
        this.n = true;
        this.h = vf_0.CONTINUE$3522afc3;
    }

    public final vj_0<T> a() {
        return this.a;
    }

    private double d() {
        return this.j;
    }

    private T e() {
        return this.b;
    }

    private int f() {
        return this.k;
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    public final void a(wr_0 wr_02) {
        vk_0 vk_02;
        Object object = wr_02.c();
        this.c = ((uI)object).a;
        this.d = this.a.b();
        if (this.d.d() == 0.0) {
            double d2 = BY.e(this.i.c().d(), BY.w(((kO)this.i.d().c(this.c)).d()));
            object = (kO)this.c.a((double)(d2 * 0.5));
            wr_02.a(object);
            this.d = this.a.b();
        }
        this.e = vk_02.d.d() >= 0.0;
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    public final boolean b(wr_0 wr_02) {
        kO kO2;
        this.m = wr_02.e();
        uJ uJ2 = wr_02.d();
        uJ uJ3 = uJ2;
        uJ3 = uJ2;
        uJ3 = uJ2.a;
        kO kO3 = (kO)uJ3.b(this.c);
        if (((kO)((kO)kO2.e()).b(this.b)).d() < 0.0) {
            return false;
        }
        int n2 = BY.b(1, (int)BY.z(BY.w(kO3.d()) / this.j));
        kO3 = (kO)kO3.d((double)n2);
        la_0 la_02 = new la_0<T>(this, wr_02){
            private /* synthetic */ ww_0 a;
            private /* synthetic */ vk_0 b;
            {
                this.b = vk_02;
                this.a = ww_02;
            }

            @Override
            public final T a(T t) {
                vk_0 vk_02 = this.b;
                vj_0 vj_02 = vk_02.a;
                this.a.a(t);
                return vj_02.b();
            }
        };
        Object object = this.c;
        Object object2 = this.d;
        for (int i2 = 0; i2 < n2; ++i2) {
            uJ uJ4 = i2 == n2 - 1 ? uJ3 : (kO)this.c.a((int)kO3.a(i2 + 1));
            wr_02.a(uJ4);
            T t = this.a.b();
            if (this.e ^ t.d() >= 0.0) {
                kO kO4;
                this.n = ((kO)t.b(object2)).d() >= 0.0;
                kO kO5 = kO4 = this.m ? this.i.a(this.k, la_02, (kO)object, (kO)((Object)uJ4), nr_0.RIGHT_SIDE$37d0779) : this.i.a(this.k, la_02, (kO)((Object)uJ4), (kO)object, nr_0.LEFT_SIDE$37d0779);
                if (this.l != null && ((kO)((kO)((kO)kO4.b(object)).e()).b(this.b)).d() <= 0.0 && ((kO)((kO)((kO)kO4.b(this.l)).e()).b(this.b)).d() <= 0.0) {
                    while (this.e ^ (object2 = la_02.a(object = this.m ? (kO)object.a(this.b) : (kO)object.b(this.b))).d() >= 0.0 && this.m ^ ((kO)((Object)object.b(uJ4))).d() >= 0.0) {
                    }
                    if (this.m ^ ((kO)((Object)object.b(uJ4))).d() >= 0.0) {
                        --i2;
                        continue;
                    }
                    this.g = kO4;
                    this.f = true;
                    return true;
                }
                if (this.l == null || ((kO)((kO)this.l.b((kO)kO4).e()).b(this.b)).d() > 0.0) {
                    this.g = kO4;
                    this.f = true;
                    return true;
                }
                object = uJ4;
                object2 = t;
                continue;
            }
            object = uJ4;
            object2 = t;
        }
        this.f = false;
        this.g = null;
        return false;
    }

    public final T b() {
        if (this.f) {
            return this.g;
        }
        return (T)((kO)((kO)this.c.c().a()).a(this.m ? Double.POSITIVE_INFINITY : Double.NEGATIVE_INFINITY));
    }

    public final void a(uJ<T> uJ2) {
        vk_0 vk_02;
        uJ<T> uJ3 = uJ2;
        this.c = uJ3.a;
        this.d = this.a.b();
        if (this.f) {
            uJ<T> uJ4;
            uJ3 = uJ2;
            if (((kO)((kO)((kO)this.g.b(uJ4.a)).e()).b(this.b)).d() <= 0.0) {
                uJ3 = uJ2;
                this.l = uJ3.a;
                this.e = this.n;
                this.h = this.a.c();
                return;
            }
        }
        this.e = vk_02.d.d() >= 0.0;
        this.h = vf_0.CONTINUE$3522afc3;
    }

    public final boolean c() {
        return this.h == vf_0.STOP$3522afc3;
    }

    public final uI<T> b(uJ<T> uI2) {
        block7: {
            block6: {
                if (!this.f) break block6;
                uJ<T> uJ2 = uI2;
                if (((kO)((kO)((kO)this.g.b(uJ2.a)).e()).b(this.b)).d() <= 0.0) break block7;
            }
            return null;
        }
        if (this.h == vf_0.RESET_STATE$3522afc3) {
            uI2 = this.a.d();
        } else if (this.h != vf_0.RESET_DERIVATIVES$3522afc3) {
            uI2 = null;
        }
        this.f = false;
        this.g = null;
        return uI2;
    }

    static /* synthetic */ vj_0 a(vk_0 vk_02) {
        return vk_02.a;
    }
}

