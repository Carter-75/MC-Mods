/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.math.BigDecimal;
import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.oU;
import org.valkyrienskies.core.impl.shadow.oV;
import org.valkyrienskies.core.impl.shadow.px_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Cq
 */
public final class cq_0 {
    public static final double a;
    public static final double b;
    private static final long c = 1023L;
    private static final long d = Long.MIN_VALUE;
    private static final int e = Integer.MIN_VALUE;
    private static final double f = 0.0;
    private static final long g;
    private static final long h;
    private static final int i;
    private static final int j;

    private cq_0() {
    }

    public static int a(double d2, double d3, double d4) {
        if (cq_0.b(d2, d3, d4)) {
            return 0;
        }
        if (d2 < d3) {
            return -1;
        }
        return 1;
    }

    public static int a(double d2, double d3, int n2) {
        if (cq_0.b(d2, 0.0, n2)) {
            return 0;
        }
        if (d2 < 0.0) {
            return -1;
        }
        return 1;
    }

    public static boolean a(float f2, float f3) {
        return cq_0.a(f2, f3, 1);
    }

    public static boolean b(float f2, float f3) {
        block3: {
            block2: {
                float f4 = f2;
                if (f4 != f4) break block2;
                float f5 = f3;
                if (f5 == f5) break block3;
            }
            float f6 = f2;
            float f7 = f3;
            return !(f6 != f6 ^ f7 != f7);
        }
        return cq_0.a(f2, f3, 1);
    }

    private static boolean a(float f2, float f3, float f4) {
        return cq_0.a(f2, f3, 1) || BY.a(f3 - f2) <= f4;
    }

    private static boolean b(float f2, float f3, float f4) {
        return cq_0.b(f2, f3) || BY.a(f3 - f2) <= f4;
    }

    private static boolean a(float f2, float f3, int n2) {
        int n3;
        int n4 = Float.floatToRawIntBits(f2);
        if (((n4 ^ (n3 = Float.floatToRawIntBits(f3))) & Integer.MIN_VALUE) == 0) {
            n2 = BY.a(n4 - n3) <= n2 ? 1 : 0;
        } else {
            int n5;
            if (n4 < n3) {
                n5 = n3 - i;
                n4 -= j;
            } else {
                n5 = n4 - i;
                n4 = n3 - j;
            }
            int n6 = n2 = n5 <= n2 && n4 <= n2 - n5 ? 1 : 0;
        }
        return n2 != 0 && !Float.isNaN(f2) && !Float.isNaN(f3);
    }

    private static boolean b(float f2, float f3, int n2) {
        block3: {
            block2: {
                float f4 = f2;
                if (f4 != f4) break block2;
                float f5 = f3;
                if (f5 == f5) break block3;
            }
            float f6 = f2;
            float f7 = f3;
            return !(f6 != f6 ^ f7 != f7);
        }
        return cq_0.a(f2, f3, n2);
    }

    public static boolean a(double d2, double d3) {
        return cq_0.b(d2, d3, 1);
    }

    public static boolean b(double d2, double d3) {
        block3: {
            block2: {
                double d4 = d2;
                if (d4 != d4) break block2;
                double d5 = d3;
                if (d5 == d5) break block3;
            }
            double d6 = d2;
            double d7 = d3;
            return !(d6 != d6 ^ d7 != d7);
        }
        return cq_0.b(d2, d3, 1);
    }

    public static boolean b(double d2, double d3, double d4) {
        return cq_0.b(d2, d3, 1) || BY.w(d3 - d2) <= d4;
    }

    public static boolean c(double d2, double d3, double d4) {
        double d5;
        if (cq_0.b(d2, d3, 1)) {
            return true;
        }
        double d6 = BY.e(BY.w(d2), BY.w(d3));
        double d7 = BY.w((d2 - d3) / d6);
        return d5 <= d4;
    }

    private static boolean d(double d2, double d3, double d4) {
        return cq_0.b(d2, d3) || BY.w(d3 - d2) <= d4;
    }

    public static boolean b(double d2, double d3, int n2) {
        long l2;
        long l3 = Double.doubleToRawLongBits(d2);
        if (((l3 ^ (l2 = Double.doubleToRawLongBits(d3))) & Long.MIN_VALUE) == 0L) {
            n2 = BY.a(l3 - l2) <= (long)n2 ? 1 : 0;
        } else {
            long l4;
            long l5;
            if (l3 < l2) {
                l5 = l2 - g;
                l4 = l3 - h;
            } else {
                l5 = l3 - g;
                l4 = l2 - h;
            }
            int n3 = n2 = l5 <= (long)n2 && l4 <= (long)n2 - l5 ? 1 : 0;
        }
        return n2 != 0 && !Double.isNaN(d2) && !Double.isNaN(d3);
    }

    private static boolean c(double d2, double d3, int n2) {
        block3: {
            block2: {
                double d4 = d2;
                if (d4 != d4) break block2;
                double d5 = d3;
                if (d5 == d5) break block3;
            }
            double d6 = d2;
            double d7 = d3;
            return !(d6 != d6 ^ d7 != d7);
        }
        return cq_0.b(d2, d3, n2);
    }

    public static double a(double d2, int n2) {
        return cq_0.a(d2, n2, 4);
    }

    private static double a(double d2, int n2, int n3) {
        try {
            double d3 = new BigDecimal(Double.toString(d2)).setScale(n2, 4).doubleValue();
            if (d3 == 0.0) {
                return d2 * 0.0;
            }
            return d3;
        }
        catch (NumberFormatException numberFormatException) {
            if (Double.isInfinite(d2)) {
                return d2;
            }
            return Double.NaN;
        }
    }

    private static float a(float f2, int n2) {
        int n3 = 4;
        float f3 = f2;
        float f4 = BY.a(1.0f, f3);
        float f5 = (float)BY.a(10.0, n2) * f4;
        int n4 = 4;
        double d2 = f4;
        double d3 = f3 * f5;
        switch (n4) {
            case 2: {
                if (d2 == -1.0) {
                    d3 = BY.y(BY.c(d3, Double.NEGATIVE_INFINITY));
                    break;
                }
                d3 = BY.z(BY.c(d3, Double.POSITIVE_INFINITY));
                break;
            }
            case 1: {
                d3 = BY.y(BY.c(d3, Double.NEGATIVE_INFINITY));
                break;
            }
            case 3: {
                if (d2 == -1.0) {
                    d3 = BY.z(BY.c(d3, Double.POSITIVE_INFINITY));
                    break;
                }
                d3 = BY.y(BY.c(d3, Double.NEGATIVE_INFINITY));
                break;
            }
            case 5: {
                double d4;
                d3 = BY.c(d3, Double.NEGATIVE_INFINITY);
                double d5 = d3 - BY.y(d3);
                if (d4 > 0.5) {
                    d3 = BY.z(d3);
                    break;
                }
                d3 = BY.y(d3);
                break;
            }
            case 6: {
                double d6;
                double d7 = d3;
                double d8 = d7 - BY.y(d7);
                if (d6 > 0.5) {
                    d3 = BY.z(d3);
                    break;
                }
                if (d8 < 0.5) {
                    d3 = BY.y(d3);
                    break;
                }
                if (BY.y(d3) / 2.0 == BY.y(BY.y(d3) / 2.0)) {
                    d3 = BY.y(d3);
                    break;
                }
                d3 = BY.z(d3);
                break;
            }
            case 4: {
                double d9;
                d3 = BY.c(d3, Double.POSITIVE_INFINITY);
                double d10 = d3 - BY.y(d3);
                if (d9 >= 0.5) {
                    d3 = BY.z(d3);
                    break;
                }
                d3 = BY.y(d3);
                break;
            }
            case 7: {
                double d11 = d3;
                if (d11 == BY.y(d11)) break;
                throw new oU();
            }
            case 0: {
                double d12 = d3;
                if (d12 == BY.y(d12)) break;
                d3 = BY.z(BY.c(d3, Double.POSITIVE_INFINITY));
                break;
            }
            default: {
                throw new oV(px_0.INVALID_ROUNDING_METHOD, n4, "ROUND_CEILING", 2, "ROUND_DOWN", 1, "ROUND_FLOOR", 3, "ROUND_HALF_DOWN", 5, "ROUND_HALF_EVEN", 6, "ROUND_HALF_UP", 4, "ROUND_UNNECESSARY", 7, "ROUND_UP", 0);
            }
        }
        return (float)d3 / f5;
    }

    private static float a(float f2, int n2, int n3) {
        float f3 = BY.a(1.0f, f2);
        float f4 = (float)BY.a(10.0, n2) * f3;
        return (float)cq_0.d((double)(f2 * f4), (double)f3, 4) / f4;
    }

    private static double d(double d2, double d3, int n2) {
        switch (n2) {
            case 2: {
                if (d3 == -1.0) {
                    d2 = BY.y(BY.c(d2, Double.NEGATIVE_INFINITY));
                    break;
                }
                d2 = BY.z(BY.c(d2, Double.POSITIVE_INFINITY));
                break;
            }
            case 1: {
                d2 = BY.y(BY.c(d2, Double.NEGATIVE_INFINITY));
                break;
            }
            case 3: {
                if (d3 == -1.0) {
                    d2 = BY.z(BY.c(d2, Double.POSITIVE_INFINITY));
                    break;
                }
                d2 = BY.y(BY.c(d2, Double.NEGATIVE_INFINITY));
                break;
            }
            case 5: {
                double d4;
                d2 = BY.c(d2, Double.NEGATIVE_INFINITY);
                double d5 = d2 - BY.y(d2);
                if (d4 > 0.5) {
                    d2 = BY.z(d2);
                    break;
                }
                d2 = BY.y(d2);
                break;
            }
            case 6: {
                double d6;
                double d7 = d2;
                double d8 = d7 - BY.y(d7);
                if (d6 > 0.5) {
                    d2 = BY.z(d2);
                    break;
                }
                if (d8 < 0.5) {
                    d2 = BY.y(d2);
                    break;
                }
                if (BY.y(d2) / 2.0 == BY.y(BY.y(d2) / 2.0)) {
                    d2 = BY.y(d2);
                    break;
                }
                d2 = BY.z(d2);
                break;
            }
            case 4: {
                double d9;
                d2 = BY.c(d2, Double.POSITIVE_INFINITY);
                double d10 = d2 - BY.y(d2);
                if (d9 >= 0.5) {
                    d2 = BY.z(d2);
                    break;
                }
                d2 = BY.y(d2);
                break;
            }
            case 7: {
                double d11 = d2;
                if (d11 == BY.y(d11)) break;
                throw new oU();
            }
            case 0: {
                double d12 = d2;
                if (d12 == BY.y(d12)) break;
                d2 = BY.z(BY.c(d2, Double.POSITIVE_INFINITY));
                break;
            }
            default: {
                throw new oV(px_0.INVALID_ROUNDING_METHOD, n2, "ROUND_CEILING", 2, "ROUND_DOWN", 1, "ROUND_FLOOR", 3, "ROUND_HALF_DOWN", 5, "ROUND_HALF_EVEN", 6, "ROUND_HALF_UP", 4, "ROUND_UNNECESSARY", 7, "ROUND_UP", 0);
            }
        }
        return d2;
    }

    private static double c(double d2, double d3) {
        return d2 + d3 - d2;
    }

    static {
        g = Double.doubleToRawLongBits(0.0);
        h = Double.doubleToRawLongBits(-0.0);
        i = Float.floatToRawIntBits(0.0f);
        j = Float.floatToRawIntBits(-0.0f);
        a = Double.longBitsToDouble(4368491638549381120L);
        b = Double.longBitsToDouble(0x10000000000000L);
    }
}

