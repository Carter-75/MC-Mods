/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import org.valkyrienskies.core.impl.shadow.fa_2;
import org.valkyrienskies.core.impl.shadow.fd_1;
import org.valkyrienskies.core.impl.shadow.fe_1;
import org.valkyrienskies.core.impl.shadow.fj_1;
import org.valkyrienskies.core.impl.shadow.fr_2;
import org.valkyrienskies.core.impl.shadow.fu_2;
import org.valkyrienskies.core.impl.shadow.ik_1;
import org.valkyrienskies.core.impl.shadow.iu_1;

public final class jB<K, V>
implements Serializable,
Cloneable,
fd_1<K, V>,
fa_2<K, V>,
fr_2<K, V> {
    private static final long a = -8931271118676803261L;
    private final K b;
    private V c;

    public jB() {
        this.b = null;
    }

    private jB(K k2, V v) {
        this.b = k2;
        this.c = v;
    }

    private jB(fr_2<K, V> fr_22) {
        this.b = fr_22.getKey();
        this.c = fr_22.getValue();
    }

    private jB(Map.Entry<? extends K, ? extends V> entry) {
        this.b = entry.getKey();
        this.c = entry.getValue();
    }

    private jB(Map<? extends K, ? extends V> object) {
        if (object.size() != 1) {
            throw new IllegalArgumentException("The map size must be 1");
        }
        object = object.entrySet().iterator().next();
        this.b = object.getKey();
        this.c = object.getValue();
    }

    @Override
    public final K getKey() {
        return this.b;
    }

    @Override
    public final V getValue() {
        return this.c;
    }

    public final V a(V v) {
        V v2 = this.c;
        this.c = v;
        return v2;
    }

    @Override
    public final boolean a() {
        return true;
    }

    @Override
    public final int b() {
        return 1;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final V get(Object key) {
        void var1_1;
        if (this.b(var1_1)) {
            return this.c;
        }
        return null;
    }

    @Override
    public final int size() {
        return 1;
    }

    @Override
    public final boolean isEmpty() {
        return false;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final boolean containsKey(Object key) {
        void var1_1;
        return this.b(var1_1);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final boolean containsValue(Object value) {
        void var1_1;
        return this.e(var1_1);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final V put(K key, V value) {
        void var1_1;
        if (this.b(var1_1)) {
            void var2_2;
            return this.a(var2_2);
        }
        throw new IllegalArgumentException("Cannot put new key/value pair - Map is fixed size singleton");
    }

    @Override
    public final void putAll(Map<? extends K, ? extends V> map2) {
        switch (map2.size()) {
            case 0: {
                return;
            }
            case 1: {
                Map.Entry entry;
                entry = entry.entrySet().iterator().next();
                this.put(entry.getKey(), entry.getValue());
                return;
            }
        }
        throw new IllegalArgumentException("The map size must be 0 or 1");
    }

    @Override
    public final V remove(Object key) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override
    public final Set<Map.Entry<K, V>> entrySet() {
        jB jB2 = this;
        ik_1 ik_12 = new ik_1(jB2, jB2.getKey());
        return Collections.singleton(ik_12);
    }

    @Override
    public final Set<K> keySet() {
        return Collections.singleton(this.b);
    }

    @Override
    public final Collection<V> values() {
        return new b(this);
    }

    @Override
    public final fe_1<K, V> e() {
        return new a(this);
    }

    @Override
    public final K firstKey() {
        return this.getKey();
    }

    @Override
    public final K lastKey() {
        return this.getKey();
    }

    @Override
    public final K c(K k2) {
        return null;
    }

    @Override
    public final K d(K k2) {
        return null;
    }

    private boolean b(Object object) {
        if (object == null) {
            return this.getKey() == null;
        }
        return object.equals(this.getKey());
    }

    private boolean e(Object object) {
        if (object == null) {
            return this.getValue() == null;
        }
        return object.equals(this.getValue());
    }

    private jB<K, V> d() {
        try {
            return (jB)super.clone();
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            throw new InternalError();
        }
    }

    @Override
    public final boolean equals(Object obj) {
        Object object;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        if ((object = (Map)object).size() != 1) {
            return false;
        }
        return this.b((object = object.entrySet().iterator().next()).getKey()) && this.e(object.getValue());
    }

    @Override
    public final int hashCode() {
        return (this.getKey() == null ? 0 : this.getKey().hashCode()) ^ (this.getValue() == null ? 0 : this.getValue().hashCode());
    }

    public final String toString() {
        return new StringBuilder(128).append('{').append((Object)(this.getKey() == this ? "(this Map)" : this.getKey())).append('=').append((Object)(this.getValue() == this ? "(this Map)" : this.getValue())).append('}').toString();
    }

    public final /* synthetic */ Object clone() {
        return this.d();
    }

    @Override
    public final /* synthetic */ fu_2 c() {
        return this.e();
    }

    static final class b<V>
    extends AbstractSet<V>
    implements Serializable {
        private static final long a = -3689524741863047872L;
        private final jB<?, V> b;

        b(jB<?, V> jB2) {
            this.b = jB2;
        }

        @Override
        public final int size() {
            return 1;
        }

        @Override
        public final boolean isEmpty() {
            return false;
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public final boolean contains(Object object) {
            void var1_1;
            return this.b.containsValue(var1_1);
        }

        @Override
        public final void clear() {
            throw new UnsupportedOperationException();
        }

        @Override
        public final Iterator<V> iterator() {
            return new iu_1<V>(this.b.getValue(), false);
        }
    }

    static final class a<K, V>
    implements fe_1<K, V>,
    fj_1<K> {
        private final jB<K, V> a;
        private boolean b = true;
        private boolean c = false;

        a(jB<K, V> jB2) {
            this.a = jB2;
        }

        @Override
        public final boolean hasNext() {
            return this.b;
        }

        @Override
        public final K next() {
            if (!this.b) {
                throw new NoSuchElementException("No next() entry in the iteration");
            }
            this.b = false;
            this.c = true;
            return this.a.getKey();
        }

        @Override
        public final boolean hasPrevious() {
            return !this.b;
        }

        @Override
        public final K previous() {
            if (this.b) {
                throw new NoSuchElementException("No previous() entry in the iteration");
            }
            this.b = true;
            return this.a.getKey();
        }

        @Override
        public final void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public final K a() {
            if (!this.c) {
                throw new IllegalStateException("getKey() can only be called after next() and before remove()");
            }
            return this.a.getKey();
        }

        @Override
        public final V b() {
            if (!this.c) {
                throw new IllegalStateException("getValue() can only be called after next() and before remove()");
            }
            return this.a.getValue();
        }

        @Override
        public final V a(V v) {
            if (!this.c) {
                throw new IllegalStateException("setValue() can only be called after next() and before remove()");
            }
            return this.a.a(v);
        }

        @Override
        public final void c() {
            this.b = true;
        }

        public final String toString() {
            if (this.b) {
                return "Iterator[]";
            }
            return "Iterator[" + this.a() + "=" + this.b() + "]";
        }
    }
}

