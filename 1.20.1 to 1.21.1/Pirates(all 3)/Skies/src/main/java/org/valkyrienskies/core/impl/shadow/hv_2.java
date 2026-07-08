/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import org.valkyrienskies.core.impl.shadow.ff_1;
import org.valkyrienskies.core.impl.shadow.hz_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.hv
 */
public final class hv_2<T>
implements Serializable,
hz_2<T> {
    private static final long a = -7625133768987126273L;
    private final ff_1<? super T> b;

    public static <T> ff_1<T> a(ff_1<? super T> ff_12) {
        if (ff_12 == null) {
            throw new NullPointerException("Predicate must not be null");
        }
        return new hv_2<T>(ff_12);
    }

    private hv_2(ff_1<? super T> ff_12) {
        this.b = ff_12;
    }

    @Override
    public final boolean a(T t) {
        if (t == null) {
            return true;
        }
        return this.b.a(t);
    }

    @Override
    public final ff_1<? super T>[] a() {
        return new ff_1[]{this.b};
    }
}

