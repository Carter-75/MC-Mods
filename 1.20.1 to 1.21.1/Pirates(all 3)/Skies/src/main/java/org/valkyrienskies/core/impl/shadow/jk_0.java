/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.valkyrienskies.core.impl.shadow.fj_1;
import org.valkyrienskies.core.impl.shadow.fu_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.jk
 */
public class jk_0<K, V>
implements fj_1<K>,
fu_2<K, V> {
    private Set<Map.Entry<K, V>> c;
    transient Iterator<Map.Entry<K, V>> a;
    transient Map.Entry<K, V> b;

    public jk_0(Set<Map.Entry<K, V>> set) {
        this.c = set;
        this.c();
    }

    @Override
    public final K a() {
        return this.d().getKey();
    }

    @Override
    public final V b() {
        return this.d().getValue();
    }

    @Override
    public final V a(V v) {
        return this.d().setValue(v);
    }

    @Override
    public boolean hasNext() {
        return this.a.hasNext();
    }

    @Override
    public K next() {
        this.b = this.a.next();
        return this.a();
    }

    @Override
    public synchronized void c() {
        this.a = this.c.iterator();
    }

    @Override
    public void remove() {
        this.a.remove();
        this.b = null;
    }

    private synchronized Map.Entry<K, V> d() {
        if (this.b == null) {
            throw new IllegalStateException();
        }
        return this.b;
    }
}

