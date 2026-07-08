/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import org.valkyrienskies.core.impl.shadow.fb_2;
import org.valkyrienskies.core.impl.shadow.ff_1;
import org.valkyrienskies.core.impl.shadow.ho_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.hh
 */
public final class hh_2<E>
implements Serializable,
fb_2<E> {
    private static final long a = 3518477308466486130L;
    private final ff_1<? super E> b;
    private final fb_2<? super E> c;
    private final fb_2<? super E> d;

    public static <E> fb_2<E> a(ff_1<? super E> ff_12, fb_2<? super E> fb_22) {
        return hh_2.a(ff_12, fb_22, ho_2.a());
    }

    public static <E> fb_2<E> a(ff_1<? super E> ff_12, fb_2<? super E> fb_22, fb_2<? super E> fb_23) {
        if (ff_12 == null) {
            throw new NullPointerException("Predicate must not be null");
        }
        if (fb_22 == null || fb_23 == null) {
            throw new NullPointerException("Closures must not be null");
        }
        return new hh_2<E>(ff_12, fb_22, fb_23);
    }

    private hh_2(ff_1<? super E> ff_12, fb_2<? super E> fb_22) {
        this(ff_12, fb_22, ho_2.a());
    }

    private hh_2(ff_1<? super E> ff_12, fb_2<? super E> fb_22, fb_2<? super E> fb_23) {
        this.b = ff_12;
        this.c = fb_22;
        this.d = fb_23;
    }

    @Override
    public final void a(E e2) {
        if (this.b.a(e2)) {
            this.c.a(e2);
            return;
        }
        this.d.a(e2);
    }

    private ff_1<? super E> a() {
        return this.b;
    }

    private fb_2<? super E> b() {
        return this.c;
    }

    private fb_2<? super E> c() {
        return this.d;
    }
}

