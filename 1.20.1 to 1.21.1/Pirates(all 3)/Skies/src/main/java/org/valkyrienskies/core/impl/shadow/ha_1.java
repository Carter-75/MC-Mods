/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import org.valkyrienskies.core.impl.shadow.ff_1;
import org.valkyrienskies.core.impl.shadow.fq_1;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.hA
 */
public final class ha_1<T>
implements Serializable,
fq_1<T, Boolean> {
    private static final long a = 5278818408044349346L;
    private final ff_1<? super T> b;

    public static <T> fq_1<T, Boolean> a(ff_1<? super T> ff_12) {
        if (ff_12 == null) {
            throw new IllegalArgumentException("Predicate must not be null");
        }
        return new ha_1<T>(ff_12);
    }

    private ha_1(ff_1<? super T> ff_12) {
        this.b = ff_12;
    }

    private Boolean b(T t) {
        return this.b.a(t);
    }

    private ff_1<? super T> a() {
        return this.b;
    }

    @Override
    public final /* synthetic */ Object a(Object object) {
        Object object2 = object;
        object = this;
        return ((ha_1)object).b.a(object2);
    }
}

