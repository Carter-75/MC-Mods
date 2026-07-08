/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import org.valkyrienskies.core.impl.shadow.ff_1;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.hj
 */
public final class hj_2
implements Serializable,
ff_1<Object> {
    private static final long a = -6682656911025165584L;
    private final Class<?> b;

    public static ff_1<Object> a(Class<?> clazz) {
        if (clazz == null) {
            throw new NullPointerException("The type to check instanceof must not be null");
        }
        return new hj_2(clazz);
    }

    private hj_2(Class<?> clazz) {
        this.b = clazz;
    }

    @Override
    public final boolean a(Object object) {
        return this.b.isInstance(object);
    }

    private Class<?> a() {
        return this.b;
    }
}

