/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Map;
import org.valkyrienskies.core.impl.shadow.fr_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.iG
 */
public abstract class ig_1<K, V>
implements Map.Entry<K, V>,
fr_2<K, V> {
    private final Map.Entry<K, V> a;

    public ig_1(Map.Entry<K, V> entry) {
        if (entry == null) {
            throw new NullPointerException("Map Entry must not be null.");
        }
        this.a = entry;
    }

    protected final Map.Entry<K, V> a() {
        return this.a;
    }

    @Override
    public K getKey() {
        return this.a.getKey();
    }

    @Override
    public V getValue() {
        return this.a.getValue();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public V setValue(V object) {
        void var1_1;
        return this.a.setValue(var1_1);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public boolean equals(Object object) {
        void var1_1;
        if (object == this) {
            return true;
        }
        return this.a.equals(var1_1);
    }

    @Override
    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return this.a.toString();
    }
}

