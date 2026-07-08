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
import org.valkyrienskies.core.impl.shadow.fn_2;
import org.valkyrienskies.core.impl.shadow.fu_1;
import org.valkyrienskies.core.impl.shadow.fu_2;
import org.valkyrienskies.core.impl.shadow.gc_1;
import org.valkyrienskies.core.impl.shadow.ib_1;
import org.valkyrienskies.core.impl.shadow.ib_2;
import org.valkyrienskies.core.impl.shadow.jF;
import org.valkyrienskies.core.impl.shadow.jd_0;
import org.valkyrienskies.core.impl.shadow.kC;

public final class jG<K, V>
extends jd_0<K, V>
implements Serializable,
fu_1 {
    private static final long b = 2737023427269031941L;

    public static <K, V> Map<K, V> a(Map<? extends K, ? extends V> map2) {
        if (map2 instanceof fu_1) {
            return map2;
        }
        return new jG<K, V>(map2);
    }

    private jG(Map<? extends K, ? extends V> map2) {
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

    @Override
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override
    public final V put(K key, V value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final void putAll(Map<? extends K, ? extends V> mapToCopy) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final V remove(Object key) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final fu_2<K, V> c() {
        if (this.a instanceof fn_2) {
            fu_2 fu_22 = ((fn_2)this.a).c();
            return ib_1.a(fu_22);
        }
        ib_2 ib_22 = new ib_2(this.a);
        return ib_1.a(ib_22);
    }

    @Override
    public final Set<Map.Entry<K, V>> entrySet() {
        Set set = super.entrySet();
        return jF.a(set);
    }

    @Override
    public final Set<K> keySet() {
        Set set = super.keySet();
        return kC.a(set);
    }

    @Override
    public final Collection<V> values() {
        Collection collection = super.values();
        return gc_1.b(collection);
    }
}

