/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import org.valkyrienskies.core.impl.shadow.ff_1;
import org.valkyrienskies.core.impl.shadow.fk_2;
import org.valkyrienskies.core.impl.shadow.hz_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.ht
 */
public final class ht_2<T>
implements Serializable,
hz_2<T> {
    private static final long a = 3243449850504576071L;
    private final ff_1<? super T> b;

    public static <T> ff_1<T> a(ff_1<? super T> ff_12) {
        if (ff_12 == null) {
            throw new NullPointerException("Predicate must not be null");
        }
        return new ht_2<T>(ff_12);
    }

    private ht_2(ff_1<? super T> ff_12) {
        this.b = ff_12;
    }

    @Override
    public final boolean a(T t) {
        if (t == null) {
            throw new fk_2("Input Object must not be null");
        }
        return this.b.a(t);
    }

    @Override
    public final ff_1<? super T>[] a() {
        return new ff_1[]{this.b};
    }
}

