/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Arrays;
import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.cq_0;
import org.valkyrienskies.core.impl.shadow.oR;
import org.valkyrienskies.core.impl.shadow.pb_0;
import org.valkyrienskies.core.impl.shadow.px_0;
import org.valkyrienskies.core.impl.shadow.tq_0;
import org.valkyrienskies.core.impl.shadow.wK;
import org.valkyrienskies.core.impl.shadow.wR;
import org.valkyrienskies.core.impl.shadow.xI;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
@Deprecated
public final class xK
extends xI {
    private static final double a = 2.0 * cq_0.a;
    private int b;
    private double[] c;
    private double[] d;
    private double[] e;
    private int[] f;
    private int g;
    private double h;
    private double[] i;
    private final double j;
    private final double k;
    private final double l;
    private final double m;
    private final double n;
    private double[] o;
    private double[][] p;

    public xK() {
        this(100.0, 1.0E-10, 1.0E-10, 1.0E-10, cq_0.b);
    }

    private xK(wK<wR> wK2) {
        this(100.0, wK2, 1.0E-10, 1.0E-10, 1.0E-10, cq_0.b);
    }

    private xK(double d2, wK<wR> wK2, double d3, double d4, double d5, double d6) {
        super(wK2);
        this.j = 100.0;
        this.k = 1.0E-10;
        this.l = 1.0E-10;
        this.m = 1.0E-10;
        this.n = d6;
    }

    private xK(double d2, double d3, double d4) {
        this(100.0, d2, d3, d4, cq_0.b);
    }

    private xK(double d2, double d3, double d4, double d5, double d6) {
        super((wK<wR>)null);
        this.j = 100.0;
        this.k = d3;
        this.l = d4;
        this.m = d5;
        this.n = d6;
    }

    private wR o() {
        xK xK2 = this;
        if (xK2.f() != null || xK2.g() != null) {
            throw new pb_0(px_0.CONSTRAINT, new Object[0]);
        }
        int n2 = this.d().length;
        double[] dArray = this.e();
        int n3 = dArray.length;
        this.b = BY.a(n2, n3);
        this.c = new double[n3];
        this.d = new double[n3];
        this.e = new double[n3];
        this.f = new int[n3];
        this.i = new double[n3];
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
        tq_0 tq_02 = this.n();
        double[] dArray9 = this.b(dArray);
        double[] dArray10 = this.e(dArray9);
        wR wR2 = new wR(dArray, dArray9);
        double d4 = this.d(dArray10);
        this.h = 0.0;
        boolean bl = true;
        wK<wR> wK2 = this.j();
        block0: while (true) {
            double d5;
            int n4;
            int n5;
            double d6;
            double d7;
            int n6;
            int n7;
            int n8;
            Object object;
            wR wR3;
            block84: {
                this.l();
                wR3 = wR2;
                xK xK3 = this;
                object = xK3.c(dArray);
                xK2 = xK3;
                xK3.p = object.b(-1.0).a();
                n8 = xK2.p.length;
                n7 = xK2.p[0].length;
                for (n6 = 0; n6 < n7; ++n6) {
                    int n9 = n6;
                    xK2.f[n9] = n9;
                    double d8 = 0.0;
                    for (int i2 = 0; i2 < n8; ++i2) {
                        double d9;
                        double d10 = d9 = xK2.p[i2][n6];
                        d8 += d10 * d10;
                    }
                    xK2.d[n6] = BY.a(d8);
                }
                for (n6 = 0; n6 < n7; ++n6) {
                    double d11;
                    double d12;
                    int n10;
                    int n11 = -1;
                    d7 = Double.NEGATIVE_INFINITY;
                    for (n10 = n6; n10 < n7; ++n10) {
                        d6 = 0.0;
                        for (int i3 = n6; i3 < n8; ++i3) {
                            double d13;
                            double d14 = d13 = xK2.p[i3][xK2.f[n10]];
                            d6 += d14 * d14;
                        }
                        if (Double.isInfinite(d6) || Double.isNaN(d6)) {
                            throw new oR(px_0.UNABLE_TO_PERFORM_QR_DECOMPOSITION_ON_JACOBIAN, n8, n7);
                        }
                        if (!(d6 > d7)) continue;
                        n11 = n10;
                        d7 = d6;
                    }
                    if (d7 <= xK2.n) {
                        xK2.g = n6;
                        break block84;
                    }
                    n10 = xK2.f[n11];
                    xK2.f[n11] = xK2.f[n6];
                    xK2.f[n6] = n10;
                    d6 = xK2.p[n6][n10];
                    double d15 = d12 > 0.0 ? -BY.a(d7) : BY.a(d7);
                    xK2.e[n10] = d11 = 1.0 / (d7 - d6 * d15);
                    xK2.c[n10] = d15;
                    double[] dArray11 = xK2.p[n6];
                    int n12 = n10;
                    dArray11[n12] = dArray11[n12] - d15;
                    for (int i4 = n7 - 1 - n6; i4 > 0; --i4) {
                        double d16 = 0.0;
                        for (n5 = n6; n5 < n8; ++n5) {
                            d16 += xK2.p[n5][n10] * xK2.p[n5][xK2.f[n6 + i4]];
                        }
                        d16 *= d11;
                        for (n5 = n6; n5 < n8; ++n5) {
                            double[] dArray12 = xK2.p[n5];
                            int n13 = xK2.f[n6 + i4];
                            dArray12[n13] = dArray12[n13] - d16 * xK2.p[n5][n10];
                        }
                    }
                }
                xK2.g = xK2.b;
            }
            this.o = tq_02.a(dArray10);
            for (n4 = 0; n4 < n2; ++n4) {
                dArray5[n4] = this.o[n4];
            }
            object = dArray5;
            xK2 = this;
            n8 = xK2.p.length;
            n7 = xK2.p[0].length;
            for (n6 = 0; n6 < n7; ++n6) {
                int n14;
                int n15 = xK2.f[n6];
                d7 = 0.0;
                for (n14 = n6; n14 < n8; ++n14) {
                    d7 += xK2.p[n14][n15] * object[n14];
                }
                d7 *= xK2.e[n15];
                for (n14 = n6; n14 < n8; ++n14) {
                    Object object2 = object;
                    int n16 = n14;
                    object2[n16] = object2[n16] - d7 * xK2.p[n14][n15];
                }
            }
            for (n4 = 0; n4 < this.b; ++n4) {
                int n17 = this.f[n4];
                this.p[n4][n17] = this.c[n17];
            }
            if (bl) {
                d3 = 0.0;
                for (n4 = 0; n4 < n3; ++n4) {
                    double d17;
                    double d18 = this.d[n4];
                    if (d18 == 0.0) {
                        d18 = 1.0;
                    }
                    double d19 = d17 = d18 * dArray[n4];
                    d3 += d19 * d19;
                    dArray2[n4] = d18;
                }
                d2 = (d3 = BY.a(d3)) == 0.0 ? this.j : this.j * d3;
            }
            double d20 = 0.0;
            if (d4 != 0.0) {
                for (int i5 = 0; i5 < this.b; ++i5) {
                    int n18 = this.f[i5];
                    d5 = this.d[n18];
                    if (d5 == 0.0) continue;
                    double d21 = 0.0;
                    for (int i6 = 0; i6 <= i5; ++i6) {
                        d21 += this.p[i6][n18] * dArray5[i6];
                    }
                    d20 = BY.e(d20, BY.w(d21) / (d5 * d4));
                }
            }
            if (d20 <= this.m) {
                this.a(d4);
                return wR2;
            }
            for (int i7 = 0; i7 < n3; ++i7) {
                dArray2[i7] = BY.e(dArray2[i7], this.d[i7]);
            }
            double d22 = 0.0;
            do {
                int n19;
                double d23;
                double d24;
                double d25;
                int n20;
                if (!(d22 < 1.0E-4)) continue block0;
                for (int i8 = 0; i8 < this.b; ++i8) {
                    int n21 = this.f[i8];
                    dArray3[n21] = dArray[n21];
                }
                d5 = d4;
                double[] dArray13 = this.o;
                this.o = dArray4;
                dArray4 = dArray13;
                dArray13 = dArray9;
                double[] dArray14 = dArray9;
                double[] dArray15 = dArray8;
                double[] dArray16 = dArray7;
                double[] dArray17 = dArray6;
                dArray13 = dArray2;
                double d26 = d2;
                object = dArray5;
                xK xK4 = this;
                int n22 = xK4.p[0].length;
                for (n20 = 0; n20 < xK4.g; ++n20) {
                    xK4.i[xK4.f[n20]] = (double)object[n20];
                }
                for (n20 = xK4.g; n20 < n22; ++n20) {
                    xK4.i[xK4.f[n20]] = 0.0;
                }
                for (n20 = xK4.g - 1; n20 >= 0; --n20) {
                    int n23 = xK4.f[n20];
                    double d27 = xK4.i[n23] / xK4.c[n23];
                    for (int i9 = 0; i9 < n20; ++i9) {
                        int n24 = xK4.f[i9];
                        xK4.i[n24] = xK4.i[n24] - d27 * xK4.p[i9][n23];
                    }
                    xK4.i[n23] = d27;
                }
                d6 = 0.0;
                for (int i10 = 0; i10 < xK4.b; ++i10) {
                    double d28;
                    int n25 = xK4.f[i10];
                    dArray17[n25] = d28 = dArray13[n25] * xK4.i[n25];
                    double d29 = d28;
                    d6 += d29 * d29;
                }
                d6 = BY.a(d6);
                double d30 = d6 - d26;
                if (d25 <= d26 * 0.1) {
                    xK4.h = 0.0;
                } else {
                    double d31;
                    int n26;
                    double d32 = 0.0;
                    if (xK4.g == xK4.b) {
                        for (n26 = 0; n26 < xK4.b; ++n26) {
                            int n27 = n5 = xK4.f[n26];
                            dArray17[n27] = dArray17[n27] * (dArray13[n5] / d6);
                        }
                        double d33 = 0.0;
                        for (n26 = 0; n26 < xK4.b; ++n26) {
                            double d34;
                            n5 = xK4.f[n26];
                            d31 = 0.0;
                            for (int i11 = 0; i11 < n26; ++i11) {
                                d31 += xK4.p[i11][n5] * dArray17[xK4.f[i11]];
                            }
                            dArray17[n5] = d34 = (dArray17[n5] - d31) / xK4.c[n5];
                            double d35 = d34;
                            d33 += d35 * d35;
                        }
                        d32 = d30 / (d26 * d33);
                    }
                    double d36 = 0.0;
                    for (n26 = 0; n26 < xK4.b; ++n26) {
                        n5 = xK4.f[n26];
                        d31 = 0.0;
                        for (int i12 = 0; i12 <= n26; ++i12) {
                            d31 += xK4.p[i12][n5] * object[i12];
                        }
                        double d37 = d31 /= dArray13[n5];
                        d36 += d37 * d37;
                    }
                    double d38 = BY.a(d36);
                    d31 = d38 / d26;
                    if (d31 == 0.0) {
                        d31 = cq_0.b / BY.d(d26, 0.1);
                    }
                    xK4.h = BY.d(d31, BY.e(xK4.h, d32));
                    if (xK4.h == 0.0) {
                        xK4.h = d38 / d6;
                    }
                    for (int i13 = 10; i13 >= 0; --i13) {
                        int n28;
                        int n29;
                        double d39;
                        int n30;
                        int n31;
                        int n32;
                        int n33;
                        if (xK4.h == 0.0) {
                            xK4.h = BY.e(cq_0.b, d31 * 0.001);
                        }
                        double d40 = BY.a(xK4.h);
                        for (n33 = 0; n33 < xK4.b; ++n33) {
                            n32 = xK4.f[n33];
                            dArray17[n32] = d40 * dArray13[n32];
                        }
                        double[] dArray18 = dArray15;
                        double[] dArray19 = dArray16;
                        double[] dArray20 = dArray17;
                        Object object3 = object;
                        xK xK5 = xK4;
                        for (n31 = 0; n31 < xK5.b; ++n31) {
                            n30 = xK5.f[n31];
                            for (int i14 = n31 + 1; i14 < xK5.b; ++i14) {
                                xK5.p[i14][n30] = xK5.p[n31][xK5.f[i14]];
                            }
                            xK5.i[n31] = xK5.c[n30];
                            dArray18[n31] = (double)object3[n31];
                        }
                        for (n31 = 0; n31 < xK5.b; ++n31) {
                            n30 = xK5.f[n31];
                            double d41 = dArray20[n30];
                            if (d41 != 0.0) {
                                Arrays.fill(dArray19, n31 + 1, dArray19.length, 0.0);
                            }
                            dArray19[n31] = d41;
                            double d42 = 0.0;
                            for (int i15 = n31; i15 < xK5.b; ++i15) {
                                double d43;
                                double d44;
                                double d45;
                                double d46;
                                int n34 = xK5.f[i15];
                                if (dArray19[i15] == 0.0) continue;
                                double d47 = xK5.p[i15][n34];
                                if (BY.w(d46) < BY.w(dArray19[i15])) {
                                    double d48 = d45 = d47 / dArray19[i15];
                                    d44 = 1.0 / BY.a(1.0 + d48 * d48);
                                    d43 = d44 * d45;
                                } else {
                                    double d49 = d45 = dArray19[i15] / d47;
                                    d43 = 1.0 / BY.a(1.0 + d49 * d49);
                                    d44 = d43 * d45;
                                }
                                xK5.p[i15][n34] = d43 * d47 + d44 * dArray19[i15];
                                d45 = d43 * dArray18[i15] + d44 * d42;
                                d42 = -d44 * dArray18[i15] + d43 * d42;
                                dArray18[i15] = d45;
                                for (int i16 = i15 + 1; i16 < xK5.b; ++i16) {
                                    double d50 = xK5.p[i16][n34];
                                    double d51 = d43 * d50 + d44 * dArray19[i16];
                                    dArray19[i16] = -d44 * d50 + d43 * dArray19[i16];
                                    xK5.p[i16][n34] = d51;
                                }
                            }
                            dArray19[n31] = xK5.p[n31][xK5.f[n31]];
                            xK5.p[n31][xK5.f[n31]] = xK5.i[n31];
                        }
                        n31 = xK5.b;
                        for (n30 = 0; n30 < xK5.b; ++n30) {
                            if (dArray19[n30] == 0.0 && n31 == xK5.b) {
                                n31 = n30;
                            }
                            if (n31 >= xK5.b) continue;
                            dArray18[n30] = 0.0;
                        }
                        if (n31 > 0) {
                            for (n30 = n31 - 1; n30 >= 0; --n30) {
                                int n35 = xK5.f[n30];
                                double d52 = 0.0;
                                for (int i17 = n30 + 1; i17 < n31; ++i17) {
                                    d52 += xK5.p[i17][n35] * dArray18[i17];
                                }
                                dArray18[n30] = (dArray18[n30] - d52) / dArray19[n30];
                            }
                        }
                        for (n30 = 0; n30 < xK5.i.length; ++n30) {
                            xK5.i[xK5.f[n30]] = dArray18[n30];
                        }
                        d6 = 0.0;
                        for (n33 = 0; n33 < xK4.b; ++n33) {
                            n32 = xK4.f[n33];
                            dArray15[n32] = d39 = dArray13[n32] * xK4.i[n32];
                            double d53 = d39;
                            d6 += d53 * d53;
                        }
                        d6 = BY.a(d6);
                        double d54 = d30;
                        d30 = d6 - d26;
                        if (BY.w(d30) <= d26 * 0.1 || d32 == 0.0 && d30 <= d54 && d54 < 0.0) break;
                        for (n29 = 0; n29 < xK4.b; ++n29) {
                            n28 = xK4.f[n29];
                            dArray17[n28] = dArray15[n28] * dArray13[n28] / d6;
                        }
                        for (n29 = 0; n29 < xK4.b; ++n29) {
                            int n36 = n28 = xK4.f[n29];
                            dArray17[n36] = dArray17[n36] / dArray16[n29];
                            double d55 = dArray17[n28];
                            for (int i18 = n29 + 1; i18 < xK4.b; ++i18) {
                                int n37 = xK4.f[i18];
                                dArray17[n37] = dArray17[n37] - xK4.p[i18][n28] * d55;
                            }
                        }
                        d36 = 0.0;
                        for (n29 = 0; n29 < xK4.b; ++n29) {
                            double d56;
                            double d57 = d56 = dArray17[xK4.f[n29]];
                            d36 += d57 * d57;
                        }
                        d39 = d30 / (d26 * d36);
                        if (d30 > 0.0) {
                            d32 = BY.e(d32, xK4.h);
                        } else if (d30 < 0.0) {
                            d31 = BY.d(d31, xK4.h);
                        }
                        xK4.h = BY.e(d32, xK4.h + d39);
                    }
                }
                double d58 = 0.0;
                for (int i19 = 0; i19 < this.b; ++i19) {
                    int n38 = this.f[i19];
                    this.i[n38] = -this.i[n38];
                    dArray[n38] = dArray3[n38] + this.i[n38];
                    double d59 = d24 = dArray2[n38] * this.i[n38];
                    d58 += d59 * d59;
                }
                d58 = BY.a(d58);
                if (bl) {
                    d2 = BY.d(d2, d58);
                }
                dArray9 = this.b(dArray);
                dArray10 = this.e(dArray9);
                wR2 = new wR(dArray, dArray9);
                d4 = this.d(dArray10);
                double d60 = -1.0;
                if (d4 * 0.1 < d5) {
                    double d61 = d24 = d4 / d5;
                    d60 = 1.0 - d61 * d61;
                }
                for (int i20 = 0; i20 < this.b; ++i20) {
                    int n39 = this.f[i20];
                    d23 = this.i[n39];
                    dArray6[i20] = 0.0;
                    for (int i21 = 0; i21 <= i20; ++i21) {
                        int n40 = i21;
                        dArray6[n40] = dArray6[n40] + this.p[i21][n39] * d23;
                    }
                }
                d24 = 0.0;
                for (int i22 = 0; i22 < this.b; ++i22) {
                    d24 += dArray6[i22] * dArray6[i22];
                }
                double d62 = d5;
                d23 = d62 * d62;
                double d63 = this.h * d58 * d58 / d23;
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
                    this.h /= d67;
                } else if (this.h == 0.0 || d22 >= 0.75) {
                    d2 = d58 * 2.0;
                    this.h *= 0.5;
                }
                if (d22 >= 1.0E-4) {
                    bl = false;
                    d3 = 0.0;
                    for (n19 = 0; n19 < n3; ++n19) {
                        double d69;
                        double d70 = d69 = dArray2[n19] * dArray[n19];
                        d3 += d70 * d70;
                    }
                    d3 = BY.a(d3);
                    if (wK2 != null && wK2.a(this.i(), wR3, wR2)) {
                        this.a(d4);
                        return wR2;
                    }
                } else {
                    d4 = d5;
                    for (n19 = 0; n19 < this.b; ++n19) {
                        int n41 = this.f[n19];
                        dArray[n41] = dArray3[n41];
                    }
                    dArray13 = this.o;
                    this.o = dArray4;
                    dArray4 = dArray13;
                    dArray9 = dArray14;
                    wR2 = new wR(dArray, dArray9);
                }
                if (BY.w(d60) <= this.k && d64 <= this.k && d22 <= 2.0 || d2 <= this.l * d3) {
                    this.a(d4);
                    return wR2;
                }
                if (BY.w(d60) <= a && d64 <= a && d22 <= 2.0) {
                    throw new oR(px_0.TOO_SMALL_COST_RELATIVE_TOLERANCE, this.k);
                }
                if (!(d2 <= a * d3)) continue;
                throw new oR(px_0.TOO_SMALL_PARAMETERS_RELATIVE_TOLERANCE, this.l);
            } while (!(d20 <= a));
            break;
        }
        throw new oR(px_0.TOO_SMALL_ORTHOGONALITY_TOLERANCE, this.m);
    }

    private void a(double[] dArray, double d2, double[] dArray2, double[] dArray3, double[] dArray4, double[] dArray5) {
        double d3;
        int n2;
        int n3;
        double d4;
        int n4;
        int n5 = this.p[0].length;
        for (n4 = 0; n4 < this.g; ++n4) {
            this.i[this.f[n4]] = dArray[n4];
        }
        for (n4 = this.g; n4 < n5; ++n4) {
            this.i[this.f[n4]] = 0.0;
        }
        for (n4 = this.g - 1; n4 >= 0; --n4) {
            int n6 = this.f[n4];
            double d5 = this.i[n6] / this.c[n6];
            for (int i2 = 0; i2 < n4; ++i2) {
                int n7 = this.f[i2];
                this.i[n7] = this.i[n7] - d5 * this.p[i2][n6];
            }
            this.i[n6] = d5;
        }
        double d6 = 0.0;
        for (int i3 = 0; i3 < this.b; ++i3) {
            double d7;
            int n8 = this.f[i3];
            dArray3[n8] = d7 = dArray2[n8] * this.i[n8];
            double d8 = d7;
            d6 += d8 * d8;
        }
        d6 = BY.a(d6);
        double d9 = d6 - d2;
        if (d4 <= d2 * 0.1) {
            this.h = 0.0;
            return;
        }
        double d10 = 0.0;
        if (this.g == this.b) {
            for (n3 = 0; n3 < this.b; ++n3) {
                int n9 = n2 = this.f[n3];
                dArray3[n9] = dArray3[n9] * (dArray2[n2] / d6);
            }
            double d11 = 0.0;
            for (n3 = 0; n3 < this.b; ++n3) {
                double d12;
                n2 = this.f[n3];
                d3 = 0.0;
                for (int i4 = 0; i4 < n3; ++i4) {
                    d3 += this.p[i4][n2] * dArray3[this.f[i4]];
                }
                dArray3[n2] = d12 = (dArray3[n2] - d3) / this.c[n2];
                double d13 = d12;
                d11 += d13 * d13;
            }
            d10 = d9 / (d2 * d11);
        }
        double d14 = 0.0;
        for (n3 = 0; n3 < this.b; ++n3) {
            n2 = this.f[n3];
            d3 = 0.0;
            for (int i5 = 0; i5 <= n3; ++i5) {
                d3 += this.p[i5][n2] * dArray[i5];
            }
            double d15 = d3 /= dArray2[n2];
            d14 += d15 * d15;
        }
        double d16 = BY.a(d14);
        d3 = d16 / d2;
        if (d3 == 0.0) {
            d3 = cq_0.b / BY.d(d2, 0.1);
        }
        this.h = BY.d(d3, BY.e(this.h, d10));
        if (this.h == 0.0) {
            this.h = d16 / d6;
        }
        for (int i6 = 10; i6 >= 0; --i6) {
            int n10;
            int n11;
            double d17;
            int n12;
            int n13;
            if (this.h == 0.0) {
                this.h = BY.e(cq_0.b, d3 * 0.001);
            }
            double d18 = BY.a(this.h);
            for (n13 = 0; n13 < this.b; ++n13) {
                n12 = this.f[n13];
                dArray3[n12] = d18 * dArray2[n12];
            }
            this.a(dArray, dArray3, dArray4, dArray5);
            d6 = 0.0;
            for (n13 = 0; n13 < this.b; ++n13) {
                n12 = this.f[n13];
                dArray5[n12] = d17 = dArray2[n12] * this.i[n12];
                double d19 = d17;
                d6 += d19 * d19;
            }
            d6 = BY.a(d6);
            double d20 = d9;
            d9 = d6 - d2;
            if (BY.w(d9) <= d2 * 0.1 || d10 == 0.0 && d9 <= d20 && d20 < 0.0) {
                return;
            }
            for (n11 = 0; n11 < this.b; ++n11) {
                n10 = this.f[n11];
                dArray3[n10] = dArray5[n10] * dArray2[n10] / d6;
            }
            for (n11 = 0; n11 < this.b; ++n11) {
                int n14 = n10 = this.f[n11];
                dArray3[n14] = dArray3[n14] / dArray4[n11];
                double d21 = dArray3[n10];
                for (n5 = n11 + 1; n5 < this.b; ++n5) {
                    int n15 = this.f[n5];
                    dArray3[n15] = dArray3[n15] - this.p[n5][n10] * d21;
                }
            }
            d14 = 0.0;
            for (n11 = 0; n11 < this.b; ++n11) {
                double d22;
                double d23 = d22 = dArray3[this.f[n11]];
                d14 += d23 * d23;
            }
            d17 = d9 / (d2 * d14);
            if (d9 > 0.0) {
                d10 = BY.e(d10, this.h);
            } else if (d9 < 0.0) {
                d3 = BY.d(d3, this.h);
            }
            this.h = BY.e(d10, this.h + d17);
        }
    }

    private void a(double[] dArray, double[] dArray2, double[] dArray3, double[] dArray4) {
        int n2;
        int n3;
        for (n3 = 0; n3 < this.b; ++n3) {
            n2 = this.f[n3];
            for (int i2 = n3 + 1; i2 < this.b; ++i2) {
                this.p[i2][n2] = this.p[n3][this.f[i2]];
            }
            this.i[n3] = this.c[n2];
            dArray4[n3] = dArray[n3];
        }
        for (n3 = 0; n3 < this.b; ++n3) {
            n2 = this.f[n3];
            double d2 = dArray2[n2];
            if (d2 != 0.0) {
                Arrays.fill(dArray3, n3 + 1, dArray3.length, 0.0);
            }
            dArray3[n3] = d2;
            double d3 = 0.0;
            for (int i3 = n3; i3 < this.b; ++i3) {
                double d4;
                double d5;
                double d6;
                double d7;
                n2 = this.f[i3];
                if (dArray3[i3] == 0.0) continue;
                double d8 = this.p[i3][n2];
                if (BY.w(d7) < BY.w(dArray3[i3])) {
                    double d9 = d6 = d8 / dArray3[i3];
                    d5 = 1.0 / BY.a(1.0 + d9 * d9);
                    d4 = d5 * d6;
                } else {
                    double d10 = d6 = dArray3[i3] / d8;
                    d4 = 1.0 / BY.a(1.0 + d10 * d10);
                    d5 = d4 * d6;
                }
                this.p[i3][n2] = d4 * d8 + d5 * dArray3[i3];
                d6 = d4 * dArray4[i3] + d5 * d3;
                d3 = -d5 * dArray4[i3] + d4 * d3;
                dArray4[i3] = d6;
                for (int i4 = i3 + 1; i4 < this.b; ++i4) {
                    double d11 = this.p[i4][n2];
                    double d12 = d4 * d11 + d5 * dArray3[i4];
                    dArray3[i4] = -d5 * d11 + d4 * dArray3[i4];
                    this.p[i4][n2] = d12;
                }
            }
            dArray3[n3] = this.p[n3][this.f[n3]];
            this.p[n3][this.f[n3]] = this.i[n3];
        }
        n3 = this.b;
        for (n2 = 0; n2 < this.b; ++n2) {
            if (dArray3[n2] == 0.0 && n3 == this.b) {
                n3 = n2;
            }
            if (n3 >= this.b) continue;
            dArray4[n2] = 0.0;
        }
        if (n3 > 0) {
            for (n2 = n3 - 1; n2 >= 0; --n2) {
                int n4 = this.f[n2];
                double d13 = 0.0;
                for (int i5 = n2 + 1; i5 < n3; ++i5) {
                    d13 += this.p[i5][n4] * dArray4[i5];
                }
                dArray4[n2] = (dArray4[n2] - d13) / dArray3[n2];
            }
        }
        for (n2 = 0; n2 < this.i.length; ++n2) {
            this.i[this.f[n2]] = dArray4[n2];
        }
    }

    private void a(tq_0 tq_02) {
        int n2;
        this.p = tq_02.b(-1.0).a();
        int n3 = this.p.length;
        int n4 = this.p[0].length;
        for (n2 = 0; n2 < n4; ++n2) {
            int n5 = n2;
            this.f[n5] = n5;
            double d2 = 0.0;
            for (int i2 = 0; i2 < n3; ++i2) {
                double d3;
                double d4 = d3 = this.p[i2][n2];
                d2 += d4 * d4;
            }
            this.d[n2] = BY.a(d2);
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
                    double d10 = d9 = this.p[i3][this.f[n6]];
                    d7 += d10 * d10;
                }
                if (Double.isInfinite(d7) || Double.isNaN(d7)) {
                    throw new oR(px_0.UNABLE_TO_PERFORM_QR_DECOMPOSITION_ON_JACOBIAN, n3, n4);
                }
                if (!(d7 > d8)) continue;
                n7 = n6;
                d8 = d7;
            }
            if (d8 <= this.n) {
                this.g = n2;
                return;
            }
            n6 = this.f[n7];
            this.f[n7] = this.f[n2];
            this.f[n2] = n6;
            d7 = this.p[n2][n6];
            double d11 = d6 > 0.0 ? -BY.a(d8) : BY.a(d8);
            this.e[n6] = d5 = 1.0 / (d8 - d7 * d11);
            this.c[n6] = d11;
            double[] dArray = this.p[n2];
            int n8 = n6;
            dArray[n8] = dArray[n8] - d11;
            for (int i4 = n4 - 1 - n2; i4 > 0; --i4) {
                double d12 = 0.0;
                for (n7 = n2; n7 < n3; ++n7) {
                    d12 += this.p[n7][n6] * this.p[n7][this.f[n2 + i4]];
                }
                d12 *= d5;
                for (n7 = n2; n7 < n3; ++n7) {
                    double[] dArray2 = this.p[n7];
                    int n9 = this.f[n2 + i4];
                    dArray2[n9] = dArray2[n9] - d12 * this.p[n7][n6];
                }
            }
        }
        this.g = this.b;
    }

    private void f(double[] dArray) {
        int n2 = this.p.length;
        int n3 = this.p[0].length;
        for (int i2 = 0; i2 < n3; ++i2) {
            int n4;
            int n5 = this.f[i2];
            double d2 = 0.0;
            for (n4 = i2; n4 < n2; ++n4) {
                d2 += this.p[n4][n5] * dArray[n4];
            }
            d2 *= this.e[n5];
            for (n4 = i2; n4 < n2; ++n4) {
                int n6 = n4;
                dArray[n6] = dArray[n6] - d2 * this.p[n4][n5];
            }
        }
    }

    private void p() {
        if (this.f() != null || this.g() != null) {
            throw new pb_0(px_0.CONSTRAINT, new Object[0]);
        }
    }

    @Override
    public final /* synthetic */ Object c() {
        xK xK2;
        xK xK3 = xK2 = this;
        if (xK2.f() != null || xK3.g() != null) {
            throw new pb_0(px_0.CONSTRAINT, new Object[0]);
        }
        int n2 = xK2.d().length;
        double[] dArray = xK2.e();
        int n3 = dArray.length;
        xK2.b = BY.a(n2, n3);
        xK2.c = new double[n3];
        xK2.d = new double[n3];
        xK2.e = new double[n3];
        xK2.f = new int[n3];
        xK2.i = new double[n3];
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
        tq_0 tq_02 = xK2.n();
        double[] dArray9 = xK2.b(dArray);
        double[] dArray10 = xK2.e(dArray9);
        wR wR2 = new wR(dArray, dArray9);
        double d4 = xK2.d(dArray10);
        xK2.h = 0.0;
        boolean bl = true;
        wK<wR> wK2 = xK2.j();
        block0: while (true) {
            double d5;
            int n4;
            int n5;
            double d6;
            double d7;
            int n6;
            int n7;
            int n8;
            Object object;
            wR wR3;
            block84: {
                xK2.l();
                wR3 = wR2;
                xK xK4 = xK2;
                object = xK4.c(dArray);
                xK3 = xK4;
                xK4.p = object.b(-1.0).a();
                n8 = xK3.p.length;
                n7 = xK3.p[0].length;
                for (n6 = 0; n6 < n7; ++n6) {
                    int n9 = n6;
                    xK3.f[n9] = n9;
                    double d8 = 0.0;
                    for (int i2 = 0; i2 < n8; ++i2) {
                        double d9;
                        double d10 = d9 = xK3.p[i2][n6];
                        d8 += d10 * d10;
                    }
                    xK3.d[n6] = BY.a(d8);
                }
                for (n6 = 0; n6 < n7; ++n6) {
                    double d11;
                    double d12;
                    int n10;
                    int n11 = -1;
                    d7 = Double.NEGATIVE_INFINITY;
                    for (n10 = n6; n10 < n7; ++n10) {
                        d6 = 0.0;
                        for (int i3 = n6; i3 < n8; ++i3) {
                            double d13;
                            double d14 = d13 = xK3.p[i3][xK3.f[n10]];
                            d6 += d14 * d14;
                        }
                        if (Double.isInfinite(d6) || Double.isNaN(d6)) {
                            throw new oR(px_0.UNABLE_TO_PERFORM_QR_DECOMPOSITION_ON_JACOBIAN, n8, n7);
                        }
                        if (!(d6 > d7)) continue;
                        n11 = n10;
                        d7 = d6;
                    }
                    if (d7 <= xK3.n) {
                        xK3.g = n6;
                        break block84;
                    }
                    n10 = xK3.f[n11];
                    xK3.f[n11] = xK3.f[n6];
                    xK3.f[n6] = n10;
                    d6 = xK3.p[n6][n10];
                    double d15 = d12 > 0.0 ? -BY.a(d7) : BY.a(d7);
                    xK3.e[n10] = d11 = 1.0 / (d7 - d6 * d15);
                    xK3.c[n10] = d15;
                    double[] dArray11 = xK3.p[n6];
                    int n12 = n10;
                    dArray11[n12] = dArray11[n12] - d15;
                    for (int i4 = n7 - 1 - n6; i4 > 0; --i4) {
                        double d16 = 0.0;
                        for (n5 = n6; n5 < n8; ++n5) {
                            d16 += xK3.p[n5][n10] * xK3.p[n5][xK3.f[n6 + i4]];
                        }
                        d16 *= d11;
                        for (n5 = n6; n5 < n8; ++n5) {
                            double[] dArray12 = xK3.p[n5];
                            int n13 = xK3.f[n6 + i4];
                            dArray12[n13] = dArray12[n13] - d16 * xK3.p[n5][n10];
                        }
                    }
                }
                xK3.g = xK3.b;
            }
            xK2.o = tq_02.a(dArray10);
            for (n4 = 0; n4 < n2; ++n4) {
                dArray5[n4] = xK2.o[n4];
            }
            object = dArray5;
            xK3 = xK2;
            n8 = xK3.p.length;
            n7 = xK3.p[0].length;
            for (n6 = 0; n6 < n7; ++n6) {
                int n14;
                int n15 = xK3.f[n6];
                d7 = 0.0;
                for (n14 = n6; n14 < n8; ++n14) {
                    d7 += xK3.p[n14][n15] * object[n14];
                }
                d7 *= xK3.e[n15];
                for (n14 = n6; n14 < n8; ++n14) {
                    Object object2 = object;
                    int n16 = n14;
                    object2[n16] = object2[n16] - d7 * xK3.p[n14][n15];
                }
            }
            for (n4 = 0; n4 < xK2.b; ++n4) {
                int n17 = xK2.f[n4];
                xK2.p[n4][n17] = xK2.c[n17];
            }
            if (bl) {
                d3 = 0.0;
                for (n4 = 0; n4 < n3; ++n4) {
                    double d17;
                    double d18 = xK2.d[n4];
                    if (d18 == 0.0) {
                        d18 = 1.0;
                    }
                    double d19 = d17 = d18 * dArray[n4];
                    d3 += d19 * d19;
                    dArray2[n4] = d18;
                }
                d2 = (d3 = BY.a(d3)) == 0.0 ? xK2.j : xK2.j * d3;
            }
            double d20 = 0.0;
            if (d4 != 0.0) {
                for (int i5 = 0; i5 < xK2.b; ++i5) {
                    int n18 = xK2.f[i5];
                    d5 = xK2.d[n18];
                    if (d5 == 0.0) continue;
                    double d21 = 0.0;
                    for (int i6 = 0; i6 <= i5; ++i6) {
                        d21 += xK2.p[i6][n18] * dArray5[i6];
                    }
                    d20 = BY.e(d20, BY.w(d21) / (d5 * d4));
                }
            }
            if (d20 <= xK2.m) {
                xK2.a(d4);
                return wR2;
            }
            for (int i7 = 0; i7 < n3; ++i7) {
                dArray2[i7] = BY.e(dArray2[i7], xK2.d[i7]);
            }
            double d22 = 0.0;
            do {
                int n19;
                double d23;
                double d24;
                double d25;
                int n20;
                if (!(d22 < 1.0E-4)) continue block0;
                for (int i8 = 0; i8 < xK2.b; ++i8) {
                    int n21 = xK2.f[i8];
                    dArray3[n21] = dArray[n21];
                }
                d5 = d4;
                double[] dArray13 = xK2.o;
                xK2.o = dArray4;
                dArray4 = dArray13;
                dArray13 = dArray9;
                double[] dArray14 = dArray9;
                double[] dArray15 = dArray8;
                double[] dArray16 = dArray7;
                double[] dArray17 = dArray6;
                dArray13 = dArray2;
                double d26 = d2;
                object = dArray5;
                xK xK5 = xK2;
                int n22 = xK5.p[0].length;
                for (n20 = 0; n20 < xK5.g; ++n20) {
                    xK5.i[xK5.f[n20]] = (double)object[n20];
                }
                for (n20 = xK5.g; n20 < n22; ++n20) {
                    xK5.i[xK5.f[n20]] = 0.0;
                }
                for (n20 = xK5.g - 1; n20 >= 0; --n20) {
                    int n23 = xK5.f[n20];
                    double d27 = xK5.i[n23] / xK5.c[n23];
                    for (int i9 = 0; i9 < n20; ++i9) {
                        int n24 = xK5.f[i9];
                        xK5.i[n24] = xK5.i[n24] - d27 * xK5.p[i9][n23];
                    }
                    xK5.i[n23] = d27;
                }
                d6 = 0.0;
                for (int i10 = 0; i10 < xK5.b; ++i10) {
                    double d28;
                    int n25 = xK5.f[i10];
                    dArray17[n25] = d28 = dArray13[n25] * xK5.i[n25];
                    double d29 = d28;
                    d6 += d29 * d29;
                }
                d6 = BY.a(d6);
                double d30 = d6 - d26;
                if (d25 <= d26 * 0.1) {
                    xK5.h = 0.0;
                } else {
                    double d31;
                    int n26;
                    double d32 = 0.0;
                    if (xK5.g == xK5.b) {
                        for (n26 = 0; n26 < xK5.b; ++n26) {
                            int n27 = n5 = xK5.f[n26];
                            dArray17[n27] = dArray17[n27] * (dArray13[n5] / d6);
                        }
                        double d33 = 0.0;
                        for (n26 = 0; n26 < xK5.b; ++n26) {
                            double d34;
                            n5 = xK5.f[n26];
                            d31 = 0.0;
                            for (int i11 = 0; i11 < n26; ++i11) {
                                d31 += xK5.p[i11][n5] * dArray17[xK5.f[i11]];
                            }
                            dArray17[n5] = d34 = (dArray17[n5] - d31) / xK5.c[n5];
                            double d35 = d34;
                            d33 += d35 * d35;
                        }
                        d32 = d30 / (d26 * d33);
                    }
                    double d36 = 0.0;
                    for (n26 = 0; n26 < xK5.b; ++n26) {
                        n5 = xK5.f[n26];
                        d31 = 0.0;
                        for (int i12 = 0; i12 <= n26; ++i12) {
                            d31 += xK5.p[i12][n5] * object[i12];
                        }
                        double d37 = d31 /= dArray13[n5];
                        d36 += d37 * d37;
                    }
                    double d38 = BY.a(d36);
                    d31 = d38 / d26;
                    if (d31 == 0.0) {
                        d31 = cq_0.b / BY.d(d26, 0.1);
                    }
                    xK5.h = BY.d(d31, BY.e(xK5.h, d32));
                    if (xK5.h == 0.0) {
                        xK5.h = d38 / d6;
                    }
                    for (int i13 = 10; i13 >= 0; --i13) {
                        int n28;
                        int n29;
                        double d39;
                        int n30;
                        int n31;
                        int n32;
                        int n33;
                        if (xK5.h == 0.0) {
                            xK5.h = BY.e(cq_0.b, d31 * 0.001);
                        }
                        double d40 = BY.a(xK5.h);
                        for (n33 = 0; n33 < xK5.b; ++n33) {
                            n32 = xK5.f[n33];
                            dArray17[n32] = d40 * dArray13[n32];
                        }
                        double[] dArray18 = dArray15;
                        double[] dArray19 = dArray16;
                        double[] dArray20 = dArray17;
                        Object object3 = object;
                        xK xK6 = xK5;
                        for (n31 = 0; n31 < xK6.b; ++n31) {
                            n30 = xK6.f[n31];
                            for (int i14 = n31 + 1; i14 < xK6.b; ++i14) {
                                xK6.p[i14][n30] = xK6.p[n31][xK6.f[i14]];
                            }
                            xK6.i[n31] = xK6.c[n30];
                            dArray18[n31] = (double)object3[n31];
                        }
                        for (n31 = 0; n31 < xK6.b; ++n31) {
                            n30 = xK6.f[n31];
                            double d41 = dArray20[n30];
                            if (d41 != 0.0) {
                                Arrays.fill(dArray19, n31 + 1, dArray19.length, 0.0);
                            }
                            dArray19[n31] = d41;
                            double d42 = 0.0;
                            for (int i15 = n31; i15 < xK6.b; ++i15) {
                                double d43;
                                double d44;
                                double d45;
                                double d46;
                                int n34 = xK6.f[i15];
                                if (dArray19[i15] == 0.0) continue;
                                double d47 = xK6.p[i15][n34];
                                if (BY.w(d46) < BY.w(dArray19[i15])) {
                                    double d48 = d45 = d47 / dArray19[i15];
                                    d44 = 1.0 / BY.a(1.0 + d48 * d48);
                                    d43 = d44 * d45;
                                } else {
                                    double d49 = d45 = dArray19[i15] / d47;
                                    d43 = 1.0 / BY.a(1.0 + d49 * d49);
                                    d44 = d43 * d45;
                                }
                                xK6.p[i15][n34] = d43 * d47 + d44 * dArray19[i15];
                                d45 = d43 * dArray18[i15] + d44 * d42;
                                d42 = -d44 * dArray18[i15] + d43 * d42;
                                dArray18[i15] = d45;
                                for (int i16 = i15 + 1; i16 < xK6.b; ++i16) {
                                    double d50 = xK6.p[i16][n34];
                                    double d51 = d43 * d50 + d44 * dArray19[i16];
                                    dArray19[i16] = -d44 * d50 + d43 * dArray19[i16];
                                    xK6.p[i16][n34] = d51;
                                }
                            }
                            dArray19[n31] = xK6.p[n31][xK6.f[n31]];
                            xK6.p[n31][xK6.f[n31]] = xK6.i[n31];
                        }
                        n31 = xK6.b;
                        for (n30 = 0; n30 < xK6.b; ++n30) {
                            if (dArray19[n30] == 0.0 && n31 == xK6.b) {
                                n31 = n30;
                            }
                            if (n31 >= xK6.b) continue;
                            dArray18[n30] = 0.0;
                        }
                        if (n31 > 0) {
                            for (n30 = n31 - 1; n30 >= 0; --n30) {
                                int n35 = xK6.f[n30];
                                double d52 = 0.0;
                                for (int i17 = n30 + 1; i17 < n31; ++i17) {
                                    d52 += xK6.p[i17][n35] * dArray18[i17];
                                }
                                dArray18[n30] = (dArray18[n30] - d52) / dArray19[n30];
                            }
                        }
                        for (n30 = 0; n30 < xK6.i.length; ++n30) {
                            xK6.i[xK6.f[n30]] = dArray18[n30];
                        }
                        d6 = 0.0;
                        for (n33 = 0; n33 < xK5.b; ++n33) {
                            n32 = xK5.f[n33];
                            dArray15[n32] = d39 = dArray13[n32] * xK5.i[n32];
                            double d53 = d39;
                            d6 += d53 * d53;
                        }
                        d6 = BY.a(d6);
                        double d54 = d30;
                        d30 = d6 - d26;
                        if (BY.w(d30) <= d26 * 0.1 || d32 == 0.0 && d30 <= d54 && d54 < 0.0) break;
                        for (n29 = 0; n29 < xK5.b; ++n29) {
                            n28 = xK5.f[n29];
                            dArray17[n28] = dArray15[n28] * dArray13[n28] / d6;
                        }
                        for (n29 = 0; n29 < xK5.b; ++n29) {
                            int n36 = n28 = xK5.f[n29];
                            dArray17[n36] = dArray17[n36] / dArray16[n29];
                            double d55 = dArray17[n28];
                            for (int i18 = n29 + 1; i18 < xK5.b; ++i18) {
                                int n37 = xK5.f[i18];
                                dArray17[n37] = dArray17[n37] - xK5.p[i18][n28] * d55;
                            }
                        }
                        d36 = 0.0;
                        for (n29 = 0; n29 < xK5.b; ++n29) {
                            double d56;
                            double d57 = d56 = dArray17[xK5.f[n29]];
                            d36 += d57 * d57;
                        }
                        d39 = d30 / (d26 * d36);
                        if (d30 > 0.0) {
                            d32 = BY.e(d32, xK5.h);
                        } else if (d30 < 0.0) {
                            d31 = BY.d(d31, xK5.h);
                        }
                        xK5.h = BY.e(d32, xK5.h + d39);
                    }
                }
                double d58 = 0.0;
                for (int i19 = 0; i19 < xK2.b; ++i19) {
                    int n38 = xK2.f[i19];
                    xK2.i[n38] = -xK2.i[n38];
                    dArray[n38] = dArray3[n38] + xK2.i[n38];
                    double d59 = d24 = dArray2[n38] * xK2.i[n38];
                    d58 += d59 * d59;
                }
                d58 = BY.a(d58);
                if (bl) {
                    d2 = BY.d(d2, d58);
                }
                dArray9 = xK2.b(dArray);
                dArray10 = xK2.e(dArray9);
                wR2 = new wR(dArray, dArray9);
                d4 = xK2.d(dArray10);
                double d60 = -1.0;
                if (d4 * 0.1 < d5) {
                    double d61 = d24 = d4 / d5;
                    d60 = 1.0 - d61 * d61;
                }
                for (int i20 = 0; i20 < xK2.b; ++i20) {
                    int n39 = xK2.f[i20];
                    d23 = xK2.i[n39];
                    dArray6[i20] = 0.0;
                    for (int i21 = 0; i21 <= i20; ++i21) {
                        int n40 = i21;
                        dArray6[n40] = dArray6[n40] + xK2.p[i21][n39] * d23;
                    }
                }
                d24 = 0.0;
                for (int i22 = 0; i22 < xK2.b; ++i22) {
                    d24 += dArray6[i22] * dArray6[i22];
                }
                double d62 = d5;
                d23 = d62 * d62;
                double d63 = xK2.h * d58 * d58 / d23;
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
                    xK2.h /= d67;
                } else if (xK2.h == 0.0 || d22 >= 0.75) {
                    d2 = d58 * 2.0;
                    xK2.h *= 0.5;
                }
                if (d22 >= 1.0E-4) {
                    bl = false;
                    d3 = 0.0;
                    for (n19 = 0; n19 < n3; ++n19) {
                        double d69;
                        double d70 = d69 = dArray2[n19] * dArray[n19];
                        d3 += d70 * d70;
                    }
                    d3 = BY.a(d3);
                    if (wK2 != null && wK2.a(xK2.i(), wR3, wR2)) {
                        xK2.a(d4);
                        return wR2;
                    }
                } else {
                    d4 = d5;
                    for (n19 = 0; n19 < xK2.b; ++n19) {
                        int n41 = xK2.f[n19];
                        dArray[n41] = dArray3[n41];
                    }
                    dArray13 = xK2.o;
                    xK2.o = dArray4;
                    dArray4 = dArray13;
                    dArray9 = dArray14;
                    wR2 = new wR(dArray, dArray9);
                }
                if (BY.w(d60) <= xK2.k && d64 <= xK2.k && d22 <= 2.0 || d2 <= xK2.l * d3) {
                    xK2.a(d4);
                    return wR2;
                }
                if (BY.w(d60) <= a && d64 <= a && d22 <= 2.0) {
                    throw new oR(px_0.TOO_SMALL_COST_RELATIVE_TOLERANCE, xK2.k);
                }
                if (!(d2 <= a * d3)) continue;
                throw new oR(px_0.TOO_SMALL_PARAMETERS_RELATIVE_TOLERANCE, xK2.l);
            } while (!(d20 <= a));
            break;
        }
        throw new oR(px_0.TOO_SMALL_ORTHOGONALITY_TOLERANCE, xK2.m);
    }
}

