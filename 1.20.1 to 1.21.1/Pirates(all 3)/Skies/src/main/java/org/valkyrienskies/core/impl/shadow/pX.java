/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Arrays;
import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.cb_0;
import org.valkyrienskies.core.impl.shadow.cq_0;
import org.valkyrienskies.core.impl.shadow.oR;
import org.valkyrienskies.core.impl.shadow.pV;
import org.valkyrienskies.core.impl.shadow.pW;
import org.valkyrienskies.core.impl.shadow.pZ;
import org.valkyrienskies.core.impl.shadow.px_0;
import org.valkyrienskies.core.impl.shadow.sA;
import org.valkyrienskies.core.impl.shadow.tq_0;
import org.valkyrienskies.core.impl.shadow.tu_0;
import org.valkyrienskies.core.impl.shadow.wK;

public final class pX
implements pV {
    private static final double a = 2.0 * cq_0.a;
    private final double b;
    private final double c;
    private final double d;
    private final double e;
    private final double f;

    public pX() {
        this(100.0, 1.0E-10, 1.0E-10, 1.0E-10, cq_0.b);
    }

    private pX(double d2, double d3, double d4, double d5, double d6) {
        this.b = d2;
        this.c = d3;
        this.d = d4;
        this.e = d5;
        this.f = d6;
    }

    private pX a(double d2) {
        return new pX(d2, this.c, this.d, this.e, this.f);
    }

    private pX b(double d2) {
        return new pX(this.b, d2, this.d, this.e, this.f);
    }

    private pX c(double d2) {
        return new pX(this.b, this.c, d2, this.e, this.f);
    }

    private pX d(double d2) {
        return new pX(this.b, this.c, this.d, d2, this.f);
    }

    private pX e(double d2) {
        return new pX(this.b, this.c, this.d, this.e, d2);
    }

    private double a() {
        return this.b;
    }

    private double b() {
        return this.c;
    }

    private double c() {
        return this.d;
    }

    private double d() {
        return this.e;
    }

    private double e() {
        return this.f;
    }

    public final pZ a(pW pW2) {
        int n2 = pW2.b();
        int n3 = pW2.c();
        cb_0 cb_02 = pW2.e();
        cb_0 cb_03 = pW2.d();
        wK<pW.a> wK2 = pW2.f();
        int n4 = BY.a(n2, n3);
        double[] dArray = new double[n3];
        double d2 = 0.0;
        double d3 = 0.0;
        double d4 = 0.0;
        double[] dArray2 = new double[n3];
        double[] dArray3 = new double[n3];
        double[] cfr_ignored_0 = new double[n2];
        double[] dArray4 = new double[n2];
        double[] dArray5 = new double[n3];
        double[] dArray6 = new double[n3];
        double[] dArray7 = new double[n3];
        cb_03.c();
        pW pW3 = pW2;
        pW.a a2 = pW3.a(pW3.a());
        double[] dArray8 = a2.d().g();
        double d5 = a2.b();
        double[] dArray9 = a2.e().g();
        boolean bl = true;
        block0: while (true) {
            double d6;
            int n5;
            int n6;
            a a3;
            double d7;
            double[] dArray10;
            double[][] dArray11;
            Object object;
            Object object2;
            pW.a a4;
            block85: {
                int n7;
                cb_02.c();
                a4 = a2;
                int n8 = n4;
                object2 = a2.c();
                object = this;
                dArray11 = object2.b(-1.0).a();
                int n9 = dArray11.length;
                int n10 = dArray11[0].length;
                int[] nArray = new int[n10];
                double[] dArray12 = new double[n10];
                double[] dArray13 = new double[n10];
                dArray10 = new double[n10];
                for (n7 = 0; n7 < n10; ++n7) {
                    int n11 = n7;
                    nArray[n11] = n11;
                    double d8 = 0.0;
                    for (int i2 = 0; i2 < n9; ++i2) {
                        double d9;
                        double d10 = d9 = dArray11[i2][n7];
                        d8 += d10 * d10;
                    }
                    dArray13[n7] = BY.a(d8);
                }
                for (n7 = 0; n7 < n10; ++n7) {
                    double d11;
                    double d12;
                    double d13;
                    int n12;
                    int n13 = -1;
                    double d14 = Double.NEGATIVE_INFINITY;
                    for (n12 = n7; n12 < n10; ++n12) {
                        d13 = 0.0;
                        for (int i3 = n7; i3 < n9; ++i3) {
                            double d15 = d7 = dArray11[i3][nArray[n12]];
                            d13 += d15 * d15;
                        }
                        if (Double.isInfinite(d13) || Double.isNaN(d13)) {
                            throw new oR(px_0.UNABLE_TO_PERFORM_QR_DECOMPOSITION_ON_JACOBIAN, n9, n10);
                        }
                        if (!(d13 > d14)) continue;
                        n13 = n12;
                        d14 = d13;
                    }
                    if (d14 <= ((pX)object).f) {
                        a3 = new a(dArray11, nArray, n7, dArray12, dArray13, dArray10);
                        break block85;
                    }
                    n12 = nArray[n13];
                    nArray[n13] = nArray[n7];
                    nArray[n7] = n12;
                    d13 = dArray11[n7][n12];
                    double d16 = d12 > 0.0 ? -BY.a(d14) : BY.a(d14);
                    dArray10[n12] = d11 = 1.0 / (d14 - d13 * d16);
                    dArray12[n12] = d16;
                    double[] dArray14 = dArray11[n7];
                    int n14 = n12;
                    dArray14[n14] = dArray14[n14] - d16;
                    for (n6 = n10 - 1 - n7; n6 > 0; --n6) {
                        int n15;
                        double d17 = 0.0;
                        for (n15 = n7; n15 < n9; ++n15) {
                            d17 += dArray11[n15][n12] * dArray11[n15][nArray[n7 + n6]];
                        }
                        d17 *= d11;
                        for (n15 = n7; n15 < n9; ++n15) {
                            double[] dArray15 = dArray11[n15];
                            int n16 = nArray[n7 + n6];
                            dArray15[n16] = dArray15[n16] - d17 * dArray11[n15][n12];
                        }
                    }
                }
                a3 = new a(dArray11, nArray, n8, dArray12, dArray13, dArray10);
            }
            a a5 = a3;
            Object object3 = a3;
            double[][] dArray16 = a3.a;
            object3 = a5;
            int[] nArray = ((a)object3).b;
            object3 = a5;
            double[] dArray17 = ((a)object3).d;
            object = a5;
            double[] dArray18 = ((a)object).e;
            object = dArray8;
            for (n5 = 0; n5 < n2; ++n5) {
                dArray4[n5] = (double)object[n5];
            }
            object2 = a5;
            object = dArray4;
            object3 = object2;
            dArray11 = ((a)object3).a;
            object3 = object2;
            int[] nArray2 = ((a)object3).b;
            Object object4 = object2;
            double[] dArray19 = ((a)object4).f;
            int n17 = dArray11.length;
            int n18 = dArray11[0].length;
            for (int i4 = 0; i4 < n18; ++i4) {
                int n19;
                int n20 = nArray2[i4];
                double d18 = 0.0;
                for (n19 = i4; n19 < n17; ++n19) {
                    d18 += dArray11[n19][n20] * object[n19];
                }
                d18 *= dArray19[n20];
                for (n19 = i4; n19 < n17; ++n19) {
                    Object object5 = object;
                    int n21 = n19;
                    object5[n21] = object5[n21] - d18 * dArray11[n19][n20];
                }
            }
            for (n5 = 0; n5 < n4; ++n5) {
                int n22 = nArray[n5];
                dArray16[n5][n22] = dArray17[n22];
            }
            if (bl) {
                d4 = 0.0;
                for (n5 = 0; n5 < n3; ++n5) {
                    double d19;
                    double d20 = dArray18[n5];
                    if (d20 == 0.0) {
                        d20 = 1.0;
                    }
                    double d21 = d19 = d20 * dArray9[n5];
                    d4 += d21 * d21;
                    dArray2[n5] = d20;
                }
                d3 = (d4 = BY.a(d4)) == 0.0 ? this.b : this.b * d4;
            }
            double d22 = 0.0;
            if (d5 != 0.0) {
                for (int i5 = 0; i5 < n4; ++i5) {
                    int n23 = nArray[i5];
                    d6 = dArray18[n23];
                    if (d6 == 0.0) continue;
                    double d23 = 0.0;
                    for (int i6 = 0; i6 <= i5; ++i6) {
                        d23 += dArray16[i6][n23] * dArray4[i6];
                    }
                    d22 = BY.e(d22, BY.w(d23) / (d6 * d5));
                }
            }
            if (d22 <= this.e) {
                cb_0 cb_04 = cb_03;
                object3 = cb_04;
                object3 = cb_02;
                return new pZ(a2, cb_04.b, ((cb_0)object3).b);
            }
            for (int i7 = 0; i7 < n3; ++i7) {
                dArray2[i7] = BY.e(dArray2[i7], dArray18[i7]);
            }
            double d24 = 0.0;
            do {
                int n24;
                double d25;
                double d26;
                double d27;
                block86: {
                    double d28;
                    double d29;
                    int n25;
                    if (!(d24 < 1.0E-4)) continue block0;
                    for (int i8 = 0; i8 < n4; ++i8) {
                        int n26 = nArray[i8];
                        dArray3[n26] = dArray9[n26];
                    }
                    d6 = d5;
                    double d30 = d2;
                    double[] dArray20 = dArray;
                    dArray10 = dArray7;
                    double[] dArray21 = dArray6;
                    double[] dArray22 = dArray5;
                    n17 = n4;
                    a a6 = a5;
                    double[] dArray23 = dArray2;
                    double d31 = d3;
                    double[] dArray24 = dArray4;
                    object = this;
                    object3 = a6;
                    object4 = ((a)object3).a;
                    object3 = a6;
                    int[] nArray3 = ((a)object3).b;
                    Object object6 = a6;
                    int n27 = ((a)object6).c;
                    object3 = a6;
                    double[] dArray25 = ((a)object3).d;
                    int n28 = ((Object)object4[0]).length;
                    for (n25 = 0; n25 < n27; ++n25) {
                        dArray20[nArray3[n25]] = dArray24[n25];
                    }
                    for (n25 = n27; n25 < n28; ++n25) {
                        dArray20[nArray3[n25]] = 0.0;
                    }
                    for (n25 = n27 - 1; n25 >= 0; --n25) {
                        int n29 = nArray3[n25];
                        d29 = dArray20[n29] / dArray25[n29];
                        for (int i9 = 0; i9 < n25; ++i9) {
                            int n30 = nArray3[i9];
                            dArray20[n30] = dArray20[n30] - d29 * object4[i9][n29];
                        }
                        dArray20[n29] = d29;
                    }
                    d7 = 0.0;
                    for (int i10 = 0; i10 < n17; ++i10) {
                        double d32;
                        n6 = nArray3[i10];
                        dArray22[n6] = d32 = dArray23[n6] * dArray20[n6];
                        double d33 = d32;
                        d7 += d33 * d33;
                    }
                    d7 = BY.a(d7);
                    d29 = d7 - d31;
                    if (d28 <= d31 * 0.1) {
                        d27 = 0.0;
                    } else {
                        double d34;
                        int n31;
                        int n32;
                        double d35 = 0.0;
                        if (n27 == n17) {
                            for (n32 = 0; n32 < n17; ++n32) {
                                int n33 = n31 = nArray3[n32];
                                dArray22[n33] = dArray22[n33] * (dArray23[n31] / d7);
                            }
                            double d36 = 0.0;
                            for (n32 = 0; n32 < n17; ++n32) {
                                double d37;
                                n31 = nArray3[n32];
                                d34 = 0.0;
                                for (int i11 = 0; i11 < n32; ++i11) {
                                    d34 += object4[i11][n31] * dArray22[nArray3[i11]];
                                }
                                dArray22[n31] = d37 = (dArray22[n31] - d34) / dArray25[n31];
                                double d38 = d37;
                                d36 += d38 * d38;
                            }
                            d35 = d29 / (d31 * d36);
                        }
                        double d39 = 0.0;
                        for (n32 = 0; n32 < n17; ++n32) {
                            n31 = nArray3[n32];
                            d34 = 0.0;
                            for (int i12 = 0; i12 <= n32; ++i12) {
                                d34 += object4[i12][n31] * dArray24[i12];
                            }
                            double d40 = d34 /= dArray23[n31];
                            d39 += d40 * d40;
                        }
                        double d41 = BY.a(d39);
                        d34 = d41 / d31;
                        if (d34 == 0.0) {
                            d34 = cq_0.b / BY.d(d31, 0.1);
                        }
                        if ((d30 = BY.d(d34, BY.e(d30, d35))) == 0.0) {
                            d30 = d41 / d7;
                        }
                        for (int i13 = 10; i13 >= 0; --i13) {
                            int n34;
                            int n35;
                            double d42;
                            int n36;
                            int n37;
                            int n38;
                            int n39;
                            if (d30 == 0.0) {
                                d30 = BY.e(cq_0.b, d34 * 0.001);
                            }
                            double d43 = BY.a(d30);
                            for (n39 = 0; n39 < n17; ++n39) {
                                n38 = nArray3[n39];
                                dArray22[n38] = d43 * dArray23[n38];
                            }
                            double[] dArray26 = dArray20;
                            double[] dArray27 = dArray10;
                            int n40 = n17;
                            a a7 = a6;
                            double[] dArray28 = dArray21;
                            double[] dArray29 = dArray22;
                            object6 = dArray24;
                            object3 = a7;
                            int[] nArray4 = ((a)object3).b;
                            object3 = a7;
                            double[][] dArray30 = ((a)object3).a;
                            object3 = a7;
                            double[] dArray31 = ((a)object3).d;
                            for (n37 = 0; n37 < n40; ++n37) {
                                n36 = nArray4[n37];
                                for (int i14 = n37 + 1; i14 < n40; ++i14) {
                                    dArray30[i14][n36] = dArray30[n37][nArray4[i14]];
                                }
                                dArray26[n37] = dArray31[n36];
                                dArray27[n37] = (double)object6[n37];
                            }
                            for (n37 = 0; n37 < n40; ++n37) {
                                n36 = nArray4[n37];
                                double d44 = dArray29[n36];
                                if (d44 != 0.0) {
                                    Arrays.fill(dArray28, n37 + 1, dArray28.length, 0.0);
                                }
                                dArray28[n37] = d44;
                                double d45 = 0.0;
                                for (int i15 = n37; i15 < n40; ++i15) {
                                    double d46;
                                    double d47;
                                    double d48;
                                    double d49;
                                    int n41 = nArray4[i15];
                                    if (dArray28[i15] == 0.0) continue;
                                    double d50 = dArray30[i15][n41];
                                    if (BY.w(d49) < BY.w(dArray28[i15])) {
                                        double d51 = d48 = d50 / dArray28[i15];
                                        d47 = 1.0 / BY.a(1.0 + d51 * d51);
                                        d46 = d47 * d48;
                                    } else {
                                        double d52 = d48 = dArray28[i15] / d50;
                                        d46 = 1.0 / BY.a(1.0 + d52 * d52);
                                        d47 = d46 * d48;
                                    }
                                    dArray30[i15][n41] = d46 * d50 + d47 * dArray28[i15];
                                    d48 = d46 * dArray27[i15] + d47 * d45;
                                    d45 = -d47 * dArray27[i15] + d46 * d45;
                                    dArray27[i15] = d48;
                                    for (int i16 = i15 + 1; i16 < n40; ++i16) {
                                        double d53 = dArray30[i16][n41];
                                        double d54 = d46 * d53 + d47 * dArray28[i16];
                                        dArray28[i16] = -d47 * d53 + d46 * dArray28[i16];
                                        dArray30[i16][n41] = d54;
                                    }
                                }
                                dArray28[n37] = dArray30[n37][nArray4[n37]];
                                dArray30[n37][nArray4[n37]] = dArray26[n37];
                            }
                            n37 = n40;
                            for (n36 = 0; n36 < n40; ++n36) {
                                if (dArray28[n36] == 0.0 && n37 == n40) {
                                    n37 = n36;
                                }
                                if (n37 >= n40) continue;
                                dArray27[n36] = 0.0;
                            }
                            if (n37 > 0) {
                                for (n36 = n37 - 1; n36 >= 0; --n36) {
                                    int n42 = nArray4[n36];
                                    double d55 = 0.0;
                                    for (int i17 = n36 + 1; i17 < n37; ++i17) {
                                        d55 += dArray30[i17][n42] * dArray27[i17];
                                    }
                                    dArray27[n36] = (dArray27[n36] - d55) / dArray28[n36];
                                }
                            }
                            for (n36 = 0; n36 < dArray26.length; ++n36) {
                                dArray26[nArray4[n36]] = dArray27[n36];
                            }
                            d7 = 0.0;
                            for (n39 = 0; n39 < n17; ++n39) {
                                n38 = nArray3[n39];
                                dArray10[n38] = d42 = dArray23[n38] * dArray20[n38];
                                double d56 = d42;
                                d7 += d56 * d56;
                            }
                            d7 = BY.a(d7);
                            double d57 = d29;
                            d29 = d7 - d31;
                            if (BY.w(d29) <= d31 * 0.1 || d35 == 0.0 && d29 <= d57 && d57 < 0.0) {
                                d27 = d30;
                                break block86;
                            }
                            for (n35 = 0; n35 < n17; ++n35) {
                                n34 = nArray3[n35];
                                dArray22[n34] = dArray10[n34] * dArray23[n34] / d7;
                            }
                            for (n35 = 0; n35 < n17; ++n35) {
                                int n43 = n34 = nArray3[n35];
                                dArray22[n43] = dArray22[n43] / dArray21[n35];
                                double d58 = dArray22[n34];
                                for (int i18 = n35 + 1; i18 < n17; ++i18) {
                                    int n44 = nArray3[i18];
                                    dArray22[n44] = dArray22[n44] - object4[i18][n34] * d58;
                                }
                            }
                            d39 = 0.0;
                            for (n35 = 0; n35 < n17; ++n35) {
                                double d59;
                                double d60 = d59 = dArray22[nArray3[n35]];
                                d39 += d60 * d60;
                            }
                            d42 = d29 / (d31 * d39);
                            if (d29 > 0.0) {
                                d35 = BY.e(d35, d30);
                            } else if (d29 < 0.0) {
                                d34 = BY.d(d34, d30);
                            }
                            d30 = BY.e(d35, d30 + d42);
                        }
                        d27 = d30;
                    }
                }
                d2 = d27;
                double d61 = 0.0;
                for (int i19 = 0; i19 < n4; ++i19) {
                    int n45 = nArray[i19];
                    dArray[n45] = -dArray[n45];
                    dArray9[n45] = dArray3[n45] + dArray[n45];
                    double d62 = d26 = dArray2[n45] * dArray[n45];
                    d61 += d62 * d62;
                }
                d61 = BY.a(d61);
                if (bl) {
                    d3 = BY.d(d3, d61);
                }
                cb_03.c();
                a2 = pW2.a((tu_0)((Object)new sA(dArray9)));
                dArray8 = a2.d().g();
                d5 = a2.b();
                dArray9 = a2.e().g();
                double d63 = -1.0;
                if (d5 * 0.1 < d6) {
                    double d64 = d26 = d5 / d6;
                    d63 = 1.0 - d64 * d64;
                }
                for (int i20 = 0; i20 < n4; ++i20) {
                    int n46 = nArray[i20];
                    d25 = dArray[n46];
                    dArray5[i20] = 0.0;
                    for (int i21 = 0; i21 <= i20; ++i21) {
                        int n47 = i21;
                        dArray5[n47] = dArray5[n47] + dArray16[i21][n46] * d25;
                    }
                }
                d26 = 0.0;
                for (int i22 = 0; i22 < n4; ++i22) {
                    d26 += dArray5[i22] * dArray5[i22];
                }
                double d65 = d6;
                d25 = d65 * d65;
                double d66 = d2 * d61 * d61 / d25;
                double d67 = (d26 /= d25) + d66 * 2.0;
                double d68 = -(d26 + d66);
                double d69 = d24 = d67 == 0.0 ? 0.0 : d63 / d67;
                if (d69 <= 0.25) {
                    double d70;
                    double d71 = d70 = d63 < 0.0 ? d68 * 0.5 / (d68 + d63 * 0.5) : 0.5;
                    if (d5 * 0.1 >= d6 || d70 < 0.1) {
                        d70 = 0.1;
                    }
                    d3 = d70 * BY.d(d3, d61 * 10.0);
                    d2 /= d70;
                } else if (d2 == 0.0 || d24 >= 0.75) {
                    d3 = d61 * 2.0;
                    d2 *= 0.5;
                }
                if (d24 >= 1.0E-4) {
                    bl = false;
                    d4 = 0.0;
                    for (n24 = 0; n24 < n3; ++n24) {
                        double d72;
                        double d73 = d72 = dArray2[n24] * dArray9[n24];
                        d4 += d73 * d73;
                    }
                    d4 = BY.a(d4);
                    if (wK2 != null) {
                        object3 = cb_02;
                        if (wK2.a(((cb_0)object3).b, a4, a2)) {
                            cb_0 cb_05 = cb_03;
                            object3 = cb_05;
                            object3 = cb_02;
                            return new pZ(a2, cb_05.b, ((cb_0)object3).b);
                        }
                    }
                } else {
                    d5 = d6;
                    for (n24 = 0; n24 < n4; ++n24) {
                        int n48 = nArray[n24];
                        dArray9[n48] = dArray3[n48];
                    }
                    a2 = a4;
                }
                if (BY.w(d63) <= this.c && d67 <= this.c && d24 <= 2.0 || d3 <= this.d * d4) {
                    cb_0 cb_06 = cb_03;
                    object3 = cb_06;
                    object3 = cb_02;
                    return new pZ(a2, cb_06.b, ((cb_0)object3).b);
                }
                if (BY.w(d63) <= a && d67 <= a && d24 <= 2.0) {
                    throw new oR(px_0.TOO_SMALL_COST_RELATIVE_TOLERANCE, this.c);
                }
                if (!(d3 <= a * d4)) continue;
                throw new oR(px_0.TOO_SMALL_PARAMETERS_RELATIVE_TOLERANCE, this.d);
            } while (!(d22 <= a));
            break;
        }
        throw new oR(px_0.TOO_SMALL_ORTHOGONALITY_TOLERANCE, this.e);
    }

    private double a(double[] dArray, double d2, double[] dArray2, a a2, int n2, double[] dArray3, double[] dArray4, double[] dArray5, double[] dArray6, double d3) {
        double d4;
        int n3;
        int n4;
        double d5;
        int n5;
        Object object = a2;
        double[][] dArray7 = ((a)object).a;
        object = a2;
        int[] nArray = ((a)object).b;
        object = a2;
        int n6 = ((a)object).c;
        object = a2;
        object = ((a)object).d;
        int n7 = dArray7[0].length;
        for (n5 = 0; n5 < n6; ++n5) {
            dArray6[nArray[n5]] = dArray[n5];
        }
        for (n5 = n6; n5 < n7; ++n5) {
            dArray6[nArray[n5]] = 0.0;
        }
        for (n5 = n6 - 1; n5 >= 0; --n5) {
            int n8 = nArray[n5];
            double d6 = dArray6[n8] / object[n8];
            for (int i2 = 0; i2 < n5; ++i2) {
                int n9 = nArray[i2];
                dArray6[n9] = dArray6[n9] - d6 * dArray7[i2][n8];
            }
            dArray6[n8] = d6;
        }
        double d7 = 0.0;
        for (int i3 = 0; i3 < n2; ++i3) {
            double d8;
            int n10 = nArray[i3];
            dArray3[n10] = d8 = dArray2[n10] * dArray6[n10];
            double d9 = d8;
            d7 += d9 * d9;
        }
        d7 = BY.a(d7);
        double d10 = d7 - d2;
        if (d5 <= d2 * 0.1) {
            return 0.0;
        }
        double d11 = 0.0;
        if (n6 == n2) {
            for (n4 = 0; n4 < n2; ++n4) {
                int n11 = n3 = nArray[n4];
                dArray3[n11] = dArray3[n11] * (dArray2[n3] / d7);
            }
            double d12 = 0.0;
            for (n4 = 0; n4 < n2; ++n4) {
                double d13;
                n3 = nArray[n4];
                d4 = 0.0;
                for (int i4 = 0; i4 < n4; ++i4) {
                    d4 += dArray7[i4][n3] * dArray3[nArray[i4]];
                }
                dArray3[n3] = d13 = (dArray3[n3] - d4) / object[n3];
                double d14 = d13;
                d12 += d14 * d14;
            }
            d11 = d10 / (d2 * d12);
        }
        double d15 = 0.0;
        for (n4 = 0; n4 < n2; ++n4) {
            n3 = nArray[n4];
            d4 = 0.0;
            for (int i5 = 0; i5 <= n4; ++i5) {
                d4 += dArray7[i5][n3] * dArray[i5];
            }
            double d16 = d4 /= dArray2[n3];
            d15 += d16 * d16;
        }
        double d17 = BY.a(d15);
        d4 = d17 / d2;
        if (d4 == 0.0) {
            d4 = cq_0.b / BY.d(d2, 0.1);
        }
        if ((d3 = BY.d(d4, BY.e(d3, d11))) == 0.0) {
            d3 = d17 / d7;
        }
        for (int i6 = 10; i6 >= 0; --i6) {
            int n12;
            int n13;
            double d18;
            int n14;
            int n15;
            if (d3 == 0.0) {
                d3 = BY.e(cq_0.b, d4 * 0.001);
            }
            double d19 = BY.a(d3);
            for (n15 = 0; n15 < n2; ++n15) {
                n14 = nArray[n15];
                dArray3[n14] = d19 * dArray2[n14];
            }
            pX.a(dArray, dArray3, dArray4, a2, n2, dArray5, dArray6);
            d7 = 0.0;
            for (n15 = 0; n15 < n2; ++n15) {
                n14 = nArray[n15];
                dArray5[n14] = d18 = dArray2[n14] * dArray6[n14];
                double d20 = d18;
                d7 += d20 * d20;
            }
            d7 = BY.a(d7);
            double d21 = d10;
            d10 = d7 - d2;
            if (BY.w(d10) <= d2 * 0.1 || d11 == 0.0 && d10 <= d21 && d21 < 0.0) {
                return d3;
            }
            for (n13 = 0; n13 < n2; ++n13) {
                n12 = nArray[n13];
                dArray3[n12] = dArray5[n12] * dArray2[n12] / d7;
            }
            for (n13 = 0; n13 < n2; ++n13) {
                int n16 = n12 = nArray[n13];
                dArray3[n16] = dArray3[n16] / dArray4[n13];
                double d22 = dArray3[n12];
                for (n6 = n13 + 1; n6 < n2; ++n6) {
                    int n17 = nArray[n6];
                    dArray3[n17] = dArray3[n17] - dArray7[n6][n12] * d22;
                }
            }
            d15 = 0.0;
            for (n13 = 0; n13 < n2; ++n13) {
                double d23;
                double d24 = d23 = dArray3[nArray[n13]];
                d15 += d24 * d24;
            }
            d18 = d10 / (d2 * d15);
            if (d10 > 0.0) {
                d11 = BY.e(d11, d3);
            } else if (d10 < 0.0) {
                d4 = BY.d(d4, d3);
            }
            d3 = BY.e(d11, d3 + d18);
        }
        return d3;
    }

    private static void a(double[] dArray, double[] dArray2, double[] dArray3, a object, int n2, double[] dArray4, double[] dArray5) {
        int n3;
        int n4;
        a a2 = object;
        int[] nArray = a2.b;
        a2 = object;
        double[][] dArray6 = a2.a;
        a2 = object;
        object = a2.d;
        for (n4 = 0; n4 < n2; ++n4) {
            n3 = nArray[n4];
            for (int i2 = n4 + 1; i2 < n2; ++i2) {
                dArray6[i2][n3] = dArray6[n4][nArray[i2]];
            }
            dArray5[n4] = (double)object[n3];
            dArray4[n4] = dArray[n4];
        }
        for (n4 = 0; n4 < n2; ++n4) {
            n3 = nArray[n4];
            double d2 = dArray2[n3];
            if (d2 != 0.0) {
                Arrays.fill(dArray3, n4 + 1, dArray3.length, 0.0);
            }
            dArray3[n4] = d2;
            double d3 = 0.0;
            for (int i3 = n4; i3 < n2; ++i3) {
                double d4;
                double d5;
                double d6;
                double d7;
                int n5 = nArray[i3];
                if (dArray3[i3] == 0.0) continue;
                double d8 = dArray6[i3][n5];
                if (BY.w(d7) < BY.w(dArray3[i3])) {
                    double d9 = d6 = d8 / dArray3[i3];
                    d5 = 1.0 / BY.a(1.0 + d9 * d9);
                    d4 = d5 * d6;
                } else {
                    double d10 = d6 = dArray3[i3] / d8;
                    d4 = 1.0 / BY.a(1.0 + d10 * d10);
                    d5 = d4 * d6;
                }
                dArray6[i3][n5] = d4 * d8 + d5 * dArray3[i3];
                d6 = d4 * dArray4[i3] + d5 * d3;
                d3 = -d5 * dArray4[i3] + d4 * d3;
                dArray4[i3] = d6;
                for (n3 = i3 + 1; n3 < n2; ++n3) {
                    double d11 = dArray6[n3][n5];
                    double d12 = d4 * d11 + d5 * dArray3[n3];
                    dArray3[n3] = -d5 * d11 + d4 * dArray3[n3];
                    dArray6[n3][n5] = d12;
                }
            }
            dArray3[n4] = dArray6[n4][nArray[n4]];
            dArray6[n4][nArray[n4]] = dArray5[n4];
        }
        n4 = n2;
        for (n3 = 0; n3 < n2; ++n3) {
            if (dArray3[n3] == 0.0 && n4 == n2) {
                n4 = n3;
            }
            if (n4 >= n2) continue;
            dArray4[n3] = 0.0;
        }
        if (n4 > 0) {
            for (n3 = n4 - 1; n3 >= 0; --n3) {
                int n6 = nArray[n3];
                double d13 = 0.0;
                for (int i4 = n3 + 1; i4 < n4; ++i4) {
                    d13 += dArray6[i4][n6] * dArray4[i4];
                }
                dArray4[n3] = (dArray4[n3] - d13) / dArray3[n3];
            }
        }
        for (n3 = 0; n3 < dArray5.length; ++n3) {
            dArray5[nArray[n3]] = dArray4[n3];
        }
    }

    private a a(tq_0 object, int n2) {
        int n3;
        double[][] dArray = object.b(-1.0).a();
        object = dArray;
        int n4 = dArray.length;
        int n5 = ((Object)object[0]).length;
        int[] nArray = new int[n5];
        double[] dArray2 = new double[n5];
        double[] dArray3 = new double[n5];
        double[] dArray4 = new double[n5];
        for (n3 = 0; n3 < n5; ++n3) {
            int n6 = n3;
            nArray[n6] = n6;
            double d2 = 0.0;
            for (int i2 = 0; i2 < n4; ++i2) {
                Object object2;
                Object object3 = object2 = object[i2][n3];
                d2 += object3 * object3;
            }
            dArray3[n3] = BY.a(d2);
        }
        for (n3 = 0; n3 < n5; ++n3) {
            double d3;
            Object object4;
            int n7;
            int n8 = -1;
            double d4 = Double.NEGATIVE_INFINITY;
            for (n7 = n3; n7 < n5; ++n7) {
                object4 = 0.0;
                for (int i3 = n3; i3 < n4; ++i3) {
                    Object object5;
                    Object object6 = object5 = object[i3][nArray[n7]];
                    object4 += object6 * object6;
                }
                if (Double.isInfinite(object4) || Double.isNaN(object4)) {
                    throw new oR(px_0.UNABLE_TO_PERFORM_QR_DECOMPOSITION_ON_JACOBIAN, n4, n5);
                }
                if (!(object4 > d4)) continue;
                n8 = n7;
                d4 = object4;
            }
            if (d4 <= this.f) {
                return new a((double[][])object, nArray, n3, dArray2, dArray3, dArray4);
            }
            n7 = nArray[n8];
            nArray[n8] = nArray[n3];
            nArray[n3] = n7;
            Object object7 = object[n3][n7];
            object4 = object7;
            double d5 = object7 > 0.0 ? -BY.a(d4) : BY.a(d4);
            dArray4[n7] = d3 = 1.0 / (d4 - object4 * d5);
            dArray2[n7] = d5;
            Object object8 = object[n3];
            int n9 = n7;
            object8[n9] = object8[n9] - d5;
            for (int i4 = n5 - 1 - n3; i4 > 0; --i4) {
                double d6 = 0.0;
                for (n8 = n3; n8 < n4; ++n8) {
                    d6 += object[n8][n7] * object[n8][nArray[n3 + i4]];
                }
                d6 *= d3;
                for (n8 = n3; n8 < n4; ++n8) {
                    Object object9 = object[n8];
                    int n10 = nArray[n3 + i4];
                    object9[n10] = object9[n10] - d6 * object[n8][n7];
                }
            }
        }
        return new a((double[][])object, nArray, n2, dArray2, dArray3, dArray4);
    }

    private static void a(double[] dArray, a object) {
        a a2 = object;
        double[][] dArray2 = a2.a;
        a2 = object;
        int[] nArray = a2.b;
        a2 = object;
        object = a2.f;
        int n2 = dArray2.length;
        int n3 = dArray2[0].length;
        for (int i2 = 0; i2 < n3; ++i2) {
            int n4;
            int n5 = nArray[i2];
            double d2 = 0.0;
            for (n4 = i2; n4 < n2; ++n4) {
                d2 += dArray2[n4][n5] * dArray[n4];
            }
            d2 *= object[n5];
            for (n4 = i2; n4 < n2; ++n4) {
                int n6 = n4;
                dArray[n6] = dArray[n6] - d2 * dArray2[n4][n5];
            }
        }
    }

    static final class a {
        final double[][] a;
        final int[] b;
        final int c;
        final double[] d;
        final double[] e;
        final double[] f;

        a(double[][] dArray, int[] nArray, int n2, double[] dArray2, double[] dArray3, double[] dArray4) {
            this.a = dArray;
            this.b = nArray;
            this.c = n2;
            this.d = dArray2;
            this.e = dArray3;
            this.f = dArray4;
        }

        static /* synthetic */ double[][] a(a a2) {
            return a2.a;
        }

        static /* synthetic */ int[] b(a a2) {
            return a2.b;
        }

        static /* synthetic */ double[] c(a a2) {
            return a2.d;
        }

        static /* synthetic */ double[] d(a a2) {
            return a2.e;
        }

        static /* synthetic */ int e(a a2) {
            return a2.c;
        }

        static /* synthetic */ double[] f(a a2) {
            return a2.f;
        }
    }
}

