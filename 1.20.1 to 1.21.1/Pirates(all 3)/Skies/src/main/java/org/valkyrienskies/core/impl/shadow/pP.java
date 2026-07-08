/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.pO;
import org.valkyrienskies.core.impl.shadow.pW;
import org.valkyrienskies.core.impl.shadow.tq_0;
import org.valkyrienskies.core.impl.shadow.tu_0;

final class pP
extends pO {
    private final pW.a a;
    private final tq_0 b;

    pP(pW.a a2, tq_0 tq_02) {
        super(tq_02.g());
        this.a = a2;
        this.b = tq_02;
    }

    public final tq_0 c() {
        return this.b.c(this.a.c());
    }

    public final tu_0 d() {
        return this.b.a(this.a.d());
    }

    public final tu_0 e() {
        return this.a.e();
    }
}

