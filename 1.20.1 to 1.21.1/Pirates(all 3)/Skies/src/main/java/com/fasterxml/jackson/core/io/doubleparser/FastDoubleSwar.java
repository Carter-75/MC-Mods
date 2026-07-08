/*
 * Decompiled with CFR 0.152.
 */
package com.fasterxml.jackson.core.io.doubleparser;

class FastDoubleSwar {
    FastDoubleSwar() {
    }

    public static int tryToParseEightDigitsUtf16(char[] a2, int offset) {
        long first2 = (long)a2[offset] | (long)a2[offset + 1] << 16 | (long)a2[offset + 2] << 32 | (long)a2[offset + 3] << 48;
        long second2 = (long)a2[offset + 4] | (long)a2[offset + 5] << 16 | (long)a2[offset + 6] << 32 | (long)a2[offset + 7] << 48;
        return FastDoubleSwar.tryToParseEightDigitsUtf16(first2, second2);
    }

    public static int tryToParseEightDigitsUtf16(long first2, long second2) {
        long fval = first2 - 0x30003000300030L;
        long fpre = first2 + 0x46004600460046L | fval;
        long sval = second2 - 0x30003000300030L;
        long spre = second2 + 0x46004600460046L | sval;
        if (((fpre | spre) & 0xFF80FF80FF80FF80L) != 0L) {
            return -1;
        }
        return (int)(sval * 281475406208040961L >>> 48) + (int)(fval * 281475406208040961L >>> 48) * 10000;
    }

    public static int tryToParseEightDigitsUtf8(byte[] a2, int offset) {
        return FastDoubleSwar.tryToParseEightDigitsUtf8(FastDoubleSwar.readLongFromByteArrayLittleEndian(a2, offset));
    }

    public static int tryToParseEightDigitsUtf8(long chunk) {
        long val = chunk - 0x3030303030303030L;
        long predicate = (chunk + 0x4646464646464646L | val) & 0x8080808080808080L;
        if (predicate != 0L) {
            return -1;
        }
        val = val * 2561L >>> 8;
        val = (val & 0xFF000000FFL) * 4294967296000100L + (val >>> 16 & 0xFF000000FFL) * 42949672960001L >>> 32;
        return (int)val;
    }

    public static long tryToParseEightHexDigitsUtf16(char[] a2, int offset) {
        long first2 = (long)a2[offset] << 48 | (long)a2[offset + 1] << 32 | (long)a2[offset + 2] << 16 | (long)a2[offset + 3];
        long second2 = (long)a2[offset + 4] << 48 | (long)a2[offset + 5] << 32 | (long)a2[offset + 6] << 16 | (long)a2[offset + 7];
        return FastDoubleSwar.tryToParseEightHexDigitsUtf16(first2, second2);
    }

    public static long tryToParseEightHexDigitsUtf16(long first2, long second2) {
        long lfirst = FastDoubleSwar.tryToParseFourHexDigitsUtf16(first2);
        long lsecond = FastDoubleSwar.tryToParseFourHexDigitsUtf16(second2);
        return lfirst << 16 | lsecond;
    }

    public static long tryToParseEightHexDigitsUtf8(byte[] a2, int offset) {
        return FastDoubleSwar.tryToParseEightHexDigitsUtf8(FastDoubleSwar.readLongFromByteArrayBigEndian(a2, offset));
    }

    public static long tryToParseEightHexDigitsUtf8(long chunk) {
        long vec = chunk - 0x3030303030303030L;
        long gt_09 = vec + 0x7676767676767676L;
        long ge_30 = vec + 0x4F4F4F4F4F4F4F4FL;
        long le_37 = 0x3737373737373737L + (vec ^ 0x7F7F7F7F7F7F7F7FL);
        if ((gt_09 &= 0x8080808080808080L) != ((ge_30 &= 0x8080808080808080L) & le_37)) {
            return -1L;
        }
        long gt_09mask = (gt_09 >>> 7) * 255L;
        long v = vec & (gt_09mask ^ 0xFFFFFFFFFFFFFFFFL) | vec - (0x2727272727272727L & gt_09mask);
        long v2 = v | v >>> 4;
        long v3 = v2 & 0xFF00FF00FF00FFL;
        long v4 = v3 | v3 >>> 8;
        long v5 = v4 >>> 16 & 0xFFFF0000L | v4 & 0xFFFFL;
        return v5;
    }

    public static long tryToParseFourHexDigitsUtf16(long chunk) {
        long vec = chunk - 0x30003000300030L;
        long gt_09 = vec + 0x7FF67FF67FF67FF6L;
        long ge_30 = vec + 0x7FCF7FCF7FCF7FCFL;
        long le_37 = 0x37003700370037L + (vec ^ 0x7FFF7FFF7FFF7FFFL);
        if ((gt_09 &= 0x8000800080008000L) != ((ge_30 &= 0x8000800080008000L) & le_37)) {
            return -1L;
        }
        long gt_09mask = (gt_09 >>> 15) * 65535L;
        long v = vec & (gt_09mask ^ 0xFFFFFFFFFFFFFFFFL) | vec - (0x27002700270027L & gt_09mask);
        long v2 = v | v >>> 12;
        long v5 = (v2 | v2 >>> 24) & 0xFFFFL;
        return v5;
    }

    public static long readLongFromByteArrayLittleEndian(byte[] a2, int offset) {
        return ((long)a2[offset + 7] & 0xFFL) << 56 | ((long)a2[offset + 6] & 0xFFL) << 48 | ((long)a2[offset + 5] & 0xFFL) << 40 | ((long)a2[offset + 4] & 0xFFL) << 32 | ((long)a2[offset + 3] & 0xFFL) << 24 | ((long)a2[offset + 2] & 0xFFL) << 16 | ((long)a2[offset + 1] & 0xFFL) << 8 | (long)a2[offset] & 0xFFL;
    }

    public static long readLongFromByteArrayBigEndian(byte[] a2, int offset) {
        return ((long)a2[offset] & 0xFFL) << 56 | ((long)a2[offset + 1] & 0xFFL) << 48 | ((long)a2[offset + 2] & 0xFFL) << 40 | ((long)a2[offset + 3] & 0xFFL) << 32 | ((long)a2[offset + 4] & 0xFFL) << 24 | ((long)a2[offset + 5] & 0xFFL) << 16 | ((long)a2[offset + 6] & 0xFFL) << 8 | (long)a2[offset + 7] & 0xFFL;
    }
}

