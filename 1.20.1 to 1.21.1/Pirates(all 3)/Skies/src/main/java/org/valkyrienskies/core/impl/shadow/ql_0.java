/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;
import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.pl_0;
import org.valkyrienskies.core.impl.shadow.px_0;
import org.valkyrienskies.core.impl.shadow.qg_0;
import org.valkyrienskies.core.impl.shadow.qj_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.ql
 */
public final class ql_0
extends qj_0 {
    private static final long a = 760934726031766749L;
    private NumberFormat b;

    public ql_0() {
        this(ql_0.d());
    }

    public ql_0(NumberFormat numberFormat) {
        NumberFormat numberFormat2 = numberFormat;
        this(numberFormat2, (NumberFormat)numberFormat2.clone(), (NumberFormat)numberFormat.clone());
    }

    private ql_0(NumberFormat numberFormat, NumberFormat numberFormat2, NumberFormat numberFormat3) {
        super(numberFormat2, numberFormat3);
        numberFormat2 = numberFormat;
        numberFormat = this;
        if (numberFormat2 == null) {
            throw new pl_0(px_0.WHOLE_FORMAT, new Object[0]);
        }
        ((ql_0)numberFormat).b = numberFormat2;
    }

    public final StringBuffer a(qg_0 qg_02, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        fieldPosition.setBeginIndex(0);
        fieldPosition.setEndIndex(0);
        Serializable serializable = qg_02;
        int n2 = serializable.d;
        serializable = qg_02;
        int n3 = serializable.c;
        int n4 = n2 / n3;
        n2 %= n3;
        if (n4 != 0) {
            serializable = this;
            ((ql_0)serializable).b.format(n4, stringBuffer, fieldPosition);
            stringBuffer.append(' ');
            n2 = BY.a(n2);
        }
        this.c().format(n2, stringBuffer, fieldPosition);
        stringBuffer.append(" / ");
        this.b().format(n3, stringBuffer, fieldPosition);
        return stringBuffer;
    }

    private NumberFormat e() {
        return this.b;
    }

    public final qg_0 c(String object, ParsePosition parsePosition) {
        qg_0 qg_02 = super.c((String)object, parsePosition);
        if (qg_02 != null) {
            return qg_02;
        }
        int n2 = parsePosition.getIndex();
        ql_0.a((String)object, parsePosition);
        Serializable serializable = this;
        serializable = ((ql_0)serializable).b.parse((String)object, parsePosition);
        if (serializable == null) {
            parsePosition.setIndex(n2);
            return null;
        }
        ql_0.a((String)object, parsePosition);
        Number number = this.c().parse((String)object, parsePosition);
        if (number == null) {
            parsePosition.setIndex(n2);
            return null;
        }
        if (number.intValue() < 0) {
            parsePosition.setIndex(n2);
            return null;
        }
        int n3 = parsePosition.getIndex();
        char c2 = ql_0.b((String)object, parsePosition);
        switch (c2) {
            case '\u0000': {
                return new qg_0(number.intValue(), 1);
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
        ql_0.a((String)object, parsePosition);
        object = this.b().parse((String)object, parsePosition);
        if (object == null) {
            parsePosition.setIndex(n2);
            return null;
        }
        if (((Number)object).intValue() < 0) {
            parsePosition.setIndex(n2);
            return null;
        }
        int n4 = ((Number)serializable).intValue();
        n2 = number.intValue();
        int n5 = ((Number)object).intValue();
        int n6 = BY.a(n4) * n5 + n2;
        n2 = n4;
        n4 = 1;
        return new qg_0(n6 * (n2 >= 0 ? 1 : -1), n5);
    }

    private void a(NumberFormat numberFormat) {
        if (numberFormat == null) {
            throw new pl_0(px_0.WHOLE_FORMAT, new Object[0]);
        }
        this.b = numberFormat;
    }

    public final /* synthetic */ Number parse(String string, ParsePosition parsePosition) {
        return ((qj_0)this).c(string, parsePosition);
    }
}

