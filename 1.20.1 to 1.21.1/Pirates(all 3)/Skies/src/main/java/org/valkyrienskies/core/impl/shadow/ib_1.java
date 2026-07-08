/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.fu_1;
import org.valkyrienskies.core.impl.shadow.fu_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.iB
 */
public final class ib_1<K, V>
implements fu_1,
fu_2<K, V> {
    private final fu_2<? extends K, ? extends V> a;

    public static <K, V> fu_2<K, V> a(fu_2<? extends K, ? extends V> fu_22) {
        if (fu_22 == null) {
            throw new NullPointerException("MapIterator must not be null");
        }
        if (fu_22 instanceof fu_1) {
            return fu_22;
        }
        return new ib_1<K, V>(fu_22);
    }

    private ib_1(fu_2<? extends K, ? extends V> fu_22) {
        this.a = fu_22;
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

