/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import org.valkyrienskies.core.impl.shadow.BM;
import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.ci_0;
import org.valkyrienskies.core.impl.shadow.kM;
import org.valkyrienskies.core.impl.shadow.kN;
import org.valkyrienskies.core.impl.shadow.oU;
import org.valkyrienskies.core.impl.shadow.oV;
import org.valkyrienskies.core.impl.shadow.pl_0;
import org.valkyrienskies.core.impl.shadow.pr_0;
import org.valkyrienskies.core.impl.shadow.px_0;
import org.valkyrienskies.core.impl.shadow.qe_0;
import org.valkyrienskies.core.impl.shadow.qh_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.qd
 */
public class qd_0
extends Number
implements Serializable,
Comparable<qd_0>,
kN<qd_0> {
    public static final qd_0 a = new qd_0(2);
    public static final qd_0 b = new qd_0(1);
    public static final qd_0 c = new qd_0(0);
    public static final qd_0 d = new qd_0(-1);
    private static qd_0 h;
    private static qd_0 i;
    public static final qd_0 e;
    private static qd_0 j;
    private static qd_0 k;
    private static qd_0 l;
    private static qd_0 m;
    private static qd_0 n;
    private static qd_0 o;
    private static qd_0 p;
    private static final long q = -5630213147331578515L;
    private static final BigInteger r;
    final BigInteger f;
    final BigInteger g;

    public qd_0(BigInteger bigInteger) {
        this(bigInteger, BigInteger.ONE);
    }

    public qd_0(BigInteger bigInteger, BigInteger bigInteger2) {
        ci_0.a(bigInteger, px_0.NUMERATOR, new Object[0]);
        ci_0.a(bigInteger2, px_0.DENOMINATOR, new Object[0]);
        if (bigInteger2.signum() == 0) {
            throw new pr_0(px_0.ZERO_DENOMINATOR, new Object[0]);
        }
        if (bigInteger.signum() == 0) {
            this.f = BigInteger.ZERO;
            this.g = BigInteger.ONE;
            return;
        }
        BigInteger bigInteger3 = bigInteger.gcd(bigInteger2);
        if (BigInteger.ONE.compareTo(bigInteger3) < 0) {
            bigInteger = bigInteger.divide(bigInteger3);
            bigInteger2 = bigInteger2.divide(bigInteger3);
        }
        if (bigInteger2.signum() == -1) {
            bigInteger = bigInteger.negate();
            bigInteger2 = bigInteger2.negate();
        }
        this.f = bigInteger;
        this.g = bigInteger2;
    }

    public qd_0(double d2) {
        if (Double.isNaN(d2)) {
            throw new oV(px_0.NAN_VALUE_CONVERSION, new Object[0]);
        }
        if (Double.isInfinite(d2)) {
            throw new oV(px_0.INFINITE_VALUE_CONVERSION, new Object[0]);
        }
        long l2 = Double.doubleToLongBits(d2);
        long l3 = l2 & Long.MIN_VALUE;
        long l4 = l2 & 0x7FF0000000000000L;
        long l5 = l2 & 0xFFFFFFFFFFFFFL;
        if (l4 != 0L) {
            l5 |= 0x10000000000000L;
        }
        if (l3 != 0L) {
            l5 = -l5;
        }
        int n2 = (int)(l4 >> 52) - 1075;
        while ((l5 & 0x1FFFFFFFFFFFFEL) != 0L && (l5 & 1L) == 0L) {
            l5 >>= 1;
            ++n2;
        }
        if (n2 < 0) {
            this.f = BigInteger.valueOf(l5);
            this.g = BigInteger.ZERO.flipBit(-n2);
            return;
        }
        this.f = BigInteger.valueOf(l5).multiply(BigInteger.ZERO.flipBit(n2));
        this.g = BigInteger.ONE;
    }

    public qd_0(double d2, double d3, int n2) {
        this(d2, d3, Integer.MAX_VALUE, 10000);
    }

    private qd_0(double d2, double d3, int n2, int n3) {
        long l2;
        long l3;
        double d4 = d2;
        long l4 = (long)BY.y(d4);
        if (BY.a(l4) > Integer.MAX_VALUE) {
            throw new qh_0(d2, l4, 1L);
        }
        if (BY.w((double)l4 - d2) < d3) {
            this.f = BigInteger.valueOf(l4);
            this.g = BigInteger.ONE;
            return;
        }
        long l5 = 1L;
        long l6 = 0L;
        long l7 = l4;
        long l8 = 1L;
        int n4 = 0;
        boolean bl = false;
        do {
            ++n4;
            double d5 = 1.0 / (d4 - (double)l4);
            long l9 = (long)BY.y(d5);
            l3 = l9 * l7 + l5;
            l2 = l9 * l8 + l6;
            if (l3 > Integer.MAX_VALUE || l2 > Integer.MAX_VALUE) {
                if (d3 == 0.0 && BY.a(l8) < (long)n2) break;
                throw new qh_0(d2, l3, l2);
            }
            double d6 = (double)l3 / (double)l2;
            if (n4 < n3 && BY.w(d6 - d2) > d3 && l2 < (long)n2) {
                l5 = l7;
                l7 = l3;
                l6 = l8;
                l8 = l2;
                l4 = l9;
                d4 = d5;
                continue;
            }
            bl = true;
        } while (!bl);
        if (n4 >= n3) {
            throw new qh_0(d2, n3);
        }
        if (l2 < (long)n2) {
            this.f = BigInteger.valueOf(l3);
            this.g = BigInteger.valueOf(l2);
            return;
        }
        this.f = BigInteger.valueOf(l7);
        this.g = BigInteger.valueOf(l8);
    }

    private qd_0(double d2, int n2) {
        this(d2, 0.0, n2, 100);
    }

    public qd_0(int n2) {
        this(BigInteger.valueOf(n2), BigInteger.ONE);
    }

    public qd_0(int n2, int n3) {
        this(BigInteger.valueOf(n2), BigInteger.valueOf(n3));
    }

    private qd_0(long l2) {
        this(BigInteger.valueOf(l2), BigInteger.ONE);
    }

    private qd_0(long l2, long l3) {
        this(BigInteger.valueOf(l2), BigInteger.valueOf(l3));
    }

    private static qd_0 b(int n2, int n3) {
        if (n2 == 0) {
            return c;
        }
        return new qd_0(n2, n3);
    }

    private qd_0 g() {
        if (this.f.signum() == 1) {
            return this;
        }
        return this.f();
    }

    @Override
    private qd_0 a(BigInteger bigInteger) {
        ci_0.a(bigInteger);
        if (this.f.signum() == 0) {
            return new qd_0(bigInteger);
        }
        if (bigInteger.signum() == 0) {
            return this;
        }
        return new qd_0(this.f.add(this.g.multiply(bigInteger)), this.g);
    }

    private qd_0 f(int n2) {
        return this.a(BigInteger.valueOf(n2));
    }

    @Override
    private qd_0 a(long l2) {
        return this.a(BigInteger.valueOf(l2));
    }

    @Override
    public final qd_0 a(qd_0 number) {
        BigInteger bigInteger;
        if (number == null) {
            throw new pl_0(px_0.FRACTION, new Object[0]);
        }
        if (number.f.signum() == 0) {
            return this;
        }
        if (this.f.signum() == 0) {
            return number;
        }
        if (this.g.equals(number.g)) {
            bigInteger = this.f.add(number.f);
            number = this.g;
        } else {
            bigInteger = this.f.multiply(number.g).add(number.f.multiply(this.g));
            number = this.g.multiply(number.g);
        }
        if (bigInteger.signum() == 0) {
            return c;
        }
        return new qd_0(bigInteger, (BigInteger)number);
    }

    private BigDecimal h() {
        return new BigDecimal(this.f).divide(new BigDecimal(this.g));
    }

    private BigDecimal g(int n2) {
        return new BigDecimal(this.f).divide(new BigDecimal(this.g), n2);
    }

    public final BigDecimal a(int n2, int n3) {
        return new BigDecimal(this.f).divide(new BigDecimal(this.g), 20, 4);
    }

    @Override
    public final int b(qd_0 number) {
        int n2;
        int n3 = this.f.signum();
        if (n3 != (n2 = number.f.signum())) {
            if (n3 > n2) {
                return 1;
            }
            return -1;
        }
        if (n3 == 0) {
            return 0;
        }
        BigInteger bigInteger = this.f.multiply(number.g);
        number = this.g.multiply(number.f);
        return bigInteger.compareTo((BigInteger)number);
    }

    @Override
    private qd_0 b(BigInteger bigInteger) {
        if (bigInteger == null) {
            throw new pl_0(px_0.FRACTION, new Object[0]);
        }
        if (bigInteger.signum() == 0) {
            throw new oU(px_0.ZERO_DENOMINATOR, new Object[0]);
        }
        if (this.f.signum() == 0) {
            return c;
        }
        return new qd_0(this.f, this.g.multiply(bigInteger));
    }

    @Override
    public final qd_0 b(int n2) {
        return this.b(BigInteger.valueOf(n2));
    }

    @Override
    private qd_0 b(long l2) {
        return this.b(BigInteger.valueOf(l2));
    }

    @Override
    public final qd_0 c(qd_0 qd_02) {
        if (qd_02 == null) {
            throw new pl_0(px_0.FRACTION, new Object[0]);
        }
        if (qd_02.f.signum() == 0) {
            throw new oU(px_0.ZERO_DENOMINATOR, new Object[0]);
        }
        if (this.f.signum() == 0) {
            return c;
        }
        return this.d(qd_02.n());
    }

    @Override
    public double doubleValue() {
        double d2 = this.f.doubleValue() / this.g.doubleValue();
        if (Double.isNaN(d2)) {
            int n2 = BY.b(this.f.bitLength(), this.g.bitLength()) - BY.C(Double.MAX_VALUE);
            d2 = this.f.shiftRight(n2).doubleValue() / this.g.shiftRight(n2).doubleValue();
        }
        return d2;
    }

    public boolean equals(Object other) {
        boolean bl;
        block4: {
            boolean bl2;
            block3: {
                qd_0 qd_02;
                block2: {
                    bl = false;
                    if (this != other) break block2;
                    bl2 = true;
                    break block3;
                }
                if (!(other instanceof qd_0)) break block4;
                qd_02 = ((qd_0)qd_02).o();
                qd_0 qd_03 = this.o();
                bl2 = qd_03.f.equals(qd_02.f) && qd_03.g.equals(qd_02.g);
            }
            bl = bl2;
        }
        return bl;
    }

    @Override
    public float floatValue() {
        float f2 = this.f.floatValue() / this.g.floatValue();
        if (Double.isNaN(f2)) {
            int n2 = BY.b(this.f.bitLength(), this.g.bitLength()) - BY.b(Float.MAX_VALUE);
            f2 = this.f.shiftRight(n2).floatValue() / this.g.shiftRight(n2).floatValue();
        }
        return f2;
    }

    public final BigInteger d() {
        return this.g;
    }

    private int i() {
        return this.g.intValue();
    }

    private long j() {
        return this.g.longValue();
    }

    public final BigInteger e() {
        return this.f;
    }

    private int k() {
        return this.f.intValue();
    }

    private long l() {
        return this.f.longValue();
    }

    public int hashCode() {
        return 37 * (629 + this.f.hashCode()) + this.g.hashCode();
    }

    @Override
    public int intValue() {
        return this.f.divide(this.g).intValue();
    }

    @Override
    public long longValue() {
        return this.f.divide(this.g).longValue();
    }

    @Override
    private qd_0 c(BigInteger bigInteger) {
        if (bigInteger == null) {
            throw new pl_0();
        }
        if (this.f.signum() == 0 || bigInteger.signum() == 0) {
            return c;
        }
        return new qd_0(bigInteger.multiply(this.f), this.g);
    }

    @Override
    public final qd_0 c(int n2) {
        if (n2 == 0 || this.f.signum() == 0) {
            return c;
        }
        return this.c(BigInteger.valueOf(n2));
    }

    @Override
    private qd_0 c(long l2) {
        if (l2 == 0L || this.f.signum() == 0) {
            return c;
        }
        return this.c(BigInteger.valueOf(l2));
    }

    @Override
    public final qd_0 d(qd_0 qd_02) {
        if (qd_02 == null) {
            throw new pl_0(px_0.FRACTION, new Object[0]);
        }
        if (this.f.signum() == 0 || qd_02.f.signum() == 0) {
            return c;
        }
        return new qd_0(this.f.multiply(qd_02.f), this.g.multiply(qd_02.g));
    }

    public final qd_0 f() {
        return new qd_0(this.f.negate(), this.g);
    }

    private double m() {
        return this.c(r).doubleValue();
    }

    @Override
    public final qd_0 d(int n2) {
        if (n2 == 0) {
            return b;
        }
        if (this.f.signum() == 0) {
            return this;
        }
        if (n2 < 0) {
            return new qd_0(this.g.pow(-n2), this.f.pow(-n2));
        }
        return new qd_0(this.f.pow(n2), this.g.pow(n2));
    }

    @Override
    private qd_0 d(long l2) {
        if (l2 == 0L) {
            return b;
        }
        if (this.f.signum() == 0) {
            return this;
        }
        if (l2 < 0L) {
            return new qd_0(BM.a(this.g, -l2), BM.a(this.f, -l2));
        }
        return new qd_0(BM.a(this.f, l2), BM.a(this.g, l2));
    }

    @Override
    private qd_0 d(BigInteger bigInteger) {
        if (bigInteger.signum() == 0) {
            return b;
        }
        if (this.f.signum() == 0) {
            return this;
        }
        if (bigInteger.signum() == -1) {
            bigInteger = bigInteger.negate();
            return new qd_0(BM.a(this.g, bigInteger), BM.a(this.f, bigInteger));
        }
        return new qd_0(BM.a(this.f, bigInteger), BM.a(this.g, bigInteger));
    }

    @Override
    private double a(double d2) {
        return BY.a(this.f.doubleValue(), d2) / BY.a(this.g.doubleValue(), d2);
    }

    private qd_0 n() {
        return new qd_0(this.g, this.f);
    }

    private qd_0 o() {
        BigInteger bigInteger = this.f.gcd(this.g);
        if (BigInteger.ONE.compareTo(bigInteger) < 0) {
            return new qd_0(this.f.divide(bigInteger), this.g.divide(bigInteger));
        }
        return this;
    }

    private qd_0 e(BigInteger bigInteger) {
        if (bigInteger == null) {
            throw new pl_0();
        }
        if (bigInteger.signum() == 0) {
            return this;
        }
        if (this.f.signum() == 0) {
            return new qd_0(bigInteger.negate());
        }
        return new qd_0(this.f.subtract(this.g.multiply(bigInteger)), this.g);
    }

    public final qd_0 e(int n2) {
        return this.e(BigInteger.valueOf(1L));
    }

    private qd_0 e(long l2) {
        return this.e(BigInteger.valueOf(l2));
    }

    public final qd_0 e(qd_0 number) {
        BigInteger bigInteger;
        if (number == null) {
            throw new pl_0(px_0.FRACTION, new Object[0]);
        }
        if (number.f.signum() == 0) {
            return this;
        }
        if (this.f.signum() == 0) {
            return number.f();
        }
        if (this.g.equals(number.g)) {
            bigInteger = this.f.subtract(number.f);
            number = this.g;
        } else {
            bigInteger = this.f.multiply(number.g).subtract(number.f.multiply(this.g));
            number = this.g.multiply(number.g);
        }
        return new qd_0(bigInteger, (BigInteger)number);
    }

    public String toString() {
        String string = BigInteger.ONE.equals(this.g) ? this.f.toString() : (BigInteger.ZERO.equals(this.f) ? "0" : this.f + " / " + this.g);
        return string;
    }

    private static qe_0 p() {
        return qe_0.a.a();
    }

    @Override
    public final /* synthetic */ kM c() {
        return qe_0.a.a();
    }

    @Override
    public final /* synthetic */ kN b() {
        return this.n();
    }

    @Override
    public final /* synthetic */ kN d(Object object) {
        return this.c((qd_0)object);
    }

    @Override
    public final /* synthetic */ kN c(Object object) {
        return this.d((qd_0)object);
    }

    @Override
    public final /* synthetic */ kN a(int n2) {
        return this.c(n2);
    }

    @Override
    public final /* synthetic */ kN a() {
        return this.f();
    }

    @Override
    public final /* synthetic */ kN b(Object object) {
        return this.e((qd_0)object);
    }

    @Override
    public /* synthetic */ int compareTo(Object object) {
        return this.b((qd_0)object);
    }

    static {
        new qd_0(4, 5);
        new qd_0(1, 5);
        e = new qd_0(1, 2);
        new qd_0(1, 4);
        new qd_0(1, 3);
        new qd_0(3, 5);
        new qd_0(3, 4);
        new qd_0(2, 5);
        new qd_0(2, 4);
        new qd_0(2, 3);
        r = BigInteger.valueOf(100L);
    }
}

