/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import org.valkyrienskies.core.impl.shadow.ey_1;
import org.valkyrienskies.core.impl.shadow.fb_1;
import org.valkyrienskies.core.impl.shadow.fo_1;
import org.valkyrienskies.core.impl.shadow.gm_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.gn
 */
public abstract class gn_2<K, V>
extends gm_2<K, V>
implements fo_1<K, V> {
    public gn_2(fo_1<K, V> fo_12) {
        super(fo_12);
    }

    protected final fo_1<K, V> k() {
        return (fo_1)super.j();
    }

    @Override
    public fo_1<V, K> f() {
        gn_2 gn_22 = this;
        return ((fo_1)super.j()).f();
    }

    @Override
    public Comparator<? super K> comparator() {
        gn_2 gn_22 = this;
        return ((fo_1)super.j()).comparator();
    }

    @Override
    public final Comparator<? super V> g() {
        gn_2 gn_22 = this;
        return ((fo_1)super.j()).g();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public SortedMap<K, V> subMap(K fromKey, K toKey) {
        void var2_2;
        void var1_1;
        gn_2 gn_22 = this;
        return ((fo_1)super.j()).subMap(var1_1, var2_2);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public SortedMap<K, V> headMap(K toKey) {
        void var1_1;
        gn_2 gn_22 = this;
        return ((fo_1)super.j()).headMap(var1_1);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public SortedMap<K, V> tailMap(K fromKey) {
        void var1_1;
        gn_2 gn_22 = this;
        return ((fo_1)super.j()).tailMap(var1_1);
    }

    @Override
    public /* synthetic */ fb_1 d() {
        return this.f();
    }

    @Override
    public /* synthetic */ ey_1 a() {
        return this.f();
    }

    @Override
    protected final /* synthetic */ ey_1 h() {
        gn_2 gn_22 = this;
        return (fo_1)super.j();
    }

    @Override
    public final /* synthetic */ Map i() {
        gn_2 gn_22 = this;
        return (fo_1)super.j();
    }
}

