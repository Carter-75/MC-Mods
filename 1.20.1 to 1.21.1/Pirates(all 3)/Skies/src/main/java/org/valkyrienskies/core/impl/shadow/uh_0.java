/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.valkyrienskies.core.impl.shadow.uh
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import org.valkyrienskies.core.impl.shadow.pn_0;
import org.valkyrienskies.core.impl.shadow.po_0;
import org.valkyrienskies.core.impl.shadow.ua_0;
import org.valkyrienskies.core.impl.shadow.ud_0;
import org.valkyrienskies.core.impl.shadow.uh;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.uh
 */
public final class uh_0
implements Serializable {
    private static final long a = 1L;
    private final ud_0 b;
    private final int c;
    private final boolean d;
    private final long[] e;

    uh_0(boolean n2, double[][] dArray) {
        this.c = dArray.length;
        if (this.c < 2) {
            throw new pn_0(this.c, (Number)2, true);
        }
        this.d = n2;
        n2 = dArray[0].length;
        this.b = new ud_0(0L, n2);
        this.e = new long[this.c];
        for (n2 = 0; n2 < this.c; ++n2) {
            this.e[n2] = this.b.a(dArray[n2]);
        }
        this.c();
    }

    private uh_0(int n2, boolean n3, ua_0[] ua_0Array) {
        if (n2 < 2) {
            throw new pn_0(n2, (Number)2, true);
        }
        this.c = n2;
        this.d = n3;
        this.e = new long[n2];
        n3 = ua_0Array.length;
        this.b = new ud_0(0L, n3);
        for (int i2 = 0; i2 < n2; ++i2) {
            double[] dArray = new double[n3];
            for (int i3 = 0; i3 < n3; ++i3) {
                dArray[i3] = ua_0Array[i3].a();
            }
            this.e[i2] = this.b.a(dArray);
        }
        this.c();
    }

    private ud_0 a() {
        return this.b;
    }

    private int b() {
        return this.c;
    }

    private double[] a(int n2) {
        if (n2 < 0 || n2 >= this.c) {
            throw new po_0(n2, (Number)0, this.c - 1);
        }
        return this.b.a(this.e[n2]).c();
    }

    private void c() {
        int n2;
        for (n2 = 0; n2 < this.c - 1; ++n2) {
            this.b.a(this.b.a(n2), this.b.a(n2 + 1));
        }
        for (n2 = this.c - 1; n2 > 0; --n2) {
            this.b.a(this.b.a(n2), this.b.a(n2 - 1));
        }
        if (this.d) {
            this.b.a(this.b.a(0L), this.b.a(this.c - 1));
            this.b.a(this.b.a(this.c - 1), this.b.a(0L));
        }
    }

    private static void d() {
        throw new IllegalStateException();
    }

    private a e() {
        double[][] dArrayArray = new double[this.c][];
        for (int i2 = 0; i2 < this.c; ++i2) {
            int n2 = i2;
            uh_0 uh_02 = this;
            if (n2 < 0 || n2 >= uh_02.c) {
                throw new po_0(n2, (Number)0, uh_02.c - 1);
            }
            dArrayArray[i2] = uh_02.b.a(uh_02.e[n2]).c();
        }
        return new a(this.d, dArrayArray);
    }

    static final class a
    implements Serializable {
        private static final long a = 20130226L;
        private final boolean b;
        private final double[][] c;

        a(boolean bl, double[][] dArray) {
            this.b = bl;
            this.c = dArray;
        }

        private uh_0 a() {
            return new uh(this.b, this.c);
        }
    }
}

