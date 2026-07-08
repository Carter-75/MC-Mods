/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import java.math.BigInteger;
import org.valkyrienskies.core.impl.shadow.BM;
import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.kM;
import org.valkyrienskies.core.impl.shadow.kN;
import org.valkyrienskies.core.impl.shadow.oU;
import org.valkyrienskies.core.impl.shadow.pl_0;
import org.valkyrienskies.core.impl.shadow.px_0;
import org.valkyrienskies.core.impl.shadow.qh_0;
import org.valkyrienskies.core.impl.shadow.qi_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.qg
 */
public class qg_0
extends Number
implements Serializable,
Comparable<qg_0>,
kN<qg_0> {
    private static qg_0 e;
    public static final qg_0 a;
    public static final qg_0 b;
    private static qg_0 f;
    private static qg_0 g;
    private static qg_0 h;
    private static qg_0 i;
    private static qg_0 j;
    private static qg_0 k;
    private static qg_0 l;
    private static qg_0 m;
    private static qg_0 n;
    private static qg_0 o;
    private static qg_0 p;
    private static final long q = 3698073679419233275L;
    private static final double r = 1.0E-5;
    final int c;
    final int d;

    public qg_0(double d2) {
        this(d2, 1.0E-5, 100);
    }

    private qg_0(double d2, double d3, int n2) {
        this(d2, 1.0E-5, Integer.MAX_VALUE, 100);
    }

    private qg_0(double d2, int n2) {
        this(d2, 0.0, n2, 100);
    }

    private qg_0(double d2, double d3, int n2, int n3) {
        long l2;
        long l3;
        double d4 = d2;
        long l4 = (long)BY.y(d4);
        if (BY.a(l4) > Integer.MAX_VALUE) {
            throw new qh_0(d2, l4, 1L);
        }
        if (BY.w((double)l4 - d2) < d3) {
            this.d = (int)l4;
            this.c = 1;
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
            if (BY.a(l3) > Integer.MAX_VALUE || BY.a(l2) > Integer.MAX_VALUE) {
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
            this.d = (int)l3;
            this.c = (int)l2;
            return;
        }
        this.d = (int)l7;
        this.c = (int)l8;
    }

    private qg_0(int n2) {
        this(n2, 1);
    }

    public qg_0(int n2, int n3) {
        int n4;
        if (n3 == 0) {
            throw new oU(px_0.ZERO_DENOMINATOR_IN_FRACTION, n2, n3);
        }
        if (n3 < 0) {
            if (n2 == Integer.MIN_VALUE || n3 == Integer.MIN_VALUE) {
                throw new oU(px_0.OVERFLOW_IN_FRACTION, n2, n3);
            }
            n2 = -n2;
            n3 = -n3;
        }
        if ((n4 = BM.b(n2, n3)) > 1) {
            n2 /= n4;
            n3 /= n4;
        }
        if (n3 < 0) {
            n2 = -n2;
            n3 = -n3;
        }
        this.d = n2;
        this.c = n3;
    }

    private qg_0 f() {
        qg_0 qg_02 = this.d >= 0 ? this : this.g();
        return qg_02;
    }

    @Override
    private int a(qg_0 qg_02) {
        long l2 = (long)this.d * (long)qg_02.c;
        long l3 = (long)this.c * (long)qg_02.d;
        if (l2 < l3) {
            return -1;
        }
        if (l2 > l3) {
            return 1;
        }
        return 0;
    }

    @Override
    public double doubleValue() {
        return (double)this.d / (double)this.c;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof qg_0) {
            qg_0 qg_02;
            qg_02 = qg_02;
            return this.d == qg_02.d && this.c == qg_02.c;
        }
        return false;
    }

    @Override
    public float floatValue() {
        return (float)this.doubleValue();
    }

    public final int d() {
        return this.c;
    }

    public final int e() {
        return this.d;
    }

    public int hashCode() {
        return 37 * (629 + this.d) + this.c;
    }

    @Override
    public int intValue() {
        return (int)this.doubleValue();
    }

    @Override
    public long longValue() {
        return (long)this.doubleValue();
    }

    private qg_0 g() {
        if (this.d == Integer.MIN_VALUE) {
            throw new oU(px_0.OVERFLOW_IN_FRACTION, this.d, this.c);
        }
        return new qg_0(-this.d, this.c);
    }

    private qg_0 h() {
        return new qg_0(this.c, this.d);
    }

    @Override
    private qg_0 b(qg_0 qg_02) {
        return this.a(qg_02, true);
    }

    @Override
    private qg_0 b(int n2) {
        return new qg_0(this.d + n2 * this.c, this.c);
    }

    @Override
    private qg_0 c(qg_0 qg_02) {
        return this.a(qg_02, false);
    }

    @Override
    private qg_0 c(int n2) {
        return new qg_0(this.d - n2 * this.c, this.c);
    }

    private qg_0 a(qg_0 qg_02, boolean bl) {
        if (qg_02 == null) {
            throw new pl_0(px_0.FRACTION, new Object[0]);
        }
        if (this.d == 0) {
            if (bl) {
                return qg_02;
            }
            return qg_02.g();
        }
        if (qg_02.d == 0) {
            return this;
        }
        int n2 = BM.b(this.c, qg_02.c);
        if (n2 == 1) {
            int n3 = BM.c(this.d, qg_02.c);
            int n4 = BM.c(qg_02.d, this.c);
            return new qg_0(bl ? BM.a(n3, n4) : BM.d(n3, n4), BM.c(this.c, qg_02.c));
        }
        BigInteger bigInteger = BigInteger.valueOf(this.d).multiply(BigInteger.valueOf(qg_02.c / n2));
        BigInteger bigInteger2 = BigInteger.valueOf(qg_02.d).multiply(BigInteger.valueOf(this.c / n2));
        BigInteger bigInteger3 = bl ? bigInteger.add(bigInteger2) : bigInteger.subtract(bigInteger2);
        int n5 = bigInteger3.mod(BigInteger.valueOf(n2)).intValue();
        if ((bigInteger3 = bigInteger3.divide(BigInteger.valueOf(n5 = n5 == 0 ? n2 : BM.b(n5, n2)))).bitLength() > 31) {
            throw new oU(px_0.NUMERATOR_OVERFLOW_AFTER_MULTIPLY, bigInteger3);
        }
        return new qg_0(bigInteger3.intValue(), BM.c(this.c / n2, qg_02.c / n5));
    }

    @Override
    private qg_0 d(qg_0 qg_02) {
        if (qg_02 == null) {
            throw new pl_0(px_0.FRACTION, new Object[0]);
        }
        if (this.d == 0 || qg_02.d == 0) {
            return b;
        }
        int n2 = BM.b(this.d, qg_02.c);
        int n3 = BM.b(qg_02.d, this.c);
        int n4 = BM.c(this.d / n2, qg_02.d / n3);
        n2 = BM.c(this.c / n3, qg_02.c / n2);
        int n5 = n4;
        if (n2 == 0) {
            throw new oU(px_0.ZERO_DENOMINATOR_IN_FRACTION, n5, n2);
        }
        if (n5 == 0) {
            return b;
        }
        if (n2 == Integer.MIN_VALUE && (n5 & 1) == 0) {
            n5 /= 2;
            n2 /= 2;
        }
        if (n2 < 0) {
            if (n5 == Integer.MIN_VALUE || n2 == Integer.MIN_VALUE) {
                throw new oU(px_0.OVERFLOW_IN_FRACTION, n5, n2);
            }
            n5 = -n5;
            n2 = -n2;
        }
        n3 = BM.b(n5, n2);
        return new qg_0(n5 /= n3, n2 /= n3);
    }

    @Override
    private qg_0 d(int n2) {
        return this.d(new qg_0(n2));
    }

    private qg_0 e(qg_0 qg_02) {
        if (qg_02 == null) {
            throw new pl_0(px_0.FRACTION, new Object[0]);
        }
        if (qg_02.d == 0) {
            throw new oU(px_0.ZERO_FRACTION_TO_DIVIDE_BY, qg_02.d, qg_02.c);
        }
        return this.d(qg_02.h());
    }

    private qg_0 e(int n2) {
        return this.e(new qg_0(n2));
    }

    private double i() {
        return 100.0 * this.doubleValue();
    }

    private static qg_0 a(int n2, int n3) {
        if (n3 == 0) {
            throw new oU(px_0.ZERO_DENOMINATOR_IN_FRACTION, n2, n3);
        }
        if (n2 == 0) {
            return b;
        }
        if (n3 == Integer.MIN_VALUE && (n2 & 1) == 0) {
            n2 /= 2;
            n3 /= 2;
        }
        if (n3 < 0) {
            if (n2 == Integer.MIN_VALUE || n3 == Integer.MIN_VALUE) {
                throw new oU(px_0.OVERFLOW_IN_FRACTION, n2, n3);
            }
            n2 = -n2;
            n3 = -n3;
        }
        int n4 = BM.b(n2, n3);
        return new qg_0(n2 /= n4, n3 /= n4);
    }

    public String toString() {
        String string = this.c == 1 ? Integer.toString(this.d) : (this.d == 0 ? "0" : this.d + " / " + this.c);
        return string;
    }

    private static qi_0 j() {
        return qi_0.a.a();
    }

    @Override
    public final /* synthetic */ kM c() {
        return qi_0.a.a();
    }

    @Override
    public final /* synthetic */ kN b() {
        return this.h();
    }

    @Override
    public final /* synthetic */ kN d(Object object) {
        return this.e((qg_0)object);
    }

    @Override
    public final /* synthetic */ kN c(Object object) {
        return this.d((qg_0)object);
    }

    @Override
    public final /* synthetic */ kN a(int n2) {
        int n3 = n2;
        qg_0 qg_02 = this;
        return qg_02.d(new qg_0(n3));
    }

    @Override
    public final /* synthetic */ kN a() {
        return this.g();
    }

    @Override
    public final /* synthetic */ kN b(Object object) {
        qg_0 qg_02 = (qg_0)object;
        object = this;
        return ((qg_0)object).a(qg_02, false);
    }

    static {
        new qg_0(2, 1);
        a = new qg_0(1, 1);
        b = new qg_0(0, 1);
        new qg_0(4, 5);
        new qg_0(1, 5);
        new qg_0(1, 2);
        new qg_0(1, 4);
        new qg_0(1, 3);
        new qg_0(3, 5);
        new qg_0(3, 4);
        new qg_0(2, 5);
        new qg_0(2, 4);
        new qg_0(2, 3);
        new qg_0(-1, 1);
    }
}

