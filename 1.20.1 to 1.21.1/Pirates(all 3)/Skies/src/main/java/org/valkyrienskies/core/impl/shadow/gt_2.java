/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.valkyrienskies.core.impl.shadow.ey_1;
import org.valkyrienskies.core.impl.shadow.fb_1;
import org.valkyrienskies.core.impl.shadow.fe_1;
import org.valkyrienskies.core.impl.shadow.fu_1;
import org.valkyrienskies.core.impl.shadow.fu_2;
import org.valkyrienskies.core.impl.shadow.gk_2;
import org.valkyrienskies.core.impl.shadow.gm_2;
import org.valkyrienskies.core.impl.shadow.ic_1;
import org.valkyrienskies.core.impl.shadow.jF;
import org.valkyrienskies.core.impl.shadow.kC;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.gt
 */
public final class gt_2<K, V>
extends gm_2<K, V>
implements fu_1 {
    private gt_2<V, K> b;

    private static <K, V> fb_1<K, V> a(fb_1<? extends K, ? extends V> fb_12) {
        if (fb_12 instanceof fu_1) {
            return fb_12;
        }
        return new gt_2<K, V>(fb_12);
    }

    private gt_2(fb_1<? extends K, ? extends V> fb_12) {
        super(fb_12);
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
    public final fb_1<V, K> d() {
        gt_2 gt_22 = this;
        if (gt_22.b == null) {
            gt_22.b = new gt_2<K, V>(gt_22.j().d());
            gt_22.b.b = gt_22;
        }
        return gt_22.b;
    }

    @Override
    public final fe_1<K, V> e() {
        fe_1 fe_12 = this.j().e();
        return ic_1.a(fe_12);
    }

    private fb_1<V, K> f() {
        if (this.b == null) {
            this.b = new gt_2<K, V>(this.j().d());
            this.b.b = this;
        }
        return this.b;
    }

    @Override
    public final /* synthetic */ ey_1 a() {
        return ((gm_2)this).d();
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

