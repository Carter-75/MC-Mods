/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.text.MessageFormat;
import org.valkyrienskies.core.impl.shadow.ce_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.bY
 */
public class by_1
implements ce_2 {
    private final String a;
    private final MessageFormat b;

    private by_1(String string, MessageFormat messageFormat) {
        this.a = string;
        this.b = messageFormat;
    }

    public static ce_2 a(String string) {
        return new by_1(string, null);
    }

    public static ce_2 a(String string, MessageFormat messageFormat) {
        return new by_1(string, messageFormat);
    }

    @Override
    public String b_() {
        return this.a;
    }

    @Override
    public MessageFormat b() {
        return this.b;
    }
}

