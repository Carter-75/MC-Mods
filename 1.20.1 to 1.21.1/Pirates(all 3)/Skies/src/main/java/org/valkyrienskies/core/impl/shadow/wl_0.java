/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.uA;
import org.valkyrienskies.core.impl.shadow.uF;
import org.valkyrienskies.core.impl.shadow.uM;
import org.valkyrienskies.core.impl.shadow.wm_0;
import org.valkyrienskies.core.impl.shadow.ws_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.wl
 */
public abstract class wl_0
extends uA {
    private final double[] f;
    private final double[][] g;
    private final double[] h;
    private final wm_0 i;
    private final double j;

    protected wl_0(String string, double[] dArray, double[][] dArray2, double[] dArray3, wm_0 wm_02, double d2) {
        super(string);
        this.f = dArray;
        this.g = dArray2;
        this.h = dArray3;
        this.i = wm_02;
        this.j = BY.w(d2);
    }

    public final void a(uF uF2, double d2) {
        uF uF3;
        this.b(uF2, d2);
        this.a(uF2);
        uF uF4 = uF2;
        boolean bl = d2 > uF3.c;
        double[] dArray = uF2.g();
        double[] dArray2 = (double[])dArray.clone();
        int n2 = this.f.length + 1;
        double[][] dArrayArray = new double[n2][];
        for (int i2 = 0; i2 < n2; ++i2) {
            dArrayArray[i2] = new double[dArray.length];
        }
        double[] dArray3 = (double[])dArray.clone();
        double[] dArray4 = new double[dArray.length];
        wm_0 wm_02 = (wm_0)this.i.d();
        uF4 = uF2;
        wm_02.a(this, dArray3, dArrayArray, bl, uF4.b, uF2.d());
        uF4 = uF2;
        wm_02.a(uF4.c);
        uF4 = uF2;
        this.a = uF4.c;
        this.b = bl ? (this.a + this.j >= d2 ? d2 - this.a : this.j) : (this.a - this.j <= d2 ? d2 - this.a : -this.j);
        uF4 = uF2;
        this.a(uF4.c, dArray, d2);
        this.c = false;
        do {
            boolean bl2;
            int n3;
            ((ws_0)wm_02).c();
            wl_0 wl_02 = this;
            wl_02.a(wl_02.a, dArray2, dArrayArray[0]);
            for (n3 = 1; n3 < n2; ++n3) {
                for (int i3 = 0; i3 < dArray.length; ++i3) {
                    double d3 = this.g[n3 - 1][0] * dArrayArray[0][i3];
                    for (int i4 = 1; i4 < n3; ++i4) {
                        d3 += this.g[n3 - 1][i4] * dArrayArray[i4][i3];
                    }
                    dArray3[i3] = dArray2[i3] + this.b * d3;
                }
                wl_0 wl_03 = this;
                wl_03.a(wl_03.a + this.f[n3 - 1] * this.b, dArray3, dArrayArray[n3]);
            }
            for (n3 = 0; n3 < dArray.length; ++n3) {
                double d4 = this.h[0] * dArrayArray[0][n3];
                for (int i5 = 1; i5 < n2; ++i5) {
                    d4 += this.h[i5] * dArrayArray[i5][n3];
                }
                dArray3[n3] = dArray2[n3] + this.b * d4;
            }
            wm_02.a(this.a + this.b);
            System.arraycopy(dArray3, 0, dArray2, 0, dArray.length);
            System.arraycopy(dArrayArray[n2 - 1], 0, dArray4, 0, dArray.length);
            this.a = this.a(wm_02, dArray2, dArray4, d2);
            if (this.c) continue;
            wm_02.a(this.a);
            double d5 = this.a + this.b;
            boolean bl3 = bl ? d5 >= d2 : (bl2 = d5 <= d2);
            if (!bl3) continue;
            this.b = d2 - this.a;
        } while (!this.c);
        double d6 = this.a;
        uF uF5 = uF2;
        uF2.c = d6;
        uF2.b(dArray2);
        this.a = Double.NaN;
        this.b = Double.NaN;
    }

    private double[] a(uM uM2, double d2, double[] dArray, double d3) {
        int n2;
        double[] dArray2 = (double[])dArray.clone();
        int n3 = this.f.length + 1;
        double[][] dArrayArray = new double[n3][];
        for (int i2 = 0; i2 < n3; ++i2) {
            dArrayArray[i2] = new double[dArray.length];
        }
        double[] dArray3 = (double[])dArray.clone();
        double d4 = d3 - d2;
        uM2.a(d2, dArray2, dArrayArray[0]);
        for (n2 = 1; n2 < n3; ++n2) {
            for (int i3 = 0; i3 < dArray.length; ++i3) {
                double d5 = this.g[n2 - 1][0] * dArrayArray[0][i3];
                for (int i4 = 1; i4 < n2; ++i4) {
                    d5 += this.g[n2 - 1][i4] * dArrayArray[i4][i3];
                }
                dArray3[i3] = dArray2[i3] + d4 * d5;
            }
            uM2.a(d2 + this.f[n2 - 1] * d4, dArray3, dArrayArray[n2]);
        }
        n2 = 0;
        while (n2 < dArray.length) {
            double d6 = this.h[0] * dArrayArray[0][n2];
            for (int i5 = 1; i5 < n3; ++i5) {
                d6 += this.h[i5] * dArrayArray[i5][n2];
            }
            int n4 = n2++;
            dArray2[n4] = dArray2[n4] + d4 * d6;
        }
        return dArray2;
    }
}

