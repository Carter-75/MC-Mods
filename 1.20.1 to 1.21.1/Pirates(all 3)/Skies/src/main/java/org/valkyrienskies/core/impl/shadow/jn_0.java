/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.valkyrienskies.core.impl.shadow.jn
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import org.valkyrienskies.core.impl.shadow.fj_1;
import org.valkyrienskies.core.impl.shadow.fn_2;
import org.valkyrienskies.core.impl.shadow.fu_2;
import org.valkyrienskies.core.impl.shadow.hw_1;
import org.valkyrienskies.core.impl.shadow.hy_1;
import org.valkyrienskies.core.impl.shadow.iz_0;
import org.valkyrienskies.core.impl.shadow.jn;
import org.valkyrienskies.core.impl.shadow.jo_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.jn
 */
public final class jn_0<K, V>
implements Serializable,
Cloneable,
fn_2<K, V> {
    private static final long a = -6701087419741928296L;
    private transient int b;
    private transient int c;
    private transient int d;
    private transient int e;
    private transient K f;
    private transient K g;
    private transient K h;
    private transient V i;
    private transient V j;
    private transient V k;
    private transient iz_0<K, V> l;

    public jn_0() {
    }

    private jn_0(Map<? extends K, ? extends V> map2) {
        this.putAll(map2);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final V get(Object key) {
        if (this.l != null) {
            return this.l.get(key);
        }
        if (key == null) {
            switch (this.b) {
                case 3: {
                    if (this.h == null) {
                        return this.k;
                    }
                }
                case 2: {
                    if (this.g == null) {
                        return this.j;
                    }
                }
                case 1: {
                    if (this.f != null) break;
                    return this.i;
                }
            }
        } else if (this.b > 0) {
            int n2 = key.hashCode();
            switch (this.b) {
                case 3: {
                    if (this.e == n2 && key.equals(this.h)) {
                        return this.k;
                    }
                }
                case 2: {
                    if (this.d == n2 && key.equals(this.g)) {
                        return this.j;
                    }
                }
                case 1: {
                    void var1_1;
                    if (this.c != n2 || !var1_1.equals(this.f)) break;
                    return this.i;
                }
            }
        }
        return null;
    }

    @Override
    public final int size() {
        if (this.l != null) {
            return this.l.size();
        }
        return this.b;
    }

    @Override
    public final boolean isEmpty() {
        return this.size() == 0;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final boolean containsKey(Object key) {
        if (this.l != null) {
            return this.l.containsKey(key);
        }
        if (key == null) {
            switch (this.b) {
                case 3: {
                    if (this.h == null) {
                        return true;
                    }
                }
                case 2: {
                    if (this.g == null) {
                        return true;
                    }
                }
                case 1: {
                    if (this.f != null) break;
                    return true;
                }
            }
        } else if (this.b > 0) {
            int n2 = key.hashCode();
            switch (this.b) {
                case 3: {
                    if (this.e == n2 && key.equals(this.h)) {
                        return true;
                    }
                }
                case 2: {
                    if (this.d == n2 && key.equals(this.g)) {
                        return true;
                    }
                }
                case 1: {
                    void var1_1;
                    if (this.c != n2 || !var1_1.equals(this.f)) break;
                    return true;
                }
            }
        }
        return false;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final boolean containsValue(Object value) {
        if (this.l != null) {
            return this.l.containsValue(value);
        }
        if (value == null) {
            switch (this.b) {
                case 3: {
                    if (this.k == null) {
                        return true;
                    }
                }
                case 2: {
                    if (this.j == null) {
                        return true;
                    }
                }
                case 1: {
                    if (this.i != null) break;
                    return true;
                }
            }
        } else {
            switch (this.b) {
                case 3: {
                    if (value.equals(this.k)) {
                        return true;
                    }
                }
                case 2: {
                    if (value.equals(this.j)) {
                        return true;
                    }
                }
                case 1: {
                    void var1_1;
                    if (!var1_1.equals(this.i)) break;
                    return true;
                }
            }
        }
        return false;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final V put(K key, V value) {
        V v;
        if (this.l != null) {
            return this.l.put(key, value);
        }
        if (key == null) {
            switch (this.b) {
                case 3: {
                    if (this.h == null) {
                        V v2 = this.k;
                        this.k = value;
                        return v2;
                    }
                }
                case 2: {
                    if (this.g == null) {
                        V v3 = this.j;
                        this.j = value;
                        return v3;
                    }
                }
                case 1: {
                    if (this.f != null) break;
                    V v4 = this.i;
                    this.i = value;
                    return v4;
                }
            }
        } else if (this.b > 0) {
            int n2 = key.hashCode();
            switch (this.b) {
                case 3: {
                    if (this.e == n2 && key.equals(this.h)) {
                        v = this.k;
                        this.k = value;
                        return v;
                    }
                }
                case 2: {
                    if (this.d == n2 && v.equals(this.g)) {
                        v = this.j;
                        this.j = value;
                        return v;
                    }
                }
                case 1: {
                    if (this.c != n2 || !v.equals(this.f)) break;
                    v = this.i;
                    this.i = value;
                    return v;
                }
            }
        }
        switch (this.b) {
            default: {
                this.a();
                this.l.put((void)v, value);
                return null;
            }
            case 2: {
                this.e = v == null ? 0 : v.hashCode();
                this.h = v;
                this.k = value;
                break;
            }
            case 1: {
                this.d = v == null ? 0 : v.hashCode();
                this.g = v;
                this.j = value;
                break;
            }
            case 0: {
                void var2_2;
                this.c = v == null ? 0 : v.hashCode();
                this.f = v;
                this.i = var2_2;
            }
        }
        ++this.b;
        return null;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final void putAll(Map<? extends K, ? extends V> map2) {
        void var1_1;
        int n2 = map2.size();
        if (n2 == 0) {
            return;
        }
        if (this.l != null) {
            this.l.putAll((Map<K, V>)((Object)map2));
            return;
        }
        if (n2 < 4) {
            for (Map.Entry entry : map2.entrySet()) {
                this.put(entry.getKey(), entry.getValue());
            }
            return;
        }
        this.a();
        this.l.putAll((Map<K, V>)var1_1);
    }

    private void a() {
        this.l = new jo_0();
        switch (this.b) {
            case 3: {
                this.l.put(this.h, this.k);
            }
            case 2: {
                this.l.put(this.g, this.j);
            }
            case 1: {
                this.l.put(this.f, this.i);
            }
            case 0: {
                break;
            }
            default: {
                throw new IllegalStateException("Invalid map index: " + this.b);
            }
        }
        this.b = 0;
        jn_0 jn_02 = this;
        this.e = 0;
        jn_02.d = 0;
        jn_02.c = 0;
        jn_0 jn_03 = this;
        this.h = null;
        jn_03.g = null;
        jn_03.f = null;
        jn_0 jn_04 = this;
        this.k = null;
        jn_04.j = null;
        jn_04.i = null;
    }

    private static iz_0<K, V> b() {
        return new jo_0();
    }

    @Override
    public final V remove(Object key) {
        if (this.l != null) {
            return this.l.remove(key);
        }
        if (this.b == 0) {
            return null;
        }
        if (key == null) {
            switch (this.b) {
                case 3: {
                    if (this.h == null) {
                        V v = this.k;
                        this.e = 0;
                        this.h = null;
                        this.k = null;
                        this.b = 2;
                        return v;
                    }
                    if (this.g == null) {
                        V v = this.j;
                        this.d = this.e;
                        this.g = this.h;
                        this.j = this.k;
                        this.e = 0;
                        this.h = null;
                        this.k = null;
                        this.b = 2;
                        return v;
                    }
                    if (this.f == null) {
                        V v = this.i;
                        this.c = this.e;
                        this.f = this.h;
                        this.i = this.k;
                        this.e = 0;
                        this.h = null;
                        this.k = null;
                        this.b = 2;
                        return v;
                    }
                    return null;
                }
                case 2: {
                    if (this.g == null) {
                        V v = this.j;
                        this.d = 0;
                        this.g = null;
                        this.j = null;
                        this.b = 1;
                        return v;
                    }
                    if (this.f == null) {
                        V v = this.i;
                        this.c = this.d;
                        this.f = this.g;
                        this.i = this.j;
                        this.d = 0;
                        this.g = null;
                        this.j = null;
                        this.b = 1;
                        return v;
                    }
                    return null;
                }
                case 1: {
                    if (this.f != null) break;
                    V v = this.i;
                    this.c = 0;
                    this.f = null;
                    this.i = null;
                    this.b = 0;
                    return v;
                }
            }
        } else if (this.b > 0) {
            int n2 = key.hashCode();
            switch (this.b) {
                case 3: {
                    V v;
                    if (this.e == n2 && key.equals(this.h)) {
                        v = this.k;
                        this.e = 0;
                        this.h = null;
                        this.k = null;
                        this.b = 2;
                        return v;
                    }
                    if (this.d == n2 && v.equals(this.g)) {
                        v = this.j;
                        this.d = this.e;
                        this.g = this.h;
                        this.j = this.k;
                        this.e = 0;
                        this.h = null;
                        this.k = null;
                        this.b = 2;
                        return v;
                    }
                    if (this.c == n2 && v.equals(this.f)) {
                        v = this.i;
                        this.c = this.e;
                        this.f = this.h;
                        this.i = this.k;
                        this.e = 0;
                        this.h = null;
                        this.k = null;
                        this.b = 2;
                        return v;
                    }
                    return null;
                }
                case 2: {
                    V v;
                    if (this.d == n2 && v.equals(this.g)) {
                        v = this.j;
                        this.d = 0;
                        this.g = null;
                        this.j = null;
                        this.b = 1;
                        return v;
                    }
                    if (this.c == n2 && v.equals(this.f)) {
                        v = this.i;
                        this.c = this.d;
                        this.f = this.g;
                        this.i = this.j;
                        this.d = 0;
                        this.g = null;
                        this.j = null;
                        this.b = 1;
                        return v;
                    }
                    return null;
                }
                case 1: {
                    V v;
                    if (this.c != n2 || !v.equals(this.f)) break;
                    v = this.i;
                    this.c = 0;
                    this.f = null;
                    this.i = null;
                    this.b = 0;
                    return v;
                }
            }
        }
        return null;
    }

    @Override
    public final void clear() {
        if (this.l != null) {
            this.l.clear();
            this.l = null;
            return;
        }
        this.b = 0;
        jn_0 jn_02 = this;
        this.e = 0;
        jn_02.d = 0;
        jn_02.c = 0;
        jn_0 jn_03 = this;
        this.h = null;
        jn_03.g = null;
        jn_03.f = null;
        jn_0 jn_04 = this;
        this.k = null;
        jn_04.j = null;
        jn_04.i = null;
    }

    @Override
    public final fu_2<K, V> c() {
        if (this.l != null) {
            return this.l.c();
        }
        if (this.b == 0) {
            return hy_1.d();
        }
        return new e(this);
    }

    @Override
    public final Set<Map.Entry<K, V>> entrySet() {
        if (this.l != null) {
            return this.l.entrySet();
        }
        return new b(this);
    }

    @Override
    public final Set<K> keySet() {
        if (this.l != null) {
            return this.l.keySet();
        }
        return new f(this);
    }

    @Override
    public final Collection<V> values() {
        if (this.l != null) {
            return this.l.values();
        }
        return new h(this);
    }

    private void a(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(this.size());
        fu_2<K, V> fu_22 = this.c();
        while (fu_22.hasNext()) {
            objectOutputStream.writeObject(fu_22.next());
            objectOutputStream.writeObject(fu_22.b());
        }
    }

    private void a(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        int n2 = objectInputStream.readInt();
        if (n2 > 3) {
            this.l = new jo_0();
        }
        while (n2 > 0) {
            this.put(objectInputStream.readObject(), objectInputStream.readObject());
            --n2;
        }
    }

    private jn_0<K, V> d() {
        try {
            jn_0 jn_02 = (jn_0)super.clone();
            if (jn_02.l != null) {
                jn_02.l = jn_02.l.i();
            }
            return jn_02;
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            throw new InternalError();
        }
    }

    @Override
    public final boolean equals(Object obj) {
        Map map2;
        if (obj == this) {
            return true;
        }
        if (this.l != null) {
            return this.l.equals(obj);
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        if (this.b != (map2 = (Map)map2).size()) {
            return false;
        }
        if (this.b > 0) {
            switch (this.b) {
                case 3: {
                    if (!map2.containsKey(this.h)) {
                        return false;
                    }
                    Object v = map2.get(this.h);
                    if (this.k == null ? v != null : !this.k.equals(v)) {
                        return false;
                    }
                }
                case 2: {
                    if (!map2.containsKey(this.g)) {
                        return false;
                    }
                    Object v = map2.get(this.g);
                    if (this.j == null ? v != null : !this.j.equals(v)) {
                        return false;
                    }
                }
                case 1: {
                    if (!map2.containsKey(this.f)) {
                        return false;
                    }
                    Object v = map2.get(this.f);
                    if (!(this.i == null ? v != null : !this.i.equals(v))) break;
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public final int hashCode() {
        if (this.l != null) {
            return this.l.hashCode();
        }
        int n2 = 0;
        switch (this.b) {
            case 3: {
                n2 = 0 + (this.e ^ (this.k == null ? 0 : this.k.hashCode()));
            }
            case 2: {
                n2 += this.d ^ (this.j == null ? 0 : this.j.hashCode());
            }
            case 1: {
                n2 += this.c ^ (this.i == null ? 0 : this.i.hashCode());
            }
            case 0: {
                break;
            }
            default: {
                throw new IllegalStateException("Invalid map index: " + this.b);
            }
        }
        return n2;
    }

    public final String toString() {
        if (this.l != null) {
            return this.l.toString();
        }
        if (this.b == 0) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append('{');
        switch (this.b) {
            case 3: {
                stringBuilder.append((Object)(this.h == this ? "(this Map)" : this.h));
                stringBuilder.append('=');
                stringBuilder.append((Object)(this.k == this ? "(this Map)" : this.k));
                stringBuilder.append(',');
            }
            case 2: {
                stringBuilder.append((Object)(this.g == this ? "(this Map)" : this.g));
                stringBuilder.append('=');
                stringBuilder.append((Object)(this.j == this ? "(this Map)" : this.j));
                stringBuilder.append(',');
            }
            case 1: {
                stringBuilder.append((Object)(this.f == this ? "(this Map)" : this.f));
                stringBuilder.append('=');
                stringBuilder.append((Object)(this.i == this ? "(this Map)" : this.i));
                break;
            }
            default: {
                throw new IllegalStateException("Invalid map index: " + this.b);
            }
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public final /* synthetic */ Object clone() {
        return this.d();
    }

    static /* synthetic */ int a(jn_0 jn_02) {
        return jn_02.b;
    }

    static /* synthetic */ Object b(jn_0 jn_02) {
        return jn_02.h;
    }

    static /* synthetic */ Object c(jn_0 jn_02) {
        return jn_02.g;
    }

    static /* synthetic */ Object d(jn_0 jn_02) {
        return jn_02.f;
    }

    static /* synthetic */ Object e(jn_0 jn_02) {
        return jn_02.k;
    }

    static /* synthetic */ Object f(jn_0 jn_02) {
        return jn_02.j;
    }

    static /* synthetic */ Object g(jn_0 jn_02) {
        return jn_02.i;
    }

    static /* synthetic */ Object a(jn_0 jn_02, Object object) {
        jn_02.k = object;
        return jn_02.k;
    }

    static /* synthetic */ Object b(jn_0 jn_02, Object object) {
        jn_02.j = object;
        return jn_02.j;
    }

    static /* synthetic */ Object c(jn_0 jn_02, Object object) {
        jn_02.i = object;
        return jn_02.i;
    }

    static /* synthetic */ iz_0 h(jn_0 jn_02) {
        return jn_02.l;
    }

    static final class i<V>
    extends a<Object, V>
    implements Iterator<V> {
        i(jn_0<?, V> jn_02) {
            super(jn_02);
        }

        @Override
        public final V next() {
            return this.a().getValue();
        }
    }

    static final class h<V>
    extends AbstractCollection<V> {
        private final jn_0<?, V> a;

        h(jn_0<?, V> jn_02) {
            this.a = jn_02;
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
        public final boolean contains(Object value) {
            void var1_1;
            return this.a.containsValue(var1_1);
        }

        @Override
        public final Iterator<V> iterator() {
            if (jn.h(this.a) != null) {
                return jn.h(this.a).values().iterator();
            }
            if (this.a.size() == 0) {
                return hw_1.b();
            }
            return new i<V>(this.a);
        }
    }

    static final class g<K>
    extends a<K, Object>
    implements Iterator<K> {
        g(jn_0<K, ?> jn_02) {
            super(jn_02);
        }

        @Override
        public final K next() {
            return this.a().getKey();
        }
    }

    static final class f<K>
    extends AbstractSet<K> {
        private final jn_0<K, ?> a;

        f(jn_0<K, ?> jn_02) {
            this.a = jn_02;
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
        public final boolean contains(Object key) {
            void var1_1;
            return this.a.containsKey(var1_1);
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public final boolean remove(Object key) {
            void var1_1;
            boolean bl = this.a.containsKey(key);
            this.a.remove(var1_1);
            return bl;
        }

        @Override
        public final Iterator<K> iterator() {
            if (jn.h(this.a) != null) {
                return jn.h(this.a).keySet().iterator();
            }
            if (this.a.size() == 0) {
                return hw_1.b();
            }
            return new g<K>(this.a);
        }
    }

    static final class c<K, V>
    extends a<K, V>
    implements Iterator<Map.Entry<K, V>> {
        c(jn_0<K, V> jn_02) {
            super(jn_02);
        }

        private Map.Entry<K, V> b() {
            return this.a();
        }

        @Override
        public final /* synthetic */ Object next() {
            c c2 = this;
            return c2.a();
        }
    }

    static abstract class a<K, V> {
        private final jn_0<K, V> a;
        private int b = 0;
        private d<K, V> c = null;

        public a(jn_0<K, V> jn_02) {
            this.a = jn_02;
        }

        public boolean hasNext() {
            return this.b < jn.a(this.a);
        }

        public final Map.Entry<K, V> a() {
            if (!this.hasNext()) {
                throw new NoSuchElementException("No next() entry in the iteration");
            }
            this.c = new d<K, V>(this.a, ++this.b);
            return this.c;
        }

        public void remove() {
            if (this.c == null) {
                throw new IllegalStateException("remove() can only be called once after next()");
            }
            boolean bl = true;
            d<K, V> d2 = this.c;
            this.c.a = true;
            this.a.remove(this.c.getKey());
            --this.b;
            this.c = null;
        }
    }

    static final class d<K, V>
    implements Map.Entry<K, V> {
        private final jn_0<K, V> b;
        private final int c;
        volatile boolean a;

        public d(jn_0<K, V> jn_02, int n2) {
            this.b = jn_02;
            this.c = n2;
            this.a = false;
        }

        final void a(boolean bl) {
            this.a = true;
        }

        @Override
        public final K getKey() {
            if (this.a) {
                throw new IllegalStateException("getKey() can only be called after next() and before remove()");
            }
            switch (this.c) {
                case 3: {
                    return (K)jn.b(this.b);
                }
                case 2: {
                    return (K)jn.c(this.b);
                }
                case 1: {
                    return (K)jn.d(this.b);
                }
            }
            throw new IllegalStateException("Invalid map index: " + this.c);
        }

        @Override
        public final V getValue() {
            if (this.a) {
                throw new IllegalStateException("getValue() can only be called after next() and before remove()");
            }
            switch (this.c) {
                case 3: {
                    return (V)jn.e(this.b);
                }
                case 2: {
                    return (V)jn.f(this.b);
                }
                case 1: {
                    return (V)jn.g(this.b);
                }
            }
            throw new IllegalStateException("Invalid map index: " + this.c);
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public final V setValue(V value) {
            if (this.a) {
                throw new IllegalStateException("setValue() can only be called after next() and before remove()");
            }
            V v = this.getValue();
            switch (this.c) {
                case 3: {
                    jn.a(this.b, value);
                    break;
                }
                case 2: {
                    jn.b(this.b, value);
                    break;
                }
                case 1: {
                    void var1_1;
                    jn.c(this.b, (Object)var1_1);
                    break;
                }
                default: {
                    throw new IllegalStateException("Invalid map index: " + this.c);
                }
            }
            return v;
        }

        @Override
        public final boolean equals(Object obj) {
            Map.Entry entry;
            if (this.a) {
                return false;
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            entry = entry;
            K k2 = this.getKey();
            V v = this.getValue();
            return (k2 == null ? entry.getKey() == null : k2.equals(entry.getKey())) && (v == null ? entry.getValue() == null : v.equals(entry.getValue()));
        }

        @Override
        public final int hashCode() {
            if (this.a) {
                return 0;
            }
            K k2 = this.getKey();
            V v = this.getValue();
            return (k2 == null ? 0 : k2.hashCode()) ^ (v == null ? 0 : v.hashCode());
        }

        public final String toString() {
            if (!this.a) {
                return this.getKey() + "=" + this.getValue();
            }
            return "";
        }
    }

    static final class b<K, V>
    extends AbstractSet<Map.Entry<K, V>> {
        private final jn_0<K, V> a;

        b(jn_0<K, V> jn_02) {
            this.a = jn_02;
        }

        @Override
        public final int size() {
            return this.a.size();
        }

        @Override
        public final void clear() {
            this.a.clear();
        }

        @Override
        public final boolean remove(Object obj) {
            Map.Entry entry;
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            entry = entry;
            entry = entry.getKey();
            boolean bl = this.a.containsKey(entry);
            this.a.remove(entry);
            return bl;
        }

        @Override
        public final Iterator<Map.Entry<K, V>> iterator() {
            if (jn.h(this.a) != null) {
                return jn.h(this.a).entrySet().iterator();
            }
            if (this.a.size() == 0) {
                return hw_1.b();
            }
            return new c<K, V>(this.a);
        }
    }

    static final class e<K, V>
    implements fj_1<K>,
    fu_2<K, V> {
        private final jn_0<K, V> a;
        private int b = 0;
        private boolean c = false;

        e(jn_0<K, V> jn_02) {
            this.a = jn_02;
        }

        @Override
        public final boolean hasNext() {
            return this.b < jn.a(this.a);
        }

        @Override
        public final K next() {
            if (!this.hasNext()) {
                throw new NoSuchElementException("No next() entry in the iteration");
            }
            this.c = true;
            ++this.b;
            return this.a();
        }

        @Override
        public final void remove() {
            if (!this.c) {
                throw new IllegalStateException("remove() can only be called once after next()");
            }
            this.a.remove(this.a());
            --this.b;
            this.c = false;
        }

        @Override
        public final K a() {
            if (!this.c) {
                throw new IllegalStateException("getKey() can only be called after next() and before remove()");
            }
            switch (this.b) {
                case 3: {
                    return (K)jn.b(this.a);
                }
                case 2: {
                    return (K)jn.c(this.a);
                }
                case 1: {
                    return (K)jn.d(this.a);
                }
            }
            throw new IllegalStateException("Invalid map index: " + this.b);
        }

        @Override
        public final V b() {
            if (!this.c) {
                throw new IllegalStateException("getValue() can only be called after next() and before remove()");
            }
            switch (this.b) {
                case 3: {
                    return (V)jn.e(this.a);
                }
                case 2: {
                    return (V)jn.f(this.a);
                }
                case 1: {
                    return (V)jn.g(this.a);
                }
            }
            throw new IllegalStateException("Invalid map index: " + this.b);
        }

        @Override
        public final V a(V v) {
            if (!this.c) {
                throw new IllegalStateException("setValue() can only be called after next() and before remove()");
            }
            V v2 = this.b();
            switch (this.b) {
                case 3: {
                    jn.a(this.a, v);
                    break;
                }
                case 2: {
                    jn.b(this.a, v);
                    break;
                }
                case 1: {
                    jn.c(this.a, v);
                    break;
                }
                default: {
                    throw new IllegalStateException("Invalid map index: " + this.b);
                }
            }
            return v2;
        }

        @Override
        public final void c() {
            this.b = 0;
            this.c = false;
        }

        public final String toString() {
            if (this.c) {
                return "Iterator[" + this.a() + "=" + this.b() + "]";
            }
            return "Iterator[]";
        }
    }
}

