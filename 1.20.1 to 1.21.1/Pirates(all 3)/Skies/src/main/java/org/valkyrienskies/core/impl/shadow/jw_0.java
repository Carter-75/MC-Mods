/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.valkyrienskies.core.impl.shadow.jw$a
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.valkyrienskies.core.impl.shadow.jd_0;
import org.valkyrienskies.core.impl.shadow.jw;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.jw
 */
public final class jw_0<K, V>
extends jd_0<K, V>
implements Serializable {
    private static final long b = 1L;
    private final Map<Object, Long> c = new HashMap<Object, Long>();
    private final b<K, V> d;

    private static long b(long l2, TimeUnit timeUnit) {
        if (timeUnit == null) {
            throw new NullPointerException("Time unit must not be null");
        }
        return TimeUnit.MILLISECONDS.convert(l2, timeUnit);
    }

    public jw_0() {
        this(-1L);
    }

    private jw_0(b<K, V> b2) {
        this(b2, new HashMap());
    }

    private jw_0(b<K, V> b2, Map<K, V> map2) {
        super(map2);
        if (b2 == null) {
            throw new NullPointerException("Policy must not be null.");
        }
        this.d = b2;
    }

    private jw_0(long l2) {
        this((b<K, V>)new jw.a(l2), (Map<K, V>)new HashMap());
    }

    private jw_0(long l2, Map<K, V> map2) {
        this((b<K, V>)new jw.a(l2), map2);
    }

    private jw_0(long l2, TimeUnit timeUnit) {
        this(jw_0.b(l2, timeUnit));
    }

    private jw_0(long l2, TimeUnit timeUnit, Map<K, V> map2) {
        this(jw_0.b(l2, timeUnit), map2);
    }

    private jw_0(Map<K, V> map2) {
        this(-1L, map2);
    }

    @Override
    public final void clear() {
        super.clear();
        this.c.clear();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final boolean containsKey(Object key) {
        void var1_1;
        this.a(key, System.currentTimeMillis());
        return super.containsKey(var1_1);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final boolean containsValue(Object value) {
        void var1_1;
        this.a(System.currentTimeMillis());
        return super.containsValue(var1_1);
    }

    @Override
    public final Set<Map.Entry<K, V>> entrySet() {
        this.a(System.currentTimeMillis());
        return super.entrySet();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final V get(Object key) {
        void var1_1;
        this.a(key, System.currentTimeMillis());
        return super.get(var1_1);
    }

    @Override
    public final boolean isEmpty() {
        this.a(System.currentTimeMillis());
        return super.isEmpty();
    }

    private static boolean a(long l2, Long l3) {
        if (l3 != null) {
            long l4 = l3;
            return l4 >= 0L && l2 >= l4;
        }
        return false;
    }

    @Override
    public final Set<K> keySet() {
        this.a(System.currentTimeMillis());
        return super.keySet();
    }

    private static long a() {
        return System.currentTimeMillis();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final V put(K key, V value) {
        void var2_2;
        void var1_1;
        long l2 = this.d.a();
        this.c.put(key, l2);
        return super.put(var1_1, var2_2);
    }

    @Override
    public final void putAll(Map<? extends K, ? extends V> mapToCopy) {
        for (Map.Entry<K, V> entry : mapToCopy.entrySet()) {
            ((jd_0)this).put(entry.getKey(), entry.getValue());
        }
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final V remove(Object key) {
        void var1_1;
        this.c.remove(key);
        return super.remove(var1_1);
    }

    private void a(long l2) {
        Iterator<Map.Entry<Object, Long>> iterator2 = this.c.entrySet().iterator();
        while (iterator2.hasNext()) {
            Map.Entry<Object, Long> entry = iterator2.next();
            if (!jw_0.a(l2, entry.getValue())) continue;
            super.remove(entry.getKey());
            iterator2.remove();
        }
    }

    private void a(Object object, long l2) {
        Long l3 = this.c.get(object);
        if (jw_0.a(l2, l3)) {
            ((jd_0)this).remove(object);
        }
    }

    @Override
    public final int size() {
        this.a(System.currentTimeMillis());
        return super.size();
    }

    private void a(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.a = (Map)objectInputStream.readObject();
    }

    private void a(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.a);
    }

    @Override
    public final Collection<V> values() {
        this.a(System.currentTimeMillis());
        return super.values();
    }

    static /* synthetic */ long a(long l2, TimeUnit timeUnit) {
        return jw_0.b(l2, timeUnit);
    }

    public static interface b<K, V>
    extends Serializable {
        public long a();
    }
}

