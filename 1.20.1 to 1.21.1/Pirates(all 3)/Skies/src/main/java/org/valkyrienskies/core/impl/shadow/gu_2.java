/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import org.valkyrienskies.core.impl.shadow.ey_1;
import org.valkyrienskies.core.impl.shadow.fb_1;
import org.valkyrienskies.core.impl.shadow.fe_1;
import org.valkyrienskies.core.impl.shadow.fo_1;
import org.valkyrienskies.core.impl.shadow.fu_1;
import org.valkyrienskies.core.impl.shadow.fu_2;
import org.valkyrienskies.core.impl.shadow.gk_2;
import org.valkyrienskies.core.impl.shadow.gm_2;
import org.valkyrienskies.core.impl.shadow.gn_2;
import org.valkyrienskies.core.impl.shadow.ic_1;
import org.valkyrienskies.core.impl.shadow.jF;
import org.valkyrienskies.core.impl.shadow.jI;
import org.valkyrienskies.core.impl.shadow.kC;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.gu
 */
public final class gu_2<K, V>
extends gn_2<K, V>
implements fu_1 {
    private gu_2<V, K> b;

    private static <K, V> fo_1<K, V> a(fo_1<K, ? extends V> fo_12) {
        if (fo_12 instanceof fu_1) {
            return fo_12;
        }
        return new gu_2<K, V>(fo_12);
    }

    private gu_2(fo_1<K, ? extends V> fo_12) {
        super(fo_12);
    }

    @Override
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override
    public final V put(K key, V value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final void putAll(Map<? extends K, ? extends V> mapToCopy) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final V remove(Object key) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final Set<Map.Entry<K, V>> entrySet() {
        Set set = super.entrySet();
        return jF.a(set);
    }

    @Override
    public final Set<K> keySet() {
        Set set = super.keySet();
        return kC.a(set);
    }

    @Override
    public final Set<V> b() {
        Set set = super.b();
        return kC.a(set);
    }

    @Override
    public final K b(Object object) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final fe_1<K, V> e() {
        fe_1 fe_12 = this.k().e();
        return ic_1.a(fe_12);
    }

    @Override
    public final fo_1<V, K> f() {
        if (this.b == null) {
            this.b = new gu_2<K, V>(this.k().f());
            this.b.b = this;
        }
        return this.b;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final SortedMap<K, V> subMap(K fromKey, K toKey) {
        void var2_2;
        SortedMap sortedMap;
        sortedMap = this.k().subMap((void)sortedMap, var2_2);
        return jI.a(sortedMap);
    }

    @Override
    public final SortedMap<K, V> headMap(K toKey) {
        SortedMap sortedMap;
        sortedMap = this.k().headMap((void)sortedMap);
        return jI.a(sortedMap);
    }

    @Override
    public final SortedMap<K, V> tailMap(K fromKey) {
        SortedMap sortedMap;
        sortedMap = this.k().tailMap((void)sortedMap);
        return jI.a(sortedMap);
    }

    @Override
    public final /* synthetic */ fb_1 d() {
        return ((gn_2)this).f();
    }

    @Override
    public final /* synthetic */ ey_1 a() {
        return ((gn_2)this).f();
    }

    @Override
    public final /* synthetic */ Collection values() {
        return ((gk_2)this).b();
    }

    @Override
    public final /* synthetic */ fu_2 c() {
        return ((gm_2)this).e();
    }
}

