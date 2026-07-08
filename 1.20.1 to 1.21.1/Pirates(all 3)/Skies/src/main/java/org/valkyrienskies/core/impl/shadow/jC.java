/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.AbstractCollection;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import org.valkyrienskies.core.impl.shadow.fr_2;
import org.valkyrienskies.core.impl.shadow.jb_0;

public final class jC<K, V>
extends jb_0<K, V> {
    private static final int a = 255;
    private final g<K, V>[] b;
    private final f[] c;

    public jC() {
        this(255);
    }

    private jC(int n2) {
        n2 = Math.max(17, 255);
        if (n2 % 2 == 0) {
            --n2;
        }
        this.b = new g[n2];
        this.c = new f[n2];
        for (int i2 = 0; i2 < n2; ++i2) {
            this.c[i2] = new f(0);
        }
    }

    private int a(Object object) {
        if (object == null) {
            return 0;
        }
        int n2 = object.hashCode();
        n2 += ~(n2 << 15);
        n2 ^= n2 >>> 10;
        n2 += n2 << 3;
        n2 ^= n2 >>> 6;
        n2 += ~(n2 << 11);
        n2 ^= n2 >>> 16;
        if ((n2 %= this.b.length) < 0) {
            return -n2;
        }
        return n2;
    }

    @Override
    public final int size() {
        int n2 = 0;
        for (int i2 = 0; i2 < this.b.length; ++i2) {
            f f2 = this.c[i2];
            synchronized (f2) {
                n2 += this.c[i2].a;
                continue;
            }
        }
        return n2;
    }

    @Override
    public final boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public final V get(Object key) {
        int n2 = this.a(key);
        f f2 = this.c[n2];
        synchronized (f2) {
            g<K, V> g2 = this.b[n2];
            while (g2 != null) {
                if (g2.a == key || g2.a != null && g2.a.equals(key)) {
                    return g2.b;
                }
                g2 = g2.c;
            }
        }
        return null;
    }

    @Override
    public final boolean containsKey(Object key) {
        int n2 = this.a(key);
        f f2 = this.c[n2];
        synchronized (f2) {
            g<K, V> g2 = this.b[n2];
            while (g2 != null) {
                if (g2.a == key || g2.a != null && g2.a.equals(key)) {
                    return true;
                }
                g2 = g2.c;
            }
        }
        return false;
    }

    @Override
    public final boolean containsValue(Object value) {
        for (int i2 = 0; i2 < this.b.length; ++i2) {
            f f2 = this.c[i2];
            synchronized (f2) {
                g<K, V> g2 = this.b[i2];
                while (g2 != null) {
                    if (g2.b == value || g2.b != null && g2.b.equals(value)) {
                        return true;
                    }
                    g2 = g2.c;
                }
                continue;
            }
        }
        return false;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final V put(K key, V value) {
        int n2 = this.a(key);
        f f2 = this.c[n2];
        synchronized (f2) {
            void var2_3;
            Object v;
            g<K, V> g2 = this.b[n2];
            if (g2 == null) {
                g2 = new g(0);
                new g(0).a = key;
                g2.b = value;
                this.b[n2] = g2;
                ++this.c[n2].a;
                return null;
            }
            g<K, V> g3 = g2;
            while (g3 != null) {
                g2 = g3;
                if (g2.a == key || g2.a != null && g2.a.equals(key)) {
                    v = g2.b;
                    g2.b = value;
                    return v;
                }
                g3 = g3.c;
            }
            g3 = new g(0);
            new g(0).a = v;
            g3.b = var2_3;
            g2.c = g3;
            ++this.c[n2].a;
        }
        return null;
    }

    @Override
    public final V remove(Object key) {
        int n2 = this.a(key);
        f f2 = this.c[n2];
        synchronized (f2) {
            g<K, V> g2 = this.b[n2];
            g<K, V> g3 = null;
            while (g2 != null) {
                if (g2.a == key || g2.a != null && g2.a.equals(key)) {
                    if (g3 == null) {
                        this.b[n2] = g2.c;
                    } else {
                        g3.c = g2.c;
                    }
                    --this.c[n2].a;
                    return g2.b;
                }
                g3 = g2;
                g2 = g2.c;
            }
        }
        return null;
    }

    @Override
    public final Set<K> keySet() {
        return new e(this, 0);
    }

    @Override
    public final Collection<V> values() {
        return new i(this, 0);
    }

    @Override
    public final Set<Map.Entry<K, V>> entrySet() {
        return new c(this, 0);
    }

    @Override
    public final void putAll(Map<? extends K, ? extends V> map2) {
        for (Map.Entry<K, V> entry : map2.entrySet()) {
            this.put(entry.getKey(), entry.getValue());
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    @Override
    public final void clear() {
        int n2 = 0;
        while (n2 < this.b.length) {
            f f2;
            f f3 = f2 = this.c[n2];
            // MONITORENTER : f2
            this.b[n2] = null;
            f2.a = 0;
            // MONITOREXIT : f3
            ++n2;
        }
    }

    @Override
    public final boolean equals(Object obj) {
        Map map2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        map2 = map2;
        return this.entrySet().equals(map2.entrySet());
    }

    @Override
    public final int hashCode() {
        int n2 = 0;
        for (int i2 = 0; i2 < this.b.length; ++i2) {
            f f2 = this.c[i2];
            synchronized (f2) {
                g<K, V> g2 = this.b[i2];
                while (g2 != null) {
                    n2 += g2.hashCode();
                    g2 = g2.c;
                }
                continue;
            }
        }
        return n2;
    }

    private void a(Runnable runnable) {
        if (runnable == null) {
            throw new NullPointerException();
        }
        this.a(runnable, 0);
    }

    private void a(Runnable runnable, int n2) {
        if (n2 >= this.b.length) {
            runnable.run();
            return;
        }
        f f2 = this.c[n2];
        synchronized (f2) {
            this.a(runnable, n2 + 1);
            return;
        }
    }

    final class i
    extends AbstractCollection<V> {
        private /* synthetic */ jC a;

        private i(jC jC2) {
            this.a = jC2;
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
        public final Iterator<V> iterator() {
            return new h(this.a, 0);
        }

        /* synthetic */ i(jC jC2, byte by) {
            this(jC2);
        }
    }

    final class e
    extends AbstractSet<K> {
        private /* synthetic */ jC a;

        private e(jC jC2) {
            this.a = jC2;
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
        public final Iterator<K> iterator() {
            return new d(this.a, 0);
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public final boolean contains(Object obj) {
            void var1_1;
            return this.a.containsKey(var1_1);
        }

        @Override
        public final boolean remove(Object obj) {
            int n2 = this.a.a(obj);
            f f2 = this.a.c[n2];
            synchronized (f2) {
                g g2 = this.a.b[n2];
                while (g2 != null) {
                    Object k2 = g2.getKey();
                    if (k2 == obj || k2 != null && k2.equals(obj)) {
                        this.a.remove(k2);
                        return true;
                    }
                    g2 = g2.c;
                }
            }
            return false;
        }

        /* synthetic */ e(jC jC2, byte by) {
            this(jC2);
        }
    }

    final class c
    extends AbstractSet<Map.Entry<K, V>> {
        private /* synthetic */ jC a;

        private c(jC jC2) {
            this.a = jC2;
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
        public final Iterator<Map.Entry<K, V>> iterator() {
            return new b(this.a, 0);
        }

        @Override
        public final boolean contains(Object obj) {
            Map.Entry entry = (Map.Entry)obj;
            int n2 = this.a.a(entry.getKey());
            f f2 = this.a.c[n2];
            synchronized (f2) {
                g g2 = this.a.b[n2];
                while (g2 != null) {
                    if (g2.equals(entry)) {
                        return true;
                    }
                    g2 = g2.c;
                }
            }
            return false;
        }

        @Override
        public final boolean remove(Object obj) {
            Map.Entry entry;
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            entry = entry;
            int n2 = this.a.a(entry.getKey());
            f f2 = this.a.c[n2];
            synchronized (f2) {
                g g2 = this.a.b[n2];
                while (g2 != null) {
                    if (g2.equals(entry)) {
                        this.a.remove(g2.getKey());
                        return true;
                    }
                    g2 = g2.c;
                }
            }
            return false;
        }

        /* synthetic */ c(jC jC2, byte by) {
            this(jC2);
        }
    }

    final class d
    extends a
    implements Iterator<K> {
        private /* synthetic */ jC a;

        private d(jC jC2) {
            this.a = jC2;
            super(jC2, (byte)0);
        }

        @Override
        public final K next() {
            return this.a().getKey();
        }

        /* synthetic */ d(jC jC2, byte by) {
            this(jC2);
        }
    }

    final class h
    extends a
    implements Iterator<V> {
        private /* synthetic */ jC a;

        private h(jC jC2) {
            this.a = jC2;
            super(jC2, (byte)0);
        }

        @Override
        public final V next() {
            return this.a().getValue();
        }

        /* synthetic */ h(jC jC2, byte by) {
            this(jC2);
        }
    }

    final class b
    extends a
    implements Iterator<Map.Entry<K, V>> {
        private /* synthetic */ jC a;

        private b(jC jC2) {
            this.a = jC2;
            super(jC2, (byte)0);
        }

        private Map.Entry<K, V> b() {
            return this.a();
        }

        @Override
        public final /* synthetic */ Object next() {
            b b2 = this;
            return b2.a();
        }

        /* synthetic */ b(jC jC2, byte by) {
            this(jC2);
        }
    }

    class a {
        private final ArrayList<Map.Entry<K, V>> a = new ArrayList();
        private int b;
        private Map.Entry<K, V> c;
        private /* synthetic */ jC d;

        private a(jC jC2) {
            this.d = jC2;
        }

        public boolean hasNext() {
            if (this.a.size() > 0) {
                return true;
            }
            while (this.b < this.d.b.length) {
                f f2 = this.d.c[this.b];
                synchronized (f2) {
                    g g2 = this.d.b[this.b];
                    while (g2 != null) {
                        this.a.add(g2);
                        g2 = g2.c;
                    }
                    ++this.b;
                    if (this.a.size() > 0) {
                        return true;
                    }
                }
            }
            return false;
        }

        protected final Map.Entry<K, V> a() {
            if (!this.hasNext()) {
                throw new NoSuchElementException();
            }
            this.c = this.a.remove(this.a.size() - 1);
            return this.c;
        }

        public void remove() {
            if (this.c == null) {
                throw new IllegalStateException();
            }
            this.d.remove(this.c.getKey());
            this.c = null;
        }

        /* synthetic */ a(jC jC2, byte by) {
            this(jC2);
        }
    }

    static final class f {
        public int a;

        private f() {
        }

        /* synthetic */ f(byte by) {
            this();
        }
    }

    static final class g<K, V>
    implements Map.Entry<K, V>,
    fr_2<K, V> {
        protected K a;
        protected V b;
        protected g<K, V> c;

        private g() {
        }

        @Override
        public final K getKey() {
            return this.a;
        }

        @Override
        public final V getValue() {
            return this.b;
        }

        @Override
        public final int hashCode() {
            return (this.a == null ? 0 : this.a.hashCode()) ^ (this.b == null ? 0 : this.b.hashCode());
        }

        @Override
        public final boolean equals(Object obj) {
            Map.Entry entry;
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            entry = entry;
            return (this.a == null ? entry.getKey() == null : this.a.equals(entry.getKey())) && (this.b == null ? entry.getValue() == null : this.b.equals(entry.getValue()));
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public final V setValue(V obj) {
            void var1_1;
            V v = this.b;
            this.b = var1_1;
            return v;
        }

        /* synthetic */ g(byte by) {
            this();
        }
    }
}

