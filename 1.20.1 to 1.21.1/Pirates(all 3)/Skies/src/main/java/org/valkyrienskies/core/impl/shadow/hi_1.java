/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import org.valkyrienskies.core.impl.shadow.ff_1;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.hI
 */
public final class hi_1<T>
implements Serializable,
ff_1<T> {
    private static final long a = 3374767158756189740L;
    private static hi_1 b = new hi_1();

    public static <T> ff_1<T> a() {
        return b;
    }

    private hi_1() {
    }

    @Override
    public final boolean a(T t) {
        return true;
    }

    private static ff_1 b() {
        return b;
    }
}

