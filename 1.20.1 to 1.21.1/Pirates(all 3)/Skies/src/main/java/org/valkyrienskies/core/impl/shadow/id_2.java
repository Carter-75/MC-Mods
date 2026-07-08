/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Iterator;
import java.util.NoSuchElementException;
import org.valkyrienskies.core.impl.shadow.ff_1;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.id
 */
public class id_2<E>
implements Iterator<E> {
    private Iterator<? extends E> a;
    private ff_1<? super E> b;
    private E c;
    private boolean d = false;

    public id_2() {
    }

    private id_2(Iterator<? extends E> iterator2) {
        this.a = iterator2;
    }

    public id_2(Iterator<? extends E> iterator2, ff_1<? super E> ff_12) {
        this.a = iterator2;
        this.b = ff_12;
    }

    @Override
    public boolean hasNext() {
        return this.d || this.c();
    }

    @Override
    public E next() {
        if (!this.d && !this.c()) {
            throw new NoSuchElementException();
        }
        this.d = false;
        return this.c;
    }

    @Override
    public void remove() {
        if (this.d) {
            throw new IllegalStateException("remove() cannot be called");
        }
        this.a.remove();
    }

    private Iterator<? extends E> a() {
        return this.a;
    }

    private void a(Iterator<? extends E> iterator2) {
        this.a = iterator2;
        this.c = null;
        this.d = false;
    }

    private ff_1<? super E> b() {
        return this.b;
    }

    private void a(ff_1<? super E> ff_12) {
        this.b = ff_12;
        this.c = null;
        this.d = false;
    }

    private boolean c() {
        while (this.a.hasNext()) {
            E e2 = this.a.next();
            if (!this.b.a(e2)) continue;
            this.c = e2;
            this.d = true;
            return true;
        }
        return false;
    }
}

