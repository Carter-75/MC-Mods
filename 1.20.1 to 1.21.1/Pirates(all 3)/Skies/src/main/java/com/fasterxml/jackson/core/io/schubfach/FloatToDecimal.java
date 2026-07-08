/*
 * Decompiled with CFR 0.152.
 */
package com.fasterxml.jackson.core.io.schubfach;

import com.fasterxml.jackson.core.io.schubfach.MathUtils;
import java.io.IOException;

public final class FloatToDecimal {
    static final int P = 24;
    private static final int W = 8;
    static final int Q_MIN = -149;
    static final int Q_MAX = 104;
    static final int E_MIN = -44;
    static final int E_MAX = 39;
    static final int C_TINY = 8;
    static final int K_MIN = -45;
    static final int K_MAX = 31;
    static final int H = 9;
    private static final int C_MIN = 0x800000;
    private static final int BQ_MASK = 255;
    private static final int T_MASK = 0x7FFFFF;
    private static final long MASK_32 = 0xFFFFFFFFL;
    private static final int MASK_28 = 0xFFFFFFF;
    private static final int NON_SPECIAL = 0;
    private static final int PLUS_ZERO = 1;
    private static final int MINUS_ZERO = 2;
    private static final int PLUS_INF = 3;
    private static final int MINUS_INF = 4;
    private static final int NAN = 5;
    private static final ThreadLocal<FloatToDecimal> threadLocal = ThreadLocal.withInitial(FloatToDecimal::new);
    public final int MAX_CHARS = 15;
    private final byte[] bytes = new byte[15];
    private final char[] chars = new char[15];
    private int index;

    private FloatToDecimal() {
    }

    public static String toString(float v) {
        return FloatToDecimal.threadLocalInstance().toDecimalString(v);
    }

    public static Appendable appendTo(float v, Appendable app) throws IOException {
        return FloatToDecimal.threadLocalInstance().appendDecimalTo(v, app);
    }

    private static FloatToDecimal threadLocalInstance() {
        return threadLocal.get();
    }

    private String toDecimalString(float v) {
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

    private Appendable appendDecimalTo(float v, Appendable app) throws IOException {
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

    private int toDecimal(float v) {
        int bits = Float.floatToRawIntBits(v);
        int t = bits & 0x7FFFFF;
        int bq = bits >>> 23 & 0xFF;
        if (bq < 255) {
            this.index = -1;
            if (bits < 0) {
                this.append(45);
            }
            if (bq != 0) {
                int f2;
                int mq = 150 - bq;
                int c2 = 0x800000 | t;
                if (0 < mq & mq < 24 && (f2 = c2 >> mq) << mq == c2) {
                    return this.toChars(f2, 0);
                }
                return this.toDecimal(-mq, c2, 0);
            }
            if (t != 0) {
                return t < 8 ? this.toDecimal(-149, 10 * t, -1) : this.toDecimal(-149, t, 0);
            }
            return bits == 0 ? 1 : 2;
        }
        if (t != 0) {
            return 5;
        }
        return bits > 0 ? 3 : 4;
    }

    private int toDecimal(int q, int c2, int dk) {
        boolean win;
        int k2;
        long cbl;
        int out = c2 & 1;
        long cb = c2 << 2;
        long cbr = cb + 2L;
        if (c2 != 0x800000 | q == -149) {
            cbl = cb - 2L;
            k2 = MathUtils.flog10pow2(q);
        } else {
            cbl = cb - 1L;
            k2 = MathUtils.flog10threeQuartersPow2(q);
        }
        int h2 = q + MathUtils.flog2pow10(-k2) + 33;
        long g2 = MathUtils.g1(k2) + 1L;
        int vb = FloatToDecimal.rop(g2, cb << h2);
        int vbl = FloatToDecimal.rop(g2, cbl << h2);
        int vbr = FloatToDecimal.rop(g2, cbr << h2);
        int s = vb >> 2;
        if (s >= 100) {
            boolean wpin;
            int sp10 = 10 * (int)((long)s * 0x66666667L >>> 34);
            int tp10 = sp10 + 10;
            boolean upin = vbl + out <= sp10 << 2;
            boolean bl = wpin = (tp10 << 2) + out <= vbr;
            if (upin != wpin) {
                return this.toChars(upin ? sp10 : tp10, k2);
            }
        }
        int t = s + 1;
        boolean uin = vbl + out <= s << 2;
        boolean bl = win = (t << 2) + out <= vbr;
        if (uin != win) {
            return this.toChars(uin ? s : t, k2 + dk);
        }
        int cmp = vb - (s + t << 1);
        return this.toChars(cmp < 0 || cmp == 0 && (s & 1) == 0 ? s : t, k2 + dk);
    }

    private static int rop(long g2, long cp) {
        long x1 = MathUtils.multiplyHigh(g2, cp);
        long vbp = x1 >>> 31;
        return (int)(vbp | (x1 & 0xFFFFFFFFL) + 0xFFFFFFFFL >>> 32);
    }

    private int toChars(int f2, int e2) {
        int len = MathUtils.flog10pow2(32 - Integer.numberOfLeadingZeros(f2));
        if ((long)f2 >= MathUtils.pow10(len)) {
            ++len;
        }
        f2 = (int)((long)f2 * MathUtils.pow10(9 - len));
        int h2 = (int)((long)f2 * 1441151881L >>> 57);
        int l2 = f2 - 100000000 * h2;
        if (0 < (e2 += len) && e2 <= 7) {
            return this.toChars1(h2, l2, e2);
        }
        if (-3 < e2 && e2 <= 0) {
            return this.toChars2(h2, l2, e2);
        }
        return this.toChars3(h2, l2, e2);
    }

    private int toChars1(int h2, int l2, int e2) {
        int t;
        int i2;
        this.appendDigit(h2);
        int y = this.y(l2);
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
        this.removeTrailingZeroes();
        return 0;
    }

    private int toChars2(int h2, int l2, int e2) {
        this.appendDigit(0);
        this.append(46);
        while (e2 < 0) {
            this.appendDigit(0);
            ++e2;
        }
        this.appendDigit(h2);
        this.append8Digits(l2);
        this.removeTrailingZeroes();
        return 0;
    }

    private int toChars3(int h2, int l2, int e2) {
        this.appendDigit(h2);
        this.append(46);
        this.append8Digits(l2);
        this.removeTrailingZeroes();
        this.exponent(e2 - 1);
        return 0;
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
        this.append(69);
        if (e2 < 0) {
            this.append(45);
            e2 = -e2;
        }
        if (e2 < 10) {
            this.appendDigit(e2);
            return;
        }
        int d2 = e2 * 103 >>> 10;
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

