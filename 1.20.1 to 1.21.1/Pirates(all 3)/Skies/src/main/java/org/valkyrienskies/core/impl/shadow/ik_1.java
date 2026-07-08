/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import java.util.Map;
import org.valkyrienskies.core.impl.shadow.fr_2;
import org.valkyrienskies.core.impl.shadow.jB;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.iK
 */
public final class ik_1<K, V>
implements Serializable,
Map.Entry<K, V>,
fr_2<K, V> {
    private static final long a = -8453869361373831205L;
    private final Map<K, V> b;
    private final K c;

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    public ik_1(jB jB2, Object object) {
        this.b = jB2;
        this.c = object;
    }

    @Override
    public final K getKey() {
        return this.c;
    }

    @Override
    public final V getValue() {
        return this.b.get(this.c);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final V setValue(V value) {
        void var1_1;
        if (value == this) {
            throw new IllegalArgumentException("Cannot set value to this map entry");
        }
        return this.b.put(this.c, var1_1);
    }

    @Override
    public final boolean equals(Object obj) {
        Map.Entry entry;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        entry = entry;
        V v = this.getValue();
        return (this.c == null ? entry.getKey() == null : this.c.equals(entry.getKey())) && (v == null ? entry.getValue() == null : v.equals(entry.getValue()));
    }

    @Override
    public final int hashCode() {
        V v = this.getValue();
        return (this.getKey() == null ? 0 : this.getKey().hashCode()) ^ (v == null ? 0 : v.hashCode());
    }

    public final String toString() {
        return this.getKey() + "=" + this.getValue();
    }
}

