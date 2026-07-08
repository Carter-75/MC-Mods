/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import org.valkyrienskies.core.impl.shadow.fk_1;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.ij
 */
public final class ij_2<E>
implements fk_1<E> {
    private static final String a = "ListIteratorWrapper does not support optional operations of ListIterator.";
    private static final String b = "Cannot remove element at index {0}.";
    private final Iterator<? extends E> c;
    private final List<E> d = new ArrayList();
    private int e = 0;
    private int f = 0;
    private boolean g;

    public ij_2(Iterator<? extends E> iterator2) {
        if (iterator2 == null) {
            throw new NullPointerException("Iterator must not be null");
        }
        this.c = iterator2;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final void add(E obj) {
        if (this.c instanceof ListIterator) {
            void var1_1;
            ListIterator listIterator = (ListIterator)this.c;
            listIterator.add(var1_1);
            return;
        }
        throw new UnsupportedOperationException(a);
    }

    @Override
    public final boolean hasNext() {
        if (this.e == this.f || this.c instanceof ListIterator) {
            return this.c.hasNext();
        }
        return true;
    }

    @Override
    public final boolean hasPrevious() {
        if (this.c instanceof ListIterator) {
            ListIterator listIterator = (ListIterator)this.c;
            return listIterator.hasPrevious();
        }
        return this.e > 0;
    }

    @Override
    public final E next() {
        if (this.c instanceof ListIterator) {
            return this.c.next();
        }
        if (this.e < this.f) {
            ++this.e;
            return this.d.get(this.e - 1);
        }
        E e2 = this.c.next();
        this.d.add(e2);
        ++this.e;
        ++this.f;
        this.g = true;
        return e2;
    }

    @Override
    public final int nextIndex() {
        if (this.c instanceof ListIterator) {
            ListIterator listIterator = (ListIterator)this.c;
            return listIterator.nextIndex();
        }
        return this.e;
    }

    @Override
    public final E previous() {
        if (this.c instanceof ListIterator) {
            ListIterator listIterator = (ListIterator)this.c;
            return listIterator.previous();
        }
        if (this.e == 0) {
            throw new NoSuchElementException();
        }
        this.g = this.f == this.e;
        return this.d.get(--this.e);
    }

    @Override
    public final int previousIndex() {
        if (this.c instanceof ListIterator) {
            ListIterator listIterator = (ListIterator)this.c;
            return listIterator.previousIndex();
        }
        return this.e - 1;
    }

    @Override
    public final void remove() {
        if (this.c instanceof ListIterator) {
            this.c.remove();
            return;
        }
        int n2 = this.e;
        if (this.e == this.f) {
            --n2;
        }
        if (!this.g || this.f - this.e > 1) {
            throw new IllegalStateException(MessageFormat.format(b, n2));
        }
        this.c.remove();
        this.d.remove(n2);
        this.e = n2;
        --this.f;
        this.g = false;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final void set(E obj) {
        if (this.c instanceof ListIterator) {
            void var1_1;
            ListIterator listIterator = (ListIterator)this.c;
            listIterator.set(var1_1);
            return;
        }
        throw new UnsupportedOperationException(a);
    }

    @Override
    public final void c() {
        if (this.c instanceof ListIterator) {
            ListIterator listIterator = (ListIterator)this.c;
            while (listIterator.previousIndex() >= 0) {
                listIterator.previous();
            }
            return;
        }
        this.e = 0;
    }
}

