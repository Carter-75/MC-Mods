/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.dt
 */
public class dt_2
implements Serializable {
    private static final long a = -8832409930574867162L;
    private final Pattern[] b;

    public dt_2(String string) {
        this(string, true);
    }

    public dt_2(String string, boolean bl) {
        this(new String[]{string}, bl);
    }

    public dt_2(String[] stringArray) {
        this(stringArray, true);
    }

    public dt_2(String[] stringArray, boolean bl) {
        if (stringArray == null || stringArray.length == 0) {
            throw new IllegalArgumentException("Regular expressions are missing");
        }
        this.b = new Pattern[stringArray.length];
        int n2 = bl ? 0 : 2;
        for (int i2 = 0; i2 < stringArray.length; ++i2) {
            if (stringArray[i2] == null || stringArray[i2].length() == 0) {
                throw new IllegalArgumentException("Regular expression[" + i2 + "] is missing");
            }
            this.b[i2] = Pattern.compile(stringArray[i2], n2);
        }
    }

    public boolean a(String string) {
        if (string == null) {
            return false;
        }
        for (int i2 = 0; i2 < this.b.length; ++i2) {
            if (!this.b[i2].matcher(string).matches()) continue;
            return true;
        }
        return false;
    }

    public String[] b(String string) {
        if (string == null) {
            return null;
        }
        for (int i2 = 0; i2 < this.b.length; ++i2) {
            Matcher matcher = this.b[i2].matcher(string);
            if (!matcher.matches()) continue;
            int n2 = matcher.groupCount();
            String[] stringArray = new String[n2];
            for (int i3 = 0; i3 < n2; ++i3) {
                stringArray[i3] = matcher.group(i3 + 1);
            }
            return stringArray;
        }
        return null;
    }

    public String c(String string) {
        if (string == null) {
            return null;
        }
        for (int i2 = 0; i2 < this.b.length; ++i2) {
            Matcher matcher = this.b[i2].matcher(string);
            if (!matcher.matches()) continue;
            int n2 = matcher.groupCount();
            if (n2 == 1) {
                return matcher.group(1);
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (int i3 = 0; i3 < n2; ++i3) {
                String string2 = matcher.group(i3 + 1);
                if (string2 == null) continue;
                stringBuilder.append(string2);
            }
            return stringBuilder.toString();
        }
        return null;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("RegexValidator{");
        for (int i2 = 0; i2 < this.b.length; ++i2) {
            if (i2 > 0) {
                stringBuilder.append(",");
            }
            stringBuilder.append(this.b[i2].pattern());
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

