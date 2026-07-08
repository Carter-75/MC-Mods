/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Comparator;
import java.util.SortedMap;
import org.valkyrienskies.core.impl.shadow.fh_2;
import org.valkyrienskies.core.impl.shadow.fq_1;
import org.valkyrienskies.core.impl.shadow.jq_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.jr
 */
public final class jr_0<K, V>
extends jq_0<K, V>
implements SortedMap<K, V> {
    private static final long c = 2715322183617658933L;

    public static <K, V> jr_0<K, V> a(SortedMap<K, V> sortedMap, fh_2<? extends V> fh_22) {
        return new jr_0<K, V>(sortedMap, fh_22);
    }

    public static <K, V> jr_0<K, V> a(SortedMap<K, V> sortedMap, fq_1<? super K, ? extends V> fq_12) {
        return new jr_0<K, V>(sortedMap, fq_12);
    }

    private jr_0(SortedMap<K, V> sortedMap, fh_2<? extends V> fh_22) {
        super(sortedMap, fh_22);
    }

    private jr_0(SortedMap<K, V> sortedMap, fq_1<? super K, ? extends V> fq_12) {
        super(sortedMap, fq_12);
    }

    private SortedMap<K, V> a() {
        return (SortedMap)this.a;
    }

    @Override
    public final K firstKey() {
        jr_0 jr_02 = this;
        return ((SortedMap)jr_02.a).firstKey();
    }

    @Override
    public final K lastKey() {
        jr_0 jr_02 = this;
        return ((SortedMap)jr_02.a).lastKey();
    }

    @Override
    public final Comparator<? super K> comparator() {
        jr_0 jr_02 = this;
        return ((SortedMap)jr_02.a).comparator();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final SortedMap<K, V> subMap(K fromKey, K toKey) {
        void var2_2;
        SortedMap sortedMap;
        jr_0 jr_02 = this;
        sortedMap = ((SortedMap)jr_02.a).subMap(sortedMap, var2_2);
        return new jr_0(sortedMap, this.b);
    }

    @Override
    public final SortedMap<K, V> headMap(K toKey) {
        SortedMap sortedMap;
        jr_0 jr_02 = this;
        sortedMap = ((SortedMap)jr_02.a).headMap(sortedMap);
        return new jr_0(sortedMap, this.b);
    }

    @Override
    public final SortedMap<K, V> tailMap(K fromKey) {
        SortedMap sortedMap;
        jr_0 jr_02 = this;
        sortedMap = ((SortedMap)jr_02.a).tailMap(sortedMap);
        return new jr_0(sortedMap, this.b);
    }
}

