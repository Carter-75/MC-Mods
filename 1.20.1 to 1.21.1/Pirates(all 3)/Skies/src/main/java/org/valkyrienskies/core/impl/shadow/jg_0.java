/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Comparator;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import org.valkyrienskies.core.impl.shadow.fe_1;
import org.valkyrienskies.core.impl.shadow.fo_2;
import org.valkyrienskies.core.impl.shadow.fu_2;
import org.valkyrienskies.core.impl.shadow.ij_2;
import org.valkyrienskies.core.impl.shadow.jd_0;
import org.valkyrienskies.core.impl.shadow.jk_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.jg
 */
public abstract class jg_0<K, V>
extends jd_0<K, V>
implements fo_2<K, V> {
    protected jg_0() {
    }

    public jg_0(SortedMap<K, V> sortedMap) {
        super(sortedMap);
    }

    public SortedMap<K, V> c_() {
        return (SortedMap)super.i();
    }

    @Override
    public Comparator<? super K> comparator() {
        return this.c_().comparator();
    }

    @Override
    public K firstKey() {
        return this.c_().firstKey();
    }

    @Override
    public K lastKey() {
        return this.c_().lastKey();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public SortedMap<K, V> subMap(K fromKey, K toKey) {
        void var2_2;
        void var1_1;
        return this.c_().subMap(var1_1, var2_2);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public SortedMap<K, V> headMap(K toKey) {
        void var1_1;
        return this.c_().headMap(var1_1);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public SortedMap<K, V> tailMap(K fromKey) {
        void var1_1;
        return this.c_().tailMap(var1_1);
    }

    @Override
    public K d(K object) {
        if ((object = this.headMap(object)).isEmpty()) {
            return null;
        }
        return object.lastKey();
    }

    @Override
    public K c(K object) {
        object = this.tailMap(object).keySet().iterator();
        object.next();
        if (object.hasNext()) {
            return (K)object.next();
        }
        return null;
    }

    @Override
    public final fe_1<K, V> e() {
        return new a(this.entrySet());
    }

    @Override
    protected /* synthetic */ Map i() {
        return this.c_();
    }

    @Override
    public final /* synthetic */ fu_2 c() {
        return this.e();
    }

    protected static final class a<K, V>
    extends jk_0<K, V>
    implements fe_1<K, V> {
        protected a(Set<Map.Entry<K, V>> set) {
            super(set);
        }

        @Override
        public final synchronized void c() {
            super.c();
            this.a = new ij_2(this.a);
        }

        @Override
        public final boolean hasPrevious() {
            return ((ListIterator)this.a).hasPrevious();
        }

        @Override
        public final K previous() {
            this.b = (Map.Entry)((ListIterator)this.a).previous();
            return this.a();
        }
    }
}

