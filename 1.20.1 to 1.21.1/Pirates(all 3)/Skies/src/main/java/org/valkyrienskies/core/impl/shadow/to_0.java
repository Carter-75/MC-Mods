/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.sG;
import org.valkyrienskies.core.impl.shadow.td_0;
import org.valkyrienskies.core.impl.shadow.tn_0;
import org.valkyrienskies.core.impl.shadow.tq_0;
import org.valkyrienskies.core.impl.shadow.tu_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.to
 */
public final class to_0
extends tn_0 {
    private int[] e;
    private tq_0 f;

    private to_0(tq_0 tq_02) {
        this(tq_02, 0.0);
    }

    private to_0(tq_0 tq_02, double d2) {
        super(tq_02, 0.0);
    }

    protected final void a(double[][] dArray) {
        this.e = new int[dArray.length];
        int n2 = 0;
        while (n2 < this.e.length) {
            int n3 = n2++;
            this.e[n3] = n3;
        }
        super.a(dArray);
    }

    protected final void a(int n2, double[][] dArray) {
        double d2 = 0.0;
        int n3 = n2;
        for (int i2 = n2; i2 < dArray.length; ++i2) {
            double d3 = 0.0;
            for (int i3 = 0; i3 < dArray[i2].length; ++i3) {
                d3 += dArray[i2][i3] * dArray[i2][i3];
            }
            if (!(d3 > d2)) continue;
            d2 = d3;
            n3 = i2;
        }
        if (n3 != n2) {
            double[] dArray2 = dArray[n2];
            dArray[n2] = dArray[n3];
            dArray[n3] = dArray2;
            int n4 = this.e[n2];
            this.e[n2] = this.e[n3];
            this.e[n3] = n4;
        }
        super.a(n2, dArray);
    }

    private tq_0 d() {
        if (this.f == null) {
            int n2;
            int n3 = n2 = this.e.length;
            this.f = td_0.a(n3, n3);
            for (int i2 = 0; i2 < n2; ++i2) {
                this.f.c(this.e[i2], i2, 1.0);
            }
        }
        return this.f;
    }

    private int a(double d2) {
        double d3;
        int n2;
        double d4;
        tq_0 tq_02 = this.a();
        int n3 = tq_02.f();
        int n4 = tq_02.g();
        double d5 = d4 = tq_02.c();
        for (n2 = 1; n2 < BY.a(n3, n4) && (d3 = tq_02.a(n2, n3 - 1, n2, n4 - 1).c()) != 0.0 && !(d3 / d4 * d5 < d2); ++n2) {
            d4 = d3;
        }
        return n2;
    }

    public final sG c() {
        return new a(super.c(), this.d(), 0);
    }

    static final class 1 {
    }

    static final class a
    implements sG {
        private final sG a;
        private tq_0 b;

        private a(sG sG2, tq_0 tq_02) {
            this.a = sG2;
            this.b = tq_02;
        }

        public final boolean a() {
            return this.a.a();
        }

        public final tu_0 a(tu_0 tu_02) {
            return this.b.a(this.a.a(tu_02));
        }

        public final tq_0 a(tq_0 tq_02) {
            return this.b.c(this.a.a(tq_02));
        }

        public final tq_0 b() {
            a a2 = this;
            return a2.a(td_0.a(a2.b.f()));
        }

        /* synthetic */ a(sG sG2, tq_0 tq_02, byte by) {
            this(sG2, tq_02);
        }
    }
}

