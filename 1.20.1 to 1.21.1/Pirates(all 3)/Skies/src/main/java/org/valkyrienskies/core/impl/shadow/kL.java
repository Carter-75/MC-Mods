/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.kI;

public final class kL
extends kI<String> {
    private static final long a = -7032449491269434877L;
    private static kL b;
    private static int c = 16;
    private static final int d = 32768;

    private static int e(int n2) {
        return 32768 >>> n2;
    }

    @Override
    public final int a() {
        return 16;
    }

    private static int a(String string) {
        if (string != null) {
            return string.length() << 4;
        }
        return 0;
    }

    private static int a(String string, int n2, int n3, String string2, int n4, int n5) {
        boolean bl = true;
        if (n2 % 16 != 0 || n4 % 16 != 0 || n3 % 16 != 0 || n5 % 16 != 0) {
            throw new IllegalArgumentException("The offsets and lengths must be at Character boundaries");
        }
        n3 = (n2 /= 16) + n3 / 16;
        n5 = (n4 /= 16) + n5 / 16;
        int n6 = Math.max(n3, n5);
        for (int i2 = 0; i2 < n6; ++i2) {
            int n7 = n2 + i2;
            int n8 = n4 + i2;
            if ((n7 = n7 >= n3 ? 0 : (int)string.charAt(n7)) != (n8 = string2 == null || n8 >= n5 ? 0 : (int)string2.charAt(n8))) {
                int n9 = n7 ^ n8;
                return (i2 << 4) + Integer.numberOfLeadingZeros(n9) - 16;
            }
            if (n7 == 0) continue;
            bl = false;
        }
        if (bl) {
            return -1;
        }
        return -2;
    }

    private static boolean a(String string, int n2, int n3) {
        if (string == null || n2 >= n3) {
            return false;
        }
        n3 = n2 / 16;
        int n4 = n2 %= 16;
        return (string.charAt(n3) & 32768 >>> n4) != 0;
    }

    private static boolean a(String string, int n2, int n3, String string2) {
        if (n2 % 16 != 0 || n3 % 16 != 0) {
            throw new IllegalArgumentException("Cannot determine prefix outside of Character boundaries");
        }
        string = string.substring(n2 / 16, n3 / 16);
        return string2.startsWith(string);
    }

    @Override
    public final /* synthetic */ boolean a(Object object, int n2, int n3, Object object2) {
        object2 = (String)object2;
        object = (String)object;
        if (n2 % 16 != 0 || n3 % 16 != 0) {
            throw new IllegalArgumentException("Cannot determine prefix outside of Character boundaries");
        }
        object = ((String)object).substring(n2 / 16, n3 / 16);
        return ((String)object2).startsWith((String)object);
    }

    @Override
    public final /* synthetic */ int a(Object object, int n2, int n3, Object object2, int n4, int n5) {
        n4 = 0;
        object2 = (String)object2;
        object = (String)object;
        boolean bl = true;
        if (n2 % 16 != 0 || n4 % 16 != 0 || n3 % 16 != 0 || n5 % 16 != 0) {
            throw new IllegalArgumentException("The offsets and lengths must be at Character boundaries");
        }
        n3 = (n2 /= 16) + n3 / 16;
        n5 = (n4 /= 16) + n5 / 16;
        int n6 = Math.max(n3, n5);
        for (int i2 = 0; i2 < n6; ++i2) {
            int n7 = n2 + i2;
            int n8 = n4 + i2;
            if ((n7 = n7 >= n3 ? 0 : (int)((String)object).charAt(n7)) != (n8 = object2 == null || n8 >= n5 ? 0 : (int)((String)object2).charAt(n8))) {
                int n9 = n7 ^ n8;
                return (i2 << 4) + Integer.numberOfLeadingZeros(n9) - 16;
            }
            if (n7 == 0) continue;
            bl = false;
        }
        if (bl) {
            return -1;
        }
        return -2;
    }

    @Override
    public final /* synthetic */ boolean a(Object object, int n2, int n3) {
        if ((object = (String)object) == null || n2 >= n3) {
            return false;
        }
        n3 = n2 / 16;
        int n4 = n2 %= 16;
        return (((String)object).charAt(n3) & 32768 >>> n4) != 0;
    }

    @Override
    public final /* synthetic */ int a(Object object) {
        if ((object = (String)object) != null) {
            return ((String)object).length() << 4;
        }
        return 0;
    }

    static {
        new kL();
    }
}

