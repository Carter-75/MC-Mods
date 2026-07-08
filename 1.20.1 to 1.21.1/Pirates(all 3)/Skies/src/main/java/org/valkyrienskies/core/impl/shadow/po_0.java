/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.oW;
import org.valkyrienskies.core.impl.shadow.pw_0;
import org.valkyrienskies.core.impl.shadow.px_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.po
 */
public final class po_0
extends oW {
    private static final long c = 111601815794403609L;
    private final Number d;
    private final Number e;

    public po_0(Number number, Number number2, Number number3) {
        this(px_0.OUT_OF_RANGE_SIMPLE, number, number2, number3);
    }

    public po_0(px_0 px_02, Number number, Number number2, Number number3) {
        super((pw_0)px_02, number, number2, number3);
        this.d = number2;
        this.e = number3;
    }

    private Number b() {
        return this.d;
    }

    private Number c() {
        return this.e;
    }
}

