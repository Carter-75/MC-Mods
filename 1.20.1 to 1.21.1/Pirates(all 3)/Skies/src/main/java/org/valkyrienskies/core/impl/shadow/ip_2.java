/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.valkyrienskies.core.impl.shadow.fq_1;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.ip
 */
public final class ip_2<E>
implements Iterator<E> {
    private final Deque<Iterator<? extends E>> a = new ArrayDeque<Iterator<? extends E>>(8);
    private E b;
    private final fq_1<? super E, ? extends E> c;
    private boolean d = false;
    private Iterator<? extends E> e;
    private E f;
    private Iterator<? extends E> g;

    public ip_2(E e2, fq_1<? super E, ? extends E> fq_12) {
        if (e2 instanceof Iterator) {
            this.e = (Iterator)e2;
        } else {
            this.b = e2;
        }
        this.c = fq_12;
    }

    private ip_2(Iterator<? extends E> iterator2) {
        this.e = iterator2;
        this.c = null;
    }

    private void a() {
        if (this.d) {
            return;
        }
        if (this.e == null) {
            if (this.b != null) {
                if (this.c == null) {
                    ip_2 ip_22 = this;
                    ip_22.a(ip_22.b);
                } else {
                    ip_2 ip_23 = this;
                    ip_23.a(ip_23.c.a(this.b));
                }
                this.b = null;
                return;
            }
        } else {
            ip_2 ip_24 = this;
            ip_24.a(ip_24.e);
        }
    }

    private void a(E e2) {
        if (e2 instanceof Iterator) {
            this.a((Iterator)e2);
            return;
        }
        this.f = e2;
        this.d = true;
    }

    private void a(Iterator<? extends E> iterator2) {
        while (true) {
            if (iterator2 != this.e) {
                if (this.e != null) {
                    this.a.push(this.e);
                }
                this.e = iterator2;
            }
            while (this.e.hasNext() && !this.d) {
                iterator2 = this.e.next();
                if (this.c != null) {
                    iterator2 = this.c.a(iterator2);
                }
                this.a((E)iterator2);
            }
            if (this.d || this.a.isEmpty()) break;
            this.e = this.a.pop();
            iterator2 = this.e;
        }
    }

    @Override
    public final boolean hasNext() {
        this.a();
        return this.d;
    }

    @Override
    public final E next() {
        this.a();
        if (!this.d) {
            throw new NoSuchElementException("No more elements in the iteration");
        }
        this.g = this.e;
        E e2 = this.f;
        this.f = null;
        this.d = false;
        return e2;
    }

    @Override
    public final void remove() {
        if (this.g == null) {
            throw new IllegalStateException("Iterator remove() cannot be called at this time");
        }
        this.g.remove();
        this.g = null;
    }
}

