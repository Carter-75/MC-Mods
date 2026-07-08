/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.fe_1;
import org.valkyrienskies.core.impl.shadow.fu_1;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.iC
 */
public final class ic_1<K, V>
implements fe_1<K, V>,
fu_1 {
    private final fe_1<? extends K, ? extends V> a;

    public static <K, V> fe_1<K, V> a(fe_1<K, ? extends V> fe_12) {
        if (fe_12 == null) {
            throw new NullPointerException("OrderedMapIterator must not be null");
        }
        if (fe_12 instanceof fu_1) {
            return fe_12;
        }
        return new ic_1<K, V>(fe_12);
    }

    private ic_1(fe_1<K, ? extends V> fe_12) {
        this.a = fe_12;
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
    public final K a() {
        return this.a.a();
    }

    @Override
    public final V b() {
        return this.a.b();
    }

    @Override
    public final V a(V v) {
        throw new UnsupportedOperationException("setValue() is not supported");
    }

    @Override
    public final void remove() {
        throw new UnsupportedOperationException("remove() is not supported");
    }
}

