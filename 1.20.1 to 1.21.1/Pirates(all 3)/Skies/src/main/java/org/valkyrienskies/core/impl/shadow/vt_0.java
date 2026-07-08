/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Arrays;
import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.sy_0;
import org.valkyrienskies.core.impl.shadow.tt_0;
import org.valkyrienskies.core.impl.shadow.uA;
import org.valkyrienskies.core.impl.shadow.uE;
import org.valkyrienskies.core.impl.shadow.uF;
import org.valkyrienskies.core.impl.shadow.vr_0;
import org.valkyrienskies.core.impl.shadow.wz_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.vt
 */
public final class vt_0
extends vr_0 {
    private static final String m = "Adams-Moulton";

    private vt_0(int n2, double d2, double d3, double d4, double d5) {
        int n3 = n2;
        super(m, n3, n3 + 1, d2, d3, d4, d5);
    }

    private vt_0(int n2, double d2, double d3, double[] dArray, double[] dArray2) {
        int n3 = n2;
        super(m, n3, n3 + 1, d2, d3, dArray, dArray2);
    }

    public final void a(uF uF2, double d2) {
        uF uF3;
        ((uA)this).b(uF2, d2);
        this.a(uF2);
        uF uF4 = uF2;
        boolean bl = d2 > uF3.c;
        double[] dArray = uF2.g();
        double[] dArray2 = (double[])dArray.clone();
        double[] dArray3 = new double[dArray2.length];
        double[] dArray4 = new double[dArray2.length];
        double[] dArray5 = new double[dArray2.length];
        sy_0 sy_02 = null;
        wz_0 wz_02 = new wz_0();
        uF4 = uF2;
        wz_02.a(dArray2, bl, uF4.b, uF2.d());
        uF4 = uF2;
        this.a(uF4.c, dArray, d2);
        uF4 = uF2;
        this.b(uF4.c, dArray2, d2);
        wz_02.a(this.a, this.b, this.f, this.g);
        wz_02.a(this.a);
        double d3 = this.b;
        wz_02.e(d3);
        this.c = false;
        do {
            boolean bl2;
            Object object;
            double d4;
            double d5 = 10.0;
            while (d5 >= 1.0) {
                double d6;
                uF uF5;
                this.b = d3;
                d4 = this.a + this.b;
                wz_02.d(d4);
                object = this.j();
                uE uE2 = uF5.b;
                uE2.b(wz_02.k(), dArray4);
                int n2 = 0;
                for (uE uE3 : ((uF)object).d()) {
                    uE3.b(wz_02.a(n2), dArray4);
                    ++n2;
                }
                this.a(d4, dArray4, dArray3);
                for (int i2 = 0; i2 < dArray.length; ++i2) {
                    dArray5[i2] = this.b * dArray3[i2];
                }
                vt_0 vt_02 = this;
                sy_02 = vt_02.a(vt_02.g);
                vt_0 vt_03 = this;
                vt_03.a(vt_03.f, dArray5, sy_02);
                d5 = sy_02.b(new a(this, dArray2, dArray5, dArray4));
                if (!(d6 >= 1.0)) continue;
                double d7 = this.a(d5);
                vt_0 vt_04 = this;
                d3 = vt_04.a(vt_04.b * d7, bl, false);
                wz_02.e(d3);
            }
            d4 = this.a + this.b;
            this.a(d4, dArray4, dArray3);
            object = new double[dArray.length];
            for (int i3 = 0; i3 < dArray.length; ++i3) {
                object[i3] = this.b * dArray3[i3];
            }
            this.a(dArray5, (double[])object, sy_02);
            System.arraycopy(dArray4, 0, dArray2, 0, dArray2.length);
            wz_02.a(d4, this.b, (double[])object, sy_02);
            wz_02.a(this.a);
            wz_02.c();
            wz_02.a(d4);
            this.a = this.a(wz_02, dArray2, dArray3, d2);
            this.f = (double[])object;
            this.g = sy_02;
            if (this.c) continue;
            wz_02.a(this.a);
            if (this.d) {
                vt_0 vt_05 = this;
                vt_05.b(vt_05.a, dArray2, d2);
                wz_02.a(this.a, this.b, this.f, this.g);
            }
            double d8 = this.a(d5);
            double d9 = this.b * d8;
            double d10 = this.a + d9;
            boolean bl3 = bl ? d10 >= d2 : d10 <= d2;
            d3 = this.a(d9, bl, bl3);
            double d11 = this.a + d3;
            boolean bl4 = bl ? d11 >= d2 : (bl2 = d11 <= d2);
            if (bl4) {
                d3 = d2 - this.a;
            }
            wz_02.e(d3);
        } while (!this.c);
        double d12 = this.a;
        uF uF6 = uF2;
        uF2.c = d12;
        uF2.b(dArray2);
        this.l();
    }

    final class a
    implements tt_0 {
        private final double[] a;
        private final double[] b;
        private final double[] c;
        private final double[] d;
        private /* synthetic */ vt_0 e;

        a(vt_0 vt_02, double[] dArray, double[] dArray2, double[] dArray3) {
            this.e = vt_02;
            this.a = dArray;
            this.b = dArray2;
            this.d = dArray3;
            this.c = (double[])dArray3.clone();
        }

        public final void a(int n2, int n3, int n4) {
            Arrays.fill(this.d, 0.0);
        }

        public final void a(int n2, int n3, double d2) {
            if ((n2 & 1) == 0) {
                int n4 = n3;
                this.d[n4] = this.d[n4] - d2;
                return;
            }
            int n5 = n3;
            this.d[n5] = this.d[n5] + d2;
        }

        public final double a() {
            double d2 = 0.0;
            for (int i2 = 0; i2 < this.d.length; ++i2) {
                double d3;
                int n2 = i2;
                this.d[n2] = this.d[n2] + (this.a[i2] + this.b[i2]);
                if (i2 >= this.e.l) continue;
                double d4 = BY.e(BY.w(this.a[i2]), BY.w(this.d[i2]));
                double d5 = this.e.j == null ? this.e.h + this.e.i * d4 : this.e.j[i2] + this.e.k[i2] * d4;
                double d6 = d3 = (this.d[i2] - this.c[i2]) / d5;
                d2 += d6 * d6;
            }
            return BY.a(d2 / (double)this.e.l);
        }
    }
}

