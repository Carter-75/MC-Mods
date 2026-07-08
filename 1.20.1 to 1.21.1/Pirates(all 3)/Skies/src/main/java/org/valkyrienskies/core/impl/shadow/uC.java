/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.ArrayList;
import java.util.List;
import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.kO;
import org.valkyrienskies.core.impl.shadow.oS;
import org.valkyrienskies.core.impl.shadow.oV;
import org.valkyrienskies.core.impl.shadow.px_0;
import org.valkyrienskies.core.impl.shadow.uI;
import org.valkyrienskies.core.impl.shadow.uJ;
import org.valkyrienskies.core.impl.shadow.wr_0;
import org.valkyrienskies.core.impl.shadow.wv_0;
import org.valkyrienskies.core.impl.shadow.ww_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public final class uC<T extends kO<T>>
implements wv_0<T> {
    private T a = null;
    private T b = null;
    private boolean c = true;
    private int d = 0;
    private List<ww_0<T>> e = new ArrayList<ww_0<T>>();

    private void a(uC<T> uC2) {
        uJ<T> uJ2;
        if (uC2.e.size() == 0) {
            return;
        }
        if (this.e.size() == 0) {
            this.a = uC2.a;
            this.c = uC2.c;
        } else {
            kO kO2;
            Object object = this.e.get(0).c();
            uJ<T> object2 = uC2.e.get(0).c();
            uJ<T> uJ3 = object;
            uJ2 = uJ3;
            uJ2 = object2;
            uC.a(uJ3.b.length, uJ2.b.length);
            uC.a(((uI)object).d(), object2.d());
            for (int i2 = 0; i2 < ((uI)object).d(); ++i2) {
                uC.a(((uI)object).a(i2), object2.a(i2));
            }
            if (this.c ^ uC2.c) {
                throw new oV(px_0.PROPAGATION_DIRECTION_MISMATCH, new Object[0]);
            }
            Object object3 = this.e.get(this.d);
            uJ2 = object3.d();
            object = uJ2.a;
            uJ2 = object3.c();
            Object t = uJ2.a;
            kO kO3 = (kO)object.b(t);
            object3 = uC2;
            object = (kO)((Object)((uC)object3).a.b(object));
            if (((kO)((kO)kO2.e()).b(((kO)kO3.e()).c(0.001))).d() > 0.0) {
                throw new oV(px_0.HOLE_BETWEEN_MODELS_TIME_RANGES, ((kO)object.e()).d());
            }
        }
        for (ww_0 ww_02 : uC2.e) {
            this.e.add(ww_02);
        }
        this.d = this.e.size() - 1;
        uJ2 = this.e.get(this.d).d();
        this.b = uJ2.a;
    }

    private static void a(int n2, int n3) {
        if (n2 != n3) {
            throw new oS(n3, n2);
        }
    }

    @Override
    public final void a(uJ<T> uJ2, T t) {
        this.a = uJ2.a;
        this.b = t;
        this.c = true;
        this.d = 0;
        this.e.clear();
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    @Override
    public final void a(wr_0 wr_02, boolean bl) {
        uJ uJ2;
        if (this.e.size() == 0) {
            uJ2 = wr_02.c();
            this.a = uJ2.a;
            this.c = wr_02.e();
        }
        this.e.add(wr_02);
        if (bl) {
            uJ2 = wr_02.d();
            this.b = uJ2.a;
            this.d = this.e.size() - 1;
        }
    }

    private T a() {
        return this.a;
    }

    private T b() {
        return this.b;
    }

    private uJ<T> a(T kO2) {
        int n2 = 0;
        ww_0<T> ww_02 = this.e.get(0);
        uJ<T> uJ2 = ww_02.c();
        Object object = uJ2;
        object = ww_02.d();
        kO kO3 = (kO)((kO)uJ2.a.a(((uI)object).a)).c(0.5);
        int n3 = this.e.size() - 1;
        Object object2 = this.e.get(n3);
        uJ<T> uJ3 = object2.c();
        object = uJ3;
        object = object2.d();
        kO kO4 = (kO)((kO)uJ3.a.a(((uI)object).a)).c(0.5);
        if (this.a(kO2, ww_02) <= 0) {
            this.d = 0;
            return ww_02.a(kO2);
        }
        if (this.a((T)kO2, (ww_0<T>)object2) >= 0) {
            this.d = n3;
            return object2.a(kO2);
        }
        while (n3 - n2 > 5) {
            ww_02 = this.e.get(this.d);
            int n4 = this.a(kO2, ww_02);
            if (n4 < 0) {
                n3 = this.d;
                uJ<T> uJ4 = ww_02.c();
                object = uJ4;
                object = ww_02.d();
                kO4 = (kO)((kO)uJ4.a.a(((uI)object).a)).c(0.5);
            } else if (n4 > 0) {
                n2 = this.d;
                uJ<T> uJ5 = ww_02.c();
                object = uJ5;
                object = ww_02.d();
                kO3 = (kO)((kO)uJ5.a.a(((uI)object).a)).c(0.5);
            } else {
                return ww_02.a(kO2);
            }
            int n5 = (n2 + n3) / 2;
            object2 = this.e.get(n5);
            uJ<T> uJ6 = object2.c();
            object = uJ6;
            object = object2.d();
            object2 = (kO)((kO)uJ6.a.a(((uI)object).a)).c(0.5);
            if (((kO)((kO)object2.b(kO3).e()).b(1.0E-6)).d() < 0.0 || ((kO)((kO)((kO)kO4.b(object2)).e()).b(1.0E-6)).d() < 0.0) {
                this.d = n5;
            } else {
                object = (kO)kO4.b(object2);
                kO kO5 = object2.b(kO3);
                kO kO6 = kO4.b(kO3);
                kO kO7 = kO2.b((kO)kO4);
                object2 = (kO)kO2.b((Object)object2);
                kO kO8 = kO2.b((kO)kO3);
                kO kO9 = ((kO)((kO)((kO)object2.c(kO8).c(kO5).a(n3)).b(kO7.c(kO8).c(kO6).a(n5))).a(((kO)((kO)kO7.c(object2)).c(object)).a(n2))).d(object.c(kO5).c(kO6));
                this.d = (int)BY.A(kO9.d());
            }
            int n6 = BY.b(n2 + 1, (n2 * 9 + n3) / 10);
            int n7 = BY.a(n3 - 1, (n2 + n3 * 9) / 10);
            if (this.d < n6) {
                this.d = n6;
                continue;
            }
            if (this.d <= n7) continue;
            this.d = n7;
        }
        this.d = n2;
        while (this.d <= n3 && this.a(kO2, this.e.get(this.d)) > 0) {
            ++this.d;
        }
        return this.e.get(this.d).a(kO2);
    }

    private int a(T t, ww_0<T> ww_02) {
        uJ<T> uJ2;
        uJ<T> uJ3;
        if (this.c) {
            uJ<T> uJ4;
            uJ<T> uJ5;
            uJ<T> uJ6 = ww_02.c();
            if (((kO)t.b(uJ5.a)).d() < 0.0) {
                return -1;
            }
            uJ6 = ww_02.d();
            if (((kO)t.b(uJ4.a)).d() > 0.0) {
                return 1;
            }
            return 0;
        }
        uJ<T> uJ7 = ww_02.c();
        if (((kO)t.b(uJ3.a)).d() > 0.0) {
            return -1;
        }
        uJ7 = ww_02.d();
        if (((kO)t.b(uJ2.a)).d() < 0.0) {
            return 1;
        }
        return 0;
    }
}

