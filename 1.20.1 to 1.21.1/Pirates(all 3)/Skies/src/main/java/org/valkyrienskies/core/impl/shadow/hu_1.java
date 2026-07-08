/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Iterator;
import java.util.NoSuchElementException;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.hU
 */
public final class hu_1<E>
implements Iterator<E> {
    private final Iterator<? extends E> a;
    private final long b;
    private final long c;
    private long d;

    public hu_1(Iterator<? extends E> hu_12, long l2, long l3) {
        if (hu_12 == null) {
            throw new NullPointerException("Iterator must not be null");
        }
        if (l2 < 0L) {
            throw new IllegalArgumentException("Offset parameter must not be negative.");
        }
        if (l3 < 0L) {
            throw new IllegalArgumentException("Max parameter must not be negative.");
        }
        this.a = hu_12;
        this.b = l2;
        this.c = l3;
        this.d = 0L;
        hu_12 = this;
        while (hu_12.d < hu_12.b && hu_12.a.hasNext()) {
            hu_12.a.next();
            ++hu_12.d;
        }
    }

    private void a() {
        while (this.d < this.b && this.a.hasNext()) {
            this.a.next();
            ++this.d;
        }
    }

    @Override
    public final boolean hasNext() {
        if (!this.b()) {
            return false;
        }
        return this.a.hasNext();
    }

    private boolean b() {
        return this.d - this.b + 1L <= this.c;
    }

    @Override
    public final E next() {
        if (!this.b()) {
            throw new NoSuchElementException();
        }
        E e2 = this.a.next();
        ++this.d;
        return e2;
    }

    @Override
    public final void remove() {
        if (this.d <= this.b) {
            throw new IllegalStateException("remove() can not be called before calling next()");
        }
        this.a.remove();
    }
}

