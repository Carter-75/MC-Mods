/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.valkyrienskies.core.impl.shadow.ey_1;
import org.valkyrienskies.core.impl.shadow.fu_1;
import org.valkyrienskies.core.impl.shadow.fu_2;
import org.valkyrienskies.core.impl.shadow.gk_2;
import org.valkyrienskies.core.impl.shadow.ib_1;
import org.valkyrienskies.core.impl.shadow.jF;
import org.valkyrienskies.core.impl.shadow.kC;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.gs
 */
public final class gs_2<K, V>
extends gk_2<K, V>
implements fu_1 {
    private gs_2<V, K> b;

    private static <K, V> ey_1<K, V> a(ey_1<? extends K, ? extends V> ey_12) {
        if (ey_12 instanceof fu_1) {
            return ey_12;
        }
        return new gs_2<K, V>(ey_12);
    }

    private gs_2(ey_1<? extends K, ? extends V> ey_12) {
        super(ey_12);
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
    public final fu_2<K, V> c() {
        fu_2 fu_22 = this.h().c();
        return ib_1.a(fu_22);
    }

    @Override
    public final synchronized ey_1<V, K> a() {
        if (this.b == null) {
            this.b = new gs_2<K, V>(this.h().a());
            this.b.b = this;
        }
        return this.b;
    }

    @Override
    public final /* synthetic */ Collection values() {
        return ((gk_2)this).b();
    }
}

