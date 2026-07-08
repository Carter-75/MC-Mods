/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.ic
 */
public final class ic_2<E>
implements Iterator<E> {
    private final Collection<? super E> a;
    private Enumeration<? extends E> b;
    private E c;

    public ic_2() {
        this(null, null);
    }

    public ic_2(Enumeration<? extends E> enumeration) {
        this(enumeration, null);
    }

    public ic_2(Enumeration<? extends E> enumeration, Collection<? super E> collection) {
        this.b = enumeration;
        this.a = collection;
        this.c = null;
    }

    @Override
    public final boolean hasNext() {
        return this.b.hasMoreElements();
    }

    @Override
    public final E next() {
        this.c = this.b.nextElement();
        return this.c;
    }

    @Override
    public final void remove() {
        if (this.a != null) {
            if (this.c != null) {
                this.a.remove(this.c);
                return;
            }
            throw new IllegalStateException("next() must have been called for remove() to function");
        }
        throw new UnsupportedOperationException("No Collection associated with this Iterator");
    }

    private Enumeration<? extends E> a() {
        return this.b;
    }

    private void a(Enumeration<? extends E> enumeration) {
        this.b = enumeration;
    }
}

