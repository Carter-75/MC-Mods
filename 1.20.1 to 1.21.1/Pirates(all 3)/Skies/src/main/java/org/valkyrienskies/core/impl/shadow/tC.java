/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.cq_0;
import org.valkyrienskies.core.impl.shadow.pm_0;
import org.valkyrienskies.core.impl.shadow.px_0;
import org.valkyrienskies.core.impl.shadow.sG;
import org.valkyrienskies.core.impl.shadow.sL;
import org.valkyrienskies.core.impl.shadow.sy_0;
import org.valkyrienskies.core.impl.shadow.td_0;
import org.valkyrienskies.core.impl.shadow.tq_0;
import org.valkyrienskies.core.impl.shadow.tu_0;

public final class tC {
    private static final double b = 2.220446049250313E-16;
    private static final double c = 1.6033346880071782E-291;
    final double[] a;
    private final int d;
    private final int e;
    private final boolean f;
    private final tq_0 g;
    private tq_0 h;
    private tq_0 i;
    private final tq_0 j;
    private tq_0 k;
    private final double l;

    public tC(tq_0 object) {
        int n2;
        double d2;
        int n3;
        int n4;
        double[][] dArray;
        if (object.f() < object.g()) {
            this.f = true;
            dArray = object.d().a();
            this.d = object.g();
            this.e = object.f();
        } else {
            this.f = false;
            dArray = object.a();
            this.d = object.f();
            this.e = object.g();
        }
        this.a = new double[this.e];
        object = new double[this.d][this.e];
        double[][] dArray2 = new double[this.e][this.e];
        double[] dArray3 = new double[this.e];
        double[] dArray4 = new double[this.d];
        int n5 = BY.a(this.d - 1, this.e);
        int n6 = BY.b(0, this.e - 2);
        for (n4 = 0; n4 < BY.b(n5, n6); ++n4) {
            int n7;
            if (n4 < n5) {
                this.a[n4] = 0.0;
                for (n3 = n4; n3 < this.d; ++n3) {
                    this.a[n4] = BY.f(this.a[n4], dArray[n3][n4]);
                }
                if (this.a[n4] != 0.0) {
                    if (dArray[n4][n4] < 0.0) {
                        this.a[n4] = -this.a[n4];
                    }
                    for (n3 = n4; n3 < this.d; ++n3) {
                        double[] dArray5 = dArray[n3];
                        int n8 = n4;
                        dArray5[n8] = dArray5[n8] / this.a[n4];
                    }
                    double[] dArray6 = dArray[n4];
                    int n9 = n4;
                    dArray6[n9] = dArray6[n9] + 1.0;
                }
                this.a[n4] = -this.a[n4];
            }
            for (n3 = n4 + 1; n3 < this.e; ++n3) {
                if (n4 < n5 && this.a[n4] != 0.0) {
                    double d3 = 0.0;
                    for (n7 = n4; n7 < this.d; ++n7) {
                        d3 += dArray[n7][n4] * dArray[n7][n3];
                    }
                    d3 = -d3 / dArray[n4][n4];
                    for (n7 = n4; n7 < this.d; ++n7) {
                        double[] dArray7 = dArray[n7];
                        int n10 = n3;
                        dArray7[n10] = dArray7[n10] + d3 * dArray[n7][n4];
                    }
                }
                dArray3[n3] = dArray[n4][n3];
            }
            if (n4 < n5) {
                for (n3 = n4; n3 < this.d; ++n3) {
                    object[n3][n4] = dArray[n3][n4];
                }
            }
            if (n4 >= n6) continue;
            dArray3[n4] = 0.0;
            for (n3 = n4 + 1; n3 < this.e; ++n3) {
                dArray3[n4] = BY.f(dArray3[n4], dArray3[n3]);
            }
            if (dArray3[n4] != 0.0) {
                if (dArray3[n4 + 1] < 0.0) {
                    dArray3[n4] = -dArray3[n4];
                }
                n3 = n4 + 1;
                while (n3 < this.e) {
                    int n11 = n3++;
                    dArray3[n11] = dArray3[n11] / dArray3[n4];
                }
                int n12 = n4 + 1;
                dArray3[n12] = dArray3[n12] + 1.0;
            }
            dArray3[n4] = -dArray3[n4];
            if (n4 + 1 < this.d && dArray3[n4] != 0.0) {
                for (n3 = n4 + 1; n3 < this.d; ++n3) {
                    dArray4[n3] = 0.0;
                }
                for (n3 = n4 + 1; n3 < this.e; ++n3) {
                    for (int i2 = n4 + 1; i2 < this.d; ++i2) {
                        int n13 = i2;
                        dArray4[n13] = dArray4[n13] + dArray3[n3] * dArray[i2][n3];
                    }
                }
                for (n3 = n4 + 1; n3 < this.e; ++n3) {
                    double d4 = -dArray3[n3] / dArray3[n4 + 1];
                    for (n7 = n4 + 1; n7 < this.d; ++n7) {
                        double[] dArray8 = dArray[n7];
                        int n14 = n3;
                        dArray8[n14] = dArray8[n14] + d4 * dArray4[n7];
                    }
                }
            }
            for (n3 = n4 + 1; n3 < this.e; ++n3) {
                dArray2[n3][n4] = dArray3[n3];
            }
        }
        n4 = this.e;
        if (n5 < this.e) {
            this.a[n5] = dArray[n5][n5];
        }
        if (this.d < n4) {
            this.a[n4 - 1] = 0.0;
        }
        if (n6 + 1 < n4) {
            dArray3[n6] = dArray[n6][n4 - 1];
        }
        dArray3[n4 - 1] = 0.0;
        for (n3 = n5; n3 < this.e; ++n3) {
            for (int i3 = 0; i3 < this.d; ++i3) {
                object[i3][n3] = 0.0;
            }
            object[n3][n3] = 1.0;
        }
        for (n3 = n5 - 1; n3 >= 0; --n3) {
            int n15;
            if (this.a[n3] != 0.0) {
                for (n15 = n3 + 1; n15 < this.e; ++n15) {
                    d2 = 0.0;
                    for (n2 = n3; n2 < this.d; ++n2) {
                        d2 += object[n2][n3] * object[n2][n15];
                    }
                    d2 = -d2 / object[n3][n3];
                    for (n2 = n3; n2 < this.d; ++n2) {
                        Object object2 = object[n2];
                        int n16 = n15;
                        object2[n16] = object2[n16] + d2 * object[n2][n3];
                    }
                }
                for (n15 = n3; n15 < this.d; ++n15) {
                    object[n15][n3] = -object[n15][n3];
                }
                object[n3][n3] = 1.0 + object[n3][n3];
                for (n15 = 0; n15 < n3 - 1; ++n15) {
                    object[n15][n3] = 0.0;
                }
                continue;
            }
            for (n15 = 0; n15 < this.d; ++n15) {
                object[n15][n3] = 0.0;
            }
            object[n3][n3] = 1.0;
        }
        for (n3 = this.e - 1; n3 >= 0; --n3) {
            int n17;
            if (n3 < n6 && dArray3[n3] != 0.0) {
                for (n17 = n3 + 1; n17 < this.e; ++n17) {
                    d2 = 0.0;
                    for (n2 = n3 + 1; n2 < this.e; ++n2) {
                        d2 += dArray2[n2][n3] * dArray2[n2][n17];
                    }
                    d2 = -d2 / dArray2[n3 + 1][n3];
                    for (n2 = n3 + 1; n2 < this.e; ++n2) {
                        double[] dArray9 = dArray2[n2];
                        int n18 = n17;
                        dArray9[n18] = dArray9[n18] + d2 * dArray2[n2][n3];
                    }
                }
            }
            for (n17 = 0; n17 < this.e; ++n17) {
                dArray2[n17][n3] = 0.0;
            }
            dArray2[n3][n3] = 1.0;
        }
        n3 = n4 - 1;
        block34: while (n4 > 0) {
            int n19;
            int n20;
            for (n20 = n4 - 2; n20 >= 0; --n20) {
                double d5 = 1.6033346880071782E-291 + 2.220446049250313E-16 * (BY.w(this.a[n20]) + BY.w(this.a[n20 + 1]));
                if (BY.w(dArray3[n20]) > d5) continue;
                dArray3[n20] = 0.0;
                break;
            }
            if (n20 == n4 - 2) {
                n19 = 4;
            } else {
                int n21;
                for (n21 = n4 - 1; n21 >= n20 && n21 != n20; --n21) {
                    double d6 = (n21 != n4 ? BY.w(dArray3[n21]) : 0.0) + (n21 != n20 + 1 ? BY.w(dArray3[n21 - 1]) : 0.0);
                    if (!(BY.w(this.a[n21]) <= 1.6033346880071782E-291 + d6 * 2.220446049250313E-16)) continue;
                    this.a[n21] = 0.0;
                    break;
                }
                if (n21 == n20) {
                    n19 = 3;
                } else if (n21 == n4 - 1) {
                    n19 = 1;
                } else {
                    n19 = 2;
                    n20 = n21;
                }
            }
            ++n20;
            switch (n19) {
                case 1: {
                    int n22;
                    double d7;
                    double d8;
                    double d9;
                    double d10 = dArray3[n4 - 2];
                    dArray3[n4 - 2] = 0.0;
                    for (int i4 = n4 - 2; i4 >= n20; --i4) {
                        d9 = BY.f(this.a[i4], d10);
                        d8 = this.a[i4] / d9;
                        d7 = d10 / d9;
                        this.a[i4] = d9;
                        if (i4 != n20) {
                            d10 = -d7 * dArray3[i4 - 1];
                            dArray3[i4 - 1] = d8 * dArray3[i4 - 1];
                        }
                        for (n22 = 0; n22 < this.e; ++n22) {
                            d9 = d8 * dArray2[n22][i4] + d7 * dArray2[n22][n4 - 1];
                            dArray2[n22][n4 - 1] = -d7 * dArray2[n22][i4] + d8 * dArray2[n22][n4 - 1];
                            dArray2[n22][i4] = d9;
                        }
                    }
                    continue block34;
                }
                case 2: {
                    int n22;
                    double d7;
                    double d8;
                    double d9;
                    double d11 = dArray3[n20 - 1];
                    dArray3[n20 - 1] = 0.0;
                    for (int i5 = n20; i5 < n4; ++i5) {
                        d9 = BY.f(this.a[i5], d11);
                        d8 = this.a[i5] / d9;
                        d7 = d11 / d9;
                        this.a[i5] = d9;
                        d11 = -d7 * dArray3[i5];
                        dArray3[i5] = d8 * dArray3[i5];
                        for (n22 = 0; n22 < this.d; ++n22) {
                            d9 = d8 * object[n22][i5] + d7 * object[n22][n20 - 1];
                            object[n22][n20 - 1] = -d7 * object[n22][i5] + d8 * object[n22][n20 - 1];
                            object[n22][i5] = d9;
                        }
                    }
                    continue block34;
                }
                case 3: {
                    double d12 = BY.e(BY.w(this.a[n4 - 1]), BY.w(this.a[n4 - 2]));
                    double d13 = BY.e(BY.e(BY.e(d12, BY.w(dArray3[n4 - 2])), BY.w(this.a[n20])), BY.w(dArray3[n20]));
                    double d14 = this.a[n4 - 1] / d13;
                    double d15 = this.a[n4 - 2] / d13;
                    double d16 = dArray3[n4 - 2] / d13;
                    double d17 = this.a[n20] / d13;
                    double d18 = dArray3[n20] / d13;
                    double d19 = d16;
                    double d20 = ((d15 + d14) * (d15 - d14) + d19 * d19) / 2.0;
                    double d21 = d14 * d16 * (d14 * d16);
                    double d22 = 0.0;
                    if (d20 != 0.0 || d21 != 0.0) {
                        double d23 = d20;
                        d22 = BY.a(d23 * d23 + d21);
                        if (d20 < 0.0) {
                            d22 = -d22;
                        }
                        d22 = d21 / (d20 + d22);
                    }
                    double d24 = (d17 + d14) * (d17 - d14) + d22;
                    double d25 = d17 * d18;
                    for (int i6 = n20; i6 < n4 - 1; ++i6) {
                        int n23;
                        double d26 = BY.f(d24, d25);
                        double d27 = d24 / d26;
                        double d28 = d25 / d26;
                        if (i6 != n20) {
                            dArray3[i6 - 1] = d26;
                        }
                        d24 = d27 * this.a[i6] + d28 * dArray3[i6];
                        dArray3[i6] = d27 * dArray3[i6] - d28 * this.a[i6];
                        d25 = d28 * this.a[i6 + 1];
                        this.a[i6 + 1] = d27 * this.a[i6 + 1];
                        for (n23 = 0; n23 < this.e; ++n23) {
                            d26 = d27 * dArray2[n23][i6] + d28 * dArray2[n23][i6 + 1];
                            dArray2[n23][i6 + 1] = -d28 * dArray2[n23][i6] + d27 * dArray2[n23][i6 + 1];
                            dArray2[n23][i6] = d26;
                        }
                        d26 = BY.f(d24, d25);
                        d27 = d24 / d26;
                        d28 = d25 / d26;
                        this.a[i6] = d26;
                        d24 = d27 * dArray3[i6] + d28 * this.a[i6 + 1];
                        this.a[i6 + 1] = -d28 * dArray3[i6] + d27 * this.a[i6 + 1];
                        d25 = d28 * dArray3[i6 + 1];
                        dArray3[i6 + 1] = d27 * dArray3[i6 + 1];
                        if (i6 >= this.d - 1) continue;
                        for (n23 = 0; n23 < this.d; ++n23) {
                            d26 = d27 * object[n23][i6] + d28 * object[n23][i6 + 1];
                            object[n23][i6 + 1] = -d28 * object[n23][i6] + d27 * object[n23][i6 + 1];
                            object[n23][i6] = d26;
                        }
                    }
                    dArray3[n4 - 2] = d24;
                    continue block34;
                }
            }
            if (this.a[n20] <= 0.0) {
                this.a[n20] = this.a[n20] < 0.0 ? -this.a[n20] : 0.0;
                for (int i7 = 0; i7 <= n3; ++i7) {
                    dArray2[i7][n20] = -dArray2[i7][n20];
                }
            }
            while (n20 < n3 && !(this.a[n20] >= this.a[n20 + 1])) {
                int n24;
                Object object3 = this.a[n20];
                this.a[n20] = this.a[n20 + 1];
                this.a[n20 + 1] = object3;
                if (n20 < this.e - 1) {
                    for (n24 = 0; n24 < this.e; ++n24) {
                        object3 = dArray2[n24][n20 + 1];
                        dArray2[n24][n20 + 1] = dArray2[n24][n20];
                        dArray2[n24][n20] = object3;
                    }
                }
                if (n20 < this.d - 1) {
                    for (n24 = 0; n24 < this.d; ++n24) {
                        object3 = object[n24][n20 + 1];
                        object[n24][n20 + 1] = object[n24][n20];
                        object[n24][n20] = object3;
                    }
                }
                ++n20;
            }
            --n4;
        }
        this.l = BY.e((double)this.d * this.a[0] * 2.220446049250313E-16, BY.a(cq_0.b));
        if (!this.f) {
            this.g = td_0.a((double[][])object);
            this.j = td_0.a(dArray2);
            return;
        }
        this.g = td_0.a(dArray2);
        this.j = td_0.a((double[][])object);
    }

    private tq_0 b() {
        return this.g;
    }

    private tq_0 c() {
        if (this.h == null) {
            tC tC2 = this;
            tC2.h = tC2.g.d();
        }
        return this.h;
    }

    private tq_0 d() {
        if (this.i == null) {
            this.i = td_0.a(this.a);
        }
        return this.i;
    }

    private double[] e() {
        return (double[])this.a.clone();
    }

    private tq_0 f() {
        return this.j;
    }

    private tq_0 g() {
        if (this.k == null) {
            tC tC2 = this;
            tC2.k = tC2.j.d();
        }
        return this.k;
    }

    private tq_0 a(double d2) {
        int n2;
        int n3 = this.a.length;
        for (n2 = 0; n2 < n3 && this.a[n2] >= d2; ++n2) {
        }
        if (n2 == 0) {
            throw new pm_0(px_0.TOO_LARGE_CUTOFF_SINGULAR_VALUE, (Number)d2, this.a[0], true);
        }
        Object object = new double[n2][n3];
        tC tC2 = this;
        if (tC2.k == null) {
            tC tC3 = tC2;
            tC3.k = tC3.j.d();
        }
        tC2.k.a(new sL(this, (double[][])object){
            private /* synthetic */ double[][] a;
            private /* synthetic */ tC b;
            {
                this.b = tC2;
                this.a = dArray;
            }

            public final void a(int n2, int n3, double d2) {
                tC tC2 = this.b;
                this.a[n2][n3] = d2 / tC2.a[n2];
            }
        }, 0, n2 - 1, 0, n3 - 1);
        sy_0 sy_02 = new sy_0((double[][])object, false);
        object = sy_02;
        return sy_02.d().c((tq_0)object);
    }

    private double h() {
        return this.a[0];
    }

    private double i() {
        return this.a[0] / this.a[this.e - 1];
    }

    private double j() {
        return this.a[this.e - 1] / this.a[0];
    }

    private int k() {
        int n2 = 0;
        for (int i2 = 0; i2 < this.a.length; ++i2) {
            if (!(this.a[i2] > this.l)) continue;
            ++n2;
        }
        return n2;
    }

    public final a a() {
        tC tC2 = this;
        return new a(this.a, this.c(), tC2.j, this.k() == this.d, this.l, 0);
    }

    static /* synthetic */ double[] a(tC tC2) {
        return tC2.a;
    }

    static final class a
    implements sG {
        private final tq_0 a;
        private boolean b;

        private a(double[] dArray, tq_0 object, tq_0 tq_02, boolean bl, double d2) {
            object = object.a();
            for (int i2 = 0; i2 < dArray.length; ++i2) {
                double d3 = dArray[i2] > d2 ? 1.0 / dArray[i2] : 0.0;
                Object object2 = object[i2];
                int n2 = 0;
                while (n2 < ((Object)object2).length) {
                    Object object3 = object2;
                    int n3 = n2++;
                    object3[n3] = object3[n3] * d3;
                }
            }
            this.a = tq_02.c(new sy_0((double[][])object, false));
            this.b = bl;
        }

        public final tu_0 a(tu_0 tu_02) {
            return this.a.a(tu_02);
        }

        public final tq_0 a(tq_0 tq_02) {
            return this.a.c(tq_02);
        }

        public final boolean a() {
            return this.b;
        }

        public final tq_0 b() {
            return this.a;
        }

        /* synthetic */ a(double[] dArray, tq_0 tq_02, tq_0 tq_03, boolean bl, double d2, byte by) {
            this(dArray, tq_02, tq_03, bl, d2);
        }
    }
}

