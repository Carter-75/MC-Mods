/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import org.valkyrienskies.core.impl.shadow.fu_1;
import org.valkyrienskies.core.impl.shadow.gc_1;
import org.valkyrienskies.core.impl.shadow.jF;
import org.valkyrienskies.core.impl.shadow.jg_0;
import org.valkyrienskies.core.impl.shadow.kC;

public final class jI<K, V>
extends jg_0<K, V>
implements Serializable,
fu_1 {
    private static final long b = 5805344239827376360L;

    public static <K, V> SortedMap<K, V> a(SortedMap<K, ? extends V> sortedMap) {
        if (sortedMap instanceof fu_1) {
            return sortedMap;
        }
        return new jI<K, V>(sortedMap);
    }

    private jI(SortedMap<K, ? extends V> sortedMap) {
        super(sortedMap);
    }

    private void a(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.a);
    }

    private void a(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.a = (Map)objectInputStream.readObject();
    }

    @Override
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override
    public final V put(K key, V value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final void putAll(Map<? extends K, ? extends V> mapToCopy) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final V remove(Object key) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final Set<Map.Entry<K, V>> entrySet() {
        return jF.a(super.entrySet());
    }

    @Override
    public final Set<K> keySet() {
        return kC.a(super.keySet());
    }

    @Override
    public final Collection<V> values() {
        return gc_1.b(super.values());
    }

    @Override
    public final K firstKey() {
        return this.c_().firstKey();
    }

    @Override
    public final K lastKey() {
        return this.c_().lastKey();
    }

    @Override
    public final Comparator<? super K> comparator() {
        return this.c_().comparator();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final SortedMap<K, V> subMap(K fromKey, K toKey) {
        void var2_2;
        void var1_1;
        return new jI(this.c_().subMap(var1_1, var2_2));
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final SortedMap<K, V> headMap(K toKey) {
        void var1_1;
        return new jI(this.c_().headMap(var1_1));
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final SortedMap<K, V> tailMap(K fromKey) {
        void var1_1;
        return new jI(this.c_().tailMap(var1_1));
    }
}

