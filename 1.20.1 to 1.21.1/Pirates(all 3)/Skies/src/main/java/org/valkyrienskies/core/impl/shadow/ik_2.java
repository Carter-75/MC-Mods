/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.valkyrienskies.core.impl.shadow.fj_1;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.ik
 */
public final class ik_2<E>
implements fj_1<E> {
    private final Collection<? extends E> a;
    private Iterator<? extends E> b;

    public ik_2(Collection<? extends E> collection) {
        if (collection == null) {
            throw new NullPointerException("The collection must not be null");
        }
        this.a = collection;
        this.c();
    }

    @Override
    public final boolean hasNext() {
        return this.a.size() > 0;
    }

    @Override
    public final E next() {
        if (this.a.size() == 0) {
            throw new NoSuchElementException("There are no elements for this iterator to loop on");
        }
        if (!this.b.hasNext()) {
            this.c();
        }
        return this.b.next();
    }

    @Override
    public final void remove() {
        this.b.remove();
    }

    @Override
    public final void c() {
        this.b = this.a.iterator();
    }

    private int a() {
        return this.a.size();
    }
}

