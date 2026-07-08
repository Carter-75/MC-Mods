/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Locale;
import org.valkyrienskies.core.impl.shadow.BS;
import org.valkyrienskies.core.impl.shadow.oZ;
import org.valkyrienskies.core.impl.shadow.sA;
import org.valkyrienskies.core.impl.shadow.tu_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.tw
 */
public final class tw_0 {
    private static final String e = "{";
    private static final String f = "}";
    private static final String g = "; ";
    final String a;
    final String b;
    final String c;
    private final String h;
    private final String i;
    private final String j;
    final NumberFormat d;

    public tw_0() {
        this(e, f, g, BS.a(Locale.getDefault()));
    }

    public tw_0(NumberFormat numberFormat) {
        this(e, f, g, numberFormat);
    }

    private tw_0(String string, String string2, String string3) {
        this(string, string2, string3, BS.a(Locale.getDefault()));
    }

    private tw_0(String string, String string2, String string3, NumberFormat numberFormat) {
        this.a = string;
        this.b = string2;
        this.c = string3;
        this.h = string.trim();
        this.i = string2.trim();
        this.j = string3.trim();
        this.d = numberFormat;
    }

    private static Locale[] b() {
        return NumberFormat.getAvailableLocales();
    }

    private String c() {
        return this.a;
    }

    private String d() {
        return this.b;
    }

    private String e() {
        return this.c;
    }

    private NumberFormat f() {
        return this.d;
    }

    public static tw_0 a() {
        return tw_0.a(Locale.getDefault());
    }

    private static tw_0 a(Locale locale) {
        return new tw_0(BS.a(locale));
    }

    public final String a(sA sA2) {
        return this.a((tu_0)((Object)sA2), new StringBuffer(), new FieldPosition(0)).toString();
    }

    private StringBuffer a(tu_0 tu_02, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        fieldPosition.setBeginIndex(0);
        fieldPosition.setEndIndex(0);
        stringBuffer.append(this.a);
        for (int i2 = 0; i2 < tu_02.f(); ++i2) {
            if (i2 > 0) {
                stringBuffer.append(this.c);
            }
            BS.a(tu_02.a(i2), this.d, stringBuffer, fieldPosition);
        }
        stringBuffer.append(this.b);
        return stringBuffer;
    }

    private sA a(String string) {
        tw_0 tw_02;
        ParsePosition parsePosition;
        block10: {
            Object object;
            ParsePosition parsePosition2 = parsePosition = new ParsePosition(0);
            String string2 = string;
            tw_02 = this;
            int n2 = parsePosition2.getIndex();
            BS.a(string2, parsePosition2);
            if (!BS.a(string2, tw_02.h, parsePosition2)) {
                object = null;
            } else {
                ArrayList<Number> arrayList = new ArrayList<Number>();
                boolean bl = true;
                while (bl) {
                    if (!arrayList.isEmpty()) {
                        BS.a(string2, parsePosition2);
                        if (!BS.a(string2, tw_02.j, parsePosition2)) {
                            bl = false;
                        }
                    }
                    if (!bl) continue;
                    BS.a(string2, parsePosition2);
                    Number number = BS.a(string2, tw_02.d, parsePosition2);
                    if (number != null) {
                        arrayList.add(number);
                        continue;
                    }
                    parsePosition2.setIndex(n2);
                    object = null;
                    break block10;
                }
                BS.a(string2, parsePosition2);
                if (!BS.a(string2, tw_02.i, parsePosition2)) {
                    object = null;
                } else {
                    double[] dArray = new double[arrayList.size()];
                    for (int i2 = 0; i2 < dArray.length; ++i2) {
                        dArray[i2] = ((Number)arrayList.get(i2)).doubleValue();
                    }
                    object = tw_02 = new sA(dArray, false);
                }
            }
        }
        if (parsePosition.getIndex() == 0) {
            throw new oZ(string, parsePosition.getErrorIndex(), sA.class);
        }
        return tw_02;
    }

    private sA a(String string, ParsePosition parsePosition) {
        int n2 = parsePosition.getIndex();
        BS.a(string, parsePosition);
        if (!BS.a(string, this.h, parsePosition)) {
            return null;
        }
        ArrayList<Number> arrayList = new ArrayList<Number>();
        boolean bl = true;
        while (bl) {
            if (!arrayList.isEmpty()) {
                BS.a(string, parsePosition);
                if (!BS.a(string, this.j, parsePosition)) {
                    bl = false;
                }
            }
            if (!bl) continue;
            BS.a(string, parsePosition);
            Number number = BS.a(string, this.d, parsePosition);
            if (number != null) {
                arrayList.add(number);
                continue;
            }
            parsePosition.setIndex(n2);
            return null;
        }
        BS.a(string, parsePosition);
        if (!BS.a(string, this.i, parsePosition)) {
            return null;
        }
        double[] dArray = new double[arrayList.size()];
        for (int i2 = 0; i2 < dArray.length; ++i2) {
            dArray[i2] = ((Number)arrayList.get(i2)).doubleValue();
        }
        return new sA(dArray, false);
    }
}

