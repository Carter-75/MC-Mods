/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Locale;
import org.valkyrienskies.core.impl.shadow.pu_0;
import org.valkyrienskies.core.impl.shadow.pv_0;
import org.valkyrienskies.core.impl.shadow.pw_0;
import org.valkyrienskies.core.impl.shadow.px_0;

public final class oU
extends ArithmeticException
implements pv_0 {
    private static final long b = -6024911025449780478L;
    public final pu_0 a = new pu_0(this);

    public oU() {
        this.a.a(px_0.ARITHMETIC_EXCEPTION, new Object[0]);
    }

    public oU(pw_0 pw_02, Object ... objectArray) {
        this.a.a(pw_02, objectArray);
    }

    public final pu_0 a() {
        return this.a;
    }

    public final String getMessage() {
        pu_0 pu_02 = this.a;
        pu_0 pu_03 = pu_02;
        Locale locale = Locale.US;
        pu_03 = pu_02;
        return pu_02.a(locale, ": ");
    }

    public final String getLocalizedMessage() {
        pu_0 pu_02 = this.a;
        pu_0 pu_03 = pu_02;
        Locale locale = Locale.getDefault();
        pu_03 = pu_02;
        return pu_02.a(locale, ": ");
    }
}

