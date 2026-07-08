/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.List;
import java.util.ListIterator;
import org.valkyrienskies.core.impl.shadow.fk_1;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.it
 */
public final class it_1<E>
implements fk_1<E> {
    private final List<E> a;
    private ListIterator<E> b;
    private boolean c = true;

    public it_1(List<E> list) {
        if (list == null) {
            throw new NullPointerException("List must not be null.");
        }
        this.a = list;
        List<E> list2 = list;
        this.b = list2.listIterator(list2.size());
    }

    @Override
    public final boolean hasNext() {
        return this.b.hasPrevious();
    }

    @Override
    public final E next() {
        E e2 = this.b.previous();
        this.c = true;
        return e2;
    }

    @Override
    public final int nextIndex() {
        return this.b.previousIndex();
    }

    @Override
    public final boolean hasPrevious() {
        return this.b.hasNext();
    }

    @Override
    public final E previous() {
        E e2 = this.b.next();
        this.c = true;
        return e2;
    }

    @Override
    public final int previousIndex() {
        return this.b.nextIndex();
    }

    @Override
    public final void remove() {
        if (!this.c) {
            throw new IllegalStateException("Cannot remove from list until next() or previous() called");
        }
        this.b.remove();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final void set(E obj) {
        void var1_1;
        if (!this.c) {
            throw new IllegalStateException("Cannot set to list until next() or previous() called");
        }
        this.b.set(var1_1);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final void add(E obj) {
        void var1_1;
        if (!this.c) {
            throw new IllegalStateException("Cannot add to list until next() or previous() called");
        }
        this.c = false;
        this.b.add(var1_1);
        this.b.previous();
    }

    @Override
    public final void c() {
        this.b = this.a.listIterator(this.a.size());
    }
}

