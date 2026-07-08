/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.valkyrienskies.core.impl.shadow.fd_2;
import org.valkyrienskies.core.impl.shadow.gw_2;
import org.valkyrienskies.core.impl.shadow.jb_0;
import org.valkyrienskies.core.impl.shadow.ks_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.ji
 */
public final class ji_0<K, V>
extends jb_0<K, V>
implements Serializable {
    private static final long a = -6096931280583808322L;
    private Map<K, V>[] b;
    private a<K, V> c;

    public ji_0() {
        this((Map<K, V>[])new Map[0], (a<K, V>)null);
    }

    private ji_0(Map<K, V> map2, Map<K, V> map3) {
        this((Map<K, V>[])new Map[]{map2, map3}, (a<K, V>)null);
    }

    private ji_0(Map<K, V> map2, Map<K, V> map3, a<K, V> a2) {
        this(new Map[]{map2, map3}, a2);
    }

    private ji_0(Map<K, V> ... mapArray) {
        this(mapArray, (a<K, V>)null);
    }

    private ji_0(Map<K, V>[] mapArray, a<K, V> a2) {
        this.c = a2;
        this.b = new Map[0];
        for (int i2 = mapArray.length - 1; i2 >= 0; --i2) {
            Map<K, V> map2 = mapArray[i2];
            ji_0 ji_02 = this;
            for (int i3 = ji_02.b.length - 1; i3 >= 0; --i3) {
                Set<K> set = fd_2.a(ji_02.b[i3].keySet(), map2.keySet());
                if (set.size() == 0) continue;
                if (ji_02.c == null) {
                    throw new IllegalArgumentException("Key collision adding Map to CompositeMap");
                }
                a<K, V> cfr_ignored_0 = ji_02.c;
                Map<K, V> cfr_ignored_1 = ji_02.b[i3];
            }
            Map[] mapArray2 = new Map[ji_02.b.length + 1];
            System.arraycopy(ji_02.b, 0, mapArray2, 0, ji_02.b.length);
            mapArray2[mapArray2.length - 1] = map2;
            ji_02.b = mapArray2;
        }
    }

    private void a(a<K, V> a2) {
        this.c = a2;
    }

    private void a(Map<K, V> map2) {
        for (int i2 = this.b.length - 1; i2 >= 0; --i2) {
            Set<K> set = fd_2.a(this.b[i2].keySet(), map2.keySet());
            if (set.size() == 0) continue;
            if (this.c == null) {
                throw new IllegalArgumentException("Key collision adding Map to CompositeMap");
            }
            Map<K, V> cfr_ignored_0 = this.b[i2];
        }
        Map[] mapArray = new Map[this.b.length + 1];
        System.arraycopy(this.b, 0, mapArray, 0, this.b.length);
        mapArray[mapArray.length - 1] = map2;
        this.b = mapArray;
    }

    private Map<K, V> b(Map<K, V> map2) {
        int n2 = this.b.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (!this.b[i2].equals(map2)) continue;
            Map[] mapArray = new Map[n2 - 1];
            System.arraycopy(this.b, 0, mapArray, 0, i2);
            System.arraycopy(this.b, i2 + 1, mapArray, i2, n2 - i2 - 1);
            this.b = mapArray;
            return map2;
        }
        return null;
    }

    @Override
    public final void clear() {
        for (int i2 = this.b.length - 1; i2 >= 0; --i2) {
            this.b[i2].clear();
        }
    }

    @Override
    public final boolean containsKey(Object key) {
        for (int i2 = this.b.length - 1; i2 >= 0; --i2) {
            if (!this.b[i2].containsKey(key)) continue;
            return true;
        }
        return false;
    }

    @Override
    public final boolean containsValue(Object value) {
        for (int i2 = this.b.length - 1; i2 >= 0; --i2) {
            if (!this.b[i2].containsValue(value)) continue;
            return true;
        }
        return false;
    }

    @Override
    public final Set<Map.Entry<K, V>> entrySet() {
        ks_0<Map.Entry<K, V>> ks_02 = new ks_0<Map.Entry<K, V>>();
        for (int i2 = this.b.length - 1; i2 >= 0; --i2) {
            ks_02.a(this.b[i2].entrySet());
        }
        return ks_02;
    }

    @Override
    public final V get(Object key) {
        for (int i2 = this.b.length - 1; i2 >= 0; --i2) {
            if (!this.b[i2].containsKey(key)) continue;
            return this.b[i2].get(key);
        }
        return null;
    }

    @Override
    public final boolean isEmpty() {
        for (int i2 = this.b.length - 1; i2 >= 0; --i2) {
            if (this.b[i2].isEmpty()) continue;
            return false;
        }
        return true;
    }

    @Override
    public final Set<K> keySet() {
        ks_0<K> ks_02 = new ks_0<K>();
        for (int i2 = this.b.length - 1; i2 >= 0; --i2) {
            ks_02.a(this.b[i2].keySet());
        }
        return ks_02;
    }

    @Override
    public final V put(K key, V value) {
        if (this.c == null) {
            throw new UnsupportedOperationException("No mutator specified");
        }
        return this.c.b();
    }

    @Override
    public final void putAll(Map<? extends K, ? extends V> map2) {
        if (this.c == null) {
            throw new UnsupportedOperationException("No mutator specified");
        }
    }

    @Override
    public final V remove(Object key) {
        for (int i2 = this.b.length - 1; i2 >= 0; --i2) {
            if (!this.b[i2].containsKey(key)) continue;
            return this.b[i2].remove(key);
        }
        return null;
    }

    @Override
    public final int size() {
        int n2 = 0;
        for (int i2 = this.b.length - 1; i2 >= 0; --i2) {
            n2 += this.b[i2].size();
        }
        return n2;
    }

    @Override
    public final Collection<V> values() {
        gw_2<V> gw_22 = new gw_2<V>();
        for (int i2 = this.b.length - 1; i2 >= 0; --i2) {
            gw_22.a(this.b[i2].values());
        }
        return gw_22;
    }

    @Override
    public final boolean equals(Object obj) {
        if (obj instanceof Map) {
            Map map2;
            map2 = map2;
            return this.entrySet().equals(map2.entrySet());
        }
        return false;
    }

    @Override
    public final int hashCode() {
        int n2 = 0;
        for (Map.Entry<K, V> entry : this.entrySet()) {
            n2 += entry.hashCode();
        }
        return n2;
    }

    public static interface a<K, V>
    extends Serializable {
        public void a();

        public V b();

        public void c();
    }
}

