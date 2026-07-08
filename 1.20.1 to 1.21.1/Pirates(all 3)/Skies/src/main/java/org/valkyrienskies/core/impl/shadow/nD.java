/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.nP;
import org.valkyrienskies.core.impl.shadow.nQ;
import org.valkyrienskies.core.impl.shadow.nT;
import org.valkyrienskies.core.impl.shadow.ni_0;
import org.valkyrienskies.core.impl.shadow.no_0;
import org.valkyrienskies.core.impl.shadow.ns_0;
import org.valkyrienskies.core.impl.shadow.pe_0;
import org.valkyrienskies.core.impl.shadow.pf_0;
import org.valkyrienskies.core.impl.shadow.pl_0;
import org.valkyrienskies.core.impl.shadow.px_0;

public final class nD
extends no_0 {
    private static final double d = 1.0E-6;
    private final a e = new a(this, 0);

    public nD() {
        this(1.0E-6);
    }

    private nD(double d2) {
        super(1.0E-6);
    }

    private nD(double d2, double d3) {
        super(d2, d3);
    }

    private nD(double d2, double d3, double d4) {
        super(d2, d3, d4);
    }

    public final double j() {
        double d2;
        double d3;
        double d4;
        double d5 = this.d();
        double d6 = this.e();
        double d7 = this.f();
        double d8 = this.i();
        double d9 = d6;
        double d10 = d7;
        double d11 = d5;
        nP.b(d11, d10, d9);
        double d12 = this.b(d7);
        if (BY.w(d4) <= d8) {
            return d7;
        }
        double d13 = this.b(d5);
        if (BY.w(d3) <= d8) {
            return d5;
        }
        if (d12 * d13 < 0.0) {
            return this.d(d5, d7);
        }
        double d14 = this.b(d6);
        if (BY.w(d2) <= d8) {
            return d6;
        }
        if (d12 * d14 < 0.0) {
            return this.d(d7, d6);
        }
        throw new pe_0(d5, d6, d13, d14);
    }

    @Deprecated
    private double d(double d2, double d3) {
        nQ nQ2;
        nQ[] nQArray = nT.a(this.a());
        nQ nQ3 = this.e.b(nQArray, nQ2 = new nQ(0.5 * (d2 + d3), 0.0));
        if (this.e.a(d2, d3, nQ3)) {
            nQ nQ4 = nQ3;
            return nQ4.d;
        }
        double d4 = Double.NaN;
        nQArray = this.e.a(nQArray, nQ2);
        for (int i2 = 0; i2 < nQArray.length; ++i2) {
            if (!this.e.a(d2, d3, nQArray[i2])) continue;
            nQ nQ5 = nQArray[i2];
            d4 = nQ5.d;
            break;
        }
        return d4;
    }

    private nQ[] a(double[] dArray, double d2) {
        int n2 = Integer.MAX_VALUE;
        double d3 = d2;
        double[] dArray2 = dArray;
        nD nD2 = this;
        nD2.a(Integer.MAX_VALUE, new ni_0(dArray2), Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, d3);
        return nD2.e.a(nT.a(dArray2), new nQ(d3, 0.0));
    }

    private nQ[] a(double[] dArray, double d2, int n2) {
        this.a(Integer.MAX_VALUE, new ni_0(dArray), Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, d2);
        return this.e.a(nT.a(dArray), new nQ(d2, 0.0));
    }

    private nQ b(double[] dArray, double d2) {
        int n2 = Integer.MAX_VALUE;
        double d3 = d2;
        double[] dArray2 = dArray;
        nD nD2 = this;
        nD2.a(Integer.MAX_VALUE, new ni_0(dArray2), Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, d3);
        return nD2.e.b(nT.a(dArray2), new nQ(d3, 0.0));
    }

    private nQ b(double[] dArray, double d2, int n2) {
        this.a(Integer.MAX_VALUE, new ni_0(dArray), Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, d2);
        return this.e.b(nT.a(dArray), new nQ(d2, 0.0));
    }

    static final class 1 {
    }

    final class a {
        private /* synthetic */ nD a;

        private a(nD nD2) {
            this.a = nD2;
        }

        public final boolean a(double d2, double d3, nQ nQ2) {
            block2: {
                block4: {
                    block3: {
                        nD nD2;
                        Object object = nQ2;
                        if (!nD.a(d2, ((nQ)object).d, d3)) break block2;
                        nD nD3 = this.a;
                        object = nD3;
                        object = this.a;
                        double d4 = BY.e(nD3.c * nQ2.d(), ((ns_0)object).b);
                        object = nQ2;
                        if (BY.w(((nQ)object).c) <= d4) break block3;
                        object = this.a;
                        if (!(nQ2.d() <= nD2.a)) break block4;
                    }
                    return true;
                }
                return false;
            }
            return false;
        }

        public final nQ[] a(nQ[] nQArray, nQ nQ2) {
            if (nQArray == null) {
                throw new pl_0();
            }
            int n2 = nQArray.length - 1;
            if (n2 == 0) {
                throw new pf_0(px_0.POLYNOMIAL);
            }
            nQ[] nQArray2 = new nQ[n2 + 1];
            for (int i2 = 0; i2 <= n2; ++i2) {
                nQArray2[i2] = nQArray[i2];
            }
            nQ[] nQArray3 = new nQ[n2];
            for (int i3 = 0; i3 < n2; ++i3) {
                Object object = new nQ[n2 - i3 + 1];
                System.arraycopy(nQArray2, 0, object, 0, ((nQ[])object).length);
                nQArray3[i3] = this.b((nQ[])object, nQ2);
                object = nQArray2[n2 - i3];
                for (int i4 = n2 - i3 - 1; i4 >= 0; --i4) {
                    nQ nQ3 = nQArray2[i4];
                    nQArray2[i4] = object;
                    object = nQ3.a(((nQ)object).c(nQArray3[i3]));
                }
            }
            return nQArray3;
        }

        public final nQ b(nQ[] nQArray, nQ nQ2) {
            if (nQArray == null) {
                throw new pl_0();
            }
            int n2 = nQArray.length - 1;
            if (n2 == 0) {
                throw new pf_0(px_0.POLYNOMIAL);
            }
            nD nD2 = this.a;
            double d2 = nD2.b;
            nD2 = this.a;
            double d3 = nD2.c;
            nD2 = this.a;
            double d4 = nD2.a;
            nQ nQ3 = new nQ(n2, 0.0);
            nQ nQ4 = new nQ(n2 - 1, 0.0);
            nQ nQ5 = new nQ(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
            while (true) {
                nQ nQ6 = nQArray[n2];
                nQ nQ7 = nQ.b;
                nQ nQ8 = nQ.b;
                for (int i2 = n2 - 1; i2 >= 0; --i2) {
                    nQ8 = nQ7.a(nQ2.c(nQ8));
                    nQ7 = nQ6.a(nQ2.c(nQ7));
                    nQ6 = nQArray[i2].a(nQ2.c(nQ6));
                }
                nQ8 = nQ8.c(new nQ(2.0, 0.0));
                double d5 = BY.e(d3 * nQ2.d(), d2);
                if (nQ2.d(nQ5).d() <= d5) {
                    return nQ2;
                }
                if (nQ6.d() <= d4) {
                    return nQ2;
                }
                nQ5 = nQ7.b(nQ6);
                nQ7 = nQ5.c(nQ5);
                nQ6 = nQ7.d(nQ8.b(nQ6));
                nQ6 = nQ4.c(nQ3.c(nQ6).d(nQ7));
                nQ6 = nQ6.g();
                nQ7 = nQ5.a(nQ6);
                nQ5 = nQ5.d(nQ6);
                nQ6 = nQ7.d() > nQ5.d() ? nQ7 : nQ5;
                if (nQ6.equals(new nQ(0.0, 0.0))) {
                    double d6 = d2;
                    nQ2 = nQ2.a(new nQ(d6, d6));
                    nQ5 = new nQ(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
                } else {
                    nQ5 = nQ2;
                    nQ2 = nQ2.d(nQ3.b(nQ6));
                }
                this.a.k();
            }
        }

        /* synthetic */ a(nD nD2, byte by) {
            this(nD2);
        }
    }
}

