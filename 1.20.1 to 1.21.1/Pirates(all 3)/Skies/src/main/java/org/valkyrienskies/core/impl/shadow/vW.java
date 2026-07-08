/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.uE;
import org.valkyrienskies.core.impl.shadow.ws_0;

final class vW
extends ws_0 {
    private static final long n = 20110928L;
    private double[] o;
    private double[] p;
    private double[] q;
    private double[][] r;
    double[][] a;
    double[] b;
    int c;

    public vW() {
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.c(-1);
    }

    vW(double[] dArray, double[] dArray2, double[] dArray3, double[] dArray4, double[][] dArray5, boolean bl, uE uE2, uE[] uEArray) {
        super(dArray, bl, uE2, uEArray);
        this.o = dArray2;
        this.p = dArray3;
        this.q = dArray4;
        this.r = dArray5;
        this.c(dArray5.length + 4);
    }

    private vW(vW vW2) {
        super(vW2);
        int n2 = this.e.length;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        if (vW2.a == null) {
            this.a = null;
            this.c = -1;
            return;
        }
        this.c(vW2.c);
        for (int i2 = 0; i2 < this.a.length; ++i2) {
            this.a[i2] = new double[n2];
            System.arraycopy(vW2.a[i2], 0, this.a[i2], 0, n2);
        }
        this.c = vW2.c;
    }

    private void c(int n2) {
        int n3;
        if (n2 < 0) {
            this.a = null;
            this.b = null;
            this.c = -1;
            return;
        }
        double[][] dArrayArray = new double[n2 + 1][];
        if (this.a != null) {
            System.arraycopy(this.a, 0, dArrayArray, 0, this.a.length);
            for (n3 = this.a.length; n3 < dArrayArray.length; ++n3) {
                dArrayArray[n3] = new double[this.e.length];
            }
        } else {
            for (n3 = 0; n3 < dArrayArray.length; ++n3) {
                dArrayArray[n3] = new double[this.e.length];
            }
        }
        this.a = dArrayArray;
        if (n2 <= 4) {
            this.b = null;
        } else {
            this.b = new double[n2 - 4];
            for (n3 = 0; n3 < this.b.length; ++n3) {
                int n4 = n2 = n3 + 5;
                this.b[n3] = 1.0 / (double)(n4 * n4);
                double d2 = 0.5 * BY.a((double)(n3 + 1) / (double)n2);
                for (n2 = 0; n2 <= n3; ++n2) {
                    int n5 = n3;
                    this.b[n5] = this.b[n5] * (d2 / (double)(n2 + 1));
                }
            }
        }
        this.c = 0;
    }

    public final ws_0 a() {
        return new vW(this);
    }

    public final void a(int n2, double d2) {
        if (this.a == null || this.a.length <= n2 + 4) {
            this.c(n2 + 4);
        }
        this.c = n2 + 4;
        for (int i2 = 0; i2 < this.e.length; ++i2) {
            double d3 = d2 * this.o[i2];
            double d4 = d2 * this.q[i2];
            double d5 = this.p[i2] - this.e[i2];
            double d6 = d5 - d4;
            double d7 = d3 - d5;
            this.a[0][i2] = this.e[i2];
            this.a[1][i2] = d5;
            this.a[2][i2] = d6;
            this.a[3][i2] = d7;
            if (n2 < 0) {
                return;
            }
            double d8 = 0.5 * (this.e[i2] + this.p[i2]) + 0.125 * (d6 + d7);
            this.a[4][i2] = 16.0 * (this.r[0][i2] - d8);
            if (n2 <= 0) continue;
            double d9 = d5 + 0.25 * (d6 - d7);
            this.a[5][i2] = 16.0 * (this.r[1][i2] - d9);
            if (n2 <= 1) continue;
            double d10 = d4 - d3;
            this.a[6][i2] = 16.0 * (this.r[2][i2] - d10 + this.a[4][i2]);
            if (n2 <= 2) continue;
            double d11 = 6.0 * (d7 - d6);
            this.a[7][i2] = 16.0 * (this.r[3][i2] - d11 + 3.0 * this.a[5][i2]);
            for (int i3 = 4; i3 <= n2; ++i3) {
                double d12 = 0.5 * (double)i3 * (double)(i3 - 1);
                double d13 = d12 * 2.0 * (double)(i3 - 2) * (double)(i3 - 3);
                this.a[i3 + 4][i2] = 16.0 * (this.r[i3][i2] + d12 * this.a[i3 + 2][i2] - d13 * this.a[i3][i2]);
            }
        }
    }

    public final double a(double[] dArray) {
        double d2 = 0.0;
        if (this.c >= 5) {
            for (int i2 = 0; i2 < dArray.length; ++i2) {
                double d3;
                double d4 = d3 = this.a[this.c][i2] / dArray[i2];
                d2 += d4 * d4;
            }
            d2 = BY.a(d2 / (double)dArray.length) * this.b[this.c - 5];
        }
        return d2;
    }

    public final void a(double d2, double d3) {
        int n2 = this.e.length;
        double d4 = 1.0 - d2;
        double d5 = d2 - 0.5;
        double d6 = d2 * d4;
        double d7 = d6 * d6;
        double d8 = d6 * 2.0 * (1.0 - d2 * 2.0);
        double d9 = 1.0 / this.d;
        double d10 = d2 * (2.0 - d2 * 3.0) / this.d;
        double d11 = ((d2 * 3.0 - 4.0) * d2 + 1.0) / this.d;
        for (int i2 = 0; i2 < n2; ++i2) {
            double d12 = this.a[0][i2];
            double d13 = this.a[1][i2];
            double d14 = this.a[2][i2];
            double d15 = this.a[3][i2];
            this.g[i2] = d12 + d2 * (d13 + d4 * (d14 * d2 + d15 * d4));
            this.h[i2] = d9 * d13 + d10 * d14 + d11 * d15;
            if (this.c <= 3) continue;
            double d16 = 0.0;
            double d17 = this.a[this.c][i2];
            for (int i3 = this.c - 1; i3 > 3; --i3) {
                double d18 = 1.0 / (double)(i3 - 3);
                d16 = d18 * (d5 * d16 + d17);
                d17 = this.a[i3][i2] + d17 * d18 * d5;
            }
            int n3 = i2;
            this.g[n3] = this.g[n3] + d7 * d17;
            int n4 = i2;
            this.h[n4] = this.h[n4] + (d7 * d16 + d8 * d17) / this.d;
        }
        if (this.d == 0.0) {
            System.arraycopy(this.r[1], 0, this.h, 0, n2);
        }
    }

    public final void writeExternal(ObjectOutput out) {
        int n2 = this.e == null ? -1 : this.e.length;
        this.a(out);
        out.writeInt(this.c);
        for (int i2 = 0; i2 <= this.c; ++i2) {
            for (int i3 = 0; i3 < n2; ++i3) {
                out.writeDouble(this.a[i2][i3]);
            }
        }
    }

    public final void readExternal(ObjectInput in) {
        double d2 = this.a(in);
        int n2 = this.e == null ? -1 : this.e.length;
        int n3 = in.readInt();
        this.c(n3);
        this.c = n3;
        for (n3 = 0; n3 <= this.c; ++n3) {
            for (int i2 = 0; i2 < n2; ++i2) {
                this.a[n3][i2] = in.readDouble();
            }
        }
        this.d(d2);
    }
}

