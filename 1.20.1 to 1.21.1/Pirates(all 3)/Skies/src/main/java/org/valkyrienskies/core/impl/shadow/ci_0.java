/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Arrays;
import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.kO;
import org.valkyrienskies.core.impl.shadow.oU;
import org.valkyrienskies.core.impl.shadow.pi_0;
import org.valkyrienskies.core.impl.shadow.pl_0;
import org.valkyrienskies.core.impl.shadow.px_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.Ci
 */
public final class ci_0 {
    private static double a = Math.PI * 2;
    private static double b = Math.PI * Math.PI;

    private ci_0() {
    }

    public static int a(double d2) {
        return Double.valueOf(d2).hashCode();
    }

    public static boolean a(double d2, double d3) {
        return Double.valueOf(d2).equals(d3);
    }

    public static int a(double[] dArray) {
        return Arrays.hashCode(dArray);
    }

    public static double b(double d2, double d3) {
        return d2 - Math.PI * 2 * BY.y((d2 + Math.PI - d3) / (Math.PI * 2));
    }

    public static <T extends kO<T>> T a(T t, T t2) {
        if (t.b(t2).d() >= 0.0) {
            return t;
        }
        return t2;
    }

    public static <T extends kO<T>> T b(T t, T t2) {
        if (t.b(t2).d() >= 0.0) {
            return t2;
        }
        return t;
    }

    public static double a(double d2, double d3, double d4) {
        double d5 = BY.w(d3);
        return d2 - d5 * BY.y((d2 - d4) / d5) - d4;
    }

    private static byte a(byte by, byte by2) {
        if (by >= 0 && by2 >= 0 || by < 0 && by2 < 0) {
            return by;
        }
        if (by2 >= 0 && by == -128) {
            throw new oU(px_0.OVERFLOW, new Object[0]);
        }
        return -by;
    }

    private static short a(short s, short s2) {
        if (s >= 0 && s2 >= 0 || s < 0 && s2 < 0) {
            return s;
        }
        if (s2 >= 0 && s == Short.MIN_VALUE) {
            throw new oU(px_0.OVERFLOW, new Object[0]);
        }
        return -s;
    }

    public static int a(int n2, int n3) {
        if (n3 >= 0) {
            return 1;
        }
        return -1;
    }

    private static long a(long l2, long l3) {
        if (l2 >= 0L && l3 >= 0L || l2 < 0L && l3 < 0L) {
            return l2;
        }
        if (l3 >= 0L && l2 == Long.MIN_VALUE) {
            throw new oU(px_0.OVERFLOW, new Object[0]);
        }
        return -l2;
    }

    public static void b(double d2) {
        if (Double.isInfinite(d2) || Double.isNaN(d2)) {
            throw new pi_0(d2, new Object[0]);
        }
    }

    private static void b(double[] dArray) {
        for (int i2 = 0; i2 < dArray.length; ++i2) {
            double d2 = dArray[i2];
            if (!Double.isInfinite(d2) && !Double.isNaN(d2)) continue;
            throw new pi_0(px_0.ARRAY_ELEMENT, (Number)d2, i2);
        }
    }

    public static void a(Object object, px_0 px_02, Object ... objectArray) {
        if (object == null) {
            throw new pl_0(px_02, objectArray);
        }
    }

    public static void a(Object object) {
        if (object == null) {
            throw new pl_0();
        }
    }
}

