/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.lang.reflect.Array;
import java.util.NoSuchElementException;
import org.valkyrienskies.core.impl.shadow.fk_1;
import org.valkyrienskies.core.impl.shadow.hs_1;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.hT
 */
public final class ht_1<E>
extends hs_1<E>
implements fk_1<E> {
    private int d = -1;

    public ht_1(Object object) {
        super(object);
    }

    public ht_1(Object object, int n2) {
        super(object, n2);
    }

    public ht_1(Object object, int n2, int n3) {
        super(object, n2, n3);
    }

    @Override
    public final boolean hasPrevious() {
        return this.c > this.b;
    }

    @Override
    public final E previous() {
        if (!this.hasPrevious()) {
            throw new NoSuchElementException();
        }
        this.d = --this.c;
        return (E)Array.get(this.a, this.c);
    }

    @Override
    public final E next() {
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        this.d = this.c;
        return (E)Array.get(this.a, this.c++);
    }

    @Override
    public final int nextIndex() {
        return this.c - this.b;
    }

    @Override
    public final int previousIndex() {
        return this.c - this.b - 1;
    }

    @Override
    public final void add(Object o) {
        throw new UnsupportedOperationException("add() method is not supported");
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final void set(Object o) {
        void var1_1;
        if (this.d == -1) {
            throw new IllegalStateException("must call next() or previous() before a call to set()");
        }
        Array.set(this.a, this.d, var1_1);
    }

    @Override
    public final void c() {
        super.c();
        this.d = -1;
    }
}

