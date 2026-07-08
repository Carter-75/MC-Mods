/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import org.valkyrienskies.core.impl.shadow.ff_1;
import org.valkyrienskies.core.impl.shadow.ja_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.jx
 */
public class jx_0<K, V>
extends ja_0<K, V>
implements Serializable {
    private static final long d = 7412622456128415156L;
    protected final ff_1<? super K> b;
    protected final ff_1<? super V> c;

    public static <K, V> jx_0<K, V> a(Map<K, V> map2, ff_1<? super K> ff_12, ff_1<? super V> ff_13) {
        return new jx_0<K, V>(map2, ff_12, ff_13);
    }

    /*
     * WARNING - void declaration
     */
    protected jx_0(Map<K, V> object, ff_1<? super K> object22, ff_1<? super V> ff_12) {
        super(object);
        void var3_5;
        this.b = object22;
        this.c = var3_5;
        for (Map.Entry entry : object.entrySet()) {
            this.a(entry.getKey(), entry.getValue());
        }
    }

    @Override
    private void a(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.a);
    }

    @Override
    private void a(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.a = (Map)objectInputStream.readObject();
    }

    private void a(K k2, V v) {
        if (this.b != null && !this.b.a(k2)) {
            throw new IllegalArgumentException("Cannot add key - Predicate rejected it");
        }
        if (this.c != null && !this.c.a(v)) {
            throw new IllegalArgumentException("Cannot add value - Predicate rejected it");
        }
    }

    @Override
    protected final V a(V v) {
        if (!this.c.a(v)) {
            throw new IllegalArgumentException("Cannot set value - Predicate rejected it");
        }
        return v;
    }

    @Override
    protected final boolean a() {
        return this.c != null;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public V put(K key, V value) {
        void var2_2;
        void var1_1;
        this.a(key, value);
        return this.a.put(var1_1, var2_2);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public void putAll(Map<? extends K, ? extends V> mapToCopy) {
        void var1_1;
        for (Map.Entry<K, V> entry : mapToCopy.entrySet()) {
            this.a(entry.getKey(), entry.getValue());
        }
        super.putAll(var1_1);
    }
}

