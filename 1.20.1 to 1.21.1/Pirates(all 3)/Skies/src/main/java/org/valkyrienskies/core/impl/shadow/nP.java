/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.lc_0;
import org.valkyrienskies.core.impl.shadow.nI;
import org.valkyrienskies.core.impl.shadow.nr_0;
import org.valkyrienskies.core.impl.shadow.nz_0;
import org.valkyrienskies.core.impl.shadow.oe_0;
import org.valkyrienskies.core.impl.shadow.pe_0;
import org.valkyrienskies.core.impl.shadow.pk_0;
import org.valkyrienskies.core.impl.shadow.pl_0;
import org.valkyrienskies.core.impl.shadow.pm_0;
import org.valkyrienskies.core.impl.shadow.px_0;
import org.valkyrienskies.core.impl.shadow.vi_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public final class nP {
    private nP() {
    }

    private static double c(lc_0 lc_02, double d2, double d3) {
        if (lc_02 == null) {
            throw new pl_0(px_0.FUNCTION, new Object[0]);
        }
        nz_0 nz_02 = new nz_0();
        return nz_02.a(Integer.MAX_VALUE, lc_02, d2, d3);
    }

    public static double a(oe_0.1 var0, double d2, double d3, double d4) {
        nz_0 nz_02 = new nz_0(d4);
        return nz_02.a(Integer.MAX_VALUE, var0, d2, d3);
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    public static double a(int n2, vi_0.1 var1_1, nI nI2, double d2, double d3, double d4, int n3) {
        if (n3 == nr_0.ANY_SIDE$37d0779) {
            return d2;
        }
        double d5 = BY.e(nI2.g(), BY.w(d2 * nI2.h()));
        double d6 = BY.e(d3, d2 - d5);
        double d7 = var1_1.a(d6);
        double d8 = BY.d(d4, d2 + d5);
        double d9 = var1_1.a(d8);
        int n4 = n2 - 2;
        while (n4 > 0) {
            if (d7 >= 0.0 && d9 <= 0.0 || d7 <= 0.0 && d9 >= 0.0) {
                return nI2.a(n4, var1_1, d6, d8, d2, n3);
            }
            boolean bl = false;
            boolean bl2 = false;
            if (d7 < d9) {
                if (d7 >= 0.0) {
                    bl = true;
                } else {
                    bl2 = true;
                }
            } else if (d7 > d9) {
                if (d7 <= 0.0) {
                    bl = true;
                } else {
                    bl2 = true;
                }
            } else {
                bl = true;
                bl2 = true;
            }
            if (bl) {
                d6 = BY.e(d3, d6 - d5);
                d7 = var1_1.a(d6);
                --n4;
            }
            if (!bl2) continue;
            d8 = BY.d(d4, d8 + d5);
            d9 = var1_1.a(d8);
            --n4;
        }
        throw new pe_0(px_0.FAILED_BRACKETING, d6, d8, d7, d9, n2 - n4, n2, d2, d3, d4);
    }

    private static double[] a(lc_0 lc_02, double d2, double d3, double d4) {
        return nP.a(lc_02, d2, d3, d4, 1.0, 1.0, Integer.MAX_VALUE);
    }

    private static double[] a(lc_0 lc_02, double d2, double d3, double d4, int n2) {
        return nP.a(lc_02, d2, d3, d4, 1.0, 1.0, n2);
    }

    private static double[] a(lc_0 lc_02, double d2, double d3, double d4, double d5, double d6, int n2) {
        if (lc_02 == null) {
            throw new pl_0(px_0.FUNCTION, new Object[0]);
        }
        if (n2 <= 0) {
            throw new pk_0(px_0.INVALID_MAX_ITERATIONS, n2);
        }
        nP.b(d3, d2, d4);
        double d7 = d2;
        double d8 = d2;
        double d9 = Double.NaN;
        double d10 = Double.NaN;
        double d11 = 0.0;
        for (int i2 = 0; i2 < n2 && (d7 > d3 || d8 < d4); ++i2) {
            double d12 = d7;
            double d13 = d9;
            double d14 = d8;
            double d15 = d10;
            d11 = d11 * 1.0 + 1.0;
            d7 = BY.e(d2 - d11, d3);
            d8 = BY.d(d2 + d11, d4);
            d9 = lc_02.a(d7);
            d10 = lc_02.a(d8);
            if (i2 == 0) {
                if (!(d9 * d10 <= 0.0)) continue;
                return new double[]{d7, d8};
            }
            if (d9 * d13 <= 0.0) {
                return new double[]{d7, d12};
            }
            if (!(d10 * d15 <= 0.0)) continue;
            return new double[]{d14, d8};
        }
        throw new pe_0(d7, d8, d9, d10);
    }

    public static double a(double d2, double d3) {
        return (d2 + d3) * 0.5;
    }

    public static boolean a(lc_0 lc_02, double d2, double d3) {
        if (lc_02 == null) {
            throw new pl_0(px_0.FUNCTION, new Object[0]);
        }
        double d4 = lc_02.a(d2);
        double d5 = lc_02.a(d3);
        return d4 >= 0.0 && d5 <= 0.0 || d4 <= 0.0 && d5 >= 0.0;
    }

    public static boolean a(double d2, double d3, double d4) {
        return d2 < d3 && d3 < d4;
    }

    public static void b(double d2, double d3) {
        if (d2 >= d3) {
            throw new pm_0(px_0.ENDPOINTS_NOT_AN_INTERVAL, (Number)d2, d3, false);
        }
    }

    public static void b(double d2, double d3, double d4) {
        nP.b(d2, d3);
        nP.b(d3, d4);
    }

    public static void b(lc_0 lc_02, double d2, double d3) {
        if (lc_02 == null) {
            throw new pl_0(px_0.FUNCTION, new Object[0]);
        }
        nP.b(d2, d3);
        if (!nP.a(lc_02, d2, d3)) {
            throw new pe_0(d2, d3, lc_02.a(d2), lc_02.a(d3));
        }
    }
}

