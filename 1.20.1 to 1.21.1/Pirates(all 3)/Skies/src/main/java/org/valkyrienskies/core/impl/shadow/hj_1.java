/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import org.valkyrienskies.core.impl.shadow.ff_1;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.hJ
 */
public final class hj_1<T>
implements Serializable,
ff_1<T> {
    private static final long a = -3319417438027438040L;
    private final Set<T> b = new HashSet<T>();

    public static <T> ff_1<T> a() {
        return new hj_1<T>();
    }

    @Override
    public final boolean a(T t) {
        return this.b.add(t);
    }
}

