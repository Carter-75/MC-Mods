/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.ch_0;
import org.valkyrienskies.core.impl.shadow.ci_0;
import org.valkyrienskies.core.impl.shadow.kM;
import org.valkyrienskies.core.impl.shadow.kO;
import org.valkyrienskies.core.impl.shadow.oS;
import org.valkyrienskies.core.impl.shadow.pn_0;
import org.valkyrienskies.core.impl.shadow.pw_0;
import org.valkyrienskies.core.impl.shadow.px_0;
import org.valkyrienskies.core.impl.shadow.uG;
import org.valkyrienskies.core.impl.shadow.uI;
import org.valkyrienskies.core.impl.shadow.uJ;
import org.valkyrienskies.core.impl.shadow.uz_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.vw
 */
public abstract class vw_0<T extends kO<T>>
extends uz_0<T> {
    protected double f;
    protected double g;
    protected double[] h;
    protected double[] i;
    protected int j;
    private T d;
    private T e;
    private T k;

    public vw_0(kM<T> object, String string, double d2, double d3, double d4, double d5) {
        super(object, string);
        double d6 = d5;
        double d7 = d4;
        double d8 = d3;
        double d9 = d2;
        object = this;
        this.e = (kO)((kO)((uz_0)object).a().a()).a(BY.w(d9));
        ((vw_0)object).k = (kO)((kO)((uz_0)object).a().a()).a(BY.w(d8));
        ((vw_0)object).d = (kO)((kO)((uz_0)object).a().b()).a();
        ((vw_0)object).f = d7;
        ((vw_0)object).g = d6;
        ((vw_0)object).h = null;
        ((vw_0)object).i = null;
        this.f_();
    }

    public vw_0(kM<T> object, String object2, double d2, double d3, double[] dArray, double[] dArray2) {
        super(object, (String)object2);
        double[] dArray3 = dArray2;
        object2 = dArray;
        double d4 = d3;
        double d5 = d2;
        object = this;
        this.e = (kO)((kO)((uz_0)object).a().a()).a(BY.w(d5));
        ((vw_0)object).k = (kO)((kO)((uz_0)object).a().a()).a(BY.w(d4));
        ((vw_0)object).d = (kO)((kO)((uz_0)object).a().b()).a();
        ((vw_0)object).f = 0.0;
        ((vw_0)object).g = 0.0;
        ((vw_0)object).h = (double[])object2.clone();
        ((vw_0)object).i = (double[])dArray3.clone();
        this.f_();
    }

    private void a(double d2, double d3, double d4, double d5) {
        this.e = (kO)((kO)this.a().a()).a(BY.w(d2));
        this.k = (kO)((kO)this.a().a()).a(BY.w(d3));
        this.d = (kO)((kO)this.a().b()).a();
        this.f = d4;
        this.g = d5;
        this.h = null;
        this.i = null;
    }

    private void a(double d2, double d3, double[] dArray, double[] dArray2) {
        this.e = (kO)((kO)this.a().a()).a(BY.w(d2));
        this.k = (kO)((kO)this.a().a()).a(BY.w(d3));
        this.d = (kO)((kO)this.a().b()).a();
        this.f = 0.0;
        this.g = 0.0;
        this.h = (double[])dArray.clone();
        this.i = (double[])dArray2.clone();
    }

    private void b(T t) {
        if (((kO)t.b(this.e)).d() < 0.0 || ((kO)t.b(this.k)).d() > 0.0) {
            this.d = (kO)((kO)this.a().b()).a();
            return;
        }
        this.d = t;
    }

    @Override
    public final void a(uI<T> uI2, T t) {
        super.a(uI2, t);
        this.j = uI2.b.length;
        if (this.h != null && this.h.length != this.j) {
            throw new oS(this.j, this.h.length);
        }
        if (this.i != null && this.i.length != this.j) {
            throw new oS(this.j, this.i.length);
        }
    }

    public final T a(boolean bl, int n2, T[] TArray, uJ<T> uJ2, uG<T> kOArray) {
        Object object;
        Object object2;
        Object object3;
        if (this.d.d() > 0.0) {
            if (bl) {
                return this.d;
            }
            return (T)((kO)this.d.a());
        }
        Object object4 = kOArray.a(uJ2);
        kOArray = kOArray.a(uJ2);
        kO kO2 = (kO)this.a().a();
        kO kO3 = (kO)this.a().a();
        for (int i2 = 0; i2 < TArray.length; ++i2) {
            kO kO4;
            object3 = (kO[])object4[i2].d(TArray[i2]);
            kO2 = kO2.a(object3.c(object3));
            kO kO5 = kO4 = (kO)kOArray[i2].d(TArray[i2]);
            kO3 = kO3.a(kO5.c(kO5));
        }
        Object object5 = object2 = kO2.d() < 1.0E-10 || kO3.d() < 1.0E-10 ? (kO)((kO)this.a().a()).a(1.0E-6) : (kO)((kO)kO2.d(kO3).k()).c(0.01);
        if (!bl) {
            object2 = (kO)object2.a();
        }
        object3 = (kO[])ch_0.a(this.a(), ((kO[])object4).length);
        for (int i3 = 0; i3 < ((kO[])object4).length; ++i3) {
            object3[i3] = object4[i3].a(kOArray[i3].c(object2));
        }
        object4 = uJ2;
        kO[] kOArray2 = this.a(((uI)object4).a.a((kO)object2), (kO[])object3);
        object4 = (kO)this.a().a();
        for (int i4 = 0; i4 < TArray.length; ++i4) {
            Object object6 = object3 = (kO)kOArray2[i4].b(kOArray[i4]).d(TArray[i4]);
            object4 = (kO)object4.a(object6.c(object6));
        }
        object4 = ((kO)object4.k()).d(object2);
        Object object7 = ci_0.a((kO)kO3.k(), object4);
        object3 = object.d() < 1.0E-15 ? ci_0.a((kO)((kO)this.a().a()).a(1.0E-6), (kO)((kO)object2.e()).c(0.001)) : (kO)((kO)((kO)object7.a(100)).b()).g(1.0 / (double)n2);
        object2 = ci_0.b((kO)((kO)object2.e()).a(100), object3);
        object4 = uJ2;
        object2 = ci_0.a(object2, (kO)((kO)((uI)object4).a.e()).c(1.0E-12));
        object2 = ci_0.a(this.e, ci_0.b(this.k, object2));
        if (!bl) {
            object2 = (kO)object2.a();
        }
        return (T)object2;
    }

    protected final T a(T t, boolean bl, boolean bl2) {
        Object object = t;
        if (((kO)((kO)t.e()).b(this.e)).d() < 0.0) {
            if (bl2) {
                object = bl ? this.e : (kO)this.e.a();
            } else {
                throw new pn_0((pw_0)px_0.MINIMAL_STEPSIZE_REACHED_DURING_INTEGRATION, (Number)((kO)t.e()).d(), this.e.d(), true);
            }
        }
        if (((kO)object.b(this.k)).d() > 0.0) {
            object = this.k;
        } else if (((kO)object.a(this.k)).d() < 0.0) {
            object = (kO)this.k.a();
        }
        return object;
    }

    protected final void f_() {
        this.a(null);
        vw_0 vw_02 = this;
        vw_02.a((kO)((kO)vw_02.e.c(this.k)).k());
    }

    private T s() {
        return this.e;
    }

    private T t() {
        return this.k;
    }
}

