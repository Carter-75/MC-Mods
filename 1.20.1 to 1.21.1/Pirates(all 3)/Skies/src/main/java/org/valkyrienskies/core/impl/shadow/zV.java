/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.ch_0;
import org.valkyrienskies.core.impl.shadow.lc_0;
import org.valkyrienskies.core.impl.shadow.oR;
import org.valkyrienskies.core.impl.shadow.oV;
import org.valkyrienskies.core.impl.shadow.px_0;
import org.valkyrienskies.core.impl.shadow.zY;

public final class zV
implements lc_0 {
    private static final double a = 0.6366197723675814;
    private static final double b = 6.28125;
    private static final double c = 0.001935307179586477;
    private static final double d = Math.PI * 2;
    private static final double e = 1.0E308;
    private static final double f = 1.0E16;
    private static final double g = 1.0E-4;
    private static final double h = 8.9E-308;
    private static final double i = 0.0;
    private static final double j = 10000.0;
    private static final double[] k = new double[]{1.0, 1.0, 2.0, 6.0, 24.0, 120.0, 720.0, 5040.0, 40320.0, 362880.0, 3628800.0, 3.99168E7, 4.790016E8, 6.2270208E9, 8.71782912E10, 1.307674368E12, 2.0922789888E13, 3.55687428096E14, 6.402373705728E15, 1.21645100408832E17, 2.43290200817664E18, 5.109094217170944E19, 1.1240007277776077E21, 2.585201673888498E22, 6.204484017332394E23};
    private final double l;

    private zV(double d2) {
        this.l = d2;
    }

    public final double a(double d2) {
        a a2;
        a a3;
        a a4;
        int n2;
        int n3;
        double d3;
        double d4;
        block54: {
            int n4;
            d4 = d2;
            d3 = this.l;
            n3 = (int)d3;
            double d5 = d3 - (double)n3;
            int n5 = n2 = n3 + 1;
            double d6 = d5;
            double d7 = d4;
            double[] dArray = new double[n5];
            int n6 = (int)d7;
            if (n5 > 0 && d7 >= 0.0 && d7 <= 10000.0 && d6 >= 0.0 && d6 < 1.0) {
                n4 = n5;
                for (int i2 = 0; i2 < n5; ++i2) {
                    dArray[i2] = 0.0;
                }
                if (d7 < 1.0E-4) {
                    double d8 = 1.0;
                    double d9 = d6 + 1.0;
                    double d10 = 0.0;
                    if (d7 > 8.9E-308) {
                        d10 = d7 * 0.5;
                    }
                    if (d6 != 0.0) {
                        double d11 = d6;
                        d8 = BY.a(d10, d6) / (d11 * zY.d(d11));
                    }
                    double d12 = 0.0;
                    if (d7 + 1.0 > 1.0) {
                        d12 = -d10 * d10;
                    }
                    double d13 = d8;
                    dArray[0] = d13 + d13 * d12 / d9;
                    if (d7 != 0.0 && dArray[0] == 0.0) {
                        n4 = 0;
                    }
                    if (n5 != 1) {
                        if (d7 <= 0.0) {
                            for (int i3 = 1; i3 < n5; ++i3) {
                                dArray[i3] = 0.0;
                            }
                        } else {
                            double d14 = d10;
                            double d15 = d12 != 0.0 ? 8.9E-308 / d12 : 1.78E-307 / d7;
                            for (int i4 = 1; i4 < n5; ++i4) {
                                double d16;
                                d8 /= d9;
                                d9 += 1.0;
                                d8 *= d14;
                                if (d16 <= d15 * d9) {
                                    d8 = 0.0;
                                }
                                double d17 = d8;
                                dArray[i4] = d17 + d17 * d12 / d9;
                                if (dArray[i4] != 0.0 || n4 <= i4) continue;
                                n4 = i4;
                            }
                        }
                    }
                } else if (d7 > 25.0 && n5 <= n6 + 1) {
                    double d18 = BY.a(0.6366197723675814 / d7);
                    double d19 = 0.125 / d7;
                    double d20 = d19 * d19;
                    int n7 = d7 >= 130.0 ? 4 : (d7 >= 35.0 ? 8 : 11);
                    double d21 = 4.0 * (double)n7;
                    double d22 = (int)(d7 / (Math.PI * 2) + 0.5);
                    double d23 = d7 - d22 * 6.28125 - d22 * 0.001935307179586477 - (d6 + 0.5) / 0.6366197723675814;
                    double d24 = BY.n(d23);
                    double d25 = BY.o(d23);
                    double d26 = d6 * 2.0;
                    for (n6 = 1; n6 <= 2; ++n6) {
                        double d27 = (d21 - 1.0 - d26) * (d21 - 1.0 + d26) * d20 * 0.5;
                        d22 = (d26 - (d21 - 3.0)) * (d26 + (d21 - 3.0));
                        double d28 = d27 * d22 / k[2 * n7];
                        double d29 = (d26 - (d21 + 1.0)) * (d26 + (d21 + 1.0));
                        double d30 = d27 * d29 / k[2 * n7 + 1];
                        double d31 = d21;
                        int n8 = 2 * n7;
                        d29 = d22;
                        for (int i5 = 2; i5 <= n7; ++i5) {
                            d27 = ((d31 -= 4.0) - 1.0 - d26) * (d31 - 1.0 + d26);
                            d22 = (d26 - (d31 - 3.0)) * (d26 + (d31 - 3.0));
                            d28 = (d28 + 1.0 / k[n8 - 2]) * d27 * d22 * d20;
                            d30 = (d30 + 1.0 / k[n8 - 1]) * d27 * d29 * d20;
                            n8 -= 2;
                            d29 = d22;
                        }
                        double d32 = d26;
                        d30 = (d30 + 1.0) * (d32 * d32 - 1.0) * (0.125 / d7);
                        dArray[n6 - 1] = d18 * ((d28 += 1.0) * d25 - d30 * d24);
                        if (n5 == 1) {
                            a4 = new a(ch_0.a(dArray, dArray.length), n4);
                            break block54;
                        }
                        d22 = d24;
                        d24 = -d25;
                        d25 = d22;
                        d26 += 2.0;
                    }
                    if (n5 > 2) {
                        d26 = d6 * 2.0 + 2.0;
                        for (n6 = 2; n6 < n5; ++n6) {
                            dArray[n6] = d26 * dArray[n6 - 1] / d7 - dArray[n6 - 2];
                            d26 += 2.0;
                        }
                    }
                } else {
                    int n9;
                    int n10;
                    double d33;
                    double d34;
                    int n11;
                    int n12 = n5 - n6;
                    int n13 = n6 + 1;
                    double d35 = 2.0 * ((double)n13 + d6);
                    double d36 = 1.0;
                    double d37 = d35 / d7;
                    double d38 = 2.0E16;
                    boolean bl = false;
                    if (n12 >= 3) {
                        int n14 = n6 + 2;
                        n11 = n5 - 1;
                        d35 = 2.0 * ((double)(n14 - 1) + d6);
                        int n15 = n14;
                        while (n15 <= n11) {
                            double d39;
                            n13 = n15++;
                            d34 = d36;
                            d36 = d37;
                            d37 = (d35 += 2.0) * d36 / d7 - d34;
                            if (!(d39 > 1.0E292)) continue;
                            double d40 = d37 /= 1.0E308;
                            double d41 = d36 /= 1.0E308;
                            n14 = n13 + 1;
                            do {
                                ++n13;
                            } while ((d37 = (d35 += 2.0) * (d36 = d37) / d7 - (d34 = d36)) <= 1.0);
                            double d42 = d33 = d35 / d7;
                            d38 = d34 * d36 * (0.5 - 0.5 / (d42 * d42));
                            d38 /= 1.0E16;
                            d37 = d36 * 1.0E308;
                            d35 -= 2.0;
                            n11 = BY.a(n5, --n13);
                            for (n10 = n14; n10 <= n11 && !((d40 = d35 * (d41 = d40) / d7 - (d34 = d41)) * d41 > d38); ++n10) {
                            }
                            n4 = n11;
                            bl = true;
                            break;
                        }
                        if (!bl) {
                            n13 = n11;
                            d35 = 2.0 * ((double)n13 + d6);
                            d38 = BY.e(d38, BY.a(d36 * 1.0E16) * BY.a(d37 * 2.0));
                        }
                    }
                    if (!bl) {
                        do {
                            ++n13;
                        } while ((d37 = (d35 += 2.0) * (d36 = d37) / d7 - (d34 = d36)) < d38);
                    }
                    d35 += 2.0;
                    d33 = 0.0;
                    double d43 = 1.0 / d37;
                    int n16 = 2 * ++n13 - 4 * (n13 / 2);
                    double d44 = 0.0;
                    double d45 = n13 / 2;
                    double d46 = d45 - 1.0 + d6;
                    double d47 = d45 * 2.0 + d6;
                    if (n16 != 0) {
                        d44 = d43 * d46 * d47 / d45;
                    }
                    n11 = n13 - n5;
                    n10 = 0;
                    boolean bl2 = false;
                    for (n9 = 1; n9 <= n11; ++n9) {
                        --n13;
                        double d48 = d33;
                        d33 = d43;
                        d43 = (d35 -= 2.0) * d33 / d7 - d48;
                        if ((n16 = 2 - n16) == 0) continue;
                        d47 = (d45 -= 1.0) * 2.0 + d6;
                        if (n13 == 1) break;
                        d46 = d45 - 1.0 + d6;
                        if (d46 == 0.0) {
                            d46 = 1.0;
                        }
                        d44 = (d44 + d43 * d47) * d46 / d45;
                    }
                    dArray[n13 - 1] = d43;
                    if (n11 >= 0) {
                        if (n5 <= 1) {
                            d47 = d6;
                            if (d6 + 1.0 == 1.0) {
                                d47 = 1.0;
                            }
                            d44 += dArray[0] * d47;
                            n10 = 1;
                        } else {
                            dArray[--n13 - 1] = (d35 -= 2.0) * d43 / d7 - d33;
                            if (n13 == 1) {
                                bl2 = true;
                            } else if ((n16 = 2 - n16) != 0) {
                                d47 = (d45 -= 1.0) * 2.0 + d6;
                                d46 = d45 - 1.0 + d6;
                                if (d46 == 0.0) {
                                    d46 = 1.0;
                                }
                                d44 = (d44 + dArray[n13 - 1] * d47) * d46 / d45;
                            }
                        }
                    }
                    if (n10 == 0 && !bl2 && (n11 = n13 - 2) != 0) {
                        for (n9 = 1; n9 <= n11; ++n9) {
                            dArray[--n13 - 1] = (d35 -= 2.0) * dArray[n13] / d7 - dArray[n13 + 1];
                            if ((n16 = 2 - n16) == 0) continue;
                            d47 = (d45 -= 1.0) * 2.0 + d6;
                            d46 = d45 - 1.0 + d6;
                            if (d46 == 0.0) {
                                d46 = 1.0;
                            }
                            d44 = (d44 + dArray[n13 - 1] * d47) * d46 / d45;
                        }
                    }
                    if (n10 == 0) {
                        if (!bl2) {
                            dArray[0] = 2.0 * (d6 + 1.0) * dArray[1] / d7 - dArray[2];
                        }
                        if ((d47 = (d45 -= 1.0) * 2.0 + d6) == 0.0) {
                            d47 = 1.0;
                        }
                        d44 += dArray[0] * d47;
                    }
                    if (BY.w(d6) > 1.0E-16) {
                        d44 *= zY.d(d6) * BY.a(d7 * 0.5, -d6);
                    }
                    d43 = 8.9E-308;
                    if (d44 > 1.0) {
                        d43 = d44 * 8.9E-308;
                    }
                    n13 = 0;
                    while (n13 < n5) {
                        if (BY.w(dArray[n13]) < d43) {
                            dArray[n13] = 0.0;
                        }
                        int n17 = n13++;
                        dArray[n17] = dArray[n17] / d44;
                    }
                }
            } else {
                if (dArray.length > 0) {
                    dArray[0] = 0.0;
                }
                n4 = BY.a(n5, 0) - 1;
            }
            a4 = new a(ch_0.a(dArray, dArray.length), n4);
        }
        a a5 = a4;
        a a6 = a4;
        if (a4.b >= n2) {
            a6 = a5;
            return a6.a[n3];
        }
        a6 = a5;
        if (a6.b < 0) {
            throw new oV(px_0.BESSEL_FUNCTION_BAD_ARGUMENT, d3, d4);
        }
        a6 = a5;
        a6 = a5;
        if (BY.w(a3.a[a2.b - 1]) < 1.0E-100) {
            a6 = a5;
            return a6.a[n3];
        }
        throw new oR(px_0.BESSEL_FUNCTION_FAILED_CONVERGENCE, d3, d4);
    }

    private static double a(double d2, double d3) {
        a a2;
        a a3;
        a a4;
        int n2 = (int)d2;
        double d4 = d2 - (double)n2;
        int n3 = n2 + 1;
        a a5 = a4 = zV.a(d3, d4, n3);
        if (a4.b >= n3) {
            a5 = a4;
            return a5.a[n2];
        }
        a5 = a4;
        if (a5.b < 0) {
            throw new oV(px_0.BESSEL_FUNCTION_BAD_ARGUMENT, d2, d3);
        }
        a5 = a4;
        a5 = a4;
        if (BY.w(a3.a[a2.b - 1]) < 1.0E-100) {
            a5 = a4;
            return a5.a[n2];
        }
        throw new oR(px_0.BESSEL_FUNCTION_FAILED_CONVERGENCE, d2, d3);
    }

    private static a a(double d2, double d3, int n2) {
        int n3;
        double[] dArray = new double[n2];
        int n4 = (int)d2;
        if (n2 > 0 && d2 >= 0.0 && d2 <= 10000.0 && d3 >= 0.0 && d3 < 1.0) {
            n3 = n2;
            for (int i2 = 0; i2 < n2; ++i2) {
                dArray[i2] = 0.0;
            }
            if (d2 < 1.0E-4) {
                double d4 = 1.0;
                double d5 = d3 + 1.0;
                double d6 = 0.0;
                if (d2 > 8.9E-308) {
                    d6 = d2 * 0.5;
                }
                if (d3 != 0.0) {
                    double d7 = d3;
                    d4 = BY.a(d6, d3) / (d7 * zY.d(d7));
                }
                double d8 = 0.0;
                if (d2 + 1.0 > 1.0) {
                    d8 = -d6 * d6;
                }
                double d9 = d4;
                dArray[0] = d9 + d9 * d8 / d5;
                if (d2 != 0.0 && dArray[0] == 0.0) {
                    n3 = 0;
                }
                if (n2 != 1) {
                    if (d2 <= 0.0) {
                        for (int i3 = 1; i3 < n2; ++i3) {
                            dArray[i3] = 0.0;
                        }
                    } else {
                        double d10 = d6;
                        double d11 = d8 != 0.0 ? 8.9E-308 / d8 : 1.78E-307 / d2;
                        for (int i4 = 1; i4 < n2; ++i4) {
                            double d12;
                            d4 /= d5;
                            d5 += 1.0;
                            d4 *= d10;
                            if (d12 <= d11 * d5) {
                                d4 = 0.0;
                            }
                            double d13 = d4;
                            dArray[i4] = d13 + d13 * d8 / d5;
                            if (dArray[i4] != 0.0 || n3 <= i4) continue;
                            n3 = i4;
                        }
                    }
                }
            } else if (d2 > 25.0 && n2 <= n4 + 1) {
                double d14 = BY.a(0.6366197723675814 / d2);
                double d15 = 0.125 / d2;
                double d16 = d15 * d15;
                int n5 = d2 >= 130.0 ? 4 : (d2 >= 35.0 ? 8 : 11);
                double d17 = 4.0 * (double)n5;
                double d18 = (int)(d2 / (Math.PI * 2) + 0.5);
                double d19 = d2 - d18 * 6.28125 - d18 * 0.001935307179586477 - (d3 + 0.5) / 0.6366197723675814;
                double d20 = BY.n(d19);
                double d21 = BY.o(d19);
                double d22 = d3 * 2.0;
                for (n4 = 1; n4 <= 2; ++n4) {
                    double d23 = (d17 - 1.0 - d22) * (d17 - 1.0 + d22) * d16 * 0.5;
                    d18 = (d22 - (d17 - 3.0)) * (d22 + (d17 - 3.0));
                    double d24 = d23 * d18 / k[2 * n5];
                    double d25 = (d22 - (d17 + 1.0)) * (d22 + (d17 + 1.0));
                    double d26 = d23 * d25 / k[2 * n5 + 1];
                    double d27 = d17;
                    int n6 = 2 * n5;
                    d25 = d18;
                    for (int i5 = 2; i5 <= n5; ++i5) {
                        d23 = ((d27 -= 4.0) - 1.0 - d22) * (d27 - 1.0 + d22);
                        d18 = (d22 - (d27 - 3.0)) * (d22 + (d27 - 3.0));
                        d24 = (d24 + 1.0 / k[n6 - 2]) * d23 * d18 * d16;
                        d26 = (d26 + 1.0 / k[n6 - 1]) * d23 * d25 * d16;
                        n6 -= 2;
                        d25 = d18;
                    }
                    double d28 = d22;
                    d26 = (d26 + 1.0) * (d28 * d28 - 1.0) * (0.125 / d2);
                    dArray[n4 - 1] = d14 * ((d24 += 1.0) * d21 - d26 * d20);
                    if (n2 == 1) {
                        return new a(ch_0.a(dArray, dArray.length), n3);
                    }
                    d18 = d20;
                    d20 = -d21;
                    d21 = d18;
                    d22 += 2.0;
                }
                if (n2 > 2) {
                    d22 = d3 * 2.0 + 2.0;
                    for (n4 = 2; n4 < n2; ++n4) {
                        dArray[n4] = d22 * dArray[n4 - 1] / d2 - dArray[n4 - 2];
                        d22 += 2.0;
                    }
                }
            } else {
                int n7;
                int n8;
                double d29;
                double d30;
                int n9;
                int n10 = n2 - n4;
                int n11 = n4 + 1;
                double d31 = 2.0 * ((double)n11 + d3);
                double d32 = 1.0;
                double d33 = d31 / d2;
                double d34 = 2.0E16;
                boolean bl = false;
                if (n10 >= 3) {
                    int n12 = n4 + 2;
                    n9 = n2 - 1;
                    d31 = 2.0 * ((double)(n12 - 1) + d3);
                    int n13 = n12;
                    while (n13 <= n9) {
                        double d35;
                        n11 = n13++;
                        d30 = d32;
                        d32 = d33;
                        d33 = (d31 += 2.0) * d32 / d2 - d30;
                        if (!(d35 > 1.0E292)) continue;
                        double d36 = d33 /= 1.0E308;
                        double d37 = d32 /= 1.0E308;
                        n12 = n11 + 1;
                        do {
                            ++n11;
                        } while ((d33 = (d31 += 2.0) * (d32 = d33) / d2 - (d30 = d32)) <= 1.0);
                        double d38 = d29 = d31 / d2;
                        d34 = d30 * d32 * (0.5 - 0.5 / (d38 * d38));
                        d34 /= 1.0E16;
                        d33 = d32 * 1.0E308;
                        d31 -= 2.0;
                        n9 = BY.a(n2, --n11);
                        for (n8 = n12; n8 <= n9 && !((d36 = d31 * (d37 = d36) / d2 - (d30 = d37)) * d37 > d34); ++n8) {
                        }
                        n3 = n9;
                        bl = true;
                        break;
                    }
                    if (!bl) {
                        n11 = n9;
                        d31 = 2.0 * ((double)n11 + d3);
                        d34 = BY.e(d34, BY.a(d32 * 1.0E16) * BY.a(d33 * 2.0));
                    }
                }
                if (!bl) {
                    do {
                        ++n11;
                    } while ((d33 = (d31 += 2.0) * (d32 = d33) / d2 - (d30 = d32)) < d34);
                }
                d31 += 2.0;
                d29 = 0.0;
                double d39 = 1.0 / d33;
                int n14 = 2 * ++n11 - 4 * (n11 / 2);
                double d40 = 0.0;
                double d41 = n11 / 2;
                double d42 = d41 - 1.0 + d3;
                double d43 = d41 * 2.0 + d3;
                if (n14 != 0) {
                    d40 = d39 * d42 * d43 / d41;
                }
                n9 = n11 - n2;
                n8 = 0;
                boolean bl2 = false;
                for (n7 = 1; n7 <= n9; ++n7) {
                    --n11;
                    double d44 = d29;
                    d29 = d39;
                    d39 = (d31 -= 2.0) * d29 / d2 - d44;
                    if ((n14 = 2 - n14) == 0) continue;
                    d43 = (d41 -= 1.0) * 2.0 + d3;
                    if (n11 == 1) break;
                    d42 = d41 - 1.0 + d3;
                    if (d42 == 0.0) {
                        d42 = 1.0;
                    }
                    d40 = (d40 + d39 * d43) * d42 / d41;
                }
                dArray[n11 - 1] = d39;
                if (n9 >= 0) {
                    if (n2 <= 1) {
                        d43 = d3;
                        if (d3 + 1.0 == 1.0) {
                            d43 = 1.0;
                        }
                        d40 += dArray[0] * d43;
                        n8 = 1;
                    } else {
                        dArray[--n11 - 1] = (d31 -= 2.0) * d39 / d2 - d29;
                        if (n11 == 1) {
                            bl2 = true;
                        } else if ((n14 = 2 - n14) != 0) {
                            d43 = (d41 -= 1.0) * 2.0 + d3;
                            d42 = d41 - 1.0 + d3;
                            if (d42 == 0.0) {
                                d42 = 1.0;
                            }
                            d40 = (d40 + dArray[n11 - 1] * d43) * d42 / d41;
                        }
                    }
                }
                if (n8 == 0 && !bl2 && (n9 = n11 - 2) != 0) {
                    for (n7 = 1; n7 <= n9; ++n7) {
                        dArray[--n11 - 1] = (d31 -= 2.0) * dArray[n11] / d2 - dArray[n11 + 1];
                        if ((n14 = 2 - n14) == 0) continue;
                        d43 = (d41 -= 1.0) * 2.0 + d3;
                        d42 = d41 - 1.0 + d3;
                        if (d42 == 0.0) {
                            d42 = 1.0;
                        }
                        d40 = (d40 + dArray[n11 - 1] * d43) * d42 / d41;
                    }
                }
                if (n8 == 0) {
                    if (!bl2) {
                        dArray[0] = 2.0 * (d3 + 1.0) * dArray[1] / d2 - dArray[2];
                    }
                    if ((d43 = (d41 -= 1.0) * 2.0 + d3) == 0.0) {
                        d43 = 1.0;
                    }
                    d40 += dArray[0] * d43;
                }
                if (BY.w(d3) > 1.0E-16) {
                    d40 *= zY.d(d3) * BY.a(d2 * 0.5, -d3);
                }
                d39 = 8.9E-308;
                if (d40 > 1.0) {
                    d39 = d40 * 8.9E-308;
                }
                n11 = 0;
                while (n11 < n2) {
                    if (BY.w(dArray[n11]) < d39) {
                        dArray[n11] = 0.0;
                    }
                    int n15 = n11++;
                    dArray[n15] = dArray[n15] / d40;
                }
            }
        } else {
            if (dArray.length > 0) {
                dArray[0] = 0.0;
            }
            n3 = BY.a(n2, 0) - 1;
        }
        return new a(ch_0.a(dArray, dArray.length), n3);
    }

    public static final class a {
        final double[] a;
        final int b;

        public a(double[] dArray, int n2) {
            this.a = ch_0.a(dArray, dArray.length);
            this.b = n2;
        }

        private double[] a() {
            return ch_0.a(this.a, this.a.length);
        }

        private int b() {
            return this.b;
        }

        static /* synthetic */ int a(a a2) {
            return a2.b;
        }

        static /* synthetic */ double[] b(a a2) {
            return a2.a;
        }
    }
}

