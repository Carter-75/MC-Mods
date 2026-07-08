/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.valkyrienskies.core.impl.shadow.fm_2;
import org.valkyrienskies.core.impl.shadow.fu_2;
import org.valkyrienskies.core.impl.shadow.jk_0;

public class kE<K, V>
implements fm_2<K, V> {
    transient Map<K, V> a;

    public kE(Map<K, V> map2) {
        if (map2 == null) {
            throw new NullPointerException("Map must not be null.");
        }
        this.a = map2;
    }

    protected kE() {
    }

    protected final Map<K, V> a() {
        return this.a;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public boolean containsKey(Object key) {
        void var1_1;
        kE kE2 = this;
        return kE2.a.containsKey(var1_1);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public boolean containsValue(Object value) {
        void var1_1;
        kE kE2 = this;
        return kE2.a.containsValue(var1_1);
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        kE kE2 = this;
        return kE2.a.entrySet();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public V get(Object key) {
        void var1_1;
        kE kE2 = this;
        return kE2.a.get(var1_1);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public V remove(Object key) {
        void var1_1;
        kE kE2 = this;
        return kE2.a.remove(var1_1);
    }

    @Override
    public boolean isEmpty() {
        kE kE2 = this;
        return kE2.a.isEmpty();
    }

    @Override
    public Set<K> keySet() {
        kE kE2 = this;
        return kE2.a.keySet();
    }

    @Override
    public int size() {
        kE kE2 = this;
        return kE2.a.size();
    }

    @Override
    public Collection<V> values() {
        kE kE2 = this;
        return kE2.a.values();
    }

    @Override
    public final fu_2<K, V> c() {
        return new jk_0<K, V>(this.entrySet());
    }

    /*
     * WARNING - void declaration
     */
    public boolean equals(Object object) {
        void var1_1;
        if (object == this) {
            return true;
        }
        kE kE2 = this;
        return kE2.a.equals(var1_1);
    }

    public int hashCode() {
        kE kE2 = this;
        return kE2.a.hashCode();
    }

    public String toString() {
        kE kE2 = this;
        return kE2.a.toString();
    }
}

