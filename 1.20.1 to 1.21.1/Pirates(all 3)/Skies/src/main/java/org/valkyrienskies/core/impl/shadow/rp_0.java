/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.valkyrienskies.core.impl.shadow.rp
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.rp;
import org.valkyrienskies.core.impl.shadow.rs_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.rp
 */
public final class rp_0
implements Serializable {
    private static final long a = 20130206L;
    private final rs_0 b;
    private final double c;
    private final double d;
    private final double e;
    private double[][] f;
    private double[][] g;
    private double[][] h;
    private double[][] i;

    public rp_0(rs_0 rs_02) {
        this.b = rs_02;
        this.c = rs_02.e();
        rs_0 rs_03 = rs_02;
        this.d = BY.b(rs_03.j, rs_03.i);
        this.e = BY.s(rs_02.k / this.c);
    }

    private rp_0(double d2, double d3, double d4) {
        double d5 = BY.o(d3);
        double d6 = BY.n(d3);
        double d7 = BY.o(d4);
        double d8 = BY.n(d4);
        this.c = d2;
        this.d = d3;
        this.e = d4;
        this.b = new rs_0(d2 * d5 * d8, d2 * d6 * d8, d2 * d7);
    }

    private rs_0 a() {
        return this.b;
    }

    private double b() {
        return this.c;
    }

    private double c() {
        return this.d;
    }

    private double d() {
        return this.e;
    }

    private double[] a(double[] dArray) {
        this.e();
        return new double[]{dArray[0] * this.f[0][0] + dArray[1] * this.f[1][0] + dArray[2] * this.f[2][0], dArray[0] * this.f[0][1] + dArray[1] * this.f[1][1] + dArray[2] * this.f[2][1], dArray[0] * this.f[0][2] + dArray[2] * this.f[2][2]};
    }

    private double[][] a(double[][] dArray, double[] dArray2) {
        Object object;
        this.e();
        Object object2 = this;
        if (((rp_0)object2).g == null) {
            object = ((rp_0)object2).b;
            double d2 = ((rs_0)object).i;
            object = ((rp_0)object2).b;
            double d3 = ((rs_0)object).j;
            object = ((rp_0)object2).b;
            double d4 = ((rs_0)object).k;
            double d5 = d2;
            double d6 = d5 * d5;
            double d7 = d3;
            double d8 = d7 * d7;
            double d9 = d4;
            double d10 = d9 * d9;
            double d11 = d6 + d8;
            double d12 = BY.a(d11);
            double d13 = d11 + d10;
            double d14 = d2 / ((rp_0)object2).c;
            double d15 = d3 / ((rp_0)object2).c;
            double d16 = d4 / ((rp_0)object2).c;
            double d17 = d2 / d11;
            double d18 = d3 / d11;
            double d19 = d14 / d13;
            double d20 = d15 / d13;
            double d21 = d16 / d13;
            ((rp_0)object2).g = new double[3][3];
            ((rp_0)object2).g[0][0] = d3 * d20 + d4 * d21;
            ((rp_0)object2).g[1][0] = -d2 * d20;
            ((rp_0)object2).g[2][0] = -d4 * d19;
            ((rp_0)object2).g[1][1] = d2 * d19 + d4 * d21;
            ((rp_0)object2).g[2][1] = -d3 * d21;
            ((rp_0)object2).g[2][2] = d2 * d19 + d3 * d20;
            ((rp_0)object2).g[0][1] = ((rp_0)object2).g[1][0];
            ((rp_0)object2).g[0][2] = ((rp_0)object2).g[2][0];
            ((rp_0)object2).g[1][2] = ((rp_0)object2).g[2][1];
            ((rp_0)object2).h = new double[2][2];
            ((rp_0)object2).h[0][0] = d17 * 2.0 * d18;
            double d22 = d18;
            double d23 = d17;
            ((rp_0)object2).h[1][0] = d22 * d22 - d23 * d23;
            ((rp_0)object2).h[1][1] = d17 * -2.0 * d18;
            ((rp_0)object2).h[0][1] = ((rp_0)object2).h[1][0];
            double d24 = d12 * d13;
            double d25 = d12 * d24;
            double d26 = d24 * d13;
            double d27 = d26 * d11;
            double d28 = d11 * 3.0 + d10;
            ((rp_0)object2).i = new double[3][3];
            ((rp_0)object2).i[0][0] = d4 * (d25 - d6 * d28) / d27;
            ((rp_0)object2).i[1][0] = -d2 * d3 * d4 * d28 / d27;
            ((rp_0)object2).i[2][0] = d2 * (d11 - d10) / d26;
            ((rp_0)object2).i[1][1] = d4 * (d25 - d8 * d28) / d27;
            ((rp_0)object2).i[2][1] = d3 * (d11 - d10) / d26;
            ((rp_0)object2).i[2][2] = d12 * 2.0 * d21 / ((rp_0)object2).c;
            ((rp_0)object2).i[0][1] = ((rp_0)object2).i[1][0];
            ((rp_0)object2).i[0][2] = ((rp_0)object2).i[2][0];
            ((rp_0)object2).i[1][2] = ((rp_0)object2).i[2][1];
        }
        object2 = new double[3][3];
        object = new double[3][3];
        object2[0][0] = dArray[0][0] * this.f[0][0] + dArray[1][0] * this.f[1][0] + dArray[2][0] * this.f[2][0];
        object2[0][1] = dArray[0][0] * this.f[0][1] + dArray[1][0] * this.f[1][1] + dArray[2][0] * this.f[2][1];
        object2[0][2] = dArray[0][0] * this.f[0][2] + dArray[2][0] * this.f[2][2];
        object2[1][0] = dArray[1][0] * this.f[0][0] + dArray[1][1] * this.f[1][0] + dArray[2][1] * this.f[2][0];
        object2[1][1] = dArray[1][0] * this.f[0][1] + dArray[1][1] * this.f[1][1] + dArray[2][1] * this.f[2][1];
        object2[2][0] = dArray[2][0] * this.f[0][0] + dArray[2][1] * this.f[1][0] + dArray[2][2] * this.f[2][0];
        object2[2][1] = dArray[2][0] * this.f[0][1] + dArray[2][1] * this.f[1][1] + dArray[2][2] * this.f[2][1];
        object2[2][2] = dArray[2][0] * this.f[0][2] + dArray[2][2] * this.f[2][2];
        object[0][0] = this.f[0][0] * object2[0][0] + this.f[1][0] * object2[1][0] + this.f[2][0] * object2[2][0];
        object[1][0] = this.f[0][1] * object2[0][0] + this.f[1][1] * object2[1][0] + this.f[2][1] * object2[2][0];
        object[2][0] = this.f[0][2] * object2[0][0] + this.f[2][2] * object2[2][0];
        object[1][1] = this.f[0][1] * object2[0][1] + this.f[1][1] * object2[1][1] + this.f[2][1] * object2[2][1];
        object[2][1] = this.f[0][2] * object2[0][1] + this.f[2][2] * object2[2][1];
        object[2][2] = this.f[0][2] * object2[0][2] + this.f[2][2] * object2[2][2];
        Object object3 = object[0];
        object3[0] = object3[0] + (dArray2[0] * this.g[0][0] + dArray2[1] * this.h[0][0] + dArray2[2] * this.i[0][0]);
        Object object4 = object[1];
        object4[0] = object4[0] + (dArray2[0] * this.g[1][0] + dArray2[1] * this.h[1][0] + dArray2[2] * this.i[1][0]);
        Object object5 = object[2];
        object5[0] = object5[0] + (dArray2[0] * this.g[2][0] + dArray2[2] * this.i[2][0]);
        Object object6 = object[1];
        object6[1] = object6[1] + (dArray2[0] * this.g[1][1] + dArray2[1] * this.h[1][1] + dArray2[2] * this.i[1][1]);
        Object object7 = object[2];
        object7[1] = object7[1] + (dArray2[0] * this.g[2][1] + dArray2[2] * this.i[2][1]);
        Object object8 = object[2];
        object8[2] = object8[2] + (dArray2[0] * this.g[2][2] + dArray2[2] * this.i[2][2]);
        object[0][1] = object[1][0];
        object[0][2] = object[2][0];
        object[1][2] = object[2][1];
        return object;
    }

    private void e() {
        if (this.f == null) {
            rs_0 rs_02 = this.b;
            double d2 = rs_02.i;
            rs_02 = this.b;
            double d3 = rs_02.j;
            rs_02 = this.b;
            double d4 = rs_02.k;
            double d5 = d2;
            double d6 = d3;
            double d7 = d5 * d5 + d6 * d6;
            double d8 = BY.a(d7);
            double d9 = d4;
            double d10 = d7 + d9 * d9;
            this.f = new double[3][3];
            this.f[0][0] = d2 / this.c;
            this.f[0][1] = d3 / this.c;
            this.f[0][2] = d4 / this.c;
            this.f[1][0] = -d3 / d7;
            this.f[1][1] = d2 / d7;
            this.f[2][0] = d2 * d4 / (d8 * d10);
            this.f[2][1] = d3 * d4 / (d8 * d10);
            this.f[2][2] = -d8 / d10;
        }
    }

    private void f() {
        if (this.g == null) {
            rs_0 rs_02 = this.b;
            double d2 = rs_02.i;
            rs_02 = this.b;
            double d3 = rs_02.j;
            rs_02 = this.b;
            double d4 = rs_02.k;
            double d5 = d2;
            double d6 = d5 * d5;
            double d7 = d3;
            double d8 = d7 * d7;
            double d9 = d4;
            double d10 = d9 * d9;
            double d11 = d6 + d8;
            double d12 = BY.a(d11);
            double d13 = d11 + d10;
            double d14 = d2 / this.c;
            double d15 = d3 / this.c;
            double d16 = d4 / this.c;
            double d17 = d2 / d11;
            double d18 = d3 / d11;
            double d19 = d14 / d13;
            double d20 = d15 / d13;
            double d21 = d16 / d13;
            this.g = new double[3][3];
            this.g[0][0] = d3 * d20 + d4 * d21;
            this.g[1][0] = -d2 * d20;
            this.g[2][0] = -d4 * d19;
            this.g[1][1] = d2 * d19 + d4 * d21;
            this.g[2][1] = -d3 * d21;
            this.g[2][2] = d2 * d19 + d3 * d20;
            this.g[0][1] = this.g[1][0];
            this.g[0][2] = this.g[2][0];
            this.g[1][2] = this.g[2][1];
            this.h = new double[2][2];
            this.h[0][0] = d17 * 2.0 * d18;
            double d22 = d18;
            double d23 = d17;
            this.h[1][0] = d22 * d22 - d23 * d23;
            this.h[1][1] = d17 * -2.0 * d18;
            this.h[0][1] = this.h[1][0];
            double d24 = d12 * d13;
            double d25 = d12 * d24;
            double d26 = d24 * d13;
            double d27 = d26 * d11;
            double d28 = d11 * 3.0 + d10;
            this.i = new double[3][3];
            this.i[0][0] = d4 * (d25 - d6 * d28) / d27;
            this.i[1][0] = -d2 * d3 * d4 * d28 / d27;
            this.i[2][0] = d2 * (d11 - d10) / d26;
            this.i[1][1] = d4 * (d25 - d8 * d28) / d27;
            this.i[2][1] = d3 * (d11 - d10) / d26;
            this.i[2][2] = d12 * 2.0 * d21 / this.c;
            this.i[0][1] = this.i[1][0];
            this.i[0][2] = this.i[2][0];
            this.i[1][2] = this.i[2][1];
        }
    }

    private a g() {
        rs_0 rs_02 = this.b;
        rs_0 rs_03 = rs_02;
        rs_0 rs_04 = this.b;
        rs_03 = rs_04;
        rs_03 = this.b;
        return new a(rs_02.i, rs_04.j, rs_03.k);
    }

    static final class a
    implements Serializable {
        private static final long a = 20130206L;
        private final double b;
        private final double c;
        private final double d;

        a(double d2, double d3, double d4) {
            this.b = d2;
            this.c = d3;
            this.d = d4;
        }

        private rp_0 a() {
            return new rp(new rs_0(this.b, this.c, this.d));
        }
    }
}

