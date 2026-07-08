/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import org.valkyrienskies.core.impl.shadow.fe_1;
import org.valkyrienskies.core.impl.shadow.fs_1;
import org.valkyrienskies.core.impl.shadow.fu_1;
import org.valkyrienskies.core.impl.shadow.fu_2;
import org.valkyrienskies.core.impl.shadow.ic_1;

public final class kK<K, V>
implements Serializable,
fs_1<K, V>,
fu_1 {
    private static final long a = -7156426030315945159L;
    private final fs_1<K, V> b;

    public static <K, V> fs_1<K, V> a(fs_1<K, ? extends V> fs_12) {
        if (fs_12 instanceof fu_1) {
            return fs_12;
        }
        return new kK<K, V>(fs_12);
    }

    private kK(fs_1<K, ? extends V> fs_12) {
        if (fs_12 == null) {
            throw new NullPointerException("Trie must not be null");
        }
        this.b = fs_12;
    }

    @Override
    public final Set<Map.Entry<K, V>> entrySet() {
        return Collections.unmodifiableSet(this.b.entrySet());
    }

    @Override
    public final Set<K> keySet() {
        return Collections.unmodifiableSet(this.b.keySet());
    }

    @Override
    public final Collection<V> values() {
        return Collections.unmodifiableCollection(this.b.values());
    }

    @Override
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final boolean containsKey(Object key) {
        void var1_1;
        return this.b.containsKey(var1_1);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final boolean containsValue(Object value) {
        void var1_1;
        return this.b.containsValue(var1_1);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final V get(Object key) {
        void var1_1;
        return this.b.get(var1_1);
    }

    @Override
    public final boolean isEmpty() {
        return this.b.isEmpty();
    }

    @Override
    public final V put(K key, V value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final void putAll(Map<? extends K, ? extends V> m2) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final V remove(Object key) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final int size() {
        return this.b.size();
    }

    @Override
    public final K firstKey() {
        return this.b.firstKey();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final SortedMap<K, V> headMap(K toKey) {
        void var1_1;
        return Collections.unmodifiableSortedMap(this.b.headMap(var1_1));
    }

    @Override
    public final K lastKey() {
        return this.b.lastKey();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final SortedMap<K, V> subMap(K fromKey, K toKey) {
        void var2_2;
        void var1_1;
        return Collections.unmodifiableSortedMap(this.b.subMap(var1_1, var2_2));
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final SortedMap<K, V> tailMap(K fromKey) {
        void var1_1;
        return Collections.unmodifiableSortedMap(this.b.tailMap(var1_1));
    }

    @Override
    public final SortedMap<K, V> a(K k2) {
        return Collections.unmodifiableSortedMap(this.b.a(k2));
    }

    @Override
    public final Comparator<? super K> comparator() {
        return this.b.comparator();
    }

    @Override
    public final fe_1<K, V> e() {
        fe_1 fe_12 = this.b.e();
        return ic_1.a(fe_12);
    }

    @Override
    public final K c(K k2) {
        return this.b.c(k2);
    }

    @Override
    public final K d(K k2) {
        return this.b.d(k2);
    }

    @Override
    public final int hashCode() {
        return this.b.hashCode();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final boolean equals(Object obj) {
        void var1_1;
        return this.b.equals(var1_1);
    }

    public final String toString() {
        return this.b.toString();
    }

    @Override
    public final /* synthetic */ fu_2 c() {
        return this.e();
    }
}

