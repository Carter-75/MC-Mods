/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.TreeSet;
import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.ci_0;
import org.valkyrienskies.core.impl.shadow.cq_0;
import org.valkyrienskies.core.impl.shadow.kM;
import org.valkyrienskies.core.impl.shadow.oM;
import org.valkyrienskies.core.impl.shadow.oS;
import org.valkyrienskies.core.impl.shadow.oU;
import org.valkyrienskies.core.impl.shadow.oV;
import org.valkyrienskies.core.impl.shadow.oY;
import org.valkyrienskies.core.impl.shadow.oc_0;
import org.valkyrienskies.core.impl.shadow.pf_0;
import org.valkyrienskies.core.impl.shadow.pg_0;
import org.valkyrienskies.core.impl.shadow.ph_0;
import org.valkyrienskies.core.impl.shadow.pj_0;
import org.valkyrienskies.core.impl.shadow.pk_0;
import org.valkyrienskies.core.impl.shadow.pl_0;
import org.valkyrienskies.core.impl.shadow.pm_0;
import org.valkyrienskies.core.impl.shadow.px_0;
import org.valkyrienskies.core.impl.shadow.zF;
import org.valkyrienskies.core.impl.shadow.zR;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.Ch
 */
public final class ch_0 {
    private ch_0() {
    }

    private static double[] b(double d2, double[] dArray) {
        double[] dArray2 = new double[dArray.length];
        for (int i2 = 0; i2 < dArray.length; ++i2) {
            dArray2[i2] = dArray[i2] * d2;
        }
        return dArray2;
    }

    public static void a(double d2, double[] dArray) {
        int n2 = 0;
        while (n2 < dArray.length) {
            int n3 = n2++;
            dArray[n3] = dArray[n3] * d2;
        }
    }

    private static double[] k(double[] dArray, double[] dArray2) {
        double[] dArray3 = dArray2;
        double[] dArray4 = dArray;
        ch_0.a(dArray, dArray3, true);
        dArray4 = (double[])dArray.clone();
        for (int i2 = 0; i2 < dArray.length; ++i2) {
            int n2 = i2;
            dArray4[n2] = dArray4[n2] + dArray2[i2];
        }
        return dArray4;
    }

    public static double[] a(double[] dArray, double[] dArray2) {
        double[] dArray3 = dArray2;
        double[] dArray4 = dArray;
        ch_0.a(dArray, dArray3, true);
        dArray4 = (double[])dArray.clone();
        for (int i2 = 0; i2 < dArray.length; ++i2) {
            int n2 = i2;
            dArray4[n2] = dArray4[n2] - dArray2[i2];
        }
        return dArray4;
    }

    private static double[] l(double[] dArray, double[] dArray2) {
        double[] dArray3 = dArray2;
        double[] dArray4 = dArray;
        ch_0.a(dArray, dArray3, true);
        dArray4 = (double[])dArray.clone();
        for (int i2 = 0; i2 < dArray.length; ++i2) {
            int n2 = i2;
            dArray4[n2] = dArray4[n2] * dArray2[i2];
        }
        return dArray4;
    }

    public static double[] b(double[] dArray, double[] dArray2) {
        double[] dArray3 = dArray2;
        double[] dArray4 = dArray;
        ch_0.a(dArray, dArray3, true);
        dArray4 = (double[])dArray.clone();
        for (int i2 = 0; i2 < dArray.length; ++i2) {
            int n2 = i2;
            dArray4[n2] = dArray4[n2] / dArray2[i2];
        }
        return dArray4;
    }

    public static double c(double[] dArray, double[] dArray2) {
        double[] dArray3 = dArray2;
        double[] dArray4 = dArray;
        ch_0.a(dArray, dArray3, true);
        double d2 = 0.0;
        for (int i2 = 0; i2 < dArray.length; ++i2) {
            d2 += BY.w(dArray[i2] - dArray2[i2]);
        }
        return d2;
    }

    private static int c(int[] nArray, int[] nArray2) {
        int[] nArray3 = nArray2;
        int[] nArray4 = nArray;
        ch_0.a(nArray, nArray3, true);
        int n2 = 0;
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            n2 += BY.a(nArray[i2] - nArray2[i2]);
        }
        return n2;
    }

    public static double d(double[] dArray, double[] dArray2) {
        double[] dArray3 = dArray2;
        double[] dArray4 = dArray;
        ch_0.a(dArray, dArray3, true);
        double d2 = 0.0;
        for (int i2 = 0; i2 < dArray.length; ++i2) {
            double d3;
            double d4 = d3 = dArray[i2] - dArray2[i2];
            d2 += d4 * d4;
        }
        return BY.a(d2);
    }

    public static double e(double[] dArray, double[] dArray2) {
        return ch_0.h(dArray, dArray2) / (ch_0.d(dArray) * ch_0.d(dArray2));
    }

    public static double a(int[] nArray, int[] nArray2) {
        int[] nArray3 = nArray2;
        int[] nArray4 = nArray;
        ch_0.a(nArray, nArray3, true);
        double d2 = 0.0;
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            double d3;
            double d4 = d3 = (double)(nArray[i2] - nArray2[i2]);
            d2 += d4 * d4;
        }
        return BY.a(d2);
    }

    public static double f(double[] dArray, double[] dArray2) {
        double[] dArray3 = dArray2;
        double[] dArray4 = dArray;
        ch_0.a(dArray, dArray3, true);
        double d2 = 0.0;
        for (int i2 = 0; i2 < dArray.length; ++i2) {
            d2 = BY.e(d2, BY.w(dArray[i2] - dArray2[i2]));
        }
        return d2;
    }

    private static int d(int[] nArray, int[] nArray2) {
        int[] nArray3 = nArray2;
        int[] nArray4 = nArray;
        ch_0.a(nArray, nArray3, true);
        int n2 = 0;
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            n2 = BY.b(n2, BY.a(nArray[i2] - nArray2[i2]));
        }
        return n2;
    }

    private static <T extends Comparable<? super T>> boolean a(T[] TArray, int n2, boolean bl) {
        T t = TArray[0];
        int n3 = TArray.length;
        for (int i2 = 1; i2 < n3; ++i2) {
            switch (3.a[n2 - 1]) {
                case 1: {
                    int n4 = t.compareTo(TArray[i2]);
                    if (!(bl ? n4 >= 0 : n4 > 0)) break;
                    return false;
                }
                case 2: {
                    int n4 = TArray[i2].compareTo(t);
                    if (!(bl ? n4 >= 0 : n4 > 0)) break;
                    return false;
                }
                default: {
                    throw new oY();
                }
            }
            t = TArray[i2];
        }
        return true;
    }

    private static boolean a(double[] dArray, int n2, boolean bl) {
        return ch_0.a(dArray, n2, bl, false);
    }

    public static boolean a(double[] dArray, double[] dArray2, boolean bl) {
        if (dArray.length == dArray2.length) {
            return true;
        }
        throw new oS(dArray.length, dArray2.length);
    }

    public static void g(double[] dArray, double[] dArray2) {
        ch_0.a(dArray, dArray2, true);
    }

    public static boolean a(int[] nArray, int[] nArray2, boolean bl) {
        if (nArray.length == nArray2.length) {
            return true;
        }
        throw new oS(nArray.length, nArray2.length);
    }

    public static void b(int[] nArray, int[] nArray2) {
        ch_0.a(nArray, nArray2, true);
    }

    public static boolean a(double[] dArray, int n2, boolean bl, boolean bl2) {
        int n3;
        double d2 = dArray[0];
        int n4 = dArray.length;
        block4: for (n3 = 1; n3 < n4; ++n3) {
            switch (3.a[n2 - 1]) {
                case 1: {
                    if (!(bl ? dArray[n3] <= d2 : dArray[n3] < d2)) break;
                    break block4;
                }
                case 2: {
                    if (!(bl ? dArray[n3] >= d2 : dArray[n3] > d2)) break;
                    break block4;
                }
                default: {
                    throw new oY();
                }
            }
            d2 = dArray[n3];
        }
        if (n3 == n4) {
            return true;
        }
        if (bl2) {
            throw new pg_0(dArray[n3], (Number)d2, n3, n2, bl);
        }
        return false;
    }

    private static void b(double[] dArray, int n2, boolean bl) {
        ch_0.a(dArray, n2, true, true);
    }

    public static void a(double[] dArray) {
        ch_0.b(dArray, b.INCREASING$37efe540, true);
    }

    public static void a(long[][] lArray) {
        ci_0.a(lArray);
        for (int i2 = 1; i2 < lArray.length; ++i2) {
            if (lArray[i2].length == lArray[0].length) continue;
            throw new oS(px_0.DIFFERENT_ROWS_LENGTHS, lArray[i2].length, lArray[0].length);
        }
    }

    public static void b(double[] dArray) {
        for (int i2 = 0; i2 < dArray.length; ++i2) {
            if (!(dArray[i2] <= 0.0)) continue;
            throw new pk_0(dArray[i2]);
        }
    }

    public static void c(double[] dArray) {
        for (int i2 = 0; i2 < dArray.length; ++i2) {
            if (!Double.isNaN(dArray[i2])) continue;
            throw new ph_0();
        }
    }

    public static void a(long[] lArray) {
        for (int i2 = 0; i2 < lArray.length; ++i2) {
            if (lArray[i2] >= 0L) continue;
            throw new pj_0(lArray[i2]);
        }
    }

    public static void b(long[][] lArray) {
        for (int i2 = 0; i2 < lArray.length; ++i2) {
            for (int i3 = 0; i3 < lArray[i2].length; ++i3) {
                if (lArray[i2][i3] >= 0L) continue;
                throw new pj_0(lArray[i2][i3]);
            }
        }
    }

    public static double d(double[] dArray) {
        double d2 = 0.0;
        double d3 = 0.0;
        double d4 = 0.0;
        double d5 = 0.0;
        double d6 = 0.0;
        double d7 = dArray.length;
        double d8 = 1.304E19 / d7;
        for (int i2 = 0; i2 < dArray.length; ++i2) {
            double d9 = BY.w(dArray[i2]);
            if (d9 < 3.834E-20 || d9 > d8) {
                double d10;
                if (d9 > 3.834E-20) {
                    if (d9 > d5) {
                        d10 = d5 / d9;
                        d2 = 1.0 + d2 * d10 * d10;
                        d5 = d9;
                        continue;
                    }
                    double d11 = d10 = d9 / d5;
                    d2 += d11 * d11;
                    continue;
                }
                if (d9 > d6) {
                    d10 = d6 / d9;
                    d4 = 1.0 + d4 * d10 * d10;
                    d6 = d9;
                    continue;
                }
                if (d9 == 0.0) continue;
                double d12 = d10 = d9 / d6;
                d4 += d12 * d12;
                continue;
            }
            double d13 = d9;
            d3 += d13 * d13;
        }
        double d14 = d2 != 0.0 ? d5 * Math.sqrt(d2 + d3 / d5 / d5) : (d3 == 0.0 ? d6 * Math.sqrt(d4) : (d3 >= d6 ? Math.sqrt(d3 * (1.0 + d6 / d3 * (d6 * d4))) : Math.sqrt(d6 * (d3 / d6 + d6 * d4))));
        return d14;
    }

    public static void a(double[] dArray, double[] ... dArray2) {
        ch_0.a(dArray, b.INCREASING$37efe540, dArray2);
    }

    private static void a(double[] dArray, int n2, double[] ... dArray2) {
        Object object;
        int n3;
        if (dArray == null) {
            throw new pl_0();
        }
        int n4 = dArray2.length;
        int n5 = dArray.length;
        for (int i2 = 0; i2 < n4; ++i2) {
            double[] dArray3 = dArray2[i2];
            if (dArray3 == null) {
                throw new pl_0();
            }
            if (dArray3.length == n5) continue;
            throw new oS(dArray3.length, n5);
        }
        ArrayList<c> arrayList = new ArrayList<c>(n5);
        for (int i3 = 0; i3 < n5; ++i3) {
            arrayList.add(new c(dArray[i3], i3));
        }
        Comparator<c> comparator = n2 == b.INCREASING$37efe540 ? new Comparator<c>(){

            private static int a(c c2, c c3) {
                c c4 = c2;
                c2 = c4;
                c2 = c3;
                return Double.compare(c4.a, c2.a);
            }
        } : new Comparator<c>(){

            private static int a(c c2, c c3) {
                c c4 = c3;
                c3 = c4;
                c3 = c2;
                return Double.compare(c4.a, c3.a);
            }
        };
        Collections.sort(arrayList, comparator);
        int[] nArray = new int[n5];
        for (n3 = 0; n3 < n5; ++n3) {
            Object object2 = object = (c)arrayList.get(n3);
            dArray[n3] = ((c)object2).a;
            object2 = object;
            nArray[n3] = ((c)object2).b;
        }
        for (n3 = 0; n3 < n4; ++n3) {
            double[] dArray4 = dArray2[n3];
            object = dArray4;
            dArray = (double[])dArray4.clone();
            for (int i4 = 0; i4 < n5; ++i4) {
                object[i4] = dArray[nArray[i4]];
            }
        }
    }

    public static int[] a(int[] nArray) {
        return ch_0.a(nArray, nArray.length);
    }

    public static double[] e(double[] dArray) {
        return ch_0.a(dArray, dArray.length);
    }

    public static int[] a(int[] nArray, int n2) {
        int[] nArray2 = new int[n2];
        System.arraycopy(nArray, 0, nArray2, 0, BY.a(n2, nArray.length));
        return nArray2;
    }

    public static double[] a(double[] dArray, int n2) {
        double[] dArray2 = new double[n2];
        System.arraycopy(dArray, 0, dArray2, 0, BY.a(n2, dArray.length));
        return dArray2;
    }

    public static double[] a(double[] dArray, int n2, int n3) {
        double[] dArray2 = new double[n3 -= n2];
        System.arraycopy(dArray, n2, dArray2, 0, BY.a(n3, dArray.length - n2));
        return dArray2;
    }

    public static double h(double[] dArray, double[] dArray2) {
        double[] dArray3 = dArray2;
        double[] dArray4 = dArray;
        ch_0.a(dArray, dArray3, true);
        int n2 = dArray.length;
        if (n2 == 1) {
            return dArray[0] * dArray2[0];
        }
        dArray3 = new double[n2];
        double d2 = 0.0;
        for (int i2 = 0; i2 < n2; ++i2) {
            double d3 = dArray[i2];
            double d4 = Double.longBitsToDouble(Double.doubleToRawLongBits(d3) & 0xFFFFFFFFF8000000L);
            double d5 = d3 - d4;
            double d6 = dArray2[i2];
            double d7 = Double.longBitsToDouble(Double.doubleToRawLongBits(d6) & 0xFFFFFFFFF8000000L);
            double d8 = d6 - d7;
            dArray3[i2] = d3 * d6;
            double d9 = d5 * d8 - (dArray3[i2] - d4 * d7 - d5 * d7 - d4 * d8);
            d2 += d9;
        }
        double d10 = dArray3[0];
        double d11 = dArray3[1];
        double d12 = d10 + d11;
        double d13 = d12 - d11;
        double d14 = d11 - (d12 - d13) + (d10 - d13);
        int n3 = n2 - 1;
        for (int i3 = 1; i3 < n3; ++i3) {
            d11 = dArray3[i3 + 1];
            double d15 = d12 + d11;
            d13 = d15 - d11;
            d14 += d11 - (d15 - d13) + (d12 - d13);
            d12 = d15;
        }
        double d16 = d12 + (d2 + d14);
        if (Double.isNaN(d16)) {
            d16 = 0.0;
            for (int i4 = 0; i4 < n2; ++i4) {
                d16 += dArray[i4] * dArray2[i4];
            }
        }
        return d16;
    }

    public static double a(double d2, double d3, double d4, double d5) {
        double d6;
        double d7;
        double d8;
        double d9;
        double d10;
        double d11;
        double d12;
        double d13;
        double d14;
        double d15 = d2 * d3;
        double d16 = d4 * d5;
        double d17 = d15 + d16;
        double d18 = Double.longBitsToDouble(Double.doubleToRawLongBits(d2) & 0xFFFFFFFFF8000000L);
        double d19 = d2 - d18;
        double d20 = d19 * (d14 = d3 - (d13 = Double.longBitsToDouble(Double.doubleToRawLongBits(d3) & 0xFFFFFFFFF8000000L))) - (d15 - d18 * d13 - d19 * d13 - d18 * d14);
        double d21 = d17 + (d20 + (d12 = (d11 = d4 - (d10 = Double.longBitsToDouble(Double.doubleToRawLongBits(d4) & 0xFFFFFFFFF8000000L))) * (d9 = d5 - (d8 = Double.longBitsToDouble(Double.doubleToRawLongBits(d5) & 0xFFFFFFFFF8000000L))) - (d16 - d10 * d8 - d11 * d8 - d10 * d9)) + (d7 = d16 - (d17 - (d6 = d17 - d16)) + (d15 - d6)));
        if (Double.isNaN(d21)) {
            d21 = d2 * d3 + d4 * d5;
        }
        return d21;
    }

    public static double a(double d2, double d3, double d4, double d5, double d6, double d7) {
        double d8;
        double d9;
        double d10;
        double d11;
        double d12;
        double d13;
        double d14;
        double d15;
        double d16;
        double d17;
        double d18;
        double d19;
        double d20;
        double d21;
        double d22;
        double d23;
        double d24 = d2 * d3;
        double d25 = d4 * d5;
        double d26 = d24 + d25;
        double d27 = d6 * d7;
        double d28 = d26 + d27;
        double d29 = Double.longBitsToDouble(Double.doubleToRawLongBits(d2) & 0xFFFFFFFFF8000000L);
        double d30 = d2 - d29;
        double d31 = d30 * (d23 = d3 - (d22 = Double.longBitsToDouble(Double.doubleToRawLongBits(d3) & 0xFFFFFFFFF8000000L))) - (d24 - d29 * d22 - d30 * d22 - d29 * d23);
        double d32 = d28 + (d31 + (d21 = (d20 = d4 - (d19 = Double.longBitsToDouble(Double.doubleToRawLongBits(d4) & 0xFFFFFFFFF8000000L))) * (d18 = d5 - (d17 = Double.longBitsToDouble(Double.doubleToRawLongBits(d5) & 0xFFFFFFFFF8000000L))) - (d25 - d19 * d17 - d20 * d17 - d19 * d18)) + (d16 = (d15 = d6 - (d14 = Double.longBitsToDouble(Double.doubleToRawLongBits(d6) & 0xFFFFFFFFF8000000L))) * (d13 = d7 - (d12 = Double.longBitsToDouble(Double.doubleToRawLongBits(d7) & 0xFFFFFFFFF8000000L))) - (d27 - d14 * d12 - d15 * d12 - d14 * d13)) + (d11 = d25 - (d26 - (d10 = d26 - d25)) + (d24 - d10)) + (d9 = d27 - (d28 - (d8 = d28 - d27)) + (d26 - d8)));
        if (Double.isNaN(d32)) {
            d32 = d2 * d3 + d4 * d5 + d6 * d7;
        }
        return d32;
    }

    public static double a(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
        double d10;
        double d11;
        double d12;
        double d13;
        double d14;
        double d15;
        double d16;
        double d17;
        double d18;
        double d19;
        double d20;
        double d21;
        double d22;
        double d23;
        double d24;
        double d25;
        double d26;
        double d27;
        double d28;
        double d29;
        double d30;
        double d31;
        double d32;
        double d33 = d2 * d3;
        double d34 = d4 * d5;
        double d35 = d33 + d34;
        double d36 = d6 * d7;
        double d37 = d35 + d36;
        double d38 = d8 * d9;
        double d39 = d37 + d38;
        double d40 = Double.longBitsToDouble(Double.doubleToRawLongBits(d2) & 0xFFFFFFFFF8000000L);
        double d41 = d2 - d40;
        double d42 = d41 * (d32 = d3 - (d31 = Double.longBitsToDouble(Double.doubleToRawLongBits(d3) & 0xFFFFFFFFF8000000L))) - (d33 - d40 * d31 - d41 * d31 - d40 * d32);
        double d43 = d39 + (d42 + (d30 = (d29 = d4 - (d28 = Double.longBitsToDouble(Double.doubleToRawLongBits(d4) & 0xFFFFFFFFF8000000L))) * (d27 = d5 - (d26 = Double.longBitsToDouble(Double.doubleToRawLongBits(d5) & 0xFFFFFFFFF8000000L))) - (d34 - d28 * d26 - d29 * d26 - d28 * d27)) + (d25 = (d24 = d6 - (d23 = Double.longBitsToDouble(Double.doubleToRawLongBits(d6) & 0xFFFFFFFFF8000000L))) * (d22 = d7 - (d21 = Double.longBitsToDouble(Double.doubleToRawLongBits(d7) & 0xFFFFFFFFF8000000L))) - (d36 - d23 * d21 - d24 * d21 - d23 * d22)) + (d20 = (d19 = d8 - (d18 = Double.longBitsToDouble(Double.doubleToRawLongBits(d8) & 0xFFFFFFFFF8000000L))) * (d17 = d9 - (d16 = Double.longBitsToDouble(Double.doubleToRawLongBits(d9) & 0xFFFFFFFFF8000000L))) - (d38 - d18 * d16 - d19 * d16 - d18 * d17)) + (d15 = d34 - (d35 - (d14 = d35 - d34)) + (d33 - d14)) + (d13 = d36 - (d37 - (d12 = d37 - d36)) + (d35 - d12)) + (d11 = d38 - (d39 - (d10 = d39 - d38)) + (d37 - d10)));
        if (Double.isNaN(d43)) {
            d43 = d2 * d3 + d4 * d5 + d6 * d7 + d8 * d9;
        }
        return d43;
    }

    private static boolean a(float[] fArray, float[] fArray2) {
        if (fArray == null || fArray2 == null) {
            return !(fArray == null ^ fArray2 == null);
        }
        if (fArray.length != fArray2.length) {
            return false;
        }
        for (int i2 = 0; i2 < fArray.length; ++i2) {
            if (cq_0.a(fArray[i2], fArray2[i2])) continue;
            return false;
        }
        return true;
    }

    private static boolean b(float[] fArray, float[] fArray2) {
        if (fArray == null || fArray2 == null) {
            return !(fArray == null ^ fArray2 == null);
        }
        if (fArray.length != fArray2.length) {
            return false;
        }
        for (int i2 = 0; i2 < fArray.length; ++i2) {
            if (cq_0.b(fArray[i2], fArray2[i2])) continue;
            return false;
        }
        return true;
    }

    public static boolean i(double[] dArray, double[] dArray2) {
        if (dArray == null || dArray2 == null) {
            return !(dArray == null ^ dArray2 == null);
        }
        if (dArray.length != dArray2.length) {
            return false;
        }
        for (int i2 = 0; i2 < dArray.length; ++i2) {
            if (cq_0.a(dArray[i2], dArray2[i2])) continue;
            return false;
        }
        return true;
    }

    public static boolean j(double[] dArray, double[] dArray2) {
        if (dArray == null || dArray2 == null) {
            return !(dArray == null ^ dArray2 == null);
        }
        if (dArray.length != dArray2.length) {
            return false;
        }
        for (int i2 = 0; i2 < dArray.length; ++i2) {
            if (cq_0.b(dArray[i2], dArray2[i2])) continue;
            return false;
        }
        return true;
    }

    public static double[] a(double[] dArray, double d2) {
        int n2;
        if (Double.isInfinite(1.0)) {
            throw new oV(px_0.NORMALIZE_INFINITE, new Object[0]);
        }
        if (Double.isNaN(1.0)) {
            throw new oV(px_0.NORMALIZE_NAN, new Object[0]);
        }
        double d3 = 0.0;
        int n3 = dArray.length;
        double[] dArray2 = new double[n3];
        for (n2 = 0; n2 < n3; ++n2) {
            if (Double.isInfinite(dArray[n2])) {
                throw new oV(px_0.INFINITE_ARRAY_ELEMENT, dArray[n2], n2);
            }
            if (Double.isNaN(dArray[n2])) continue;
            d3 += dArray[n2];
        }
        if (d3 == 0.0) {
            throw new oU(px_0.ARRAY_SUMS_TO_ZERO, new Object[0]);
        }
        for (n2 = 0; n2 < n3; ++n2) {
            dArray2[n2] = Double.isNaN(dArray[n2]) ? Double.NaN : dArray[n2] / d3;
        }
        return dArray2;
    }

    public static <T> T[] a(kM<T> kM2, int n2) {
        Object[] objectArray = (Object[])Array.newInstance(kM2.c(), n2);
        Arrays.fill(objectArray, kM2.a());
        return objectArray;
    }

    public static <T> T[][] a(kM<T> kM2, int n2, int n3) {
        Object[][] objectArray;
        if (n3 < 0) {
            T[] TArray = ch_0.a(kM2, 0);
            objectArray = (Object[][])Array.newInstance(TArray.getClass(), n2);
        } else {
            objectArray = (Object[][])Array.newInstance(kM2.c(), n2, n3);
            for (int i2 = 0; i2 < n2; ++i2) {
                Arrays.fill(objectArray[i2], kM2.a());
            }
        }
        return objectArray;
    }

    private static double[] m(double[] dArray, double[] dArray2) {
        ci_0.a((Object)dArray);
        ci_0.a((Object)dArray2);
        int n2 = dArray.length;
        int n3 = dArray2.length;
        if (n2 == 0 || n3 == 0) {
            throw new pf_0();
        }
        int n4 = n2 + n3 - 1;
        double[] dArray3 = new double[n4];
        for (int i2 = 0; i2 < n4; ++i2) {
            double d2 = 0.0;
            int n5 = BY.b(0, i2 + 1 - n2);
            int n6 = i2 - n5;
            while (n5 < n3 && n6 >= 0) {
                d2 += dArray[n6--] * dArray2[n5++];
            }
            dArray3[i2] = d2;
        }
        return dArray3;
    }

    private static void a(int[] nArray, int n2, int n3) {
        ch_0.a(nArray, n2, n3, new zR());
    }

    private static void a(int[] nArray, int n2, int n3, zF zF2) {
        switch (3.b[n3 - 1]) {
            case 1: {
                for (n3 = nArray.length - 1; n3 >= n2; --n3) {
                    int n4 = n3 == n2 ? n2 : ((oc_0)new oM(zF2, n2, n3)).a();
                    int n5 = nArray[n4];
                    nArray[n4] = nArray[n3];
                    nArray[n3] = n5;
                }
                return;
            }
            case 2: {
                for (n3 = 0; n3 <= n2; ++n3) {
                    int n6 = n3 == n2 ? n2 : ((oc_0)new oM(zF2, n3, n2)).a();
                    int n7 = nArray[n6];
                    nArray[n6] = nArray[n3];
                    nArray[n3] = n7;
                }
                return;
            }
        }
        throw new oY();
    }

    public static void a(int[] nArray, zF zF2) {
        ch_0.a(nArray, 0, d.TAIL$748fd098, zF2);
    }

    private static void b(int[] nArray) {
        ch_0.a(nArray, new zR());
    }

    public static int[] a(int n2) {
        return ch_0.a(n2, 0, 1);
    }

    public static int[] a(int n2, int n3, int n4) {
        int[] nArray = new int[n2];
        for (n4 = 0; n4 < n2; ++n4) {
            nArray[n4] = 0 + n4;
        }
        return nArray;
    }

    public static boolean b(double[] dArray, int n2, int n3) {
        return ch_0.a(dArray, n2, n3, false);
    }

    public static boolean a(double[] dArray, int n2, int n3, boolean bl) {
        if (dArray == null) {
            throw new pl_0(px_0.INPUT_ARRAY, new Object[0]);
        }
        if (n2 < 0) {
            throw new pj_0(px_0.START_POSITION, n2);
        }
        if (n3 < 0) {
            throw new pj_0(px_0.LENGTH, n3);
        }
        if (n2 + n3 > dArray.length) {
            throw new pm_0(px_0.SUBARRAY_ENDS_AFTER_ARRAY_END, (Number)(n2 + n3), dArray.length, true);
        }
        return n3 != 0 || bl;
    }

    private static boolean a(double[] dArray, double[] dArray2, int n2, int n3) {
        return ch_0.a(dArray, dArray2, n2, n3, false);
    }

    public static boolean a(double[] dArray, double[] dArray2, int n2, int n3, boolean bl) {
        if (dArray2 == null || dArray == null) {
            throw new pl_0(px_0.INPUT_ARRAY, new Object[0]);
        }
        double[] dArray3 = dArray;
        double[] dArray4 = dArray2;
        ch_0.a(dArray2, dArray3, true);
        boolean bl2 = false;
        for (int i2 = n2; i2 < n2 + n3; ++i2) {
            double d2 = dArray2[i2];
            if (Double.isNaN(d2)) {
                throw new oV(px_0.NAN_ELEMENT_AT_INDEX, i2);
            }
            if (Double.isInfinite(d2)) {
                throw new oV(px_0.INFINITE_ARRAY_ELEMENT, d2, i2);
            }
            if (d2 < 0.0) {
                throw new oV(px_0.NEGATIVE_ELEMENT_AT_INDEX, i2, d2);
            }
            if (bl2 || !(d2 > 0.0)) continue;
            bl2 = true;
        }
        if (!bl2) {
            throw new oV(px_0.WEIGHT_AT_LEAST_ONE_NON_ZERO, new Object[0]);
        }
        return ch_0.a(dArray, n2, n3, bl);
    }

    public static double[] a(double[] ... dArray) {
        int n2 = 0;
        double[][] dArray2 = dArray;
        int cfr_ignored_0 = dArray.length;
        for (int i2 = 0; i2 < 2; ++i2) {
            double[] dArray3 = dArray2[i2];
            n2 += dArray3.length;
        }
        int n3 = 0;
        double[] dArray4 = new double[n2];
        for (int i3 = 0; i3 < dArray.length; ++i3) {
            n2 = dArray[i3].length;
            System.arraycopy(dArray[i3], 0, dArray4, n3, n2);
            n3 += n2;
        }
        return dArray4;
    }

    public static double[] f(double[] dArray) {
        int n2;
        Object object = new TreeSet<Double>();
        for (n2 = 0; n2 < dArray.length; ++n2) {
            ((TreeSet)object).add(dArray[n2]);
        }
        n2 = ((TreeSet)object).size();
        dArray = new double[n2];
        object = ((TreeSet)object).iterator();
        int n3 = 0;
        while (object.hasNext()) {
            dArray[n2 - ++n3] = (Double)object.next();
        }
        return dArray;
    }

    static final class 3 {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;

        static {
            b = new int[d.values$75deba52().length];
            try {
                3.b[d.TAIL$748fd098 - 1] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                3.b[d.HEAD$748fd098 - 1] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            a = new int[org.valkyrienskies.core.impl.shadow.Ch$b.values$121350fa().length];
            try {
                3.a[org.valkyrienskies.core.impl.shadow.Ch$b.INCREASING$37efe540 - 1] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                3.a[org.valkyrienskies.core.impl.shadow.Ch$b.DECREASING$37efe540 - 1] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
        }
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    public static final class d
    extends Enum<d> {
        public static final int HEAD$748fd098 = 1;
        public static final int TAIL$748fd098 = 2;
        private static final /* synthetic */ int[] $VALUES$2890f0d3;

        public static int[] values$75deba52() {
            return (int[])$VALUES$2890f0d3.clone();
        }

        private d() {
        }

        static {
            $VALUES$2890f0d3 = new int[]{HEAD$748fd098, TAIL$748fd098};
        }
    }

    static final class c {
        final double a;
        final int b;

        c(double d2, int n2) {
            this.a = d2;
            this.b = n2;
        }

        public final double a() {
            return this.a;
        }

        public final int b() {
            return this.b;
        }
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    public static final class b
    extends Enum<b> {
        public static final int INCREASING$37efe540 = 1;
        public static final int DECREASING$37efe540 = 2;
        private static final /* synthetic */ int[] $VALUES$50371d45;

        public static int[] values$121350fa() {
            return (int[])$VALUES$50371d45.clone();
        }

        private b() {
        }

        static {
            $VALUES$50371d45 = new int[]{INCREASING$37efe540, DECREASING$37efe540};
        }
    }

    public static interface a {
        public double a(double[] var1);

        public double a(double[] var1, int var2, int var3);
    }
}

