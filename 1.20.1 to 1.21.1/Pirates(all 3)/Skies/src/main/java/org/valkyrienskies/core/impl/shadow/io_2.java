/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.NoSuchElementException;
import org.valkyrienskies.core.impl.shadow.fk_1;
import org.valkyrienskies.core.impl.shadow.in_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.io
 */
public final class io_2<E>
extends in_2<E>
implements fk_1<E> {
    private int d = -1;

    public io_2(E ... EArray) {
        super(EArray);
    }

    public io_2(E[] EArray, int n2) {
        super(EArray, n2);
    }

    public io_2(E[] EArray, int n2, int n3) {
        super(EArray, n2, n3);
    }

    @Override
    public final boolean hasPrevious() {
        io_2 io_22 = this;
        return this.c > io_22.b;
    }

    @Override
    public final E previous() {
        if (!this.hasPrevious()) {
            throw new NoSuchElementException();
        }
        this.d = --this.c;
        return this.a[this.c];
    }

    @Override
    public final E next() {
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        this.d = this.c;
        return this.a[this.c++];
    }

    @Override
    public final int nextIndex() {
        io_2 io_22 = this;
        return this.c - io_22.b;
    }

    @Override
    public final int previousIndex() {
        io_2 io_22 = this;
        return this.c - io_22.b - 1;
    }

    @Override
    public final void add(E obj) {
        throw new UnsupportedOperationException("add() method is not supported");
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final void set(E obj) {
        void var1_1;
        if (this.d == -1) {
            throw new IllegalStateException("must call next() or previous() before a call to set()");
        }
        this.a[this.d] = var1_1;
    }

    @Override
    public final void c() {
        super.c();
        this.d = -1;
    }
}

