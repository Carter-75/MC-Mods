/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.sy_0;
import org.valkyrienskies.core.impl.shadow.uA;
import org.valkyrienskies.core.impl.shadow.uE;
import org.valkyrienskies.core.impl.shadow.uF;
import org.valkyrienskies.core.impl.shadow.vr_0;
import org.valkyrienskies.core.impl.shadow.wz_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.vo
 */
public final class vo_0
extends vr_0 {
    private static final String m = "Adams-Bashforth";

    private vo_0(int n2, double d2, double d3, double d4, double d5) {
        int n3 = n2;
        super(m, n3, n3, d2, d3, d4, d5);
    }

    private vo_0(int n2, double d2, double d3, double[] dArray, double[] dArray2) {
        int n3 = n2;
        super(m, n3, n3, d2, d3, dArray, dArray2);
    }

    private double a(double[] dArray, double[] dArray2, double[] dArray3, sy_0 sy_02) {
        double d2 = 0.0;
        for (int i2 = 0; i2 < this.l; ++i2) {
            double d3;
            double d4 = BY.w(dArray2[i2]);
            double d5 = this.j == null ? this.h + this.i * d4 : this.j[i2] + this.k[i2] * d4;
            double d6 = 0.0;
            int n2 = sy_02.f() % 2 == 0 ? -1 : 1;
            for (int i3 = sy_02.f() - 1; i3 >= 0; --i3) {
                d6 += (double)n2 * sy_02.b(i3, i2);
                n2 = -n2;
            }
            double d7 = d3 = (dArray2[i2] - dArray[i2] + (d6 -= dArray3[i2])) / d5;
            d2 += d7 * d7;
        }
        return BY.a(d2 / (double)this.l);
    }

    /*
     * WARNING - void declaration
     */
    public final void a(uF uF2, double d2) {
        uF uF3;
        ((uA)this).b(uF2, d2);
        this.a(uF2);
        uF object3 = uF2;
        boolean bl = d2 > uF3.c;
        double[] dArray = uF2.g();
        double[] dArray2 = new double[dArray.length];
        wz_0 wz_02 = new wz_0();
        uF bl3 = uF2;
        wz_02.a(dArray, bl, bl3.b, uF2.d());
        uF uF4 = uF2;
        this.a(uF4.c, dArray, d2);
        uF uF5 = uF2;
        this.b(uF5.c, dArray, d2);
        wz_02.a(this.a, this.b, this.f, this.g);
        wz_02.a(this.a);
        double d3 = this.b;
        wz_02.e(d3);
        this.c = false;
        do {
            boolean bl2;
            void var12_8;
            wz_02.c();
            double[] dArray3 = new double[dArray.length];
            double[] dArray4 = new double[dArray.length];
            Object var12_7 = null;
            double d4 = 10.0;
            while (d4 >= 1.0) {
                double d5;
                double d6 = this.a + d3;
                wz_02.a(d6);
                Object object = this.j();
                uF uF6 = object;
                uE uE2 = ((uF)object).b;
                uE2.b(wz_02.k(), dArray3);
                int n2 = 0;
                for (uE uE3 : ((uF)object).d()) {
                    uE3.b(wz_02.a(n2), dArray3);
                    ++n2;
                }
                this.a(d6, dArray3, dArray2);
                for (int i2 = 0; i2 < dArray4.length; ++i2) {
                    dArray4[i2] = d3 * dArray2[i2];
                }
                vo_0 vo_02 = this;
                sy_0 sy_02 = vo_02.a(vo_02.g);
                vo_0 vo_03 = this;
                vo_03.a(vo_03.f, dArray4, sy_02);
                object = sy_02;
                double[] dArray5 = dArray4;
                double[] dArray6 = dArray3;
                double[] dArray7 = dArray;
                vo_0 vo_04 = this;
                double d7 = 0.0;
                for (int i3 = 0; i3 < vo_04.l; ++i3) {
                    double d8;
                    double d9 = BY.w(dArray6[i3]);
                    double d10 = vo_04.j == null ? vo_04.h + vo_04.i * d9 : vo_04.j[i3] + vo_04.k[i3] * d9;
                    double d11 = 0.0;
                    n2 = object.f() % 2 == 0 ? -1 : 1;
                    for (int i4 = object.f() - 1; i4 >= 0; --i4) {
                        d11 += (double)n2 * object.b(i4, i3);
                        n2 = -n2;
                    }
                    double d12 = d8 = (dArray6[i3] - dArray7[i3] + (d11 -= dArray5[i3])) / d10;
                    d7 += d12 * d12;
                }
                d4 = BY.a(d7 / (double)vo_04.l);
                if (!(d5 >= 1.0)) continue;
                double d13 = this.a(d4);
                d3 = this.a(d3 * d13, bl, false);
                wz_02.e(d3);
            }
            this.b = d3;
            double d14 = this.a + this.b;
            wz_02.a(d14, this.b, dArray4, (sy_0)var12_8);
            wz_02.a(d14);
            System.arraycopy(dArray3, 0, dArray, 0, dArray.length);
            this.a = this.a(wz_02, dArray, dArray2, d2);
            this.f = dArray4;
            this.g = var12_8;
            wz_02.a(d14, this.b, this.f, this.g);
            if (this.c) continue;
            wz_02.a(this.a);
            if (this.d) {
                vo_0 vo_05 = this;
                vo_05.b(vo_05.a, dArray, d2);
                wz_02.a(this.a, this.b, this.f, this.g);
            }
            double d15 = this.a(d4);
            double d16 = this.b * d15;
            double d17 = this.a + d16;
            boolean bl4 = bl ? d17 >= d2 : d17 <= d2;
            d3 = this.a(d16, bl, bl4);
            double d18 = this.a + d3;
            boolean bl5 = bl ? d18 >= d2 : (bl2 = d18 <= d2);
            if (bl5) {
                d3 = d2 - this.a;
            }
            wz_02.e(d3);
        } while (!this.c);
        double d19 = this.a;
        uF uF7 = uF2;
        uF2.c = d19;
        uF2.b(dArray);
        this.l();
    }
}

