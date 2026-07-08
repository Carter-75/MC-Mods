/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.lc_0;
import org.valkyrienskies.core.impl.shadow.nO;
import org.valkyrienskies.core.impl.shadow.nz_0;
import org.valkyrienskies.core.impl.shadow.oX;
import org.valkyrienskies.core.impl.shadow.px_0;
import org.valkyrienskies.core.impl.shadow.yQ;
import org.valkyrienskies.core.impl.shadow.yR;
import org.valkyrienskies.core.impl.shadow.yV;
import org.valkyrienskies.core.impl.shadow.ya_0;
import org.valkyrienskies.core.impl.shadow.yf_0;
import org.valkyrienskies.core.impl.shadow.yp_0;
import org.valkyrienskies.core.impl.shadow.yt_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
@Deprecated
public final class yU
extends yQ {
    private final int c;
    private final yV d;
    private final nO e;
    private double f;
    double[] b;

    @Deprecated
    private yU(int n2) {
        this(n2, new yt_0());
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    private yU(int n2, yt_0 yt_02) {
        this(n2, yt_02, new nz_0(), new a());
    }

    private yU(int n2, ya_0<yp_0> ya_02, nO nO2) {
        this(n2, ya_02, nO2, new a());
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    private yU(int n2, ya_0 ya_02, nO nO2, a a2) {
        super(ya_02);
        this.c = n2;
        this.e = nO2;
        this.d = a2;
        this.f = 1.0;
    }

    private void a(double d2) {
        if (d2 <= 0.0) {
            this.f = 1.0;
            return;
        }
        this.f = d2;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    @Override
    public final yp_0 d() {
        var1_1 = this.c();
        this.b = this.f();
        var2_2 = this.e();
        var3_3 = this.b.length;
        v0 = this;
        var4_4 /* !! */  = v0.b(v0.b);
        if (var2_2 == yf_0.MINIMIZE) {
            for (var5_5 = 0; var5_5 < var3_3; ++var5_5) {
                var4_4 /* !! */ [var5_5] = -var4_4 /* !! */ [var5_5];
            }
        }
        var5_6 /* !! */  = this.d.a(var4_4 /* !! */ );
        var6_7 = (double[])var5_6 /* !! */ .clone();
        var7_8 = 0.0;
        for (var9_9 = 0; var9_9 < var3_3; ++var9_9) {
            var7_8 += var4_4 /* !! */ [var9_9] * var6_7[var9_9];
        }
        var9_10 = null;
        var10_11 = 0;
        var11_12 = this.a();
        block2: while (true) {
            block16: {
                v1 = this;
                var12_18 = v1.a(v1.b);
                var4_4 /* !! */  = var9_10;
                var9_10 = new yp_0(this.b, var12_18);
                if (var4_4 /* !! */  != null && var1_1.a(++var10_11, (yp_0)var4_4 /* !! */ , var9_10)) {
                    return var9_10;
                }
                v2 = new b(this, var6_7);
                var4_4 /* !! */  = (double[])v2;
                var31_29 = this.f;
                var29_28 = 0.0;
                var12_17 = v2;
                var33_13 = v2.a(0.0);
                for (var37_15 = var31_29; var37_15 < 1.7976931348623157E308; var37_15 *= BY.e(2.0, var33_13 / var35_14)) {
                    var39_16 = var37_15 + 0.0;
                    var35_14 = var12_17.a(var39_16);
                    if (!(var33_13 * var35_14 <= 0.0)) {
                        continue;
                    }
                    break block16;
                }
                throw new oX(px_0.UNABLE_TO_BRACKET_OPTIMUM_IN_LINE_SEARCH, new Object[0]);
            }
            var16_20 = var39_16;
            var18_21 = this.e.b(var11_12, var4_4 /* !! */ , 0.0, var16_20, 1.0E-15);
            var11_12 -= this.e.c();
            for (var20_23 = 0; var20_23 < this.b.length; ++var20_23) {
                v3 = var20_23;
                this.b[v3] = this.b[v3] + var18_21 * var6_7[var20_23];
            }
            v4 = this;
            var4_4 /* !! */  = v4.b(v4.b);
            if (var2_2 == yf_0.MINIMIZE) {
                for (var20_23 = 0; var20_23 < var3_3; ++var20_23) {
                    var4_4 /* !! */ [var20_23] = -var4_4 /* !! */ [var20_23];
                }
            }
            var20_22 = var7_8;
            var12_17 = this.d.a(var4_4 /* !! */ );
            var7_8 = 0.0;
            for (var23_25 = 0; var23_25 < var3_3; ++var23_25) {
                var7_8 += var4_4 /* !! */ [var23_25] * var12_17[var23_25];
            }
            if (this.c == yR.FLETCHER_REEVES$7966eac9) {
                var23_24 = var7_8 / var20_22;
            } else {
                var25_26 = 0.0;
                for (var13_19 = 0; var13_19 < var4_4 /* !! */ .length; ++var13_19) {
                    var25_26 += var4_4 /* !! */ [var13_19] * var5_6 /* !! */ [var13_19];
                }
                var23_24 = (var7_8 - var25_26) / var20_22;
            }
            var5_6 /* !! */  = (double[])var12_17;
            if (var10_11 % var3_3 == 0 || var23_24 < 0.0) {
                var6_7 = (double[])var5_6 /* !! */ .clone();
                continue;
            }
            var25_27 = 0;
            while (true) {
                if (var25_27 < var3_3) ** break;
                continue block2;
                var6_7[var25_27] = var5_6 /* !! */ [var25_27] + var23_24 * var6_7[var25_27];
                ++var25_27;
            }
            break;
        }
    }

    private static double a(b b2, double d2, double d3) {
        double d4;
        double d5 = b2.a(0.0);
        for (double d6 = d3; d6 < Double.MAX_VALUE; d6 *= BY.e(2.0, d5 / d4)) {
            double d7 = d6 + 0.0;
            d4 = b2.a(d7);
            if (!(d5 * d4 <= 0.0)) continue;
            return d7;
        }
        throw new oX(px_0.UNABLE_TO_BRACKET_OPTIMUM_IN_LINE_SEARCH, new Object[0]);
    }

    static /* synthetic */ double[] a(yU yU2) {
        return yU2.b;
    }

    final class b
    implements lc_0 {
        private final double[] a;
        private /* synthetic */ yU b;

        b(yU yU2, double[] dArray) {
            this.b = yU2;
            this.a = dArray;
        }

        public final double a(double d2) {
            Object object = this.b;
            object = (double[])((yU)object).b.clone();
            for (int i2 = 0; i2 < ((Object)object).length; ++i2) {
                Object object2 = object;
                int n2 = i2;
                object2[n2] = object2[n2] + d2 * this.a[i2];
            }
            double[] dArray = this.b.b((double[])object);
            double d3 = 0.0;
            for (int i3 = 0; i3 < dArray.length; ++i3) {
                d3 += dArray[i3] * this.a[i3];
            }
            return d3;
        }
    }

    public static final class a
    implements yV {
        public final double[] a(double[] dArray) {
            return (double[])dArray.clone();
        }
    }
}

