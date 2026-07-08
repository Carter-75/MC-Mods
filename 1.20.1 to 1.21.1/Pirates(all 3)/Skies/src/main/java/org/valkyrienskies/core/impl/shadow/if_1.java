/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Map;
import org.valkyrienskies.core.impl.shadow.ie_1;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.iF
 */
public abstract class if_1<K, V>
extends ie_1<K, V>
implements Map.Entry<K, V> {
    public if_1(K k2, V v) {
        super(k2, v);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public V setValue(V value) {
        void var1_1;
        return super.setValue(var1_1);
    }

    @Override
    public boolean equals(Object obj) {
        Map.Entry entry;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        entry = entry;
        return (this.getKey() == null ? entry.getKey() == null : this.getKey().equals(entry.getKey())) && (this.getValue() == null ? entry.getValue() == null : this.getValue().equals(entry.getValue()));
    }

    @Override
    public int hashCode() {
        return (this.getKey() == null ? 0 : this.getKey().hashCode()) ^ (this.getValue() == null ? 0 : this.getValue().hashCode());
    }
}

