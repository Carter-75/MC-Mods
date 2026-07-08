/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import org.valkyrienskies.core.impl.shadow.fq_1;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.hp
 */
public final class hp_2<T>
implements Serializable,
fq_1<T, T> {
    private static final long a = 2133891748318574490L;
    private static hp_2 b = new hp_2();

    public static <T> fq_1<T, T> a() {
        return b;
    }

    private hp_2() {
    }

    @Override
    public final T a(T t) {
        return t;
    }

    private static fq_1 b() {
        return b;
    }
}

