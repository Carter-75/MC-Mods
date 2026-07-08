/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.fr_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.iE
 */
public abstract class ie_1<K, V>
implements fr_2<K, V> {
    private K a;
    private V b;

    protected ie_1(K k2, V v) {
        this.a = k2;
        this.b = v;
    }

    @Override
    public K getKey() {
        return this.a;
    }

    protected K a(K k2) {
        K k3 = this.a;
        this.a = k2;
        return k3;
    }

    @Override
    public V getValue() {
        return this.b;
    }

    /*
     * WARNING - void declaration
     */
    protected V setValue(V value) {
        void var1_1;
        V v = this.b;
        this.b = var1_1;
        return v;
    }

    public String toString() {
        return "" + this.getKey() + '=' + this.getValue();
    }
}

