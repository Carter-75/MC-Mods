/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.Locale;
import org.valkyrienskies.core.impl.shadow.BS;
import org.valkyrienskies.core.impl.shadow.qN;
import org.valkyrienskies.core.impl.shadow.qO;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public abstract class qP<S extends qN> {
    private static String a = "{";
    private static String b = "}";
    private static String c = "; ";
    private final String d;
    private final String e;
    private final String f;
    private final String g;
    private final String h;
    private final String i;
    private final NumberFormat j;

    protected qP() {
        this("{", "}", "; ", BS.a(Locale.getDefault()));
    }

    private qP(NumberFormat numberFormat) {
        this("{", "}", "; ", numberFormat);
    }

    private qP(String string, String string2, String string3) {
        this(string, string2, string3, BS.a(Locale.getDefault()));
    }

    public qP(String string, String string2, String string3, NumberFormat numberFormat) {
        this.d = string;
        this.e = string2;
        this.f = string3;
        this.g = string.trim();
        this.h = string2.trim();
        this.i = string3.trim();
        this.j = numberFormat;
    }

    private static Locale[] a() {
        return NumberFormat.getAvailableLocales();
    }

    private String b() {
        return this.d;
    }

    private String c() {
        return this.e;
    }

    private String d() {
        return this.f;
    }

    private NumberFormat e() {
        return this.j;
    }

    public final String a(qO<S> qO2) {
        return this.a(qO2, new StringBuffer(), new FieldPosition(0)).toString();
    }

    public abstract StringBuffer a(qO<S> var1, StringBuffer var2, FieldPosition var3);

    protected final StringBuffer a(StringBuffer stringBuffer, FieldPosition fieldPosition, double ... dArray) {
        fieldPosition.setBeginIndex(0);
        fieldPosition.setEndIndex(0);
        stringBuffer.append(this.d);
        for (int i2 = 0; i2 < dArray.length; ++i2) {
            if (i2 > 0) {
                stringBuffer.append(this.f);
            }
            BS.a(dArray[i2], this.j, stringBuffer, fieldPosition);
        }
        stringBuffer.append(this.e);
        return stringBuffer;
    }

    public abstract qO<S> a(String var1);

    public abstract qO<S> a(String var1, ParsePosition var2);

    protected final double[] a(int n2, String string, ParsePosition parsePosition) {
        int n3 = parsePosition.getIndex();
        double[] dArray = new double[n2];
        BS.a(string, parsePosition);
        if (!BS.a(string, this.g, parsePosition)) {
            return null;
        }
        for (int i2 = 0; i2 < n2; ++i2) {
            BS.a(string, parsePosition);
            if (i2 > 0 && !BS.a(string, this.i, parsePosition)) {
                return null;
            }
            BS.a(string, parsePosition);
            Number number = BS.a(string, this.j, parsePosition);
            if (number == null) {
                parsePosition.setIndex(n3);
                return null;
            }
            dArray[i2] = number.doubleValue();
        }
        BS.a(string, parsePosition);
        if (!BS.a(string, this.h, parsePosition)) {
            return null;
        }
        return dArray;
    }
}

