/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import org.valkyrienskies.core.impl.shadow.fh_2;
import org.valkyrienskies.core.impl.shadow.fq_1;
import org.valkyrienskies.core.impl.shadow.gv_1;
import org.valkyrienskies.core.impl.shadow.hc_2;
import org.valkyrienskies.core.impl.shadow.jd_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.jj
 */
public final class jj_0<K, V>
extends jd_0<K, V>
implements Serializable {
    private static final long b = 19698628745827L;
    private final fq_1<? super K, ? extends V> c;

    private static <K, V> jj_0<K, V> a(Map<K, V> map2, V v) {
        return new jj_0<K, V>(map2, gv_1.b(v));
    }

    private static <K, V> jj_0<K, V> a(Map<K, V> map2, fh_2<? extends V> fh_22) {
        if (fh_22 == null) {
            throw new IllegalArgumentException("Factory must not be null");
        }
        return new jj_0<K, V>(map2, hc_2.a(fh_22));
    }

    private static <K, V> Map<K, V> a(Map<K, V> map2, fq_1<? super K, ? extends V> fq_12) {
        if (fq_12 == null) {
            throw new IllegalArgumentException("Transformer must not be null");
        }
        return new jj_0<K, V>(map2, fq_12);
    }

    private jj_0(V v) {
        this(gv_1.b(v));
    }

    private jj_0(fq_1<? super K, ? extends V> fq_12) {
        this(new HashMap(), fq_12);
    }

    private jj_0(Map<K, V> map2, fq_1<? super K, ? extends V> fq_12) {
        super(map2);
        if (fq_12 == null) {
            throw new NullPointerException("Transformer must not be null.");
        }
        this.c = fq_12;
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
    public final V get(Object key) {
        void var1_1;
        Object v = this.a.get(key);
        if (v != null || this.a.containsKey(key)) {
            return v;
        }
        return this.c.a(var1_1);
    }
}

