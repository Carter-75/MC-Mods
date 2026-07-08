/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import java.util.Arrays;
import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.ch_0;
import org.valkyrienskies.core.impl.shadow.ci_0;
import org.valkyrienskies.core.impl.shadow.lc_0;
import org.valkyrienskies.core.impl.shadow.mY;
import org.valkyrienskies.core.impl.shadow.ng_0;
import org.valkyrienskies.core.impl.shadow.nl_0;
import org.valkyrienskies.core.impl.shadow.oS;
import org.valkyrienskies.core.impl.shadow.pf_0;
import org.valkyrienskies.core.impl.shadow.pj_0;
import org.valkyrienskies.core.impl.shadow.pn_0;
import org.valkyrienskies.core.impl.shadow.po_0;
import org.valkyrienskies.core.impl.shadow.pw_0;
import org.valkyrienskies.core.impl.shadow.px_0;

public final class mP
implements Serializable,
ng_0 {
    private static double a = 0.3;
    private static int b = 2;
    private static double c = 1.0E-12;
    private static final long d = 5204927143605193821L;
    private final double e;
    private final int f;
    private final double g;

    public mP() {
        this.e = 0.3;
        this.f = 2;
        this.g = 1.0E-12;
    }

    private mP(double d2, int n2) {
        this(d2, n2, 1.0E-12);
    }

    private mP(double d2, int n2, double d3) {
        if (d2 < 0.0 || d2 > 1.0) {
            throw new po_0(px_0.BANDWIDTH, (Number)d2, 0, 1);
        }
        this.e = d2;
        if (n2 < 0) {
            throw new pj_0(px_0.ROBUSTNESS_ITERATIONS, n2);
        }
        this.f = n2;
        this.g = 1.0E-12;
    }

    private nl_0 a(double[] object, double[] dArray) {
        double[] dArray2;
        new mY();
        double[] dArray3 = object;
        double[] dArray4 = dArray;
        dArray = object;
        object = this;
        if (dArray.length != dArray4.length) {
            throw new oS(dArray.length, dArray4.length);
        }
        double[] dArray5 = new double[dArray.length];
        Arrays.fill(dArray5, 1.0);
        if (dArray.length != dArray4.length) {
            throw new oS(dArray.length, dArray4.length);
        }
        int n2 = dArray.length;
        if (n2 == 0) {
            throw new pf_0();
        }
        mP.a(dArray);
        mP.a(dArray4);
        mP.a(dArray5);
        ch_0.a(dArray);
        if (n2 == 1) {
            double[] dArray6 = new double[1];
            dArray2 = dArray6;
            dArray6[0] = dArray4[0];
        } else if (n2 == 2) {
            double[] dArray7 = new double[2];
            dArray7[0] = dArray4[0];
            dArray2 = dArray7;
            dArray7[1] = dArray4[1];
        } else {
            int n3 = (int)(object.e * (double)n2);
            if (n3 < 2) {
                throw new pn_0((pw_0)px_0.BANDWIDTH, (Number)n3, 2, true);
            }
            double[] dArray8 = new double[n2];
            double[] dArray9 = new double[n2];
            double[] dArray10 = new double[n2];
            double[] dArray11 = new double[n2];
            Arrays.fill(dArray11, 1.0);
            for (int i2 = 0; i2 <= object.f; ++i2) {
                int[] nArray = new int[]{0, n3 - 1};
                for (int i3 = 0; i3 < n2; ++i3) {
                    double d2;
                    double d3;
                    int n4;
                    int n5;
                    double d4 = dArray[i3];
                    if (i3 > 0) {
                        int[] nArray2 = nArray;
                        int n6 = i3;
                        double[] dArray12 = dArray5;
                        double[] dArray13 = dArray;
                        int n7 = nArray2[0];
                        int n8 = nArray2[1];
                        int n9 = mP.a(dArray12, n8);
                        if (n9 < dArray13.length && dArray13[n9] - dArray13[n6] < dArray13[n6] - dArray13[n7]) {
                            int n10;
                            nArray2[0] = n10 = mP.a(dArray12, nArray2[0]);
                            nArray2[1] = n9;
                        }
                    }
                    int n11 = dArray[i3] - dArray[n5 = nArray[0]] > dArray[n4 = nArray[1]] - dArray[i3] ? n5 : n4;
                    double d5 = 0.0;
                    double d6 = 0.0;
                    double d7 = 0.0;
                    double d8 = 0.0;
                    double d9 = 0.0;
                    double d10 = BY.w(1.0 / (dArray[n11] - d4));
                    for (int i4 = n5; i4 <= n4; ++i4) {
                        double d11;
                        double d12;
                        double d13 = dArray[i4];
                        double d14 = dArray4[i4];
                        double d15 = i4 < i3 ? d4 - d13 : d13 - d4;
                        double d16 = d15 * d10;
                        double d17 = BY.w(d16);
                        if (d12 >= 1.0) {
                            d11 = 0.0;
                        } else {
                            double d18 = d17;
                            double d19 = 1.0 - d18 * d18 * d17;
                            d11 = d19 * d19 * d19;
                        }
                        double d20 = d11 * dArray11[i4] * dArray5[i4];
                        double d21 = d13 * d20;
                        d5 += d20;
                        d6 += d21;
                        d7 += d13 * d21;
                        d8 += d14 * d20;
                        d9 += d14 * d21;
                    }
                    double d22 = d6 / d5;
                    double d23 = d8 / d5;
                    double d24 = d9 / d5;
                    double d25 = d7 / d5;
                    double d26 = d22;
                    if (BY.a(BY.w(d3 - d26 * d26)) < object.g) {
                        d2 = 0.0;
                    } else {
                        double d27 = d22;
                        d2 = (d24 - d22 * d23) / (d25 - d27 * d27);
                    }
                    double d28 = d23 - d2 * d22;
                    dArray8[i3] = d2 * d4 + d28;
                    dArray9[i3] = BY.w(dArray4[i3] - dArray8[i3]);
                }
                if (i2 == object.f) break;
                System.arraycopy(dArray9, 0, dArray10, 0, n2);
                Arrays.sort(dArray10);
                double d29 = dArray10[n2 / 2];
                if (BY.w(d29) < object.g) break;
                for (int i5 = 0; i5 < n2; ++i5) {
                    double d30;
                    double d31;
                    double d32 = dArray9[i5] / (d29 * 6.0);
                    if (d31 >= 1.0) {
                        dArray11[i5] = 0.0;
                        continue;
                    }
                    double d33 = d32;
                    double d34 = d30 = 1.0 - d33 * d33;
                    dArray11[i5] = d34 * d34;
                }
            }
            dArray2 = dArray8;
        }
        return mY.a(dArray3, dArray2);
    }

    private double[] a(double[] dArray, double[] dArray2, double[] dArray3) {
        if (dArray.length != dArray2.length) {
            throw new oS(dArray.length, dArray2.length);
        }
        int n2 = dArray.length;
        if (n2 == 0) {
            throw new pf_0();
        }
        mP.a(dArray);
        mP.a(dArray2);
        mP.a(dArray3);
        ch_0.a(dArray);
        if (n2 == 1) {
            return new double[]{dArray2[0]};
        }
        if (n2 == 2) {
            return new double[]{dArray2[0], dArray2[1]};
        }
        int n3 = (int)(this.e * (double)n2);
        if (n3 < 2) {
            throw new pn_0((pw_0)px_0.BANDWIDTH, (Number)n3, 2, true);
        }
        double[] dArray4 = new double[n2];
        double[] dArray5 = new double[n2];
        double[] dArray6 = new double[n2];
        double[] dArray7 = new double[n2];
        Arrays.fill(dArray7, 1.0);
        for (int i2 = 0; i2 <= this.f; ++i2) {
            int[] nArray = new int[]{0, n3 - 1};
            for (int i3 = 0; i3 < n2; ++i3) {
                double d2;
                double d3;
                int n4;
                int n5;
                double d4 = dArray[i3];
                if (i3 > 0) {
                    mP.a(dArray, dArray3, i3, nArray);
                }
                int n6 = dArray[i3] - dArray[n5 = nArray[0]] > dArray[n4 = nArray[1]] - dArray[i3] ? n5 : n4;
                double d5 = 0.0;
                double d6 = 0.0;
                double d7 = 0.0;
                double d8 = 0.0;
                double d9 = 0.0;
                double d10 = BY.w(1.0 / (dArray[n6] - d4));
                for (int i4 = n5; i4 <= n4; ++i4) {
                    double d11 = dArray[i4];
                    double d12 = dArray2[i4];
                    double d13 = i4 < i3 ? d4 - d11 : d11 - d4;
                    double d14 = mP.a(d13 * d10) * dArray7[i4] * dArray3[i4];
                    double d15 = d11 * d14;
                    d5 += d14;
                    d6 += d15;
                    d7 += d11 * d15;
                    d8 += d12 * d14;
                    d9 += d12 * d15;
                }
                double d16 = d6 / d5;
                double d17 = d8 / d5;
                double d18 = d9 / d5;
                double d19 = d7 / d5;
                double d20 = d16;
                if (BY.a(BY.w(d3 - d20 * d20)) < this.g) {
                    d2 = 0.0;
                } else {
                    double d21 = d16;
                    d2 = (d18 - d16 * d17) / (d19 - d21 * d21);
                }
                double d22 = d17 - d2 * d16;
                dArray4[i3] = d2 * d4 + d22;
                dArray5[i3] = BY.w(dArray2[i3] - dArray4[i3]);
            }
            if (i2 == this.f) break;
            System.arraycopy(dArray5, 0, dArray6, 0, n2);
            Arrays.sort(dArray6);
            double d23 = dArray6[n2 / 2];
            if (BY.w(d23) < this.g) break;
            for (int i5 = 0; i5 < n2; ++i5) {
                double d24;
                double d25;
                double d26 = dArray5[i5] / (d23 * 6.0);
                if (d25 >= 1.0) {
                    dArray7[i5] = 0.0;
                    continue;
                }
                double d27 = d26;
                double d28 = d24 = 1.0 - d27 * d27;
                dArray7[i5] = d28 * d28;
            }
        }
        return dArray4;
    }

    private double[] c(double[] dArray, double[] dArray2) {
        if (dArray.length != dArray2.length) {
            throw new oS(dArray.length, dArray2.length);
        }
        double[] dArray3 = new double[dArray.length];
        Arrays.fill(dArray3, 1.0);
        return this.a(dArray, dArray2, dArray3);
    }

    private static void a(double[] dArray, double[] dArray2, int n2, int[] nArray) {
        int n3 = nArray[0];
        int n4 = nArray[1];
        if ((n4 = mP.a(dArray2, n4)) < dArray.length && dArray[n4] - dArray[n2] < dArray[n2] - dArray[n3]) {
            int n5;
            nArray[0] = n5 = mP.a(dArray2, nArray[0]);
            nArray[1] = n4;
        }
    }

    private static int a(double[] dArray, int n2) {
        ++n2;
        while (n2 < dArray.length && dArray[n2] == 0.0) {
            ++n2;
        }
        return n2;
    }

    private static double a(double d2) {
        double d3;
        double d4 = BY.w(d2);
        if (d3 >= 1.0) {
            return 0.0;
        }
        double d5 = d4;
        double d6 = 1.0 - d5 * d5 * d4;
        return d6 * d6 * d6;
    }

    private static void a(double[] dArray) {
        for (int i2 = 0; i2 < dArray.length; ++i2) {
            ci_0.b(dArray[i2]);
        }
    }

    public final /* synthetic */ lc_0 b(double[] object, double[] dArray) {
        double[] dArray2;
        double[] dArray3 = dArray;
        dArray = object;
        object = this;
        new mY();
        double[] dArray4 = dArray;
        if (dArray.length != dArray3.length) {
            throw new oS(dArray.length, dArray3.length);
        }
        double[] dArray5 = new double[dArray.length];
        Arrays.fill(dArray5, 1.0);
        if (dArray.length != dArray3.length) {
            throw new oS(dArray.length, dArray3.length);
        }
        int n2 = dArray.length;
        if (n2 == 0) {
            throw new pf_0();
        }
        mP.a(dArray);
        mP.a(dArray3);
        mP.a(dArray5);
        ch_0.a(dArray);
        if (n2 == 1) {
            double[] dArray6 = new double[1];
            dArray2 = dArray6;
            dArray6[0] = dArray3[0];
        } else if (n2 == 2) {
            double[] dArray7 = new double[2];
            dArray7[0] = dArray3[0];
            dArray2 = dArray7;
            dArray7[1] = dArray3[1];
        } else {
            int n3 = (int)(object.e * (double)n2);
            if (n3 < 2) {
                throw new pn_0((pw_0)px_0.BANDWIDTH, (Number)n3, 2, true);
            }
            double[] dArray8 = new double[n2];
            double[] dArray9 = new double[n2];
            double[] dArray10 = new double[n2];
            double[] dArray11 = new double[n2];
            Arrays.fill(dArray11, 1.0);
            for (int i2 = 0; i2 <= object.f; ++i2) {
                int[] nArray = new int[]{0, n3 - 1};
                for (int i3 = 0; i3 < n2; ++i3) {
                    double d2;
                    double d3;
                    int n4;
                    int n5;
                    double d4 = dArray[i3];
                    if (i3 > 0) {
                        int[] nArray2 = nArray;
                        int n6 = i3;
                        double[] dArray12 = dArray5;
                        double[] dArray13 = dArray;
                        int n7 = nArray2[0];
                        int n8 = nArray2[1];
                        int n9 = mP.a(dArray12, n8);
                        if (n9 < dArray13.length && dArray13[n9] - dArray13[n6] < dArray13[n6] - dArray13[n7]) {
                            int n10;
                            nArray2[0] = n10 = mP.a(dArray12, nArray2[0]);
                            nArray2[1] = n9;
                        }
                    }
                    int n11 = dArray[i3] - dArray[n5 = nArray[0]] > dArray[n4 = nArray[1]] - dArray[i3] ? n5 : n4;
                    double d5 = 0.0;
                    double d6 = 0.0;
                    double d7 = 0.0;
                    double d8 = 0.0;
                    double d9 = 0.0;
                    double d10 = BY.w(1.0 / (dArray[n11] - d4));
                    for (int i4 = n5; i4 <= n4; ++i4) {
                        double d11;
                        double d12;
                        double d13 = dArray[i4];
                        double d14 = dArray3[i4];
                        double d15 = i4 < i3 ? d4 - d13 : d13 - d4;
                        double d16 = d15 * d10;
                        double d17 = BY.w(d16);
                        if (d12 >= 1.0) {
                            d11 = 0.0;
                        } else {
                            double d18 = d17;
                            double d19 = 1.0 - d18 * d18 * d17;
                            d11 = d19 * d19 * d19;
                        }
                        double d20 = d11 * dArray11[i4] * dArray5[i4];
                        double d21 = d13 * d20;
                        d5 += d20;
                        d6 += d21;
                        d7 += d13 * d21;
                        d8 += d14 * d20;
                        d9 += d14 * d21;
                    }
                    double d22 = d6 / d5;
                    double d23 = d8 / d5;
                    double d24 = d9 / d5;
                    double d25 = d7 / d5;
                    double d26 = d22;
                    if (BY.a(BY.w(d3 - d26 * d26)) < object.g) {
                        d2 = 0.0;
                    } else {
                        double d27 = d22;
                        d2 = (d24 - d22 * d23) / (d25 - d27 * d27);
                    }
                    double d28 = d23 - d2 * d22;
                    dArray8[i3] = d2 * d4 + d28;
                    dArray9[i3] = BY.w(dArray3[i3] - dArray8[i3]);
                }
                if (i2 == object.f) break;
                System.arraycopy(dArray9, 0, dArray10, 0, n2);
                Arrays.sort(dArray10);
                double d29 = dArray10[n2 / 2];
                if (BY.w(d29) < object.g) break;
                for (int i5 = 0; i5 < n2; ++i5) {
                    double d30;
                    double d31;
                    double d32 = dArray9[i5] / (d29 * 6.0);
                    if (d31 >= 1.0) {
                        dArray11[i5] = 0.0;
                        continue;
                    }
                    double d33 = d32;
                    double d34 = d30 = 1.0 - d33 * d33;
                    dArray11[i5] = d34 * d34;
                }
            }
            dArray2 = dArray8;
        }
        return mY.a(dArray4, dArray2);
    }
}

