/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import org.valkyrienskies.core.impl.shadow.fu_1;
import org.valkyrienskies.core.impl.shadow.iz_1;
import org.valkyrienskies.core.impl.shadow.kp_0;

public final class kC<E>
extends kp_0<E>
implements fu_1 {
    private static final long a = 6499119872185240161L;

    public static <E> Set<E> a(Set<? extends E> set) {
        if (set instanceof fu_1) {
            return set;
        }
        return new kC<E>(set);
    }

    private kC(Set<? extends E> set) {
        super(set);
    }

    @Override
    public final Iterator<E> iterator() {
        return iz_1.a(this.c().iterator());
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

