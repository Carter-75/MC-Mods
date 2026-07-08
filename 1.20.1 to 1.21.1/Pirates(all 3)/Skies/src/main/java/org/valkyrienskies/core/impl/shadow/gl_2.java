/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.valkyrienskies.core.impl.shadow.gl
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.valkyrienskies.core.impl.shadow.ey_1;
import org.valkyrienskies.core.impl.shadow.fj_1;
import org.valkyrienskies.core.impl.shadow.fu_2;
import org.valkyrienskies.core.impl.shadow.gl;
import org.valkyrienskies.core.impl.shadow.gv_2;
import org.valkyrienskies.core.impl.shadow.hn_1;
import org.valkyrienskies.core.impl.shadow.ig_1;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.gl
 */
public abstract class gl_2<K, V>
implements ey_1<K, V> {
    transient Map<K, V> a;
    transient Map<V, K> b;
    transient ey_1<V, K> c = null;
    private transient Set<K> d = null;
    private transient Set<V> e = null;
    private transient Set<Map.Entry<K, V>> f = null;

    protected gl_2() {
    }

    protected gl_2(Map<K, V> map2, Map<V, K> map3) {
        this.a = map2;
        this.b = map3;
    }

    protected gl_2(Map<K, V> map2, Map<V, K> map3, ey_1<V, K> ey_12) {
        this.a = map2;
        this.b = map3;
        this.c = ey_12;
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    protected abstract gl_2 a(Map var1, Map var2, gl_2 var3);

    /*
     * WARNING - void declaration
     */
    @Override
    public V get(Object key) {
        void var1_1;
        return this.a.get(var1_1);
    }

    @Override
    public int size() {
        return this.a.size();
    }

    @Override
    public boolean isEmpty() {
        return this.a.isEmpty();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public boolean containsKey(Object key) {
        void var1_1;
        return this.a.containsKey(var1_1);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public boolean equals(Object obj) {
        void var1_1;
        return this.a.equals(var1_1);
    }

    @Override
    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return this.a.toString();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public V put(K key, V value) {
        void var1_1;
        void var2_2;
        if (this.a.containsKey(key)) {
            this.b.remove(this.a.get(key));
        }
        if (this.b.containsKey(value)) {
            this.a.remove(this.b.get(value));
        }
        V v = this.a.put(key, value);
        this.b.put(var2_2, var1_1);
        return v;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> map2) {
        for (Map.Entry<K, V> entry : map2.entrySet()) {
            this.put(entry.getKey(), entry.getValue());
        }
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public V remove(Object key) {
        V v = null;
        if (this.a.containsKey(key)) {
            void var1_1;
            v = this.a.remove(var1_1);
            this.b.remove(v);
        }
        return v;
    }

    @Override
    public void clear() {
        this.a.clear();
        this.b.clear();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public boolean containsValue(Object value) {
        void var1_1;
        return this.b.containsKey(var1_1);
    }

    @Override
    public fu_2<K, V> c() {
        return new a(this);
    }

    @Override
    public final K a(Object object) {
        return this.b.get(object);
    }

    @Override
    public final K b(Object object) {
        K k2 = null;
        if (this.b.containsKey(object)) {
            k2 = this.b.remove(object);
            this.a.remove(k2);
        }
        return k2;
    }

    @Override
    public ey_1<V, K> a() {
        if (this.c == null) {
            this.c = this.a(this.b, this.a, this);
        }
        return this.c;
    }

    @Override
    public Set<K> keySet() {
        if (this.d == null) {
            this.d = new d(this);
        }
        return this.d;
    }

    protected final Iterator<K> a(Iterator<K> iterator2) {
        return new e<K>(iterator2, this);
    }

    @Override
    public final Set<V> b() {
        if (this.e == null) {
            this.e = new g(this);
        }
        return this.e;
    }

    protected final Iterator<V> b(Iterator<V> iterator2) {
        return new h<V>(iterator2, this);
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.f == null) {
            this.f = new b(this);
        }
        return this.f;
    }

    protected final Iterator<Map.Entry<K, V>> c(Iterator<Map.Entry<K, V>> iterator2) {
        return new c<K, V>(iterator2, this);
    }

    @Override
    public /* synthetic */ Collection values() {
        return this.b();
    }

    protected static final class a<K, V>
    implements fj_1<K>,
    fu_2<K, V> {
        private gl_2<K, V> a;
        private Iterator<Map.Entry<K, V>> b;
        private Map.Entry<K, V> c = null;
        private boolean d = false;

        protected a(gl_2<K, V> gl_22) {
            this.a = gl_22;
            this.b = ((gl)gl_22).a.entrySet().iterator();
        }

        @Override
        public final boolean hasNext() {
            return this.b.hasNext();
        }

        @Override
        public final K next() {
            this.c = this.b.next();
            this.d = true;
            return this.c.getKey();
        }

        @Override
        public final void remove() {
            if (!this.d) {
                throw new IllegalStateException("Iterator remove() can only be called once after next()");
            }
            V v = this.c.getValue();
            this.b.remove();
            ((gl)this.a).b.remove(v);
            this.c = null;
            this.d = false;
        }

        @Override
        public final K a() {
            if (this.c == null) {
                throw new IllegalStateException("Iterator getKey() can only be called after next() and before remove()");
            }
            return this.c.getKey();
        }

        @Override
        public final V b() {
            if (this.c == null) {
                throw new IllegalStateException("Iterator getValue() can only be called after next() and before remove()");
            }
            return this.c.getValue();
        }

        @Override
        public final V a(V v) {
            if (this.c == null) {
                throw new IllegalStateException("Iterator setValue() can only be called after next() and before remove()");
            }
            if (((gl)this.a).b.containsKey(v) && ((gl)this.a).b.get(v) != this.c.getKey()) {
                throw new IllegalArgumentException("Cannot use setValue() when the object being set is already in the map");
            }
            return (V)this.a.put(this.c.getKey(), v);
        }

        @Override
        public final void c() {
            this.b = ((gl)this.a).a.entrySet().iterator();
            this.c = null;
            this.d = false;
        }

        public final String toString() {
            if (this.c != null) {
                return "MapIterator[" + this.a() + "=" + this.b() + "]";
            }
            return "MapIterator[]";
        }
    }

    protected static final class f<K, V>
    extends ig_1<K, V> {
        private gl_2<K, V> a;

        protected f(Map.Entry<K, V> entry, gl_2<K, V> gl_22) {
            super(entry);
            this.a = gl_22;
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public final V setValue(V value) {
            void var1_1;
            Object k2 = this.getKey();
            if (((gl)this.a).b.containsKey(value) && ((gl)this.a).b.get(value) != k2) {
                throw new IllegalArgumentException("Cannot use setValue() when the object being set is already in the map");
            }
            this.a.put(k2, value);
            return super.setValue(var1_1);
        }
    }

    protected static final class c<K, V>
    extends hn_1<Map.Entry<K, V>> {
        private gl_2<K, V> a;
        private Map.Entry<K, V> b = null;
        private boolean c = false;

        protected c(Iterator<Map.Entry<K, V>> iterator2, gl_2<K, V> gl_22) {
            super(iterator2);
            this.a = gl_22;
        }

        private Map.Entry<K, V> b() {
            this.b = new f<K, V>((Map.Entry)super.next(), this.a);
            this.c = true;
            return this.b;
        }

        @Override
        public final void remove() {
            if (!this.c) {
                throw new IllegalStateException("Iterator remove() can only be called once after next()");
            }
            V v = this.b.getValue();
            super.remove();
            ((gl)this.a).b.remove(v);
            this.b = null;
            this.c = false;
        }

        @Override
        public final /* synthetic */ Object next() {
            c c2 = this;
            this.b = new f<K, V>((Map.Entry)super.next(), c2.a);
            c2.c = true;
            return c2.b;
        }
    }

    protected static final class b<K, V>
    extends i<K, V, Map.Entry<K, V>>
    implements Set<Map.Entry<K, V>> {
        private static final long b = 4040410962603292348L;

        protected b(gl_2<K, V> gl_22) {
            super(((gl)gl_22).a.entrySet(), gl_22);
        }

        @Override
        public final Iterator<Map.Entry<K, V>> iterator() {
            return this.a.c(super.iterator());
        }

        @Override
        public final boolean remove(Object obj) {
            Object v;
            Map.Entry entry;
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Object k2 = (entry = (Map.Entry)entry).getKey();
            if (this.a.containsKey(k2) && ((v = ((gl)this.a).a.get(k2)) == null ? entry.getValue() == null : v.equals(entry.getValue()))) {
                ((gl)this.a).a.remove(k2);
                ((gl)this.a).b.remove(v);
                return true;
            }
            return false;
        }
    }

    protected static final class h<V>
    extends hn_1<V> {
        private gl_2<Object, V> a;
        private V b = null;
        private boolean c = false;

        protected h(Iterator<V> iterator2, gl_2<?, V> gl_22) {
            super(iterator2);
            this.a = gl_22;
        }

        @Override
        public final V next() {
            this.b = super.next();
            this.c = true;
            return this.b;
        }

        @Override
        public final void remove() {
            if (!this.c) {
                throw new IllegalStateException("Iterator remove() can only be called once after next()");
            }
            super.remove();
            ((gl)this.a).b.remove(this.b);
            this.b = null;
            this.c = false;
        }
    }

    protected static final class g<V>
    extends i<Object, V, V>
    implements Set<V> {
        private static final long b = 4023777119829639864L;

        protected g(gl_2<?, V> gl_22) {
            super(((gl)gl_22).a.values(), gl_22);
        }

        @Override
        public final Iterator<V> iterator() {
            return this.a.b(super.iterator());
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public final boolean contains(Object value) {
            void var1_1;
            return ((gl)this.a).b.containsKey(var1_1);
        }

        @Override
        public final boolean remove(Object value) {
            if (((gl)this.a).b.containsKey(value)) {
                Object v;
                v = ((gl)this.a).b.remove(v);
                ((gl)this.a).a.remove(v);
                return true;
            }
            return false;
        }
    }

    protected static final class e<K>
    extends hn_1<K> {
        private gl_2<K, ?> a;
        private K b = null;
        private boolean c = false;

        protected e(Iterator<K> iterator2, gl_2<K, ?> gl_22) {
            super(iterator2);
            this.a = gl_22;
        }

        @Override
        public final K next() {
            this.b = super.next();
            this.c = true;
            return this.b;
        }

        @Override
        public final void remove() {
            if (!this.c) {
                throw new IllegalStateException("Iterator remove() can only be called once after next()");
            }
            Object v = ((gl)this.a).a.get(this.b);
            super.remove();
            ((gl)this.a).b.remove(v);
            this.b = null;
            this.c = false;
        }
    }

    protected static final class d<K>
    extends i<K, Object, K>
    implements Set<K> {
        private static final long b = -7107935777385040694L;

        protected d(gl_2<K, ?> gl_22) {
            super(((gl)gl_22).a.keySet(), gl_22);
        }

        @Override
        public final Iterator<K> iterator() {
            return this.a.a(super.iterator());
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public final boolean contains(Object key) {
            void var1_1;
            return ((gl)this.a).a.containsKey(var1_1);
        }

        @Override
        public final boolean remove(Object key) {
            if (((gl)this.a).a.containsKey(key)) {
                Object v;
                v = ((gl)this.a).a.remove(v);
                ((gl)this.a).b.remove(v);
                return true;
            }
            return false;
        }
    }

    protected static abstract class i<K, V, E>
    extends gv_2<E> {
        private static final long b = 4621510560119690639L;
        protected final gl_2<K, V> a;

        protected i(Collection<E> collection, gl_2<K, V> gl_22) {
            super(collection);
            this.a = gl_22;
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public boolean equals(Object object) {
            void var1_1;
            return object == this || this.f().equals(var1_1);
        }

        @Override
        public int hashCode() {
            return this.f().hashCode();
        }

        @Override
        public boolean removeAll(Collection<?> coll) {
            Iterator iterator2;
            if (this.a.isEmpty() || coll.isEmpty()) {
                return false;
            }
            boolean bl = false;
            iterator2 = iterator2.iterator();
            while (iterator2.hasNext()) {
                bl |= this.remove(iterator2.next());
            }
            return bl;
        }

        @Override
        public boolean retainAll(Collection<?> coll) {
            if (this.a.isEmpty()) {
                return false;
            }
            if (coll.isEmpty()) {
                this.a.clear();
                return true;
            }
            boolean bl = false;
            Iterator iterator2 = this.iterator();
            while (iterator2.hasNext()) {
                if (coll.contains(iterator2.next())) continue;
                iterator2.remove();
                bl = true;
            }
            return bl;
        }

        @Override
        public void clear() {
            this.a.clear();
        }
    }
}

