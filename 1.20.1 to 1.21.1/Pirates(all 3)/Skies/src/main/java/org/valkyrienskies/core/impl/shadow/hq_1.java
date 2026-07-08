/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.fe_1;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.hQ
 */
public final class hq_1<K, V>
implements fe_1<K, V> {
    private final fe_1<K, V> a;

    private hq_1(fe_1<K, V> fe_12) {
        if (fe_12 == null) {
            throw new NullPointerException("OrderedMapIterator must not be null");
        }
        this.a = fe_12;
    }

    private fe_1<K, V> c() {
        return this.a;
    }

    @Override
    public final boolean hasNext() {
        return this.a.hasNext();
    }

    @Override
    public final K next() {
        return (K)this.a.next();
    }

    @Override
    public final boolean hasPrevious() {
        return this.a.hasPrevious();
    }

    @Override
    public final K previous() {
        return this.a.previous();
    }

    @Override
    public final void remove() {
        this.a.remove();
    }

    @Override
    public final K a() {
        return this.a.a();
    }

    @Override
    public final V b() {
        return this.a.b();
    }

    @Override
    public final V a(V v) {
        return this.a.a(v);
    }
}

