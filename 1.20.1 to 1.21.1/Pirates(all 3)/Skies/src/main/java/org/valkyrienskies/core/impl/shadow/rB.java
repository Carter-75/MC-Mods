/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.text.NumberFormat;
import java.util.Locale;
import org.valkyrienskies.core.impl.shadow.BS;
import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.ch_0;
import org.valkyrienskies.core.impl.shadow.ci_0;
import org.valkyrienskies.core.impl.shadow.oS;
import org.valkyrienskies.core.impl.shadow.oU;
import org.valkyrienskies.core.impl.shadow.px_0;
import org.valkyrienskies.core.impl.shadow.qM;
import org.valkyrienskies.core.impl.shadow.qN;
import org.valkyrienskies.core.impl.shadow.qO;
import org.valkyrienskies.core.impl.shadow.rC;
import org.valkyrienskies.core.impl.shadow.rs_0;
import org.valkyrienskies.core.impl.shadow.rv_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class rB
implements qO<rv_0> {
    public static final rB a = new rB(0.0, 0.0);
    public static final rB b = new rB(Double.NaN, Double.NaN);
    private static rB e;
    private static rB f;
    private static final long g = 266938651998679754L;
    public final double c;
    public final double d;

    public rB(double d2, double d3) {
        this.c = d2;
        this.d = d3;
    }

    private rB(double[] dArray) {
        if (dArray.length != 2) {
            throw new oS(dArray.length, 2);
        }
        this.c = dArray[0];
        this.d = dArray[1];
    }

    private rB(double d2, rB rB2) {
        this.c = d2 * rB2.c;
        this.d = d2 * rB2.d;
    }

    public rB(double d2, rB rB2, double d3, rB rB3) {
        this.c = 0.5 * rB2.c + 0.5 * rB3.c;
        this.d = 0.5 * rB2.d + 0.5 * rB3.d;
    }

    private rB(double d2, rB rB2, double d3, rB rB3, double d4, rB rB4) {
        this.c = d2 * rB2.c + d3 * rB3.c + d4 * rB4.c;
        this.d = d2 * rB2.d + d3 * rB3.d + d4 * rB4.d;
    }

    private rB(double d2, rB rB2, double d3, rB rB3, double d4, rB rB4, double d5, rB rB5) {
        this.c = d2 * rB2.c + d3 * rB3.c + d4 * rB4.c + d5 * rB5.c;
        this.d = d2 * rB2.d + d3 * rB3.d + d4 * rB4.d + d5 * rB5.d;
    }

    public final double k() {
        return this.c;
    }

    public final double l() {
        return this.d;
    }

    private double[] m() {
        return new double[]{this.c, this.d};
    }

    @Override
    public final qN a() {
        return rv_0.a.a();
    }

    private static rB n() {
        return a;
    }

    @Override
    public final double d() {
        return BY.w(this.c) + BY.w(this.d);
    }

    @Override
    public final double e() {
        return BY.a(this.c * this.c + this.d * this.d);
    }

    @Override
    public final double f() {
        return this.c * this.c + this.d * this.d;
    }

    @Override
    public final double g() {
        return BY.e(BY.w(this.c), BY.w(this.d));
    }

    private rB h(qO<rv_0> rB2) {
        rB rB3 = rB2 = (rB)rB2;
        rB rB4 = rB3;
        rB4 = rB2;
        return new rB(this.c + rB3.c, this.d + rB4.d);
    }

    private rB c(double d2, qO<rv_0> rB2) {
        rB rB3 = rB2 = (rB)rB2;
        rB rB4 = rB3;
        rB4 = rB2;
        return new rB(this.c + d2 * rB3.c, this.d + d2 * rB4.d);
    }

    public final rB g(qO<rv_0> rB2) {
        rB2 = rB2;
        return new rB(this.c - rB2.c, this.d - rB2.d);
    }

    private rB d(double d2, qO<rv_0> rB2) {
        rB rB3 = rB2 = (rB)rB2;
        rB rB4 = rB3;
        rB4 = rB2;
        return new rB(this.c - d2 * rB3.c, this.d - d2 * rB4.d);
    }

    private rB o() {
        double d2 = this.e();
        if (d2 == 0.0) {
            throw new oU(px_0.CANNOT_NORMALIZE_A_ZERO_NORM_VECTOR, new Object[0]);
        }
        return this.b(1.0 / d2);
    }

    public static double a(rB rB2, rB rB3) {
        double d2;
        double d3 = rB2.e() * rB3.e();
        if (d3 == 0.0) {
            throw new oU(px_0.ZERO_NORM, new Object[0]);
        }
        double d4 = rB2.f(rB3);
        if (d4 < -(d2 = d3 * 0.9999) || d4 > d2) {
            double d5 = BY.w(ch_0.a(rB2.c, rB3.d, -rB2.d, rB3.c));
            if (d4 >= 0.0) {
                return BY.r(d5 / d3);
            }
            return Math.PI - BY.r(d5 / d3);
        }
        return BY.s(d4 / d3);
    }

    private rB p() {
        return new rB(-this.c, -this.d);
    }

    private rB b(double d2) {
        return new rB(d2 * this.c, d2 * this.d);
    }

    @Override
    public final boolean b() {
        return Double.isNaN(this.c) || Double.isNaN(this.d);
    }

    @Override
    public final boolean j() {
        return !this.b() && (Double.isInfinite(this.c) || Double.isInfinite(this.d));
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    @Override
    public final double a(rs_0 qO2) {
        qO2 = (rB)qO2;
        double d2 = BY.w(((rB)qO2).c - this.c);
        double d3 = BY.w(((rB)qO2).d - this.d);
        return d2 + d3;
    }

    @Override
    public final double c(qO<rv_0> qO2) {
        return this.a((qM<rv_0>)qO2);
    }

    @Override
    public final double a(qM<rv_0> rB2) {
        rB2 = rB2;
        double d2 = rB2.c - this.c;
        double d3 = rB2.d - this.d;
        double d4 = d2;
        double d5 = d3;
        return BY.a(d4 * d4 + d5 * d5);
    }

    @Override
    public final double d(qO<rv_0> rB2) {
        rB2 = rB2;
        double d2 = BY.w(rB2.c - this.c);
        double d3 = BY.w(rB2.d - this.d);
        return BY.e(d2, d3);
    }

    @Override
    public final double e(qO<rv_0> rB2) {
        rB2 = rB2;
        double d2 = rB2.c - this.c;
        double d3 = rB2.d - this.d;
        double d4 = d2;
        double d5 = d3;
        return d4 * d4 + d5 * d5;
    }

    @Override
    public final double f(qO<rv_0> rB2) {
        rB2 = rB2;
        return ch_0.a(this.c, rB2.c, this.d, rB2.d);
    }

    public final double b(rB rB2, rB rB3) {
        rB rB4 = rB3;
        rB rB5 = rB4;
        rB5 = rB2;
        double d2 = rB4.c - rB5.c;
        rB rB6 = this;
        rB5 = rB6;
        rB5 = rB2;
        double d3 = rB6.d - rB5.d;
        rB rB7 = this;
        rB5 = rB7;
        rB5 = rB2;
        double d4 = rB7.c - rB5.c;
        rB rB8 = rB3;
        rB5 = rB8;
        rB5 = rB2;
        double d5 = rB8.d - rB5.d;
        return ch_0.a(d2, d3, -d4, d5);
    }

    public static double c(rB rB2, rB rB3) {
        return rB2.a((qM<rv_0>)rB3);
    }

    private static double d(rB rB2, rB rB3) {
        return rB2.d(rB3);
    }

    private static double e(rB rB2, rB rB3) {
        return rB2.e(rB3);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof rB) {
            rB rB2;
            if ((rB2 = (rB)rB2).b()) {
                return this.b();
            }
            return this.c == rB2.c && this.d == rB2.d;
        }
        return false;
    }

    public int hashCode() {
        if (this.b()) {
            return 542;
        }
        return 122 * (76 * ci_0.a(this.c) + ci_0.a(this.d));
    }

    public String toString() {
        Locale locale = Locale.getDefault();
        return new rC(BS.a(locale)).a(this);
    }

    @Override
    public final String a(NumberFormat numberFormat) {
        return new rC(numberFormat).a(this);
    }

    @Override
    public final /* synthetic */ qO a(double d2) {
        return this.b(d2);
    }

    @Override
    public final /* synthetic */ qO i() {
        rB rB2 = this;
        double d2 = rB2.e();
        if (d2 == 0.0) {
            throw new oU(px_0.CANNOT_NORMALIZE_A_ZERO_NORM_VECTOR, new Object[0]);
        }
        return rB2.b(1.0 / d2);
    }

    @Override
    public final /* synthetic */ qO h() {
        rB rB2 = this;
        return new rB(-rB2.c, -rB2.d);
    }

    @Override
    public final /* synthetic */ qO b(double d2, qO qO2) {
        qO qO3 = qO2;
        double d3 = d2;
        rB rB2 = this;
        qO qO4 = qO3 = (rB)qO3;
        qO2 = qO4;
        qO2 = qO3;
        return new rB(rB2.c - d3 * ((rB)qO4).c, rB2.d - d3 * ((rB)qO2).d);
    }

    @Override
    public final /* synthetic */ qO b(qO qO2) {
        return this.g(qO2);
    }

    @Override
    public final /* synthetic */ qO a(double d2, qO qO2) {
        qO qO3 = qO2;
        double d3 = d2;
        rB rB2 = this;
        qO qO4 = qO3 = (rB)qO3;
        qO2 = qO4;
        qO2 = qO3;
        return new rB(rB2.c + d3 * ((rB)qO4).c, rB2.d + d3 * ((rB)qO2).d);
    }

    @Override
    public final /* synthetic */ qO a(qO qO2) {
        qO qO3 = qO2;
        qO2 = this;
        qO qO4 = qO3 = (rB)qO3;
        qO qO5 = qO4;
        qO5 = qO3;
        return new rB(((rB)qO2).c + ((rB)qO4).c, ((rB)qO2).d + ((rB)qO5).d);
    }

    static {
        new rB(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
        new rB(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY);
    }
}

