/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Comparator;
import java.util.SortedMap;
import org.valkyrienskies.core.impl.shadow.ff_1;
import org.valkyrienskies.core.impl.shadow.jx_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.jy
 */
public final class jy_0<K, V>
extends jx_0<K, V>
implements SortedMap<K, V> {
    private static final long d = 3359846175935304332L;

    public static <K, V> jy_0<K, V> a(SortedMap<K, V> sortedMap, ff_1<? super K> ff_12, ff_1<? super V> ff_13) {
        return new jy_0<K, V>(sortedMap, ff_12, ff_13);
    }

    private jy_0(SortedMap<K, V> sortedMap, ff_1<? super K> ff_12, ff_1<? super V> ff_13) {
        super(sortedMap, ff_12, ff_13);
    }

    private SortedMap<K, V> b() {
        return (SortedMap)this.a;
    }

    @Override
    public final K firstKey() {
        jy_0 jy_02 = this;
        return ((SortedMap)jy_02.a).firstKey();
    }

    @Override
    public final K lastKey() {
        jy_0 jy_02 = this;
        return ((SortedMap)jy_02.a).lastKey();
    }

    @Override
    public final Comparator<? super K> comparator() {
        jy_0 jy_02 = this;
        return ((SortedMap)jy_02.a).comparator();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final SortedMap<K, V> subMap(K fromKey, K toKey) {
        void var2_2;
        SortedMap sortedMap;
        jy_0 jy_02 = this;
        sortedMap = ((SortedMap)jy_02.a).subMap(sortedMap, var2_2);
        return new jy_0(sortedMap, this.b, this.c);
    }

    @Override
    public final SortedMap<K, V> headMap(K toKey) {
        SortedMap sortedMap;
        jy_0 jy_02 = this;
        sortedMap = ((SortedMap)jy_02.a).headMap(sortedMap);
        return new jy_0(sortedMap, this.b, this.c);
    }

    @Override
    public final SortedMap<K, V> tailMap(K fromKey) {
        SortedMap sortedMap;
        jy_0 jy_02 = this;
        sortedMap = ((SortedMap)jy_02.a).tailMap(sortedMap);
        return new jy_0(sortedMap, this.b, this.c);
    }
}

