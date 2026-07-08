/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.ch_0;
import org.valkyrienskies.core.impl.shadow.kM;
import org.valkyrienskies.core.impl.shadow.kO;
import org.valkyrienskies.core.impl.shadow.oU;
import org.valkyrienskies.core.impl.shadow.oV;
import org.valkyrienskies.core.impl.shadow.px_0;
import org.valkyrienskies.core.impl.shadow.rb_0;
import org.valkyrienskies.core.impl.shadow.re_0;
import org.valkyrienskies.core.impl.shadow.rg_0;
import org.valkyrienskies.core.impl.shadow.rk_0;
import org.valkyrienskies.core.impl.shadow.rl_0;
import org.valkyrienskies.core.impl.shadow.rm_0;
import org.valkyrienskies.core.impl.shadow.rs_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.rd
 */
public final class rd_0<T extends kO<T>>
implements Serializable {
    private static final long a = 20130224L;
    private final T b;
    private final T c;
    private final T d;
    private final T e;

    private rd_0(T t, T t2, T t3, T t4, boolean bl) {
        this.b = t;
        this.c = t2;
        this.d = t3;
        this.e = t4;
    }

    @Deprecated
    private rd_0(re_0<T> re_02, T t) {
        this(re_02, t, rl_0.VECTOR_OPERATOR$59e4743c);
    }

    private rd_0(re_0<T> re_02, T object, int n2) {
        T t = re_02.d();
        if (t.d() == 0.0) {
            throw new oV(px_0.ZERO_NORM_FOR_ROTATION_AXIS, new Object[0]);
        }
        object = (kO)object.c(n2 == rl_0.VECTOR_OPERATOR$59e4743c ? -0.5 : 0.5);
        kO kO2 = (kO)((kO)object.r()).d(t);
        this.b = (kO)object.q();
        object = re_02;
        this.c = (kO)kO2.c(((re_0)object).a);
        object = re_02;
        this.d = (kO)kO2.c(((re_0)object).b);
        object = re_02;
        this.e = (kO)kO2.c(((re_0)object).c);
    }

    private rd_0(T[][] object, double d2) {
        kO kO2;
        kO[][] kOArray;
        kO kO3;
        kO kO4;
        kO kO5;
        block4: {
            if (((T[][])object).length != 3 || object[0].length != 3 || object[1].length != 3 || object[2].length != 3) {
                throw new rg_0(px_0.ROTATION_MATRIX_DIMENSIONS, ((T[][])object).length, object[0].length);
            }
            double d3 = d2;
            kO5 = object[0][0];
            kO4 = object[0][1];
            kO3 = object[0][2];
            kO kO6 = object[1][0];
            kO kO7 = object[1][1];
            kO kO8 = object[1][2];
            kO kO9 = object[2][0];
            kO kO10 = object[2][1];
            kO kO11 = object[2][2];
            double d4 = 0.0;
            kOArray = (kO[][])ch_0.a(object[0][0].c(), 3, 3);
            int n2 = 0;
            while (++n2 < 11) {
                double d5;
                kO kO12 = (kO)((kO)((kO)object[0][0].c(kO5)).a(object[1][0].c(kO6))).a(object[2][0].c(kO9));
                kO kO13 = (kO)((kO)((kO)object[0][1].c(kO5)).a(object[1][1].c(kO6))).a(object[2][1].c(kO9));
                kO kO14 = (kO)((kO)((kO)object[0][2].c(kO5)).a(object[1][2].c(kO6))).a(object[2][2].c(kO9));
                kO kO15 = (kO)((kO)((kO)object[0][0].c(kO4)).a(object[1][0].c(kO7))).a(object[2][0].c(kO10));
                kO kO16 = (kO)((kO)((kO)object[0][1].c(kO4)).a(object[1][1].c(kO7))).a(object[2][1].c(kO10));
                kO kO17 = (kO)((kO)((kO)object[0][2].c(kO4)).a(object[1][2].c(kO7))).a(object[2][2].c(kO10));
                kO kO18 = (kO)((kO)((kO)object[0][0].c(kO3)).a(object[1][0].c(kO8))).a(object[2][0].c(kO11));
                kO kO19 = (kO)((kO)((kO)object[0][1].c(kO3)).a(object[1][1].c(kO8))).a(object[2][1].c(kO11));
                kO kO20 = (kO)((kO)((kO)object[0][2].c(kO3)).a(object[1][2].c(kO8))).a(object[2][2].c(kO11));
                kO kO21 = kO5;
                kOArray[0][0] = (kO)kO21.b(((kO)kO21.c((kO)kO12).a(kO4.c((kO)kO13)).a(kO3.c((kO)kO14)).b(object[0][0])).c(0.5));
                kOArray[0][1] = (kO)kO4.b(((kO)kO5.c((kO)kO15).a(kO4.c((kO)kO16)).a(kO3.c((kO)kO17)).b(object[0][1])).c(0.5));
                kOArray[0][2] = (kO)kO3.b(((kO)kO5.c((kO)kO18).a(kO4.c((kO)kO19)).a(kO3.c((kO)kO20)).b(object[0][2])).c(0.5));
                kO kO22 = kO6;
                kOArray[1][0] = (kO)kO22.b(((kO)kO22.c((kO)kO12).a(kO7.c((kO)kO13)).a(kO8.c((kO)kO14)).b(object[1][0])).c(0.5));
                kOArray[1][1] = (kO)kO7.b(((kO)kO6.c((kO)kO15).a(kO7.c((kO)kO16)).a(kO8.c((kO)kO17)).b(object[1][1])).c(0.5));
                kOArray[1][2] = (kO)kO8.b(((kO)kO6.c((kO)kO18).a(kO7.c((kO)kO19)).a(kO8.c((kO)kO20)).b(object[1][2])).c(0.5));
                kO kO23 = kO9;
                kOArray[2][0] = (kO)kO23.b(((kO)kO23.c((kO)kO12).a(kO10.c((kO)kO13)).a(kO11.c((kO)kO14)).b(object[2][0])).c(0.5));
                kOArray[2][1] = (kO)kO10.b(((kO)kO9.c((kO)kO15).a(kO10.c((kO)kO16)).a(kO11.c((kO)kO17)).b(object[2][1])).c(0.5));
                kOArray[2][2] = (kO)kO11.b(((kO)kO9.c((kO)kO18).a(kO10.c((kO)kO19)).a(kO11.c((kO)kO20)).b(object[2][2])).c(0.5));
                double d6 = kOArray[0][0].d() - object[0][0].d();
                double d7 = kOArray[0][1].d() - object[0][1].d();
                double d8 = kOArray[0][2].d() - object[0][2].d();
                double d9 = kOArray[1][0].d() - object[1][0].d();
                double d10 = kOArray[1][1].d() - object[1][1].d();
                double d11 = kOArray[1][2].d() - object[1][2].d();
                double d12 = kOArray[2][0].d() - object[2][0].d();
                double d13 = kOArray[2][1].d() - object[2][1].d();
                double d14 = kOArray[2][2].d() - object[2][2].d();
                double d15 = d6;
                double d16 = d7;
                double d17 = d8;
                double d18 = d9;
                double d19 = d10;
                double d20 = d11;
                double d21 = d12;
                double d22 = d13;
                double d23 = d14;
                double d24 = d15 * d15 + d16 * d16 + d17 * d17 + d18 * d18 + d19 * d19 + d20 * d20 + d21 * d21 + d22 * d22 + d23 * d23;
                if (!(BY.w(d5 - d4) <= d3)) {
                    kO5 = kOArray[0][0];
                    kO4 = kOArray[0][1];
                    kO3 = kOArray[0][2];
                    kO6 = kOArray[1][0];
                    kO7 = kOArray[1][1];
                    kO8 = kOArray[1][2];
                    kO9 = kOArray[2][0];
                    kO10 = kOArray[2][1];
                    kO11 = kOArray[2][2];
                    d4 = d24;
                    continue;
                }
                break block4;
            }
            throw new rg_0(px_0.UNABLE_TO_ORTHOGONOLIZE_MATRIX, n2 - 1);
        }
        object = kOArray;
        kO5 = (kO)((kO)kOArray[1][1].c(object[2][2])).b(object[2][1].c(object[1][2]));
        kO4 = (kO)((kO)object[0][1].c(object[2][2])).b(object[2][1].c(object[0][2]));
        kO3 = (kO)((kO)object[0][1].c(object[1][2])).b(object[1][1].c(object[0][2]));
        kO5 = (kO)((kO)((kO)object[0][0].c(kO5)).b(object[1][0].c(kO4))).a(object[2][0].c(kO3));
        if (kO2.d() < 0.0) {
            throw new rg_0(px_0.CLOSEST_ORTHOGONAL_MATRIX_HAS_NEGATIVE_DETERMINANT, kO5);
        }
        object = rd_0.a(object);
        this.b = object[0];
        this.c = object[1];
        this.d = object[2];
        this.e = object[3];
    }

    private rd_0(re_0<T> kOArray, re_0<T> kOArray2, re_0<T> re_02, re_0<T> re_03) {
        kO[][] kOArray3 = kOArray2;
        Object object = kOArray;
        re_0<T> re_04 = kOArray.b(kOArray3).e();
        kOArray3 = kOArray;
        object = re_04;
        kOArray2 = re_04.b((re_0<T>)kOArray3).e();
        kOArray = kOArray.e();
        kOArray3 = re_03;
        object = re_02;
        re_0<T> re_05 = object.b(kOArray3).e();
        kOArray3 = re_02;
        object = re_05;
        re_03 = re_05.b((re_0<T>)kOArray3).e();
        re_02 = re_02.e();
        object = kOArray;
        kOArray3 = (kO[][])ch_0.a(kOArray.a.c(), 3, 3);
        object = kOArray;
        re_0<T> re_06 = re_02;
        object = re_06;
        object = kOArray2;
        re_0<T> re_07 = re_03;
        object = re_07;
        re_0<T> re_08 = re_04;
        object = re_08;
        object = re_05;
        kOArray3[0][0] = (kO)((kO)((kO)kOArray.a.c(re_06.a)).a(kOArray2.a.c(re_07.a))).a(re_08.a.c(object.a));
        object = kOArray;
        re_0<T> re_09 = re_02;
        object = re_09;
        object = kOArray2;
        re_0<T> re_010 = re_03;
        object = re_010;
        re_0<T> re_011 = re_04;
        object = re_011;
        object = re_05;
        kOArray3[0][1] = (kO)((kO)((kO)kOArray.b.c(re_09.a)).a(kOArray2.b.c(re_010.a))).a(re_011.b.c(object.a));
        object = kOArray;
        re_0<T> re_012 = re_02;
        object = re_012;
        object = kOArray2;
        re_0<T> re_013 = re_03;
        object = re_013;
        re_0<T> re_014 = re_04;
        object = re_014;
        object = re_05;
        kOArray3[0][2] = (kO)((kO)((kO)kOArray.c.c(re_012.a)).a(kOArray2.c.c(re_013.a))).a(re_014.c.c(object.a));
        object = kOArray;
        re_0<T> re_015 = re_02;
        object = re_015;
        object = kOArray2;
        re_0<T> re_016 = re_03;
        object = re_016;
        re_0<T> re_017 = re_04;
        object = re_017;
        object = re_05;
        kOArray3[1][0] = (kO)((kO)((kO)kOArray.a.c(re_015.b)).a(kOArray2.a.c(re_016.b))).a(re_017.a.c(object.b));
        object = kOArray;
        re_0<T> re_018 = re_02;
        object = re_018;
        object = kOArray2;
        re_0<T> re_019 = re_03;
        object = re_019;
        re_0<T> re_020 = re_04;
        object = re_020;
        object = re_05;
        kOArray3[1][1] = (kO)((kO)((kO)kOArray.b.c(re_018.b)).a(kOArray2.b.c(re_019.b))).a(re_020.b.c(object.b));
        object = kOArray;
        re_0<T> re_021 = re_02;
        object = re_021;
        object = kOArray2;
        re_0<T> re_022 = re_03;
        object = re_022;
        re_0<T> re_023 = re_04;
        object = re_023;
        object = re_05;
        kOArray3[1][2] = (kO)((kO)((kO)kOArray.c.c(re_021.b)).a(kOArray2.c.c(re_022.b))).a(re_023.c.c(object.b));
        object = kOArray;
        re_0<T> re_024 = re_02;
        object = re_024;
        object = kOArray2;
        re_0<T> re_025 = re_03;
        object = re_025;
        re_0<T> re_026 = re_04;
        object = re_026;
        object = re_05;
        kOArray3[2][0] = (kO)((kO)((kO)kOArray.a.c(re_024.c)).a(kOArray2.a.c(re_025.c))).a(re_026.a.c(object.c));
        object = kOArray;
        re_0<T> re_027 = re_02;
        object = re_027;
        object = kOArray2;
        re_0<T> re_028 = re_03;
        object = re_028;
        re_0<T> re_029 = re_04;
        object = re_029;
        object = re_05;
        kOArray3[2][1] = (kO)((kO)((kO)kOArray.b.c(re_027.c)).a(kOArray2.b.c(re_028.c))).a(re_029.b.c(object.c));
        object = kOArray;
        re_0<T> re_030 = re_02;
        object = re_030;
        object = kOArray2;
        re_0<T> re_031 = re_03;
        object = re_031;
        re_0<T> re_032 = re_04;
        object = re_032;
        object = re_05;
        kOArray3[2][2] = (kO)((kO)((kO)kOArray.c.c(re_030.c)).a(kOArray2.c.c(re_031.c))).a(re_032.c.c(object.c));
        kOArray = rd_0.a((kO[][])kOArray3);
        this.b = kOArray[0];
        this.c = kOArray[1];
        this.d = kOArray[2];
        this.e = kOArray[3];
    }

    private rd_0(re_0<T> re_02, re_0<T> object) {
        kO kO2;
        kO kO3 = (kO)re_02.d().c(((re_0)object).d());
        if (kO3.d() == 0.0) {
            throw new oU(px_0.ZERO_NORM_FOR_ROTATION_DEFINING_VECTOR, new Object[0]);
        }
        re_0<T> re_03 = object;
        Object object2 = re_02;
        Object object3 = ((re_0)object2).a(re_03);
        if (kO2.d() < -0.999999999999998 * kO3.d()) {
            re_0<kO> re_04;
            double d2 = 0.6 * re_02.d().d();
            if (d2 == 0.0) {
                throw new oU(px_0.ZERO_NORM, new Object[0]);
            }
            if (BY.w(re_02.a.d()) <= d2) {
                object = (kO)((kO)((kO)((kO)re_02.b.c(re_02.b)).a(re_02.c.c(re_02.c))).k()).b();
                re_04 = new re_0<kO>((kO)object.c().a(), (kO)object.c(re_02.c), (kO)((kO)object.c(re_02.b)).a());
            } else if (BY.w(re_02.b.d()) <= d2) {
                object = (kO)((kO)((kO)((kO)re_02.a.c(re_02.a)).a(re_02.c.c(re_02.c))).k()).b();
                re_04 = new re_0<kO>((kO)((kO)object.c(re_02.c)).a(), (kO)object.c().a(), (kO)object.c(re_02.a));
            } else {
                object = (kO)((kO)((kO)((kO)re_02.a.c(re_02.a)).a(re_02.b.c(re_02.b))).k()).b();
                re_04 = new re_0<kO>((kO)object.c(re_02.b), (kO)((kO)object.c(re_02.a)).a(), (kO)object.c().a());
            }
            object3 = re_04;
            this.b = (kO)kO3.c().a();
            object2 = object3;
            this.c = (kO)((re_0)object2).a.a();
            object2 = object3;
            this.d = (kO)((re_0)object2).b.a();
            object2 = object3;
            this.e = (kO)((re_0)object2).c.a();
            return;
        }
        this.b = (kO)((kO)((kO)object3.d((kO)kO3).a(1.0)).c(0.5)).k();
        object3 = (kO)((kO)this.b.c((kO)kO3).c(2.0)).b();
        re_03 = re_02;
        object2 = object;
        re_02 = ((re_0)object2).b(re_03);
        object2 = re_02;
        this.c = (kO)object3.c(((re_0)object2).a);
        object2 = re_02;
        this.d = (kO)object3.c(((re_0)object2).b);
        object2 = re_02;
        this.e = (kO)object3.c(((re_0)object2).c);
    }

    @Deprecated
    private rd_0(rm_0 rm_02, T t, T t2, T t3) {
        this(rm_02, rl_0.VECTOR_OPERATOR$59e4743c, t, t2, t3);
    }

    private rd_0(rm_0 rd_02, int n2, T object, T object2, T t) {
        kO kO2 = (kO)object.c().b();
        rm_0 rm_02 = rd_02;
        object = new rd_0<kO>(new re_0<kO>(kO2, rm_02.l), (kO)object, n2);
        rm_02 = rd_02;
        object2 = new rd_0<kO>(new re_0<kO>(kO2, rm_02.m), (kO)object2, n2);
        rm_02 = rd_02;
        rd_02 = new rd_0<kO>(new re_0<kO>(kO2, rm_02.n), (kO)t, n2);
        rd_02 = ((rd_0)object).a(((rd_0)object2).a(rd_02, n2), n2);
        this.b = rd_02.b;
        this.c = rd_02.c;
        this.d = rd_02.d;
        this.e = rd_02.e;
    }

    private static T[] a(T[][] TArray) {
        kO kO2;
        kO[] kOArray = (kO[])ch_0.a(TArray[0][0].c(), 4);
        kO kO3 = (kO)((kO)TArray[0][0].a(TArray[1][1])).a(TArray[2][2]);
        if (kO2.d() > -0.19) {
            kOArray[0] = (kO)((kO)((kO)kO3.a(1.0)).k()).c(0.5);
            kO3 = (kO)((kO)kOArray[0].b()).c(0.25);
            kOArray[1] = (kO)kO3.c(TArray[1][2].b(TArray[2][1]));
            kOArray[2] = (kO)kO3.c(TArray[2][0].b(TArray[0][2]));
            kOArray[3] = (kO)kO3.c(TArray[0][1].b(TArray[1][0]));
        } else {
            kO kO4;
            kO3 = (kO)((kO)TArray[0][0].b(TArray[1][1])).b(TArray[2][2]);
            if (kO4.d() > -0.19) {
                kOArray[1] = (kO)((kO)((kO)kO3.a(1.0)).k()).c(0.5);
                kO3 = (kO)((kO)kOArray[1].b()).c(0.25);
                kOArray[0] = (kO)kO3.c(TArray[1][2].b(TArray[2][1]));
                kOArray[2] = (kO)kO3.c(TArray[0][1].a(TArray[1][0]));
                kOArray[3] = (kO)kO3.c(TArray[0][2].a(TArray[2][0]));
            } else {
                kO kO5;
                kO3 = (kO)((kO)TArray[1][1].b(TArray[0][0])).b(TArray[2][2]);
                if (kO5.d() > -0.19) {
                    kOArray[2] = (kO)((kO)((kO)kO3.a(1.0)).k()).c(0.5);
                    kO3 = (kO)((kO)kOArray[2].b()).c(0.25);
                    kOArray[0] = (kO)kO3.c(TArray[2][0].b(TArray[0][2]));
                    kOArray[1] = (kO)kO3.c(TArray[0][1].a(TArray[1][0]));
                    kOArray[3] = (kO)kO3.c(TArray[2][1].a(TArray[1][2]));
                } else {
                    kO3 = (kO)((kO)TArray[2][2].b(TArray[0][0])).b(TArray[1][1]);
                    kOArray[3] = (kO)((kO)((kO)kO3.a(1.0)).k()).c(0.5);
                    kO3 = (kO)((kO)kOArray[3].b()).c(0.25);
                    kOArray[0] = (kO)kO3.c(TArray[0][1].b(TArray[1][0]));
                    kOArray[1] = (kO)kO3.c(TArray[0][2].a(TArray[2][0]));
                    kOArray[2] = (kO)kO3.c(TArray[2][1].a(TArray[1][2]));
                }
            }
        }
        return kOArray;
    }

    private rd_0<T> a() {
        return new rd_0<kO>((kO)this.b.a(), (kO)this.c, (kO)this.d, (kO)this.e, false);
    }

    private T b() {
        return this.b;
    }

    private T c() {
        return this.c;
    }

    private T d() {
        return this.d;
    }

    private T e() {
        return this.e;
    }

    @Deprecated
    private re_0<T> f() {
        double d2;
        int n2 = rl_0.VECTOR_OPERATOR$59e4743c;
        rd_0 rd_02 = this;
        kO kO2 = (kO)((kO)((kO)rd_02.c.c(rd_02.c)).a(rd_02.d.c(rd_02.d))).a(rd_02.e.c(rd_02.e));
        if (kO2.d() == 0.0) {
            kM kM2 = kO2.c();
            return new re_0<kO>(n2 == rl_0.VECTOR_OPERATOR$59e4743c ? (kO)kM2.b() : (kO)((kO)kM2.b()).a(), (kO)kM2.a(), (kO)kM2.a());
        }
        double d3 = d2 = n2 == rl_0.VECTOR_OPERATOR$59e4743c ? 1.0 : -1.0;
        if (rd_02.b.d() < 0.0) {
            kO kO3 = (kO)((kO)((kO)kO2.k()).b()).c(d2);
            return new re_0<kO>(rd_02.c.c((kO)kO3), rd_02.d.c((kO)kO3), rd_02.e.c((kO)kO3));
        }
        kO kO4 = (kO)((kO)((kO)((kO)kO2.k()).b()).a()).c(d2);
        return new re_0<kO>(rd_02.c.c((kO)kO4), rd_02.d.c((kO)kO4), rd_02.e.c((kO)kO4));
    }

    private re_0<T> a(int n2) {
        double d2;
        kO kO2 = (kO)((kO)((kO)this.c.c(this.c)).a(this.d.c(this.d))).a(this.e.c(this.e));
        if (kO2.d() == 0.0) {
            kM kM2 = kO2.c();
            return new re_0<kO>(n2 == rl_0.VECTOR_OPERATOR$59e4743c ? (kO)kM2.b() : (kO)((kO)kM2.b()).a(), (kO)kM2.a(), (kO)kM2.a());
        }
        double d3 = d2 = n2 == rl_0.VECTOR_OPERATOR$59e4743c ? 1.0 : -1.0;
        if (this.b.d() < 0.0) {
            kO kO3 = (kO)((kO)((kO)kO2.k()).b()).c(d2);
            return new re_0<kO>(this.c.c((kO)kO3), this.d.c((kO)kO3), this.e.c((kO)kO3));
        }
        kO kO4 = (kO)((kO)((kO)((kO)kO2.k()).b()).a()).c(d2);
        return new re_0<kO>(this.c.c((kO)kO4), this.d.c((kO)kO4), this.e.c((kO)kO4));
    }

    private T g() {
        if (this.b.d() < -0.1 || this.b.d() > 0.1) {
            return (T)((kO)((kO)((kO)((kO)((kO)((kO)this.c.c(this.c)).a(this.d.c(this.d))).a(this.e.c(this.e))).k()).u()).a(2));
        }
        if (this.b.d() < 0.0) {
            return (T)((kO)((kO)((kO)this.b.a()).t()).a(2));
        }
        return (T)((kO)((kO)this.b.t()).a(2));
    }

    @Deprecated
    private T[] a(rm_0 re_02) {
        re_0<T> re_03;
        re_0<T> re_04;
        block118: {
            block117: {
                re_0<T> re_05;
                block114: {
                    re_0<T> re_06;
                    block116: {
                        block115: {
                            re_0<T> re_07;
                            block111: {
                                re_0<T> re_08;
                                block113: {
                                    block112: {
                                        re_0<T> re_09;
                                        block108: {
                                            re_0<T> re_010;
                                            block110: {
                                                block109: {
                                                    re_0<T> re_011;
                                                    block105: {
                                                        re_0<T> re_012;
                                                        block107: {
                                                            block106: {
                                                                re_0<T> re_013;
                                                                block102: {
                                                                    re_0<T> re_014;
                                                                    block104: {
                                                                        block103: {
                                                                            re_0<T> re_015;
                                                                            block99: {
                                                                                re_0<T> re_016;
                                                                                block101: {
                                                                                    block100: {
                                                                                        re_0<T> re_017;
                                                                                        block96: {
                                                                                            re_0<T> re_018;
                                                                                            block98: {
                                                                                                block97: {
                                                                                                    re_0<T> re_019;
                                                                                                    block93: {
                                                                                                        re_0<T> re_020;
                                                                                                        block95: {
                                                                                                            block94: {
                                                                                                                re_0<T> re_021;
                                                                                                                block90: {
                                                                                                                    re_0<T> re_022;
                                                                                                                    block92: {
                                                                                                                        block91: {
                                                                                                                            re_0<T> re_023;
                                                                                                                            block87: {
                                                                                                                                re_0<T> re_024;
                                                                                                                                block89: {
                                                                                                                                    block88: {
                                                                                                                                        re_0<T> re_025;
                                                                                                                                        block84: {
                                                                                                                                            re_0<T> re_026;
                                                                                                                                            block86: {
                                                                                                                                                block85: {
                                                                                                                                                    re_0<T> re_027;
                                                                                                                                                    block48: {
                                                                                                                                                        re_0<T> re_028;
                                                                                                                                                        block83: {
                                                                                                                                                            block82: {
                                                                                                                                                                re_0<T> re_029;
                                                                                                                                                                block79: {
                                                                                                                                                                    re_0<T> re_030;
                                                                                                                                                                    block81: {
                                                                                                                                                                        block80: {
                                                                                                                                                                            re_0<T> re_031;
                                                                                                                                                                            block76: {
                                                                                                                                                                                re_0<T> re_032;
                                                                                                                                                                                block78: {
                                                                                                                                                                                    block77: {
                                                                                                                                                                                        re_0<T> re_033;
                                                                                                                                                                                        block73: {
                                                                                                                                                                                            re_0<T> re_034;
                                                                                                                                                                                            block75: {
                                                                                                                                                                                                block74: {
                                                                                                                                                                                                    re_0<T> re_035;
                                                                                                                                                                                                    block70: {
                                                                                                                                                                                                        re_0<T> re_036;
                                                                                                                                                                                                        block72: {
                                                                                                                                                                                                            block71: {
                                                                                                                                                                                                                re_0<T> re_037;
                                                                                                                                                                                                                block67: {
                                                                                                                                                                                                                    re_0<T> re_038;
                                                                                                                                                                                                                    block69: {
                                                                                                                                                                                                                        block68: {
                                                                                                                                                                                                                            re_0<T> re_039;
                                                                                                                                                                                                                            block64: {
                                                                                                                                                                                                                                re_0<T> re_040;
                                                                                                                                                                                                                                block66: {
                                                                                                                                                                                                                                    block65: {
                                                                                                                                                                                                                                        re_0<T> re_041;
                                                                                                                                                                                                                                        block61: {
                                                                                                                                                                                                                                            re_0<T> re_042;
                                                                                                                                                                                                                                            block63: {
                                                                                                                                                                                                                                                block62: {
                                                                                                                                                                                                                                                    re_0<T> re_043;
                                                                                                                                                                                                                                                    block58: {
                                                                                                                                                                                                                                                        re_0<T> re_044;
                                                                                                                                                                                                                                                        block60: {
                                                                                                                                                                                                                                                            block59: {
                                                                                                                                                                                                                                                                re_0<T> re_045;
                                                                                                                                                                                                                                                                block55: {
                                                                                                                                                                                                                                                                    re_0<T> re_046;
                                                                                                                                                                                                                                                                    block57: {
                                                                                                                                                                                                                                                                        block56: {
                                                                                                                                                                                                                                                                            re_0<T> re_047;
                                                                                                                                                                                                                                                                            block52: {
                                                                                                                                                                                                                                                                                re_0<T> re_048;
                                                                                                                                                                                                                                                                                block54: {
                                                                                                                                                                                                                                                                                    block53: {
                                                                                                                                                                                                                                                                                        re_0<T> re_049;
                                                                                                                                                                                                                                                                                        block49: {
                                                                                                                                                                                                                                                                                            re_0<T> re_050;
                                                                                                                                                                                                                                                                                            block51: {
                                                                                                                                                                                                                                                                                                block50: {
                                                                                                                                                                                                                                                                                                    re_0<T> re_051;
                                                                                                                                                                                                                                                                                                    int n2 = rl_0.VECTOR_OPERATOR$59e4743c;
                                                                                                                                                                                                                                                                                                    re_04 = re_02;
                                                                                                                                                                                                                                                                                                    re_02 = this;
                                                                                                                                                                                                                                                                                                    if (n2 != rl_0.VECTOR_OPERATOR$59e4743c) break block48;
                                                                                                                                                                                                                                                                                                    if (re_04 != rm_0.a) break block49;
                                                                                                                                                                                                                                                                                                    re_0<T> re_052 = re_02;
                                                                                                                                                                                                                                                                                                    re_04 = ((rd_0)((Object)re_052)).a(super.a(0.0, 0.0, 1.0));
                                                                                                                                                                                                                                                                                                    re_0<T> re_053 = re_02;
                                                                                                                                                                                                                                                                                                    re_02 = ((rd_0)((Object)re_053)).b(super.a(1.0, 0.0, 0.0));
                                                                                                                                                                                                                                                                                                    re_050 = re_02;
                                                                                                                                                                                                                                                                                                    if (re_02.c.d() < -0.9999999999) break block50;
                                                                                                                                                                                                                                                                                                    re_050 = re_02;
                                                                                                                                                                                                                                                                                                    if (!(re_051.c.d() > 0.9999999999)) break block51;
                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                throw new rb_0(true);
                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                            re_0<T> re_054 = re_04;
                                                                                                                                                                                                                                                                                            re_050 = re_054;
                                                                                                                                                                                                                                                                                            re_0<T> re_055 = re_04;
                                                                                                                                                                                                                                                                                            re_050 = re_055;
                                                                                                                                                                                                                                                                                            re_0<T> re_056 = re_02;
                                                                                                                                                                                                                                                                                            re_050 = re_056;
                                                                                                                                                                                                                                                                                            re_0<T> re_057 = re_02;
                                                                                                                                                                                                                                                                                            re_050 = re_057;
                                                                                                                                                                                                                                                                                            re_050 = re_02;
                                                                                                                                                                                                                                                                                            return rd_0.a((kO)((kO)((kO)re_054.b.a()).h(re_055.c)), (kO)((kO)re_056.c.u()), (kO)((kO)((kO)re_057.b.a()).h(re_050.a)));
                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                        if (re_04 != rm_0.b) break block52;
                                                                                                                                                                                                                                                                                        re_0<T> re_058 = re_02;
                                                                                                                                                                                                                                                                                        re_04 = ((rd_0)((Object)re_058)).a(super.a(0.0, 1.0, 0.0));
                                                                                                                                                                                                                                                                                        re_0<T> re_059 = re_02;
                                                                                                                                                                                                                                                                                        re_02 = ((rd_0)((Object)re_059)).b(super.a(1.0, 0.0, 0.0));
                                                                                                                                                                                                                                                                                        re_048 = re_02;
                                                                                                                                                                                                                                                                                        if (re_02.b.d() < -0.9999999999) break block53;
                                                                                                                                                                                                                                                                                        re_048 = re_02;
                                                                                                                                                                                                                                                                                        if (!(re_049.b.d() > 0.9999999999)) break block54;
                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                    throw new rb_0(true);
                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                re_0<T> re_060 = re_04;
                                                                                                                                                                                                                                                                                re_048 = re_060;
                                                                                                                                                                                                                                                                                re_0<T> re_061 = re_04;
                                                                                                                                                                                                                                                                                re_048 = re_061;
                                                                                                                                                                                                                                                                                re_0<T> re_062 = re_02;
                                                                                                                                                                                                                                                                                re_048 = re_062;
                                                                                                                                                                                                                                                                                re_0<T> re_063 = re_02;
                                                                                                                                                                                                                                                                                re_048 = re_063;
                                                                                                                                                                                                                                                                                re_048 = re_02;
                                                                                                                                                                                                                                                                                return rd_0.a((kO)((kO)re_060.c.h(re_061.b)), (kO)((kO)((kO)re_062.b.u()).a()), (kO)((kO)re_063.c.h(re_048.a)));
                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                            if (re_04 != rm_0.c) break block55;
                                                                                                                                                                                                                                                                            re_0<T> re_064 = re_02;
                                                                                                                                                                                                                                                                            re_04 = ((rd_0)((Object)re_064)).a(super.a(0.0, 0.0, 1.0));
                                                                                                                                                                                                                                                                            re_0<T> re_065 = re_02;
                                                                                                                                                                                                                                                                            re_02 = ((rd_0)((Object)re_065)).b(super.a(0.0, 1.0, 0.0));
                                                                                                                                                                                                                                                                            re_046 = re_02;
                                                                                                                                                                                                                                                                            if (re_02.c.d() < -0.9999999999) break block56;
                                                                                                                                                                                                                                                                            re_046 = re_02;
                                                                                                                                                                                                                                                                            if (!(re_047.c.d() > 0.9999999999)) break block57;
                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                        throw new rb_0(true);
                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                    re_0<T> re_066 = re_04;
                                                                                                                                                                                                                                                                    re_046 = re_066;
                                                                                                                                                                                                                                                                    re_0<T> re_067 = re_04;
                                                                                                                                                                                                                                                                    re_046 = re_067;
                                                                                                                                                                                                                                                                    re_0<T> re_068 = re_02;
                                                                                                                                                                                                                                                                    re_046 = re_068;
                                                                                                                                                                                                                                                                    re_0<T> re_069 = re_02;
                                                                                                                                                                                                                                                                    re_046 = re_069;
                                                                                                                                                                                                                                                                    re_046 = re_02;
                                                                                                                                                                                                                                                                    return rd_0.a((kO)((kO)re_066.a.h(re_067.c)), (kO)((kO)((kO)re_068.c.u()).a()), (kO)((kO)re_069.a.h(re_046.b)));
                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                if (re_04 != rm_0.d) break block58;
                                                                                                                                                                                                                                                                re_0<T> re_070 = re_02;
                                                                                                                                                                                                                                                                re_04 = ((rd_0)((Object)re_070)).a(super.a(1.0, 0.0, 0.0));
                                                                                                                                                                                                                                                                re_0<T> re_071 = re_02;
                                                                                                                                                                                                                                                                re_02 = ((rd_0)((Object)re_071)).b(super.a(0.0, 1.0, 0.0));
                                                                                                                                                                                                                                                                re_044 = re_02;
                                                                                                                                                                                                                                                                if (re_02.a.d() < -0.9999999999) break block59;
                                                                                                                                                                                                                                                                re_044 = re_02;
                                                                                                                                                                                                                                                                if (!(re_045.a.d() > 0.9999999999)) break block60;
                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                            throw new rb_0(true);
                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                        re_0<T> re_072 = re_04;
                                                                                                                                                                                                                                                        re_044 = re_072;
                                                                                                                                                                                                                                                        re_0<T> re_073 = re_04;
                                                                                                                                                                                                                                                        re_044 = re_073;
                                                                                                                                                                                                                                                        re_0<T> re_074 = re_02;
                                                                                                                                                                                                                                                        re_044 = re_074;
                                                                                                                                                                                                                                                        re_0<T> re_075 = re_02;
                                                                                                                                                                                                                                                        re_044 = re_075;
                                                                                                                                                                                                                                                        re_044 = re_02;
                                                                                                                                                                                                                                                        return rd_0.a((kO)((kO)((kO)re_072.c.a()).h(re_073.a)), (kO)((kO)re_074.a.u()), (kO)((kO)((kO)re_075.c.a()).h(re_044.b)));
                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                    if (re_04 != rm_0.e) break block61;
                                                                                                                                                                                                                                                    re_0<T> re_076 = re_02;
                                                                                                                                                                                                                                                    re_04 = ((rd_0)((Object)re_076)).a(super.a(0.0, 1.0, 0.0));
                                                                                                                                                                                                                                                    re_0<T> re_077 = re_02;
                                                                                                                                                                                                                                                    re_02 = ((rd_0)((Object)re_077)).b(super.a(0.0, 0.0, 1.0));
                                                                                                                                                                                                                                                    re_042 = re_02;
                                                                                                                                                                                                                                                    if (re_02.b.d() < -0.9999999999) break block62;
                                                                                                                                                                                                                                                    re_042 = re_02;
                                                                                                                                                                                                                                                    if (!(re_043.b.d() > 0.9999999999)) break block63;
                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                throw new rb_0(true);
                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                            re_0<T> re_078 = re_04;
                                                                                                                                                                                                                                            re_042 = re_078;
                                                                                                                                                                                                                                            re_0<T> re_079 = re_04;
                                                                                                                                                                                                                                            re_042 = re_079;
                                                                                                                                                                                                                                            re_0<T> re_080 = re_02;
                                                                                                                                                                                                                                            re_042 = re_080;
                                                                                                                                                                                                                                            re_0<T> re_081 = re_02;
                                                                                                                                                                                                                                            re_042 = re_081;
                                                                                                                                                                                                                                            re_042 = re_02;
                                                                                                                                                                                                                                            return rd_0.a((kO)((kO)((kO)re_078.a.a()).h(re_079.b)), (kO)((kO)re_080.b.u()), (kO)((kO)((kO)re_081.a.a()).h(re_042.c)));
                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                        if (re_04 != rm_0.f) break block64;
                                                                                                                                                                                                                                        re_0<T> re_082 = re_02;
                                                                                                                                                                                                                                        re_04 = ((rd_0)((Object)re_082)).a(super.a(1.0, 0.0, 0.0));
                                                                                                                                                                                                                                        re_0<T> re_083 = re_02;
                                                                                                                                                                                                                                        re_02 = ((rd_0)((Object)re_083)).b(super.a(0.0, 0.0, 1.0));
                                                                                                                                                                                                                                        re_040 = re_02;
                                                                                                                                                                                                                                        if (re_02.a.d() < -0.9999999999) break block65;
                                                                                                                                                                                                                                        re_040 = re_02;
                                                                                                                                                                                                                                        if (!(re_041.a.d() > 0.9999999999)) break block66;
                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                    throw new rb_0(true);
                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                re_0<T> re_084 = re_04;
                                                                                                                                                                                                                                re_040 = re_084;
                                                                                                                                                                                                                                re_0<T> re_085 = re_04;
                                                                                                                                                                                                                                re_040 = re_085;
                                                                                                                                                                                                                                re_0<T> re_086 = re_02;
                                                                                                                                                                                                                                re_040 = re_086;
                                                                                                                                                                                                                                re_0<T> re_087 = re_02;
                                                                                                                                                                                                                                re_040 = re_087;
                                                                                                                                                                                                                                re_040 = re_02;
                                                                                                                                                                                                                                return rd_0.a((kO)((kO)re_084.b.h(re_085.a)), (kO)((kO)((kO)re_086.a.u()).a()), (kO)((kO)re_087.b.h(re_040.c)));
                                                                                                                                                                                                                            }
                                                                                                                                                                                                                            if (re_04 != rm_0.g) break block67;
                                                                                                                                                                                                                            re_0<T> re_088 = re_02;
                                                                                                                                                                                                                            re_04 = ((rd_0)((Object)re_088)).a(super.a(1.0, 0.0, 0.0));
                                                                                                                                                                                                                            re_0<T> re_089 = re_02;
                                                                                                                                                                                                                            re_02 = ((rd_0)((Object)re_089)).b(super.a(1.0, 0.0, 0.0));
                                                                                                                                                                                                                            re_038 = re_02;
                                                                                                                                                                                                                            if (re_02.a.d() < -0.9999999999) break block68;
                                                                                                                                                                                                                            re_038 = re_02;
                                                                                                                                                                                                                            if (!(re_039.a.d() > 0.9999999999)) break block69;
                                                                                                                                                                                                                        }
                                                                                                                                                                                                                        throw new rb_0(false);
                                                                                                                                                                                                                    }
                                                                                                                                                                                                                    re_0<T> re_090 = re_04;
                                                                                                                                                                                                                    re_038 = re_090;
                                                                                                                                                                                                                    re_0<T> re_091 = re_04;
                                                                                                                                                                                                                    re_038 = re_091;
                                                                                                                                                                                                                    re_0<T> re_092 = re_02;
                                                                                                                                                                                                                    re_038 = re_092;
                                                                                                                                                                                                                    re_0<T> re_093 = re_02;
                                                                                                                                                                                                                    re_038 = re_093;
                                                                                                                                                                                                                    re_038 = re_02;
                                                                                                                                                                                                                    return rd_0.a((kO)((kO)re_090.b.h(re_091.c.a())), (kO)((kO)re_092.a.t()), (kO)((kO)re_093.b.h(re_038.c)));
                                                                                                                                                                                                                }
                                                                                                                                                                                                                if (re_04 != rm_0.h) break block70;
                                                                                                                                                                                                                re_0<T> re_094 = re_02;
                                                                                                                                                                                                                re_04 = ((rd_0)((Object)re_094)).a(super.a(1.0, 0.0, 0.0));
                                                                                                                                                                                                                re_0<T> re_095 = re_02;
                                                                                                                                                                                                                re_02 = ((rd_0)((Object)re_095)).b(super.a(1.0, 0.0, 0.0));
                                                                                                                                                                                                                re_036 = re_02;
                                                                                                                                                                                                                if (re_02.a.d() < -0.9999999999) break block71;
                                                                                                                                                                                                                re_036 = re_02;
                                                                                                                                                                                                                if (!(re_037.a.d() > 0.9999999999)) break block72;
                                                                                                                                                                                                            }
                                                                                                                                                                                                            throw new rb_0(false);
                                                                                                                                                                                                        }
                                                                                                                                                                                                        re_0<T> re_096 = re_04;
                                                                                                                                                                                                        re_036 = re_096;
                                                                                                                                                                                                        re_0<T> re_097 = re_04;
                                                                                                                                                                                                        re_036 = re_097;
                                                                                                                                                                                                        re_0<T> re_098 = re_02;
                                                                                                                                                                                                        re_036 = re_098;
                                                                                                                                                                                                        re_0<T> re_099 = re_02;
                                                                                                                                                                                                        re_036 = re_099;
                                                                                                                                                                                                        re_036 = re_02;
                                                                                                                                                                                                        return rd_0.a((kO)((kO)re_096.c.h(re_097.b)), (kO)((kO)re_098.a.t()), (kO)((kO)re_099.c.h(re_036.b.a())));
                                                                                                                                                                                                    }
                                                                                                                                                                                                    if (re_04 != rm_0.i) break block73;
                                                                                                                                                                                                    re_0<T> re_0100 = re_02;
                                                                                                                                                                                                    re_04 = ((rd_0)((Object)re_0100)).a(super.a(0.0, 1.0, 0.0));
                                                                                                                                                                                                    re_0<T> re_0101 = re_02;
                                                                                                                                                                                                    re_02 = ((rd_0)((Object)re_0101)).b(super.a(0.0, 1.0, 0.0));
                                                                                                                                                                                                    re_034 = re_02;
                                                                                                                                                                                                    if (re_02.b.d() < -0.9999999999) break block74;
                                                                                                                                                                                                    re_034 = re_02;
                                                                                                                                                                                                    if (!(re_035.b.d() > 0.9999999999)) break block75;
                                                                                                                                                                                                }
                                                                                                                                                                                                throw new rb_0(false);
                                                                                                                                                                                            }
                                                                                                                                                                                            re_0<T> re_0102 = re_04;
                                                                                                                                                                                            re_034 = re_0102;
                                                                                                                                                                                            re_0<T> re_0103 = re_04;
                                                                                                                                                                                            re_034 = re_0103;
                                                                                                                                                                                            re_0<T> re_0104 = re_02;
                                                                                                                                                                                            re_034 = re_0104;
                                                                                                                                                                                            re_0<T> re_0105 = re_02;
                                                                                                                                                                                            re_034 = re_0105;
                                                                                                                                                                                            re_034 = re_02;
                                                                                                                                                                                            return rd_0.a((kO)((kO)re_0102.a.h(re_0103.c)), (kO)((kO)re_0104.b.t()), (kO)((kO)re_0105.a.h(re_034.c.a())));
                                                                                                                                                                                        }
                                                                                                                                                                                        if (re_04 != rm_0.j) break block76;
                                                                                                                                                                                        re_0<T> re_0106 = re_02;
                                                                                                                                                                                        re_04 = ((rd_0)((Object)re_0106)).a(super.a(0.0, 1.0, 0.0));
                                                                                                                                                                                        re_0<T> re_0107 = re_02;
                                                                                                                                                                                        re_02 = ((rd_0)((Object)re_0107)).b(super.a(0.0, 1.0, 0.0));
                                                                                                                                                                                        re_032 = re_02;
                                                                                                                                                                                        if (re_02.b.d() < -0.9999999999) break block77;
                                                                                                                                                                                        re_032 = re_02;
                                                                                                                                                                                        if (!(re_033.b.d() > 0.9999999999)) break block78;
                                                                                                                                                                                    }
                                                                                                                                                                                    throw new rb_0(false);
                                                                                                                                                                                }
                                                                                                                                                                                re_0<T> re_0108 = re_04;
                                                                                                                                                                                re_032 = re_0108;
                                                                                                                                                                                re_0<T> re_0109 = re_04;
                                                                                                                                                                                re_032 = re_0109;
                                                                                                                                                                                re_0<T> re_0110 = re_02;
                                                                                                                                                                                re_032 = re_0110;
                                                                                                                                                                                re_0<T> re_0111 = re_02;
                                                                                                                                                                                re_032 = re_0111;
                                                                                                                                                                                re_032 = re_02;
                                                                                                                                                                                return rd_0.a((kO)((kO)re_0108.c.h(re_0109.a.a())), (kO)((kO)re_0110.b.t()), (kO)((kO)re_0111.c.h(re_032.a)));
                                                                                                                                                                            }
                                                                                                                                                                            if (re_04 != rm_0.k) break block79;
                                                                                                                                                                            re_0<T> re_0112 = re_02;
                                                                                                                                                                            re_04 = ((rd_0)((Object)re_0112)).a(super.a(0.0, 0.0, 1.0));
                                                                                                                                                                            re_0<T> re_0113 = re_02;
                                                                                                                                                                            re_02 = ((rd_0)((Object)re_0113)).b(super.a(0.0, 0.0, 1.0));
                                                                                                                                                                            re_030 = re_02;
                                                                                                                                                                            if (re_02.c.d() < -0.9999999999) break block80;
                                                                                                                                                                            re_030 = re_02;
                                                                                                                                                                            if (!(re_031.c.d() > 0.9999999999)) break block81;
                                                                                                                                                                        }
                                                                                                                                                                        throw new rb_0(false);
                                                                                                                                                                    }
                                                                                                                                                                    re_0<T> re_0114 = re_04;
                                                                                                                                                                    re_030 = re_0114;
                                                                                                                                                                    re_0<T> re_0115 = re_04;
                                                                                                                                                                    re_030 = re_0115;
                                                                                                                                                                    re_0<T> re_0116 = re_02;
                                                                                                                                                                    re_030 = re_0116;
                                                                                                                                                                    re_0<T> re_0117 = re_02;
                                                                                                                                                                    re_030 = re_0117;
                                                                                                                                                                    re_030 = re_02;
                                                                                                                                                                    return rd_0.a((kO)((kO)re_0114.a.h(re_0115.b.a())), (kO)((kO)re_0116.c.t()), (kO)((kO)re_0117.a.h(re_030.b)));
                                                                                                                                                                }
                                                                                                                                                                re_0<T> re_0118 = re_02;
                                                                                                                                                                re_04 = ((rd_0)((Object)re_0118)).a(super.a(0.0, 0.0, 1.0));
                                                                                                                                                                re_0<T> re_0119 = re_02;
                                                                                                                                                                re_02 = ((rd_0)((Object)re_0119)).b(super.a(0.0, 0.0, 1.0));
                                                                                                                                                                re_028 = re_02;
                                                                                                                                                                if (re_02.c.d() < -0.9999999999) break block82;
                                                                                                                                                                re_028 = re_02;
                                                                                                                                                                if (!(re_029.c.d() > 0.9999999999)) break block83;
                                                                                                                                                            }
                                                                                                                                                            throw new rb_0(false);
                                                                                                                                                        }
                                                                                                                                                        re_0<T> re_0120 = re_04;
                                                                                                                                                        re_028 = re_0120;
                                                                                                                                                        re_0<T> re_0121 = re_04;
                                                                                                                                                        re_028 = re_0121;
                                                                                                                                                        re_0<T> re_0122 = re_02;
                                                                                                                                                        re_028 = re_0122;
                                                                                                                                                        re_0<T> re_0123 = re_02;
                                                                                                                                                        re_028 = re_0123;
                                                                                                                                                        re_028 = re_02;
                                                                                                                                                        return rd_0.a((kO)((kO)re_0120.b.h(re_0121.a)), (kO)((kO)re_0122.c.t()), (kO)((kO)re_0123.b.h(re_028.a.a())));
                                                                                                                                                    }
                                                                                                                                                    if (re_04 != rm_0.a) break block84;
                                                                                                                                                    re_04 = ((rd_0)((Object)re_02)).a(rs_0.b);
                                                                                                                                                    re_026 = re_02 = ((rd_0)((Object)re_02)).b(rs_0.f);
                                                                                                                                                    if (re_02.a.d() < -0.9999999999) break block85;
                                                                                                                                                    re_026 = re_02;
                                                                                                                                                    if (!(re_027.a.d() > 0.9999999999)) break block86;
                                                                                                                                                }
                                                                                                                                                throw new rb_0(true);
                                                                                                                                            }
                                                                                                                                            re_0<T> re_0124 = re_02;
                                                                                                                                            re_026 = re_0124;
                                                                                                                                            re_0<T> re_0125 = re_02;
                                                                                                                                            re_026 = re_0125;
                                                                                                                                            re_0<T> re_0126 = re_02;
                                                                                                                                            re_026 = re_0126;
                                                                                                                                            re_0<T> re_0127 = re_04;
                                                                                                                                            re_026 = re_0127;
                                                                                                                                            re_026 = re_04;
                                                                                                                                            return rd_0.a((kO)((kO)((kO)re_0124.b.a()).h(re_0125.c)), (kO)((kO)re_0126.a.u()), (kO)((kO)((kO)re_0127.b.a()).h(re_026.a)));
                                                                                                                                        }
                                                                                                                                        if (re_04 != rm_0.b) break block87;
                                                                                                                                        re_04 = ((rd_0)((Object)re_02)).a(rs_0.b);
                                                                                                                                        re_02 = ((rd_0)((Object)re_02)).b(rs_0.d);
                                                                                                                                        re_024 = re_02;
                                                                                                                                        if (re_02.a.d() < -0.9999999999) break block88;
                                                                                                                                        re_024 = re_02;
                                                                                                                                        if (!(re_025.a.d() > 0.9999999999)) break block89;
                                                                                                                                    }
                                                                                                                                    throw new rb_0(true);
                                                                                                                                }
                                                                                                                                re_0<T> re_0128 = re_02;
                                                                                                                                re_024 = re_0128;
                                                                                                                                re_0<T> re_0129 = re_02;
                                                                                                                                re_024 = re_0129;
                                                                                                                                re_0<T> re_0130 = re_02;
                                                                                                                                re_024 = re_0130;
                                                                                                                                re_0<T> re_0131 = re_04;
                                                                                                                                re_024 = re_0131;
                                                                                                                                re_024 = re_04;
                                                                                                                                return rd_0.a((kO)((kO)re_0128.c.h(re_0129.b)), (kO)((kO)((kO)re_0130.a.u()).a()), (kO)((kO)re_0131.c.h(re_024.a)));
                                                                                                                            }
                                                                                                                            if (re_04 != rm_0.c) break block90;
                                                                                                                            re_04 = ((rd_0)((Object)re_02)).a(rs_0.d);
                                                                                                                            re_02 = ((rd_0)((Object)re_02)).b(rs_0.f);
                                                                                                                            re_022 = re_02;
                                                                                                                            if (re_02.b.d() < -0.9999999999) break block91;
                                                                                                                            re_022 = re_02;
                                                                                                                            if (!(re_023.b.d() > 0.9999999999)) break block92;
                                                                                                                        }
                                                                                                                        throw new rb_0(true);
                                                                                                                    }
                                                                                                                    re_0<T> re_0132 = re_02;
                                                                                                                    re_022 = re_0132;
                                                                                                                    re_0<T> re_0133 = re_02;
                                                                                                                    re_022 = re_0133;
                                                                                                                    re_0<T> re_0134 = re_02;
                                                                                                                    re_022 = re_0134;
                                                                                                                    re_0<T> re_0135 = re_04;
                                                                                                                    re_022 = re_0135;
                                                                                                                    re_022 = re_04;
                                                                                                                    return rd_0.a((kO)((kO)re_0132.a.h(re_0133.c)), (kO)((kO)((kO)re_0134.b.u()).a()), (kO)((kO)re_0135.a.h(re_022.b)));
                                                                                                                }
                                                                                                                if (re_04 != rm_0.d) break block93;
                                                                                                                re_04 = ((rd_0)((Object)re_02)).a(rs_0.d);
                                                                                                                re_02 = ((rd_0)((Object)re_02)).b(rs_0.b);
                                                                                                                re_020 = re_02;
                                                                                                                if (re_02.b.d() < -0.9999999999) break block94;
                                                                                                                re_020 = re_02;
                                                                                                                if (!(re_021.b.d() > 0.9999999999)) break block95;
                                                                                                            }
                                                                                                            throw new rb_0(true);
                                                                                                        }
                                                                                                        re_0<T> re_0136 = re_02;
                                                                                                        re_020 = re_0136;
                                                                                                        re_0<T> re_0137 = re_02;
                                                                                                        re_020 = re_0137;
                                                                                                        re_0<T> re_0138 = re_02;
                                                                                                        re_020 = re_0138;
                                                                                                        re_0<T> re_0139 = re_04;
                                                                                                        re_020 = re_0139;
                                                                                                        re_020 = re_04;
                                                                                                        return rd_0.a((kO)((kO)((kO)re_0136.c.a()).h(re_0137.a)), (kO)((kO)re_0138.b.u()), (kO)((kO)((kO)re_0139.c.a()).h(re_020.b)));
                                                                                                    }
                                                                                                    if (re_04 != rm_0.e) break block96;
                                                                                                    re_04 = ((rd_0)((Object)re_02)).a(rs_0.f);
                                                                                                    re_02 = ((rd_0)((Object)re_02)).b(rs_0.d);
                                                                                                    re_018 = re_02;
                                                                                                    if (re_02.c.d() < -0.9999999999) break block97;
                                                                                                    re_018 = re_02;
                                                                                                    if (!(re_019.c.d() > 0.9999999999)) break block98;
                                                                                                }
                                                                                                throw new rb_0(true);
                                                                                            }
                                                                                            re_0<T> re_0140 = re_02;
                                                                                            re_018 = re_0140;
                                                                                            re_0<T> re_0141 = re_02;
                                                                                            re_018 = re_0141;
                                                                                            re_0<T> re_0142 = re_02;
                                                                                            re_018 = re_0142;
                                                                                            re_0<T> re_0143 = re_04;
                                                                                            re_018 = re_0143;
                                                                                            re_018 = re_04;
                                                                                            return rd_0.a((kO)((kO)((kO)re_0140.a.a()).h(re_0141.b)), (kO)((kO)re_0142.c.u()), (kO)((kO)((kO)re_0143.a.a()).h(re_018.c)));
                                                                                        }
                                                                                        if (re_04 != rm_0.f) break block99;
                                                                                        re_04 = ((rd_0)((Object)re_02)).a(rs_0.f);
                                                                                        re_02 = ((rd_0)((Object)re_02)).b(rs_0.b);
                                                                                        re_016 = re_02;
                                                                                        if (re_02.c.d() < -0.9999999999) break block100;
                                                                                        re_016 = re_02;
                                                                                        if (!(re_017.c.d() > 0.9999999999)) break block101;
                                                                                    }
                                                                                    throw new rb_0(true);
                                                                                }
                                                                                re_0<T> re_0144 = re_02;
                                                                                re_016 = re_0144;
                                                                                re_0<T> re_0145 = re_02;
                                                                                re_016 = re_0145;
                                                                                re_0<T> re_0146 = re_02;
                                                                                re_016 = re_0146;
                                                                                re_0<T> re_0147 = re_04;
                                                                                re_016 = re_0147;
                                                                                re_016 = re_04;
                                                                                return rd_0.a((kO)((kO)re_0144.b.h(re_0145.a)), (kO)((kO)((kO)re_0146.c.u()).a()), (kO)((kO)re_0147.b.h(re_016.c)));
                                                                            }
                                                                            if (re_04 != rm_0.g) break block102;
                                                                            re_04 = ((rd_0)((Object)re_02)).a(rs_0.b);
                                                                            re_02 = ((rd_0)((Object)re_02)).b(rs_0.b);
                                                                            re_014 = re_02;
                                                                            if (re_02.a.d() < -0.9999999999) break block103;
                                                                            re_014 = re_02;
                                                                            if (!(re_015.a.d() > 0.9999999999)) break block104;
                                                                        }
                                                                        throw new rb_0(false);
                                                                    }
                                                                    re_0<T> re_0148 = re_02;
                                                                    re_014 = re_0148;
                                                                    re_0<T> re_0149 = re_02;
                                                                    re_014 = re_0149;
                                                                    re_0<T> re_0150 = re_02;
                                                                    re_014 = re_0150;
                                                                    re_0<T> re_0151 = re_04;
                                                                    re_014 = re_0151;
                                                                    re_014 = re_04;
                                                                    return rd_0.a((kO)((kO)re_0148.b.h(re_0149.c.a())), (kO)((kO)re_0150.a.t()), (kO)((kO)re_0151.b.h(re_014.c)));
                                                                }
                                                                if (re_04 != rm_0.h) break block105;
                                                                re_04 = ((rd_0)((Object)re_02)).a(rs_0.b);
                                                                re_02 = ((rd_0)((Object)re_02)).b(rs_0.b);
                                                                re_012 = re_02;
                                                                if (re_02.a.d() < -0.9999999999) break block106;
                                                                re_012 = re_02;
                                                                if (!(re_013.a.d() > 0.9999999999)) break block107;
                                                            }
                                                            throw new rb_0(false);
                                                        }
                                                        re_0<T> re_0152 = re_02;
                                                        re_012 = re_0152;
                                                        re_0<T> re_0153 = re_02;
                                                        re_012 = re_0153;
                                                        re_0<T> re_0154 = re_02;
                                                        re_012 = re_0154;
                                                        re_0<T> re_0155 = re_04;
                                                        re_012 = re_0155;
                                                        re_012 = re_04;
                                                        return rd_0.a((kO)((kO)re_0152.c.h(re_0153.b)), (kO)((kO)re_0154.a.t()), (kO)((kO)re_0155.c.h(re_012.b.a())));
                                                    }
                                                    if (re_04 != rm_0.i) break block108;
                                                    re_04 = ((rd_0)((Object)re_02)).a(rs_0.d);
                                                    re_02 = ((rd_0)((Object)re_02)).b(rs_0.d);
                                                    re_010 = re_02;
                                                    if (re_02.b.d() < -0.9999999999) break block109;
                                                    re_010 = re_02;
                                                    if (!(re_011.b.d() > 0.9999999999)) break block110;
                                                }
                                                throw new rb_0(false);
                                            }
                                            re_0<T> re_0156 = re_02;
                                            re_010 = re_0156;
                                            re_0<T> re_0157 = re_02;
                                            re_010 = re_0157;
                                            re_0<T> re_0158 = re_02;
                                            re_010 = re_0158;
                                            re_0<T> re_0159 = re_04;
                                            re_010 = re_0159;
                                            re_010 = re_04;
                                            return rd_0.a((kO)((kO)re_0156.a.h(re_0157.c)), (kO)((kO)re_0158.b.t()), (kO)((kO)re_0159.a.h(re_010.c.a())));
                                        }
                                        if (re_04 != rm_0.j) break block111;
                                        re_04 = ((rd_0)((Object)re_02)).a(rs_0.d);
                                        re_02 = ((rd_0)((Object)re_02)).b(rs_0.d);
                                        re_08 = re_02;
                                        if (re_02.b.d() < -0.9999999999) break block112;
                                        re_08 = re_02;
                                        if (!(re_09.b.d() > 0.9999999999)) break block113;
                                    }
                                    throw new rb_0(false);
                                }
                                re_0<T> re_0160 = re_02;
                                re_08 = re_0160;
                                re_0<T> re_0161 = re_02;
                                re_08 = re_0161;
                                re_0<T> re_0162 = re_02;
                                re_08 = re_0162;
                                re_0<T> re_0163 = re_04;
                                re_08 = re_0163;
                                re_08 = re_04;
                                return rd_0.a((kO)((kO)re_0160.c.h(re_0161.a.a())), (kO)((kO)re_0162.b.t()), (kO)((kO)re_0163.c.h(re_08.a)));
                            }
                            if (re_04 != rm_0.k) break block114;
                            re_04 = ((rd_0)((Object)re_02)).a(rs_0.f);
                            re_02 = ((rd_0)((Object)re_02)).b(rs_0.f);
                            re_06 = re_02;
                            if (re_02.c.d() < -0.9999999999) break block115;
                            re_06 = re_02;
                            if (!(re_07.c.d() > 0.9999999999)) break block116;
                        }
                        throw new rb_0(false);
                    }
                    re_0<T> re_0164 = re_02;
                    re_06 = re_0164;
                    re_0<T> re_0165 = re_02;
                    re_06 = re_0165;
                    re_0<T> re_0166 = re_02;
                    re_06 = re_0166;
                    re_0<T> re_0167 = re_04;
                    re_06 = re_0167;
                    re_06 = re_04;
                    return rd_0.a((kO)((kO)re_0164.a.h(re_0165.b.a())), (kO)((kO)re_0166.c.t()), (kO)((kO)re_0167.a.h(re_06.b)));
                }
                re_04 = ((rd_0)((Object)re_02)).a(rs_0.f);
                re_02 = ((rd_0)((Object)re_02)).b(rs_0.f);
                re_03 = re_02;
                if (re_02.c.d() < -0.9999999999) break block117;
                re_03 = re_02;
                if (!(re_05.c.d() > 0.9999999999)) break block118;
            }
            throw new rb_0(false);
        }
        re_0<T> re_0168 = re_02;
        re_03 = re_0168;
        re_0<T> re_0169 = re_02;
        re_03 = re_0169;
        re_0<T> re_0170 = re_02;
        re_03 = re_0170;
        re_0<T> re_0171 = re_04;
        re_03 = re_0171;
        re_03 = re_04;
        return rd_0.a((kO)((kO)re_0168.b.h(re_0169.a)), (kO)((kO)re_0170.c.t()), (kO)((kO)re_0171.b.h(re_03.a.a())));
    }

    private T[] a(rm_0 re_02, int n2) {
        re_0<T> re_03;
        re_0<T> re_04;
        block118: {
            block117: {
                re_0<T> re_05;
                block114: {
                    re_0<T> re_06;
                    re_0<T> re_07;
                    block116: {
                        block115: {
                            re_0<T> re_08;
                            block111: {
                                re_0<T> re_09;
                                re_0<T> re_010;
                                block113: {
                                    block112: {
                                        re_0<T> re_011;
                                        block108: {
                                            re_0<T> re_012;
                                            re_0<T> re_013;
                                            block110: {
                                                block109: {
                                                    re_0<T> re_014;
                                                    block105: {
                                                        re_0<T> re_015;
                                                        re_0<T> re_016;
                                                        block107: {
                                                            block106: {
                                                                re_0<T> re_017;
                                                                block102: {
                                                                    re_0<T> re_018;
                                                                    re_0<T> re_019;
                                                                    block104: {
                                                                        block103: {
                                                                            re_0<T> re_020;
                                                                            block99: {
                                                                                re_0<T> re_021;
                                                                                re_0<T> re_022;
                                                                                block101: {
                                                                                    block100: {
                                                                                        re_0<T> re_023;
                                                                                        block96: {
                                                                                            re_0<T> re_024;
                                                                                            re_0<T> re_025;
                                                                                            block98: {
                                                                                                block97: {
                                                                                                    re_0<T> re_026;
                                                                                                    block93: {
                                                                                                        re_0<T> re_027;
                                                                                                        re_0<T> re_028;
                                                                                                        block95: {
                                                                                                            block94: {
                                                                                                                re_0<T> re_029;
                                                                                                                block90: {
                                                                                                                    re_0<T> re_030;
                                                                                                                    re_0<T> re_031;
                                                                                                                    block92: {
                                                                                                                        block91: {
                                                                                                                            re_0<T> re_032;
                                                                                                                            block87: {
                                                                                                                                re_0<T> re_033;
                                                                                                                                re_0<T> re_034;
                                                                                                                                block89: {
                                                                                                                                    block88: {
                                                                                                                                        re_0<T> re_035;
                                                                                                                                        block84: {
                                                                                                                                            re_0<T> re_036;
                                                                                                                                            re_0<T> re_037;
                                                                                                                                            block86: {
                                                                                                                                                block85: {
                                                                                                                                                    re_0<T> re_038;
                                                                                                                                                    block48: {
                                                                                                                                                        re_0<T> re_039;
                                                                                                                                                        re_0<T> re_040;
                                                                                                                                                        block83: {
                                                                                                                                                            block82: {
                                                                                                                                                                re_0<T> re_041;
                                                                                                                                                                block79: {
                                                                                                                                                                    re_0<T> re_042;
                                                                                                                                                                    re_0<T> re_043;
                                                                                                                                                                    block81: {
                                                                                                                                                                        block80: {
                                                                                                                                                                            re_0<T> re_044;
                                                                                                                                                                            block76: {
                                                                                                                                                                                re_0<T> re_045;
                                                                                                                                                                                re_0<T> re_046;
                                                                                                                                                                                block78: {
                                                                                                                                                                                    block77: {
                                                                                                                                                                                        re_0<T> re_047;
                                                                                                                                                                                        block73: {
                                                                                                                                                                                            re_0<T> re_048;
                                                                                                                                                                                            re_0<T> re_049;
                                                                                                                                                                                            block75: {
                                                                                                                                                                                                block74: {
                                                                                                                                                                                                    re_0<T> re_050;
                                                                                                                                                                                                    block70: {
                                                                                                                                                                                                        re_0<T> re_051;
                                                                                                                                                                                                        re_0<T> re_052;
                                                                                                                                                                                                        block72: {
                                                                                                                                                                                                            block71: {
                                                                                                                                                                                                                re_0<T> re_053;
                                                                                                                                                                                                                block67: {
                                                                                                                                                                                                                    re_0<T> re_054;
                                                                                                                                                                                                                    re_0<T> re_055;
                                                                                                                                                                                                                    block69: {
                                                                                                                                                                                                                        block68: {
                                                                                                                                                                                                                            re_0<T> re_056;
                                                                                                                                                                                                                            block64: {
                                                                                                                                                                                                                                re_0<T> re_057;
                                                                                                                                                                                                                                re_0<T> re_058;
                                                                                                                                                                                                                                block66: {
                                                                                                                                                                                                                                    block65: {
                                                                                                                                                                                                                                        re_0<T> re_059;
                                                                                                                                                                                                                                        block61: {
                                                                                                                                                                                                                                            re_0<T> re_060;
                                                                                                                                                                                                                                            re_0<T> re_061;
                                                                                                                                                                                                                                            block63: {
                                                                                                                                                                                                                                                block62: {
                                                                                                                                                                                                                                                    re_0<T> re_062;
                                                                                                                                                                                                                                                    block58: {
                                                                                                                                                                                                                                                        re_0<T> re_063;
                                                                                                                                                                                                                                                        re_0<T> re_064;
                                                                                                                                                                                                                                                        block60: {
                                                                                                                                                                                                                                                            block59: {
                                                                                                                                                                                                                                                                re_0<T> re_065;
                                                                                                                                                                                                                                                                block55: {
                                                                                                                                                                                                                                                                    re_0<T> re_066;
                                                                                                                                                                                                                                                                    re_0<T> re_067;
                                                                                                                                                                                                                                                                    block57: {
                                                                                                                                                                                                                                                                        block56: {
                                                                                                                                                                                                                                                                            re_0<T> re_068;
                                                                                                                                                                                                                                                                            block52: {
                                                                                                                                                                                                                                                                                re_0<T> re_069;
                                                                                                                                                                                                                                                                                re_0<T> re_070;
                                                                                                                                                                                                                                                                                block54: {
                                                                                                                                                                                                                                                                                    block53: {
                                                                                                                                                                                                                                                                                        re_0<T> re_071;
                                                                                                                                                                                                                                                                                        block49: {
                                                                                                                                                                                                                                                                                            re_0<T> re_072;
                                                                                                                                                                                                                                                                                            re_0<T> re_073;
                                                                                                                                                                                                                                                                                            block51: {
                                                                                                                                                                                                                                                                                                block50: {
                                                                                                                                                                                                                                                                                                    re_0<T> re_074;
                                                                                                                                                                                                                                                                                                    if (n2 != rl_0.VECTOR_OPERATOR$59e4743c) break block48;
                                                                                                                                                                                                                                                                                                    if (re_02 != rm_0.a) break block49;
                                                                                                                                                                                                                                                                                                    rd_0 rd_02 = this;
                                                                                                                                                                                                                                                                                                    re_02 = rd_02.a(rd_02.a(0.0, 0.0, 1.0));
                                                                                                                                                                                                                                                                                                    rd_0 rd_03 = this;
                                                                                                                                                                                                                                                                                                    re_072 = re_073 = rd_03.b(rd_03.a(1.0, 0.0, 0.0));
                                                                                                                                                                                                                                                                                                    if (re_073.c.d() < -0.9999999999) break block50;
                                                                                                                                                                                                                                                                                                    re_072 = re_073;
                                                                                                                                                                                                                                                                                                    if (!(re_074.c.d() > 0.9999999999)) break block51;
                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                throw new rb_0(true);
                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                            re_0<T> re_075 = re_02;
                                                                                                                                                                                                                                                                                            re_072 = re_075;
                                                                                                                                                                                                                                                                                            re_0<T> re_076 = re_02;
                                                                                                                                                                                                                                                                                            re_072 = re_076;
                                                                                                                                                                                                                                                                                            re_0<T> re_077 = re_073;
                                                                                                                                                                                                                                                                                            re_072 = re_077;
                                                                                                                                                                                                                                                                                            re_0<T> re_078 = re_073;
                                                                                                                                                                                                                                                                                            re_072 = re_078;
                                                                                                                                                                                                                                                                                            re_072 = re_073;
                                                                                                                                                                                                                                                                                            return rd_0.a((kO)((kO)((kO)re_075.b.a()).h(re_076.c)), (kO)((kO)re_077.c.u()), (kO)((kO)((kO)re_078.b.a()).h(re_072.a)));
                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                        if (re_02 != rm_0.b) break block52;
                                                                                                                                                                                                                                                                                        rd_0 rd_04 = this;
                                                                                                                                                                                                                                                                                        re_02 = rd_04.a(rd_04.a(0.0, 1.0, 0.0));
                                                                                                                                                                                                                                                                                        rd_0 rd_05 = this;
                                                                                                                                                                                                                                                                                        re_069 = re_070 = rd_05.b(rd_05.a(1.0, 0.0, 0.0));
                                                                                                                                                                                                                                                                                        if (re_070.b.d() < -0.9999999999) break block53;
                                                                                                                                                                                                                                                                                        re_069 = re_070;
                                                                                                                                                                                                                                                                                        if (!(re_071.b.d() > 0.9999999999)) break block54;
                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                    throw new rb_0(true);
                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                re_0<T> re_079 = re_02;
                                                                                                                                                                                                                                                                                re_069 = re_079;
                                                                                                                                                                                                                                                                                re_0<T> re_080 = re_02;
                                                                                                                                                                                                                                                                                re_069 = re_080;
                                                                                                                                                                                                                                                                                re_0<T> re_081 = re_070;
                                                                                                                                                                                                                                                                                re_069 = re_081;
                                                                                                                                                                                                                                                                                re_0<T> re_082 = re_070;
                                                                                                                                                                                                                                                                                re_069 = re_082;
                                                                                                                                                                                                                                                                                re_069 = re_070;
                                                                                                                                                                                                                                                                                return rd_0.a((kO)((kO)re_079.c.h(re_080.b)), (kO)((kO)((kO)re_081.b.u()).a()), (kO)((kO)re_082.c.h(re_069.a)));
                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                            if (re_02 != rm_0.c) break block55;
                                                                                                                                                                                                                                                                            rd_0 rd_06 = this;
                                                                                                                                                                                                                                                                            re_02 = rd_06.a(rd_06.a(0.0, 0.0, 1.0));
                                                                                                                                                                                                                                                                            rd_0 rd_07 = this;
                                                                                                                                                                                                                                                                            re_066 = re_067 = rd_07.b(rd_07.a(0.0, 1.0, 0.0));
                                                                                                                                                                                                                                                                            if (re_067.c.d() < -0.9999999999) break block56;
                                                                                                                                                                                                                                                                            re_066 = re_067;
                                                                                                                                                                                                                                                                            if (!(re_068.c.d() > 0.9999999999)) break block57;
                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                        throw new rb_0(true);
                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                    re_0<T> re_083 = re_02;
                                                                                                                                                                                                                                                                    re_066 = re_083;
                                                                                                                                                                                                                                                                    re_0<T> re_084 = re_02;
                                                                                                                                                                                                                                                                    re_066 = re_084;
                                                                                                                                                                                                                                                                    re_0<T> re_085 = re_067;
                                                                                                                                                                                                                                                                    re_066 = re_085;
                                                                                                                                                                                                                                                                    re_0<T> re_086 = re_067;
                                                                                                                                                                                                                                                                    re_066 = re_086;
                                                                                                                                                                                                                                                                    re_066 = re_067;
                                                                                                                                                                                                                                                                    return rd_0.a((kO)((kO)re_083.a.h(re_084.c)), (kO)((kO)((kO)re_085.c.u()).a()), (kO)((kO)re_086.a.h(re_066.b)));
                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                if (re_02 != rm_0.d) break block58;
                                                                                                                                                                                                                                                                rd_0 rd_08 = this;
                                                                                                                                                                                                                                                                re_02 = rd_08.a(rd_08.a(1.0, 0.0, 0.0));
                                                                                                                                                                                                                                                                rd_0 rd_09 = this;
                                                                                                                                                                                                                                                                re_063 = re_064 = rd_09.b(rd_09.a(0.0, 1.0, 0.0));
                                                                                                                                                                                                                                                                if (re_064.a.d() < -0.9999999999) break block59;
                                                                                                                                                                                                                                                                re_063 = re_064;
                                                                                                                                                                                                                                                                if (!(re_065.a.d() > 0.9999999999)) break block60;
                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                            throw new rb_0(true);
                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                        re_0<T> re_087 = re_02;
                                                                                                                                                                                                                                                        re_063 = re_087;
                                                                                                                                                                                                                                                        re_0<T> re_088 = re_02;
                                                                                                                                                                                                                                                        re_063 = re_088;
                                                                                                                                                                                                                                                        re_0<T> re_089 = re_064;
                                                                                                                                                                                                                                                        re_063 = re_089;
                                                                                                                                                                                                                                                        re_0<T> re_090 = re_064;
                                                                                                                                                                                                                                                        re_063 = re_090;
                                                                                                                                                                                                                                                        re_063 = re_064;
                                                                                                                                                                                                                                                        return rd_0.a((kO)((kO)((kO)re_087.c.a()).h(re_088.a)), (kO)((kO)re_089.a.u()), (kO)((kO)((kO)re_090.c.a()).h(re_063.b)));
                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                    if (re_02 != rm_0.e) break block61;
                                                                                                                                                                                                                                                    rd_0 rd_010 = this;
                                                                                                                                                                                                                                                    re_02 = rd_010.a(rd_010.a(0.0, 1.0, 0.0));
                                                                                                                                                                                                                                                    rd_0 rd_011 = this;
                                                                                                                                                                                                                                                    re_060 = re_061 = rd_011.b(rd_011.a(0.0, 0.0, 1.0));
                                                                                                                                                                                                                                                    if (re_061.b.d() < -0.9999999999) break block62;
                                                                                                                                                                                                                                                    re_060 = re_061;
                                                                                                                                                                                                                                                    if (!(re_062.b.d() > 0.9999999999)) break block63;
                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                throw new rb_0(true);
                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                            re_0<T> re_091 = re_02;
                                                                                                                                                                                                                                            re_060 = re_091;
                                                                                                                                                                                                                                            re_0<T> re_092 = re_02;
                                                                                                                                                                                                                                            re_060 = re_092;
                                                                                                                                                                                                                                            re_0<T> re_093 = re_061;
                                                                                                                                                                                                                                            re_060 = re_093;
                                                                                                                                                                                                                                            re_0<T> re_094 = re_061;
                                                                                                                                                                                                                                            re_060 = re_094;
                                                                                                                                                                                                                                            re_060 = re_061;
                                                                                                                                                                                                                                            return rd_0.a((kO)((kO)((kO)re_091.a.a()).h(re_092.b)), (kO)((kO)re_093.b.u()), (kO)((kO)((kO)re_094.a.a()).h(re_060.c)));
                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                        if (re_02 != rm_0.f) break block64;
                                                                                                                                                                                                                                        rd_0 rd_012 = this;
                                                                                                                                                                                                                                        re_02 = rd_012.a(rd_012.a(1.0, 0.0, 0.0));
                                                                                                                                                                                                                                        rd_0 rd_013 = this;
                                                                                                                                                                                                                                        re_057 = re_058 = rd_013.b(rd_013.a(0.0, 0.0, 1.0));
                                                                                                                                                                                                                                        if (re_058.a.d() < -0.9999999999) break block65;
                                                                                                                                                                                                                                        re_057 = re_058;
                                                                                                                                                                                                                                        if (!(re_059.a.d() > 0.9999999999)) break block66;
                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                    throw new rb_0(true);
                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                re_0<T> re_095 = re_02;
                                                                                                                                                                                                                                re_057 = re_095;
                                                                                                                                                                                                                                re_0<T> re_096 = re_02;
                                                                                                                                                                                                                                re_057 = re_096;
                                                                                                                                                                                                                                re_0<T> re_097 = re_058;
                                                                                                                                                                                                                                re_057 = re_097;
                                                                                                                                                                                                                                re_0<T> re_098 = re_058;
                                                                                                                                                                                                                                re_057 = re_098;
                                                                                                                                                                                                                                re_057 = re_058;
                                                                                                                                                                                                                                return rd_0.a((kO)((kO)re_095.b.h(re_096.a)), (kO)((kO)((kO)re_097.a.u()).a()), (kO)((kO)re_098.b.h(re_057.c)));
                                                                                                                                                                                                                            }
                                                                                                                                                                                                                            if (re_02 != rm_0.g) break block67;
                                                                                                                                                                                                                            rd_0 rd_014 = this;
                                                                                                                                                                                                                            re_02 = rd_014.a(rd_014.a(1.0, 0.0, 0.0));
                                                                                                                                                                                                                            rd_0 rd_015 = this;
                                                                                                                                                                                                                            re_054 = re_055 = rd_015.b(rd_015.a(1.0, 0.0, 0.0));
                                                                                                                                                                                                                            if (re_055.a.d() < -0.9999999999) break block68;
                                                                                                                                                                                                                            re_054 = re_055;
                                                                                                                                                                                                                            if (!(re_056.a.d() > 0.9999999999)) break block69;
                                                                                                                                                                                                                        }
                                                                                                                                                                                                                        throw new rb_0(false);
                                                                                                                                                                                                                    }
                                                                                                                                                                                                                    re_0<T> re_099 = re_02;
                                                                                                                                                                                                                    re_054 = re_099;
                                                                                                                                                                                                                    re_0<T> re_0100 = re_02;
                                                                                                                                                                                                                    re_054 = re_0100;
                                                                                                                                                                                                                    re_0<T> re_0101 = re_055;
                                                                                                                                                                                                                    re_054 = re_0101;
                                                                                                                                                                                                                    re_0<T> re_0102 = re_055;
                                                                                                                                                                                                                    re_054 = re_0102;
                                                                                                                                                                                                                    re_054 = re_055;
                                                                                                                                                                                                                    return rd_0.a((kO)((kO)re_099.b.h(re_0100.c.a())), (kO)((kO)re_0101.a.t()), (kO)((kO)re_0102.b.h(re_054.c)));
                                                                                                                                                                                                                }
                                                                                                                                                                                                                if (re_02 != rm_0.h) break block70;
                                                                                                                                                                                                                rd_0 rd_016 = this;
                                                                                                                                                                                                                re_02 = rd_016.a(rd_016.a(1.0, 0.0, 0.0));
                                                                                                                                                                                                                rd_0 rd_017 = this;
                                                                                                                                                                                                                re_051 = re_052 = rd_017.b(rd_017.a(1.0, 0.0, 0.0));
                                                                                                                                                                                                                if (re_052.a.d() < -0.9999999999) break block71;
                                                                                                                                                                                                                re_051 = re_052;
                                                                                                                                                                                                                if (!(re_053.a.d() > 0.9999999999)) break block72;
                                                                                                                                                                                                            }
                                                                                                                                                                                                            throw new rb_0(false);
                                                                                                                                                                                                        }
                                                                                                                                                                                                        re_0<T> re_0103 = re_02;
                                                                                                                                                                                                        re_051 = re_0103;
                                                                                                                                                                                                        re_0<T> re_0104 = re_02;
                                                                                                                                                                                                        re_051 = re_0104;
                                                                                                                                                                                                        re_0<T> re_0105 = re_052;
                                                                                                                                                                                                        re_051 = re_0105;
                                                                                                                                                                                                        re_0<T> re_0106 = re_052;
                                                                                                                                                                                                        re_051 = re_0106;
                                                                                                                                                                                                        re_051 = re_052;
                                                                                                                                                                                                        return rd_0.a((kO)((kO)re_0103.c.h(re_0104.b)), (kO)((kO)re_0105.a.t()), (kO)((kO)re_0106.c.h(re_051.b.a())));
                                                                                                                                                                                                    }
                                                                                                                                                                                                    if (re_02 != rm_0.i) break block73;
                                                                                                                                                                                                    rd_0 rd_018 = this;
                                                                                                                                                                                                    re_02 = rd_018.a(rd_018.a(0.0, 1.0, 0.0));
                                                                                                                                                                                                    rd_0 rd_019 = this;
                                                                                                                                                                                                    re_048 = re_049 = rd_019.b(rd_019.a(0.0, 1.0, 0.0));
                                                                                                                                                                                                    if (re_049.b.d() < -0.9999999999) break block74;
                                                                                                                                                                                                    re_048 = re_049;
                                                                                                                                                                                                    if (!(re_050.b.d() > 0.9999999999)) break block75;
                                                                                                                                                                                                }
                                                                                                                                                                                                throw new rb_0(false);
                                                                                                                                                                                            }
                                                                                                                                                                                            re_0<T> re_0107 = re_02;
                                                                                                                                                                                            re_048 = re_0107;
                                                                                                                                                                                            re_0<T> re_0108 = re_02;
                                                                                                                                                                                            re_048 = re_0108;
                                                                                                                                                                                            re_0<T> re_0109 = re_049;
                                                                                                                                                                                            re_048 = re_0109;
                                                                                                                                                                                            re_0<T> re_0110 = re_049;
                                                                                                                                                                                            re_048 = re_0110;
                                                                                                                                                                                            re_048 = re_049;
                                                                                                                                                                                            return rd_0.a((kO)((kO)re_0107.a.h(re_0108.c)), (kO)((kO)re_0109.b.t()), (kO)((kO)re_0110.a.h(re_048.c.a())));
                                                                                                                                                                                        }
                                                                                                                                                                                        if (re_02 != rm_0.j) break block76;
                                                                                                                                                                                        rd_0 rd_020 = this;
                                                                                                                                                                                        re_02 = rd_020.a(rd_020.a(0.0, 1.0, 0.0));
                                                                                                                                                                                        rd_0 rd_021 = this;
                                                                                                                                                                                        re_045 = re_046 = rd_021.b(rd_021.a(0.0, 1.0, 0.0));
                                                                                                                                                                                        if (re_046.b.d() < -0.9999999999) break block77;
                                                                                                                                                                                        re_045 = re_046;
                                                                                                                                                                                        if (!(re_047.b.d() > 0.9999999999)) break block78;
                                                                                                                                                                                    }
                                                                                                                                                                                    throw new rb_0(false);
                                                                                                                                                                                }
                                                                                                                                                                                re_0<T> re_0111 = re_02;
                                                                                                                                                                                re_045 = re_0111;
                                                                                                                                                                                re_0<T> re_0112 = re_02;
                                                                                                                                                                                re_045 = re_0112;
                                                                                                                                                                                re_0<T> re_0113 = re_046;
                                                                                                                                                                                re_045 = re_0113;
                                                                                                                                                                                re_0<T> re_0114 = re_046;
                                                                                                                                                                                re_045 = re_0114;
                                                                                                                                                                                re_045 = re_046;
                                                                                                                                                                                return rd_0.a((kO)((kO)re_0111.c.h(re_0112.a.a())), (kO)((kO)re_0113.b.t()), (kO)((kO)re_0114.c.h(re_045.a)));
                                                                                                                                                                            }
                                                                                                                                                                            if (re_02 != rm_0.k) break block79;
                                                                                                                                                                            rd_0 rd_022 = this;
                                                                                                                                                                            re_02 = rd_022.a(rd_022.a(0.0, 0.0, 1.0));
                                                                                                                                                                            rd_0 rd_023 = this;
                                                                                                                                                                            re_042 = re_043 = rd_023.b(rd_023.a(0.0, 0.0, 1.0));
                                                                                                                                                                            if (re_043.c.d() < -0.9999999999) break block80;
                                                                                                                                                                            re_042 = re_043;
                                                                                                                                                                            if (!(re_044.c.d() > 0.9999999999)) break block81;
                                                                                                                                                                        }
                                                                                                                                                                        throw new rb_0(false);
                                                                                                                                                                    }
                                                                                                                                                                    re_0<T> re_0115 = re_02;
                                                                                                                                                                    re_042 = re_0115;
                                                                                                                                                                    re_0<T> re_0116 = re_02;
                                                                                                                                                                    re_042 = re_0116;
                                                                                                                                                                    re_0<T> re_0117 = re_043;
                                                                                                                                                                    re_042 = re_0117;
                                                                                                                                                                    re_0<T> re_0118 = re_043;
                                                                                                                                                                    re_042 = re_0118;
                                                                                                                                                                    re_042 = re_043;
                                                                                                                                                                    return rd_0.a((kO)((kO)re_0115.a.h(re_0116.b.a())), (kO)((kO)re_0117.c.t()), (kO)((kO)re_0118.a.h(re_042.b)));
                                                                                                                                                                }
                                                                                                                                                                rd_0 rd_024 = this;
                                                                                                                                                                re_02 = rd_024.a(rd_024.a(0.0, 0.0, 1.0));
                                                                                                                                                                rd_0 rd_025 = this;
                                                                                                                                                                re_039 = re_040 = rd_025.b(rd_025.a(0.0, 0.0, 1.0));
                                                                                                                                                                if (re_040.c.d() < -0.9999999999) break block82;
                                                                                                                                                                re_039 = re_040;
                                                                                                                                                                if (!(re_041.c.d() > 0.9999999999)) break block83;
                                                                                                                                                            }
                                                                                                                                                            throw new rb_0(false);
                                                                                                                                                        }
                                                                                                                                                        re_0<T> re_0119 = re_02;
                                                                                                                                                        re_039 = re_0119;
                                                                                                                                                        re_0<T> re_0120 = re_02;
                                                                                                                                                        re_039 = re_0120;
                                                                                                                                                        re_0<T> re_0121 = re_040;
                                                                                                                                                        re_039 = re_0121;
                                                                                                                                                        re_0<T> re_0122 = re_040;
                                                                                                                                                        re_039 = re_0122;
                                                                                                                                                        re_039 = re_040;
                                                                                                                                                        return rd_0.a((kO)((kO)re_0119.b.h(re_0120.a)), (kO)((kO)re_0121.c.t()), (kO)((kO)re_0122.b.h(re_039.a.a())));
                                                                                                                                                    }
                                                                                                                                                    if (re_02 != rm_0.a) break block84;
                                                                                                                                                    re_02 = this.a(rs_0.b);
                                                                                                                                                    re_036 = re_037 = this.b(rs_0.f);
                                                                                                                                                    if (re_037.a.d() < -0.9999999999) break block85;
                                                                                                                                                    re_036 = re_037;
                                                                                                                                                    if (!(re_038.a.d() > 0.9999999999)) break block86;
                                                                                                                                                }
                                                                                                                                                throw new rb_0(true);
                                                                                                                                            }
                                                                                                                                            re_0<T> re_0123 = re_037;
                                                                                                                                            re_036 = re_0123;
                                                                                                                                            re_0<T> re_0124 = re_037;
                                                                                                                                            re_036 = re_0124;
                                                                                                                                            re_0<T> re_0125 = re_037;
                                                                                                                                            re_036 = re_0125;
                                                                                                                                            re_0<T> re_0126 = re_02;
                                                                                                                                            re_036 = re_0126;
                                                                                                                                            re_036 = re_02;
                                                                                                                                            return rd_0.a((kO)((kO)((kO)re_0123.b.a()).h(re_0124.c)), (kO)((kO)re_0125.a.u()), (kO)((kO)((kO)re_0126.b.a()).h(re_036.a)));
                                                                                                                                        }
                                                                                                                                        if (re_02 != rm_0.b) break block87;
                                                                                                                                        re_02 = this.a(rs_0.b);
                                                                                                                                        re_033 = re_034 = this.b(rs_0.d);
                                                                                                                                        if (re_034.a.d() < -0.9999999999) break block88;
                                                                                                                                        re_033 = re_034;
                                                                                                                                        if (!(re_035.a.d() > 0.9999999999)) break block89;
                                                                                                                                    }
                                                                                                                                    throw new rb_0(true);
                                                                                                                                }
                                                                                                                                re_0<T> re_0127 = re_034;
                                                                                                                                re_033 = re_0127;
                                                                                                                                re_0<T> re_0128 = re_034;
                                                                                                                                re_033 = re_0128;
                                                                                                                                re_0<T> re_0129 = re_034;
                                                                                                                                re_033 = re_0129;
                                                                                                                                re_0<T> re_0130 = re_02;
                                                                                                                                re_033 = re_0130;
                                                                                                                                re_033 = re_02;
                                                                                                                                return rd_0.a((kO)((kO)re_0127.c.h(re_0128.b)), (kO)((kO)((kO)re_0129.a.u()).a()), (kO)((kO)re_0130.c.h(re_033.a)));
                                                                                                                            }
                                                                                                                            if (re_02 != rm_0.c) break block90;
                                                                                                                            re_02 = this.a(rs_0.d);
                                                                                                                            re_030 = re_031 = this.b(rs_0.f);
                                                                                                                            if (re_031.b.d() < -0.9999999999) break block91;
                                                                                                                            re_030 = re_031;
                                                                                                                            if (!(re_032.b.d() > 0.9999999999)) break block92;
                                                                                                                        }
                                                                                                                        throw new rb_0(true);
                                                                                                                    }
                                                                                                                    re_0<T> re_0131 = re_031;
                                                                                                                    re_030 = re_0131;
                                                                                                                    re_0<T> re_0132 = re_031;
                                                                                                                    re_030 = re_0132;
                                                                                                                    re_0<T> re_0133 = re_031;
                                                                                                                    re_030 = re_0133;
                                                                                                                    re_0<T> re_0134 = re_02;
                                                                                                                    re_030 = re_0134;
                                                                                                                    re_030 = re_02;
                                                                                                                    return rd_0.a((kO)((kO)re_0131.a.h(re_0132.c)), (kO)((kO)((kO)re_0133.b.u()).a()), (kO)((kO)re_0134.a.h(re_030.b)));
                                                                                                                }
                                                                                                                if (re_02 != rm_0.d) break block93;
                                                                                                                re_02 = this.a(rs_0.d);
                                                                                                                re_027 = re_028 = this.b(rs_0.b);
                                                                                                                if (re_028.b.d() < -0.9999999999) break block94;
                                                                                                                re_027 = re_028;
                                                                                                                if (!(re_029.b.d() > 0.9999999999)) break block95;
                                                                                                            }
                                                                                                            throw new rb_0(true);
                                                                                                        }
                                                                                                        re_0<T> re_0135 = re_028;
                                                                                                        re_027 = re_0135;
                                                                                                        re_0<T> re_0136 = re_028;
                                                                                                        re_027 = re_0136;
                                                                                                        re_0<T> re_0137 = re_028;
                                                                                                        re_027 = re_0137;
                                                                                                        re_0<T> re_0138 = re_02;
                                                                                                        re_027 = re_0138;
                                                                                                        re_027 = re_02;
                                                                                                        return rd_0.a((kO)((kO)((kO)re_0135.c.a()).h(re_0136.a)), (kO)((kO)re_0137.b.u()), (kO)((kO)((kO)re_0138.c.a()).h(re_027.b)));
                                                                                                    }
                                                                                                    if (re_02 != rm_0.e) break block96;
                                                                                                    re_02 = this.a(rs_0.f);
                                                                                                    re_024 = re_025 = this.b(rs_0.d);
                                                                                                    if (re_025.c.d() < -0.9999999999) break block97;
                                                                                                    re_024 = re_025;
                                                                                                    if (!(re_026.c.d() > 0.9999999999)) break block98;
                                                                                                }
                                                                                                throw new rb_0(true);
                                                                                            }
                                                                                            re_0<T> re_0139 = re_025;
                                                                                            re_024 = re_0139;
                                                                                            re_0<T> re_0140 = re_025;
                                                                                            re_024 = re_0140;
                                                                                            re_0<T> re_0141 = re_025;
                                                                                            re_024 = re_0141;
                                                                                            re_0<T> re_0142 = re_02;
                                                                                            re_024 = re_0142;
                                                                                            re_024 = re_02;
                                                                                            return rd_0.a((kO)((kO)((kO)re_0139.a.a()).h(re_0140.b)), (kO)((kO)re_0141.c.u()), (kO)((kO)((kO)re_0142.a.a()).h(re_024.c)));
                                                                                        }
                                                                                        if (re_02 != rm_0.f) break block99;
                                                                                        re_02 = this.a(rs_0.f);
                                                                                        re_021 = re_022 = this.b(rs_0.b);
                                                                                        if (re_022.c.d() < -0.9999999999) break block100;
                                                                                        re_021 = re_022;
                                                                                        if (!(re_023.c.d() > 0.9999999999)) break block101;
                                                                                    }
                                                                                    throw new rb_0(true);
                                                                                }
                                                                                re_0<T> re_0143 = re_022;
                                                                                re_021 = re_0143;
                                                                                re_0<T> re_0144 = re_022;
                                                                                re_021 = re_0144;
                                                                                re_0<T> re_0145 = re_022;
                                                                                re_021 = re_0145;
                                                                                re_0<T> re_0146 = re_02;
                                                                                re_021 = re_0146;
                                                                                re_021 = re_02;
                                                                                return rd_0.a((kO)((kO)re_0143.b.h(re_0144.a)), (kO)((kO)((kO)re_0145.c.u()).a()), (kO)((kO)re_0146.b.h(re_021.c)));
                                                                            }
                                                                            if (re_02 != rm_0.g) break block102;
                                                                            re_02 = this.a(rs_0.b);
                                                                            re_018 = re_019 = this.b(rs_0.b);
                                                                            if (re_019.a.d() < -0.9999999999) break block103;
                                                                            re_018 = re_019;
                                                                            if (!(re_020.a.d() > 0.9999999999)) break block104;
                                                                        }
                                                                        throw new rb_0(false);
                                                                    }
                                                                    re_0<T> re_0147 = re_019;
                                                                    re_018 = re_0147;
                                                                    re_0<T> re_0148 = re_019;
                                                                    re_018 = re_0148;
                                                                    re_0<T> re_0149 = re_019;
                                                                    re_018 = re_0149;
                                                                    re_0<T> re_0150 = re_02;
                                                                    re_018 = re_0150;
                                                                    re_018 = re_02;
                                                                    return rd_0.a((kO)((kO)re_0147.b.h(re_0148.c.a())), (kO)((kO)re_0149.a.t()), (kO)((kO)re_0150.b.h(re_018.c)));
                                                                }
                                                                if (re_02 != rm_0.h) break block105;
                                                                re_02 = this.a(rs_0.b);
                                                                re_015 = re_016 = this.b(rs_0.b);
                                                                if (re_016.a.d() < -0.9999999999) break block106;
                                                                re_015 = re_016;
                                                                if (!(re_017.a.d() > 0.9999999999)) break block107;
                                                            }
                                                            throw new rb_0(false);
                                                        }
                                                        re_0<T> re_0151 = re_016;
                                                        re_015 = re_0151;
                                                        re_0<T> re_0152 = re_016;
                                                        re_015 = re_0152;
                                                        re_0<T> re_0153 = re_016;
                                                        re_015 = re_0153;
                                                        re_0<T> re_0154 = re_02;
                                                        re_015 = re_0154;
                                                        re_015 = re_02;
                                                        return rd_0.a((kO)((kO)re_0151.c.h(re_0152.b)), (kO)((kO)re_0153.a.t()), (kO)((kO)re_0154.c.h(re_015.b.a())));
                                                    }
                                                    if (re_02 != rm_0.i) break block108;
                                                    re_02 = this.a(rs_0.d);
                                                    re_012 = re_013 = this.b(rs_0.d);
                                                    if (re_013.b.d() < -0.9999999999) break block109;
                                                    re_012 = re_013;
                                                    if (!(re_014.b.d() > 0.9999999999)) break block110;
                                                }
                                                throw new rb_0(false);
                                            }
                                            re_0<T> re_0155 = re_013;
                                            re_012 = re_0155;
                                            re_0<T> re_0156 = re_013;
                                            re_012 = re_0156;
                                            re_0<T> re_0157 = re_013;
                                            re_012 = re_0157;
                                            re_0<T> re_0158 = re_02;
                                            re_012 = re_0158;
                                            re_012 = re_02;
                                            return rd_0.a((kO)((kO)re_0155.a.h(re_0156.c)), (kO)((kO)re_0157.b.t()), (kO)((kO)re_0158.a.h(re_012.c.a())));
                                        }
                                        if (re_02 != rm_0.j) break block111;
                                        re_02 = this.a(rs_0.d);
                                        re_09 = re_010 = this.b(rs_0.d);
                                        if (re_010.b.d() < -0.9999999999) break block112;
                                        re_09 = re_010;
                                        if (!(re_011.b.d() > 0.9999999999)) break block113;
                                    }
                                    throw new rb_0(false);
                                }
                                re_0<T> re_0159 = re_010;
                                re_09 = re_0159;
                                re_0<T> re_0160 = re_010;
                                re_09 = re_0160;
                                re_0<T> re_0161 = re_010;
                                re_09 = re_0161;
                                re_0<T> re_0162 = re_02;
                                re_09 = re_0162;
                                re_09 = re_02;
                                return rd_0.a((kO)((kO)re_0159.c.h(re_0160.a.a())), (kO)((kO)re_0161.b.t()), (kO)((kO)re_0162.c.h(re_09.a)));
                            }
                            if (re_02 != rm_0.k) break block114;
                            re_02 = this.a(rs_0.f);
                            re_06 = re_07 = this.b(rs_0.f);
                            if (re_07.c.d() < -0.9999999999) break block115;
                            re_06 = re_07;
                            if (!(re_08.c.d() > 0.9999999999)) break block116;
                        }
                        throw new rb_0(false);
                    }
                    re_0<T> re_0163 = re_07;
                    re_06 = re_0163;
                    re_0<T> re_0164 = re_07;
                    re_06 = re_0164;
                    re_0<T> re_0165 = re_07;
                    re_06 = re_0165;
                    re_0<T> re_0166 = re_02;
                    re_06 = re_0166;
                    re_06 = re_02;
                    return rd_0.a((kO)((kO)re_0163.a.h(re_0164.b.a())), (kO)((kO)re_0165.c.t()), (kO)((kO)re_0166.a.h(re_06.b)));
                }
                re_02 = this.a(rs_0.f);
                re_03 = re_04 = this.b(rs_0.f);
                if (re_04.c.d() < -0.9999999999) break block117;
                re_03 = re_04;
                if (!(re_05.c.d() > 0.9999999999)) break block118;
            }
            throw new rb_0(false);
        }
        re_0<T> re_0167 = re_04;
        re_03 = re_0167;
        re_0<T> re_0168 = re_04;
        re_03 = re_0168;
        re_0<T> re_0169 = re_04;
        re_03 = re_0169;
        re_0<T> re_0170 = re_02;
        re_03 = re_0170;
        re_03 = re_02;
        return rd_0.a((kO)((kO)re_0167.b.h(re_0168.a)), (kO)((kO)re_0169.c.t()), (kO)((kO)re_0170.b.h(re_03.a.a())));
    }

    private static T[] a(T t, T t2, T t3) {
        kO[] kOArray = (kO[])ch_0.a(t.c(), 3);
        kO[] kOArray2 = kOArray;
        kOArray[0] = t;
        kOArray2[1] = t2;
        kOArray2[2] = t3;
        return kOArray2;
    }

    private re_0<T> a(double d2, double d3, double d4) {
        kO kO2 = (kO)this.b.c().a();
        return new re_0<kO>((kO)kO2.a(d2), (kO)kO2.a(d3), (kO)kO2.a(d4));
    }

    private T[][] h() {
        kO kO2 = (kO)this.b.c(this.b);
        kO kO3 = (kO)this.b.c(this.c);
        kO kO4 = (kO)this.b.c(this.d);
        kO kO5 = (kO)this.b.c(this.e);
        kO kO6 = (kO)this.c.c(this.c);
        kO kO7 = (kO)this.c.c(this.d);
        kO kO8 = (kO)this.c.c(this.e);
        kO kO9 = (kO)this.d.c(this.d);
        kO kO10 = (kO)this.d.c(this.e);
        kO kO11 = (kO)this.e.c(this.e);
        kO[][] kOArray = (kO[][])ch_0.a(this.b.c(), 3, 3);
        kOArray[0][0] = (kO)((kO)kO2.a(kO6).a(2)).b(1.0);
        kOArray[1][0] = (kO)kO7.b(kO5).a(2);
        kOArray[2][0] = (kO)kO8.a(kO4).a(2);
        kOArray[0][1] = (kO)kO7.a(kO5).a(2);
        kOArray[1][1] = (kO)((kO)kO2.a(kO9).a(2)).b(1.0);
        kOArray[2][1] = (kO)kO10.b(kO3).a(2);
        kOArray[0][2] = (kO)kO8.b(kO4).a(2);
        kOArray[1][2] = (kO)kO10.a(kO3).a(2);
        kOArray[2][2] = (kO)((kO)kO2.a(kO11).a(2)).b(1.0);
        return kOArray;
    }

    private rk_0 i() {
        return new rk_0(this.b.d(), this.c.d(), this.d.d(), this.e.d(), false);
    }

    private re_0<T> a(re_0<T> re_02) {
        Object object = re_02;
        T t = ((re_0)object).a;
        object = re_02;
        T t2 = ((re_0)object).b;
        object = re_02;
        re_02 = ((re_0)object).c;
        object = (kO)((Object)((kO)((kO)this.c.c(t)).a(this.d.c(t2))).a(this.e.c((T)re_02)));
        return new re_0<kO>((kO)((kO)((kO)((kO)this.b.c(((kO)t.c(this.b)).b(((kO)((Object)this.d.c((T)re_02))).b(this.e.c(t2))))).a(object.c(this.c))).a(2)).b(t), (kO)((kO)((kO)((kO)((Object)this.b.c((T)((kO)t2.c(this.b)).b(((kO)this.e.c(t)).b(this.c.c((T)re_02)))))).a(object.c(this.d))).a(2)).b(t2), (kO)((Object)((kO)((kO)((kO)this.b.c(((kO)re_02.c(this.b)).b(((kO)this.c.c(t2)).b(this.d.c(t))))).a(object.c(this.e))).a(2)).b(re_02)));
    }

    private re_0<T> a(rs_0 object) {
        rs_0 rs_02 = object;
        double d2 = rs_02.i;
        rs_02 = object;
        double d3 = rs_02.j;
        rs_02 = object;
        double d4 = rs_02.k;
        object = (kO)((kO)((kO)this.c.c(d2)).a(this.d.c(d3))).a(this.e.c(d4));
        return new re_0<kO>((kO)((kO)((kO)((kO)this.b.c(((kO)this.b.c(d2)).b(((kO)this.d.c(d4)).b(this.e.c(d3))))).a(object.c(this.c))).a(2)).b(d2), (kO)((kO)((kO)((kO)this.b.c(((kO)this.b.c(d3)).b(((kO)this.e.c(d2)).b(this.c.c(d4))))).a(object.c(this.d))).a(2)).b(d3), (kO)((kO)((kO)((kO)this.b.c(((kO)this.b.c(d4)).b(((kO)this.c.c(d3)).b(this.d.c(d2))))).a(object.c(this.e))).a(2)).b(d4));
    }

    private void a(T[] object, T[] TArray) {
        T t = object[0];
        T t2 = object[1];
        object = object[2];
        kO kO2 = (kO)((kO)((kO)this.c.c(t)).a(this.d.c(t2))).a(this.e.c(object));
        TArray[0] = (kO)((kO)((kO)((kO)this.b.c(((kO)t.c(this.b)).b(((kO)this.d.c(object)).b(this.e.c(t2))))).a(kO2.c(this.c))).a(2)).b(t);
        TArray[1] = (kO)((kO)((kO)((kO)this.b.c(((kO)t2.c(this.b)).b(((kO)this.e.c(t)).b(this.c.c(object))))).a(kO2.c(this.d))).a(2)).b(t2);
        TArray[2] = (kO)((kO)((kO)((kO)this.b.c(((kO)object.c(this.b)).b(((kO)this.c.c(t2)).b(this.d.c(t))))).a(kO2.c(this.e))).a(2)).b(object);
    }

    private void a(double[] object, T[] TArray) {
        double d2 = object[0];
        double d3 = object[1];
        double d4 = object[2];
        object = (kO)((kO)((kO)this.c.c(d2)).a(this.d.c(d3))).a(this.e.c(d4));
        TArray[0] = (kO)((kO)((kO)((kO)this.b.c(((kO)this.b.c(d2)).b(((kO)this.d.c(d4)).b(this.e.c(d3))))).a(object.c(this.c))).a(2)).b(d2);
        TArray[1] = (kO)((kO)((kO)((kO)this.b.c(((kO)this.b.c(d3)).b(((kO)this.e.c(d2)).b(this.c.c(d4))))).a(object.c(this.d))).a(2)).b(d3);
        TArray[2] = (kO)((kO)((kO)((kO)this.b.c(((kO)this.b.c(d4)).b(((kO)this.c.c(d3)).b(this.d.c(d2))))).a(object.c(this.e))).a(2)).b(d4);
    }

    private static <T extends kO<T>> re_0<T> a(rk_0 rk_02, re_0<T> re_02) {
        Serializable serializable = re_02;
        Object t = serializable.a;
        serializable = re_02;
        Object t2 = serializable.b;
        serializable = re_02;
        re_02 = serializable.c;
        rk_0 rk_03 = rk_02;
        serializable = rk_03;
        rk_0 rk_04 = rk_02;
        serializable = rk_04;
        serializable = rk_02;
        kO kO2 = (kO)((kO)((kO)t.c(rk_03.b)).a(t2.c(rk_04.c))).a(re_02.c(((rk_0)serializable).d));
        rk_0 rk_05 = rk_02;
        serializable = rk_05;
        rk_0 rk_06 = rk_02;
        serializable = rk_06;
        rk_0 rk_07 = rk_02;
        serializable = rk_07;
        rk_0 rk_08 = rk_02;
        serializable = rk_08;
        rk_0 rk_09 = rk_02;
        serializable = rk_09;
        rk_0 rk_010 = rk_02;
        serializable = rk_010;
        rk_0 rk_011 = rk_02;
        serializable = rk_011;
        rk_0 rk_012 = rk_02;
        serializable = rk_012;
        rk_0 rk_013 = rk_02;
        serializable = rk_013;
        rk_0 rk_014 = rk_02;
        serializable = rk_014;
        rk_0 rk_015 = rk_02;
        serializable = rk_015;
        rk_0 rk_016 = rk_02;
        serializable = rk_016;
        rk_0 rk_017 = rk_02;
        serializable = rk_017;
        rk_0 rk_018 = rk_02;
        serializable = rk_018;
        serializable = rk_02;
        return new re_0<kO>((kO)((kO)((kO)((kO)((kO)((kO)t.c(rk_05.a)).b(((kO)re_02.c(rk_06.c)).b(t2.c(rk_07.d)))).c(rk_08.a)).a(kO2.c(rk_09.b))).a(2)).b(t), (kO)((kO)((kO)((kO)((kO)((kO)t2.c(rk_010.a)).b(((kO)t.c(rk_011.d)).b(re_02.c(rk_012.b)))).c(rk_013.a)).a(kO2.c(rk_014.c))).a(2)).b(t2), (kO)((Object)((kO)((kO)((kO)((kO)((kO)re_02.c(rk_015.a)).b(((kO)t2.c(rk_016.b)).b(t.c(rk_017.c)))).c(rk_018.a)).a(kO2.c(((rk_0)serializable).d))).a(2)).b(re_02)));
    }

    private re_0<T> b(re_0<T> re_02) {
        Object object = re_02;
        kO kO2 = ((re_0)object).a;
        object = re_02;
        kO kO3 = ((re_0)object).b;
        object = re_02;
        re_02 = ((re_0)object).c;
        object = (kO)((Object)((kO)((kO)this.c.c(kO2)).a(this.d.c(kO3))).a(this.e.c((T)re_02)));
        kO kO4 = (kO)this.b.a();
        return new re_0<kO>((kO)((kO)((kO)((kO)kO4.c(kO2.c((kO)kO4).b(((kO)((Object)this.d.c((T)re_02))).b(this.e.c(kO3))))).a(object.c(this.c))).a(2)).b(kO2), (kO)((kO)((kO)((kO)((Object)kO4.c(kO3.c((kO)kO4).b(((kO)this.e.c(kO2)).b(this.c.c((T)re_02)))))).a(object.c(this.d))).a(2)).b(kO3), (kO)((Object)((kO)((kO)((kO)kO4.c(re_02.c(kO4).b(((kO)this.c.c(kO3)).b(this.d.c(kO2))))).a(object.c(this.e))).a(2)).b(re_02)));
    }

    private re_0<T> b(rs_0 object) {
        kO kO2;
        rs_0 rs_02 = object;
        double d2 = rs_02.i;
        rs_02 = object;
        double d3 = rs_02.j;
        rs_02 = object;
        double d4 = rs_02.k;
        object = (kO)((kO)((kO)this.c.c(d2)).a(this.d.c(d3))).a(this.e.c(d4));
        kO kO3 = kO2 = (kO)this.b.a();
        kO kO4 = kO2;
        kO kO5 = kO2;
        return new re_0<kO>((kO)((kO)((kO)((kO)kO3.c(((kO)kO3.c(d2)).b(((kO)this.d.c(d4)).b(this.e.c(d3))))).a(object.c(this.c))).a(2)).b(d2), (kO)((kO)((kO)((kO)kO4.c(((kO)kO4.c(d3)).b(((kO)this.e.c(d2)).b(this.c.c(d4))))).a(object.c(this.d))).a(2)).b(d3), (kO)((kO)((kO)((kO)kO5.c(((kO)kO5.c(d4)).b(((kO)this.c.c(d3)).b(this.d.c(d2))))).a(object.c(this.e))).a(2)).b(d4));
    }

    private void b(T[] object, T[] TArray) {
        kO kO2 = object[0];
        kO kO3 = object[1];
        object = object[2];
        kO kO4 = (kO)((kO)((kO)this.c.c(kO2)).a(this.d.c(kO3))).a(this.e.c(object));
        kO kO5 = (kO)this.b.a();
        TArray[0] = (kO)((kO)((kO)((kO)kO5.c(kO2.c((kO)kO5).b(((kO)this.d.c(object)).b(this.e.c(kO3))))).a(kO4.c(this.c))).a(2)).b(kO2);
        TArray[1] = (kO)((kO)((kO)((kO)kO5.c(kO3.c((kO)kO5).b(((kO)this.e.c(kO2)).b(this.c.c(object))))).a(kO4.c(this.d))).a(2)).b(kO3);
        TArray[2] = (kO)((kO)((kO)((kO)kO5.c(object.c(kO5).b(((kO)this.c.c(kO3)).b(this.d.c(kO2))))).a(kO4.c(this.e))).a(2)).b(object);
    }

    private void b(double[] object, T[] TArray) {
        kO kO2;
        double d2 = object[0];
        double d3 = object[1];
        double d4 = object[2];
        object = (kO)((kO)((kO)this.c.c(d2)).a(this.d.c(d3))).a(this.e.c(d4));
        kO kO3 = kO2 = (kO)this.b.a();
        TArray[0] = (kO)((kO)((kO)((kO)kO3.c(((kO)kO3.c(d2)).b(((kO)this.d.c(d4)).b(this.e.c(d3))))).a(object.c(this.c))).a(2)).b(d2);
        kO kO4 = kO2;
        TArray[1] = (kO)((kO)((kO)((kO)kO4.c(((kO)kO4.c(d3)).b(((kO)this.e.c(d2)).b(this.c.c(d4))))).a(object.c(this.d))).a(2)).b(d3);
        kO kO5 = kO2;
        TArray[2] = (kO)((kO)((kO)((kO)kO5.c(((kO)kO5.c(d4)).b(((kO)this.c.c(d3)).b(this.d.c(d2))))).a(object.c(this.e))).a(2)).b(d4);
    }

    private static <T extends kO<T>> re_0<T> b(rk_0 rk_02, re_0<T> re_02) {
        Serializable serializable = re_02;
        Object t = serializable.a;
        serializable = re_02;
        Object t2 = serializable.b;
        serializable = re_02;
        re_02 = serializable.c;
        rk_0 rk_03 = rk_02;
        serializable = rk_03;
        rk_0 rk_04 = rk_02;
        serializable = rk_04;
        serializable = rk_02;
        kO kO2 = (kO)((kO)((kO)t.c(rk_03.b)).a(t2.c(rk_04.c))).a(re_02.c(((rk_0)serializable).d));
        serializable = rk_02;
        double d2 = -((rk_0)serializable).a;
        rk_0 rk_05 = rk_02;
        serializable = rk_05;
        rk_0 rk_06 = rk_02;
        serializable = rk_06;
        rk_0 rk_07 = rk_02;
        serializable = rk_07;
        rk_0 rk_08 = rk_02;
        serializable = rk_08;
        rk_0 rk_09 = rk_02;
        serializable = rk_09;
        rk_0 rk_010 = rk_02;
        serializable = rk_010;
        rk_0 rk_011 = rk_02;
        serializable = rk_011;
        rk_0 rk_012 = rk_02;
        serializable = rk_012;
        serializable = rk_02;
        return new re_0<kO>((kO)((kO)((kO)((kO)((kO)((kO)t.c(d2)).b(((kO)re_02.c(rk_05.c)).b(t2.c(rk_06.d)))).c(d2)).a(kO2.c(rk_07.b))).a(2)).b(t), (kO)((kO)((kO)((kO)((kO)((kO)t2.c(d2)).b(((kO)t.c(rk_08.d)).b(re_02.c(rk_09.b)))).c(d2)).a(kO2.c(rk_010.c))).a(2)).b(t2), (kO)((Object)((kO)((kO)((kO)((kO)((kO)re_02.c(d2)).b(((kO)t2.c(rk_011.b)).b(t.c(rk_012.c)))).c(d2)).a(kO2.c(((rk_0)serializable).d))).a(2)).b(re_02)));
    }

    private rd_0<T> a(rd_0<T> rd_02) {
        return this.a(rd_02, rl_0.VECTOR_OPERATOR$59e4743c);
    }

    private rd_0<T> a(rd_0<T> rd_02, int n2) {
        if (n2 == rl_0.VECTOR_OPERATOR$59e4743c) {
            return this.b(rd_02);
        }
        return super.b(this);
    }

    private rd_0<T> b(rd_0<T> rd_02) {
        return new rd_0<kO>((kO)((kO)rd_02.b.c(this.b)).b(((kO)((kO)rd_02.c.c(this.c)).a(rd_02.d.c(this.d))).a(rd_02.e.c(this.e))), (kO)((kO)((kO)rd_02.c.c(this.b)).a(rd_02.b.c(this.c))).a(((kO)rd_02.d.c(this.e)).b(rd_02.e.c(this.d))), (kO)((kO)((kO)rd_02.d.c(this.b)).a(rd_02.b.c(this.d))).a(((kO)rd_02.e.c(this.c)).b(rd_02.c.c(this.e))), (kO)((kO)((kO)rd_02.e.c(this.b)).a(rd_02.b.c(this.e))).a(((kO)rd_02.c.c(this.d)).b(rd_02.d.c(this.c))), false);
    }

    private rd_0<T> a(rk_0 serializable) {
        int n2 = rl_0.VECTOR_OPERATOR$59e4743c;
        rk_0 rk_02 = serializable;
        serializable = this;
        if (n2 == rl_0.VECTOR_OPERATOR$59e4743c) {
            rk_0 rk_03 = rk_02;
            rk_0 rk_04 = rk_03;
            rk_0 rk_05 = rk_02;
            rk_04 = rk_05;
            rk_0 rk_06 = rk_02;
            rk_04 = rk_06;
            rk_0 rk_07 = rk_02;
            rk_04 = rk_07;
            rk_0 rk_08 = rk_02;
            rk_04 = rk_08;
            rk_0 rk_09 = rk_02;
            rk_04 = rk_09;
            rk_0 rk_010 = rk_02;
            rk_04 = rk_010;
            rk_0 rk_011 = rk_02;
            rk_04 = rk_011;
            rk_0 rk_012 = rk_02;
            rk_04 = rk_012;
            rk_0 rk_013 = rk_02;
            rk_04 = rk_013;
            rk_0 rk_014 = rk_02;
            rk_04 = rk_014;
            rk_0 rk_015 = rk_02;
            rk_04 = rk_015;
            rk_0 rk_016 = rk_02;
            rk_04 = rk_016;
            rk_0 rk_017 = rk_02;
            rk_04 = rk_017;
            rk_0 rk_018 = rk_02;
            rk_04 = rk_018;
            rk_04 = rk_02;
            return new rd_0<kO>((kO)((kO)((rd_0)serializable).b.c(rk_03.a)).b(((kO)((kO)((rd_0)serializable).c.c(rk_05.b)).a(((rd_0)serializable).d.c(rk_06.c))).a(((rd_0)serializable).e.c(rk_07.d))), (kO)((kO)((kO)((rd_0)serializable).b.c(rk_08.b)).a(((rd_0)serializable).c.c(rk_09.a))).a(((kO)((rd_0)serializable).e.c(rk_010.c)).b(((rd_0)serializable).d.c(rk_011.d))), (kO)((kO)((kO)((rd_0)serializable).b.c(rk_012.c)).a(((rd_0)serializable).d.c(rk_013.a))).a(((kO)((rd_0)serializable).c.c(rk_014.d)).b(((rd_0)serializable).e.c(rk_015.b))), (kO)((kO)((kO)((rd_0)serializable).b.c(rk_016.d)).a(((rd_0)serializable).e.c(rk_017.a))).a(((kO)((rd_0)serializable).d.c(rk_018.b)).b(((rd_0)serializable).c.c(rk_04.c))), false);
        }
        return rd_0.a(rk_02, serializable);
    }

    private rd_0<T> a(rk_0 rk_02, int n2) {
        if (n2 == rl_0.VECTOR_OPERATOR$59e4743c) {
            return this.b(rk_02);
        }
        return rd_0.a(rk_02, this);
    }

    private rd_0<T> b(rk_0 rk_02) {
        rk_0 rk_03 = rk_02;
        rk_0 rk_04 = rk_03;
        rk_0 rk_05 = rk_02;
        rk_04 = rk_05;
        rk_0 rk_06 = rk_02;
        rk_04 = rk_06;
        rk_0 rk_07 = rk_02;
        rk_04 = rk_07;
        rk_0 rk_08 = rk_02;
        rk_04 = rk_08;
        rk_0 rk_09 = rk_02;
        rk_04 = rk_09;
        rk_0 rk_010 = rk_02;
        rk_04 = rk_010;
        rk_0 rk_011 = rk_02;
        rk_04 = rk_011;
        rk_0 rk_012 = rk_02;
        rk_04 = rk_012;
        rk_0 rk_013 = rk_02;
        rk_04 = rk_013;
        rk_0 rk_014 = rk_02;
        rk_04 = rk_014;
        rk_0 rk_015 = rk_02;
        rk_04 = rk_015;
        rk_0 rk_016 = rk_02;
        rk_04 = rk_016;
        rk_0 rk_017 = rk_02;
        rk_04 = rk_017;
        rk_0 rk_018 = rk_02;
        rk_04 = rk_018;
        rk_04 = rk_02;
        return new rd_0<kO>((kO)((kO)this.b.c(rk_03.a)).b(((kO)((kO)this.c.c(rk_05.b)).a(this.d.c(rk_06.c))).a(this.e.c(rk_07.d))), (kO)((kO)((kO)this.b.c(rk_08.b)).a(this.c.c(rk_09.a))).a(((kO)this.e.c(rk_010.c)).b(this.d.c(rk_011.d))), (kO)((kO)((kO)this.b.c(rk_012.c)).a(this.d.c(rk_013.a))).a(((kO)this.c.c(rk_014.d)).b(this.e.c(rk_015.b))), (kO)((kO)((kO)this.b.c(rk_016.d)).a(this.e.c(rk_017.a))).a(((kO)this.d.c(rk_018.b)).b(this.c.c(rk_04.c))), false);
    }

    private static <T extends kO<T>> rd_0<T> a(rk_0 rk_02, rd_0<T> rd_02) {
        rk_0 rk_03 = rk_02;
        rk_0 rk_04 = rk_03;
        rk_0 rk_05 = rk_02;
        rk_04 = rk_05;
        rk_0 rk_06 = rk_02;
        rk_04 = rk_06;
        rk_0 rk_07 = rk_02;
        rk_04 = rk_07;
        rk_0 rk_08 = rk_02;
        rk_04 = rk_08;
        rk_0 rk_09 = rk_02;
        rk_04 = rk_09;
        rk_0 rk_010 = rk_02;
        rk_04 = rk_010;
        rk_0 rk_011 = rk_02;
        rk_04 = rk_011;
        rk_0 rk_012 = rk_02;
        rk_04 = rk_012;
        rk_0 rk_013 = rk_02;
        rk_04 = rk_013;
        rk_0 rk_014 = rk_02;
        rk_04 = rk_014;
        rk_0 rk_015 = rk_02;
        rk_04 = rk_015;
        rk_0 rk_016 = rk_02;
        rk_04 = rk_016;
        rk_0 rk_017 = rk_02;
        rk_04 = rk_017;
        rk_0 rk_018 = rk_02;
        rk_04 = rk_018;
        rk_04 = rk_02;
        return new rd_0<kO>((kO)((kO)rd_02.b.c(rk_03.a)).b(((kO)((kO)rd_02.c.c(rk_05.b)).a(rd_02.d.c(rk_06.c))).a(rd_02.e.c(rk_07.d))), (kO)((kO)((kO)rd_02.c.c(rk_08.a)).a(rd_02.b.c(rk_09.b))).a(((kO)rd_02.d.c(rk_010.d)).b(rd_02.e.c(rk_011.c))), (kO)((kO)((kO)rd_02.d.c(rk_012.a)).a(rd_02.b.c(rk_013.c))).a(((kO)rd_02.e.c(rk_014.b)).b(rd_02.c.c(rk_015.d))), (kO)((kO)((kO)rd_02.e.c(rk_016.a)).a(rd_02.b.c(rk_017.d))).a(((kO)rd_02.c.c(rk_018.c)).b(rd_02.d.c(rk_04.b))), false);
    }

    private rd_0<T> c(rd_0<T> rd_02) {
        int n2 = rl_0.VECTOR_OPERATOR$59e4743c;
        rd_0 rd_03 = rd_02;
        rd_02 = this;
        if (n2 == rl_0.VECTOR_OPERATOR$59e4743c) {
            return rd_02.d(rd_03);
        }
        return rd_03.b(rd_02.a());
    }

    private rd_0<T> b(rd_0<T> rd_02, int n2) {
        if (n2 == rl_0.VECTOR_OPERATOR$59e4743c) {
            return this.d(rd_02);
        }
        return super.b(this.a());
    }

    private rd_0<T> d(rd_0<T> rd_02) {
        return new rd_0<kO>((kO)((kO)((kO)rd_02.b.c(this.b)).a(((kO)((kO)rd_02.c.c(this.c)).a(rd_02.d.c(this.d))).a(rd_02.e.c(this.e)))).a(), (kO)((kO)((kO)rd_02.b.c(this.c)).a(((kO)rd_02.d.c(this.e)).b(rd_02.e.c(this.d)))).b(rd_02.c.c(this.b)), (kO)((kO)((kO)rd_02.b.c(this.d)).a(((kO)rd_02.e.c(this.c)).b(rd_02.c.c(this.e)))).b(rd_02.d.c(this.b)), (kO)((kO)((kO)rd_02.b.c(this.e)).a(((kO)rd_02.c.c(this.d)).b(rd_02.d.c(this.c)))).b(rd_02.e.c(this.b)), false);
    }

    private rd_0<T> c(rk_0 serializable) {
        int n2 = rl_0.VECTOR_OPERATOR$59e4743c;
        rk_0 rk_02 = serializable;
        serializable = this;
        if (n2 == rl_0.VECTOR_OPERATOR$59e4743c) {
            rk_0 rk_03 = rk_02;
            rk_0 rk_04 = rk_03;
            rk_0 rk_05 = rk_02;
            rk_04 = rk_05;
            rk_0 rk_06 = rk_02;
            rk_04 = rk_06;
            rk_0 rk_07 = rk_02;
            rk_04 = rk_07;
            rk_0 rk_08 = rk_02;
            rk_04 = rk_08;
            rk_0 rk_09 = rk_02;
            rk_04 = rk_09;
            rk_0 rk_010 = rk_02;
            rk_04 = rk_010;
            rk_0 rk_011 = rk_02;
            rk_04 = rk_011;
            rk_0 rk_012 = rk_02;
            rk_04 = rk_012;
            rk_0 rk_013 = rk_02;
            rk_04 = rk_013;
            rk_0 rk_014 = rk_02;
            rk_04 = rk_014;
            rk_0 rk_015 = rk_02;
            rk_04 = rk_015;
            rk_0 rk_016 = rk_02;
            rk_04 = rk_016;
            rk_0 rk_017 = rk_02;
            rk_04 = rk_017;
            rk_0 rk_018 = rk_02;
            rk_04 = rk_018;
            rk_04 = rk_02;
            return new rd_0<kO>((kO)((kO)((kO)((rd_0)serializable).b.c(rk_03.a)).a(((kO)((kO)((rd_0)serializable).c.c(rk_05.b)).a(((rd_0)serializable).d.c(rk_06.c))).a(((rd_0)serializable).e.c(rk_07.d)))).a(), (kO)((kO)((kO)((rd_0)serializable).c.c(rk_08.a)).a(((kO)((rd_0)serializable).e.c(rk_09.c)).b(((rd_0)serializable).d.c(rk_010.d)))).b(((rd_0)serializable).b.c(rk_011.b)), (kO)((kO)((kO)((rd_0)serializable).d.c(rk_012.a)).a(((kO)((rd_0)serializable).c.c(rk_013.d)).b(((rd_0)serializable).e.c(rk_014.b)))).b(((rd_0)serializable).b.c(rk_015.c)), (kO)((kO)((kO)((rd_0)serializable).e.c(rk_016.a)).a(((kO)((rd_0)serializable).d.c(rk_017.b)).b(((rd_0)serializable).c.c(rk_018.c)))).b(((rd_0)serializable).b.c(rk_04.d)), false);
        }
        return rd_0.a(rk_02, ((rd_0)serializable).a());
    }

    private rd_0<T> b(rk_0 rk_02, int n2) {
        if (n2 == rl_0.VECTOR_OPERATOR$59e4743c) {
            return this.d(rk_02);
        }
        return rd_0.a(rk_02, this.a());
    }

    private rd_0<T> d(rk_0 rk_02) {
        rk_0 rk_03 = rk_02;
        rk_0 rk_04 = rk_03;
        rk_0 rk_05 = rk_02;
        rk_04 = rk_05;
        rk_0 rk_06 = rk_02;
        rk_04 = rk_06;
        rk_0 rk_07 = rk_02;
        rk_04 = rk_07;
        rk_0 rk_08 = rk_02;
        rk_04 = rk_08;
        rk_0 rk_09 = rk_02;
        rk_04 = rk_09;
        rk_0 rk_010 = rk_02;
        rk_04 = rk_010;
        rk_0 rk_011 = rk_02;
        rk_04 = rk_011;
        rk_0 rk_012 = rk_02;
        rk_04 = rk_012;
        rk_0 rk_013 = rk_02;
        rk_04 = rk_013;
        rk_0 rk_014 = rk_02;
        rk_04 = rk_014;
        rk_0 rk_015 = rk_02;
        rk_04 = rk_015;
        rk_0 rk_016 = rk_02;
        rk_04 = rk_016;
        rk_0 rk_017 = rk_02;
        rk_04 = rk_017;
        rk_0 rk_018 = rk_02;
        rk_04 = rk_018;
        rk_04 = rk_02;
        return new rd_0<kO>((kO)((kO)((kO)this.b.c(rk_03.a)).a(((kO)((kO)this.c.c(rk_05.b)).a(this.d.c(rk_06.c))).a(this.e.c(rk_07.d)))).a(), (kO)((kO)((kO)this.c.c(rk_08.a)).a(((kO)this.e.c(rk_09.c)).b(this.d.c(rk_010.d)))).b(this.b.c(rk_011.b)), (kO)((kO)((kO)this.d.c(rk_012.a)).a(((kO)this.c.c(rk_013.d)).b(this.e.c(rk_014.b)))).b(this.b.c(rk_015.c)), (kO)((kO)((kO)this.e.c(rk_016.a)).a(((kO)this.d.c(rk_017.b)).b(this.c.c(rk_018.c)))).b(this.b.c(rk_04.d)), false);
    }

    private static <T extends kO<T>> rd_0<T> b(rk_0 rk_02, rd_0<T> rd_02) {
        rk_0 rk_03 = rk_02;
        rk_0 rk_04 = rk_03;
        rk_0 rk_05 = rk_02;
        rk_04 = rk_05;
        rk_0 rk_06 = rk_02;
        rk_04 = rk_06;
        rk_0 rk_07 = rk_02;
        rk_04 = rk_07;
        rk_0 rk_08 = rk_02;
        rk_04 = rk_08;
        rk_0 rk_09 = rk_02;
        rk_04 = rk_09;
        rk_0 rk_010 = rk_02;
        rk_04 = rk_010;
        rk_0 rk_011 = rk_02;
        rk_04 = rk_011;
        rk_0 rk_012 = rk_02;
        rk_04 = rk_012;
        rk_0 rk_013 = rk_02;
        rk_04 = rk_013;
        rk_0 rk_014 = rk_02;
        rk_04 = rk_014;
        rk_0 rk_015 = rk_02;
        rk_04 = rk_015;
        rk_0 rk_016 = rk_02;
        rk_04 = rk_016;
        rk_0 rk_017 = rk_02;
        rk_04 = rk_017;
        rk_0 rk_018 = rk_02;
        rk_04 = rk_018;
        rk_04 = rk_02;
        return new rd_0<kO>((kO)((kO)((kO)rd_02.b.c(rk_03.a)).a(((kO)((kO)rd_02.c.c(rk_05.b)).a(rd_02.d.c(rk_06.c))).a(rd_02.e.c(rk_07.d)))).a(), (kO)((kO)((kO)rd_02.b.c(rk_08.b)).a(((kO)rd_02.d.c(rk_09.d)).b(rd_02.e.c(rk_010.c)))).b(rd_02.c.c(rk_011.a)), (kO)((kO)((kO)rd_02.b.c(rk_012.c)).a(((kO)rd_02.e.c(rk_013.b)).b(rd_02.c.c(rk_014.d)))).b(rd_02.d.c(rk_015.a)), (kO)((kO)((kO)rd_02.b.c(rk_016.d)).a(((kO)rd_02.c.c(rk_017.c)).b(rd_02.d.c(rk_018.b)))).b(rd_02.e.c(rk_04.a)), false);
    }

    private static T[][] a(T[][] TArray, double d2) {
        kO kO2 = TArray[0][0];
        kO kO3 = TArray[0][1];
        kO kO4 = TArray[0][2];
        kO kO5 = TArray[1][0];
        kO kO6 = TArray[1][1];
        kO kO7 = TArray[1][2];
        kO kO8 = TArray[2][0];
        kO kO9 = TArray[2][1];
        kO kO10 = TArray[2][2];
        double d3 = 0.0;
        kO[][] kOArray = (kO[][])ch_0.a(TArray[0][0].c(), 3, 3);
        int n2 = 0;
        while (++n2 < 11) {
            double d4;
            kO kO11 = (kO)((kO)((kO)TArray[0][0].c(kO2)).a(TArray[1][0].c(kO5))).a(TArray[2][0].c(kO8));
            kO kO12 = (kO)((kO)((kO)TArray[0][1].c(kO2)).a(TArray[1][1].c(kO5))).a(TArray[2][1].c(kO8));
            kO kO13 = (kO)((kO)((kO)TArray[0][2].c(kO2)).a(TArray[1][2].c(kO5))).a(TArray[2][2].c(kO8));
            kO kO14 = (kO)((kO)((kO)TArray[0][0].c(kO3)).a(TArray[1][0].c(kO6))).a(TArray[2][0].c(kO9));
            kO kO15 = (kO)((kO)((kO)TArray[0][1].c(kO3)).a(TArray[1][1].c(kO6))).a(TArray[2][1].c(kO9));
            kO kO16 = (kO)((kO)((kO)TArray[0][2].c(kO3)).a(TArray[1][2].c(kO6))).a(TArray[2][2].c(kO9));
            kO kO17 = (kO)((kO)((kO)TArray[0][0].c(kO4)).a(TArray[1][0].c(kO7))).a(TArray[2][0].c(kO10));
            kO kO18 = (kO)((kO)((kO)TArray[0][1].c(kO4)).a(TArray[1][1].c(kO7))).a(TArray[2][1].c(kO10));
            kO kO19 = (kO)((kO)((kO)TArray[0][2].c(kO4)).a(TArray[1][2].c(kO7))).a(TArray[2][2].c(kO10));
            kO kO20 = kO2;
            kOArray[0][0] = (kO)kO20.b(((kO)kO20.c((kO)kO11).a(kO3.c((kO)kO12)).a(kO4.c((kO)kO13)).b(TArray[0][0])).c(0.5));
            kOArray[0][1] = (kO)kO3.b(((kO)kO2.c((kO)kO14).a(kO3.c((kO)kO15)).a(kO4.c((kO)kO16)).b(TArray[0][1])).c(0.5));
            kOArray[0][2] = (kO)kO4.b(((kO)kO2.c((kO)kO17).a(kO3.c((kO)kO18)).a(kO4.c((kO)kO19)).b(TArray[0][2])).c(0.5));
            kO kO21 = kO5;
            kOArray[1][0] = (kO)kO21.b(((kO)kO21.c((kO)kO11).a(kO6.c((kO)kO12)).a(kO7.c((kO)kO13)).b(TArray[1][0])).c(0.5));
            kOArray[1][1] = (kO)kO6.b(((kO)kO5.c((kO)kO14).a(kO6.c((kO)kO15)).a(kO7.c((kO)kO16)).b(TArray[1][1])).c(0.5));
            kOArray[1][2] = (kO)kO7.b(((kO)kO5.c((kO)kO17).a(kO6.c((kO)kO18)).a(kO7.c((kO)kO19)).b(TArray[1][2])).c(0.5));
            kO kO22 = kO8;
            kOArray[2][0] = (kO)kO22.b(((kO)kO22.c((kO)kO11).a(kO9.c((kO)kO12)).a(kO10.c((kO)kO13)).b(TArray[2][0])).c(0.5));
            kOArray[2][1] = (kO)kO9.b(((kO)kO8.c((kO)kO14).a(kO9.c((kO)kO15)).a(kO10.c((kO)kO16)).b(TArray[2][1])).c(0.5));
            kOArray[2][2] = (kO)kO10.b(((kO)kO8.c((kO)kO17).a(kO9.c((kO)kO18)).a(kO10.c((kO)kO19)).b(TArray[2][2])).c(0.5));
            double d5 = kOArray[0][0].d() - TArray[0][0].d();
            double d6 = kOArray[0][1].d() - TArray[0][1].d();
            double d7 = kOArray[0][2].d() - TArray[0][2].d();
            double d8 = kOArray[1][0].d() - TArray[1][0].d();
            double d9 = kOArray[1][1].d() - TArray[1][1].d();
            double d10 = kOArray[1][2].d() - TArray[1][2].d();
            double d11 = kOArray[2][0].d() - TArray[2][0].d();
            double d12 = kOArray[2][1].d() - TArray[2][1].d();
            double d13 = kOArray[2][2].d() - TArray[2][2].d();
            double d14 = d5;
            double d15 = d6;
            double d16 = d7;
            double d17 = d8;
            double d18 = d9;
            double d19 = d10;
            double d20 = d11;
            double d21 = d12;
            double d22 = d13;
            double d23 = d14 * d14 + d15 * d15 + d16 * d16 + d17 * d17 + d18 * d18 + d19 * d19 + d20 * d20 + d21 * d21 + d22 * d22;
            if (BY.w(d4 - d3) <= d2) {
                return kOArray;
            }
            kO2 = kOArray[0][0];
            kO3 = kOArray[0][1];
            kO4 = kOArray[0][2];
            kO5 = kOArray[1][0];
            kO6 = kOArray[1][1];
            kO7 = kOArray[1][2];
            kO8 = kOArray[2][0];
            kO9 = kOArray[2][1];
            kO10 = kOArray[2][2];
            d3 = d23;
        }
        throw new rg_0(px_0.UNABLE_TO_ORTHOGONOLIZE_MATRIX, n2 - 1);
    }

    private static <T extends kO<T>> T a(rd_0<T> rd_02, rd_0<T> rd_03) {
        rd_02 = super.d(rd_03);
        if (rd_02.b.d() < -0.1 || rd_02.b.d() > 0.1) {
            return (T)((kO)((kO)((kO)((kO)((kO)((kO)rd_02.c.c(rd_02.c)).a(rd_02.d.c(rd_02.d))).a(rd_02.e.c(rd_02.e))).k()).u()).a(2));
        }
        if (rd_02.b.d() < 0.0) {
            return (T)((kO)((kO)((kO)rd_02.b.a()).t()).a(2));
        }
        return (T)((kO)((kO)rd_02.b.t()).a(2));
    }
}

