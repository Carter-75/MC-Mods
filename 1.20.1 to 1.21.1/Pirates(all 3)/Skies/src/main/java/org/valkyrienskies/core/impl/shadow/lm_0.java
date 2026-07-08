/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.ch_0;
import org.valkyrienskies.core.impl.shadow.ci_0;
import org.valkyrienskies.core.impl.shadow.cq_0;
import org.valkyrienskies.core.impl.shadow.kM;
import org.valkyrienskies.core.impl.shadow.kN;
import org.valkyrienskies.core.impl.shadow.kO;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.lm
 */
public class lm_0
implements Serializable,
kO<lm_0> {
    private static final long a = 20131025L;
    private double b;
    private final Map<Integer, Double> c;

    private lm_0(double d2, Map<Integer, Double> map2) {
        this.b = d2;
        this.c = new HashMap<Integer, Double>();
        if (map2 != null) {
            this.c.putAll(map2);
        }
    }

    private lm_0(double d2, double d3, Map<Integer, Double> map2) {
        this.b = d2;
        this.c = new HashMap<Integer, Double>();
        if (map2 != null) {
            for (Map.Entry<Integer, Double> entry : map2.entrySet()) {
                this.c.put(entry.getKey(), d3 * entry.getValue());
            }
        }
    }

    public static lm_0 h(double d2) {
        return new lm_0(d2, Collections.<Integer, Double>emptyMap());
    }

    private static lm_0 a(int n2, double d2) {
        return new lm_0(d2, Collections.singletonMap(n2, 1.0));
    }

    private int C() {
        return this.c.size();
    }

    @Override
    private double e(int n2) {
        Double d2 = this.c.get(n2);
        if (d2 == null) {
            return 0.0;
        }
        return d2;
    }

    private double D() {
        return this.b;
    }

    @Override
    public final double d() {
        return this.b;
    }

    @Override
    private lm_0 a(lm_0 object) {
        lm_0 lm_02 = new lm_0(this.b + ((lm_0)((Object)object)).b, this.c);
        for (Map.Entry<Integer, Double> entry : ((lm_0)((Object)object)).c.entrySet()) {
            int n2 = entry.getKey();
            Double d2 = lm_02.c.get(n2);
            if (d2 == null) {
                lm_02.c.put(n2, entry.getValue());
                continue;
            }
            lm_02.c.put(n2, d2 + entry.getValue());
        }
        return lm_02;
    }

    @Override
    private void b(lm_0 object) {
        this.b += ((lm_0)((Object)object)).b;
        for (Map.Entry<Integer, Double> entry : ((lm_0)((Object)object)).c.entrySet()) {
            int n2 = entry.getKey();
            Double d2 = this.c.get(n2);
            if (d2 == null) {
                this.c.put(n2, entry.getValue());
                continue;
            }
            this.c.put(n2, d2 + entry.getValue());
        }
    }

    private lm_0 i(double d2) {
        lm_0 lm_02 = new lm_0(this.b + d2, this.c);
        return lm_02;
    }

    @Override
    private lm_0 c(lm_0 object) {
        lm_0 lm_02 = new lm_0(this.b - ((lm_0)((Object)object)).b, this.c);
        for (Map.Entry<Integer, Double> entry : ((lm_0)((Object)object)).c.entrySet()) {
            int n2 = entry.getKey();
            Double d2 = lm_02.c.get(n2);
            if (d2 == null) {
                lm_02.c.put(n2, -entry.getValue().doubleValue());
                continue;
            }
            lm_02.c.put(n2, d2 - entry.getValue());
        }
        return lm_02;
    }

    private lm_0 j(double d2) {
        return new lm_0(this.b - d2, this.c);
    }

    @Override
    private lm_0 d(lm_0 lm_02) {
        lm_0 lm_03 = new lm_0(this.b * lm_02.b, Collections.<Integer, Double>emptyMap());
        for (Map.Entry<Integer, Double> entry : this.c.entrySet()) {
            lm_03.c.put(entry.getKey(), lm_02.b * entry.getValue());
        }
        for (Map.Entry<Integer, Double> entry : lm_02.c.entrySet()) {
            int n2 = entry.getKey();
            Double d2 = lm_03.c.get(n2);
            if (d2 == null) {
                lm_03.c.put(n2, this.b * entry.getValue());
                continue;
            }
            lm_03.c.put(n2, d2 + this.b * entry.getValue());
        }
        return lm_03;
    }

    @Override
    private void e(lm_0 lm_02) {
        for (Map.Entry<Integer, Double> entry : this.c.entrySet()) {
            this.c.put(entry.getKey(), lm_02.b * entry.getValue());
        }
        for (Map.Entry<Integer, Double> entry : lm_02.c.entrySet()) {
            int n2 = entry.getKey();
            Double d2 = this.c.get(n2);
            if (d2 == null) {
                this.c.put(n2, this.b * entry.getValue());
                continue;
            }
            this.c.put(n2, d2 + this.b * entry.getValue());
        }
        this.b *= lm_02.b;
    }

    private lm_0 k(double d2) {
        return new lm_0(this.b * d2, d2, this.c);
    }

    @Override
    private lm_0 f(int n2) {
        return new lm_0(this.b * (double)n2, n2, this.c);
    }

    @Override
    private lm_0 f(lm_0 lm_02) {
        lm_0 lm_03 = new lm_0(this.b / lm_02.b, Collections.<Integer, Double>emptyMap());
        for (Map.Entry<Integer, Double> entry : this.c.entrySet()) {
            lm_03.c.put(entry.getKey(), entry.getValue() / lm_02.b);
        }
        for (Map.Entry<Integer, Double> entry : lm_02.c.entrySet()) {
            int n2 = entry.getKey();
            Double d2 = lm_03.c.get(n2);
            if (d2 == null) {
                lm_03.c.put(n2, -lm_03.b / lm_02.b * entry.getValue());
                continue;
            }
            lm_03.c.put(n2, d2 - lm_03.b / lm_02.b * entry.getValue());
        }
        return lm_03;
    }

    private lm_0 l(double d2) {
        return new lm_0(this.b / d2, 1.0 / d2, this.c);
    }

    private lm_0 E() {
        return new lm_0(-this.b, -1.0, this.c);
    }

    @Override
    public final kM<lm_0> c() {
        return new kM<lm_0>(this){
            private /* synthetic */ lm_0 a;
            {
                this.a = lm_02;
            }

            private static lm_0 d() {
                return lm_0.h(0.0);
            }

            private static lm_0 e() {
                return lm_0.h(1.0);
            }

            @Override
            public final Class<? extends kN<lm_0>> c() {
                return lm_0.class;
            }

            @Override
            public final /* synthetic */ kN b() {
                return lm_0.h(1.0);
            }

            @Override
            public final /* synthetic */ kN a() {
                return lm_0.h(0.0);
            }
        };
    }

    private lm_0 m(double d2) {
        return new lm_0(BY.g(this.b, d2), this.c);
    }

    @Override
    private lm_0 g(lm_0 lm_02) {
        double d2 = BY.g(this.b, lm_02.b);
        double d3 = BY.A((this.b - d2) / lm_02.b);
        return this.c(lm_02.k(d3));
    }

    private lm_0 F() {
        if (Double.doubleToLongBits(this.b) < 0L) {
            return this.E();
        }
        return this;
    }

    private lm_0 G() {
        return lm_0.h(BY.z(this.b));
    }

    private lm_0 H() {
        return lm_0.h(BY.y(this.b));
    }

    private lm_0 I() {
        return lm_0.h(BY.A(this.b));
    }

    @Override
    public final long i() {
        return BY.B(this.b);
    }

    private lm_0 J() {
        return lm_0.h(BY.h(this.b));
    }

    @Override
    private lm_0 h(lm_0 lm_02) {
        long l2 = Double.doubleToLongBits(this.b);
        long l3 = Double.doubleToLongBits(lm_02.b);
        if (l2 >= 0L && l3 >= 0L || l2 < 0L && l3 < 0L) {
            return this;
        }
        return this.E();
    }

    private lm_0 n(double d2) {
        long l2 = Double.doubleToLongBits(this.b);
        long l3 = Double.doubleToLongBits(d2);
        if (l2 >= 0L && l3 >= 0L || l2 < 0L && l3 < 0L) {
            return this;
        }
        return this.E();
    }

    @Override
    private lm_0 g(int n2) {
        lm_0 lm_02 = new lm_0(BY.b(this.b, n2), Collections.<Integer, Double>emptyMap());
        for (Map.Entry<Integer, Double> entry : this.c.entrySet()) {
            lm_02.c.put(entry.getKey(), BY.b((double)entry.getValue(), n2));
        }
        return lm_02;
    }

    private lm_0 i(lm_0 lm_02) {
        int n2;
        if (Double.isInfinite(this.b) || Double.isInfinite(lm_02.b)) {
            return lm_0.h(Double.POSITIVE_INFINITY);
        }
        if (Double.isNaN(this.b) || Double.isNaN(lm_02.b)) {
            return lm_0.h(Double.NaN);
        }
        int n3 = BY.C(this.b);
        if (n3 > (n2 = BY.C(lm_02.b)) + 27) {
            return this.F();
        }
        if (n2 > n3 + 27) {
            return lm_02.F();
        }
        n3 = (n3 + n2) / 2;
        lm_0 lm_03 = this.g(-n3);
        lm_02 = lm_02.g(-n3);
        lm_0 lm_04 = lm_03;
        lm_0 lm_05 = lm_02;
        lm_02 = lm_04.d(lm_04).a(lm_05.d(lm_05)).L();
        return lm_02.g(n3);
    }

    private static lm_0 a(lm_0 lm_02, lm_0 lm_03) {
        return lm_02.i(lm_03);
    }

    private lm_0 K() {
        return new lm_0(1.0 / this.b, -1.0 / (this.b * this.b), this.c);
    }

    private lm_0 L() {
        double d2 = BY.a(this.b);
        return new lm_0(d2, 0.5 / d2, this.c);
    }

    private lm_0 M() {
        double d2 = BY.t(this.b);
        return new lm_0(d2, 1.0 / (d2 * 3.0 * d2), this.c);
    }

    @Override
    private lm_0 h(int n2) {
        if (n2 == 2) {
            return this.L();
        }
        if (n2 == 3) {
            return this.M();
        }
        double d2 = BY.a(this.b, 1.0 / (double)n2);
        return new lm_0(d2, 1.0 / ((double)n2 * BY.a(d2, n2 - 1)), this.c);
    }

    private lm_0 o(double d2) {
        return new lm_0(BY.a(this.b, d2), d2 * BY.a(this.b, d2 - 1.0), this.c);
    }

    private lm_0 i(int n2) {
        if (n2 == 0) {
            return this.c().b();
        }
        double d2 = BY.a(this.b, n2 - 1);
        return new lm_0(this.b * d2, (double)n2 * d2, this.c);
    }

    private lm_0 j(lm_0 lm_02) {
        return this.P().d(lm_02).N();
    }

    private static lm_0 a(double d2, lm_0 lm_02) {
        double d3;
        if (d2 == 0.0) {
            if (lm_02.b == 0.0) {
                return lm_02.a(1.0, Double.NEGATIVE_INFINITY);
            }
            if (lm_02.b < 0.0) {
                return lm_02.a(Double.NaN, Double.NaN);
            }
            return lm_02.c().a();
        }
        double d4 = d3 = BY.a(d2, lm_02.b);
        return new lm_0(d4, d4 * BY.k(d2), lm_02.c);
    }

    private lm_0 N() {
        double d2;
        double d3 = d2 = BY.i(this.b);
        return new lm_0(d3, d3, this.c);
    }

    private lm_0 O() {
        return new lm_0(BY.j(this.b), BY.i(this.b), this.c);
    }

    private lm_0 P() {
        return new lm_0(BY.k(this.b), 1.0 / this.b, this.c);
    }

    private lm_0 Q() {
        return new lm_0(BY.m(this.b), 1.0 / (BY.k(10.0) * this.b), this.c);
    }

    private lm_0 R() {
        return new lm_0(BY.l(this.b), 1.0 / (1.0 + this.b), this.c);
    }

    private lm_0 S() {
        return new lm_0(BY.o(this.b), -BY.n(this.b), this.c);
    }

    private lm_0 T() {
        return new lm_0(BY.n(this.b), BY.o(this.b), this.c);
    }

    private lm_0 U() {
        double d2;
        double d3 = d2 = BY.p(this.b);
        return new lm_0(d2, 1.0 + d3 * d3, this.c);
    }

    private lm_0 V() {
        return new lm_0(BY.s(this.b), -1.0 / BY.a(1.0 - this.b * this.b), this.c);
    }

    private lm_0 W() {
        return new lm_0(BY.r(this.b), 1.0 / BY.a(1.0 - this.b * this.b), this.c);
    }

    private lm_0 X() {
        return new lm_0(BY.q(this.b), 1.0 / (1.0 + this.b * this.b), this.c);
    }

    private lm_0 k(lm_0 lm_02) {
        lm_0 lm_03 = this;
        lm_0 lm_04 = lm_02;
        lm_0 lm_05 = lm_03.d(lm_03).a(lm_04.d(lm_04)).L();
        if (lm_02.b >= 0.0) {
            lm_05 = this.f(lm_05.a(lm_02)).X().f(2);
        } else {
            lm_05 = this.f(lm_05.c(lm_02)).X().f(-2);
            lm_05 = lm_05.i(lm_05.b <= 0.0 ? -Math.PI : Math.PI);
        }
        lm_05.b = BY.b(this.b, lm_02.b);
        return lm_05;
    }

    private static lm_0 b(lm_0 lm_02, lm_0 lm_03) {
        return lm_02.k(lm_03);
    }

    private lm_0 Y() {
        return new lm_0(BY.b(this.b), BY.c(this.b), this.c);
    }

    private lm_0 Z() {
        return new lm_0(BY.c(this.b), BY.b(this.b), this.c);
    }

    private lm_0 aa() {
        double d2;
        double d3 = d2 = BY.d(this.b);
        return new lm_0(d2, 1.0 - d3 * d3, this.c);
    }

    private lm_0 ab() {
        return new lm_0(BY.e(this.b), 1.0 / BY.a(this.b * this.b - 1.0), this.c);
    }

    private lm_0 ac() {
        return new lm_0(BY.f(this.b), 1.0 / BY.a(this.b * this.b + 1.0), this.c);
    }

    private lm_0 ad() {
        return new lm_0(BY.g(this.b), 1.0 / (1.0 - this.b * this.b), this.c);
    }

    private lm_0 ae() {
        return new lm_0(BY.v(this.b), BY.v(1.0), this.c);
    }

    private lm_0 af() {
        return new lm_0(BY.u(this.b), BY.u(1.0), this.c);
    }

    @Override
    private double a(double ... dArray) {
        double d2 = this.b;
        for (int i2 = 0; i2 < dArray.length; ++i2) {
            int n2 = i2;
            Serializable serializable = this;
            serializable = ((lm_0)serializable).c.get(n2);
            d2 += dArray[i2] * (serializable == null ? 0.0 : (Double)serializable);
        }
        return d2;
    }

    private lm_0 a(double d2, double d3) {
        return new lm_0(d2, d3, this.c);
    }

    private static lm_0 a(lm_0[] lm_0Array, lm_0[] lm_0Array2) {
        lm_0 lm_02;
        lm_0 lm_03 = lm_0Array[0].c().a();
        for (int i2 = 0; i2 < lm_0Array.length; ++i2) {
            lm_03 = lm_03.a(lm_0Array[i2].d(lm_0Array2[i2]));
        }
        double[] dArray = new double[lm_0Array.length];
        for (int i3 = 0; i3 < lm_0Array.length; ++i3) {
            lm_02 = lm_0Array[i3];
            dArray[i3] = lm_02.b;
        }
        double[] dArray2 = new double[lm_0Array2.length];
        for (int i4 = 0; i4 < lm_0Array2.length; ++i4) {
            lm_02 = lm_0Array2[i4];
            dArray2[i4] = lm_02.b;
        }
        lm_03.b = ch_0.h(dArray, dArray2);
        return lm_03;
    }

    private static lm_0 a(double[] dArray, lm_0[] lm_0Array) {
        lm_0 lm_02 = lm_0Array[0].c().a();
        for (int i2 = 0; i2 < dArray.length; ++i2) {
            lm_02 = lm_02.a(lm_0Array[i2].k(dArray[i2]));
        }
        double[] dArray2 = new double[lm_0Array.length];
        for (int i3 = 0; i3 < lm_0Array.length; ++i3) {
            lm_0 lm_03 = lm_0Array[i3];
            dArray2[i3] = lm_03.b;
        }
        lm_02.b = ch_0.h(dArray, dArray2);
        return lm_02;
    }

    private static lm_0 a(lm_0 lm_02, lm_0 lm_03, lm_0 lm_04, lm_0 lm_05) {
        lm_0 lm_06 = lm_02.d(lm_03).a(lm_04.d(lm_05));
        lm_02.d(lm_03).a(lm_04.d(lm_05)).b = ch_0.a(lm_02.b, lm_03.b, lm_04.b, lm_05.b);
        return lm_06;
    }

    private static lm_0 a(double d2, lm_0 lm_02, double d3, lm_0 lm_03) {
        lm_0 lm_04 = lm_02.k(d2).a(lm_03.k(d3));
        lm_02.k(d2).a(lm_03.k(d3)).b = ch_0.a(d2, lm_02.b, d3, lm_03.b);
        return lm_04;
    }

    private static lm_0 a(lm_0 lm_02, lm_0 lm_03, lm_0 lm_04, lm_0 lm_05, lm_0 lm_06, lm_0 lm_07) {
        lm_0 lm_08 = lm_02.d(lm_03).a(lm_04.d(lm_05)).a(lm_06.d(lm_07));
        lm_02.d(lm_03).a(lm_04.d(lm_05)).a(lm_06.d(lm_07)).b = ch_0.a(lm_02.b, lm_03.b, lm_04.b, lm_05.b, lm_06.b, lm_07.b);
        return lm_08;
    }

    private static lm_0 a(double d2, lm_0 lm_02, double d3, lm_0 lm_03, double d4, lm_0 lm_04) {
        lm_0 lm_05 = lm_02.k(d2).a(lm_03.k(d3)).a(lm_04.k(d4));
        lm_02.k(d2).a(lm_03.k(d3)).a(lm_04.k(d4)).b = ch_0.a(d2, lm_02.b, d3, lm_03.b, d4, lm_04.b);
        return lm_05;
    }

    private static lm_0 a(lm_0 lm_02, lm_0 lm_03, lm_0 lm_04, lm_0 lm_05, lm_0 lm_06, lm_0 lm_07, lm_0 lm_08, lm_0 lm_09) {
        lm_0 lm_010 = lm_02.d(lm_03).a(lm_04.d(lm_05)).a(lm_06.d(lm_07)).a(lm_08.d(lm_09));
        lm_02.d(lm_03).a(lm_04.d(lm_05)).a(lm_06.d(lm_07)).a(lm_08.d(lm_09)).b = ch_0.a(lm_02.b, lm_03.b, lm_04.b, lm_05.b, lm_06.b, lm_07.b, lm_08.b, lm_09.b);
        return lm_010;
    }

    private static lm_0 a(double d2, lm_0 lm_02, double d3, lm_0 lm_03, double d4, lm_0 lm_04, double d5, lm_0 lm_05) {
        lm_0 lm_06 = lm_02.k(d2).a(lm_03.k(d3)).a(lm_04.k(d4)).a(lm_05.k(d5));
        lm_02.k(d2).a(lm_03.k(d3)).a(lm_04.k(d4)).a(lm_05.k(d5)).b = ch_0.a(d2, lm_02.b, d3, lm_03.b, d4, lm_04.b, d5, lm_05.b);
        return lm_06;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof lm_0) {
            lm_0 lm_02;
            lm_02 = lm_02;
            if (!cq_0.b(this.b, lm_02.b, 1)) {
                return false;
            }
            if (this.c.size() != lm_02.c.size()) {
                return false;
            }
            for (Map.Entry<Integer, Double> entry : this.c.entrySet()) {
                if (!lm_02.c.containsKey(entry.getKey())) {
                    return false;
                }
                if (cq_0.b((double)entry.getValue(), (double)lm_02.c.get(entry.getKey()), 1)) continue;
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        return 743 + 809 * ci_0.a(this.b) + 167 * this.c.hashCode();
    }

    @Override
    public final /* synthetic */ kO a(double d2, kO kO2, double d3, kO kO3, double d4, kO kO4, double d5, kO kO5) {
        lm_0 lm_02 = (lm_0)kO2;
        lm_0 lm_03 = (lm_0)kO5;
        double d6 = d5;
        kO2 = (lm_0)kO4;
        double d7 = d4;
        lm_0 lm_04 = (lm_0)kO3;
        double d8 = d3;
        lm_0 lm_05 = lm_02;
        double d9 = d2;
        lm_0 lm_06 = lm_05.k(d9).a(lm_04.k(d8)).a(((lm_0)kO2).k(d7)).a(lm_03.k(d6));
        lm_05.k(d9).a(lm_04.k(d8)).a(((lm_0)kO2).k(d7)).a(lm_03.k(d6)).b = ch_0.a(d9, lm_05.b, d8, lm_04.b, d7, ((lm_0)kO2).b, d6, lm_03.b);
        return lm_06;
    }

    @Override
    public final /* synthetic */ kO a(kO kO2, kO kO3, kO kO4, kO kO5, kO kO6, kO kO7, kO kO8, kO kO9) {
        kO9 = (lm_0)kO9;
        kO8 = (lm_0)kO8;
        kO7 = (lm_0)kO7;
        kO6 = (lm_0)kO6;
        kO5 = (lm_0)kO5;
        kO4 = (lm_0)kO4;
        kO3 = (lm_0)kO3;
        kO2 = (lm_0)kO2;
        lm_0 lm_02 = ((lm_0)kO2).d((lm_0)kO3).a(((lm_0)kO4).d((lm_0)kO5)).a(((lm_0)kO6).d((lm_0)kO7)).a(((lm_0)kO8).d((lm_0)kO9));
        ((lm_0)kO2).d((lm_0)kO3).a(((lm_0)kO4).d((lm_0)kO5)).a(((lm_0)kO6).d((lm_0)kO7)).a(((lm_0)kO8).d((lm_0)kO9)).b = ch_0.a(((lm_0)kO2).b, ((lm_0)kO3).b, ((lm_0)kO4).b, ((lm_0)kO5).b, ((lm_0)kO6).b, ((lm_0)kO7).b, ((lm_0)kO8).b, ((lm_0)kO9).b);
        return lm_02;
    }

    @Override
    public final /* synthetic */ kO a(double d2, kO kO2, double d3, kO kO3, double d4, kO kO4) {
        lm_0 lm_02 = (lm_0)kO2;
        kO2 = (lm_0)kO4;
        double d5 = d4;
        lm_0 lm_03 = (lm_0)kO3;
        double d6 = d3;
        lm_0 lm_04 = lm_02;
        double d7 = d2;
        lm_0 lm_05 = lm_04.k(d7).a(lm_03.k(d6)).a(((lm_0)kO2).k(d5));
        lm_04.k(d7).a(lm_03.k(d6)).a(((lm_0)kO2).k(d5)).b = ch_0.a(d7, lm_04.b, d6, lm_03.b, d5, ((lm_0)kO2).b);
        return lm_05;
    }

    @Override
    public final /* synthetic */ kO a(kO kO2, kO kO3, kO kO4, kO kO5, kO kO6, kO kO7) {
        kO7 = (lm_0)kO7;
        kO6 = (lm_0)kO6;
        kO5 = (lm_0)kO5;
        kO4 = (lm_0)kO4;
        kO3 = (lm_0)kO3;
        kO2 = (lm_0)kO2;
        lm_0 lm_02 = ((lm_0)kO2).d((lm_0)kO3).a(((lm_0)kO4).d((lm_0)kO5)).a(((lm_0)kO6).d((lm_0)kO7));
        ((lm_0)kO2).d((lm_0)kO3).a(((lm_0)kO4).d((lm_0)kO5)).a(((lm_0)kO6).d((lm_0)kO7)).b = ch_0.a(((lm_0)kO2).b, ((lm_0)kO3).b, ((lm_0)kO4).b, ((lm_0)kO5).b, ((lm_0)kO6).b, ((lm_0)kO7).b);
        return lm_02;
    }

    @Override
    public final /* synthetic */ kO a(double d2, kO kO2, double d3, kO kO3) {
        lm_0 lm_02 = (lm_0)kO3;
        double d4 = d3;
        lm_0 lm_03 = (lm_0)kO2;
        double d5 = d2;
        kO2 = lm_03.k(d5).a(lm_02.k(d4));
        lm_03.k(d5).a(lm_02.k(d4)).b = ch_0.a(d5, lm_03.b, d4, lm_02.b);
        return kO2;
    }

    @Override
    public final /* synthetic */ kO a(kO kO2, kO kO3, Object object, kO kO4) {
        kO4 = (lm_0)kO4;
        object = (lm_0)object;
        kO3 = (lm_0)kO3;
        kO2 = (lm_0)kO2;
        lm_0 lm_02 = ((lm_0)kO2).d((lm_0)kO3).a(((lm_0)object).d((lm_0)kO4));
        ((lm_0)kO2).d((lm_0)kO3).a(((lm_0)object).d((lm_0)kO4)).b = ch_0.a(((lm_0)kO2).b, ((lm_0)kO3).b, ((lm_0)object).b, ((lm_0)kO4).b);
        return lm_02;
    }

    @Override
    public final /* synthetic */ kO a(double[] dArray, Object[] objectArray) {
        objectArray = (lm_0[])objectArray;
        lm_0 lm_02 = ((lm_0)objectArray[0]).c().a();
        for (int i2 = 0; i2 < dArray.length; ++i2) {
            lm_02 = lm_02.a(((lm_0)objectArray[i2]).k(dArray[i2]));
        }
        double[] dArray2 = new double[objectArray.length];
        for (int i3 = 0; i3 < objectArray.length; ++i3) {
            Object object = objectArray[i3];
            dArray2[i3] = ((lm_0)object).b;
        }
        lm_02.b = ch_0.h(dArray, dArray2);
        return lm_02;
    }

    @Override
    public final /* synthetic */ kO a(Object[] objectArray, Object[] objectArray2) {
        Object object;
        objectArray2 = (lm_0[])objectArray2;
        objectArray = (lm_0[])objectArray;
        lm_0 lm_02 = objectArray[0].c().a();
        for (int i2 = 0; i2 < objectArray.length; ++i2) {
            lm_02 = lm_02.a(((lm_0)objectArray[i2]).d((lm_0)objectArray2[i2]));
        }
        double[] dArray = new double[objectArray.length];
        for (int i3 = 0; i3 < objectArray.length; ++i3) {
            object = objectArray[i3];
            dArray[i3] = ((lm_0)object).b;
        }
        double[] dArray2 = new double[objectArray2.length];
        for (int i4 = 0; i4 < objectArray2.length; ++i4) {
            object = objectArray2[i4];
            dArray2[i4] = ((lm_0)object).b;
        }
        lm_02.b = ch_0.h(dArray, dArray2);
        return lm_02;
    }

    @Override
    public final /* synthetic */ kO B() {
        lm_0 lm_02 = this;
        return new lm_0(BY.g(lm_02.b), 1.0 / (1.0 - lm_02.b * lm_02.b), lm_02.c);
    }

    @Override
    public final /* synthetic */ kO A() {
        lm_0 lm_02 = this;
        return new lm_0(BY.f(lm_02.b), 1.0 / BY.a(lm_02.b * lm_02.b + 1.0), lm_02.c);
    }

    @Override
    public final /* synthetic */ kO z() {
        lm_0 lm_02 = this;
        return new lm_0(BY.e(lm_02.b), 1.0 / BY.a(lm_02.b * lm_02.b - 1.0), lm_02.c);
    }

    @Override
    public final /* synthetic */ kO y() {
        double d2;
        lm_0 lm_02 = this;
        double d3 = d2 = BY.d(lm_02.b);
        return new lm_0(d2, 1.0 - d3 * d3, lm_02.c);
    }

    @Override
    public final /* synthetic */ kO x() {
        lm_0 lm_02 = this;
        return new lm_0(BY.c(lm_02.b), BY.b(lm_02.b), lm_02.c);
    }

    @Override
    public final /* synthetic */ kO w() {
        lm_0 lm_02 = this;
        return new lm_0(BY.b(lm_02.b), BY.c(lm_02.b), lm_02.c);
    }

    @Override
    public final /* synthetic */ kO h(Object object) {
        return this.k((lm_0)object);
    }

    @Override
    public final /* synthetic */ kO v() {
        return this.X();
    }

    @Override
    public final /* synthetic */ kO u() {
        lm_0 lm_02 = this;
        return new lm_0(BY.r(lm_02.b), 1.0 / BY.a(1.0 - lm_02.b * lm_02.b), lm_02.c);
    }

    @Override
    public final /* synthetic */ kO t() {
        lm_0 lm_02 = this;
        return new lm_0(BY.s(lm_02.b), -1.0 / BY.a(1.0 - lm_02.b * lm_02.b), lm_02.c);
    }

    @Override
    public final /* synthetic */ kO s() {
        double d2;
        lm_0 lm_02 = this;
        double d3 = d2 = BY.p(lm_02.b);
        return new lm_0(d2, 1.0 + d3 * d3, lm_02.c);
    }

    @Override
    public final /* synthetic */ kO r() {
        lm_0 lm_02 = this;
        return new lm_0(BY.n(lm_02.b), BY.o(lm_02.b), lm_02.c);
    }

    @Override
    public final /* synthetic */ kO q() {
        lm_0 lm_02 = this;
        return new lm_0(BY.o(lm_02.b), -BY.n(lm_02.b), lm_02.c);
    }

    @Override
    public final /* synthetic */ kO p() {
        lm_0 lm_02 = this;
        return new lm_0(BY.l(lm_02.b), 1.0 / (1.0 + lm_02.b), lm_02.c);
    }

    @Override
    public final /* synthetic */ kO o() {
        return this.P();
    }

    @Override
    public final /* synthetic */ kO n() {
        lm_0 lm_02 = this;
        return new lm_0(BY.j(lm_02.b), BY.i(lm_02.b), lm_02.c);
    }

    @Override
    public final /* synthetic */ kO m() {
        return this.N();
    }

    @Override
    public final /* synthetic */ kO a(kO kO2) {
        lm_0 lm_02 = (lm_0)kO2;
        kO2 = this;
        return ((lm_0)kO2).P().d(lm_02).N();
    }

    @Override
    public final /* synthetic */ kO d(int n2) {
        int n3 = n2;
        lm_0 lm_02 = this;
        if (n3 == 0) {
            return lm_02.c().b();
        }
        double d2 = BY.a(lm_02.b, n3 - 1);
        return new lm_0(lm_02.b * d2, (double)n3 * d2, lm_02.c);
    }

    @Override
    public final /* synthetic */ kO g(double d2) {
        double d3 = d2;
        lm_0 lm_02 = this;
        return new lm_0(BY.a(lm_02.b, d3), d3 * BY.a(lm_02.b, d3 - 1.0), lm_02.c);
    }

    @Override
    public final /* synthetic */ kO c(int n2) {
        int n3 = n2;
        lm_0 lm_02 = this;
        if (n3 == 2) {
            return lm_02.L();
        }
        if (n3 == 3) {
            return lm_02.M();
        }
        double d2 = BY.a(lm_02.b, 1.0 / (double)n3);
        return new lm_0(d2, 1.0 / ((double)n3 * BY.a(d2, n3 - 1)), lm_02.c);
    }

    @Override
    public final /* synthetic */ kO l() {
        return this.M();
    }

    @Override
    public final /* synthetic */ kO k() {
        return this.L();
    }

    @Override
    public final /* synthetic */ kN b() {
        lm_0 lm_02 = this;
        return new lm_0(1.0 / lm_02.b, -1.0 / (lm_02.b * lm_02.b), lm_02.c);
    }

    @Override
    public final /* synthetic */ kO g(Object object) {
        return this.i((lm_0)object);
    }

    @Override
    public final /* synthetic */ kO b(int n2) {
        return this.g(n2);
    }

    @Override
    public final /* synthetic */ kO f(double d2) {
        double d3 = d2;
        lm_0 lm_02 = this;
        long l2 = Double.doubleToLongBits(lm_02.b);
        long l3 = Double.doubleToLongBits(d3);
        if (l2 >= 0L && l3 >= 0L || l2 < 0L && l3 < 0L) {
            return lm_02;
        }
        return lm_02.E();
    }

    @Override
    public final /* synthetic */ kO f(Object object) {
        lm_0 lm_02 = (lm_0)object;
        object = this;
        long l2 = Double.doubleToLongBits(((lm_0)object).b);
        long l3 = Double.doubleToLongBits(lm_02.b);
        if (l2 >= 0L && l3 >= 0L || l2 < 0L && l3 < 0L) {
            return object;
        }
        return ((lm_0)object).E();
    }

    @Override
    public final /* synthetic */ kO j() {
        lm_0 lm_02 = this;
        return lm_0.h(BY.h(lm_02.b));
    }

    @Override
    public final /* synthetic */ kO h() {
        lm_0 lm_02 = this;
        return lm_0.h(BY.A(lm_02.b));
    }

    @Override
    public final /* synthetic */ kO g() {
        lm_0 lm_02 = this;
        return lm_0.h(BY.y(lm_02.b));
    }

    @Override
    public final /* synthetic */ kO f() {
        lm_0 lm_02 = this;
        return lm_0.h(BY.z(lm_02.b));
    }

    @Override
    public final /* synthetic */ kO e() {
        return this.F();
    }

    @Override
    public final /* synthetic */ kO e(Object object) {
        lm_0 lm_02 = (lm_0)object;
        object = this;
        double d2 = BY.g(((lm_0)object).b, lm_02.b);
        double d3 = BY.A((((lm_0)object).b - d2) / lm_02.b);
        return ((lm_0)object).c(lm_02.k(d3));
    }

    @Override
    public final /* synthetic */ kO e(double d2) {
        double d3 = d2;
        lm_0 lm_02 = this;
        return new lm_0(BY.g(lm_02.b, d3), lm_02.c);
    }

    @Override
    public final /* synthetic */ kO d(double d2) {
        double d3 = d2;
        lm_0 lm_02 = this;
        return new lm_0(lm_02.b / d3, 1.0 / d3, lm_02.c);
    }

    @Override
    public final /* synthetic */ kO c(double d2) {
        return this.k(d2);
    }

    @Override
    public final /* synthetic */ kO b(double d2) {
        double d3 = d2;
        lm_0 lm_02 = this;
        return new lm_0(lm_02.b - d3, lm_02.c);
    }

    @Override
    public final /* synthetic */ kO a(double d2) {
        return this.i(d2);
    }

    @Override
    public final /* synthetic */ kN d(Object object) {
        return this.f((lm_0)object);
    }

    @Override
    public final /* synthetic */ kN c(Object object) {
        return this.d((lm_0)object);
    }

    @Override
    public final /* synthetic */ kN a(int n2) {
        return this.f(n2);
    }

    @Override
    public final /* synthetic */ kN a() {
        return this.E();
    }

    @Override
    public final /* synthetic */ kN b(Object object) {
        return this.c((lm_0)object);
    }
}

