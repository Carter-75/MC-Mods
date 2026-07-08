/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.oS;
import org.valkyrienskies.core.impl.shadow.sA;
import org.valkyrienskies.core.impl.shadow.sG;
import org.valkyrienskies.core.impl.shadow.sy_0;
import org.valkyrienskies.core.impl.shadow.tA;
import org.valkyrienskies.core.impl.shadow.td_0;
import org.valkyrienskies.core.impl.shadow.th_0;
import org.valkyrienskies.core.impl.shadow.tq_0;
import org.valkyrienskies.core.impl.shadow.tu_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.tb
 */
public final class tb_0 {
    private static final double a = 1.0E-11;
    private final double[][] b;
    private final int[] c;
    private boolean d;
    private boolean e;
    private tq_0 f;
    private tq_0 g;
    private tq_0 h;

    public tb_0(tq_0 tq_02) {
        this(tq_02, 1.0E-11);
    }

    public tb_0(tq_0 tq_02, double d2) {
        if (!tq_02.e()) {
            throw new th_0(tq_02.f(), tq_02.g());
        }
        int n2 = tq_02.g();
        this.b = tq_02.a();
        this.c = new int[n2];
        this.f = null;
        this.g = null;
        this.h = null;
        int n3 = 0;
        while (n3 < n2) {
            int n4 = n3++;
            this.c[n4] = n4;
        }
        this.d = true;
        this.e = false;
        for (n3 = 0; n3 < n2; ++n3) {
            int n5;
            int n6;
            for (n6 = 0; n6 < n3; ++n6) {
                double[] dArray = this.b[n6];
                double d3 = dArray[n3];
                for (int i2 = 0; i2 < n6; ++i2) {
                    d3 -= dArray[i2] * this.b[i2][n3];
                }
                dArray[n3] = d3;
            }
            n6 = n3;
            double d4 = Double.NEGATIVE_INFINITY;
            for (int i3 = n3; i3 < n2; ++i3) {
                double[] dArray = this.b[i3];
                double d5 = dArray[n3];
                for (n5 = 0; n5 < n3; ++n5) {
                    d5 -= dArray[n5] * this.b[n5][n3];
                }
                dArray[n3] = d5;
                if (!(BY.w(d5) > d4)) continue;
                d4 = BY.w(d5);
                n6 = i3;
            }
            if (BY.w(this.b[n6][n3]) < 1.0E-11) {
                this.e = true;
                return;
            }
            if (n6 != n3) {
                double[] dArray = this.b[n6];
                double[] dArray2 = this.b[n3];
                for (n5 = 0; n5 < n2; ++n5) {
                    double d6 = dArray[n5];
                    dArray[n5] = dArray2[n5];
                    dArray2[n5] = d6;
                }
                n5 = this.c[n6];
                this.c[n6] = this.c[n3];
                this.c[n3] = n5;
                this.d = !this.d;
            }
            double d7 = this.b[n3][n3];
            for (int i4 = n3 + 1; i4 < n2; ++i4) {
                double[] dArray = this.b[i4];
                int n7 = n3;
                dArray[n7] = dArray[n7] / d7;
            }
        }
    }

    private tq_0 b() {
        if (this.f == null && !this.e) {
            int n2;
            int n3 = n2 = this.c.length;
            this.f = td_0.a(n3, n3);
            int n4 = 0;
            while (n4 < n2) {
                double[] dArray = this.b[n4];
                for (int i2 = 0; i2 < n4; ++i2) {
                    this.f.c(n4, i2, dArray[i2]);
                }
                int n5 = n4++;
                this.f.c(n5, n5, 1.0);
            }
        }
        return this.f;
    }

    private tq_0 c() {
        if (this.g == null && !this.e) {
            int n2;
            int n3 = n2 = this.c.length;
            this.g = td_0.a(n3, n3);
            for (int i2 = 0; i2 < n2; ++i2) {
                double[] dArray = this.b[i2];
                for (int i3 = i2; i3 < n2; ++i3) {
                    this.g.c(i2, i3, dArray[i3]);
                }
            }
        }
        return this.g;
    }

    private tq_0 d() {
        if (this.h == null && !this.e) {
            int n2;
            int n3 = n2 = this.c.length;
            this.h = td_0.a(n3, n3);
            for (int i2 = 0; i2 < n2; ++i2) {
                this.h.c(i2, this.c[i2], 1.0);
            }
        }
        return this.h;
    }

    private int[] e() {
        return (int[])this.c.clone();
    }

    private double f() {
        if (this.e) {
            return 0.0;
        }
        int n2 = this.c.length;
        double d2 = this.d ? 1.0 : -1.0;
        for (int i2 = 0; i2 < n2; ++i2) {
            d2 *= this.b[i2][i2];
        }
        return d2;
    }

    public final a a() {
        return new a(this.b, this.c, this.e, 0);
    }

    static final class 1 {
    }

    static final class a
    implements sG {
        private final double[][] a;
        private final int[] b;
        private final boolean c;

        private a(double[][] dArray, int[] nArray, boolean bl) {
            this.a = dArray;
            this.b = nArray;
            this.c = bl;
        }

        public final boolean a() {
            return !this.c;
        }

        public final tu_0 a(tu_0 tu_02) {
            double d2;
            int n2;
            int n3 = this.b.length;
            if (tu_02.f() != n3) {
                throw new oS(tu_02.f(), n3);
            }
            if (this.c) {
                throw new tA();
            }
            double[] dArray = new double[n3];
            for (n2 = 0; n2 < n3; ++n2) {
                dArray[n2] = tu_02.a(this.b[n2]);
            }
            for (n2 = 0; n2 < n3; ++n2) {
                d2 = dArray[n2];
                for (int i2 = n2 + 1; i2 < n3; ++i2) {
                    int n4 = i2;
                    dArray[n4] = dArray[n4] - d2 * this.a[i2][n2];
                }
            }
            for (n2 = n3 - 1; n2 >= 0; --n2) {
                int n5 = n2;
                dArray[n5] = dArray[n5] / this.a[n2][n2];
                d2 = dArray[n2];
                for (int i3 = 0; i3 < n2; ++i3) {
                    int n6 = i3;
                    dArray[n6] = dArray[n6] - d2 * this.a[i3][n2];
                }
            }
            return new sA(dArray, false);
        }

        public final tq_0 a(tq_0 tq_02) {
            int n2;
            double[] dArray;
            int n3;
            int n4 = this.b.length;
            if (tq_02.f() != n4) {
                throw new oS(tq_02.f(), n4);
            }
            if (this.c) {
                throw new tA();
            }
            int n5 = tq_02.g();
            double[][] dArray2 = new double[n4][n5];
            for (n3 = 0; n3 < n4; ++n3) {
                dArray = dArray2[n3];
                n2 = this.b[n3];
                for (int i2 = 0; i2 < n5; ++i2) {
                    dArray[i2] = tq_02.b(n2, i2);
                }
            }
            for (n3 = 0; n3 < n4; ++n3) {
                dArray = dArray2[n3];
                for (n2 = n3 + 1; n2 < n4; ++n2) {
                    double[] dArray3 = dArray2[n2];
                    double d2 = this.a[n2][n3];
                    for (int i3 = 0; i3 < n5; ++i3) {
                        int n6 = i3;
                        dArray3[n6] = dArray3[n6] - dArray[i3] * d2;
                    }
                }
            }
            for (n3 = n4 - 1; n3 >= 0; --n3) {
                dArray = dArray2[n3];
                double d3 = this.a[n3][n3];
                int n7 = 0;
                while (n7 < n5) {
                    int n8 = n7++;
                    dArray[n8] = dArray[n8] / d3;
                }
                for (n7 = 0; n7 < n3; ++n7) {
                    double[] dArray4 = dArray2[n7];
                    double d4 = this.a[n7][n3];
                    for (int i4 = 0; i4 < n5; ++i4) {
                        int n9 = i4;
                        dArray4[n9] = dArray4[n9] - dArray[i4] * d4;
                    }
                }
            }
            return new sy_0(dArray2, false);
        }

        public final tq_0 b() {
            a a2 = this;
            return a2.a(td_0.a(a2.b.length));
        }

        /* synthetic */ a(double[][] dArray, int[] nArray, boolean bl, byte by) {
            this(dArray, nArray, bl);
        }
    }
}

