/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.Locale;
import org.valkyrienskies.core.impl.shadow.oV;
import org.valkyrienskies.core.impl.shadow.oZ;
import org.valkyrienskies.core.impl.shadow.px_0;
import org.valkyrienskies.core.impl.shadow.qc_0;
import org.valkyrienskies.core.impl.shadow.qg_0;
import org.valkyrienskies.core.impl.shadow.ql_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.qj
 */
public class qj_0
extends qc_0 {
    private static final long a = 3008655719530972611L;

    public qj_0() {
    }

    private qj_0(NumberFormat numberFormat) {
        super(numberFormat);
    }

    public qj_0(NumberFormat numberFormat, NumberFormat numberFormat2) {
        super(numberFormat, numberFormat2);
    }

    private static Locale[] e() {
        return NumberFormat.getAvailableLocales();
    }

    private static String a(qg_0 qg_02) {
        Locale locale = Locale.getDefault();
        return new qj_0(qj_0.a(locale)).format(qg_02);
    }

    private static qj_0 f() {
        return qj_0.b(Locale.getDefault());
    }

    private static qj_0 b(Locale locale) {
        return new qj_0(qj_0.a(locale));
    }

    private static qj_0 g() {
        Locale locale = Locale.getDefault();
        return new ql_0(qj_0.a(locale));
    }

    private static ql_0 c(Locale locale) {
        return new ql_0(qj_0.a(locale));
    }

    protected static NumberFormat d() {
        return qj_0.a(Locale.getDefault());
    }

    public StringBuffer a(qg_0 qg_02, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        fieldPosition.setBeginIndex(0);
        fieldPosition.setEndIndex(0);
        qg_0 qg_03 = qg_02;
        this.c().format(qg_03.d, stringBuffer, fieldPosition);
        stringBuffer.append(" / ");
        qg_03 = qg_02;
        this.b().format(qg_03.c, stringBuffer, fieldPosition);
        return stringBuffer;
    }

    /*
     * WARNING - void declaration
     */
    public StringBuffer format(Object obj, StringBuffer toAppendTo, FieldPosition pos) {
        StringBuffer stringBuffer;
        if (obj instanceof qg_0) {
            stringBuffer = this.a((qg_0)obj, toAppendTo, pos);
        } else if (stringBuffer instanceof Number) {
            void var3_3;
            void var2_2;
            stringBuffer = this.a(new qg_0(((Number)((Object)stringBuffer)).doubleValue()), (StringBuffer)var2_2, (FieldPosition)var3_3);
        } else {
            throw new oV(px_0.CANNOT_FORMAT_OBJECT_TO_FRACTION, new Object[0]);
        }
        return stringBuffer;
    }

    private qg_0 a(String string) {
        ParsePosition parsePosition = new ParsePosition(0);
        qg_0 qg_02 = this.c(string, parsePosition);
        if (parsePosition.getIndex() == 0) {
            throw new oZ(string, parsePosition.getErrorIndex(), qg_0.class);
        }
        return qg_02;
    }

    public qg_0 c(String object, ParsePosition parsePosition) {
        int n2 = parsePosition.getIndex();
        qj_0.a((String)object, parsePosition);
        Number number = this.c().parse((String)object, parsePosition);
        if (number == null) {
            parsePosition.setIndex(n2);
            return null;
        }
        int n3 = parsePosition.getIndex();
        char c2 = qj_0.b((String)object, parsePosition);
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
        qj_0.a((String)object, parsePosition);
        object = this.b().parse((String)object, parsePosition);
        if (object == null) {
            parsePosition.setIndex(n2);
            return null;
        }
        return new qg_0(number.intValue(), ((Number)object).intValue());
    }

    public /* synthetic */ Number parse(String object) {
        String string = object;
        object = this;
        ParsePosition parsePosition = new ParsePosition(0);
        object = ((qj_0)object).c(string, parsePosition);
        if (parsePosition.getIndex() == 0) {
            throw new oZ(string, parsePosition.getErrorIndex(), qg_0.class);
        }
        return object;
    }

    public /* synthetic */ Number parse(String string, ParsePosition parsePosition) {
        return this.c(string, parsePosition);
    }
}

