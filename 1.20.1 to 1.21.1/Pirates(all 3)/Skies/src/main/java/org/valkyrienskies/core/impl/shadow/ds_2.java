/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import org.valkyrienskies.core.impl.shadow.dt_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.ds
 */
public class ds_2
implements Serializable {
    private static final int a = 255;
    private static final int b = 65535;
    private static final int c = 16;
    private static final long d = -919201640201914789L;
    private static final String e = "^(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})$";
    private static final int f = 8;
    private static final int g = 4;
    private static final ds_2 h = new ds_2();
    private final dt_2 i = new dt_2("^(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})$");

    public static ds_2 a() {
        return h;
    }

    public boolean a(String string) {
        return this.b(string) || this.c(string);
    }

    public boolean b(String stringArray) {
        if ((stringArray = this.i.b((String)stringArray)) == null) {
            return false;
        }
        for (String string : stringArray) {
            int n2;
            if (string == null || string.length() == 0) {
                return false;
            }
            try {
                n2 = Integer.parseInt(string);
            }
            catch (NumberFormatException numberFormatException) {
                return false;
            }
            if (n2 > 255) {
                return false;
            }
            if (string.length() <= 1 || !string.startsWith("0")) continue;
            return false;
        }
        return true;
    }

    public boolean c(String string) {
        boolean bl = string.contains("::");
        if (bl && string.indexOf("::") != string.lastIndexOf("::")) {
            return false;
        }
        if (string.startsWith(":") && !string.startsWith("::") || string.endsWith(":") && !string.endsWith("::")) {
            return false;
        }
        String[] stringArray = string.split(":");
        if (bl) {
            ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(stringArray));
            if (string.endsWith("::")) {
                arrayList.add("");
            } else if (string.startsWith("::") && !arrayList.isEmpty()) {
                arrayList.remove(0);
            }
            ArrayList<String> arrayList2 = arrayList;
            stringArray = arrayList2.toArray(new String[arrayList2.size()]);
        }
        if (stringArray.length > 8) {
            return false;
        }
        int n2 = 0;
        int n3 = 0;
        for (int i2 = 0; i2 < stringArray.length; ++i2) {
            String string2 = stringArray[i2];
            if (string2.length() == 0) {
                if (++n3 > 1) {
                    return false;
                }
            } else {
                int n4;
                n3 = 0;
                if (i2 == stringArray.length - 1 && string2.contains(".")) {
                    if (!this.b(string2)) {
                        return false;
                    }
                    n2 += 2;
                    continue;
                }
                if (string2.length() > 4) {
                    return false;
                }
                try {
                    n4 = Integer.parseInt(string2, 16);
                }
                catch (NumberFormatException numberFormatException) {
                    return false;
                }
                if (n4 < 0 || n4 > 65535) {
                    return false;
                }
            }
            ++n2;
        }
        return n2 <= 8 && (n2 >= 8 || bl);
    }
}

