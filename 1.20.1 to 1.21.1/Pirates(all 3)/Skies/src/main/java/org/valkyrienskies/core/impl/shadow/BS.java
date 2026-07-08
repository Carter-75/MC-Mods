/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.Locale;

public final class BS {
    private BS() {
    }

    public static NumberFormat a() {
        return BS.a(Locale.getDefault());
    }

    public static NumberFormat a(Locale cloneable) {
        cloneable = NumberFormat.getInstance(cloneable);
        ((NumberFormat)cloneable).setMaximumFractionDigits(10);
        return cloneable;
    }

    public static void a(String string, ParsePosition parsePosition) {
        BS.b(string, parsePosition);
        ParsePosition parsePosition2 = parsePosition;
        parsePosition2.setIndex(parsePosition2.getIndex() - 1);
    }

    public static char b(String string, ParsePosition parsePosition) {
        int n2 = parsePosition.getIndex();
        int n3 = string.length();
        char c2 = '\u0000';
        if (n2 < n3) {
            char c3;
            while (Character.isWhitespace(c3 = string.charAt(n2++)) && n2 < n3) {
            }
            parsePosition.setIndex(n2);
            if (n2 < n3) {
                c2 = c3;
            }
        }
        return c2;
    }

    private static Number a(String string, double d2, ParsePosition parsePosition) {
        Double d3 = null;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('(');
        stringBuilder.append(d2);
        stringBuilder.append(')');
        int n2 = stringBuilder.length();
        int n3 = parsePosition.getIndex();
        n2 = n3 + n2;
        if (n2 < string.length() && string.substring(n3, n2).compareTo(stringBuilder.toString()) == 0) {
            d3 = d2;
            parsePosition.setIndex(n2);
        }
        return d3;
    }

    public static Number a(String string, NumberFormat serializable, ParsePosition parsePosition) {
        int n2 = parsePosition.getIndex();
        serializable = serializable.parse(string, parsePosition);
        int n3 = parsePosition.getIndex();
        if (n2 == n3) {
            double[] dArray = new double[]{Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY};
            for (n3 = 0; n3 < dArray.length && (serializable = BS.a(string, dArray[n3], parsePosition)) == null; ++n3) {
            }
        }
        return serializable;
    }

    public static boolean a(String string, String string2, ParsePosition parsePosition) {
        int n2 = parsePosition.getIndex();
        int n3 = n2 + string2.length();
        if (n2 >= string.length() || n3 > string.length() || string.substring(n2, n3).compareTo(string2) != 0) {
            parsePosition.setIndex(n2);
            parsePosition.setErrorIndex(n2);
            return false;
        }
        parsePosition.setIndex(n3);
        return true;
    }

    public static StringBuffer a(double d2, NumberFormat numberFormat, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        if (Double.isNaN(d2) || Double.isInfinite(d2)) {
            stringBuffer.append('(');
            stringBuffer.append(d2);
            stringBuffer.append(')');
        } else {
            numberFormat.format(d2, stringBuffer, fieldPosition);
        }
        return stringBuffer;
    }
}

