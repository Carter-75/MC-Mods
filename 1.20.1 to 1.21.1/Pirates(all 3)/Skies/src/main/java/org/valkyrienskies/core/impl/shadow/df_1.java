/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.dF
 */
public class df_1 {
    private static final char a = '0';
    private static final char b = '1';
    private static final char c = '9';
    private static final char d = '-';
    private static final char e = '+';
    private static final char f = '.';
    private static final char g = 'E';
    private static final char h = 'e';

    public static boolean a(String string) {
        if (string == null || string.equals("")) {
            return false;
        }
        int n2 = 0;
        if (string.charAt(0) == '-' || string.charAt(0) == '+') {
            if (string.length() == 1) {
                return false;
            }
            n2 = 1;
        }
        while (n2 < string.length()) {
            char c2 = string.charAt(n2);
            if (c2 < '0' || c2 > '9') {
                return false;
            }
            ++n2;
        }
        return true;
    }

    public static boolean b(String string) {
        return "true".equals(string) || "false".equals(string);
    }

    /*
     * Handled impossible loop by adding 'first' condition
     * Enabled aggressive block sorting
     */
    public static boolean c(String string) {
        char c2;
        if (string == null || string.equals("")) {
            return false;
        }
        int n2 = 0;
        int n3 = string.length();
        if (string.charAt(0) == '-' || string.charAt(0) == '+') {
            if (string.length() == 1) {
                return false;
            }
            n2 = 1;
        }
        if ((c2 = string.charAt(n2++)) == '0') {
            if (n2 < n3 && (c2 = string.charAt(n2++)) != '.' && c2 != 'E' && c2 != 'e') {
                return false;
            }
        } else if ('1' <= c2 && c2 <= '9') {
            while (n2 < n3 && '0' <= c2 && c2 <= '9') {
                c2 = string.charAt(n2++);
            }
        } else {
            return false;
        }
        if (c2 == '.') {
            if (n2 >= n3) {
                return false;
            }
            do {
                c2 = string.charAt(n2++);
            } while (n2 < n3 && '0' <= c2 && c2 <= '9');
        }
        if (c2 == 'E' || c2 == 'e') {
            if (n2 >= n3) {
                return false;
            }
            boolean bl = true;
            do {
                if (bl && !(bl = false)) {
                    if ((c2 = string.charAt(n2++)) != '+' && c2 != '-') continue;
                    if (n2 >= n3) {
                        return false;
                    }
                }
                c2 = string.charAt(n2++);
            } while (n2 < n3 && '0' <= c2 && c2 <= '9');
        }
        return n2 >= n3 && '0' <= c2 && c2 <= '9';
    }
}

