/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.valkyrienskies.core.impl.shadow.vi
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.lc_0;
import org.valkyrienskies.core.impl.shadow.nI;
import org.valkyrienskies.core.impl.shadow.nO;
import org.valkyrienskies.core.impl.shadow.nP;
import org.valkyrienskies.core.impl.shadow.nr_0;
import org.valkyrienskies.core.impl.shadow.nx_0;
import org.valkyrienskies.core.impl.shadow.pc_0;
import org.valkyrienskies.core.impl.shadow.uE;
import org.valkyrienskies.core.impl.shadow.uF;
import org.valkyrienskies.core.impl.shadow.vh_0;
import org.valkyrienskies.core.impl.shadow.vi;
import org.valkyrienskies.core.impl.shadow.wB;
import org.valkyrienskies.core.impl.shadow.ws_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.vi
 */
public final class vi_0 {
    public final vh_0 a;
    private final double k;
    public final double b;
    private final int l;
    public uF c;
    public double d;
    public double e;
    public boolean f;
    public boolean g;
    public double h;
    private double m;
    private boolean n;
    private boolean o;
    public int i;
    public final nO j;

    public vi_0(vh_0 vh_02, double d2, double d3, int n2, nO nO2) {
        this.a = vh_02;
        this.k = d2;
        this.b = BY.w(d3);
        this.l = n2;
        this.j = nO2;
        this.c = null;
        this.d = Double.NaN;
        this.e = Double.NaN;
        this.f = true;
        this.g = false;
        this.h = Double.NaN;
        this.m = Double.NaN;
        this.o = true;
        this.i = vh_0.a.CONTINUE$534a8113;
    }

    public final vh_0 a() {
        return this.a;
    }

    public final void a(uF uF2) {
        this.c = uF2;
    }

    private double d() {
        return this.k;
    }

    private double e() {
        return this.b;
    }

    private int f() {
        return this.l;
    }

    public final void a(ws_0 ws_02) {
        vi_0 vi_02;
        this.d = ws_02.g();
        ws_02.d(this.d);
        this.e = this.a.a(this.d, this.a((wB)ws_02));
        if (this.e == 0.0) {
            double d2 = BY.e(this.j.g(), BY.w(this.j.h() * this.d));
            double d3 = this.d + d2 * 0.5;
            ws_02.d(d3);
            this.e = this.a.a(d3, this.a((wB)ws_02));
        }
        this.f = vi_02.e >= 0.0;
    }

    public double[] a(wB wB2) {
        double[] dArray = new double[this.c.b()];
        uF uF2 = this.c;
        uF2.b.b(wB2.k(), dArray);
        int n2 = 0;
        for (uE uE2 : this.c.d()) {
            uE2.b(wB2.a(n2++), dArray);
        }
        return dArray;
    }

    public final boolean b(ws_0 serializable) {
        try {
            double d2;
            this.n = serializable.j();
            double d3 = serializable.h();
            double d4 = d3 - this.d;
            if (BY.w(d2) < this.b) {
                return false;
            }
            int n2 = BY.b(1, (int)BY.z(BY.w(d4) / this.k));
            double d5 = d4 / (double)n2;
            lc_0 lc_02 = new lc_0(this, (wB)serializable){
                private /* synthetic */ wB a;
                private /* synthetic */ vi_0 b;
                {
                    this.b = vi_02;
                    this.a = wB2;
                }

                public final double a(double d2) {
                    try {
                        this.a.d(d2);
                        vi_0 vi_02 = this.b;
                        vi_0 vi_03 = vi_02;
                        wB wB2 = this.a;
                        vi_03 = this.b;
                        return ((vi)vi_02).a.a(d2, vi_03.a(wB2));
                    }
                    catch (pc_0 pc_02) {
                        throw new a(pc_02);
                    }
                }
            };
            double d6 = this.d;
            double d7 = this.e;
            for (int i2 = 0; i2 < n2; ++i2) {
                double d8 = i2 == n2 - 1 ? d3 : this.d + (double)(i2 + 1) * d5;
                serializable.d(d8);
                double d9 = this.a.a(d8, this.a((wB)serializable));
                if (this.f ^ d9 >= 0.0) {
                    double d10;
                    boolean bl = this.o = d9 >= d7;
                    if (this.j instanceof nx_0) {
                        nx_0 nx_02 = (nx_0)((Object)this.j);
                        d10 = this.n ? nx_02.a(this.l, lc_02, d6, d8, nr_0.RIGHT_SIDE$37d0779) : nx_02.a(this.l, lc_02, d8, d6, nr_0.LEFT_SIDE$37d0779);
                    } else {
                        double d11 = this.n ? this.j.a(this.l, lc_02, d6, d8) : this.j.a(this.l, lc_02, d8, d6);
                        int n3 = this.l - this.j.c();
                        nI nI2 = new nI(this.j.h(), this.j.g());
                        double d12 = d10 = this.n ? nP.a(n3, lc_02, nI2, d11, d6, d8, nr_0.RIGHT_SIDE$37d0779) : nP.a(n3, lc_02, nI2, d11, d8, d6, nr_0.LEFT_SIDE$37d0779);
                    }
                    if (!Double.isNaN(this.m) && BY.w(d10 - d6) <= this.b && BY.w(d10 - this.m) <= this.b) {
                        while (this.f ^ (d7 = lc_02.a(d6 = this.n ? d6 + this.b : d6 - this.b)) >= 0.0 && this.n ^ d6 >= d8) {
                        }
                        if (this.n ^ d6 >= d8) {
                            --i2;
                            continue;
                        }
                        this.h = d10;
                        this.g = true;
                        return true;
                    }
                    if (Double.isNaN(this.m) || BY.w(this.m - d10) > this.b) {
                        this.h = d10;
                        this.g = true;
                        return true;
                    }
                    d6 = d8;
                    d7 = d9;
                    continue;
                }
                d6 = d8;
                d7 = d9;
            }
            this.g = false;
            this.h = Double.NaN;
            return false;
        }
        catch (a a2) {
            a a3 = a2;
            serializable = a2;
            throw a2.a;
        }
    }

    public final double b() {
        if (this.g) {
            return this.h;
        }
        if (this.n) {
            return Double.POSITIVE_INFINITY;
        }
        return Double.NEGATIVE_INFINITY;
    }

    public final void a(double d2, double[] dArray) {
        vi_0 vi_02;
        this.d = d2;
        this.e = this.a.a(d2, dArray);
        if (this.g && BY.w(this.h - d2) <= this.b) {
            this.m = d2;
            this.f = this.o;
            this.i = this.a.b(d2, dArray);
            return;
        }
        this.f = vi_02.e >= 0.0;
        this.i = vh_0.a.CONTINUE$534a8113;
    }

    public final boolean c() {
        return this.i == vh_0.a.STOP$534a8113;
    }

    public final boolean b(double d2, double[] dArray) {
        if (!this.g || !(BY.w(this.h - d2) <= this.b)) {
            return false;
        }
        if (this.i == vh_0.a.RESET_STATE$534a8113) {
        }
        this.g = false;
        this.h = Double.NaN;
        return this.i == vh_0.a.RESET_STATE$534a8113 || this.i == vh_0.a.RESET_DERIVATIVES$534a8113;
    }

    static /* synthetic */ double[] a(vi_0 vi_02, wB wB2) {
        return vi_02.a(wB2);
    }

    static /* synthetic */ vh_0 a(vi_0 vi_02) {
        return vi_02.a;
    }

    static final class a
    extends RuntimeException {
        private static final long b = 20120901L;
        final pc_0 a;

        a(pc_0 pc_02) {
            this.a = pc_02;
        }

        public final pc_0 a() {
            return this.a;
        }
    }
}

