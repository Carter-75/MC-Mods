/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.ci_0;
import org.valkyrienskies.core.impl.shadow.cq_0;
import org.valkyrienskies.core.impl.shadow.kM;
import org.valkyrienskies.core.impl.shadow.kN;
import org.valkyrienskies.core.impl.shadow.nR;
import org.valkyrienskies.core.impl.shadow.pj_0;
import org.valkyrienskies.core.impl.shadow.px_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class nQ
implements Serializable,
kN<nQ> {
    private static nQ e = new nQ(0.0, 1.0);
    private static nQ f = new nQ(Double.NaN, Double.NaN);
    private static nQ g = new nQ(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
    public static final nQ a = new nQ(1.0, 0.0);
    public static final nQ b = new nQ(0.0, 0.0);
    private static final long h = -6195664516687396620L;
    public final double c;
    public final double d;
    private final transient boolean i;
    private final transient boolean j;

    private nQ(double d2) {
        this(d2, 0.0);
    }

    public nQ(double d2, double d3) {
        this.d = d2;
        this.c = d3;
        this.i = Double.isNaN(d2) || Double.isNaN(d3);
        this.j = !this.i && (Double.isInfinite(d2) || Double.isInfinite(d3));
    }

    public final double d() {
        double d2;
        if (this.i) {
            return Double.NaN;
        }
        nQ nQ2 = this;
        if (nQ2.j) {
            return Double.POSITIVE_INFINITY;
        }
        if (BY.w(this.d) < BY.w(this.c)) {
            double d3;
            if (this.c == 0.0) {
                return BY.w(this.d);
            }
            double d4 = d3 = this.d / this.c;
            return BY.w(this.c) * BY.a(1.0 + d4 * d4);
        }
        if (this.d == 0.0) {
            return BY.w(this.c);
        }
        double d5 = d2 = this.c / this.d;
        return BY.w(this.d) * BY.a(1.0 + d5 * d5);
    }

    @Override
    public final nQ a(nQ nQ2) {
        ci_0.a(nQ2);
        if (this.i || nQ2.i) {
            return f;
        }
        nQ nQ3 = nQ2;
        nQ nQ4 = nQ3;
        nQ4 = nQ2;
        return nQ.a(this.d + nQ3.d, this.c + nQ4.c);
    }

    @Override
    private nQ a(double d2) {
        if (this.i || Double.isNaN(d2)) {
            return f;
        }
        return nQ.a(this.d + d2, this.c);
    }

    private nQ h() {
        if (this.i) {
            return f;
        }
        return nQ.a(this.d, -this.c);
    }

    @Override
    public final nQ b(nQ nQ2) {
        ci_0.a(nQ2);
        if (this.i || nQ2.i) {
            return f;
        }
        nQ nQ3 = nQ2;
        double d2 = nQ3.d;
        nQ3 = nQ2;
        double d3 = nQ3.c;
        if (d2 == 0.0 && d3 == 0.0) {
            return f;
        }
        nQ3 = nQ2;
        if (nQ3.j) {
            nQ3 = this;
            if (!nQ3.j) {
                return b;
            }
        }
        if (BY.w(d2) < BY.w(d3)) {
            double d4 = d2 / d3;
            double d5 = d2 * d4 + d3;
            return nQ.a((this.d * d4 + this.c) / d5, (this.c * d4 - this.d) / d5);
        }
        double d6 = d3 / d2;
        double d7 = d3 * d6 + d2;
        return nQ.a((this.c * d6 + this.d) / d7, (this.c - this.d * d6) / d7);
    }

    @Override
    private nQ b(double d2) {
        if (this.i || Double.isNaN(d2)) {
            return f;
        }
        if (d2 == 0.0) {
            return f;
        }
        if (Double.isInfinite(d2)) {
            nQ nQ2 = this;
            if (!nQ2.j) {
                return b;
            }
            return f;
        }
        return nQ.a(this.d / d2, this.c / d2);
    }

    private nQ i() {
        if (this.i) {
            return f;
        }
        if (this.d == 0.0 && this.c == 0.0) {
            return g;
        }
        if (this.j) {
            return b;
        }
        if (BY.w(this.d) < BY.w(this.c)) {
            double d2 = this.d / this.c;
            double d3 = 1.0 / (this.d * d2 + this.c);
            return nQ.a(d3 * d2, -d3);
        }
        double d4 = this.c / this.d;
        double d5 = 1.0 / (this.c * d4 + this.d);
        return nQ.a(d5, -d5 * d4);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof nQ) {
            nQ nQ2;
            nQ2 = nQ2;
            if (nQ2.i) {
                return this.i;
            }
            return ci_0.a(this.d, nQ2.d) && ci_0.a(this.c, nQ2.c);
        }
        return false;
    }

    private static boolean a(nQ nQ2, nQ nQ3, int n2) {
        return cq_0.b(nQ2.d, nQ3.d, 1) && cq_0.b(nQ2.c, nQ3.c, 1);
    }

    private static boolean a(nQ nQ2, nQ nQ3) {
        boolean bl = true;
        nQ nQ4 = nQ2;
        return cq_0.b(nQ4.d, nQ3.d, 1) && cq_0.b(nQ4.c, nQ3.c, 1);
    }

    private static boolean a(nQ nQ2, nQ nQ3, double d2) {
        return cq_0.b(nQ2.d, nQ3.d, d2) && cq_0.b(nQ2.c, nQ3.c, d2);
    }

    private static boolean b(nQ nQ2, nQ nQ3, double d2) {
        return cq_0.c(nQ2.d, nQ3.d, d2) && cq_0.c(nQ2.c, nQ3.c, d2);
    }

    public int hashCode() {
        if (this.i) {
            return 7;
        }
        return 37 * (17 * ci_0.a(this.c) + ci_0.a(this.d));
    }

    public final double e() {
        return this.c;
    }

    public final double f() {
        return this.d;
    }

    private boolean j() {
        return this.i;
    }

    private boolean k() {
        return this.j;
    }

    @Override
    public final nQ c(nQ nQ2) {
        ci_0.a(nQ2);
        if (this.i || nQ2.i) {
            return f;
        }
        if (Double.isInfinite(this.d) || Double.isInfinite(this.c) || Double.isInfinite(nQ2.d) || Double.isInfinite(nQ2.c)) {
            return g;
        }
        return nQ.a(this.d * nQ2.d - this.c * nQ2.c, this.d * nQ2.c + this.c * nQ2.d);
    }

    @Override
    private nQ b(int n2) {
        if (this.i) {
            return f;
        }
        if (Double.isInfinite(this.d) || Double.isInfinite(this.c)) {
            return g;
        }
        return nQ.a(this.d * (double)n2, this.c * (double)n2);
    }

    @Override
    private nQ c(double d2) {
        if (this.i || Double.isNaN(d2)) {
            return f;
        }
        if (Double.isInfinite(this.d) || Double.isInfinite(this.c) || Double.isInfinite(d2)) {
            return g;
        }
        return nQ.a(this.d * d2, this.c * d2);
    }

    private nQ l() {
        if (this.i) {
            return f;
        }
        return nQ.a(-this.d, -this.c);
    }

    @Override
    public final nQ d(nQ nQ2) {
        ci_0.a(nQ2);
        if (this.i || nQ2.i) {
            return f;
        }
        nQ nQ3 = nQ2;
        nQ nQ4 = nQ3;
        nQ4 = nQ2;
        return nQ.a(this.d - nQ3.d, this.c - nQ4.c);
    }

    @Override
    private nQ d(double d2) {
        if (this.i || Double.isNaN(d2)) {
            return f;
        }
        return nQ.a(this.d - d2, this.c);
    }

    private nQ m() {
        if (this.i) {
            return f;
        }
        nQ nQ2 = this;
        return nQ2.a(nQ2.v().c(e)).s().c(e.l());
    }

    private nQ n() {
        if (this.i) {
            return f;
        }
        return this.v().a(this.c(e)).s().c(e.l());
    }

    private nQ o() {
        if (this.i) {
            return f;
        }
        return this.a(e).b(e.d(this)).s().c(e.b(nQ.a(2.0, 0.0)));
    }

    private nQ p() {
        if (this.i) {
            return f;
        }
        return nQ.a(BY.o(this.d) * BY.b(this.c), -BY.n(this.d) * BY.c(this.c));
    }

    private nQ q() {
        if (this.i) {
            return f;
        }
        return nQ.a(BY.b(this.d) * BY.o(this.c), BY.c(this.d) * BY.n(this.c));
    }

    private nQ r() {
        if (this.i) {
            return f;
        }
        double d2 = BY.i(this.d);
        return nQ.a(d2 * BY.o(this.c), d2 * BY.n(this.c));
    }

    private nQ s() {
        if (this.i) {
            return f;
        }
        return nQ.a(BY.k(this.d()), BY.b(this.c, this.d));
    }

    private nQ e(nQ nQ2) {
        ci_0.a(nQ2);
        return this.s().c(nQ2).r();
    }

    private nQ e(double d2) {
        double d3 = d2;
        nQ nQ2 = this.s();
        return (nQ2.i || Double.isNaN(d3) ? f : (Double.isInfinite(nQ2.d) || Double.isInfinite(nQ2.c) || Double.isInfinite(d3) ? g : nQ.a(nQ2.d * d3, nQ2.c * d3))).r();
    }

    private nQ t() {
        if (this.i) {
            return f;
        }
        return nQ.a(BY.n(this.d) * BY.b(this.c), BY.o(this.d) * BY.c(this.c));
    }

    private nQ u() {
        if (this.i) {
            return f;
        }
        return nQ.a(BY.c(this.d) * BY.o(this.c), BY.b(this.d) * BY.n(this.c));
    }

    public final nQ g() {
        if (this.i) {
            return f;
        }
        if (this.d == 0.0 && this.c == 0.0) {
            return nQ.a(0.0, 0.0);
        }
        double d2 = BY.a((BY.w(this.d) + this.d()) / 2.0);
        if (this.d >= 0.0) {
            return nQ.a(d2, this.c / (d2 * 2.0));
        }
        return nQ.a(BY.w(this.c) / (d2 * 2.0), BY.h(1.0, this.c) * d2);
    }

    private nQ v() {
        nQ nQ2 = this;
        return nQ.a(1.0, 0.0).d(nQ2.c(nQ2)).g();
    }

    private nQ w() {
        if (this.i || Double.isInfinite(this.d)) {
            return f;
        }
        if (this.c > 20.0) {
            return nQ.a(0.0, 1.0);
        }
        if (this.c < -20.0) {
            return nQ.a(0.0, -1.0);
        }
        double d2 = 2.0 * this.d;
        double d3 = 2.0 * this.c;
        double d4 = BY.o(d2) + BY.b(d3);
        return nQ.a(BY.n(d2) / d4, BY.c(d3) / d4);
    }

    private nQ x() {
        if (this.i || Double.isInfinite(this.c)) {
            return f;
        }
        if (this.d > 20.0) {
            return nQ.a(1.0, 0.0);
        }
        if (this.d < -20.0) {
            return nQ.a(-1.0, 0.0);
        }
        double d2 = 2.0 * this.d;
        double d3 = 2.0 * this.c;
        double d4 = BY.b(d2) + BY.o(d3);
        return nQ.a(BY.c(d2) / d4, BY.n(d3) / d4);
    }

    private double y() {
        nQ nQ2 = this;
        nQ nQ3 = nQ2;
        nQ3 = this;
        return BY.b(nQ2.c, nQ3.d);
    }

    @Override
    private List<nQ> c(int n2) {
        nQ nQ2;
        if (n2 <= 0) {
            throw new pj_0(px_0.CANNOT_COMPUTE_NTH_ROOT_FOR_NEGATIVE_N, n2);
        }
        ArrayList<nQ> arrayList = new ArrayList<nQ>();
        if (this.i) {
            arrayList.add(f);
            return arrayList;
        }
        nQ nQ3 = this;
        if (nQ3.j) {
            arrayList.add(g);
            return arrayList;
        }
        double d2 = BY.a(this.d(), 1.0 / (double)n2);
        nQ3 = nQ2 = this;
        nQ3 = nQ2;
        double d3 = BY.b(nQ2.c, nQ3.d) / (double)n2;
        double d4 = Math.PI * 2 / (double)n2;
        double d5 = d3;
        for (int i2 = 0; i2 < n2; ++i2) {
            double d6 = d2 * BY.o(d5);
            double d7 = d2 * BY.n(d5);
            arrayList.add(nQ.a(d6, d7));
            d5 += d4;
        }
        return arrayList;
    }

    private static nQ a(double d2, double d3) {
        return new nQ(d2, d3);
    }

    private static nQ b(double d2, double d3) {
        if (Double.isNaN(d2) || Double.isNaN(d3)) {
            return f;
        }
        return new nQ(d2, d3);
    }

    private static nQ f(double d2) {
        if (Double.isNaN(d2)) {
            return f;
        }
        return new nQ(d2);
    }

    private nQ z() {
        return nQ.a(this.d, this.c);
    }

    private static nR A() {
        return nR.a.a();
    }

    public String toString() {
        return "(" + this.d + ", " + this.c + ")";
    }

    @Override
    public final /* synthetic */ kM c() {
        return nR.a.a();
    }

    @Override
    public final /* synthetic */ kN b() {
        nQ nQ2 = this;
        if (nQ2.i) {
            return f;
        }
        if (nQ2.d == 0.0 && nQ2.c == 0.0) {
            return g;
        }
        if (nQ2.j) {
            return b;
        }
        if (BY.w(nQ2.d) < BY.w(nQ2.c)) {
            double d2 = nQ2.d / nQ2.c;
            double d3 = 1.0 / (nQ2.d * d2 + nQ2.c);
            return nQ.a(d3 * d2, -d3);
        }
        double d4 = nQ2.c / nQ2.d;
        double d5 = 1.0 / (nQ2.c * d4 + nQ2.d);
        return nQ.a(d5, -d5 * d4);
    }

    @Override
    public final /* synthetic */ kN d(Object object) {
        return this.b((nQ)object);
    }

    @Override
    public final /* synthetic */ kN a(int n2) {
        int n3 = n2;
        nQ nQ2 = this;
        if (nQ2.i) {
            return f;
        }
        if (Double.isInfinite(nQ2.d) || Double.isInfinite(nQ2.c)) {
            return g;
        }
        return nQ.a(nQ2.d * (double)n3, nQ2.c * (double)n3);
    }

    @Override
    public final /* synthetic */ kN a() {
        return this.l();
    }

    @Override
    public final /* synthetic */ kN b(Object object) {
        return this.d((nQ)object);
    }
}

