/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Arrays;
import java.util.Collection;
import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.at_0;
import org.valkyrienskies.core.impl.shadow.ba_0;
import org.valkyrienskies.core.impl.shadow.bb_0;
import org.valkyrienskies.core.impl.shadow.bc_0;
import org.valkyrienskies.core.impl.shadow.be_0;
import org.valkyrienskies.core.impl.shadow.bf_0;
import org.valkyrienskies.core.impl.shadow.oI;
import org.valkyrienskies.core.impl.shadow.oi_0;
import org.valkyrienskies.core.impl.shadow.po_0;
import org.valkyrienskies.core.impl.shadow.px_0;
import org.valkyrienskies.core.impl.shadow.zF;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.Bg
 */
public final class bg_0 {
    private static final bf_0 a = new bf_0();
    private static final ba_0 b = new ba_0();
    private static final be_0 c = new be_0();
    private static final bb_0 d = new bb_0();
    private static final bc_0 e = new bc_0();

    private bg_0() {
    }

    private static double a(double[] dArray, double[] dArray2) {
        return a.c(dArray, dArray2);
    }

    private static double a(at_0 at_02, at_0 at_03) {
        return a.b(at_02, at_03);
    }

    private static boolean a(double[] dArray, double[] dArray2, double d2) {
        return a.c(dArray, dArray2, d2);
    }

    private static double b(double[] dArray, double[] dArray2) {
        return a.f(dArray, dArray2);
    }

    private static double b(at_0 at_02, at_0 at_03) {
        return a.d(at_02, at_03);
    }

    private static double c(double[] dArray, double[] dArray2) {
        return a.a(dArray, dArray2);
    }

    private static boolean b(double[] dArray, double[] dArray2, double d2) {
        return a.a(dArray, dArray2, d2);
    }

    private static double d(double[] dArray, double[] dArray2) {
        return a.b(dArray, dArray2);
    }

    private static double a(double d2, double[] dArray) {
        return a.a(d2, dArray);
    }

    private static double a(double d2, at_0 at_02) {
        return a.a(d2, at_02);
    }

    private static double e(double[] dArray, double[] dArray2) {
        return a.d(dArray, dArray2);
    }

    private static double c(at_0 at_02, at_0 at_03) {
        return a.a(at_02, at_03);
    }

    private static boolean a(double d2, double[] dArray, double d3) {
        return a.a(d2, dArray, d3);
    }

    private static double b(double d2, double[] dArray) {
        return a.b(d2, dArray);
    }

    private static boolean a(double d2, at_0 at_02, double d3) {
        return a.a(d2, at_02, d3);
    }

    private static double b(double d2, at_0 at_02) {
        return a.b(d2, at_02);
    }

    private static boolean c(double[] dArray, double[] dArray2, double d2) {
        return a.b(dArray, dArray2, d2);
    }

    private static double f(double[] dArray, double[] dArray2) {
        return a.e(dArray, dArray2);
    }

    private static boolean a(at_0 at_02, at_0 at_03, double d2) {
        return a.a(at_02, at_03, d2);
    }

    private static double d(at_0 at_02, at_0 at_03) {
        return a.c(at_02, at_03);
    }

    private static double a(double[] dArray, long[] lArray) {
        return ba_0.a(dArray, lArray);
    }

    private static double a(long[][] lArray) {
        return b.a(lArray);
    }

    private static boolean a(double[] object, long[] objectArray, double d2) {
        double d3 = d2;
        long[] lArray = objectArray;
        objectArray = (Object[])object;
        object = b;
        if (d3 <= 0.0 || d3 > 0.5) {
            throw new po_0(px_0.OUT_OF_BOUND_SIGNIFICANCE_LEVEL, (Number)d3, 0, 0.5);
        }
        return ((ba_0)object).b((double[])objectArray, lArray) < d3;
    }

    private static double b(double[] dArray, long[] lArray) {
        return b.b(dArray, lArray);
    }

    private static boolean a(long[][] object, double d2) {
        double d3 = d2;
        long[][] lArray = object;
        object = b;
        if (d3 <= 0.0 || d3 > 0.5) {
            throw new po_0(px_0.OUT_OF_BOUND_SIGNIFICANCE_LEVEL, (Number)d3, 0, 0.5);
        }
        return ((ba_0)object).b(lArray) < d3;
    }

    private static double b(long[][] lArray) {
        return b.b(lArray);
    }

    private static double a(long[] lArray, long[] lArray2) {
        return ba_0.a(lArray, lArray2);
    }

    private static double b(long[] lArray, long[] lArray2) {
        return b.b(lArray, lArray2);
    }

    private static boolean a(long[] object, long[] lArray, double d2) {
        double d3 = d2;
        long[] lArray2 = lArray;
        lArray = object;
        object = b;
        if (d3 <= 0.0 || d3 > 0.5) {
            throw new po_0(px_0.OUT_OF_BOUND_SIGNIFICANCE_LEVEL, (Number)d3, 0, 0.5);
        }
        return ((ba_0)object).b(lArray, lArray2) < d3;
    }

    private static double a(Collection<double[]> object) {
        Collection<double[]> collection = object;
        object = c;
        be_0.a a2 = ((be_0)object).c(collection);
        object = a2;
        object = a2;
        return a2.c;
    }

    private static double b(Collection<double[]> collection) {
        return c.b(collection);
    }

    private static boolean a(Collection<double[]> object, double d2) {
        double d3 = d2;
        Collection<double[]> collection = object;
        object = c;
        if (d3 <= 0.0 || d3 > 0.5) {
            throw new po_0(px_0.OUT_OF_BOUND_SIGNIFICANCE_LEVEL, (Number)d3, 0, 0.5);
        }
        return ((be_0)object).b(collection) < d3;
    }

    private static double c(double[] dArray, long[] lArray) {
        return bb_0.a(dArray, lArray);
    }

    private static double d(double[] dArray, long[] lArray) {
        return d.b(dArray, lArray);
    }

    private static double e(double[] object, long[] objectArray) {
        long[] lArray = objectArray;
        objectArray = (Object[])object;
        object = d;
        object = new oi_0(null, (double)objectArray.length - 2.0);
        return 1.0 - ((oi_0)object).e(bb_0.a(objectArray, lArray));
    }

    private static boolean b(double[] object, long[] objectArray, double d2) {
        double d3 = d2;
        long[] lArray = objectArray;
        objectArray = (Object[])object;
        object = d;
        if (d3 <= 0.0 || d3 > 0.5) {
            throw new po_0(px_0.OUT_OF_BOUND_SIGNIFICANCE_LEVEL, (Number)d3, 0, 0.5);
        }
        return ((bb_0)object).b((double[])objectArray, lArray) < d3;
    }

    private static double c(long[] lArray, long[] lArray2) {
        return d.a(lArray, lArray2);
    }

    private static double a(long l2, long l3, long l4, long l5) {
        long l6 = l5;
        long l7 = l4;
        long l8 = l3;
        long l9 = l2;
        bb_0 bb_02 = d;
        double d2 = bb_02.a(new long[]{l9, l8}, new long[]{l7, l6});
        double d3 = BY.a(d2);
        if ((double)l9 / (double)(l9 + l8) < (double)l7 / (double)(l7 + l6)) {
            d3 = -d3;
        }
        return d3;
    }

    private static double d(long[] lArray, long[] lArray2) {
        return d.b(lArray, lArray2);
    }

    private static boolean b(long[] object, long[] lArray, double d2) {
        double d3 = d2;
        long[] lArray2 = lArray;
        lArray = object;
        object = d;
        if (d3 <= 0.0 || d3 > 0.5) {
            throw new po_0(px_0.OUT_OF_BOUND_SIGNIFICANCE_LEVEL, (Number)d3, 0, 0.5);
        }
        return ((bb_0)object).b(lArray, lArray2) < d3;
    }

    private static double a(oI oI2, double[] dArray) {
        return e.a(oI2, dArray);
    }

    private static double b(oI object, double[] object2) {
        double[] dArray = object2;
        object2 = object;
        object = e;
        return ((bc_0)object).a((oI)object2, dArray, false);
    }

    private static double a(oI oI2, double[] dArray, boolean bl) {
        return e.a(oI2, dArray, bl);
    }

    private static boolean a(oI object, double[] object2, double d2) {
        Object object3;
        double d3 = d2;
        double[] dArray = object2;
        object2 = object;
        object = e;
        if (d3 <= 0.0 || d3 > 0.5) {
            throw new po_0(px_0.OUT_OF_BOUND_SIGNIFICANCE_LEVEL, (Number)d3, 0, 0.5);
        }
        return ((bc_0)object3).a((oI)object2, dArray, false) < d3;
    }

    private static double g(double[] dArray, double[] dArray2) {
        return e.b(dArray, dArray2);
    }

    private static double h(double[] object, double[] dArray) {
        bc_0 bc_02 = e;
        double[] dArray2 = dArray;
        dArray = object;
        object = bc_02;
        return bc_02.a(dArray, dArray2, true);
    }

    private static double a(double[] dArray, double[] dArray2, boolean bl) {
        return e.a(dArray, dArray2, bl);
    }

    private static double a(double d2, int n2, int n3, boolean bl) {
        return bc_0.b(d2, n3, n2, bl);
    }

    private static double a(double d2, int n2, int n3) {
        return e.a(d2, n2, n3);
    }

    private static double a(double d2, int n2, int n3, boolean n4, int n5) {
        int n6 = n2;
        int n7 = n3;
        int n8 = n4;
        n4 = n5;
        n3 = n8;
        n2 = n7;
        int n9 = n6;
        double d3 = d2;
        bc_0 bc_02 = e;
        long l2 = bc_0.a(d3, n9, n2, n3 != 0);
        n3 = n4;
        long l3 = l2;
        n4 = BY.b(n9, n2);
        n9 = BY.a(n9, n2);
        n2 = n4 + n9;
        n5 = 0;
        boolean[] blArray = new boolean[n2];
        block0: for (int i2 = 0; i2 < n3; ++i2) {
            zF zF2 = bc_02.a;
            int n10 = n4;
            boolean[] blArray2 = blArray;
            Arrays.fill(blArray, true);
            while (n10 < blArray2.length) {
                blArray2[blArray2[var10_15 = zF2.nextInt((int)(n10 + 1))] ? var10_15 : n10] = false;
                ++n10;
            }
            long l4 = 0L;
            for (int i3 = 0; i3 < blArray.length; ++i3) {
                if (blArray[i3]) {
                    if ((l4 += (long)n9) < l3) continue;
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
}

