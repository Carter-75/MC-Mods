/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.oW;
import org.valkyrienskies.core.impl.shadow.pw_0;
import org.valkyrienskies.core.impl.shadow.px_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.pm
 */
public final class pm_0
extends oW {
    private static final long c = 4330003017885151975L;
    private final Number d;
    private final boolean e;

    public pm_0(Number number, Number number2, boolean bl) {
        this(bl ? px_0.NUMBER_TOO_LARGE : px_0.NUMBER_TOO_LARGE_BOUND_EXCLUDED, number, number2, bl);
    }

    public pm_0(px_0 px_02, Number number, Number number2, boolean bl) {
        super((pw_0)px_02, number, number2);
        this.d = number2;
        this.e = bl;
    }

    private boolean b() {
        return this.e;
    }

    private Number c() {
        return this.d;
    }
}

