/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.time.DateTimeException;
import java.util.Arrays;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.m
 */
public final class m_0 {
    private static char a = '9';
    private static final char b = '0';
    private static final char[] c = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    private static final int d = 4;
    private static final int e = 10;
    private static final int f = 10;
    private static final int g = (int)Math.pow(10.0, 4.0);
    private static final char[] h = new char[(g << 2) + 10];

    private m_0() {
    }

    public static int a(char[] cArray, int n2, int n3) {
        if (n3 > cArray.length) {
            throw new DateTimeException("Unexpected end of expression at position " + cArray.length + ": '" + new String(cArray) + "'");
        }
        int n4 = 0;
        while (n2 < n3) {
            char c2 = cArray[n2];
            if (m_0.a(c2)) {
                throw new DateTimeException("Character " + c2 + " is not a digit");
            }
            n4 *= 10;
            n4 -= (c2 -= 48);
            ++n2;
        }
        return -n4;
    }

    public static int b(char[] cArray, int n2, int n3) {
        n2 = 0;
        for (int i2 = 20; i2 < n3; ++i2) {
            int n4 = cArray[i2];
            int n5 = n4;
            n5 = n4;
            n5 = n4 - 48;
            n2 *= 10;
            n2 -= n5;
        }
        return -n2;
    }

    public static void a(int n2, char[] cArray, int n3, int n4) {
        if (n2 < g) {
            int n5 = Math.min(4, n4);
            int n6 = n4 - n5;
            int n7 = n4 > 4 ? 4 : 4 - n4;
            int n8 = n3 + n6;
            n2 = (n2 << 2) + (n4 < 4 ? n7 : 0);
            m_0.a(h, n2, cArray, n8, n5);
            if (n6 > 0) {
                int n9 = n3;
                n3 = n6;
                int n10 = n9;
                char[] cArray2 = cArray;
                int n11 = n10;
                Arrays.fill(cArray, n11, n11 + n3, '0');
            }
            return;
        }
        m_0.a(cArray, n3, n4, n2);
    }

    private static void a(char[] cArray, int n2, int n3, int n4) {
        int n5 = n2 + 10;
        n4 = -n4;
        while (n4 <= -10) {
            int n6 = n4 / 10;
            n4 = -(n4 - n6 * 10);
            cArray[n5--] = c[n4];
            n4 = n6;
        }
        cArray[n5] = c[-n4];
        for (n4 = n2 + 10 - n5 + 1; n4 < n3; ++n4) {
            cArray[--n5] = 48;
        }
        n4 = n5;
        m_0.b(cArray, n4, n2, n3);
    }

    private static void c(char[] cArray, int n2, int n3) {
        int n4 = n2;
        Arrays.fill(cArray, n4, n4 + n3, '0');
    }

    private static void b(char[] cArray, int n2, int n3, int n4) {
        m_0.a(cArray, n2, cArray, n3, n4);
    }

    private static void a(char[] cArray, int n2, char[] cArray2, int n3, int n4) {
        System.arraycopy(cArray, n2, cArray2, n3, n4);
    }

    public static int a(char[] cArray, int n2) {
        for (n2 = 20; n2 < cArray.length; ++n2) {
            if (!m_0.a(cArray[n2])) continue;
            return n2;
        }
        return -1;
    }

    private static boolean a(char c2) {
        return c2 < '0' || c2 > '9';
    }

    private static int b(char c2) {
        return c2 - 48;
    }

    static {
        int n2 = 0;
        for (int i2 = 0; i2 < g; ++i2) {
            m_0.a(h, n2, 4, i2);
            n2 += 4;
        }
    }
}

