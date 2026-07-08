/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Map;
import org.valkyrienskies.core.impl.shadow.fr_2;
import org.valkyrienskies.core.impl.shadow.ie_1;
import org.valkyrienskies.core.impl.shadow.ii_1;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.iH
 */
public final class ih_1<K, V>
extends ie_1<K, V> {
    public ih_1() {
        super(null, null);
    }

    private ih_1(K k2, V v) {
        super(k2, v);
    }

    private ih_1(fr_2<? extends K, ? extends V> fr_22) {
        super(fr_22.getKey(), fr_22.getValue());
    }

    private ih_1(Map.Entry<? extends K, ? extends V> entry) {
        super(entry.getKey(), entry.getValue());
    }

    @Override
    public final K a(K k2) {
        if (k2 == this) {
            throw new IllegalArgumentException("DefaultKeyValue may not contain itself as a key.");
        }
        return super.a(k2);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final V setValue(V value) {
        void var1_1;
        if (value == this) {
            throw new IllegalArgumentException("DefaultKeyValue may not contain itself as a value.");
        }
        return super.setValue(var1_1);
    }

    private Map.Entry<K, V> a() {
        return new ii_1(this);
    }

    public final boolean equals(Object obj) {
        ih_1 ih_12;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ih_1)) {
            return false;
        }
        ih_12 = ih_12;
        return (this.getKey() == null ? ih_12.getKey() == null : this.getKey().equals(ih_12.getKey())) && (this.getValue() == null ? ih_12.getValue() == null : this.getValue().equals(ih_12.getValue()));
    }

    public final int hashCode() {
        return (this.getKey() == null ? 0 : this.getKey().hashCode()) ^ (this.getValue() == null ? 0 : this.getValue().hashCode());
    }
}

