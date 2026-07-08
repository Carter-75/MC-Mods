/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Map;
import org.valkyrienskies.core.impl.shadow.fr_2;
import org.valkyrienskies.core.impl.shadow.fu_1;
import org.valkyrienskies.core.impl.shadow.if_1;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.iL
 */
public final class il_1<K, V>
extends if_1<K, V>
implements fu_1 {
    public il_1(K k2, V v) {
        super(k2, v);
    }

    private il_1(fr_2<? extends K, ? extends V> fr_22) {
        super(fr_22.getKey(), fr_22.getValue());
    }

    private il_1(Map.Entry<? extends K, ? extends V> entry) {
        super(entry.getKey(), entry.getValue());
    }

    @Override
    public final V setValue(V value) {
        throw new UnsupportedOperationException("setValue() is not supported");
    }
}

