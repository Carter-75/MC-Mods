/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Iterator;
import java.util.NoSuchElementException;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.iq
 */
public final class iq_1<E>
implements Iterator<E> {
    private final Iterator<? extends E> a;
    private boolean b = false;
    private boolean c = false;
    private E d;

    public static <E> iq_1<E> a(Iterator<? extends E> iq_12) {
        if (iq_12 == null) {
            throw new NullPointerException("Iterator must not be null");
        }
        if (iq_12 instanceof iq_1) {
            iq_12 = iq_12;
            return iq_12;
        }
        return new iq_1<E>(iq_12);
    }

    private iq_1(Iterator<? extends E> iterator2) {
        this.a = iterator2;
    }

    private void a() {
        if (this.b || this.c) {
            return;
        }
        if (this.a.hasNext()) {
            this.d = this.a.next();
            this.c = true;
            return;
        }
        this.b = true;
        this.d = null;
        this.c = false;
    }

    @Override
    public final boolean hasNext() {
        if (this.b) {
            return false;
        }
        if (this.c) {
            return true;
        }
        return this.a.hasNext();
    }

    private E b() {
        this.a();
        if (this.b) {
            return null;
        }
        return this.d;
    }

    private E c() {
        this.a();
        if (this.b) {
            throw new NoSuchElementException();
        }
        return this.d;
    }

    @Override
    public final E next() {
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        E e2 = this.c ? this.d : this.a.next();
        this.d = null;
        this.c = false;
        return e2;
    }

    @Override
    public final void remove() {
        if (this.c) {
            throw new IllegalStateException("peek() or element() called before remove()");
        }
        this.a.remove();
    }
}

