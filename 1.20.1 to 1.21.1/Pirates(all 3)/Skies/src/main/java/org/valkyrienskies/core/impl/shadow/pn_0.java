/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.oW;
import org.valkyrienskies.core.impl.shadow.pw_0;
import org.valkyrienskies.core.impl.shadow.px_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.pn
 */
public class pn_0
extends oW {
    private static final long c = -6100997100383932834L;
    private final Number d;
    private final boolean e;

    public pn_0(Number number, Number number2, boolean bl) {
        this((pw_0)(bl ? px_0.NUMBER_TOO_SMALL : px_0.NUMBER_TOO_SMALL_BOUND_EXCLUDED), number, number2, bl);
    }

    public pn_0(pw_0 pw_02, Number number, Number number2, boolean bl) {
        super(pw_02, number, number2);
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

