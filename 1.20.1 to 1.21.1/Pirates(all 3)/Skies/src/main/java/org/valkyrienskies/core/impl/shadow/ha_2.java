/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import org.valkyrienskies.core.impl.shadow.ff_1;
import org.valkyrienskies.core.impl.shadow.fk_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.ha
 */
public final class ha_2<T>
implements Serializable,
ff_1<T> {
    private static final long a = 7179106032121985545L;
    private static ha_2 b = new ha_2();

    public static <T> ff_1<T> a() {
        return b;
    }

    private ha_2() {
    }

    @Override
    public final boolean a(T t) {
        throw new fk_2("ExceptionPredicate invoked");
    }

    private static ff_1 b() {
        return b;
    }
}

