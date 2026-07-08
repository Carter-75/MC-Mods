/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.BT;
import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.pn_0;
import org.valkyrienskies.core.impl.shadow.po_0;
import org.valkyrienskies.core.impl.shadow.zY;

public final class zW {
    private static final double a = 1.0E-14;
    private static final double b = 0.9189385332046727;
    private static final double[] c = new double[]{0.08333333333333333, -2.777777777777778E-5, 7.936507936507937E-8, -5.952380952380953E-10, 8.417508417508329E-12, -1.917526917518546E-13, 6.410256405103255E-15, -2.955065141253382E-16, 1.7964371635940225E-17, -1.3922896466162779E-18, 1.338028550140209E-19, -1.542460098679661E-20, 1.9770199298095743E-21, -2.3406566479399704E-22, 1.713480149663986E-23};

    private zW() {
    }

    public static double a(double d2, double d3, double d4) {
        return zW.a(d2, d3, d4, 1.0E-14, Integer.MAX_VALUE);
    }

    private static double a(double d2, double d3, double d4, double d5) {
        return zW.a(d2, d3, d4, d5, Integer.MAX_VALUE);
    }

    private static double a(double d2, double d3, double d4, int n2) {
        return zW.a(d2, d3, d4, 1.0E-14, n2);
    }

    private static double a(double d2, double d3, double d4, double d5, int n2) {
        double d6;
        if (Double.isNaN(d2) || Double.isNaN(d3) || Double.isNaN(d4) || d2 < 0.0 || d2 > 1.0 || d3 <= 0.0 || d4 <= 0.0) {
            d6 = Double.NaN;
        } else if (d2 > (d3 + 1.0) / (d4 + 2.0 + d3) && 1.0 - d2 <= (d4 + 1.0) / (d4 + 2.0 + d3)) {
            d6 = 1.0 - zW.a(1.0 - d2, d4, d3, d5, n2);
        } else {
            BT bT = new BT(d4, d3){
                private /* synthetic */ double a;
                private /* synthetic */ double b;
                {
                    this.a = d2;
                    this.b = d3;
                }

                public final double a(int n2, double d2) {
                    double d3;
                    if (n2 % 2 == 0) {
                        double d4 = (double)n2 / 2.0;
                        d3 = d4 * (this.a - d4) * d2 / ((this.b + d4 * 2.0 - 1.0) * (this.b + d4 * 2.0));
                    } else {
                        double d5 = ((double)n2 - 1.0) / 2.0;
                        d3 = -((this.b + d5) * (this.b + this.a + d5) * d2) / ((this.b + d5 * 2.0) * (this.b + d5 * 2.0 + 1.0));
                    }
                    return d3;
                }

                public final double b(int n2, double d2) {
                    return 1.0;
                }
            };
            d6 = BY.i(d3 * BY.k(d2) + d4 * BY.l(-d2) - BY.k(d3) - zW.a(d3, d4)) / bT.a(d2, d5, n2);
        }
        return d6;
    }

    @Deprecated
    private static double b(double d2, double d3) {
        return zW.a(d2, d3);
    }

    private static double c(double d2, double d3) {
        double d4;
        if (d2 < 1.0 || d2 > 2.0) {
            throw new po_0(d2, (Number)1.0, 2.0);
        }
        if (d3 < 1.0 || d3 > 2.0) {
            throw new po_0(d3, (Number)1.0, 2.0);
        }
        double d5 = d2 - 1.0 + (d3 - 1.0);
        if (d4 <= 0.5) {
            return zY.c(d5 + 1.0);
        }
        if (d5 <= 1.5) {
            return zY.c(d5) + BY.l(d5);
        }
        return zY.c(d5 - 1.0) + BY.k(d5 * (d5 + 1.0));
    }

    private static double d(double d2, double d3) {
        double d4;
        double d5;
        if (d2 < 0.0) {
            throw new pn_0(d2, (Number)0.0, true);
        }
        if (d3 < 10.0) {
            throw new pn_0(d3, (Number)10.0, true);
        }
        if (d2 <= d3) {
            d5 = d3 + (d2 - 0.5);
            d4 = zW.e(d2, d3);
        } else {
            d5 = d2 + (d3 - 0.5);
            d4 = zW.e(d3, d2);
        }
        double d6 = d5 * BY.l(d2 / d3);
        double d7 = d2 * (BY.k(d3) - 1.0);
        if (d6 <= d7) {
            return d4 - d6 - d7;
        }
        return d4 - d7 - d6;
    }

    private static double e(double d2, double d3) {
        if (d2 < 0.0 || d2 > d3) {
            throw new po_0(d2, (Number)0, d3);
        }
        if (d3 < 10.0) {
            throw new pn_0(d3, (Number)10, true);
        }
        double d4 = d2 / d3;
        double d5 = d4 / (d4 + 1.0);
        double d6 = 1.0 / (d4 + 1.0);
        double d7 = d6 * d6;
        double[] dArray = new double[c.length];
        double[] dArray2 = dArray;
        dArray[0] = 1.0;
        for (int i2 = 1; i2 < dArray2.length; ++i2) {
            dArray2[i2] = 1.0 + (d6 + d7 * dArray2[i2 - 1]);
        }
        double d8 = 10.0 / d3;
        double d9 = d8 * d8;
        double d10 = c[c.length - 1] * dArray2[dArray2.length - 1];
        for (int i3 = c.length - 2; i3 >= 0; --i3) {
            d10 = d9 * d10 + c[i3] * dArray2[i3];
        }
        return d10 * d5 / d3;
    }

    private static double f(double d2, double d3) {
        if (d2 < 10.0) {
            throw new pn_0(d2, (Number)10.0, true);
        }
        if (d3 < 10.0) {
            throw new pn_0(d3, (Number)10.0, true);
        }
        double d4 = BY.d(d2, d3);
        double d5 = BY.e(d2, d3);
        double d6 = 10.0 / d4;
        double d7 = d6 * d6;
        double d8 = c[c.length - 1];
        for (int i2 = c.length - 2; i2 >= 0; --i2) {
            d8 = d7 * d8 + c[i2];
        }
        return d8 / d4 + zW.e(d4, d5);
    }

    public static double a(double d2, double d3) {
        if (Double.isNaN(d2) || Double.isNaN(d3) || d2 <= 0.0 || d3 <= 0.0) {
            return Double.NaN;
        }
        double d4 = BY.d(d2, d3);
        double d5 = BY.e(d2, d3);
        if (d4 >= 10.0) {
            double d6;
            double d7 = zW.f(d4, d5);
            double d8 = d4 / d5;
            double d9 = d8 / (d8 + 1.0);
            double d10 = -(d4 - 0.5) * BY.k(d9);
            if (d10 <= (d6 = d5 * BY.l(d8))) {
                return -0.5 * BY.k(d5) + 0.9189385332046727 + d7 - d10 - d6;
            }
            return -0.5 * BY.k(d5) + 0.9189385332046727 + d7 - d6 - d10;
        }
        if (d4 > 2.0) {
            double d11;
            if (d5 > 1000.0) {
                int n2 = (int)BY.y(d4 - 1.0);
                double d12 = 1.0;
                double d13 = d4;
                for (int i2 = 0; i2 < n2; ++i2) {
                    d12 *= (d13 -= 1.0) / (1.0 + d13 / d5);
                }
                return BY.k(d12) - (double)n2 * BY.k(d5) + (zY.a(d13) + zW.d(d13, d5));
            }
            double d14 = 1.0;
            double d15 = d4;
            while (d15 > 2.0) {
                d11 = (d15 -= 1.0) / d5;
                d14 *= d11 / (d11 + 1.0);
            }
            if (d5 < 10.0) {
                d11 = 1.0;
                double d16 = d5;
                while (d16 > 2.0) {
                    d11 *= (d16 -= 1.0) / (d15 + d16);
                }
                return BY.k(d14) + BY.k(d11) + (zY.a(d15) + (zY.a(d16) - zW.c(d15, d16)));
            }
            return BY.k(d14) + zY.a(d15) + zW.d(d15, d5);
        }
        if (d4 >= 1.0) {
            if (d5 > 2.0) {
                if (d5 < 10.0) {
                    double d17 = 1.0;
                    double d18 = d5;
                    while (d18 > 2.0) {
                        d17 *= (d18 -= 1.0) / (d4 + d18);
                    }
                    return BY.k(d17) + (zY.a(d4) + (zY.a(d18) - zW.c(d4, d18)));
                }
                return zY.a(d4) + zW.d(d4, d5);
            }
            return zY.a(d4) + zY.a(d5) - zW.c(d4, d5);
        }
        if (d5 >= 10.0) {
            return zY.a(d4) + zW.d(d4, d5);
        }
        return BY.k(zY.d(d4) * zY.d(d5) / zY.d(d4 + d5));
    }
}

