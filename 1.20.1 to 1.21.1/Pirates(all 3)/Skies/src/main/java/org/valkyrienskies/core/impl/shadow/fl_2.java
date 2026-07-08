/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.fl
 */
public interface fl_2<K, V> {
    public boolean containsKey(Object var1);

    public boolean containsValue(Object var1);

    public Set<Map.Entry<K, V>> entrySet();

    public V get(Object var1);

    public V remove(Object var1);

    public boolean isEmpty();

    public Set<K> keySet();

    public int size();

    public Collection<V> values();
}

