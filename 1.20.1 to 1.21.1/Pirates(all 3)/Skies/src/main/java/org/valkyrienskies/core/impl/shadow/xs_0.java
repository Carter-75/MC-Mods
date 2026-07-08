/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.nO;
import org.valkyrienskies.core.impl.shadow.oY;
import org.valkyrienskies.core.impl.shadow.pb_0;
import org.valkyrienskies.core.impl.shadow.px_0;
import org.valkyrienskies.core.impl.shadow.wI;
import org.valkyrienskies.core.impl.shadow.wK;
import org.valkyrienskies.core.impl.shadow.wO;
import org.valkyrienskies.core.impl.shadow.wQ;
import org.valkyrienskies.core.impl.shadow.xi_0;
import org.valkyrienskies.core.impl.shadow.xj_0;
import org.valkyrienskies.core.impl.shadow.xl_0;
import org.valkyrienskies.core.impl.shadow.xt_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.xs
 */
public final class xs_0
extends xj_0 {
    private final int b;
    private final xt_0 c;
    private final xl_0 d;

    private xs_0(int n2, wK<wQ> wK2) {
        this(n2, wK2, 1.0E-8, 1.0E-8, 1.0E-8, new c());
    }

    @Deprecated
    private xs_0(int n2, wK<wQ> wK2, nO nO2) {
        this(n2, wK2, nO2, new c());
    }

    private xs_0(int n2, wK<wQ> wK2, double d2, double d3, double d4) {
        this(n2, wK2, d2, d3, d4, new c());
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    @Deprecated
    private xs_0(int n2, wK wK2, nO nO2, c c2) {
        this(n2, wK2, nO2.h(), nO2.g(), nO2.g(), c2);
    }

    private xs_0(int n2, wK<wQ> wK2, double d2, double d3, double d4, xt_0 xt_02) {
        super(wK2);
        this.b = n2;
        this.c = xt_02;
        this.d = new xl_0(this, d2, d3, d4);
    }

    @Override
    public final wQ c(wO ... wOArray) {
        return super.c(wOArray);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private wQ b() {
        var1_1 = this.j();
        var2_2 = this.e();
        var3_3 = this.n();
        var4_4 = var2_2.length;
        var5_5 /* !! */  = this.a(var2_2);
        if (var3_3 == xi_0.MINIMIZE) {
            for (var6_6 = 0; var6_6 < var4_4; ++var6_6) {
                var5_5 /* !! */ [var6_6] = -var5_5 /* !! */ [var6_6];
            }
        }
        var6_7 = this.c.a(var5_5 /* !! */ );
        var7_8 = (double[])var6_7.clone();
        var8_9 = 0.0;
        for (var10_10 = 0; var10_10 < var4_4; ++var10_10) {
            var8_9 += var5_5 /* !! */ [var10_10] * var7_8[var10_10];
        }
        var10_11 = null;
        block6: while (true) {
            this.l();
            var11_13 = this.b(var2_2);
            var5_5 /* !! */  = var10_11;
            var10_11 = new wQ(var2_2, var11_13);
            if (var5_5 /* !! */  != null && var1_1.a(this.i(), (wQ)var5_5 /* !! */ , var10_11)) {
                return var10_11;
            }
            v0 = this.d.a(var2_2, var7_8);
            var5_5 /* !! */  = (double[])v0;
            var14_15 = v0.a;
            for (var16_17 = 0; var16_17 < var2_2.length; ++var16_17) {
                v1 = var16_17;
                var2_2[v1] = var2_2[v1] + var14_15 * var7_8[var16_17];
            }
            var5_5 /* !! */  = this.a(var2_2);
            if (var3_3 == xi_0.MINIMIZE) {
                for (var16_17 = 0; var16_17 < var4_4; ++var16_17) {
                    var5_5 /* !! */ [var16_17] = -var5_5 /* !! */ [var16_17];
                }
            }
            var16_16 = var8_9;
            var11_12 = this.c.a(var5_5 /* !! */ );
            var8_9 = 0.0;
            for (var19_19 = 0; var19_19 < var4_4; ++var19_19) {
                var8_9 += var5_5 /* !! */ [var19_19] * var11_12[var19_19];
            }
            switch (1.a[this.b - 1]) {
                case 1: {
                    var19_18 = var8_9 / var16_16;
                    break;
                }
                case 2: {
                    var21_20 = 0.0;
                    for (var12_14 = 0; var12_14 < var5_5 /* !! */ .length; ++var12_14) {
                        var21_20 += var5_5 /* !! */ [var12_14] * var6_7[var12_14];
                    }
                    var19_18 = (var8_9 - var21_20) / var16_16;
                    break;
                }
                default: {
                    throw new oY();
                }
            }
            var6_7 = var11_12;
            if (this.i() % var4_4 == 0 || var19_18 < 0.0) {
                var7_8 = (double[])var6_7.clone();
                continue;
            }
            var21_21 = 0;
            while (true) {
                if (var21_21 < var4_4) ** break;
                continue block6;
                var7_8[var21_21] = var6_7[var21_21] + var19_18 * var7_8[var21_21];
                ++var21_21;
            }
            break;
        }
    }

    @Override
    public final void b(wO ... object) {
        super.b((wO[])object);
        object = this;
        if (((wI)object).f() != null || ((wI)object).g() != null) {
            throw new pb_0(px_0.CONSTRAINT, new Object[0]);
        }
    }

    private void d() {
        if (this.f() != null || this.g() != null) {
            throw new pb_0(px_0.CONSTRAINT, new Object[0]);
        }
    }

    @Override
    public final /* synthetic */ Object a(wO[] object) {
        wO[] wOArray = object;
        object = this;
        return super.c(wOArray);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    @Override
    public final /* synthetic */ Object c() {
        var1_1 = this;
        var2_2 = var1_1.j();
        var3_3 = var1_1.e();
        var4_4 = var1_1.n();
        var5_5 = var3_3.length;
        var6_6 /* !! */  = var1_1.a(var3_3);
        if (var4_4 == xi_0.MINIMIZE) {
            for (var7_7 = 0; var7_7 < var5_5; ++var7_7) {
                var6_6 /* !! */ [var7_7] = -var6_6 /* !! */ [var7_7];
            }
        }
        var7_8 = var1_1.c.a(var6_6 /* !! */ );
        var8_9 = (double[])var7_8.clone();
        var9_10 = 0.0;
        for (var11_11 = 0; var11_11 < var5_5; ++var11_11) {
            var9_10 += var6_6 /* !! */ [var11_11] * var8_9[var11_11];
        }
        var11_12 = null;
        block6: while (true) {
            var1_1.l();
            var12_14 = var1_1.b(var3_3);
            var6_6 /* !! */  = var11_12;
            var11_12 = new wQ(var3_3, var12_14);
            if (var6_6 /* !! */  != null && var2_2.a(var1_1.i(), (wQ)var6_6 /* !! */ , var11_12)) {
                return var11_12;
            }
            v0 = var1_1.d.a(var3_3, var8_9);
            var6_6 /* !! */  = (double[])v0;
            var15_16 = v0.a;
            for (var17_18 = 0; var17_18 < var3_3.length; ++var17_18) {
                v1 = var17_18;
                var3_3[v1] = var3_3[v1] + var15_16 * var8_9[var17_18];
            }
            var6_6 /* !! */  = var1_1.a(var3_3);
            if (var4_4 == xi_0.MINIMIZE) {
                for (var17_18 = 0; var17_18 < var5_5; ++var17_18) {
                    var6_6 /* !! */ [var17_18] = -var6_6 /* !! */ [var17_18];
                }
            }
            var17_17 = var9_10;
            var12_13 = var1_1.c.a(var6_6 /* !! */ );
            var9_10 = 0.0;
            for (var20_20 = 0; var20_20 < var5_5; ++var20_20) {
                var9_10 += var6_6 /* !! */ [var20_20] * var12_13[var20_20];
            }
            switch (1.a[var1_1.b - 1]) {
                case 1: {
                    var20_19 = var9_10 / var17_17;
                    break;
                }
                case 2: {
                    var22_21 = 0.0;
                    for (var13_15 = 0; var13_15 < var6_6 /* !! */ .length; ++var13_15) {
                        var22_21 += var6_6 /* !! */ [var13_15] * var7_8[var13_15];
                    }
                    var20_19 = (var9_10 - var22_21) / var17_17;
                    break;
                }
                default: {
                    throw new oY();
                }
            }
            var7_8 = var12_13;
            if (var1_1.i() % var5_5 == 0 || var20_19 < 0.0) {
                var8_9 = (double[])var7_8.clone();
                continue;
            }
            var22_22 = 0;
            while (true) {
                if (var22_22 < var5_5) ** break;
                continue block6;
                var8_9[var22_22] = var7_8[var22_22] + var20_19 * var8_9[var22_22];
                ++var22_22;
            }
            break;
        }
    }

    static final class 1 {
        static final /* synthetic */ int[] a;

        static {
            a = new int[org.valkyrienskies.core.impl.shadow.xs$b.values$41b1d4e6().length];
            try {
                1.a[org.valkyrienskies.core.impl.shadow.xs$b.FLETCHER_REEVES$65df34e0 - 1] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                1.a[org.valkyrienskies.core.impl.shadow.xs$b.POLAK_RIBIERE$65df34e0 - 1] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
        }
    }

    public static final class c
    implements xt_0 {
        public final double[] a(double[] dArray) {
            return (double[])dArray.clone();
        }
    }

    @Deprecated
    public static final class a
    implements wO {
        private final double a;

        private a(double d2) {
            this.a = d2;
        }

        private double a() {
            return this.a;
        }
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    public static final class b
    extends Enum<b> {
        public static final int FLETCHER_REEVES$65df34e0 = 1;
        public static final int POLAK_RIBIERE$65df34e0 = 2;
        private static final /* synthetic */ int[] $VALUES$7075a8c5;

        public static int[] values$41b1d4e6() {
            return (int[])$VALUES$7075a8c5.clone();
        }

        private b() {
        }

        static {
            $VALUES$7075a8c5 = new int[]{FLETCHER_REEVES$65df34e0, POLAK_RIBIERE$65df34e0};
        }
    }
}

