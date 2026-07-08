/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.ListIterator;
import java.util.NoSuchElementException;
import org.valkyrienskies.core.impl.shadow.ff_1;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.ie
 */
public final class ie_2<E>
implements ListIterator<E> {
    private ListIterator<? extends E> a;
    private ff_1<? super E> b;
    private E c;
    private boolean d = false;
    private E e;
    private boolean f = false;
    private int g = 0;

    public ie_2() {
    }

    private ie_2(ListIterator<? extends E> listIterator) {
        this.a = listIterator;
    }

    public ie_2(ListIterator<? extends E> listIterator, ff_1<? super E> ff_12) {
        this.a = listIterator;
        this.b = ff_12;
    }

    private ie_2(ff_1<? super E> ff_12) {
        this.b = ff_12;
    }

    @Override
    public final void add(E o) {
        throw new UnsupportedOperationException("FilterListIterator.add(Object) is not supported.");
    }

    @Override
    public final boolean hasNext() {
        return this.d || this.d();
    }

    @Override
    public final boolean hasPrevious() {
        return this.f || this.f();
    }

    @Override
    public final E next() {
        if (!this.d && !this.d()) {
            throw new NoSuchElementException();
        }
        ++this.g;
        E e2 = this.c;
        this.c();
        return e2;
    }

    @Override
    public final int nextIndex() {
        return this.g;
    }

    @Override
    public final E previous() {
        if (!this.f && !this.f()) {
            throw new NoSuchElementException();
        }
        --this.g;
        E e2 = this.e;
        this.e();
        return e2;
    }

    @Override
    public final int previousIndex() {
        return this.g - 1;
    }

    @Override
    public final void remove() {
        throw new UnsupportedOperationException("FilterListIterator.remove() is not supported.");
    }

    @Override
    public final void set(E o) {
        throw new UnsupportedOperationException("FilterListIterator.set(Object) is not supported.");
    }

    private ListIterator<? extends E> a() {
        return this.a;
    }

    private void a(ListIterator<? extends E> listIterator) {
        this.a = listIterator;
    }

    private ff_1<? super E> b() {
        return this.b;
    }

    private void a(ff_1<? super E> ff_12) {
        this.b = ff_12;
    }

    private void c() {
        this.c = null;
        this.d = false;
    }

    private boolean d() {
        if (this.f) {
            this.e();
            if (!this.d()) {
                return false;
            }
            this.c();
        }
        if (this.a == null) {
            return false;
        }
        while (this.a.hasNext()) {
            E e2 = this.a.next();
            if (!this.b.a(e2)) continue;
            this.c = e2;
            this.d = true;
            return true;
        }
        return false;
    }

    private void e() {
        this.e = null;
        this.f = false;
    }

    private boolean f() {
        if (this.d) {
            this.c();
            if (!this.f()) {
                return false;
            }
            this.e();
        }
        if (this.a == null) {
            return false;
        }
        while (this.a.hasPrevious()) {
            E e2 = this.a.previous();
            if (!this.b.a(e2)) continue;
            this.e = e2;
            this.f = true;
            return true;
        }
        return false;
    }
}

