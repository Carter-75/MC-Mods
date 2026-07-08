/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.valkyrienskies.core.impl.shadow.jt
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import org.valkyrienskies.core.impl.shadow.fd_1;
import org.valkyrienskies.core.impl.shadow.fe_1;
import org.valkyrienskies.core.impl.shadow.fj_1;
import org.valkyrienskies.core.impl.shadow.fu_2;
import org.valkyrienskies.core.impl.shadow.hr_1;
import org.valkyrienskies.core.impl.shadow.if_1;
import org.valkyrienskies.core.impl.shadow.iy_0;
import org.valkyrienskies.core.impl.shadow.jd_0;
import org.valkyrienskies.core.impl.shadow.jt;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.jt
 */
public final class jt_0<K, V>
extends jd_0<K, V>
implements Serializable,
fd_1<K, V> {
    private static final long c = 2728177751851003750L;
    final List<K> b = new ArrayList<K>();

    public static <K, V> jt_0<K, V> a(Map<K, V> map2) {
        return new jt_0<K, V>(map2);
    }

    public jt_0() {
        this(new HashMap());
    }

    private jt_0(Map<K, V> map2) {
        super(map2);
        this.b.addAll(this.i().keySet());
    }

    private void a(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.a);
    }

    private void a(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.a = (Map)objectInputStream.readObject();
    }

    @Override
    public final fe_1<K, V> e() {
        return new e(this);
    }

    @Override
    public final K firstKey() {
        if (this.size() == 0) {
            throw new NoSuchElementException("Map is empty");
        }
        return this.b.get(0);
    }

    @Override
    public final K lastKey() {
        if (this.size() == 0) {
            throw new NoSuchElementException("Map is empty");
        }
        return this.b.get(this.size() - 1);
    }

    @Override
    public final K c(Object object) {
        int n2 = this.b.indexOf(object);
        if (n2 >= 0 && n2 < this.size() - 1) {
            return this.b.get(n2 + 1);
        }
        return null;
    }

    @Override
    public final K d(Object object) {
        int n2 = this.b.indexOf(object);
        if (n2 > 0) {
            return this.b.get(n2 - 1);
        }
        return null;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final V put(K key, V value) {
        void var1_1;
        void var2_2;
        if (this.i().containsKey(key)) {
            return this.i().put(key, value);
        }
        var2_2 = this.i().put(key, var2_2);
        this.b.add(var1_1);
        return var2_2;
    }

    @Override
    public final void putAll(Map<? extends K, ? extends V> map2) {
        for (Map.Entry<K, V> entry : map2.entrySet()) {
            ((jd_0)this).put(entry.getKey(), entry.getValue());
        }
    }

    private void a(int n2, Map<? extends K, ? extends V> object) {
        if (n2 < 0 || n2 > this.b.size()) {
            throw new IndexOutOfBoundsException("Index: " + n2 + ", Size: " + this.b.size());
        }
        for (Map.Entry entry : object.entrySet()) {
            Object v0;
            Object k2 = entry.getKey();
            boolean bl = this.containsKey(k2);
            Object v = entry.getValue();
            Object k3 = entry.getKey();
            int n3 = n2;
            jt_0 jt_02 = this;
            if (n3 < 0 || n3 > jt_02.b.size()) {
                throw new IndexOutOfBoundsException("Index: " + n3 + ", Size: " + jt_02.b.size());
            }
            Map map2 = jt_02.i();
            if (map2.containsKey(k3)) {
                Object v2 = map2.remove(k3);
                int n4 = jt_02.b.indexOf(k3);
                jt_02.b.remove(n4);
                if (n4 < n3) {
                    --n3;
                }
                jt_02.b.add(n3, k3);
                map2.put(k3, v);
                v0 = v2;
            } else {
                jt_02.b.add(n3, k3);
                map2.put(k3, v);
                v0 = null;
            }
            if (!bl) {
                ++n2;
                continue;
            }
            Object k4 = entry.getKey();
            jt_02 = this;
            n2 = jt_02.b.indexOf(k4) + 1;
        }
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final V remove(Object key) {
        V v = null;
        if (this.i().containsKey(key)) {
            void var1_1;
            v = this.i().remove(key);
            this.b.remove(var1_1);
        }
        return v;
    }

    @Override
    public final void clear() {
        this.i().clear();
        this.b.clear();
    }

    @Override
    public final Set<K> keySet() {
        return new b(this);
    }

    private List<K> a() {
        return iy_0.a(this.b);
    }

    @Override
    public final Collection<V> values() {
        return new f(this);
    }

    private List<V> b() {
        return new f(this);
    }

    @Override
    public final Set<Map.Entry<K, V>> entrySet() {
        jt_0 jt_02 = this;
        return new a(jt_02, jt_02.b);
    }

    @Override
    public final String toString() {
        if (this.isEmpty()) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('{');
        boolean bl = true;
        for (Map.Entry entry : ((jd_0)this).entrySet()) {
            Object k2 = entry.getKey();
            entry = entry.getValue();
            if (bl) {
                bl = false;
            } else {
                stringBuilder.append(", ");
            }
            stringBuilder.append((Object)(k2 == this ? "(this Map)" : k2));
            stringBuilder.append('=');
            stringBuilder.append(entry == this ? "(this Map)" : entry);
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    @Override
    private K c(int n2) {
        return this.b.get(n2);
    }

    public final V a(int n2) {
        jt_0 jt_02 = this;
        return jt_02.get(jt_02.b.get(n2));
    }

    private int a(Object object) {
        return this.b.indexOf(object);
    }

    public final V a(int n2, V v) {
        K k2 = this.b.get(n2);
        return ((jd_0)this).put(k2, v);
    }

    private V a(int n2, K k2, V v) {
        if (n2 < 0 || n2 > this.b.size()) {
            throw new IndexOutOfBoundsException("Index: " + n2 + ", Size: " + this.b.size());
        }
        Map<K, V> map2 = this.i();
        if (map2.containsKey(k2)) {
            Object v2 = map2.remove(k2);
            int n3 = this.b.indexOf(k2);
            this.b.remove(n3);
            if (n3 < n2) {
                --n2;
            }
            this.b.add(n2, k2);
            map2.put(k2, v);
            return v2;
        }
        this.b.add(n2, k2);
        map2.put(k2, v);
        return null;
    }

    public final V b(int n2) {
        int n3 = n2;
        jt_0 jt_02 = this;
        return ((jd_0)jt_02).remove(jt_02.b.get(n3));
    }

    private List<K> d() {
        jt_0 jt_02 = this;
        return iy_0.a(jt_02.b);
    }

    @Override
    public final /* synthetic */ fu_2 c() {
        return this.e();
    }

    static /* synthetic */ List a(jt_0 jt_02) {
        return jt_02.b;
    }

    static final class e<K, V>
    implements fe_1<K, V>,
    fj_1<K> {
        private final jt_0<K, V> a;
        private ListIterator<K> b;
        private K c = null;
        private boolean d = false;

        e(jt_0<K, V> jt_02) {
            this.a = jt_02;
            this.b = jt.a(jt_02).listIterator();
        }

        @Override
        public final boolean hasNext() {
            return this.b.hasNext();
        }

        @Override
        public final K next() {
            this.c = this.b.next();
            this.d = true;
            return this.c;
        }

        @Override
        public final boolean hasPrevious() {
            return this.b.hasPrevious();
        }

        @Override
        public final K previous() {
            this.c = this.b.previous();
            this.d = true;
            return this.c;
        }

        @Override
        public final void remove() {
            if (!this.d) {
                throw new IllegalStateException("remove() can only be called once after next()");
            }
            this.b.remove();
            this.a.a.remove(this.c);
            this.d = false;
        }

        @Override
        public final K a() {
            if (!this.d) {
                throw new IllegalStateException("getKey() can only be called after next() and before remove()");
            }
            return this.c;
        }

        @Override
        public final V b() {
            if (!this.d) {
                throw new IllegalStateException("getValue() can only be called after next() and before remove()");
            }
            return this.a.get(this.c);
        }

        @Override
        public final V a(V v) {
            if (!this.d) {
                throw new IllegalStateException("setValue() can only be called after next() and before remove()");
            }
            return this.a.a.put(this.c, v);
        }

        @Override
        public final void c() {
            this.b = jt.a(this.a).listIterator();
            this.c = null;
            this.d = false;
        }

        public final String toString() {
            if (this.d) {
                return "Iterator[" + this.a() + "=" + this.b() + "]";
            }
            return "Iterator[]";
        }
    }

    static final class d<K, V>
    extends if_1<K, V> {
        private final jt_0<K, V> a;

        d(jt_0<K, V> jt_02, K k2) {
            super(k2, null);
            this.a = jt_02;
        }

        @Override
        public final V getValue() {
            return this.a.get(this.getKey());
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public final V setValue(V value) {
            void var1_1;
            return this.a.i().put(this.getKey(), var1_1);
        }
    }

    static final class c<K, V>
    extends hr_1<K, Map.Entry<K, V>> {
        private final jt_0<K, V> a;
        private K b = null;

        c(jt_0<K, V> jt_02, List<K> list) {
            super(list.iterator());
            this.a = jt_02;
        }

        private Map.Entry<K, V> b() {
            this.b = this.a().next();
            return new d<K, V>(this.a, this.b);
        }

        @Override
        public final void remove() {
            super.remove();
            this.a.i().remove(this.b);
        }

        @Override
        public final /* synthetic */ Object next() {
            c c2 = this;
            this.b = c2.a().next();
            return new d<K, V>(c2.a, c2.b);
        }
    }

    static final class a<K, V>
    extends AbstractSet<Map.Entry<K, V>> {
        private final jt_0<K, V> a;
        private final List<K> b;
        private Set<Map.Entry<K, V>> c;

        public a(jt_0<K, V> jt_02, List<K> list) {
            this.a = jt_02;
            this.b = list;
        }

        private Set<Map.Entry<K, V>> a() {
            if (this.c == null) {
                this.c = this.a.i().entrySet();
            }
            return this.c;
        }

        @Override
        public final int size() {
            return this.a.size();
        }

        @Override
        public final boolean isEmpty() {
            return this.a.isEmpty();
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public final boolean contains(Object obj) {
            void var1_1;
            return this.a().contains(var1_1);
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public final boolean containsAll(Collection<?> coll) {
            void var1_1;
            return this.a().containsAll((Collection<?>)var1_1);
        }

        @Override
        public final boolean remove(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            if (this.a().contains(obj)) {
                Object k2;
                k2 = ((Map.Entry)k2).getKey();
                ((jd_0)this.a).remove(k2);
                return true;
            }
            return false;
        }

        @Override
        public final void clear() {
            ((jd_0)this.a).clear();
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public final boolean equals(Object obj) {
            void var1_1;
            if (obj == this) {
                return true;
            }
            return this.a().equals(var1_1);
        }

        @Override
        public final int hashCode() {
            return this.a().hashCode();
        }

        @Override
        public final String toString() {
            return this.a().toString();
        }

        @Override
        public final Iterator<Map.Entry<K, V>> iterator() {
            return new c<K, V>(this.a, this.b);
        }
    }

    static final class b<K>
    extends AbstractSet<K> {
        private final jt_0<K, Object> a;

        b(jt_0<K, ?> jt_02) {
            this.a = jt_02;
        }

        @Override
        public final int size() {
            return this.a.size();
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public final boolean contains(Object value) {
            void var1_1;
            return this.a.containsKey(var1_1);
        }

        @Override
        public final void clear() {
            ((jd_0)this.a).clear();
        }

        @Override
        public final Iterator<K> iterator() {
            b b2 = this;
            return new hr_1<Map.Entry<K, Object>, K>(b2, ((jd_0)b2.a).entrySet().iterator()){
                private /* synthetic */ b a;
                {
                    this.a = b2;
                    super(iterator2);
                }

                @Override
                public final K next() {
                    return ((Map.Entry)this.a().next()).getKey();
                }
            };
        }
    }

    static final class f<V>
    extends AbstractList<V> {
        private final jt_0<Object, V> a;

        f(jt_0<?, V> jt_02) {
            this.a = jt_02;
        }

        @Override
        public final int size() {
            return this.a.size();
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public final boolean contains(Object value) {
            void var1_1;
            return this.a.containsValue(var1_1);
        }

        @Override
        public final void clear() {
            ((jd_0)this.a).clear();
        }

        @Override
        public final Iterator<V> iterator() {
            f f2 = this;
            return new hr_1<Map.Entry<Object, V>, V>(f2, ((jd_0)f2.a).entrySet().iterator()){
                private /* synthetic */ f a;
                {
                    this.a = f2;
                    super(iterator2);
                }

                @Override
                public final V next() {
                    return ((Map.Entry)this.a().next()).getValue();
                }
            };
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public final V get(int index) {
            void var1_1;
            void var2_3 = var1_1;
            jt_0<Object, V> jt_02 = this.a;
            return jt_02.get(((jt)jt_02).b.get((int)var2_3));
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public final V set(int index, V value) {
            void var1_1;
            void var2_3;
            void var3_6 = var2_3;
            void var2_4 = var1_1;
            jt_0<Object, void> jt_02 = this.a;
            Object e2 = ((jt)jt_02).b.get((int)var2_4);
            return ((jd_0)jt_02).put(e2, var3_6);
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public final V remove(int index) {
            void var1_1;
            jt_0<Object, V> jt_02 = this.a;
            void var2_3 = var1_1;
            jt_0<Object, V> jt_03 = jt_02;
            return ((jd_0)jt_02).remove(((jt)jt_03).b.get((int)var2_3));
        }
    }
}

