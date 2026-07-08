/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Collection;
import java.util.Comparator;
import org.valkyrienskies.core.impl.shadow.ff_1;
import org.valkyrienskies.core.impl.shadow.fn_1;
import org.valkyrienskies.core.impl.shadow.gb_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.gc
 */
public final class gc_2<E>
extends gb_2<E>
implements fn_1<E> {
    private static final long b = 3448581314086406616L;

    public static <E> gc_2<E> a(fn_1<E> fn_12, ff_1<? super E> ff_12) {
        return new gc_2<E>(fn_12, ff_12);
    }

    private gc_2(fn_1<E> fn_12, ff_1<? super E> ff_12) {
        super(fn_12, ff_12);
    }

    private fn_1<E> g() {
        return (fn_1)super.e();
    }

    @Override
    public final E c() {
        gc_2 gc_22 = this;
        return ((fn_1)super.e()).c();
    }

    @Override
    public final E d() {
        gc_2 gc_22 = this;
        return ((fn_1)super.e()).d();
    }

    @Override
    public final Comparator<? super E> b() {
        gc_2 gc_22 = this;
        return ((fn_1)super.e()).b();
    }

    @Override
    public final /* synthetic */ Collection f() {
        gc_2 gc_22 = this;
        return (fn_1)super.e();
    }
}

