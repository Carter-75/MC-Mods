/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Locale;
import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.ch_0;
import org.valkyrienskies.core.impl.shadow.kO;
import org.valkyrienskies.core.impl.shadow.oS;
import org.valkyrienskies.core.impl.shadow.oU;
import org.valkyrienskies.core.impl.shadow.px_0;
import org.valkyrienskies.core.impl.shadow.rs_0;
import org.valkyrienskies.core.impl.shadow.rt_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.re
 */
public final class re_0<T extends kO<T>>
implements Serializable {
    private static final long d = 20130224L;
    final T a;
    final T b;
    final T c;

    public re_0(T t, T t2, T t3) {
        this.a = t;
        this.b = t2;
        this.c = t3;
    }

    private re_0(T[] TArray) {
        if (TArray.length != 3) {
            throw new oS(TArray.length, 3);
        }
        this.a = TArray[0];
        this.b = TArray[1];
        this.c = TArray[2];
    }

    private re_0(T t, T t2) {
        kO kO2 = (kO)t2.q();
        this.a = ((kO)t.q()).c(kO2);
        this.b = ((kO)t.r()).c(kO2);
        this.c = (kO)t2.r();
    }

    private re_0(T t, re_0<T> re_02) {
        this.a = (kO)t.c(re_02.a);
        this.b = (kO)t.c(re_02.b);
        this.c = (kO)t.c(re_02.c);
    }

    public re_0(T t, rs_0 rs_02) {
        rs_0 rs_03 = rs_02;
        this.a = (kO)t.c(rs_03.i);
        rs_03 = rs_02;
        this.b = (kO)t.c(rs_03.j);
        rs_03 = rs_02;
        this.c = (kO)t.c(rs_03.k);
    }

    private re_0(double d2, re_0<T> re_02) {
        this.a = (kO)re_02.a.c(d2);
        this.b = (kO)re_02.b.c(d2);
        this.c = (kO)re_02.c.c(d2);
    }

    private re_0(T t, re_0<T> re_02, T t2, re_0<T> re_03) {
        T t3 = t;
        re_0<T> re_04 = re_02;
        re_0<T> re_05 = re_04;
        re_05 = re_03;
        this.a = (kO)t3.a(t, re_04.a, t2, re_05.a);
        re_0<T> re_06 = re_02;
        re_05 = re_06;
        re_05 = re_03;
        this.b = (kO)t3.a(t, re_06.b, t2, re_05.b);
        re_0<T> re_07 = re_02;
        re_05 = re_07;
        re_05 = re_03;
        this.c = (kO)t3.a(t, re_07.c, t2, re_05.c);
    }

    private re_0(T t, rs_0 rs_02, T t2, rs_0 rs_03) {
        T t3 = t;
        rs_0 rs_04 = rs_02;
        rs_0 rs_05 = rs_04;
        rs_05 = rs_03;
        this.a = (kO)t3.a(rs_04.i, t, rs_05.i, t2);
        rs_0 rs_06 = rs_02;
        rs_05 = rs_06;
        rs_05 = rs_03;
        this.b = (kO)t3.a(rs_06.j, t, rs_05.j, t2);
        rs_0 rs_07 = rs_02;
        rs_05 = rs_07;
        rs_05 = rs_03;
        this.c = (kO)t3.a(rs_07.k, t, rs_05.k, t2);
    }

    private re_0(double d2, re_0<T> re_02, double d3, re_0<T> re_03) {
        re_0<T> re_04 = re_02;
        T t = re_04.a;
        re_0<T> re_05 = re_02;
        re_04 = re_05;
        re_04 = re_03;
        this.a = (kO)t.a(1.0, re_05.a, d3, re_04.a);
        re_0<T> re_06 = re_02;
        re_04 = re_06;
        re_04 = re_03;
        this.b = (kO)t.a(1.0, re_06.b, d3, re_04.b);
        re_0<T> re_07 = re_02;
        re_04 = re_07;
        re_04 = re_03;
        this.c = (kO)t.a(1.0, re_07.c, d3, re_04.c);
    }

    private re_0(T t, re_0<T> re_02, T t2, re_0<T> re_03, T t3, re_0<T> re_04) {
        T t4 = t;
        re_0<T> re_05 = re_02;
        re_0<T> re_06 = re_05;
        re_0<T> re_07 = re_03;
        re_06 = re_07;
        re_06 = re_04;
        this.a = (kO)t4.a(t, re_05.a, t2, re_07.a, t3, re_06.a);
        re_0<T> re_08 = re_02;
        re_06 = re_08;
        re_0<T> re_09 = re_03;
        re_06 = re_09;
        re_06 = re_04;
        this.b = (kO)t4.a(t, re_08.b, t2, re_09.b, t3, re_06.b);
        re_0<T> re_010 = re_02;
        re_06 = re_010;
        re_0<T> re_011 = re_03;
        re_06 = re_011;
        re_06 = re_04;
        this.c = (kO)t4.a(t, re_010.c, t2, re_011.c, t3, re_06.c);
    }

    private re_0(T t, rs_0 rs_02, T t2, rs_0 rs_03, T t3, rs_0 rs_04) {
        T t4 = t;
        rs_0 rs_05 = rs_02;
        rs_0 rs_06 = rs_05;
        rs_0 rs_07 = rs_03;
        rs_06 = rs_07;
        rs_06 = rs_04;
        this.a = (kO)t4.a(rs_05.i, t, rs_07.i, t2, rs_06.i, t3);
        rs_0 rs_08 = rs_02;
        rs_06 = rs_08;
        rs_0 rs_09 = rs_03;
        rs_06 = rs_09;
        rs_06 = rs_04;
        this.b = (kO)t4.a(rs_08.j, t, rs_09.j, t2, rs_06.j, t3);
        rs_0 rs_010 = rs_02;
        rs_06 = rs_010;
        rs_0 rs_011 = rs_03;
        rs_06 = rs_011;
        rs_06 = rs_04;
        this.c = (kO)t4.a(rs_010.k, t, rs_011.k, t2, rs_06.k, t3);
    }

    private re_0(double d2, re_0<T> re_02, double d3, re_0<T> re_03, double d4, re_0<T> re_04) {
        re_0<T> re_05 = re_02;
        T t = re_05.a;
        re_0<T> re_06 = re_02;
        re_05 = re_06;
        re_0<T> re_07 = re_03;
        re_05 = re_07;
        re_05 = re_04;
        this.a = (kO)t.a(d2, re_06.a, d3, re_07.a, d4, re_05.a);
        re_0<T> re_08 = re_02;
        re_05 = re_08;
        re_0<T> re_09 = re_03;
        re_05 = re_09;
        re_05 = re_04;
        this.b = (kO)t.a(d2, re_08.b, d3, re_09.b, d4, re_05.b);
        re_0<T> re_010 = re_02;
        re_05 = re_010;
        re_0<T> re_011 = re_03;
        re_05 = re_011;
        re_05 = re_04;
        this.c = (kO)t.a(d2, re_010.c, d3, re_011.c, d4, re_05.c);
    }

    private re_0(T t, re_0<T> re_02, T t2, re_0<T> re_03, T t3, re_0<T> re_04, T t4, re_0<T> re_05) {
        T t5 = t;
        re_0<T> re_06 = re_02;
        re_0<T> re_07 = re_06;
        re_0<T> re_08 = re_03;
        re_07 = re_08;
        re_0<T> re_09 = re_04;
        re_07 = re_09;
        re_07 = re_05;
        this.a = (kO)t5.a(t, re_06.a, t2, re_08.a, t3, re_09.a, t4, re_07.a);
        re_0<T> re_010 = re_02;
        re_07 = re_010;
        re_0<T> re_011 = re_03;
        re_07 = re_011;
        re_0<T> re_012 = re_04;
        re_07 = re_012;
        re_07 = re_05;
        this.b = (kO)t5.a(t, re_010.b, t2, re_011.b, t3, re_012.b, t4, re_07.b);
        re_0<T> re_013 = re_02;
        re_07 = re_013;
        re_0<T> re_014 = re_03;
        re_07 = re_014;
        re_0<T> re_015 = re_04;
        re_07 = re_015;
        re_07 = re_05;
        this.c = (kO)t5.a(t, re_013.c, t2, re_014.c, t3, re_015.c, t4, re_07.c);
    }

    private re_0(T t, rs_0 rs_02, T t2, rs_0 rs_03, T t3, rs_0 rs_04, T t4, rs_0 rs_05) {
        T t5 = t;
        rs_0 rs_06 = rs_02;
        rs_0 rs_07 = rs_06;
        rs_0 rs_08 = rs_03;
        rs_07 = rs_08;
        rs_0 rs_09 = rs_04;
        rs_07 = rs_09;
        rs_07 = rs_05;
        this.a = (kO)t5.a(rs_06.i, t, rs_08.i, t2, rs_09.i, t3, rs_07.i, t4);
        rs_0 rs_010 = rs_02;
        rs_07 = rs_010;
        rs_0 rs_011 = rs_03;
        rs_07 = rs_011;
        rs_0 rs_012 = rs_04;
        rs_07 = rs_012;
        rs_07 = rs_05;
        this.b = (kO)t5.a(rs_010.j, t, rs_011.j, t2, rs_012.j, t3, rs_07.j, t4);
        rs_0 rs_013 = rs_02;
        rs_07 = rs_013;
        rs_0 rs_014 = rs_03;
        rs_07 = rs_014;
        rs_0 rs_015 = rs_04;
        rs_07 = rs_015;
        rs_07 = rs_05;
        this.c = (kO)t5.a(rs_013.k, t, rs_014.k, t2, rs_015.k, t3, rs_07.k, t4);
    }

    private re_0(double d2, re_0<T> re_02, double d3, re_0<T> re_03, double d4, re_0<T> re_04, double d5, re_0<T> re_05) {
        re_0<T> re_06 = re_02;
        T t = re_06.a;
        re_0<T> re_07 = re_02;
        re_06 = re_07;
        re_0<T> re_08 = re_03;
        re_06 = re_08;
        re_0<T> re_09 = re_04;
        re_06 = re_09;
        re_06 = re_05;
        this.a = (kO)t.a(d2, re_07.a, d3, re_08.a, d4, re_09.a, d5, re_06.a);
        re_0<T> re_010 = re_02;
        re_06 = re_010;
        re_0<T> re_011 = re_03;
        re_06 = re_011;
        re_0<T> re_012 = re_04;
        re_06 = re_012;
        re_06 = re_05;
        this.b = (kO)t.a(d2, re_010.b, d3, re_011.b, d4, re_012.b, d5, re_06.b);
        re_0<T> re_013 = re_02;
        re_06 = re_013;
        re_0<T> re_014 = re_03;
        re_06 = re_014;
        re_0<T> re_015 = re_04;
        re_06 = re_015;
        re_06 = re_05;
        this.c = (kO)t.a(d2, re_013.c, d3, re_014.c, d4, re_015.c, d5, re_06.c);
    }

    public final T a() {
        return this.a;
    }

    public final T b() {
        return this.b;
    }

    public final T c() {
        return this.c;
    }

    private T[] g() {
        kO[] kOArray = (kO[])ch_0.a(this.a.c(), 3);
        kO[] kOArray2 = kOArray;
        kOArray[0] = this.a;
        kOArray2[1] = this.b;
        kOArray2[2] = this.c;
        return kOArray2;
    }

    private rs_0 h() {
        return new rs_0(this.a.d(), this.b.d(), this.c.d());
    }

    private T i() {
        return (T)((kO)((kO)((kO)this.a.e()).a(this.b.e())).a(this.c.e()));
    }

    public final T d() {
        return (T)((kO)((kO)((kO)((kO)this.a.c(this.a)).a(this.b.c(this.b))).a(this.c.c(this.c))).k());
    }

    private T j() {
        return (T)((kO)((kO)((kO)this.a.c(this.a)).a(this.b.c(this.b))).a(this.c.c(this.c)));
    }

    private T k() {
        kO kO2 = (kO)this.a.e();
        kO kO3 = (kO)this.b.e();
        kO kO4 = (kO)this.c.e();
        if (kO2.d() <= kO3.d()) {
            if (kO3.d() <= kO4.d()) {
                return (T)kO4;
            }
            return (T)kO3;
        }
        if (kO2.d() <= kO4.d()) {
            return (T)kO4;
        }
        return (T)kO2;
    }

    private T l() {
        return (T)((kO)this.b.h(this.a));
    }

    private T m() {
        return (T)((kO)((kO)this.c.d(this.d())).u());
    }

    private re_0<T> c(re_0<T> re_02) {
        return new re_0<kO>((kO)this.a.a(re_02.a), (kO)this.b.a(re_02.b), (kO)this.c.a(re_02.c));
    }

    private re_0<T> a(rs_0 rs_02) {
        rs_0 rs_03 = rs_02;
        rs_0 rs_04 = rs_03;
        rs_0 rs_05 = rs_02;
        rs_04 = rs_05;
        rs_04 = rs_02;
        return new re_0<kO>((kO)this.a.a((double)rs_03.i), (kO)this.b.a((double)rs_05.j), (kO)this.c.a((double)rs_04.k));
    }

    private re_0<T> a(T t, re_0<T> re_02) {
        return new re_0<kO>((kO)this.a.c().b(), (re_0<kO>)this, (kO)t, (re_0<kO>)re_02);
    }

    private re_0<T> a(T t, rs_0 rs_02) {
        rs_0 rs_03 = rs_02;
        rs_0 rs_04 = rs_03;
        rs_0 rs_05 = rs_02;
        rs_04 = rs_05;
        rs_04 = rs_02;
        return new re_0<kO>((kO)this.a.a(t.c(rs_03.i)), (kO)this.b.a(t.c(rs_05.j)), (kO)this.c.a(t.c(rs_04.k)));
    }

    private re_0<T> a(double d2, re_0<T> re_02) {
        return new re_0<T>(1.0, this, d2, re_02);
    }

    private re_0<T> a(double d2, rs_0 rs_02) {
        rs_0 rs_03 = rs_02;
        rs_0 rs_04 = rs_03;
        rs_0 rs_05 = rs_02;
        rs_04 = rs_05;
        rs_04 = rs_02;
        return new re_0<kO>((kO)this.a.a((double)(d2 * rs_03.i)), (kO)this.b.a((double)(d2 * rs_05.j)), (kO)this.c.a((double)(d2 * rs_04.k)));
    }

    private re_0<T> d(re_0<T> re_02) {
        return new re_0<kO>((kO)this.a.b(re_02.a), (kO)this.b.b(re_02.b), (kO)this.c.b(re_02.c));
    }

    private re_0<T> b(rs_0 rs_02) {
        rs_0 rs_03 = rs_02;
        rs_0 rs_04 = rs_03;
        rs_0 rs_05 = rs_02;
        rs_04 = rs_05;
        rs_04 = rs_02;
        return new re_0<kO>((kO)this.a.b(rs_03.i), (kO)this.b.b(rs_05.j), (kO)this.c.b(rs_04.k));
    }

    private re_0<T> b(T t, re_0<T> re_02) {
        return new re_0<kO>((kO)this.a.c().b(), this, (kO)t.a(), re_02);
    }

    private re_0<T> b(T t, rs_0 rs_02) {
        rs_0 rs_03 = rs_02;
        rs_0 rs_04 = rs_03;
        rs_0 rs_05 = rs_02;
        rs_04 = rs_05;
        rs_04 = rs_02;
        return new re_0<kO>((kO)this.a.b(t.c(rs_03.i)), (kO)this.b.b(t.c(rs_05.j)), (kO)this.c.b(t.c(rs_04.k)));
    }

    private re_0<T> b(double d2, re_0<T> re_02) {
        return new re_0<T>(1.0, this, -d2, re_02);
    }

    private re_0<T> b(double d2, rs_0 rs_02) {
        rs_0 rs_03 = rs_02;
        rs_0 rs_04 = rs_03;
        rs_0 rs_05 = rs_02;
        rs_04 = rs_05;
        rs_04 = rs_02;
        return new re_0<kO>((kO)this.a.b(d2 * rs_03.i), (kO)this.b.b(d2 * rs_05.j), (kO)this.c.b(d2 * rs_04.k));
    }

    public final re_0<T> e() {
        T t = this.d();
        if (t.d() == 0.0) {
            throw new oU(px_0.CANNOT_NORMALIZE_A_ZERO_NORM_VECTOR, new Object[0]);
        }
        return this.a((kO)t.b());
    }

    public final re_0<T> f() {
        double d2 = 0.6 * this.d().d();
        if (d2 == 0.0) {
            throw new oU(px_0.ZERO_NORM, new Object[0]);
        }
        if (BY.w(this.a.d()) <= d2) {
            kO kO2 = (kO)((kO)((kO)((kO)this.b.c(this.b)).a(this.c.c(this.c))).k()).b();
            return new re_0<kO>((kO)kO2.c().a(), (kO)kO2.c(this.c), (kO)((kO)kO2.c(this.b)).a());
        }
        if (BY.w(this.b.d()) <= d2) {
            kO kO3 = (kO)((kO)((kO)((kO)this.a.c(this.a)).a(this.c.c(this.c))).k()).b();
            return new re_0<kO>((kO)((kO)kO3.c(this.c)).a(), (kO)kO3.c().a(), (kO)kO3.c(this.a));
        }
        kO kO4 = (kO)((kO)((kO)((kO)this.a.c(this.a)).a(this.b.c(this.b))).k()).b();
        return new re_0<kO>((kO)kO4.c(this.b), (kO)((kO)kO4.c(this.a)).a(), (kO)kO4.c().a());
    }

    private static <T extends kO<T>> T c(re_0<T> re_02, re_0<T> re_03) {
        kO kO2 = (kO)re_02.d().c(re_03.d());
        if (kO2.d() == 0.0) {
            throw new oU(px_0.ZERO_NORM, new Object[0]);
        }
        re_0<T> re_04 = re_03;
        re_0<T> re_05 = re_02;
        kO kO3 = re_05.a(re_04);
        double d2 = kO2.d() * 0.9999;
        if (kO3.d() < -d2 || kO3.d() > d2) {
            re_04 = re_03;
            re_0<T> re_06 = re_02;
            re_02 = re_06.b(re_04);
            if (kO3.d() >= 0.0) {
                return (T)((kO)re_02.d().d((kO)kO2).u());
            }
            return (T)((kO)((kO)((kO)re_02.d().d((kO)kO2).u()).b(Math.PI)).a());
        }
        return (T)((kO)kO3.d((kO)kO2).t());
    }

    private static <T extends kO<T>> T a(re_0<T> re_02, rs_0 rs_02) {
        kO kO2 = (kO)re_02.d().c(rs_02.e());
        if (kO2.d() == 0.0) {
            throw new oU(px_0.ZERO_NORM, new Object[0]);
        }
        rs_0 rs_03 = rs_02;
        re_0<T> re_03 = re_02;
        kO kO3 = re_03.c(rs_03);
        double d2 = kO2.d() * 0.9999;
        if (kO3.d() < -d2 || kO3.d() > d2) {
            rs_03 = rs_02;
            Serializable serializable = re_02;
            rs_02 = rs_03;
            re_02 = serializable;
            rs_0 rs_04 = rs_02;
            serializable = rs_04;
            rs_0 rs_05 = rs_02;
            serializable = rs_05;
            rs_0 rs_06 = rs_02;
            serializable = rs_06;
            rs_0 rs_07 = rs_02;
            serializable = rs_07;
            rs_0 rs_08 = rs_02;
            serializable = rs_08;
            serializable = rs_02;
            re_02 = new re_0<kO>((kO)re_02.a.a(rs_04.k, re_02.b, -rs_05.j, re_02.c), (kO)re_02.b.a(rs_06.i, re_02.c, -rs_07.k, re_02.a), (kO)re_02.c.a(rs_08.j, re_02.a, -((rs_0)serializable).i, re_02.b));
            if (kO3.d() >= 0.0) {
                return (T)((kO)re_02.d().d(kO2).u());
            }
            return (T)((kO)((kO)((kO)re_02.d().d(kO2).u()).b(Math.PI)).a());
        }
        return (T)((kO)kO3.d((kO)kO2).t());
    }

    private static <T extends kO<T>> T a(rs_0 serializable, re_0<T> serializable2) {
        re_0<T> re_02 = serializable2;
        serializable2 = serializable;
        serializable = re_02;
        kO kO2 = (kO)re_02.d().c(((rs_0)serializable2).e());
        if (kO2.d() == 0.0) {
            throw new oU(px_0.ZERO_NORM, new Object[0]);
        }
        Serializable serializable3 = serializable2;
        Serializable serializable4 = serializable;
        kO kO3 = ((re_0)serializable4).c((rs_0)serializable3);
        double d2 = kO2.d() * 0.9999;
        if (kO3.d() < -d2 || kO3.d() > d2) {
            serializable3 = serializable2;
            serializable4 = serializable;
            serializable2 = serializable3;
            serializable = serializable4;
            Serializable serializable5 = serializable2;
            serializable4 = serializable5;
            Serializable serializable6 = serializable2;
            serializable4 = serializable6;
            Serializable serializable7 = serializable2;
            serializable4 = serializable7;
            Serializable serializable8 = serializable2;
            serializable4 = serializable8;
            Serializable serializable9 = serializable2;
            serializable4 = serializable9;
            serializable4 = serializable2;
            serializable = new re_0<kO>((kO)((re_0)serializable).a.a(((rs_0)serializable5).k, ((re_0)serializable).b, -((rs_0)serializable6).j, ((re_0)serializable).c), (kO)((re_0)serializable).b.a(((rs_0)serializable7).i, ((re_0)serializable).c, -((rs_0)serializable8).k, ((re_0)serializable).a), (kO)((re_0)serializable).c.a(((rs_0)serializable9).j, ((re_0)serializable).a, -((rs_0)serializable4).i, ((re_0)serializable).b));
            if (kO3.d() >= 0.0) {
                return (T)((kO)((re_0)serializable).d().d((kO)kO2).u());
            }
            return (T)((kO)((kO)((kO)((re_0)serializable).d().d((kO)kO2).u()).b(Math.PI)).a());
        }
        return (T)((kO)kO3.d((kO)kO2).t());
    }

    private re_0<T> n() {
        return new re_0<kO>((kO)this.a.a(), (kO)this.b.a(), (kO)this.c.a());
    }

    private re_0<T> a(T t) {
        return new re_0<kO>((kO)this.a.c(t), (kO)this.b.c(t), (kO)this.c.c(t));
    }

    private re_0<T> a(double d2) {
        return new re_0<kO>((kO)this.a.c(d2), (kO)this.b.c(d2), (kO)this.c.c(d2));
    }

    private boolean o() {
        return Double.isNaN(this.a.d()) || Double.isNaN(this.b.d()) || Double.isNaN(this.c.d());
    }

    private boolean p() {
        return !this.o() && (Double.isInfinite(this.a.d()) || Double.isInfinite(this.b.d()) || Double.isInfinite(this.c.d()));
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof re_0) {
            re_0 re_02;
            if ((re_02 = (re_0)re_02).o()) {
                return this.o();
            }
            return this.a.equals(re_02.a) && this.b.equals(re_02.b) && this.c.equals(re_02.c);
        }
        return false;
    }

    public final int hashCode() {
        if (this.o()) {
            return 409;
        }
        return 311 * (107 * this.a.hashCode() + 83 * this.b.hashCode() + this.c.hashCode());
    }

    public final T a(re_0<T> re_02) {
        return (T)((kO)this.a.a(this.a, re_02.a, this.b, re_02.b, this.c, re_02.c));
    }

    private T c(rs_0 rs_02) {
        rs_0 rs_03 = rs_02;
        rs_0 rs_04 = rs_03;
        rs_0 rs_05 = rs_02;
        rs_04 = rs_05;
        rs_04 = rs_02;
        return (T)((kO)this.a.a(rs_03.i, this.a, rs_05.j, this.b, rs_04.k, this.c));
    }

    public final re_0<T> b(re_0<T> re_02) {
        return new re_0<kO>((kO)this.a.a(this.b, re_02.c, this.c.a(), re_02.b), (kO)this.b.a(this.c, re_02.a, this.a.a(), re_02.c), (kO)this.c.a(this.a, re_02.b, this.b.a(), re_02.a));
    }

    private re_0<T> d(rs_0 rs_02) {
        rs_0 rs_03 = rs_02;
        rs_0 rs_04 = rs_03;
        rs_0 rs_05 = rs_02;
        rs_04 = rs_05;
        rs_0 rs_06 = rs_02;
        rs_04 = rs_06;
        rs_0 rs_07 = rs_02;
        rs_04 = rs_07;
        rs_0 rs_08 = rs_02;
        rs_04 = rs_08;
        rs_04 = rs_02;
        return new re_0<kO>((kO)this.a.a(rs_03.k, this.b, -rs_05.j, this.c), (kO)this.b.a(rs_06.i, this.c, -rs_07.k, this.a), (kO)this.c.a(rs_08.j, this.a, -rs_04.i, this.b));
    }

    private T e(re_0<T> object) {
        kO kO2 = (kO)((kO)((re_0)object).a.b(this.a)).e();
        kO kO3 = (kO)((kO)((re_0)object).b.b(this.b)).e();
        object = (kO)((kO)((re_0)object).c.b(this.c)).e();
        return (T)((kO)kO2.a(kO3).a(object));
    }

    private T e(rs_0 object) {
        rs_0 rs_02 = object;
        kO kO2 = (kO)((kO)this.a.b(rs_02.i)).e();
        rs_02 = object;
        kO kO3 = (kO)((kO)this.b.b(rs_02.j)).e();
        rs_02 = object;
        object = (kO)((kO)this.c.b(rs_02.k)).e();
        return (T)((kO)kO2.a(kO3).a(object));
    }

    private T f(re_0<T> object) {
        kO kO2 = (kO)((re_0)object).a.b(this.a);
        kO kO3 = (kO)((re_0)object).b.b(this.b);
        object = (kO)((re_0)object).c.b(this.c);
        kO kO4 = kO2;
        kO kO5 = kO3;
        Object object2 = object;
        return (T)((kO)((kO)kO4.c(kO4).a(kO5.c(kO5)).a(object2.c(object2))).k());
    }

    private T f(rs_0 object) {
        rs_0 rs_02 = object;
        kO kO2 = (kO)this.a.b(rs_02.i);
        rs_02 = object;
        kO kO3 = (kO)this.b.b(rs_02.j);
        rs_02 = object;
        object = (kO)this.c.b(rs_02.k);
        kO kO4 = kO2;
        kO kO5 = kO3;
        Object object2 = object;
        return (T)((kO)((kO)kO4.c(kO4).a(kO5.c(kO5)).a(object2.c(object2))).k());
    }

    private T g(re_0<T> object) {
        kO kO2 = (kO)((kO)((re_0)object).a.b(this.a)).e();
        kO kO3 = (kO)((kO)((re_0)object).b.b(this.b)).e();
        object = (kO)((kO)((re_0)object).c.b(this.c)).e();
        if (kO2.d() <= kO3.d()) {
            if (kO3.d() <= object.d()) {
                return (T)object;
            }
            return (T)kO3;
        }
        if (kO2.d() <= object.d()) {
            return (T)object;
        }
        return (T)kO2;
    }

    private T g(rs_0 object) {
        rs_0 rs_02 = object;
        kO kO2 = (kO)((kO)this.a.b(rs_02.i)).e();
        rs_02 = object;
        kO kO3 = (kO)((kO)this.b.b(rs_02.j)).e();
        rs_02 = object;
        object = (kO)((kO)this.c.b(rs_02.k)).e();
        if (kO2.d() <= kO3.d()) {
            if (kO3.d() <= object.d()) {
                return (T)object;
            }
            return (T)kO3;
        }
        if (kO2.d() <= object.d()) {
            return (T)object;
        }
        return (T)kO2;
    }

    private T h(re_0<T> object) {
        kO kO2 = (kO)((re_0)object).a.b(this.a);
        kO kO3 = (kO)((re_0)object).b.b(this.b);
        object = (kO)((re_0)object).c.b(this.c);
        kO kO4 = kO2;
        kO kO5 = kO3;
        Object object2 = object;
        return (T)((kO)kO4.c(kO4).a(kO5.c(kO5)).a(object2.c(object2)));
    }

    private T h(rs_0 object) {
        rs_0 rs_02 = object;
        kO kO2 = (kO)this.a.b(rs_02.i);
        rs_02 = object;
        kO kO3 = (kO)this.b.b(rs_02.j);
        rs_02 = object;
        object = (kO)this.c.b(rs_02.k);
        kO kO4 = kO2;
        kO kO5 = kO3;
        Object object2 = object;
        return (T)((kO)kO4.c(kO4).a(kO5.c(kO5)).a(object2.c(object2)));
    }

    public static <T extends kO<T>> T a(re_0<T> re_02, re_0<T> re_03) {
        return re_02.a(re_03);
    }

    private static <T extends kO<T>> T b(re_0<T> re_02, rs_0 rs_02) {
        return re_02.c(rs_02);
    }

    private static <T extends kO<T>> T b(rs_0 rs_02, re_0<T> re_02) {
        return re_02.c(rs_02);
    }

    public static <T extends kO<T>> re_0<T> b(re_0<T> re_02, re_0<T> re_03) {
        return re_02.b(re_03);
    }

    private static <T extends kO<T>> re_0<T> c(re_0<T> re_02, rs_0 rs_02) {
        return re_02.d(rs_02);
    }

    private static <T extends kO<T>> re_0<T> c(rs_0 rs_02, re_0<T> re_02) {
        rs_0 rs_03 = rs_02;
        rs_0 rs_04 = rs_03;
        rs_0 rs_05 = rs_02;
        rs_04 = rs_05;
        rs_0 rs_06 = rs_02;
        rs_04 = rs_06;
        rs_0 rs_07 = rs_02;
        rs_04 = rs_07;
        rs_0 rs_08 = rs_02;
        rs_04 = rs_08;
        rs_04 = rs_02;
        return new re_0<kO>((kO)re_02.a.a(rs_03.j, re_02.c, -rs_05.k, re_02.b), (kO)re_02.b.a(rs_06.k, re_02.a, -rs_07.i, re_02.c), (kO)re_02.c.a(rs_08.i, re_02.b, -rs_04.j, re_02.a));
    }

    private static <T extends kO<T>> T d(re_0<T> object, re_0<T> re_02) {
        kO kO2 = (kO)((kO)re_02.a.b(((re_0)object).a)).e();
        kO kO3 = (kO)((kO)re_02.b.b(((re_0)object).b)).e();
        object = (kO)((kO)re_02.c.b(((re_0)object).c)).e();
        return (T)((kO)kO2.a(kO3).a(object));
    }

    private static <T extends kO<T>> T d(re_0<T> re_02, rs_0 rs_02) {
        return re_02.e(rs_02);
    }

    private static <T extends kO<T>> T d(rs_0 rs_02, re_0<T> re_02) {
        return re_02.e(rs_02);
    }

    private static <T extends kO<T>> T e(re_0<T> object, re_0<T> re_02) {
        kO kO2 = (kO)re_02.a.b(((re_0)object).a);
        kO kO3 = (kO)re_02.b.b(((re_0)object).b);
        object = (kO)re_02.c.b(((re_0)object).c);
        kO kO4 = kO2;
        kO kO5 = kO3;
        Object object2 = object;
        return (T)((kO)((kO)kO4.c(kO4).a(kO5.c(kO5)).a(object2.c(object2))).k());
    }

    private static <T extends kO<T>> T e(re_0<T> re_02, rs_0 rs_02) {
        return re_02.f(rs_02);
    }

    private static <T extends kO<T>> T e(rs_0 rs_02, re_0<T> re_02) {
        return re_02.f(rs_02);
    }

    private static <T extends kO<T>> T f(re_0<T> object, re_0<T> re_02) {
        kO kO2 = (kO)((kO)re_02.a.b(((re_0)object).a)).e();
        kO kO3 = (kO)((kO)re_02.b.b(((re_0)object).b)).e();
        object = (kO)((kO)re_02.c.b(((re_0)object).c)).e();
        if (kO2.d() <= kO3.d()) {
            if (kO3.d() <= object.d()) {
                return (T)object;
            }
            return (T)kO3;
        }
        if (kO2.d() <= object.d()) {
            return (T)object;
        }
        return (T)kO2;
    }

    private static <T extends kO<T>> T f(re_0<T> re_02, rs_0 rs_02) {
        return re_02.g(rs_02);
    }

    private static <T extends kO<T>> T f(rs_0 rs_02, re_0<T> re_02) {
        return re_02.g(rs_02);
    }

    private static <T extends kO<T>> T g(re_0<T> object, re_0<T> re_02) {
        kO kO2 = (kO)re_02.a.b(((re_0)object).a);
        kO kO3 = (kO)re_02.b.b(((re_0)object).b);
        object = (kO)re_02.c.b(((re_0)object).c);
        kO kO4 = kO2;
        kO kO5 = kO3;
        Object object2 = object;
        return (T)((kO)kO4.c(kO4).a(kO5.c(kO5)).a(object2.c(object2)));
    }

    private static <T extends kO<T>> T g(re_0<T> re_02, rs_0 rs_02) {
        return re_02.h(rs_02);
    }

    private static <T extends kO<T>> T g(rs_0 rs_02, re_0<T> re_02) {
        return re_02.h(rs_02);
    }

    public final String toString() {
        return rt_0.a(Locale.getDefault()).a(this.h());
    }

    private String a(NumberFormat numberFormat) {
        return new rt_0(numberFormat).a(this.h());
    }
}

