/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.uA;
import org.valkyrienskies.core.impl.shadow.uF;
import org.valkyrienskies.core.impl.shadow.vx_0;
import org.valkyrienskies.core.impl.shadow.wm_0;
import org.valkyrienskies.core.impl.shadow.ws_0;

public abstract class vL
extends vx_0 {
    private final boolean f;
    private final double[] g;
    private final double[][] m;
    private final double[] n;
    private final wm_0 o;
    private final double p;
    private double q;
    private double r;
    private double s;

    protected vL(String object, boolean bl, double[] dArray, double[][] dArray2, double[] dArray3, wm_0 wm_02, double d2, double d3, double d4, double d5) {
        super((String)object, d2, d3, d4, d5);
        this.f = bl;
        this.g = dArray;
        this.m = dArray2;
        this.n = dArray3;
        this.o = wm_02;
        this.p = -1.0 / (double)this.n();
        double d6 = 0.9;
        object = this;
        this.q = 0.9;
        d6 = 0.2;
        object = this;
        this.r = 0.2;
        d6 = 10.0;
        object = this;
        this.s = 10.0;
    }

    protected vL(String object, boolean bl, double[] dArray, double[][] dArray2, double[] dArray3, wm_0 wm_02, double d2, double d3, double[] dArray4, double[] dArray5) {
        super((String)object, d2, d3, dArray4, dArray5);
        this.f = bl;
        this.g = dArray;
        this.m = dArray2;
        this.n = dArray3;
        this.o = wm_02;
        this.p = -1.0 / (double)this.n();
        double d4 = 0.9;
        object = this;
        this.q = 0.9;
        d4 = 0.2;
        object = this;
        this.r = 0.2;
        d4 = 10.0;
        object = this;
        this.s = 10.0;
    }

    public abstract int n();

    private double o() {
        return this.q;
    }

    private void a(double d2) {
        this.q = 0.9;
    }

    public final void a(uF uF2, double d2) {
        uF uF3;
        ((uA)this).b(uF2, d2);
        this.a(uF2);
        uF uF4 = uF2;
        boolean bl = d2 > uF3.c;
        double[] dArray = uF2.g();
        double[] dArray2 = (double[])dArray.clone();
        int n2 = this.g.length + 1;
        double[][] dArray3 = new double[n2][dArray2.length];
        double[] dArray4 = (double[])dArray.clone();
        double[] dArray5 = new double[dArray2.length];
        wm_0 wm_02 = (wm_0)this.o.d();
        uF4 = uF2;
        wm_02.a(this, dArray4, dArray3, bl, uF4.b, uF2.d());
        uF4 = uF2;
        wm_02.a(uF4.c);
        uF4 = uF2;
        this.a = uF4.c;
        double d3 = 0.0;
        boolean bl2 = true;
        uF4 = uF2;
        this.a(uF4.c, dArray, d2);
        this.c = false;
        do {
            boolean bl3;
            double d4;
            ((ws_0)wm_02).c();
            double d5 = 10.0;
            while (d5 >= 1.0) {
                double d6;
                int n3;
                int n4;
                if (bl2 || !this.f) {
                    vL vL2 = this;
                    vL2.a(vL2.a, dArray2, dArray3[0]);
                }
                if (bl2) {
                    double[] dArray6 = new double[this.l];
                    if (this.j == null) {
                        for (n4 = 0; n4 < dArray6.length; ++n4) {
                            dArray6[n4] = this.h + this.i * BY.w(dArray2[n4]);
                        }
                    } else {
                        for (n4 = 0; n4 < dArray6.length; ++n4) {
                            dArray6[n4] = this.j[n4] + this.k[n4] * BY.w(dArray2[n4]);
                        }
                    }
                    d3 = this.a(bl, this.n(), dArray6, this.a, dArray2, dArray3[0], dArray4, dArray3[1]);
                    bl2 = false;
                }
                this.b = d3;
                if (bl) {
                    if (this.a + this.b >= d2) {
                        this.b = d2 - this.a;
                    }
                } else if (this.a + this.b <= d2) {
                    this.b = d2 - this.a;
                }
                for (n3 = 1; n3 < n2; ++n3) {
                    for (n4 = 0; n4 < dArray.length; ++n4) {
                        d4 = this.m[n3 - 1][0] * dArray3[0][n4];
                        for (int i2 = 1; i2 < n3; ++i2) {
                            d4 += this.m[n3 - 1][i2] * dArray3[i2][n4];
                        }
                        dArray4[n4] = dArray2[n4] + this.b * d4;
                    }
                    vL vL3 = this;
                    vL3.a(vL3.a + this.g[n3 - 1] * this.b, dArray4, dArray3[n3]);
                }
                for (n3 = 0; n3 < dArray.length; ++n3) {
                    double d7 = this.n[0] * dArray3[0][n3];
                    for (int i3 = 1; i3 < n2; ++i3) {
                        d7 += this.n[i3] * dArray3[i3][n3];
                    }
                    dArray4[n3] = dArray2[n3] + this.b * d7;
                }
                d5 = this.a(dArray3, dArray2, dArray4, this.b);
                if (!(d6 >= 1.0)) continue;
                double d8 = BY.d(this.s, BY.e(this.r, this.q * BY.a(d5, this.p)));
                vL vL4 = this;
                d3 = vL4.a(vL4.b * d8, bl, false);
            }
            wm_02.a(this.a + this.b);
            System.arraycopy(dArray4, 0, dArray2, 0, dArray.length);
            System.arraycopy(dArray3[n2 - 1], 0, dArray5, 0, dArray.length);
            this.a = this.a(wm_02, dArray2, dArray5, d2);
            System.arraycopy(dArray2, 0, dArray4, 0, dArray2.length);
            if (this.c) continue;
            wm_02.a(this.a);
            if (this.f) {
                System.arraycopy(dArray5, 0, dArray3[0], 0, dArray.length);
            }
            double d9 = BY.d(this.s, BY.e(this.r, this.q * BY.a(d5, this.p)));
            d4 = this.b * d9;
            double d10 = this.a + d4;
            boolean bl4 = bl ? d10 >= d2 : d10 <= d2;
            d3 = this.a(d4, bl, bl4);
            double d11 = this.a + d3;
            boolean bl5 = bl ? d11 >= d2 : (bl3 = d11 <= d2);
            if (!bl5) continue;
            d3 = d2 - this.a;
        } while (!this.c);
        double d12 = this.a;
        uF uF5 = uF2;
        uF2.c = d12;
        uF2.b(dArray2);
        this.l();
    }

    private double p() {
        return this.r;
    }

    private void b(double d2) {
        this.r = 0.2;
    }

    private double q() {
        return this.s;
    }

    private void c(double d2) {
        this.s = 10.0;
    }

    protected abstract double a(double[][] var1, double[] var2, double[] var3, double var4);
}

