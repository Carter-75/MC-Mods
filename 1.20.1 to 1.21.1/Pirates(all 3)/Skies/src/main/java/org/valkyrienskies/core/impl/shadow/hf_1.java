/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import org.valkyrienskies.core.impl.shadow.ff_1;
import org.valkyrienskies.core.impl.shadow.fq_1;
import org.valkyrienskies.core.impl.shadow.hz_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.hF
 */
public final class hf_1<T>
implements Serializable,
hz_2<T> {
    private static final long a = -5596090919668315834L;
    private final fq_1<? super T, ? extends T> b;
    private final ff_1<? super T> c;

    public static <T> ff_1<T> a(fq_1<? super T, ? extends T> fq_12, ff_1<? super T> ff_12) {
        if (fq_12 == null) {
            throw new NullPointerException("The transformer to call must not be null");
        }
        if (ff_12 == null) {
            throw new NullPointerException("The predicate to call must not be null");
        }
        return new hf_1<T>(fq_12, ff_12);
    }

    private hf_1(fq_1<? super T, ? extends T> fq_12, ff_1<? super T> ff_12) {
        this.b = fq_12;
        this.c = ff_12;
    }

    @Override
    public final boolean a(T t) {
        t = this.b.a(t);
        return this.c.a(t);
    }

    @Override
    public final ff_1<? super T>[] a() {
        return new ff_1[]{this.c};
    }

    private fq_1<? super T, ? extends T> b() {
        return this.b;
    }
}

