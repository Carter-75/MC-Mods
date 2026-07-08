/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.oX;
import org.valkyrienskies.core.impl.shadow.pv_0;
import org.valkyrienskies.core.impl.shadow.px_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public final class oZ
extends oX
implements pv_0 {
    private static final long a = -6024911025449780478L;

    public oZ(String string, int n2, Class<?> clazz) {
        this.a().a(px_0.CANNOT_PARSE_AS_TYPE, string, n2, clazz.getName());
    }

    public oZ(String string, int n2) {
        this.a().a(px_0.CANNOT_PARSE, string, n2);
    }
}

