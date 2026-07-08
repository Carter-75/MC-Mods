/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.fu_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.hP
 */
public final class hp_1<K, V>
implements fu_2<K, V> {
    private final fu_2<K, V> a;

    private hp_1(fu_2<K, V> fu_22) {
        if (fu_22 == null) {
            throw new NullPointerException("MapIterator must not be null");
        }
        this.a = fu_22;
    }

    private fu_2<K, V> c() {
        return this.a;
    }

    @Override
    public final boolean hasNext() {
        return this.a.hasNext();
    }

    @Override
    public final K next() {
        return this.a.next();
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

