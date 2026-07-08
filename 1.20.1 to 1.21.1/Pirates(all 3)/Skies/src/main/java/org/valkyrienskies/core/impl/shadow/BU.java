/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.BV;
import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.ch_0;
import org.valkyrienskies.core.impl.shadow.kM;
import org.valkyrienskies.core.impl.shadow.kN;
import org.valkyrienskies.core.impl.shadow.kO;
import org.valkyrienskies.core.impl.shadow.oS;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class BU
extends Number
implements Comparable<BU>,
kO<BU> {
    public static final BU a = new BU(0.0);
    public static final BU b = new BU(1.0);
    private static BU c;
    private static BU d;
    private static BU e;
    private static final long f = 20120227L;
    private final double g;

    private BU(double d2) {
        this.g = d2;
    }

    @Override
    public final kM<BU> c() {
        return BV.d();
    }

    @Override
    private BU a(BU bU) {
        return new BU(this.g + bU.g);
    }

    @Override
    private BU b(BU bU) {
        return new BU(this.g - bU.g);
    }

    private BU C() {
        return new BU(-this.g);
    }

    @Override
    private BU c(BU bU) {
        return new BU(this.g * bU.g);
    }

    @Override
    private BU e(int n2) {
        return new BU((double)n2 * this.g);
    }

    @Override
    private BU d(BU bU) {
        return new BU(this.g / bU.g);
    }

    private BU D() {
        return new BU(1.0 / this.g);
    }

    @Override
    public byte byteValue() {
        return (byte)this.g;
    }

    @Override
    public short shortValue() {
        return (short)this.g;
    }

    @Override
    public int intValue() {
        return (int)this.g;
    }

    @Override
    public long longValue() {
        return (long)this.g;
    }

    @Override
    public float floatValue() {
        return (float)this.g;
    }

    @Override
    public double doubleValue() {
        return this.g;
    }

    @Override
    private int e(BU bU) {
        return Double.compare(this.g, bU.g);
    }

    public boolean equals(Object obj) {
        if (obj instanceof BU) {
            BU bU;
            bU = bU;
            return Double.doubleToLongBits(this.g) == Double.doubleToLongBits(bU.g);
        }
        return false;
    }

    public int hashCode() {
        long l2 = Double.doubleToLongBits(this.g);
        return (int)(l2 ^ l2 >>> 32);
    }

    public String toString() {
        return Double.toString(this.g);
    }

    private boolean E() {
        return Double.isInfinite(this.g);
    }

    private boolean F() {
        return Double.isNaN(this.g);
    }

    @Override
    public final double d() {
        return this.g;
    }

    @Override
    private BU h(double d2) {
        return new BU(this.g + d2);
    }

    private BU i(double d2) {
        return new BU(this.g - d2);
    }

    private BU j(double d2) {
        return new BU(this.g * d2);
    }

    private BU k(double d2) {
        return new BU(this.g / d2);
    }

    private BU l(double d2) {
        return new BU(BY.g(this.g, d2));
    }

    @Override
    private BU f(BU bU) {
        return new BU(BY.g(this.g, bU.g));
    }

    private BU G() {
        return new BU(BY.w(this.g));
    }

    private BU H() {
        return new BU(BY.z(this.g));
    }

    private BU I() {
        return new BU(BY.y(this.g));
    }

    private BU J() {
        return new BU(BY.A(this.g));
    }

    @Override
    public final long i() {
        return BY.B(this.g);
    }

    private BU K() {
        return new BU(BY.h(this.g));
    }

    @Override
    private BU g(BU bU) {
        return new BU(BY.h(this.g, bU.g));
    }

    private BU m(double d2) {
        return new BU(BY.h(this.g, d2));
    }

    @Override
    private BU f(int n2) {
        return new BU(BY.b(this.g, n2));
    }

    @Override
    private BU h(BU bU) {
        return new BU(BY.f(this.g, bU.g));
    }

    private BU L() {
        return new BU(BY.a(this.g));
    }

    private BU M() {
        return new BU(BY.t(this.g));
    }

    @Override
    private BU g(int n2) {
        if (this.g < 0.0) {
            return new BU(-BY.a(-this.g, 1.0 / (double)n2));
        }
        return new BU(BY.a(this.g, 1.0 / (double)n2));
    }

    private BU n(double d2) {
        return new BU(BY.a(this.g, d2));
    }

    @Override
    private BU h(int n2) {
        return new BU(BY.a(this.g, n2));
    }

    private BU i(BU bU) {
        return new BU(BY.a(this.g, bU.g));
    }

    private BU N() {
        return new BU(BY.i(this.g));
    }

    private BU O() {
        return new BU(BY.j(this.g));
    }

    private BU P() {
        return new BU(BY.k(this.g));
    }

    private BU Q() {
        return new BU(BY.l(this.g));
    }

    private BU R() {
        return new BU(BY.m(this.g));
    }

    private BU S() {
        return new BU(BY.o(this.g));
    }

    private BU T() {
        return new BU(BY.n(this.g));
    }

    private BU U() {
        return new BU(BY.p(this.g));
    }

    private BU V() {
        return new BU(BY.s(this.g));
    }

    private BU W() {
        return new BU(BY.r(this.g));
    }

    private BU X() {
        return new BU(BY.q(this.g));
    }

    private BU j(BU bU) {
        return new BU(BY.b(this.g, bU.g));
    }

    private BU Y() {
        return new BU(BY.b(this.g));
    }

    private BU Z() {
        return new BU(BY.c(this.g));
    }

    private BU aa() {
        return new BU(BY.d(this.g));
    }

    private BU ab() {
        return new BU(BY.e(this.g));
    }

    private BU ac() {
        return new BU(BY.f(this.g));
    }

    private BU ad() {
        return new BU(BY.g(this.g));
    }

    private static BU a(BU[] bUArray, BU[] bUArray2) {
        if (bUArray.length != bUArray2.length) {
            throw new oS(bUArray.length, bUArray2.length);
        }
        double[] dArray = new double[bUArray.length];
        double[] dArray2 = new double[bUArray2.length];
        for (int i2 = 0; i2 < bUArray.length; ++i2) {
            dArray[i2] = bUArray[i2].g;
            dArray2[i2] = bUArray2[i2].g;
        }
        return new BU(ch_0.h(dArray, dArray2));
    }

    private static BU a(double[] dArray, BU[] bUArray) {
        if (dArray.length != bUArray.length) {
            throw new oS(dArray.length, bUArray.length);
        }
        double[] dArray2 = new double[bUArray.length];
        for (int i2 = 0; i2 < dArray.length; ++i2) {
            dArray2[i2] = bUArray[i2].g;
        }
        return new BU(ch_0.h(dArray, dArray2));
    }

    private static BU a(BU bU, BU bU2, BU bU3, BU bU4) {
        return new BU(ch_0.a(bU.g, bU2.g, bU3.g, bU4.g));
    }

    private static BU a(double d2, BU bU, double d3, BU bU2) {
        return new BU(ch_0.a(d2, bU.g, d3, bU2.g));
    }

    private static BU a(BU bU, BU bU2, BU bU3, BU bU4, BU bU5, BU bU6) {
        return new BU(ch_0.a(bU.g, bU2.g, bU3.g, bU4.g, bU5.g, bU6.g));
    }

    private static BU a(double d2, BU bU, double d3, BU bU2, double d4, BU bU3) {
        return new BU(ch_0.a(d2, bU.g, d3, bU2.g, d4, bU3.g));
    }

    private static BU a(BU bU, BU bU2, BU bU3, BU bU4, BU bU5, BU bU6, BU bU7, BU bU8) {
        return new BU(ch_0.a(bU.g, bU2.g, bU3.g, bU4.g, bU5.g, bU6.g, bU7.g, bU8.g));
    }

    private static BU a(double d2, BU bU, double d3, BU bU2, double d4, BU bU3, double d5, BU bU4) {
        return new BU(ch_0.a(d2, bU.g, d3, bU2.g, d4, bU3.g, d5, bU4.g));
    }

    @Override
    public final /* synthetic */ kO a(double d2, kO kO2, double d3, kO kO3, double d4, kO kO4, double d5, kO kO5) {
        BU bU = (BU)kO2;
        BU bU2 = (BU)kO5;
        double d6 = d5;
        kO2 = (BU)kO4;
        double d7 = d4;
        BU bU3 = (BU)kO3;
        double d8 = d3;
        BU bU4 = bU;
        double d9 = d2;
        return new BU(ch_0.a(d9, bU4.g, d8, bU3.g, d7, ((BU)kO2).g, d6, bU2.g));
    }

    @Override
    public final /* synthetic */ kO a(kO kO2, kO kO3, kO kO4, kO kO5, kO kO6, kO kO7, kO kO8, kO kO9) {
        kO9 = (BU)kO9;
        kO8 = (BU)kO8;
        kO7 = (BU)kO7;
        kO6 = (BU)kO6;
        kO5 = (BU)kO5;
        kO4 = (BU)kO4;
        kO3 = (BU)kO3;
        kO2 = (BU)kO2;
        return new BU(ch_0.a(((BU)kO2).g, ((BU)kO3).g, ((BU)kO4).g, ((BU)kO5).g, ((BU)kO6).g, ((BU)kO7).g, ((BU)kO8).g, ((BU)kO9).g));
    }

    @Override
    public final /* synthetic */ kO a(double d2, kO kO2, double d3, kO kO3, double d4, kO kO4) {
        BU bU = (BU)kO2;
        kO2 = (BU)kO4;
        double d5 = d4;
        BU bU2 = (BU)kO3;
        double d6 = d3;
        BU bU3 = bU;
        double d7 = d2;
        return new BU(ch_0.a(d7, bU3.g, d6, bU2.g, d5, ((BU)kO2).g));
    }

    @Override
    public final /* synthetic */ kO a(kO kO2, kO kO3, kO kO4, kO kO5, kO kO6, kO kO7) {
        kO7 = (BU)kO7;
        kO6 = (BU)kO6;
        kO5 = (BU)kO5;
        kO4 = (BU)kO4;
        kO3 = (BU)kO3;
        kO2 = (BU)kO2;
        return new BU(ch_0.a(((BU)kO2).g, ((BU)kO3).g, ((BU)kO4).g, ((BU)kO5).g, ((BU)kO6).g, ((BU)kO7).g));
    }

    @Override
    public final /* synthetic */ kO a(double d2, kO kO2, double d3, kO kO3) {
        BU bU = (BU)kO3;
        double d4 = d3;
        BU bU2 = (BU)kO2;
        double d5 = d2;
        return new BU(ch_0.a(d5, bU2.g, d4, bU.g));
    }

    @Override
    public final /* synthetic */ kO a(kO kO2, kO kO3, Object object, kO kO4) {
        kO4 = (BU)kO4;
        object = (BU)object;
        kO3 = (BU)kO3;
        kO2 = (BU)kO2;
        return new BU(ch_0.a(((BU)kO2).g, ((BU)kO3).g, ((BU)object).g, ((BU)kO4).g));
    }

    @Override
    public final /* synthetic */ kO a(double[] dArray, Object[] objectArray) {
        if (dArray.length != (objectArray = (BU[])objectArray).length) {
            throw new oS(dArray.length, objectArray.length);
        }
        double[] dArray2 = new double[objectArray.length];
        for (int i2 = 0; i2 < dArray.length; ++i2) {
            dArray2[i2] = ((BU)objectArray[i2]).g;
        }
        return new BU(ch_0.h(dArray, dArray2));
    }

    @Override
    public final /* synthetic */ kO a(Object[] objectArray, Object[] objectArray2) {
        if ((objectArray = (BU[])objectArray).length != (objectArray2 = (BU[])objectArray2).length) {
            throw new oS(objectArray.length, objectArray2.length);
        }
        double[] dArray = new double[objectArray.length];
        double[] dArray2 = new double[objectArray2.length];
        for (int i2 = 0; i2 < objectArray.length; ++i2) {
            dArray[i2] = ((BU)objectArray[i2]).g;
            dArray2[i2] = ((BU)objectArray2[i2]).g;
        }
        return new BU(ch_0.h(dArray, dArray2));
    }

    @Override
    public final /* synthetic */ kO B() {
        BU bU = this;
        return new BU(BY.g(bU.g));
    }

    @Override
    public final /* synthetic */ kO A() {
        BU bU = this;
        return new BU(BY.f(bU.g));
    }

    @Override
    public final /* synthetic */ kO z() {
        BU bU = this;
        return new BU(BY.e(bU.g));
    }

    @Override
    public final /* synthetic */ kO y() {
        BU bU = this;
        return new BU(BY.d(bU.g));
    }

    @Override
    public final /* synthetic */ kO x() {
        BU bU = this;
        return new BU(BY.c(bU.g));
    }

    @Override
    public final /* synthetic */ kO w() {
        BU bU = this;
        return new BU(BY.b(bU.g));
    }

    @Override
    public final /* synthetic */ kO h(Object object) {
        BU bU = (BU)object;
        object = this;
        return new BU(BY.b(((BU)object).g, bU.g));
    }

    @Override
    public final /* synthetic */ kO v() {
        BU bU = this;
        return new BU(BY.q(bU.g));
    }

    @Override
    public final /* synthetic */ kO u() {
        BU bU = this;
        return new BU(BY.r(bU.g));
    }

    @Override
    public final /* synthetic */ kO t() {
        BU bU = this;
        return new BU(BY.s(bU.g));
    }

    @Override
    public final /* synthetic */ kO s() {
        BU bU = this;
        return new BU(BY.p(bU.g));
    }

    @Override
    public final /* synthetic */ kO r() {
        BU bU = this;
        return new BU(BY.n(bU.g));
    }

    @Override
    public final /* synthetic */ kO q() {
        BU bU = this;
        return new BU(BY.o(bU.g));
    }

    @Override
    public final /* synthetic */ kO p() {
        BU bU = this;
        return new BU(BY.l(bU.g));
    }

    @Override
    public final /* synthetic */ kO o() {
        BU bU = this;
        return new BU(BY.k(bU.g));
    }

    @Override
    public final /* synthetic */ kO n() {
        BU bU = this;
        return new BU(BY.j(bU.g));
    }

    @Override
    public final /* synthetic */ kO m() {
        BU bU = this;
        return new BU(BY.i(bU.g));
    }

    @Override
    public final /* synthetic */ kO a(kO kO2) {
        BU bU = (BU)kO2;
        kO2 = this;
        return new BU(BY.a(((BU)kO2).g, bU.g));
    }

    @Override
    public final /* synthetic */ kO d(int n2) {
        int n3 = n2;
        BU bU = this;
        return new BU(BY.a(bU.g, n3));
    }

    @Override
    public final /* synthetic */ kO g(double d2) {
        double d3 = d2;
        BU bU = this;
        return new BU(BY.a(bU.g, d3));
    }

    @Override
    public final /* synthetic */ kO c(int n2) {
        BU bU;
        int n3 = n2;
        BU bU2 = this;
        if (bU.g < 0.0) {
            return new BU(-BY.a(-bU2.g, 1.0 / (double)n3));
        }
        return new BU(BY.a(bU2.g, 1.0 / (double)n3));
    }

    @Override
    public final /* synthetic */ kO l() {
        BU bU = this;
        return new BU(BY.t(bU.g));
    }

    @Override
    public final /* synthetic */ kO k() {
        BU bU = this;
        return new BU(BY.a(bU.g));
    }

    @Override
    public final /* synthetic */ kN b() {
        BU bU = this;
        return new BU(1.0 / bU.g);
    }

    @Override
    public final /* synthetic */ kO g(Object object) {
        BU bU = (BU)object;
        object = this;
        return new BU(BY.f(((BU)object).g, bU.g));
    }

    @Override
    public final /* synthetic */ kO b(int n2) {
        int n3 = n2;
        BU bU = this;
        return new BU(BY.b(bU.g, n3));
    }

    @Override
    public final /* synthetic */ kO f(double d2) {
        double d3 = d2;
        BU bU = this;
        return new BU(BY.h(bU.g, d3));
    }

    @Override
    public final /* synthetic */ kO f(Object object) {
        BU bU = (BU)object;
        object = this;
        return new BU(BY.h(((BU)object).g, bU.g));
    }

    @Override
    public final /* synthetic */ kO j() {
        BU bU = this;
        return new BU(BY.h(bU.g));
    }

    @Override
    public final /* synthetic */ kO h() {
        BU bU = this;
        return new BU(BY.A(bU.g));
    }

    @Override
    public final /* synthetic */ kO g() {
        BU bU = this;
        return new BU(BY.y(bU.g));
    }

    @Override
    public final /* synthetic */ kO f() {
        BU bU = this;
        return new BU(BY.z(bU.g));
    }

    @Override
    public final /* synthetic */ kO e() {
        BU bU = this;
        return new BU(BY.w(bU.g));
    }

    @Override
    public final /* synthetic */ kO e(Object object) {
        BU bU = (BU)object;
        object = this;
        return new BU(BY.g(((BU)object).g, bU.g));
    }

    @Override
    public final /* synthetic */ kO e(double d2) {
        double d3 = d2;
        BU bU = this;
        return new BU(BY.g(bU.g, d3));
    }

    @Override
    public final /* synthetic */ kO d(double d2) {
        double d3 = d2;
        BU bU = this;
        return new BU(bU.g / d3);
    }

    @Override
    public final /* synthetic */ kO c(double d2) {
        double d3 = d2;
        BU bU = this;
        return new BU(bU.g * d3);
    }

    @Override
    public final /* synthetic */ kO b(double d2) {
        double d3 = d2;
        BU bU = this;
        return new BU(bU.g - d3);
    }

    @Override
    public final /* synthetic */ kO a(double d2) {
        double d3 = d2;
        BU bU = this;
        return new BU(bU.g + d3);
    }

    @Override
    public final /* synthetic */ kN d(Object object) {
        BU bU = (BU)object;
        object = this;
        return new BU(((BU)object).g / bU.g);
    }

    @Override
    public final /* synthetic */ kN c(Object object) {
        BU bU = (BU)object;
        object = this;
        return new BU(((BU)object).g * bU.g);
    }

    @Override
    public final /* synthetic */ kN a(int n2) {
        int n3 = n2;
        BU bU = this;
        return new BU((double)n3 * bU.g);
    }

    @Override
    public final /* synthetic */ kN a() {
        BU bU = this;
        return new BU(-bU.g);
    }

    @Override
    public final /* synthetic */ kN b(Object object) {
        BU bU = (BU)object;
        object = this;
        return new BU(((BU)object).g - bU.g);
    }

    @Override
    public final /* synthetic */ kN a(Object object) {
        BU bU = (BU)object;
        object = this;
        return new BU(((BU)object).g + bU.g);
    }

    @Override
    public /* synthetic */ int compareTo(Object object) {
        BU bU = (BU)object;
        object = this;
        return Double.compare(((BU)object).g, bU.g);
    }

    static {
        new BU(Double.NEGATIVE_INFINITY);
        new BU(Double.POSITIVE_INFINITY);
        new BU(Double.NaN);
    }
}

