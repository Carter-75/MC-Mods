/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.valkyrienskies.core.impl.shadow.fd_2;
import org.valkyrienskies.core.impl.shadow.fh_2;
import org.valkyrienskies.core.impl.shadow.fk_2;
import org.valkyrienskies.core.impl.shadow.fq_1;
import org.valkyrienskies.core.impl.shadow.fw_2;
import org.valkyrienskies.core.impl.shadow.hw_1;
import org.valkyrienskies.core.impl.shadow.if_2;
import org.valkyrienskies.core.impl.shadow.ii_2;
import org.valkyrienskies.core.impl.shadow.ix_1;
import org.valkyrienskies.core.impl.shadow.jd_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.jv
 */
@Deprecated
public final class jv_0<K, V>
extends jd_0<K, Object>
implements Serializable,
fw_2<K, V> {
    private static final long b = -2214159910087182007L;
    private final fh_2<? extends Collection<V>> c;
    private transient Collection<V> d;

    public static <K, V> jv_0<K, V> a(Map<K, ? super Collection<V>> map2) {
        return jv_0.a(map2, ArrayList.class);
    }

    public static <K, V, C extends Collection<V>> jv_0<K, V> a(Map<K, ? super C> map2, Class<C> clazz) {
        return new jv_0<K, V>(map2, new a<C>(clazz));
    }

    public static <K, V, C extends Collection<V>> jv_0<K, V> a(Map<K, ? super C> map2, fh_2<C> fh_22) {
        return new jv_0<K, V>(map2, fh_22);
    }

    public jv_0() {
        this(new HashMap(), new a<ArrayList>(ArrayList.class));
    }

    private <C extends Collection<V>> jv_0(Map<K, ? super C> map2, fh_2<C> fh_22) {
        super(map2);
        if (fh_22 == null) {
            throw new IllegalArgumentException("The factory must not be null");
        }
        this.c = fh_22;
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
    public final void clear() {
        this.i().clear();
    }

    @Override
    public final boolean a(Object object, Object object2) {
        Collection<V> collection = this.a(object);
        if (collection == null) {
            return false;
        }
        boolean bl = collection.remove(object2);
        if (!bl) {
            return false;
        }
        if (collection.isEmpty()) {
            this.remove(object);
        }
        return true;
    }

    @Override
    public final boolean containsValue(Object value) {
        Set set = this.i().entrySet();
        if (set != null) {
            for (Map.Entry entry : set) {
                if (!((Collection)entry.getValue()).contains(value)) continue;
                return true;
            }
        }
        return false;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final Object put(K key, Object value) {
        boolean bl = false;
        Collection<V> collection = this.a(key);
        if (collection == null) {
            collection = this.d();
            collection.add(value);
            if (collection.size() > 0) {
                void var1_1;
                this.i().put(var1_1, collection);
                bl = true;
            }
        } else {
            bl = collection.add(value);
        }
        if (bl) {
            void var2_2;
            return var2_2;
        }
        return null;
    }

    @Override
    public final void putAll(Map<? extends K, ?> map2) {
        Iterator iterator2;
        if (map2 instanceof fw_2) {
            for (Map.Entry entry : ((fw_2)((Object)map2)).entrySet()) {
                boolean bl;
                Collection collection = (Collection)entry.getValue();
                Object k2 = entry.getKey();
                jv_0 object = this;
                if (collection == null || collection.size() == 0) {
                    bl = false;
                    continue;
                }
                boolean bl2 = false;
                Collection<V> collection2 = object.a(k2);
                if (collection2 == null) {
                    collection.size();
                    collection2 = object.d();
                    collection2.addAll(collection);
                    if (collection2.size() > 0) {
                        object.i().put(k2, collection2);
                        bl2 = true;
                    }
                } else {
                    bl2 = collection2.addAll(collection);
                }
                bl = bl2;
            }
            return;
        }
        for (Map.Entry entry : iterator2.entrySet()) {
            ((jd_0)this).put(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public final Set<Map.Entry<K, Object>> entrySet() {
        return super.entrySet();
    }

    @Override
    public final Collection<Object> values() {
        Collection<Object> collection = this.d;
        if (collection != null) {
            return collection;
        }
        this.d = new b(this, 0);
        return this.d;
    }

    private boolean b(Object collection, Object object) {
        if ((collection = this.a(collection)) == null) {
            return false;
        }
        return collection.contains(object);
    }

    public final Collection<V> a(Object object) {
        return (Collection)this.i().get(object);
    }

    private int b(Object collection) {
        if ((collection = this.a(collection)) == null) {
            return 0;
        }
        return collection.size();
    }

    @Override
    private boolean a(K k2, Collection<V> collection) {
        if (collection == null || collection.size() == 0) {
            return false;
        }
        boolean bl = false;
        Collection<V> collection2 = this.a(k2);
        if (collection2 == null) {
            collection.size();
            collection2 = this.d();
            collection2.addAll(collection);
            if (collection2.size() > 0) {
                this.i().put(k2, collection2);
                bl = true;
            }
        } else {
            bl = collection2.addAll(collection);
        }
        return bl;
    }

    private Iterator<V> c(Object object) {
        if (!this.containsKey(object)) {
            return hw_1.b();
        }
        return new c(this, object);
    }

    private Iterator<Map.Entry<K, V>> b() {
        Object object = new ArrayList(this.keySet());
        object = object.iterator();
        return new ii_2<Map.Entry<K, V>>(this, (Iterator)object){
            private /* synthetic */ Iterator a;
            private /* synthetic */ jv_0 b;
            {
                this.b = jv_02;
                this.a = iterator2;
            }

            @Override
            public final Iterator<? extends Map.Entry<K, V>> a(int n2) {
                if (!this.a.hasNext()) {
                    return null;
                }
                Object e2 = this.a.next();
                fq_1 fq_12 = new fq_1<V, Map.Entry<K, V>>(this, e2){
                    final /* synthetic */ Object a;
                    private /* synthetic */ 1 b;
                    {
                        this.b = var1_1;
                        this.a = object;
                    }

                    private Map.Entry<K, V> b(V v) {
                        return new Map.Entry<K, V>(this, v){
                            private /* synthetic */ Object a;
                            private /* synthetic */ 1 b;
                            {
                                this.b = var1_1;
                                this.a = object;
                            }

                            @Override
                            public final K getKey() {
                                return this.b.a;
                            }

                            @Override
                            public final V getValue() {
                                return this.a;
                            }

                            @Override
                            public final V setValue(V value) {
                                throw new UnsupportedOperationException();
                            }
                        };
                    }

                    @Override
                    public final /* synthetic */ Object a(Object object) {
                        Object object2 = object;
                        object = this;
                        return new /* invalid duplicate definition of identical inner class */;
                    }
                };
                return new ix_1(new c(this.b, e2), fq_12);
            }
        };
    }

    public final int a() {
        int n2 = 0;
        for (Object v : this.i().values()) {
            n2 += fd_2.a(v);
        }
        return n2;
    }

    private Collection<V> d() {
        return this.c.a();
    }

    static final class a<T extends Collection<?>>
    implements Serializable,
    fh_2<T> {
        private static final long a = 2986114157496788874L;
        private final Class<T> b;

        public a(Class<T> clazz) {
            this.b = clazz;
        }

        private T b() {
            try {
                return (T)((Collection)this.b.newInstance());
            }
            catch (Exception exception) {
                throw new fk_2("Cannot instantiate class: " + this.b, exception);
            }
        }

        private void a(ObjectInputStream objectInputStream) {
            objectInputStream.defaultReadObject();
            if (this.b != null && !Collection.class.isAssignableFrom(this.b)) {
                throw new UnsupportedOperationException();
            }
        }

        @Override
        public final /* synthetic */ Object a() {
            return this.b();
        }
    }

    final class c
    implements Iterator<V> {
        private final Object a;
        private final Collection<V> b;
        private final Iterator<V> c;
        private /* synthetic */ jv_0 d;

        public c(jv_0 jv_02, Object object) {
            this.d = jv_02;
            this.a = object;
            this.b = jv_02.a(object);
            this.c = this.b.iterator();
        }

        @Override
        public final void remove() {
            this.c.remove();
            if (this.b.isEmpty()) {
                this.d.remove(this.a);
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

    final class b
    extends AbstractCollection<V> {
        private /* synthetic */ jv_0 a;

        private b(jv_0 jv_02) {
            this.a = jv_02;
        }

        @Override
        public final Iterator<V> iterator() {
            if_2 if_22 = new if_2();
            for (Object k2 : this.a.keySet()) {
                if_22.a(new c(this.a, k2));
            }
            return if_22;
        }

        @Override
        public final int size() {
            return this.a.a();
        }

        @Override
        public final void clear() {
            ((jd_0)this.a).clear();
        }

        /* synthetic */ b(jv_0 jv_02, byte by) {
            this(jv_02);
        }
    }
}

