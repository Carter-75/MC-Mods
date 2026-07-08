/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.cq_0;
import org.valkyrienskies.core.impl.shadow.pc_0;
import org.valkyrienskies.core.impl.shadow.px_0;
import org.valkyrienskies.core.impl.shadow.sW;
import org.valkyrienskies.core.impl.shadow.td_0;
import org.valkyrienskies.core.impl.shadow.th_0;
import org.valkyrienskies.core.impl.shadow.tq_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.tz
 */
final class tz_0 {
    private static final int a = 100;
    private final double[][] b;
    private final double[][] c;
    private tq_0 d;
    private tq_0 e;
    private tq_0 f;
    private final double g = cq_0.a;

    tz_0(tq_0 object) {
        int n2;
        int n3;
        if (!object.e()) {
            throw new th_0(object.f(), object.g());
        }
        Object object2 = object = new sW((tq_0)object);
        if (((sW)object2).b == null) {
            n3 = ((sW)object2).a.length;
            double[][] dArray = new double[n3][n3];
            for (int i2 = 0; i2 < n3; ++i2) {
                if (i2 > 0) {
                    dArray[i2][i2 - 1] = ((sW)object2).a[i2][i2 - 1];
                }
                for (int i3 = i2; i3 < n3; ++i3) {
                    dArray[i2][i3] = ((sW)object2).a[i2][i3];
                }
            }
            ((sW)object2).b = td_0.a(dArray);
        }
        this.c = ((sW)object2).b.a();
        this.b = ((sW)object).a().a();
        this.e = null;
        this.d = null;
        this.f = null;
        object2 = this;
        n3 = ((tz_0)object2).c.length;
        Object object3 = object2;
        double d2 = 0.0;
        for (n2 = 0; n2 < ((tz_0)object3).c.length; ++n2) {
            for (int i4 = BY.b(n2 - 1, 0); i4 < ((tz_0)object3).c.length; ++i4) {
                d2 += BY.w(((tz_0)object3).c[n2][i4]);
            }
        }
        double d3 = d2;
        a a2 = new a(0);
        int n4 = 0;
        int n5 = n3 - 1;
        while (n5 >= 0) {
            int n6;
            int n7;
            int n8;
            double d4;
            int n9;
            double d5 = d3;
            int n10 = n5;
            object3 = object2;
            for (n9 = n10; n9 > 0; --n9) {
                d4 = BY.w(((tz_0)object3).c[n9 - 1][n9 - 1]) + BY.w(((tz_0)object3).c[n9][n9]);
                if (d4 == 0.0) {
                    d4 = d5;
                }
                if (BY.w(((tz_0)object3).c[n9][n9 - 1]) < ((tz_0)object3).g * d4) break;
            }
            if ((n8 = n9) == n5) {
                double[] dArray = ((tz_0)object2).c[n5];
                int n11 = n5--;
                dArray[n11] = dArray[n11] + a2.d;
                n4 = 0;
                continue;
            }
            if (n8 == n5 - 1) {
                double d6 = (((tz_0)object2).c[n5 - 1][n5 - 1] - ((tz_0)object2).c[n5][n5]) / 2.0;
                double d7 = d6 * d6 + ((tz_0)object2).c[n5][n5 - 1] * ((tz_0)object2).c[n5 - 1][n5];
                double[] dArray = ((tz_0)object2).c[n5];
                int n12 = n5;
                dArray[n12] = dArray[n12] + a2.d;
                double[] dArray2 = ((tz_0)object2).c[n5 - 1];
                int n13 = n5 - 1;
                dArray2[n13] = dArray2[n13] + a2.d;
                if (d7 >= 0.0) {
                    double d8 = BY.a(BY.w(d7));
                    d8 = d6 >= 0.0 ? d6 + d8 : d6 - d8;
                    double d9 = ((tz_0)object2).c[n5][n5 - 1];
                    double d10 = BY.w(d9) + BY.w(d8);
                    d6 = d9 / d10;
                    d7 = d8 / d10;
                    double d11 = d6;
                    double d12 = d7;
                    double d13 = BY.a(d11 * d11 + d12 * d12);
                    d6 /= d13;
                    d7 /= d13;
                    for (n4 = n5 - 1; n4 < n3; ++n4) {
                        d8 = ((tz_0)object2).c[n5 - 1][n4];
                        ((tz_0)object2).c[n5 - 1][n4] = d7 * d8 + d6 * ((tz_0)object2).c[n5][n4];
                        ((tz_0)object2).c[n5][n4] = d7 * ((tz_0)object2).c[n5][n4] - d6 * d8;
                    }
                    for (n4 = 0; n4 <= n5; ++n4) {
                        d8 = ((tz_0)object2).c[n4][n5 - 1];
                        ((tz_0)object2).c[n4][n5 - 1] = d7 * d8 + d6 * ((tz_0)object2).c[n4][n5];
                        ((tz_0)object2).c[n4][n5] = d7 * ((tz_0)object2).c[n4][n5] - d6 * d8;
                    }
                    for (n4 = 0; n4 <= n3 - 1; ++n4) {
                        d8 = ((tz_0)object2).b[n4][n5 - 1];
                        ((tz_0)object2).b[n4][n5 - 1] = d7 * d8 + d6 * ((tz_0)object2).b[n4][n5];
                        ((tz_0)object2).b[n4][n5] = d7 * ((tz_0)object2).b[n4][n5] - d6 * d8;
                    }
                }
                n5 -= 2;
                n4 = 0;
                continue;
            }
            Object object4 = a2;
            n2 = n4;
            int n14 = n5;
            n10 = n8;
            object3 = object2;
            ((a)object4).a = ((tz_0)object3).c[n14][n14];
            a a3 = object4;
            a3.c = 0.0;
            a3.b = 0.0;
            if (n10 < n14) {
                ((a)object4).b = ((tz_0)object3).c[n14 - 1][n14 - 1];
                ((a)object4).c = ((tz_0)object3).c[n14][n14 - 1] * ((tz_0)object3).c[n14 - 1][n14];
            }
            if (n2 == 10) {
                ((a)object4).d += ((a)object4).a;
                int n15 = 0;
                while (n15 <= n14) {
                    double[] dArray = ((tz_0)object3).c[n15];
                    int n16 = n15++;
                    dArray[n16] = dArray[n16] - ((a)object4).a;
                }
                double d14 = BY.w(((tz_0)object3).c[n14][n14 - 1]) + BY.w(((tz_0)object3).c[n14 - 1][n14 - 2]);
                ((a)object4).a = d14 * 0.75;
                ((a)object4).b = d14 * 0.75;
                ((a)object4).c = d14 * -0.4375 * d14;
            }
            if (n2 == 30) {
                double d15;
                d4 = (((a)object4).b - ((a)object4).a) / 2.0;
                d4 = d4 * d4 + ((a)object4).c;
                if (d15 > 0.0) {
                    d4 = BY.a(d4);
                    if (((a)object4).b < ((a)object4).a) {
                        d4 = -d4;
                    }
                    d4 = ((a)object4).a - ((a)object4).c / ((((a)object4).b - ((a)object4).a) / 2.0 + d4);
                    int n17 = 0;
                    while (n17 <= n14) {
                        double[] dArray = ((tz_0)object3).c[n17];
                        int n18 = n17++;
                        dArray[n18] = dArray[n18] - d4;
                    }
                    ((a)object4).d += d4;
                    Object object5 = object4;
                    ((a)object4).c = 0.964;
                    ((a)object5).b = 0.964;
                    ((a)object5).a = 0.964;
                }
            }
            if (++n4 > 100) {
                throw new pc_0(px_0.CONVERGENCE_FAILED, 100, new Object[0]);
            }
            double[] dArray = new double[3];
            object4 = dArray;
            a a4 = a2;
            n14 = n5;
            n10 = n8;
            object3 = object2;
            for (n7 = n14 - 2; n7 >= n10; --n7) {
                double d16;
                double d17;
                double d18 = ((tz_0)object3).c[n7][n7];
                double d19 = a4.a - d18;
                double d20 = a4.b - d18;
                object4[0] = (d19 * d20 - a4.c) / ((tz_0)object3).c[n7 + 1][n7] + ((tz_0)object3).c[n7][n7 + 1];
                object4[1] = ((tz_0)object3).c[n7 + 1][n7 + 1] - d18 - d19 - d20;
                object4[2] = ((tz_0)object3).c[n7 + 2][n7 + 1];
                if (n7 == n10 || (d17 = BY.w(((tz_0)object3).c[n7][n7 - 1]) * (BY.w((double)object4[1]) + BY.w((double)object4[2]))) < ((tz_0)object3).g * (d16 = BY.w((double)object4[0]) * (BY.w(((tz_0)object3).c[n7 - 1][n7 - 1]) + BY.w(d18) + BY.w(((tz_0)object3).c[n7 + 1][n7 + 1])))) break;
            }
            int n19 = n7;
            double[] dArray3 = dArray;
            object4 = a2;
            n2 = n5;
            n14 = n19;
            n10 = n8;
            object3 = object2;
            int n20 = ((tz_0)object3).c.length;
            double d21 = dArray3[0];
            double d22 = dArray3[1];
            double d23 = dArray3[2];
            for (n6 = n14; n6 <= n2 - 1; ++n6) {
                boolean bl;
                boolean bl2 = bl = n6 != n2 - 1;
                if (n6 != n14) {
                    d21 = ((tz_0)object3).c[n6][n6 - 1];
                    d22 = ((tz_0)object3).c[n6 + 1][n6 - 1];
                    d23 = bl ? ((tz_0)object3).c[n6 + 2][n6 - 1] : 0.0;
                    ((a)object4).a = BY.w(d21) + BY.w(d22) + BY.w(d23);
                    if (cq_0.b(((a)object4).a, 0.0, ((tz_0)object3).g)) continue;
                    d21 /= ((a)object4).a;
                    d22 /= ((a)object4).a;
                    d23 /= ((a)object4).a;
                }
                double d24 = d21;
                double d25 = d22;
                double d26 = d23;
                double d27 = BY.a(d24 * d24 + d25 * d25 + d26 * d26);
                if (d21 < 0.0) {
                    d27 = -d27;
                }
                if (d27 == 0.0) continue;
                if (n6 != n14) {
                    ((tz_0)object3).c[n6][n6 - 1] = -d27 * ((a)object4).a;
                } else if (n10 != n14) {
                    ((tz_0)object3).c[n6][n6 - 1] = -((tz_0)object3).c[n6][n6 - 1];
                }
                ((a)object4).a = (d21 += d27) / d27;
                ((a)object4).b = d22 / d27;
                double d28 = d23 / d27;
                d22 /= d21;
                d23 /= d21;
                n8 = n6;
                while (n8 < n20) {
                    d21 = ((tz_0)object3).c[n6][n8] + d22 * ((tz_0)object3).c[n6 + 1][n8];
                    if (bl) {
                        double[] dArray4 = ((tz_0)object3).c[n6 + 2];
                        int n21 = n8;
                        dArray4[n21] = dArray4[n21] - (d21 += d23 * ((tz_0)object3).c[n6 + 2][n8]) * d28;
                    }
                    double[] dArray5 = ((tz_0)object3).c[n6];
                    int n22 = n8;
                    dArray5[n22] = dArray5[n22] - d21 * ((a)object4).a;
                    double[] dArray6 = ((tz_0)object3).c[n6 + 1];
                    int n23 = n8++;
                    dArray6[n23] = dArray6[n23] - d21 * ((a)object4).b;
                }
                for (n8 = 0; n8 <= BY.a(n2, n6 + 3); ++n8) {
                    d21 = ((a)object4).a * ((tz_0)object3).c[n8][n6] + ((a)object4).b * ((tz_0)object3).c[n8][n6 + 1];
                    if (bl) {
                        double[] dArray7 = ((tz_0)object3).c[n8];
                        int n24 = n6 + 2;
                        dArray7[n24] = dArray7[n24] - (d21 += d28 * ((tz_0)object3).c[n8][n6 + 2]) * d23;
                    }
                    double[] dArray8 = ((tz_0)object3).c[n8];
                    int n25 = n6;
                    dArray8[n25] = dArray8[n25] - d21;
                    double[] dArray9 = ((tz_0)object3).c[n8];
                    int n26 = n6 + 1;
                    dArray9[n26] = dArray9[n26] - d21 * d22;
                }
                n8 = ((tz_0)object3).c.length - 1;
                for (int i5 = 0; i5 <= n8; ++i5) {
                    d21 = ((a)object4).a * ((tz_0)object3).b[i5][n6] + ((a)object4).b * ((tz_0)object3).b[i5][n6 + 1];
                    if (bl) {
                        double[] dArray10 = ((tz_0)object3).b[i5];
                        int n27 = n6 + 2;
                        dArray10[n27] = dArray10[n27] - (d21 += d28 * ((tz_0)object3).b[i5][n6 + 2]) * d23;
                    }
                    double[] dArray11 = ((tz_0)object3).b[i5];
                    int n28 = n6;
                    dArray11[n28] = dArray11[n28] - d21;
                    double[] dArray12 = ((tz_0)object3).b[i5];
                    int n29 = n6 + 1;
                    dArray12[n29] = dArray12[n29] - d21 * d22;
                }
            }
            for (n6 = n14 + 2; n6 <= n2; ++n6) {
                ((tz_0)object3).c[n6][n6 - 2] = 0.0;
                if (n6 <= n14 + 2) continue;
                ((tz_0)object3).c[n6][n6 - 3] = 0.0;
            }
        }
    }

    public final tq_0 a() {
        if (this.d == null) {
            this.d = td_0.a(this.b);
        }
        return this.d;
    }

    private tq_0 c() {
        if (this.f == null) {
            this.f = this.a().d();
        }
        return this.f;
    }

    public final tq_0 b() {
        if (this.e == null) {
            this.e = td_0.a(this.c);
        }
        return this.e;
    }

    private void d() {
        int n2 = this.c.length;
        double d2 = this.e();
        a a2 = new a(0);
        int n3 = 0;
        int n4 = n2 - 1;
        while (n4 >= 0) {
            int n5 = this.a(n4, d2);
            if (n5 == n4) {
                double[] dArray = this.c[n4];
                int n6 = n4--;
                dArray[n6] = dArray[n6] + a2.d;
                n3 = 0;
                continue;
            }
            if (n5 == n4 - 1) {
                double d3 = (this.c[n4 - 1][n4 - 1] - this.c[n4][n4]) / 2.0;
                double d4 = d3 * d3 + this.c[n4][n4 - 1] * this.c[n4 - 1][n4];
                double[] dArray = this.c[n4];
                int n7 = n4;
                dArray[n7] = dArray[n7] + a2.d;
                double[] dArray2 = this.c[n4 - 1];
                int n8 = n4 - 1;
                dArray2[n8] = dArray2[n8] + a2.d;
                if (d4 >= 0.0) {
                    double d5 = BY.a(BY.w(d4));
                    d5 = d3 >= 0.0 ? d3 + d5 : d3 - d5;
                    double d6 = this.c[n4][n4 - 1];
                    double d7 = BY.w(d6) + BY.w(d5);
                    d3 = d6 / d7;
                    d4 = d5 / d7;
                    double d8 = d3;
                    double d9 = d4;
                    double d10 = BY.a(d8 * d8 + d9 * d9);
                    d3 /= d10;
                    d4 /= d10;
                    for (n3 = n4 - 1; n3 < n2; ++n3) {
                        d5 = this.c[n4 - 1][n3];
                        this.c[n4 - 1][n3] = d4 * d5 + d3 * this.c[n4][n3];
                        this.c[n4][n3] = d4 * this.c[n4][n3] - d3 * d5;
                    }
                    for (n3 = 0; n3 <= n4; ++n3) {
                        d5 = this.c[n3][n4 - 1];
                        this.c[n3][n4 - 1] = d4 * d5 + d3 * this.c[n3][n4];
                        this.c[n3][n4] = d4 * this.c[n3][n4] - d3 * d5;
                    }
                    for (n3 = 0; n3 <= n2 - 1; ++n3) {
                        d5 = this.b[n3][n4 - 1];
                        this.b[n3][n4 - 1] = d4 * d5 + d3 * this.b[n3][n4];
                        this.b[n3][n4] = d4 * this.b[n3][n4] - d3 * d5;
                    }
                }
                n4 -= 2;
                n3 = 0;
                continue;
            }
            this.a(n5, n4, n3, a2);
            if (++n3 > 100) {
                throw new pc_0(px_0.CONVERGENCE_FAILED, 100, new Object[0]);
            }
            double[] dArray = new double[3];
            int n9 = this.a(n5, n4, a2, dArray);
            this.a(n5, n9, n4, a2, dArray);
        }
    }

    private double e() {
        double d2 = 0.0;
        for (int i2 = 0; i2 < this.c.length; ++i2) {
            for (int i3 = BY.b(i2 - 1, 0); i3 < this.c.length; ++i3) {
                d2 += BY.w(this.c[i2][i3]);
            }
        }
        return d2;
    }

    private int a(int n2, double d2) {
        while (n2 > 0) {
            double d3 = BY.w(this.c[n2 - 1][n2 - 1]) + BY.w(this.c[n2][n2]);
            if (d3 == 0.0) {
                d3 = d2;
            }
            if (BY.w(this.c[n2][n2 - 1]) < this.g * d3) break;
            --n2;
        }
        return n2;
    }

    private void a(int n2, int n3, int n4, a a2) {
        double d2;
        a2.a = this.c[n3][n3];
        a a3 = a2;
        a3.c = 0.0;
        a3.b = 0.0;
        if (n2 < n3) {
            a2.b = this.c[n3 - 1][n3 - 1];
            a2.c = this.c[n3][n3 - 1] * this.c[n3 - 1][n3];
        }
        if (n4 == 10) {
            a2.d += a2.a;
            int n5 = 0;
            while (n5 <= n3) {
                double[] dArray = this.c[n5];
                int n6 = n5++;
                dArray[n6] = dArray[n6] - a2.a;
            }
            d2 = BY.w(this.c[n3][n3 - 1]) + BY.w(this.c[n3 - 1][n3 - 2]);
            a2.a = d2 * 0.75;
            a2.b = d2 * 0.75;
            a2.c = d2 * -0.4375 * d2;
        }
        if (n4 == 30) {
            double d3;
            d2 = (a2.b - a2.a) / 2.0;
            d2 = d2 * d2 + a2.c;
            if (d3 > 0.0) {
                d2 = BY.a(d2);
                if (a2.b < a2.a) {
                    d2 = -d2;
                }
                d2 = a2.a - a2.c / ((a2.b - a2.a) / 2.0 + d2);
                n2 = 0;
                while (n2 <= n3) {
                    double[] dArray = this.c[n2];
                    int n7 = n2++;
                    dArray[n7] = dArray[n7] - d2;
                }
                a2.d += d2;
                a a4 = a2;
                a2.c = 0.964;
                a4.b = 0.964;
                a4.a = 0.964;
            }
        }
    }

    private int a(int n2, int n3, a a2, double[] dArray) {
        n3 -= 2;
        while (n3 >= n2) {
            double d2;
            double d3;
            double d4 = this.c[n3][n3];
            double d5 = a2.a - d4;
            double d6 = a2.b - d4;
            dArray[0] = (d5 * d6 - a2.c) / this.c[n3 + 1][n3] + this.c[n3][n3 + 1];
            dArray[1] = this.c[n3 + 1][n3 + 1] - d4 - d5 - d6;
            dArray[2] = this.c[n3 + 2][n3 + 1];
            if (n3 == n2 || (d3 = BY.w(this.c[n3][n3 - 1]) * (BY.w(dArray[1]) + BY.w(dArray[2]))) < this.g * (d2 = BY.w(dArray[0]) * (BY.w(this.c[n3 - 1][n3 - 1]) + BY.w(d4) + BY.w(this.c[n3 + 1][n3 + 1])))) break;
            --n3;
        }
        return n3;
    }

    private void a(int n2, int n3, int n4, a a2, double[] dArray) {
        int n5;
        int n6 = this.c.length;
        double d2 = dArray[0];
        double d3 = dArray[1];
        double d4 = dArray[2];
        for (n5 = n3; n5 <= n4 - 1; ++n5) {
            boolean bl;
            boolean bl2 = bl = n5 != n4 - 1;
            if (n5 != n3) {
                d2 = this.c[n5][n5 - 1];
                d3 = this.c[n5 + 1][n5 - 1];
                d4 = bl ? this.c[n5 + 2][n5 - 1] : 0.0;
                a2.a = BY.w(d2) + BY.w(d3) + BY.w(d4);
                if (cq_0.b(a2.a, 0.0, this.g)) continue;
                d2 /= a2.a;
                d3 /= a2.a;
                d4 /= a2.a;
            }
            double d5 = d2;
            double d6 = d3;
            double d7 = d4;
            double d8 = BY.a(d5 * d5 + d6 * d6 + d7 * d7);
            if (d2 < 0.0) {
                d8 = -d8;
            }
            if (d8 == 0.0) continue;
            if (n5 != n3) {
                this.c[n5][n5 - 1] = -d8 * a2.a;
            } else if (n2 != n3) {
                this.c[n5][n5 - 1] = -this.c[n5][n5 - 1];
            }
            a2.a = (d2 += d8) / d8;
            a2.b = d3 / d8;
            double d9 = d4 / d8;
            d3 /= d2;
            d4 /= d2;
            int n7 = n5;
            while (n7 < n6) {
                d2 = this.c[n5][n7] + d3 * this.c[n5 + 1][n7];
                if (bl) {
                    double[] dArray2 = this.c[n5 + 2];
                    int n8 = n7;
                    dArray2[n8] = dArray2[n8] - (d2 += d4 * this.c[n5 + 2][n7]) * d9;
                }
                double[] dArray3 = this.c[n5];
                int n9 = n7;
                dArray3[n9] = dArray3[n9] - d2 * a2.a;
                double[] dArray4 = this.c[n5 + 1];
                int n10 = n7++;
                dArray4[n10] = dArray4[n10] - d2 * a2.b;
            }
            for (n7 = 0; n7 <= BY.a(n4, n5 + 3); ++n7) {
                d2 = a2.a * this.c[n7][n5] + a2.b * this.c[n7][n5 + 1];
                if (bl) {
                    double[] dArray5 = this.c[n7];
                    int n11 = n5 + 2;
                    dArray5[n11] = dArray5[n11] - (d2 += d9 * this.c[n7][n5 + 2]) * d4;
                }
                double[] dArray6 = this.c[n7];
                int n12 = n5;
                dArray6[n12] = dArray6[n12] - d2;
                double[] dArray7 = this.c[n7];
                int n13 = n5 + 1;
                dArray7[n13] = dArray7[n13] - d2 * d3;
            }
            n7 = this.c.length - 1;
            for (int i2 = 0; i2 <= n7; ++i2) {
                d2 = a2.a * this.b[i2][n5] + a2.b * this.b[i2][n5 + 1];
                if (bl) {
                    double[] dArray8 = this.b[i2];
                    int n14 = n5 + 2;
                    dArray8[n14] = dArray8[n14] - (d2 += d9 * this.b[i2][n5 + 2]) * d4;
                }
                double[] dArray9 = this.b[i2];
                int n15 = n5;
                dArray9[n15] = dArray9[n15] - d2;
                double[] dArray10 = this.b[i2];
                int n16 = n5 + 1;
                dArray10[n16] = dArray10[n16] - d2 * d3;
            }
        }
        for (n5 = n3 + 2; n5 <= n4; ++n5) {
            this.c[n5][n5 - 2] = 0.0;
            if (n5 <= n3 + 2) continue;
            this.c[n5][n5 - 3] = 0.0;
        }
    }

    static final class 1 {
    }

    static final class a {
        double a;
        double b;
        double c;
        double d;

        private a() {
        }

        /* synthetic */ a(byte by) {
            this();
        }
    }
}

