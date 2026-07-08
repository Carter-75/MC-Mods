/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.ch_0;
import org.valkyrienskies.core.impl.shadow.oW;
import org.valkyrienskies.core.impl.shadow.pw_0;
import org.valkyrienskies.core.impl.shadow.px_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.pg
 */
public final class pg_0
extends oW {
    private static final long c = 3596849179428944575L;
    private final int d;
    private final boolean e;
    private final int f;
    private final Number g;

    private pg_0(Number number, Number number2, int n2) {
        this(number, number2, n2, ch_0.b.INCREASING$37efe540, true);
    }

    public pg_0(Number number, Number number2, int n2, int n3, boolean bl) {
        super((pw_0)(n3 == ch_0.b.INCREASING$37efe540 ? (bl ? px_0.NOT_STRICTLY_INCREASING_SEQUENCE : px_0.NOT_INCREASING_SEQUENCE) : (bl ? px_0.NOT_STRICTLY_DECREASING_SEQUENCE : px_0.NOT_DECREASING_SEQUENCE)), number, number2, n2, n2 - 1);
        this.d = n3;
        this.e = bl;
        this.f = n2;
        this.g = number2;
    }

    private int b() {
        return this.d;
    }

    private boolean c() {
        return this.e;
    }

    private int d() {
        return this.f;
    }

    private Number e() {
        return this.g;
    }
}

