/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import org.valkyrienskies.core.impl.shadow.fe_1;
import org.valkyrienskies.core.impl.shadow.fu_2;
import org.valkyrienskies.core.impl.shadow.kG;
import org.valkyrienskies.core.impl.shadow.kI;
import org.valkyrienskies.core.impl.shadow.kL;

abstract class kH<K, V>
extends kG<K, V> {
    private static final long c = 5155253417231339498L;
    private transient i<K, V> d = new i<Object, Object>(null, null, -1);
    private volatile transient Set<K> e;
    private volatile transient Collection<V> f;
    private volatile transient Set<Map.Entry<K, V>> g;
    private transient int h = 0;
    protected transient int b = 0;

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    protected kH(kL kL2) {
        super(kL2);
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    protected kH(kL kL2, Map map2) {
        super(kL2);
        this.putAll(map2);
    }

    @Override
    public void clear() {
        this.d.a = null;
        this.d.c = -1;
        this.d.b = null;
        this.d.d = null;
        this.d.e = this.d;
        this.d.f = null;
        this.d.g = this.d;
        this.h = 0;
        this.h();
    }

    @Override
    public int size() {
        return this.h;
    }

    private void f() {
        ++this.h;
        this.h();
    }

    private void g() {
        --this.h;
        this.h();
    }

    private void h() {
        ++this.b;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public V put(K key, V value) {
        void var2_2;
        i<K, V> i2;
        if (key == null) {
            throw new NullPointerException("Key cannot be null");
        }
        int n2 = this.e(key);
        if (n2 == 0) {
            if (this.d.a()) {
                this.f();
            } else {
                this.h();
            }
            return this.d.a(key, value);
        }
        i<K, V> i3 = this.a(key, n2);
        if (this.b(key, i3.a)) {
            if (i3.a()) {
                this.f();
            } else {
                this.h();
            }
            return i3.a(key, value);
        }
        int n3 = this.a(key, i3.a);
        if (!kI.a(n3)) {
            if (kI.d(n3)) {
                i2 = new i<K, V>(key, value, n3);
                this.a((K)i2, n2);
                this.f();
                return null;
            }
            if (kI.c(n3)) {
                if (this.d.a()) {
                    this.f();
                } else {
                    this.h();
                }
                return this.d.a(i2, value);
            }
            if (kI.b(n3) && i3 != this.d) {
                this.h();
                return i3.a(i2, value);
            }
        }
        throw new IllegalArgumentException("Failed to put: " + i2 + " -> " + var2_2 + ", " + n3);
    }

    private i<K, V> a(i<K, V> i2, int n2) {
        i i3 = this.d.e;
        i<K, V> i4 = this.d;
        while (true) {
            if (i3.c >= i2.c || i3.c <= i4.c) {
                i2.g = i2;
                if (!this.a(i2.a, i2.c, n2)) {
                    i2.e = i2;
                    i2.f = i3;
                } else {
                    i2.e = i3;
                    i2.f = i2;
                }
                i2.d = i4;
                if (i3.c >= i2.c) {
                    i3.d = i2;
                }
                if (i3.c <= i4.c) {
                    i3.g = i2;
                }
                if (i4 == this.d || !this.a(i2.a, i4.c, n2)) {
                    i4.e = i2;
                } else {
                    i4.f = i2;
                }
                return i2;
            }
            i4 = i3;
            if (!this.a(i2.a, i3.c, n2)) {
                i3 = i3.e;
                continue;
            }
            i3 = i3.f;
        }
    }

    @Override
    public V get(Object k2) {
        i<K, V> i2;
        if ((i2 = this.f((Object)i2)) != null) {
            return i2.getValue();
        }
        return null;
    }

    final i<K, V> f(Object object) {
        Object object2 = object;
        object = object2;
        object = object2;
        if (object2 == null) {
            return null;
        }
        int n2 = this.e(object);
        i<Object, V> i2 = this.a(object, n2);
        if (!i2.a() && this.b(object, i2.a)) {
            return i2;
        }
        return null;
    }

    private Map.Entry<K, V> k(K object) {
        int n2 = this.e(object);
        h<Map.Entry<K, V>> h2 = new h<Map.Entry<K, V>>(0);
        kH kH2 = this;
        if (!kH2.a(kH2.d.e, -1, object, n2, h2)) {
            object = h2;
            return (Map.Entry)((h)object).a;
        }
        return null;
    }

    private K l(K object) {
        if ((object = this.k(object)) == null) {
            return null;
        }
        return object.getKey();
    }

    private V m(K object) {
        if ((object = this.k(object)) == null) {
            return null;
        }
        return object.getValue();
    }

    private boolean a(i<K, V> i2, int n2, K k2, int n3, h<Map.Entry<K, V>> h2) {
        while (true) {
            if (i2.c <= n2) {
                if (!i2.a()) {
                    i<K, V> i3 = i2;
                    i2 = h2;
                    h2.a = i3;
                    return false;
                }
                return true;
            }
            if (!this.a(k2, i2.c, n3)) {
                if (!this.a(i2.e, i2.c, k2, n3, h2)) break;
                n2 = i2.c;
                i2 = i2.f;
                continue;
            }
            if (!this.a(i2.f, i2.c, k2, n3, h2)) break;
            n2 = i2.c;
            i2 = i2.e;
        }
        return false;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public boolean containsKey(Object k2) {
        void var1_1;
        if (k2 == null) {
            return false;
        }
        int n2 = this.e(var1_1);
        i<void, V> i2 = this.a((K)var1_1, n2);
        return !i2.a() && this.b(var1_1, i2.a);
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.g == null) {
            this.g = new a(0);
        }
        return this.g;
    }

    @Override
    public Set<K> keySet() {
        if (this.e == null) {
            this.e = new b(0);
        }
        return this.e;
    }

    @Override
    public Collection<V> values() {
        if (this.f == null) {
            this.f = new l(0);
        }
        return this.f;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public V remove(Object k2) {
        void var1_1;
        if (k2 == null) {
            return null;
        }
        int n2 = this.e(var1_1);
        i i2 = this.d.e;
        i<K, V> i3 = this.d;
        while (true) {
            if (i2.c <= i3.c) {
                if (!i2.a() && this.b(var1_1, i2.a)) {
                    return this.a(i2);
                }
                return null;
            }
            i3 = i2;
            if (!this.a(var1_1, i2.c, n2)) {
                i2 = i2.e;
                continue;
            }
            i2 = i2.f;
        }
    }

    private i<K, V> a(K k2, int n2) {
        i i2 = this.d.e;
        i<K, V> i3 = this.d;
        while (i2.c > i3.c) {
            i3 = i2;
            if (!this.a(k2, i2.c, n2)) {
                i2 = i2.e;
                continue;
            }
            i2 = i2.f;
        }
        return i2;
    }

    final V a(i<K, V> i2) {
        if (i2 != this.d) {
            if (i2.b()) {
                this.f(i2);
            } else {
                this.e(i2);
            }
        }
        this.g();
        return i2.a(null, null);
    }

    private void e(i<K, V> i2) {
        i i3;
        if (i2 == this.d) {
            throw new IllegalArgumentException("Cannot delete root Entry!");
        }
        if (!i2.c()) {
            throw new IllegalArgumentException(i2 + " is not an external Entry!");
        }
        i i4 = i2.d;
        i i5 = i3 = i2.e == i2 ? i2.f : i2.e;
        if (i4.e == i2) {
            i4.e = i3;
        } else {
            i4.f = i3;
        }
        if (i3.c > i4.c) {
            i3.d = i4;
            return;
        }
        i3.g = i4;
    }

    private void f(i<K, V> i2) {
        i i3;
        if (i2 == this.d) {
            throw new IllegalArgumentException("Cannot delete root Entry!");
        }
        if (!i2.b()) {
            throw new IllegalArgumentException(i2 + " is not an internal Entry!");
        }
        i i4 = i2.g;
        i2.g.c = i2.c;
        i i5 = i4.d;
        i i6 = i3 = i4.e == i2 ? i4.f : i4.e;
        if (i4.g == i4 && i4.d != i2) {
            i4.g = i4.d;
        }
        if (i5.e == i4) {
            i5.e = i3;
        } else {
            i5.f = i3;
        }
        if (i3.c > i5.c) {
            i3.d = i5;
        }
        if (i2.e.d == i2) {
            i2.e.d = i4;
        }
        if (i2.f.d == i2) {
            i2.f.d = i4;
        }
        if (i2.d.e == i2) {
            i2.d.e = i4;
        } else {
            i2.d.f = i4;
        }
        i4.d = i2.d;
        i4.e = i2.e;
        i4.f = i2.f;
        if (kH.b(i4.e, i4)) {
            i4.e.g = i4;
        }
        if (kH.b(i4.f, i4)) {
            i4.f.g = i4;
        }
    }

    final i<K, V> b(i<K, V> i2) {
        if (i2 == null) {
            return this.b();
        }
        return this.a(i2.g, i2, null);
    }

    private i<K, V> a(i<K, V> i2, i<K, V> i3, i<K, V> i4) {
        while (true) {
            i<K, V> i5 = i2;
            if (i3 == null || i2 != i3.g) {
                while (!i5.e.a() && i3 != i5.e) {
                    if (kH.b(i5.e, i5)) {
                        return i5.e;
                    }
                    i5 = i5.e;
                }
            }
            if (i5.a()) {
                return null;
            }
            if (i5.f == null) {
                return null;
            }
            if (i3 != i5.f) {
                if (kH.b(i5.f, i5)) {
                    return i5.f;
                }
                i2 = i5.f;
                continue;
            }
            while (true) {
                i<K, V> i6 = i5;
                if (i6 != i6.d.f) break;
                if (i5 == i4) {
                    return null;
                }
                i5 = i5.d;
            }
            if (i5 == i4) {
                return null;
            }
            if (i5.d.f == null) {
                return null;
            }
            if (i3 != i5.d.f && kH.b(i5.d.f, i5.d)) {
                return i5.d.f;
            }
            if (i5.d.f == i5.d) {
                return null;
            }
            i2 = i5.d.f;
        }
    }

    final i<K, V> b() {
        if (this.isEmpty()) {
            return null;
        }
        return kH.c(this.d);
    }

    static i<K, V> c(i<K, V> i2) {
        while (true) {
            i i3;
            if ((i3 = i2.e).a()) {
                i3 = i2.f;
            }
            if (i3.c <= i2.c) {
                return i3;
            }
            i2 = i3;
        }
    }

    @Override
    public Comparator<? super K> comparator() {
        return this.a();
    }

    @Override
    public K firstKey() {
        if (this.size() == 0) {
            throw new NoSuchElementException();
        }
        return this.b().getKey();
    }

    @Override
    public K lastKey() {
        i<K, V> i2 = this.d();
        if (i2 != null) {
            return i2.getKey();
        }
        throw new NoSuchElementException();
    }

    @Override
    public final K c(K object) {
        if (object == null) {
            throw new NullPointerException();
        }
        if ((object = this.f(object)) != null) {
            if ((object = this.b((i<K, V>)object)) != null) {
                return ((kG.a)object).getKey();
            }
            return null;
        }
        return null;
    }

    @Override
    public final K d(K object) {
        if (object == null) {
            throw new NullPointerException();
        }
        if ((object = this.f(object)) != null) {
            if ((object = this.d((i<K, V>)object)) != null) {
                return ((kG.a)object).getKey();
            }
            return null;
        }
        return null;
    }

    @Override
    public fe_1<K, V> e() {
        return new k(this, 0);
    }

    @Override
    public final SortedMap<K, V> a(K k2) {
        int n2 = this.e(k2);
        boolean bl = false;
        int n3 = n2 + 0;
        kH kH2 = this;
        K k3 = k2;
        if (n3 > kH2.e(k3)) {
            throw new IllegalArgumentException("0" + " + " + n2 + " > " + kH2.e(k3));
        }
        if (n3 == 0) {
            return kH2;
        }
        return new d(kH2, k3, 0, n2, 0);
    }

    private SortedMap<K, V> c(K k2, int n2, int n3) {
        n2 = n3 + 0;
        if (n2 > this.e(k2)) {
            throw new IllegalArgumentException("0" + " + " + n3 + " > " + this.e(k2));
        }
        if (n2 == 0) {
            return this;
        }
        return new d(this, k2, 0, n3, 0);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public SortedMap<K, V> headMap(K toKey) {
        void var1_1;
        return new e(this, null, var1_1);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public SortedMap<K, V> subMap(K fromKey, K toKey) {
        void var2_2;
        void var1_1;
        return new e(this, var1_1, var2_2);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public SortedMap<K, V> tailMap(K fromKey) {
        void var1_1;
        return new e(this, var1_1, null);
    }

    final i<K, V> g(K object) {
        int n2 = this.e(object);
        if (n2 == 0) {
            if (!this.d.a()) {
                if (this.size() > 1) {
                    kH kH2 = this;
                    return kH2.b(kH2.d);
                }
                return null;
            }
            return this.b();
        }
        i<K, V> i2 = this.a(object, n2);
        if (this.b(object, i2.a)) {
            return this.b(i2);
        }
        int n3 = this.a(object, i2.a);
        if (kI.d(n3)) {
            object = new i<K, Object>(object, null, n3);
            this.a(object, n2);
            this.f();
            i<K, V> i3 = this.b((i<K, V>)object);
            this.a((i<K, V>)object);
            this.b -= 2;
            return i3;
        }
        if (kI.c(n3)) {
            if (!this.d.a()) {
                return this.b();
            }
            if (this.size() > 1) {
                kH kH3 = this;
                return kH3.b(kH3.b());
            }
            return null;
        }
        if (kI.b(n3)) {
            return this.b(i2);
        }
        throw new IllegalStateException("invalid lookup: " + object);
    }

    final i<K, V> h(K object) {
        int n2 = this.e(object);
        if (n2 == 0) {
            if (!this.d.a()) {
                return this.d;
            }
            return this.b();
        }
        i<K, V> i2 = this.a(object, n2);
        if (this.b(object, i2.a)) {
            return i2;
        }
        int n3 = this.a(object, i2.a);
        if (kI.d(n3)) {
            object = new i<K, Object>(object, null, n3);
            this.a(object, n2);
            this.f();
            i<K, V> i3 = this.b((i<K, V>)object);
            this.a((i<K, V>)object);
            this.b -= 2;
            return i3;
        }
        if (kI.c(n3)) {
            if (!this.d.a()) {
                return this.d;
            }
            return this.b();
        }
        if (kI.b(n3)) {
            return i2;
        }
        throw new IllegalStateException("invalid lookup: " + object);
    }

    final i<K, V> i(K object) {
        int n2 = this.e(object);
        if (n2 == 0) {
            return null;
        }
        i<K, V> i2 = this.a(object, n2);
        if (this.b(object, i2.a)) {
            return this.d(i2);
        }
        int n3 = this.a(object, i2.a);
        if (kI.d(n3)) {
            object = new i<K, Object>(object, null, n3);
            this.a(object, n2);
            this.f();
            i<K, V> i3 = this.d((i<K, V>)object);
            this.a((i<K, V>)object);
            this.b -= 2;
            return i3;
        }
        if (kI.c(n3)) {
            return null;
        }
        if (kI.b(n3)) {
            return this.d(i2);
        }
        throw new IllegalStateException("invalid lookup: " + object);
    }

    final i<K, V> j(K object) {
        int n2 = this.e(object);
        if (n2 == 0) {
            if (!this.d.a()) {
                return this.d;
            }
            return null;
        }
        i<K, V> i2 = this.a(object, n2);
        if (this.b(object, i2.a)) {
            return i2;
        }
        int n3 = this.a(object, i2.a);
        if (kI.d(n3)) {
            object = new i<K, Object>(object, null, n3);
            this.a(object, n2);
            this.f();
            i<K, V> i3 = this.d((i<K, V>)object);
            this.a((i<K, V>)object);
            this.b -= 2;
            return i3;
        }
        if (kI.c(n3)) {
            if (!this.d.a()) {
                return this.d;
            }
            return null;
        }
        if (kI.b(n3)) {
            return i2;
        }
        throw new IllegalStateException("invalid lookup: " + object);
    }

    final i<K, V> b(K k2, int n2, int n3) {
        i i2 = this.d.e;
        i<K, V> i3 = this.d;
        while (i2.c > i3.c && n3 > i2.c) {
            i3 = i2;
            if (!this.a(k2, n2 + i2.c, n2 + n3)) {
                i2 = i2.e;
                continue;
            }
            i2 = i2.f;
        }
        if ((i2 = i2.a() ? i3 : i2).a()) {
            return null;
        }
        int n4 = n2 + n3;
        if (i2 == this.d && this.e(i2.getKey()) < n4) {
            return null;
        }
        if (this.a(k2, n4 - 1, n4) != this.a(i2.a, n3 - 1, this.e(i2.a))) {
            return null;
        }
        int n5 = this.a().a(k2, n2, n3, i2.a, 0, this.e(i2.getKey()));
        if (n5 >= 0 && n5 < n3) {
            return null;
        }
        return i2;
    }

    final i<K, V> d() {
        return kH.g(this.d.e);
    }

    private static i<K, V> g(i<K, V> i2) {
        if (i2.f == null) {
            return null;
        }
        while (i2.f.c > i2.c) {
            i2 = i2.f;
        }
        return i2.f;
    }

    @Override
    final i<K, V> d(i<K, V> i2) {
        if (i2.g == null) {
            throw new IllegalArgumentException("must have come from somewhere!");
        }
        if (i2.g.f == i2) {
            if (kH.b(i2.g.e, i2.g)) {
                return i2.g.e;
            }
            return kH.g(i2.g.e);
        }
        i2 = i2.g;
        while (i2.d != null) {
            i<K, V> i3 = i2;
            if (i3 != i3.d.e) break;
            i2 = i2.d;
        }
        if (i2.d == null) {
            return null;
        }
        if (kH.b(i2.d.e, i2.d)) {
            if (i2.d.e == this.d) {
                if (this.d.a()) {
                    return null;
                }
                return this.d;
            }
            return i2.d.e;
        }
        return kH.g(i2.d.e);
    }

    final i<K, V> a(i<K, V> i2, i<K, V> i3) {
        if (i2 == null) {
            return this.b();
        }
        return this.a(i2.g, i2, i3);
    }

    private static boolean b(i<?, ?> i2, i<?, ?> i3) {
        return i2 != null && i2.c <= i3.c && !i2.a();
    }

    private void a(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.d = new i<Object, Object>(null, null, -1);
        int n2 = objectInputStream.readInt();
        for (int i2 = 0; i2 < n2; ++i2) {
            Object object = objectInputStream.readObject();
            Object object2 = objectInputStream.readObject();
            this.put(object, object2);
        }
    }

    private void a(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(this.size());
        for (Map.Entry<K, V> entry : this.entrySet()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeObject(entry.getValue());
        }
    }

    @Override
    public final /* synthetic */ fu_2 c() {
        return this.e();
    }

    final class c
    extends f {
        private final d c;
        private i<K, V> d;
        private int e;

        public c(d d2) {
            super(d2);
            this.e = 0;
            this.c = d2;
        }

        @Override
        public final int size() {
            return this.c.f();
        }

        @Override
        public final Iterator<Map.Entry<K, V>> iterator() {
            if (kH.this.b != this.e) {
                this.d = kH.this.b(this.c.a, this.c.b, this.c.c);
                this.e = kH.this.b;
            }
            if (this.d == null) {
                Set set = Collections.emptySet();
                return set.iterator();
            }
            if (this.c.c > this.d.c) {
                c c2 = this;
                return new b(c2, c2.d);
            }
            c c3 = this;
            return new a(c3, c3.d, this.c.a, this.c.b, this.c.c);
        }

        final class a
        extends j<Map.Entry<K, V>> {
            private final K d;
            private final int e;
            private final int f;
            private boolean g;
            private i<K, V> h;
            private /* synthetic */ c i;

            a(c c2, i<K, V> i2, K k2, int n2, int n3) {
                this.i = c2;
                super(c2.kH.this);
                this.h = i2;
                kH cfr_ignored_0 = c2.kH.this;
                this.b = kH.c(i2);
                this.d = k2;
                this.e = n2;
                this.f = n3;
            }

            private Map.Entry<K, V> a() {
                i i2 = this.c();
                if (this.g) {
                    this.b = null;
                }
                return i2;
            }

            @Override
            protected final i<K, V> a(i<K, V> i2) {
                return this.i.kH.this.a(i2, this.h);
            }

            @Override
            public final void remove() {
                boolean bl = false;
                int n2 = this.h.c;
                if (this.c == this.h) {
                    bl = true;
                }
                super.remove();
                if (n2 != this.h.c || bl) {
                    this.h = this.i.kH.this.b(this.d, this.e, this.f);
                }
                if (this.f >= this.h.c) {
                    this.g = true;
                }
            }

            @Override
            public final /* synthetic */ Object next() {
                a a2 = this;
                i i2 = a2.c();
                if (a2.g) {
                    a2.b = null;
                }
                return i2;
            }
        }

        final class b
        implements Iterator<Map.Entry<K, V>> {
            private final i<K, V> a;
            private int b = 0;
            private /* synthetic */ c c;

            public b(c c2, i<K, V> i2) {
                this.c = c2;
                this.a = i2;
            }

            @Override
            public final boolean hasNext() {
                return this.b == 0;
            }

            private Map.Entry<K, V> a() {
                if (this.b != 0) {
                    throw new NoSuchElementException();
                }
                ++this.b;
                return this.a;
            }

            @Override
            public final void remove() {
                if (this.b != 1) {
                    throw new IllegalStateException();
                }
                ++this.b;
                this.c.kH.this.a(this.a);
            }

            @Override
            public final /* synthetic */ Object next() {
                b b2 = this;
                if (b2.b != 0) {
                    throw new NoSuchElementException();
                }
                ++b2.b;
                return b2.a;
            }
        }
    }

    final class d
    extends g {
        private final K a;
        private final int b;
        private final int c;
        private K d;
        private K e;
        private transient int f;
        private int g;
        private /* synthetic */ kH h;

        private d(kH kH2, K k2, int n2, int n3) {
            this.h = kH2;
            super(kH2, (byte)0);
            this.d = null;
            this.e = null;
            this.f = 0;
            this.g = -1;
            this.a = k2;
            this.b = n2;
            this.c = n3;
        }

        private int f() {
            if (this.g == -1 || this.h.b != this.f) {
                Iterator iterator2 = super.entrySet().iterator();
                this.g = 0;
                Map.Entry entry = null;
                if (iterator2.hasNext()) {
                    entry = iterator2.next();
                    this.g = 1;
                }
                Object v0 = (this.d = entry == null ? null : entry.getKey());
                if (this.d != null) {
                    i i2 = this.h.d((i)entry);
                    this.d = i2 == null ? null : i2.getKey();
                }
                this.e = this.d;
                while (iterator2.hasNext()) {
                    ++this.g;
                    entry = iterator2.next();
                }
                this.e = entry == null ? null : entry.getKey();
                Object v1 = this.e;
                if (this.e != null) {
                    this.e = (entry = this.h.b((i)entry)) == null ? null : entry.getKey();
                }
                this.f = this.h.b;
            }
            return this.g;
        }

        @Override
        public final K firstKey() {
            Object k2;
            block3: {
                block2: {
                    this.f();
                    Serializable serializable = this.d == null ? this.h.b() : this.h.g(this.d);
                    Object k3 = k2 = serializable != null ? (Object)serializable.getKey() : null;
                    if (serializable == null) break block2;
                    serializable = this.h;
                    if (((kG)serializable).a.a(this.a, this.b, this.c, k2)) break block3;
                }
                throw new NoSuchElementException();
            }
            return k2;
        }

        @Override
        public final K lastKey() {
            Object k2;
            block3: {
                block2: {
                    this.f();
                    Serializable serializable = this.e == null ? this.h.d() : this.h.i(this.e);
                    Object k3 = k2 = serializable != null ? (Object)serializable.getKey() : null;
                    if (serializable == null) break block2;
                    serializable = this.h;
                    if (((kG)serializable).a.a(this.a, this.b, this.c, k2)) break block3;
                }
                throw new NoSuchElementException();
            }
            return k2;
        }

        @Override
        protected final boolean a(K k2) {
            kH kH2 = this.h;
            return kH2.a.a(this.a, this.b, this.c, k2);
        }

        @Override
        protected final boolean b(K k2) {
            return this.a(k2);
        }

        @Override
        protected final boolean a(K k2, boolean bl) {
            kH kH2 = this.h;
            return kH2.a.a(this.a, this.b, this.c, k2);
        }

        @Override
        protected final boolean b(K k2, boolean bl) {
            kH kH2 = this.h;
            return kH2.a.a(this.a, this.b, this.c, k2);
        }

        @Override
        protected final Set<Map.Entry<K, V>> a() {
            return this.h.new c(this);
        }

        @Override
        public final K b() {
            return this.d;
        }

        @Override
        public final K c() {
            return this.e;
        }

        @Override
        public final boolean d() {
            return false;
        }

        @Override
        public final boolean e() {
            return false;
        }

        @Override
        protected final SortedMap<K, V> a(K k2, boolean bl, K k3, boolean bl2) {
            return new e(this.h, k2, bl, k3, bl2);
        }

        @Override
        public final void clear() {
            Iterator iterator2 = this.h.entrySet().iterator();
            Set set = this.keySet();
            while (iterator2.hasNext()) {
                if (!set.contains(iterator2.next().getKey())) continue;
                iterator2.remove();
            }
        }

        /* synthetic */ d(kH kH2, Object object, int n2, int n3, byte by) {
            this(kH2, object, n2, n3);
        }
    }

    class f
    extends AbstractSet<Map.Entry<K, V>> {
        private final g a;
        private transient int c = -1;
        private transient int d;

        public f(g g2) {
            if (g2 == null) {
                throw new NullPointerException("delegate");
            }
            this.a = g2;
        }

        @Override
        public Iterator<Map.Entry<K, V>> iterator() {
            Object object = this.a.b();
            Object k2 = this.a.c();
            object = object == null ? kH.this.b() : kH.this.h(object);
            i i2 = null;
            if (k2 != null) {
                i2 = kH.this.h(k2);
            }
            return new a(this, (i)object, i2, 0);
        }

        @Override
        public int size() {
            if (this.c == -1 || this.d != kH.this.b) {
                this.c = 0;
                Iterator iterator2 = this.iterator();
                while (iterator2.hasNext()) {
                    ++this.c;
                    iterator2.next();
                }
                this.d = kH.this.b;
            }
            return this.c;
        }

        @Override
        public boolean isEmpty() {
            return !this.iterator().hasNext();
        }

        @Override
        public boolean contains(Object o) {
            Map.Entry entry;
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Object object = (entry = (Map.Entry)entry).getKey();
            if (!this.a.a(object)) {
                return false;
            }
            return (object = kH.this.f(object)) != null && kG.c(((kG.a)object).getValue(), entry.getValue());
        }

        @Override
        public boolean remove(Object o) {
            Map.Entry entry;
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Object object = (entry = (Map.Entry)entry).getKey();
            if (!this.a.a(object)) {
                return false;
            }
            if ((object = kH.this.f(object)) != null && kG.c(((kG.a)object).getValue(), entry.getValue())) {
                kH.this.a(object);
                return true;
            }
            return false;
        }

        final class a
        extends j<Map.Entry<K, V>> {
            private final K d;
            private /* synthetic */ f e;

            private a(f f2, i<K, V> i2, i<K, V> i3) {
                this.e = f2;
                super(f2.kH.this, i2);
                this.d = i3 != null ? i3.getKey() : null;
            }

            @Override
            public final boolean hasNext() {
                return this.b != null && !kG.c(this.b.a, this.d);
            }

            private Map.Entry<K, V> a() {
                if (this.b == null || kG.c(this.b.a, this.d)) {
                    throw new NoSuchElementException();
                }
                return this.c();
            }

            @Override
            public final /* synthetic */ Object next() {
                a a2 = this;
                if (a2.b == null || kG.c(a2.b.a, a2.d)) {
                    throw new NoSuchElementException();
                }
                return a2.c();
            }

            /* synthetic */ a(f f2, i i2, i i3, byte by) {
                this(f2, i2, i3);
            }
        }
    }

    final class e
    extends g {
        private final K a;
        private final K b;
        private final boolean c;
        private final boolean d;
        private /* synthetic */ kH e;

        protected e(kH kH2, K k2, K k3) {
            this(kH2, k2, true, k3, false);
        }

        protected e(kH kH2, K k2, boolean bl, K k3, boolean bl2) {
            this.e = kH2;
            super(kH2, (byte)0);
            if (k2 == null && k3 == null) {
                throw new IllegalArgumentException("must have a from or to!");
            }
            if (k2 != null && k3 != null && kH2.a.compare(k2, k3) > 0) {
                throw new IllegalArgumentException("fromKey > toKey");
            }
            this.a = k2;
            this.c = bl;
            this.b = k3;
            this.d = bl2;
        }

        @Override
        public final K firstKey() {
            Object k2;
            i i2 = this.a == null ? this.e.b() : (this.c ? this.e.h(this.a) : this.e.g(this.a));
            Object k3 = k2 = i2 != null ? (Object)i2.getKey() : null;
            if (i2 == null || this.b != null && !this.b(k2, false)) {
                throw new NoSuchElementException();
            }
            return k2;
        }

        @Override
        public final K lastKey() {
            Object k2;
            i i2 = this.b == null ? this.e.d() : (this.d ? this.e.j(this.b) : this.e.i(this.b));
            Object k3 = k2 = i2 != null ? (Object)i2.getKey() : null;
            if (i2 == null || this.a != null && !this.a(k2, false)) {
                throw new NoSuchElementException();
            }
            return k2;
        }

        @Override
        protected final Set<Map.Entry<K, V>> a() {
            return this.e.new f(this);
        }

        @Override
        public final K b() {
            return this.a;
        }

        @Override
        public final K c() {
            return this.b;
        }

        @Override
        public final boolean d() {
            return this.c;
        }

        @Override
        public final boolean e() {
            return this.d;
        }

        @Override
        protected final SortedMap<K, V> a(K k2, boolean bl, K k3, boolean bl2) {
            return new e(this.e, k2, bl, k3, bl2);
        }
    }

    abstract class g
    extends AbstractMap<K, V>
    implements SortedMap<K, V> {
        private volatile transient Set<Map.Entry<K, V>> a;
        private /* synthetic */ kH b;

        private g(kH kH2) {
            this.b = kH2;
        }

        protected abstract Set<Map.Entry<K, V>> a();

        protected abstract K b();

        protected abstract boolean d();

        protected abstract K c();

        protected abstract boolean e();

        @Override
        public Comparator<? super K> comparator() {
            return this.b.comparator();
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public boolean containsKey(Object key) {
            void var1_1;
            g g2 = this;
            kH cfr_ignored_0 = g2.b;
            if (!g2.a(kH.b(key))) {
                return false;
            }
            return this.b.containsKey(var1_1);
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public V remove(Object key) {
            void var1_1;
            g g2 = this;
            kH cfr_ignored_0 = g2.b;
            if (!g2.a(kH.b(key))) {
                return null;
            }
            return this.b.remove(var1_1);
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public V get(Object key) {
            void var1_1;
            g g2 = this;
            kH cfr_ignored_0 = g2.b;
            if (!g2.a(kH.b(key))) {
                return null;
            }
            return this.b.get(var1_1);
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public V put(K key, V value) {
            void var2_2;
            void var1_1;
            if (!this.a(key)) {
                throw new IllegalArgumentException("Key is out of range: " + key);
            }
            return this.b.put(var1_1, var2_2);
        }

        @Override
        public Set<Map.Entry<K, V>> entrySet() {
            if (this.a == null) {
                this.a = this.a();
            }
            return this.a;
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public SortedMap<K, V> subMap(K fromKey, K toKey) {
            void var2_2;
            void var1_1;
            if (!this.b(fromKey)) {
                throw new IllegalArgumentException("FromKey is out of range: " + fromKey);
            }
            if (!this.b(toKey)) {
                throw new IllegalArgumentException("ToKey is out of range: " + toKey);
            }
            return this.a(var1_1, this.d(), var2_2, this.e());
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public SortedMap<K, V> headMap(K toKey) {
            void var1_1;
            if (!this.b(toKey)) {
                throw new IllegalArgumentException("ToKey is out of range: " + toKey);
            }
            g g2 = this;
            return g2.a(g2.b(), this.d(), var1_1, this.e());
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public SortedMap<K, V> tailMap(K fromKey) {
            void var1_1;
            if (!this.b(fromKey)) {
                throw new IllegalArgumentException("FromKey is out of range: " + fromKey);
            }
            return this.a(var1_1, this.d(), this.c(), this.e());
        }

        protected boolean a(K k2) {
            Object k3 = this.b();
            Object k4 = this.c();
            return !(k3 != null && !this.a(k2, false) || k4 != null && !this.b(k2, false));
        }

        protected boolean b(K k2) {
            Object k3 = this.b();
            Object k4 = this.c();
            return !(k3 != null && !this.a(k2, false) || k4 != null && !this.b(k2, true));
        }

        protected boolean a(K k2, boolean bl) {
            Object k3 = this.b();
            boolean bl2 = this.d();
            kH kH2 = this.b;
            int n2 = kH2.a.compare(k2, k3);
            if (bl2) {
                return n2 >= 0;
            }
            return n2 > 0;
        }

        protected boolean b(K k2, boolean bl) {
            Object k3 = this.c();
            boolean bl2 = this.e();
            kH kH2 = this.b;
            int n2 = kH2.a.compare(k2, k3);
            if (bl2 || bl) {
                return n2 <= 0;
            }
            return n2 < 0;
        }

        protected abstract SortedMap<K, V> a(K var1, boolean var2, K var3, boolean var4);

        /* synthetic */ g(kH kH2, byte by) {
            this(kH2);
        }
    }

    final class k
    extends j<K>
    implements fe_1<K, V> {
        private i<K, V> d;
        private /* synthetic */ kH e;

        private k(kH kH2) {
            this.e = kH2;
            super(kH2);
        }

        @Override
        public final K next() {
            return this.c().getKey();
        }

        @Override
        public final K a() {
            if (this.c == null) {
                throw new IllegalStateException();
            }
            return this.c.getKey();
        }

        @Override
        public final V b() {
            if (this.c == null) {
                throw new IllegalStateException();
            }
            return this.c.getValue();
        }

        @Override
        public final V a(V v) {
            if (this.c == null) {
                throw new IllegalStateException();
            }
            return this.c.setValue(v);
        }

        @Override
        public final boolean hasPrevious() {
            return this.d != null;
        }

        @Override
        public final K previous() {
            k k2 = this;
            if (k2.a != k2.e.b) {
                throw new ConcurrentModificationException();
            }
            i i2 = k2.d;
            if (i2 == null) {
                throw new NoSuchElementException();
            }
            k2.d = k2.e.d(i2);
            k2.b = k2.c;
            k2.c = i2;
            return k2.c.getKey();
        }

        @Override
        protected final i<K, V> c() {
            i i2 = super.c();
            this.d = i2;
            return i2;
        }

        private i<K, V> d() {
            if (this.a != this.e.b) {
                throw new ConcurrentModificationException();
            }
            i i2 = this.d;
            if (i2 == null) {
                throw new NoSuchElementException();
            }
            this.d = this.e.d(i2);
            this.b = this.c;
            this.c = i2;
            return this.c;
        }

        /* synthetic */ k(kH kH2, byte by) {
            this(kH2);
        }
    }

    abstract class j<E>
    implements Iterator<E> {
        protected int a;
        protected i<K, V> b;
        protected i<K, V> c;
        private /* synthetic */ kH d;

        protected j(kH kH2) {
            this.d = kH2;
            this.a = this.d.b;
            this.b = kH2.b(null);
        }

        protected j(kH kH2, i<K, V> i2) {
            this.d = kH2;
            this.a = this.d.b;
            this.b = i2;
        }

        protected i<K, V> c() {
            if (this.a != this.d.b) {
                throw new ConcurrentModificationException();
            }
            i i2 = this.b;
            if (i2 == null) {
                throw new NoSuchElementException();
            }
            this.b = this.a(i2);
            this.c = i2;
            return i2;
        }

        protected i<K, V> a(i<K, V> i2) {
            return this.d.b(i2);
        }

        @Override
        public boolean hasNext() {
            return this.b != null;
        }

        @Override
        public void remove() {
            if (this.c == null) {
                throw new IllegalStateException();
            }
            if (this.a != this.d.b) {
                throw new ConcurrentModificationException();
            }
            i i2 = this.c;
            this.c = null;
            this.d.a(i2);
            this.a = this.d.b;
        }
    }

    final class l
    extends AbstractCollection<V> {
        private l() {
        }

        @Override
        public final Iterator<V> iterator() {
            return new a(this, 0);
        }

        @Override
        public final int size() {
            return kH.this.size();
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public final boolean contains(Object o) {
            void var1_1;
            return kH.this.containsValue(var1_1);
        }

        @Override
        public final void clear() {
            kH.this.clear();
        }

        @Override
        public final boolean remove(Object o) {
            Iterator iterator2 = this.iterator();
            while (iterator2.hasNext()) {
                Object v = iterator2.next();
                if (!kG.c(v, o)) continue;
                iterator2.remove();
                return true;
            }
            return false;
        }

        /* synthetic */ l(byte by) {
            this();
        }

        final class a
        extends j<V> {
            private /* synthetic */ l d;

            private a(l l2) {
                this.d = l2;
                super(l2.kH.this);
            }

            @Override
            public final V next() {
                return this.c().getValue();
            }

            /* synthetic */ a(l l2, byte by) {
                this(l2);
            }
        }
    }

    final class b
    extends AbstractSet<K> {
        private b() {
        }

        @Override
        public final Iterator<K> iterator() {
            return new a(this, 0);
        }

        @Override
        public final int size() {
            return kH.this.size();
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public final boolean contains(Object o) {
            void var1_1;
            return kH.this.containsKey(var1_1);
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public final boolean remove(Object o) {
            void var1_1;
            int n2 = this.size();
            kH.this.remove(var1_1);
            return n2 != this.size();
        }

        @Override
        public final void clear() {
            kH.this.clear();
        }

        /* synthetic */ b(byte by) {
            this();
        }

        final class a
        extends j<K> {
            private /* synthetic */ b d;

            private a(b b2) {
                this.d = b2;
                super(b2.kH.this);
            }

            @Override
            public final K next() {
                return this.c().getKey();
            }

            /* synthetic */ a(b b2, byte by) {
                this(b2);
            }
        }
    }

    final class org.valkyrienskies.core.impl.shadow.kH$a
    extends AbstractSet<Map.Entry<K, V>> {
        private org.valkyrienskies.core.impl.shadow.kH$a() {
        }

        @Override
        public final Iterator<Map.Entry<K, V>> iterator() {
            return new a(this, 0);
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public final boolean contains(Object o) {
            void var1_1;
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            i i2 = kH.this.f(((Map.Entry)o).getKey());
            return i2 != null && i2.equals(var1_1);
        }

        @Override
        public final boolean remove(Object obj) {
            Map.Entry entry;
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            if (!this.contains(obj)) {
                return false;
            }
            entry = entry;
            kH.this.remove(entry.getKey());
            return true;
        }

        @Override
        public final int size() {
            return kH.this.size();
        }

        @Override
        public final void clear() {
            kH.this.clear();
        }

        /* synthetic */ org.valkyrienskies.core.impl.shadow.kH$a(byte by) {
            this();
        }

        final class a
        extends j<Map.Entry<K, V>> {
            private /* synthetic */ org.valkyrienskies.core.impl.shadow.kH$a d;

            private a(org.valkyrienskies.core.impl.shadow.kH$a a2) {
                this.d = a2;
                super(a2.kH.this);
            }

            private Map.Entry<K, V> a() {
                return this.c();
            }

            @Override
            public final /* synthetic */ Object next() {
                a a2 = this;
                return a2.c();
            }

            /* synthetic */ a(org.valkyrienskies.core.impl.shadow.kH$a a2, byte by) {
                this(a2);
            }
        }
    }

    protected static final class i<K, V>
    extends kG.a<K, V> {
        private static final long h = 4596023148184140013L;
        protected int c;
        protected i<K, V> d;
        protected i<K, V> e;
        protected i<K, V> f;
        protected i<K, V> g;

        public i(K k2, V v, int n2) {
            super(k2, v);
            this.c = n2;
            this.d = null;
            this.e = this;
            this.f = null;
            this.g = this;
        }

        public final boolean a() {
            return this.a == null;
        }

        public final boolean b() {
            return this.e != this && this.f != this;
        }

        public final boolean c() {
            return !this.b();
        }

        @Override
        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            if (this.c == -1) {
                stringBuilder.append("RootEntry(");
            } else {
                stringBuilder.append("Entry(");
            }
            stringBuilder.append("key=").append(this.getKey()).append(" [").append(this.c).append("], ");
            stringBuilder.append("value=").append(this.getValue()).append(", ");
            if (this.d != null) {
                if (this.d.c == -1) {
                    stringBuilder.append("parent=ROOT");
                } else {
                    stringBuilder.append("parent=").append(this.d.getKey()).append(" [").append(this.d.c).append("]");
                }
            } else {
                stringBuilder.append("parent=null");
            }
            stringBuilder.append(", ");
            if (this.e != null) {
                if (this.e.c == -1) {
                    stringBuilder.append("left=ROOT");
                } else {
                    stringBuilder.append("left=").append(this.e.getKey()).append(" [").append(this.e.c).append("]");
                }
            } else {
                stringBuilder.append("left=null");
            }
            stringBuilder.append(", ");
            if (this.f != null) {
                if (this.f.c == -1) {
                    stringBuilder.append("right=ROOT");
                } else {
                    stringBuilder.append("right=").append(this.f.getKey()).append(" [").append(this.f.c).append("]");
                }
            } else {
                stringBuilder.append("right=null");
            }
            stringBuilder.append(", ");
            if (this.g != null) {
                if (this.g.c == -1) {
                    stringBuilder.append("predecessor=ROOT");
                } else {
                    stringBuilder.append("predecessor=").append(this.g.getKey()).append(" [").append(this.g.c).append("]");
                }
            }
            stringBuilder.append(")");
            return stringBuilder.toString();
        }
    }

    static final class h<E> {
        E a;

        private h() {
        }

        public final void a(E e2) {
            this.a = e2;
        }

        public final E a() {
            return this.a;
        }

        /* synthetic */ h(byte by) {
            this();
        }
    }
}

