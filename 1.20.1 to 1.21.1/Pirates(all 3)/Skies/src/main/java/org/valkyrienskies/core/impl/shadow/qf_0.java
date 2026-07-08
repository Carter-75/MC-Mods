/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import java.math.BigInteger;
import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.Locale;
import org.valkyrienskies.core.impl.shadow.oV;
import org.valkyrienskies.core.impl.shadow.oZ;
import org.valkyrienskies.core.impl.shadow.px_0;
import org.valkyrienskies.core.impl.shadow.qc_0;
import org.valkyrienskies.core.impl.shadow.qd_0;
import org.valkyrienskies.core.impl.shadow.qk_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.qf
 */
public class qf_0
extends qc_0
implements Serializable {
    private static final long a = -2932167925527338976L;

    public qf_0() {
    }

    private qf_0(NumberFormat numberFormat) {
        super(numberFormat);
    }

    public qf_0(NumberFormat numberFormat, NumberFormat numberFormat2) {
        super(numberFormat, numberFormat2);
    }

    private static Locale[] d() {
        return NumberFormat.getAvailableLocales();
    }

    private static String a(qd_0 qd_02) {
        Locale locale = Locale.getDefault();
        return new qf_0(qf_0.a(locale)).format(qd_02);
    }

    private static qf_0 e() {
        return qf_0.b(Locale.getDefault());
    }

    private static qf_0 b(Locale locale) {
        return new qf_0(qf_0.a(locale));
    }

    private static qf_0 f() {
        Locale locale = Locale.getDefault();
        return new qk_0(qf_0.a(locale));
    }

    private static qk_0 c(Locale locale) {
        return new qk_0(qf_0.a(locale));
    }

    public StringBuffer a(qd_0 qd_02, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        fieldPosition.setBeginIndex(0);
        fieldPosition.setEndIndex(0);
        qd_0 qd_03 = qd_02;
        this.c().format(qd_03.f, stringBuffer, fieldPosition);
        stringBuffer.append(" / ");
        qd_03 = qd_02;
        this.b().format(qd_03.g, stringBuffer, fieldPosition);
        return stringBuffer;
    }

    /*
     * WARNING - void declaration
     */
    public StringBuffer format(Object obj, StringBuffer toAppendTo, FieldPosition pos) {
        StringBuffer stringBuffer;
        if (obj instanceof qd_0) {
            stringBuffer = this.a((qd_0)obj, toAppendTo, pos);
        } else if (stringBuffer instanceof BigInteger) {
            stringBuffer = this.a(new qd_0((BigInteger)((Object)stringBuffer)), toAppendTo, pos);
        } else if (stringBuffer instanceof Number) {
            void var3_3;
            void var2_2;
            stringBuffer = this.a(new qd_0(((Number)((Object)stringBuffer)).doubleValue()), (StringBuffer)var2_2, (FieldPosition)var3_3);
        } else {
            throw new oV(px_0.CANNOT_FORMAT_OBJECT_TO_FRACTION, new Object[0]);
        }
        return stringBuffer;
    }

    private qd_0 a(String string) {
        ParsePosition parsePosition = new ParsePosition(0);
        qd_0 qd_02 = this.c(string, parsePosition);
        if (parsePosition.getIndex() == 0) {
            throw new oZ(string, parsePosition.getErrorIndex(), qd_0.class);
        }
        return qd_02;
    }

    public qd_0 c(String object, ParsePosition parsePosition) {
        int n2 = parsePosition.getIndex();
        qf_0.a((String)object, parsePosition);
        BigInteger bigInteger = qf_0.d((String)object, parsePosition);
        if (bigInteger == null) {
            parsePosition.setIndex(n2);
            return null;
        }
        int n3 = parsePosition.getIndex();
        char c2 = qf_0.b((String)object, parsePosition);
        switch (c2) {
            case '\u0000': {
                return new qd_0(bigInteger);
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
        qf_0.a((String)object, parsePosition);
        object = qf_0.d((String)object, parsePosition);
        if (object == null) {
            parsePosition.setIndex(n2);
            return null;
        }
        return new qd_0(bigInteger, (BigInteger)object);
    }

    protected static BigInteger d(String object, ParsePosition parsePosition) {
        int n2;
        int n3 = parsePosition.getIndex();
        int n4 = n2 = ((String)object).charAt(n3) == '-' ? n3 + 1 : n3;
        while (n2 < ((String)object).length() && Character.isDigit(((String)object).charAt(n2))) {
            ++n2;
        }
        try {
            object = new BigInteger(((String)object).substring(n3, n2));
            parsePosition.setIndex(n2);
            return object;
        }
        catch (NumberFormatException numberFormatException) {
            parsePosition.setErrorIndex(n3);
            return null;
        }
    }

    public /* synthetic */ Number parse(String object) {
        String string = object;
        object = this;
        ParsePosition parsePosition = new ParsePosition(0);
        object = ((qf_0)object).c(string, parsePosition);
        if (parsePosition.getIndex() == 0) {
            throw new oZ(string, parsePosition.getErrorIndex(), qd_0.class);
        }
        return object;
    }

    public /* synthetic */ Number parse(String string, ParsePosition parsePosition) {
        return this.c(string, parsePosition);
    }
}

