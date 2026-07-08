/*
 * Decompiled with CFR 0.152.
 */
package com.fasterxml.jackson.core.io;

import com.fasterxml.jackson.core.io.BigDecimalParser;
import com.fasterxml.jackson.core.io.doubleparser.FastDoubleParser;
import com.fasterxml.jackson.core.io.doubleparser.FastFloatParser;
import java.math.BigDecimal;
import java.math.BigInteger;

public final class NumberInput {
    private static final int LARGE_INT_SIZE = 1250;
    @Deprecated
    public static final String NASTY_SMALL_DOUBLE = "2.2250738585072012e-308";
    static final long L_BILLION = 1000000000L;
    static final String MIN_LONG_STR_NO_SIGN = String.valueOf(Long.MIN_VALUE).substring(1);
    static final String MAX_LONG_STR = String.valueOf(Long.MAX_VALUE);

    public static int parseInt(char[] ch, int off, int len) {
        if (len > 0 && ch[off] == '+') {
            ++off;
            --len;
        }
        int num = ch[off + len - 1] - 48;
        switch (len) {
            case 9: {
                num += (ch[off++] - 48) * 100000000;
            }
            case 8: {
                num += (ch[off++] - 48) * 10000000;
            }
            case 7: {
                num += (ch[off++] - 48) * 1000000;
            }
            case 6: {
                num += (ch[off++] - 48) * 100000;
            }
            case 5: {
                num += (ch[off++] - 48) * 10000;
            }
            case 4: {
                num += (ch[off++] - 48) * 1000;
            }
            case 3: {
                num += (ch[off++] - 48) * 100;
            }
            case 2: {
                num += (ch[off] - 48) * 10;
            }
        }
        return num;
    }

    public static int parseInt(String s) {
        char c2 = s.charAt(0);
        int len = s.length();
        boolean neg = c2 == '-';
        int offset = 1;
        if (neg) {
            if (len == 1 || len > 10) {
                return Integer.parseInt(s);
            }
            c2 = s.charAt(offset++);
        } else if (len > 9) {
            return Integer.parseInt(s);
        }
        if (c2 > '9' || c2 < '0') {
            return Integer.parseInt(s);
        }
        int num = c2 - 48;
        if (offset < len) {
            if ((c2 = s.charAt(offset++)) > '9' || c2 < '0') {
                return Integer.parseInt(s);
            }
            num = num * 10 + (c2 - 48);
            if (offset < len) {
                if ((c2 = s.charAt(offset++)) > '9' || c2 < '0') {
                    return Integer.parseInt(s);
                }
                num = num * 10 + (c2 - 48);
                if (offset < len) {
                    do {
                        if ((c2 = s.charAt(offset++)) > '9' || c2 < '0') {
                            return Integer.parseInt(s);
                        }
                        num = num * 10 + (c2 - 48);
                    } while (offset < len);
                }
            }
        }
        return neg ? -num : num;
    }

    public static long parseLong(char[] ch, int off, int len) {
        int len1 = len - 9;
        long val = (long)NumberInput.parseInt(ch, off, len1) * 1000000000L;
        return val + (long)NumberInput.parseInt(ch, off + len1, 9);
    }

    public static long parseLong(String s) {
        int length = s.length();
        if (length <= 9) {
            return NumberInput.parseInt(s);
        }
        return Long.parseLong(s);
    }

    public static boolean inLongRange(char[] ch, int off, int len, boolean negative) {
        String cmpStr = negative ? MIN_LONG_STR_NO_SIGN : MAX_LONG_STR;
        int cmpLen = cmpStr.length();
        if (len < cmpLen) {
            return true;
        }
        if (len > cmpLen) {
            return false;
        }
        for (int i2 = 0; i2 < cmpLen; ++i2) {
            int diff = ch[off + i2] - cmpStr.charAt(i2);
            if (diff == 0) continue;
            return diff < 0;
        }
        return true;
    }

    public static boolean inLongRange(String s, boolean negative) {
        String cmp = negative ? MIN_LONG_STR_NO_SIGN : MAX_LONG_STR;
        int cmpLen = cmp.length();
        int alen = s.length();
        if (alen < cmpLen) {
            return true;
        }
        if (alen > cmpLen) {
            return false;
        }
        for (int i2 = 0; i2 < cmpLen; ++i2) {
            int diff = s.charAt(i2) - cmp.charAt(i2);
            if (diff == 0) continue;
            return diff < 0;
        }
        return true;
    }

    public static int parseAsInt(String s, int def) {
        if (s == null) {
            return def;
        }
        int len = (s = s.trim()).length();
        if (len == 0) {
            return def;
        }
        int i2 = 0;
        char sign = s.charAt(0);
        if (sign == '+') {
            s = s.substring(1);
            len = s.length();
        } else if (sign == '-') {
            i2 = 1;
        }
        while (i2 < len) {
            char c2 = s.charAt(i2);
            if (c2 > '9' || c2 < '0') {
                try {
                    return (int)NumberInput.parseDouble(s, true);
                }
                catch (NumberFormatException e2) {
                    return def;
                }
            }
            ++i2;
        }
        try {
            return Integer.parseInt(s);
        }
        catch (NumberFormatException numberFormatException) {
            return def;
        }
    }

    public static long parseAsLong(String s, long def) {
        if (s == null) {
            return def;
        }
        int len = (s = s.trim()).length();
        if (len == 0) {
            return def;
        }
        int i2 = 0;
        char sign = s.charAt(0);
        if (sign == '+') {
            s = s.substring(1);
            len = s.length();
        } else if (sign == '-') {
            i2 = 1;
        }
        while (i2 < len) {
            char c2 = s.charAt(i2);
            if (c2 > '9' || c2 < '0') {
                try {
                    return (long)NumberInput.parseDouble(s, true);
                }
                catch (NumberFormatException e2) {
                    return def;
                }
            }
            ++i2;
        }
        try {
            return Long.parseLong(s);
        }
        catch (NumberFormatException numberFormatException) {
            return def;
        }
    }

    public static double parseAsDouble(String s, double def) {
        return NumberInput.parseAsDouble(s, def, false);
    }

    public static double parseAsDouble(String s, double def, boolean useFastParser) {
        if (s == null) {
            return def;
        }
        int len = (s = s.trim()).length();
        if (len == 0) {
            return def;
        }
        try {
            return NumberInput.parseDouble(s, useFastParser);
        }
        catch (NumberFormatException numberFormatException) {
            return def;
        }
    }

    public static double parseDouble(String s) throws NumberFormatException {
        return NumberInput.parseDouble(s, false);
    }

    public static double parseDouble(String s, boolean useFastParser) throws NumberFormatException {
        return useFastParser ? FastDoubleParser.parseDouble(s) : Double.parseDouble(s);
    }

    public static float parseFloat(String s) throws NumberFormatException {
        return NumberInput.parseFloat(s, false);
    }

    public static float parseFloat(String s, boolean useFastParser) throws NumberFormatException {
        return useFastParser ? FastFloatParser.parseFloat(s) : Float.parseFloat(s);
    }

    public static BigDecimal parseBigDecimal(String s) throws NumberFormatException {
        return BigDecimalParser.parse(s);
    }

    public static BigDecimal parseBigDecimal(char[] ch, int off, int len) throws NumberFormatException {
        return BigDecimalParser.parse(ch, off, len);
    }

    public static BigDecimal parseBigDecimal(char[] ch) throws NumberFormatException {
        return BigDecimalParser.parse(ch);
    }

    public static BigInteger parseBigInteger(String s) throws NumberFormatException {
        if (s.length() > 1250) {
            return BigDecimalParser.parse(s).toBigInteger();
        }
        return new BigInteger(s);
    }
}

