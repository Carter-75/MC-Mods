/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

public final class IE {
    public static final boolean a(byte by) {
        byte by2 = by;
        if (by2 == 0) {
            return false;
        }
        if (by2 == 1) {
            return true;
        }
        throw new IllegalStateException("Tried converting byte " + by + " to boolean!");
    }

    public static final byte a(boolean bl) {
        if (bl) {
            return 1;
        }
        return 0;
    }

    public static final /* synthetic */ byte b(boolean bl) {
        return IE.a(bl);
    }

    public static final /* synthetic */ boolean b(byte by) {
        return IE.a(by);
    }
}

