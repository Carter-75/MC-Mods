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
import org.valkyrienskies.core.impl.shadow.fa_2;
import org.valkyrienskies.core.impl.shadow.gc_1;
import org.valkyrienskies.core.impl.shadow.jd_0;
import org.valkyrienskies.core.impl.shadow.kC;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.jl
 */
public final class jl_0<K, V>
extends jd_0<K, V>
implements Serializable,
fa_2<K, V> {
    private static final long b = 7450927208116179316L;

    public static <K, V> jl_0<K, V> a(Map<K, V> map2) {
        return new jl_0<K, V>(map2);
    }

    private jl_0(Map<K, V> map2) {
        super(map2);
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
        for (K k2 : mapToCopy.keySet()) {
            if (this.containsKey(k2)) continue;
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
        Set set = this.a.entrySet();
        return kC.a(set);
    }

    @Override
    public final Set<K> keySet() {
        Set set = this.a.keySet();
        return kC.a(set);
    }

    @Override
    public final Collection<V> values() {
        Collection collection = this.a.values();
        return gc_1.b(collection);
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

