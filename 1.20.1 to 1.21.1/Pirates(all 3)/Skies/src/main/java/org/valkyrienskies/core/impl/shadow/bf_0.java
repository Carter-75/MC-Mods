/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.aa_0;
import org.valkyrienskies.core.impl.shadow.at_0;
import org.valkyrienskies.core.impl.shadow.oK;
import org.valkyrienskies.core.impl.shadow.pl_0;
import org.valkyrienskies.core.impl.shadow.pn_0;
import org.valkyrienskies.core.impl.shadow.po_0;
import org.valkyrienskies.core.impl.shadow.pw_0;
import org.valkyrienskies.core.impl.shadow.px_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Bf
 */
public final class bf_0 {
    public final double a(double[] dArray, double[] dArray2) {
        bf_0.a(dArray);
        bf_0.a(dArray2);
        double d2 = aa_0.a(dArray, dArray2);
        return bf_0.b(d2, 0.0, aa_0.a(dArray, dArray2, d2), dArray.length);
    }

    public final double b(double[] dArray, double[] dArray2) {
        double d2 = aa_0.a(dArray, dArray2);
        return this.c(d2, 0.0, aa_0.a(dArray, dArray2, d2), dArray.length);
    }

    public final boolean a(double[] dArray, double[] dArray2, double d2) {
        bf_0.a(d2);
        return this.b(dArray, dArray2) < d2;
    }

    public final double a(double d2, double[] dArray) {
        bf_0.a(dArray);
        return bf_0.b(aa_0.b(dArray), d2, aa_0.c(dArray), dArray.length);
    }

    public final double a(double d2, at_0 at_02) {
        bf_0.a(at_02);
        return bf_0.b(at_02.b(), d2, at_02.g(), at_02.d());
    }

    public final double c(double[] dArray, double[] dArray2) {
        bf_0.a(dArray);
        bf_0.a(dArray2);
        return bf_0.b(aa_0.b(dArray), aa_0.b(dArray2), aa_0.c(dArray), aa_0.c(dArray2), dArray.length, dArray2.length);
    }

    public final double d(double[] dArray, double[] dArray2) {
        bf_0.a(dArray);
        bf_0.a(dArray2);
        return bf_0.a(aa_0.b(dArray), aa_0.b(dArray2), aa_0.c(dArray), aa_0.c(dArray2), dArray.length, dArray2.length);
    }

    public final double a(at_0 at_02, at_0 at_03) {
        bf_0.a(at_02);
        bf_0.a(at_03);
        return bf_0.a(at_02.b(), at_03.b(), at_02.g(), at_03.g(), at_02.d(), at_03.d());
    }

    public final double b(at_0 at_02, at_0 at_03) {
        bf_0.a(at_02);
        bf_0.a(at_03);
        return bf_0.b(at_02.b(), at_03.b(), at_02.g(), at_03.g(), at_02.d(), at_03.d());
    }

    public final double b(double d2, double[] dArray) {
        bf_0.a(dArray);
        return this.c(aa_0.b(dArray), d2, aa_0.c(dArray), dArray.length);
    }

    public final boolean a(double d2, double[] dArray, double d3) {
        bf_0.a(d3);
        return this.b(d2, dArray) < d3;
    }

    public final double b(double d2, at_0 at_02) {
        bf_0.a(at_02);
        return this.c(at_02.b(), d2, at_02.g(), at_02.d());
    }

    public final boolean a(double d2, at_0 at_02, double d3) {
        bf_0.a(d3);
        return this.b(d2, at_02) < d3;
    }

    public final double e(double[] dArray, double[] dArray2) {
        bf_0.a(dArray);
        bf_0.a(dArray2);
        return this.c(aa_0.b(dArray), aa_0.b(dArray2), aa_0.c(dArray), aa_0.c(dArray2), dArray.length, dArray2.length);
    }

    public final double f(double[] dArray, double[] dArray2) {
        bf_0.a(dArray);
        bf_0.a(dArray2);
        return this.d(aa_0.b(dArray), aa_0.b(dArray2), aa_0.c(dArray), aa_0.c(dArray2), dArray.length, dArray2.length);
    }

    public final boolean b(double[] dArray, double[] dArray2, double d2) {
        bf_0.a(d2);
        return this.e(dArray, dArray2) < d2;
    }

    public final boolean c(double[] dArray, double[] dArray2, double d2) {
        bf_0.a(d2);
        return this.f(dArray, dArray2) < d2;
    }

    public final double c(at_0 at_02, at_0 at_03) {
        bf_0.a(at_02);
        bf_0.a(at_03);
        return this.c(at_02.b(), at_03.b(), at_02.g(), at_03.g(), at_02.d(), at_03.d());
    }

    public final double d(at_0 at_02, at_0 at_03) {
        bf_0.a(at_02);
        bf_0.a(at_03);
        return this.d(at_02.b(), at_03.b(), at_02.g(), at_03.g(), at_02.d(), at_03.d());
    }

    public final boolean a(at_0 at_02, at_0 at_03, double d2) {
        bf_0.a(d2);
        return this.c(at_02, at_03) < d2;
    }

    private static double a(double d2, double d3, double d4, double d5) {
        double d6 = d2;
        double d7 = d4;
        double d8 = d3;
        double d9 = d5;
        return (d2 / d4 + d3 / d5) * (d2 / d4 + d3 / d5) / (d6 * d6 / (d7 * d7 * (d4 - 1.0)) + d8 * d8 / (d9 * d9 * (d5 - 1.0)));
    }

    private static double b(double d2, double d3, double d4, double d5) {
        return (d2 - d3) / BY.a(d4 / d5);
    }

    private static double a(double d2, double d3, double d4, double d5, double d6, double d7) {
        return (d2 - d3) / BY.a(d4 / d6 + d5 / d7);
    }

    private static double b(double d2, double d3, double d4, double d5, double d6, double d7) {
        double d8 = ((d6 - 1.0) * d4 + (d7 - 1.0) * d5) / (d6 + d7 - 2.0);
        return (d2 - d3) / BY.a(d8 * (1.0 / d6 + 1.0 / d7));
    }

    private double c(double d2, double d3, double d4, double d5) {
        double d6 = BY.w(bf_0.b(d2, d3, d4, d5));
        oK oK2 = new oK(null, d5 - 1.0);
        return 2.0 * oK2.e(-d6);
    }

    private double c(double d2, double d3, double d4, double d5, double d6, double d7) {
        double d8 = BY.w(bf_0.a(d2, d3, d4, d5, d6, d7));
        double d9 = bf_0.a(d4, d5, d6, d7);
        oK oK2 = new oK(null, d9);
        return 2.0 * oK2.e(-d8);
    }

    private double d(double d2, double d3, double d4, double d5, double d6, double d7) {
        double d8 = BY.w(bf_0.b(d2, d3, d4, d5, d6, d7));
        double d9 = d6 + d7 - 2.0;
        oK oK2 = new oK(null, d9);
        return 2.0 * oK2.e(-d8);
    }

    private static void a(double d2) {
        if (d2 <= 0.0 || d2 > 0.5) {
            throw new po_0(px_0.SIGNIFICANCE_LEVEL, (Number)d2, 0.0, 0.5);
        }
    }

    private static void a(double[] dArray) {
        if (dArray == null) {
            throw new pl_0();
        }
        if (dArray.length < 2) {
            throw new pn_0((pw_0)px_0.INSUFFICIENT_DATA_FOR_T_STATISTIC, (Number)dArray.length, 2, true);
        }
    }

    private static void a(at_0 at_02) {
        if (at_02 == null) {
            throw new pl_0();
        }
        if (at_02.d() < 2L) {
            throw new pn_0((pw_0)px_0.INSUFFICIENT_DATA_FOR_T_STATISTIC, (Number)at_02.d(), 2, true);
        }
    }
}

