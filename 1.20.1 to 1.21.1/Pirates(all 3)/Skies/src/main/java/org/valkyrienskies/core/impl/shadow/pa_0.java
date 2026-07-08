/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Locale;
import org.valkyrienskies.core.impl.shadow.pu_0;
import org.valkyrienskies.core.impl.shadow.pv_0;
import org.valkyrienskies.core.impl.shadow.pw_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.pa
 */
public final class pa_0
extends RuntimeException
implements pv_0 {
    private static final long a = 20120926L;
    private final pu_0 b = new pu_0(this);

    private pa_0(pw_0 pw_02, Object ... objectArray) {
        this.b.a(pw_02, objectArray);
    }

    public final pu_0 a() {
        return this.b;
    }

    public final String getMessage() {
        pu_0 pu_02 = this.b;
        pu_0 pu_03 = pu_02;
        Locale locale = Locale.US;
        pu_03 = pu_02;
        return pu_02.a(locale, ": ");
    }

    public final String getLocalizedMessage() {
        pu_0 pu_02 = this.b;
        pu_0 pu_03 = pu_02;
        Locale locale = Locale.getDefault();
        pu_03 = pu_02;
        return pu_02.a(locale, ": ");
    }
}

