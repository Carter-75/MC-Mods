/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.kW;
import org.valkyrienskies.core.impl.shadow.oX;
import org.valkyrienskies.core.impl.shadow.pn_0;
import org.valkyrienskies.core.impl.shadow.po_0;
import org.valkyrienskies.core.impl.shadow.px_0;
import org.valkyrienskies.core.impl.shadow.sA;
import org.valkyrienskies.core.impl.shadow.sv_0;
import org.valkyrienskies.core.impl.shadow.sy_0;
import org.valkyrienskies.core.impl.shadow.tp_0;
import org.valkyrienskies.core.impl.shadow.tu_0;
import org.valkyrienskies.core.impl.shadow.yA;
import org.valkyrienskies.core.impl.shadow.yf_0;
import org.valkyrienskies.core.impl.shadow.yn_0;
import org.valkyrienskies.core.impl.shadow.yp_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.yy
 */
@Deprecated
public final class yy_0
extends yA<kW>
implements yn_0 {
    private static int b = 2;
    private static double c = 10.0;
    private static double d = 1.0E-8;
    private static final double e = 0.0;
    private static final double f = 1.0;
    private static final double g = 2.0;
    private static final double h = 10.0;
    private static final double i = 16.0;
    private static final double j = 250.0;
    private static final double k = -1.0;
    private static final double l = 0.5;
    private static final double m = 0.25;
    private static final double n = 0.125;
    private static final double o = 0.1;
    private static final double p = 0.001;
    private final int q;
    private double r;
    private final double s;
    private boolean t;
    private sA u;
    private double[] v;
    private int w;
    private sy_0 x;
    private sy_0 y;
    private sy_0 z;
    private sA A;
    private sA B;
    private sA C;
    private sA D;
    private sA E;
    private sA F;
    private sA G;
    private sA H;
    private sA I;
    private sA J;
    private sA K;
    private sA L;

    private yy_0(int n2) {
        this(n2, 10.0, 1.0E-8);
    }

    private yy_0(int n2, double d2, double d3) {
        super(null);
        this.q = n2;
        this.r = 10.0;
        this.s = 1.0E-8;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    @Override
    protected final yp_0 d() {
        var1_1 = this.g();
        var5_3 = var2_2 = this.h();
        var4_5 = var1_1;
        var3_7 = this;
        var6_9 = var3_7.f();
        var7_11 = var6_9.length;
        if (var7_11 < 2) {
            throw new pn_0(var7_11, (Number)2, true);
        }
        var10_12 /* !! */  = new int[]{var7_11 + 2, (var7_11 + 2) * (var7_11 + 1) / 2};
        if (var3_7.q < var10_12 /* !! */ [0] || var3_7.q > var10_12 /* !! */ [1]) {
            throw new po_0(px_0.NUMBER_OF_INTERPOLATION_POINTS, (Number)var3_7.q, var10_12 /* !! */ [0], var10_12 /* !! */ [1]);
        }
        var3_7.v = new double[var7_11];
        var11_14 = 2.0 * var3_7.r;
        var13_16 = Infinity;
        for (var15_18 = 0; var15_18 < var7_11; ++var15_18) {
            var3_7.v[var15_18] = var5_3[var15_18] - var4_5[var15_18];
            var13_16 = BY.d(var13_16, var3_7.v[var15_18]);
        }
        if (var13_16 < var11_14) {
            var3_7.r = var13_16 / 3.0;
        }
        var3_7.x = new sy_0(var7_11 + var3_7.q, var7_11);
        var3_7.y = new sy_0(var3_7.q, var3_7.q - var7_11 - 1);
        var3_7.z = new sy_0(var3_7.q, var7_11);
        var3_7.A = new sA(var7_11);
        var3_7.B = new sA(var3_7.q);
        var3_7.C = new sA(var7_11);
        var3_7.D = new sA(var7_11);
        var3_7.E = new sA(var7_11);
        var3_7.F = new sA(var7_11);
        var3_7.G = new sA(var3_7.q);
        var3_7.H = new sA(var7_11);
        var3_7.I = new sA(var7_11);
        var3_7.J = new sA(var7_11);
        var3_7.K = new sA(var7_11 + var3_7.q);
        v0 = var7_11;
        var3_7.L = new sA(v0 * (v0 + 1) / 2);
        this.t = this.e() == yf_0.MINIMIZE;
        this.u = new sA(this.f());
        var5_3 = var2_2;
        var4_5 = var1_1;
        var3_7 = this;
        var102_19 = var3_7.u;
        var6_10 = var102_19.a.length;
        for (var7_11 = 0; var7_11 < var6_10; ++var7_11) {
            var10_13 = var3_7.v[var7_11];
            var3_7.E.a(var7_11, var4_5[var7_11] - var3_7.u.a(var7_11));
            var3_7.F.a(var7_11, var5_3[var7_11] - var3_7.u.a(var7_11));
            if (var3_7.E.a(var7_11) >= -var3_7.r) {
                if (var3_7.E.a(var7_11) >= 0.0) {
                    var3_7.u.a(var7_11, var4_5[var7_11]);
                    var3_7.E.a(var7_11, 0.0);
                    var3_7.F.a(var7_11, var10_13);
                    continue;
                }
                var3_7.u.a(var7_11, var4_5[var7_11] + var3_7.r);
                var3_7.E.a(var7_11, -var3_7.r);
                var12_20 = var5_3[var7_11] - var3_7.u.a(var7_11);
                var3_7.F.a(var7_11, BY.e(var12_20, var3_7.r));
                continue;
            }
            if (!(var3_7.F.a(var7_11) <= var3_7.r)) continue;
            if (var3_7.F.a(var7_11) <= 0.0) {
                var3_7.u.a(var7_11, var5_3[var7_11]);
                var3_7.E.a(var7_11, -var10_13);
                var3_7.F.a(var7_11, 0.0);
                continue;
            }
            var3_7.u.a(var7_11, var5_3[var7_11] - var3_7.r);
            var12_20 = var4_5[var7_11] - var3_7.u.a(var7_11);
            var14_22 = -var3_7.r;
            var3_7.E.a(var7_11, BY.d(var12_20, var14_22));
            var3_7.F.a(var7_11, var3_7.r);
        }
        v1 = var3_7;
        var3_7 = var5_3;
        var2_2 = var4_5;
        var1_1 = v1;
        var102_19 = v1.u;
        var4_6 = var102_19.a.length;
        var5_4 = var1_1.q;
        var6_10 = var4_6 + 1;
        var7_11 = var5_4 - var6_10;
        var6_10 = var4_6 * var6_10 / 2;
        var8_24 = new sA(var4_6);
        var9_25 = new sA(var5_4);
        var10_12 /* !! */  = (int[])new sA(var5_4);
        var27_26 = NaN;
        var29_27 = NaN;
        var31_28 = NaN;
        var1_1.w = 0;
        super.c(var2_2, (double[])var3_7);
        var35_29 = 0.0;
        for (var37_30 = 0; var37_30 < var4_6; ++var37_30) {
            var1_1.C.a(var37_30, var1_1.z.b(var1_1.w, var37_30));
            v2 = var38_32 = var1_1.C.a(var37_30);
            var35_29 += v2 * v2;
        }
        var37_31 = var1_1.B.a(0);
        var11_15 = 0;
        var12_21 = 0;
        var13_17 = 0;
        var14_23 = var1_1.b();
        var46_34 = var44_33 = var1_1.r;
        var48_35 = 0.0;
        var50_36 = 0.0;
        var52_37 = 0.0;
        var54_38 = 0.0;
        var56_39 = 0.0;
        var58_40 = 0.0;
        var60_41 = 0.0;
        var62_42 = 0.0;
        var64_43 = 0.0;
        var70_44 = 0.0;
        var72_45 = 20;
        block14: while (true) {
            switch (var72_45) {
                case 20: {
                    if (var1_1.w != 0) {
                        var73_49 = 0;
                        for (var74_60 = 0; var74_60 < var4_6; ++var74_60) {
                            for (var75_68 = 0; var75_68 <= var74_60; ++var75_68) {
                                if (var75_68 < var74_60) {
                                    v3 = var1_1.D;
                                    v3.a(var74_60, v3.a(var74_60) + var1_1.L.a(var73_49) * var1_1.C.a(var75_68));
                                }
                                v4 = var1_1.D;
                                v4.a(var75_68, v4.a(var75_68) + var1_1.L.a(var73_49) * var1_1.C.a(var74_60));
                                ++var73_49;
                            }
                        }
                        if (var1_1.b() > var5_4) {
                            for (var74_60 = 0; var74_60 < var5_4; ++var74_60) {
                                var75_69 = 0.0;
                                for (var77_81 = 0; var77_81 < var4_6; ++var77_81) {
                                    var75_69 += var1_1.z.b(var74_60, var77_81) * var1_1.C.a(var77_81);
                                }
                                var75_69 *= var1_1.G.a(var74_60);
                                for (var77_81 = 0; var77_81 < var4_6; ++var77_81) {
                                    v5 = var1_1.D;
                                    v5.a(var77_81, v5.a(var77_81) + var75_69 * var1_1.z.b(var74_60, var77_81));
                                }
                            }
                        }
                    }
                }
                case 60: {
                    var73_50 = new sA(var4_6);
                    var74_61 = new sA(var4_6);
                    var75_70 = new sA(var4_6);
                    var76_75 = new sA(var4_6);
                    var77_82 = new sA(var4_6);
                    var78_89 = super.a(var46_34, var73_50, var74_61, var75_70, var76_75, var77_82);
                    var31_28 = var78_89[0];
                    var33_46 = var78_89[1];
                    var79_99 = var46_34;
                    var81_113 = BY.a(var31_28);
                    var64_43 = BY.d(var79_99, var81_113);
                    if (v6 < var44_33 * 0.5) {
                        var11_15 = -1;
                        var79_99 = var44_33 * 10.0;
                        var70_44 = var79_99 * var79_99;
                        if (var1_1.b() <= var14_23 + 2) {
                            var72_45 = 650;
                            continue block14;
                        }
                        var79_99 = BY.e(var48_35, var50_36);
                        var83_122 = BY.e(var79_99, var52_37);
                        var85_131 = var44_33 * 0.125 * var44_33;
                        if (var33_46 > 0.0 && var83_122 > var85_131 * var33_46) {
                            var72_45 = 650;
                            continue block14;
                        }
                        var87_145 = var83_122 / var44_33;
                        for (var89_152 = 0; var89_152 < var4_6; ++var89_152) {
                            var90_155 = var87_145;
                            if (var1_1.H.a(var89_152) == var1_1.E.a(var89_152)) {
                                var90_155 = var8_24.a(var89_152);
                            }
                            if (var1_1.H.a(var89_152) == var1_1.F.a(var89_152)) {
                                var90_155 = -var8_24.a(var89_152);
                            }
                            if (!(var90_155 < var87_145)) continue;
                            v7 = var89_152;
                            var92_158 = var1_1.L.a((v7 + v7 * var89_152) / 2);
                            for (var94_159 = 0; var94_159 < var5_4; ++var94_159) {
                                v8 = var95_162 = var1_1.z.b(var94_159, var89_152);
                                var92_158 += var1_1.G.a(var94_159) * (v8 * v8);
                            }
                            if ((var90_155 += var92_158 * 0.5 * var44_33) < var87_145) break;
                        }
                        var72_45 = 680;
                        continue block14;
                    }
                    ++var11_15;
                }
                case 90: {
                    if (var31_28 <= var35_29 * 0.001) {
                        var73_51 = var35_29 * 0.25;
                        var75_71 = 0.0;
                        for (var77_83 = 0; var77_83 < var5_4; ++var77_83) {
                            var75_71 += var1_1.G.a(var77_83);
                            var78_90 = var35_29 * -0.5;
                            for (var80_105 = 0; var80_105 < var4_6; ++var80_105) {
                                var78_90 += var1_1.z.b(var77_83, var80_105) * var1_1.C.a(var80_105);
                            }
                            var9_25.a(var77_83, var78_90);
                            var80_106 = var73_51 - var78_90 * 0.5;
                            for (var82_114 = 0; var82_114 < var4_6; ++var82_114) {
                                var8_24.a(var82_114, var1_1.x.b(var77_83, var82_114));
                                var1_1.K.a(var82_114, var78_90 * var1_1.z.b(var77_83, var82_114) + var80_106 * var1_1.C.a(var82_114));
                                var83_123 = var5_4 + var82_114;
                                for (var84_128 = 0; var84_128 <= var82_114; ++var84_128) {
                                    var1_1.x.c(var83_123, var84_128, var1_1.x.b(var83_123, var84_128) + var8_24.a(var82_114) * var1_1.K.a(var84_128) + var1_1.K.a(var82_114) * var8_24.a(var84_128));
                                }
                            }
                        }
                        for (var77_83 = 0; var77_83 < var7_11; ++var77_83) {
                            var78_91 = 0.0;
                            var80_107 = 0.0;
                            for (var82_114 = 0; var82_114 < var5_4; ++var82_114) {
                                var78_91 += var1_1.y.b(var82_114, var77_83);
                                var1_1.K.a(var82_114, var9_25.a(var82_114) * var1_1.y.b(var82_114, var77_83));
                                var80_107 += var1_1.K.a(var82_114);
                            }
                            for (var82_114 = 0; var82_114 < var4_6; ++var82_114) {
                                var83_124 = (var73_51 * var78_91 - var80_107 * 0.5) * var1_1.C.a(var82_114);
                                for (var85_132 = 0; var85_132 < var5_4; ++var85_132) {
                                    var83_124 += var1_1.K.a(var85_132) * var1_1.z.b(var85_132, var82_114);
                                }
                                var8_24.a(var82_114, var83_124);
                                for (var85_132 = 0; var85_132 < var5_4; ++var85_132) {
                                    var1_1.x.c(var85_132, var82_114, var1_1.x.b(var85_132, var82_114) + var83_124 * var1_1.y.b(var85_132, var77_83));
                                }
                            }
                            for (var82_114 = 0; var82_114 < var4_6; ++var82_114) {
                                var83_125 = var82_114 + var5_4;
                                var84_129 = var8_24.a(var82_114);
                                for (var86_141 = 0; var86_141 <= var82_114; ++var86_141) {
                                    var1_1.x.c(var83_125, var86_141, var1_1.x.b(var83_125, var86_141) + var84_129 * var8_24.a(var86_141));
                                }
                            }
                        }
                        var77_83 = 0;
                        for (var78_92 = 0; var78_92 < var4_6; ++var78_92) {
                            var8_24.a(var78_92, var75_71 * -0.5 * var1_1.C.a(var78_92));
                            for (var79_100 = 0; var79_100 < var5_4; ++var79_100) {
                                var8_24.a(var78_92, var8_24.a(var78_92) + var1_1.G.a(var79_100) * var1_1.z.b(var79_100, var78_92));
                                var1_1.z.c(var79_100, var78_92, var1_1.z.b(var79_100, var78_92) - var1_1.C.a(var78_92));
                            }
                            for (var79_100 = 0; var79_100 <= var78_92; ++var79_100) {
                                v9 = var1_1.L;
                                v9.a(var77_83, v9.a(var77_83) + var8_24.a(var79_100) * var1_1.C.a(var78_92) + var1_1.C.a(var79_100) * var8_24.a(var78_92));
                                var1_1.x.c(var5_4 + var79_100, var78_92, var1_1.x.b(var5_4 + var78_92, var79_100));
                                ++var77_83;
                            }
                        }
                        for (var78_92 = 0; var78_92 < var4_6; ++var78_92) {
                            v10 = var1_1.A;
                            v10.a(var78_92, v10.a(var78_92) + var1_1.C.a(var78_92));
                            v11 = var1_1.H;
                            v11.a(var78_92, v11.a(var78_92) - var1_1.C.a(var78_92));
                            v12 = var1_1.E;
                            v12.a(var78_92, v12.a(var78_92) - var1_1.C.a(var78_92));
                            v13 = var1_1.F;
                            v13.a(var78_92, v13.a(var78_92) - var1_1.C.a(var78_92));
                            var1_1.C.a(var78_92, 0.0);
                        }
                        var35_29 = 0.0;
                    }
                    if (var11_15 == 0) {
                        var72_45 = 210;
                        continue block14;
                    }
                    var72_45 = 230;
                    continue block14;
                }
                case 210: {
                    var73_52 = super.a(var13_17, var58_40);
                    var29_27 = var73_52[0];
                    var27_26 = var73_52[1];
                    for (var74_62 = 0; var74_62 < var4_6; ++var74_62) {
                        var1_1.J.a(var74_62, var1_1.H.a(var74_62) - var1_1.C.a(var74_62));
                    }
                }
                case 230: {
                    for (var73_53 = 0; var73_53 < var5_4; ++var73_53) {
                        var74_63 = 0.0;
                        var76_76 = 0.0;
                        var78_93 = 0.0;
                        for (var80_108 = 0; var80_108 < var4_6; ++var80_108) {
                            var74_63 += var1_1.z.b(var73_53, var80_108) * var1_1.J.a(var80_108);
                            var76_76 += var1_1.z.b(var73_53, var80_108) * var1_1.C.a(var80_108);
                            var78_93 += var1_1.x.b(var73_53, var80_108) * var1_1.J.a(var80_108);
                        }
                        var10_12 /* !! */ .a(var73_53, var74_63 * (var74_63 * 0.5 + var76_76));
                        var1_1.K.a(var73_53, var78_93);
                        var9_25.a(var73_53, var74_63);
                    }
                    var56_39 = 0.0;
                    for (var73_53 = 0; var73_53 < var7_11; ++var73_53) {
                        var74_64 = 0.0;
                        for (var76_77 = 0; var76_77 < var5_4; ++var76_77) {
                            var74_64 += var1_1.y.b(var76_77, var73_53) * var10_12 /* !! */ .a(var76_77);
                        }
                        v14 = var74_64;
                        var56_39 -= v14 * v14;
                        for (var76_77 = 0; var76_77 < var5_4; ++var76_77) {
                            v15 = var1_1.K;
                            v15.a(var76_77, v15.a(var76_77) + var74_64 * var1_1.y.b(var76_77, var73_53));
                        }
                    }
                    var31_28 = 0.0;
                    var73_54 = 0.0;
                    var75_72 = 0.0;
                    for (var77_84 = 0; var77_84 < var4_6; ++var77_84) {
                        v16 = var78_94 = var1_1.J.a(var77_84);
                        var31_28 += v16 * v16;
                        var80_109 = 0.0;
                        for (var82_115 = 0; var82_115 < var5_4; ++var82_115) {
                            var80_109 += var10_12 /* !! */ .a(var82_115) * var1_1.x.b(var82_115, var77_84);
                        }
                        var73_54 += var80_109 * var1_1.J.a(var77_84);
                        var82_115 = var5_4 + var77_84;
                        for (var83_126 = 0; var83_126 < var4_6; ++var83_126) {
                            var80_109 += var1_1.x.b(var82_115, var83_126) * var1_1.J.a(var83_126);
                        }
                        var1_1.K.a(var82_115, var80_109);
                        var73_54 += var80_109 * var1_1.J.a(var77_84);
                        var75_72 += var1_1.J.a(var77_84) * var1_1.C.a(var77_84);
                    }
                    v17 = var75_72;
                    var56_39 = v17 * v17 + var31_28 * (var35_29 + var75_72 + var75_72 + var31_28 * 0.5) + var56_39 - var73_54;
                    var1_1.K.a(var1_1.w, var1_1.K.a(var1_1.w) + 1.0);
                    if (var11_15 != 0) ** GOTO lbl329
                    var77_85 = var1_1.K.a(var13_17);
                    var60_41 = var77_85 * var77_85 + var29_27 * var56_39;
                    if (v18 < var27_26 && var27_26 > 0.0) {
                        for (var79_101 = 0; var79_101 < var4_6; ++var79_101) {
                            var1_1.H.a(var79_101, var1_1.I.a(var79_101));
                            var1_1.J.a(var79_101, var1_1.H.a(var79_101) - var1_1.C.a(var79_101));
                        }
                        var27_26 = 0.0;
                        var72_45 = 230;
                        continue block14;
                    }
                    ** GOTO lbl357
lbl329:
                    // 1 sources

                    v19 = var46_34;
                    var77_86 = v19 * v19;
                    var66_47 = 0.0;
                    var68_48 = 0.0;
                    var13_17 = 0;
                    for (var79_102 = 0; var79_102 < var5_4; ++var79_102) {
                        if (var79_102 == var1_1.w) continue;
                        var80_110 = 0.0;
                        for (var82_116 = 0; var82_116 < var7_11; ++var82_116) {
                            v20 = var83_127 = var1_1.y.b(var79_102, var82_116);
                            var80_110 += v20 * v20;
                        }
                        v21 = var82_117 = var1_1.K.a(var79_102);
                        var84_130 = var56_39 * var80_110 + v21 * v21;
                        var70_44 = 0.0;
                        for (var86_142 = 0; var86_142 < var4_6; ++var86_142) {
                            v22 = var87_145 = var1_1.z.b(var79_102, var86_142) - var1_1.C.a(var86_142);
                            var70_44 += v22 * v22;
                        }
                        v23 = var86_143 = var70_44 / var77_86;
                        var88_151 = BY.e(1.0, v23 * v23);
                        if (v24 * var84_130 > var66_47) {
                            var66_47 = var88_151 * var84_130;
                            var13_17 = var79_102;
                            var60_41 = var84_130;
                        }
                        v25 = var90_155 = var1_1.K.a(var79_102);
                        var68_48 = BY.e(var68_48, var88_151 * (v25 * v25));
                    }
                }
lbl357:
                // 3 sources

                case 360: {
                    for (var73_55 = 0; var73_55 < var4_6; ++var73_55) {
                        var74_65 = var2_2[var73_55];
                        var76_78 = var1_1.A.a(var73_55) + var1_1.H.a(var73_55);
                        var78_95 = BY.e(var74_65, var76_78);
                        var80_107 = (double)var3_7[var73_55];
                        var1_1.u.a(var73_55, BY.d(var78_95, var80_107));
                        if (var1_1.H.a(var73_55) == var1_1.E.a(var73_55)) {
                            var1_1.u.a(var73_55, var2_2[var73_55]);
                        }
                        if (var1_1.H.a(var73_55) != var1_1.F.a(var73_55)) continue;
                        var1_1.u.a(var73_55, (double)var3_7[var73_55]);
                    }
                    v26 = var1_1;
                    var54_38 = v26.a(v26.u.g());
                    if (!var1_1.t) {
                        var54_38 = -var54_38;
                    }
                    if (var11_15 == -1) {
                        var37_31 = var54_38;
                        var72_45 = 720;
                        continue block14;
                    }
                    var73_56 = var1_1.B.a(var1_1.w);
                    var75_73 = 0.0;
                    var77_87 = 0;
                    for (var78_96 = 0; var78_96 < var4_6; ++var78_96) {
                        var75_73 += var1_1.J.a(var78_96) * var1_1.D.a(var78_96);
                        for (var79_103 = 0; var79_103 <= var78_96; ++var79_103) {
                            var80_111 = var1_1.J.a(var79_103) * var1_1.J.a(var78_96);
                            if (var79_103 == var78_96) {
                                var80_111 *= 0.5;
                            }
                            var75_73 += var1_1.L.a(var77_87) * var80_111;
                            ++var77_87;
                        }
                    }
                    for (var78_96 = 0; var78_96 < var5_4; ++var78_96) {
                        var79_104 = var9_25.a(var78_96);
                        var81_113 = var79_104 * var79_104;
                        var75_73 += 0.5 * var1_1.G.a(var78_96) * var81_113;
                    }
                    var78_97 = var54_38 - var73_56 - var75_73;
                    var52_37 = var50_36;
                    var50_36 = var48_35;
                    var48_35 = BY.w(var78_97);
                    if (var64_43 > var44_33) {
                        var14_23 = var1_1.b();
                    }
                    if (var11_15 > 0) {
                        if (var75_73 >= 0.0) {
                            throw new oX(px_0.TRUST_REGION_STEP_FAILED, new Object[]{var75_73});
                        }
                        var62_42 = (var54_38 - var73_56) / var75_73;
                        var80_111 = var46_34 * 0.5;
                        var46_34 = var62_42 <= 0.1 ? BY.d(var80_111, var64_43) : (var62_42 <= 0.7 ? BY.e(var80_111, var64_43) : BY.e(var80_111, var64_43 * 2.0));
                        if (var46_34 <= var44_33 * 1.5) {
                            var46_34 = var44_33;
                        }
                        if (var54_38 < var73_56) {
                            var82_118 = var13_17;
                            var83_122 = var60_41;
                            v27 = var46_34;
                            var85_131 = v27 * v27;
                            var66_47 = 0.0;
                            var68_48 = 0.0;
                            var13_17 = 0;
                            for (var87_146 = 0; var87_146 < var5_4; ++var87_146) {
                                var88_151 = 0.0;
                                for (var90_156 = 0; var90_156 < var7_11; ++var90_156) {
                                    v28 = var91_157 = var1_1.y.b(var87_146, var90_156);
                                    var88_151 += v28 * v28;
                                }
                                v29 = var90_155 = var1_1.K.a(var87_146);
                                var92_158 = var56_39 * var88_151 + v29 * v29;
                                var70_44 = 0.0;
                                for (var94_160 = 0; var94_160 < var4_6; ++var94_160) {
                                    v30 = var95_162 = var1_1.z.b(var87_146, var94_160) - var1_1.H.a(var94_160);
                                    var70_44 += v30 * v30;
                                }
                                v31 = var94_161 = var70_44 / var85_131;
                                var96_163 = BY.e(1.0, v31 * v31);
                                if (v32 * var92_158 > var66_47) {
                                    var66_47 = var96_163 * var92_158;
                                    var13_17 = var87_146;
                                    var60_41 = var92_158;
                                }
                                v33 = var98_164 = var1_1.K.a(var87_146);
                                var100_165 = var96_163 * (v33 * v33);
                                var68_48 = BY.e(var68_48, var100_165);
                            }
                            if (var66_47 <= var68_48 * 0.5) {
                                var13_17 = var82_118;
                                var60_41 = var83_122;
                            }
                        }
                    }
                    super.a(var56_39, var60_41, var13_17);
                    var77_87 = 0;
                    var80_111 = var1_1.G.a(var13_17);
                    var1_1.G.a(var13_17, 0.0);
                    for (var82_119 = 0; var82_119 < var4_6; ++var82_119) {
                        var83_122 = var80_111 * var1_1.z.b(var13_17, var82_119);
                        for (var85_133 = 0; var85_133 <= var82_119; ++var85_133) {
                            v34 = var1_1.L;
                            v34.a(var77_87, v34.a(var77_87) + var83_122 * var1_1.z.b(var13_17, var85_133));
                            ++var77_87;
                        }
                    }
                    for (var82_119 = 0; var82_119 < var7_11; ++var82_119) {
                        var83_122 = var78_97 * var1_1.y.b(var13_17, var82_119);
                        for (var85_134 = 0; var85_134 < var5_4; ++var85_134) {
                            v35 = var1_1.G;
                            v35.a(var85_134, v35.a(var85_134) + var83_122 * var1_1.y.b(var85_134, var82_119));
                        }
                    }
                    var1_1.B.a(var13_17, var54_38);
                    for (var82_119 = 0; var82_119 < var4_6; ++var82_119) {
                        var1_1.z.c(var13_17, var82_119, var1_1.H.a(var82_119));
                        var8_24.a(var82_119, var1_1.x.b(var13_17, var82_119));
                    }
                    for (var82_119 = 0; var82_119 < var5_4; ++var82_119) {
                        var83_122 = 0.0;
                        for (var85_135 = 0; var85_135 < var7_11; ++var85_135) {
                            var83_122 += var1_1.y.b(var13_17, var85_135) * var1_1.y.b(var82_119, var85_135);
                        }
                        var85_136 = 0.0;
                        for (var87_147 = 0; var87_147 < var4_6; ++var87_147) {
                            var85_136 += var1_1.z.b(var82_119, var87_147) * var1_1.C.a(var87_147);
                        }
                        var87_148 = var83_122 * var85_136;
                        for (var89_152 = 0; var89_152 < var4_6; ++var89_152) {
                            var8_24.a(var89_152, var8_24.a(var89_152) + var87_148 * var1_1.z.b(var82_119, var89_152));
                        }
                    }
                    for (var82_119 = 0; var82_119 < var4_6; ++var82_119) {
                        v36 = var1_1.D;
                        v36.a(var82_119, v36.a(var82_119) + var78_97 * var8_24.a(var82_119));
                    }
                    if (var54_38 < var73_56) {
                        var1_1.w = var13_17;
                        var35_29 = 0.0;
                        var77_87 = 0;
                        for (var82_119 = 0; var82_119 < var4_6; ++var82_119) {
                            var1_1.C.a(var82_119, var1_1.H.a(var82_119));
                            v37 = var83_122 = var1_1.C.a(var82_119);
                            var35_29 += v37 * v37;
                            for (var85_137 = 0; var85_137 <= var82_119; ++var85_137) {
                                if (var85_137 < var82_119) {
                                    v38 = var1_1.D;
                                    v38.a(var82_119, v38.a(var82_119) + var1_1.L.a(var77_87) * var1_1.J.a(var85_137));
                                }
                                v39 = var1_1.D;
                                v39.a(var85_137, v39.a(var85_137) + var1_1.L.a(var77_87) * var1_1.J.a(var82_119));
                                ++var77_87;
                            }
                        }
                        for (var82_119 = 0; var82_119 < var5_4; ++var82_119) {
                            var83_122 = 0.0;
                            for (var85_138 = 0; var85_138 < var4_6; ++var85_138) {
                                var83_122 += var1_1.z.b(var82_119, var85_138) * var1_1.J.a(var85_138);
                            }
                            var83_122 *= var1_1.G.a(var82_119);
                            for (var85_138 = 0; var85_138 < var4_6; ++var85_138) {
                                v40 = var1_1.D;
                                v40.a(var85_138, v40.a(var85_138) + var83_122 * var1_1.z.b(var82_119, var85_138));
                            }
                        }
                    }
                    if (var11_15 > 0) {
                        for (var82_119 = 0; var82_119 < var5_4; ++var82_119) {
                            var1_1.K.a(var82_119, var1_1.B.a(var82_119) - var1_1.B.a(var1_1.w));
                            var10_12 /* !! */ .a(var82_119, 0.0);
                        }
                        for (var82_119 = 0; var82_119 < var7_11; ++var82_119) {
                            var83_122 = 0.0;
                            for (var85_139 = 0; var85_139 < var5_4; ++var85_139) {
                                var83_122 += var1_1.y.b(var85_139, var82_119) * var1_1.K.a(var85_139);
                            }
                            for (var85_139 = 0; var85_139 < var5_4; ++var85_139) {
                                var10_12 /* !! */ .a(var85_139, var10_12 /* !! */ .a(var85_139) + var83_122 * var1_1.y.b(var85_139, var82_119));
                            }
                        }
                        for (var82_119 = 0; var82_119 < var5_4; ++var82_119) {
                            var83_122 = 0.0;
                            for (var85_140 = 0; var85_140 < var4_6; ++var85_140) {
                                var83_122 += var1_1.z.b(var82_119, var85_140) * var1_1.C.a(var85_140);
                            }
                            var9_25.a(var82_119, var10_12 /* !! */ .a(var82_119));
                            var10_12 /* !! */ .a(var82_119, var83_122 * var10_12 /* !! */ .a(var82_119));
                        }
                        var82_120 = 0.0;
                        var84_130 = 0.0;
                        for (var86_144 = 0; var86_144 < var4_6; ++var86_144) {
                            var87_149 = 0.0;
                            for (var89_153 = 0; var89_153 < var5_4; ++var89_153) {
                                var87_149 += var1_1.x.b(var89_153, var86_144) * var1_1.K.a(var89_153) + var1_1.z.b(var89_153, var86_144) * var10_12 /* !! */ .a(var89_153);
                            }
                            if (var1_1.C.a(var86_144) == var1_1.E.a(var86_144)) {
                                v41 = var89_154 = BY.d(0.0, var1_1.D.a(var86_144));
                                var82_120 += v41 * v41;
                                v42 = var91_157 = BY.d(0.0, var87_149);
                                var84_130 += v42 * v42;
                            } else if (var1_1.C.a(var86_144) == var1_1.F.a(var86_144)) {
                                v43 = var89_154 = BY.e(0.0, var1_1.D.a(var86_144));
                                var82_120 += v43 * v43;
                                v44 = var91_157 = BY.e(0.0, var87_149);
                                var84_130 += v44 * v44;
                            } else {
                                v45 = var89_154 = var1_1.D.a(var86_144);
                                var82_120 += v45 * v45;
                                v46 = var87_149;
                                var84_130 += v46 * v46;
                            }
                            var1_1.K.a(var5_4 + var86_144, var87_149);
                        }
                        ++var12_21;
                        if (var82_120 < var84_130 * 10.0) {
                            var12_21 = 0;
                        }
                        if (var12_21 >= 3) {
                            var87_150 = BY.b(var5_4, var6_10);
                            for (var86_144 = 0; var86_144 < var87_150; ++var86_144) {
                                if (var86_144 < var4_6) {
                                    var1_1.D.a(var86_144, var1_1.K.a(var5_4 + var86_144));
                                }
                                if (var86_144 < var5_4) {
                                    var1_1.G.a(var86_144, var9_25.a(var86_144));
                                }
                                if (var86_144 < var6_10) {
                                    var1_1.L.a(var86_144, 0.0);
                                }
                                var12_21 = 0;
                            }
                        }
                    }
                    if (var11_15 == 0) {
                        var72_45 = 60;
                        continue block14;
                    }
                    if (var54_38 <= var73_56 + var75_73 * 0.1) {
                        var72_45 = 60;
                        continue block14;
                    }
                    var82_121 = var46_34 * 2.0;
                    var84_130 = var44_33 * 10.0;
                    v47 = var82_121;
                    v48 = var84_130;
                    var70_44 = BY.e(v47 * v47, v48 * v48);
                }
                case 650: {
                    var13_17 = -1;
                    for (var73_57 = 0; var73_57 < var5_4; ++var73_57) {
                        var74_66 = 0.0;
                        for (var76_79 = 0; var76_79 < var4_6; ++var76_79) {
                            v49 = var77_88 = var1_1.z.b(var73_57, var76_79) - var1_1.C.a(var76_79);
                            var74_66 += v49 * v49;
                        }
                        if (!(var74_66 > var70_44)) continue;
                        var13_17 = var73_57;
                        var70_44 = var74_66;
                    }
                    if (var13_17 >= 0) {
                        var73_58 = BY.a(var70_44);
                        if (var11_15 == -1) {
                            var46_34 = BY.d(var46_34 * 0.1, var73_58 * 0.5);
                            if (v50 <= var44_33 * 1.5) {
                                var46_34 = var44_33;
                            }
                        }
                        var11_15 = 0;
                        var75_74 = BY.d(var73_58 * 0.1, var46_34);
                        var58_40 = BY.e(var75_74, var44_33);
                        var31_28 = var58_40 * var58_40;
                        var72_45 = 90;
                        continue block14;
                    }
                    if (var11_15 == -1) {
                        var72_45 = 680;
                        continue block14;
                    }
                    if (var62_42 > 0.0) {
                        var72_45 = 60;
                        continue block14;
                    }
                    if (BY.e(var46_34, var64_43) > var44_33) {
                        var72_45 = 60;
                        continue block14;
                    }
                }
                case 680: {
                    if (var44_33 > var1_1.s) {
                        var46_34 = var44_33 * 0.5;
                        var62_42 = var44_33 / var1_1.s;
                        var44_33 = v51 <= 16.0 ? var1_1.s : (var62_42 <= 250.0 ? BY.a(var62_42) * var1_1.s : (var44_33 *= 0.1));
                        var46_34 = BY.e(var46_34, var44_33);
                        var11_15 = 0;
                        var14_23 = var1_1.b();
                        var72_45 = 60;
                        continue block14;
                    }
                    if (var11_15 == -1) {
                        var72_45 = 360;
                        continue block14;
                    }
                }
                case 720: {
                    if (!(var1_1.B.a(var1_1.w) <= var37_31)) break block14;
                    for (var73_59 = 0; var73_59 < var4_6; ++var73_59) {
                        var74_67 = var2_2[var73_59];
                        var76_80 = var1_1.A.a(var73_59) + var1_1.C.a(var73_59);
                        var78_98 = BY.e(var74_67, var76_80);
                        var80_112 = var3_7[var73_59];
                        var1_1.u.a(var73_59, BY.d(var78_98, (double)var80_112));
                        if (var1_1.C.a(var73_59) == var1_1.E.a(var73_59)) {
                            var1_1.u.a(var73_59, var2_2[var73_59]);
                        }
                        if (var1_1.C.a(var73_59) != var1_1.F.a(var73_59)) continue;
                        var1_1.u.a(var73_59, (double)var3_7[var73_59]);
                    }
                    var54_38 = var1_1.B.a(var1_1.w);
                    break block14;
                }
                default: {
                    throw new oX(px_0.SIMPLE_MESSAGE, new Object[]{"bobyqb"});
                }
            }
            break;
        }
        var3_8 = var54_38;
        var102_19 = this.u;
        return new yp_0(var102_19.a, this.t != false ? var3_8 : -var3_8);
    }

    private double a(double[] dArray, double[] dArray2) {
        sA sA2 = this.u;
        int n2 = sA2.a.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            double d2;
            double d3 = this.v[i2];
            ((tu_0)((Object)this.E)).a(i2, dArray[i2] - ((tu_0)((Object)this.u)).a(i2));
            ((tu_0)((Object)this.F)).a(i2, dArray2[i2] - ((tu_0)((Object)this.u)).a(i2));
            if (((tu_0)((Object)this.E)).a(i2) >= -this.r) {
                if (((tu_0)((Object)this.E)).a(i2) >= 0.0) {
                    ((tu_0)((Object)this.u)).a(i2, dArray[i2]);
                    ((tu_0)((Object)this.E)).a(i2, 0.0);
                    ((tu_0)((Object)this.F)).a(i2, d3);
                    continue;
                }
                ((tu_0)((Object)this.u)).a(i2, dArray[i2] + this.r);
                ((tu_0)((Object)this.E)).a(i2, -this.r);
                d2 = dArray2[i2] - ((tu_0)((Object)this.u)).a(i2);
                ((tu_0)((Object)this.F)).a(i2, BY.e(d2, this.r));
                continue;
            }
            if (!(((tu_0)((Object)this.F)).a(i2) <= this.r)) continue;
            if (((tu_0)((Object)this.F)).a(i2) <= 0.0) {
                ((tu_0)((Object)this.u)).a(i2, dArray2[i2]);
                ((tu_0)((Object)this.E)).a(i2, -d3);
                ((tu_0)((Object)this.F)).a(i2, 0.0);
                continue;
            }
            ((tu_0)((Object)this.u)).a(i2, dArray2[i2] - this.r);
            d2 = dArray[i2] - ((tu_0)((Object)this.u)).a(i2);
            double d4 = -this.r;
            ((tu_0)((Object)this.E)).a(i2, BY.d(d2, d4));
            ((tu_0)((Object)this.F)).a(i2, this.r);
        }
        return this.b(dArray, dArray2);
    }

    /*
     * Unable to fully structure code
     */
    private double b(double[] var1_1, double[] var2_2) {
        var86_3 = this.u;
        var3_4 = var86_3.a.length;
        var4_5 = this.q;
        var5_6 = var3_4 + 1;
        var6_7 = var4_5 - var5_6;
        var5_6 = var3_4 * var5_6 / 2;
        var7_8 = new sA(var3_4);
        var8_9 = new sA(var4_5);
        var9_10 = new sA(var4_5);
        var11_11 = NaN;
        var13_12 = NaN;
        var15_13 = NaN;
        this.w = 0;
        this.c(var1_1, var2_2);
        var19_14 = 0.0;
        for (var21_15 = 0; var21_15 < var3_4; ++var21_15) {
            this.C.a(var21_15, this.z.b(this.w, var21_15));
            v0 = var22_17 = this.C.a(var21_15);
            var19_14 += v0 * v0;
        }
        var21_16 = this.B.a(0);
        var10_18 = 0;
        var23_19 = 0;
        var24_20 = 0;
        var25_21 = this.b();
        var30_23 = var28_22 = this.r;
        var32_24 = 0.0;
        var34_25 = 0.0;
        var36_26 = 0.0;
        var38_27 = 0.0;
        var40_28 = 0.0;
        var42_29 = 0.0;
        var44_30 = 0.0;
        var46_31 = 0.0;
        var48_32 = 0.0;
        var54_33 = 0.0;
        var17_34 = 20;
        block12: while (true) {
            switch (var17_34) {
                case 20: {
                    if (this.w != 0) {
                        var57_38 = 0;
                        for (var58_49 = 0; var58_49 < var3_4; ++var58_49) {
                            for (var59_57 = 0; var59_57 <= var58_49; ++var59_57) {
                                if (var59_57 < var58_49) {
                                    v1 = this.D;
                                    v1.a(var58_49, v1.a(var58_49) + this.L.a(var57_38) * this.C.a(var59_57));
                                }
                                v2 = this.D;
                                v2.a(var59_57, v2.a(var59_57) + this.L.a(var57_38) * this.C.a(var58_49));
                                ++var57_38;
                            }
                        }
                        if (this.b() > var4_5) {
                            for (var58_49 = 0; var58_49 < var4_5; ++var58_49) {
                                var59_58 = 0.0;
                                for (var61_70 = 0; var61_70 < var3_4; ++var61_70) {
                                    var59_58 += this.z.b(var58_49, var61_70) * this.C.a(var61_70);
                                }
                                var59_58 *= this.G.a(var58_49);
                                for (var61_70 = 0; var61_70 < var3_4; ++var61_70) {
                                    v3 = this.D;
                                    v3.a(var61_70, v3.a(var61_70) + var59_58 * this.z.b(var58_49, var61_70));
                                }
                            }
                        }
                    }
                }
                case 60: {
                    var57_39 = new sA(var3_4);
                    var58_50 = new sA(var3_4);
                    var59_59 = new sA(var3_4);
                    var60_64 = new sA(var3_4);
                    var61_71 = new sA(var3_4);
                    var62_78 = this.a(var30_23, var57_39, var58_50, var59_59, var60_64, var61_71);
                    var15_13 = var62_78[0];
                    var17_35 = var62_78[1];
                    var63_88 = var30_23;
                    var65_102 = BY.a(var15_13);
                    var48_32 = BY.d(var63_88, var65_102);
                    if (v4 < var28_22 * 0.5) {
                        var10_18 = -1;
                        var63_88 = var28_22 * 10.0;
                        var54_33 = var63_88 * var63_88;
                        if (this.b() <= var25_21 + 2) {
                            var17_34 = 650;
                            continue block12;
                        }
                        var63_88 = BY.e(var32_24, var34_25);
                        var67_111 = BY.e(var63_88, var36_26);
                        var69_120 = var28_22 * 0.125 * var28_22;
                        if (var17_35 > 0.0 && var67_111 > var69_120 * var17_35) {
                            var17_34 = 650;
                            continue block12;
                        }
                        var71_134 = var67_111 / var28_22;
                        for (var73_141 = 0; var73_141 < var3_4; ++var73_141) {
                            var74_144 = var71_134;
                            if (this.H.a(var73_141) == this.E.a(var73_141)) {
                                var74_144 = var7_8.a(var73_141);
                            }
                            if (this.H.a(var73_141) == this.F.a(var73_141)) {
                                var74_144 = -var7_8.a(var73_141);
                            }
                            if (!(var74_144 < var71_134)) continue;
                            v5 = var73_141;
                            var76_147 = this.L.a((v5 + v5 * var73_141) / 2);
                            for (var78_148 = 0; var78_148 < var4_5; ++var78_148) {
                                v6 = var79_151 = this.z.b(var78_148, var73_141);
                                var76_147 += this.G.a(var78_148) * (v6 * v6);
                            }
                            if ((var74_144 += var76_147 * 0.5 * var28_22) < var71_134) break;
                        }
                        var17_34 = 680;
                        continue block12;
                    }
                    ++var10_18;
                }
                case 90: {
                    if (var15_13 <= var19_14 * 0.001) {
                        var57_40 = var19_14 * 0.25;
                        var59_60 = 0.0;
                        for (var61_72 = 0; var61_72 < var4_5; ++var61_72) {
                            var59_60 += this.G.a(var61_72);
                            var62_79 = var19_14 * -0.5;
                            for (var64_94 = 0; var64_94 < var3_4; ++var64_94) {
                                var62_79 += this.z.b(var61_72, var64_94) * this.C.a(var64_94);
                            }
                            var8_9.a(var61_72, var62_79);
                            var64_95 = var57_40 - var62_79 * 0.5;
                            for (var66_103 = 0; var66_103 < var3_4; ++var66_103) {
                                var7_8.a(var66_103, this.x.b(var61_72, var66_103));
                                this.K.a(var66_103, var62_79 * this.z.b(var61_72, var66_103) + var64_95 * this.C.a(var66_103));
                                var67_112 = var4_5 + var66_103;
                                for (var68_117 = 0; var68_117 <= var66_103; ++var68_117) {
                                    this.x.c(var67_112, var68_117, this.x.b(var67_112, var68_117) + var7_8.a(var66_103) * this.K.a(var68_117) + this.K.a(var66_103) * var7_8.a(var68_117));
                                }
                            }
                        }
                        for (var61_72 = 0; var61_72 < var6_7; ++var61_72) {
                            var62_80 = 0.0;
                            var64_96 = 0.0;
                            for (var66_103 = 0; var66_103 < var4_5; ++var66_103) {
                                var62_80 += this.y.b(var66_103, var61_72);
                                this.K.a(var66_103, var8_9.a(var66_103) * this.y.b(var66_103, var61_72));
                                var64_96 += this.K.a(var66_103);
                            }
                            for (var66_103 = 0; var66_103 < var3_4; ++var66_103) {
                                var67_113 = (var57_40 * var62_80 - var64_96 * 0.5) * this.C.a(var66_103);
                                for (var69_121 = 0; var69_121 < var4_5; ++var69_121) {
                                    var67_113 += this.K.a(var69_121) * this.z.b(var69_121, var66_103);
                                }
                                var7_8.a(var66_103, var67_113);
                                for (var69_121 = 0; var69_121 < var4_5; ++var69_121) {
                                    this.x.c(var69_121, var66_103, this.x.b(var69_121, var66_103) + var67_113 * this.y.b(var69_121, var61_72));
                                }
                            }
                            for (var66_103 = 0; var66_103 < var3_4; ++var66_103) {
                                var67_114 = var66_103 + var4_5;
                                var68_118 = var7_8.a(var66_103);
                                for (var70_130 = 0; var70_130 <= var66_103; ++var70_130) {
                                    this.x.c(var67_114, var70_130, this.x.b(var67_114, var70_130) + var68_118 * var7_8.a(var70_130));
                                }
                            }
                        }
                        var61_72 = 0;
                        for (var62_81 = 0; var62_81 < var3_4; ++var62_81) {
                            var7_8.a(var62_81, var59_60 * -0.5 * this.C.a(var62_81));
                            for (var63_89 = 0; var63_89 < var4_5; ++var63_89) {
                                var7_8.a(var62_81, var7_8.a(var62_81) + this.G.a(var63_89) * this.z.b(var63_89, var62_81));
                                this.z.c(var63_89, var62_81, this.z.b(var63_89, var62_81) - this.C.a(var62_81));
                            }
                            for (var63_89 = 0; var63_89 <= var62_81; ++var63_89) {
                                v7 = this.L;
                                v7.a(var61_72, v7.a(var61_72) + var7_8.a(var63_89) * this.C.a(var62_81) + this.C.a(var63_89) * var7_8.a(var62_81));
                                this.x.c(var4_5 + var63_89, var62_81, this.x.b(var4_5 + var62_81, var63_89));
                                ++var61_72;
                            }
                        }
                        for (var62_81 = 0; var62_81 < var3_4; ++var62_81) {
                            v8 = this.A;
                            v8.a(var62_81, v8.a(var62_81) + this.C.a(var62_81));
                            v9 = this.H;
                            v9.a(var62_81, v9.a(var62_81) - this.C.a(var62_81));
                            v10 = this.E;
                            v10.a(var62_81, v10.a(var62_81) - this.C.a(var62_81));
                            v11 = this.F;
                            v11.a(var62_81, v11.a(var62_81) - this.C.a(var62_81));
                            this.C.a(var62_81, 0.0);
                        }
                        var19_14 = 0.0;
                    }
                    if (var10_18 == 0) {
                        var17_34 = 210;
                        continue block12;
                    }
                    var17_34 = 230;
                    continue block12;
                }
                case 210: {
                    var57_41 = this.a(var24_20, var42_29);
                    var13_12 = var57_41[0];
                    var11_11 = var57_41[1];
                    for (var58_51 = 0; var58_51 < var3_4; ++var58_51) {
                        this.J.a(var58_51, this.H.a(var58_51) - this.C.a(var58_51));
                    }
                }
                case 230: {
                    for (var57_42 = 0; var57_42 < var4_5; ++var57_42) {
                        var58_52 = 0.0;
                        var60_65 = 0.0;
                        var62_82 = 0.0;
                        for (var64_97 = 0; var64_97 < var3_4; ++var64_97) {
                            var58_52 += this.z.b(var57_42, var64_97) * this.J.a(var64_97);
                            var60_65 += this.z.b(var57_42, var64_97) * this.C.a(var64_97);
                            var62_82 += this.x.b(var57_42, var64_97) * this.J.a(var64_97);
                        }
                        var9_10.a(var57_42, var58_52 * (var58_52 * 0.5 + var60_65));
                        this.K.a(var57_42, var62_82);
                        var8_9.a(var57_42, var58_52);
                    }
                    var40_28 = 0.0;
                    for (var57_42 = 0; var57_42 < var6_7; ++var57_42) {
                        var58_53 = 0.0;
                        for (var60_66 = 0; var60_66 < var4_5; ++var60_66) {
                            var58_53 += this.y.b(var60_66, var57_42) * var9_10.a(var60_66);
                        }
                        v12 = var58_53;
                        var40_28 -= v12 * v12;
                        for (var60_66 = 0; var60_66 < var4_5; ++var60_66) {
                            v13 = this.K;
                            v13.a(var60_66, v13.a(var60_66) + var58_53 * this.y.b(var60_66, var57_42));
                        }
                    }
                    var15_13 = 0.0;
                    var57_43 = 0.0;
                    var59_61 = 0.0;
                    for (var61_73 = 0; var61_73 < var3_4; ++var61_73) {
                        v14 = var62_83 = this.J.a(var61_73);
                        var15_13 += v14 * v14;
                        var64_98 = 0.0;
                        for (var66_104 = 0; var66_104 < var4_5; ++var66_104) {
                            var64_98 += var9_10.a(var66_104) * this.x.b(var66_104, var61_73);
                        }
                        var57_43 += var64_98 * this.J.a(var61_73);
                        var66_104 = var4_5 + var61_73;
                        for (var67_115 = 0; var67_115 < var3_4; ++var67_115) {
                            var64_98 += this.x.b(var66_104, var67_115) * this.J.a(var67_115);
                        }
                        this.K.a(var66_104, var64_98);
                        var57_43 += var64_98 * this.J.a(var61_73);
                        var59_61 += this.J.a(var61_73) * this.C.a(var61_73);
                    }
                    v15 = var59_61;
                    var40_28 = v15 * v15 + var15_13 * (var19_14 + var59_61 + var59_61 + var15_13 * 0.5) + var40_28 - var57_43;
                    this.K.a(this.w, this.K.a(this.w) + 1.0);
                    if (var10_18 != 0) ** GOTO lbl255
                    var61_74 = this.K.a(var24_20);
                    var44_30 = var61_74 * var61_74 + var13_12 * var40_28;
                    if (v16 < var11_11 && var11_11 > 0.0) {
                        for (var63_90 = 0; var63_90 < var3_4; ++var63_90) {
                            this.H.a(var63_90, this.I.a(var63_90));
                            this.J.a(var63_90, this.H.a(var63_90) - this.C.a(var63_90));
                        }
                        var11_11 = 0.0;
                        var17_34 = 230;
                        continue block12;
                    }
                    ** GOTO lbl283
lbl255:
                    // 1 sources

                    v17 = var30_23;
                    var61_75 = v17 * v17;
                    var50_36 = 0.0;
                    var52_37 = 0.0;
                    var24_20 = 0;
                    for (var63_91 = 0; var63_91 < var4_5; ++var63_91) {
                        if (var63_91 == this.w) continue;
                        var64_99 = 0.0;
                        for (var66_105 = 0; var66_105 < var6_7; ++var66_105) {
                            v18 = var67_116 = this.y.b(var63_91, var66_105);
                            var64_99 += v18 * v18;
                        }
                        v19 = var66_106 = this.K.a(var63_91);
                        var68_119 = var40_28 * var64_99 + v19 * v19;
                        var54_33 = 0.0;
                        for (var70_131 = 0; var70_131 < var3_4; ++var70_131) {
                            v20 = var71_134 = this.z.b(var63_91, var70_131) - this.C.a(var70_131);
                            var54_33 += v20 * v20;
                        }
                        v21 = var70_132 = var54_33 / var61_75;
                        var72_140 = BY.e(1.0, v21 * v21);
                        if (v22 * var68_119 > var50_36) {
                            var50_36 = var72_140 * var68_119;
                            var24_20 = var63_91;
                            var44_30 = var68_119;
                        }
                        v23 = var74_144 = this.K.a(var63_91);
                        var52_37 = BY.e(var52_37, var72_140 * (v23 * v23));
                    }
                }
lbl283:
                // 3 sources

                case 360: {
                    for (var57_44 = 0; var57_44 < var3_4; ++var57_44) {
                        var58_54 = var1_1[var57_44];
                        var60_67 = this.A.a(var57_44) + this.H.a(var57_44);
                        var62_84 = BY.e(var58_54, var60_67);
                        var64_96 = var2_2[var57_44];
                        this.u.a(var57_44, BY.d(var62_84, var64_96));
                        if (this.H.a(var57_44) == this.E.a(var57_44)) {
                            this.u.a(var57_44, var1_1[var57_44]);
                        }
                        if (this.H.a(var57_44) != this.F.a(var57_44)) continue;
                        this.u.a(var57_44, var2_2[var57_44]);
                    }
                    v24 = this;
                    var38_27 = v24.a(v24.u.g());
                    if (!this.t) {
                        var38_27 = -var38_27;
                    }
                    if (var10_18 == -1) {
                        var21_16 = var38_27;
                        var17_34 = 720;
                        continue block12;
                    }
                    var57_45 = this.B.a(this.w);
                    var59_62 = 0.0;
                    var61_76 = 0;
                    for (var62_85 = 0; var62_85 < var3_4; ++var62_85) {
                        var59_62 += this.J.a(var62_85) * this.D.a(var62_85);
                        for (var63_92 = 0; var63_92 <= var62_85; ++var63_92) {
                            var64_100 = this.J.a(var63_92) * this.J.a(var62_85);
                            if (var63_92 == var62_85) {
                                var64_100 *= 0.5;
                            }
                            var59_62 += this.L.a(var61_76) * var64_100;
                            ++var61_76;
                        }
                    }
                    for (var62_85 = 0; var62_85 < var4_5; ++var62_85) {
                        var63_93 = var8_9.a(var62_85);
                        var65_102 = var63_93 * var63_93;
                        var59_62 += 0.5 * this.G.a(var62_85) * var65_102;
                    }
                    var62_86 = var38_27 - var57_45 - var59_62;
                    var36_26 = var34_25;
                    var34_25 = var32_24;
                    var32_24 = BY.w(var62_86);
                    if (var48_32 > var28_22) {
                        var25_21 = this.b();
                    }
                    if (var10_18 > 0) {
                        if (var59_62 >= 0.0) {
                            throw new oX(px_0.TRUST_REGION_STEP_FAILED, new Object[]{var59_62});
                        }
                        var46_31 = (var38_27 - var57_45) / var59_62;
                        var64_100 = var30_23 * 0.5;
                        var30_23 = var46_31 <= 0.1 ? BY.d(var64_100, var48_32) : (var46_31 <= 0.7 ? BY.e(var64_100, var48_32) : BY.e(var64_100, var48_32 * 2.0));
                        if (var30_23 <= var28_22 * 1.5) {
                            var30_23 = var28_22;
                        }
                        if (var38_27 < var57_45) {
                            var66_107 = var24_20;
                            var67_111 = var44_30;
                            v25 = var30_23;
                            var69_120 = v25 * v25;
                            var50_36 = 0.0;
                            var52_37 = 0.0;
                            var24_20 = 0;
                            for (var71_135 = 0; var71_135 < var4_5; ++var71_135) {
                                var72_140 = 0.0;
                                for (var74_145 = 0; var74_145 < var6_7; ++var74_145) {
                                    v26 = var75_146 = this.y.b(var71_135, var74_145);
                                    var72_140 += v26 * v26;
                                }
                                v27 = var74_144 = this.K.a(var71_135);
                                var76_147 = var40_28 * var72_140 + v27 * v27;
                                var54_33 = 0.0;
                                for (var78_149 = 0; var78_149 < var3_4; ++var78_149) {
                                    v28 = var79_151 = this.z.b(var71_135, var78_149) - this.H.a(var78_149);
                                    var54_33 += v28 * v28;
                                }
                                v29 = var78_150 = var54_33 / var69_120;
                                var80_152 = BY.e(1.0, v29 * v29);
                                if (v30 * var76_147 > var50_36) {
                                    var50_36 = var80_152 * var76_147;
                                    var24_20 = var71_135;
                                    var44_30 = var76_147;
                                }
                                v31 = var82_153 = this.K.a(var71_135);
                                var84_154 = var80_152 * (v31 * v31);
                                var52_37 = BY.e(var52_37, var84_154);
                            }
                            if (var50_36 <= var52_37 * 0.5) {
                                var24_20 = var66_107;
                                var44_30 = var67_111;
                            }
                        }
                    }
                    this.a(var40_28, var44_30, var24_20);
                    var61_76 = 0;
                    var64_100 = this.G.a(var24_20);
                    this.G.a(var24_20, 0.0);
                    for (var66_108 = 0; var66_108 < var3_4; ++var66_108) {
                        var67_111 = var64_100 * this.z.b(var24_20, var66_108);
                        for (var69_122 = 0; var69_122 <= var66_108; ++var69_122) {
                            v32 = this.L;
                            v32.a(var61_76, v32.a(var61_76) + var67_111 * this.z.b(var24_20, var69_122));
                            ++var61_76;
                        }
                    }
                    for (var66_108 = 0; var66_108 < var6_7; ++var66_108) {
                        var67_111 = var62_86 * this.y.b(var24_20, var66_108);
                        for (var69_123 = 0; var69_123 < var4_5; ++var69_123) {
                            v33 = this.G;
                            v33.a(var69_123, v33.a(var69_123) + var67_111 * this.y.b(var69_123, var66_108));
                        }
                    }
                    this.B.a(var24_20, var38_27);
                    for (var66_108 = 0; var66_108 < var3_4; ++var66_108) {
                        this.z.c(var24_20, var66_108, this.H.a(var66_108));
                        var7_8.a(var66_108, this.x.b(var24_20, var66_108));
                    }
                    for (var66_108 = 0; var66_108 < var4_5; ++var66_108) {
                        var67_111 = 0.0;
                        for (var69_124 = 0; var69_124 < var6_7; ++var69_124) {
                            var67_111 += this.y.b(var24_20, var69_124) * this.y.b(var66_108, var69_124);
                        }
                        var69_125 = 0.0;
                        for (var71_136 = 0; var71_136 < var3_4; ++var71_136) {
                            var69_125 += this.z.b(var66_108, var71_136) * this.C.a(var71_136);
                        }
                        var71_137 = var67_111 * var69_125;
                        for (var73_141 = 0; var73_141 < var3_4; ++var73_141) {
                            var7_8.a(var73_141, var7_8.a(var73_141) + var71_137 * this.z.b(var66_108, var73_141));
                        }
                    }
                    for (var66_108 = 0; var66_108 < var3_4; ++var66_108) {
                        v34 = this.D;
                        v34.a(var66_108, v34.a(var66_108) + var62_86 * var7_8.a(var66_108));
                    }
                    if (var38_27 < var57_45) {
                        this.w = var24_20;
                        var19_14 = 0.0;
                        var61_76 = 0;
                        for (var66_108 = 0; var66_108 < var3_4; ++var66_108) {
                            this.C.a(var66_108, this.H.a(var66_108));
                            v35 = var67_111 = this.C.a(var66_108);
                            var19_14 += v35 * v35;
                            for (var69_126 = 0; var69_126 <= var66_108; ++var69_126) {
                                if (var69_126 < var66_108) {
                                    v36 = this.D;
                                    v36.a(var66_108, v36.a(var66_108) + this.L.a(var61_76) * this.J.a(var69_126));
                                }
                                v37 = this.D;
                                v37.a(var69_126, v37.a(var69_126) + this.L.a(var61_76) * this.J.a(var66_108));
                                ++var61_76;
                            }
                        }
                        for (var66_108 = 0; var66_108 < var4_5; ++var66_108) {
                            var67_111 = 0.0;
                            for (var69_127 = 0; var69_127 < var3_4; ++var69_127) {
                                var67_111 += this.z.b(var66_108, var69_127) * this.J.a(var69_127);
                            }
                            var67_111 *= this.G.a(var66_108);
                            for (var69_127 = 0; var69_127 < var3_4; ++var69_127) {
                                v38 = this.D;
                                v38.a(var69_127, v38.a(var69_127) + var67_111 * this.z.b(var66_108, var69_127));
                            }
                        }
                    }
                    if (var10_18 > 0) {
                        for (var66_108 = 0; var66_108 < var4_5; ++var66_108) {
                            this.K.a(var66_108, this.B.a(var66_108) - this.B.a(this.w));
                            var9_10.a(var66_108, 0.0);
                        }
                        for (var66_108 = 0; var66_108 < var6_7; ++var66_108) {
                            var67_111 = 0.0;
                            for (var69_128 = 0; var69_128 < var4_5; ++var69_128) {
                                var67_111 += this.y.b(var69_128, var66_108) * this.K.a(var69_128);
                            }
                            for (var69_128 = 0; var69_128 < var4_5; ++var69_128) {
                                var9_10.a(var69_128, var9_10.a(var69_128) + var67_111 * this.y.b(var69_128, var66_108));
                            }
                        }
                        for (var66_108 = 0; var66_108 < var4_5; ++var66_108) {
                            var67_111 = 0.0;
                            for (var69_129 = 0; var69_129 < var3_4; ++var69_129) {
                                var67_111 += this.z.b(var66_108, var69_129) * this.C.a(var69_129);
                            }
                            var8_9.a(var66_108, var9_10.a(var66_108));
                            var9_10.a(var66_108, var67_111 * var9_10.a(var66_108));
                        }
                        var66_109 = 0.0;
                        var68_119 = 0.0;
                        for (var70_133 = 0; var70_133 < var3_4; ++var70_133) {
                            var71_138 = 0.0;
                            for (var73_142 = 0; var73_142 < var4_5; ++var73_142) {
                                var71_138 += this.x.b(var73_142, var70_133) * this.K.a(var73_142) + this.z.b(var73_142, var70_133) * var9_10.a(var73_142);
                            }
                            if (this.C.a(var70_133) == this.E.a(var70_133)) {
                                v39 = var73_143 = BY.d(0.0, this.D.a(var70_133));
                                var66_109 += v39 * v39;
                                v40 = var75_146 = BY.d(0.0, var71_138);
                                var68_119 += v40 * v40;
                            } else if (this.C.a(var70_133) == this.F.a(var70_133)) {
                                v41 = var73_143 = BY.e(0.0, this.D.a(var70_133));
                                var66_109 += v41 * v41;
                                v42 = var75_146 = BY.e(0.0, var71_138);
                                var68_119 += v42 * v42;
                            } else {
                                v43 = var73_143 = this.D.a(var70_133);
                                var66_109 += v43 * v43;
                                v44 = var71_138;
                                var68_119 += v44 * v44;
                            }
                            this.K.a(var4_5 + var70_133, var71_138);
                        }
                        ++var23_19;
                        if (var66_109 < var68_119 * 10.0) {
                            var23_19 = 0;
                        }
                        if (var23_19 >= 3) {
                            var71_139 = BY.b(var4_5, var5_6);
                            for (var70_133 = 0; var70_133 < var71_139; ++var70_133) {
                                if (var70_133 < var3_4) {
                                    this.D.a(var70_133, this.K.a(var4_5 + var70_133));
                                }
                                if (var70_133 < var4_5) {
                                    this.G.a(var70_133, var8_9.a(var70_133));
                                }
                                if (var70_133 < var5_6) {
                                    this.L.a(var70_133, 0.0);
                                }
                                var23_19 = 0;
                            }
                        }
                    }
                    if (var10_18 == 0) {
                        var17_34 = 60;
                        continue block12;
                    }
                    if (var38_27 <= var57_45 + var59_62 * 0.1) {
                        var17_34 = 60;
                        continue block12;
                    }
                    var66_110 = var30_23 * 2.0;
                    var68_119 = var28_22 * 10.0;
                    v45 = var66_110;
                    v46 = var68_119;
                    var54_33 = BY.e(v45 * v45, v46 * v46);
                }
                case 650: {
                    var24_20 = -1;
                    for (var57_46 = 0; var57_46 < var4_5; ++var57_46) {
                        var58_55 = 0.0;
                        for (var60_68 = 0; var60_68 < var3_4; ++var60_68) {
                            v47 = var61_77 = this.z.b(var57_46, var60_68) - this.C.a(var60_68);
                            var58_55 += v47 * v47;
                        }
                        if (!(var58_55 > var54_33)) continue;
                        var24_20 = var57_46;
                        var54_33 = var58_55;
                    }
                    if (var24_20 >= 0) {
                        var57_47 = BY.a(var54_33);
                        if (var10_18 == -1) {
                            var30_23 = BY.d(var30_23 * 0.1, var57_47 * 0.5);
                            if (v48 <= var28_22 * 1.5) {
                                var30_23 = var28_22;
                            }
                        }
                        var10_18 = 0;
                        var59_63 = BY.d(var57_47 * 0.1, var30_23);
                        var42_29 = BY.e(var59_63, var28_22);
                        var15_13 = var42_29 * var42_29;
                        var17_34 = 90;
                        continue block12;
                    }
                    if (var10_18 == -1) {
                        var17_34 = 680;
                        continue block12;
                    }
                    if (var46_31 > 0.0) {
                        var17_34 = 60;
                        continue block12;
                    }
                    if (BY.e(var30_23, var48_32) > var28_22) {
                        var17_34 = 60;
                        continue block12;
                    }
                }
                case 680: {
                    if (var28_22 > this.s) {
                        var30_23 = var28_22 * 0.5;
                        var46_31 = var28_22 / this.s;
                        var28_22 = v49 <= 16.0 ? this.s : (var46_31 <= 250.0 ? BY.a(var46_31) * this.s : (var28_22 *= 0.1));
                        var30_23 = BY.e(var30_23, var28_22);
                        var10_18 = 0;
                        var25_21 = this.b();
                        var17_34 = 60;
                        continue block12;
                    }
                    if (var10_18 == -1) {
                        var17_34 = 360;
                        continue block12;
                    }
                }
                case 720: {
                    if (this.B.a(this.w) <= var21_16) {
                        for (var57_48 = 0; var57_48 < var3_4; ++var57_48) {
                            var58_56 = var1_1[var57_48];
                            var60_69 = this.A.a(var57_48) + this.C.a(var57_48);
                            var62_87 = BY.e(var58_56, var60_69);
                            var64_101 = var2_2[var57_48];
                            this.u.a(var57_48, BY.d(var62_87, var64_101));
                            if (this.C.a(var57_48) == this.E.a(var57_48)) {
                                this.u.a(var57_48, var1_1[var57_48]);
                            }
                            if (this.C.a(var57_48) != this.F.a(var57_48)) continue;
                            this.u.a(var57_48, var2_2[var57_48]);
                        }
                        var38_27 = this.B.a(this.w);
                    }
                    return var38_27;
                }
            }
            break;
        }
        throw new oX(px_0.SIMPLE_MESSAGE, new Object[]{"bobyqb"});
    }

    private double[] a(int n2, double d2) {
        double d3;
        double d4;
        double d5;
        double d6;
        double d7;
        double d8;
        double d9;
        int n3;
        int n4;
        double d10;
        int n5;
        sA sA2 = this.u;
        int n6 = sA2.a.length;
        int n7 = this.q;
        sA sA3 = new sA(n6);
        sA sA4 = new sA(n7);
        sA sA5 = new sA(n6);
        sA sA6 = new sA(n6);
        for (n5 = 0; n5 < n7; ++n5) {
            ((tu_0)((Object)sA4)).a(n5, 0.0);
        }
        int n8 = n7 - n6 - 1;
        for (n5 = 0; n5 < n8; ++n5) {
            d10 = ((sv_0)this.y).b(n2, n5);
            for (n4 = 0; n4 < n7; ++n4) {
                ((tu_0)((Object)sA4)).a(n4, ((tu_0)((Object)sA4)).a(n4) + d10 * ((sv_0)this.y).b(n4, n5));
            }
        }
        double d11 = ((tu_0)((Object)sA4)).a(n2);
        d10 = d11 * 0.5;
        for (n4 = 0; n4 < n6; ++n4) {
            ((tu_0)((Object)sA3)).a(n4, ((sv_0)this.x).b(n2, n4));
        }
        for (n4 = 0; n4 < n7; ++n4) {
            int n9;
            double d12 = 0.0;
            for (n9 = 0; n9 < n6; ++n9) {
                d12 += ((sv_0)this.z).b(n4, n9) * ((tu_0)((Object)this.C)).a(n9);
            }
            d12 *= ((tu_0)((Object)sA4)).a(n4);
            for (n9 = 0; n9 < n6; ++n9) {
                ((tu_0)((Object)sA3)).a(n9, ((tu_0)((Object)sA3)).a(n9) + d12 * ((sv_0)this.z).b(n4, n9));
            }
        }
        double d13 = 0.0;
        double d14 = Double.NaN;
        int n10 = 0;
        int n11 = 0;
        double d15 = 0.0;
        for (n3 = 0; n3 < n7; ++n3) {
            double d16;
            int n12;
            if (n3 == this.w) continue;
            d9 = 0.0;
            d8 = 0.0;
            for (int i2 = 0; i2 < n6; ++i2) {
                double d17 = ((sv_0)this.z).b(n3, i2) - ((tu_0)((Object)this.C)).a(i2);
                d9 += ((tu_0)((Object)sA3)).a(i2) * d17;
                double d18 = d17;
                d8 += d18 * d18;
            }
            d7 = d2 / BY.a(d8);
            double d19 = -d7;
            int n13 = 0;
            int n14 = 0;
            d6 = BY.d(1.0, d7);
            for (n12 = 0; n12 < n6; ++n12) {
                double d20;
                d5 = ((sv_0)this.z).b(n3, n12) - ((tu_0)((Object)this.C)).a(n12);
                if (d20 > 0.0) {
                    if (d19 * d5 < ((tu_0)((Object)this.E)).a(n12) - ((tu_0)((Object)this.C)).a(n12)) {
                        d19 = (((tu_0)((Object)this.E)).a(n12) - ((tu_0)((Object)this.C)).a(n12)) / d5;
                        n13 = -n12 - 1;
                    }
                    if (!(d7 * d5 > ((tu_0)((Object)this.F)).a(n12) - ((tu_0)((Object)this.C)).a(n12))) continue;
                    d7 = BY.e(d6, (((tu_0)((Object)this.F)).a(n12) - ((tu_0)((Object)this.C)).a(n12)) / d5);
                    n14 = n12 + 1;
                    continue;
                }
                if (!(d5 < 0.0)) continue;
                if (d19 * d5 > ((tu_0)((Object)this.F)).a(n12) - ((tu_0)((Object)this.C)).a(n12)) {
                    d19 = (((tu_0)((Object)this.F)).a(n12) - ((tu_0)((Object)this.C)).a(n12)) / d5;
                    n13 = n12 + 1;
                }
                if (!(d7 * d5 < ((tu_0)((Object)this.E)).a(n12) - ((tu_0)((Object)this.C)).a(n12))) continue;
                d7 = BY.e(d6, (((tu_0)((Object)this.E)).a(n12) - ((tu_0)((Object)this.C)).a(n12)) / d5);
                n14 = -n12 - 1;
            }
            d14 = d19;
            n12 = n13;
            if (n3 == n2) {
                double d21;
                double d22;
                double d23;
                double d24;
                d4 = d9 - 1.0;
                d5 = d19 * (d9 - d19 * d4);
                d3 = d7 * (d9 - d7 * d4);
                if (BY.w(d24) > BY.w(d5)) {
                    d14 = d7;
                    d5 = d3;
                    n12 = n14;
                }
                if ((d23 = (d22 = d9 * 0.5) - d4 * d19) * (d21 = d22 - d4 * d7) < 0.0) {
                    double d25;
                    double d26 = d22;
                    double d27 = d26 * d26 / d4;
                    if (BY.w(d25) > BY.w(d5)) {
                        d14 = d22 / d4;
                        d5 = d27;
                        n12 = 0;
                    }
                }
            } else {
                double d28;
                d5 = d19 * (1.0 - d19);
                d4 = d7 * (1.0 - d7);
                if (BY.w(d28) > BY.w(d5)) {
                    d14 = d7;
                    d5 = d4;
                    n12 = n14;
                }
                if (d7 > 0.5 && BY.w(d5) < 0.25) {
                    d14 = 0.5;
                    d5 = 0.25;
                    n12 = 0;
                }
                d5 *= d9;
            }
            d4 = d14 * (1.0 - d14) * d8;
            double d29 = d5;
            double d30 = d5;
            d3 = d29 * d29 * (d30 * d30 + d10 * d4 * d4);
            if (!(d16 > d13)) continue;
            d13 = d3;
            n10 = n3;
            d15 = d14;
            n11 = n12;
        }
        for (n3 = 0; n3 < n6; ++n3) {
            d9 = ((tu_0)((Object)this.C)).a(n3) + d15 * (((sv_0)this.z).b(n10, n3) - ((tu_0)((Object)this.C)).a(n3));
            ((tu_0)((Object)this.H)).a(n3, BY.e(((tu_0)((Object)this.E)).a(n3), BY.d(((tu_0)((Object)this.F)).a(n3), d9)));
        }
        if (n11 < 0) {
            ((tu_0)((Object)this.H)).a(-n11 - 1, ((tu_0)((Object)this.E)).a(-n11 - 1));
        }
        if (n11 > 0) {
            ((tu_0)((Object)this.H)).a(n11 - 1, ((tu_0)((Object)this.F)).a(n11 - 1));
        }
        double d31 = d2;
        double d32 = d31 + d31;
        boolean bl = false;
        d7 = 0.0;
        while (true) {
            double d33;
            int n15;
            double d34;
            double d35 = 0.0;
            for (int i3 = 0; i3 < n6; ++i3) {
                double d36 = ((tu_0)((Object)sA3)).a(i3);
                ((tu_0)((Object)sA5)).a(i3, 0.0);
                if (!(BY.d(((tu_0)((Object)this.C)).a(i3) - ((tu_0)((Object)this.E)).a(i3), d36) > 0.0) && !(BY.e(((tu_0)((Object)this.C)).a(i3) - ((tu_0)((Object)this.F)).a(i3), d36) < 0.0)) continue;
                ((tu_0)((Object)sA5)).a(i3, d32);
                double d37 = d36;
                d35 += d37 * d37;
            }
            if (d35 == 0.0) {
                return new double[]{d11, 0.0};
            }
            double d38 = d2;
            d6 = d38 * d38;
            if (d34 > 0.0) {
                d14 = BY.a(d6 / d35);
                for (int i4 = 0; i4 < n6; ++i4) {
                    double d39;
                    if (((tu_0)((Object)sA5)).a(i4) != d32) continue;
                    d5 = ((tu_0)((Object)this.C)).a(i4) - d14 * ((tu_0)((Object)sA3)).a(i4);
                    if (d39 <= ((tu_0)((Object)this.E)).a(i4)) {
                        ((tu_0)((Object)sA5)).a(i4, ((tu_0)((Object)this.E)).a(i4) - ((tu_0)((Object)this.C)).a(i4));
                        ((tu_0)((Object)sA5)).a(i4);
                        continue;
                    }
                    if (d5 >= ((tu_0)((Object)this.F)).a(i4)) {
                        ((tu_0)((Object)sA5)).a(i4, ((tu_0)((Object)this.F)).a(i4) - ((tu_0)((Object)this.C)).a(i4));
                        ((tu_0)((Object)sA5)).a(i4);
                        continue;
                    }
                    ((tu_0)((Object)sA3)).a(i4);
                }
            }
            double d40 = 0.0;
            for (int i5 = 0; i5 < n6; ++i5) {
                d4 = ((tu_0)((Object)sA3)).a(i5);
                if (((tu_0)((Object)sA5)).a(i5) == d32) {
                    ((tu_0)((Object)sA5)).a(i5, -d14 * d4);
                    d3 = BY.d(((tu_0)((Object)this.F)).a(i5), ((tu_0)((Object)this.C)).a(i5) + ((tu_0)((Object)sA5)).a(i5));
                    ((tu_0)((Object)this.I)).a(i5, BY.e(((tu_0)((Object)this.E)).a(i5), d3));
                } else if (((tu_0)((Object)sA5)).a(i5) == 0.0) {
                    ((tu_0)((Object)this.I)).a(i5, ((tu_0)((Object)this.C)).a(i5));
                } else if (d4 > 0.0) {
                    ((tu_0)((Object)this.I)).a(i5, ((tu_0)((Object)this.E)).a(i5));
                } else {
                    ((tu_0)((Object)this.I)).a(i5, ((tu_0)((Object)this.F)).a(i5));
                }
                d40 += d4 * ((tu_0)((Object)sA5)).a(i5);
            }
            double d41 = 0.0;
            for (n15 = 0; n15 < n7; ++n15) {
                d3 = 0.0;
                for (int i6 = 0; i6 < n6; ++i6) {
                    d3 += ((sv_0)this.z).b(n15, i6) * ((tu_0)((Object)sA5)).a(i6);
                }
                d41 += ((tu_0)((Object)sA4)).a(n15) * d3 * d3;
            }
            if (bl) {
                d41 = -d41;
            }
            if (d41 > -d40 && d41 < -d40 * (1.0 + BY.a(2.0))) {
                d33 = -d40 / d41;
                for (int i7 = 0; i7 < n6; ++i7) {
                    double d42 = ((tu_0)((Object)this.C)).a(i7) + d33 * ((tu_0)((Object)sA5)).a(i7);
                    ((tu_0)((Object)this.I)).a(i7, BY.e(((tu_0)((Object)this.E)).a(i7), BY.d(((tu_0)((Object)this.F)).a(i7), d42)));
                }
                double d43 = d40 * 0.5 * d33;
                d8 = d43 * d43;
            } else {
                d33 = d40 + d41 * 0.5;
                d8 = d33 * d33;
            }
            if (bl) break;
            for (n15 = 0; n15 < n6; ++n15) {
                ((tu_0)((Object)sA3)).a(n15, -((tu_0)((Object)sA3)).a(n15));
                ((tu_0)((Object)sA6)).a(n15, ((tu_0)((Object)this.I)).a(n15));
            }
            d7 = d8;
            bl = true;
        }
        if (d7 > d8) {
            for (int i8 = 0; i8 < n6; ++i8) {
                ((tu_0)((Object)this.I)).a(i8, ((tu_0)((Object)sA6)).a(i8));
            }
            d8 = d7;
        }
        return new double[]{d11, d8};
    }

    private void c(double[] dArray, double[] dArray2) {
        int n2;
        int n3;
        sA sA2 = this.u;
        int n4 = sA2.a.length;
        int n5 = this.q;
        int n6 = ((tp_0)this.x).f();
        double d2 = this.r * this.r;
        double d3 = 1.0 / d2;
        int n7 = n4 + 1;
        for (n3 = 0; n3 < n4; ++n3) {
            ((tu_0)((Object)this.A)).a(n3, ((tu_0)((Object)this.u)).a(n3));
            for (n2 = 0; n2 < n5; ++n2) {
                ((sv_0)this.z).c(n2, n3, 0.0);
            }
            for (n2 = 0; n2 < n6; ++n2) {
                ((sv_0)this.x).c(n2, n3, 0.0);
            }
        }
        n2 = n4 * n7 / 2;
        for (n3 = 0; n3 < n2; ++n3) {
            ((tu_0)((Object)this.L)).a(n3, 0.0);
        }
        for (n3 = 0; n3 < n5; ++n3) {
            ((tu_0)((Object)this.G)).a(n3, 0.0);
            int n8 = n5 - n7;
            for (n2 = 0; n2 < n8; ++n2) {
                ((sv_0)this.y).c(n3, n2, 0.0);
            }
        }
        n3 = 0;
        n2 = 0;
        double d4 = Double.NaN;
        do {
            double d5;
            int n9;
            n6 = this.b();
            int n10 = n6 - n4;
            int n11 = n6 - 1;
            int n12 = n10 - 1;
            double d6 = 0.0;
            double d7 = 0.0;
            if (n6 <= 2 * n4) {
                if (n6 > 0 && n6 <= n4) {
                    d6 = this.r;
                    if (((tu_0)((Object)this.F)).a(n11) == 0.0) {
                        d6 = -d6;
                    }
                    ((sv_0)this.z).c(n6, n11, d6);
                } else if (n6 > n4) {
                    d6 = ((sv_0)this.z).b(n10, n12);
                    d7 = -this.r;
                    if (((tu_0)((Object)this.E)).a(n12) == 0.0) {
                        d7 = BY.d(2.0 * this.r, ((tu_0)((Object)this.F)).a(n12));
                    }
                    if (((tu_0)((Object)this.F)).a(n12) == 0.0) {
                        d7 = BY.e(-2.0 * this.r, ((tu_0)((Object)this.E)).a(n12));
                    }
                    ((sv_0)this.z).c(n6, n12, d7);
                }
            } else {
                int n13;
                n9 = (n6 - n7) / n4;
                n2 = n6 - n9 * n4 - n4;
                n3 = n2 + n9;
                if (n3 > n4) {
                    n13 = n2;
                    n2 = n3 - n4;
                    n3 = n13;
                }
                n13 = n3 - 1;
                int n14 = n2 - 1;
                ((sv_0)this.z).c(n6, n13, ((sv_0)this.z).b(n3, n13));
                ((sv_0)this.z).c(n6, n14, ((sv_0)this.z).b(n2, n14));
            }
            for (n9 = 0; n9 < n4; ++n9) {
                ((tu_0)((Object)this.u)).a(n9, BY.d(BY.e(dArray[n9], ((tu_0)((Object)this.A)).a(n9) + ((sv_0)this.z).b(n6, n9)), dArray2[n9]));
                if (((sv_0)this.z).b(n6, n9) == ((tu_0)((Object)this.E)).a(n9)) {
                    ((tu_0)((Object)this.u)).a(n9, dArray[n9]);
                }
                if (((sv_0)this.z).b(n6, n9) != ((tu_0)((Object)this.F)).a(n9)) continue;
                ((tu_0)((Object)this.u)).a(n9, dArray2[n9]);
            }
            yy_0 yy_02 = this;
            double d8 = yy_02.a(((tu_0)((Object)yy_02.u)).g());
            double d9 = this.t ? d8 : -d8;
            int n15 = this.b();
            ((tu_0)((Object)this.B)).a(n6, d9);
            if (n15 == 1) {
                d4 = d9;
                this.w = 0;
            } else if (d9 < ((tu_0)((Object)this.B)).a(this.w)) {
                this.w = n6;
            }
            if (n15 <= 2 * n4 + 1) {
                if (n15 >= 2 && n15 <= n4 + 1) {
                    ((tu_0)((Object)this.D)).a(n11, (d9 - d4) / d6);
                    if (n5 >= n15 + n4) continue;
                    double d10 = 1.0 / d6;
                    ((sv_0)this.x).c(0, n11, -d10);
                    ((sv_0)this.x).c(n6, n11, d10);
                    ((sv_0)this.x).c(n5 + n11, n11, d2 * -0.5);
                    continue;
                }
                if (n15 < n4 + 2) continue;
                int n16 = n10;
                int n17 = n16 * (n16 + 1) / 2 - 1;
                d5 = (d9 - d4) / d7;
                double d11 = d7 - d6;
                ((tu_0)((Object)this.L)).a(n17, 2.0 * (d5 - ((tu_0)((Object)this.D)).a(n12)) / d11);
                sA sA3 = this.D;
                ((tu_0)((Object)sA3)).a(n12, (((tu_0)((Object)sA3)).a(n12) * d7 - d5 * d6) / d11);
                if (d6 * d7 < 0.0 && d9 < ((tu_0)((Object)this.B)).a(n6 - n4)) {
                    sA sA4 = this.B;
                    ((tu_0)((Object)sA4)).a(n6, ((tu_0)((Object)sA4)).a(n6 - n4));
                    ((tu_0)((Object)this.B)).a(n6 - n4, d9);
                    if (this.w == n6) {
                        this.w = n6 - n4;
                    }
                    ((sv_0)this.z).c(n6 - n4, n12, d7);
                    ((sv_0)this.z).c(n6, n12, d6);
                }
                ((sv_0)this.x).c(0, n12, -(d6 + d7) / (d6 * d7));
                ((sv_0)this.x).c(n6, n12, -0.5 / ((sv_0)this.z).b(n6 - n4, n12));
                ((sv_0)this.x).c(n6 - n4, n12, -((sv_0)this.x).b(0, n12) - ((sv_0)this.x).b(n6, n12));
                ((sv_0)this.y).c(0, n12, BY.a(2.0) / (d6 * d7));
                ((sv_0)this.y).c(n6, n12, BY.a(0.5) / d2);
                ((sv_0)this.y).c(n6 - n4, n12, -((sv_0)this.y).b(0, n12) - ((sv_0)this.y).b(n6, n12));
                continue;
            }
            ((sv_0)this.y).c(0, n12, d3);
            ((sv_0)this.y).c(n6, n12, d3);
            ((sv_0)this.y).c(n3, n12, -d3);
            ((sv_0)this.y).c(n2, n12, -d3);
            int n18 = n3;
            int n19 = n18 * (n18 - 1) / 2 + n2 - 1;
            d5 = ((sv_0)this.z).b(n6, n3 - 1) * ((sv_0)this.z).b(n6, n2 - 1);
            ((tu_0)((Object)this.L)).a(n19, (d4 - ((tu_0)((Object)this.B)).a(n3) - ((tu_0)((Object)this.B)).a(n2) + d9) / d5);
        } while (this.b() < n5);
    }

    private double[] a(double d2, sA sA2, sA sA3, sA sA4, sA sA5, sA sA6) {
        int n2;
        sA sA7 = this.u;
        int n3 = sA7.a.length;
        int n4 = this.q;
        double d3 = 0.0;
        int n5 = -1;
        double d4 = 0.0;
        double d5 = 0.0;
        double d6 = 0.0;
        double d7 = 0.0;
        double d8 = 0.0;
        double d9 = 0.0;
        double d10 = 0.0;
        double d11 = 0.0;
        int n6 = 0;
        double d12 = 0.0;
        double d13 = 0.0;
        double d14 = 0.0;
        int n7 = 0;
        int n8 = 0;
        int n9 = 0;
        for (n2 = 0; n2 < n3; ++n2) {
            ((tu_0)((Object)sA3)).a(n2, 0.0);
            if (((tu_0)((Object)this.C)).a(n2) <= ((tu_0)((Object)this.E)).a(n2)) {
                if (((tu_0)((Object)this.D)).a(n2) >= 0.0) {
                    ((tu_0)((Object)sA3)).a(n2, -1.0);
                }
            } else if (((tu_0)((Object)this.C)).a(n2) >= ((tu_0)((Object)this.F)).a(n2) && ((tu_0)((Object)this.D)).a(n2) <= 0.0) {
                ((tu_0)((Object)sA3)).a(n2, 1.0);
            }
            if (((tu_0)((Object)sA3)).a(n2) != 0.0) {
                ++n9;
            }
            ((tu_0)((Object)this.J)).a(n2, 0.0);
            ((tu_0)((Object)sA2)).a(n2, ((tu_0)((Object)this.D)).a(n2));
        }
        double d15 = d2;
        double d16 = d15 * d15;
        double d17 = 0.0;
        double d18 = -1.0;
        n2 = 20;
        block12: while (true) {
            switch (n2) {
                case 20: {
                    d3 = 0.0;
                }
                case 30: {
                    d14 = 0.0;
                    for (int i2 = 0; i2 < n3; ++i2) {
                        double d19;
                        if (((tu_0)((Object)sA3)).a(i2) != 0.0) {
                            ((tu_0)((Object)sA4)).a(i2, 0.0);
                        } else if (d3 == 0.0) {
                            ((tu_0)((Object)sA4)).a(i2, -((tu_0)((Object)sA2)).a(i2));
                        } else {
                            ((tu_0)((Object)sA4)).a(i2, d3 * ((tu_0)((Object)sA4)).a(i2) - ((tu_0)((Object)sA2)).a(i2));
                        }
                        double d20 = d19 = ((tu_0)((Object)sA4)).a(i2);
                        d14 += d20 * d20;
                    }
                    if (d14 == 0.0) {
                        n2 = 190;
                        continue block12;
                    }
                    if (d3 == 0.0) {
                        d11 = d14;
                        n7 = n8 + n3 - n9;
                    }
                    if (d11 * d16 <= d17 * 1.0E-4 * d17) {
                        n2 = 190;
                        continue block12;
                    }
                    n2 = 210;
                    continue block12;
                }
                case 50: {
                    int n10;
                    double d21 = d16;
                    double d22 = 0.0;
                    double d23 = 0.0;
                    for (n10 = 0; n10 < n3; ++n10) {
                        double d24;
                        if (((tu_0)((Object)sA3)).a(n10) != 0.0) continue;
                        double d25 = d24 = ((tu_0)((Object)this.J)).a(n10);
                        d21 -= d25 * d25;
                        d22 += ((tu_0)((Object)sA4)).a(n10) * ((tu_0)((Object)this.J)).a(n10);
                        d23 += ((tu_0)((Object)sA4)).a(n10) * ((tu_0)((Object)sA5)).a(n10);
                    }
                    if (d21 <= 0.0) {
                        n2 = 90;
                        continue block12;
                    }
                    double d26 = d22;
                    double d27 = BY.a(d14 * d21 + d26 * d26);
                    double d28 = d22 < 0.0 ? (d27 - d22) / d14 : d21 / (d27 + d22);
                    double d29 = d28;
                    if (d23 > 0.0) {
                        d29 = BY.d(d28, d11 / d23);
                    }
                    n5 = -1;
                    for (n10 = 0; n10 < n3; ++n10) {
                        if (((tu_0)((Object)sA4)).a(n10) == 0.0) continue;
                        double d30 = ((tu_0)((Object)this.C)).a(n10) + ((tu_0)((Object)this.J)).a(n10);
                        d27 = ((tu_0)((Object)sA4)).a(n10) > 0.0 ? (((tu_0)((Object)this.F)).a(n10) - d30) / ((tu_0)((Object)sA4)).a(n10) : (((tu_0)((Object)this.E)).a(n10) - d30) / ((tu_0)((Object)sA4)).a(n10);
                        if (!(d27 < d29)) continue;
                        d29 = d27;
                        n5 = n10;
                    }
                    double d31 = 0.0;
                    if (d29 > 0.0) {
                        ++n8;
                        d27 = d23 / d14;
                        if (n5 == -1 && d27 > 0.0 && (d18 = BY.d(d18, d27)) == -1.0) {
                            d18 = d27;
                        }
                        d9 = d11;
                        d11 = 0.0;
                        for (n10 = 0; n10 < n3; ++n10) {
                            ((tu_0)((Object)sA2)).a(n10, ((tu_0)((Object)sA2)).a(n10) + d29 * ((tu_0)((Object)sA5)).a(n10));
                            if (((tu_0)((Object)sA3)).a(n10) == 0.0) {
                                double d32;
                                double d33 = d32 = ((tu_0)((Object)sA2)).a(n10);
                                d11 += d33 * d33;
                            }
                            sA sA8 = this.J;
                            ((tu_0)((Object)sA8)).a(n10, ((tu_0)((Object)sA8)).a(n10) + d29 * ((tu_0)((Object)sA4)).a(n10));
                        }
                        double d34 = d29 * (d9 - d29 * 0.5 * d23);
                        d31 = BY.e(d34, 0.0);
                        d17 += d31;
                    }
                    if (n5 >= 0) {
                        double d35;
                        double d36;
                        ++n9;
                        ((tu_0)((Object)sA3)).a(n5, 1.0);
                        if (((tu_0)((Object)sA4)).a(n5) < 0.0) {
                            ((tu_0)((Object)sA3)).a(n5, -1.0);
                        }
                        double d37 = d36 = ((tu_0)((Object)this.J)).a(n5);
                        d16 -= d37 * d37;
                        if (d35 <= 0.0) {
                            n2 = 190;
                            continue block12;
                        }
                        n2 = 20;
                        continue block12;
                    }
                    if (d29 < d28) {
                        if (n8 == n7) {
                            n2 = 190;
                            continue block12;
                        }
                        if (d31 <= d17 * 0.01) {
                            n2 = 190;
                            continue block12;
                        }
                        d3 = d11 / d9;
                        n2 = 30;
                        continue block12;
                    }
                }
                case 90: {
                    d18 = 0.0;
                }
                case 100: {
                    if (n9 >= n3 - 1) {
                        n2 = 190;
                        continue block12;
                    }
                    d10 = 0.0;
                    d7 = 0.0;
                    d11 = 0.0;
                    for (int i3 = 0; i3 < n3; ++i3) {
                        if (((tu_0)((Object)sA3)).a(i3) == 0.0) {
                            double d38;
                            double d39 = d38 = ((tu_0)((Object)this.J)).a(i3);
                            d10 += d39 * d39;
                            d7 += ((tu_0)((Object)this.J)).a(i3) * ((tu_0)((Object)sA2)).a(i3);
                            double d40 = d38 = ((tu_0)((Object)sA2)).a(i3);
                            d11 += d40 * d40;
                            ((tu_0)((Object)sA4)).a(i3, ((tu_0)((Object)this.J)).a(i3));
                            continue;
                        }
                        ((tu_0)((Object)sA4)).a(i3, 0.0);
                    }
                    n6 = n8;
                    n2 = 210;
                    continue block12;
                }
                case 120: {
                    double d41;
                    int n11;
                    double d42;
                    ++n8;
                    double d43 = d7;
                    double d27 = d11 * d10 - d43 * d43;
                    if (d42 <= d17 * 1.0E-4 * d17) {
                        n2 = 190;
                        continue block12;
                    }
                    d27 = BY.a(d27);
                    for (n11 = 0; n11 < n3; ++n11) {
                        if (((tu_0)((Object)sA3)).a(n11) == 0.0) {
                            ((tu_0)((Object)sA4)).a(n11, (d7 * ((tu_0)((Object)this.J)).a(n11) - d10 * ((tu_0)((Object)sA2)).a(n11)) / d27);
                            continue;
                        }
                        ((tu_0)((Object)sA4)).a(n11, 0.0);
                    }
                    d8 = -d27;
                    d6 = 1.0;
                    n5 = -1;
                    for (n11 = 0; n11 < n3; ++n11) {
                        double d44;
                        double d45;
                        if (((tu_0)((Object)sA3)).a(n11) != 0.0) continue;
                        double d46 = ((tu_0)((Object)this.C)).a(n11) + ((tu_0)((Object)this.J)).a(n11) - ((tu_0)((Object)this.E)).a(n11);
                        double d47 = ((tu_0)((Object)this.F)).a(n11) - ((tu_0)((Object)this.C)).a(n11) - ((tu_0)((Object)this.J)).a(n11);
                        if (d46 <= 0.0) {
                            ++n9;
                            ((tu_0)((Object)sA3)).a(n11, -1.0);
                            break;
                        }
                        if (d47 <= 0.0) {
                            ++n9;
                            ((tu_0)((Object)sA3)).a(n11, 1.0);
                            break;
                        }
                        double d48 = ((tu_0)((Object)this.J)).a(n11);
                        d41 = ((tu_0)((Object)sA4)).a(n11);
                        double d49 = d48;
                        double d50 = d41;
                        double d51 = d49 * d49 + d50 * d50;
                        double d52 = d48 = ((tu_0)((Object)this.C)).a(n11) - ((tu_0)((Object)this.E)).a(n11);
                        d27 = d51 - d52 * d52;
                        if (d45 > 0.0 && d6 * (d27 = BY.a(d27) - ((tu_0)((Object)sA4)).a(n11)) > d46) {
                            d6 = d46 / d27;
                            n5 = n11;
                            d5 = -1.0;
                        }
                        double d53 = d48 = ((tu_0)((Object)this.F)).a(n11) - ((tu_0)((Object)this.C)).a(n11);
                        d27 = d51 - d53 * d53;
                        if (!(d44 > 0.0) || !(d6 * (d27 = BY.a(d27) + ((tu_0)((Object)sA4)).a(n11)) > d47)) continue;
                        d6 = d47 / d27;
                        n5 = n11;
                        d5 = 1.0;
                    }
                    n2 = 210;
                    continue block12;
                }
                case 150: {
                    double d54;
                    double d55;
                    int n12;
                    double d27;
                    double d23 = 0.0;
                    double d56 = 0.0;
                    double d57 = 0.0;
                    for (n12 = 0; n12 < n3; ++n12) {
                        if (((tu_0)((Object)sA3)).a(n12) != 0.0) continue;
                        d23 += ((tu_0)((Object)sA4)).a(n12) * ((tu_0)((Object)sA5)).a(n12);
                        d56 += ((tu_0)((Object)this.J)).a(n12) * ((tu_0)((Object)sA5)).a(n12);
                        d57 += ((tu_0)((Object)this.J)).a(n12) * ((tu_0)((Object)sA6)).a(n12);
                    }
                    double d58 = 0.0;
                    int n13 = -1;
                    double d59 = 0.0;
                    int n14 = (int)(d6 * 17.0 + 3.1);
                    for (n12 = 0; n12 < n14; ++n12) {
                        double d60;
                        double d61 = d4 = d6 * (double)n12 / (double)n14;
                        d55 = (d4 + d4) / (1.0 + d61 * d61);
                        double d62 = d4;
                        d27 = d23 + d62 * (d62 * d57 - d56 - d56);
                        double d63 = d55 * (d4 * d7 - d8 - d55 * 0.5 * d27);
                        if (d60 > d58) {
                            d58 = d63;
                            n13 = n12;
                            d12 = d59;
                        } else if (n12 == n13 + 1) {
                            d13 = d63;
                        }
                        d59 = d63;
                    }
                    if (n13 < 0) {
                        n2 = 190;
                        continue block12;
                    }
                    if (n13 < n14) {
                        double d64 = d58;
                        d27 = (d13 - d12) / (d64 + d64 - d12 - d13);
                        d4 = d6 * ((double)n13 + d27 * 0.5) / (double)n14;
                    }
                    double d65 = d4;
                    double d66 = d4;
                    double d67 = (1.0 - d65 * d65) / (1.0 + d66 * d66);
                    double d68 = d4;
                    double d69 = d4;
                    d55 = (d68 + d68) / (1.0 + d69 * d69);
                    double d70 = d4;
                    d27 = d23 + d70 * (d70 * d57 - d56 - d56);
                    double d31 = d55 * (d4 * d7 - d8 - d55 * 0.5 * d27);
                    if (d54 <= 0.0) {
                        n2 = 190;
                        continue block12;
                    }
                    d7 = 0.0;
                    d11 = 0.0;
                    for (n12 = 0; n12 < n3; ++n12) {
                        ((tu_0)((Object)sA2)).a(n12, ((tu_0)((Object)sA2)).a(n12) + (d67 - 1.0) * ((tu_0)((Object)sA6)).a(n12) + d55 * ((tu_0)((Object)sA5)).a(n12));
                        if (((tu_0)((Object)sA3)).a(n12) == 0.0) {
                            double d71;
                            ((tu_0)((Object)this.J)).a(n12, d67 * ((tu_0)((Object)this.J)).a(n12) + d55 * ((tu_0)((Object)sA4)).a(n12));
                            d7 += ((tu_0)((Object)this.J)).a(n12) * ((tu_0)((Object)sA2)).a(n12);
                            double d72 = d71 = ((tu_0)((Object)sA2)).a(n12);
                            d11 += d72 * d72;
                        }
                        ((tu_0)((Object)sA6)).a(n12, d67 * ((tu_0)((Object)sA6)).a(n12) + d55 * ((tu_0)((Object)sA5)).a(n12));
                    }
                    d17 += d31;
                    if (n5 >= 0 && n13 == n14) {
                        ++n9;
                        ((tu_0)((Object)sA3)).a(n5, d5);
                        n2 = 100;
                        continue block12;
                    }
                    if (d31 > d17 * 0.01) {
                        n2 = 120;
                        continue block12;
                    }
                }
                case 190: {
                    double d41;
                    double d73 = 0.0;
                    for (int i4 = 0; i4 < n3; ++i4) {
                        double d74 = BY.d(((tu_0)((Object)this.C)).a(i4) + ((tu_0)((Object)this.J)).a(i4), ((tu_0)((Object)this.F)).a(i4));
                        ((tu_0)((Object)this.H)).a(i4, BY.e(d74, ((tu_0)((Object)this.E)).a(i4)));
                        if (((tu_0)((Object)sA3)).a(i4) == -1.0) {
                            ((tu_0)((Object)this.H)).a(i4, ((tu_0)((Object)this.E)).a(i4));
                        }
                        if (((tu_0)((Object)sA3)).a(i4) == 1.0) {
                            ((tu_0)((Object)this.H)).a(i4, ((tu_0)((Object)this.F)).a(i4));
                        }
                        ((tu_0)((Object)this.J)).a(i4, ((tu_0)((Object)this.H)).a(i4) - ((tu_0)((Object)this.C)).a(i4));
                        double d75 = d41 = ((tu_0)((Object)this.J)).a(i4);
                        d73 += d75 * d75;
                    }
                    return new double[]{d73, d18};
                }
                case 210: {
                    int n15;
                    int n16 = 0;
                    for (int i5 = 0; i5 < n3; ++i5) {
                        ((tu_0)((Object)sA5)).a(i5, 0.0);
                        for (n15 = 0; n15 <= i5; ++n15) {
                            if (n15 < i5) {
                                ((tu_0)((Object)sA5)).a(i5, ((tu_0)((Object)sA5)).a(i5) + ((tu_0)((Object)this.L)).a(n16) * ((tu_0)((Object)sA4)).a(n15));
                            }
                            ((tu_0)((Object)sA5)).a(n15, ((tu_0)((Object)sA5)).a(n15) + ((tu_0)((Object)this.L)).a(n16) * ((tu_0)((Object)sA4)).a(i5));
                            ++n16;
                        }
                    }
                    tu_0 tu_02 = ((tu_0)((Object)((tp_0)this.z).a((tu_0)((Object)sA4)))).i((tu_0)((Object)this.G));
                    for (n15 = 0; n15 < n4; ++n15) {
                        if (((tu_0)((Object)this.G)).a(n15) == 0.0) continue;
                        for (int i6 = 0; i6 < n3; ++i6) {
                            ((tu_0)((Object)sA5)).a(i6, ((tu_0)((Object)sA5)).a(i6) + tu_02.a(n15) * ((sv_0)this.z).b(n15, i6));
                        }
                    }
                    if (d18 != 0.0) {
                        n2 = 50;
                        continue block12;
                    }
                    if (n8 > n6) {
                        n2 = 150;
                        continue block12;
                    }
                    for (n15 = 0; n15 < n3; ++n15) {
                        ((tu_0)((Object)sA6)).a(n15, ((tu_0)((Object)sA5)).a(n15));
                    }
                    n2 = 120;
                    continue block12;
                }
            }
            break;
        }
        throw new oX(px_0.SIMPLE_MESSAGE, "trsbox");
    }

    private void a(double d2, double d3, int n2) {
        int n3;
        double d4;
        int n4;
        sA sA2 = this.u;
        int n5 = sA2.a.length;
        int n6 = this.q;
        int n7 = n6 - n5 - 1;
        sA sA3 = new sA(n6 + n5);
        double d5 = 0.0;
        for (n4 = 0; n4 < n6; ++n4) {
            for (int i2 = 0; i2 < n7; ++i2) {
                d5 = BY.e(d5, BY.w(((sv_0)this.y).b(n4, i2)));
            }
        }
        d5 *= 1.0E-20;
        for (n4 = 1; n4 < n7; ++n4) {
            double d6;
            double d7 = ((sv_0)this.y).b(n2, n4);
            if (BY.w(d6) > d5) {
                double d8 = ((sv_0)this.y).b(n2, 0);
                double d9 = ((sv_0)this.y).b(n2, n4);
                double d10 = d8;
                double d11 = d9;
                double d12 = BY.a(d10 * d10 + d11 * d11);
                double d13 = ((sv_0)this.y).b(n2, 0) / d12;
                double d14 = ((sv_0)this.y).b(n2, n4) / d12;
                for (int i3 = 0; i3 < n6; ++i3) {
                    d4 = d13 * ((sv_0)this.y).b(i3, 0) + d14 * ((sv_0)this.y).b(i3, n4);
                    ((sv_0)this.y).c(i3, n4, d13 * ((sv_0)this.y).b(i3, n4) - d14 * ((sv_0)this.y).b(i3, 0));
                    ((sv_0)this.y).c(i3, 0, d4);
                }
            }
            ((sv_0)this.y).c(n2, n4, 0.0);
        }
        for (n4 = 0; n4 < n6; ++n4) {
            ((tu_0)((Object)sA3)).a(n4, ((sv_0)this.y).b(n2, 0) * ((sv_0)this.y).b(n4, 0));
        }
        double d15 = ((tu_0)((Object)sA3)).a(n2);
        double d16 = ((tu_0)((Object)this.K)).a(n2);
        sA sA4 = this.K;
        ((tu_0)((Object)sA4)).a(n2, ((tu_0)((Object)sA4)).a(n2) - 1.0);
        double d17 = BY.a(d3);
        double d18 = d16 / d17;
        double d19 = ((sv_0)this.y).b(n2, 0) / d17;
        for (n3 = 0; n3 < n6; ++n3) {
            ((sv_0)this.y).c(n3, 0, d18 * ((sv_0)this.y).b(n3, 0) - d19 * ((tu_0)((Object)this.K)).a(n3));
        }
        for (n3 = 0; n3 < n5; ++n3) {
            int n8 = n6 + n3;
            ((tu_0)((Object)sA3)).a(n8, ((sv_0)this.x).b(n2, n3));
            double d20 = (d15 * ((tu_0)((Object)this.K)).a(n8) - d16 * ((tu_0)((Object)sA3)).a(n8)) / d3;
            d4 = (-d2 * ((tu_0)((Object)sA3)).a(n8) - d16 * ((tu_0)((Object)this.K)).a(n8)) / d3;
            for (n7 = 0; n7 <= n8; ++n7) {
                ((sv_0)this.x).c(n7, n3, ((sv_0)this.x).b(n7, n3) + d20 * ((tu_0)((Object)this.K)).a(n7) + d4 * ((tu_0)((Object)sA3)).a(n7));
                if (n7 < n6) continue;
                ((sv_0)this.x).c(n8, n7 - n6, ((sv_0)this.x).b(n7, n3));
            }
        }
    }

    private void d(double[] dArray, double[] dArray2) {
        double[] dArray3 = this.f();
        int n2 = dArray3.length;
        if (n2 < 2) {
            throw new pn_0(n2, (Number)2, true);
        }
        int[] nArray = new int[]{n2 + 2, (n2 + 2) * (n2 + 1) / 2};
        if (this.q < nArray[0] || this.q > nArray[1]) {
            throw new po_0(px_0.NUMBER_OF_INTERPOLATION_POINTS, (Number)this.q, nArray[0], nArray[1]);
        }
        this.v = new double[n2];
        double d2 = 2.0 * this.r;
        double d3 = Double.POSITIVE_INFINITY;
        for (int i2 = 0; i2 < n2; ++i2) {
            this.v[i2] = dArray2[i2] - dArray[i2];
            d3 = BY.d(d3, this.v[i2]);
        }
        if (d3 < d2) {
            this.r = d3 / 3.0;
        }
        this.x = new sy_0(n2 + this.q, n2);
        this.y = new sy_0(this.q, this.q - n2 - 1);
        this.z = new sy_0(this.q, n2);
        this.A = new sA(n2);
        this.B = new sA(this.q);
        this.C = new sA(n2);
        this.D = new sA(n2);
        this.E = new sA(n2);
        this.F = new sA(n2);
        this.G = new sA(this.q);
        this.H = new sA(n2);
        this.I = new sA(n2);
        this.J = new sA(n2);
        this.K = new sA(n2 + this.q);
        int n3 = n2;
        this.L = new sA(n3 * (n3 + 1) / 2);
    }

    private static String b(int n2) {
        StackTraceElement[] stackTraceElementArray = new Throwable();
        stackTraceElementArray = stackTraceElementArray.getStackTrace();
        StackTraceElement stackTraceElement = stackTraceElementArray[n2];
        return stackTraceElement.getMethodName() + " (at line " + stackTraceElement.getLineNumber() + ")";
    }

    private static void i() {
    }

    private static void j() {
    }

    static /* synthetic */ String a(int n2) {
        n2 = 3;
        StackTraceElement[] stackTraceElementArray = new Throwable();
        stackTraceElementArray = stackTraceElementArray.getStackTrace();
        StackTraceElement stackTraceElement = stackTraceElementArray[n2];
        return stackTraceElement.getMethodName() + " (at line " + stackTraceElement.getLineNumber() + ")";
    }

    static final class a
    extends RuntimeException {
        private static final long a = 745350979634801853L;
        private static final String b = "If this exception is thrown, just remove it from the code";

        a() {
            int n2 = 3;
            n2 = 3;
            StackTraceElement[] stackTraceElementArray = new Throwable();
            stackTraceElementArray = stackTraceElementArray.getStackTrace();
            StackTraceElement stackTraceElement = stackTraceElementArray[n2];
            super("If this exception is thrown, just remove it from the code " + (stackTraceElement.getMethodName() + " (at line " + stackTraceElement.getLineNumber() + ")"));
        }
    }
}

