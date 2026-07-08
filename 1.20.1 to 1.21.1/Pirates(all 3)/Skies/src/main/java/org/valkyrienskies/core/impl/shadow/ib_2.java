/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Iterator;
import java.util.Map;
import org.valkyrienskies.core.impl.shadow.fj_1;
import org.valkyrienskies.core.impl.shadow.fu_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.ib
 */
public final class ib_2<K, V>
implements fj_1<K>,
fu_2<K, V> {
    private final Map<K, V> a;
    private Iterator<Map.Entry<K, V>> b;
    private Map.Entry<K, V> c;
    private boolean d = false;

    public ib_2(Map<K, V> map2) {
        this.a = map2;
        this.b = map2.entrySet().iterator();
    }

    @Override
    public final boolean hasNext() {
        return this.b.hasNext();
    }

    @Override
    public final K next() {
        this.c = this.b.next();
        this.d = true;
        return this.c.getKey();
    }

    @Override
    public final void remove() {
        if (!this.d) {
            throw new IllegalStateException("Iterator remove() can only be called once after next()");
        }
        this.b.remove();
        this.c = null;
        this.d = false;
    }

    @Override
    public final K a() {
        if (this.c == null) {
            throw new IllegalStateException("Iterator getKey() can only be called after next() and before remove()");
        }
        return this.c.getKey();
    }

    @Override
    public final V b() {
        if (this.c == null) {
            throw new IllegalStateException("Iterator getValue() can only be called after next() and before remove()");
        }
        return this.c.getValue();
    }

    @Override
    public final V a(V v) {
        if (this.c == null) {
            throw new IllegalStateException("Iterator setValue() can only be called after next() and before remove()");
        }
        return this.c.setValue(v);
    }

    @Override
    public final void c() {
        this.b = this.a.entrySet().iterator();
        this.c = null;
        this.d = false;
    }

    public final String toString() {
        if (this.c != null) {
            return "MapIterator[" + this.a() + "=" + this.b() + "]";
        }
        return "MapIterator[]";
    }
}

