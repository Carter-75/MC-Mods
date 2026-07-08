/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.regex.Pattern;
import org.valkyrienskies.core.impl.shadow.ci_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.cK
 */
public class ck_1
implements ci_2 {
    private final String a;
    private final Pattern b;

    public ck_1(String string, String string2) {
        this.a = string;
        this.b = Pattern.compile(string2);
    }

    @Override
    public boolean a(String string) {
        return this.b.matcher(string).matches();
    }

    @Override
    public String a() {
        return this.a;
    }

    @Override
    public String b() {
        return this.b.pattern();
    }
}

