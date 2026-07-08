/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import org.valkyrienskies.core.impl.shadow.fu_1;
import org.valkyrienskies.core.impl.shadow.ia_1;
import org.valkyrienskies.core.impl.shadow.io_1;
import org.valkyrienskies.core.impl.shadow.iz_1;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.iY
 */
public final class iy_0<E>
extends io_1<E>
implements fu_1 {
    private static final long a = 6595182819922443652L;

    public static <E> List<E> a(List<? extends E> list) {
        if (list instanceof fu_1) {
            return list;
        }
        return new iy_0<E>(list);
    }

    private iy_0(List<? extends E> list) {
        super(list);
    }

    @Override
    public final Iterator<E> iterator() {
        return iz_1.a(this.c().iterator());
    }

    @Override
    public final boolean add(Object object) {
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

    @Override
    public final ListIterator<E> listIterator() {
        return ia_1.a(this.c().listIterator());
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final ListIterator<E> listIterator(int index) {
        void var1_1;
        return ia_1.a(this.c().listIterator((int)var1_1));
    }

    @Override
    public final void add(int index, E object) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final boolean addAll(int index, Collection<? extends E> coll) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final E remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final E set(int index, E object) {
        throw new UnsupportedOperationException();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final List<E> subList(int fromIndex, int toIndex) {
        void var2_3;
        void var1_1;
        List list = this.c().subList((int)var1_1, (int)var2_3);
        return new iy_0(list);
    }
}

