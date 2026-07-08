/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.ListIterator;
import org.valkyrienskies.core.impl.shadow.fu_1;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.iA
 */
public final class ia_1<E>
implements ListIterator<E>,
fu_1 {
    private final ListIterator<? extends E> a;

    public static <E> ListIterator<E> a(ListIterator<? extends E> listIterator) {
        if (listIterator == null) {
            throw new NullPointerException("ListIterator must not be null");
        }
        if (listIterator instanceof fu_1) {
            return listIterator;
        }
        return new ia_1<E>(listIterator);
    }

    private ia_1(ListIterator<? extends E> listIterator) {
        this.a = listIterator;
    }

    @Override
    public final boolean hasNext() {
        return this.a.hasNext();
    }

    @Override
    public final E next() {
        return this.a.next();
    }

    @Override
    public final int nextIndex() {
        return this.a.nextIndex();
    }

    @Override
    public final boolean hasPrevious() {
        return this.a.hasPrevious();
    }

    @Override
    public final E previous() {
        return this.a.previous();
    }

    @Override
    public final int previousIndex() {
        return this.a.previousIndex();
    }

    @Override
    public final void remove() {
        throw new UnsupportedOperationException("remove() is not supported");
    }

    @Override
    public final void set(E obj) {
        throw new UnsupportedOperationException("set() is not supported");
    }

    @Override
    public final void add(E obj) {
        throw new UnsupportedOperationException("add() is not supported");
    }
}

