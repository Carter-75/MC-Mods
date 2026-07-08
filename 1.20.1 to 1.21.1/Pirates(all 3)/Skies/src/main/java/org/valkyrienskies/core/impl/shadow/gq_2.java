/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.valkyrienskies.core.impl.shadow.gq
 *  org.valkyrienskies.core.impl.shadow.gq$a
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import org.valkyrienskies.core.impl.shadow.ey_1;
import org.valkyrienskies.core.impl.shadow.fb_1;
import org.valkyrienskies.core.impl.shadow.fd_1;
import org.valkyrienskies.core.impl.shadow.fe_1;
import org.valkyrienskies.core.impl.shadow.fo_1;
import org.valkyrienskies.core.impl.shadow.fu_2;
import org.valkyrienskies.core.impl.shadow.gl_2;
import org.valkyrienskies.core.impl.shadow.gq;
import org.valkyrienskies.core.impl.shadow.jg_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.gq
 */
public final class gq_2<K, V>
extends gl_2<K, V>
implements Serializable,
fo_1<K, V> {
    private static final long d = 721969328361809L;
    private final Comparator<? super K> e;
    private final Comparator<? super V> f;

    public gq_2() {
        super(new TreeMap(), new TreeMap());
        this.e = null;
        this.f = null;
    }

    private gq_2(Map<? extends K, ? extends V> map2) {
        super(new TreeMap(), new TreeMap());
        this.putAll(map2);
        this.e = null;
        this.f = null;
    }

    private gq_2(Comparator<? super K> comparator, Comparator<? super V> comparator2) {
        super(new TreeMap(comparator), new TreeMap(comparator2));
        this.e = comparator;
        this.f = comparator2;
    }

    protected gq_2(Map<K, V> map2, Map<V, K> map3, ey_1<V, K> ey_12) {
        super(map2, map3, ey_12);
        this.e = ((SortedMap)map2).comparator();
        this.f = ((SortedMap)map3).comparator();
    }

    private static gq_2<V, K> a(Map<V, K> map2, Map<K, V> map3, ey_1<K, V> ey_12) {
        return new gq_2(map2, map3, ey_12);
    }

    @Override
    public final Comparator<? super K> comparator() {
        return ((SortedMap)this.a).comparator();
    }

    @Override
    public final Comparator<? super V> g() {
        return ((SortedMap)this.b).comparator();
    }

    @Override
    public final K firstKey() {
        return ((SortedMap)this.a).firstKey();
    }

    @Override
    public final K lastKey() {
        return ((SortedMap)this.a).lastKey();
    }

    @Override
    public final K c(K object) {
        if (this.isEmpty()) {
            return null;
        }
        if (this.a instanceof fd_1) {
            return ((fd_1)this.a).c(object);
        }
        SortedMap sortedMap = (SortedMap)this.a;
        object = sortedMap.tailMap(object).keySet().iterator();
        object.next();
        if (object.hasNext()) {
            return (K)object.next();
        }
        return null;
    }

    @Override
    public final K d(K object) {
        if (this.isEmpty()) {
            return null;
        }
        if (this.a instanceof fd_1) {
            return ((fd_1)this.a).d(object);
        }
        SortedMap sortedMap = (SortedMap)this.a;
        if ((object = sortedMap.headMap(object)).isEmpty()) {
            return null;
        }
        return object.lastKey();
    }

    @Override
    public final fe_1<K, V> e() {
        return new gq.a(this);
    }

    private fo_1<V, K> h() {
        gq_2 gq_22 = this;
        return (fo_1)super.a();
    }

    private fb_1<V, K> i() {
        gq_2 gq_22 = this;
        return (fo_1)super.a();
    }

    @Override
    public final SortedMap<K, V> headMap(K toKey) {
        SortedMap sortedMap;
        sortedMap = ((SortedMap)this.a).headMap(sortedMap);
        return new b(this, sortedMap);
    }

    @Override
    public final SortedMap<K, V> tailMap(K fromKey) {
        SortedMap sortedMap;
        sortedMap = ((SortedMap)this.a).tailMap(sortedMap);
        return new b(this, sortedMap);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final SortedMap<K, V> subMap(K fromKey, K toKey) {
        void var2_2;
        SortedMap sortedMap;
        sortedMap = ((SortedMap)this.a).subMap(sortedMap, var2_2);
        return new b(this, sortedMap);
    }

    @Override
    public final fo_1<V, K> f() {
        return (fo_1)super.a();
    }

    private void a(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.a);
    }

    private void a(ObjectInputStream object) {
        ((ObjectInputStream)object).defaultReadObject();
        this.a = new TreeMap(this.e);
        this.b = new TreeMap(this.f);
        object = (Map)((ObjectInputStream)object).readObject();
        this.putAll(object);
    }

    @Override
    public final /* synthetic */ fu_2 c() {
        return this.e();
    }

    @Override
    protected final /* synthetic */ gl_2 a(Map map2, Map map3, gl_2 gl_22) {
        return new gq_2<K, V>(map2, map3, gl_22);
    }

    @Override
    public final /* synthetic */ fb_1 d() {
        gq_2 gq_22 = this;
        return (fo_1)super.a();
    }

    protected static final class b<K, V>
    extends jg_0<K, V> {
        protected b(gq_2<K, V> gq_22, SortedMap<K, V> sortedMap) {
            super(new gq(sortedMap, gq_22.b, gq_22.c));
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public final boolean containsValue(Object value) {
            void var1_1;
            b b2 = this;
            return ((gq)super.c_()).a.containsValue(var1_1);
        }

        @Override
        public final void clear() {
            Iterator iterator2 = this.keySet().iterator();
            while (iterator2.hasNext()) {
                iterator2.next();
                iterator2.remove();
            }
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public final SortedMap<K, V> headMap(K toKey) {
            void var1_1;
            b b2 = this;
            return new b((gq)super.c_(), super.headMap(var1_1));
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public final SortedMap<K, V> tailMap(K fromKey) {
            void var1_1;
            b b2 = this;
            return new b((gq)super.c_(), super.tailMap(var1_1));
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public final SortedMap<K, V> subMap(K fromKey, K toKey) {
            void var2_2;
            void var1_1;
            b b2 = this;
            return new b((gq)super.c_(), super.subMap(var1_1, var2_2));
        }

        private gq_2<K, V> b() {
            return (gq)super.c_();
        }

        @Override
        public final K d(K k2) {
            b b2 = this;
            return (K)((gq)super.c_()).d(k2);
        }

        @Override
        public final K c(K k2) {
            b b2 = this;
            return (K)((gq)super.c_()).c(k2);
        }

        @Override
        public final /* synthetic */ Map i() {
            b b2 = this;
            return (gq)super.c_();
        }
    }
}

