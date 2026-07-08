/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import org.valkyrienskies.core.impl.shadow.BO;
import org.valkyrienskies.core.impl.shadow.kM;
import org.valkyrienskies.core.impl.shadow.kN;
import org.valkyrienskies.core.impl.shadow.oU;
import org.valkyrienskies.core.impl.shadow.px_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class BN
implements Serializable,
Comparable<BN>,
kN<BN> {
    public static final BN a = new BN(BigDecimal.ZERO);
    public static final BN b = new BN(BigDecimal.ONE);
    private static final long c = 4984534880991310382L;
    private final BigDecimal d;
    private RoundingMode e = RoundingMode.HALF_UP;
    private int f = 64;

    private BN(BigDecimal bigDecimal) {
        this.d = bigDecimal;
    }

    private BN(BigInteger bigInteger) {
        this.d = new BigDecimal(bigInteger);
    }

    private BN(BigInteger bigInteger, int n2) {
        this.d = new BigDecimal(bigInteger, n2);
    }

    private BN(BigInteger bigInteger, int n2, MathContext mathContext) {
        this.d = new BigDecimal(bigInteger, n2, mathContext);
    }

    private BN(BigInteger bigInteger, MathContext mathContext) {
        this.d = new BigDecimal(bigInteger, mathContext);
    }

    private BN(char[] cArray) {
        this.d = new BigDecimal(cArray);
    }

    private BN(char[] cArray, int n2, int n3) {
        this.d = new BigDecimal(cArray, n2, n3);
    }

    private BN(char[] cArray, int n2, int n3, MathContext mathContext) {
        this.d = new BigDecimal(cArray, n2, n3, mathContext);
    }

    private BN(char[] cArray, MathContext mathContext) {
        this.d = new BigDecimal(cArray, mathContext);
    }

    private BN(double d2) {
        this.d = new BigDecimal(d2);
    }

    private BN(double d2, MathContext mathContext) {
        this.d = new BigDecimal(d2, mathContext);
    }

    private BN(int n2) {
        this.d = new BigDecimal(n2);
    }

    private BN(int n2, MathContext mathContext) {
        this.d = new BigDecimal(n2, mathContext);
    }

    private BN(long l2) {
        this.d = new BigDecimal(l2);
    }

    private BN(long l2, MathContext mathContext) {
        this.d = new BigDecimal(l2, mathContext);
    }

    private BN(String string) {
        this.d = new BigDecimal(string);
    }

    private BN(String string, MathContext mathContext) {
        this.d = new BigDecimal(string, mathContext);
    }

    private RoundingMode d() {
        return this.e;
    }

    @Override
    private void a(RoundingMode roundingMode) {
        this.e = roundingMode;
    }

    private int e() {
        return this.f;
    }

    @Override
    private void b(int n2) {
        this.f = n2;
    }

    @Override
    private BN a(BN bN) {
        return new BN(this.d.add(bN.d));
    }

    @Override
    private BN b(BN bN) {
        return new BN(this.d.subtract(bN.d));
    }

    private BN f() {
        return new BN(this.d.negate());
    }

    @Override
    private BN c(BN bN) {
        try {
            return new BN(this.d.divide(bN.d, this.f, this.e));
        }
        catch (ArithmeticException arithmeticException) {
            throw new oU(px_0.ZERO_NOT_ALLOWED, new Object[0]);
        }
    }

    private BN g() {
        try {
            return new BN(BigDecimal.ONE.divide(this.d, this.f, this.e));
        }
        catch (ArithmeticException arithmeticException) {
            throw new oU(px_0.ZERO_NOT_ALLOWED, new Object[0]);
        }
    }

    @Override
    private BN d(BN bN) {
        return new BN(this.d.multiply(bN.d));
    }

    @Override
    private BN c(int n2) {
        return new BN(this.d.multiply(new BigDecimal(n2)));
    }

    private int e(BN bN) {
        return this.d.compareTo(bN.d);
    }

    private double h() {
        return this.d.doubleValue();
    }

    private BigDecimal i() {
        return this.d;
    }

    /*
     * WARNING - void declaration
     */
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof BN) {
            void var1_1;
            return this.d.equals(((BN)var1_1).d);
        }
        return false;
    }

    public int hashCode() {
        return this.d.hashCode();
    }

    @Override
    public final kM<BN> c() {
        return BO.a.a();
    }

    @Override
    public final /* synthetic */ kN b() {
        return this.g();
    }

    @Override
    public final /* synthetic */ kN d(Object object) {
        return this.c((BN)object);
    }

    @Override
    public final /* synthetic */ kN c(Object object) {
        BN bN = (BN)object;
        object = this;
        return new BN(((BN)object).d.multiply(bN.d));
    }

    @Override
    public final /* synthetic */ kN a(int n2) {
        int n3 = n2;
        BN bN = this;
        return new BN(bN.d.multiply(new BigDecimal(n3)));
    }

    @Override
    public final /* synthetic */ kN a() {
        BN bN = this;
        return new BN(bN.d.negate());
    }

    @Override
    public final /* synthetic */ kN b(Object object) {
        BN bN = (BN)object;
        object = this;
        return new BN(((BN)object).d.subtract(bN.d));
    }

    @Override
    public final /* synthetic */ kN a(Object object) {
        BN bN = (BN)object;
        object = this;
        return new BN(((BN)object).d.add(bN.d));
    }
}

