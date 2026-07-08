/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
import org.valkyrienskies.core.impl.shadow.BM;
import org.valkyrienskies.core.impl.shadow.BQ;
import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.oU;
import org.valkyrienskies.core.impl.shadow.pj_0;
import org.valkyrienskies.core.impl.shadow.pm_0;
import org.valkyrienskies.core.impl.shadow.px_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public final class BR {
    private static long[] a = new long[]{1L, 1L, 2L, 6L, 24L, 120L, 720L, 5040L, 40320L, 362880L, 3628800L, 39916800L, 479001600L, 6227020800L, 87178291200L, 1307674368000L, 20922789888000L, 355687428096000L, 6402373705728000L, 121645100408832000L, 2432902008176640000L};
    private static AtomicReference<long[][]> b = new AtomicReference<Object>(null);

    private BR() {
    }

    public static long a(int n2, int n3) {
        while (true) {
            BR.e(n2, n3);
            if (n2 == n3 || n3 == 0) {
                return 1L;
            }
            if (n3 == 1 || n3 == n2 - 1) {
                return n2;
            }
            if (n3 <= n2 / 2) break;
            n3 = n2 - n3;
        }
        long l2 = 1L;
        if (n2 <= 61) {
            n2 = n2 - n3 + 1;
            for (int i2 = 1; i2 <= n3; ++i2) {
                l2 = l2 * (long)n2 / (long)i2;
                ++n2;
            }
        } else if (n2 <= 66) {
            n2 = n2 - n3 + 1;
            for (int i3 = 1; i3 <= n3; ++i3) {
                long l3 = BM.b(n2, i3);
                l2 = l2 / ((long)i3 / l3) * ((long)n2 / l3);
                ++n2;
            }
        } else {
            n2 = n2 - n3 + 1;
            for (int i4 = 1; i4 <= n3; ++i4) {
                long l4 = BM.b(n2, i4);
                l2 = BM.a(l2 / ((long)i4 / l4), (long)n2 / l4);
                ++n2;
            }
        }
        return l2;
    }

    public static double b(int n2, int n3) {
        while (true) {
            BR.e(n2, n3);
            if (n2 == n3 || n3 == 0) {
                return 1.0;
            }
            if (n3 == 1 || n3 == n2 - 1) {
                return n2;
            }
            if (n3 <= n2 / 2) break;
            n3 = n2 - n3;
        }
        if (n2 < 67) {
            return BR.a(n2, n3);
        }
        double d2 = 1.0;
        for (int i2 = 1; i2 <= n3; ++i2) {
            d2 *= (double)(n2 - n3 + i2) / (double)i2;
        }
        return BY.y(d2 + 0.5);
    }

    public static double c(int n2, int n3) {
        int n4;
        while (true) {
            BR.e(n2, n3);
            if (n2 == n3 || n3 == 0) {
                return 0.0;
            }
            if (n3 == 1 || n3 == n2 - 1) {
                return BY.k(n2);
            }
            if (n2 < 67) {
                return BY.k(BR.a(n2, n3));
            }
            if (n2 < 1030) {
                return BY.k(BR.b(n2, n3));
            }
            if (n3 <= n2 / 2) break;
            n3 = n2 - n3;
        }
        double d2 = 0.0;
        for (n4 = n2 - n3 + 1; n4 <= n2; ++n4) {
            d2 += BY.k(n4);
        }
        for (n4 = 2; n4 <= n3; ++n4) {
            d2 -= BY.k(n4);
        }
        return d2;
    }

    public static long a(int n2) {
        if (n2 < 0) {
            throw new pj_0(px_0.FACTORIAL_NEGATIVE_PARAMETER, n2);
        }
        if (n2 > 20) {
            throw new oU();
        }
        return a[n2];
    }

    public static double b(int n2) {
        if (n2 < 0) {
            throw new pj_0(px_0.FACTORIAL_NEGATIVE_PARAMETER, n2);
        }
        if (n2 < 21) {
            return a[n2];
        }
        return BY.y(BY.i(BR.c(n2)) + 0.5);
    }

    public static double c(int n2) {
        if (n2 < 0) {
            throw new pj_0(px_0.FACTORIAL_NEGATIVE_PARAMETER, n2);
        }
        if (n2 < 21) {
            return BY.k(a[n2]);
        }
        double d2 = 0.0;
        for (int i2 = 2; i2 <= n2; ++i2) {
            d2 += BY.k(i2);
        }
        return d2;
    }

    public static long d(int n2, int n3) {
        if (n3 < 0) {
            throw new pj_0(n3);
        }
        if (n3 > n2) {
            throw new pm_0(n3, (Number)n2, true);
        }
        Object object = b.get();
        if (object == null) {
            long[][] lArrayArray = new long[26][];
            object = lArrayArray;
            lArrayArray[0] = new long[]{1L};
            for (int i2 = 1; i2 < ((long[][])object).length; ++i2) {
                int n4 = i2;
                object[n4] = new long[n4 + 1];
                object[i2][0] = 0L;
                object[i2][1] = 1L;
                object[i2][i2] = 1L;
                for (int i3 = 2; i3 < i2; ++i3) {
                    int n5 = i3;
                    object[i2][n5] = (long)n5 * object[i2 - 1][i3] + object[i2 - 1][i3 - 1];
                }
            }
            b.compareAndSet((long[][])null, (long[][])object);
        }
        if (n2 < ((long[][])object).length) {
            return object[n2][n3];
        }
        if (n3 == 0) {
            return 0L;
        }
        if (n3 == 1 || n3 == n2) {
            return 1L;
        }
        if (n3 == 2) {
            return (1L << n2 - 1) - 1L;
        }
        if (n3 == n2 - 1) {
            return BR.a(n2, 2);
        }
        long l2 = 0L;
        long l3 = (n3 & 1) == 0 ? 1L : -1L;
        for (int i4 = 1; i4 <= n3; ++i4) {
            if ((l2 += (l3 = -l3) * BR.a(n3, i4) * (long)BM.e(i4, n2)) >= 0L) continue;
            throw new oU(px_0.ARGUMENT_OUTSIDE_DOMAIN, n2, 0, ((long[][])object).length - 1);
        }
        return l2 / BR.a(n3);
    }

    private static Iterator<int[]> f(int n2, int n3) {
        return new BQ(n2, n3).iterator();
    }

    public static void e(int n2, int n3) {
        if (n2 < n3) {
            throw new pm_0(px_0.BINOMIAL_INVALID_PARAMETERS_ORDER, (Number)n3, n2, true);
        }
        if (n2 < 0) {
            throw new pj_0(px_0.BINOMIAL_NEGATIVE_PARAMETER, n2);
        }
    }
}

