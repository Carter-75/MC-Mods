/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import org.valkyrienskies.core.impl.shadow.fq_1;
import org.valkyrienskies.core.impl.shadow.ja_0;
import org.valkyrienskies.core.impl.shadow.jd_0;
import org.valkyrienskies.core.impl.shadow.js_0;

public class jD<K, V>
extends ja_0<K, V>
implements Serializable {
    private static final long d = 7023152376788900464L;
    protected final fq_1<? super K, ? extends K> b;
    protected final fq_1<? super V, ? extends V> c;

    public static <K, V> jD<K, V> a(Map<K, V> map2, fq_1<? super K, ? extends K> fq_12, fq_1<? super V, ? extends V> fq_13) {
        return new jD<K, V>(map2, fq_12, fq_13);
    }

    private static <K, V> jD<K, V> b(Map<K, V> map2, fq_1<? super K, ? extends K> object, fq_1<? super V, ? extends V> fq_12) {
        object = new jD<K, V>(map2, object, fq_12);
        if (map2.size() > 0) {
            map2 = ((jD)object).a((V)map2);
            ((jd_0)object).clear();
            ((jd_0)object).i().putAll(map2);
        }
        return object;
    }

    protected jD(Map<K, V> map2, fq_1<? super K, ? extends K> fq_12, fq_1<? super V, ? extends V> fq_13) {
        super(map2);
        this.b = fq_12;
        this.c = fq_13;
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

    private K b(K k2) {
        if (this.b == null) {
            return k2;
        }
        return this.b.a(k2);
    }

    private V c(V v) {
        if (this.c == null) {
            return v;
        }
        return this.c.a(v);
    }

    @Override
    protected final Map<K, V> a(Map<? extends K, ? extends V> object) {
        if (object.isEmpty()) {
            return object;
        }
        js_0 js_02 = new js_0(object.size());
        for (Map.Entry entry : object.entrySet()) {
            js_02.put(this.b(entry.getKey()), this.c(entry.getValue()));
        }
        return js_02;
    }

    @Override
    protected final V a(V v) {
        return this.c.a(v);
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
        key = this.b(key);
        value = this.c(value);
        return this.i().put(var1_1, var2_2);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public void putAll(Map<? extends K, ? extends V> mapToCopy) {
        void var1_1;
        mapToCopy = this.a((V)mapToCopy);
        this.i().putAll(var1_1);
    }
}

