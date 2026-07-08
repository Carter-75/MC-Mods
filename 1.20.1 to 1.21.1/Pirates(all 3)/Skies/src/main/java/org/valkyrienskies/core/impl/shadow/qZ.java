/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.text.NumberFormat;
import java.util.Locale;
import org.valkyrienskies.core.impl.shadow.BS;
import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.ci_0;
import org.valkyrienskies.core.impl.shadow.oU;
import org.valkyrienskies.core.impl.shadow.px_0;
import org.valkyrienskies.core.impl.shadow.qM;
import org.valkyrienskies.core.impl.shadow.qN;
import org.valkyrienskies.core.impl.shadow.qO;
import org.valkyrienskies.core.impl.shadow.qU;
import org.valkyrienskies.core.impl.shadow.ra_0;
import org.valkyrienskies.core.impl.shadow.rs_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class qZ
implements qO<qU> {
    public static final qZ a = new qZ(0.0);
    public static final qZ b = new qZ(1.0);
    public static final qZ c = new qZ(Double.NaN);
    private static qZ e;
    private static qZ f;
    private static final long g = 7556674948671647925L;
    public final double d;

    public qZ(double d2) {
        this.d = d2;
    }

    private qZ(double d2, qZ qZ2) {
        this.d = d2 * qZ2.d;
    }

    private qZ(double d2, qZ qZ2, double d3, qZ qZ3) {
        this.d = d2 * qZ2.d + d3 * qZ3.d;
    }

    private qZ(double d2, qZ qZ2, double d3, qZ qZ3, double d4, qZ qZ4) {
        this.d = d2 * qZ2.d + d3 * qZ3.d + d4 * qZ4.d;
    }

    private qZ(double d2, qZ qZ2, double d3, qZ qZ3, double d4, qZ qZ4, double d5, qZ qZ5) {
        this.d = d2 * qZ2.d + d3 * qZ3.d + d4 * qZ4.d + d5 * qZ5.d;
    }

    public final double k() {
        return this.d;
    }

    @Override
    public final qN a() {
        return qU.a.a();
    }

    private static qZ l() {
        return a;
    }

    @Override
    public final double d() {
        return BY.w(this.d);
    }

    @Override
    public final double e() {
        return BY.w(this.d);
    }

    @Override
    public final double f() {
        return this.d * this.d;
    }

    @Override
    public final double g() {
        return BY.w(this.d);
    }

    private qZ g(qO<qU> qZ2) {
        qZ2 = qZ2;
        return new qZ(this.d + qZ2.d);
    }

    private qZ c(double d2, qO<qU> qZ2) {
        qZ qZ3 = qZ2 = (qZ)qZ2;
        return new qZ(this.d + d2 * qZ3.d);
    }

    private qZ h(qO<qU> qZ2) {
        qZ2 = qZ2;
        return new qZ(this.d - qZ2.d);
    }

    private qZ d(double d2, qO<qU> qZ2) {
        qZ qZ3 = qZ2 = (qZ)qZ2;
        return new qZ(this.d - d2 * qZ3.d);
    }

    private qZ m() {
        qZ qZ2 = this;
        double d2 = BY.w(qZ2.d);
        if (d2 == 0.0) {
            throw new oU(px_0.CANNOT_NORMALIZE_A_ZERO_NORM_VECTOR, new Object[0]);
        }
        return this.b(1.0 / d2);
    }

    private qZ n() {
        return new qZ(-this.d);
    }

    private qZ b(double d2) {
        return new qZ(d2 * this.d);
    }

    @Override
    public final boolean b() {
        return Double.isNaN(this.d);
    }

    @Override
    public final boolean j() {
        qZ qZ2 = this;
        return !Double.isNaN(qZ2.d) && Double.isInfinite(this.d);
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    @Override
    public final double a(rs_0 qO2) {
        qO2 = (qZ)qO2;
        double d2 = BY.w(((qZ)qO2).d - this.d);
        return d2;
    }

    @Override
    @Deprecated
    public final double c(qO<qU> qO2) {
        return this.a((qM<qU>)qO2);
    }

    @Override
    public final double a(qM<qU> qZ2) {
        qZ2 = qZ2;
        double d2 = qZ2.d - this.d;
        return BY.w(d2);
    }

    @Override
    public final double d(qO<qU> qZ2) {
        qZ2 = qZ2;
        double d2 = BY.w(qZ2.d - this.d);
        return d2;
    }

    @Override
    public final double e(qO<qU> qZ2) {
        qZ2 = qZ2;
        double d2 = qZ2.d - this.d;
        return d2 * d2;
    }

    @Override
    public final double f(qO<qU> qZ2) {
        qZ2 = qZ2;
        return this.d * qZ2.d;
    }

    private static double a(qZ qZ2, qZ qZ3) {
        return qZ2.a((qM<qU>)qZ3);
    }

    private static double b(qZ qZ2, qZ qZ3) {
        return qZ2.d(qZ3);
    }

    private static double c(qZ qZ2, qZ qZ3) {
        return qZ2.e(qZ3);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof qZ) {
            qZ qZ2;
            qZ qZ3 = qZ2 = (qZ)qZ2;
            if (Double.isNaN(qZ2.d)) {
                qZ3 = this;
                return Double.isNaN(qZ3.d);
            }
            return this.d == qZ2.d;
        }
        return false;
    }

    public int hashCode() {
        qZ qZ2 = this;
        if (Double.isNaN(qZ2.d)) {
            return 7785;
        }
        return 997 * ci_0.a(this.d);
    }

    public String toString() {
        Locale locale = Locale.getDefault();
        return new ra_0(BS.a(locale)).a(this);
    }

    @Override
    public final String a(NumberFormat numberFormat) {
        return new ra_0(numberFormat).a(this);
    }

    @Override
    public final /* synthetic */ qO a(double d2) {
        return this.b(d2);
    }

    @Override
    public final /* synthetic */ qO i() {
        qZ qZ2;
        qZ qZ3 = qZ2 = this;
        double d2 = BY.w(qZ2.d);
        if (d2 == 0.0) {
            throw new oU(px_0.CANNOT_NORMALIZE_A_ZERO_NORM_VECTOR, new Object[0]);
        }
        return qZ2.b(1.0 / d2);
    }

    @Override
    public final /* synthetic */ qO h() {
        qZ qZ2 = this;
        return new qZ(-qZ2.d);
    }

    @Override
    public final /* synthetic */ qO b(double d2, qO qO2) {
        qO qO3 = qO2;
        double d3 = d2;
        qO<qU> qO4 = this;
        qO3 = (qZ)qO3;
        qO4 = qO3;
        return new qZ(qO4.d - d3 * qO4.d);
    }

    @Override
    public final /* synthetic */ qO b(qO qO2) {
        qO qO3 = qO2;
        qO2 = this;
        qO3 = (qZ)qO3;
        return new qZ(((qZ)qO2).d - ((qZ)qO3).d);
    }

    @Override
    public final /* synthetic */ qO a(double d2, qO qO2) {
        qO qO3 = qO2;
        double d3 = d2;
        qO<qU> qO4 = this;
        qO3 = (qZ)qO3;
        qO4 = qO3;
        return new qZ(qO4.d + d3 * qO4.d);
    }

    @Override
    public final /* synthetic */ qO a(qO qO2) {
        qO qO3 = qO2;
        qO2 = this;
        qO2 = qO3 = (qZ)qO3;
        return new qZ(((qZ)qO2).d + ((qZ)qO2).d);
    }

    static {
        new qZ(Double.POSITIVE_INFINITY);
        new qZ(Double.NEGATIVE_INFINITY);
    }
}

