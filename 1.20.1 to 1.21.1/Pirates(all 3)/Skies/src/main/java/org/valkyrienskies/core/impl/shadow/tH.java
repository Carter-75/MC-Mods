/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.cf_0;
import org.valkyrienskies.core.impl.shadow.ci_0;
import org.valkyrienskies.core.impl.shadow.oV;
import org.valkyrienskies.core.impl.shadow.pu_0;
import org.valkyrienskies.core.impl.shadow.sA;
import org.valkyrienskies.core.impl.shadow.sJ;
import org.valkyrienskies.core.impl.shadow.sX;
import org.valkyrienskies.core.impl.shadow.tB;
import org.valkyrienskies.core.impl.shadow.tf_0;
import org.valkyrienskies.core.impl.shadow.tg_0;
import org.valkyrienskies.core.impl.shadow.tm_0;
import org.valkyrienskies.core.impl.shadow.tp_0;
import org.valkyrienskies.core.impl.shadow.tu_0;

public final class tH
extends tm_0 {
    private static final String a = "operator";
    private static final String b = "threshold";
    private static final String c = "vector";
    private static final String d = "vector1";
    private static final String e = "vector2";
    private final boolean f;
    private final double g;

    private tH(int n2, double d2, boolean bl) {
        super(n2);
        this.g = d2;
        this.f = bl;
    }

    private tH(cf_0 cf_02, double d2, boolean bl) {
        super(cf_02);
        this.g = d2;
        this.f = bl;
    }

    private boolean b() {
        return this.f;
    }

    public final tu_0 a(tp_0 tp_02, tp_0 tp_03, tu_0 tu_02) {
        ci_0.a(tp_02);
        sA sA2 = new sA(tp_02.g());
        return this.a(tp_02, tp_03, tu_02, (tu_0)((Object)sA2), false, 0.0);
    }

    private tu_0 a(tp_0 tp_02, tp_0 tp_03, tu_0 tu_02, boolean bl, double d2) {
        ci_0.a(tp_02);
        sA sA2 = new sA(tp_02.g());
        return this.a(tp_02, tp_03, tu_02, (tu_0)((Object)sA2), bl, d2);
    }

    public final tu_0 b(tp_0 tp_02, tp_0 tp_03, tu_0 tu_02, tu_0 tu_03) {
        ci_0.a(tu_03);
        return this.a(tp_02, tp_03, tu_02, tu_03.j(), false, 0.0);
    }

    public final tu_0 a(tp_0 tp_02, tu_0 tu_02) {
        ci_0.a(tp_02);
        sA sA2 = new sA(tp_02.g());
        ((tu_0)((Object)sA2)).f(0.0);
        return this.a(tp_02, null, tu_02, (tu_0)((Object)sA2), false, 0.0);
    }

    private tu_0 a(tp_0 tp_02, tu_0 tu_02, boolean bl, double d2) {
        ci_0.a(tp_02);
        sA sA2 = new sA(tp_02.g());
        return this.a(tp_02, null, tu_02, (tu_0)((Object)sA2), bl, d2);
    }

    public final tu_0 b(tp_0 tp_02, tu_0 tu_02, tu_0 tu_03) {
        ci_0.a(tu_03);
        return this.a(tp_02, null, tu_02, tu_03.j(), false, 0.0);
    }

    public final tu_0 a(tp_0 tp_02, tp_0 tp_03, tu_0 tu_02, tu_0 tu_03) {
        return this.a(tp_02, tp_03, tu_02, tu_03, false, 0.0);
    }

    /*
     * Unable to fully structure code
     */
    private tu_0 a(tp_0 var1_1, tp_0 var2_2, tu_0 var3_3, tu_0 var4_4, boolean var5_5, double var6_6) {
        tH.c((tp_0)var1_1, (tp_0)var2_2, var3_3, var4_4);
        var8_7 = this.a();
        var8_7.c();
        var9_8 = var8_7;
        var9_8 = var9_8.a;
        var9_8.d(1);
        var1_1 = new a((tp_0)var1_1, (tp_0)var2_2, var3_3, var5_5, var6_6, this.g, this.f);
        var1_1.a();
        var1_1.a(var4_4);
        var9_8 = var8_7;
        v0 = var9_8.a;
        var9_8 = v0;
        var9_8 = var1_1;
        var2_2 = new sJ(this, v0.e, var4_4, var3_3, var9_8.b);
        var9_8 = var1_1;
        if (var9_8.c) {
            var8_7.d((sJ)var2_2);
            return var4_4;
        }
        if (var1_1.e()) ** GOTO lbl-1000
        var9_8 = var1_1;
        if (var9_8.a) lbl-1000:
        // 2 sources

        {
            v1 = true;
        } else {
            v1 = false;
        }
        var5_5 = v1;
        var8_7.a((sJ)var2_2);
        if (!var5_5) {
            do {
                var9_8 = var8_7;
                var9_8 = var9_8.a;
                var9_8.d(1);
                var9_8 = var8_7;
                v2 = var9_8.a;
                var9_8 = v2;
                var9_8 = var1_1;
                var2_2 = new sJ(this, v2.e, var4_4, var3_3, var9_8.b);
                var8_7.c((sJ)var2_2);
                var1_1.b();
                var1_1.a(var4_4);
                var9_8 = var8_7;
                v3 = var9_8.a;
                var9_8 = v3;
                var9_8 = var1_1;
                var2_2 = new sJ(this, v3.e, var4_4, var3_3, var9_8.b);
                var8_7.b((sJ)var2_2);
                var9_8 = var1_1;
            } while (!var9_8.a);
        }
        var9_8 = var8_7;
        v4 = var9_8.a;
        var9_8 = v4;
        var9_8 = var1_1;
        var2_2 = new sJ(this, v4.e, var4_4, var3_3, var9_8.b);
        var8_7.d((sJ)var2_2);
        return var4_4;
    }

    public final tu_0 c(tp_0 tp_02, tu_0 tu_02, tu_0 tu_03) {
        return this.a(tp_02, null, tu_02, tu_03, false, 0.0);
    }

    static final class a {
        private static double d;
        private static double e;
        private final tp_0 f;
        private final tu_0 g;
        private final boolean h;
        private final double i;
        private double j;
        private double k;
        private double l;
        private double m;
        private double n;
        private double o;
        private double p;
        private double q;
        private double r;
        private final boolean s;
        boolean a;
        private double t;
        private final tp_0 u;
        private double v;
        private final tu_0 w;
        private double x;
        private tu_0 y;
        private tu_0 z;
        double b;
        private final double A;
        private double B;
        private double C;
        private tu_0 D;
        private final sA E;
        private tu_0 F;
        private double G;
        boolean c;

        a(tp_0 tp_02, tp_0 tp_03, tu_0 tu_02, boolean bl, double d2, double d3, boolean bl2) {
            this.f = tp_02;
            this.u = tp_03;
            this.g = tu_02;
            this.E = new sA(tu_02.f());
            this.s = bl;
            this.A = d2;
            this.w = tp_03 == null ? tu_02 : tp_03.a(tu_02);
            this.a = false;
            this.h = bl2;
            this.i = d3;
        }

        private static void a(tp_0 tp_02, tu_0 tu_02, tu_0 tu_03, tu_0 object) {
            tu_0 tu_04 = tu_03;
            double d2 = tu_04.b(tu_04);
            double d3 = tu_02.b((tu_0)object);
            double d4 = (d2 + e) * d;
            if (BY.w(d2 - d3) > d4) {
                object = new tg_0();
                Serializable serializable = object;
                serializable = ((oV)object).a;
                ((pu_0)serializable).a(tH.a, tp_02);
                ((pu_0)serializable).a(tH.d, tu_02);
                ((pu_0)serializable).a(tH.e, tu_03);
                ((pu_0)serializable).a(tH.b, d4);
                throw object;
            }
        }

        private static void a(tp_0 tp_02, tu_0 tu_02) {
            tf_0 tf_02 = new tf_0();
            Serializable serializable = tf_02;
            serializable = tf_02.a;
            ((pu_0)serializable).a(tH.a, tp_02);
            ((pu_0)serializable).a(tH.c, tu_02);
            throw tf_02;
        }

        private static void a(double d2, tu_0 tu_02, tu_0 tu_03) {
            int n2 = tu_02.f();
            for (int i2 = 0; i2 < n2; ++i2) {
                tu_03.a(i2, d2 * tu_02.a(i2) + tu_03.a(i2));
            }
        }

        private static void a(double d2, tu_0 tu_02, double d3, tu_0 tu_03, tu_0 tu_04) {
            int n2 = tu_04.f();
            for (int i2 = 0; i2 < n2; ++i2) {
                double d4 = d2 * tu_02.a(i2) + d3 * tu_03.a(i2) + tu_04.a(i2);
                tu_04.a(i2, d4);
            }
        }

        final void a(tu_0 tu_02) {
            int n2 = ((tu_0)((Object)this.E)).f();
            if (this.t < this.m) {
                if (!this.s) {
                    tu_02.a(0, (tu_0)((Object)this.E));
                    return;
                }
                double d2 = this.l / this.k;
                for (int i2 = 0; i2 < n2; ++i2) {
                    double d3 = this.w.a(i2);
                    double d4 = ((tu_0)((Object)this.E)).a(i2);
                    tu_02.a(i2, d4 + d2 * d3);
                }
                return;
            }
            double d5 = BY.a(this.C);
            double d6 = this.p == 0.0 ? d5 * e : this.p;
            double d7 = this.o / d6;
            double d8 = (this.l + this.B * d7) / this.k;
            if (!this.s) {
                for (int i3 = 0; i3 < n2; ++i3) {
                    double d9 = ((tu_0)((Object)this.E)).a(i3);
                    double d10 = this.D.a(i3);
                    tu_02.a(i3, d9 + d7 * d10);
                }
                return;
            }
            for (int i4 = 0; i4 < n2; ++i4) {
                double d11 = ((tu_0)((Object)this.E)).a(i4);
                double d12 = this.D.a(i4);
                double d13 = this.w.a(i4);
                tu_02.a(i4, d11 + d7 * d12 + d8 * d13);
            }
        }

        final void a() {
            ((tu_0)((Object)this.E)).f(0.0);
            this.y = this.g.j();
            tu_0 tu_02 = this.F = this.u == null ? this.g.j() : this.u.a(this.y);
            if (this.u != null && this.h) {
                org.valkyrienskies.core.impl.shadow.tH$a.a(this.u, this.y, this.F, (tu_0)((Object)this.u.a(this.F)));
            }
            this.k = this.y.b(this.F);
            if (this.k < 0.0) {
                org.valkyrienskies.core.impl.shadow.tH$a.a(this.u, this.F);
            }
            if (this.k == 0.0) {
                this.c = true;
                return;
            }
            this.c = false;
            this.k = BY.a(this.k);
            tu_0 tu_03 = this.F.h(1.0 / this.k);
            this.F = this.f.a(tu_03);
            if (this.h) {
                org.valkyrienskies.core.impl.shadow.tH$a.a(this.f, tu_03, this.F, (tu_0)((Object)this.f.a(this.F)));
            }
            org.valkyrienskies.core.impl.shadow.tH$a.a(-this.A, tu_03, this.F);
            double d2 = tu_03.b(this.F);
            org.valkyrienskies.core.impl.shadow.tH$a.a(-d2 / this.k, this.y, this.F);
            double d3 = tu_03.b(this.F);
            tu_0 tu_04 = tu_03;
            double d4 = tu_04.b(tu_04);
            org.valkyrienskies.core.impl.shadow.tH$a.a(-d3 / d4, tu_03, this.F);
            this.z = this.F.j();
            if (this.u != null) {
                this.F = this.u.a(this.z);
            }
            this.x = this.k;
            this.j = this.z.b(this.F);
            if (this.j < 0.0) {
                org.valkyrienskies.core.impl.shadow.tH$a.a(this.u, this.F);
            }
            this.j = BY.a(this.j);
            this.m = this.k;
            this.p = d2;
            this.n = this.j;
            this.o = this.k;
            this.v = 0.0;
            this.l = 0.0;
            this.B = 1.0;
            double d5 = d2;
            this.C = d5 * d5 + this.j * this.j;
            this.G = 0.0;
            this.r = this.q = BY.w(d2) + e;
            if (this.s) {
                this.D = new sA(this.f.f());
                this.D.f(0.0);
            } else {
                this.D = tu_03;
            }
            this.g();
        }

        final void b() {
            tu_0 tu_02 = this.F.h(1.0 / this.j);
            this.F = this.f.a(tu_02);
            org.valkyrienskies.core.impl.shadow.tH$a.a(-this.A, tu_02, -this.j / this.x, this.y, this.F);
            double d2 = tu_02.b(this.F);
            org.valkyrienskies.core.impl.shadow.tH$a.a(-d2 / this.j, this.z, this.F);
            this.y = this.z;
            this.z = this.F;
            if (this.u != null) {
                this.F = this.u.a(this.z);
            }
            this.x = this.j;
            this.j = this.z.b(this.F);
            if (this.j < 0.0) {
                org.valkyrienskies.core.impl.shadow.tH$a.a(this.u, this.F);
            }
            this.j = BY.a(this.j);
            double d3 = d2;
            this.C += d3 * d3 + this.x * this.x + this.j * this.j;
            double d4 = BY.a(this.p * this.p + this.x * this.x);
            double d5 = this.p / d4;
            double d6 = this.x / d4;
            double d7 = d5 * this.n + d6 * d2;
            this.p = d6 * this.n - d5 * d2;
            double d8 = d6 * this.j;
            this.n = -d5 * this.j;
            double d9 = this.o / d4;
            double d10 = d9 * d5;
            double d11 = d9 * d6;
            int n2 = ((tu_0)((Object)this.E)).f();
            for (int i2 = 0; i2 < n2; ++i2) {
                double d12 = ((tu_0)((Object)this.E)).a(i2);
                double d13 = tu_02.a(i2);
                double d14 = this.D.a(i2);
                ((tu_0)((Object)this.E)).a(i2, d12 + d14 * d10 + d13 * d11);
                this.D.a(i2, d14 * d6 - d13 * d5);
            }
            this.l += this.B * d5 * d9;
            this.B *= d6;
            this.q = BY.e(this.q, d4);
            this.r = BY.d(this.r, d4);
            double d15 = d9;
            this.G += d15 * d15;
            this.o = this.v - d7 * d9;
            this.v = -d8 * d9;
            this.g();
        }

        private void g() {
            double d2 = BY.a(this.C);
            double d3 = BY.a(this.G);
            double d4 = d2 * e;
            double d5 = d2 * d3 * e;
            double d6 = d2 * d3 * this.i;
            double d7 = this.p == 0.0 ? d4 : this.p;
            this.t = BY.a(this.o * this.o + this.v * this.v);
            double d8 = this.B * this.k;
            this.m = d8 * this.j / BY.w(d7);
            double d9 = this.t <= this.m ? this.q / this.r : this.q / BY.d(this.r, BY.w(d7));
            if (d9 * e >= 0.1) {
                throw new sX(d9);
            }
            if (this.k <= d5) {
                throw new tB();
            }
            this.b = BY.d(this.m, this.t);
            this.a = this.m <= d5 || this.m <= d6;
        }

        final boolean c() {
            return this.a;
        }

        final boolean d() {
            return this.c;
        }

        final boolean e() {
            return this.j < e;
        }

        final double f() {
            return this.b;
        }

        static {
            e = BY.x(1.0);
            d = BY.t(e);
        }
    }
}

