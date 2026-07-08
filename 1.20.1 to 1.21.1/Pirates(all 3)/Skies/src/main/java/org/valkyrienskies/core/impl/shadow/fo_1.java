/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Comparator;
import java.util.SortedMap;
import org.valkyrienskies.core.impl.shadow.fb_1;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.fO
 */
public interface fo_1<K, V>
extends SortedMap<K, V>,
fb_1<K, V> {
    public fo_1<V, K> f();

    public Comparator<? super V> g();
}

