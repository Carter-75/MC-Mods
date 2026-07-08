/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Collections;
import java.util.Map;
import org.valkyrienskies.core.impl.shadow.ek_2;
import org.valkyrienskies.core.impl.shadow.ew_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.ed
 */
abstract class ed_2<K, V, V2>
implements ek_2<Map<K, V2>> {
    private final Map<K, ew_2<V>> a;

    ed_2(Map<K, ew_2<V>> map2) {
        this.a = Collections.unmodifiableMap(map2);
    }

    final Map<K, ew_2<V>> a() {
        return this.a;
    }

    static /* synthetic */ Map a(ed_2 ed_22) {
        return ed_22.a;
    }
}

