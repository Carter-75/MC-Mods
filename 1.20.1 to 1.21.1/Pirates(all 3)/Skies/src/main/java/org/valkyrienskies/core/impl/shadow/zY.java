/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.BT;
import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.pc_0;
import org.valkyrienskies.core.impl.shadow.pm_0;
import org.valkyrienskies.core.impl.shadow.pn_0;

public final class zY {
    private static double a = 0.5772156649015329;
    private static double b = 4.7421875;
    private static final double c = 1.0E-14;
    private static final double[] d = new double[]{0.9999999999999971, 57.15623566586292, -59.59796035547549, 14.136097974741746, -0.4919138160976202, 3.399464998481189E-5, 4.652362892704858E-5, -9.837447530487956E-5, 1.580887032249125E-4, -2.1026444172410488E-4, 2.1743961811521265E-4, -1.643181065367639E-4, 8.441822398385275E-5, -2.6190838401581408E-5, 3.6899182659531625E-6};
    private static final double e = 0.5 * BY.k(Math.PI * 2);
    private static final double f = 2.5066282746310007;
    private static final double g = 49.0;
    private static final double h = 1.0E-5;
    private static final double i = 6.116095104481416E-9;
    private static final double j = 6.247308301164655E-9;
    private static final double k = 0.203610414066807;
    private static final double l = 0.026620534842894922;
    private static final double m = 4.939449793824468E-4;
    private static final double n = -8.514194324403149E-6;
    private static final double o = -6.4304548177935305E-6;
    private static final double p = 9.926418406727737E-7;
    private static final double q = -6.077618957228252E-8;
    private static final double r = 1.9575583661463974E-10;
    private static final double s = 6.116095104481416E-9;
    private static final double t = 6.8716741130671986E-9;
    private static final double u = 6.820161668496171E-10;
    private static final double v = 4.686843322948848E-11;
    private static final double w = 1.5728330277104463E-12;
    private static final double x = -1.2494415722763663E-13;
    private static final double y = 4.343529937408594E-15;
    private static final double z = 0.3056961078365221;
    private static final double A = 0.054642130860422966;
    private static final double B = 0.004956830093825887;
    private static final double C = 2.6923694661863613E-4;
    private static final double D = -0.42278433509846713;
    private static final double E = 0.5772156649015329;
    private static final double F = -0.6558780715202539;
    private static final double G = -0.04200263503409524;
    private static final double H = 0.16653861138229148;
    private static final double I = -0.04219773455554433;
    private static final double J = -0.009621971527876973;
    private static final double K = 0.0072189432466631;
    private static final double L = -0.0011651675918590652;
    private static final double M = -2.1524167411495098E-4;
    private static final double N = 1.280502823881162E-4;
    private static final double O = -2.013485478078824E-5;
    private static final double P = -1.2504934821426706E-6;
    private static final double Q = 1.133027231981696E-6;
    private static final double R = -2.056338416977607E-7;

    private zY() {
    }

    public static double a(double d2) {
        double d3;
        if (Double.isNaN(d2) || d2 <= 0.0) {
            d3 = Double.NaN;
        } else {
            if (d2 < 0.5) {
                return zY.c(d2) - BY.k(d2);
            }
            if (d2 <= 2.5) {
                return zY.c(d2 - 0.5 - 0.5);
            }
            if (d2 <= 8.0) {
                int n2 = (int)BY.y(d2 - 1.5);
                double d4 = 1.0;
                for (int i2 = 1; i2 <= n2; ++i2) {
                    d4 *= d2 - (double)i2;
                }
                return zY.c(d2 - (double)(n2 + 1)) + BY.k(d4);
            }
            double d5 = zY.b(d2);
            double d6 = d2 + 4.7421875 + 0.5;
            d3 = (d2 + 0.5) * BY.k(d6) - d6 + e + BY.k(d5 / d2);
        }
        return d3;
    }

    public static double a(double d2, double d3) {
        return zY.a(d2, d3, 1.0E-14, Integer.MAX_VALUE);
    }

    public static double a(double d2, double d3, double d4, int n2) {
        double d5;
        if (Double.isNaN(d2) || Double.isNaN(d3) || d2 <= 0.0 || d3 < 0.0) {
            d5 = Double.NaN;
        } else if (d3 == 0.0) {
            d5 = 0.0;
        } else if (d3 >= d2 + 1.0) {
            d5 = 1.0 - zY.b(d2, d3, d4, n2);
        } else {
            double d6;
            double d7;
            double d8 = 0.0;
            for (d6 = d7 = 1.0 / d2; BY.w(d7 / d6) > d4 && d8 < (double)n2 && d6 < Double.POSITIVE_INFINITY; d6 += (d7 *= d3 / (d2 + (d8 += 1.0)))) {
            }
            if (d8 >= (double)n2) {
                throw new pc_0(n2);
            }
            d5 = Double.isInfinite(d6) ? 1.0 : BY.i(-d3 + d2 * BY.k(d3) - zY.a(d2)) * d6;
        }
        return d5;
    }

    private static double b(double d2, double d3) {
        return zY.b(d2, d3, 1.0E-14, Integer.MAX_VALUE);
    }

    public static double b(double d2, double d3, double d4, int n2) {
        double d5;
        if (Double.isNaN(d2) || Double.isNaN(d3) || d2 <= 0.0 || d3 < 0.0) {
            d5 = Double.NaN;
        } else if (d3 == 0.0) {
            d5 = 1.0;
        } else if (d3 < d2 + 1.0) {
            d5 = 1.0 - zY.a(d2, d3, d4, n2);
        } else {
            BT bT = new BT(d2){
                private /* synthetic */ double a;
                {
                    this.a = d2;
                }

                public final double b(int n2, double d2) {
                    return 2.0 * (double)n2 + 1.0 - this.a + d2;
                }

                public final double a(int n2, double d2) {
                    return (double)n2 * (this.a - (double)n2);
                }
            };
            d5 = 1.0 / bT.a(d3, d4, n2);
            d5 = BY.i(-d3 + d2 * BY.k(d3) - zY.a(d2)) * d5;
        }
        return d5;
    }

    private static double e(double d2) {
        if (Double.isNaN(d2) || Double.isInfinite(d2)) {
            return d2;
        }
        if (d2 > 0.0 && d2 <= 1.0E-5) {
            return -0.5772156649015329 - 1.0 / d2;
        }
        if (d2 >= 49.0) {
            double d3 = d2;
            double d4 = 1.0 / (d3 * d3);
            return BY.k(d2) - 0.5 / d2 - d4 * (0.08333333333333333 + d4 * (0.008333333333333333 - d4 / 252.0));
        }
        return zY.e(d2 + 1.0) - 1.0 / d2;
    }

    private static double f(double d2) {
        if (Double.isNaN(d2) || Double.isInfinite(d2)) {
            return d2;
        }
        if (d2 > 0.0 && d2 <= 1.0E-5) {
            double d3 = d2;
            return 1.0 / (d3 * d3);
        }
        if (d2 >= 49.0) {
            double d4 = d2;
            double d5 = 1.0 / (d4 * d4);
            return 1.0 / d2 + d5 / 2.0 + d5 / d2 * (0.16666666666666666 - d5 * (0.03333333333333333 + d5 / 42.0));
        }
        double d6 = d2;
        return zY.f(d2 + 1.0) + 1.0 / (d6 * d6);
    }

    public static double b(double d2) {
        double d3 = 0.0;
        for (int i2 = d.length - 1; i2 > 0; --i2) {
            d3 += d[i2] / (d2 + (double)i2);
        }
        return d3 + d[0];
    }

    private static double g(double d2) {
        double d3;
        double d4;
        if (d2 < -0.5) {
            throw new pn_0(d2, (Number)-0.5, true);
        }
        if (d2 > 1.5) {
            throw new pm_0(d2, (Number)1.5, true);
        }
        double d5 = d4 = d2 <= 0.5 ? d2 : d2 - 0.5 - 0.5;
        if (d5 < 0.0) {
            double d6 = 6.116095104481416E-9 + d4 * 6.247308301164655E-9;
            double d7 = -6.077618957228252E-8 + d4 * 1.9575583661463974E-10;
            d7 = 9.926418406727737E-7 + d4 * d7;
            d7 = -6.4304548177935305E-6 + d4 * d7;
            d7 = -8.514194324403149E-6 + d4 * d7;
            d7 = 4.939449793824468E-4 + d4 * d7;
            d7 = 0.026620534842894922 + d4 * d7;
            d7 = 0.203610414066807 + d4 * d7;
            d7 = 1.0 + d4 * d7;
            double d8 = -2.056338416977607E-7 + d4 * (d6 / d7);
            d8 = 1.133027231981696E-6 + d4 * d8;
            d8 = -1.2504934821426706E-6 + d4 * d8;
            d8 = -2.013485478078824E-5 + d4 * d8;
            d8 = 1.280502823881162E-4 + d4 * d8;
            d8 = -2.1524167411495098E-4 + d4 * d8;
            d8 = -0.0011651675918590652 + d4 * d8;
            d8 = 0.0072189432466631 + d4 * d8;
            d8 = -0.009621971527876973 + d4 * d8;
            d8 = -0.04219773455554433 + d4 * d8;
            d8 = 0.16653861138229148 + d4 * d8;
            d8 = -0.04200263503409524 + d4 * d8;
            d8 = -0.6558780715202539 + d4 * d8;
            d8 = -0.42278433509846713 + d4 * d8;
            d3 = d2 > 0.5 ? d4 * d8 / d2 : d2 * (d8 + 0.5 + 0.5);
        } else {
            double d9 = -1.2494415722763663E-13 + d4 * 4.343529937408594E-15;
            d9 = 1.5728330277104463E-12 + d4 * d9;
            d9 = 4.686843322948848E-11 + d4 * d9;
            d9 = 6.820161668496171E-10 + d4 * d9;
            d9 = 6.8716741130671986E-9 + d4 * d9;
            d9 = 6.116095104481416E-9 + d4 * d9;
            double d10 = 0.004956830093825887 + d4 * 2.6923694661863613E-4;
            d10 = 0.054642130860422966 + d4 * d10;
            d10 = 0.3056961078365221 + d4 * d10;
            d10 = 1.0 + d4 * d10;
            double d11 = -2.056338416977607E-7 + d9 / d10 * d4;
            d11 = 1.133027231981696E-6 + d4 * d11;
            d11 = -1.2504934821426706E-6 + d4 * d11;
            d11 = -2.013485478078824E-5 + d4 * d11;
            d11 = 1.280502823881162E-4 + d4 * d11;
            d11 = -2.1524167411495098E-4 + d4 * d11;
            d11 = -0.0011651675918590652 + d4 * d11;
            d11 = 0.0072189432466631 + d4 * d11;
            d11 = -0.009621971527876973 + d4 * d11;
            d11 = -0.04219773455554433 + d4 * d11;
            d11 = 0.16653861138229148 + d4 * d11;
            d11 = -0.04200263503409524 + d4 * d11;
            d11 = -0.6558780715202539 + d4 * d11;
            d11 = 0.5772156649015329 + d4 * d11;
            d3 = d2 > 0.5 ? d4 / d2 * (d11 - 0.5 - 0.5) : d2 * d11;
        }
        return d3;
    }

    public static double c(double d2) {
        if (d2 < -0.5) {
            throw new pn_0(d2, (Number)-0.5, true);
        }
        if (d2 > 1.5) {
            throw new pm_0(d2, (Number)1.5, true);
        }
        return -BY.l(zY.g(d2));
    }

    public static double d(double d2) {
        double d3;
        double d4;
        double d5 = d2;
        if (d5 == BY.A(d5) && d2 <= 0.0) {
            return Double.NaN;
        }
        double d6 = BY.w(d2);
        if (d4 <= 20.0) {
            if (d2 >= 1.0) {
                double d7 = 1.0;
                double d8 = d2;
                while (d8 > 2.5) {
                    d7 *= (d8 -= 1.0);
                }
                d3 = d7 / (1.0 + zY.g(d8 - 1.0));
            } else {
                double d9 = d2;
                double d10 = d2;
                while (d10 < -0.5) {
                    d9 *= (d10 += 1.0);
                }
                d3 = 1.0 / (d9 * (1.0 + zY.g(d10)));
            }
        } else {
            double d11 = d6 + 4.7421875 + 0.5;
            double d12 = 2.5066282746310007 / d6 * BY.a(d11, d6 + 0.5) * BY.i(-d11) * zY.b(d6);
            d3 = d2 > 0.0 ? d12 : -Math.PI / (d2 * BY.n(Math.PI * d2) * d12);
        }
        return d3;
    }
}

