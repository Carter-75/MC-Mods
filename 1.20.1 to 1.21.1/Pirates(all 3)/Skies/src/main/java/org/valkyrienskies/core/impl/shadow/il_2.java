/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import org.valkyrienskies.core.impl.shadow.fk_1;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.il
 */
public final class il_2<E>
implements fk_1<E> {
    private final List<E> a;
    private ListIterator<E> b;

    public il_2(List<E> list) {
        if (list == null) {
            throw new NullPointerException("The list must not be null");
        }
        this.a = list;
        this.a();
    }

    @Override
    public final boolean hasNext() {
        return !this.a.isEmpty();
    }

    @Override
    public final E next() {
        if (this.a.isEmpty()) {
            throw new NoSuchElementException("There are no elements for this iterator to loop on");
        }
        if (!this.b.hasNext()) {
            il_2 il_22 = this;
            il_22.a();
        }
        return this.b.next();
    }

    @Override
    public final int nextIndex() {
        if (this.a.isEmpty()) {
            throw new NoSuchElementException("There are no elements for this iterator to loop on");
        }
        if (!this.b.hasNext()) {
            return 0;
        }
        return this.b.nextIndex();
    }

    @Override
    public final boolean hasPrevious() {
        return !this.a.isEmpty();
    }

    @Override
    public final E previous() {
        if (this.a.isEmpty()) {
            throw new NoSuchElementException("There are no elements for this iterator to loop on");
        }
        if (!this.b.hasPrevious()) {
            E e2 = null;
            while (this.b.hasNext()) {
                e2 = this.b.next();
            }
            this.b.previous();
            return e2;
        }
        return this.b.previous();
    }

    @Override
    public final int previousIndex() {
        if (this.a.isEmpty()) {
            throw new NoSuchElementException("There are no elements for this iterator to loop on");
        }
        if (!this.b.hasPrevious()) {
            return this.a.size() - 1;
        }
        return this.b.previousIndex();
    }

    @Override
    public final void remove() {
        this.b.remove();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final void add(E obj) {
        void var1_1;
        this.b.add(var1_1);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final void set(E obj) {
        void var1_1;
        this.b.set(var1_1);
    }

    @Override
    public final void c() {
        this.a();
    }

    private void a() {
        this.b = this.a.listIterator();
    }

    private int b() {
        return this.a.size();
    }
}

