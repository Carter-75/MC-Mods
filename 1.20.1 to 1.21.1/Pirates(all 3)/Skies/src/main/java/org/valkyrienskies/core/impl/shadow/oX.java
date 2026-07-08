/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Locale;
import org.valkyrienskies.core.impl.shadow.pu_0;
import org.valkyrienskies.core.impl.shadow.pv_0;
import org.valkyrienskies.core.impl.shadow.pw_0;
import org.valkyrienskies.core.impl.shadow.px_0;

public class oX
extends IllegalStateException
implements pv_0 {
    private static final long a = -6024911025449780478L;
    private final pu_0 b = new pu_0(this);

    public oX(pw_0 pw_02, Object ... objectArray) {
        this.b.a(pw_02, objectArray);
    }

    public oX(Throwable throwable, px_0 px_02, Object ... objectArray) {
        super(throwable);
        this.b.a(px_02, objectArray);
    }

    public oX() {
        this(px_0.ILLEGAL_STATE, new Object[0]);
    }

    public final pu_0 a() {
        return this.b;
    }

    public String getMessage() {
        pu_0 pu_02 = this.b;
        pu_0 pu_03 = pu_02;
        Locale locale = Locale.US;
        pu_03 = pu_02;
        return pu_02.a(locale, ": ");
    }

    public String getLocalizedMessage() {
        pu_0 pu_02 = this.b;
        pu_0 pu_03 = pu_02;
        Locale locale = Locale.getDefault();
        pu_03 = pu_02;
        return pu_02.a(locale, ": ");
    }
}

