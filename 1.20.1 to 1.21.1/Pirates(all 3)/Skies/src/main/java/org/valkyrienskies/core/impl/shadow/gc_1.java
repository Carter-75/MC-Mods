/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Collection;
import java.util.Iterator;
import org.valkyrienskies.core.impl.shadow.fu_1;
import org.valkyrienskies.core.impl.shadow.gv_2;
import org.valkyrienskies.core.impl.shadow.iz_1;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.gC
 */
public final class gc_1<E>
extends gv_2<E>
implements fu_1 {
    private static final long a = -239892006883819945L;

    public static <T> Collection<T> b(Collection<? extends T> collection) {
        if (collection instanceof fu_1) {
            return collection;
        }
        return new gc_1<T>(collection);
    }

    private gc_1(Collection<? extends E> collection) {
        super(collection);
    }

    @Override
    public final Iterator<E> iterator() {
        return iz_1.a(this.f().iterator());
    }

    @Override
    public final boolean add(E object) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final boolean addAll(Collection<? extends E> coll) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override
    public final boolean remove(Object object) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final boolean removeAll(Collection<?> coll) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final boolean retainAll(Collection<?> coll) {
        throw new UnsupportedOperationException();
    }
}

