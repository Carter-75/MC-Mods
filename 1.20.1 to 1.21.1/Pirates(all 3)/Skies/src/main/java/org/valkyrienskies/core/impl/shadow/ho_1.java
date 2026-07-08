/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.ListIterator;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.hO
 */
public class ho_1<E>
implements ListIterator<E> {
    private final ListIterator<E> a;

    public ho_1(ListIterator<E> listIterator) {
        if (listIterator == null) {
            throw new NullPointerException("ListIterator must not be null");
        }
        this.a = listIterator;
    }

    protected final ListIterator<E> a() {
        return this.a;
    }

    @Override
    public boolean hasNext() {
        return this.a.hasNext();
    }

    @Override
    public E next() {
        return this.a.next();
    }

    @Override
    public int nextIndex() {
        return this.a.nextIndex();
    }

    @Override
    public boolean hasPrevious() {
        return this.a.hasPrevious();
    }

    @Override
    public E previous() {
        return this.a.previous();
    }

    @Override
    public int previousIndex() {
        return this.a.previousIndex();
    }

    @Override
    public void remove() {
        this.a.remove();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public void set(E obj) {
        void var1_1;
        this.a.set(var1_1);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public void add(E obj) {
        void var1_1;
        this.a.add(var1_1);
    }
}

