/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.oX;
import org.valkyrienskies.core.impl.shadow.pn_0;
import org.valkyrienskies.core.impl.shadow.pw_0;
import org.valkyrienskies.core.impl.shadow.px_0;
import org.valkyrienskies.core.impl.shadow.sy_0;
import org.valkyrienskies.core.impl.shadow.uA;
import org.valkyrienskies.core.impl.shadow.uE;
import org.valkyrienskies.core.impl.shadow.uF;
import org.valkyrienskies.core.impl.shadow.uM;
import org.valkyrienskies.core.impl.shadow.uP;
import org.valkyrienskies.core.impl.shadow.vI;
import org.valkyrienskies.core.impl.shadow.vx_0;
import org.valkyrienskies.core.impl.shadow.wA;
import org.valkyrienskies.core.impl.shadow.ws_0;

public abstract class uT
extends vx_0 {
    protected double[] f;
    protected sy_0 g;
    private uP m;
    private final int n;
    private double o;
    private double p;
    private double q;
    private double r;

    public uT(String object, int n2, int n3, double d2, double d3, double d4, double d5) {
        super((String)object, d2, d3, d4, d5);
        if (n2 < 2) {
            throw new pn_0((pw_0)px_0.INTEGRATION_METHOD_NEEDS_AT_LEAST_TWO_PREVIOUS_POINTS, (Number)n2, 2, true);
        }
        this.m = new vI(d2, d3, d4, d5);
        this.n = n2;
        this.o = -1.0 / (double)n3;
        double d6 = 0.9;
        object = this;
        this.p = 0.9;
        d6 = 0.2;
        object = this;
        this.q = 0.2;
        d6 = BY.a(2.0, -this.o);
        object = this;
        this.r = d6;
    }

    public uT(String object, int n2, int n3, double d2, double d3, double[] dArray, double[] dArray2) {
        super((String)object, d2, d3, dArray, dArray2);
        this.m = new vI(d2, d3, dArray, dArray2);
        this.n = n2;
        this.o = -1.0 / (double)n3;
        double d4 = 0.9;
        object = this;
        this.p = 0.9;
        d4 = 0.2;
        object = this;
        this.q = 0.2;
        d4 = BY.a(2.0, -this.o);
        object = this;
        this.r = d4;
    }

    private uP n() {
        return this.m;
    }

    private void a(uP uP2) {
        this.m = uP2;
    }

    protected final void b(double d2, double[] dArray, double d3) {
        this.m.e();
        this.m.c();
        uT uT2 = this;
        this.m.a(new b(uT2, (uT2.n + 3) / 2, dArray.length));
        try {
            if (this.m instanceof uA) {
                ((uA)this.m).a(this.j(), d3);
            } else {
                this.m.a(new uM(this){
                    private /* synthetic */ uT a;
                    {
                        this.a = uT2;
                    }

                    public final int a() {
                        uT uT2 = this.a;
                        return uT2.e.b();
                    }

                    public final void a(double d2, double[] dArray, double[] dArray2) {
                        uT uT2 = this.a;
                        uT2.e.a(d2, dArray, dArray2);
                    }
                }, d2, dArray, d3, new double[dArray.length]);
            }
            throw new oX(px_0.MULTISTEP_STARTER_STOPPED_EARLY, new Object[0]);
        }
        catch (a a2) {
            this.k().d(this.m.i());
            this.m.c();
            return;
        }
    }

    protected abstract sy_0 a(double var1, double[] var3, double[][] var4, double[][] var5);

    private double o() {
        return this.q;
    }

    private void b(double d2) {
        this.q = 0.2;
    }

    private double p() {
        return this.r;
    }

    private void c(double d2) {
        this.r = d2;
    }

    private double q() {
        return this.p;
    }

    private void d(double d2) {
        this.p = 0.9;
    }

    private int r() {
        return this.n;
    }

    protected final double a(double d2) {
        return BY.d(this.r, BY.e(this.q, this.p * BY.a(d2, this.o)));
    }

    static final class a
    extends RuntimeException {
        private static final long a = -1914085471038046418L;

        a() {
            super((Throwable)null);
        }
    }

    final class b
    implements wA {
        private int a = 0;
        private final double[] b;
        private final double[][] c;
        private final double[][] d;
        private /* synthetic */ uT e;

        b(uT uT2, int n2, int n3) {
            this.e = uT2;
            this.b = new double[n2];
            this.c = new double[n2][n3];
            this.d = new double[n2][n3];
        }

        public final void a(ws_0 ws_02, boolean bl) {
            double d2 = ws_02.g();
            double d3 = ws_02.h();
            if (this.a == 0) {
                ws_02.d(d2);
                this.b[0] = d2;
                Object object = this.e;
                uE[] uEArray = ((uA)object).e;
                object = ((uA)object).e;
                object = ((uF)object).b;
                ((uE)object).b(ws_02.k(), this.c[this.a]);
                ((uE)object).b(ws_02.l(), this.d[this.a]);
                int n2 = 0;
                for (uE uE2 : uEArray.d()) {
                    uE2.b(ws_02.a(n2), this.c[this.a]);
                    uE2.b(ws_02.b(n2), this.d[this.a]);
                    ++n2;
                }
            }
            ++this.a;
            ws_02.d(d3);
            this.b[this.a] = d3;
            Object object = this.e;
            uE[] uEArray = ((uA)object).e;
            object = ((uA)object).e;
            object = ((uF)object).b;
            ((uE)object).b(ws_02.k(), this.c[this.a]);
            ((uE)object).b(ws_02.l(), this.d[this.a]);
            int n3 = 0;
            for (uE uE2 : uEArray.d()) {
                uE2.b(ws_02.a(n3), this.c[this.a]);
                uE2.b(ws_02.b(n3), this.d[this.a]);
                ++n3;
            }
            if (this.a == this.b.length - 1) {
                this.e.a = this.b[0];
                this.e.b = (this.b[this.b.length - 1] - this.b[0]) / (double)(this.b.length - 1);
                this.e.f = (double[])this.d[0].clone();
                int n4 = 0;
                while (n4 < this.e.f.length) {
                    int n5 = n4++;
                    this.e.f[n5] = this.e.f[n5] * this.e.b;
                }
                this.e.g = this.e.a(this.e.b, this.b, this.c, this.d);
                throw new a();
            }
        }

        public final void a(double d2, double[] dArray, double d3) {
        }
    }

    @Deprecated
    public static interface c {
        public sy_0 a();
    }
}

