/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import org.valkyrienskies.core.impl.shadow.cq_0;
import org.valkyrienskies.core.impl.shadow.qM;
import org.valkyrienskies.core.impl.shadow.qU;
import org.valkyrienskies.core.impl.shadow.qV;
import org.valkyrienskies.core.impl.shadow.qX;
import org.valkyrienskies.core.impl.shadow.qY;
import org.valkyrienskies.core.impl.shadow.qZ;
import org.valkyrienskies.core.impl.shadow.rK;
import org.valkyrienskies.core.impl.shadow.rM;
import org.valkyrienskies.core.impl.shadow.rQ;
import org.valkyrienskies.core.impl.shadow.sb_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public final class qW
extends rK<qU, qU>
implements Iterable<double[]> {
    private static final double b = 1.0E-10;

    public qW(double d2) {
        super(d2);
    }

    public qW(double d2, double d3, double d4) {
        rM<qU> rM2;
        double d5 = d4;
        double d6 = d3;
        double d7 = d2;
        if (Double.isInfinite(d7) && d7 < 0.0) {
            if (Double.isInfinite(d6) && d6 > 0.0) {
                rM2 = new rM<qU>(Boolean.TRUE);
            } else {
                qY qY2 = new qX(new qZ(d6), true, d5).a();
                rM2 = new rM<qU>(qY2, new rM(Boolean.FALSE), new rM(Boolean.TRUE), null);
            }
        } else {
            qY qY3 = new qX(new qZ(d7), false, d5).a();
            if (Double.isInfinite(d6) && d6 > 0.0) {
                rM2 = new rM<qU>(qY3, new rM(Boolean.FALSE), new rM(Boolean.TRUE), null);
            } else {
                qY qY4 = new qX(new qZ(d6), true, d5).a();
                rM2 = new rM<qU>(qY3, new rM(Boolean.FALSE), new rM<qU>(qY4, new rM(Boolean.FALSE), new rM(Boolean.TRUE), null), null);
            }
        }
        super(rM2, d4);
    }

    public qW(rM<qU> rM2, double d2) {
        super(rM2, d2);
    }

    private qW(Collection<sb_0<qU>> collection, double d2) {
        super(collection, 1.0E-10);
    }

    @Deprecated
    public qW() {
        this(1.0E-10);
    }

    @Deprecated
    private qW(double d2, double d3) {
        this(d2, d3, 1.0E-10);
    }

    @Deprecated
    private qW(rM<qU> rM2) {
        this(rM2, 1.0E-10);
    }

    @Deprecated
    private qW(Collection<sb_0<qU>> collection) {
        this(collection, 1.0E-10);
    }

    private static rM<qU> a(double d2, double d3, double d4) {
        if (Double.isInfinite(d2) && d2 < 0.0) {
            if (Double.isInfinite(d3) && d3 > 0.0) {
                return new rM<qU>(Boolean.TRUE);
            }
            qY qY2 = new qX(new qZ(d3), true, d4).a();
            return new rM<qU>(qY2, new rM(Boolean.FALSE), new rM(Boolean.TRUE), null);
        }
        qY qY3 = new qX(new qZ(d2), false, d4).a();
        if (Double.isInfinite(d3) && d3 > 0.0) {
            return new rM<qU>(qY3, new rM(Boolean.FALSE), new rM(Boolean.TRUE), null);
        }
        qY qY4 = new qX(new qZ(d3), true, d4).a();
        return new rM<qU>(qY3, new rM(Boolean.FALSE), new rM<qU>(qY4, new rM(Boolean.FALSE), new rM(Boolean.TRUE), null), null);
    }

    private qW e(rM<qU> rM2) {
        return new qW(rM2, this.c());
    }

    @Override
    public final void a() {
        rM rM2 = this.a(false);
        if (rM2.a == null) {
            this.c(qZ.c);
            qW qW2 = this;
            rM2 = qW2.a(false);
            qW2.a((Boolean)rM2.e != false ? Double.POSITIVE_INFINITY : 0.0);
            return;
        }
        double d2 = 0.0;
        double d3 = 0.0;
        for (qV qV2 : this.b()) {
            d2 += qV2.c();
            d3 += qV2.c() * qV2.d();
        }
        this.a(d2);
        if (Double.isInfinite(d2)) {
            this.c(qZ.c);
            return;
        }
        if (d2 >= cq_0.b) {
            this.c(new qZ(d3 / d2));
            return;
        }
        qW qW3 = this;
        Object object = qW3.a(false);
        object = (qX)((rM)object).a.c();
        qW3.c(((qX)object).a);
    }

    private double j() {
        rM rM2;
        rM rM3 = this.a(false);
        double d2 = Double.POSITIVE_INFINITY;
        while (true) {
            rM rM4;
            rM2 = rM3;
            if (rM2.a == null) break;
            rM2 = rM3;
            qX qX2 = (qX)rM2.a.c();
            rM2 = qX2;
            rM2 = qX2.a;
            d2 = ((qZ)((Object)rM2)).d;
            rM2 = qX2;
            if (((qX)((Object)rM2)).b) {
                rM2 = rM3;
                rM4 = rM2.c;
            } else {
                rM2 = rM3;
                rM4 = rM2.b;
            }
            rM3 = rM4;
        }
        rM2 = rM3;
        if (((Boolean)rM2.e).booleanValue()) {
            return Double.NEGATIVE_INFINITY;
        }
        return d2;
    }

    private double k() {
        rM rM2;
        rM rM3 = this.a(false);
        double d2 = Double.NEGATIVE_INFINITY;
        while (true) {
            rM rM4;
            rM2 = rM3;
            if (rM2.a == null) break;
            rM2 = rM3;
            qX qX2 = (qX)rM2.a.c();
            rM2 = qX2;
            rM2 = qX2.a;
            d2 = ((qZ)((Object)rM2)).d;
            rM2 = qX2;
            if (((qX)((Object)rM2)).b) {
                rM2 = rM3;
                rM4 = rM2.b;
            } else {
                rM2 = rM3;
                rM4 = rM2.c;
            }
            rM3 = rM4;
        }
        rM2 = rM3;
        if (((Boolean)rM2.e).booleanValue()) {
            return Double.POSITIVE_INFINITY;
        }
        return d2;
    }

    @Override
    public final rQ<qU> a(qM<qU> qM2) {
        qZ qZ2 = (qZ)qM2;
        double d2 = qZ2.d;
        double d3 = Double.NEGATIVE_INFINITY;
        for (double[] dArray : this) {
            if (d2 < dArray[0]) {
                double d4 = d2 - d3;
                double d5 = dArray[0] - d2;
                if (d4 < d5) {
                    return new rQ<qU>(qM2, qW.b(d3), d4);
                }
                return new rQ<qU>(qM2, qW.b(dArray[0]), d5);
            }
            if (d2 <= dArray[1]) {
                double d6 = dArray[0] - d2;
                double d7 = d2 - dArray[1];
                if (d6 < d7) {
                    return new rQ<qU>(qM2, qW.b(dArray[1]), d7);
                }
                return new rQ<qU>(qM2, qW.b(dArray[0]), d6);
            }
            d3 = dArray[1];
        }
        return new rQ<qU>(qM2, qW.b(d3), d2 - d3);
    }

    private static qZ b(double d2) {
        if (Double.isInfinite(d2)) {
            return null;
        }
        return new qZ(d2);
    }

    public final List<qV> b() {
        ArrayList<qV> arrayList = new ArrayList<qV>();
        for (double[] dArray : this) {
            arrayList.add(new qV(dArray[0], dArray[1]));
        }
        return arrayList;
    }

    private rM<qU> f(rM<qU> rM2) {
        rM<qU> rM3 = rM2;
        if (rM3.a == null) {
            return rM2;
        }
        rM<qU> rM4 = null;
        while (rM2 != null) {
            rM rM5;
            rM4 = rM2;
            rM<qU> rM6 = rM2;
            rM2 = this;
            rM3 = ((qW)((Object)rM2)).o(rM6);
            if (rM3.a != null) {
                rM3 = super.k(rM6);
                rM5 = rM3.d;
            } else {
                while (true) {
                    rM<qU> rM7 = rM6;
                    rM rM8 = rM2;
                    rM3 = rM7;
                    rM3 = rM3.d;
                    if (!(rM3 != null && rM7 == super.o(rM3))) break;
                    rM3 = rM6;
                    rM6 = rM3.d;
                }
                rM3 = rM6;
                rM5 = rM3.d;
            }
            rM2 = rM5;
        }
        return this.k(rM4);
    }

    private rM<qU> l() {
        rM<qU> rM2;
        rM<qU> rM3 = rM2 = this.a(false);
        if (rM2.a == null) {
            return null;
        }
        rM3 = this.f(rM2);
        rM2 = rM3.d;
        while (rM2 != null && !this.g(rM2) && !this.h(rM2)) {
            rM2 = this.i(rM2);
        }
        return rM2;
    }

    private boolean g(rM<qU> rM2) {
        rM<qU> rM3 = this.k(rM2);
        if (((Boolean)rM3.e).booleanValue()) {
            return false;
        }
        rM3 = this.l(rM2);
        return (Boolean)rM3.e != false;
    }

    private boolean h(rM<qU> rM2) {
        rM<qU> rM3 = this.k(rM2);
        if (!((Boolean)rM3.e).booleanValue()) {
            return false;
        }
        rM3 = this.l(rM2);
        return (Boolean)rM3.e == false;
    }

    private rM<qU> i(rM<qU> rM2) {
        rM<qU> rM3 = this.p(rM2);
        if (rM3.a != null) {
            rM3 = this.l(rM2);
            return rM3.d;
        }
        while (this.n(rM2)) {
            rM3 = rM2;
            rM2 = rM3.d;
        }
        rM3 = rM2;
        return rM3.d;
    }

    private rM<qU> j(rM<qU> rM2) {
        rM<qU> rM3 = this.o(rM2);
        if (rM3.a != null) {
            rM3 = this.k(rM2);
            return rM3.d;
        }
        while (this.m(rM2)) {
            rM3 = rM2;
            rM2 = rM3.d;
        }
        rM3 = rM2;
        return rM3.d;
    }

    private rM<qU> k(rM<qU> rM2) {
        rM2 = this.o(rM2);
        while (true) {
            rM<qU> rM3 = rM2;
            if (rM3.a == null) break;
            rM2 = this.p(rM2);
        }
        return rM2;
    }

    private rM<qU> l(rM<qU> rM2) {
        rM2 = this.p(rM2);
        while (true) {
            rM<qU> rM3 = rM2;
            if (rM3.a == null) break;
            rM2 = this.o(rM2);
        }
        return rM2;
    }

    private boolean m(rM<qU> rM2) {
        rM<qU> rM3 = rM2;
        rM3 = rM3.d;
        if (rM3 == null) {
            return false;
        }
        return rM2 == this.o(rM3);
    }

    private boolean n(rM<qU> rM2) {
        rM<qU> rM3 = rM2;
        rM3 = rM3.d;
        if (rM3 == null) {
            return false;
        }
        return rM2 == this.p(rM3);
    }

    private rM<qU> o(rM<qU> rM2) {
        if (qW.q(rM2)) {
            return rM2.c;
        }
        return rM2.b;
    }

    private rM<qU> p(rM<qU> rM2) {
        if (qW.q(rM2)) {
            return rM2.b;
        }
        return rM2.c;
    }

    private static boolean q(rM<qU> object) {
        object = (qX)((rM)object).a.c();
        return ((qX)object).b;
    }

    private static double r(rM<qU> object) {
        object = (qX)((rM)object).a.c();
        object = ((qX)object).a;
        return ((qZ)object).d;
    }

    @Override
    public final Iterator<double[]> iterator() {
        return new a(this);
    }

    @Override
    public final /* synthetic */ rK a(rM rM2) {
        return this.e(rM2);
    }

    @Override
    public final /* synthetic */ rK b(rM rM2) {
        return this.e(rM2);
    }

    static /* synthetic */ rM a(qW qW2) {
        rM<qU> rM2;
        rM<qU> rM3 = rM2 = qW2.a(false);
        if (rM2.a == null) {
            return null;
        }
        rM3 = qW2.f(rM2);
        rM2 = rM3.d;
        while (rM2 != null && !qW2.g(rM2) && !qW2.h(rM2)) {
            rM2 = qW2.i(rM2);
        }
        return rM2;
    }

    static /* synthetic */ double c(qW object, rM rM2) {
        rM rM3 = rM2;
        object = rM3;
        object = rM3;
        object = (qX)rM3.a.c();
        object = ((qX)object).a;
        return ((qZ)object).d;
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    final class a
    implements Iterator<double[]> {
        private rM<qU> a;
        private double[] b;
        private /* synthetic */ qW c;

        a(qW object) {
            this.c = object;
            this.a = qW.a((qW)object);
            if (this.a == null) {
                qW qW2 = object;
                object = qW2.f(qW2.a(false));
                if (((Boolean)((rM)object).e).booleanValue()) {
                    this.b = new double[]{Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY};
                    return;
                }
                this.b = null;
                return;
            }
            if (((qW)object).h(this.a)) {
                this.b = new double[]{Double.NEGATIVE_INFINITY, qW.c((qW)object, this.a)};
                return;
            }
            this.a();
        }

        private void a() {
            rM rM2 = this.a;
            while (rM2 != null && !this.c.g(rM2)) {
                rM2 = this.c.i(rM2);
            }
            if (rM2 == null) {
                this.a = null;
                this.b = null;
                return;
            }
            rM rM3 = rM2;
            while (rM3 != null && !this.c.h(rM3)) {
                rM3 = this.c.i(rM3);
            }
            if (rM3 != null) {
                this.b = new double[]{qW.c(this.c, rM2), qW.c(this.c, rM3)};
                this.a = rM3;
                return;
            }
            this.b = new double[]{qW.c(this.c, rM2), Double.POSITIVE_INFINITY};
            this.a = null;
        }

        @Override
        public final boolean hasNext() {
            return this.b != null;
        }

        private double[] b() {
            if (this.b == null) {
                throw new NoSuchElementException();
            }
            double[] dArray = this.b;
            this.a();
            return dArray;
        }

        @Override
        public final void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public final /* synthetic */ Object next() {
            a a2 = this;
            if (a2.b == null) {
                throw new NoSuchElementException();
            }
            double[] dArray = a2.b;
            a2.a();
            return dArray;
        }
    }
}

