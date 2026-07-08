/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import org.valkyrienskies.core.impl.shadow.hw_1;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.if
 */
public final class if_2<E>
implements Iterator<E> {
    private final Queue<Iterator<? extends E>> a = new LinkedList<Iterator<? extends E>>();
    private Iterator<? extends E> b = null;
    private Iterator<? extends E> c = null;
    private boolean d = false;

    public if_2() {
    }

    private if_2(Iterator<? extends E> iterator2) {
        this.a(iterator2);
    }

    public if_2(Iterator<? extends E> iterator2, Iterator<? extends E> iterator3) {
        this.a(iterator2);
        this.a(iterator3);
    }

    public if_2(Iterator<? extends E> ... iteratorArray) {
        for (Iterator<? extends E> iterator2 : iteratorArray) {
            this.a(iterator2);
        }
    }

    public if_2(Collection<Iterator<? extends E>> object) {
        object = object.iterator();
        while (object.hasNext()) {
            Iterator iterator2 = (Iterator)object.next();
            this.a(iterator2);
        }
    }

    public final void a(Iterator<? extends E> iterator2) {
        this.c();
        if (iterator2 == null) {
            throw new NullPointerException("Iterator must not be null");
        }
        this.a.add(iterator2);
    }

    private int a() {
        return this.a.size();
    }

    private boolean b() {
        return this.d;
    }

    private void c() {
        if (this.d) {
            throw new UnsupportedOperationException("IteratorChain cannot be changed after the first use of a method from the Iterator interface");
        }
    }

    private void d() {
        if (!this.d) {
            this.d = true;
        }
    }

    private void e() {
        if (this.b == null) {
            this.b = this.a.isEmpty() ? hw_1.b() : this.a.remove();
            this.c = this.b;
        }
        while (!this.b.hasNext() && !this.a.isEmpty()) {
            this.b = this.a.remove();
        }
    }

    @Override
    public final boolean hasNext() {
        this.d();
        this.e();
        this.c = this.b;
        return this.b.hasNext();
    }

    @Override
    public final E next() {
        this.d();
        this.e();
        this.c = this.b;
        return this.b.next();
    }

    @Override
    public final void remove() {
        this.d();
        if (this.b == null) {
            this.e();
        }
        this.c.remove();
    }
}

