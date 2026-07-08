/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Locale;
import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.ch_0;
import org.valkyrienskies.core.impl.shadow.ci_0;
import org.valkyrienskies.core.impl.shadow.oS;
import org.valkyrienskies.core.impl.shadow.oU;
import org.valkyrienskies.core.impl.shadow.px_0;
import org.valkyrienskies.core.impl.shadow.qM;
import org.valkyrienskies.core.impl.shadow.qN;
import org.valkyrienskies.core.impl.shadow.qO;
import org.valkyrienskies.core.impl.shadow.rc_0;
import org.valkyrienskies.core.impl.shadow.rt_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.rs
 */
public class rs_0
implements Serializable,
qO<rc_0> {
    public static final rs_0 a = new rs_0(0.0, 0.0, 0.0);
    public static final rs_0 b = new rs_0(1.0, 0.0, 0.0);
    public static final rs_0 c = new rs_0(-1.0, 0.0, 0.0);
    public static final rs_0 d = new rs_0(0.0, 1.0, 0.0);
    public static final rs_0 e = new rs_0(0.0, -1.0, 0.0);
    public static final rs_0 f = new rs_0(0.0, 0.0, 1.0);
    public static final rs_0 g = new rs_0(0.0, 0.0, -1.0);
    public static final rs_0 h = new rs_0(Double.NaN, Double.NaN, Double.NaN);
    private static rs_0 l;
    private static rs_0 m;
    private static final long n = 1313493323784566947L;
    public final double i;
    public final double j;
    final double k;

    public rs_0(double d2, double d3, double d4) {
        this.i = d2;
        this.j = d3;
        this.k = d4;
    }

    private rs_0(double[] dArray) {
        if (dArray.length != 3) {
            throw new oS(dArray.length, 3);
        }
        this.i = dArray[0];
        this.j = dArray[1];
        this.k = dArray[2];
    }

    private rs_0(double d2, double d3) {
        double d4 = BY.o(d3);
        this.i = BY.o(d2) * d4;
        this.j = BY.n(d2) * d4;
        this.k = BY.n(d3);
    }

    public rs_0(double d2, rs_0 rs_02) {
        this.i = d2 * rs_02.i;
        this.j = d2 * rs_02.j;
        this.k = d2 * rs_02.k;
    }

    public rs_0(double d2, rs_0 rs_02, double d3, rs_0 rs_03) {
        this.i = ch_0.a(d2, rs_02.i, d3, rs_03.i);
        this.j = ch_0.a(d2, rs_02.j, d3, rs_03.j);
        this.k = ch_0.a(d2, rs_02.k, d3, rs_03.k);
    }

    public rs_0(double d2, rs_0 rs_02, double d3, rs_0 rs_03, double d4, rs_0 rs_04) {
        this.i = ch_0.a(d2, rs_02.i, d3, rs_03.i, d4, rs_04.i);
        this.j = ch_0.a(d2, rs_02.j, d3, rs_03.j, d4, rs_04.j);
        this.k = ch_0.a(d2, rs_02.k, d3, rs_03.k, d4, rs_04.k);
    }

    private rs_0(double d2, rs_0 rs_02, double d3, rs_0 rs_03, double d4, rs_0 rs_04, double d5, rs_0 rs_05) {
        this.i = ch_0.a(d2, rs_02.i, d3, rs_03.i, d4, rs_04.i, d5, rs_05.i);
        this.j = ch_0.a(d2, rs_02.j, d3, rs_03.j, d4, rs_04.j, d5, rs_05.j);
        this.k = ch_0.a(d2, rs_02.k, d3, rs_03.k, d4, rs_04.k, d5, rs_05.k);
    }

    public final double k() {
        return this.i;
    }

    public final double l() {
        return this.j;
    }

    public final double m() {
        return this.k;
    }

    private double[] r() {
        return new double[]{this.i, this.j, this.k};
    }

    @Override
    public final qN a() {
        return rc_0.a.a();
    }

    private static rs_0 s() {
        return a;
    }

    @Override
    public final double d() {
        return BY.w(this.i) + BY.w(this.j) + BY.w(this.k);
    }

    @Override
    public final double e() {
        return BY.a(this.i * this.i + this.j * this.j + this.k * this.k);
    }

    @Override
    public final double f() {
        return this.i * this.i + this.j * this.j + this.k * this.k;
    }

    @Override
    public final double g() {
        return BY.e(BY.e(BY.w(this.i), BY.w(this.j)), BY.w(this.k));
    }

    public final double n() {
        return BY.b(this.j, this.i);
    }

    private double t() {
        return BY.r(this.k / this.e());
    }

    public final rs_0 g(qO<rc_0> rs_02) {
        rs_02 = rs_02;
        return new rs_0(this.i + rs_02.i, this.j + rs_02.j, this.k + rs_02.k);
    }

    private rs_0 c(double d2, qO<rc_0> qO2) {
        return new rs_0(1.0, this, d2, (rs_0)qO2);
    }

    public final rs_0 h(qO<rc_0> rs_02) {
        rs_02 = rs_02;
        return new rs_0(this.i - rs_02.i, this.j - rs_02.j, this.k - rs_02.k);
    }

    private rs_0 d(double d2, qO<rc_0> qO2) {
        return new rs_0(1.0, this, -d2, (rs_0)qO2);
    }

    public final rs_0 o() {
        double d2 = this.e();
        if (d2 == 0.0) {
            throw new oU(px_0.CANNOT_NORMALIZE_A_ZERO_NORM_VECTOR, new Object[0]);
        }
        return this.b(1.0 / d2);
    }

    public final rs_0 p() {
        double d2 = 0.6 * this.e();
        if (d2 == 0.0) {
            throw new oU(px_0.ZERO_NORM, new Object[0]);
        }
        if (BY.w(this.i) <= d2) {
            double d3 = 1.0 / BY.a(this.j * this.j + this.k * this.k);
            return new rs_0(0.0, d3 * this.k, -d3 * this.j);
        }
        if (BY.w(this.j) <= d2) {
            double d4 = 1.0 / BY.a(this.i * this.i + this.k * this.k);
            return new rs_0(-d4 * this.k, 0.0, d4 * this.i);
        }
        double d5 = 1.0 / BY.a(this.i * this.i + this.j * this.j);
        return new rs_0(d5 * this.j, -d5 * this.i, 0.0);
    }

    public static double a(rs_0 rs_02, rs_0 rs_03) {
        double d2;
        double d3 = rs_02.e() * rs_03.e();
        if (d3 == 0.0) {
            throw new oU(px_0.ZERO_NORM, new Object[0]);
        }
        double d4 = rs_02.f(rs_03);
        if (d4 < -(d2 = d3 * 0.9999) || d4 > d2) {
            rs_02 = rs_02.b(rs_03);
            if (d4 >= 0.0) {
                return BY.r(rs_02.e() / d3);
            }
            return Math.PI - BY.r(rs_02.e() / d3);
        }
        return BY.s(d4 / d3);
    }

    public final rs_0 q() {
        return new rs_0(-this.i, -this.j, -this.k);
    }

    private rs_0 b(double d2) {
        return new rs_0(d2 * this.i, d2 * this.j, d2 * this.k);
    }

    @Override
    public final boolean b() {
        return Double.isNaN(this.i) || Double.isNaN(this.j) || Double.isNaN(this.k);
    }

    @Override
    public final boolean j() {
        return !this.b() && (Double.isInfinite(this.i) || Double.isInfinite(this.j) || Double.isInfinite(this.k));
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof rs_0) {
            rs_0 rs_02;
            if ((rs_02 = (rs_0)rs_02).b()) {
                return this.b();
            }
            return this.i == rs_02.i && this.j == rs_02.j && this.k == rs_02.k;
        }
        return false;
    }

    public int hashCode() {
        if (this.b()) {
            return 642;
        }
        return 643 * (164 * ci_0.a(this.i) + 3 * ci_0.a(this.j) + ci_0.a(this.k));
    }

    @Override
    public final double f(qO<rc_0> rs_02) {
        rs_02 = rs_02;
        return ch_0.a(this.i, rs_02.i, this.j, rs_02.j, this.k, rs_02.k);
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    public final rs_0 b(rs_0 rs_02) {
        return new rs_0(ch_0.a(this.j, rs_02.k, -this.k, rs_02.j), ch_0.a(this.k, rs_02.i, -this.i, rs_02.k), ch_0.a(this.i, rs_02.j, -this.j, rs_02.i));
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    @Override
    public final double a(rs_0 rs_02) {
        double d2 = BY.w(rs_02.i - this.i);
        double d3 = BY.w(rs_02.j - this.j);
        double d4 = BY.w(rs_02.k - this.k);
        return d2 + d3 + d4;
    }

    @Override
    public final double c(qO<rc_0> qO2) {
        return this.a((qM<rc_0>)qO2);
    }

    @Override
    public final double a(qM<rc_0> rs_02) {
        rs_02 = rs_02;
        double d2 = rs_02.i - this.i;
        double d3 = rs_02.j - this.j;
        double d4 = rs_02.k - this.k;
        double d5 = d2;
        double d6 = d3;
        double d7 = d4;
        return BY.a(d5 * d5 + d6 * d6 + d7 * d7);
    }

    @Override
    public final double d(qO<rc_0> rs_02) {
        rs_02 = rs_02;
        double d2 = BY.w(rs_02.i - this.i);
        double d3 = BY.w(rs_02.j - this.j);
        double d4 = BY.w(rs_02.k - this.k);
        return BY.e(BY.e(d2, d3), d4);
    }

    @Override
    public final double e(qO<rc_0> rs_02) {
        rs_02 = rs_02;
        double d2 = rs_02.i - this.i;
        double d3 = rs_02.j - this.j;
        double d4 = rs_02.k - this.k;
        double d5 = d2;
        double d6 = d3;
        double d7 = d4;
        return d5 * d5 + d6 * d6 + d7 * d7;
    }

    public static double b(rs_0 rs_02, rs_0 rs_03) {
        return rs_02.f(rs_03);
    }

    public static rs_0 c(rs_0 rs_02, rs_0 rs_03) {
        return rs_02.b(rs_03);
    }

    private static double e(rs_0 rs_02, rs_0 rs_03) {
        double d2 = BY.w(rs_03.i - rs_02.i);
        double d3 = BY.w(rs_03.j - rs_02.j);
        double d4 = BY.w(rs_03.k - rs_02.k);
        return d2 + d3 + d4;
    }

    public static double d(rs_0 rs_02, rs_0 rs_03) {
        return rs_02.a((qM<rc_0>)rs_03);
    }

    private static double f(rs_0 rs_02, rs_0 rs_03) {
        return rs_02.d(rs_03);
    }

    private static double g(rs_0 rs_02, rs_0 rs_03) {
        return rs_02.e(rs_03);
    }

    public String toString() {
        return rt_0.a(Locale.getDefault()).a(this);
    }

    @Override
    public final String a(NumberFormat numberFormat) {
        return new rt_0(numberFormat).a(this);
    }

    @Override
    public final /* synthetic */ qO a(double d2) {
        return this.b(d2);
    }

    @Override
    public final /* synthetic */ qO i() {
        return this.o();
    }

    @Override
    public final /* synthetic */ qO h() {
        return this.q();
    }

    @Override
    public final /* synthetic */ qO b(double d2, qO qO2) {
        qO qO3 = qO2;
        double d3 = d2;
        rs_0 rs_02 = this;
        return new rs_0(1.0, rs_02, -d3, (rs_0)qO3);
    }

    @Override
    public final /* synthetic */ qO b(qO qO2) {
        return this.h(qO2);
    }

    @Override
    public final /* synthetic */ qO a(double d2, qO qO2) {
        qO qO3 = qO2;
        double d3 = d2;
        rs_0 rs_02 = this;
        return new rs_0(1.0, rs_02, d3, (rs_0)qO3);
    }

    @Override
    public final /* synthetic */ qO a(qO qO2) {
        return this.g(qO2);
    }

    static {
        new rs_0(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
        new rs_0(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY);
    }
}

