/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.Locale;
import org.valkyrienskies.core.impl.shadow.BS;
import org.valkyrienskies.core.impl.shadow.nQ;
import org.valkyrienskies.core.impl.shadow.oV;
import org.valkyrienskies.core.impl.shadow.oZ;
import org.valkyrienskies.core.impl.shadow.pf_0;
import org.valkyrienskies.core.impl.shadow.pl_0;
import org.valkyrienskies.core.impl.shadow.px_0;

public final class nS {
    private static final String a = "i";
    private final String b;
    private final NumberFormat c;
    private final NumberFormat d;

    public nS() {
        this.b = a;
        this.d = this.c = BS.a(Locale.getDefault());
    }

    private nS(NumberFormat numberFormat) {
        if (numberFormat == null) {
            throw new pl_0(px_0.IMAGINARY_FORMAT, new Object[0]);
        }
        this.b = a;
        this.c = numberFormat;
        this.d = numberFormat;
    }

    private nS(NumberFormat numberFormat, NumberFormat numberFormat2) {
        if (numberFormat2 == null) {
            throw new pl_0(px_0.IMAGINARY_FORMAT, new Object[0]);
        }
        if (numberFormat == null) {
            throw new pl_0(px_0.REAL_FORMAT, new Object[0]);
        }
        this.b = a;
        this.c = numberFormat2;
        this.d = numberFormat;
    }

    private nS(String string) {
        this(string, BS.a(Locale.getDefault()));
    }

    private nS(String string, NumberFormat numberFormat) {
        NumberFormat numberFormat2 = numberFormat;
        this(string, numberFormat2, numberFormat2);
    }

    private nS(String string, NumberFormat numberFormat, NumberFormat numberFormat2) {
        if (string == null) {
            throw new pl_0();
        }
        if (string.length() == 0) {
            throw new pf_0();
        }
        if (numberFormat2 == null) {
            throw new pl_0(px_0.IMAGINARY_FORMAT, new Object[0]);
        }
        if (numberFormat == null) {
            throw new pl_0(px_0.REAL_FORMAT, new Object[0]);
        }
        this.b = string;
        this.c = numberFormat2;
        this.d = numberFormat;
    }

    private static Locale[] a() {
        return NumberFormat.getAvailableLocales();
    }

    private String a(nQ nQ2) {
        return this.a(nQ2, new StringBuffer(), new FieldPosition(0)).toString();
    }

    private String a(Double d2) {
        return this.a(new nQ(d2, 0.0), new StringBuffer(), new FieldPosition(0)).toString();
    }

    private StringBuffer a(nQ serializable, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        double d2;
        fieldPosition.setBeginIndex(0);
        fieldPosition.setEndIndex(0);
        nQ nQ2 = serializable;
        double d3 = nQ2.d;
        Object object = this;
        BS.a(d3, ((nS)object).d, stringBuffer, fieldPosition);
        object = serializable;
        double d4 = ((nQ)object).c;
        if (d2 < 0.0) {
            stringBuffer.append(" - ");
            serializable = this.a(-d4, new StringBuffer(), fieldPosition);
            stringBuffer.append((StringBuffer)serializable);
            object = this;
            stringBuffer.append(((nS)object).b);
        } else if (d4 > 0.0 || Double.isNaN(d4)) {
            stringBuffer.append(" + ");
            serializable = this.a(d4, new StringBuffer(), fieldPosition);
            stringBuffer.append((StringBuffer)serializable);
            object = this;
            stringBuffer.append(((nS)object).b);
        }
        return stringBuffer;
    }

    private StringBuffer a(double d2, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        fieldPosition.setBeginIndex(0);
        fieldPosition.setEndIndex(0);
        nS nS2 = this;
        BS.a(d2, nS2.c, stringBuffer, fieldPosition);
        if (stringBuffer.toString().equals("1")) {
            stringBuffer.setLength(0);
        }
        return stringBuffer;
    }

    private StringBuffer a(Object object, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        if (object instanceof nQ) {
            object = this.a((nQ)object, stringBuffer, fieldPosition);
        } else if (object instanceof Number) {
            object = this.a(new nQ(((Number)object).doubleValue(), 0.0), stringBuffer, fieldPosition);
        } else {
            throw new oV(px_0.CANNOT_FORMAT_INSTANCE_AS_COMPLEX, object.getClass().getName());
        }
        return object;
    }

    private String b() {
        return this.b;
    }

    private NumberFormat c() {
        return this.c;
    }

    private static nS d() {
        Cloneable cloneable = Locale.getDefault();
        cloneable = BS.a(cloneable);
        return new nS((NumberFormat)cloneable);
    }

    private static nS a(Locale cloneable) {
        cloneable = BS.a(cloneable);
        return new nS((NumberFormat)cloneable);
    }

    private static nS a(String string, Locale cloneable) {
        cloneable = BS.a(cloneable);
        return new nS(string, (NumberFormat)cloneable);
    }

    private NumberFormat e() {
        return this.d;
    }

    private nQ a(String string) {
        nS nS2;
        ParsePosition parsePosition;
        block9: {
            Object object;
            Number number;
            nS nS3;
            int n2;
            String string2;
            ParsePosition parsePosition2;
            block8: {
                parsePosition2 = parsePosition = new ParsePosition(0);
                string2 = string;
                nS2 = this;
                n2 = parsePosition2.getIndex();
                BS.a(string2, parsePosition2);
                nS3 = nS2;
                number = BS.a(string2, nS3.d, parsePosition2);
                if (number != null) break block8;
                parsePosition2.setIndex(n2);
                object = null;
                break block9;
            }
            int n3 = parsePosition2.getIndex();
            char c2 = BS.b(string2, parsePosition2);
            switch (c2) {
                case '\u0000': {
                    object = new nQ(number.doubleValue(), 0.0);
                    break block9;
                }
                case '-': {
                    n3 = -1;
                    break;
                }
                case '+': {
                    n3 = 1;
                    break;
                }
                default: {
                    parsePosition2.setIndex(n2);
                    parsePosition2.setErrorIndex(n3);
                    object = null;
                    break block9;
                }
            }
            BS.a(string2, parsePosition2);
            nS3 = nS2;
            Number number2 = BS.a(string2, nS3.d, parsePosition2);
            if (number2 == null) {
                parsePosition2.setIndex(n2);
                object = null;
            } else {
                nS3 = nS2;
                object = nS2 = !BS.a(string2, nS3.b, parsePosition2) ? null : new nQ(number.doubleValue(), number2.doubleValue() * (double)n3);
            }
        }
        if (parsePosition.getIndex() == 0) {
            throw new oZ(string, parsePosition.getErrorIndex(), nQ.class);
        }
        return nS2;
    }

    private nQ a(String string, ParsePosition parsePosition) {
        int n2 = parsePosition.getIndex();
        BS.a(string, parsePosition);
        nS nS2 = this;
        Number number = BS.a(string, nS2.d, parsePosition);
        if (number == null) {
            parsePosition.setIndex(n2);
            return null;
        }
        int n3 = parsePosition.getIndex();
        char c2 = BS.b(string, parsePosition);
        switch (c2) {
            case '\u0000': {
                return new nQ(number.doubleValue(), 0.0);
            }
            case '-': {
                n3 = -1;
                break;
            }
            case '+': {
                n3 = 1;
                break;
            }
            default: {
                parsePosition.setIndex(n2);
                parsePosition.setErrorIndex(n3);
                return null;
            }
        }
        BS.a(string, parsePosition);
        nS2 = this;
        Number number2 = BS.a(string, nS2.d, parsePosition);
        if (number2 == null) {
            parsePosition.setIndex(n2);
            return null;
        }
        nS2 = this;
        if (!BS.a(string, nS2.b, parsePosition)) {
            return null;
        }
        return new nQ(number.doubleValue(), number2.doubleValue() * (double)n3);
    }
}

