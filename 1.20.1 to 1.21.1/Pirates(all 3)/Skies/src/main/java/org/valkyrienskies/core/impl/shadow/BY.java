/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.PrintStream;
import org.valkyrienskies.core.impl.shadow.BZ;
import org.valkyrienskies.core.impl.shadow.ca_0;
import org.valkyrienskies.core.impl.shadow.cq_0;
import org.valkyrienskies.core.impl.shadow.oU;
import org.valkyrienskies.core.impl.shadow.px_0;

public final class BY {
    private static double a = Math.PI;
    private static double b = Math.E;
    private static int c = 750;
    private static int d = 1500;
    private static int e = 1024;
    private static int f = 1025;
    private static final double g = StrictMath.log(Double.MAX_VALUE);
    private static final boolean h = false;
    private static final double i = 0.6931470632553101;
    private static final double j = 1.1730463525082348E-7;
    private static final double[][] k = new double[][]{{1.0, 5.669184079525E-24}, {-0.25, -0.25}, {0.3333333134651184, 1.986821492305628E-8}, {-0.25, -6.663542893624021E-14}, {0.19999998807907104, 1.1921056801463227E-8}, {-0.1666666567325592, -7.800414592973399E-9}, {0.1428571343421936, 5.650007086920087E-9}, {-0.1250253f, -7.44321345601866E-11}, {0.11113807559013367, 9.219544613762692E-9}};
    private static final double[][] l = new double[][]{{1.0, -6.032174644509064E-23}, {-0.25, -0.25}, {0.3333333134651184, 1.9868161777724352E-8}, {-0.2499999701976776, -2.957007209750105E-8}, {0.19999954104423523, 1.5830993332061267E-10}, {-0.1662488f, -2.6033824355191673E-8}};
    private static final int m = 14;
    private static final double[] n = new double[]{0.0, 0.1246747374534607, 0.24740394949913025, 0.366272509098053, 0.4794255495071411, 0.5850973129272461, 0.6816387176513672, 0.7675435543060303, 0.8414709568023682, 0.902267575263977, 0.9489846229553223, 0.980893f, 0.9974949359893799, 0.9985313415527344};
    private static final double[] o = new double[]{0.0, -4.068233003401932E-9, 9.755392680573412E-9, 1.9987994582857286E-8, -1.0902938113007961E-8, -3.9986783938944604E-8, 4.23719669792332E-8, -5.207000323380292E-8, 2.800552834259E-8, 1.883511811213715E-8, -3.5997360512765566E-9, 4.116164446561962E-8, 5.0614674548127384E-8, -1.0129027912496858E-9};
    private static final double[] p = new double[]{1.0, 0.9921976327896118, 0.9689123630523682, 0.9305076599121094, 0.8775825500488281, 0.8109631538391113, 0.7316888570785522, 0.6409968137741089, 0.5403022766113281, 0.4311765432357788, 0.3153223395347595, 0.19454771280288696, 0.0707372f, -0.05417713522911072};
    private static final double[] q = new double[]{0.0, 3.4439717236742845E-8, 5.865827662008209E-8, -3.7999795083850525E-8, 1.184154459111628E-8, -3.43338934259355E-8, 1.1795268640216787E-8, 4.438921624363781E-8, 2.925681159240093E-8, -2.6437112632041807E-8, 2.2860509143963117E-8, -4.813899778443457E-9, 3.6725170580355583E-9, 2.0217439756338078E-10};
    private static final double[] r = new double[]{0.0, 0.1256551444530487, 0.25534194707870483, 0.3936265707015991, 0.5463024377822876, 0.7214844226837158, 0.9315965175628662, 1.1974215507507324, 1.5574076175689697, 2.092571258544922, 3.0095696449279785, 5.041914939880371, 14.101419448852539, -18.430862426757812};
    private static final double[] s = new double[]{0.0, -7.877917738262007E-9, -2.5857668567479893E-8, 5.2240336371356666E-9, 5.206150291559893E-8, 1.8307188599677033E-8, -5.7618793749770706E-8, 7.848361555046424E-8, 1.0708593250394448E-7, 1.7827257129423813E-8, 2.893485277253286E-8, 3.1660099222737955E-7, 4.983191803254889E-7, -3.356118100840571E-7};
    private static final long[] t = new long[]{2935890503282001226L, 9154082963658192752L, 3952090531849364496L, 9193070505571053912L, 7910884519577875640L, 113236205062349959L, 4577762542105553359L, -5034868814120038111L, 4208363204685324176L, 5648769086999809661L, 2819561105158720014L, -4035746434778044925L, -302932621132653753L, -2644281811660520851L, -3183605296591799669L, 6722166367014452318L, -3512299194304650054L, -7278142539171889152L};
    private static final long[] u = new long[]{-3958705157555305932L, -4267615245585081135L};
    private static final double[] v = new double[]{0.0, 0.125, 0.25, 0.375, 0.5, 0.625, 0.75, 0.875, 1.0, 1.125, 1.25, 1.375, 1.5, 1.625};
    private static final double[] w = new double[]{0.6299605249474366, 0.7937005259840998, 1.0, 1.2599210498948732, 1.5874010519681994};
    private static final long x = 0x40000000L;
    private static final long y = -1073741824L;
    private static final int z = Integer.MAX_VALUE;
    private static final long A = Long.MAX_VALUE;
    private static final long B = 0x7FF0000000000000L;
    private static final long C = 0xFFFFFFFFFFFFFL;
    private static final long D = 0x10000000000000L;
    private static final double E = 4.503599627370496E15;
    private static final double F = 0.3333333333333333;
    private static final double G = 0.2;
    private static final double H = 0.14285714285714285;
    private static final double I = 0.1111111111111111;
    private static final double J = 0.09090909090909091;
    private static final double K = 0.07692307692307693;
    private static final double L = 0.06666666666666667;
    private static final double M = 0.058823529411764705;
    private static final double N = 0.75;
    private static final double O = 0.9375;
    private static final double P = 0.9285714285714286;
    private static final double Q = 0.9166666666666666;
    private static final double R = 0.9;
    private static final double S = 0.875;
    private static final double T = 0.8333333333333334;
    private static final double U = 0.5;
    private static final double V = 0.25;

    private BY() {
    }

    private static double D(double d2) {
        if (d2 > -cq_0.b && d2 < cq_0.b) {
            return d2;
        }
        long l2 = Double.doubleToRawLongBits(d2);
        return Double.longBitsToDouble(l2 &= 0xFFFFFFFFC0000000L);
    }

    public static double a(double d2) {
        return Math.sqrt(d2);
    }

    public static double b(double d2) {
        double d3 = d2;
        if (d3 != d3) {
            return d2;
        }
        if (d2 > 20.0) {
            if (d2 >= g) {
                double d4 = d2 * 0.5;
                double d5 = BY.a(d4, 0.0, null);
                return d5 * 0.5 * d5;
            }
            double d6 = d2;
            return 0.5 * BY.a(d6, 0.0, null);
        }
        if (d2 < -20.0) {
            if (d2 <= -g) {
                double d7 = d2 * -0.5;
                double d8 = BY.a(d7, 0.0, null);
                return d8 * 0.5 * d8;
            }
            double d9 = -d2;
            return 0.5 * BY.a(d9, 0.0, null);
        }
        double[] dArray = new double[2];
        if (d2 < 0.0) {
            d2 = -d2;
        }
        BY.a(d2, 0.0, dArray);
        double d10 = dArray[0] + dArray[1];
        double d11 = -(d10 - dArray[0] - dArray[1]);
        double d12 = d10 * 1.073741824E9;
        double d13 = d10 + d12 - d12;
        double d14 = d10 - d13;
        double d15 = 1.0 / d10;
        d12 = d15 * 1.073741824E9;
        double d16 = d15 + d12 - d12;
        double d17 = d15 - d16;
        d17 += (1.0 - d13 * d16 - d13 * d17 - d14 * d16 - d14 * d17) * d15;
        d17 += -d11 * d15 * d15;
        d12 = d10 + d16;
        d11 -= d12 - d10 - d16;
        d10 = d12;
        d12 = d10 + d17;
        d11 -= d12 - d10 - d17;
        d10 = d12;
        double d18 = d10 + d11;
        return d18 *= 0.5;
    }

    public static double c(double d2) {
        double d3;
        boolean bl = false;
        double d4 = d2;
        if (d4 != d4) {
            return d2;
        }
        if (d2 > 20.0) {
            if (d2 >= g) {
                double d5 = d2 * 0.5;
                double d6 = BY.a(d5, 0.0, null);
                return d6 * 0.5 * d6;
            }
            double d7 = d2;
            return 0.5 * BY.a(d7, 0.0, null);
        }
        if (d2 < -20.0) {
            if (d2 <= -g) {
                double d8 = d2 * -0.5;
                double d9 = BY.a(d8, 0.0, null);
                return d9 * -0.5 * d9;
            }
            double d10 = -d2;
            return -0.5 * BY.a(d10, 0.0, null);
        }
        if (d2 == 0.0) {
            return d2;
        }
        if (d2 < 0.0) {
            d2 = -d2;
            bl = true;
        }
        if (d2 > 0.25) {
            double[] dArray = new double[2];
            BY.a(d2, 0.0, dArray);
            double d11 = dArray[0] + dArray[1];
            double d12 = -(d11 - dArray[0] - dArray[1]);
            double d13 = d11 * 1.073741824E9;
            double d14 = d11 + d13 - d13;
            double d15 = d11 - d14;
            double d16 = 1.0 / d11;
            d13 = d16 * 1.073741824E9;
            double d17 = d16 + d13 - d13;
            double d18 = d16 - d17;
            d18 += (1.0 - d14 * d17 - d14 * d18 - d15 * d17 - d15 * d18) * d16;
            d18 += -d12 * d16 * d16;
            d17 = -d17;
            d18 = -d18;
            d13 = d11 + d17;
            d12 -= d13 - d11 - d17;
            d11 = d13;
            d13 = d11 + d18;
            d12 -= d13 - d11 - d18;
            d11 = d13;
            d3 = d11 + d12;
            d3 *= 0.5;
        } else {
            double[] dArray = new double[2];
            BY.a(d2, dArray);
            double d19 = dArray[0] + dArray[1];
            double d20 = -(d19 - dArray[0] - dArray[1]);
            double d21 = d19 + 1.0;
            double d22 = 1.0 / d21;
            double d23 = -(d21 - 1.0 - d19) + d20;
            double d24 = d19 * d22;
            double d25 = d24 * 1.073741824E9;
            double d26 = d24 + d25 - d25;
            double d27 = d24 - d26;
            d25 = d21 * 1.073741824E9;
            double d28 = d21 + d25 - d25;
            double d29 = d21 - d28;
            d27 += (d19 - d28 * d26 - d28 * d27 - d29 * d26 - d29 * d27) * d22;
            d27 += d20 * d22;
            d27 += -d19 * d23 * d22 * d22;
            d25 = d19 + d26;
            d20 -= d25 - d19 - d26;
            d19 = d25;
            d25 = d19 + d27;
            d20 -= d25 - d19 - d27;
            d19 = d25;
            d3 = d19 + d20;
            d3 *= 0.5;
        }
        if (bl) {
            d3 = -d3;
        }
        return d3;
    }

    public static double d(double d2) {
        double d3;
        boolean bl = false;
        double d4 = d2;
        if (d4 != d4) {
            return d2;
        }
        if (d2 > 20.0) {
            return 1.0;
        }
        if (d2 < -20.0) {
            return -1.0;
        }
        if (d2 == 0.0) {
            return d2;
        }
        if (d2 < 0.0) {
            d2 = -d2;
            bl = true;
        }
        if (d2 >= 0.5) {
            double[] dArray = new double[2];
            BY.a(d2 * 2.0, 0.0, dArray);
            double d5 = dArray[0] + dArray[1];
            double d6 = -(d5 - dArray[0] - dArray[1]);
            double d7 = d5 + -1.0;
            double d8 = -(d7 + 1.0 - d5);
            double d9 = d7 + d6;
            d8 -= d9 - d7 - d6;
            d7 = d9;
            double d10 = d5 + 1.0;
            double d11 = -(d10 - 1.0 - d5);
            d9 = d10 + d6;
            d11 -= d9 - d10 - d6;
            d10 = d9;
            d9 = d10 * 1.073741824E9;
            double d12 = d10 + d9 - d9;
            double d13 = d10 - d12;
            double d14 = d7 / d10;
            d9 = d14 * 1.073741824E9;
            double d15 = d14 + d9 - d9;
            double d16 = d14 - d15;
            d16 += (d7 - d12 * d15 - d12 * d16 - d13 * d15 - d13 * d16) / d10;
            d16 += d8 / d10;
            d3 = d15 + (d16 += -d11 * d7 / d10 / d10);
        } else {
            double[] dArray = new double[2];
            BY.a(d2 * 2.0, dArray);
            double d17 = dArray[0] + dArray[1];
            double d18 = -(d17 - dArray[0] - dArray[1]);
            double d19 = d17;
            double d20 = d18;
            double d21 = d17 + 2.0;
            double d22 = -(d21 - 2.0 - d17);
            double d23 = d21 + d18;
            d22 -= d23 - d21 - d18;
            d21 = d23;
            d23 = d21 * 1.073741824E9;
            double d24 = d21 + d23 - d23;
            double d25 = d21 - d24;
            double d26 = d19 / d21;
            d23 = d26 * 1.073741824E9;
            double d27 = d26 + d23 - d23;
            double d28 = d26 - d27;
            d28 += (d19 - d24 * d27 - d24 * d28 - d25 * d27 - d25 * d28) / d21;
            d28 += d20 / d21;
            d3 = d27 + (d28 += -d22 * d19 / d21 / d21);
        }
        if (bl) {
            d3 = -d3;
        }
        return d3;
    }

    public static double e(double d2) {
        double d3 = d2;
        double d4 = d3 * d2 - 1.0;
        d4 = d3 + Math.sqrt(d4);
        return BY.b(d4, null);
    }

    public static double f(double d2) {
        double d3;
        boolean bl = false;
        if (d2 < 0.0) {
            bl = true;
            d2 = -d2;
        }
        if (d2 > 0.167) {
            double d4 = d2;
            double d5 = d4 * d4 + 1.0;
            d5 = Math.sqrt(d5) + d2;
            d3 = BY.b(d5, null);
        } else {
            double d6 = d2;
            double d7 = d6 * d6;
            d3 = d2 > 0.097 ? d2 * (1.0 - d7 * (0.3333333333333333 - d7 * (0.2 - d7 * (0.14285714285714285 - d7 * (0.1111111111111111 - d7 * (0.09090909090909091 - d7 * (0.07692307692307693 - d7 * (0.06666666666666667 - d7 * 0.058823529411764705 * 0.9375) * 0.9285714285714286) * 0.9166666666666666) * 0.9) * 0.875) * 0.8333333333333334) * 0.75) * 0.5) : (d2 > 0.036 ? d2 * (1.0 - d7 * (0.3333333333333333 - d7 * (0.2 - d7 * (0.14285714285714285 - d7 * (0.1111111111111111 - d7 * (0.09090909090909091 - d7 * 0.07692307692307693 * 0.9166666666666666) * 0.9) * 0.875) * 0.8333333333333334) * 0.75) * 0.5) : (d2 > 0.0036 ? d2 * (1.0 - d7 * (0.3333333333333333 - d7 * (0.2 - d7 * (0.14285714285714285 - d7 * 0.1111111111111111 * 0.875) * 0.8333333333333334) * 0.75) * 0.5) : d2 * (1.0 - d7 * (0.3333333333333333 - d7 * 0.2 * 0.75) * 0.5)));
        }
        if (bl) {
            return -d3;
        }
        return d3;
    }

    public static double g(double d2) {
        double d3;
        boolean bl = false;
        if (d2 < 0.0) {
            bl = true;
            d2 = -d2;
        }
        if (d2 > 0.15) {
            double d4 = (d2 + 1.0) / (1.0 - d2);
            d3 = 0.5 * BY.b(d4, null);
        } else {
            double d5 = d2;
            double d6 = d5 * d5;
            d3 = d2 > 0.087 ? d2 * (1.0 + d6 * (0.3333333333333333 + d6 * (0.2 + d6 * (0.14285714285714285 + d6 * (0.1111111111111111 + d6 * (0.09090909090909091 + d6 * (0.07692307692307693 + d6 * (0.06666666666666667 + d6 * 0.058823529411764705)))))))) : (d2 > 0.031 ? d2 * (1.0 + d6 * (0.3333333333333333 + d6 * (0.2 + d6 * (0.14285714285714285 + d6 * (0.1111111111111111 + d6 * (0.09090909090909091 + d6 * 0.07692307692307693)))))) : (d2 > 0.003 ? d2 * (1.0 + d6 * (0.3333333333333333 + d6 * (0.2 + d6 * (0.14285714285714285 + d6 * 0.1111111111111111)))) : d2 * (1.0 + d6 * (0.3333333333333333 + d6 * 0.2))));
        }
        if (bl) {
            return -d3;
        }
        return d3;
    }

    public static double h(double d2) {
        if (d2 < 0.0) {
            return -1.0;
        }
        if (d2 > 0.0) {
            return 1.0;
        }
        return d2;
    }

    private static float c(float f2) {
        if (f2 < 0.0f) {
            return -1.0f;
        }
        if (f2 > 0.0f) {
            return 1.0f;
        }
        return f2;
    }

    private static double E(double d2) {
        return BY.c(d2, Double.POSITIVE_INFINITY);
    }

    private static float d(float f2) {
        return BY.a(f2, Double.POSITIVE_INFINITY);
    }

    private static double F(double d2) {
        return BY.c(d2, Double.NEGATIVE_INFINITY);
    }

    private static float e(float f2) {
        return BY.a(f2, Double.NEGATIVE_INFINITY);
    }

    public static double a() {
        return Math.random();
    }

    public static double i(double d2) {
        return BY.a(d2, 0.0, null);
    }

    private static double a(double d2, double d3, double[] dArray) {
        int n2 = (int)d2;
        if (d2 < 0.0) {
            if (d2 < -746.0) {
                if (dArray != null) {
                    dArray[0] = 0.0;
                    dArray[1] = 0.0;
                }
                return 0.0;
            }
            if (n2 < -709) {
                double d4 = BY.a(d2 + 40.19140625, d3, dArray) / 2.8504009514401178E17;
                if (dArray != null) {
                    dArray[0] = dArray[0] / 2.8504009514401178E17;
                    dArray[1] = dArray[1] / 2.8504009514401178E17;
                }
                return d4;
            }
            if (n2 == -709) {
                double d5 = BY.a(d2 + 1.494140625, d3, dArray) / 4.455505956692757;
                if (dArray != null) {
                    dArray[0] = dArray[0] / 4.455505956692757;
                    dArray[1] = dArray[1] / 4.455505956692757;
                }
                return d5;
            }
            --n2;
        } else if (n2 > 709) {
            if (dArray != null) {
                dArray[0] = Double.POSITIVE_INFINITY;
                dArray[1] = 0.0;
            }
            return Double.POSITIVE_INFINITY;
        }
        double d6 = org.valkyrienskies.core.impl.shadow.BY$c.a[n2 + 750];
        double d7 = org.valkyrienskies.core.impl.shadow.BY$c.b[n2 + 750];
        int n3 = (int)((d2 - (double)n2) * 1024.0);
        double d8 = org.valkyrienskies.core.impl.shadow.BY$b.a[n3];
        double d9 = org.valkyrienskies.core.impl.shadow.BY$b.b[n3];
        double d10 = d2 - ((double)n2 + (double)n3 / 1024.0);
        double d11 = d10 * 0.04168701738764507 + 0.1666666505023083;
        d11 = d11 * d10 + 0.5000000000042687;
        d11 = d11 * d10 + 1.0;
        d11 = d11 * d10 + -3.940510424527919E-20;
        double d12 = d6 * d8;
        double d13 = d6 * d9 + d7 * d8 + d7 * d9;
        double d14 = d13 + d12;
        if (d14 == Double.POSITIVE_INFINITY) {
            return Double.POSITIVE_INFINITY;
        }
        double d15 = d3 != 0.0 ? d14 * d3 * d11 + d14 * d3 + d14 * d11 + d13 + d12 : d14 * d11 + d13 + d12;
        if (dArray != null) {
            dArray[0] = d12;
            dArray[1] = d14 * d3 * d11 + d14 * d3 + d14 * d11 + d13;
        }
        return d15;
    }

    public static double j(double d2) {
        return BY.a(d2, null);
    }

    private static double a(double d2, double[] dArray) {
        double d3 = d2;
        if (d3 != d3 || d2 == 0.0) {
            return d2;
        }
        if (d2 <= -1.0 || d2 >= 1.0) {
            double[] dArray2 = new double[2];
            BY.a(d2, 0.0, dArray2);
            if (d2 > 0.0) {
                return -1.0 + dArray2[0] + dArray2[1];
            }
            double d4 = -1.0 + dArray2[0];
            double d5 = -(d4 + 1.0 - dArray2[0]);
            return d4 + (d5 += dArray2[1]);
        }
        boolean bl = false;
        if (d2 < 0.0) {
            d2 = -d2;
            bl = true;
        }
        int n2 = (int)(d2 * 1024.0);
        double d6 = org.valkyrienskies.core.impl.shadow.BY$b.a[n2] - 1.0;
        double d7 = org.valkyrienskies.core.impl.shadow.BY$b.b[n2];
        double d8 = d6 + d7;
        d7 = -(d8 - d6 - d7);
        d6 = d8;
        d8 = d6 * 1.073741824E9;
        double d9 = d6 + d8 - d8;
        double d10 = d7 + (d6 - d9);
        double d11 = d2 - (double)n2 / 1024.0;
        double d12 = d11 * 0.008336750013465571 + 0.041666663879186654;
        d12 = d12 * d11 + 0.16666666666745392;
        d12 = d12 * d11 + 0.49999999999999994;
        d12 *= d11;
        double d13 = d11;
        double d14 = d13 + (d12 *= d11);
        d12 = -(d14 - d13 - d12);
        d13 = d14;
        d14 = d13 * 1.073741824E9;
        d14 = d13 + d14 - d14;
        d12 += d13 - d14;
        d13 = d14;
        double d15 = d13 * d9;
        d14 = d15 + d13 * d10;
        double d16 = -(d14 - d15 - d13 * d10);
        d15 = d14;
        d14 = d15 + d12 * d9;
        d16 -= d14 - d15 - d12 * d9;
        d15 = d14;
        d14 = d15 + d12 * d10;
        d16 -= d14 - d15 - d12 * d10;
        d15 = d14;
        d14 = d15 + d9;
        d16 -= d14 - d9 - d15;
        d15 = d14;
        d14 = d15 + d13;
        d16 -= d14 - d15 - d13;
        d15 = d14;
        d14 = d15 + d10;
        d16 -= d14 - d15 - d10;
        d15 = d14;
        d14 = d15 + d12;
        d16 -= d14 - d15 - d12;
        d15 = d14;
        if (bl) {
            double d17 = d15 + 1.0;
            double d18 = 1.0 / d17;
            double d19 = -(d17 - 1.0 - d15) + d16;
            double d20 = d15 * d18;
            d14 = d20 * 1.073741824E9;
            double d21 = d20 + d14 - d14;
            double d22 = d20 - d21;
            d14 = d17 * 1.073741824E9;
            d13 = d17 + d14 - d14;
            d12 = d17 - d13;
            d22 += (d15 - d13 * d21 - d13 * d22 - d12 * d21 - d12 * d22) * d18;
            d22 += d16 * d18;
            d22 += -d15 * d19 * d18 * d18;
            d15 = -d21;
            d16 = -d22;
        }
        if (dArray != null) {
            dArray[0] = d15;
            dArray[1] = d16;
        }
        return d15 + d16;
    }

    public static double k(double d2) {
        return BY.b(d2, null);
    }

    private static double b(double d2, double[] dArray) {
        double d3;
        double d4;
        double d5;
        double d6;
        double d7;
        long l2;
        block19: {
            block18: {
                if (d2 == 0.0) {
                    return Double.NEGATIVE_INFINITY;
                }
                l2 = Double.doubleToRawLongBits(d2);
                if ((l2 & Long.MIN_VALUE) != 0L) break block18;
                double d8 = d2;
                if (d8 == d8) break block19;
            }
            if (d2 != 0.0) {
                if (dArray != null) {
                    dArray[0] = Double.NaN;
                }
                return Double.NaN;
            }
        }
        if (d2 == Double.POSITIVE_INFINITY) {
            if (dArray != null) {
                dArray[0] = Double.POSITIVE_INFINITY;
            }
            return Double.POSITIVE_INFINITY;
        }
        int n2 = (int)(l2 >> 52) - 1023;
        if ((l2 & 0x7FF0000000000000L) == 0L) {
            if (d2 == 0.0) {
                if (dArray != null) {
                    dArray[0] = Double.NEGATIVE_INFINITY;
                }
                return Double.NEGATIVE_INFINITY;
            }
            while (((l2 <<= 1) & 0x10000000000000L) == 0L) {
                --n2;
            }
        }
        if ((n2 == -1 || n2 == 0) && d2 < 1.01 && d2 > 0.99 && dArray == null) {
            double d9 = d2 - 1.0;
            double d10 = d9 * 1.073741824E9;
            double d11 = d9 + d10 - d10;
            double d12 = d9 - d11;
            d9 = d11;
            double d13 = d12;
            double[] dArray2 = k[k.length - 1];
            double d14 = dArray2[0];
            double d15 = dArray2[1];
            for (int i2 = k.length - 2; i2 >= 0; --i2) {
                d11 = d14 * d9;
                d12 = d14 * d13 + d15 * d9 + d15 * d13;
                d10 = d11 * 1.073741824E9;
                d14 = d11 + d10 - d10;
                d15 = d11 - d14 + d12;
                double[] dArray3 = k[i2];
                d11 = d14 + dArray3[0];
                d12 = d15 + dArray3[1];
                d10 = d11 * 1.073741824E9;
                d14 = d11 + d10 - d10;
                d15 = d11 - d14 + d12;
            }
            d11 = d14 * d9;
            d12 = d14 * d13 + d15 * d9 + d15 * d13;
            d10 = d11 * 1.073741824E9;
            d14 = d11 + d10 - d10;
            d15 = d11 - d14 + d12;
            return d14 + d15;
        }
        double[] dArray4 = org.valkyrienskies.core.impl.shadow.BY$e.a[(int)((l2 & 0xFFC0000000000L) >> 42)];
        double d16 = (double)(l2 & 0x3FFFFFFFFFFL) / (4.503599627370496E15 + (double)(l2 & 0xFFC0000000000L));
        double d17 = 0.0;
        if (dArray != null) {
            d7 = d16 * 1.073741824E9;
            d6 = d16 + d7 - d7;
            d5 = d16 - d6;
            d4 = d6;
            double d18 = d5;
            double d19 = l2 & 0x3FFFFFFFFFFL;
            double d20 = 4.503599627370496E15 + (double)(l2 & 0xFFC0000000000L);
            d6 = d19 - d4 * d20 - d18 * d20;
            d18 += d6 / d20;
            double[] dArray5 = l[l.length - 1];
            double d21 = dArray5[0];
            double d22 = dArray5[1];
            for (int i3 = l.length - 2; i3 >= 0; --i3) {
                d6 = d21 * d4;
                d5 = d21 * d18 + d22 * d4 + d22 * d18;
                d7 = d6 * 1.073741824E9;
                d21 = d6 + d7 - d7;
                d22 = d6 - d21 + d5;
                double[] dArray6 = l[i3];
                d6 = d21 + dArray6[0];
                d5 = d22 + dArray6[1];
                d7 = d6 * 1.073741824E9;
                d21 = d6 + d7 - d7;
                d22 = d6 - d21 + d5;
            }
            d6 = d21 * d4;
            d5 = d21 * d18 + d22 * d4 + d22 * d18;
            d3 = d6 + d5;
            d17 = -(d3 - d6 - d5);
        } else {
            d3 = d16 * -0.16624882440418567 + 0.19999954120254515;
            d3 = d3 * d16 + -0.2499999997677497;
            d3 = d3 * d16 + 0.3333333333332802;
            d3 = d3 * d16 + -0.5;
            d3 = d3 * d16 + 1.0;
            d3 *= d16;
        }
        d7 = 0.6931470632553101 * (double)n2;
        d5 = d7 + dArray4[0];
        d4 = -(d5 - d7 - dArray4[0]);
        d7 = d5;
        d6 = d4 + 0.0;
        d5 = d7 + d3;
        d4 = -(d5 - d7 - d3);
        d7 = d5;
        d6 += d4;
        d5 = d7 + 1.1730463525082348E-7 * (double)n2;
        d4 = -(d5 - d7 - 1.1730463525082348E-7 * (double)n2);
        d7 = d5;
        d6 += d4;
        d5 = d7 + dArray4[1];
        d4 = -(d5 - d7 - dArray4[1]);
        d7 = d5;
        d6 += d4;
        d5 = d7 + d17;
        d4 = -(d5 - d7 - d17);
        d7 = d5;
        d6 += d4;
        if (dArray != null) {
            dArray[0] = d7;
            dArray[1] = d6;
        }
        return d7 + d6;
    }

    public static double l(double d2) {
        if (d2 == -1.0) {
            return Double.NEGATIVE_INFINITY;
        }
        if (d2 == Double.POSITIVE_INFINITY) {
            return Double.POSITIVE_INFINITY;
        }
        if (d2 > 1.0E-6 || d2 < -1.0E-6) {
            double d3 = d2 + 1.0;
            double d4 = -(d3 - 1.0 - d2);
            double[] dArray = new double[2];
            double d5 = BY.b(d3, dArray);
            if (Double.isInfinite(d5)) {
                return d5;
            }
            double d6 = d4 / d3;
            double d7 = d6 * 0.5 + 1.0;
            return d7 * d6 + dArray[1] + dArray[0];
        }
        double d8 = (d2 * 0.3333333333333333 - 0.5) * d2 + 1.0;
        return d8 * d2;
    }

    public static double m(double d2) {
        double[] dArray = new double[2];
        double d3 = BY.b(d2, dArray);
        if (Double.isInfinite(d3)) {
            return d3;
        }
        double d4 = dArray[0] * 1.073741824E9;
        double d5 = dArray[0] + d4 - d4;
        double d6 = dArray[0] - d5 + dArray[1];
        return d6 * 1.9699272335463627E-8 + d5 * 1.9699272335463627E-8 + d6 * 0.4342944622039795 + d5 * 0.4342944622039795;
    }

    private static double i(double d2, double d3) {
        double d4 = d3;
        double d5 = d4;
        d5 = d2;
        return BY.b(d4, null) / BY.b(d5, null);
    }

    public static double a(double d2, double d3) {
        if (d3 == 0.0) {
            return 1.0;
        }
        long l2 = Double.doubleToRawLongBits(d3);
        int n2 = (int)((l2 & 0x7FF0000000000000L) >> 52);
        long l3 = l2 & 0xFFFFFFFFFFFFFL;
        long l4 = Double.doubleToRawLongBits(d2);
        int n3 = (int)((l4 & 0x7FF0000000000000L) >> 52);
        long l5 = l4 & 0xFFFFFFFFFFFFFL;
        if (n2 > 1085) {
            if (n2 == 2047 && l3 != 0L || n3 == 2047 && l5 != 0L) {
                return Double.NaN;
            }
            if (n3 == 1023 && l5 == 0L) {
                if (n2 == 2047) {
                    return Double.NaN;
                }
                return 1.0;
            }
            if (d3 > 0.0 ^ n3 < 1023) {
                return Double.POSITIVE_INFINITY;
            }
            return 0.0;
        }
        if (n2 >= 1023) {
            long l6 = 0x10000000000000L | l3;
            if (n2 < 1075) {
                long l7 = -1L << 1075 - n2;
                if ((l6 & l7) == l6) {
                    long l8 = l6 >> 1075 - n2;
                    return BY.a(d2, d3 < 0.0 ? -l8 : l8);
                }
            } else {
                long l9 = l6 << n2 - 1075;
                return BY.a(d2, d3 < 0.0 ? -l9 : l9);
            }
        }
        if (d2 == 0.0) {
            if (d3 < 0.0) {
                return Double.POSITIVE_INFINITY;
            }
            return 0.0;
        }
        if (n3 == 2047) {
            if (l5 == 0L) {
                if (d3 < 0.0) {
                    return 0.0;
                }
                return Double.POSITIVE_INFINITY;
            }
            return Double.NaN;
        }
        if (d2 < 0.0) {
            return Double.NaN;
        }
        double d4 = d3 * 1.073741824E9;
        double d5 = d3 + d4 - d4;
        double d6 = d3 - d5;
        double[] dArray = new double[2];
        double d7 = BY.b(d2, dArray);
        if (Double.isInfinite(d7)) {
            return d7;
        }
        double d8 = dArray[0];
        double d9 = dArray[1];
        double d10 = d8 * 1.073741824E9;
        double d11 = d8 + d10 - d10;
        d9 += d8 - d11;
        d8 = d11;
        double d12 = d8 * d5;
        double d13 = d8 * d6 + d9 * d5 + d9 * d6;
        d8 = d12 + d13;
        d9 = -(d8 - d12 - d13);
        double d14 = d9 * 0.008333333333333333 + 0.041666666666666664;
        d14 = d14 * d9 + 0.16666666666666666;
        d14 = d14 * d9 + 0.5;
        d14 = d14 * d9 + 1.0;
        double d15 = BY.a(d8, d14 *= d9, null);
        return d15;
    }

    public static double a(double d2, int n2) {
        return BY.a(d2, (long)n2);
    }

    private static double a(double d2, long l2) {
        if (l2 == 0L) {
            return 1.0;
        }
        if (l2 > 0L) {
            return org.valkyrienskies.core.impl.shadow.BY$d.a(new d(d2), l2).d;
        }
        return org.valkyrienskies.core.impl.shadow.BY$d.a(new d(d2).a(), -l2).d;
    }

    private static double G(double d2) {
        double d3 = d2;
        double d4 = d3 * d3;
        double d5 = d4 * 2.7553817452272217E-6 + -1.9841269659586505E-4;
        d5 = d5 * d4 + 0.008333333333329196;
        d5 = d5 * d4 + -0.16666666666666666;
        d5 = d5 * d4 * d2;
        return d5;
    }

    private static double H(double d2) {
        double d3 = d2;
        double d4 = d3 * d3;
        double d5 = d4 * 2.479773539153719E-5 + -0.0013888888689039883;
        d5 = d5 * d4 + 0.041666666666621166;
        d5 = d5 * d4 + -0.49999999999999994;
        return d5 *= d4;
    }

    private static double j(double d2, double d3) {
        int n2 = (int)(d2 * 8.0 + 0.5);
        double d4 = d2 - v[n2];
        double d5 = n[n2];
        double d6 = o[n2];
        double d7 = p[n2];
        double d8 = q[n2];
        double d9 = d4;
        double d10 = BY.G(d4);
        double d11 = BY.H(d4);
        double d12 = d9 * 1.073741824E9;
        double d13 = d9 + d12 - d12;
        d10 += d9 - d13;
        d9 = d13;
        double d14 = d5;
        double d15 = d14 + 0.0;
        double d16 = -(d15 - d14);
        double d17 = d15;
        double d18 = d16 + 0.0;
        d14 = d7 * d9;
        d15 = d17 + d14;
        d16 = -(d15 - d17 - d14);
        d17 = d15;
        d18 += d16;
        d18 = d18 + d5 * d11 + d7 * d10;
        d18 = d18 + d6 + d8 * d9 + d6 * d11 + d8 * d10;
        if (d3 != 0.0) {
            d14 = ((d7 + d8) * (d11 + 1.0) - (d5 + d6) * (d9 + d10)) * d3;
            d15 = d17 + d14;
            d16 = -(d15 - d17 - d14);
            d17 = d15;
            d18 += d16;
        }
        double d19 = d17 + d18;
        return d19;
    }

    private static double k(double d2, double d3) {
        double d4 = 1.5707963267948966 - d2;
        double d5 = -(d4 - 1.5707963267948966 + d2);
        return BY.j(d4, d5 += 6.123233995736766E-17 - d3);
    }

    private static double a(double d2, double d3, boolean bl) {
        double d4;
        int n2 = (int)(d2 * 8.0 + 0.5);
        double d5 = d2 - v[n2];
        double d6 = n[n2];
        double d7 = o[n2];
        double d8 = p[n2];
        double d9 = q[n2];
        double d10 = d5;
        double d11 = BY.G(d5);
        double d12 = BY.H(d5);
        double d13 = d10 * 1.073741824E9;
        double d14 = d10 + d13 - d13;
        d11 += d10 - d14;
        d10 = d14;
        double d15 = d6;
        double d16 = d15 + 0.0;
        double d17 = -(d16 - d15);
        double d18 = d16;
        double d19 = d17 + 0.0;
        d15 = d8 * d10;
        d16 = d18 + d15;
        d17 = -(d16 - d18 - d15);
        d18 = d16;
        d19 += d17;
        d19 += d6 * d12 + d8 * d11;
        double d20 = d18 + (d19 += d7 + d9 * d10 + d7 * d12 + d9 * d11);
        double d21 = -(d20 - d18 - d19);
        d15 = d8;
        d16 = d15 + 0.0;
        d17 = -(d16 - d15);
        d18 = d16;
        d19 = d17 + 0.0;
        d15 = -d6 * d10;
        d16 = d18 + d15;
        d17 = -(d16 - d18 - d15);
        d18 = d16;
        d19 += d17;
        d19 += d9 + d8 * d12 + d9 * d12;
        double d22 = d18 + (d19 -= d7 * d10 + d6 * d11 + d7 * d11);
        double d23 = -(d22 - d18 - d19);
        if (bl) {
            d4 = d22;
            d22 = d20;
            d20 = d4;
            d4 = d23;
            d23 = d21;
            d21 = d4;
        }
        d4 = d20 / d22;
        d13 = d4 * 1.073741824E9;
        double d24 = d4 + d13 - d13;
        double d25 = d4 - d24;
        d13 = d22 * 1.073741824E9;
        double d26 = d22 + d13 - d13;
        double d27 = d22 - d26;
        double d28 = (d20 - d24 * d26 - d24 * d27 - d25 * d26 - d25 * d27) / d22;
        d28 += d21 / d22;
        d28 += -d20 * d23 / d22 / d22;
        if (d3 != 0.0) {
            double d29 = d4;
            double d30 = d3 + d29 * d29 * d3;
            if (bl) {
                d30 = -d30;
            }
            d28 += d30;
        }
        return d4 + d28;
    }

    private static void c(double d2, double[] dArray) {
        boolean bl;
        long l2;
        long l3;
        long l4;
        int n2;
        long l5 = Double.doubleToRawLongBits(d2);
        int n3 = (int)(l5 >> 52 & 0x7FFL) - 1023;
        l5 &= 0xFFFFFFFFFFFFFL;
        l5 |= 0x10000000000000L;
        ++n3;
        l5 <<= 11;
        if ((n3 -= (n2 = n3 >> 6) << 6) != 0) {
            l4 = n2 == 0 ? 0L : t[n2 - 1] << n3;
            l4 = l4 | t[n2] >>> 64 - n3;
            l3 = t[n2] << n3 | t[n2 + 1] >>> 64 - n3;
            l2 = t[n2 + 1] << n3 | t[n2 + 2] >>> 64 - n3;
        } else {
            l4 = n2 == 0 ? 0L : t[n2 - 1];
            l3 = t[n2];
            l2 = t[n2 + 1];
        }
        long l6 = l5 >>> 32;
        long l7 = l5 & 0xFFFFFFFFL;
        long l8 = l3 >>> 32;
        long l9 = l3 & 0xFFFFFFFFL;
        long l10 = l6 * l8;
        long l11 = l7 * l9;
        long l12 = l7 * l8;
        long l13 = l6 * l9;
        long l14 = l11 + (l13 << 32);
        long l15 = l10 + (l13 >>> 32);
        n3 = (l11 & Long.MIN_VALUE) != 0L ? 1 : 0;
        n2 = (l13 & 0x80000000L) != 0L ? 1 : 0;
        boolean bl2 = bl = (l14 & Long.MIN_VALUE) != 0L;
        if (n3 != 0 && n2 != 0 || (n3 != 0 || n2 != 0) && !bl) {
            ++l15;
        }
        n3 = (l14 & Long.MIN_VALUE) != 0L ? 1 : 0;
        n2 = (l12 & 0x80000000L) != 0L ? 1 : 0;
        l15 += l12 >>> 32;
        boolean bl3 = bl = ((l14 += l12 << 32) & Long.MIN_VALUE) != 0L;
        if (n3 != 0 && n2 != 0 || (n3 != 0 || n2 != 0) && !bl) {
            ++l15;
        }
        l8 = l2 >>> 32;
        l9 = l2 & 0xFFFFFFFFL;
        l10 = l6 * l8;
        l12 = l7 * l8;
        l13 = l6 * l9;
        n3 = (l14 & Long.MIN_VALUE) != 0L ? 1 : 0;
        n2 = ((l10 += l12 + l13 >>> 32) & Long.MIN_VALUE) != 0L ? 1 : 0;
        boolean bl4 = bl = ((l14 += l10) & Long.MIN_VALUE) != 0L;
        if (n3 != 0 && n2 != 0 || (n3 != 0 || n2 != 0) && !bl) {
            ++l15;
        }
        l8 = l4 >>> 32;
        l9 = l4 & 0xFFFFFFFFL;
        l11 = l7 * l9;
        l12 = l7 * l8;
        l13 = l6 * l9;
        int n4 = (int)((l15 += l11 + (l12 + l13 << 32)) >>> 62);
        l15 <<= 2;
        l15 |= l14 >>> 62;
        l14 <<= 2;
        l6 = l15 >>> 32;
        l7 = l15 & 0xFFFFFFFFL;
        l8 = u[0] >>> 32;
        l9 = u[0] & 0xFFFFFFFFL;
        l10 = l6 * l8;
        l11 = l7 * l9;
        l12 = l7 * l8;
        l13 = l6 * l9;
        long l16 = l11 + (l13 << 32);
        long l17 = l10 + (l13 >>> 32);
        n3 = (l11 & Long.MIN_VALUE) != 0L ? 1 : 0;
        n2 = (l13 & 0x80000000L) != 0L ? 1 : 0;
        boolean bl5 = bl = (l16 & Long.MIN_VALUE) != 0L;
        if (n3 != 0 && n2 != 0 || (n3 != 0 || n2 != 0) && !bl) {
            ++l17;
        }
        n3 = (l16 & Long.MIN_VALUE) != 0L ? 1 : 0;
        n2 = (l12 & 0x80000000L) != 0L ? 1 : 0;
        l17 += l12 >>> 32;
        boolean bl6 = bl = ((l16 += l12 << 32) & Long.MIN_VALUE) != 0L;
        if (n3 != 0 && n2 != 0 || (n3 != 0 || n2 != 0) && !bl) {
            ++l17;
        }
        l8 = u[1] >>> 32;
        l9 = u[1] & 0xFFFFFFFFL;
        l10 = l6 * l8;
        l12 = l7 * l8;
        l13 = l6 * l9;
        n3 = (l16 & Long.MIN_VALUE) != 0L ? 1 : 0;
        n2 = ((l10 += l12 + l13 >>> 32) & Long.MIN_VALUE) != 0L ? 1 : 0;
        boolean bl7 = bl = ((l16 += l10) & Long.MIN_VALUE) != 0L;
        if (n3 != 0 && n2 != 0 || (n3 != 0 || n2 != 0) && !bl) {
            ++l17;
        }
        l6 = l14 >>> 32;
        l7 = l14 & 0xFFFFFFFFL;
        l8 = u[0] >>> 32;
        l9 = u[0] & 0xFFFFFFFFL;
        l10 = l6 * l8;
        l12 = l7 * l8;
        l13 = l6 * l9;
        n3 = (l16 & Long.MIN_VALUE) != 0L ? 1 : 0;
        n2 = ((l10 += l12 + l13 >>> 32) & Long.MIN_VALUE) != 0L ? 1 : 0;
        boolean bl8 = bl = ((l16 += l10) & Long.MIN_VALUE) != 0L;
        if (n3 != 0 && n2 != 0 || (n3 != 0 || n2 != 0) && !bl) {
            ++l17;
        }
        double d3 = (double)(l17 >>> 12) / 4.503599627370496E15;
        double d4 = (double)(((l17 & 0xFFFL) << 40) + (l16 >>> 24)) / 4.503599627370496E15 / 4.503599627370496E15;
        double d5 = d3 + d4;
        double d6 = -(d5 - d3 - d4);
        dArray[0] = n4;
        dArray[1] = d5 * 2.0;
        dArray[2] = d6 * 2.0;
    }

    public static double n(double d2) {
        boolean bl = false;
        int n2 = 0;
        double d3 = 0.0;
        double d4 = d2;
        if (d2 < 0.0) {
            bl = true;
            d4 = -d4;
        }
        if (d4 == 0.0) {
            long l2 = Double.doubleToRawLongBits(d2);
            if (l2 < 0L) {
                return -0.0;
            }
            return 0.0;
        }
        double d5 = d4;
        if (d5 != d5 || d4 == Double.POSITIVE_INFINITY) {
            return Double.NaN;
        }
        if (d4 > 3294198.0) {
            double[] dArray = new double[3];
            BY.c(d4, dArray);
            n2 = (int)dArray[0] & 3;
            d4 = dArray[1];
            d3 = dArray[2];
        } else if (d4 > 1.5707963267948966) {
            a a2;
            a a3 = a2 = new a(d4);
            n2 = a2.a & 3;
            a3 = a2;
            d4 = a3.b;
            a3 = a2;
            d3 = a3.c;
        }
        if (bl) {
            n2 ^= 2;
        }
        switch (n2) {
            case 0: {
                return BY.j(d4, d3);
            }
            case 1: {
                return BY.k(d4, d3);
            }
            case 2: {
                return -BY.j(d4, d3);
            }
            case 3: {
                return -BY.k(d4, d3);
            }
        }
        return Double.NaN;
    }

    public static double o(double d2) {
        int n2 = 0;
        double d3 = d2;
        if (d2 < 0.0) {
            d3 = -d3;
        }
        double d4 = d3;
        if (d4 != d4 || d3 == Double.POSITIVE_INFINITY) {
            return Double.NaN;
        }
        double d5 = 0.0;
        if (d3 > 3294198.0) {
            double[] dArray = new double[3];
            BY.c(d3, dArray);
            n2 = (int)dArray[0] & 3;
            d3 = dArray[1];
            d5 = dArray[2];
        } else if (d3 > 1.5707963267948966) {
            a a2;
            a a3 = a2 = new a(d3);
            n2 = a2.a & 3;
            a3 = a2;
            d3 = a3.b;
            a3 = a2;
            d5 = a3.c;
        }
        switch (n2) {
            case 0: {
                return BY.k(d3, d5);
            }
            case 1: {
                return -BY.j(d3, d5);
            }
            case 2: {
                return -BY.k(d3, d5);
            }
            case 3: {
                return BY.j(d3, d5);
            }
        }
        return Double.NaN;
    }

    public static double p(double d2) {
        Object object;
        boolean bl = false;
        int n2 = 0;
        double d3 = d2;
        if (d2 < 0.0) {
            bl = true;
            d3 = -d3;
        }
        if (d3 == 0.0) {
            long l2 = Double.doubleToRawLongBits(d2);
            if (l2 < 0L) {
                return -0.0;
            }
            return 0.0;
        }
        double d4 = d3;
        if (d4 != d4 || d3 == Double.POSITIVE_INFINITY) {
            return Double.NaN;
        }
        double d5 = 0.0;
        if (d3 > 3294198.0) {
            object = new double[3];
            BY.c(d3, object);
            n2 = (int)object[0] & 3;
            d3 = object[1];
            d5 = object[2];
        } else if (d3 > 1.5707963267948966) {
            a a2 = new a(d3);
            object = a2;
            Object object2 = a2;
            n2 = a2.a & 3;
            object2 = object;
            d3 = object.b;
            object2 = object;
            d5 = object.c;
        }
        if (d3 > 1.5) {
            double d6 = 1.5707963267948966 - d3;
            double d7 = -(d6 - 1.5707963267948966 + d3);
            d3 = d6 + (d7 += 6.123233995736766E-17 - d5);
            d5 = -(d3 - d6 - d7);
            n2 ^= 1;
            bl ^= true;
        }
        double d8 = !(n2 & true) ? BY.a(d3, d5, false) : -BY.a(d3, d5, true);
        if (bl) {
            d8 = -d8;
        }
        return d8;
    }

    public static double q(double d2) {
        return BY.b(d2, 0.0, false);
    }

    private static double b(double d2, double d3, boolean bl) {
        double d4;
        double d5;
        double d6;
        double d7;
        double d8;
        double d9;
        double d10;
        int n2;
        boolean bl2;
        if (d2 == 0.0) {
            if (bl) {
                return BY.h(Math.PI, d2);
            }
            return d2;
        }
        if (d2 < 0.0) {
            d2 = -d2;
            d3 = -d3;
            bl2 = true;
        } else {
            bl2 = false;
        }
        if (d2 > 1.633123935319537E16) {
            if (bl2 ^ bl) {
                return -1.5707963267948966;
            }
            return 1.5707963267948966;
        }
        if (d2 < 1.0) {
            n2 = (int)((d2 * -1.7168146928204135 * d2 + 8.0) * d2 + 0.5);
        } else {
            d10 = 1.0 / d2;
            n2 = (int)(-((d10 * -1.7168146928204135 * d10 + 8.0) * d10) + 13.07);
        }
        d10 = r[n2];
        double d11 = s[n2];
        double d12 = d2 - d10;
        double d13 = -(d12 - d2 + d10);
        double d14 = d12 + (d13 += d3 - d11);
        d13 = -(d14 - d12 - d13);
        d12 = d14;
        d14 = d2 * 1.073741824E9;
        double d15 = d2 + d14 - d14;
        double d16 = d3 + d2 - d15;
        d2 = d15;
        d3 += d16;
        if (n2 == 0) {
            d9 = 1.0 / (1.0 + (d2 + d3) * (d10 + d11));
            d15 = d12 * d9;
            d16 = d13 * d9;
        } else {
            d9 = d2 * d10;
            d8 = d9 + 1.0;
            d7 = -(d8 - 1.0 - d9);
            d9 = d3 * d10 + d2 * d11;
            d14 = d8 + d9;
            d7 -= d14 - d8 - d9;
            d8 = d14;
            d7 += d3 * d11;
            d15 = d12 / d8;
            d14 = d15 * 1.073741824E9;
            d6 = d15 + d14 - d14;
            d5 = d15 - d6;
            d14 = d8 * 1.073741824E9;
            d4 = d8 + d14 - d14;
            double d17 = d8 - d4;
            d16 = (d12 - d6 * d4 - d6 * d17 - d5 * d4 - d5 * d17) / d8;
            d16 += -d12 * d7 / d8 / d8;
            d16 += d13 / d8;
        }
        d12 = d15;
        d13 = d16;
        double d18 = d12;
        d9 = d18 * d18;
        d16 = d9 * 0.07490822288864472 - 0.09088450866185192;
        d16 = d16 * d9 + 0.11111095942313305;
        d16 = d16 * d9 - 0.1428571423679182;
        d16 = d16 * d9 + 0.19999999999923582;
        d16 = d16 * d9 - 0.33333333333333287;
        d16 = d16 * d9 * d12;
        d15 = d12;
        d14 = d15 + d16;
        d16 = -(d14 - d15 - d16);
        d15 = d14;
        double d19 = d12;
        d8 = v[n2];
        d7 = d8 + d15;
        d6 = -(d7 - d8 - d15);
        d14 = d7 + (d16 += d13 / (1.0 + d19 * d19));
        d6 -= d14 - d7 - d16;
        d7 = d14;
        d5 = d7 + d6;
        if (bl) {
            d4 = -(d5 - d7 - d6);
            d7 = Math.PI - d5;
            d6 = -(d7 - Math.PI + d5);
            d5 = d7 + (d6 += 1.2246467991473532E-16 - d4);
        }
        if (bl2 ^ bl) {
            d5 = -d5;
        }
        return d5;
    }

    public static double b(double d2, double d3) {
        double d4;
        block26: {
            block25: {
                double d5 = d3;
                if (d5 != d5) break block25;
                double d6 = d2;
                if (d6 == d6) break block26;
            }
            return Double.NaN;
        }
        if (d2 == 0.0) {
            double d7 = d3 * d2;
            double d8 = 1.0 / d3;
            double d9 = 1.0 / d2;
            if (d8 == 0.0) {
                if (d3 > 0.0) {
                    return d2;
                }
                return BY.h(Math.PI, d2);
            }
            if (d3 < 0.0 || d8 < 0.0) {
                if (d2 < 0.0 || d9 < 0.0) {
                    return -Math.PI;
                }
                return Math.PI;
            }
            return d7;
        }
        if (d2 == Double.POSITIVE_INFINITY) {
            if (d3 == Double.POSITIVE_INFINITY) {
                return 0.7853981633974483;
            }
            if (d3 == Double.NEGATIVE_INFINITY) {
                return 2.356194490192345;
            }
            return 1.5707963267948966;
        }
        if (d2 == Double.NEGATIVE_INFINITY) {
            if (d3 == Double.POSITIVE_INFINITY) {
                return -0.7853981633974483;
            }
            if (d3 == Double.NEGATIVE_INFINITY) {
                return -2.356194490192345;
            }
            return -1.5707963267948966;
        }
        if (d3 == Double.POSITIVE_INFINITY) {
            if (d2 > 0.0 || 1.0 / d2 > 0.0) {
                return 0.0;
            }
            if (d2 < 0.0 || 1.0 / d2 < 0.0) {
                return -0.0;
            }
        }
        if (d3 == Double.NEGATIVE_INFINITY) {
            if (d2 > 0.0 || 1.0 / d2 > 0.0) {
                return Math.PI;
            }
            if (d2 < 0.0 || 1.0 / d2 < 0.0) {
                return -Math.PI;
            }
        }
        if (d3 == 0.0) {
            if (d2 > 0.0 || 1.0 / d2 > 0.0) {
                return 1.5707963267948966;
            }
            if (d2 < 0.0 || 1.0 / d2 < 0.0) {
                return -1.5707963267948966;
            }
        }
        if (Double.isInfinite(d4 = d2 / d3)) {
            return BY.b(d4, 0.0, d3 < 0.0);
        }
        double d10 = BY.D(d4);
        double d11 = d4 - d10;
        double d12 = BY.D(d3);
        double d13 = d3 - d12;
        d11 += (d2 - d10 * d12 - d10 * d13 - d11 * d12 - d11 * d13) / d3;
        double d14 = d10 + d11;
        d11 = -(d14 - d10 - d11);
        d10 = d14;
        if (d10 == 0.0) {
            d10 = BY.h(0.0, d2);
        }
        double d15 = BY.b(d10, d11, d3 < 0.0);
        return d15;
    }

    public static double r(double d2) {
        double d3 = d2;
        if (d3 != d3) {
            return Double.NaN;
        }
        if (d2 > 1.0 || d2 < -1.0) {
            return Double.NaN;
        }
        if (d2 == 1.0) {
            return 1.5707963267948966;
        }
        if (d2 == -1.0) {
            return -1.5707963267948966;
        }
        if (d2 == 0.0) {
            return d2;
        }
        double d4 = d2 * 1.073741824E9;
        double d5 = d2 + d4 - d4;
        double d6 = d2 - d5;
        double d7 = d5;
        double d8 = d7 * d7;
        double d9 = d6;
        double d10 = d5 * d6 * 2.0 + d9 * d9;
        d8 = -d8;
        d10 = -d10;
        double d11 = d8 + 1.0;
        double d12 = -(d11 - 1.0 - d8);
        d4 = d11 + d10;
        d12 -= d4 - d11 - d10;
        double d13 = d11 = d4;
        double d14 = Math.sqrt(d11);
        d4 = d14 * 1.073741824E9;
        d8 = d14 + d4 - d4;
        d10 = d14 - d8;
        double d15 = d8;
        double d16 = d10;
        d10 += (d11 - d15 * d15 - d8 * 2.0 * d10 - d16 * d16) / (d14 * 2.0);
        double d17 = d12 / (d14 * 2.0);
        double d18 = d2 / d14;
        d4 = d18 * 1.073741824E9;
        double d19 = d18 + d4 - d4;
        double d20 = d18 - d19;
        d20 += (d2 - d19 * d8 - d19 * d10 - d20 * d8 - d20 * d10) / d14;
        d4 = d19 + (d20 += -d2 * d17 / d14 / d14);
        d20 = -(d4 - d19 - d20);
        d19 = d4;
        return BY.b(d19, d20, false);
    }

    public static double s(double d2) {
        double d3 = d2;
        if (d3 != d3) {
            return Double.NaN;
        }
        if (d2 > 1.0 || d2 < -1.0) {
            return Double.NaN;
        }
        if (d2 == -1.0) {
            return Math.PI;
        }
        if (d2 == 1.0) {
            return 0.0;
        }
        if (d2 == 0.0) {
            return 1.5707963267948966;
        }
        double d4 = d2 * 1.073741824E9;
        double d5 = d2 + d4 - d4;
        double d6 = d2 - d5;
        double d7 = d5;
        double d8 = d7 * d7;
        double d9 = d6;
        double d10 = d5 * d6 * 2.0 + d9 * d9;
        d8 = -d8;
        d10 = -d10;
        double d11 = d8 + 1.0;
        double d12 = -(d11 - 1.0 - d8);
        d4 = d11 + d10;
        d12 -= d4 - d11 - d10;
        double d13 = d11 = d4;
        double d14 = Math.sqrt(d11);
        d4 = d14 * 1.073741824E9;
        d8 = d14 + d4 - d4;
        d10 = d14 - d8;
        double d15 = d8;
        double d16 = d10;
        d10 += (d11 - d15 * d15 - d8 * 2.0 * d10 - d16 * d16) / (d14 * 2.0);
        d10 += d12 / (d14 * 2.0);
        d14 = d8 + d10;
        d10 = -(d14 - d8 - d10);
        double d17 = d14 / d2;
        if (Double.isInfinite(d17)) {
            return 1.5707963267948966;
        }
        double d18 = BY.D(d17);
        double d19 = d17 - d18;
        d19 += (d14 - d18 * d5 - d18 * d6 - d19 * d5 - d19 * d6) / d2;
        d4 = d18 + (d19 += d10 / d2);
        d19 = -(d4 - d18 - d19);
        d18 = d4;
        return BY.b(d18, d19, d2 < 0.0);
    }

    public static double t(double d2) {
        long l2 = Double.doubleToRawLongBits(d2);
        int n2 = (int)(l2 >> 52 & 0x7FFL) - 1023;
        boolean bl = false;
        if (n2 == -1023) {
            if (d2 == 0.0) {
                return d2;
            }
            bl = true;
            l2 = Double.doubleToRawLongBits(d2 *= 1.8014398509481984E16);
            n2 = (int)(l2 >> 52 & 0x7FFL) - 1023;
        }
        if (n2 == 1024) {
            return d2;
        }
        int n3 = n2 / 3;
        double d3 = Double.longBitsToDouble(l2 & Long.MIN_VALUE | (long)(n3 + 1023 & 0x7FF) << 52);
        double d4 = Double.longBitsToDouble(l2 & 0xFFFFFFFFFFFFFL | 0x3FF0000000000000L);
        double d5 = d4 * -0.010714690733195933 + 0.0875862700108075;
        d5 = d5 * d4 + -0.3058015757857271;
        d5 = d5 * d4 + 0.7249995199969751;
        d5 = d5 * d4 + 0.5039018405998233;
        double d6 = d3;
        double d7 = d2 / (d6 * d6 * d3);
        double d8 = d5 *= w[n2 % 3 + 2];
        d5 += (d7 - d8 * d8 * d5) / (d5 * 3.0 * d5);
        double d9 = d5;
        d5 += (d7 - d9 * d9 * d5) / (d5 * 3.0 * d5);
        double d10 = d5 * 1.073741824E9;
        double d11 = d5 + d10 - d10;
        double d12 = d5 - d11;
        double d13 = d11;
        double d14 = d13 * d13;
        double d15 = d12;
        double d16 = d11 * d12 * 2.0 + d15 * d15;
        d10 = d14 * 1.073741824E9;
        double d17 = d14 + d10 - d10;
        d16 += d14 - d17;
        d14 = d17;
        d16 = d14 * d12 + d11 * d16 + d16 * d12;
        double d18 = d7 - (d14 *= d11);
        double d19 = -(d18 - d7 + d14);
        d5 += (d18 + (d19 -= d16)) / (d5 * 3.0 * d5);
        d5 *= d3;
        if (bl) {
            d5 *= 3.814697265625E-6;
        }
        return d5;
    }

    public static double u(double d2) {
        if (Double.isInfinite(d2) || d2 == 0.0) {
            return d2;
        }
        double d3 = BY.D(d2);
        double d4 = d2 - d3;
        double d5 = d4 * 1.997844754509471E-9 + d4 * 0.01745329052209854 + d3 * 1.997844754509471E-9 + d3 * 0.01745329052209854;
        if (d5 == 0.0) {
            d5 *= d2;
        }
        return d5;
    }

    public static double v(double d2) {
        if (Double.isInfinite(d2) || d2 == 0.0) {
            return d2;
        }
        double d3 = BY.D(d2);
        double d4 = d2 - d3;
        return d4 * 3.145894820876798E-6 + d4 * 57.2957763671875 + d3 * 3.145894820876798E-6 + d3 * 57.2957763671875;
    }

    public static int a(int n2) {
        int n3 = n2 >>> 31;
        return (n2 ^ ~n3 + 1) + n3;
    }

    public static long a(long l2) {
        long l3 = l2 >>> 63;
        return (l2 ^ (l3 ^ 0xFFFFFFFFFFFFFFFFL) + 1L) + l3;
    }

    public static float a(float f2) {
        return Float.intBitsToFloat(Integer.MAX_VALUE & Float.floatToRawIntBits(f2));
    }

    public static double w(double d2) {
        return Double.longBitsToDouble(Long.MAX_VALUE & Double.doubleToRawLongBits(d2));
    }

    public static double x(double d2) {
        if (Double.isInfinite(d2)) {
            return Double.POSITIVE_INFINITY;
        }
        double d3 = d2;
        return BY.w(d3 - Double.longBitsToDouble(Double.doubleToRawLongBits(d3) ^ 1L));
    }

    private static float f(float f2) {
        if (Float.isInfinite(f2)) {
            return Float.POSITIVE_INFINITY;
        }
        float f3 = f2;
        return BY.a(f3 - Float.intBitsToFloat(Float.floatToIntBits(f3) ^ 1));
    }

    public static double b(double d2, int n2) {
        if (n2 > -1023 && n2 < 1024) {
            return d2 * Double.longBitsToDouble((long)(n2 + 1023) << 52);
        }
        if (Double.isNaN(d2) || Double.isInfinite(d2) || d2 == 0.0) {
            return d2;
        }
        if (n2 < -2098) {
            if (d2 > 0.0) {
                return 0.0;
            }
            return -0.0;
        }
        if (n2 > 2097) {
            if (d2 > 0.0) {
                return Double.POSITIVE_INFINITY;
            }
            return Double.NEGATIVE_INFINITY;
        }
        long l2 = Double.doubleToRawLongBits(d2);
        long l3 = l2 & Long.MIN_VALUE;
        int n3 = (int)(l2 >>> 52) & 0x7FF;
        long l4 = l2 & 0xFFFFFFFFFFFFFL;
        int n4 = n3 + n2;
        if (n2 < 0) {
            if (n4 > 0) {
                return Double.longBitsToDouble(l3 | (long)n4 << 52 | l4);
            }
            if (n4 > -53) {
                long l5 = (l4 |= 0x10000000000000L) & 1L << -n4;
                l4 >>>= 1 - n4;
                if (l5 != 0L) {
                    ++l4;
                }
                return Double.longBitsToDouble(l3 | l4);
            }
            if (l3 == 0L) {
                return 0.0;
            }
            return -0.0;
        }
        if (n3 == 0) {
            while (l4 >>> 52 != 1L) {
                l4 <<= 1;
                --n4;
            }
            l4 &= 0xFFFFFFFFFFFFFL;
            if (++n4 < 2047) {
                return Double.longBitsToDouble(l3 | (long)n4 << 52 | l4);
            }
            if (l3 == 0L) {
                return Double.POSITIVE_INFINITY;
            }
            return Double.NEGATIVE_INFINITY;
        }
        if (n4 < 2047) {
            return Double.longBitsToDouble(l3 | (long)n4 << 52 | l4);
        }
        if (l3 == 0L) {
            return Double.POSITIVE_INFINITY;
        }
        return Double.NEGATIVE_INFINITY;
    }

    private static float a(float f2, int n2) {
        if (n2 > -127 && n2 < 128) {
            return f2 * Float.intBitsToFloat(n2 + 127 << 23);
        }
        if (Float.isNaN(f2) || Float.isInfinite(f2) || f2 == 0.0f) {
            return f2;
        }
        if (n2 < -277) {
            if (f2 > 0.0f) {
                return 0.0f;
            }
            return -0.0f;
        }
        if (n2 > 276) {
            if (f2 > 0.0f) {
                return Float.POSITIVE_INFINITY;
            }
            return Float.NEGATIVE_INFINITY;
        }
        int n3 = Float.floatToIntBits(f2);
        int n4 = n3 & Integer.MIN_VALUE;
        int n5 = n3 >>> 23 & 0xFF;
        n3 &= 0x7FFFFF;
        int n6 = n5 + n2;
        if (n2 < 0) {
            if (n6 > 0) {
                return Float.intBitsToFloat(n4 | n6 << 23 | n3);
            }
            if (n6 > -24) {
                n2 = (n3 |= 0x800000) & 1 << -n6;
                n3 >>>= 1 - n6;
                if (n2 != 0) {
                    ++n3;
                }
                return Float.intBitsToFloat(n4 | n3);
            }
            if (n4 == 0) {
                return 0.0f;
            }
            return -0.0f;
        }
        if (n5 == 0) {
            while (n3 >>> 23 != 1) {
                n3 <<= 1;
                --n6;
            }
            n3 &= 0x7FFFFF;
            if (++n6 < 255) {
                return Float.intBitsToFloat(n4 | n6 << 23 | n3);
            }
            if (n4 == 0) {
                return Float.POSITIVE_INFINITY;
            }
            return Float.NEGATIVE_INFINITY;
        }
        if (n6 < 255) {
            return Float.intBitsToFloat(n4 | n6 << 23 | n3);
        }
        if (n4 == 0) {
            return Float.POSITIVE_INFINITY;
        }
        return Float.NEGATIVE_INFINITY;
    }

    public static double c(double d2, double d3) {
        long l2;
        long l3;
        if (Double.isNaN(d2) || Double.isNaN(d3)) {
            return Double.NaN;
        }
        if (d2 == d3) {
            return d3;
        }
        if (Double.isInfinite(d2)) {
            if (d2 < 0.0) {
                return -1.7976931348623157E308;
            }
            return Double.MAX_VALUE;
        }
        if (d2 == 0.0) {
            if (d3 < 0.0) {
                return -4.9E-324;
            }
            return Double.MIN_VALUE;
        }
        if (d3 < d2 ^ (l3 = (l2 = Double.doubleToRawLongBits(d2)) & Long.MIN_VALUE) == 0L) {
            return Double.longBitsToDouble(l3 | (l2 & Long.MAX_VALUE) + 1L);
        }
        return Double.longBitsToDouble(l3 | (l2 & Long.MAX_VALUE) - 1L);
    }

    private static float a(float f2, double d2) {
        int n2;
        int n3;
        if (Double.isNaN(f2) || Double.isNaN(d2)) {
            return Float.NaN;
        }
        if ((double)f2 == d2) {
            return (float)d2;
        }
        if (Float.isInfinite(f2)) {
            if (f2 < 0.0f) {
                return -3.4028235E38f;
            }
            return Float.MAX_VALUE;
        }
        if (f2 == 0.0f) {
            if (d2 < 0.0) {
                return -1.4E-45f;
            }
            return Float.MIN_VALUE;
        }
        if (d2 < (double)f2 ^ (n3 = (n2 = Float.floatToIntBits(f2)) & Integer.MIN_VALUE) == 0) {
            return Float.intBitsToFloat(n3 | (n2 & Integer.MAX_VALUE) + 1);
        }
        return Float.intBitsToFloat(n3 | (n2 & Integer.MAX_VALUE) - 1);
    }

    public static double y(double d2) {
        double d3 = d2;
        if (d3 != d3) {
            return d2;
        }
        if (d2 >= 4.503599627370496E15 || d2 <= -4.503599627370496E15) {
            return d2;
        }
        long l2 = (long)d2;
        if (d2 < 0.0 && (double)l2 != d2) {
            --l2;
        }
        if (l2 == 0L) {
            return d2 * (double)l2;
        }
        return l2;
    }

    public static double z(double d2) {
        double d3 = d2;
        if (d3 != d3) {
            return d2;
        }
        double d4 = BY.y(d2);
        if (d4 == d2) {
            return d4;
        }
        if ((d4 += 1.0) == 0.0) {
            return d2 * d4;
        }
        return d4;
    }

    public static double A(double d2) {
        double d3;
        double d4 = BY.y(d2);
        double d5 = d2 - d4;
        if (d3 > 0.5) {
            if (d4 == -1.0) {
                return -0.0;
            }
            return d4 + 1.0;
        }
        if (d5 < 0.5) {
            return d4;
        }
        long l2 = (long)d4;
        if ((l2 & 1L) == 0L) {
            return d4;
        }
        return d4 + 1.0;
    }

    public static long B(double d2) {
        return (long)BY.y(d2 + 0.5);
    }

    private static int g(float f2) {
        return (int)BY.y(f2 + 0.5f);
    }

    public static int a(int n2, int n3) {
        if (n2 <= n3) {
            return n2;
        }
        return n3;
    }

    public static long a(long l2, long l3) {
        if (l2 <= Integer.MAX_VALUE) {
            return l2;
        }
        return Integer.MAX_VALUE;
    }

    private static float b(float f2, float f3) {
        if (f2 > f3) {
            return f3;
        }
        if (f2 < f3) {
            return f2;
        }
        if (f2 != f3) {
            return Float.NaN;
        }
        int n2 = Float.floatToRawIntBits(f2);
        if (n2 == Integer.MIN_VALUE) {
            return f2;
        }
        return f3;
    }

    public static double d(double d2, double d3) {
        if (d2 > d3) {
            return d3;
        }
        if (d2 < d3) {
            return d2;
        }
        if (d2 != d3) {
            return Double.NaN;
        }
        long l2 = Double.doubleToRawLongBits(d2);
        if (l2 == Long.MIN_VALUE) {
            return d2;
        }
        return d3;
    }

    public static int b(int n2, int n3) {
        if (n2 <= n3) {
            return n3;
        }
        return n2;
    }

    private static long b(long l2, long l3) {
        if (l2 <= l3) {
            return l3;
        }
        return l2;
    }

    private static float c(float f2, float f3) {
        if (f2 > f3) {
            return f2;
        }
        if (f2 < f3) {
            return f3;
        }
        if (f2 != f3) {
            return Float.NaN;
        }
        int n2 = Float.floatToRawIntBits(f2);
        if (n2 == Integer.MIN_VALUE) {
            return f3;
        }
        return f2;
    }

    public static double e(double d2, double d3) {
        if (d2 > d3) {
            return d2;
        }
        if (d2 < d3) {
            return d3;
        }
        if (d2 != d3) {
            return Double.NaN;
        }
        long l2 = Double.doubleToRawLongBits(d2);
        if (l2 == Long.MIN_VALUE) {
            return d3;
        }
        return d2;
    }

    public static double f(double d2, double d3) {
        int n2;
        if (Double.isInfinite(d2) || Double.isInfinite(d3)) {
            return Double.POSITIVE_INFINITY;
        }
        if (Double.isNaN(d2) || Double.isNaN(d3)) {
            return Double.NaN;
        }
        int n3 = BY.C(d2);
        if (n3 > (n2 = BY.C(d3)) + 27) {
            return BY.w(d2);
        }
        if (n2 > n3 + 27) {
            return BY.w(d3);
        }
        n3 = (n3 + n2) / 2;
        double d4 = BY.b(d2, -n3);
        double d5 = BY.b(d3, -n3);
        double d6 = d4;
        double d7 = d5;
        double d8 = d6 * d6 + d7 * d7;
        double d9 = Math.sqrt(d8);
        return BY.b(d9, n3);
    }

    public static double g(double d2, double d3) {
        return StrictMath.IEEEremainder(d2, d3);
    }

    private static int b(long l2) {
        if (l2 < Integer.MIN_VALUE || l2 > Integer.MAX_VALUE) {
            throw new oU(px_0.OVERFLOW, new Object[0]);
        }
        return (int)l2;
    }

    private static int b(int n2) {
        if (n2 == Integer.MAX_VALUE) {
            throw new oU(px_0.OVERFLOW_IN_ADDITION, n2, 1);
        }
        return n2 + 1;
    }

    private static long c(long l2) {
        if (l2 == Long.MAX_VALUE) {
            throw new oU(px_0.OVERFLOW_IN_ADDITION, l2, 1);
        }
        return l2 + 1L;
    }

    private static int c(int n2) {
        if (n2 == Integer.MIN_VALUE) {
            throw new oU(px_0.OVERFLOW_IN_SUBTRACTION, n2, 1);
        }
        return n2 - 1;
    }

    private static long d(long l2) {
        if (l2 == Long.MIN_VALUE) {
            throw new oU(px_0.OVERFLOW_IN_SUBTRACTION, l2, 1);
        }
        return l2 - 1L;
    }

    private static int c(int n2, int n3) {
        int n4 = n2 + n3;
        if ((n2 ^ n3) >= 0 && (n4 ^ n3) < 0) {
            throw new oU(px_0.OVERFLOW_IN_ADDITION, n2, n3);
        }
        return n4;
    }

    private static long c(long l2, long l3) {
        long l4 = l2 + l3;
        if ((l2 ^ l3) >= 0L && (l4 ^ l3) < 0L) {
            throw new oU(px_0.OVERFLOW_IN_ADDITION, l2, l3);
        }
        return l4;
    }

    private static int d(int n2, int n3) {
        int n4 = n2 - n3;
        if ((n2 ^ n3) < 0 && (n4 ^ n3) >= 0) {
            throw new oU(px_0.OVERFLOW_IN_SUBTRACTION, n2, n3);
        }
        return n4;
    }

    private static long d(long l2, long l3) {
        long l4 = l2 - l3;
        if ((l2 ^ l3) < 0L && (l4 ^ l3) >= 0L) {
            throw new oU(px_0.OVERFLOW_IN_SUBTRACTION, l2, l3);
        }
        return l4;
    }

    private static int e(int n2, int n3) {
        if (n3 > 0 && (n2 > Integer.MAX_VALUE / n3 || n2 < Integer.MIN_VALUE / n3) || n3 < -1 && (n2 > Integer.MIN_VALUE / n3 || n2 < Integer.MAX_VALUE / n3) || n3 == -1 && n2 == Integer.MIN_VALUE) {
            throw new oU(px_0.OVERFLOW_IN_MULTIPLICATION, n2, n3);
        }
        return n2 * n3;
    }

    private static long e(long l2, long l3) {
        if (l3 > 0L && (l2 > Long.MAX_VALUE / l3 || l2 < Long.MIN_VALUE / l3) || l3 < -1L && (l2 > Long.MIN_VALUE / l3 || l2 < Long.MAX_VALUE / l3) || l3 == -1L && l2 == Long.MIN_VALUE) {
            throw new oU(px_0.OVERFLOW_IN_MULTIPLICATION, l2, l3);
        }
        return l2 * l3;
    }

    private static int f(int n2, int n3) {
        if (n3 == 0) {
            throw new oU(px_0.ZERO_DENOMINATOR, new Object[0]);
        }
        int n4 = n2 % n3;
        if ((n2 ^ n3) >= 0 || n4 == 0) {
            return n2 / n3;
        }
        return n2 / n3 - 1;
    }

    private static long f(long l2, long l3) {
        if (l3 == 0L) {
            throw new oU(px_0.ZERO_DENOMINATOR, new Object[0]);
        }
        long l4 = l2 % l3;
        if ((l2 ^ l3) >= 0L || l4 == 0L) {
            return l2 / l3;
        }
        return l2 / l3 - 1L;
    }

    private static int g(int n2, int n3) {
        if (n3 == 0) {
            throw new oU(px_0.ZERO_DENOMINATOR, new Object[0]);
        }
        int n4 = n2 % n3;
        if ((n2 ^ n3) >= 0 || n4 == 0) {
            return n4;
        }
        return n3 + n4;
    }

    private static long g(long l2, long l3) {
        if (l3 == 0L) {
            throw new oU(px_0.ZERO_DENOMINATOR, new Object[0]);
        }
        long l4 = l2 % l3;
        if ((l2 ^ l3) >= 0L || l4 == 0L) {
            return l4;
        }
        return l3 + l4;
    }

    public static double h(double d2, double d3) {
        long l2;
        long l3 = Double.doubleToRawLongBits(d2);
        if ((l3 ^ (l2 = Double.doubleToRawLongBits(d3))) >= 0L) {
            return d2;
        }
        return -d2;
    }

    public static float a(float f2, float f3) {
        int n2;
        int n3 = Float.floatToRawIntBits(1.0f);
        if ((n3 ^ (n2 = Float.floatToRawIntBits(f3))) >= 0) {
            return 1.0f;
        }
        return -1.0f;
    }

    public static int C(double d2) {
        return (int)(Double.doubleToRawLongBits(d2) >>> 52 & 0x7FFL) - 1023;
    }

    public static int b(float f2) {
        return (Float.floatToRawIntBits(Float.MAX_VALUE) >>> 23 & 0xFF) - 127;
    }

    private static void b() {
        PrintStream printStream = System.out;
        BZ.a(printStream, "EXP_INT_TABLE_A", 1500, org.valkyrienskies.core.impl.shadow.BY$c.a);
        BZ.a(printStream, "EXP_INT_TABLE_B", 1500, org.valkyrienskies.core.impl.shadow.BY$c.b);
        BZ.a(printStream, "EXP_FRAC_TABLE_A", 1025, org.valkyrienskies.core.impl.shadow.BY$b.a);
        BZ.a(printStream, "EXP_FRAC_TABLE_B", 1025, org.valkyrienskies.core.impl.shadow.BY$b.b);
        BZ.a(printStream, "LN_MANT", 1024, org.valkyrienskies.core.impl.shadow.BY$e.a);
        BZ.a(printStream, "SINE_TABLE_A", 14, n);
        BZ.a(printStream, "SINE_TABLE_B", 14, o);
        BZ.a(printStream, "COSINE_TABLE_A", 14, p);
        BZ.a(printStream, "COSINE_TABLE_B", 14, q);
        BZ.a(printStream, "TANGENT_TABLE_A", 14, r);
        BZ.a(printStream, "TANGENT_TABLE_B", 14, s);
    }

    static final class a {
        final int a;
        final double b;
        final double c;

        a(double d2) {
            double d3;
            double d4;
            int n2 = (int)(d2 * 0.6366197723675814);
            while (true) {
                double d5 = (double)(-n2) * 1.570796251296997;
                d4 = d2 + d5;
                d3 = -(d4 - d2 - d5);
                d5 = (double)(-n2) * 7.549789948768648E-8;
                double d6 = d4;
                d4 = d5 + d6;
                d3 -= d4 - d6 - d5;
                d5 = (double)(-n2) * 6.123233995736766E-17;
                d6 = d4;
                d4 = d5 + d6;
                d3 -= d4 - d6 - d5;
                if (d4 > 0.0) break;
                --n2;
            }
            this.a = n2;
            this.b = d4;
            this.c = d3;
        }

        final int a() {
            return this.a;
        }

        final double b() {
            return this.b;
        }

        final double c() {
            return this.c;
        }
    }

    static final class e {
        private static final double[][] a = ca_0.e();

        private e() {
        }
    }

    static final class b {
        private static final double[] a = ca_0.c();
        private static final double[] b = ca_0.d();

        private b() {
        }
    }

    static final class c {
        private static final double[] a = ca_0.a();
        private static final double[] b = ca_0.b();

        private c() {
        }
    }

    static final class d {
        private static d a = new d(Double.NaN, 0.0);
        private static d b = new d(Double.POSITIVE_INFINITY, 0.0);
        private static d c = new d(Double.NEGATIVE_INFINITY, 0.0);
        private final double d;
        private final double e;
        private final double f;

        d(double d2) {
            this.d = d2;
            this.e = Double.longBitsToDouble(Double.doubleToRawLongBits(d2) & 0xFFFFFFFFF8000000L);
            this.f = d2 - this.e;
        }

        private d(double d2, double d3) {
            this(d2 == 0.0 ? (d3 == 0.0 && Double.doubleToRawLongBits(d2) == Long.MIN_VALUE ? -0.0 : d3) : d2 + d3, d2, d3);
        }

        private d(double d2, double d3, double d4) {
            this.d = d2;
            this.e = d3;
            this.f = d4;
        }

        private d b(d d2) {
            d d3 = new d(this.d * d2.d);
            double d4 = this.f * d2.f - (d3.d - this.e * d2.e - this.f * d2.e - this.e * d2.f);
            return new d(d3.e, d3.f + d4);
        }

        public final d a() {
            double d2 = 1.0 / this.d;
            d d3 = new d(d2);
            d d4 = this.b(d3);
            double d5 = d4.e - 1.0 + d4.f;
            if (Double.isNaN(d5)) {
                return d3;
            }
            return new d(d3.e, d3.f - d5 / this.d);
        }

        private d a(long l2) {
            d d2 = new d(1.0);
            d d3 = new d(this.d, this.e, this.f);
            for (long i2 = l2; i2 != 0L; i2 >>>= 1) {
                if ((i2 & 1L) != 0L) {
                    d2 = d2.b(d3);
                }
                d d4 = d3;
                d3 = d4.b(d4);
            }
            if (Double.isNaN(d2.d)) {
                if (Double.isNaN(this.d)) {
                    return a;
                }
                if (BY.w(this.d) < 1.0) {
                    return new d(BY.h(0.0, this.d), 0.0);
                }
                if (this.d < 0.0 && (l2 & 1L) == 1L) {
                    return c;
                }
                return b;
            }
            return d2;
        }

        static /* synthetic */ d a(d d2, long l2) {
            long l3 = l2;
            d d3 = new d(1.0);
            d d4 = new d(d2.d, d2.e, d2.f);
            for (long i2 = l3; i2 != 0L; i2 >>>= 1) {
                if ((i2 & 1L) != 0L) {
                    d3 = d3.b(d4);
                }
                d d5 = d4;
                d4 = d5.b(d5);
            }
            if (Double.isNaN(d3.d)) {
                if (Double.isNaN(d2.d)) {
                    return a;
                }
                if (BY.w(d2.d) < 1.0) {
                    return new d(BY.h(0.0, d2.d), 0.0);
                }
                if (d2.d < 0.0 && (l3 & 1L) == 1L) {
                    return c;
                }
                return b;
            }
            return d3;
        }
    }
}

