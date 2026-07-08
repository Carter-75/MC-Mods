/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import org.valkyrienskies.core.impl.shadow.fh_2;
import org.valkyrienskies.core.impl.shadow.fq_1;
import org.valkyrienskies.core.impl.shadow.hc_2;
import org.valkyrienskies.core.impl.shadow.jd_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.jq
 */
public class jq_0<K, V>
extends jd_0<K, V>
implements Serializable {
    private static final long c = 7990956402564206740L;
    protected final fq_1<? super K, ? extends V> b;

    public static <K, V> jq_0<K, V> a(Map<K, V> map2, fh_2<? extends V> fh_22) {
        return new jq_0<K, V>(map2, fh_22);
    }

    public static <V, K> jq_0<K, V> a(Map<K, V> map2, fq_1<? super K, ? extends V> fq_12) {
        return new jq_0<K, V>(map2, fq_12);
    }

    protected jq_0(Map<K, V> map2, fh_2<? extends V> fh_22) {
        super(map2);
        if (fh_22 == null) {
            throw new NullPointerException("Factory must not be null");
        }
        this.b = hc_2.a(fh_22);
    }

    protected jq_0(Map<K, V> map2, fq_1<? super K, ? extends V> fq_12) {
        super(map2);
        if (fq_12 == null) {
            throw new NullPointerException("Factory must not be null");
        }
        this.b = fq_12;
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
    public V get(Object key) {
        Object object;
        if (!this.a.containsKey(key)) {
            object = key;
            V v = this.b.a(object);
            this.a.put(object, v);
            return v;
        }
        return this.a.get(object);
    }
}

