/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.pb_0;
import org.valkyrienskies.core.impl.shadow.sF;
import org.valkyrienskies.core.impl.shadow.sZ;
import org.valkyrienskies.core.impl.shadow.tH;
import org.valkyrienskies.core.impl.shadow.tu_0;

public final class sJ
extends sZ {
    private static final long a = 20120129L;
    private final tu_0 b;
    private final tu_0 c;
    private final double d;
    private final tu_0 e;

    public sJ(sF sF2, int n2, tu_0 tu_02, tu_0 tu_03, tu_0 tu_04, double d2) {
        super(sF2, n2);
        this.e = tu_02;
        this.b = tu_03;
        this.c = tu_04;
        this.d = d2;
    }

    public sJ(tH tH2, int n2, tu_0 tu_02, tu_0 tu_03, double d2) {
        super(tH2, n2);
        this.e = tu_02;
        this.b = tu_03;
        this.c = null;
        this.d = d2;
    }

    public final double a() {
        return this.d;
    }

    public final tu_0 b() {
        if (this.c != null) {
            return this.c;
        }
        throw new pb_0();
    }

    public final tu_0 c() {
        return this.b;
    }

    public final tu_0 d() {
        return this.e;
    }

    public final boolean e() {
        return this.c != null;
    }
}

