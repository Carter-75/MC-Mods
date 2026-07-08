/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import org.valkyrienskies.core.impl.shadow.ff_1;
import org.valkyrienskies.core.impl.shadow.hw_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.hg
 */
public final class hg_2<T>
implements Serializable,
ff_1<T> {
    private static final long a = -89901658494523293L;
    private final T b;

    public static <T> ff_1<T> b(T t) {
        if (t == null) {
            return hw_2.a();
        }
        return new hg_2<T>(t);
    }

    private hg_2(T t) {
        this.b = t;
    }

    @Override
    public final boolean a(T t) {
        return this.b == t;
    }

    private T a() {
        return this.b;
    }
}

