/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.ch_0;
import org.valkyrienskies.core.impl.shadow.oU;
import org.valkyrienskies.core.impl.shadow.oV;
import org.valkyrienskies.core.impl.shadow.px_0;
import org.valkyrienskies.core.impl.shadow.rb_0;
import org.valkyrienskies.core.impl.shadow.rg_0;
import org.valkyrienskies.core.impl.shadow.rl_0;
import org.valkyrienskies.core.impl.shadow.rm_0;
import org.valkyrienskies.core.impl.shadow.rs_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.rk
 */
public final class rk_0
implements Serializable {
    private static rk_0 e;
    private static final long f = -2153622329907944313L;
    final double a;
    final double b;
    final double c;
    final double d;

    public rk_0(double d2, double d3, double d4, double d5, boolean bl) {
        this.a = d2;
        this.b = d3;
        this.c = d4;
        this.d = d5;
    }

    @Deprecated
    private rk_0(rs_0 rs_02, double d2) {
        this(rs_02, d2, rl_0.VECTOR_OPERATOR$59e4743c);
    }

    public rk_0(rs_0 rs_02, double d2, int n2) {
        double d3 = rs_02.e();
        if (d3 == 0.0) {
            throw new oV(px_0.ZERO_NORM_FOR_ROTATION_AXIS, new Object[0]);
        }
        double d4 = n2 == rl_0.VECTOR_OPERATOR$59e4743c ? d2 * -0.5 : d2 * 0.5;
        double d5 = BY.n(d4) / d3;
        this.a = BY.o(d4);
        rs_0 rs_03 = rs_02;
        this.b = d5 * rs_03.i;
        rs_03 = rs_02;
        this.c = d5 * rs_03.j;
        rs_03 = rs_02;
        this.d = d5 * rs_03.k;
    }

    private rk_0(double[][] object, double d2) {
        double d3;
        double[][] dArray;
        block4: {
            if (((double[][])object).length != 3 || object[0].length != 3 || object[1].length != 3 || object[2].length != 3) {
                throw new rg_0(px_0.ROTATION_MATRIX_DIMENSIONS, ((double[][])object).length, object[0].length);
            }
            double d4 = d2;
            double[] dArray2 = object[0];
            double[] dArray3 = object[1];
            object = object[2];
            double d5 = dArray2[0];
            double d6 = dArray2[1];
            double d7 = dArray2[2];
            double d8 = dArray3[0];
            double d9 = dArray3[1];
            double d10 = dArray3[2];
            Object object2 = object[0];
            Object object3 = object[1];
            Object object4 = object[2];
            double d11 = 0.0;
            dArray = new double[3][3];
            double[] dArray4 = dArray[0];
            double[] dArray5 = dArray[1];
            double[] dArray6 = dArray[2];
            int n2 = 0;
            while (++n2 < 11) {
                double d12;
                double d13 = dArray2[0] * d5 + dArray3[0] * d8 + object[0] * object2;
                double d14 = dArray2[1] * d5 + dArray3[1] * d8 + object[1] * object2;
                double d15 = dArray2[2] * d5 + dArray3[2] * d8 + object[2] * object2;
                double d16 = dArray2[0] * d6 + dArray3[0] * d9 + object[0] * object3;
                double d17 = dArray2[1] * d6 + dArray3[1] * d9 + object[1] * object3;
                double d18 = dArray2[2] * d6 + dArray3[2] * d9 + object[2] * object3;
                double d19 = dArray2[0] * d7 + dArray3[0] * d10 + object[0] * object4;
                double d20 = dArray2[1] * d7 + dArray3[1] * d10 + object[1] * object4;
                double d21 = dArray2[2] * d7 + dArray3[2] * d10 + object[2] * object4;
                dArray4[0] = d5 - 0.5 * (d5 * d13 + d6 * d14 + d7 * d15 - dArray2[0]);
                dArray4[1] = d6 - 0.5 * (d5 * d16 + d6 * d17 + d7 * d18 - dArray2[1]);
                dArray4[2] = d7 - 0.5 * (d5 * d19 + d6 * d20 + d7 * d21 - dArray2[2]);
                dArray5[0] = d8 - 0.5 * (d8 * d13 + d9 * d14 + d10 * d15 - dArray3[0]);
                dArray5[1] = d9 - 0.5 * (d8 * d16 + d9 * d17 + d10 * d18 - dArray3[1]);
                dArray5[2] = d10 - 0.5 * (d8 * d19 + d9 * d20 + d10 * d21 - dArray3[2]);
                dArray6[0] = (double)(object2 - 0.5 * (object2 * d13 + object3 * d14 + object4 * d15 - object[0]));
                dArray6[1] = (double)(object3 - 0.5 * (object2 * d16 + object3 * d17 + object4 * d18 - object[1]));
                dArray6[2] = (double)(object4 - 0.5 * (object2 * d19 + object3 * d20 + object4 * d21 - object[2]));
                double d22 = dArray4[0] - dArray2[0];
                double d23 = dArray4[1] - dArray2[1];
                double d24 = dArray4[2] - dArray2[2];
                double d25 = dArray5[0] - dArray3[0];
                double d26 = dArray5[1] - dArray3[1];
                double d27 = dArray5[2] - dArray3[2];
                double d28 = dArray6[0] - object[0];
                double d29 = dArray6[1] - object[1];
                double d30 = dArray6[2] - object[2];
                double d31 = d22;
                double d32 = d23;
                double d33 = d24;
                double d34 = d25;
                double d35 = d26;
                double d36 = d27;
                double d37 = d28;
                double d38 = d29;
                double d39 = d30;
                double d40 = d31 * d31 + d32 * d32 + d33 * d33 + d34 * d34 + d35 * d35 + d36 * d36 + d37 * d37 + d38 * d38 + d39 * d39;
                if (!(BY.w(d12 - d11) <= d4)) {
                    d5 = dArray4[0];
                    d6 = dArray4[1];
                    d7 = dArray4[2];
                    d8 = dArray5[0];
                    d9 = dArray5[1];
                    d10 = dArray5[2];
                    object2 = dArray6[0];
                    object3 = dArray6[1];
                    object4 = dArray6[2];
                    d11 = d40;
                    continue;
                }
                break block4;
            }
            throw new rg_0(px_0.UNABLE_TO_ORTHOGONOLIZE_MATRIX, n2 - 1);
        }
        object = dArray;
        double d41 = dArray[0][0] * (object[1][1] * object[2][2] - object[2][1] * object[1][2]) - object[1][0] * (object[0][1] * object[2][2] - object[2][1] * object[0][2]) + object[2][0] * (object[0][1] * object[1][2] - object[1][1] * object[0][2]);
        if (d3 < 0.0) {
            throw new rg_0(px_0.CLOSEST_ORTHOGONAL_MATRIX_HAS_NEGATIVE_DETERMINANT, d41);
        }
        object = rk_0.a(object);
        this.a = (double)object[0];
        this.b = (double)object[1];
        this.c = (double)object[2];
        this.d = (double)object[3];
    }

    private rk_0(rs_0 object, rs_0 rs_02, rs_0 rs_03, rs_0 rs_04) {
        rs_0 rs_05 = ((rs_0)object).b(rs_02).o();
        rs_02 = rs_05.b((rs_0)object).o();
        object = ((rs_0)object).o();
        rs_0 rs_06 = rs_03.b(rs_04).o();
        rs_04 = rs_06.b(rs_03).o();
        rs_03 = rs_03.o();
        double[][] dArrayArray = new double[3][];
        double[] dArray = new double[3];
        rs_0 rs_07 = object;
        rs_0 rs_08 = rs_07;
        rs_0 rs_09 = rs_03;
        rs_08 = rs_09;
        rs_0 rs_010 = rs_02;
        rs_08 = rs_010;
        rs_0 rs_011 = rs_04;
        rs_08 = rs_011;
        rs_0 rs_012 = rs_05;
        rs_08 = rs_012;
        rs_08 = rs_06;
        dArray[0] = ch_0.a(rs_07.i, rs_09.i, rs_010.i, rs_011.i, rs_012.i, rs_08.i);
        rs_0 rs_013 = object;
        rs_08 = rs_013;
        rs_0 rs_014 = rs_03;
        rs_08 = rs_014;
        rs_0 rs_015 = rs_02;
        rs_08 = rs_015;
        rs_0 rs_016 = rs_04;
        rs_08 = rs_016;
        rs_0 rs_017 = rs_05;
        rs_08 = rs_017;
        rs_08 = rs_06;
        dArray[1] = ch_0.a(rs_013.j, rs_014.i, rs_015.j, rs_016.i, rs_017.j, rs_08.i);
        rs_0 rs_018 = object;
        rs_08 = rs_018;
        rs_0 rs_019 = rs_03;
        rs_08 = rs_019;
        rs_0 rs_020 = rs_02;
        rs_08 = rs_020;
        rs_0 rs_021 = rs_04;
        rs_08 = rs_021;
        rs_0 rs_022 = rs_05;
        rs_08 = rs_022;
        rs_08 = rs_06;
        dArray[2] = ch_0.a(rs_018.k, rs_019.i, rs_020.k, rs_021.i, rs_022.k, rs_08.i);
        dArrayArray[0] = dArray;
        double[] dArray2 = new double[3];
        rs_0 rs_023 = object;
        rs_08 = rs_023;
        rs_0 rs_024 = rs_03;
        rs_08 = rs_024;
        rs_0 rs_025 = rs_02;
        rs_08 = rs_025;
        rs_0 rs_026 = rs_04;
        rs_08 = rs_026;
        rs_0 rs_027 = rs_05;
        rs_08 = rs_027;
        rs_08 = rs_06;
        dArray2[0] = ch_0.a(rs_023.i, rs_024.j, rs_025.i, rs_026.j, rs_027.i, rs_08.j);
        rs_0 rs_028 = object;
        rs_08 = rs_028;
        rs_0 rs_029 = rs_03;
        rs_08 = rs_029;
        rs_0 rs_030 = rs_02;
        rs_08 = rs_030;
        rs_0 rs_031 = rs_04;
        rs_08 = rs_031;
        rs_0 rs_032 = rs_05;
        rs_08 = rs_032;
        rs_08 = rs_06;
        dArray2[1] = ch_0.a(rs_028.j, rs_029.j, rs_030.j, rs_031.j, rs_032.j, rs_08.j);
        rs_0 rs_033 = object;
        rs_08 = rs_033;
        rs_0 rs_034 = rs_03;
        rs_08 = rs_034;
        rs_0 rs_035 = rs_02;
        rs_08 = rs_035;
        rs_0 rs_036 = rs_04;
        rs_08 = rs_036;
        rs_0 rs_037 = rs_05;
        rs_08 = rs_037;
        rs_08 = rs_06;
        dArray2[2] = ch_0.a(rs_033.k, rs_034.j, rs_035.k, rs_036.j, rs_037.k, rs_08.j);
        dArrayArray[1] = dArray2;
        double[] dArray3 = new double[3];
        rs_0 rs_038 = object;
        rs_08 = rs_038;
        rs_0 rs_039 = rs_03;
        rs_08 = rs_039;
        rs_0 rs_040 = rs_02;
        rs_08 = rs_040;
        rs_0 rs_041 = rs_04;
        rs_08 = rs_041;
        rs_0 rs_042 = rs_05;
        rs_08 = rs_042;
        rs_08 = rs_06;
        dArray3[0] = ch_0.a(rs_038.i, rs_039.k, rs_040.i, rs_041.k, rs_042.i, rs_08.k);
        rs_0 rs_043 = object;
        rs_08 = rs_043;
        rs_0 rs_044 = rs_03;
        rs_08 = rs_044;
        rs_0 rs_045 = rs_02;
        rs_08 = rs_045;
        rs_0 rs_046 = rs_04;
        rs_08 = rs_046;
        rs_0 rs_047 = rs_05;
        rs_08 = rs_047;
        rs_08 = rs_06;
        dArray3[1] = ch_0.a(rs_043.j, rs_044.k, rs_045.j, rs_046.k, rs_047.j, rs_08.k);
        rs_0 rs_048 = object;
        rs_08 = rs_048;
        rs_0 rs_049 = rs_03;
        rs_08 = rs_049;
        rs_0 rs_050 = rs_02;
        rs_08 = rs_050;
        rs_0 rs_051 = rs_04;
        rs_08 = rs_051;
        rs_0 rs_052 = rs_05;
        rs_08 = rs_052;
        rs_08 = rs_06;
        dArray3[2] = ch_0.a(rs_048.k, rs_049.k, rs_050.k, rs_051.k, rs_052.k, rs_08.k);
        dArrayArray[2] = dArray3;
        object = dArrayArray;
        object = rk_0.a(dArrayArray);
        this.a = (double)object[0];
        this.b = (double)object[1];
        this.c = (double)object[2];
        this.d = (double)object[3];
    }

    private rk_0(rs_0 rs_02, rs_0 rs_03) {
        double d2;
        double d3 = rs_02.e() * rs_03.e();
        if (d3 == 0.0) {
            throw new oU(px_0.ZERO_NORM_FOR_ROTATION_DEFINING_VECTOR, new Object[0]);
        }
        double d4 = rs_02.f(rs_03);
        if (d2 < d3 * -0.999999999999998) {
            rs_0 rs_04 = rs_02.p();
            this.a = 0.0;
            rs_03 = rs_04;
            this.b = -rs_03.i;
            rs_03 = rs_04;
            this.c = -rs_03.j;
            rs_03 = rs_04;
            this.d = -rs_03.k;
            return;
        }
        this.a = BY.a(0.5 * (1.0 + d4 / d3));
        double d5 = 1.0 / (2.0 * this.a * d3);
        rs_03 = rs_02 = rs_03.b(rs_02);
        this.b = d5 * rs_03.i;
        rs_03 = rs_02;
        this.c = d5 * rs_03.j;
        rs_03 = rs_02;
        this.d = d5 * rs_03.k;
    }

    @Deprecated
    private rk_0(rm_0 rm_02, double d2, double d3, double d4) {
        this(rm_02, rl_0.VECTOR_OPERATOR$59e4743c, d2, d3, d4);
    }

    private rk_0(rm_0 object, int n2, double d2, double d3, double d4) {
        rm_0 rm_02 = object;
        rk_0 rk_02 = new rk_0(rm_02.l, d2, n2);
        rm_02 = object;
        rk_0 rk_03 = new rk_0(rm_02.m, d3, n2);
        rm_02 = object;
        object = new rk_0(rm_02.n, d4, n2);
        object = rk_02.a(rk_03.a((rk_0)object, n2), n2);
        this.a = ((rk_0)object).a;
        this.b = ((rk_0)object).b;
        this.c = ((rk_0)object).c;
        this.d = ((rk_0)object).d;
    }

    private static double[] a(double[][] dArray) {
        double d2;
        double[] dArray2 = new double[4];
        double d3 = dArray[0][0] + dArray[1][1] + dArray[2][2];
        if (d2 > -0.19) {
            dArray2[0] = 0.5 * BY.a(d3 + 1.0);
            double d4 = 0.25 / dArray2[0];
            dArray2[1] = d4 * (dArray[1][2] - dArray[2][1]);
            dArray2[2] = d4 * (dArray[2][0] - dArray[0][2]);
            dArray2[3] = d4 * (dArray[0][1] - dArray[1][0]);
        } else {
            double d5;
            d3 = dArray[0][0] - dArray[1][1] - dArray[2][2];
            if (d5 > -0.19) {
                dArray2[1] = 0.5 * BY.a(d3 + 1.0);
                double d6 = 0.25 / dArray2[1];
                dArray2[0] = d6 * (dArray[1][2] - dArray[2][1]);
                dArray2[2] = d6 * (dArray[0][1] + dArray[1][0]);
                dArray2[3] = d6 * (dArray[0][2] + dArray[2][0]);
            } else {
                double d7;
                d3 = dArray[1][1] - dArray[0][0] - dArray[2][2];
                if (d7 > -0.19) {
                    dArray2[2] = 0.5 * BY.a(d3 + 1.0);
                    double d8 = 0.25 / dArray2[2];
                    dArray2[0] = d8 * (dArray[2][0] - dArray[0][2]);
                    dArray2[1] = d8 * (dArray[0][1] + dArray[1][0]);
                    dArray2[3] = d8 * (dArray[2][1] + dArray[1][2]);
                } else {
                    d3 = dArray[2][2] - dArray[0][0] - dArray[1][1];
                    dArray2[3] = 0.5 * BY.a(d3 + 1.0);
                    double d9 = 0.25 / dArray2[3];
                    dArray2[0] = d9 * (dArray[0][1] - dArray[1][0]);
                    dArray2[1] = d9 * (dArray[0][2] + dArray[2][0]);
                    dArray2[2] = d9 * (dArray[2][1] + dArray[1][2]);
                }
            }
        }
        return dArray2;
    }

    private rk_0 e() {
        return new rk_0(-this.a, this.b, this.c, this.d, false);
    }

    public final double a() {
        return this.a;
    }

    public final double b() {
        return this.b;
    }

    public final double c() {
        return this.c;
    }

    public final double d() {
        return this.d;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Deprecated
    private rs_0 f() {
        rs_0 rs_02;
        int n2 = rl_0.VECTOR_OPERATOR$59e4743c;
        rk_0 rk_02 = this;
        double d2 = rk_02.b * rk_02.b + rk_02.c * rk_02.c + rk_02.d * rk_02.d;
        if (d2 == 0.0) {
            if (n2 != rl_0.VECTOR_OPERATOR$59e4743c) return rs_0.c;
            rs_02 = rs_0.b;
            return rs_02;
        } else {
            double d3;
            double d4 = d3 = n2 == rl_0.VECTOR_OPERATOR$59e4743c ? 1.0 : -1.0;
            if (rk_02.a < 0.0) {
                double d5 = d3 / BY.a(d2);
                return new rs_0(rk_02.b * d5, rk_02.c * d5, rk_02.d * d5);
            }
            double d6 = -d3 / BY.a(d2);
            rs_02 = new rs_0(rk_02.b * d6, rk_02.c * d6, rk_02.d * d6);
        }
        return rs_02;
    }

    private rs_0 a(int n2) {
        double d2;
        double d3 = this.b * this.b + this.c * this.c + this.d * this.d;
        if (d3 == 0.0) {
            if (n2 == rl_0.VECTOR_OPERATOR$59e4743c) {
                return rs_0.b;
            }
            return rs_0.c;
        }
        double d4 = d2 = n2 == rl_0.VECTOR_OPERATOR$59e4743c ? 1.0 : -1.0;
        if (this.a < 0.0) {
            double d5 = d2 / BY.a(d3);
            return new rs_0(this.b * d5, this.c * d5, this.d * d5);
        }
        double d6 = -d2 / BY.a(d3);
        return new rs_0(this.b * d6, this.c * d6, this.d * d6);
    }

    private double g() {
        if (this.a < -0.1 || this.a > 0.1) {
            return 2.0 * BY.r(BY.a(this.b * this.b + this.c * this.c + this.d * this.d));
        }
        if (this.a < 0.0) {
            return 2.0 * BY.s(-this.a);
        }
        return 2.0 * BY.s(this.a);
    }

    @Deprecated
    private double[] a(rm_0 object) {
        Object object2;
        Object object3;
        block118: {
            block117: {
                Object object4;
                block114: {
                    Object object5;
                    block116: {
                        block115: {
                            Object object6;
                            block111: {
                                Object object7;
                                block113: {
                                    block112: {
                                        Object object8;
                                        block108: {
                                            Object object9;
                                            block110: {
                                                block109: {
                                                    Object object10;
                                                    block105: {
                                                        Object object11;
                                                        block107: {
                                                            block106: {
                                                                Object object12;
                                                                block102: {
                                                                    Object object13;
                                                                    block104: {
                                                                        block103: {
                                                                            Object object14;
                                                                            block99: {
                                                                                Object object15;
                                                                                block101: {
                                                                                    block100: {
                                                                                        Object object16;
                                                                                        block96: {
                                                                                            Object object17;
                                                                                            block98: {
                                                                                                block97: {
                                                                                                    Object object18;
                                                                                                    block93: {
                                                                                                        Object object19;
                                                                                                        block95: {
                                                                                                            block94: {
                                                                                                                Object object20;
                                                                                                                block90: {
                                                                                                                    Object object21;
                                                                                                                    block92: {
                                                                                                                        block91: {
                                                                                                                            Object object22;
                                                                                                                            block87: {
                                                                                                                                Object object23;
                                                                                                                                block89: {
                                                                                                                                    block88: {
                                                                                                                                        Object object24;
                                                                                                                                        block84: {
                                                                                                                                            Object object25;
                                                                                                                                            block86: {
                                                                                                                                                block85: {
                                                                                                                                                    Object object26;
                                                                                                                                                    block48: {
                                                                                                                                                        Object object27;
                                                                                                                                                        block83: {
                                                                                                                                                            block82: {
                                                                                                                                                                Object object28;
                                                                                                                                                                block79: {
                                                                                                                                                                    Object object29;
                                                                                                                                                                    block81: {
                                                                                                                                                                        block80: {
                                                                                                                                                                            Object object30;
                                                                                                                                                                            block76: {
                                                                                                                                                                                Object object31;
                                                                                                                                                                                block78: {
                                                                                                                                                                                    block77: {
                                                                                                                                                                                        Object object32;
                                                                                                                                                                                        block73: {
                                                                                                                                                                                            Object object33;
                                                                                                                                                                                            block75: {
                                                                                                                                                                                                block74: {
                                                                                                                                                                                                    Object object34;
                                                                                                                                                                                                    block70: {
                                                                                                                                                                                                        Object object35;
                                                                                                                                                                                                        block72: {
                                                                                                                                                                                                            block71: {
                                                                                                                                                                                                                Object object36;
                                                                                                                                                                                                                block67: {
                                                                                                                                                                                                                    Object object37;
                                                                                                                                                                                                                    block69: {
                                                                                                                                                                                                                        block68: {
                                                                                                                                                                                                                            Object object38;
                                                                                                                                                                                                                            block64: {
                                                                                                                                                                                                                                Object object39;
                                                                                                                                                                                                                                block66: {
                                                                                                                                                                                                                                    block65: {
                                                                                                                                                                                                                                        Object object40;
                                                                                                                                                                                                                                        block61: {
                                                                                                                                                                                                                                            Object object41;
                                                                                                                                                                                                                                            block63: {
                                                                                                                                                                                                                                                block62: {
                                                                                                                                                                                                                                                    Object object42;
                                                                                                                                                                                                                                                    block58: {
                                                                                                                                                                                                                                                        Object object43;
                                                                                                                                                                                                                                                        block60: {
                                                                                                                                                                                                                                                            block59: {
                                                                                                                                                                                                                                                                Object object44;
                                                                                                                                                                                                                                                                block55: {
                                                                                                                                                                                                                                                                    Object object45;
                                                                                                                                                                                                                                                                    block57: {
                                                                                                                                                                                                                                                                        block56: {
                                                                                                                                                                                                                                                                            Object object46;
                                                                                                                                                                                                                                                                            block52: {
                                                                                                                                                                                                                                                                                Object object47;
                                                                                                                                                                                                                                                                                block54: {
                                                                                                                                                                                                                                                                                    block53: {
                                                                                                                                                                                                                                                                                        Object object48;
                                                                                                                                                                                                                                                                                        block49: {
                                                                                                                                                                                                                                                                                            Object object49;
                                                                                                                                                                                                                                                                                            block51: {
                                                                                                                                                                                                                                                                                                block50: {
                                                                                                                                                                                                                                                                                                    Object object50;
                                                                                                                                                                                                                                                                                                    int n2 = rl_0.VECTOR_OPERATOR$59e4743c;
                                                                                                                                                                                                                                                                                                    object3 = object;
                                                                                                                                                                                                                                                                                                    object = this;
                                                                                                                                                                                                                                                                                                    if (n2 != rl_0.VECTOR_OPERATOR$59e4743c) break block48;
                                                                                                                                                                                                                                                                                                    if (object3 != rm_0.a) break block49;
                                                                                                                                                                                                                                                                                                    object3 = ((rk_0)object).a(rs_0.f);
                                                                                                                                                                                                                                                                                                    object49 = object = ((rk_0)object).b(rs_0.b);
                                                                                                                                                                                                                                                                                                    if (((rs_0)object).k < -0.9999999999) break block50;
                                                                                                                                                                                                                                                                                                    object49 = object;
                                                                                                                                                                                                                                                                                                    if (!(((rs_0)object50).k > 0.9999999999)) break block51;
                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                throw new rb_0(true);
                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                            double[] dArray = new double[3];
                                                                                                                                                                                                                                                                                            Object object51 = object3;
                                                                                                                                                                                                                                                                                            object49 = object51;
                                                                                                                                                                                                                                                                                            object49 = object3;
                                                                                                                                                                                                                                                                                            dArray[0] = BY.b(-((rs_0)object51).j, ((rs_0)object49).k);
                                                                                                                                                                                                                                                                                            object49 = object;
                                                                                                                                                                                                                                                                                            dArray[1] = BY.r(((rs_0)object49).k);
                                                                                                                                                                                                                                                                                            Object object52 = object;
                                                                                                                                                                                                                                                                                            object49 = object52;
                                                                                                                                                                                                                                                                                            object49 = object;
                                                                                                                                                                                                                                                                                            dArray[2] = BY.b(-((rs_0)object52).j, ((rs_0)object49).i);
                                                                                                                                                                                                                                                                                            return dArray;
                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                        if (object3 != rm_0.b) break block52;
                                                                                                                                                                                                                                                                                        object3 = ((rk_0)object).a(rs_0.d);
                                                                                                                                                                                                                                                                                        object47 = object = ((rk_0)object).b(rs_0.b);
                                                                                                                                                                                                                                                                                        if (((rs_0)object).j < -0.9999999999) break block53;
                                                                                                                                                                                                                                                                                        object47 = object;
                                                                                                                                                                                                                                                                                        if (!(((rs_0)object48).j > 0.9999999999)) break block54;
                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                    throw new rb_0(true);
                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                double[] dArray = new double[3];
                                                                                                                                                                                                                                                                                Object object53 = object3;
                                                                                                                                                                                                                                                                                object47 = object53;
                                                                                                                                                                                                                                                                                object47 = object3;
                                                                                                                                                                                                                                                                                dArray[0] = BY.b(((rs_0)object53).k, ((rs_0)object47).j);
                                                                                                                                                                                                                                                                                object47 = object;
                                                                                                                                                                                                                                                                                dArray[1] = -BY.r(((rs_0)object47).j);
                                                                                                                                                                                                                                                                                Object object54 = object;
                                                                                                                                                                                                                                                                                object47 = object54;
                                                                                                                                                                                                                                                                                object47 = object;
                                                                                                                                                                                                                                                                                dArray[2] = BY.b(((rs_0)object54).k, ((rs_0)object47).i);
                                                                                                                                                                                                                                                                                return dArray;
                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                            if (object3 != rm_0.c) break block55;
                                                                                                                                                                                                                                                                            object3 = ((rk_0)object).a(rs_0.f);
                                                                                                                                                                                                                                                                            object45 = object = ((rk_0)object).b(rs_0.d);
                                                                                                                                                                                                                                                                            if (((rs_0)object).k < -0.9999999999) break block56;
                                                                                                                                                                                                                                                                            object45 = object;
                                                                                                                                                                                                                                                                            if (!(((rs_0)object46).k > 0.9999999999)) break block57;
                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                        throw new rb_0(true);
                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                    double[] dArray = new double[3];
                                                                                                                                                                                                                                                                    Object object55 = object3;
                                                                                                                                                                                                                                                                    object45 = object55;
                                                                                                                                                                                                                                                                    object45 = object3;
                                                                                                                                                                                                                                                                    dArray[0] = BY.b(((rs_0)object55).i, ((rs_0)object45).k);
                                                                                                                                                                                                                                                                    object45 = object;
                                                                                                                                                                                                                                                                    dArray[1] = -BY.r(((rs_0)object45).k);
                                                                                                                                                                                                                                                                    Object object56 = object;
                                                                                                                                                                                                                                                                    object45 = object56;
                                                                                                                                                                                                                                                                    object45 = object;
                                                                                                                                                                                                                                                                    dArray[2] = BY.b(((rs_0)object56).i, ((rs_0)object45).j);
                                                                                                                                                                                                                                                                    return dArray;
                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                if (object3 != rm_0.d) break block58;
                                                                                                                                                                                                                                                                object3 = ((rk_0)object).a(rs_0.b);
                                                                                                                                                                                                                                                                object43 = object = ((rk_0)object).b(rs_0.d);
                                                                                                                                                                                                                                                                if (((rs_0)object).i < -0.9999999999) break block59;
                                                                                                                                                                                                                                                                object43 = object;
                                                                                                                                                                                                                                                                if (!(((rs_0)object44).i > 0.9999999999)) break block60;
                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                            throw new rb_0(true);
                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                        double[] dArray = new double[3];
                                                                                                                                                                                                                                                        Object object57 = object3;
                                                                                                                                                                                                                                                        object43 = object57;
                                                                                                                                                                                                                                                        object43 = object3;
                                                                                                                                                                                                                                                        dArray[0] = BY.b(-((rs_0)object57).k, ((rs_0)object43).i);
                                                                                                                                                                                                                                                        object43 = object;
                                                                                                                                                                                                                                                        dArray[1] = BY.r(((rs_0)object43).i);
                                                                                                                                                                                                                                                        Object object58 = object;
                                                                                                                                                                                                                                                        object43 = object58;
                                                                                                                                                                                                                                                        object43 = object;
                                                                                                                                                                                                                                                        dArray[2] = BY.b(-((rs_0)object58).k, ((rs_0)object43).j);
                                                                                                                                                                                                                                                        return dArray;
                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                    if (object3 != rm_0.e) break block61;
                                                                                                                                                                                                                                                    object3 = ((rk_0)object).a(rs_0.d);
                                                                                                                                                                                                                                                    object41 = object = ((rk_0)object).b(rs_0.f);
                                                                                                                                                                                                                                                    if (((rs_0)object).j < -0.9999999999) break block62;
                                                                                                                                                                                                                                                    object41 = object;
                                                                                                                                                                                                                                                    if (!(((rs_0)object42).j > 0.9999999999)) break block63;
                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                throw new rb_0(true);
                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                            double[] dArray = new double[3];
                                                                                                                                                                                                                                            Object object59 = object3;
                                                                                                                                                                                                                                            object41 = object59;
                                                                                                                                                                                                                                            object41 = object3;
                                                                                                                                                                                                                                            dArray[0] = BY.b(-((rs_0)object59).i, ((rs_0)object41).j);
                                                                                                                                                                                                                                            object41 = object;
                                                                                                                                                                                                                                            dArray[1] = BY.r(((rs_0)object41).j);
                                                                                                                                                                                                                                            Object object60 = object;
                                                                                                                                                                                                                                            object41 = object60;
                                                                                                                                                                                                                                            object41 = object;
                                                                                                                                                                                                                                            dArray[2] = BY.b(-((rs_0)object60).i, ((rs_0)object41).k);
                                                                                                                                                                                                                                            return dArray;
                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                        if (object3 != rm_0.f) break block64;
                                                                                                                                                                                                                                        object3 = ((rk_0)object).a(rs_0.b);
                                                                                                                                                                                                                                        object39 = object = ((rk_0)object).b(rs_0.f);
                                                                                                                                                                                                                                        if (((rs_0)object).i < -0.9999999999) break block65;
                                                                                                                                                                                                                                        object39 = object;
                                                                                                                                                                                                                                        if (!(((rs_0)object40).i > 0.9999999999)) break block66;
                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                    throw new rb_0(true);
                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                double[] dArray = new double[3];
                                                                                                                                                                                                                                Object object61 = object3;
                                                                                                                                                                                                                                object39 = object61;
                                                                                                                                                                                                                                object39 = object3;
                                                                                                                                                                                                                                dArray[0] = BY.b(((rs_0)object61).j, ((rs_0)object39).i);
                                                                                                                                                                                                                                object39 = object;
                                                                                                                                                                                                                                dArray[1] = -BY.r(((rs_0)object39).i);
                                                                                                                                                                                                                                Object object62 = object;
                                                                                                                                                                                                                                object39 = object62;
                                                                                                                                                                                                                                object39 = object;
                                                                                                                                                                                                                                dArray[2] = BY.b(((rs_0)object62).j, ((rs_0)object39).k);
                                                                                                                                                                                                                                return dArray;
                                                                                                                                                                                                                            }
                                                                                                                                                                                                                            if (object3 != rm_0.g) break block67;
                                                                                                                                                                                                                            object3 = ((rk_0)object).a(rs_0.b);
                                                                                                                                                                                                                            object37 = object = ((rk_0)object).b(rs_0.b);
                                                                                                                                                                                                                            if (((rs_0)object).i < -0.9999999999) break block68;
                                                                                                                                                                                                                            object37 = object;
                                                                                                                                                                                                                            if (!(((rs_0)object38).i > 0.9999999999)) break block69;
                                                                                                                                                                                                                        }
                                                                                                                                                                                                                        throw new rb_0(false);
                                                                                                                                                                                                                    }
                                                                                                                                                                                                                    double[] dArray = new double[3];
                                                                                                                                                                                                                    Object object63 = object3;
                                                                                                                                                                                                                    object37 = object63;
                                                                                                                                                                                                                    object37 = object3;
                                                                                                                                                                                                                    dArray[0] = BY.b(((rs_0)object63).j, -((rs_0)object37).k);
                                                                                                                                                                                                                    object37 = object;
                                                                                                                                                                                                                    dArray[1] = BY.s(((rs_0)object37).i);
                                                                                                                                                                                                                    Object object64 = object;
                                                                                                                                                                                                                    object37 = object64;
                                                                                                                                                                                                                    object37 = object;
                                                                                                                                                                                                                    dArray[2] = BY.b(((rs_0)object64).j, ((rs_0)object37).k);
                                                                                                                                                                                                                    return dArray;
                                                                                                                                                                                                                }
                                                                                                                                                                                                                if (object3 != rm_0.h) break block70;
                                                                                                                                                                                                                object3 = ((rk_0)object).a(rs_0.b);
                                                                                                                                                                                                                object35 = object = ((rk_0)object).b(rs_0.b);
                                                                                                                                                                                                                if (((rs_0)object).i < -0.9999999999) break block71;
                                                                                                                                                                                                                object35 = object;
                                                                                                                                                                                                                if (!(((rs_0)object36).i > 0.9999999999)) break block72;
                                                                                                                                                                                                            }
                                                                                                                                                                                                            throw new rb_0(false);
                                                                                                                                                                                                        }
                                                                                                                                                                                                        double[] dArray = new double[3];
                                                                                                                                                                                                        Object object65 = object3;
                                                                                                                                                                                                        object35 = object65;
                                                                                                                                                                                                        object35 = object3;
                                                                                                                                                                                                        dArray[0] = BY.b(((rs_0)object65).k, ((rs_0)object35).j);
                                                                                                                                                                                                        object35 = object;
                                                                                                                                                                                                        dArray[1] = BY.s(((rs_0)object35).i);
                                                                                                                                                                                                        Object object66 = object;
                                                                                                                                                                                                        object35 = object66;
                                                                                                                                                                                                        object35 = object;
                                                                                                                                                                                                        dArray[2] = BY.b(((rs_0)object66).k, -((rs_0)object35).j);
                                                                                                                                                                                                        return dArray;
                                                                                                                                                                                                    }
                                                                                                                                                                                                    if (object3 != rm_0.i) break block73;
                                                                                                                                                                                                    object3 = ((rk_0)object).a(rs_0.d);
                                                                                                                                                                                                    object33 = object = ((rk_0)object).b(rs_0.d);
                                                                                                                                                                                                    if (((rs_0)object).j < -0.9999999999) break block74;
                                                                                                                                                                                                    object33 = object;
                                                                                                                                                                                                    if (!(((rs_0)object34).j > 0.9999999999)) break block75;
                                                                                                                                                                                                }
                                                                                                                                                                                                throw new rb_0(false);
                                                                                                                                                                                            }
                                                                                                                                                                                            double[] dArray = new double[3];
                                                                                                                                                                                            Object object67 = object3;
                                                                                                                                                                                            object33 = object67;
                                                                                                                                                                                            object33 = object3;
                                                                                                                                                                                            dArray[0] = BY.b(((rs_0)object67).i, ((rs_0)object33).k);
                                                                                                                                                                                            object33 = object;
                                                                                                                                                                                            dArray[1] = BY.s(((rs_0)object33).j);
                                                                                                                                                                                            Object object68 = object;
                                                                                                                                                                                            object33 = object68;
                                                                                                                                                                                            object33 = object;
                                                                                                                                                                                            dArray[2] = BY.b(((rs_0)object68).i, -((rs_0)object33).k);
                                                                                                                                                                                            return dArray;
                                                                                                                                                                                        }
                                                                                                                                                                                        if (object3 != rm_0.j) break block76;
                                                                                                                                                                                        object3 = ((rk_0)object).a(rs_0.d);
                                                                                                                                                                                        object31 = object = ((rk_0)object).b(rs_0.d);
                                                                                                                                                                                        if (((rs_0)object).j < -0.9999999999) break block77;
                                                                                                                                                                                        object31 = object;
                                                                                                                                                                                        if (!(((rs_0)object32).j > 0.9999999999)) break block78;
                                                                                                                                                                                    }
                                                                                                                                                                                    throw new rb_0(false);
                                                                                                                                                                                }
                                                                                                                                                                                double[] dArray = new double[3];
                                                                                                                                                                                Object object69 = object3;
                                                                                                                                                                                object31 = object69;
                                                                                                                                                                                object31 = object3;
                                                                                                                                                                                dArray[0] = BY.b(((rs_0)object69).k, -((rs_0)object31).i);
                                                                                                                                                                                object31 = object;
                                                                                                                                                                                dArray[1] = BY.s(((rs_0)object31).j);
                                                                                                                                                                                Object object70 = object;
                                                                                                                                                                                object31 = object70;
                                                                                                                                                                                object31 = object;
                                                                                                                                                                                dArray[2] = BY.b(((rs_0)object70).k, ((rs_0)object31).i);
                                                                                                                                                                                return dArray;
                                                                                                                                                                            }
                                                                                                                                                                            if (object3 != rm_0.k) break block79;
                                                                                                                                                                            object3 = ((rk_0)object).a(rs_0.f);
                                                                                                                                                                            object29 = object = ((rk_0)object).b(rs_0.f);
                                                                                                                                                                            if (((rs_0)object).k < -0.9999999999) break block80;
                                                                                                                                                                            object29 = object;
                                                                                                                                                                            if (!(((rs_0)object30).k > 0.9999999999)) break block81;
                                                                                                                                                                        }
                                                                                                                                                                        throw new rb_0(false);
                                                                                                                                                                    }
                                                                                                                                                                    double[] dArray = new double[3];
                                                                                                                                                                    Object object71 = object3;
                                                                                                                                                                    object29 = object71;
                                                                                                                                                                    object29 = object3;
                                                                                                                                                                    dArray[0] = BY.b(((rs_0)object71).i, -((rs_0)object29).j);
                                                                                                                                                                    object29 = object;
                                                                                                                                                                    dArray[1] = BY.s(((rs_0)object29).k);
                                                                                                                                                                    Object object72 = object;
                                                                                                                                                                    object29 = object72;
                                                                                                                                                                    object29 = object;
                                                                                                                                                                    dArray[2] = BY.b(((rs_0)object72).i, ((rs_0)object29).j);
                                                                                                                                                                    return dArray;
                                                                                                                                                                }
                                                                                                                                                                object3 = ((rk_0)object).a(rs_0.f);
                                                                                                                                                                object27 = object = ((rk_0)object).b(rs_0.f);
                                                                                                                                                                if (((rs_0)object).k < -0.9999999999) break block82;
                                                                                                                                                                object27 = object;
                                                                                                                                                                if (!(((rs_0)object28).k > 0.9999999999)) break block83;
                                                                                                                                                            }
                                                                                                                                                            throw new rb_0(false);
                                                                                                                                                        }
                                                                                                                                                        double[] dArray = new double[3];
                                                                                                                                                        Object object73 = object3;
                                                                                                                                                        object27 = object73;
                                                                                                                                                        object27 = object3;
                                                                                                                                                        dArray[0] = BY.b(((rs_0)object73).j, ((rs_0)object27).i);
                                                                                                                                                        object27 = object;
                                                                                                                                                        dArray[1] = BY.s(((rs_0)object27).k);
                                                                                                                                                        Object object74 = object;
                                                                                                                                                        object27 = object74;
                                                                                                                                                        object27 = object;
                                                                                                                                                        dArray[2] = BY.b(((rs_0)object74).j, -((rs_0)object27).i);
                                                                                                                                                        return dArray;
                                                                                                                                                    }
                                                                                                                                                    if (object3 != rm_0.a) break block84;
                                                                                                                                                    object3 = ((rk_0)object).a(rs_0.b);
                                                                                                                                                    object25 = object = ((rk_0)object).b(rs_0.f);
                                                                                                                                                    if (((rs_0)object).i < -0.9999999999) break block85;
                                                                                                                                                    object25 = object;
                                                                                                                                                    if (!(((rs_0)object26).i > 0.9999999999)) break block86;
                                                                                                                                                }
                                                                                                                                                throw new rb_0(true);
                                                                                                                                            }
                                                                                                                                            double[] dArray = new double[3];
                                                                                                                                            Object object75 = object;
                                                                                                                                            object25 = object75;
                                                                                                                                            object25 = object;
                                                                                                                                            dArray[0] = BY.b(-((rs_0)object75).j, ((rs_0)object25).k);
                                                                                                                                            object25 = object;
                                                                                                                                            dArray[1] = BY.r(((rs_0)object25).i);
                                                                                                                                            Object object76 = object3;
                                                                                                                                            object25 = object76;
                                                                                                                                            object25 = object3;
                                                                                                                                            dArray[2] = BY.b(-((rs_0)object76).j, ((rs_0)object25).i);
                                                                                                                                            return dArray;
                                                                                                                                        }
                                                                                                                                        if (object3 != rm_0.b) break block87;
                                                                                                                                        object3 = ((rk_0)object).a(rs_0.b);
                                                                                                                                        object23 = object = ((rk_0)object).b(rs_0.d);
                                                                                                                                        if (((rs_0)object).i < -0.9999999999) break block88;
                                                                                                                                        object23 = object;
                                                                                                                                        if (!(((rs_0)object24).i > 0.9999999999)) break block89;
                                                                                                                                    }
                                                                                                                                    throw new rb_0(true);
                                                                                                                                }
                                                                                                                                double[] dArray = new double[3];
                                                                                                                                Object object77 = object;
                                                                                                                                object23 = object77;
                                                                                                                                object23 = object;
                                                                                                                                dArray[0] = BY.b(((rs_0)object77).k, ((rs_0)object23).j);
                                                                                                                                object23 = object;
                                                                                                                                dArray[1] = -BY.r(((rs_0)object23).i);
                                                                                                                                Object object78 = object3;
                                                                                                                                object23 = object78;
                                                                                                                                object23 = object3;
                                                                                                                                dArray[2] = BY.b(((rs_0)object78).k, ((rs_0)object23).i);
                                                                                                                                return dArray;
                                                                                                                            }
                                                                                                                            if (object3 != rm_0.c) break block90;
                                                                                                                            object3 = ((rk_0)object).a(rs_0.d);
                                                                                                                            object21 = object = ((rk_0)object).b(rs_0.f);
                                                                                                                            if (((rs_0)object).j < -0.9999999999) break block91;
                                                                                                                            object21 = object;
                                                                                                                            if (!(((rs_0)object22).j > 0.9999999999)) break block92;
                                                                                                                        }
                                                                                                                        throw new rb_0(true);
                                                                                                                    }
                                                                                                                    double[] dArray = new double[3];
                                                                                                                    Object object79 = object;
                                                                                                                    object21 = object79;
                                                                                                                    object21 = object;
                                                                                                                    dArray[0] = BY.b(((rs_0)object79).i, ((rs_0)object21).k);
                                                                                                                    object21 = object;
                                                                                                                    dArray[1] = -BY.r(((rs_0)object21).j);
                                                                                                                    Object object80 = object3;
                                                                                                                    object21 = object80;
                                                                                                                    object21 = object3;
                                                                                                                    dArray[2] = BY.b(((rs_0)object80).i, ((rs_0)object21).j);
                                                                                                                    return dArray;
                                                                                                                }
                                                                                                                if (object3 != rm_0.d) break block93;
                                                                                                                object3 = ((rk_0)object).a(rs_0.d);
                                                                                                                object19 = object = ((rk_0)object).b(rs_0.b);
                                                                                                                if (((rs_0)object).j < -0.9999999999) break block94;
                                                                                                                object19 = object;
                                                                                                                if (!(((rs_0)object20).j > 0.9999999999)) break block95;
                                                                                                            }
                                                                                                            throw new rb_0(true);
                                                                                                        }
                                                                                                        double[] dArray = new double[3];
                                                                                                        Object object81 = object;
                                                                                                        object19 = object81;
                                                                                                        object19 = object;
                                                                                                        dArray[0] = BY.b(-((rs_0)object81).k, ((rs_0)object19).i);
                                                                                                        object19 = object;
                                                                                                        dArray[1] = BY.r(((rs_0)object19).j);
                                                                                                        Object object82 = object3;
                                                                                                        object19 = object82;
                                                                                                        object19 = object3;
                                                                                                        dArray[2] = BY.b(-((rs_0)object82).k, ((rs_0)object19).j);
                                                                                                        return dArray;
                                                                                                    }
                                                                                                    if (object3 != rm_0.e) break block96;
                                                                                                    object3 = ((rk_0)object).a(rs_0.f);
                                                                                                    object17 = object = ((rk_0)object).b(rs_0.d);
                                                                                                    if (((rs_0)object).k < -0.9999999999) break block97;
                                                                                                    object17 = object;
                                                                                                    if (!(((rs_0)object18).k > 0.9999999999)) break block98;
                                                                                                }
                                                                                                throw new rb_0(true);
                                                                                            }
                                                                                            double[] dArray = new double[3];
                                                                                            Object object83 = object;
                                                                                            object17 = object83;
                                                                                            object17 = object;
                                                                                            dArray[0] = BY.b(-((rs_0)object83).i, ((rs_0)object17).j);
                                                                                            object17 = object;
                                                                                            dArray[1] = BY.r(((rs_0)object17).k);
                                                                                            Object object84 = object3;
                                                                                            object17 = object84;
                                                                                            object17 = object3;
                                                                                            dArray[2] = BY.b(-((rs_0)object84).i, ((rs_0)object17).k);
                                                                                            return dArray;
                                                                                        }
                                                                                        if (object3 != rm_0.f) break block99;
                                                                                        object3 = ((rk_0)object).a(rs_0.f);
                                                                                        object15 = object = ((rk_0)object).b(rs_0.b);
                                                                                        if (((rs_0)object).k < -0.9999999999) break block100;
                                                                                        object15 = object;
                                                                                        if (!(((rs_0)object16).k > 0.9999999999)) break block101;
                                                                                    }
                                                                                    throw new rb_0(true);
                                                                                }
                                                                                double[] dArray = new double[3];
                                                                                Object object85 = object;
                                                                                object15 = object85;
                                                                                object15 = object;
                                                                                dArray[0] = BY.b(((rs_0)object85).j, ((rs_0)object15).i);
                                                                                object15 = object;
                                                                                dArray[1] = -BY.r(((rs_0)object15).k);
                                                                                Object object86 = object3;
                                                                                object15 = object86;
                                                                                object15 = object3;
                                                                                dArray[2] = BY.b(((rs_0)object86).j, ((rs_0)object15).k);
                                                                                return dArray;
                                                                            }
                                                                            if (object3 != rm_0.g) break block102;
                                                                            object3 = ((rk_0)object).a(rs_0.b);
                                                                            object13 = object = ((rk_0)object).b(rs_0.b);
                                                                            if (((rs_0)object).i < -0.9999999999) break block103;
                                                                            object13 = object;
                                                                            if (!(((rs_0)object14).i > 0.9999999999)) break block104;
                                                                        }
                                                                        throw new rb_0(false);
                                                                    }
                                                                    double[] dArray = new double[3];
                                                                    Object object87 = object;
                                                                    object13 = object87;
                                                                    object13 = object;
                                                                    dArray[0] = BY.b(((rs_0)object87).j, -((rs_0)object13).k);
                                                                    object13 = object;
                                                                    dArray[1] = BY.s(((rs_0)object13).i);
                                                                    Object object88 = object3;
                                                                    object13 = object88;
                                                                    object13 = object3;
                                                                    dArray[2] = BY.b(((rs_0)object88).j, ((rs_0)object13).k);
                                                                    return dArray;
                                                                }
                                                                if (object3 != rm_0.h) break block105;
                                                                object3 = ((rk_0)object).a(rs_0.b);
                                                                object11 = object = ((rk_0)object).b(rs_0.b);
                                                                if (((rs_0)object).i < -0.9999999999) break block106;
                                                                object11 = object;
                                                                if (!(((rs_0)object12).i > 0.9999999999)) break block107;
                                                            }
                                                            throw new rb_0(false);
                                                        }
                                                        double[] dArray = new double[3];
                                                        Object object89 = object;
                                                        object11 = object89;
                                                        object11 = object;
                                                        dArray[0] = BY.b(((rs_0)object89).k, ((rs_0)object11).j);
                                                        object11 = object;
                                                        dArray[1] = BY.s(((rs_0)object11).i);
                                                        Object object90 = object3;
                                                        object11 = object90;
                                                        object11 = object3;
                                                        dArray[2] = BY.b(((rs_0)object90).k, -((rs_0)object11).j);
                                                        return dArray;
                                                    }
                                                    if (object3 != rm_0.i) break block108;
                                                    object3 = ((rk_0)object).a(rs_0.d);
                                                    object9 = object = ((rk_0)object).b(rs_0.d);
                                                    if (((rs_0)object).j < -0.9999999999) break block109;
                                                    object9 = object;
                                                    if (!(((rs_0)object10).j > 0.9999999999)) break block110;
                                                }
                                                throw new rb_0(false);
                                            }
                                            double[] dArray = new double[3];
                                            Object object91 = object;
                                            object9 = object91;
                                            object9 = object;
                                            dArray[0] = BY.b(((rs_0)object91).i, ((rs_0)object9).k);
                                            object9 = object;
                                            dArray[1] = BY.s(((rs_0)object9).j);
                                            Object object92 = object3;
                                            object9 = object92;
                                            object9 = object3;
                                            dArray[2] = BY.b(((rs_0)object92).i, -((rs_0)object9).k);
                                            return dArray;
                                        }
                                        if (object3 != rm_0.j) break block111;
                                        object3 = ((rk_0)object).a(rs_0.d);
                                        object7 = object = ((rk_0)object).b(rs_0.d);
                                        if (((rs_0)object).j < -0.9999999999) break block112;
                                        object7 = object;
                                        if (!(((rs_0)object8).j > 0.9999999999)) break block113;
                                    }
                                    throw new rb_0(false);
                                }
                                double[] dArray = new double[3];
                                Object object93 = object;
                                object7 = object93;
                                object7 = object;
                                dArray[0] = BY.b(((rs_0)object93).k, -((rs_0)object7).i);
                                object7 = object;
                                dArray[1] = BY.s(((rs_0)object7).j);
                                Object object94 = object3;
                                object7 = object94;
                                object7 = object3;
                                dArray[2] = BY.b(((rs_0)object94).k, ((rs_0)object7).i);
                                return dArray;
                            }
                            if (object3 != rm_0.k) break block114;
                            object3 = ((rk_0)object).a(rs_0.f);
                            object5 = object = ((rk_0)object).b(rs_0.f);
                            if (((rs_0)object).k < -0.9999999999) break block115;
                            object5 = object;
                            if (!(((rs_0)object6).k > 0.9999999999)) break block116;
                        }
                        throw new rb_0(false);
                    }
                    double[] dArray = new double[3];
                    Object object95 = object;
                    object5 = object95;
                    object5 = object;
                    dArray[0] = BY.b(((rs_0)object95).i, -((rs_0)object5).j);
                    object5 = object;
                    dArray[1] = BY.s(((rs_0)object5).k);
                    Object object96 = object3;
                    object5 = object96;
                    object5 = object3;
                    dArray[2] = BY.b(((rs_0)object96).i, ((rs_0)object5).j);
                    return dArray;
                }
                object3 = ((rk_0)object).a(rs_0.f);
                object2 = object = ((rk_0)object).b(rs_0.f);
                if (((rs_0)object).k < -0.9999999999) break block117;
                object2 = object;
                if (!(((rs_0)object4).k > 0.9999999999)) break block118;
            }
            throw new rb_0(false);
        }
        double[] dArray = new double[3];
        Object object97 = object;
        object2 = object97;
        object2 = object;
        dArray[0] = BY.b(((rs_0)object97).j, ((rs_0)object2).i);
        object2 = object;
        dArray[1] = BY.s(((rs_0)object2).k);
        Object object98 = object3;
        object2 = object98;
        object2 = object3;
        dArray[2] = BY.b(((rs_0)object98).j, -((rs_0)object2).i);
        return dArray;
    }

    private double[] a(rm_0 object, int n2) {
        Object object2;
        rs_0 rs_02;
        block118: {
            block117: {
                rs_0 rs_03;
                block114: {
                    Object object3;
                    rs_0 rs_04;
                    block116: {
                        block115: {
                            rs_0 rs_05;
                            block111: {
                                Object object4;
                                rs_0 rs_06;
                                block113: {
                                    block112: {
                                        rs_0 rs_07;
                                        block108: {
                                            Object object5;
                                            rs_0 rs_08;
                                            block110: {
                                                block109: {
                                                    rs_0 rs_09;
                                                    block105: {
                                                        Object object6;
                                                        rs_0 rs_010;
                                                        block107: {
                                                            block106: {
                                                                rs_0 rs_011;
                                                                block102: {
                                                                    Object object7;
                                                                    rs_0 rs_012;
                                                                    block104: {
                                                                        block103: {
                                                                            rs_0 rs_013;
                                                                            block99: {
                                                                                Object object8;
                                                                                rs_0 rs_014;
                                                                                block101: {
                                                                                    block100: {
                                                                                        rs_0 rs_015;
                                                                                        block96: {
                                                                                            Object object9;
                                                                                            rs_0 rs_016;
                                                                                            block98: {
                                                                                                block97: {
                                                                                                    rs_0 rs_017;
                                                                                                    block93: {
                                                                                                        Object object10;
                                                                                                        rs_0 rs_018;
                                                                                                        block95: {
                                                                                                            block94: {
                                                                                                                rs_0 rs_019;
                                                                                                                block90: {
                                                                                                                    Object object11;
                                                                                                                    rs_0 rs_020;
                                                                                                                    block92: {
                                                                                                                        block91: {
                                                                                                                            rs_0 rs_021;
                                                                                                                            block87: {
                                                                                                                                Object object12;
                                                                                                                                rs_0 rs_022;
                                                                                                                                block89: {
                                                                                                                                    block88: {
                                                                                                                                        rs_0 rs_023;
                                                                                                                                        block84: {
                                                                                                                                            Object object13;
                                                                                                                                            rs_0 rs_024;
                                                                                                                                            block86: {
                                                                                                                                                block85: {
                                                                                                                                                    rs_0 rs_025;
                                                                                                                                                    block48: {
                                                                                                                                                        Object object14;
                                                                                                                                                        rs_0 rs_026;
                                                                                                                                                        block83: {
                                                                                                                                                            block82: {
                                                                                                                                                                rs_0 rs_027;
                                                                                                                                                                block79: {
                                                                                                                                                                    Object object15;
                                                                                                                                                                    rs_0 rs_028;
                                                                                                                                                                    block81: {
                                                                                                                                                                        block80: {
                                                                                                                                                                            rs_0 rs_029;
                                                                                                                                                                            block76: {
                                                                                                                                                                                Object object16;
                                                                                                                                                                                rs_0 rs_030;
                                                                                                                                                                                block78: {
                                                                                                                                                                                    block77: {
                                                                                                                                                                                        rs_0 rs_031;
                                                                                                                                                                                        block73: {
                                                                                                                                                                                            Object object17;
                                                                                                                                                                                            rs_0 rs_032;
                                                                                                                                                                                            block75: {
                                                                                                                                                                                                block74: {
                                                                                                                                                                                                    rs_0 rs_033;
                                                                                                                                                                                                    block70: {
                                                                                                                                                                                                        Object object18;
                                                                                                                                                                                                        rs_0 rs_034;
                                                                                                                                                                                                        block72: {
                                                                                                                                                                                                            block71: {
                                                                                                                                                                                                                rs_0 rs_035;
                                                                                                                                                                                                                block67: {
                                                                                                                                                                                                                    Object object19;
                                                                                                                                                                                                                    rs_0 rs_036;
                                                                                                                                                                                                                    block69: {
                                                                                                                                                                                                                        block68: {
                                                                                                                                                                                                                            rs_0 rs_037;
                                                                                                                                                                                                                            block64: {
                                                                                                                                                                                                                                Object object20;
                                                                                                                                                                                                                                rs_0 rs_038;
                                                                                                                                                                                                                                block66: {
                                                                                                                                                                                                                                    block65: {
                                                                                                                                                                                                                                        rs_0 rs_039;
                                                                                                                                                                                                                                        block61: {
                                                                                                                                                                                                                                            Object object21;
                                                                                                                                                                                                                                            rs_0 rs_040;
                                                                                                                                                                                                                                            block63: {
                                                                                                                                                                                                                                                block62: {
                                                                                                                                                                                                                                                    rs_0 rs_041;
                                                                                                                                                                                                                                                    block58: {
                                                                                                                                                                                                                                                        Object object22;
                                                                                                                                                                                                                                                        rs_0 rs_042;
                                                                                                                                                                                                                                                        block60: {
                                                                                                                                                                                                                                                            block59: {
                                                                                                                                                                                                                                                                rs_0 rs_043;
                                                                                                                                                                                                                                                                block55: {
                                                                                                                                                                                                                                                                    Object object23;
                                                                                                                                                                                                                                                                    rs_0 rs_044;
                                                                                                                                                                                                                                                                    block57: {
                                                                                                                                                                                                                                                                        block56: {
                                                                                                                                                                                                                                                                            rs_0 rs_045;
                                                                                                                                                                                                                                                                            block52: {
                                                                                                                                                                                                                                                                                Object object24;
                                                                                                                                                                                                                                                                                rs_0 rs_046;
                                                                                                                                                                                                                                                                                block54: {
                                                                                                                                                                                                                                                                                    block53: {
                                                                                                                                                                                                                                                                                        rs_0 rs_047;
                                                                                                                                                                                                                                                                                        block49: {
                                                                                                                                                                                                                                                                                            Object object25;
                                                                                                                                                                                                                                                                                            rs_0 rs_048;
                                                                                                                                                                                                                                                                                            block51: {
                                                                                                                                                                                                                                                                                                block50: {
                                                                                                                                                                                                                                                                                                    rs_0 rs_049;
                                                                                                                                                                                                                                                                                                    if (n2 != rl_0.VECTOR_OPERATOR$59e4743c) break block48;
                                                                                                                                                                                                                                                                                                    if (object != rm_0.a) break block49;
                                                                                                                                                                                                                                                                                                    object = this.a(rs_0.f);
                                                                                                                                                                                                                                                                                                    rs_048 = this.b(rs_0.b);
                                                                                                                                                                                                                                                                                                    object25 = rs_048;
                                                                                                                                                                                                                                                                                                    if (rs_048.k < -0.9999999999) break block50;
                                                                                                                                                                                                                                                                                                    object25 = rs_048;
                                                                                                                                                                                                                                                                                                    if (!(rs_049.k > 0.9999999999)) break block51;
                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                throw new rb_0(true);
                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                            double[] dArray = new double[3];
                                                                                                                                                                                                                                                                                            Object object26 = object;
                                                                                                                                                                                                                                                                                            object25 = object26;
                                                                                                                                                                                                                                                                                            object25 = object;
                                                                                                                                                                                                                                                                                            dArray[0] = BY.b(-((rs_0)object26).j, ((rs_0)object25).k);
                                                                                                                                                                                                                                                                                            object25 = rs_048;
                                                                                                                                                                                                                                                                                            dArray[1] = BY.r(((rs_0)object25).k);
                                                                                                                                                                                                                                                                                            rs_0 rs_050 = rs_048;
                                                                                                                                                                                                                                                                                            object25 = rs_050;
                                                                                                                                                                                                                                                                                            object25 = rs_048;
                                                                                                                                                                                                                                                                                            dArray[2] = BY.b(-rs_050.j, ((rs_0)object25).i);
                                                                                                                                                                                                                                                                                            return dArray;
                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                        if (object != rm_0.b) break block52;
                                                                                                                                                                                                                                                                                        object = this.a(rs_0.d);
                                                                                                                                                                                                                                                                                        rs_046 = this.b(rs_0.b);
                                                                                                                                                                                                                                                                                        object24 = rs_046;
                                                                                                                                                                                                                                                                                        if (rs_046.j < -0.9999999999) break block53;
                                                                                                                                                                                                                                                                                        object24 = rs_046;
                                                                                                                                                                                                                                                                                        if (!(rs_047.j > 0.9999999999)) break block54;
                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                    throw new rb_0(true);
                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                double[] dArray = new double[3];
                                                                                                                                                                                                                                                                                Object object27 = object;
                                                                                                                                                                                                                                                                                object24 = object27;
                                                                                                                                                                                                                                                                                object24 = object;
                                                                                                                                                                                                                                                                                dArray[0] = BY.b(((rs_0)object27).k, ((rs_0)object24).j);
                                                                                                                                                                                                                                                                                object24 = rs_046;
                                                                                                                                                                                                                                                                                dArray[1] = -BY.r(((rs_0)object24).j);
                                                                                                                                                                                                                                                                                rs_0 rs_051 = rs_046;
                                                                                                                                                                                                                                                                                object24 = rs_051;
                                                                                                                                                                                                                                                                                object24 = rs_046;
                                                                                                                                                                                                                                                                                dArray[2] = BY.b(rs_051.k, ((rs_0)object24).i);
                                                                                                                                                                                                                                                                                return dArray;
                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                            if (object != rm_0.c) break block55;
                                                                                                                                                                                                                                                                            object = this.a(rs_0.f);
                                                                                                                                                                                                                                                                            rs_044 = this.b(rs_0.d);
                                                                                                                                                                                                                                                                            object23 = rs_044;
                                                                                                                                                                                                                                                                            if (rs_044.k < -0.9999999999) break block56;
                                                                                                                                                                                                                                                                            object23 = rs_044;
                                                                                                                                                                                                                                                                            if (!(rs_045.k > 0.9999999999)) break block57;
                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                        throw new rb_0(true);
                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                    double[] dArray = new double[3];
                                                                                                                                                                                                                                                                    Object object28 = object;
                                                                                                                                                                                                                                                                    object23 = object28;
                                                                                                                                                                                                                                                                    object23 = object;
                                                                                                                                                                                                                                                                    dArray[0] = BY.b(((rs_0)object28).i, ((rs_0)object23).k);
                                                                                                                                                                                                                                                                    object23 = rs_044;
                                                                                                                                                                                                                                                                    dArray[1] = -BY.r(((rs_0)object23).k);
                                                                                                                                                                                                                                                                    rs_0 rs_052 = rs_044;
                                                                                                                                                                                                                                                                    object23 = rs_052;
                                                                                                                                                                                                                                                                    object23 = rs_044;
                                                                                                                                                                                                                                                                    dArray[2] = BY.b(rs_052.i, ((rs_0)object23).j);
                                                                                                                                                                                                                                                                    return dArray;
                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                if (object != rm_0.d) break block58;
                                                                                                                                                                                                                                                                object = this.a(rs_0.b);
                                                                                                                                                                                                                                                                rs_042 = this.b(rs_0.d);
                                                                                                                                                                                                                                                                object22 = rs_042;
                                                                                                                                                                                                                                                                if (rs_042.i < -0.9999999999) break block59;
                                                                                                                                                                                                                                                                object22 = rs_042;
                                                                                                                                                                                                                                                                if (!(rs_043.i > 0.9999999999)) break block60;
                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                            throw new rb_0(true);
                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                        double[] dArray = new double[3];
                                                                                                                                                                                                                                                        Object object29 = object;
                                                                                                                                                                                                                                                        object22 = object29;
                                                                                                                                                                                                                                                        object22 = object;
                                                                                                                                                                                                                                                        dArray[0] = BY.b(-((rs_0)object29).k, ((rs_0)object22).i);
                                                                                                                                                                                                                                                        object22 = rs_042;
                                                                                                                                                                                                                                                        dArray[1] = BY.r(((rs_0)object22).i);
                                                                                                                                                                                                                                                        rs_0 rs_053 = rs_042;
                                                                                                                                                                                                                                                        object22 = rs_053;
                                                                                                                                                                                                                                                        object22 = rs_042;
                                                                                                                                                                                                                                                        dArray[2] = BY.b(-rs_053.k, ((rs_0)object22).j);
                                                                                                                                                                                                                                                        return dArray;
                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                    if (object != rm_0.e) break block61;
                                                                                                                                                                                                                                                    object = this.a(rs_0.d);
                                                                                                                                                                                                                                                    rs_040 = this.b(rs_0.f);
                                                                                                                                                                                                                                                    object21 = rs_040;
                                                                                                                                                                                                                                                    if (rs_040.j < -0.9999999999) break block62;
                                                                                                                                                                                                                                                    object21 = rs_040;
                                                                                                                                                                                                                                                    if (!(rs_041.j > 0.9999999999)) break block63;
                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                throw new rb_0(true);
                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                            double[] dArray = new double[3];
                                                                                                                                                                                                                                            Object object30 = object;
                                                                                                                                                                                                                                            object21 = object30;
                                                                                                                                                                                                                                            object21 = object;
                                                                                                                                                                                                                                            dArray[0] = BY.b(-((rs_0)object30).i, ((rs_0)object21).j);
                                                                                                                                                                                                                                            object21 = rs_040;
                                                                                                                                                                                                                                            dArray[1] = BY.r(((rs_0)object21).j);
                                                                                                                                                                                                                                            rs_0 rs_054 = rs_040;
                                                                                                                                                                                                                                            object21 = rs_054;
                                                                                                                                                                                                                                            object21 = rs_040;
                                                                                                                                                                                                                                            dArray[2] = BY.b(-rs_054.i, ((rs_0)object21).k);
                                                                                                                                                                                                                                            return dArray;
                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                        if (object != rm_0.f) break block64;
                                                                                                                                                                                                                                        object = this.a(rs_0.b);
                                                                                                                                                                                                                                        rs_038 = this.b(rs_0.f);
                                                                                                                                                                                                                                        object20 = rs_038;
                                                                                                                                                                                                                                        if (rs_038.i < -0.9999999999) break block65;
                                                                                                                                                                                                                                        object20 = rs_038;
                                                                                                                                                                                                                                        if (!(rs_039.i > 0.9999999999)) break block66;
                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                    throw new rb_0(true);
                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                double[] dArray = new double[3];
                                                                                                                                                                                                                                Object object31 = object;
                                                                                                                                                                                                                                object20 = object31;
                                                                                                                                                                                                                                object20 = object;
                                                                                                                                                                                                                                dArray[0] = BY.b(((rs_0)object31).j, ((rs_0)object20).i);
                                                                                                                                                                                                                                object20 = rs_038;
                                                                                                                                                                                                                                dArray[1] = -BY.r(((rs_0)object20).i);
                                                                                                                                                                                                                                rs_0 rs_055 = rs_038;
                                                                                                                                                                                                                                object20 = rs_055;
                                                                                                                                                                                                                                object20 = rs_038;
                                                                                                                                                                                                                                dArray[2] = BY.b(rs_055.j, ((rs_0)object20).k);
                                                                                                                                                                                                                                return dArray;
                                                                                                                                                                                                                            }
                                                                                                                                                                                                                            if (object != rm_0.g) break block67;
                                                                                                                                                                                                                            object = this.a(rs_0.b);
                                                                                                                                                                                                                            rs_036 = this.b(rs_0.b);
                                                                                                                                                                                                                            object19 = rs_036;
                                                                                                                                                                                                                            if (rs_036.i < -0.9999999999) break block68;
                                                                                                                                                                                                                            object19 = rs_036;
                                                                                                                                                                                                                            if (!(rs_037.i > 0.9999999999)) break block69;
                                                                                                                                                                                                                        }
                                                                                                                                                                                                                        throw new rb_0(false);
                                                                                                                                                                                                                    }
                                                                                                                                                                                                                    double[] dArray = new double[3];
                                                                                                                                                                                                                    Object object32 = object;
                                                                                                                                                                                                                    object19 = object32;
                                                                                                                                                                                                                    object19 = object;
                                                                                                                                                                                                                    dArray[0] = BY.b(((rs_0)object32).j, -((rs_0)object19).k);
                                                                                                                                                                                                                    object19 = rs_036;
                                                                                                                                                                                                                    dArray[1] = BY.s(((rs_0)object19).i);
                                                                                                                                                                                                                    rs_0 rs_056 = rs_036;
                                                                                                                                                                                                                    object19 = rs_056;
                                                                                                                                                                                                                    object19 = rs_036;
                                                                                                                                                                                                                    dArray[2] = BY.b(rs_056.j, ((rs_0)object19).k);
                                                                                                                                                                                                                    return dArray;
                                                                                                                                                                                                                }
                                                                                                                                                                                                                if (object != rm_0.h) break block70;
                                                                                                                                                                                                                object = this.a(rs_0.b);
                                                                                                                                                                                                                rs_034 = this.b(rs_0.b);
                                                                                                                                                                                                                object18 = rs_034;
                                                                                                                                                                                                                if (rs_034.i < -0.9999999999) break block71;
                                                                                                                                                                                                                object18 = rs_034;
                                                                                                                                                                                                                if (!(rs_035.i > 0.9999999999)) break block72;
                                                                                                                                                                                                            }
                                                                                                                                                                                                            throw new rb_0(false);
                                                                                                                                                                                                        }
                                                                                                                                                                                                        double[] dArray = new double[3];
                                                                                                                                                                                                        Object object33 = object;
                                                                                                                                                                                                        object18 = object33;
                                                                                                                                                                                                        object18 = object;
                                                                                                                                                                                                        dArray[0] = BY.b(((rs_0)object33).k, ((rs_0)object18).j);
                                                                                                                                                                                                        object18 = rs_034;
                                                                                                                                                                                                        dArray[1] = BY.s(((rs_0)object18).i);
                                                                                                                                                                                                        rs_0 rs_057 = rs_034;
                                                                                                                                                                                                        object18 = rs_057;
                                                                                                                                                                                                        object18 = rs_034;
                                                                                                                                                                                                        dArray[2] = BY.b(rs_057.k, -((rs_0)object18).j);
                                                                                                                                                                                                        return dArray;
                                                                                                                                                                                                    }
                                                                                                                                                                                                    if (object != rm_0.i) break block73;
                                                                                                                                                                                                    object = this.a(rs_0.d);
                                                                                                                                                                                                    rs_032 = this.b(rs_0.d);
                                                                                                                                                                                                    object17 = rs_032;
                                                                                                                                                                                                    if (rs_032.j < -0.9999999999) break block74;
                                                                                                                                                                                                    object17 = rs_032;
                                                                                                                                                                                                    if (!(rs_033.j > 0.9999999999)) break block75;
                                                                                                                                                                                                }
                                                                                                                                                                                                throw new rb_0(false);
                                                                                                                                                                                            }
                                                                                                                                                                                            double[] dArray = new double[3];
                                                                                                                                                                                            Object object34 = object;
                                                                                                                                                                                            object17 = object34;
                                                                                                                                                                                            object17 = object;
                                                                                                                                                                                            dArray[0] = BY.b(((rs_0)object34).i, ((rs_0)object17).k);
                                                                                                                                                                                            object17 = rs_032;
                                                                                                                                                                                            dArray[1] = BY.s(((rs_0)object17).j);
                                                                                                                                                                                            rs_0 rs_058 = rs_032;
                                                                                                                                                                                            object17 = rs_058;
                                                                                                                                                                                            object17 = rs_032;
                                                                                                                                                                                            dArray[2] = BY.b(rs_058.i, -((rs_0)object17).k);
                                                                                                                                                                                            return dArray;
                                                                                                                                                                                        }
                                                                                                                                                                                        if (object != rm_0.j) break block76;
                                                                                                                                                                                        object = this.a(rs_0.d);
                                                                                                                                                                                        rs_030 = this.b(rs_0.d);
                                                                                                                                                                                        object16 = rs_030;
                                                                                                                                                                                        if (rs_030.j < -0.9999999999) break block77;
                                                                                                                                                                                        object16 = rs_030;
                                                                                                                                                                                        if (!(rs_031.j > 0.9999999999)) break block78;
                                                                                                                                                                                    }
                                                                                                                                                                                    throw new rb_0(false);
                                                                                                                                                                                }
                                                                                                                                                                                double[] dArray = new double[3];
                                                                                                                                                                                Object object35 = object;
                                                                                                                                                                                object16 = object35;
                                                                                                                                                                                object16 = object;
                                                                                                                                                                                dArray[0] = BY.b(((rs_0)object35).k, -((rs_0)object16).i);
                                                                                                                                                                                object16 = rs_030;
                                                                                                                                                                                dArray[1] = BY.s(((rs_0)object16).j);
                                                                                                                                                                                rs_0 rs_059 = rs_030;
                                                                                                                                                                                object16 = rs_059;
                                                                                                                                                                                object16 = rs_030;
                                                                                                                                                                                dArray[2] = BY.b(rs_059.k, ((rs_0)object16).i);
                                                                                                                                                                                return dArray;
                                                                                                                                                                            }
                                                                                                                                                                            if (object != rm_0.k) break block79;
                                                                                                                                                                            object = this.a(rs_0.f);
                                                                                                                                                                            rs_028 = this.b(rs_0.f);
                                                                                                                                                                            object15 = rs_028;
                                                                                                                                                                            if (rs_028.k < -0.9999999999) break block80;
                                                                                                                                                                            object15 = rs_028;
                                                                                                                                                                            if (!(rs_029.k > 0.9999999999)) break block81;
                                                                                                                                                                        }
                                                                                                                                                                        throw new rb_0(false);
                                                                                                                                                                    }
                                                                                                                                                                    double[] dArray = new double[3];
                                                                                                                                                                    Object object36 = object;
                                                                                                                                                                    object15 = object36;
                                                                                                                                                                    object15 = object;
                                                                                                                                                                    dArray[0] = BY.b(((rs_0)object36).i, -((rs_0)object15).j);
                                                                                                                                                                    object15 = rs_028;
                                                                                                                                                                    dArray[1] = BY.s(((rs_0)object15).k);
                                                                                                                                                                    rs_0 rs_060 = rs_028;
                                                                                                                                                                    object15 = rs_060;
                                                                                                                                                                    object15 = rs_028;
                                                                                                                                                                    dArray[2] = BY.b(rs_060.i, ((rs_0)object15).j);
                                                                                                                                                                    return dArray;
                                                                                                                                                                }
                                                                                                                                                                object = this.a(rs_0.f);
                                                                                                                                                                rs_026 = this.b(rs_0.f);
                                                                                                                                                                object14 = rs_026;
                                                                                                                                                                if (rs_026.k < -0.9999999999) break block82;
                                                                                                                                                                object14 = rs_026;
                                                                                                                                                                if (!(rs_027.k > 0.9999999999)) break block83;
                                                                                                                                                            }
                                                                                                                                                            throw new rb_0(false);
                                                                                                                                                        }
                                                                                                                                                        double[] dArray = new double[3];
                                                                                                                                                        Object object37 = object;
                                                                                                                                                        object14 = object37;
                                                                                                                                                        object14 = object;
                                                                                                                                                        dArray[0] = BY.b(((rs_0)object37).j, ((rs_0)object14).i);
                                                                                                                                                        object14 = rs_026;
                                                                                                                                                        dArray[1] = BY.s(((rs_0)object14).k);
                                                                                                                                                        rs_0 rs_061 = rs_026;
                                                                                                                                                        object14 = rs_061;
                                                                                                                                                        object14 = rs_026;
                                                                                                                                                        dArray[2] = BY.b(rs_061.j, -((rs_0)object14).i);
                                                                                                                                                        return dArray;
                                                                                                                                                    }
                                                                                                                                                    if (object != rm_0.a) break block84;
                                                                                                                                                    object = this.a(rs_0.b);
                                                                                                                                                    rs_024 = this.b(rs_0.f);
                                                                                                                                                    object13 = rs_024;
                                                                                                                                                    if (rs_024.i < -0.9999999999) break block85;
                                                                                                                                                    object13 = rs_024;
                                                                                                                                                    if (!(rs_025.i > 0.9999999999)) break block86;
                                                                                                                                                }
                                                                                                                                                throw new rb_0(true);
                                                                                                                                            }
                                                                                                                                            double[] dArray = new double[3];
                                                                                                                                            rs_0 rs_062 = rs_024;
                                                                                                                                            object13 = rs_062;
                                                                                                                                            object13 = rs_024;
                                                                                                                                            dArray[0] = BY.b(-rs_062.j, ((rs_0)object13).k);
                                                                                                                                            object13 = rs_024;
                                                                                                                                            dArray[1] = BY.r(((rs_0)object13).i);
                                                                                                                                            Object object38 = object;
                                                                                                                                            object13 = object38;
                                                                                                                                            object13 = object;
                                                                                                                                            dArray[2] = BY.b(-((rs_0)object38).j, ((rs_0)object13).i);
                                                                                                                                            return dArray;
                                                                                                                                        }
                                                                                                                                        if (object != rm_0.b) break block87;
                                                                                                                                        object = this.a(rs_0.b);
                                                                                                                                        rs_022 = this.b(rs_0.d);
                                                                                                                                        object12 = rs_022;
                                                                                                                                        if (rs_022.i < -0.9999999999) break block88;
                                                                                                                                        object12 = rs_022;
                                                                                                                                        if (!(rs_023.i > 0.9999999999)) break block89;
                                                                                                                                    }
                                                                                                                                    throw new rb_0(true);
                                                                                                                                }
                                                                                                                                double[] dArray = new double[3];
                                                                                                                                rs_0 rs_063 = rs_022;
                                                                                                                                object12 = rs_063;
                                                                                                                                object12 = rs_022;
                                                                                                                                dArray[0] = BY.b(rs_063.k, ((rs_0)object12).j);
                                                                                                                                object12 = rs_022;
                                                                                                                                dArray[1] = -BY.r(((rs_0)object12).i);
                                                                                                                                Object object39 = object;
                                                                                                                                object12 = object39;
                                                                                                                                object12 = object;
                                                                                                                                dArray[2] = BY.b(((rs_0)object39).k, ((rs_0)object12).i);
                                                                                                                                return dArray;
                                                                                                                            }
                                                                                                                            if (object != rm_0.c) break block90;
                                                                                                                            object = this.a(rs_0.d);
                                                                                                                            rs_020 = this.b(rs_0.f);
                                                                                                                            object11 = rs_020;
                                                                                                                            if (rs_020.j < -0.9999999999) break block91;
                                                                                                                            object11 = rs_020;
                                                                                                                            if (!(rs_021.j > 0.9999999999)) break block92;
                                                                                                                        }
                                                                                                                        throw new rb_0(true);
                                                                                                                    }
                                                                                                                    double[] dArray = new double[3];
                                                                                                                    rs_0 rs_064 = rs_020;
                                                                                                                    object11 = rs_064;
                                                                                                                    object11 = rs_020;
                                                                                                                    dArray[0] = BY.b(rs_064.i, ((rs_0)object11).k);
                                                                                                                    object11 = rs_020;
                                                                                                                    dArray[1] = -BY.r(((rs_0)object11).j);
                                                                                                                    Object object40 = object;
                                                                                                                    object11 = object40;
                                                                                                                    object11 = object;
                                                                                                                    dArray[2] = BY.b(((rs_0)object40).i, ((rs_0)object11).j);
                                                                                                                    return dArray;
                                                                                                                }
                                                                                                                if (object != rm_0.d) break block93;
                                                                                                                object = this.a(rs_0.d);
                                                                                                                rs_018 = this.b(rs_0.b);
                                                                                                                object10 = rs_018;
                                                                                                                if (rs_018.j < -0.9999999999) break block94;
                                                                                                                object10 = rs_018;
                                                                                                                if (!(rs_019.j > 0.9999999999)) break block95;
                                                                                                            }
                                                                                                            throw new rb_0(true);
                                                                                                        }
                                                                                                        double[] dArray = new double[3];
                                                                                                        rs_0 rs_065 = rs_018;
                                                                                                        object10 = rs_065;
                                                                                                        object10 = rs_018;
                                                                                                        dArray[0] = BY.b(-rs_065.k, ((rs_0)object10).i);
                                                                                                        object10 = rs_018;
                                                                                                        dArray[1] = BY.r(((rs_0)object10).j);
                                                                                                        Object object41 = object;
                                                                                                        object10 = object41;
                                                                                                        object10 = object;
                                                                                                        dArray[2] = BY.b(-((rs_0)object41).k, ((rs_0)object10).j);
                                                                                                        return dArray;
                                                                                                    }
                                                                                                    if (object != rm_0.e) break block96;
                                                                                                    object = this.a(rs_0.f);
                                                                                                    rs_016 = this.b(rs_0.d);
                                                                                                    object9 = rs_016;
                                                                                                    if (rs_016.k < -0.9999999999) break block97;
                                                                                                    object9 = rs_016;
                                                                                                    if (!(rs_017.k > 0.9999999999)) break block98;
                                                                                                }
                                                                                                throw new rb_0(true);
                                                                                            }
                                                                                            double[] dArray = new double[3];
                                                                                            rs_0 rs_066 = rs_016;
                                                                                            object9 = rs_066;
                                                                                            object9 = rs_016;
                                                                                            dArray[0] = BY.b(-rs_066.i, ((rs_0)object9).j);
                                                                                            object9 = rs_016;
                                                                                            dArray[1] = BY.r(((rs_0)object9).k);
                                                                                            Object object42 = object;
                                                                                            object9 = object42;
                                                                                            object9 = object;
                                                                                            dArray[2] = BY.b(-((rs_0)object42).i, ((rs_0)object9).k);
                                                                                            return dArray;
                                                                                        }
                                                                                        if (object != rm_0.f) break block99;
                                                                                        object = this.a(rs_0.f);
                                                                                        rs_014 = this.b(rs_0.b);
                                                                                        object8 = rs_014;
                                                                                        if (rs_014.k < -0.9999999999) break block100;
                                                                                        object8 = rs_014;
                                                                                        if (!(rs_015.k > 0.9999999999)) break block101;
                                                                                    }
                                                                                    throw new rb_0(true);
                                                                                }
                                                                                double[] dArray = new double[3];
                                                                                rs_0 rs_067 = rs_014;
                                                                                object8 = rs_067;
                                                                                object8 = rs_014;
                                                                                dArray[0] = BY.b(rs_067.j, ((rs_0)object8).i);
                                                                                object8 = rs_014;
                                                                                dArray[1] = -BY.r(((rs_0)object8).k);
                                                                                Object object43 = object;
                                                                                object8 = object43;
                                                                                object8 = object;
                                                                                dArray[2] = BY.b(((rs_0)object43).j, ((rs_0)object8).k);
                                                                                return dArray;
                                                                            }
                                                                            if (object != rm_0.g) break block102;
                                                                            object = this.a(rs_0.b);
                                                                            rs_012 = this.b(rs_0.b);
                                                                            object7 = rs_012;
                                                                            if (rs_012.i < -0.9999999999) break block103;
                                                                            object7 = rs_012;
                                                                            if (!(rs_013.i > 0.9999999999)) break block104;
                                                                        }
                                                                        throw new rb_0(false);
                                                                    }
                                                                    double[] dArray = new double[3];
                                                                    rs_0 rs_068 = rs_012;
                                                                    object7 = rs_068;
                                                                    object7 = rs_012;
                                                                    dArray[0] = BY.b(rs_068.j, -((rs_0)object7).k);
                                                                    object7 = rs_012;
                                                                    dArray[1] = BY.s(((rs_0)object7).i);
                                                                    Object object44 = object;
                                                                    object7 = object44;
                                                                    object7 = object;
                                                                    dArray[2] = BY.b(((rs_0)object44).j, ((rs_0)object7).k);
                                                                    return dArray;
                                                                }
                                                                if (object != rm_0.h) break block105;
                                                                object = this.a(rs_0.b);
                                                                rs_010 = this.b(rs_0.b);
                                                                object6 = rs_010;
                                                                if (rs_010.i < -0.9999999999) break block106;
                                                                object6 = rs_010;
                                                                if (!(rs_011.i > 0.9999999999)) break block107;
                                                            }
                                                            throw new rb_0(false);
                                                        }
                                                        double[] dArray = new double[3];
                                                        rs_0 rs_069 = rs_010;
                                                        object6 = rs_069;
                                                        object6 = rs_010;
                                                        dArray[0] = BY.b(rs_069.k, ((rs_0)object6).j);
                                                        object6 = rs_010;
                                                        dArray[1] = BY.s(((rs_0)object6).i);
                                                        Object object45 = object;
                                                        object6 = object45;
                                                        object6 = object;
                                                        dArray[2] = BY.b(((rs_0)object45).k, -((rs_0)object6).j);
                                                        return dArray;
                                                    }
                                                    if (object != rm_0.i) break block108;
                                                    object = this.a(rs_0.d);
                                                    rs_08 = this.b(rs_0.d);
                                                    object5 = rs_08;
                                                    if (rs_08.j < -0.9999999999) break block109;
                                                    object5 = rs_08;
                                                    if (!(rs_09.j > 0.9999999999)) break block110;
                                                }
                                                throw new rb_0(false);
                                            }
                                            double[] dArray = new double[3];
                                            rs_0 rs_070 = rs_08;
                                            object5 = rs_070;
                                            object5 = rs_08;
                                            dArray[0] = BY.b(rs_070.i, ((rs_0)object5).k);
                                            object5 = rs_08;
                                            dArray[1] = BY.s(((rs_0)object5).j);
                                            Object object46 = object;
                                            object5 = object46;
                                            object5 = object;
                                            dArray[2] = BY.b(((rs_0)object46).i, -((rs_0)object5).k);
                                            return dArray;
                                        }
                                        if (object != rm_0.j) break block111;
                                        object = this.a(rs_0.d);
                                        rs_06 = this.b(rs_0.d);
                                        object4 = rs_06;
                                        if (rs_06.j < -0.9999999999) break block112;
                                        object4 = rs_06;
                                        if (!(rs_07.j > 0.9999999999)) break block113;
                                    }
                                    throw new rb_0(false);
                                }
                                double[] dArray = new double[3];
                                rs_0 rs_071 = rs_06;
                                object4 = rs_071;
                                object4 = rs_06;
                                dArray[0] = BY.b(rs_071.k, -((rs_0)object4).i);
                                object4 = rs_06;
                                dArray[1] = BY.s(((rs_0)object4).j);
                                Object object47 = object;
                                object4 = object47;
                                object4 = object;
                                dArray[2] = BY.b(((rs_0)object47).k, ((rs_0)object4).i);
                                return dArray;
                            }
                            if (object != rm_0.k) break block114;
                            object = this.a(rs_0.f);
                            rs_04 = this.b(rs_0.f);
                            object3 = rs_04;
                            if (rs_04.k < -0.9999999999) break block115;
                            object3 = rs_04;
                            if (!(rs_05.k > 0.9999999999)) break block116;
                        }
                        throw new rb_0(false);
                    }
                    double[] dArray = new double[3];
                    rs_0 rs_072 = rs_04;
                    object3 = rs_072;
                    object3 = rs_04;
                    dArray[0] = BY.b(rs_072.i, -((rs_0)object3).j);
                    object3 = rs_04;
                    dArray[1] = BY.s(((rs_0)object3).k);
                    Object object48 = object;
                    object3 = object48;
                    object3 = object;
                    dArray[2] = BY.b(((rs_0)object48).i, ((rs_0)object3).j);
                    return dArray;
                }
                object = this.a(rs_0.f);
                rs_02 = this.b(rs_0.f);
                object2 = rs_02;
                if (rs_02.k < -0.9999999999) break block117;
                object2 = rs_02;
                if (!(rs_03.k > 0.9999999999)) break block118;
            }
            throw new rb_0(false);
        }
        double[] dArray = new double[3];
        rs_0 rs_073 = rs_02;
        object2 = rs_073;
        object2 = rs_02;
        dArray[0] = BY.b(rs_073.j, ((rs_0)object2).i);
        object2 = rs_02;
        dArray[1] = BY.s(((rs_0)object2).k);
        Object object49 = object;
        object2 = object49;
        object2 = object;
        dArray[2] = BY.b(((rs_0)object49).j, -((rs_0)object2).i);
        return dArray;
    }

    private double[][] h() {
        double d2 = this.a * this.a;
        double d3 = this.a * this.b;
        double d4 = this.a * this.c;
        double d5 = this.a * this.d;
        double d6 = this.b * this.b;
        double d7 = this.b * this.c;
        double d8 = this.b * this.d;
        double d9 = this.c * this.c;
        double d10 = this.c * this.d;
        double d11 = this.d * this.d;
        double[][] dArrayArray = new double[3][];
        double[][] dArrayArray2 = dArrayArray;
        dArrayArray[0] = new double[3];
        dArrayArray2[1] = new double[3];
        dArrayArray2[2] = new double[3];
        dArrayArray2[0][0] = 2.0 * (d2 + d6) - 1.0;
        dArrayArray2[1][0] = 2.0 * (d7 - d5);
        dArrayArray2[2][0] = 2.0 * (d8 + d4);
        dArrayArray2[0][1] = 2.0 * (d7 + d5);
        dArrayArray2[1][1] = 2.0 * (d2 + d9) - 1.0;
        dArrayArray2[2][1] = 2.0 * (d10 - d3);
        dArrayArray2[0][2] = 2.0 * (d8 - d4);
        dArrayArray2[1][2] = 2.0 * (d10 + d3);
        dArrayArray2[2][2] = 2.0 * (d2 + d11) - 1.0;
        return dArrayArray2;
    }

    public final rs_0 a(rs_0 rs_02) {
        rs_0 rs_03 = rs_02;
        double d2 = rs_03.i;
        rs_03 = rs_02;
        double d3 = rs_03.j;
        rs_03 = rs_02;
        double d4 = rs_03.k;
        double d5 = this.b * d2 + this.c * d3 + this.d * d4;
        return new rs_0(2.0 * (this.a * (d2 * this.a - (this.c * d4 - this.d * d3)) + d5 * this.b) - d2, 2.0 * (this.a * (d3 * this.a - (this.d * d2 - this.b * d4)) + d5 * this.c) - d3, 2.0 * (this.a * (d4 * this.a - (this.b * d3 - this.c * d2)) + d5 * this.d) - d4);
    }

    private void a(double[] dArray, double[] dArray2) {
        double d2 = dArray[0];
        double d3 = dArray[1];
        double d4 = dArray[2];
        double d5 = this.b * d2 + this.c * d3 + this.d * d4;
        dArray2[0] = 2.0 * (this.a * (d2 * this.a - (this.c * d4 - this.d * d3)) + d5 * this.b) - d2;
        dArray2[1] = 2.0 * (this.a * (d3 * this.a - (this.d * d2 - this.b * d4)) + d5 * this.c) - d3;
        dArray2[2] = 2.0 * (this.a * (d4 * this.a - (this.b * d3 - this.c * d2)) + d5 * this.d) - d4;
    }

    private rs_0 b(rs_0 rs_02) {
        rs_0 rs_03 = rs_02;
        double d2 = rs_03.i;
        rs_03 = rs_02;
        double d3 = rs_03.j;
        rs_03 = rs_02;
        double d4 = rs_03.k;
        double d5 = this.b * d2 + this.c * d3 + this.d * d4;
        double d6 = -this.a;
        return new rs_0(2.0 * (d6 * (d2 * d6 - (this.c * d4 - this.d * d3)) + d5 * this.b) - d2, 2.0 * (d6 * (d3 * d6 - (this.d * d2 - this.b * d4)) + d5 * this.c) - d3, 2.0 * (d6 * (d4 * d6 - (this.b * d3 - this.c * d2)) + d5 * this.d) - d4);
    }

    private void b(double[] dArray, double[] dArray2) {
        double d2 = dArray[0];
        double d3 = dArray[1];
        double d4 = dArray[2];
        double d5 = this.b * d2 + this.c * d3 + this.d * d4;
        double d6 = -this.a;
        dArray2[0] = 2.0 * (d6 * (d2 * d6 - (this.c * d4 - this.d * d3)) + d5 * this.b) - d2;
        dArray2[1] = 2.0 * (d6 * (d3 * d6 - (this.d * d2 - this.b * d4)) + d5 * this.c) - d3;
        dArray2[2] = 2.0 * (d6 * (d4 * d6 - (this.b * d3 - this.c * d2)) + d5 * this.d) - d4;
    }

    private rk_0 a(rk_0 rk_02) {
        return this.a(rk_02, rl_0.VECTOR_OPERATOR$59e4743c);
    }

    private rk_0 a(rk_0 rk_02, int n2) {
        if (n2 == rl_0.VECTOR_OPERATOR$59e4743c) {
            return this.b(rk_02);
        }
        return rk_02.b(this);
    }

    private rk_0 b(rk_0 rk_02) {
        return new rk_0(rk_02.a * this.a - (rk_02.b * this.b + rk_02.c * this.c + rk_02.d * this.d), rk_02.b * this.a + rk_02.a * this.b + (rk_02.c * this.d - rk_02.d * this.c), rk_02.c * this.a + rk_02.a * this.c + (rk_02.d * this.b - rk_02.b * this.d), rk_02.d * this.a + rk_02.a * this.d + (rk_02.b * this.c - rk_02.c * this.b), false);
    }

    private rk_0 c(rk_0 rk_02) {
        int n2 = rl_0.VECTOR_OPERATOR$59e4743c;
        rk_0 rk_03 = rk_02;
        rk_02 = this;
        if (n2 == rl_0.VECTOR_OPERATOR$59e4743c) {
            return rk_02.d(rk_03);
        }
        return rk_03.b(new rk_0(-rk_02.a, rk_02.b, rk_02.c, rk_02.d, false));
    }

    private rk_0 b(rk_0 rk_02, int n2) {
        if (n2 == rl_0.VECTOR_OPERATOR$59e4743c) {
            return this.d(rk_02);
        }
        return rk_02.b(this.e());
    }

    private rk_0 d(rk_0 rk_02) {
        return new rk_0(-rk_02.a * this.a - (rk_02.b * this.b + rk_02.c * this.c + rk_02.d * this.d), -rk_02.b * this.a + rk_02.a * this.b + (rk_02.c * this.d - rk_02.d * this.c), -rk_02.c * this.a + rk_02.a * this.c + (rk_02.d * this.b - rk_02.b * this.d), -rk_02.d * this.a + rk_02.a * this.d + (rk_02.b * this.c - rk_02.c * this.b), false);
    }

    private static double[][] a(double[][] object, double d2) {
        double[] dArray = object[0];
        double[] dArray2 = object[1];
        object = object[2];
        double d3 = dArray[0];
        double d4 = dArray[1];
        double d5 = dArray[2];
        double d6 = dArray2[0];
        double d7 = dArray2[1];
        double d8 = dArray2[2];
        Object object2 = object[0];
        Object object3 = object[1];
        Object object4 = object[2];
        double d9 = 0.0;
        double[][] dArray3 = new double[3][3];
        double[] dArray4 = dArray3[0];
        double[] dArray5 = dArray3[1];
        double[] dArray6 = dArray3[2];
        int n2 = 0;
        while (++n2 < 11) {
            double d10;
            double d11 = dArray[0] * d3 + dArray2[0] * d6 + object[0] * object2;
            double d12 = dArray[1] * d3 + dArray2[1] * d6 + object[1] * object2;
            double d13 = dArray[2] * d3 + dArray2[2] * d6 + object[2] * object2;
            double d14 = dArray[0] * d4 + dArray2[0] * d7 + object[0] * object3;
            double d15 = dArray[1] * d4 + dArray2[1] * d7 + object[1] * object3;
            double d16 = dArray[2] * d4 + dArray2[2] * d7 + object[2] * object3;
            double d17 = dArray[0] * d5 + dArray2[0] * d8 + object[0] * object4;
            double d18 = dArray[1] * d5 + dArray2[1] * d8 + object[1] * object4;
            double d19 = dArray[2] * d5 + dArray2[2] * d8 + object[2] * object4;
            dArray4[0] = d3 - 0.5 * (d3 * d11 + d4 * d12 + d5 * d13 - dArray[0]);
            dArray4[1] = d4 - 0.5 * (d3 * d14 + d4 * d15 + d5 * d16 - dArray[1]);
            dArray4[2] = d5 - 0.5 * (d3 * d17 + d4 * d18 + d5 * d19 - dArray[2]);
            dArray5[0] = d6 - 0.5 * (d6 * d11 + d7 * d12 + d8 * d13 - dArray2[0]);
            dArray5[1] = d7 - 0.5 * (d6 * d14 + d7 * d15 + d8 * d16 - dArray2[1]);
            dArray5[2] = d8 - 0.5 * (d6 * d17 + d7 * d18 + d8 * d19 - dArray2[2]);
            dArray6[0] = (double)(object2 - 0.5 * (object2 * d11 + object3 * d12 + object4 * d13 - object[0]));
            dArray6[1] = (double)(object3 - 0.5 * (object2 * d14 + object3 * d15 + object4 * d16 - object[1]));
            dArray6[2] = (double)(object4 - 0.5 * (object2 * d17 + object3 * d18 + object4 * d19 - object[2]));
            double d20 = dArray4[0] - dArray[0];
            double d21 = dArray4[1] - dArray[1];
            double d22 = dArray4[2] - dArray[2];
            double d23 = dArray5[0] - dArray2[0];
            double d24 = dArray5[1] - dArray2[1];
            double d25 = dArray5[2] - dArray2[2];
            double d26 = dArray6[0] - object[0];
            double d27 = dArray6[1] - object[1];
            double d28 = dArray6[2] - object[2];
            double d29 = d20;
            double d30 = d21;
            double d31 = d22;
            double d32 = d23;
            double d33 = d24;
            double d34 = d25;
            double d35 = d26;
            double d36 = d27;
            double d37 = d28;
            double d38 = d29 * d29 + d30 * d30 + d31 * d31 + d32 * d32 + d33 * d33 + d34 * d34 + d35 * d35 + d36 * d36 + d37 * d37;
            if (BY.w(d10 - d9) <= d2) {
                return dArray3;
            }
            d3 = dArray4[0];
            d4 = dArray4[1];
            d5 = dArray4[2];
            d6 = dArray5[0];
            d7 = dArray5[1];
            d8 = dArray5[2];
            object2 = dArray6[0];
            object3 = dArray6[1];
            object4 = dArray6[2];
            d9 = d38;
        }
        throw new rg_0(px_0.UNABLE_TO_ORTHOGONOLIZE_MATRIX, n2 - 1);
    }

    private static double a(rk_0 rk_02, rk_0 rk_03) {
        rk_02 = rk_02.d(rk_03);
        if (rk_02.a < -0.1 || rk_02.a > 0.1) {
            return 2.0 * BY.r(BY.a(rk_02.b * rk_02.b + rk_02.c * rk_02.c + rk_02.d * rk_02.d));
        }
        if (rk_02.a < 0.0) {
            return 2.0 * BY.s(-rk_02.a);
        }
        return 2.0 * BY.s(rk_02.a);
    }

    static {
        new rk_0(1.0, 0.0, 0.0, 0.0, false);
    }
}

