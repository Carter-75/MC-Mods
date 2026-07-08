/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.ch_0;
import org.valkyrienskies.core.impl.shadow.ci_0;
import org.valkyrienskies.core.impl.shadow.kM;
import org.valkyrienskies.core.impl.shadow.kO;
import org.valkyrienskies.core.impl.shadow.uG;
import org.valkyrienskies.core.impl.shadow.uH;
import org.valkyrienskies.core.impl.shadow.uI;
import org.valkyrienskies.core.impl.shadow.uJ;
import org.valkyrienskies.core.impl.shadow.uz_0;
import org.valkyrienskies.core.impl.shadow.vQ;
import org.valkyrienskies.core.impl.shadow.vw_0;
import org.valkyrienskies.core.impl.shadow.wk_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public abstract class vK<T extends kO<T>>
extends vw_0<T>
implements vQ<T> {
    private final int d;
    private final T[] e;
    private final T[][] k;
    private final T[] l;
    private final T m;
    private T n;
    private T o;
    private T p;

    protected vK(kM<T> kM2, String object, int n2, double d2, double d3, double d4, double d5) {
        super(kM2, (String)object, d2, d3, d4, d5);
        this.d = n2;
        this.e = this.p();
        this.k = this.q();
        this.l = this.r();
        this.m = (kO)((kO)kM2.b()).d((double)(-this.s()));
        kO kO2 = (kO)((kO)kM2.a()).a(0.9);
        object = this;
        this.n = kO2;
        kO2 = (kO)((kO)kM2.a()).a(0.2);
        object = this;
        this.o = kO2;
        kO2 = (kO)((kO)kM2.a()).a(10.0);
        object = this;
        this.p = kO2;
    }

    protected vK(kM<T> kM2, String object, int n2, double d2, double d3, double[] dArray, double[] dArray2) {
        super(kM2, (String)object, d2, d3, dArray, dArray2);
        this.d = n2;
        this.e = this.p();
        this.k = this.q();
        this.l = this.r();
        this.m = (kO)((kO)kM2.b()).d((double)(-this.s()));
        kO kO2 = (kO)((kO)kM2.a()).a(0.9);
        object = this;
        this.n = kO2;
        kO2 = (kO)((kO)kM2.a()).a(0.2);
        object = this;
        this.o = kO2;
        kO2 = (kO)((kO)kM2.a()).a(10.0);
        object = this;
        this.p = kO2;
    }

    protected final T a(int n2, int n3) {
        return (T)((kO)((kO)((kO)this.a().b()).a(n2)).d((double)n3));
    }

    protected final T a(double d2, double d3) {
        return (T)((kO)((kO)((kO)this.a().b()).c(d2)).d(d3));
    }

    protected abstract wk_0<T> a(boolean var1, T[][] var2, uJ<T> var3, uJ<T> var4, uG<T> var5);

    public abstract int s();

    private T t() {
        return this.n;
    }

    private void b(T t) {
        this.n = t;
    }

    @Override
    public final uJ<T> a(uH<T> uH2, uI<T> uI2, T t) {
        Object object;
        uI<T> uI3;
        ((uz_0)this).a(uI2, t);
        Object object2 = uI2;
        Object t2 = object2.a;
        object2 = uH2;
        kO[] kOArray = object2.c.a(uI2);
        vK vK2 = this;
        vK2.a(vK2.a(uH2, (kO)t2, kOArray, (kO)t));
        object2 = uI2;
        boolean bl = ((kO)t.b(uI3.a)).d() > 0.0;
        int n2 = this.e.length + 1;
        kO[] kOArray2 = kOArray;
        kO[][] kOArray3 = (kO[][])ch_0.a(this.a(), n2, -1);
        kO[] kOArray4 = (kO[])ch_0.a(this.a(), kOArray.length);
        kO kO2 = (kO)this.a().a();
        boolean bl2 = true;
        this.a(false);
        do {
            boolean bl3;
            object = (kO)((kO)this.a().a()).a(10.0);
            while (((kO)object.b(1.0)).d() >= 0.0) {
                kO kO3;
                int n3;
                object2 = uH2;
                kOArray2 = object2.c.a(this.n());
                object2 = uH2;
                kOArray3[0] = object2.c.a(this.n());
                if (bl2) {
                    int n4;
                    kO[] kOArray5 = (kO[])ch_0.a(this.a(), this.j);
                    if (this.h == null) {
                        for (n4 = 0; n4 < kOArray5.length; ++n4) {
                            kOArray5[n4] = (kO)((kO)((kO)kOArray2[n4].e()).c(this.g)).a(this.f);
                        }
                    } else {
                        for (n4 = 0; n4 < kOArray5.length; ++n4) {
                            kOArray5[n4] = (kO)((kO)((kO)kOArray2[n4].e()).c(this.i[n4])).a(this.h[n4]);
                        }
                    }
                    object2 = uH2;
                    kO2 = this.a(bl, this.s(), kOArray5, this.n(), object2.c);
                    bl2 = false;
                }
                this.a(kO2);
                if (bl) {
                    uJ uJ2;
                    object2 = this.n();
                    if (((kO)((kO)uJ2.a.a(this.m())).b(t)).d() >= 0.0) {
                        object2 = this.n();
                        this.a((kO)t.b(object2.a));
                    }
                } else {
                    uJ uJ3;
                    object2 = this.n();
                    if (((kO)((kO)uJ3.a.a(this.m())).b(t)).d() <= 0.0) {
                        object2 = this.n();
                        this.a((kO)t.b(object2.a));
                    }
                }
                for (n3 = 1; n3 < n2; ++n3) {
                    for (int i2 = 0; i2 < kOArray.length; ++i2) {
                        kO kO4 = (kO)kOArray3[0][i2].c(this.k[n3 - 1][0]);
                        for (int i3 = 1; i3 < n3; ++i3) {
                            kO4 = (kO)kO4.a(kOArray3[i3][i2].c(this.k[n3 - 1][i3]));
                        }
                        kOArray4[i2] = kOArray2[i2].a(this.m().c((kO)kO4));
                    }
                    vK vK3 = this;
                    object2 = vK3.n();
                    kOArray3[n3] = vK3.a((kO)object2.a.a(this.m().c(this.e[n3 - 1])), kOArray4);
                }
                for (n3 = 0; n3 < kOArray.length; ++n3) {
                    object2 = (kO)kOArray3[0][n3].c(this.l[0]);
                    for (int i4 = 1; i4 < n2; ++i4) {
                        object2 = (kO)object2.a(kOArray3[i4][n3].c(this.l[i4]));
                    }
                    kOArray4[n3] = (kO)kOArray2[n3].a(this.m().c((kO[])object2));
                }
                object = this.a(kOArray3, kOArray2, kOArray4, (kO)this.m());
                if (!(((kO)kO3.b(1.0)).d() >= 0.0)) continue;
                kO kO5 = ci_0.b(this.p, ci_0.a(this.o, (kO)this.n.c(object.a(this.m))));
                vK vK4 = this;
                kO2 = vK4.a(vK4.m().c((kO)kO5), bl, false);
            }
            object2 = this.n();
            kO kO6 = (kO)object2.a.a(this.m());
            object2 = this.d >= 0 ? kOArray3[this.d] : this.a(kO6, kOArray4);
            uJ uJ4 = new uJ(kO6, kOArray4, object2);
            System.arraycopy(kOArray4, 0, kOArray2, 0, kOArray.length);
            vK vK5 = this;
            object2 = uH2;
            vK5.a(vK5.a(this.a(bl, kOArray3, this.n(), uJ4, object2.c), t));
            if (this.o()) continue;
            object = ci_0.b(this.p, ci_0.a(this.o, (kO)this.n.c(object.a(this.m))));
            kO2 = (kO)this.m().c((Object)object);
            object2 = this.n();
            object = object2.a.a((kO)kO2);
            boolean bl4 = bl ? ((kO)object.b(t)).d() >= 0.0 : ((kO)object.b(t)).d() <= 0.0;
            kO2 = this.a(kO2, bl, bl4);
            object2 = this.n();
            kO kO7 = object2.a.a((kO)kO2);
            boolean bl5 = bl ? ((kO)kO7.b(t)).d() >= 0.0 : (bl3 = ((kO)kO7.b(t)).d() <= 0.0);
            if (!bl5) continue;
            object2 = this.n();
            kO2 = (kO)t.b(object2.a);
        } while (!this.o());
        object = this.n();
        this.f_();
        return object;
    }

    private T u() {
        return this.o;
    }

    private void c(T t) {
        this.o = t;
    }

    private T v() {
        return this.p;
    }

    private void d(T t) {
        this.p = t;
    }

    protected abstract T a(T[][] var1, T[] var2, T[] var3, T var4);
}

