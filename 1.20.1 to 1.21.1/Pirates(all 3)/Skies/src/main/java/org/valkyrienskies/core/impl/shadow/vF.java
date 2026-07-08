/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.uA;
import org.valkyrienskies.core.impl.shadow.uE;
import org.valkyrienskies.core.impl.shadow.wm_0;
import org.valkyrienskies.core.impl.shadow.ws_0;

final class vF
extends wm_0 {
    private static final double n = 0.09114583333333333;
    private static final double o = 0.44923629829290207;
    private static final double p = 0.6510416666666666;
    private static final double q = -0.322376179245283;
    private static final double r = 0.13095238095238096;
    private static final double s = -1.1270175653862835;
    private static final double t = 2.675424484351598;
    private static final double u = -5.685526961588504;
    private static final double v = 3.5219323679207912;
    private static final double w = -1.7672812570757455;
    private static final double x = 2.382468931778144;
    private static final long y = 20111120L;
    private double[] z;
    private double[] A;
    private double[] B;
    private double[] C;
    private boolean D;

    public vF() {
        this.z = null;
        this.A = null;
        this.B = null;
        this.C = null;
        this.D = false;
    }

    private vF(vF vF2) {
        super(vF2);
        if (vF2.z == null) {
            this.z = null;
            this.A = null;
            this.B = null;
            this.C = null;
            this.D = false;
            return;
        }
        this.z = (double[])vF2.z.clone();
        this.A = (double[])vF2.A.clone();
        this.B = (double[])vF2.B.clone();
        this.C = (double[])vF2.C.clone();
        this.D = vF2.D;
    }

    public final ws_0 a() {
        return new vF(this);
    }

    public final void a(uA uA2, double[] dArray, double[][] dArray2, boolean bl, uE uE2, uE[] uEArray) {
        super.a(uA2, dArray, dArray2, bl, uE2, uEArray);
        this.z = null;
        this.A = null;
        this.B = null;
        this.C = null;
        this.D = false;
    }

    public final void a(double d2) {
        super.a(d2);
        this.D = false;
    }

    public final void a(double d2, double d3) {
        if (!this.D) {
            if (this.z == null) {
                this.z = new double[this.g.length];
                this.A = new double[this.g.length];
                this.B = new double[this.g.length];
                this.C = new double[this.g.length];
            }
            for (int i2 = 0; i2 < this.g.length; ++i2) {
                double d4 = this.b[0][i2];
                double d5 = this.b[2][i2];
                double d6 = this.b[3][i2];
                double d7 = this.b[4][i2];
                double d8 = this.b[5][i2];
                double d9 = this.b[6][i2];
                this.z[i2] = d4 * 0.09114583333333333 + d5 * 0.44923629829290207 + d6 * 0.6510416666666666 + d7 * -0.322376179245283 + d8 * 0.13095238095238096;
                this.A[i2] = d4 - this.z[i2];
                this.B[i2] = this.z[i2] - this.A[i2] - d9;
                this.C[i2] = d4 * -1.1270175653862835 + d5 * 2.675424484351598 + d6 * -5.685526961588504 + d7 * 3.5219323679207912 + d8 * -1.7672812570757455 + d9 * 2.382468931778144;
            }
            this.D = true;
        }
        double d10 = 1.0 - d2;
        double d11 = d2 * 2.0;
        double d12 = 1.0 - d11;
        double d13 = d2 * (2.0 - d2 * 3.0);
        double d14 = d11 * (1.0 + d2 * (d11 - 3.0));
        if (this.a != null && d2 <= 0.5) {
            for (int i3 = 0; i3 < this.g.length; ++i3) {
                this.g[i3] = this.a[i3] + d2 * this.d * (this.z[i3] + d10 * (this.A[i3] + d2 * (this.B[i3] + d10 * this.C[i3])));
                this.h[i3] = this.z[i3] + d12 * this.A[i3] + d13 * this.B[i3] + d14 * this.C[i3];
            }
            return;
        }
        for (int i4 = 0; i4 < this.g.length; ++i4) {
            this.g[i4] = this.e[i4] - d3 * (this.z[i4] - d2 * (this.A[i4] + d2 * (this.B[i4] + d10 * this.C[i4])));
            this.h[i4] = this.z[i4] + d12 * this.A[i4] + d13 * this.B[i4] + d14 * this.C[i4];
        }
    }
}

