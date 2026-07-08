/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.math.BigDecimal;
import java.math.MathContext;
import org.valkyrienskies.core.impl.shadow.co_0;
import org.valkyrienskies.core.impl.shadow.mu_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.my
 */
public final class my_0
extends mu_0<BigDecimal> {
    private final MathContext a;
    private final BigDecimal b;
    private final BigDecimal c;
    private final BigDecimal d;

    public my_0() {
        this(MathContext.DECIMAL128);
    }

    private my_0(MathContext mathContext) {
        this.a = mathContext;
        this.b = new BigDecimal("2", mathContext);
        this.c = new BigDecimal("-1", mathContext);
        this.d = new BigDecimal("0.5", mathContext);
    }

    @Override
    protected final co_0<BigDecimal[], BigDecimal[]> c(int n2) {
        BigDecimal bigDecimal;
        BigDecimal bigDecimal2;
        if (n2 == 1) {
            return new co_0<BigDecimal[], BigDecimal[]>(new BigDecimal[]{BigDecimal.ZERO}, new BigDecimal[]{this.b});
        }
        BigDecimal[] bigDecimalArray = this.b(n2 - 1);
        bigDecimalArray = (BigDecimal[])bigDecimalArray.a;
        BigDecimal[] bigDecimalArray2 = new BigDecimal[n2];
        BigDecimal[] bigDecimalArray3 = new BigDecimal[n2];
        int n3 = n2 / 2;
        for (int i2 = 0; i2 < n3; ++i2) {
            BigDecimal bigDecimal3;
            BigDecimal bigDecimal4;
            BigDecimal bigDecimal5;
            BigDecimal bigDecimal6;
            BigDecimal bigDecimal7 = i2 == 0 ? this.c : bigDecimalArray[i2 - 1];
            bigDecimal2 = n3 == 1 ? BigDecimal.ONE : bigDecimalArray[i2];
            bigDecimal = BigDecimal.ONE;
            BigDecimal bigDecimal8 = bigDecimal7;
            BigDecimal bigDecimal9 = BigDecimal.ONE;
            BigDecimal bigDecimal10 = bigDecimal2;
            for (int i3 = 1; i3 < n2; ++i3) {
                bigDecimal6 = new BigDecimal(2 * i3 + 1, this.a);
                bigDecimal5 = new BigDecimal(i3, this.a);
                BigDecimal bigDecimal11 = new BigDecimal(i3 + 1, this.a);
                bigDecimal4 = bigDecimal7.multiply(bigDecimal6, this.a);
                bigDecimal4 = bigDecimal8.multiply(bigDecimal4, this.a);
                bigDecimal = bigDecimal.multiply(bigDecimal5, this.a);
                bigDecimal3 = bigDecimal4.subtract(bigDecimal, this.a);
                bigDecimal3 = bigDecimal3.divide(bigDecimal11, this.a);
                bigDecimal4 = bigDecimal2.multiply(bigDecimal6, this.a);
                bigDecimal4 = bigDecimal10.multiply(bigDecimal4, this.a);
                bigDecimal = bigDecimal9.multiply(bigDecimal5, this.a);
                bigDecimal4 = bigDecimal4.subtract(bigDecimal, this.a);
                bigDecimal4 = bigDecimal4.divide(bigDecimal11, this.a);
                bigDecimal = bigDecimal8;
                bigDecimal8 = bigDecimal3;
                bigDecimal9 = bigDecimal10;
                bigDecimal10 = bigDecimal4;
            }
            BigDecimal bigDecimal12 = bigDecimal7.add(bigDecimal2, this.a).multiply(this.d, this.a);
            bigDecimal6 = BigDecimal.ONE;
            bigDecimal5 = bigDecimal12;
            boolean bl = false;
            while (!bl) {
                bigDecimal4 = bigDecimal2.subtract(bigDecimal7, this.a);
                bl = bigDecimal4.compareTo(bigDecimal = bigDecimal12.ulp().multiply(BigDecimal.TEN, this.a)) <= 0;
                bigDecimal6 = BigDecimal.ONE;
                bigDecimal5 = bigDecimal12;
                for (int i4 = 1; i4 < n2; ++i4) {
                    bigDecimal4 = new BigDecimal(2 * i4 + 1, this.a);
                    bigDecimal = new BigDecimal(i4, this.a);
                    bigDecimal9 = new BigDecimal(i4 + 1, this.a);
                    bigDecimal4 = bigDecimal12.multiply(bigDecimal4, this.a);
                    bigDecimal4 = bigDecimal5.multiply(bigDecimal4, this.a);
                    bigDecimal = bigDecimal6.multiply(bigDecimal, this.a);
                    bigDecimal = bigDecimal4.subtract(bigDecimal, this.a);
                    bigDecimal = bigDecimal.divide(bigDecimal9, this.a);
                    bigDecimal6 = bigDecimal5;
                    bigDecimal5 = bigDecimal;
                }
                if (bl) continue;
                if (bigDecimal8.signum() * bigDecimal5.signum() <= 0) {
                    bigDecimal2 = bigDecimal12;
                } else {
                    bigDecimal7 = bigDecimal12;
                    bigDecimal8 = bigDecimal5;
                }
                bigDecimal12 = bigDecimal7.add(bigDecimal2, this.a).multiply(this.d, this.a);
            }
            bigDecimal4 = new BigDecimal(n2, this.a);
            bigDecimal = bigDecimal6.subtract(bigDecimal12.multiply(bigDecimal5, this.a), this.a);
            bigDecimal = bigDecimal.multiply(bigDecimal4);
            bigDecimal = bigDecimal.pow(2, this.a);
            bigDecimal3 = bigDecimal12.pow(2, this.a);
            bigDecimal3 = BigDecimal.ONE.subtract(bigDecimal3, this.a);
            bigDecimal3 = bigDecimal3.multiply(this.b, this.a);
            bigDecimal3 = bigDecimal3.divide(bigDecimal, this.a);
            bigDecimalArray2[i2] = bigDecimal12;
            bigDecimalArray3[i2] = bigDecimal3;
            int n4 = n2 - i2 - 1;
            bigDecimalArray2[n4] = bigDecimal12.negate(this.a);
            bigDecimalArray3[n4] = bigDecimal3;
        }
        if (n2 % 2 != 0) {
            BigDecimal bigDecimal13 = BigDecimal.ONE;
            for (int i5 = 1; i5 < n2; i5 += 2) {
                bigDecimal2 = new BigDecimal(i5, this.a);
                bigDecimal = new BigDecimal(i5 + 1, this.a);
                bigDecimal13 = bigDecimal13.multiply(bigDecimal2, this.a);
                bigDecimal13 = bigDecimal13.divide(bigDecimal, this.a);
                bigDecimal13 = bigDecimal13.negate(this.a);
            }
            BigDecimal bigDecimal14 = new BigDecimal(n2, this.a);
            bigDecimal2 = bigDecimal13.multiply(bigDecimal14, this.a);
            bigDecimal2 = bigDecimal2.pow(2, this.a);
            bigDecimal = this.b.divide(bigDecimal2, this.a);
            bigDecimalArray2[n3] = BigDecimal.ZERO;
            bigDecimalArray3[n3] = bigDecimal;
        }
        return new co_0<BigDecimal[], BigDecimal[]>(bigDecimalArray2, bigDecimalArray3);
    }
}

