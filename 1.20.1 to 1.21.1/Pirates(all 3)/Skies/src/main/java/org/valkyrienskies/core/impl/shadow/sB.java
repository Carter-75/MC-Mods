/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.td_0;
import org.valkyrienskies.core.impl.shadow.tq_0;

final class sB {
    private final double[][] a;
    private final double[] b;
    private final double[] c;
    private tq_0 d;
    private tq_0 e;
    private tq_0 f;

    private sB(tq_0 object) {
        int n2 = object.f();
        int n3 = object.g();
        int n4 = BY.a(n2, n3);
        this.a = object.a();
        this.b = new double[n4];
        this.c = new double[n4 - 1];
        this.d = null;
        this.e = null;
        this.f = null;
        if (n2 >= n3) {
            object = this;
            n2 = ((sB)object).a.length;
            n3 = ((sB)object).a[0].length;
            for (n4 = 0; n4 < n3; ++n4) {
                double d2;
                double d3;
                int n5;
                double[] dArray;
                double d4;
                double d5 = 0.0;
                for (int i2 = n4; i2 < n2; ++i2) {
                    double d6 = d4 = ((sB)object).a[i2][n4];
                    d5 += d6 * d6;
                }
                double[] dArray2 = ((sB)object).a[n4];
                ((sB)object).b[n4] = d4 = dArray[n4] > 0.0 ? -BY.a(d5) : BY.a(d5);
                if (d4 != 0.0) {
                    int n6 = n4;
                    dArray2[n6] = dArray2[n6] - d4;
                    for (n5 = n4 + 1; n5 < n3; ++n5) {
                        double[] dArray3;
                        int n7;
                        d3 = 0.0;
                        for (n7 = n4; n7 < n2; ++n7) {
                            dArray3 = ((sB)object).a[n7];
                            d3 -= dArray3[n5] * dArray3[n4];
                        }
                        d3 /= d4 * ((sB)object).a[n4][n4];
                        for (n7 = n4; n7 < n2; ++n7) {
                            double[] dArray4 = ((sB)object).a[n7];
                            dArray3 = dArray4;
                            int n8 = n5;
                            dArray4[n8] = dArray4[n8] - d3 * dArray3[n4];
                        }
                    }
                }
                if (n4 >= n3 - 1) continue;
                d5 = 0.0;
                for (n5 = n4 + 1; n5 < n3; ++n5) {
                    double d7 = d3 = dArray2[n5];
                    d5 += d7 * d7;
                }
                ((sB)object).c[n4] = d2 = dArray2[n4 + 1] > 0.0 ? -BY.a(d5) : BY.a(d5);
                if (d2 == 0.0) continue;
                int n9 = n4 + 1;
                dArray2[n9] = dArray2[n9] - d2;
                for (int i3 = n4 + 1; i3 < n2; ++i3) {
                    int n10;
                    double[] dArray5 = ((sB)object).a[i3];
                    double d8 = 0.0;
                    for (n10 = n4 + 1; n10 < n3; ++n10) {
                        d8 -= dArray5[n10] * dArray2[n10];
                    }
                    d8 /= d2 * dArray2[n4 + 1];
                    for (n10 = n4 + 1; n10 < n3; ++n10) {
                        int n11 = n10;
                        dArray5[n11] = dArray5[n11] - d8 * dArray2[n10];
                    }
                }
            }
            return;
        }
        object = this;
        n2 = ((sB)object).a.length;
        n3 = ((sB)object).a[0].length;
        for (n4 = 0; n4 < n2; ++n4) {
            double d9;
            double d10;
            double d11;
            double[] dArray = ((sB)object).a[n4];
            double d12 = 0.0;
            for (int i4 = n4; i4 < n3; ++i4) {
                double d13;
                double d14 = d13 = dArray[i4];
                d12 += d14 * d14;
            }
            ((sB)object).b[n4] = d11 = dArray[n4] > 0.0 ? -BY.a(d12) : BY.a(d12);
            if (d11 != 0.0) {
                int n12 = n4;
                dArray[n12] = dArray[n12] - d11;
                for (int i5 = n4 + 1; i5 < n2; ++i5) {
                    int n13;
                    double[] dArray6 = ((sB)object).a[i5];
                    d10 = 0.0;
                    for (n13 = n4; n13 < n3; ++n13) {
                        d10 -= dArray6[n13] * dArray[n13];
                    }
                    d10 /= d11 * ((sB)object).a[n4][n4];
                    for (n13 = n4; n13 < n3; ++n13) {
                        int n14 = n13;
                        dArray6[n14] = dArray6[n14] - d10 * dArray[n13];
                    }
                }
            }
            if (n4 >= n2 - 1) continue;
            double[] dArray7 = ((sB)object).a[n4 + 1];
            d12 = 0.0;
            for (int i6 = n4 + 1; i6 < n2; ++i6) {
                double d15 = d10 = ((sB)object).a[i6][n4];
                d12 += d15 * d15;
            }
            ((sB)object).c[n4] = d9 = dArray7[n4] > 0.0 ? -BY.a(d12) : BY.a(d12);
            if (d9 == 0.0) continue;
            int n15 = n4;
            dArray7[n15] = dArray7[n15] - d9;
            for (int i7 = n4 + 1; i7 < n3; ++i7) {
                double[] dArray8;
                int n16;
                double d16 = 0.0;
                for (n16 = n4 + 1; n16 < n2; ++n16) {
                    dArray8 = ((sB)object).a[n16];
                    d16 -= dArray8[i7] * dArray8[n4];
                }
                d16 /= d9 * dArray7[n4];
                for (n16 = n4 + 1; n16 < n2; ++n16) {
                    double[] dArray9 = ((sB)object).a[n16];
                    dArray8 = dArray9;
                    int n17 = i7;
                    dArray9[n17] = dArray9[n17] - d16 * dArray8[n4];
                }
            }
        }
    }

    private tq_0 a() {
        if (this.d == null) {
            int n2;
            int n3 = this.a.length;
            int n4 = this.a[0].length;
            int n5 = this.b.length;
            int n6 = n3 >= n4 ? 0 : 1;
            double[] dArray = n3 >= n4 ? this.b : this.c;
            int n7 = n3;
            double[][] dArray2 = new double[n7][n7];
            for (n2 = n3 - 1; n2 >= n5; --n2) {
                dArray2[n2][n2] = 1.0;
            }
            for (n2 = n5 - 1; n2 >= n6; --n2) {
                double[] dArray3 = this.a[n2];
                dArray2[n2][n2] = 1.0;
                if (dArray3[n2 - n6] == 0.0) continue;
                for (int i2 = n2; i2 < n3; ++i2) {
                    int n8;
                    double d2 = 0.0;
                    for (n8 = n2; n8 < n3; ++n8) {
                        d2 -= dArray2[n8][i2] * this.a[n8][n2 - n6];
                    }
                    d2 /= dArray[n2 - n6] * dArray3[n2 - n6];
                    for (n8 = n2; n8 < n3; ++n8) {
                        double[] dArray4 = dArray2[n8];
                        int n9 = i2;
                        dArray4[n9] = dArray4[n9] + -d2 * this.a[n8][n2 - n6];
                    }
                }
            }
            if (n6 > 0) {
                dArray2[0][0] = 1.0;
            }
            this.d = td_0.a(dArray2);
        }
        return this.d;
    }

    private tq_0 b() {
        if (this.e == null) {
            int n2 = this.a.length;
            int n3 = this.a[0].length;
            double[][] dArray = new double[n2][n3];
            for (int i2 = 0; i2 < this.b.length; ++i2) {
                dArray[i2][i2] = this.b[i2];
                if (n2 < n3) {
                    if (i2 <= 0) continue;
                    dArray[i2][i2 - 1] = this.c[i2 - 1];
                    continue;
                }
                if (i2 >= this.b.length - 1) continue;
                dArray[i2][i2 + 1] = this.c[i2];
            }
            this.e = td_0.a(dArray);
        }
        return this.e;
    }

    private tq_0 c() {
        if (this.f == null) {
            int n2;
            int n3 = this.a.length;
            int n4 = this.a[0].length;
            int n5 = this.b.length;
            int n6 = n3 >= n4 ? 1 : 0;
            double[] dArray = n3 >= n4 ? this.c : this.b;
            int n7 = n4;
            double[][] dArray2 = new double[n7][n7];
            for (n2 = n4 - 1; n2 >= n5; --n2) {
                dArray2[n2][n2] = 1.0;
            }
            for (n2 = n5 - 1; n2 >= n6; --n2) {
                double[] dArray3 = this.a[n2 - n6];
                dArray2[n2][n2] = 1.0;
                if (dArray3[n2] == 0.0) continue;
                for (int i2 = n2; i2 < n4; ++i2) {
                    int n8;
                    double d2 = 0.0;
                    for (n8 = n2; n8 < n4; ++n8) {
                        d2 -= dArray2[n8][i2] * dArray3[n8];
                    }
                    d2 /= dArray[n2 - n6] * dArray3[n2];
                    for (n8 = n2; n8 < n4; ++n8) {
                        double[] dArray4 = dArray2[n8];
                        int n9 = i2;
                        dArray4[n9] = dArray4[n9] + -d2 * dArray3[n8];
                    }
                }
            }
            if (n6 > 0) {
                dArray2[0][0] = 1.0;
            }
            this.f = td_0.a(dArray2);
        }
        return this.f;
    }

    private double[][] d() {
        return this.a;
    }

    private double[] e() {
        return this.b;
    }

    private double[] f() {
        return this.c;
    }

    private boolean g() {
        return this.a.length >= this.a[0].length;
    }

    private void h() {
        int n2 = this.a.length;
        int n3 = this.a[0].length;
        for (int i2 = 0; i2 < n3; ++i2) {
            double d2;
            double d3;
            int n4;
            double[] dArray;
            double d4;
            double d5 = 0.0;
            for (int i3 = i2; i3 < n2; ++i3) {
                double d6 = d4 = this.a[i3][i2];
                d5 += d6 * d6;
            }
            double[] dArray2 = this.a[i2];
            this.b[i2] = d4 = dArray[i2] > 0.0 ? -BY.a(d5) : BY.a(d5);
            if (d4 != 0.0) {
                int n5 = i2;
                dArray2[n5] = dArray2[n5] - d4;
                for (n4 = i2 + 1; n4 < n3; ++n4) {
                    double[] dArray3;
                    int n6;
                    d3 = 0.0;
                    for (n6 = i2; n6 < n2; ++n6) {
                        dArray3 = this.a[n6];
                        d3 -= dArray3[n4] * dArray3[i2];
                    }
                    d3 /= d4 * this.a[i2][i2];
                    for (n6 = i2; n6 < n2; ++n6) {
                        double[] dArray4 = this.a[n6];
                        dArray3 = dArray4;
                        int n7 = n4;
                        dArray4[n7] = dArray4[n7] - d3 * dArray3[i2];
                    }
                }
            }
            if (i2 >= n3 - 1) continue;
            d5 = 0.0;
            for (n4 = i2 + 1; n4 < n3; ++n4) {
                double d7 = d3 = dArray2[n4];
                d5 += d7 * d7;
            }
            this.c[i2] = d2 = dArray2[i2 + 1] > 0.0 ? -BY.a(d5) : BY.a(d5);
            if (d2 == 0.0) continue;
            int n8 = i2 + 1;
            dArray2[n8] = dArray2[n8] - d2;
            for (int i4 = i2 + 1; i4 < n2; ++i4) {
                int n9;
                double[] dArray5 = this.a[i4];
                double d8 = 0.0;
                for (n9 = i2 + 1; n9 < n3; ++n9) {
                    d8 -= dArray5[n9] * dArray2[n9];
                }
                d8 /= d2 * dArray2[i2 + 1];
                for (n9 = i2 + 1; n9 < n3; ++n9) {
                    int n10 = n9;
                    dArray5[n10] = dArray5[n10] - d8 * dArray2[n9];
                }
            }
        }
    }

    private void i() {
        int n2 = this.a.length;
        int n3 = this.a[0].length;
        for (int i2 = 0; i2 < n2; ++i2) {
            double d2;
            double d3;
            double d4;
            double[] dArray = this.a[i2];
            double d5 = 0.0;
            for (int i3 = i2; i3 < n3; ++i3) {
                double d6;
                double d7 = d6 = dArray[i3];
                d5 += d7 * d7;
            }
            this.b[i2] = d4 = dArray[i2] > 0.0 ? -BY.a(d5) : BY.a(d5);
            if (d4 != 0.0) {
                int n4 = i2;
                dArray[n4] = dArray[n4] - d4;
                for (int i4 = i2 + 1; i4 < n2; ++i4) {
                    int n5;
                    double[] dArray2 = this.a[i4];
                    d3 = 0.0;
                    for (n5 = i2; n5 < n3; ++n5) {
                        d3 -= dArray2[n5] * dArray[n5];
                    }
                    d3 /= d4 * this.a[i2][i2];
                    for (n5 = i2; n5 < n3; ++n5) {
                        int n6 = n5;
                        dArray2[n6] = dArray2[n6] - d3 * dArray[n5];
                    }
                }
            }
            if (i2 >= n2 - 1) continue;
            double[] dArray3 = this.a[i2 + 1];
            d5 = 0.0;
            for (int i5 = i2 + 1; i5 < n2; ++i5) {
                double d8 = d3 = this.a[i5][i2];
                d5 += d8 * d8;
            }
            this.c[i2] = d2 = dArray3[i2] > 0.0 ? -BY.a(d5) : BY.a(d5);
            if (d2 == 0.0) continue;
            int n7 = i2;
            dArray3[n7] = dArray3[n7] - d2;
            for (int i6 = i2 + 1; i6 < n3; ++i6) {
                int n8;
                double d9 = 0.0;
                for (n8 = i2 + 1; n8 < n2; ++n8) {
                    double[] dArray4 = this.a[n8];
                    d9 -= dArray4[i6] * dArray4[i2];
                }
                d9 /= d2 * dArray3[i2];
                for (n8 = i2 + 1; n8 < n2; ++n8) {
                    double[] dArray5 = this.a[n8];
                    double[] dArray6 = dArray5;
                    int n9 = i6;
                    dArray5[n9] = dArray5[n9] - d9 * dArray6[i2];
                }
            }
        }
    }
}

