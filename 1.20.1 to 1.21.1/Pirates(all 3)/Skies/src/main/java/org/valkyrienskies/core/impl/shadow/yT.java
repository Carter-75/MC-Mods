/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Arrays;
import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.cq_0;
import org.valkyrienskies.core.impl.shadow.oR;
import org.valkyrienskies.core.impl.shadow.px_0;
import org.valkyrienskies.core.impl.shadow.tq_0;
import org.valkyrienskies.core.impl.shadow.yP;
import org.valkyrienskies.core.impl.shadow.ya_0;
import org.valkyrienskies.core.impl.shadow.yq_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
@Deprecated
public final class yT
extends yP {
    private int c;
    private double[] d;
    private double[] e;
    private double[] f;
    private int[] g;
    private int h;
    private double i;
    private double[] j;
    private final double k;
    private final double l;
    private final double m;
    private final double n;
    private final double o;
    private double[] p;
    private double[][] q;

    public yT() {
        this(100.0, 1.0E-10, 1.0E-10, 1.0E-10, cq_0.b);
    }

    private yT(ya_0<yq_0> ya_02) {
        this(100.0, ya_02, 1.0E-10, 1.0E-10, 1.0E-10, cq_0.b);
    }

    private yT(double d2, ya_0<yq_0> ya_02, double d3, double d4, double d5, double d6) {
        super(ya_02);
        this.k = 100.0;
        this.l = 1.0E-10;
        this.m = 1.0E-10;
        this.n = 1.0E-10;
        this.o = d6;
    }

    private yT(double d2, double d3, double d4) {
        this(100.0, d2, d3, d4, cq_0.b);
    }

    private yT(double d2, double d3, double d4, double d5, double d6) {
        super(null);
        this.k = 100.0;
        this.l = d3;
        this.m = d4;
        this.n = d5;
        this.o = d6;
    }

    @Override
    public final yq_0 h() {
        int n2 = this.f().length;
        double[] dArray = this.d();
        int n3 = dArray.length;
        this.c = BY.a(n2, n3);
        this.d = new double[n3];
        this.e = new double[n3];
        this.f = new double[n3];
        this.g = new int[n3];
        this.j = new double[n3];
        double d2 = 0.0;
        double d3 = 0.0;
        double[] dArray2 = new double[n3];
        double[] dArray3 = new double[n3];
        double[] dArray4 = new double[n2];
        double[] cfr_ignored_0 = new double[n2];
        double[] dArray5 = new double[n2];
        double[] dArray6 = new double[n3];
        double[] dArray7 = new double[n3];
        double[] dArray8 = new double[n3];
        tq_0 tq_02 = this.j();
        double[] dArray9 = this.a(dArray);
        double[] dArray10 = this.d(dArray9);
        yq_0 yq_02 = new yq_0(dArray, dArray9);
        double d4 = this.c(dArray10);
        this.i = 0.0;
        boolean bl = true;
        int n4 = 0;
        ya_0<yq_0> ya_02 = this.c();
        block0: while (true) {
            double d5;
            int n5;
            int n6;
            double d6;
            double d7;
            int n7;
            int n8;
            int n9;
            yT yT2;
            Object object;
            yq_0 yq_03;
            block83: {
                ++n4;
                yq_03 = yq_02;
                yT yT3 = this;
                object = yT3.b(dArray);
                yT2 = yT3;
                yT3.q = object.b(-1.0).a();
                n9 = yT2.q.length;
                n8 = yT2.q[0].length;
                for (n7 = 0; n7 < n8; ++n7) {
                    int n10 = n7;
                    yT2.g[n10] = n10;
                    double d8 = 0.0;
                    for (int i2 = 0; i2 < n9; ++i2) {
                        double d9;
                        double d10 = d9 = yT2.q[i2][n7];
                        d8 += d10 * d10;
                    }
                    yT2.e[n7] = BY.a(d8);
                }
                for (n7 = 0; n7 < n8; ++n7) {
                    double d11;
                    double d12;
                    int n11;
                    int n12 = -1;
                    d7 = Double.NEGATIVE_INFINITY;
                    for (n11 = n7; n11 < n8; ++n11) {
                        d6 = 0.0;
                        for (int i3 = n7; i3 < n9; ++i3) {
                            double d13;
                            double d14 = d13 = yT2.q[i3][yT2.g[n11]];
                            d6 += d14 * d14;
                        }
                        if (Double.isInfinite(d6) || Double.isNaN(d6)) {
                            throw new oR(px_0.UNABLE_TO_PERFORM_QR_DECOMPOSITION_ON_JACOBIAN, n9, n8);
                        }
                        if (!(d6 > d7)) continue;
                        n12 = n11;
                        d7 = d6;
                    }
                    if (d7 <= yT2.o) {
                        yT2.h = n7;
                        break block83;
                    }
                    n11 = yT2.g[n12];
                    yT2.g[n12] = yT2.g[n7];
                    yT2.g[n7] = n11;
                    d6 = yT2.q[n7][n11];
                    double d15 = d12 > 0.0 ? -BY.a(d7) : BY.a(d7);
                    yT2.f[n11] = d11 = 1.0 / (d7 - d6 * d15);
                    yT2.d[n11] = d15;
                    double[] dArray11 = yT2.q[n7];
                    int n13 = n11;
                    dArray11[n13] = dArray11[n13] - d15;
                    for (int i4 = n8 - 1 - n7; i4 > 0; --i4) {
                        double d16 = 0.0;
                        for (n6 = n7; n6 < n9; ++n6) {
                            d16 += yT2.q[n6][n11] * yT2.q[n6][yT2.g[n7 + i4]];
                        }
                        d16 *= d11;
                        for (n6 = n7; n6 < n9; ++n6) {
                            double[] dArray12 = yT2.q[n6];
                            int n14 = yT2.g[n7 + i4];
                            dArray12[n14] = dArray12[n14] - d16 * yT2.q[n6][n11];
                        }
                    }
                }
                yT2.h = yT2.c;
            }
            this.p = tq_02.a(dArray10);
            for (n5 = 0; n5 < n2; ++n5) {
                dArray5[n5] = this.p[n5];
            }
            object = dArray5;
            yT2 = this;
            n9 = yT2.q.length;
            n8 = yT2.q[0].length;
            for (n7 = 0; n7 < n8; ++n7) {
                int n15;
                int n16 = yT2.g[n7];
                d7 = 0.0;
                for (n15 = n7; n15 < n9; ++n15) {
                    d7 += yT2.q[n15][n16] * object[n15];
                }
                d7 *= yT2.f[n16];
                for (n15 = n7; n15 < n9; ++n15) {
                    Object object2 = object;
                    int n17 = n15;
                    object2[n17] = object2[n17] - d7 * yT2.q[n15][n16];
                }
            }
            for (n5 = 0; n5 < this.c; ++n5) {
                int n18 = this.g[n5];
                this.q[n5][n18] = this.d[n18];
            }
            if (bl) {
                d3 = 0.0;
                for (n5 = 0; n5 < n3; ++n5) {
                    double d17;
                    double d18 = this.e[n5];
                    if (d18 == 0.0) {
                        d18 = 1.0;
                    }
                    double d19 = d17 = d18 * dArray[n5];
                    d3 += d19 * d19;
                    dArray2[n5] = d18;
                }
                d2 = (d3 = BY.a(d3)) == 0.0 ? this.k : this.k * d3;
            }
            double d20 = 0.0;
            if (d4 != 0.0) {
                for (int i5 = 0; i5 < this.c; ++i5) {
                    int n19 = this.g[i5];
                    d5 = this.e[n19];
                    if (d5 == 0.0) continue;
                    double d21 = 0.0;
                    for (int i6 = 0; i6 <= i5; ++i6) {
                        d21 += this.q[i6][n19] * dArray5[i6];
                    }
                    d20 = BY.e(d20, BY.w(d21) / (d5 * d4));
                }
            }
            if (d20 <= this.n) {
                this.a(d4);
                this.a = yq_02.a();
                return yq_02;
            }
            for (int i7 = 0; i7 < n3; ++i7) {
                dArray2[i7] = BY.e(dArray2[i7], this.e[i7]);
            }
            double d22 = 0.0;
            do {
                int n20;
                double d23;
                double d24;
                double d25;
                int n21;
                if (!(d22 < 1.0E-4)) continue block0;
                for (int i8 = 0; i8 < this.c; ++i8) {
                    int n22 = this.g[i8];
                    dArray3[n22] = dArray[n22];
                }
                d5 = d4;
                double[] dArray13 = this.p;
                this.p = dArray4;
                dArray4 = dArray13;
                dArray13 = dArray9;
                double[] dArray14 = dArray9;
                double[] dArray15 = dArray8;
                double[] dArray16 = dArray7;
                double[] dArray17 = dArray6;
                dArray13 = dArray2;
                double d26 = d2;
                object = dArray5;
                yT yT4 = this;
                int n23 = yT4.q[0].length;
                for (n21 = 0; n21 < yT4.h; ++n21) {
                    yT4.j[yT4.g[n21]] = (double)object[n21];
                }
                for (n21 = yT4.h; n21 < n23; ++n21) {
                    yT4.j[yT4.g[n21]] = 0.0;
                }
                for (n21 = yT4.h - 1; n21 >= 0; --n21) {
                    int n24 = yT4.g[n21];
                    double d27 = yT4.j[n24] / yT4.d[n24];
                    for (int i9 = 0; i9 < n21; ++i9) {
                        int n25 = yT4.g[i9];
                        yT4.j[n25] = yT4.j[n25] - d27 * yT4.q[i9][n24];
                    }
                    yT4.j[n24] = d27;
                }
                d6 = 0.0;
                for (int i10 = 0; i10 < yT4.c; ++i10) {
                    double d28;
                    int n26 = yT4.g[i10];
                    dArray17[n26] = d28 = dArray13[n26] * yT4.j[n26];
                    double d29 = d28;
                    d6 += d29 * d29;
                }
                d6 = BY.a(d6);
                double d30 = d6 - d26;
                if (d25 <= d26 * 0.1) {
                    yT4.i = 0.0;
                } else {
                    double d31;
                    int n27;
                    double d32 = 0.0;
                    if (yT4.h == yT4.c) {
                        for (n27 = 0; n27 < yT4.c; ++n27) {
                            int n28 = n6 = yT4.g[n27];
                            dArray17[n28] = dArray17[n28] * (dArray13[n6] / d6);
                        }
                        double d33 = 0.0;
                        for (n27 = 0; n27 < yT4.c; ++n27) {
                            double d34;
                            n6 = yT4.g[n27];
                            d31 = 0.0;
                            for (int i11 = 0; i11 < n27; ++i11) {
                                d31 += yT4.q[i11][n6] * dArray17[yT4.g[i11]];
                            }
                            dArray17[n6] = d34 = (dArray17[n6] - d31) / yT4.d[n6];
                            double d35 = d34;
                            d33 += d35 * d35;
                        }
                        d32 = d30 / (d26 * d33);
                    }
                    double d36 = 0.0;
                    for (n27 = 0; n27 < yT4.c; ++n27) {
                        n6 = yT4.g[n27];
                        d31 = 0.0;
                        for (int i12 = 0; i12 <= n27; ++i12) {
                            d31 += yT4.q[i12][n6] * object[i12];
                        }
                        double d37 = d31 /= dArray13[n6];
                        d36 += d37 * d37;
                    }
                    double d38 = BY.a(d36);
                    d31 = d38 / d26;
                    if (d31 == 0.0) {
                        d31 = 2.2251E-308 / BY.d(d26, 0.1);
                    }
                    yT4.i = BY.d(d31, BY.e(yT4.i, d32));
                    if (yT4.i == 0.0) {
                        yT4.i = d38 / d6;
                    }
                    for (int i13 = 10; i13 >= 0; --i13) {
                        int n29;
                        int n30;
                        double d39;
                        int n31;
                        int n32;
                        int n33;
                        int n34;
                        if (yT4.i == 0.0) {
                            yT4.i = BY.e(2.2251E-308, d31 * 0.001);
                        }
                        double d40 = BY.a(yT4.i);
                        for (n34 = 0; n34 < yT4.c; ++n34) {
                            n33 = yT4.g[n34];
                            dArray17[n33] = d40 * dArray13[n33];
                        }
                        double[] dArray18 = dArray15;
                        double[] dArray19 = dArray16;
                        double[] dArray20 = dArray17;
                        Object object3 = object;
                        yT yT5 = yT4;
                        for (n32 = 0; n32 < yT5.c; ++n32) {
                            n31 = yT5.g[n32];
                            for (int i14 = n32 + 1; i14 < yT5.c; ++i14) {
                                yT5.q[i14][n31] = yT5.q[n32][yT5.g[i14]];
                            }
                            yT5.j[n32] = yT5.d[n31];
                            dArray18[n32] = (double)object3[n32];
                        }
                        for (n32 = 0; n32 < yT5.c; ++n32) {
                            n31 = yT5.g[n32];
                            double d41 = dArray20[n31];
                            if (d41 != 0.0) {
                                Arrays.fill(dArray19, n32 + 1, dArray19.length, 0.0);
                            }
                            dArray19[n32] = d41;
                            double d42 = 0.0;
                            for (int i15 = n32; i15 < yT5.c; ++i15) {
                                double d43;
                                double d44;
                                double d45;
                                double d46;
                                int n35 = yT5.g[i15];
                                if (dArray19[i15] == 0.0) continue;
                                double d47 = yT5.q[i15][n35];
                                if (BY.w(d46) < BY.w(dArray19[i15])) {
                                    double d48 = d45 = d47 / dArray19[i15];
                                    d44 = 1.0 / BY.a(1.0 + d48 * d48);
                                    d43 = d44 * d45;
                                } else {
                                    double d49 = d45 = dArray19[i15] / d47;
                                    d43 = 1.0 / BY.a(1.0 + d49 * d49);
                                    d44 = d43 * d45;
                                }
                                yT5.q[i15][n35] = d43 * d47 + d44 * dArray19[i15];
                                d45 = d43 * dArray18[i15] + d44 * d42;
                                d42 = -d44 * dArray18[i15] + d43 * d42;
                                dArray18[i15] = d45;
                                for (int i16 = i15 + 1; i16 < yT5.c; ++i16) {
                                    double d50 = yT5.q[i16][n35];
                                    double d51 = d43 * d50 + d44 * dArray19[i16];
                                    dArray19[i16] = -d44 * d50 + d43 * dArray19[i16];
                                    yT5.q[i16][n35] = d51;
                                }
                            }
                            dArray19[n32] = yT5.q[n32][yT5.g[n32]];
                            yT5.q[n32][yT5.g[n32]] = yT5.j[n32];
                        }
                        n32 = yT5.c;
                        for (n31 = 0; n31 < yT5.c; ++n31) {
                            if (dArray19[n31] == 0.0 && n32 == yT5.c) {
                                n32 = n31;
                            }
                            if (n32 >= yT5.c) continue;
                            dArray18[n31] = 0.0;
                        }
                        if (n32 > 0) {
                            for (n31 = n32 - 1; n31 >= 0; --n31) {
                                int n36 = yT5.g[n31];
                                double d52 = 0.0;
                                for (int i17 = n31 + 1; i17 < n32; ++i17) {
                                    d52 += yT5.q[i17][n36] * dArray18[i17];
                                }
                                dArray18[n31] = (dArray18[n31] - d52) / dArray19[n31];
                            }
                        }
                        for (n31 = 0; n31 < yT5.j.length; ++n31) {
                            yT5.j[yT5.g[n31]] = dArray18[n31];
                        }
                        d6 = 0.0;
                        for (n34 = 0; n34 < yT4.c; ++n34) {
                            n33 = yT4.g[n34];
                            dArray15[n33] = d39 = dArray13[n33] * yT4.j[n33];
                            double d53 = d39;
                            d6 += d53 * d53;
                        }
                        d6 = BY.a(d6);
                        double d54 = d30;
                        d30 = d6 - d26;
                        if (BY.w(d30) <= d26 * 0.1 || d32 == 0.0 && d30 <= d54 && d54 < 0.0) break;
                        for (n30 = 0; n30 < yT4.c; ++n30) {
                            n29 = yT4.g[n30];
                            dArray17[n29] = dArray15[n29] * dArray13[n29] / d6;
                        }
                        for (n30 = 0; n30 < yT4.c; ++n30) {
                            int n37 = n29 = yT4.g[n30];
                            dArray17[n37] = dArray17[n37] / dArray16[n30];
                            double d55 = dArray17[n29];
                            for (int i18 = n30 + 1; i18 < yT4.c; ++i18) {
                                int n38 = yT4.g[i18];
                                dArray17[n38] = dArray17[n38] - yT4.q[i18][n29] * d55;
                            }
                        }
                        d36 = 0.0;
                        for (n30 = 0; n30 < yT4.c; ++n30) {
                            double d56;
                            double d57 = d56 = dArray17[yT4.g[n30]];
                            d36 += d57 * d57;
                        }
                        d39 = d30 / (d26 * d36);
                        if (d30 > 0.0) {
                            d32 = BY.e(d32, yT4.i);
                        } else if (d30 < 0.0) {
                            d31 = BY.d(d31, yT4.i);
                        }
                        yT4.i = BY.e(d32, yT4.i + d39);
                    }
                }
                double d58 = 0.0;
                for (int i19 = 0; i19 < this.c; ++i19) {
                    int n39 = this.g[i19];
                    this.j[n39] = -this.j[n39];
                    dArray[n39] = dArray3[n39] + this.j[n39];
                    double d59 = d24 = dArray2[n39] * this.j[n39];
                    d58 += d59 * d59;
                }
                d58 = BY.a(d58);
                if (bl) {
                    d2 = BY.d(d2, d58);
                }
                dArray9 = this.a(dArray);
                dArray10 = this.d(dArray9);
                yq_02 = new yq_0(dArray, dArray9);
                d4 = this.c(dArray10);
                double d60 = -1.0;
                if (d4 * 0.1 < d5) {
                    double d61 = d24 = d4 / d5;
                    d60 = 1.0 - d61 * d61;
                }
                for (int i20 = 0; i20 < this.c; ++i20) {
                    int n40 = this.g[i20];
                    d23 = this.j[n40];
                    dArray6[i20] = 0.0;
                    for (int i21 = 0; i21 <= i20; ++i21) {
                        int n41 = i21;
                        dArray6[n41] = dArray6[n41] + this.q[i21][n40] * d23;
                    }
                }
                d24 = 0.0;
                for (int i22 = 0; i22 < this.c; ++i22) {
                    d24 += dArray6[i22] * dArray6[i22];
                }
                double d62 = d5;
                d23 = d62 * d62;
                double d63 = this.i * d58 * d58 / d23;
                double d64 = (d24 /= d23) + d63 * 2.0;
                double d65 = -(d24 + d63);
                double d66 = d22 = d64 == 0.0 ? 0.0 : d60 / d64;
                if (d66 <= 0.25) {
                    double d67;
                    double d68 = d67 = d60 < 0.0 ? d65 * 0.5 / (d65 + d60 * 0.5) : 0.5;
                    if (d4 * 0.1 >= d5 || d67 < 0.1) {
                        d67 = 0.1;
                    }
                    d2 = d67 * BY.d(d2, d58 * 10.0);
                    this.i /= d67;
                } else if (this.i == 0.0 || d22 >= 0.75) {
                    d2 = d58 * 2.0;
                    this.i *= 0.5;
                }
                if (d22 >= 1.0E-4) {
                    bl = false;
                    d3 = 0.0;
                    for (n20 = 0; n20 < n3; ++n20) {
                        double d69;
                        double d70 = d69 = dArray2[n20] * dArray[n20];
                        d3 += d70 * d70;
                    }
                    d3 = BY.a(d3);
                    if (ya_02 != null && ya_02.a(n4, yq_03, yq_02)) {
                        this.a(d4);
                        this.a = yq_02.a();
                        return yq_02;
                    }
                } else {
                    d4 = d5;
                    for (n20 = 0; n20 < this.c; ++n20) {
                        int n42 = this.g[n20];
                        dArray[n42] = dArray3[n42];
                    }
                    dArray13 = this.p;
                    this.p = dArray4;
                    dArray4 = dArray13;
                    dArray9 = dArray14;
                    yq_02 = new yq_0(dArray, dArray9);
                }
                if (BY.w(d60) <= this.l && d64 <= this.l && d22 <= 2.0 || d2 <= this.m * d3) {
                    this.a(d4);
                    this.a = yq_02.a();
                    return yq_02;
                }
                if (BY.w(d60) <= 2.2204E-16 && d64 <= 2.2204E-16 && d22 <= 2.0) {
                    throw new oR(px_0.TOO_SMALL_COST_RELATIVE_TOLERANCE, this.l);
                }
                if (!(d2 <= d3 * 2.2204E-16)) continue;
                throw new oR(px_0.TOO_SMALL_PARAMETERS_RELATIVE_TOLERANCE, this.m);
            } while (!(d20 <= 2.2204E-16));
            break;
        }
        throw new oR(px_0.TOO_SMALL_ORTHOGONALITY_TOLERANCE, this.n);
    }

    private void a(double[] dArray, double d2, double[] dArray2, double[] dArray3, double[] dArray4, double[] dArray5) {
        double d3;
        int n2;
        int n3;
        double d4;
        int n4;
        int n5 = this.q[0].length;
        for (n4 = 0; n4 < this.h; ++n4) {
            this.j[this.g[n4]] = dArray[n4];
        }
        for (n4 = this.h; n4 < n5; ++n4) {
            this.j[this.g[n4]] = 0.0;
        }
        for (n4 = this.h - 1; n4 >= 0; --n4) {
            int n6 = this.g[n4];
            double d5 = this.j[n6] / this.d[n6];
            for (int i2 = 0; i2 < n4; ++i2) {
                int n7 = this.g[i2];
                this.j[n7] = this.j[n7] - d5 * this.q[i2][n6];
            }
            this.j[n6] = d5;
        }
        double d6 = 0.0;
        for (int i3 = 0; i3 < this.c; ++i3) {
            double d7;
            int n8 = this.g[i3];
            dArray3[n8] = d7 = dArray2[n8] * this.j[n8];
            double d8 = d7;
            d6 += d8 * d8;
        }
        d6 = BY.a(d6);
        double d9 = d6 - d2;
        if (d4 <= d2 * 0.1) {
            this.i = 0.0;
            return;
        }
        double d10 = 0.0;
        if (this.h == this.c) {
            for (n3 = 0; n3 < this.c; ++n3) {
                int n9 = n2 = this.g[n3];
                dArray3[n9] = dArray3[n9] * (dArray2[n2] / d6);
            }
            double d11 = 0.0;
            for (n3 = 0; n3 < this.c; ++n3) {
                double d12;
                n2 = this.g[n3];
                d3 = 0.0;
                for (int i4 = 0; i4 < n3; ++i4) {
                    d3 += this.q[i4][n2] * dArray3[this.g[i4]];
                }
                dArray3[n2] = d12 = (dArray3[n2] - d3) / this.d[n2];
                double d13 = d12;
                d11 += d13 * d13;
            }
            d10 = d9 / (d2 * d11);
        }
        double d14 = 0.0;
        for (n3 = 0; n3 < this.c; ++n3) {
            n2 = this.g[n3];
            d3 = 0.0;
            for (int i5 = 0; i5 <= n3; ++i5) {
                d3 += this.q[i5][n2] * dArray[i5];
            }
            double d15 = d3 /= dArray2[n2];
            d14 += d15 * d15;
        }
        double d16 = BY.a(d14);
        d3 = d16 / d2;
        if (d3 == 0.0) {
            d3 = 2.2251E-308 / BY.d(d2, 0.1);
        }
        this.i = BY.d(d3, BY.e(this.i, d10));
        if (this.i == 0.0) {
            this.i = d16 / d6;
        }
        for (int i6 = 10; i6 >= 0; --i6) {
            int n10;
            int n11;
            double d17;
            int n12;
            int n13;
            if (this.i == 0.0) {
                this.i = BY.e(2.2251E-308, d3 * 0.001);
            }
            double d18 = BY.a(this.i);
            for (n13 = 0; n13 < this.c; ++n13) {
                n12 = this.g[n13];
                dArray3[n12] = d18 * dArray2[n12];
            }
            this.a(dArray, dArray3, dArray4, dArray5);
            d6 = 0.0;
            for (n13 = 0; n13 < this.c; ++n13) {
                n12 = this.g[n13];
                dArray5[n12] = d17 = dArray2[n12] * this.j[n12];
                double d19 = d17;
                d6 += d19 * d19;
            }
            d6 = BY.a(d6);
            double d20 = d9;
            d9 = d6 - d2;
            if (BY.w(d9) <= d2 * 0.1 || d10 == 0.0 && d9 <= d20 && d20 < 0.0) {
                return;
            }
            for (n11 = 0; n11 < this.c; ++n11) {
                n10 = this.g[n11];
                dArray3[n10] = dArray5[n10] * dArray2[n10] / d6;
            }
            for (n11 = 0; n11 < this.c; ++n11) {
                int n14 = n10 = this.g[n11];
                dArray3[n14] = dArray3[n14] / dArray4[n11];
                double d21 = dArray3[n10];
                for (n5 = n11 + 1; n5 < this.c; ++n5) {
                    int n15 = this.g[n5];
                    dArray3[n15] = dArray3[n15] - this.q[n5][n10] * d21;
                }
            }
            d14 = 0.0;
            for (n11 = 0; n11 < this.c; ++n11) {
                double d22;
                double d23 = d22 = dArray3[this.g[n11]];
                d14 += d23 * d23;
            }
            d17 = d9 / (d2 * d14);
            if (d9 > 0.0) {
                d10 = BY.e(d10, this.i);
            } else if (d9 < 0.0) {
                d3 = BY.d(d3, this.i);
            }
            this.i = BY.e(d10, this.i + d17);
        }
    }

    private void a(double[] dArray, double[] dArray2, double[] dArray3, double[] dArray4) {
        int n2;
        int n3;
        for (n3 = 0; n3 < this.c; ++n3) {
            n2 = this.g[n3];
            for (int i2 = n3 + 1; i2 < this.c; ++i2) {
                this.q[i2][n2] = this.q[n3][this.g[i2]];
            }
            this.j[n3] = this.d[n2];
            dArray4[n3] = dArray[n3];
        }
        for (n3 = 0; n3 < this.c; ++n3) {
            n2 = this.g[n3];
            double d2 = dArray2[n2];
            if (d2 != 0.0) {
                Arrays.fill(dArray3, n3 + 1, dArray3.length, 0.0);
            }
            dArray3[n3] = d2;
            double d3 = 0.0;
            for (int i3 = n3; i3 < this.c; ++i3) {
                double d4;
                double d5;
                double d6;
                double d7;
                n2 = this.g[i3];
                if (dArray3[i3] == 0.0) continue;
                double d8 = this.q[i3][n2];
                if (BY.w(d7) < BY.w(dArray3[i3])) {
                    double d9 = d6 = d8 / dArray3[i3];
                    d5 = 1.0 / BY.a(1.0 + d9 * d9);
                    d4 = d5 * d6;
                } else {
                    double d10 = d6 = dArray3[i3] / d8;
                    d4 = 1.0 / BY.a(1.0 + d10 * d10);
                    d5 = d4 * d6;
                }
                this.q[i3][n2] = d4 * d8 + d5 * dArray3[i3];
                d6 = d4 * dArray4[i3] + d5 * d3;
                d3 = -d5 * dArray4[i3] + d4 * d3;
                dArray4[i3] = d6;
                for (int i4 = i3 + 1; i4 < this.c; ++i4) {
                    double d11 = this.q[i4][n2];
                    double d12 = d4 * d11 + d5 * dArray3[i4];
                    dArray3[i4] = -d5 * d11 + d4 * dArray3[i4];
                    this.q[i4][n2] = d12;
                }
            }
            dArray3[n3] = this.q[n3][this.g[n3]];
            this.q[n3][this.g[n3]] = this.j[n3];
        }
        n3 = this.c;
        for (n2 = 0; n2 < this.c; ++n2) {
            if (dArray3[n2] == 0.0 && n3 == this.c) {
                n3 = n2;
            }
            if (n3 >= this.c) continue;
            dArray4[n2] = 0.0;
        }
        if (n3 > 0) {
            for (n2 = n3 - 1; n2 >= 0; --n2) {
                int n4 = this.g[n2];
                double d13 = 0.0;
                for (int i5 = n2 + 1; i5 < n3; ++i5) {
                    d13 += this.q[i5][n4] * dArray4[i5];
                }
                dArray4[n2] = (dArray4[n2] - d13) / dArray3[n2];
            }
        }
        for (n2 = 0; n2 < this.j.length; ++n2) {
            this.j[this.g[n2]] = dArray4[n2];
        }
    }

    private void a(tq_0 tq_02) {
        int n2;
        this.q = tq_02.b(-1.0).a();
        int n3 = this.q.length;
        int n4 = this.q[0].length;
        for (n2 = 0; n2 < n4; ++n2) {
            int n5 = n2;
            this.g[n5] = n5;
            double d2 = 0.0;
            for (int i2 = 0; i2 < n3; ++i2) {
                double d3;
                double d4 = d3 = this.q[i2][n2];
                d2 += d4 * d4;
            }
            this.e[n2] = BY.a(d2);
        }
        for (n2 = 0; n2 < n4; ++n2) {
            double d5;
            double d6;
            double d7;
            int n6;
            int n7 = -1;
            double d8 = Double.NEGATIVE_INFINITY;
            for (n6 = n2; n6 < n4; ++n6) {
                d7 = 0.0;
                for (int i3 = n2; i3 < n3; ++i3) {
                    double d9;
                    double d10 = d9 = this.q[i3][this.g[n6]];
                    d7 += d10 * d10;
                }
                if (Double.isInfinite(d7) || Double.isNaN(d7)) {
                    throw new oR(px_0.UNABLE_TO_PERFORM_QR_DECOMPOSITION_ON_JACOBIAN, n3, n4);
                }
                if (!(d7 > d8)) continue;
                n7 = n6;
                d8 = d7;
            }
            if (d8 <= this.o) {
                this.h = n2;
                return;
            }
            n6 = this.g[n7];
            this.g[n7] = this.g[n2];
            this.g[n2] = n6;
            d7 = this.q[n2][n6];
            double d11 = d6 > 0.0 ? -BY.a(d8) : BY.a(d8);
            this.f[n6] = d5 = 1.0 / (d8 - d7 * d11);
            this.d[n6] = d11;
            double[] dArray = this.q[n2];
            int n8 = n6;
            dArray[n8] = dArray[n8] - d11;
            for (int i4 = n4 - 1 - n2; i4 > 0; --i4) {
                double d12 = 0.0;
                for (n7 = n2; n7 < n3; ++n7) {
                    d12 += this.q[n7][n6] * this.q[n7][this.g[n2 + i4]];
                }
                d12 *= d5;
                for (n7 = n2; n7 < n3; ++n7) {
                    double[] dArray2 = this.q[n7];
                    int n9 = this.g[n2 + i4];
                    dArray2[n9] = dArray2[n9] - d12 * this.q[n7][n6];
                }
            }
        }
        this.h = this.c;
    }

    private void e(double[] dArray) {
        int n2 = this.q.length;
        int n3 = this.q[0].length;
        for (int i2 = 0; i2 < n3; ++i2) {
            int n4;
            int n5 = this.g[i2];
            double d2 = 0.0;
            for (n4 = i2; n4 < n2; ++n4) {
                d2 += this.q[n4][n5] * dArray[n4];
            }
            d2 *= this.f[n5];
            for (n4 = i2; n4 < n2; ++n4) {
                int n6 = n4;
                dArray[n6] = dArray[n6] - d2 * this.q[n4][n5];
            }
        }
    }
}

