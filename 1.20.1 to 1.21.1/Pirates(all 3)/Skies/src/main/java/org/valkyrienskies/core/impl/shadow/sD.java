/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import java.util.Arrays;
import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.ci_0;
import org.valkyrienskies.core.impl.shadow.oS;
import org.valkyrienskies.core.impl.shadow.pf_0;
import org.valkyrienskies.core.impl.shadow.px_0;
import org.valkyrienskies.core.impl.shadow.sA;
import org.valkyrienskies.core.impl.shadow.sL;
import org.valkyrienskies.core.impl.shadow.sv_0;
import org.valkyrienskies.core.impl.shadow.sw_0;
import org.valkyrienskies.core.impl.shadow.tc_0;
import org.valkyrienskies.core.impl.shadow.td_0;
import org.valkyrienskies.core.impl.shadow.tq_0;
import org.valkyrienskies.core.impl.shadow.tr_0;
import org.valkyrienskies.core.impl.shadow.tt_0;
import org.valkyrienskies.core.impl.shadow.tu_0;

public final class sD
extends sv_0
implements Serializable {
    private static int c = 52;
    private static final long d = 4991895511313664478L;
    final double[][] a;
    private final int e;
    private final int f;
    private final int g;
    final int b;

    public sD(int n2, int n3) {
        super(n2, n3);
        this.e = n2;
        this.f = n3;
        this.g = (n2 + 52 - 1) / 52;
        this.b = (n3 + 52 - 1) / 52;
        this.a = sD.c(n2, n3);
    }

    public sD(double[][] dArray) {
        this(dArray.length, dArray[0].length, sD.a(dArray), false);
    }

    public sD(int n2, int n3, double[][] dArray, boolean bl) {
        super(n2, n3);
        this.e = n2;
        this.f = n3;
        this.g = (n2 + 52 - 1) / 52;
        this.b = (n3 + 52 - 1) / 52;
        this.a = dArray;
        n2 = 0;
        for (n3 = 0; n3 < this.g; ++n3) {
            int n4 = this.k(n3);
            int n5 = 0;
            while (n5 < this.b) {
                if (dArray[n2].length != n4 * this.h(n5)) {
                    throw new oS(dArray[n2].length, n4 * this.h(n5));
                }
                ++n5;
                ++n2;
            }
        }
    }

    private static double[][] a(double[][] dArray) {
        int n2;
        int n3 = dArray.length;
        int n4 = dArray[0].length;
        int n5 = (n3 + 52 - 1) / 52;
        int n6 = (n4 + 52 - 1) / 52;
        for (int i2 = 0; i2 < dArray.length; ++i2) {
            n2 = dArray[i2].length;
            if (n2 == n4) continue;
            throw new oS(n4, n2);
        }
        double[][] dArrayArray = new double[n5 * n6][];
        n2 = 0;
        for (int i3 = 0; i3 < n5; ++i3) {
            int n7 = i3 * 52;
            int n8 = BY.a(n7 + 52, n3);
            int n9 = n8 - n7;
            for (int i4 = 0; i4 < n6; ++i4) {
                int n10 = i4 * 52;
                int n11 = BY.a(n10 + 52, n4);
                double[] dArray2 = new double[n9 * (n11 -= n10)];
                dArrayArray[n2] = dArray2;
                int n12 = 0;
                for (int i5 = n7; i5 < n8; ++i5) {
                    System.arraycopy(dArray[i5], n10, dArray2, n12, n11);
                    n12 += n11;
                }
                ++n2;
            }
        }
        return dArrayArray;
    }

    public static double[][] c(int n2, int n3) {
        int n4 = (n2 + 52 - 1) / 52;
        int n5 = (n3 + 52 - 1) / 52;
        double[][] dArrayArray = new double[n4 * n5][];
        int n6 = 0;
        for (int i2 = 0; i2 < n4; ++i2) {
            int n7 = i2 * 52;
            int n8 = BY.a(n7 + 52, n2);
            n7 = n8 - n7;
            for (n8 = 0; n8 < n5; ++n8) {
                int n9 = n8 * 52;
                int n10 = BY.a(n9 + 52, n3);
                n9 = n10 - n9;
                dArrayArray[n6] = new double[n7 * n9];
                ++n6;
            }
        }
        return dArrayArray;
    }

    private static sD d(int n2, int n3) {
        return new sD(n2, n3);
    }

    private sD j() {
        sD sD2 = new sD(this.e, this.f);
        for (int i2 = 0; i2 < this.a.length; ++i2) {
            System.arraycopy(this.a[i2], 0, sD2.a[i2], 0, this.a[i2].length);
        }
        return sD2;
    }

    private sD e(tq_0 tq_02) {
        try {
            sD sD2 = (sD)tq_02;
            sD sD3 = this;
            td_0.a((tq_0)sD3, (tq_0)sD2);
            sD sD4 = new sD(sD3.e, sD3.f);
            for (int i2 = 0; i2 < sD4.a.length; ++i2) {
                double[] dArray = sD4.a[i2];
                double[] dArray2 = sD3.a[i2];
                double[] dArray3 = sD2.a[i2];
                for (int i3 = 0; i3 < dArray.length; ++i3) {
                    dArray[i3] = dArray2[i3] + dArray3[i3];
                }
            }
            return sD4;
        }
        catch (ClassCastException classCastException) {
            td_0.a((tq_0)this, tq_02);
            sD sD5 = new sD(this.e, this.f);
            int n2 = 0;
            for (int i4 = 0; i4 < sD5.g; ++i4) {
                for (int i5 = 0; i5 < sD5.b; ++i5) {
                    double[] dArray = sD5.a[n2];
                    double[] dArray4 = this.a[n2];
                    int n3 = i4 * 52;
                    int n4 = BY.a(n3 + 52, this.e);
                    int n5 = i5 * 52;
                    int n6 = BY.a(n5 + 52, this.f);
                    int n7 = 0;
                    while (n3 < n4) {
                        for (int i6 = n5; i6 < n6; ++i6) {
                            dArray[n7] = dArray4[n7] + tq_02.b(n3, i6);
                            ++n7;
                        }
                        ++n3;
                    }
                    ++n2;
                }
            }
            return sD5;
        }
    }

    private sD a(sD sD2) {
        td_0.a((tq_0)this, (tq_0)sD2);
        sD sD3 = new sD(this.e, this.f);
        for (int i2 = 0; i2 < sD3.a.length; ++i2) {
            double[] dArray = sD3.a[i2];
            double[] dArray2 = this.a[i2];
            double[] dArray3 = sD2.a[i2];
            for (int i3 = 0; i3 < dArray.length; ++i3) {
                dArray[i3] = dArray2[i3] + dArray3[i3];
            }
        }
        return sD3;
    }

    private sD f(tq_0 tq_02) {
        try {
            sD sD2 = (sD)tq_02;
            sD sD3 = this;
            td_0.a(sD3, (tq_0)sD2);
            sD sD4 = new sD(sD3.e, sD3.f);
            for (int i2 = 0; i2 < sD4.a.length; ++i2) {
                double[] dArray = sD4.a[i2];
                double[] dArray2 = sD3.a[i2];
                double[] dArray3 = sD2.a[i2];
                for (int i3 = 0; i3 < dArray.length; ++i3) {
                    dArray[i3] = dArray2[i3] - dArray3[i3];
                }
            }
            return sD4;
        }
        catch (ClassCastException classCastException) {
            td_0.a(this, tq_02);
            sD sD5 = new sD(this.e, this.f);
            int n2 = 0;
            for (int i4 = 0; i4 < sD5.g; ++i4) {
                for (int i5 = 0; i5 < sD5.b; ++i5) {
                    double[] dArray = sD5.a[n2];
                    double[] dArray4 = this.a[n2];
                    int n3 = i4 * 52;
                    int n4 = BY.a(n3 + 52, this.e);
                    int n5 = i5 * 52;
                    int n6 = BY.a(n5 + 52, this.f);
                    int n7 = 0;
                    while (n3 < n4) {
                        for (int i6 = n5; i6 < n6; ++i6) {
                            dArray[n7] = dArray4[n7] - tq_02.b(n3, i6);
                            ++n7;
                        }
                        ++n3;
                    }
                    ++n2;
                }
            }
            return sD5;
        }
    }

    private sD b(sD sD2) {
        td_0.a(this, (tq_0)sD2);
        sD sD3 = new sD(this.e, this.f);
        for (int i2 = 0; i2 < sD3.a.length; ++i2) {
            double[] dArray = sD3.a[i2];
            double[] dArray2 = this.a[i2];
            double[] dArray3 = sD2.a[i2];
            for (int i3 = 0; i3 < dArray.length; ++i3) {
                dArray[i3] = dArray2[i3] - dArray3[i3];
            }
        }
        return sD3;
    }

    private sD c(double d2) {
        sD sD2 = new sD(this.e, this.f);
        for (int i2 = 0; i2 < sD2.a.length; ++i2) {
            double[] dArray = sD2.a[i2];
            double[] dArray2 = this.a[i2];
            for (int i3 = 0; i3 < dArray.length; ++i3) {
                dArray[i3] = dArray2[i3] + d2;
            }
        }
        return sD2;
    }

    public final tq_0 b(double d2) {
        sD sD2 = new sD(this.e, this.f);
        for (int i2 = 0; i2 < sD2.a.length; ++i2) {
            double[] dArray = sD2.a[i2];
            double[] dArray2 = this.a[i2];
            for (int i3 = 0; i3 < dArray.length; ++i3) {
                dArray[i3] = dArray2[i3] * d2;
            }
        }
        return sD2;
    }

    private sD g(tq_0 tq_02) {
        try {
            sD sD2 = (sD)tq_02;
            sD sD3 = this;
            td_0.b(sD3, sD2);
            sD sD4 = new sD(sD3.e, sD2.f);
            int n2 = 0;
            for (int i2 = 0; i2 < sD4.g; ++i2) {
                int n3 = i2 * 52;
                int n4 = BY.a(n3 + 52, sD3.e);
                for (int i3 = 0; i3 < sD4.b; ++i3) {
                    int n5 = sD4.h(i3);
                    int n6 = n5 + n5;
                    int n7 = n6 + n5;
                    int n8 = n7 + n5;
                    double[] dArray = sD4.a[n2];
                    for (int i4 = 0; i4 < sD3.b; ++i4) {
                        int n9 = sD3.h(i4);
                        double[] dArray2 = sD3.a[i2 * sD3.b + i4];
                        double[] dArray3 = sD2.a[i4 * sD2.b + i3];
                        int n10 = 0;
                        for (int i5 = n3; i5 < n4; ++i5) {
                            int n11 = (i5 - n3) * n9;
                            int n12 = n11 + n9;
                            for (int i6 = 0; i6 < n5; ++i6) {
                                double d2 = 0.0;
                                int n13 = n11;
                                int n14 = i6;
                                while (n13 < n12 - 3) {
                                    d2 += dArray2[n13] * dArray3[n14] + dArray2[n13 + 1] * dArray3[n14 + n5] + dArray2[n13 + 2] * dArray3[n14 + n6] + dArray2[n13 + 3] * dArray3[n14 + n7];
                                    n13 += 4;
                                    n14 += n8;
                                }
                                while (n13 < n12) {
                                    d2 += dArray2[n13++] * dArray3[n14];
                                    n14 += n5;
                                }
                                int n15 = n10++;
                                dArray[n15] = dArray[n15] + d2;
                            }
                        }
                    }
                    ++n2;
                }
            }
            return sD4;
        }
        catch (ClassCastException classCastException) {
            td_0.b(this, tq_02);
            sD sD5 = new sD(this.e, tq_02.g());
            int n16 = 0;
            for (int i7 = 0; i7 < sD5.g; ++i7) {
                int n17 = i7 * 52;
                int n18 = BY.a(n17 + 52, this.e);
                for (int i8 = 0; i8 < sD5.b; ++i8) {
                    int n19 = i8 * 52;
                    int n20 = BY.a(n19 + 52, tq_02.g());
                    double[] dArray = sD5.a[n16];
                    for (int i9 = 0; i9 < this.b; ++i9) {
                        int n21 = this.h(i9);
                        double[] dArray4 = this.a[i7 * this.b + i9];
                        int n22 = i9 * 52;
                        int n23 = 0;
                        for (int i10 = n17; i10 < n18; ++i10) {
                            int n24 = (i10 - n17) * n21;
                            int n25 = n24 + n21;
                            for (int i11 = n19; i11 < n20; ++i11) {
                                double d3 = 0.0;
                                int n26 = n22;
                                for (int i12 = n24; i12 < n25; ++i12) {
                                    d3 += dArray4[i12] * tq_02.b(n26, i11);
                                    ++n26;
                                }
                                int n27 = n23++;
                                dArray[n27] = dArray[n27] + d3;
                            }
                        }
                    }
                    ++n16;
                }
            }
            return sD5;
        }
    }

    private sD c(sD sD2) {
        td_0.b(this, sD2);
        sD sD3 = new sD(this.e, sD2.f);
        int n2 = 0;
        for (int i2 = 0; i2 < sD3.g; ++i2) {
            int n3 = i2 * 52;
            int n4 = BY.a(n3 + 52, this.e);
            for (int i3 = 0; i3 < sD3.b; ++i3) {
                int n5 = sD3.h(i3);
                int n6 = n5 + n5;
                int n7 = n6 + n5;
                int n8 = n7 + n5;
                double[] dArray = sD3.a[n2];
                for (int i4 = 0; i4 < this.b; ++i4) {
                    int n9 = this.h(i4);
                    double[] dArray2 = this.a[i2 * this.b + i4];
                    double[] dArray3 = sD2.a[i4 * sD2.b + i3];
                    int n10 = 0;
                    for (int i5 = n3; i5 < n4; ++i5) {
                        int n11 = (i5 - n3) * n9;
                        int n12 = n11 + n9;
                        for (int i6 = 0; i6 < n5; ++i6) {
                            double d2 = 0.0;
                            int n13 = n11;
                            int n14 = i6;
                            while (n13 < n12 - 3) {
                                d2 += dArray2[n13] * dArray3[n14] + dArray2[n13 + 1] * dArray3[n14 + n5] + dArray2[n13 + 2] * dArray3[n14 + n6] + dArray2[n13 + 3] * dArray3[n14 + n7];
                                n13 += 4;
                                n14 += n8;
                            }
                            while (n13 < n12) {
                                d2 += dArray2[n13++] * dArray3[n14];
                                n14 += n5;
                            }
                            int n15 = n10++;
                            dArray[n15] = dArray[n15] + d2;
                        }
                    }
                }
                ++n2;
            }
        }
        return sD3;
    }

    public final double[][] a() {
        sD sD2 = this;
        Object object = sD2;
        object = this;
        object = new double[sD2.e][((sD)object).f];
        int n2 = this.f - (this.b - 1) * 52;
        for (int i2 = 0; i2 < this.g; ++i2) {
            int n3 = i2 * 52;
            int n4 = BY.a(n3 + 52, this.e);
            int n5 = 0;
            int n6 = 0;
            while (n3 < n4) {
                Object object2 = object[n3];
                int n7 = i2 * this.b;
                int n8 = 0;
                for (int i3 = 0; i3 < this.b - 1; ++i3) {
                    System.arraycopy(this.a[n7++], n5, object2, n8, 52);
                    n8 += 52;
                }
                System.arraycopy(this.a[n7], n6, object2, n8, n2);
                n5 += 52;
                n6 += n2;
                ++n3;
            }
        }
        return object;
    }

    public final double b() {
        double[] dArray = new double[52];
        double d2 = 0.0;
        for (int i2 = 0; i2 < this.b; ++i2) {
            int n2;
            int n3 = this.h(i2);
            Arrays.fill(dArray, 0, n3, 0.0);
            for (n2 = 0; n2 < this.g; ++n2) {
                int n4 = this.k(n2);
                double[] dArray2 = this.a[n2 * this.b + i2];
                int n5 = 0;
                while (n5 < n3) {
                    double d3 = 0.0;
                    for (int i3 = 0; i3 < n4; ++i3) {
                        d3 += BY.w(dArray2[i3 * n3 + n5]);
                    }
                    int n6 = n5++;
                    dArray[n6] = dArray[n6] + d3;
                }
            }
            for (n2 = 0; n2 < n3; ++n2) {
                d2 = BY.e(d2, dArray[n2]);
            }
        }
        return d2;
    }

    public final double c() {
        double d2 = 0.0;
        for (int i2 = 0; i2 < this.a.length; ++i2) {
            double[] dArray = this.a[i2];
            int n2 = dArray.length;
            for (int i3 = 0; i3 < n2; ++i3) {
                double d3;
                double d4 = d3 = dArray[i3];
                d2 += d4 * d4;
            }
        }
        return BY.a(d2);
    }

    private sD b(int n2, int n3, int n4, int n5) {
        td_0.a(this, n2, n3, n4, n5);
        sD sD2 = new sD(n3 - n2 + 1, n5 - n4 + 1);
        n5 = n2 / 52;
        n2 %= 52;
        int n6 = n4 / 52;
        n4 %= 52;
        for (int i2 = 0; i2 < sD2.g; ++i2) {
            int n7 = sD2.k(i2);
            int n8 = n6;
            for (int i3 = 0; i3 < sD2.b; ++i3) {
                int n9;
                int n10 = sD2.h(i3);
                int n11 = i2 * sD2.b + i3;
                double[] dArray = sD2.a[n11];
                int n12 = n5 * this.b + n8;
                int n13 = this.h(n8);
                int n14 = n7 + n2 - 52;
                int n15 = n10 + n4 - 52;
                if (n14 > 0) {
                    if (n15 > 0) {
                        n9 = this.h(n8 + 1);
                        sD.a(this.a[n12], n13, n2, 52, n4, 52, dArray, n10, 0, 0);
                        sD.a(this.a[n12 + 1], n9, n2, 52, 0, n15, dArray, n10, 0, n10 - n15);
                        sD.a(this.a[n12 + this.b], n13, 0, n14, n4, 52, dArray, n10, n7 - n14, 0);
                        sD.a(this.a[n12 + this.b + 1], n9, 0, n14, 0, n15, dArray, n10, n7 - n14, n10 - n15);
                    } else {
                        sD.a(this.a[n12], n13, n2, 52, n4, n10 + n4, dArray, n10, 0, 0);
                        sD.a(this.a[n12 + this.b], n13, 0, n14, n4, n10 + n4, dArray, n10, n7 - n14, 0);
                    }
                } else if (n15 > 0) {
                    n9 = this.h(n8 + 1);
                    sD.a(this.a[n12], n13, n2, n7 + n2, n4, 52, dArray, n10, 0, 0);
                    sD.a(this.a[n12 + 1], n9, n2, n7 + n2, 0, n15, dArray, n10, 0, n10 - n15);
                } else {
                    sD.a(this.a[n12], n13, n2, n7 + n2, n4, n10 + n4, dArray, n10, 0, 0);
                }
                ++n8;
            }
            ++n5;
        }
        return sD2;
    }

    private static void a(double[] dArray, int n2, int n3, int n4, int n5, int n6, double[] dArray2, int n7, int n8, int n9) {
        n6 -= n5;
        n5 = n3 * n2 + n5;
        n8 = n8 * n7 + n9;
        while (n3 < n4) {
            System.arraycopy(dArray, n5, dArray2, n8, n6);
            n5 += n2;
            n8 += n7;
            ++n3;
        }
    }

    public final void a(double[][] dArray, int n2, int n3) {
        int n4;
        ci_0.a(dArray);
        int n5 = dArray[0].length;
        if (n5 == 0) {
            throw new pf_0(px_0.AT_LEAST_ONE_COLUMN);
        }
        int n6 = n2 + dArray.length - 1;
        int n7 = n3 + n5 - 1;
        td_0.a(this, n2, n6, n3, n7);
        double[][] dArray2 = dArray;
        int n8 = dArray.length;
        for (n4 = 0; n4 < n8; ++n4) {
            double[] dArray3 = dArray2[n4];
            if (dArray3.length == n5) continue;
            throw new oS(n5, dArray3.length);
        }
        int n9 = n2 / 52;
        n8 = (n6 + 52) / 52;
        n4 = n3 / 52;
        int n10 = (n7 + 52) / 52;
        for (n5 = n9; n5 < n8; ++n5) {
            n9 = this.k(n5);
            int n11 = n5 * 52;
            int n12 = BY.b(n2, n11);
            n9 = BY.a(n6 + 1, n11 + n9);
            for (int i2 = n4; i2 < n10; ++i2) {
                int n13 = this.h(i2);
                int n14 = i2 * 52;
                int n15 = BY.b(n3, n14);
                int n16 = BY.a(n7 + 1, n14 + n13);
                n16 -= n15;
                double[] dArray4 = this.a[n5 * this.b + i2];
                for (int i3 = n12; i3 < n9; ++i3) {
                    System.arraycopy(dArray[i3 - n2], n15 - n3, dArray4, (i3 - n11) * n13 + (n15 - n14), n16);
                }
            }
        }
    }

    private sD i(int n2) {
        td_0.a((sw_0)this, n2);
        sD sD2 = new sD(1, this.f);
        int n3 = n2 / 52;
        n2 -= n3 * 52;
        int n4 = 0;
        int n5 = 0;
        double[] dArray = sD2.a[0];
        for (int i2 = 0; i2 < this.b; ++i2) {
            int n6 = this.h(i2);
            double[] dArray2 = this.a[n3 * this.b + i2];
            int n7 = dArray.length - n5;
            if (n6 > n7) {
                System.arraycopy(dArray2, n2 * n6, dArray, n5, n7);
                dArray = sD2.a[++n4];
                System.arraycopy(dArray2, n2 * n6, dArray, 0, n6 - n7);
                n5 = n6 - n7;
                continue;
            }
            System.arraycopy(dArray2, n2 * n6, dArray, n5, n6);
            n5 += n6;
        }
        return sD2;
    }

    public final void a(int n2, tq_0 tq_02) {
        try {
            int n3;
            sD sD2;
            int n4;
            sD sD3;
            block8: {
                sD sD4;
                block7: {
                    sD3 = (sD)tq_02;
                    n4 = n2;
                    sD2 = this;
                    td_0.a((sw_0)sD2, n4);
                    sD4 = sD2;
                    n3 = sD4.f;
                    sD4 = sD3;
                    if (sD4.e != 1) break block7;
                    sD4 = sD3;
                    if (sD4.f == n3) break block8;
                }
                sD sD5 = sD3;
                sD4 = sD5;
                sD4 = sD3;
                throw new tc_0(sD5.e, sD4.f, 1, n3);
            }
            n3 = n4 / 52;
            n4 -= n3 * 52;
            int n5 = 0;
            int n6 = 0;
            double[] dArray = sD3.a[0];
            for (int i2 = 0; i2 < sD2.b; ++i2) {
                int n7 = sD2.h(i2);
                double[] dArray2 = sD2.a[n3 * sD2.b + i2];
                int n8 = dArray.length - n6;
                if (n7 > n8) {
                    System.arraycopy(dArray, n6, dArray2, n4 * n7, n8);
                    dArray = sD3.a[++n5];
                    System.arraycopy(dArray, 0, dArray2, n4 * n7, n7 - n8);
                    n6 = n7 - n8;
                    continue;
                }
                System.arraycopy(dArray, n6, dArray2, n4 * n7, n7);
                n6 += n7;
            }
            return;
        }
        catch (ClassCastException classCastException) {
            super.a(n2, tq_02);
            return;
        }
    }

    private void a(int n2, sD sD2) {
        int n3;
        block6: {
            sD sD3;
            block5: {
                td_0.a((sw_0)this, n2);
                sD3 = this;
                n3 = sD3.f;
                sD3 = sD2;
                if (sD3.e != 1) break block5;
                sD3 = sD2;
                if (sD3.f == n3) break block6;
            }
            sD sD4 = sD2;
            sD3 = sD4;
            sD3 = sD2;
            throw new tc_0(sD4.e, sD3.f, 1, n3);
        }
        n3 = n2 / 52;
        n2 -= n3 * 52;
        int n4 = 0;
        int n5 = 0;
        double[] dArray = sD2.a[0];
        for (int i2 = 0; i2 < this.b; ++i2) {
            int n6 = this.h(i2);
            double[] dArray2 = this.a[n3 * this.b + i2];
            int n7 = dArray.length - n5;
            if (n6 > n7) {
                System.arraycopy(dArray, n5, dArray2, n2 * n6, n7);
                dArray = sD2.a[++n4];
                System.arraycopy(dArray, 0, dArray2, n2 * n6, n6 - n7);
                n5 = n6 - n7;
                continue;
            }
            System.arraycopy(dArray, n5, dArray2, n2 * n6, n6);
            n5 += n6;
        }
    }

    private sD j(int n2) {
        td_0.b((sw_0)this, n2);
        sD sD2 = new sD(this.e, 1);
        int n3 = n2 / 52;
        n2 -= n3 * 52;
        int n4 = this.h(n3);
        int n5 = 0;
        int n6 = 0;
        double[] dArray = sD2.a[0];
        for (int i2 = 0; i2 < this.g; ++i2) {
            int n7 = this.k(i2);
            double[] dArray2 = this.a[i2 * this.b + n3];
            for (int i3 = 0; i3 < n7; ++i3) {
                if (n6 >= dArray.length) {
                    dArray = sD2.a[++n5];
                    n6 = 0;
                }
                dArray[n6++] = dArray2[i3 * n4 + n2];
            }
        }
        return sD2;
    }

    public final void b(int n2, tq_0 tq_02) {
        try {
            int n3;
            sD sD2;
            int n4;
            sD sD3;
            block9: {
                sD sD4;
                block8: {
                    sD3 = (sD)tq_02;
                    n4 = n2;
                    sD2 = this;
                    td_0.b((sw_0)sD2, n4);
                    sD4 = sD2;
                    n3 = sD4.e;
                    sD4 = sD3;
                    if (sD4.e != n3) break block8;
                    sD4 = sD3;
                    if (sD4.f == 1) break block9;
                }
                sD sD5 = sD3;
                sD4 = sD5;
                sD4 = sD3;
                throw new tc_0(sD5.e, sD4.f, n3, 1);
            }
            n3 = n4 / 52;
            n4 -= n3 * 52;
            int n5 = sD2.h(n3);
            int n6 = 0;
            int n7 = 0;
            double[] dArray = sD3.a[0];
            for (int i2 = 0; i2 < sD2.g; ++i2) {
                int n8 = sD2.k(i2);
                double[] dArray2 = sD2.a[i2 * sD2.b + n3];
                for (int i3 = 0; i3 < n8; ++i3) {
                    if (n7 >= dArray.length) {
                        dArray = sD3.a[++n6];
                        n7 = 0;
                    }
                    dArray2[i3 * n5 + n4] = dArray[n7++];
                }
            }
            return;
        }
        catch (ClassCastException classCastException) {
            super.b(n2, tq_02);
            return;
        }
    }

    private void b(int n2, sD sD2) {
        int n3;
        block7: {
            sD sD3;
            block6: {
                td_0.b((sw_0)this, n2);
                sD3 = this;
                n3 = sD3.e;
                sD3 = sD2;
                if (sD3.e != n3) break block6;
                sD3 = sD2;
                if (sD3.f == 1) break block7;
            }
            sD sD4 = sD2;
            sD3 = sD4;
            sD3 = sD2;
            throw new tc_0(sD4.e, sD3.f, n3, 1);
        }
        n3 = n2 / 52;
        n2 -= n3 * 52;
        int n4 = this.h(n3);
        int n5 = 0;
        int n6 = 0;
        double[] dArray = sD2.a[0];
        for (int i2 = 0; i2 < this.g; ++i2) {
            int n7 = this.k(i2);
            double[] dArray2 = this.a[i2 * this.b + n3];
            for (int i3 = 0; i3 < n7; ++i3) {
                if (n6 >= dArray.length) {
                    dArray = sD2.a[++n5];
                    n6 = 0;
                }
                dArray2[i3 * n4 + n2] = dArray[n6++];
            }
        }
    }

    public final sA d(int n2) {
        td_0.a((sw_0)this, n2);
        double[] dArray = new double[this.f];
        int n3 = n2 / 52;
        n2 -= n3 * 52;
        int n4 = 0;
        for (int i2 = 0; i2 < this.b; ++i2) {
            int n5 = this.h(i2);
            double[] dArray2 = this.a[n3 * this.b + i2];
            System.arraycopy(dArray2, n2 * n5, dArray, n4, n5);
            n4 += n5;
        }
        return new sA(dArray, false);
    }

    public final void a(int n2, tu_0 tu_02) {
        try {
            Serializable serializable = (sA)((Object)tu_02);
            double[] dArray = serializable.a;
            int n3 = n2;
            sD sD2 = this;
            td_0.a((sw_0)sD2, n3);
            serializable = sD2;
            int n4 = ((sD)serializable).f;
            if (dArray.length != n4) {
                throw new tc_0(1, dArray.length, 1, n4);
            }
            n4 = n3 / 52;
            n3 -= n4 * 52;
            int n5 = 0;
            for (int i2 = 0; i2 < sD2.b; ++i2) {
                int n6 = sD2.h(i2);
                double[] dArray2 = sD2.a[n4 * sD2.b + i2];
                System.arraycopy(dArray, n5, dArray2, n3 * n6, n6);
                n5 += n6;
            }
            return;
        }
        catch (ClassCastException classCastException) {
            super.a(n2, tu_02);
            return;
        }
    }

    public final sA e(int n2) {
        td_0.b((sw_0)this, n2);
        double[] dArray = new double[this.e];
        int n3 = n2 / 52;
        n2 -= n3 * 52;
        int n4 = this.h(n3);
        int n5 = 0;
        for (int i2 = 0; i2 < this.g; ++i2) {
            int n6 = this.k(i2);
            double[] dArray2 = this.a[i2 * this.b + n3];
            for (int i3 = 0; i3 < n6; ++i3) {
                dArray[n5++] = dArray2[i3 * n4 + n2];
            }
        }
        return new sA(dArray, false);
    }

    public final void b(int n2, tu_0 tu_02) {
        try {
            sA sA2 = (sA)((Object)tu_02);
            ((sv_0)this).b(n2, sA2.a);
            return;
        }
        catch (ClassCastException classCastException) {
            super.b(n2, tu_02);
            return;
        }
    }

    public final double[] f(int n2) {
        td_0.a((sw_0)this, n2);
        double[] dArray = new double[this.f];
        int n3 = n2 / 52;
        n2 -= n3 * 52;
        int n4 = 0;
        for (int i2 = 0; i2 < this.b; ++i2) {
            int n5 = this.h(i2);
            double[] dArray2 = this.a[n3 * this.b + i2];
            System.arraycopy(dArray2, n2 * n5, dArray, n4, n5);
            n4 += n5;
        }
        return dArray;
    }

    public final void a(int n2, double[] dArray) {
        td_0.a((sw_0)this, n2);
        sD sD2 = this;
        int n3 = sD2.f;
        if (dArray.length != n3) {
            throw new tc_0(1, dArray.length, 1, n3);
        }
        n3 = n2 / 52;
        n2 -= n3 * 52;
        int n4 = 0;
        for (int i2 = 0; i2 < this.b; ++i2) {
            int n5 = this.h(i2);
            double[] dArray2 = this.a[n3 * this.b + i2];
            System.arraycopy(dArray, n4, dArray2, n2 * n5, n5);
            n4 += n5;
        }
    }

    public final double[] g(int n2) {
        td_0.b((sw_0)this, n2);
        double[] dArray = new double[this.e];
        int n3 = n2 / 52;
        n2 -= n3 * 52;
        int n4 = this.h(n3);
        int n5 = 0;
        for (int i2 = 0; i2 < this.g; ++i2) {
            int n6 = this.k(i2);
            double[] dArray2 = this.a[i2 * this.b + n3];
            for (int i3 = 0; i3 < n6; ++i3) {
                dArray[n5++] = dArray2[i3 * n4 + n2];
            }
        }
        return dArray;
    }

    public final void b(int n2, double[] dArray) {
        td_0.b((sw_0)this, n2);
        sD sD2 = this;
        int n3 = sD2.e;
        if (dArray.length != n3) {
            throw new tc_0(dArray.length, 1, n3, 1);
        }
        n3 = n2 / 52;
        n2 -= n3 * 52;
        int n4 = this.h(n3);
        int n5 = 0;
        for (int i2 = 0; i2 < this.g; ++i2) {
            int n6 = this.k(i2);
            double[] dArray2 = this.a[i2 * this.b + n3];
            for (int i3 = 0; i3 < n6; ++i3) {
                dArray2[i3 * n4 + n2] = dArray[n5++];
            }
        }
    }

    public final double b(int n2, int n3) {
        td_0.a((sv_0)this, n2, n3);
        int n4 = n2 / 52;
        int n5 = n3 / 52;
        n2 = (n2 - n4 * 52) * this.h(n5) + (n3 - n5 * 52);
        return this.a[n4 * this.b + n5][n2];
    }

    public final void c(int n2, int n3, double d2) {
        td_0.a((sv_0)this, n2, n3);
        int n4 = n2 / 52;
        int n5 = n3 / 52;
        n2 = (n2 - n4 * 52) * this.h(n5) + (n3 - n5 * 52);
        this.a[n4 * this.b + n5][n2] = d2;
    }

    public final void a(int n2, int n3, double d2) {
        td_0.a((sv_0)this, n2, n3);
        int n4 = n2 / 52;
        int n5 = n3 / 52;
        n2 = (n2 - n4 * 52) * this.h(n5) + (n3 - n5 * 52);
        double[] dArray = this.a[n4 * this.b + n5];
        int n6 = n2;
        dArray[n6] = dArray[n6] + d2;
    }

    public final void b(int n2, int n3, double d2) {
        td_0.a((sv_0)this, n2, n3);
        int n4 = n2 / 52;
        int n5 = n3 / 52;
        n2 = (n2 - n4 * 52) * this.h(n5) + (n3 - n5 * 52);
        double[] dArray = this.a[n4 * this.b + n5];
        int n6 = n2;
        dArray[n6] = dArray[n6] * d2;
    }

    private sD k() {
        sD sD2 = this;
        int n2 = sD2.e;
        sD2 = this;
        int n3 = sD2.f;
        sD sD3 = new sD(n3, n2);
        n3 = 0;
        for (int i2 = 0; i2 < this.b; ++i2) {
            for (int i3 = 0; i3 < this.g; ++i3) {
                double[] dArray = sD3.a[n3];
                double[] dArray2 = this.a[i3 * this.b + i2];
                int n4 = i2 * 52;
                int n5 = BY.a(n4 + 52, this.f);
                int n6 = i3 * 52;
                int n7 = BY.a(n6 + 52, this.e);
                int n8 = 0;
                for (int i4 = n4; i4 < n5; ++i4) {
                    int n9 = n5 - n4;
                    int n10 = i4 - n4;
                    for (int i5 = n6; i5 < n7; ++i5) {
                        dArray[n8] = dArray2[n10];
                        ++n8;
                        n10 += n9;
                    }
                }
                ++n3;
            }
        }
        return sD3;
    }

    public final int f() {
        return this.e;
    }

    public final int g() {
        return this.f;
    }

    public final double[] a(double[] dArray) {
        if (dArray.length != this.f) {
            throw new oS(dArray.length, this.f);
        }
        double[] dArray2 = new double[this.e];
        for (int i2 = 0; i2 < this.g; ++i2) {
            int n2 = i2 * 52;
            int n3 = BY.a(n2 + 52, this.e);
            for (int i3 = 0; i3 < this.b; ++i3) {
                double[] dArray3 = this.a[i2 * this.b + i3];
                int n4 = i3 * 52;
                int n5 = BY.a(n4 + 52, this.f);
                int n6 = 0;
                int n7 = n2;
                while (n7 < n3) {
                    int n8;
                    double d2 = 0.0;
                    for (n8 = n4; n8 < n5 - 3; n8 += 4) {
                        d2 += dArray3[n6] * dArray[n8] + dArray3[n6 + 1] * dArray[n8 + 1] + dArray3[n6 + 2] * dArray[n8 + 2] + dArray3[n6 + 3] * dArray[n8 + 3];
                        n6 += 4;
                    }
                    while (n8 < n5) {
                        d2 += dArray3[n6++] * dArray[n8++];
                    }
                    int n9 = n7++;
                    dArray2[n9] = dArray2[n9] + d2;
                }
            }
        }
        return dArray2;
    }

    public final double[] b(double[] dArray) {
        if (dArray.length != this.e) {
            throw new oS(dArray.length, this.e);
        }
        double[] dArray2 = new double[this.f];
        for (int i2 = 0; i2 < this.b; ++i2) {
            int n2 = this.h(i2);
            int n3 = n2 + n2;
            int n4 = n3 + n2;
            int n5 = n4 + n2;
            int n6 = i2 * 52;
            int n7 = BY.a(n6 + 52, this.f);
            for (int i3 = 0; i3 < this.g; ++i3) {
                double[] dArray3 = this.a[i3 * this.b + i2];
                int n8 = i3 * 52;
                int n9 = BY.a(n8 + 52, this.e);
                int n10 = n6;
                while (n10 < n7) {
                    int n11;
                    int n12 = n10 - n6;
                    double d2 = 0.0;
                    for (n11 = n8; n11 < n9 - 3; n11 += 4) {
                        d2 += dArray3[n12] * dArray[n11] + dArray3[n12 + n2] * dArray[n11 + 1] + dArray3[n12 + n3] * dArray[n11 + 2] + dArray3[n12 + n4] * dArray[n11 + 3];
                        n12 += n5;
                    }
                    while (n11 < n9) {
                        d2 += dArray3[n12] * dArray[n11++];
                        n12 += n2;
                    }
                    int n13 = n10++;
                    dArray2[n13] = dArray2[n13] + d2;
                }
            }
        }
        return dArray2;
    }

    public final double a(tr_0 tr_02) {
        for (int i2 = 0; i2 < this.g; ++i2) {
            int n2 = i2 * 52;
            int n3 = BY.a(n2 + 52, this.e);
            for (int i3 = n2; i3 < n3; ++i3) {
                for (int i4 = 0; i4 < this.b; ++i4) {
                    int n4 = this.h(i4);
                    int n5 = i4 * 52;
                    int n6 = BY.a(n5 + 52, this.f);
                    double[] dArray = this.a[i2 * this.b + i4];
                    n4 = (i3 - n2) * n4;
                    while (n5 < n6) {
                        dArray[n4] = tr_02.a(i3, n5, dArray[n4]);
                        ++n4;
                        ++n5;
                    }
                }
            }
        }
        return tr_02.b();
    }

    public final double a(tt_0 tt_02) {
        tt_02.a(0, this.e - 1, 0);
        for (int i2 = 0; i2 < this.g; ++i2) {
            int n2 = i2 * 52;
            int n3 = BY.a(n2 + 52, this.e);
            for (int i3 = n2; i3 < n3; ++i3) {
                for (int i4 = 0; i4 < this.b; ++i4) {
                    int n4 = this.h(i4);
                    int n5 = i4 * 52;
                    int n6 = BY.a(n5 + 52, this.f);
                    double[] dArray = this.a[i2 * this.b + i4];
                    n4 = (i3 - n2) * n4;
                    while (n5 < n6) {
                        tt_02.a(i3, n5, dArray[n4]);
                        ++n4;
                        ++n5;
                    }
                }
            }
        }
        return tt_02.a();
    }

    public final double a(tr_0 tr_02, int n2, int n3, int n4, int n5) {
        td_0.a(this, n2, n3, n4, n5);
        for (int i2 = n2 / 52; i2 < 1 + n3 / 52; ++i2) {
            int n6 = i2 * 52;
            int n7 = BY.b(n2, n6);
            int n8 = BY.a((i2 + 1) * 52, n3 + 1);
            while (n7 < n8) {
                for (int i3 = n4 / 52; i3 < 1 + n5 / 52; ++i3) {
                    int n9 = this.h(i3);
                    int n10 = i3 * 52;
                    int n11 = BY.b(n4, n10);
                    int n12 = BY.a((i3 + 1) * 52, n5 + 1);
                    double[] dArray = this.a[i2 * this.b + i3];
                    n9 = (n7 - n6) * n9 + n11 - n10;
                    for (n10 = n11; n10 < n12; ++n10) {
                        dArray[n9] = tr_02.a(n7, n10, dArray[n9]);
                        ++n9;
                    }
                }
                ++n7;
            }
        }
        return tr_02.b();
    }

    public final double a(tt_0 tt_02, int n2, int n3, int n4, int n5) {
        td_0.a(this, n2, n3, n4, n5);
        tt_02.a(n2, n3, n4);
        for (int i2 = n2 / 52; i2 < 1 + n3 / 52; ++i2) {
            int n6 = i2 * 52;
            int n7 = BY.b(n2, n6);
            int n8 = BY.a((i2 + 1) * 52, n3 + 1);
            while (n7 < n8) {
                for (int i3 = n4 / 52; i3 < 1 + n5 / 52; ++i3) {
                    int n9 = this.h(i3);
                    int n10 = i3 * 52;
                    int n11 = BY.b(n4, n10);
                    int n12 = BY.a((i3 + 1) * 52, n5 + 1);
                    double[] dArray = this.a[i2 * this.b + i3];
                    n9 = (n7 - n6) * n9 + n11 - n10;
                    for (n10 = n11; n10 < n12; ++n10) {
                        tt_02.a(n7, n10, dArray[n9]);
                        ++n9;
                    }
                }
                ++n7;
            }
        }
        return tt_02.a();
    }

    public final double a(sv_0.3 var1_1) {
        int n2 = 0;
        for (int i2 = 0; i2 < this.g; ++i2) {
            int n3 = i2 * 52;
            int n4 = BY.a(n3 + 52, this.e);
            for (int i3 = 0; i3 < this.b; ++i3) {
                int n5 = i3 * 52;
                int n6 = BY.a(n5 + 52, this.f);
                double[] dArray = this.a[n2];
                int n7 = 0;
                for (int i4 = n3; i4 < n4; ++i4) {
                    for (int i5 = n5; i5 < n6; ++i5) {
                        dArray[n7] = var1_1.a(i4, i5, dArray[n7]);
                        ++n7;
                    }
                }
                ++n2;
            }
        }
        return var1_1.b();
    }

    public final double b(tt_0 tt_02) {
        tt_02.a(0, this.e - 1, 0);
        int n2 = 0;
        for (int i2 = 0; i2 < this.g; ++i2) {
            int n3 = i2 * 52;
            int n4 = BY.a(n3 + 52, this.e);
            for (int i3 = 0; i3 < this.b; ++i3) {
                int n5 = i3 * 52;
                int n6 = BY.a(n5 + 52, this.f);
                double[] dArray = this.a[n2];
                int n7 = 0;
                for (int i4 = n3; i4 < n4; ++i4) {
                    for (int i5 = n5; i5 < n6; ++i5) {
                        tt_02.a(i4, i5, dArray[n7]);
                        ++n7;
                    }
                }
                ++n2;
            }
        }
        return tt_02.a();
    }

    public final double c(tr_0 tr_02, int n2, int n3, int n4, int n5) {
        td_0.a(this, n2, n3, n4, n5);
        for (int i2 = n2 / 52; i2 < 1 + n3 / 52; ++i2) {
            int n6 = i2 * 52;
            int n7 = BY.b(n2, n6);
            int n8 = BY.a((i2 + 1) * 52, n3 + 1);
            for (int i3 = n4 / 52; i3 < 1 + n5 / 52; ++i3) {
                int n9 = this.h(i3);
                int n10 = i3 * 52;
                int n11 = BY.b(n4, n10);
                int n12 = BY.a((i3 + 1) * 52, n5 + 1);
                double[] dArray = this.a[i2 * this.b + i3];
                for (int i4 = n7; i4 < n8; ++i4) {
                    int n13 = (i4 - n6) * n9 + n11 - n10;
                    for (int i5 = n11; i5 < n12; ++i5) {
                        dArray[n13] = tr_02.a(i4, i5, dArray[n13]);
                        ++n13;
                    }
                }
            }
        }
        return tr_02.b();
    }

    public final double a(sL sL2, int n2, int n3, int n4, int n5) {
        td_0.a(this, n2, n3, n4, n5);
        sL2.a(n2, n3, n4);
        for (int i2 = n2 / 52; i2 < 1 + n3 / 52; ++i2) {
            int n6 = i2 * 52;
            int n7 = BY.b(n2, n6);
            int n8 = BY.a((i2 + 1) * 52, n3 + 1);
            for (int i3 = n4 / 52; i3 < 1 + n5 / 52; ++i3) {
                int n9 = this.h(i3);
                int n10 = i3 * 52;
                int n11 = BY.b(n4, n10);
                int n12 = BY.a((i3 + 1) * 52, n5 + 1);
                double[] dArray = this.a[i2 * this.b + i3];
                for (int i4 = n7; i4 < n8; ++i4) {
                    int n13 = (i4 - n6) * n9 + n11 - n10;
                    for (int i5 = n11; i5 < n12; ++i5) {
                        sL2.a(i4, i5, dArray[n13]);
                        ++n13;
                    }
                }
            }
        }
        return sL2.a();
    }

    private int k(int n2) {
        if (n2 == this.g - 1) {
            return this.e - n2 * 52;
        }
        return 52;
    }

    int h(int n2) {
        if (n2 == this.b - 1) {
            return this.f - n2 * 52;
        }
        return 52;
    }

    public final /* synthetic */ sv_0 i() {
        sD sD2 = this;
        sD sD3 = new sD(sD2.e, sD2.f);
        for (int i2 = 0; i2 < sD2.a.length; ++i2) {
            System.arraycopy(sD2.a[i2], 0, sD3.a[i2], 0, sD2.a[i2].length);
        }
        return sD3;
    }

    public final /* synthetic */ sv_0 a(int n2, int n3) {
        return new sD(n2, n3);
    }

    public final /* synthetic */ tq_0 d() {
        sD sD2;
        sD sD3 = sD2 = this;
        int n2 = sD2.e;
        sD3 = sD2;
        int n3 = sD3.f;
        sD sD4 = new sD(n3, n2);
        n3 = 0;
        for (int i2 = 0; i2 < sD2.b; ++i2) {
            for (int i3 = 0; i3 < sD2.g; ++i3) {
                double[] dArray = sD4.a[n3];
                double[] dArray2 = sD2.a[i3 * sD2.b + i2];
                int n4 = i2 * 52;
                int n5 = BY.a(n4 + 52, sD2.f);
                int n6 = i3 * 52;
                int n7 = BY.a(n6 + 52, sD2.e);
                int n8 = 0;
                for (int i4 = n4; i4 < n5; ++i4) {
                    int n9 = n5 - n4;
                    int n10 = i4 - n4;
                    for (int i5 = n6; i5 < n7; ++i5) {
                        dArray[n8] = dArray2[n10];
                        ++n8;
                        n10 += n9;
                    }
                }
                ++n3;
            }
        }
        return sD4;
    }

    public final /* synthetic */ tq_0 c(int n2) {
        int n3 = n2;
        sD sD2 = this;
        td_0.b((sw_0)sD2, n3);
        sD sD3 = new sD(sD2.e, 1);
        int n4 = n3 / 52;
        n3 -= n4 * 52;
        int n5 = sD2.h(n4);
        int n6 = 0;
        int n7 = 0;
        double[] dArray = sD3.a[0];
        for (int i2 = 0; i2 < sD2.g; ++i2) {
            int n8 = sD2.k(i2);
            double[] dArray2 = sD2.a[i2 * sD2.b + n4];
            for (int i3 = 0; i3 < n8; ++i3) {
                if (n7 >= dArray.length) {
                    dArray = sD3.a[++n6];
                    n7 = 0;
                }
                dArray[n7++] = dArray2[i3 * n5 + n3];
            }
        }
        return sD3;
    }

    public final /* synthetic */ tq_0 b(int n2) {
        int n3 = n2;
        sD sD2 = this;
        td_0.a((sw_0)sD2, n3);
        sD sD3 = new sD(1, sD2.f);
        int n4 = n3 / 52;
        n3 -= n4 * 52;
        int n5 = 0;
        int n6 = 0;
        double[] dArray = sD3.a[0];
        for (int i2 = 0; i2 < sD2.b; ++i2) {
            int n7 = sD2.h(i2);
            double[] dArray2 = sD2.a[n4 * sD2.b + i2];
            int n8 = dArray.length - n6;
            if (n7 > n8) {
                System.arraycopy(dArray2, n3 * n7, dArray, n6, n8);
                dArray = sD3.a[++n5];
                System.arraycopy(dArray2, n3 * n7, dArray, 0, n7 - n8);
                n6 = n7 - n8;
                continue;
            }
            System.arraycopy(dArray2, n3 * n7, dArray, n6, n7);
            n6 += n7;
        }
        return sD3;
    }

    public final /* synthetic */ tq_0 a(int n2, int n3, int n4, int n5) {
        int n6 = n5;
        n5 = n4;
        n4 = n3;
        n3 = n2;
        sD sD2 = this;
        td_0.a(sD2, n3, n4, n5, n6);
        sD sD3 = new sD(n4 - n3 + 1, n6 - n5 + 1);
        n6 = n3 / 52;
        n3 %= 52;
        int n7 = n5 / 52;
        n5 %= 52;
        for (int i2 = 0; i2 < sD3.g; ++i2) {
            int n8 = sD3.k(i2);
            int n9 = n7;
            for (int i3 = 0; i3 < sD3.b; ++i3) {
                int n10;
                int n11 = sD3.h(i3);
                int n12 = i2 * sD3.b + i3;
                double[] dArray = sD3.a[n12];
                int n13 = n6 * sD2.b + n9;
                int n14 = sD2.h(n9);
                int n15 = n8 + n3 - 52;
                int n16 = n11 + n5 - 52;
                if (n15 > 0) {
                    if (n16 > 0) {
                        n10 = sD2.h(n9 + 1);
                        sD.a(sD2.a[n13], n14, n3, 52, n5, 52, dArray, n11, 0, 0);
                        sD.a(sD2.a[n13 + 1], n10, n3, 52, 0, n16, dArray, n11, 0, n11 - n16);
                        sD.a(sD2.a[n13 + sD2.b], n14, 0, n15, n5, 52, dArray, n11, n8 - n15, 0);
                        sD.a(sD2.a[n13 + sD2.b + 1], n10, 0, n15, 0, n16, dArray, n11, n8 - n15, n11 - n16);
                    } else {
                        sD.a(sD2.a[n13], n14, n3, 52, n5, n11 + n5, dArray, n11, 0, 0);
                        sD.a(sD2.a[n13 + sD2.b], n14, 0, n15, n5, n11 + n5, dArray, n11, n8 - n15, 0);
                    }
                } else if (n16 > 0) {
                    n10 = sD2.h(n9 + 1);
                    sD.a(sD2.a[n13], n14, n3, n8 + n3, n5, 52, dArray, n11, 0, 0);
                    sD.a(sD2.a[n13 + 1], n10, n3, n8 + n3, 0, n16, dArray, n11, 0, n11 - n16);
                } else {
                    sD.a(sD2.a[n13], n14, n3, n8 + n3, n5, n11 + n5, dArray, n11, 0, 0);
                }
                ++n9;
            }
            ++n6;
        }
        return sD3;
    }

    public final /* synthetic */ tq_0 c(tq_0 tq_02) {
        return this.g(tq_02);
    }

    public final /* synthetic */ tq_0 a(double d2) {
        double d3 = d2;
        sD sD2 = this;
        sD sD3 = new sD(sD2.e, sD2.f);
        for (int i2 = 0; i2 < sD3.a.length; ++i2) {
            double[] dArray = sD3.a[i2];
            double[] dArray2 = sD2.a[i2];
            for (int i3 = 0; i3 < dArray.length; ++i3) {
                dArray[i3] = dArray2[i3] + d3;
            }
        }
        return sD3;
    }

    public final /* synthetic */ tq_0 b(tq_0 tq_02) {
        return this.f(tq_02);
    }

    public final /* synthetic */ tq_0 a(tq_0 tq_02) {
        return this.e(tq_02);
    }
}

