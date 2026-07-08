/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.math.BigInteger;
import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;
import org.valkyrienskies.core.impl.shadow.pl_0;
import org.valkyrienskies.core.impl.shadow.px_0;
import org.valkyrienskies.core.impl.shadow.qd_0;
import org.valkyrienskies.core.impl.shadow.qf_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.qk
 */
public final class qk_0
extends qf_0 {
    private static final long a = -6337346779577272307L;
    private NumberFormat b;

    public qk_0() {
        this(qk_0.a());
    }

    public qk_0(NumberFormat numberFormat) {
        NumberFormat numberFormat2 = numberFormat;
        this(numberFormat2, (NumberFormat)numberFormat2.clone(), (NumberFormat)numberFormat.clone());
    }

    private qk_0(NumberFormat numberFormat, NumberFormat numberFormat2, NumberFormat numberFormat3) {
        super(numberFormat2, numberFormat3);
        numberFormat2 = numberFormat;
        numberFormat = this;
        if (numberFormat2 == null) {
            throw new pl_0(px_0.WHOLE_FORMAT, new Object[0]);
        }
        ((qk_0)numberFormat).b = numberFormat2;
    }

    public final StringBuffer a(qd_0 number, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        fieldPosition.setBeginIndex(0);
        fieldPosition.setEndIndex(0);
        Number number2 = number;
        BigInteger bigInteger = number2.f;
        number2 = number;
        number = number2.g;
        number2 = bigInteger.divide((BigInteger)number);
        bigInteger = bigInteger.remainder((BigInteger)number);
        if (!BigInteger.ZERO.equals(number2)) {
            qk_0 qk_02 = this;
            qk_02.b.format(number2, stringBuffer, fieldPosition);
            stringBuffer.append(' ');
            if (bigInteger.compareTo(BigInteger.ZERO) < 0) {
                bigInteger = bigInteger.negate();
            }
        }
        this.c().format(bigInteger, stringBuffer, fieldPosition);
        stringBuffer.append(" / ");
        this.b().format(number, stringBuffer, fieldPosition);
        return stringBuffer;
    }

    private NumberFormat d() {
        return this.b;
    }

    public final qd_0 c(String object, ParsePosition parsePosition) {
        qd_0 qd_02 = super.c((String)object, parsePosition);
        if (qd_02 != null) {
            return qd_02;
        }
        int n2 = parsePosition.getIndex();
        qk_0.a((String)object, parsePosition);
        BigInteger bigInteger = qk_0.d((String)object, parsePosition);
        if (bigInteger == null) {
            parsePosition.setIndex(n2);
            return null;
        }
        qk_0.a((String)object, parsePosition);
        BigInteger bigInteger2 = qk_0.d((String)object, parsePosition);
        if (bigInteger2 == null) {
            parsePosition.setIndex(n2);
            return null;
        }
        if (bigInteger2.compareTo(BigInteger.ZERO) < 0) {
            parsePosition.setIndex(n2);
            return null;
        }
        int n3 = parsePosition.getIndex();
        char c2 = qk_0.b((String)object, parsePosition);
        switch (c2) {
            case '\u0000': {
                return new qd_0(bigInteger2);
            }
            case '/': {
                break;
            }
            default: {
                parsePosition.setIndex(n2);
                parsePosition.setErrorIndex(n3);
                return null;
            }
        }
        qk_0.a((String)object, parsePosition);
        object = qk_0.d((String)object, parsePosition);
        if (object == null) {
            parsePosition.setIndex(n2);
            return null;
        }
        if (((BigInteger)object).compareTo(BigInteger.ZERO) < 0) {
            parsePosition.setIndex(n2);
            return null;
        }
        boolean bl = bigInteger.compareTo(BigInteger.ZERO) < 0;
        if (bl) {
            bigInteger = bigInteger.negate();
        }
        bigInteger2 = bigInteger.multiply((BigInteger)object).add(bigInteger2);
        if (bl) {
            bigInteger2 = bigInteger2.negate();
        }
        return new qd_0(bigInteger2, (BigInteger)object);
    }

    private void a(NumberFormat numberFormat) {
        if (numberFormat == null) {
            throw new pl_0(px_0.WHOLE_FORMAT, new Object[0]);
        }
        this.b = numberFormat;
    }

    public final /* synthetic */ Number parse(String string, ParsePosition parsePosition) {
        return ((qf_0)this).c(string, parsePosition);
    }
}

