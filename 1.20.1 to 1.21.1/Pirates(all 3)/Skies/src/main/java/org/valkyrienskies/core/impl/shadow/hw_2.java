/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import org.valkyrienskies.core.impl.shadow.ff_1;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.hw
 */
public final class hw_2<T>
implements Serializable,
ff_1<T> {
    private static final long a = 7533784454832764388L;
    private static hw_2 b = new hw_2();

    public static <T> ff_1<T> a() {
        return b;
    }

    private hw_2() {
    }

    @Override
    public final boolean a(T t) {
        return t == null;
    }

    private static ff_1 b() {
        return b;
    }
}

