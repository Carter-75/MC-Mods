/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.bS
 */
public class bs_1 {
    static final bs_1 a = new bs_1(false, false, false);
    private final boolean b;
    private final boolean c;
    private final boolean d;

    public bs_1(boolean bl, boolean bl2, boolean bl3) {
        if (!bl && bl2) {
            throw new IllegalArgumentException();
        }
        this.b = bl;
        this.c = bl2;
        this.d = bl3;
    }

    public boolean a() {
        return this.b;
    }

    public boolean b() {
        return this.c;
    }

    public boolean c() {
        return this.d;
    }
}

