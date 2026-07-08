/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.ch_0;
import org.valkyrienskies.core.impl.shadow.ci_0;
import org.valkyrienskies.core.impl.shadow.kM;
import org.valkyrienskies.core.impl.shadow.kO;
import org.valkyrienskies.core.impl.shadow.oX;
import org.valkyrienskies.core.impl.shadow.pn_0;
import org.valkyrienskies.core.impl.shadow.pw_0;
import org.valkyrienskies.core.impl.shadow.px_0;
import org.valkyrienskies.core.impl.shadow.sx_0;
import org.valkyrienskies.core.impl.shadow.uG;
import org.valkyrienskies.core.impl.shadow.uH;
import org.valkyrienskies.core.impl.shadow.uI;
import org.valkyrienskies.core.impl.shadow.uJ;
import org.valkyrienskies.core.impl.shadow.uO;
import org.valkyrienskies.core.impl.shadow.uz_0;
import org.valkyrienskies.core.impl.shadow.vG;
import org.valkyrienskies.core.impl.shadow.vw_0;
import org.valkyrienskies.core.impl.shadow.wr_0;
import org.valkyrienskies.core.impl.shadow.wv_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public abstract class uS<T extends kO<T>>
extends vw_0<T> {
    protected T[] d;
    protected sx_0<T> e;
    private uO<T> k;
    private final int l;
    private double m;
    private double n;
    private double o;
    private double p;

    public uS(kM<T> object, String string, int n2, int n3, double d2, double d3, double d4, double d5) {
        super(object, string, d2, d3, d4, d5);
        if (n2 < 2) {
            throw new pn_0((pw_0)px_0.INTEGRATION_METHOD_NEEDS_AT_LEAST_TWO_PREVIOUS_POINTS, (Number)n2, 2, true);
        }
        this.k = new vG<T>(object, d2, d3, d4, d5);
        this.l = n2;
        this.m = -1.0 / (double)n3;
        double d6 = 0.9;
        object = this;
        this.n = 0.9;
        d6 = 0.2;
        object = this;
        this.o = 0.2;
        d6 = BY.a(2.0, -this.m);
        object = this;
        this.p = d6;
    }

    public uS(kM<T> object, String string, int n2, int n3, double d2, double d3, double[] dArray, double[] dArray2) {
        super(object, string, d2, d3, dArray, dArray2);
        this.k = new vG<T>(object, d2, d3, dArray, dArray2);
        this.l = n2;
        this.m = -1.0 / (double)n3;
        double d4 = 0.9;
        object = this;
        this.n = 0.9;
        d4 = 0.2;
        object = this;
        this.o = 0.2;
        d4 = BY.a(2.0, -this.m);
        object = this;
        this.p = d4;
    }

    private uO<T> q() {
        return this.k;
    }

    @Override
    private void a(uO<T> uO2) {
        this.k = uO2;
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    protected final void a(uH uH2, uJ uJ2, kO kO2) {
        this.k.f();
        this.k.d();
        uH uH3 = uH2;
        this.k.a(new a(this, uH3.c, (this.l + 3) / 2));
        try {
            this.k.a(uH2, uJ2, kO2);
            throw new oX(px_0.MULTISTEP_STARTER_STOPPED_EARLY, new Object[0]);
        }
        catch (b b2) {
            this.k().d(this.k.j());
            this.k.d();
            return;
        }
    }

    protected abstract sx_0<T> a(T var1, T[] var2, T[][] var3, T[][] var4);

    private double r() {
        return this.o;
    }

    @Override
    private void a(double d2) {
        this.o = 0.2;
    }

    private double s() {
        return this.p;
    }

    private void b(double d2) {
        this.p = d2;
    }

    private double t() {
        return this.n;
    }

    private void c(double d2) {
        this.n = 0.9;
    }

    private int u() {
        return this.l;
    }

    protected final void b(T t) {
        kO kO2 = (kO)t.d(this.m());
        for (int i2 = 0; i2 < this.d.length; ++i2) {
            this.d[i2] = this.d[i2].c((kO)kO2);
        }
        kO[][] kOArray = this.e;
        kOArray = (kO[][])this.e.a;
        kO kO3 = kO2;
        for (int i3 = 0; i3 < kOArray.length; ++i3) {
            kO3 = kO3.c(kO2);
            kO[] kOArray2 = kOArray[i3];
            for (int i4 = 0; i4 < kOArray2.length; ++i4) {
                kOArray2[i4] = kOArray2[i4].c(kO3);
            }
        }
        this.a(t);
    }

    protected final T c(T t) {
        return (T)ci_0.b((kO)((kO)t.c().a()).a(this.p), ci_0.a((kO)((kO)t.c().a()).a(this.o), (kO)((kO)t.g(this.m)).c(this.n)));
    }

    static final class b
    extends RuntimeException {
        private static final long a = -1914085471038046418L;

        b() {
            super((Throwable)null);
        }
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    final class a
    implements wv_0<T> {
        private final uG<T> a;
        private int b;
        private uJ<T> c;
        private final T[] d;
        private final T[][] e;
        private final T[][] f;
        private /* synthetic */ uS g;

        a(uS uS2, uG<T> object, int n2) {
            this.g = uS2;
            this.a = object;
            this.b = 0;
            object = uS2;
            this.d = (kO[])ch_0.a(((uz_0)object).c, n2);
            object = uS2;
            this.e = (kO[][])ch_0.a(((uz_0)object).c, n2, -1);
            object = uS2;
            this.f = (kO[][])ch_0.a(((uz_0)object).c, n2, -1);
        }

        /*
         * Ignored method signature, as it can't be verified against descriptor
         */
        @Override
        public final void a(wr_0 object, boolean bl) {
            Object object2;
            if (this.b == 0) {
                uJ uJ2 = object.c();
                this.c = uJ2;
                object2 = uJ2;
                this.d[this.b] = ((uI)object2).a;
                this.e[this.b] = this.a.a(uJ2);
                this.f[this.b] = this.a.a(uJ2);
            }
            ++this.b;
            uJ uJ3 = object.d();
            object2 = uJ3;
            this.d[this.b] = ((uI)object2).a;
            this.e[this.b] = this.a.a(uJ3);
            this.f[this.b] = this.a.a(uJ3);
            if (this.b == this.d.length - 1) {
                object = (kO)((kO)this.d[this.d.length - 1].b(this.d[0])).d((double)(this.d.length - 1));
                object2 = this.g;
                this.g.b = object;
                object2 = this.g;
                this.g.d = (kO[])ch_0.a(((uz_0)object2).c, this.f[0].length);
                for (int i2 = 0; i2 < this.g.d.length; ++i2) {
                    object2 = this.g;
                    this.g.d[i2] = (kO)this.f[0][i2].c(((uz_0)object2).b);
                }
                object2 = this.g;
                this.g.e = this.g.a((kO)((uz_0)object2).b, (kO[])this.d, (kO[][])this.e, (kO[][])this.f);
                uJ uJ4 = this.c;
                object2 = this.g;
                this.g.a = uJ4;
                throw new b();
            }
        }

        @Override
        public final void a(uJ<T> uJ2, T t) {
        }
    }
}

