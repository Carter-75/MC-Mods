/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import org.valkyrienskies.core.impl.shadow.fa_2;
import org.valkyrienskies.core.impl.shadow.fd_2;
import org.valkyrienskies.core.impl.shadow.gc_1;
import org.valkyrienskies.core.impl.shadow.jd_0;
import org.valkyrienskies.core.impl.shadow.jg_0;
import org.valkyrienskies.core.impl.shadow.kC;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.jm
 */
public final class jm_0<K, V>
extends jg_0<K, V>
implements Serializable,
fa_2<K, V> {
    private static final long b = 3126019624511683653L;

    public static <K, V> jm_0<K, V> a(SortedMap<K, V> sortedMap) {
        return new jm_0<K, V>(sortedMap);
    }

    private jm_0(SortedMap<K, V> sortedMap) {
        super(sortedMap);
    }

    private SortedMap<K, V> d() {
        return (SortedMap)this.a;
    }

    private void a(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.a);
    }

    private void a(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.a = (Map)objectInputStream.readObject();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final V put(K key, V value) {
        void var2_2;
        void var1_1;
        if (!this.a.containsKey(key)) {
            throw new IllegalArgumentException("Cannot put new key/value pair - Map is fixed size");
        }
        return this.a.put(var1_1, var2_2);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final void putAll(Map<? extends K, ? extends V> mapToCopy) {
        void var1_1;
        if (fd_2.a(mapToCopy.keySet(), ((jd_0)this).keySet())) {
            throw new IllegalArgumentException("Cannot put new key/value pair - Map is fixed size");
        }
        this.a.putAll(var1_1);
    }

    @Override
    public final void clear() {
        throw new UnsupportedOperationException("Map is fixed size");
    }

    @Override
    public final V remove(Object key) {
        throw new UnsupportedOperationException("Map is fixed size");
    }

    @Override
    public final Set<Map.Entry<K, V>> entrySet() {
        return kC.a(this.a.entrySet());
    }

    @Override
    public final Set<K> keySet() {
        return kC.a(this.a.keySet());
    }

    @Override
    public final Collection<V> values() {
        return gc_1.b(this.a.values());
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final SortedMap<K, V> subMap(K fromKey, K toKey) {
        void var2_2;
        void var1_1;
        jm_0 jm_02 = this;
        return new jm_0(((SortedMap)jm_02.a).subMap(var1_1, var2_2));
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final SortedMap<K, V> headMap(K toKey) {
        void var1_1;
        jm_0 jm_02 = this;
        return new jm_0(((SortedMap)jm_02.a).headMap(var1_1));
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final SortedMap<K, V> tailMap(K fromKey) {
        void var1_1;
        jm_0 jm_02 = this;
        return new jm_0(((SortedMap)jm_02.a).tailMap(var1_1));
    }

    @Override
    public final boolean a() {
        return true;
    }

    @Override
    public final int b() {
        return this.size();
    }
}

