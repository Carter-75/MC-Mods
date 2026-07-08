/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public enum wD {
    NEITHER(false, false),
    FIRST(true, false),
    LAST(false, true),
    BOTH(true, true);

    final boolean first;
    final boolean last;

    private wD(boolean bl, boolean bl2) {
        this.first = bl;
        this.last = bl2;
    }

    public final boolean a() {
        return this.first;
    }

    public final boolean b() {
        return this.last;
    }
}

