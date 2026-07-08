/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.valkyrienskies.core.impl.shadow.fa_1;
import org.valkyrienskies.core.impl.shadow.fd_2;
import org.valkyrienskies.core.impl.shadow.fq_1;
import org.valkyrienskies.core.impl.shadow.fq_2;
import org.valkyrienskies.core.impl.shadow.fu_2;
import org.valkyrienskies.core.impl.shadow.fy_2;
import org.valkyrienskies.core.impl.shadow.hn_1;
import org.valkyrienskies.core.impl.shadow.hy_1;
import org.valkyrienskies.core.impl.shadow.if_1;
import org.valkyrienskies.core.impl.shadow.if_2;
import org.valkyrienskies.core.impl.shadow.ii_2;
import org.valkyrienskies.core.impl.shadow.il_1;
import org.valkyrienskies.core.impl.shadow.ix_1;
import org.valkyrienskies.core.impl.shadow.jS;
import org.valkyrienskies.core.impl.shadow.jX;

public abstract class jK<K, V>
implements fa_1<K, V> {
    private transient Collection<V> b;
    private transient b c;
    private transient fy_2<K> d;
    private transient a e;
    transient Map<K, Collection<V>> a;

    protected jK() {
    }

    protected jK(Map<K, ? extends Collection<V>> map2) {
        if (map2 == null) {
            throw new NullPointerException("Map must not be null.");
        }
        this.a = map2;
    }

    protected Map<K, ? extends Collection<V>> j() {
        return this.a;
    }

    protected final void b(Map<K, ? extends Collection<V>> map2) {
        this.a = map2;
    }

    protected abstract Collection<V> l();

    @Override
    public final boolean c(Object object) {
        return this.j().containsKey(object);
    }

    @Override
    public final boolean d(Object object) {
        return this.g().contains(object);
    }

    @Override
    public final boolean a(Object collection, Object object) {
        collection = this.j().get(collection);
        return collection != null && collection.contains(object);
    }

    @Override
    public final Collection<Map.Entry<K, V>> d() {
        if (this.c != null) {
            return this.c;
        }
        this.c = new b(0);
        return this.c;
    }

    @Override
    public Collection<V> e(K k2) {
        return this.g(k2);
    }

    Collection<V> g(K k2) {
        return new h(this, k2);
    }

    @Override
    public Collection<V> f(Object object) {
        return fd_2.a(this.j().remove(object));
    }

    @Override
    public final boolean c(Object object, Object object2) {
        Collection<V> collection = this.j().get(object);
        if (collection == null) {
            return false;
        }
        boolean bl = collection.remove(object2);
        if (collection.isEmpty()) {
            this.j().remove(object);
        }
        return bl;
    }

    @Override
    public final boolean b() {
        return this.j().isEmpty();
    }

    @Override
    public final Set<K> f() {
        return this.j().keySet();
    }

    @Override
    public final int a() {
        int n2 = 0;
        for (Collection<V> collection : this.j().values()) {
            n2 += collection.size();
        }
        return n2;
    }

    @Override
    public final Collection<V> g() {
        Collection<V> collection = this.b;
        if (collection != null) {
            return collection;
        }
        this.b = new f(this, 0);
        return this.b;
    }

    @Override
    public final void c() {
        this.j().clear();
    }

    @Override
    public final boolean b(K k2, V v) {
        Collection<V> collection = this.j().get(k2);
        if (collection == null) {
            collection = this.l();
            if (collection.add(v)) {
                this.a.put(k2, collection);
                return true;
            }
            return false;
        }
        return collection.add(v);
    }

    @Override
    public final boolean a(Map<? extends K, ? extends V> object) {
        if (object == null) {
            throw new NullPointerException("Map must not be null.");
        }
        boolean bl = false;
        for (Map.Entry entry : object.entrySet()) {
            bl |= this.b(entry.getKey(), entry.getValue());
        }
        return bl;
    }

    @Override
    public final boolean a(fa_1<? extends K, ? extends V> object) {
        if (object == null) {
            throw new NullPointerException("Map must not be null.");
        }
        boolean bl = false;
        for (Map.Entry entry : object.d()) {
            bl |= this.b(entry.getKey(), entry.getValue());
        }
        return bl;
    }

    @Override
    public final fy_2<K> e() {
        if (this.d == null) {
            this.d = jX.a(new c(this, 0));
        }
        return this.d;
    }

    @Override
    public final Map<K, Collection<V>> h() {
        if (this.e != null) {
            return this.e;
        }
        jK jK2 = this;
        this.e = jK2.new a(jK2.a);
        return this.e;
    }

    @Override
    public final boolean a(K k2, Iterable<? extends V> object) {
        if (object == null) {
            throw new NullPointerException("Values must not be null.");
        }
        if (object instanceof Collection) {
            return !(object = (Collection)object).isEmpty() && this.e(k2).addAll((Collection<V>)object);
        }
        return (object = object.iterator()).hasNext() && fd_2.a(this.e(k2), object);
    }

    @Override
    public final fu_2<K, V> i() {
        if (this.a() == 0) {
            return hy_1.d();
        }
        return new e(this);
    }

    /*
     * WARNING - void declaration
     */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof fa_1) {
            void var1_1;
            return this.h().equals(((fa_1)var1_1).h());
        }
        return false;
    }

    public int hashCode() {
        return this.j().hashCode();
    }

    public String toString() {
        return this.j().toString();
    }

    protected final void a(ObjectOutputStream objectOutputStream) {
        objectOutputStream.writeInt(this.a.size());
        for (Map.Entry<K, Collection<V>> entry : this.a.entrySet()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeInt(entry.getValue().size());
            for (V v : entry.getValue()) {
                objectOutputStream.writeObject(v);
            }
        }
    }

    protected final void a(ObjectInputStream objectInputStream) {
        int n2 = objectInputStream.readInt();
        for (int i2 = 0; i2 < n2; ++i2) {
            Collection<V> collection = objectInputStream.readObject();
            collection = this.e(collection);
            int n3 = objectInputStream.readInt();
            for (int i3 = 0; i3 < n3; ++i3) {
                Object object = objectInputStream.readObject();
                collection.add(object);
            }
        }
    }

    static /* synthetic */ Map a(jK jK2) {
        return jK2.a;
    }

    final class org.valkyrienskies.core.impl.shadow.jK$a
    extends AbstractMap<K, Collection<V>> {
        final transient Map<K, Collection<V>> a;

        org.valkyrienskies.core.impl.shadow.jK$a(Map<K, Collection<V>> map2) {
            this.a = map2;
        }

        @Override
        public final Set<Map.Entry<K, Collection<V>>> entrySet() {
            return new a(this);
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public final boolean containsKey(Object key) {
            void var1_1;
            return this.a.containsKey(var1_1);
        }

        private Collection<V> a(Object object) {
            Collection collection = this.a.get(object);
            if (collection == null) {
                return null;
            }
            return jK.this.g(object);
        }

        @Override
        public final Set<K> keySet() {
            return jK.this.f();
        }

        @Override
        public final int size() {
            return this.a.size();
        }

        private Collection<V> b(Object collection) {
            if ((collection = this.a.remove(collection)) == null) {
                return null;
            }
            Collection collection2 = jK.this.l();
            collection2.addAll(collection);
            collection.clear();
            return collection2;
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public final boolean equals(Object object) {
            void var1_1;
            return this == object || this.a.equals(var1_1);
        }

        @Override
        public final int hashCode() {
            return this.a.hashCode();
        }

        @Override
        public final String toString() {
            return this.a.toString();
        }

        @Override
        public final void clear() {
            jK.this.c();
        }

        @Override
        public final /* synthetic */ Object remove(Object collection) {
            Collection collection2 = collection;
            collection = this;
            if ((collection2 = ((org.valkyrienskies.core.impl.shadow.jK$a)((Object)collection)).a.remove(collection2)) == null) {
                return null;
            }
            collection = ((org.valkyrienskies.core.impl.shadow.jK$a)((Object)collection)).jK.this.l();
            collection.addAll(collection2);
            collection2.clear();
            return collection;
        }

        @Override
        public final /* synthetic */ Object get(Object object) {
            Object object2 = object;
            object = this;
            Collection collection = ((org.valkyrienskies.core.impl.shadow.jK$a)object).a.get(object2);
            if (collection == null) {
                return null;
            }
            return ((org.valkyrienskies.core.impl.shadow.jK$a)object).jK.this.g(object2);
        }

        final class b
        extends hn_1<Map.Entry<K, Collection<V>>> {
            private /* synthetic */ org.valkyrienskies.core.impl.shadow.jK$a a;

            b(org.valkyrienskies.core.impl.shadow.jK$a a2, Iterator<Map.Entry<K, Collection<V>>> iterator2) {
                this.a = a2;
                super(iterator2);
            }

            private Map.Entry<K, Collection<V>> b() {
                Map.Entry entry = (Map.Entry)super.next();
                entry = entry.getKey();
                return new il_1(entry, this.a.jK.this.g(entry));
            }

            @Override
            public final /* synthetic */ Object next() {
                b b2 = this;
                Map.Entry entry = (Map.Entry)super.next();
                entry = entry.getKey();
                return new il_1(entry, b2.a.jK.this.g(entry));
            }
        }

        final class a
        extends AbstractSet<Map.Entry<K, Collection<V>>> {
            private /* synthetic */ org.valkyrienskies.core.impl.shadow.jK$a a;

            a(org.valkyrienskies.core.impl.shadow.jK$a a2) {
                this.a = a2;
            }

            @Override
            public final Iterator<Map.Entry<K, Collection<V>>> iterator() {
                return new b(this.a, this.a.a.entrySet().iterator());
            }

            @Override
            public final int size() {
                return this.a.size();
            }

            @Override
            public final void clear() {
                this.a.clear();
            }

            /*
             * WARNING - void declaration
             */
            @Override
            public final boolean contains(Object o) {
                void var1_1;
                return this.a.a.entrySet().contains(var1_1);
            }

            @Override
            public final boolean remove(Object o) {
                Map.Entry entry;
                if (!this.contains(o)) {
                    return false;
                }
                entry = entry;
                this.a.jK.this.f(entry.getKey());
                return true;
            }
        }
    }

    final class g
    implements Iterator<V> {
        private final Object a;
        private final Collection<V> b;
        private final Iterator<V> c;
        private /* synthetic */ jK d;

        public g(jK jK2, Object object) {
            this.d = jK2;
            this.a = object;
            this.b = jK2.j().get(object);
            this.c = this.b.iterator();
        }

        @Override
        public final void remove() {
            this.c.remove();
            if (this.b.isEmpty()) {
                this.d.f(this.a);
            }
        }

        @Override
        public final boolean hasNext() {
            return this.c.hasNext();
        }

        @Override
        public final V next() {
            return this.c.next();
        }
    }

    final class f
    extends AbstractCollection<V> {
        private /* synthetic */ jK a;

        private f(jK jK2) {
            this.a = jK2;
        }

        @Override
        public final Iterator<V> iterator() {
            if_2 if_22 = new if_2();
            for (Object k2 : this.a.f()) {
                if_22.a(new g(this.a, k2));
            }
            return if_22;
        }

        @Override
        public final int size() {
            return this.a.a();
        }

        @Override
        public final void clear() {
            this.a.c();
        }

        /* synthetic */ f(jK jK2, byte by) {
            this(jK2);
        }
    }

    final class e
    implements fu_2<K, V> {
        private final Iterator<Map.Entry<K, V>> a;
        private Map.Entry<K, V> b = null;
        private /* synthetic */ jK c;

        public e(jK jK2) {
            this.c = jK2;
            this.a = jK2.d().iterator();
        }

        @Override
        public final boolean hasNext() {
            return this.a.hasNext();
        }

        @Override
        public final K next() {
            this.b = this.a.next();
            return this.b.getKey();
        }

        @Override
        public final K a() {
            if (this.b == null) {
                throw new IllegalStateException();
            }
            return this.b.getKey();
        }

        @Override
        public final V b() {
            if (this.b == null) {
                throw new IllegalStateException();
            }
            return this.b.getValue();
        }

        @Override
        public final void remove() {
            this.a.remove();
        }

        @Override
        public final V a(V v) {
            if (this.b == null) {
                throw new IllegalStateException();
            }
            return this.b.setValue(v);
        }
    }

    final class d
    extends if_1<K, V> {
        private /* synthetic */ jK a;

        public d(jK jK2, K k2, V v) {
            this.a = jK2;
            super(k2, v);
        }

        @Override
        public final V setValue(V value) {
            throw new UnsupportedOperationException();
        }
    }

    final class b
    extends AbstractCollection<Map.Entry<K, V>> {
        private b() {
        }

        @Override
        public final Iterator<Map.Entry<K, V>> iterator() {
            return new ii_2<Map.Entry<K, V>>(){
                private Collection<K> b;
                private Iterator<K> c;
                {
                    this.b = new ArrayList(jK.this.j().keySet());
                    this.c = this.b.iterator();
                }

                @Override
                public final Iterator<? extends Map.Entry<K, V>> a(int n2) {
                    if (!this.c.hasNext()) {
                        return null;
                    }
                    Object k2 = this.c.next();
                    fq_1 fq_12 = new fq_1<V, Map.Entry<K, V>>(this, k2){
                        private /* synthetic */ Object a;
                        private /* synthetic */ 1 b;
                        {
                            this.b = var1_1;
                            this.a = object;
                        }

                        private Map.Entry<K, V> b(V v) {
                            return new d(this.b.jK.this, this.a, v);
                        }

                        @Override
                        public final /* synthetic */ Object a(Object object) {
                            Object object2 = object;
                            object = this;
                            return new d(object.b.jK.this, object.a, object2);
                        }
                    };
                    return new ix_1(new g(jK.this, k2), fq_12);
                }
            };
        }

        @Override
        public final int size() {
            return jK.this.a();
        }

        /* synthetic */ b(byte by) {
            this();
        }
    }

    final class c
    extends jS<K> {
        private /* synthetic */ jK a;

        private c(jK jK2) {
            this.a = jK2;
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public final boolean contains(Object o) {
            void var1_1;
            return this.a.j().containsKey(var1_1);
        }

        @Override
        public final boolean isEmpty() {
            return this.a.j().isEmpty();
        }

        @Override
        public final int size() {
            return this.a.a();
        }

        @Override
        public final int c() {
            return this.a.j().size();
        }

        @Override
        public final int a(Object collection) {
            int n2 = 0;
            collection = this.a.j().get(collection);
            if (collection != null) {
                n2 = collection.size();
            }
            return n2;
        }

        @Override
        public final Iterator<fy_2.a_0<K>> d() {
            a a2 = new a(this, 0);
            jK jK2 = this.a;
            return fq_2.a(jK2.a.entrySet().iterator(), (fq_1)a2);
        }

        /* synthetic */ c(jK jK2, byte by) {
            this(jK2);
        }

        final class a
        implements fq_1<Map.Entry<K, Collection<V>>, fy_2.a_0<K>> {
            private /* synthetic */ c a;

            private a(c c2) {
                this.a = c2;
            }

            @Override
            private fy_2.a_0<K> a(Map.Entry<K, Collection<V>> entry) {
                return new jS.a<K>(this, entry){
                    private /* synthetic */ Map.Entry a;
                    private /* synthetic */ a b;
                    {
                        this.b = a2;
                        this.a = entry;
                    }

                    @Override
                    public final K a() {
                        return this.a.getKey();
                    }

                    @Override
                    public final int b() {
                        return ((Collection)this.a.getValue()).size();
                    }
                };
            }

            @Override
            public final /* synthetic */ Object a(Object object) {
                Map.Entry entry = (Map.Entry)object;
                object = this;
                return new /* invalid duplicate definition of identical inner class */;
            }

            /* synthetic */ a(c c2, byte by) {
                this(c2);
            }
        }
    }

    class h
    implements Collection<V> {
        protected final K a;
        private /* synthetic */ jK b;

        public h(jK jK2, K k2) {
            this.b = jK2;
            this.a = k2;
        }

        protected Collection<V> a() {
            return this.b.j().get(this.a);
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public boolean add(V value) {
            void var1_1;
            Collection collection = this.a();
            if (collection == null) {
                collection = this.b.l();
                jK jK2 = this.b;
                jK2.a.put(this.a, collection);
            }
            return collection.add(var1_1);
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public boolean addAll(Collection<? extends V> other) {
            void var1_1;
            Collection collection = this.a();
            if (collection == null) {
                collection = this.b.l();
                jK jK2 = this.b;
                jK2.a.put(this.a, collection);
            }
            return collection.addAll((Collection)var1_1);
        }

        @Override
        public void clear() {
            Collection collection = this.a();
            if (collection != null) {
                collection.clear();
                this.b.f(this.a);
            }
        }

        @Override
        public Iterator<V> iterator() {
            Collection collection = this.a();
            if (collection == null) {
                return fq_2.a;
            }
            return new g(this.b, this.a);
        }

        @Override
        public int size() {
            Collection collection = this.a();
            if (collection == null) {
                return 0;
            }
            return collection.size();
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public boolean contains(Object obj) {
            void var1_1;
            Collection collection = this.a();
            if (collection == null) {
                return false;
            }
            return collection.contains(var1_1);
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public boolean containsAll(Collection<?> other) {
            void var1_1;
            Collection collection = this.a();
            if (collection == null) {
                return false;
            }
            return collection.containsAll((Collection<?>)var1_1);
        }

        @Override
        public boolean isEmpty() {
            Collection collection = this.a();
            if (collection == null) {
                return true;
            }
            return collection.isEmpty();
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public boolean remove(Object item) {
            void var1_1;
            Collection collection = this.a();
            if (collection == null) {
                return false;
            }
            boolean bl = collection.remove(var1_1);
            if (collection.isEmpty()) {
                this.b.f(this.a);
            }
            return bl;
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public boolean removeAll(Collection<?> c2) {
            void var1_1;
            Collection collection = this.a();
            if (collection == null) {
                return false;
            }
            boolean bl = collection.removeAll((Collection<?>)var1_1);
            if (collection.isEmpty()) {
                this.b.f(this.a);
            }
            return bl;
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public boolean retainAll(Collection<?> c2) {
            void var1_1;
            Collection collection = this.a();
            if (collection == null) {
                return false;
            }
            boolean bl = collection.retainAll((Collection<?>)var1_1);
            if (collection.isEmpty()) {
                this.b.f(this.a);
            }
            return bl;
        }

        @Override
        public Object[] toArray() {
            Collection collection = this.a();
            if (collection == null) {
                return fd_2.a.toArray();
            }
            return collection.toArray();
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public <T> T[] toArray(T[] a2) {
            void var1_1;
            Collection collection = this.a();
            if (collection == null) {
                return fd_2.a.toArray(a2);
            }
            return collection.toArray((T[])var1_1);
        }

        public String toString() {
            Collection collection = this.a();
            if (collection == null) {
                return fd_2.a.toString();
            }
            return collection.toString();
        }
    }
}

