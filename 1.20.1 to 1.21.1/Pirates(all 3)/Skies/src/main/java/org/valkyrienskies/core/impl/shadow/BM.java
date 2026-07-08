/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.math.BigInteger;
import org.valkyrienskies.core.impl.shadow.BR;
import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.oU;
import org.valkyrienskies.core.impl.shadow.pj_0;
import org.valkyrienskies.core.impl.shadow.px_0;

public final class BM {
    private BM() {
    }

    public static int a(int n2, int n3) {
        long l2 = (long)n2 + (long)n3;
        if (l2 < Integer.MIN_VALUE || l2 > Integer.MAX_VALUE) {
            throw new oU(px_0.OVERFLOW_IN_ADDITION, n2, n3);
        }
        return (int)l2;
    }

    private static long b(long l2, long l3) {
        return BM.a(l2, l3, px_0.OVERFLOW_IN_ADDITION);
    }

    @Deprecated
    private static long f(int n2, int n3) {
        return BR.a(n2, n3);
    }

    @Deprecated
    private static double g(int n2, int n3) {
        return BR.b(n2, n3);
    }

    @Deprecated
    private static double h(int n2, int n3) {
        return BR.c(n2, n3);
    }

    @Deprecated
    private static long a(int n2) {
        return BR.a(n2);
    }

    @Deprecated
    private static double b(int n2) {
        return BR.b(n2);
    }

    @Deprecated
    private static double c(int n2) {
        return BR.c(n2);
    }

    public static int b(int n2, int n3) {
        int n4 = n2;
        int n5 = n3;
        if (n4 == 0 || n5 == 0) {
            if (n4 == Integer.MIN_VALUE || n5 == Integer.MIN_VALUE) {
                throw new oU(px_0.GCD_OVERFLOW_32_BITS, n2, n3);
            }
            return BY.a(n4 + n5);
        }
        long l2 = n4;
        long l3 = n5;
        boolean bl = false;
        if (n4 < 0) {
            if (Integer.MIN_VALUE == n4) {
                bl = true;
            } else {
                n4 = -n4;
            }
            l2 = -l2;
        }
        if (n5 < 0) {
            if (Integer.MIN_VALUE == n5) {
                bl = true;
            } else {
                n5 = -n5;
            }
            l3 = -l3;
        }
        if (bl) {
            if (l2 == l3) {
                throw new oU(px_0.GCD_OVERFLOW_32_BITS, n2, n3);
            }
            long l4 = l3;
            l3 = l2;
            if ((l2 = l4 % l2) == 0L) {
                if (l3 > Integer.MAX_VALUE) {
                    throw new oU(px_0.GCD_OVERFLOW_32_BITS, n2, n3);
                }
                return (int)l3;
            }
            l4 = l3;
            n5 = (int)l2;
            n4 = (int)(l4 % l2);
        }
        return BM.i(n4, n5);
    }

    private static int i(int n2, int n3) {
        if (n2 == 0) {
            return n3;
        }
        if (n3 == 0) {
            return n2;
        }
        int n4 = Integer.numberOfTrailingZeros(n2);
        n2 >>= n4;
        int n5 = Integer.numberOfTrailingZeros(n3);
        n3 >>= n5;
        n4 = BY.a(n4, n5);
        while (n2 != n3) {
            n5 = n2 - n3;
            n3 = Math.min(n2, n3);
            n2 = Math.abs(n5);
            n2 >>= Integer.numberOfTrailingZeros(n2);
        }
        return n2 << n4;
    }

    private static long c(long l2, long l3) {
        long l4;
        int n2;
        long l5 = l2;
        long l6 = l3;
        if (l5 == 0L || l6 == 0L) {
            if (l5 == Long.MIN_VALUE || l6 == Long.MIN_VALUE) {
                throw new oU(px_0.GCD_OVERFLOW_64_BITS, l2, l3);
            }
            return BY.a(l5) + BY.a(l6);
        }
        if (l5 > 0L) {
            l5 = -l5;
        }
        if (l6 > 0L) {
            l6 = -l6;
        }
        for (n2 = 0; (l5 & 1L) == 0L && (l6 & 1L) == 0L && n2 < 63; ++n2) {
            l5 /= 2L;
            l6 /= 2L;
        }
        if (n2 == 63) {
            throw new oU(px_0.GCD_OVERFLOW_64_BITS, l2, l3);
        }
        long l7 = l4 = (l5 & 1L) == 1L ? l6 : -(l5 / 2L);
        while (true) {
            if ((l4 & 1L) == 0L) {
                l7 = l4 / 2L;
                continue;
            }
            if (l4 > 0L) {
                l5 = -l4;
            } else {
                l6 = l4;
            }
            if ((l4 = (l6 - l5) / 2L) == 0L) break;
        }
        return -l5 * (1L << n2);
    }

    private static int j(int n2, int n3) {
        if (n2 == 0 || n3 == 0) {
            return 0;
        }
        int n4 = n2;
        int n5 = BY.a(BM.c(n4 / BM.b(n4, n3), n3));
        if (n5 == Integer.MIN_VALUE) {
            throw new oU(px_0.LCM_OVERFLOW_32_BITS, n2, n3);
        }
        return n5;
    }

    private static long d(long l2, long l3) {
        long l4;
        long l5;
        if (l2 == 0L || l3 == 0L) {
            return 0L;
        }
        long l6 = l3;
        long l7 = l5 = l2;
        long l8 = l6;
        if (l7 == 0L || l8 == 0L) {
            if (l7 == Long.MIN_VALUE || l8 == Long.MIN_VALUE) {
                throw new oU(px_0.GCD_OVERFLOW_64_BITS, l5, l6);
            }
            l4 = BY.a(l7) + BY.a(l8);
        } else {
            long l9;
            int n2;
            if (l7 > 0L) {
                l7 = -l7;
            }
            if (l8 > 0L) {
                l8 = -l8;
            }
            for (n2 = 0; (l7 & 1L) == 0L && (l8 & 1L) == 0L && n2 < 63; ++n2) {
                l7 /= 2L;
                l8 /= 2L;
            }
            if (n2 == 63) {
                throw new oU(px_0.GCD_OVERFLOW_64_BITS, l5, l6);
            }
            long l10 = l9 = (l7 & 1L) == 1L ? l8 : -(l7 / 2L);
            while (true) {
                if ((l9 & 1L) == 0L) {
                    l10 = l9 / 2L;
                    continue;
                }
                if (l9 > 0L) {
                    l7 = -l9;
                } else {
                    l8 = l9;
                }
                if ((l9 = (l8 - l7) / 2L) == 0L) break;
            }
            l4 = -l7 * (1L << n2);
        }
        long l11 = BY.a(BM.a(l5 / l4, l3));
        if (l11 == Long.MIN_VALUE) {
            throw new oU(px_0.LCM_OVERFLOW_64_BITS, l2, l3);
        }
        return l11;
    }

    public static int c(int n2, int n3) {
        long l2 = (long)n2 * (long)n3;
        if (l2 < Integer.MIN_VALUE || l2 > Integer.MAX_VALUE) {
            throw new oU();
        }
        return (int)l2;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static long a(long l2, long l3) {
        if (l2 > l3) {
            return BM.a(l3, l2);
        }
        if (l2 < 0L) {
            if (l3 < 0L) {
                if (l2 < Long.MAX_VALUE / l3) throw new oU();
                return l2 * l3;
            }
            if (l3 <= 0L) return 0L;
            if (Long.MIN_VALUE / l3 > l2) throw new oU();
            return l2 * l3;
        }
        if (l2 <= 0L) return 0L;
        if (l2 > Long.MAX_VALUE / l3) throw new oU();
        return l2 * l3;
    }

    public static int d(int n2, int n3) {
        long l2 = (long)n2 - (long)n3;
        if (l2 < Integer.MIN_VALUE || l2 > Integer.MAX_VALUE) {
            throw new oU(px_0.OVERFLOW_IN_SUBTRACTION, n2, n3);
        }
        return (int)l2;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static long e(long l2, long l3) {
        if (l3 != Long.MIN_VALUE) return BM.a(l2, -l3, px_0.OVERFLOW_IN_ADDITION);
        if (l2 >= 0L) throw new oU(px_0.OVERFLOW_IN_ADDITION, l2, -l3);
        return l2 - l3;
    }

    public static int e(int n2, int n3) {
        if (n3 < 0) {
            throw new pj_0(px_0.EXPONENT, n3);
        }
        try {
            int n4 = n3;
            int n5 = 1;
            int n6 = n2;
            while (true) {
                if ((n4 & 1) != 0) {
                    n5 = BM.c(n5, n6);
                }
                if ((n4 >>= 1) == 0) break;
                int n7 = n6;
                n6 = BM.c(n7, n7);
            }
            return n5;
        }
        catch (oU oU2) {
            oU oU3 = oU2;
            oU oU4 = oU2;
            oU2.a.a(px_0.OVERFLOW, new Object[0]);
            oU4 = oU3;
            oU4.a.a(px_0.BASE, n2);
            oU4 = oU3;
            oU4.a.a(px_0.EXPONENT, n3);
            throw oU3;
        }
    }

    @Deprecated
    private static int a(int n2, long l2) {
        if (l2 < 0L) {
            throw new pj_0(px_0.EXPONENT, l2);
        }
        int n3 = 1;
        while (l2 != 0L) {
            if ((l2 & 1L) != 0L) {
                n3 *= n2;
            }
            int n4 = n2;
            n2 = n4 * n4;
            l2 >>= 1;
        }
        return n3;
    }

    private static long a(long l2, int n2) {
        if (n2 < 0) {
            throw new pj_0(px_0.EXPONENT, n2);
        }
        try {
            int n3 = n2;
            long l3 = 1L;
            long l4 = l2;
            while (true) {
                if ((n3 & 1) != 0) {
                    l3 = BM.a(l3, l4);
                }
                if ((n3 >>= 1) == 0) break;
                long l5 = l4;
                l4 = BM.a(l5, l5);
            }
            return l3;
        }
        catch (oU oU2) {
            oU oU3 = oU2;
            oU oU4 = oU2;
            oU2.a.a(px_0.OVERFLOW, new Object[0]);
            oU4 = oU3;
            oU4.a.a(px_0.BASE, l2);
            oU4 = oU3;
            oU4.a.a(px_0.EXPONENT, n2);
            throw oU3;
        }
    }

    @Deprecated
    private static long f(long l2, long l3) {
        if (l3 < 0L) {
            throw new pj_0(px_0.EXPONENT, l3);
        }
        long l4 = 1L;
        long l5 = l2;
        while (l3 != 0L) {
            if ((l3 & 1L) != 0L) {
                l4 *= l5;
            }
            long l6 = l5;
            l5 = l6 * l6;
            l3 >>= 1;
        }
        return l4;
    }

    private static BigInteger a(BigInteger bigInteger, int n2) {
        if (n2 < 0) {
            throw new pj_0(px_0.EXPONENT, n2);
        }
        return bigInteger.pow(n2);
    }

    public static BigInteger a(BigInteger bigInteger, long l2) {
        if (l2 < 0L) {
            throw new pj_0(px_0.EXPONENT, l2);
        }
        BigInteger bigInteger2 = BigInteger.ONE;
        while (l2 != 0L) {
            if ((l2 & 1L) != 0L) {
                bigInteger2 = bigInteger2.multiply(bigInteger);
            }
            BigInteger bigInteger3 = bigInteger;
            bigInteger = bigInteger3.multiply(bigInteger3);
            l2 >>= 1;
        }
        return bigInteger2;
    }

    public static BigInteger a(BigInteger bigInteger, BigInteger bigInteger2) {
        if (bigInteger2.compareTo(BigInteger.ZERO) < 0) {
            throw new pj_0(px_0.EXPONENT, bigInteger2);
        }
        BigInteger bigInteger3 = BigInteger.ONE;
        while (!BigInteger.ZERO.equals(bigInteger2)) {
            if (bigInteger2.testBit(0)) {
                bigInteger3 = bigInteger3.multiply(bigInteger);
            }
            BigInteger bigInteger4 = bigInteger;
            bigInteger = bigInteger4.multiply(bigInteger4);
            bigInteger2 = bigInteger2.shiftRight(1);
        }
        return bigInteger3;
    }

    @Deprecated
    private static long k(int n2, int n3) {
        return BR.d(n2, n3);
    }

    private static long a(long l2, long l3, px_0 px_02) {
        long l4;
        if (!((l2 ^ l3) < 0L | (l2 ^ (l4 = l2 + l3)) >= 0L)) {
            throw new oU(px_02, l2, l3);
        }
        return l4;
    }

    public static boolean a(long l2) {
        if (l2 > 0L) {
            long l3 = l2;
            if ((l3 & l3 - 1L) == 0L) {
                return true;
            }
        }
        return false;
    }
}

