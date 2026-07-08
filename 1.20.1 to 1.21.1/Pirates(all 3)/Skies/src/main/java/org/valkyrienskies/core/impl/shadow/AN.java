/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import java.util.Arrays;
import org.valkyrienskies.core.impl.shadow.oS;
import org.valkyrienskies.core.impl.shadow.sv_0;
import org.valkyrienskies.core.impl.shadow.td_0;
import org.valkyrienskies.core.impl.shadow.tq_0;

public final class AN
implements Serializable {
    private static final long d = 4118372414238930270L;
    public final double[] a;
    public final double[] b;
    private final boolean e;
    public long c;

    public AN(int n2, boolean bl) {
        this.a = new double[n2];
        int n3 = n2;
        this.b = new double[n3 * (n3 + 1) / 2];
        this.c = 0L;
        this.e = bl;
    }

    public final void a(double[] dArray) {
        if (dArray.length != this.a.length) {
            throw new oS(dArray.length, this.a.length);
        }
        int n2 = 0;
        for (int i2 = 0; i2 < dArray.length; ++i2) {
            int n3 = i2;
            this.a[n3] = this.a[n3] + dArray[i2];
            for (int i3 = 0; i3 <= i2; ++i3) {
                int n4 = n2++;
                this.b[n4] = this.b[n4] + dArray[i2] * dArray[i3];
            }
        }
        ++this.c;
    }

    public final tq_0 a() {
        int n2 = this.a.length;
        sv_0 sv_02 = td_0.a(n2, n2);
        if (this.c > 1L) {
            double d2 = 1.0 / (double)(this.c * (this.e ? this.c - 1L : this.c));
            int n3 = 0;
            for (int i2 = 0; i2 < n2; ++i2) {
                for (int i3 = 0; i3 <= i2; ++i3) {
                    double d3 = d2 * ((double)this.c * this.b[n3++] - this.a[i2] * this.a[i3]);
                    sv_02.c(i2, i3, d3);
                    sv_02.c(i3, i2, d3);
                }
            }
        }
        return sv_02;
    }

    private long c() {
        return this.c;
    }

    public final void b() {
        this.c = 0L;
        Arrays.fill(this.a, 0.0);
        Arrays.fill(this.b, 0.0);
    }

    public final int hashCode() {
        int n2 = 31 + (this.e ? 1231 : 1237);
        n2 = n2 * 31 + (int)(this.c ^ this.c >>> 32);
        n2 = n2 * 31 + Arrays.hashCode(this.b);
        n2 = n2 * 31 + Arrays.hashCode(this.a);
        return n2;
    }

    public final boolean equals(Object obj) {
        AN aN;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AN)) {
            return false;
        }
        aN = aN;
        if (this.e != aN.e) {
            return false;
        }
        if (this.c != aN.c) {
            return false;
        }
        if (!Arrays.equals(this.b, aN.b)) {
            return false;
        }
        return Arrays.equals(this.a, aN.a);
    }
}

