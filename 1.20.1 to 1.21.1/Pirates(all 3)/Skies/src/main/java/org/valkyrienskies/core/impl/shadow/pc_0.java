/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.oX;
import org.valkyrienskies.core.impl.shadow.px_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.pc
 */
public class pc_0
extends oX {
    private static final long b = 4330003017885151975L;
    public final Number a;

    public pc_0(Number number) {
        this(px_0.MAX_COUNT_EXCEEDED, number, new Object[0]);
    }

    public pc_0(px_0 px_02, Number number, Object ... objectArray) {
        this.a().a(px_02, number, objectArray);
        this.a = number;
    }

    public final Number b() {
        return this.a;
    }
}

