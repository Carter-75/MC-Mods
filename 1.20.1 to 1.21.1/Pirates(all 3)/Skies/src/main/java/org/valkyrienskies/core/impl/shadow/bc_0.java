/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Arrays;
import java.util.HashSet;
import java.util.TreeSet;
import org.valkyrienskies.core.impl.shadow.BR;
import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.ch_0;
import org.valkyrienskies.core.impl.shadow.kM;
import org.valkyrienskies.core.impl.shadow.kN;
import org.valkyrienskies.core.impl.shadow.oI;
import org.valkyrienskies.core.impl.shadow.oN;
import org.valkyrienskies.core.impl.shadow.oT;
import org.valkyrienskies.core.impl.shadow.oY;
import org.valkyrienskies.core.impl.shadow.oe_0;
import org.valkyrienskies.core.impl.shadow.om_0;
import org.valkyrienskies.core.impl.shadow.pl_0;
import org.valkyrienskies.core.impl.shadow.pm_0;
import org.valkyrienskies.core.impl.shadow.po_0;
import org.valkyrienskies.core.impl.shadow.pq_0;
import org.valkyrienskies.core.impl.shadow.px_0;
import org.valkyrienskies.core.impl.shadow.qd_0;
import org.valkyrienskies.core.impl.shadow.qe_0;
import org.valkyrienskies.core.impl.shadow.qh_0;
import org.valkyrienskies.core.impl.shadow.sQ;
import org.valkyrienskies.core.impl.shadow.sx_0;
import org.valkyrienskies.core.impl.shadow.td_0;
import org.valkyrienskies.core.impl.shadow.tq_0;
import org.valkyrienskies.core.impl.shadow.zF;
import org.valkyrienskies.core.impl.shadow.zR;
import org.valkyrienskies.core.impl.shadow.zy_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.Bc
 */
public final class bc_0 {
    private static int b = 100000;
    private static double c = 1.0E-20;
    private static double d = 1.0E-10;
    @Deprecated
    private static int e = 200;
    private static int f = 10000;
    @Deprecated
    private static int g = 1000000;
    final zF a;

    public bc_0() {
        this.a = new zR();
    }

    @Deprecated
    private bc_0(zF zF2) {
        this.a = zF2;
    }

    public final double a(oI oI2, double[] dArray, boolean bl) {
        bc_0 bc_02 = this;
        return 1.0 - bc_02.a(bc_02.a(oI2, dArray), dArray.length, bl);
    }

    public final double a(oI oI2, double[] dArray) {
        bc_0.a(dArray);
        int n2 = dArray.length;
        double d2 = n2;
        double[] dArray2 = new double[n2];
        System.arraycopy(dArray, 0, dArray2, 0, n2);
        Arrays.sort(dArray2);
        double d3 = 0.0;
        for (int i2 = 1; i2 <= n2; ++i2) {
            double d4;
            double d5 = oI2.e(dArray2[i2 - 1]);
            double d6 = BY.e(d5 - (double)(i2 - 1) / d2, (double)i2 / d2 - d5);
            if (!(d4 > d3)) continue;
            d3 = d6;
        }
        return d3;
    }

    /*
     * WARNING - void declaration
     */
    public final double a(double[] dArray, double[] dArray2, boolean bl) {
        double[] dArray3;
        double[] dArray4;
        long l2 = (long)dArray.length * (long)dArray2.length;
        if (l2 < 10000L && bc_0.e(dArray, dArray2)) {
            void var15_21;
            dArray4 = dArray;
            dArray3 = ch_0.a(dArray, dArray4.length);
            dArray4 = dArray2;
            double[] dArray5 = dArray4 = ch_0.a(dArray2, dArray4.length);
            double[] dArray6 = dArray3;
            Object object = new double[][]{dArray6, dArray5};
            int n3 = 0;
            double[][] dArrayArray = object;
            int cfr_ignored_0 = ((double[][])object).length;
            for (int i2 = 0; i2 < 2; ++i2) {
                double[] dArray7 = dArrayArray[i2];
                n3 += dArray7.length;
            }
            int n4 = 0;
            Object object2 = new double[n3];
            boolean n2 = false;
            while (var15_21 < ((double[][])object).length) {
                int n5 = object[var15_21].length;
                System.arraycopy(object[var15_21], 0, object2, n4, n5);
                n4 += n5;
                ++var15_21;
            }
            object = object2;
            TreeSet<Double> treeSet = new TreeSet<Double>();
            for (n4 = 0; n4 < ((double[][])object).length; ++n4) {
                treeSet.add((double)object[n4]);
            }
            n4 = treeSet.size();
            double[] dArray7 = new double[n4];
            object2 = treeSet.iterator();
            boolean bl2 = false;
            while (object2.hasNext()) {
                dArray7[n4 - ++var15_23] = (Double)object2.next();
            }
            object = dArray7;
            if (dArray7.length != dArray6.length + dArray5.length) {
                boolean bl22;
                Object object3 = 1.0;
                double[] dArray8 = object[0];
                for (int i2 = 1; i2 < ((double[][])object).length; ++i2) {
                    reference v0;
                    reference var15_24 = dArray8 - object[i2];
                    if (v0 < object3) {
                        object3 = var15_24;
                    }
                    dArray8 = object[i2];
                }
                oN oN2 = new oN(new zy_0(100), -(object3 /= 2.0), (double)object3);
                int n6 = 0;
                do {
                    bc_0.a(dArray6, oN2);
                    bc_0.a(dArray5, oN2);
                } while ((bl22 = bc_0.e(dArray6, dArray5)) && ++n6 < 1000);
                if (bl22) {
                    throw new oY();
                }
            }
        } else {
            dArray3 = dArray;
            dArray4 = dArray2;
        }
        if (l2 < 10000L) {
            return bc_0.b(this.b(dArray3, dArray4), dArray.length, dArray2.length, bl);
        }
        bc_0 bc_02 = this;
        return bc_02.a(bc_02.b(dArray, dArray2), dArray.length, dArray2.length);
    }

    public final double a(double[] dArray, double[] dArray2) {
        return this.a(dArray, dArray2, true);
    }

    public final double b(double[] dArray, double[] dArray2) {
        return (double)this.c(dArray, dArray2) / (double)((long)dArray.length * (long)dArray2.length);
    }

    private long c(double[] dArray, double[] dArray2) {
        bc_0.a(dArray);
        bc_0.a(dArray2);
        double[] dArray3 = dArray;
        dArray = ch_0.a(dArray, dArray3.length);
        dArray3 = dArray2;
        dArray2 = ch_0.a(dArray2, dArray3.length);
        Arrays.sort(dArray);
        Arrays.sort(dArray2);
        int n2 = dArray.length;
        int n3 = dArray2.length;
        int n4 = 0;
        int n5 = 0;
        long l2 = 0L;
        long l3 = 0L;
        do {
            double d2;
            double d3 = d2 = Double.compare(dArray[n4], dArray2[n5]) <= 0 ? dArray[n4] : dArray2[n5];
            while (n4 < n2 && Double.compare(dArray[n4], d2) == 0) {
                ++n4;
                l2 += (long)n3;
            }
            while (n5 < n3 && Double.compare(dArray2[n5], d2) == 0) {
                ++n5;
                l2 -= (long)n2;
            }
            if (l2 > l3) {
                l3 = l2;
                continue;
            }
            if (-l2 <= l3) continue;
            l3 = -l2;
        } while (n4 < n2 && n5 < n3);
        return l3;
    }

    public final double b(oI oI2, double[] dArray) {
        return this.a(oI2, dArray, false);
    }

    public final boolean a(oI object, double[] object2, double d2) {
        bc_0 bc_02;
        if (d2 <= 0.0 || d2 > 0.5) {
            throw new po_0(px_0.OUT_OF_BOUND_SIGNIFICANCE_LEVEL, (Number)d2, 0, 0.5);
        }
        double[] dArray = object2;
        object2 = object;
        object = this;
        return bc_02.a((oI)object2, dArray, false) < d2;
    }

    private double a(double[] dArray, double[] dArray2, int n2, boolean bl) {
        int n3 = dArray.length;
        int n4 = dArray2.length;
        Object object = new double[n3 + n4];
        System.arraycopy(dArray, 0, object, 0, n3);
        System.arraycopy(dArray2, 0, object, n3, n4);
        object = new om_0(this.a, (double[])object);
        long l2 = this.c(dArray, dArray2);
        int n42 = 0;
        for (int i2 = 0; i2 < n2; ++i2) {
            double[] dArray3;
            dArray2 = ((oe_0)object).a(n3);
            long l3 = this.c(dArray2, dArray3 = ((oe_0)object).a(n4));
            if (l3 <= l2) continue;
            ++n42;
        }
        return (double)n42 / (double)n2;
    }

    private double a(double[] dArray, double[] dArray2, int n2) {
        boolean bl = true;
        int n3 = n2;
        double[] dArray3 = dArray2;
        dArray2 = dArray;
        bc_0 bc_02 = this;
        int n4 = dArray2.length;
        int n5 = dArray3.length;
        Object object = new double[n4 + n5];
        System.arraycopy(dArray2, 0, object, 0, n4);
        System.arraycopy(dArray3, 0, object, n4, n5);
        object = new om_0(bc_02.a, (double[])object);
        long l2 = bc_02.c(dArray2, dArray3);
        int n6 = 0;
        for (int i2 = 0; i2 < n3; ++i2) {
            double[] dArray4;
            dArray3 = ((oe_0)object).a(n4);
            long l3 = bc_02.c(dArray3, dArray4 = ((oe_0)object).a(n5));
            if (l3 <= l2) continue;
            ++n6;
        }
        return (double)n6 / (double)n3;
    }

    private double a(double d2, int n2) {
        return this.a(d2, n2, false);
    }

    private double b(double d2, int n2) {
        return this.a(d2, n2, true);
    }

    private double a(double d2, int n2, boolean bl) {
        double d3 = 1.0 / (double)n2;
        double d4 = d3 * 0.5;
        if (d2 <= d4) {
            return 0.0;
        }
        if (d4 < d2 && d2 <= d3) {
            double d5 = 1.0;
            double d6 = d2 * 2.0 - d3;
            for (int i2 = 1; i2 <= n2; ++i2) {
                d5 *= (double)i2 * d6;
            }
            return d5;
        }
        if (1.0 - d3 <= d2 && d2 < 1.0) {
            return 1.0 - 2.0 * Math.pow(1.0 - d2, n2);
        }
        if (1.0 <= d2) {
            return 1.0;
        }
        if (bl) {
            return this.c(d2, n2);
        }
        if (n2 <= 140) {
            return this.d(d2, n2);
        }
        return bc_0.e(d2, n2);
    }

    private double c(double d2, int n2) {
        int n3 = (int)Math.ceil((double)n2 * d2);
        Object object = bc_0.f((double)d2, (int)n2);
        object = object.a(n2);
        object = (qd_0)object.b(n3 - 1, n3 - 1);
        for (int i2 = 1; i2 <= n2; ++i2) {
            object = ((qd_0)object).c(i2).b(n2);
        }
        return ((qd_0)object).a(20, 4).doubleValue();
    }

    private double d(double d2, int n2) {
        int n3 = (int)Math.ceil((double)n2 * d2);
        tq_0 tq_02 = bc_0.g(d2, n2);
        tq_02 = tq_02.a(n2);
        double d3 = tq_02.b(n3 - 1, n3 - 1);
        for (int i2 = 1; i2 <= n2; ++i2) {
            d3 *= (double)i2 / (double)n2;
        }
        return d3;
    }

    private static double e(double d2, int n2) {
        double d3;
        double d4;
        double d5;
        double d6;
        double d7;
        int n3;
        double d8 = BY.a((double)n2);
        double d9 = d2 * d8;
        double d10 = d2;
        double d11 = d10 * d10 * (double)n2;
        double d12 = d11 * d11;
        double d13 = d12 * d11;
        double d14 = d12;
        double d15 = d14 * d14;
        double d16 = 0.0;
        double d17 = Math.PI * Math.PI / (d11 * 8.0);
        for (n3 = 1; n3 < 100000 && !((d7 = BY.i(-d17 * (d6 = (double)(2 * n3 - 1)) * d6)) <= (d16 += d7) * 1.0E-10); ++n3) {
        }
        if (n3 == 100000) {
            throw new pq_0(100000);
        }
        double d18 = d16 * BY.a(Math.PI * 2) / d9;
        double d19 = d11 * 2.0;
        d16 = 0.0;
        for (n3 = 0; n3 < 100000 && !(BY.w(d7 = ((d5 = (d6 = (double)n3 + 0.5) * d6) * (Math.PI * Math.PI) - d11) * BY.i(d5 * -9.869604401089358 / d19)) < 1.0E-10 * BY.w(d16 += d7)); ++n3) {
        }
        if (n3 == 100000) {
            throw new pq_0(100000);
        }
        double d20 = BY.a(1.5707963267948966);
        d18 += d16 * d20 / (d12 * 3.0 * d8);
        double d21 = d12 * 2.0;
        double d22 = d13 * 6.0;
        d17 = d11 * 5.0;
        d16 = 0.0;
        for (n3 = 0; n3 < 100000 && !(BY.w(d7 = (d22 + d21 + Math.PI * Math.PI * (d21 - d17) * (d5 = (d6 = (double)n3 + 0.5) * d6) + 97.40909103400243 * (1.0 - d19) * d5 * d5) * BY.i(d5 * -9.869604401089358 / d19)) < 1.0E-10 * BY.w(d16 += d7)); ++n3) {
        }
        if (n3 == 100000) {
            throw new pq_0(100000);
        }
        double d23 = 0.0;
        n3 = 1;
        while (n3 < 100000) {
            int n4 = n3++;
            d5 = n4 * n4;
            d7 = d5 * (Math.PI * Math.PI) * BY.i(d5 * -9.869604401089358 / d19);
            if (!(BY.w(d7) < 1.0E-10 * BY.w(d23 += d7))) continue;
        }
        if (n3 == 100000) {
            throw new pq_0(100000);
        }
        d18 += d20 / (double)n2 * (d16 / (d11 * 36.0 * d11 * d11 * d9) - d23 / (d11 * 18.0 * d9));
        d16 = 0.0;
        for (n3 = 0; n3 < 100000 && !(BY.w(d7 = ((d4 = (d3 = (d5 = (d6 = (double)n3 + 0.5) * d6) * d5) * d5) * 961.3891935753043 * (5.0 - d11 * 30.0) + d3 * 97.40909103400243 * (d11 * -60.0 + d12 * 212.0) + d5 * (Math.PI * Math.PI) * (d12 * 135.0 - d13 * 96.0) - d13 * 30.0 - d15 * 90.0) * BY.i(d5 * -9.869604401089358 / d19)) < 1.0E-10 * BY.w(d16 += d7)); ++n3) {
        }
        if (n3 == 100000) {
            throw new pq_0(100000);
        }
        d23 = 0.0;
        n3 = 1;
        while (n3 < 100000) {
            int n5 = n3++;
            d5 = n5 * n5;
            d3 = d5 * d5;
            d7 = (d3 * -97.40909103400243 + d5 * 29.608813203268074 * d11) * BY.i(d5 * -9.869604401089358 / d19);
            if (!(BY.w(d7) < 1.0E-10 * BY.w(d23 += d7))) continue;
        }
        if (n3 == 100000) {
            throw new pq_0(100000);
        }
        return d18 + d20 / (d8 * (double)n2) * (d16 / (d13 * 3240.0 * d12) + d23 / (d13 * 108.0));
    }

    private static sQ<qd_0> f(double d2, int n2) {
        qd_0 qd_02;
        double d3;
        int n3 = (int)Math.ceil((double)n2 * d2);
        int n4 = 2 * n3 - 1;
        double d4 = (double)n3 - (double)n2 * d2;
        if (d3 >= 1.0) {
            throw new pm_0(d4, (Number)1.0, false);
        }
        try {
            qd_02 = new qd_0(d4, 1.0E-20, 10000);
        }
        catch (qh_0 qh_02) {
            try {
                qd_02 = new qd_0(d4, 1.0E-10, 10000);
            }
            catch (qh_0 qh_03) {
                qd_02 = new qd_0(d4, 1.0E-5, 10000);
            }
        }
        int n5 = n4;
        kN[][] kNArray = new qd_0[n5][n5];
        for (n2 = 0; n2 < n4; ++n2) {
            for (n3 = 0; n3 < n4; ++n3) {
                kNArray[n2][n3] = n2 - n3 + 1 < 0 ? qd_0.c : qd_0.b;
            }
        }
        qd_0[] qd_0Array = new qd_0[n4];
        qd_0[] qd_0Array2 = qd_0Array;
        qd_0Array[0] = qd_02;
        for (n3 = 1; n3 < n4; ++n3) {
            qd_0Array2[n3] = qd_02.d(qd_0Array2[n3 - 1]);
        }
        for (n3 = 0; n3 < n4; ++n3) {
            kNArray[n3][0] = kNArray[n3][0].e(qd_0Array2[n3]);
            kNArray[n4 - 1][n3] = ((qd_0)kNArray[n4 - 1][n3]).e(qd_0Array2[n4 - n3 - 1]);
        }
        if (qd_02.b(qd_0.e) == 1) {
            kNArray[n4 - 1][0] = ((qd_0)kNArray[n4 - 1][0]).a(qd_02.c(2).e(1).d(n4));
        }
        for (n3 = 0; n3 < n4; ++n3) {
            for (int i2 = 0; i2 < n3 + 1; ++i2) {
                if (n3 - i2 + 1 <= 0) continue;
                for (int i3 = 2; i3 <= n3 - i2 + 1; ++i3) {
                    kNArray[n3][i2] = ((qd_0)kNArray[n3][i2]).b(i3);
                }
            }
        }
        return new sx_0((kM)qe_0.d(), kNArray);
    }

    private static tq_0 g(double d2, int n2) {
        double d3;
        int n3 = (int)Math.ceil((double)n2 * d2);
        int n4 = 2 * n3 - 1;
        double d4 = (double)n3 - (double)n2 * d2;
        if (d3 >= 1.0) {
            throw new pm_0(d4, (Number)1.0, false);
        }
        int n5 = n4;
        double[][] dArray = new double[n5][n5];
        for (int i2 = 0; i2 < n4; ++i2) {
            for (n2 = 0; n2 < n4; ++n2) {
                dArray[i2][n2] = i2 - n2 + 1 < 0 ? 0.0 : 1.0;
            }
        }
        double[] dArray2 = new double[n4];
        double[] dArray3 = dArray2;
        dArray2[0] = d4;
        for (n2 = 1; n2 < n4; ++n2) {
            dArray3[n2] = d4 * dArray3[n2 - 1];
        }
        for (n2 = 0; n2 < n4; ++n2) {
            dArray[n2][0] = dArray[n2][0] - dArray3[n2];
            double[] dArray4 = dArray[n4 - 1];
            int n6 = n2;
            dArray4[n6] = dArray4[n6] - dArray3[n4 - n2 - 1];
        }
        if (Double.compare(d4, 0.5) > 0) {
            double[] dArray5 = dArray[n4 - 1];
            dArray5[0] = dArray5[0] + BY.a(d4 * 2.0 - 1.0, n4);
        }
        for (n2 = 0; n2 < n4; ++n2) {
            for (int i3 = 0; i3 < n2 + 1; ++i3) {
                if (n2 - i3 + 1 <= 0) continue;
                for (n3 = 2; n3 <= n2 - i3 + 1; ++n3) {
                    double[] dArray6 = dArray[n2];
                    int n7 = i3;
                    dArray6[n7] = dArray6[n7] / (double)n3;
                }
            }
        }
        return td_0.a(dArray);
    }

    private static void a(double[] dArray) {
        if (dArray == null) {
            throw new pl_0(px_0.NULL_NOT_ALLOWED, new Object[0]);
        }
        if (dArray.length < 2) {
            throw new oT(px_0.INSUFFICIENT_OBSERVED_POINTS_IN_SAMPLE, dArray.length, 2);
        }
    }

    private static double a(double d2, double d3, int n2) {
        long l2;
        if (d2 == 0.0) {
            return 0.0;
        }
        double d4 = d2 * -2.0 * d2;
        int n3 = -1;
        double d5 = 0.5;
        double d6 = 1.0;
        for (l2 = 1L; d6 > 1.0E-20 && l2 < 100000L; ++l2) {
            d6 = BY.i(d4 * (double)l2 * (double)l2);
            d5 += (double)n3 * d6;
            n3 = -n3;
        }
        if (l2 == 100000L) {
            throw new pq_0(100000);
        }
        return d5 * 2.0;
    }

    static long a(double d2, int n2, int n3, boolean bl) {
        long l2 = (long)n2 * (long)n3;
        long l3 = (long)BY.z((d2 - 1.0E-12) * (double)l2);
        long l4 = (long)BY.y((d2 + 1.0E-12) * (double)l2);
        if (bl && l4 == l3) {
            return l3 + 1L;
        }
        return l3;
    }

    public static double b(double d2, int n2, int n3, boolean bl) {
        return 1.0 - bc_0.b(n3, n2, n3, n2, bc_0.a(d2, n3, n2, bl), bl) / BR.b(n2 + n3, n3);
    }

    public final double a(double d2, int n2, int n3) {
        double d3 = n3;
        double d4 = n2;
        return 1.0 - bc_0.a(d2 * BY.a(d3 * d4 / (d3 + d4)), 1.0E-20, 100000);
    }

    private static void a(boolean[] blArray, int n2, zF zF2) {
        Arrays.fill(blArray, true);
        while (n2 < blArray.length) {
            blArray[blArray[var3_3 = zF2.nextInt((int)(n2 + 1))] ? var3_3 : n2] = false;
            ++n2;
        }
    }

    public final double a(double d2, int n2, int n3, boolean n4, int n5) {
        long l2 = bc_0.a(d2, n2, n3, n4 != 0);
        int n6 = n2;
        int n7 = n3;
        n3 = n5;
        n2 = n7;
        int n8 = n6;
        long l3 = l2;
        bc_0 bc_02 = this;
        n4 = BY.b(n8, n2);
        n8 = BY.a(n8, n2);
        n2 = n4 + n8;
        n5 = 0;
        boolean[] blArray = new boolean[n2];
        block0: for (int i2 = 0; i2 < n3; ++i2) {
            zF zF2 = bc_02.a;
            int n9 = n4;
            boolean[] blArray2 = blArray;
            Arrays.fill(blArray, true);
            while (n9 < blArray2.length) {
                blArray2[blArray2[var13_15 = zF2.nextInt((int)(n9 + 1))] ? var13_15 : n9] = false;
                ++n9;
            }
            long l4 = 0L;
            for (int i3 = 0; i3 < blArray.length; ++i3) {
                if (blArray[i3]) {
                    if ((l4 += (long)n8) < l3) continue;
                    ++n5;
                    continue block0;
                }
                if ((l4 -= (long)n4) > -l3) continue;
                ++n5;
                continue block0;
            }
        }
        return (double)n5 / (double)n3;
    }

    private double a(long l2, int n2, int n3, int n4) {
        int n5 = BY.b(n2, n3);
        n2 = BY.a(n2, n3);
        n3 = n5 + n2;
        int n6 = 0;
        boolean[] blArray = new boolean[n3];
        block0: for (int i2 = 0; i2 < n4; ++i2) {
            bc_0.a(blArray, n5, this.a);
            long l3 = 0L;
            for (int i3 = 0; i3 < blArray.length; ++i3) {
                if (blArray[i3]) {
                    if ((l3 += (long)n2) < l2) continue;
                    ++n6;
                    continue block0;
                }
                if ((l3 -= (long)n5) > -l2) continue;
                ++n6;
                continue block0;
            }
        }
        return (double)n6 / (double)n4;
    }

    private static void d(double[] dArray, double[] dArray2) {
        boolean bl;
        double[] dArray3 = ch_0.f(ch_0.a(new double[][]{dArray, dArray2}));
        if (dArray3.length == dArray.length + dArray2.length) {
            return;
        }
        double d2 = 1.0;
        double d3 = dArray3[0];
        for (int i2 = 1; i2 < dArray3.length; ++i2) {
            double d4;
            double d5 = d3 - dArray3[i2];
            if (d4 < d2) {
                d2 = d5;
            }
            d3 = dArray3[i2];
        }
        oN oN2 = new oN(new zy_0(100), -(d2 /= 2.0), d2);
        int n2 = 0;
        do {
            bc_0.a(dArray, oN2);
            bc_0.a(dArray2, oN2);
        } while ((bl = bc_0.e(dArray, dArray2)) && ++n2 < 1000);
        if (bl) {
            throw new oY();
        }
    }

    private static boolean e(double[] dArray, double[] dArray2) {
        int n2;
        HashSet<Double> hashSet = new HashSet<Double>();
        for (n2 = 0; n2 < dArray.length; ++n2) {
            if (hashSet.add(dArray[n2])) continue;
            return true;
        }
        for (n2 = 0; n2 < dArray2.length; ++n2) {
            if (hashSet.add(dArray2[n2])) continue;
            return true;
        }
        return false;
    }

    private static void a(double[] dArray, oN oN2) {
        int n2 = 0;
        while (n2 < dArray.length) {
            int n3 = n2++;
            dArray[n3] = dArray[n3] + oN2.b();
        }
    }

    private static int a(int n2, int n3, int n4, int n5, long l2, boolean bl) {
        if (bl) {
            if (BY.a((long)n2 * (long)n5 - (long)n3 * (long)n4) <= l2) {
                return 1;
            }
            return 0;
        }
        if (BY.a((long)n2 * (long)n5 - (long)n3 * (long)n4) < l2) {
            return 1;
        }
        return 0;
    }

    private static double b(int n2, int n3, int n4, int n5, long l2, boolean bl) {
        int n6;
        double[] dArray = new double[n5];
        double d2 = 0.0;
        for (n6 = 0; n6 < n5; ++n6) {
            dArray[n6] = bc_0.a(0, n6 + 1, n4, n5, l2, bl);
        }
        for (n6 = 1; n6 <= n2; ++n6) {
            d2 = bc_0.a(n6, 0, n4, n5, l2, bl);
            for (int i2 = 1; i2 <= n3; ++i2) {
                dArray[i2 - 1] = (double)bc_0.a(n6, i2, n4, n5, l2, bl) * (d2 + dArray[i2 - 1]);
                d2 = dArray[i2 - 1];
            }
        }
        return d2;
    }
}

