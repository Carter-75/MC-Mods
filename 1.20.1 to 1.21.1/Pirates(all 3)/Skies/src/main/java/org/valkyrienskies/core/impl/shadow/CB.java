/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

public final class CB {
    private static final <T> T b(Class<T> clazz, Object object) {
        if (clazz.isInstance(object)) {
            return clazz.cast(object);
        }
        return null;
    }

    public static final /* synthetic */ Object a(Class clazz, Object object) {
        return CB.b(clazz, object);
    }
}

