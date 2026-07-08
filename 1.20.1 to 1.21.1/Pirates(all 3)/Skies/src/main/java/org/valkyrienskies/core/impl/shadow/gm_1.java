/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import org.valkyrienskies.core.impl.shadow.ff_1;
import org.valkyrienskies.core.impl.shadow.hz_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.gM
 */
public final class gm_1<T>
implements Serializable,
hz_2<T> {
    private static final long a = 4189014213763186912L;
    private final ff_1<? super T> b;
    private final ff_1<? super T> c;

    public static <T> ff_1<T> a(ff_1<? super T> ff_12, ff_1<? super T> ff_13) {
        if (ff_12 == null || ff_13 == null) {
            throw new NullPointerException("Predicate must not be null");
        }
        return new gm_1<T>(ff_12, ff_13);
    }

    private gm_1(ff_1<? super T> ff_12, ff_1<? super T> ff_13) {
        this.b = ff_12;
        this.c = ff_13;
    }

    @Override
    public final boolean a(T t) {
        return this.b.a(t) && this.c.a(t);
    }

    @Override
    public final ff_1<? super T>[] a() {
        return new ff_1[]{this.b, this.c};
    }
}

