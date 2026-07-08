/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.qN;
import org.valkyrienskies.core.impl.shadow.rX;
import org.valkyrienskies.core.impl.shadow.sb_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public final class rO<S extends qN> {
    public final sb_0<S> a;
    public final sb_0<S> b;
    public final rX<S> c;

    @Deprecated
    private rO(sb_0<S> sb_02, sb_0<S> sb_03) {
        this(sb_02, sb_03, null);
    }

    rO(sb_0<S> sb_02, sb_0<S> sb_03, rX<S> rX2) {
        this.a = sb_02;
        this.b = sb_03;
        this.c = rX2;
    }

    public final sb_0<S> a() {
        return this.a;
    }

    public final sb_0<S> b() {
        return this.b;
    }

    public final rX<S> c() {
        return this.c;
    }
}

