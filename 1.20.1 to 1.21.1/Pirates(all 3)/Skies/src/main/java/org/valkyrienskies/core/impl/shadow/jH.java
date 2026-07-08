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
import org.valkyrienskies.core.impl.shadow.fd_1;
import org.valkyrienskies.core.impl.shadow.fe_1;
import org.valkyrienskies.core.impl.shadow.fu_1;
import org.valkyrienskies.core.impl.shadow.fu_2;
import org.valkyrienskies.core.impl.shadow.gc_1;
import org.valkyrienskies.core.impl.shadow.ic_1;
import org.valkyrienskies.core.impl.shadow.jF;
import org.valkyrienskies.core.impl.shadow.je_0;
import org.valkyrienskies.core.impl.shadow.kC;

public final class jH<K, V>
extends je_0<K, V>
implements Serializable,
fu_1 {
    private static final long b = 8136428161720526266L;

    private static <K, V> fd_1<K, V> a(fd_1<? extends K, ? extends V> fd_12) {
        if (fd_12 instanceof fu_1) {
            return fd_12;
        }
        return new jH<K, V>(fd_12);
    }

    private jH(fd_1<? extends K, ? extends V> fd_12) {
        super(fd_12);
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
    public final fe_1<K, V> e() {
        fe_1 fe_12 = this.a().e();
        return ic_1.a(fe_12);
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

    @Override
    public final /* synthetic */ fu_2 c() {
        return ((je_0)this).e();
    }
}

