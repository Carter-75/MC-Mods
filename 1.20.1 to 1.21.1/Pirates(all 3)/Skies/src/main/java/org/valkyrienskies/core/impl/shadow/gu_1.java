/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import org.valkyrienskies.core.impl.shadow.fh_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.gU
 */
public final class gu_1<T>
implements Serializable,
fh_2<T> {
    private static final long a = -3520677225766901240L;
    private static gu_1 b = new gu_1<Object>(null);
    private final T c;

    public static <T> fh_2<T> a(T t) {
        if (t == null) {
            return b;
        }
        return new gu_1<T>(t);
    }

    private gu_1(T t) {
        this.c = t;
    }

    @Override
    public final T a() {
        return this.c;
    }

    private T b() {
        return this.c;
    }
}

