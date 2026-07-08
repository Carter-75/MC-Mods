/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.fb_2;
import org.valkyrienskies.core.impl.shadow.ff_1;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.hK
 */
public final class hk_1<E>
implements fb_2<E> {
    private final ff_1<? super E> a;
    private final fb_2<? super E> b;
    private final boolean c;

    public static <E> fb_2<E> a(ff_1<? super E> ff_12, fb_2<? super E> fb_22, boolean bl) {
        if (ff_12 == null) {
            throw new NullPointerException("Predicate must not be null");
        }
        if (fb_22 == null) {
            throw new NullPointerException("Closure must not be null");
        }
        return new hk_1<E>(ff_12, fb_22, bl);
    }

    private hk_1(ff_1<? super E> ff_12, fb_2<? super E> fb_22, boolean bl) {
        this.a = ff_12;
        this.b = fb_22;
        this.c = bl;
    }

    @Override
    public final void a(E e2) {
        if (this.c) {
            this.b.a(e2);
        }
        while (this.a.a(e2)) {
            this.b.a(e2);
        }
    }

    private ff_1<? super E> a() {
        return this.a;
    }

    private fb_2<? super E> b() {
        return this.b;
    }

    private boolean c() {
        return this.c;
    }
}

