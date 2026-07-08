/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.oS;
import org.valkyrienskies.core.impl.shadow.pn_0;
import org.valkyrienskies.core.impl.shadow.pw_0;
import org.valkyrienskies.core.impl.shadow.px_0;
import org.valkyrienskies.core.impl.shadow.uA;
import org.valkyrienskies.core.impl.shadow.uE;
import org.valkyrienskies.core.impl.shadow.uF;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.vx
 */
public abstract class vx_0
extends uA {
    protected double h;
    protected double i;
    protected double[] j;
    protected double[] k;
    protected int l;
    private double f;
    private double g;
    private double m;

    public vx_0(String object, double d2, double d3, double d4, double d5) {
        super((String)object);
        double d6 = d5;
        double d7 = d4;
        double d8 = d3;
        double d9 = d2;
        object = this;
        this.g = BY.w(d9);
        ((vx_0)object).m = BY.w(d8);
        ((vx_0)object).f = -1.0;
        ((vx_0)object).h = d7;
        ((vx_0)object).i = d6;
        ((vx_0)object).j = null;
        ((vx_0)object).k = null;
        this.l();
    }

    public vx_0(String object, double d2, double d3, double[] dArray, double[] dArray2) {
        super((String)object);
        double[] dArray3 = dArray2;
        double[] dArray4 = dArray;
        double d4 = d3;
        double d5 = d2;
        object = this;
        this.g = BY.w(d5);
        ((vx_0)object).m = BY.w(d4);
        ((vx_0)object).f = -1.0;
        ((vx_0)object).h = 0.0;
        ((vx_0)object).i = 0.0;
        ((vx_0)object).j = (double[])dArray4.clone();
        ((vx_0)object).k = (double[])dArray3.clone();
        this.l();
    }

    private void a(double d2, double d3, double d4, double d5) {
        this.g = BY.w(d2);
        this.m = BY.w(d3);
        this.f = -1.0;
        this.h = d4;
        this.i = d5;
        this.j = null;
        this.k = null;
    }

    private void a(double d2, double d3, double[] dArray, double[] dArray2) {
        this.g = BY.w(d2);
        this.m = BY.w(d3);
        this.f = -1.0;
        this.h = 0.0;
        this.i = 0.0;
        this.j = (double[])dArray.clone();
        this.k = (double[])dArray2.clone();
    }

    private void a(double d2) {
        if (d2 < this.g || d2 > this.m) {
            this.f = -1.0;
            return;
        }
        this.f = d2;
    }

    public final void b(uF object, double d2) {
        super.b((uF)object, d2);
        object = ((uF)object).b;
        this.l = ((uE)object).b;
        if (this.j != null && this.j.length != this.l) {
            throw new oS(this.l, this.j.length);
        }
        if (this.k != null && this.k.length != this.l) {
            throw new oS(this.l, this.k.length);
        }
    }

    public final double a(boolean bl, int n2, double[] dArray, double d2, double[] dArray2, double[] dArray3, double[] dArray4, double[] dArray5) {
        vx_0 vx_02;
        vx_0 vx_03;
        double d3;
        double d4;
        double d5;
        double d6;
        if (this.f > 0.0) {
            if (bl) {
                return this.f;
            }
            return -this.f;
        }
        double d7 = 0.0;
        double d8 = 0.0;
        for (int i2 = 0; i2 < dArray.length; ++i2) {
            double d9 = d6 = dArray2[i2] / dArray[i2];
            d7 += d9 * d9;
            double d10 = d6 = dArray3[i2] / dArray[i2];
            d8 += d10 * d10;
        }
        double d11 = d5 = d7 < 1.0E-10 || d8 < 1.0E-10 ? 1.0E-6 : 0.01 * BY.a(d7 / d8);
        if (!bl) {
            d5 = -d5;
        }
        for (int i3 = 0; i3 < dArray2.length; ++i3) {
            dArray4[i3] = dArray2[i3] + d5 * dArray3[i3];
        }
        this.a(d2 + d5, dArray4, dArray5);
        double d12 = 0.0;
        for (int i4 = 0; i4 < dArray.length; ++i4) {
            double d13 = d6 = (dArray5[i4] - dArray3[i4]) / dArray[i4];
            d12 += d13 * d13;
        }
        d12 = BY.a(d12) / d5;
        double d14 = BY.e(BY.a(d8), d12);
        double d15 = d4 < 1.0E-15 ? BY.e(1.0E-6, 0.001 * BY.w(d5)) : BY.a(0.01 / d14, 1.0 / (double)n2);
        d5 = BY.d(100.0 * BY.w(d5), d15);
        d5 = BY.e(d5, 1.0E-12 * BY.w(d2));
        vx_0 vx_04 = this;
        if (d3 < vx_03.g) {
            vx_04 = this;
            d5 = vx_04.g;
        }
        vx_04 = this;
        if (d5 > vx_02.m) {
            vx_04 = this;
            d5 = vx_04.m;
        }
        if (!bl) {
            d5 = -d5;
        }
        return d5;
    }

    protected final double a(double d2, boolean bl, boolean bl2) {
        double d3 = d2;
        if (BY.w(d2) < this.g) {
            if (bl2) {
                d3 = bl ? this.g : -this.g;
            } else {
                throw new pn_0((pw_0)px_0.MINIMAL_STEPSIZE_REACHED_DURING_INTEGRATION, (Number)BY.w(d2), this.g, true);
            }
        }
        if (d3 > this.m) {
            d3 = this.m;
        } else if (d3 < -this.m) {
            d3 = -this.m;
        }
        return d3;
    }

    public abstract void a(uF var1, double var2);

    public final double f() {
        return this.a;
    }

    protected final void l() {
        this.a = Double.NaN;
        this.b = BY.a(this.g * this.m);
    }

    private double n() {
        return this.g;
    }

    public final double m() {
        return this.m;
    }
}

