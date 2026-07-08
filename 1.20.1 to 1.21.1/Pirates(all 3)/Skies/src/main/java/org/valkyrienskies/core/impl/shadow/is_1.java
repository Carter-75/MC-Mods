/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.is
 */
public final class is_1<E>
implements Iterator<E> {
    private final Iterator<? extends E> a;
    private final Deque<E> b = new ArrayDeque();

    public static <E> is_1<E> a(Iterator<? extends E> is_12) {
        if (is_12 == null) {
            throw new NullPointerException("Iterator must not be null");
        }
        if (is_12 instanceof is_1) {
            is_12 = is_12;
            return is_12;
        }
        return new is_1<E>(is_12);
    }

    private is_1(Iterator<? extends E> iterator2) {
        this.a = iterator2;
    }

    private void a(E e2) {
        this.b.push(e2);
    }

    @Override
    public final boolean hasNext() {
        if (!this.b.isEmpty()) {
            return true;
        }
        return this.a.hasNext();
    }

    @Override
    public final E next() {
        if (!this.b.isEmpty()) {
            return this.b.pop();
        }
        return this.a.next();
    }

    @Override
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}

