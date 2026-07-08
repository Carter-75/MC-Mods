/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Comparator;
import java.util.SortedMap;
import org.valkyrienskies.core.impl.shadow.fq_1;
import org.valkyrienskies.core.impl.shadow.jD;
import org.valkyrienskies.core.impl.shadow.jd_0;

public final class jE<K, V>
extends jD<K, V>
implements SortedMap<K, V> {
    private static final long d = -8751771676410385778L;

    public static <K, V> jE<K, V> a(SortedMap<K, V> sortedMap, fq_1<? super K, ? extends K> fq_12, fq_1<? super V, ? extends V> fq_13) {
        return new jE<K, V>(sortedMap, fq_12, fq_13);
    }

    private static <K, V> jE<K, V> b(SortedMap<K, V> sortedMap, fq_1<? super K, ? extends K> object, fq_1<? super V, ? extends V> fq_12) {
        object = new jE<K, V>(sortedMap, object, fq_12);
        if (sortedMap.size() > 0) {
            sortedMap = ((jD)object).a(sortedMap);
            ((jd_0)object).clear();
            ((jd_0)object).i().putAll(sortedMap);
        }
        return object;
    }

    private jE(SortedMap<K, V> sortedMap, fq_1<? super K, ? extends K> fq_12, fq_1<? super V, ? extends V> fq_13) {
        super(sortedMap, fq_12, fq_13);
    }

    private SortedMap<K, V> b() {
        return (SortedMap)this.a;
    }

    @Override
    public final K firstKey() {
        jE jE2 = this;
        return ((SortedMap)jE2.a).firstKey();
    }

    @Override
    public final K lastKey() {
        jE jE2 = this;
        return ((SortedMap)jE2.a).lastKey();
    }

    @Override
    public final Comparator<? super K> comparator() {
        jE jE2 = this;
        return ((SortedMap)jE2.a).comparator();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final SortedMap<K, V> subMap(K fromKey, K toKey) {
        void var2_2;
        SortedMap sortedMap;
        jE jE2 = this;
        sortedMap = ((SortedMap)jE2.a).subMap(sortedMap, var2_2);
        return new jE(sortedMap, this.b, this.c);
    }

    @Override
    public final SortedMap<K, V> headMap(K toKey) {
        SortedMap sortedMap;
        jE jE2 = this;
        sortedMap = ((SortedMap)jE2.a).headMap(sortedMap);
        return new jE(sortedMap, this.b, this.c);
    }

    @Override
    public final SortedMap<K, V> tailMap(K fromKey) {
        SortedMap sortedMap;
        jE jE2 = this;
        sortedMap = ((SortedMap)jE2.a).tailMap(sortedMap);
        return new jE(sortedMap, this.b, this.c);
    }
}

