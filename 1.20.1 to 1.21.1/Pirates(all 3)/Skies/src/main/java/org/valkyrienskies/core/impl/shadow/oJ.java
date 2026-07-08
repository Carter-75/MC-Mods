/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.zY;

final class oJ {
    private static final double a = 0.5 * BY.k(Math.PI * 2);
    private static final double[] b = new double[]{0.0, 0.15342640972002736, 0.08106146679532726, 0.05481412105191765, 0.0413406959554093, 0.03316287351993629, 0.02767792568499834, 0.023746163656297496, 0.020790672103765093, 0.018488450532673187, 0.016644691189821193, 0.015134973221917378, 0.013876128823070748, 0.012810465242920227, 0.01189670994589177, 0.011104559758206917, 0.010411265261972096, 0.009799416126158804, 0.009255462182712733, 0.008768700134139386, 0.00833056343336287, 0.00793411456431402, 0.007573675487951841, 0.007244554301320383, 0.00694284010720953, 0.006665247032707682, 0.006408994188004207, 0.006171712263039458, 0.0059513701127588475, 0.0057462165130101155, 0.005554733551962801};

    private oJ() {
    }

    static double a(double d2) {
        double d3;
        if (d2 < 15.0) {
            double d4 = d2 * 2.0;
            d3 = BY.y(d4) == d4 ? b[(int)d4] : zY.a(d2 + 1.0) - (d2 + 0.5) * BY.k(d2) + d2 - a;
        } else {
            double d5 = d2;
            double d6 = d5 * d5;
            d3 = (0.08333333333333333 - (0.002777777777777778 - (7.936507936507937E-4 - (5.952380952380953E-4 - 8.417508417508417E-4 / d6) / d6) / d6) / d6) / d2;
        }
        return d3;
    }

    static double a(double d2, double d3) {
        double d4;
        if (BY.w(d2 - d3) < 0.1 * (d2 + d3)) {
            double d5 = d2 - d3;
            double d6 = d5 / (d2 + d3);
            double d7 = d6 * d5;
            double d8 = Double.NaN;
            double d9 = d2 * 2.0 * d6;
            double d10 = d6;
            d6 = d10 * d10;
            int n2 = 1;
            while (d7 != d8) {
                d8 = d7;
                d7 = d8 + (d9 *= d6) / (double)((n2 << 1) + 1);
                ++n2;
            }
            d4 = d7;
        } else {
            double d11 = d2;
            d4 = d11 * BY.k(d11 / d3) + d3 - d2;
        }
        return d4;
    }

    static double a(int n2, int n3, double d2, double d3) {
        double d4;
        if (n2 == 0) {
            d4 = d2 < 0.1 ? -oJ.a(n3, (double)n3 * d3) - (double)n3 * d2 : (double)n3 * BY.k(d3);
        } else if (n2 == n3) {
            d4 = d3 < 0.1 ? -oJ.a(n3, (double)n3 * d2) - (double)n3 * d3 : (double)n3 * BY.k(d2);
        } else {
            d4 = oJ.a(n3) - oJ.a(n2) - oJ.a(n3 - n2) - oJ.a(n2, (double)n3 * d2) - oJ.a(n3 - n2, (double)n3 * d3);
            double d5 = Math.PI * 2 * (double)n2 * (double)(n3 - n2) / (double)n3;
            d4 = -0.5 * BY.k(d5) + d4;
        }
        return d4;
    }
}

