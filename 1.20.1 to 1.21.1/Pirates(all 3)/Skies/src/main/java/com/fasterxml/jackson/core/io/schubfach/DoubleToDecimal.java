/*
 * Decompiled with CFR 0.152.
 */
package com.fasterxml.jackson.core.io.schubfach;

import com.fasterxml.jackson.core.io.schubfach.MathUtils;
import java.io.IOException;

public final class DoubleToDecimal {
    static final int P = 53;
    private static final int W = 11;
    static final int Q_MIN = -1074;
    static final int Q_MAX = 971;
    static final int E_MIN = -323;
    static final int E_MAX = 309;
    static final long C_TINY = 3L;
    static final int K_MIN = -324;
    static final int K_MAX = 292;
    static final int H = 17;
    private static final long C_MIN = 0x10000000000000L;
    private static final int BQ_MASK = 2047;
    private static final long T_MASK = 0xFFFFFFFFFFFFFL;
    private static final long MASK_63 = Long.MAX_VALUE;
    private static final int MASK_28 = 0xFFFFFFF;
    private static final int NON_SPECIAL = 0;
    private static final int PLUS_ZERO = 1;
    private static final int MINUS_ZERO = 2;
    private static final int PLUS_INF = 3;
    private static final int MINUS_INF = 4;
    private static final int NAN = 5;
    private static final ThreadLocal<DoubleToDecimal> threadLocal = ThreadLocal.withInitial(DoubleToDecimal::new);
    public final int MAX_CHARS = 24;
    private final byte[] bytes = new byte[24];
    private final char[] chars = new char[24];
    private int index;

    private DoubleToDecimal() {
    }

    public static String toString(double v) {
        return DoubleToDecimal.threadLocalInstance().toDecimalString(v);
    }

    public static Appendable appendTo(double v, Appendable app) throws IOException {
        return DoubleToDecimal.threadLocalInstance().appendDecimalTo(v, app);
    }

    private static DoubleToDecimal threadLocalInstance() {
        return threadLocal.get();
    }

    private String toDecimalString(double v) {
        switch (this.toDecimal(v)) {
            case 0: {
                return this.charsToString();
            }
            case 1: {
                return "0.0";
            }
            case 2: {
                return "-0.0";
            }
            case 3: {
                return "Infinity";
            }
            case 4: {
                return "-Infinity";
            }
        }
        return "NaN";
    }

    private Appendable appendDecimalTo(double v, Appendable app) throws IOException {
        switch (this.toDecimal(v)) {
            case 0: {
                int i2;
                for (i2 = 0; i2 <= this.index; ++i2) {
                    this.chars[i2] = (char)this.bytes[i2];
                }
                if (app instanceof StringBuilder) {
                    return ((StringBuilder)app).append(this.chars, 0, this.index + 1);
                }
                if (app instanceof StringBuffer) {
                    return ((StringBuffer)app).append(this.chars, 0, this.index + 1);
                }
                for (i2 = 0; i2 <= this.index; ++i2) {
                    app.append(this.chars[i2]);
                }
                return app;
            }
            case 1: {
                return app.append("0.0");
            }
            case 2: {
                return app.append("-0.0");
            }
            case 3: {
                return app.append("Infinity");
            }
            case 4: {
                return app.append("-Infinity");
            }
        }
        return app.append("NaN");
    }

    private int toDecimal(double v) {
        long bits = Double.doubleToRawLongBits(v);
        long t = bits & 0xFFFFFFFFFFFFFL;
        int bq = (int)(bits >>> 52) & 0x7FF;
        if (bq < 2047) {
            this.index = -1;
            if (bits < 0L) {
                this.append(45);
            }
            if (bq != 0) {
                long f2;
                int mq = 1075 - bq;
                long c2 = 0x10000000000000L | t;
                if (0 < mq & mq < 53 && (f2 = c2 >> mq) << mq == c2) {
                    return this.toChars(f2, 0);
                }
                return this.toDecimal(-mq, c2, 0);
            }
            if (t != 0L) {
                return t < 3L ? this.toDecimal(-1074, 10L * t, -1) : this.toDecimal(-1074, t, 0);
            }
            return bits == 0L ? 1 : 2;
        }
        if (t != 0L) {
            return 5;
        }
        return bits > 0L ? 3 : 4;
    }

    private int toDecimal(int q, long c2, int dk) {
        boolean win;
        int k2;
        long cbl;
        int out = (int)c2 & 1;
        long cb = c2 << 2;
        long cbr = cb + 2L;
        if (c2 != 0x10000000000000L | q == -1074) {
            cbl = cb - 2L;
            k2 = MathUtils.flog10pow2(q);
        } else {
            cbl = cb - 1L;
            k2 = MathUtils.flog10threeQuartersPow2(q);
        }
        int h2 = q + MathUtils.flog2pow10(-k2) + 2;
        long g1 = MathUtils.g1(k2);
        long g0 = MathUtils.g0(k2);
        long vb = DoubleToDecimal.rop(g1, g0, cb << h2);
        long vbl = DoubleToDecimal.rop(g1, g0, cbl << h2);
        long vbr = DoubleToDecimal.rop(g1, g0, cbr << h2);
        long s = vb >> 2;
        if (s >= 100L) {
            boolean wpin;
            long sp10 = 10L * MathUtils.multiplyHigh(s, 1844674407370955168L);
            long tp10 = sp10 + 10L;
            boolean upin = vbl + (long)out <= sp10 << 2;
            boolean bl = wpin = (tp10 << 2) + (long)out <= vbr;
            if (upin != wpin) {
                return this.toChars(upin ? sp10 : tp10, k2);
            }
        }
        long t = s + 1L;
        boolean uin = vbl + (long)out <= s << 2;
        boolean bl = win = (t << 2) + (long)out <= vbr;
        if (uin != win) {
            return this.toChars(uin ? s : t, k2 + dk);
        }
        long cmp = vb - (s + t << 1);
        return this.toChars(cmp < 0L || cmp == 0L && (s & 1L) == 0L ? s : t, k2 + dk);
    }

    private static long rop(long g1, long g0, long cp) {
        long x1 = MathUtils.multiplyHigh(g0, cp);
        long y0 = g1 * cp;
        long y1 = MathUtils.multiplyHigh(g1, cp);
        long z = (y0 >>> 1) + x1;
        long vbp = y1 + (z >>> 63);
        return vbp | (z & Long.MAX_VALUE) + Long.MAX_VALUE >>> 63;
    }

    private int toChars(long f2, int e2) {
        int len = MathUtils.flog10pow2(64 - Long.numberOfLeadingZeros(f2));
        if (f2 >= MathUtils.pow10(len)) {
            ++len;
        }
        long hm = MathUtils.multiplyHigh(f2 *= MathUtils.pow10(17 - len), 193428131138340668L) >>> 20;
        int l2 = (int)(f2 - 100000000L * hm);
        int h2 = (int)(hm * 1441151881L >>> 57);
        int m2 = (int)(hm - (long)(100000000 * h2));
        if (0 < (e2 += len) && e2 <= 7) {
            return this.toChars1(h2, m2, l2, e2);
        }
        if (-3 < e2 && e2 <= 0) {
            return this.toChars2(h2, m2, l2, e2);
        }
        return this.toChars3(h2, m2, l2, e2);
    }

    private int toChars1(int h2, int m2, int l2, int e2) {
        int t;
        int i2;
        this.appendDigit(h2);
        int y = this.y(m2);
        for (i2 = 1; i2 < e2; ++i2) {
            t = 10 * y;
            this.appendDigit(t >>> 28);
            y = t & 0xFFFFFFF;
        }
        this.append(46);
        while (i2 <= 8) {
            t = 10 * y;
            this.appendDigit(t >>> 28);
            y = t & 0xFFFFFFF;
            ++i2;
        }
        this.lowDigits(l2);
        return 0;
    }

    private int toChars2(int h2, int m2, int l2, int e2) {
        this.appendDigit(0);
        this.append(46);
        while (e2 < 0) {
            this.appendDigit(0);
            ++e2;
        }
        this.appendDigit(h2);
        this.append8Digits(m2);
        this.lowDigits(l2);
        return 0;
    }

    private int toChars3(int h2, int m2, int l2, int e2) {
        this.appendDigit(h2);
        this.append(46);
        this.append8Digits(m2);
        this.lowDigits(l2);
        this.exponent(e2 - 1);
        return 0;
    }

    private void lowDigits(int l2) {
        if (l2 != 0) {
            this.append8Digits(l2);
        }
        this.removeTrailingZeroes();
    }

    private void append8Digits(int m2) {
        int y = this.y(m2);
        for (int i2 = 0; i2 < 8; ++i2) {
            int t = 10 * y;
            this.appendDigit(t >>> 28);
            y = t & 0xFFFFFFF;
        }
    }

    private void removeTrailingZeroes() {
        while (this.bytes[this.index] == 48) {
            --this.index;
        }
        if (this.bytes[this.index] == 46) {
            ++this.index;
        }
    }

    private int y(int a2) {
        return (int)(MathUtils.multiplyHigh((long)(a2 + 1) << 28, 193428131138340668L) >>> 20) - 1;
    }

    private void exponent(int e2) {
        int d2;
        this.append(69);
        if (e2 < 0) {
            this.append(45);
            e2 = -e2;
        }
        if (e2 < 10) {
            this.appendDigit(e2);
            return;
        }
        if (e2 >= 100) {
            d2 = e2 * 1311 >>> 17;
            this.appendDigit(d2);
            e2 -= 100 * d2;
        }
        d2 = e2 * 103 >>> 10;
        this.appendDigit(d2);
        this.appendDigit(e2 - 10 * d2);
    }

    private void append(int c2) {
        this.bytes[++this.index] = (byte)c2;
    }

    private void appendDigit(int d2) {
        this.bytes[++this.index] = (byte)(48 + d2);
    }

    private String charsToString() {
        return new String(this.bytes, 0, 0, this.index + 1);
    }
}

