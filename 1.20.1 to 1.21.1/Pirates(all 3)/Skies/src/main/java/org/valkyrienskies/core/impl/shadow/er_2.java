/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Collections;
import java.util.Map;
import org.valkyrienskies.core.impl.shadow.eg_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.er
 */
public final class er_2<K, V> {
    private final Map<K, V> a;

    private er_2(int size) {
        this.a = eg_2.c(size);
    }

    private static <K, V> er_2<K, V> a(int size) {
        return new er_2<K, V>(size);
    }

    private er_2<K, V> a(K key, V value) {
        this.a.put(key, value);
        return this;
    }

    private er_2<K, V> a(Map<K, V> map2) {
        this.a.putAll(map2);
        return this;
    }

    private Map<K, V> a() {
        if (this.a.isEmpty()) {
            return Collections.emptyMap();
        }
        return Collections.unmodifiableMap(this.a);
    }
}

