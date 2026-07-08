/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.ch_0;
import org.valkyrienskies.core.impl.shadow.kW;
import org.valkyrienskies.core.impl.shadow.lc_0;
import org.valkyrienskies.core.impl.shadow.pk_0;
import org.valkyrienskies.core.impl.shadow.pn_0;
import org.valkyrienskies.core.impl.shadow.ya_0;
import org.valkyrienskies.core.impl.shadow.yf_0;
import org.valkyrienskies.core.impl.shadow.yn_0;
import org.valkyrienskies.core.impl.shadow.yp_0;
import org.valkyrienskies.core.impl.shadow.yz_0;
import org.valkyrienskies.core.impl.shadow.zh_0;
import org.valkyrienskies.core.impl.shadow.zi_0;
import org.valkyrienskies.core.impl.shadow.zj_0;
import org.valkyrienskies.core.impl.shadow.zm_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
@Deprecated
public final class yH
extends yz_0<kW>
implements yn_0 {
    private static final double b = 2.0 * BY.x(1.0);
    private final double c;
    private final double d;
    private final a e;

    private yH(double d2, double d3, ya_0<yp_0> ya_02) {
        this(d2, d3, BY.a(d2), BY.a(d3), null);
    }

    private yH(double d2, double d3, double d4, double d5, ya_0<yp_0> ya_02) {
        super(ya_02);
        if (d2 < b) {
            throw new pn_0(d2, (Number)b, true);
        }
        if (d3 <= 0.0) {
            throw new pk_0(d3);
        }
        this.c = d2;
        this.d = d3;
        this.e = new a(d4, d5);
    }

    private yH(double d2, double d3) {
        this(d2, d3, null);
    }

    private yH(double d2, double d3, double d4, double d5) {
        this(d2, d3, d4, d5, null);
    }

    @Override
    protected final yp_0 d() {
        yf_0 yf_02 = this.e();
        double[] dArray = this.f();
        int n2 = dArray.length;
        double[][] dArray2 = new double[n2][n2];
        for (int i2 = 0; i2 < n2; ++i2) {
            dArray2[i2][i2] = 1.0;
        }
        ya_0<yp_0> ya_02 = this.c();
        double d2 = this.a(dArray);
        double[] dArray3 = (double[])dArray.clone();
        int n3 = 0;
        while (true) {
            double d3;
            double d4;
            double d5;
            Object object;
            Object object2;
            int n4;
            ++n3;
            double d6 = d2;
            double d7 = 0.0;
            int n5 = 0;
            for (n4 = 0; n4 < n2; ++n4) {
                object2 = dArray2[n4];
                object = ch_0.a(object2, ((double[])object2).length);
                d5 = d2;
                zm_0 zm_02 = this.e.a(dArray, (double[])object);
                object2 = zm_02;
                d2 = zm_02.b;
                zm_0 zm_03 = zm_02;
                object2 = zm_03;
                double d8 = zm_03.a;
                double[][] dArray4 = yH.a(dArray, object, d8);
                object = dArray4;
                dArray = dArray4[0];
                if (!(d5 - d2 > d7)) continue;
                d7 = d5 - d2;
                n5 = n4;
            }
            n4 = 2.0 * (d6 - d2) <= this.c * (BY.w(d6) + BY.w(d2)) + this.d ? 1 : 0;
            object = new yp_0(dArray3, d6);
            yp_0 yp_02 = new yp_0(dArray, d2);
            if (n4 == 0 && ya_02 != null) {
                n4 = ya_02.a(n3, (yp_0)object, yp_02) ? 1 : 0;
            }
            if (n4 != 0) {
                if (yf_02 == yf_0.MINIMIZE) {
                    if (d2 < d6) {
                        return yp_02;
                    }
                    return object;
                }
                if (d2 > d6) {
                    return yp_02;
                }
                return object;
            }
            object = new double[n2];
            double[] dArray5 = new double[n2];
            for (int i3 = 0; i3 < n2; ++i3) {
                object[i3] = dArray[i3] - dArray3[i3];
                dArray5[i3] = 2.0 * dArray[i3] - dArray3[i3];
            }
            dArray3 = (double[])dArray.clone();
            d5 = this.a(dArray5);
            if (!(d6 > d5)) continue;
            double d9 = 2.0 * (d6 + d5 - d2 * 2.0);
            double d10 = d4 = d6 - d2 - d7;
            d9 *= d10 * d10;
            d4 = d6 - d5;
            d9 -= d7 * d4 * d4;
            if (!(d3 < 0.0)) continue;
            Object object3 = this.e.a(dArray, (double[])object);
            object2 = object3;
            d2 = ((zm_0)object3).b;
            zm_0 zm_04 = object3;
            object2 = zm_04;
            double d11 = zm_04.a;
            double[][] dArray6 = yH.a(dArray, object, d11);
            object3 = dArray6;
            dArray = dArray6[0];
            int n6 = n2 - 1;
            dArray2[n5] = dArray2[n6];
            dArray2[n6] = (double[])object3[1];
        }
    }

    private static double[][] a(double[] dArray, double[] dArray2, double d2) {
        int n2 = dArray.length;
        double[] dArray3 = new double[n2];
        double[] dArray4 = new double[n2];
        for (int i2 = 0; i2 < n2; ++i2) {
            dArray4[i2] = dArray2[i2] * d2;
            dArray3[i2] = dArray[i2] + dArray4[i2];
        }
        double[][] dArrayArray = new double[2][];
        double[][] dArrayArray2 = dArrayArray;
        dArrayArray[0] = dArray3;
        dArrayArray2[1] = dArray4;
        return dArrayArray2;
    }

    final class a
    extends zi_0 {
        private static final double b = 1.0E-15;
        private static final double c = Double.MIN_VALUE;
        private final zh_0 d;

        a(double d2, double d3) {
            super(1.0E-15, Double.MIN_VALUE, new zj_0(d2, d3));
            this.d = new zh_0();
        }

        public final zm_0 a(double[] object, double[] object2) {
            int n2 = ((double[])object).length;
            object = new lc_0(this, n2, (double[])object, (double[])object2){
                private /* synthetic */ int a;
                private /* synthetic */ double[] b;
                private /* synthetic */ double[] c;
                private /* synthetic */ a d;
                {
                    this.d = a2;
                    this.a = n2;
                    this.b = dArray;
                    this.c = dArray2;
                }

                public final double a(double d2) {
                    double[] dArray = new double[this.a];
                    for (int i2 = 0; i2 < this.a; ++i2) {
                        dArray[i2] = this.b[i2] + d2 * this.c[i2];
                    }
                    double d3 = this.d.yH.this.a(dArray);
                    return d3;
                }
            };
            yH yH2 = yH.this;
            object2 = yH2;
            object2 = yH2.a;
            this.d.a(object, (yf_0)object2, 0.0, 1.0);
            Object object3 = object2;
            zh_0 zh_02 = this.d;
            object2 = zh_02;
            zh_0 zh_03 = this.d;
            object2 = zh_03;
            zh_0 zh_04 = this.d;
            object2 = zh_04;
            return this.a(Integer.MAX_VALUE, (lc_0)object, (yf_0)object3, zh_02.a, zh_03.b, zh_04.c);
        }
    }
}

