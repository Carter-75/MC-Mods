/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.valkyrienskies.core.impl.shadow.jb_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.jd
 */
public abstract class jd_0<K, V>
extends jb_0<K, V> {
    transient Map<K, V> a;

    protected jd_0() {
    }

    public jd_0(Map<K, V> map2) {
        if (map2 == null) {
            throw new NullPointerException("Map must not be null.");
        }
        this.a = map2;
    }

    public Map<K, V> i() {
        return this.a;
    }

    @Override
    public void clear() {
        this.i().clear();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public boolean containsKey(Object key) {
        void var1_1;
        return this.i().containsKey(var1_1);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public boolean containsValue(Object value) {
        void var1_1;
        return this.i().containsValue(var1_1);
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        return this.i().entrySet();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public V get(Object key) {
        void var1_1;
        return this.i().get(var1_1);
    }

    @Override
    public boolean isEmpty() {
        return this.i().isEmpty();
    }

    @Override
    public Set<K> keySet() {
        return this.i().keySet();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public V put(K key, V value) {
        void var2_2;
        void var1_1;
        return this.i().put(var1_1, var2_2);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public void putAll(Map<? extends K, ? extends V> mapToCopy) {
        void var1_1;
        this.i().putAll((Map<K, V>)var1_1);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public V remove(Object key) {
        void var1_1;
        return this.i().remove(var1_1);
    }

    @Override
    public int size() {
        return this.i().size();
    }

    @Override
    public Collection<V> values() {
        return this.i().values();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public boolean equals(Object object) {
        void var1_1;
        if (object == this) {
            return true;
        }
        return this.i().equals(var1_1);
    }

    @Override
    public int hashCode() {
        return this.i().hashCode();
    }

    public String toString() {
        return this.i().toString();
    }
}

