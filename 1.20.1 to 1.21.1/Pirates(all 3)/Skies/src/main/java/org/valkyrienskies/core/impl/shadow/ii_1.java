/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Map;
import org.valkyrienskies.core.impl.shadow.if_1;
import org.valkyrienskies.core.impl.shadow.ih_1;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.iI
 */
public final class ii_1<K, V>
extends if_1<K, V> {
    private ii_1(K k2, V v) {
        super(k2, v);
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    public ii_1(ih_1 ih_12) {
        super(ih_12.getKey(), ih_12.getValue());
    }

    public ii_1(Map.Entry<? extends K, ? extends V> entry) {
        super(entry.getKey(), entry.getValue());
    }
}

