/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import org.valkyrienskies.core.impl.shadow.ff_1;
import org.valkyrienskies.core.impl.shadow.fq_1;
import org.valkyrienskies.core.impl.shadow.hp_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.hi
 */
public final class hi_2<I, O>
implements Serializable,
fq_1<I, O> {
    private static final long a = 8069309411242014252L;
    private final ff_1<? super I> b;
    private final fq_1<? super I, ? extends O> c;
    private final fq_1<? super I, ? extends O> d;

    public static <I, O> fq_1<I, O> a(ff_1<? super I> ff_12, fq_1<? super I, ? extends O> fq_12, fq_1<? super I, ? extends O> fq_13) {
        if (ff_12 == null) {
            throw new NullPointerException("Predicate must not be null");
        }
        if (fq_12 == null || fq_13 == null) {
            throw new NullPointerException("Transformers must not be null");
        }
        return new hi_2<I, O>(ff_12, fq_12, fq_13);
    }

    public static <T> fq_1<T, T> a(ff_1<? super T> ff_12, fq_1<? super T, ? extends T> fq_12) {
        if (ff_12 == null) {
            throw new NullPointerException("Predicate must not be null");
        }
        if (fq_12 == null) {
            throw new NullPointerException("Transformer must not be null");
        }
        return new hi_2<T, T>(ff_12, fq_12, hp_2.a());
    }

    private hi_2(ff_1<? super I> ff_12, fq_1<? super I, ? extends O> fq_12, fq_1<? super I, ? extends O> fq_13) {
        this.b = ff_12;
        this.c = fq_12;
        this.d = fq_13;
    }

    @Override
    public final O a(I i2) {
        if (this.b.a(i2)) {
            return this.c.a(i2);
        }
        return this.d.a(i2);
    }

    private ff_1<? super I> a() {
        return this.b;
    }

    private fq_1<? super I, ? extends O> b() {
        return this.c;
    }

    private fq_1<? super I, ? extends O> c() {
        return this.d;
    }
}

