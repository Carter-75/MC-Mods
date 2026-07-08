/*
 * Decompiled with CFR 0.152.
 */
package com.fasterxml.jackson.core.io.doubleparser;

import com.fasterxml.jackson.core.io.doubleparser.FloatBitsFromCharArray;
import com.fasterxml.jackson.core.io.doubleparser.FloatBitsFromCharSequence;

public class FastFloatParser {
    private FastFloatParser() {
    }

    public static float parseFloat(CharSequence str) throws NumberFormatException {
        return FastFloatParser.parseFloat(str, 0, str.length());
    }

    public static float parseFloat(CharSequence str, int offset, int length) throws NumberFormatException {
        long bitPattern = new FloatBitsFromCharSequence().parseFloatingPointLiteral(str, offset, length);
        if (bitPattern == -1L) {
            throw new NumberFormatException("Illegal input");
        }
        return Float.intBitsToFloat((int)bitPattern);
    }

    public static float parseFloat(char[] str) throws NumberFormatException {
        return FastFloatParser.parseFloat(str, 0, str.length);
    }

    public static float parseFloat(char[] str, int offset, int length) throws NumberFormatException {
        long bitPattern = new FloatBitsFromCharArray().parseFloatingPointLiteral(str, offset, length);
        if (bitPattern == -1L) {
            throw new NumberFormatException("Illegal input");
        }
        return Float.intBitsToFloat((int)bitPattern);
    }

    public static long parseFloatBits(CharSequence str, int offset, int length) {
        return new FloatBitsFromCharSequence().parseFloatingPointLiteral(str, offset, length);
    }

    public static long parseFloatBits(char[] str, int offset, int length) {
        return new FloatBitsFromCharArray().parseFloatingPointLiteral(str, offset, length);
    }
}

