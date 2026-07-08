/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import org.valkyrienskies.core.impl.shadow.fh_1;
import org.valkyrienskies.core.impl.shadow.fq_1;
import org.valkyrienskies.core.impl.shadow.js_0;
import org.valkyrienskies.core.impl.shadow.kE;

public final class kF<J, K, U, V>
extends kE<K, V>
implements Serializable,
fh_1<J, U> {
    private static final long b = 5966875321133456994L;
    private final fq_1<? super J, ? extends K> c;
    private final fq_1<? super U, ? extends V> d;

    private static <J, K, U, V> kF<J, K, U, V> a(Map<K, V> map2, fq_1<? super J, ? extends K> fq_12, fq_1<? super U, ? extends V> fq_13) {
        return new kF<J, K, U, V>(map2, fq_12, fq_13);
    }

    private kF(Map<K, V> map2, fq_1<? super J, ? extends K> fq_12, fq_1<? super U, ? extends V> fq_13) {
        super(map2);
        if (fq_12 == null) {
            throw new NullPointerException("KeyTransformer must not be null.");
        }
        this.c = fq_12;
        if (fq_13 == null) {
            throw new NullPointerException("ValueTransformer must not be null.");
        }
        this.d = fq_13;
    }

    private void a(ObjectOutputStream object) {
        ((ObjectOutputStream)object).defaultWriteObject();
        ObjectOutputStream objectOutputStream = object;
        object = this;
        objectOutputStream.writeObject(((kE)object).a);
    }

    private void a(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.a = (Map)objectInputStream.readObject();
    }

    private K a(J j2) {
        return this.c.a(j2);
    }

    private V b(U u) {
        return this.d.a(u);
    }

    private Map<K, V> a(Map<? extends J, ? extends U> object) {
        if (object.isEmpty()) {
            return object;
        }
        js_0 js_02 = new js_0(object.size());
        for (Map.Entry entry : object.entrySet()) {
            js_02.put(this.a(entry.getKey()), this.b(entry.getValue()));
        }
        return js_02;
    }

    private V c(U u) {
        return this.d.a(u);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final V put(J key, U value) {
        void var2_2;
        void var1_1;
        kF kF2 = this;
        return kF2.a.put(this.a(var1_1), this.b(var2_2));
    }

    @Override
    public final void putAll(Map<? extends J, ? extends U> mapToCopy) {
        Serializable serializable;
        kF kF2;
        Object object = this;
        Map map2 = ((kE)object).a;
        object = kF2;
        kF2 = this;
        if (object.isEmpty()) {
            serializable = object;
        } else {
            js_0 js_02 = new js_0(object.size());
            for (Map.Entry entry : object.entrySet()) {
                js_02.put(kF2.a(entry.getKey()), kF2.b(entry.getValue()));
            }
            serializable = js_02;
        }
        map2.putAll(serializable);
    }

    @Override
    public final void clear() {
        kF kF2 = this;
        kF2.a.clear();
    }
}

