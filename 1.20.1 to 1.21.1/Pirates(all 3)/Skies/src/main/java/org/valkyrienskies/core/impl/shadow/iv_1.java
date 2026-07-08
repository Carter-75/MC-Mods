/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.NoSuchElementException;
import org.valkyrienskies.core.impl.shadow.fk_1;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.iv
 */
public final class iv_1<E>
implements fk_1<E> {
    private boolean a = true;
    private boolean b = false;
    private boolean c = false;
    private E d;

    public iv_1(E e2) {
        this.d = e2;
    }

    @Override
    public final boolean hasNext() {
        return this.a && !this.c;
    }

    @Override
    public final boolean hasPrevious() {
        return !this.a && !this.c;
    }

    @Override
    public final int nextIndex() {
        if (this.a) {
            return 0;
        }
        return 1;
    }

    @Override
    public final int previousIndex() {
        if (this.a) {
            return -1;
        }
        return 0;
    }

    @Override
    public final E next() {
        if (!this.a || this.c) {
            throw new NoSuchElementException();
        }
        this.a = false;
        this.b = true;
        return this.d;
    }

    @Override
    public final E previous() {
        if (this.a || this.c) {
            throw new NoSuchElementException();
        }
        this.a = true;
        return this.d;
    }

    @Override
    public final void remove() {
        if (!this.b || this.c) {
            throw new IllegalStateException();
        }
        this.d = null;
        this.c = true;
    }

    @Override
    public final void add(E obj) {
        throw new UnsupportedOperationException("add() is not supported by this iterator");
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final void set(E obj) {
        void var1_1;
        if (!this.b || this.c) {
            throw new IllegalStateException();
        }
        this.d = var1_1;
    }

    @Override
    public final void c() {
        this.a = true;
        this.b = false;
    }
}

