/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.ch_0;
import org.valkyrienskies.core.impl.shadow.pb_0;
import org.valkyrienskies.core.impl.shadow.pk_0;
import org.valkyrienskies.core.impl.shadow.pn_0;
import org.valkyrienskies.core.impl.shadow.px_0;
import org.valkyrienskies.core.impl.shadow.wI;
import org.valkyrienskies.core.impl.shadow.wK;
import org.valkyrienskies.core.impl.shadow.wQ;
import org.valkyrienskies.core.impl.shadow.xS;
import org.valkyrienskies.core.impl.shadow.xi_0;
import org.valkyrienskies.core.impl.shadow.xl_0;
import org.valkyrienskies.core.impl.shadow.xp_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.xz
 */
public final class xz_0
extends xp_0 {
    private static final double b = 2.0 * BY.x(1.0);
    private final double c;
    private final double d;
    private final xl_0 e;

    private xz_0(double d2, double d3, wK<wQ> wK2) {
        this(d2, d3, BY.a(d2), BY.a(d3), null);
    }

    private xz_0(double d2, double d3, double d4, double d5, wK<wQ> wK2) {
        super(wK2);
        if (d2 < b) {
            throw new pn_0(d2, (Number)b, true);
        }
        if (d3 <= 0.0) {
            throw new pk_0(d3);
        }
        this.c = d2;
        this.d = d3;
        this.e = new xl_0(this, d4, d5, 1.0);
    }

    private xz_0(double d2, double d3) {
        this(d2, d3, null);
    }

    private xz_0(double d2, double d3, double d4, double d5) {
        this(d2, d3, d4, d5, null);
    }

    private wQ b() {
        Object object = this;
        if (((wI)object).f() != null || ((wI)object).g() != null) {
            throw new pb_0(px_0.CONSTRAINT, new Object[0]);
        }
        object = this.n();
        double[] dArray = this.e();
        int n2 = dArray.length;
        double[][] dArray2 = new double[n2][n2];
        for (int i2 = 0; i2 < n2; ++i2) {
            dArray2[i2][i2] = 1.0;
        }
        wK<wQ> wK2 = this.j();
        double d2 = this.b(dArray);
        double[] dArray3 = (double[])dArray.clone();
        while (true) {
            double d3;
            double d4;
            double d5;
            Object object2;
            Object object3;
            int n3;
            this.l();
            double d6 = d2;
            double d7 = 0.0;
            int n4 = 0;
            for (n3 = 0; n3 < n2; ++n3) {
                object3 = dArray2[n3];
                object2 = ch_0.a(object3, ((double[])object3).length);
                d5 = d2;
                xS xS2 = this.e.a(dArray, (double[])object2);
                object3 = xS2;
                d2 = xS2.b;
                xS xS3 = xS2;
                object3 = xS3;
                double d8 = xS3.a;
                double[][] dArray4 = xz_0.a(dArray, object2, d8);
                object2 = dArray4;
                dArray = dArray4[0];
                if (!(d5 - d2 > d7)) continue;
                d7 = d5 - d2;
                n4 = n3;
            }
            n3 = 2.0 * (d6 - d2) <= this.c * (BY.w(d6) + BY.w(d2)) + this.d ? 1 : 0;
            object2 = new wQ(dArray3, d6);
            wQ wQ2 = new wQ(dArray, d2);
            if (n3 == 0 && wK2 != null) {
                n3 = wK2.a(this.i(), (wQ)object2, wQ2) ? 1 : 0;
            }
            if (n3 != 0) {
                if (object == xi_0.MINIMIZE) {
                    if (d2 < d6) {
                        return wQ2;
                    }
                    return object2;
                }
                if (d2 > d6) {
                    return wQ2;
                }
                return object2;
            }
            object2 = new double[n2];
            double[] dArray5 = new double[n2];
            for (int i3 = 0; i3 < n2; ++i3) {
                object2[i3] = dArray[i3] - dArray3[i3];
                dArray5[i3] = 2.0 * dArray[i3] - dArray3[i3];
            }
            dArray3 = (double[])dArray.clone();
            d5 = this.b(dArray5);
            if (!(d6 > d5)) continue;
            double d9 = 2.0 * (d6 + d5 - d2 * 2.0);
            double d10 = d4 = d6 - d2 - d7;
            d9 *= d10 * d10;
            d4 = d6 - d5;
            d9 -= d7 * d4 * d4;
            if (!(d3 < 0.0)) continue;
            Object object4 = this.e.a(dArray, (double[])object2);
            object3 = object4;
            d2 = ((xS)object4).b;
            xS xS4 = object4;
            object3 = xS4;
            double d11 = xS4.a;
            double[][] dArray6 = xz_0.a(dArray, object2, d11);
            object4 = dArray6;
            dArray = dArray6[0];
            int n5 = n2 - 1;
            dArray2[n4] = dArray2[n5];
            dArray2[n5] = (double[])object4[1];
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

    private void d() {
        if (this.f() != null || this.g() != null) {
            throw new pb_0(px_0.CONSTRAINT, new Object[0]);
        }
    }

    @Override
    public final /* synthetic */ Object c() {
        wQ wQ2;
        xz_0 xz_02 = this;
        Object object = xz_02;
        if (xz_02.f() != null || ((wI)object).g() != null) {
            throw new pb_0(px_0.CONSTRAINT, new Object[0]);
        }
        object = xz_02.n();
        double[] dArray = xz_02.e();
        int n2 = dArray.length;
        double[][] dArray2 = new double[n2][n2];
        for (int i2 = 0; i2 < n2; ++i2) {
            dArray2[i2][i2] = 1.0;
        }
        wK<wQ> wK2 = xz_02.j();
        double d2 = xz_02.b(dArray);
        double[] dArray3 = (double[])dArray.clone();
        while (true) {
            double d3;
            double d4;
            double d5;
            Object object2;
            Object object3;
            int n3;
            xz_02.l();
            double d6 = d2;
            double d7 = 0.0;
            int n4 = 0;
            for (n3 = 0; n3 < n2; ++n3) {
                object3 = dArray2[n3];
                object2 = ch_0.a(object3, ((double[])object3).length);
                d5 = d2;
                xS xS2 = xz_02.e.a(dArray, (double[])object2);
                object3 = xS2;
                d2 = xS2.b;
                xS xS3 = xS2;
                object3 = xS3;
                double d8 = xS3.a;
                double[][] dArray4 = xz_0.a(dArray, object2, d8);
                object2 = dArray4;
                dArray = dArray4[0];
                if (!(d5 - d2 > d7)) continue;
                d7 = d5 - d2;
                n4 = n3;
            }
            n3 = 2.0 * (d6 - d2) <= xz_02.c * (BY.w(d6) + BY.w(d2)) + xz_02.d ? 1 : 0;
            object2 = new wQ(dArray3, d6);
            wQ wQ3 = new wQ(dArray, d2);
            if (n3 == 0 && wK2 != null) {
                n3 = wK2.a(xz_02.i(), (wQ)object2, wQ3) ? 1 : 0;
            }
            if (n3 != 0) {
                if (object == xi_0.MINIMIZE) {
                    if (d2 < d6) {
                        wQ2 = wQ3;
                        break;
                    }
                    return object2;
                }
                if (d2 > d6) {
                    wQ2 = wQ3;
                    break;
                }
                return object2;
            }
            object2 = new double[n2];
            double[] dArray5 = new double[n2];
            for (int i3 = 0; i3 < n2; ++i3) {
                object2[i3] = dArray[i3] - dArray3[i3];
                dArray5[i3] = 2.0 * dArray[i3] - dArray3[i3];
            }
            dArray3 = (double[])dArray.clone();
            d5 = xz_02.b(dArray5);
            if (!(d6 > d5)) continue;
            double d9 = 2.0 * (d6 + d5 - d2 * 2.0);
            double d10 = d4 = d6 - d2 - d7;
            d9 *= d10 * d10;
            d4 = d6 - d5;
            d9 -= d7 * d4 * d4;
            if (!(d3 < 0.0)) continue;
            Object object4 = xz_02.e.a(dArray, (double[])object2);
            object3 = object4;
            d2 = ((xS)object4).b;
            xS xS4 = object4;
            object3 = xS4;
            double d11 = xS4.a;
            double[][] dArray6 = xz_0.a(dArray, object2, d11);
            object4 = dArray6;
            dArray = dArray6[0];
            int n5 = n2 - 1;
            dArray2[n4] = dArray2[n5];
            dArray2[n5] = (double[])object4[1];
        }
        return wQ2;
    }
}

