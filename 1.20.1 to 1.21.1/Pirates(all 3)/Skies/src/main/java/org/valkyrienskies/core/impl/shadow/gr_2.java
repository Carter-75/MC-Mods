/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.valkyrienskies.core.impl.shadow.gr
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import org.valkyrienskies.core.impl.shadow.ey_1;
import org.valkyrienskies.core.impl.shadow.fb_1;
import org.valkyrienskies.core.impl.shadow.fc_1;
import org.valkyrienskies.core.impl.shadow.fe_1;
import org.valkyrienskies.core.impl.shadow.fr_2;
import org.valkyrienskies.core.impl.shadow.fu_2;
import org.valkyrienskies.core.impl.shadow.gr;
import org.valkyrienskies.core.impl.shadow.ia_2;
import org.valkyrienskies.core.impl.shadow.il_1;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.gr
 */
public final class gr_2<K extends Comparable<K>, V extends Comparable<V>>
implements Serializable,
fb_1<K, V> {
    private static final long a = 721969328361807L;
    private transient h<K, V>[] b = new h[2];
    private transient int c = 0;
    private transient int d = 0;
    private transient Set<K> e;
    private transient Set<V> f;
    private transient Set<Map.Entry<K, V>> g;
    private transient c h = null;

    public gr_2() {
    }

    private gr_2(Map<? extends K, ? extends V> map2) {
        this();
        this.putAll(map2);
    }

    @Override
    public final int size() {
        return this.c;
    }

    @Override
    public final boolean isEmpty() {
        return this.c == 0;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final boolean containsKey(Object key) {
        void var1_1;
        Object object = key;
        gr_2.c(object, org.valkyrienskies.core.impl.shadow.gr$a.KEY);
        return this.l(var1_1) != null;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final boolean containsValue(Object value) {
        void var1_1;
        Object object = value;
        gr_2.c(object, org.valkyrienskies.core.impl.shadow.gr$a.VALUE);
        return this.m(var1_1) != null;
    }

    public final V e(Object h2) {
        h<K, V> h3 = h2;
        gr_2.c((Object)h3, org.valkyrienskies.core.impl.shadow.gr$a.KEY);
        h2 = this.l(h2);
        if (h2 == null) {
            return null;
        }
        h3 = h2;
        return h3.b;
    }

    private V a(K k2, V v) {
        V v2 = this.e(k2);
        this.b(k2, v);
        return v2;
    }

    @Override
    public final void putAll(Map<? extends K, ? extends V> map2) {
        for (Map.Entry<K, V> entry : map2.entrySet()) {
            this.a((Comparable)entry.getKey(), (Comparable)entry.getValue());
        }
    }

    public final V f(Object object) {
        return this.i(object);
    }

    @Override
    public final void clear() {
        this.h();
        this.c = 0;
        this.b[org.valkyrienskies.core.impl.shadow.gr$a.KEY.ordinal()] = null;
        this.b[org.valkyrienskies.core.impl.shadow.gr$a.VALUE.ordinal()] = null;
    }

    public final K g(Object h2) {
        h<K, V> h3 = h2;
        gr_2.c((Object)h3, org.valkyrienskies.core.impl.shadow.gr$a.VALUE);
        h2 = this.m(h2);
        if (h2 == null) {
            return null;
        }
        h3 = h2;
        return h3.a;
    }

    public final K h(Object object) {
        return this.j(object);
    }

    private K f() {
        if (this.c == 0) {
            throw new NoSuchElementException("Map is empty");
        }
        h<K, V> h2 = gr_2.c(this.b[org.valkyrienskies.core.impl.shadow.gr$a.KEY.ordinal()], org.valkyrienskies.core.impl.shadow.gr$a.KEY);
        return h2.a;
    }

    private K g() {
        if (this.c == 0) {
            throw new NoSuchElementException("Map is empty");
        }
        h<K, V> h2 = gr_2.d(this.b[org.valkyrienskies.core.impl.shadow.gr$a.KEY.ordinal()], org.valkyrienskies.core.impl.shadow.gr$a.KEY);
        return h2.a;
    }

    @Override
    private K a(K object) {
        K k2 = object;
        gr_2.c(k2, org.valkyrienskies.core.impl.shadow.gr$a.KEY);
        gr_2 gr_22 = this;
        object = gr_22.a(gr_22.l(object), org.valkyrienskies.core.impl.shadow.gr$a.KEY);
        if (object == null) {
            return null;
        }
        k2 = object;
        return ((h)k2).a;
    }

    @Override
    private K b(K object) {
        K k2 = object;
        gr_2.c(k2, org.valkyrienskies.core.impl.shadow.gr$a.KEY);
        gr_2 gr_22 = this;
        object = gr_22.b(gr_22.l(object), org.valkyrienskies.core.impl.shadow.gr$a.KEY);
        if (object == null) {
            return null;
        }
        k2 = object;
        return ((h)k2).a;
    }

    @Override
    public final Set<K> keySet() {
        if (this.e == null) {
            this.e = new g(this, org.valkyrienskies.core.impl.shadow.gr$a.KEY);
        }
        return this.e;
    }

    @Override
    public final Set<V> b() {
        if (this.f == null) {
            this.f = new i(this, org.valkyrienskies.core.impl.shadow.gr$a.KEY);
        }
        return this.f;
    }

    @Override
    public final Set<Map.Entry<K, V>> entrySet() {
        if (this.g == null) {
            this.g = new b(this);
        }
        return this.g;
    }

    @Override
    public final fe_1<K, V> e() {
        if (this.isEmpty()) {
            return ia_2.d();
        }
        return new m(this, org.valkyrienskies.core.impl.shadow.gr$a.KEY);
    }

    @Override
    public final fb_1<V, K> d() {
        if (this.h == null) {
            this.h = new c(this);
        }
        return this.h;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final boolean equals(Object obj) {
        void var1_1;
        return this.d(var1_1, org.valkyrienskies.core.impl.shadow.gr$a.KEY);
    }

    @Override
    public final int hashCode() {
        return this.a(org.valkyrienskies.core.impl.shadow.gr$a.KEY);
    }

    public final String toString() {
        return this.b(org.valkyrienskies.core.impl.shadow.gr$a.KEY);
    }

    private void b(K object, V v) {
        gr_2.a(object, v);
        this.i(object);
        this.j(v);
        h h2 = this.b[org.valkyrienskies.core.impl.shadow.gr$a.KEY.ordinal()];
        if (h2 == null) {
            h<K, V> h3 = new h<K, V>(object, v);
            this.b[org.valkyrienskies.core.impl.shadow.gr$a.KEY.ordinal()] = h3;
            this.b[org.valkyrienskies.core.impl.shadow.gr$a.VALUE.ordinal()] = h3;
            this.i();
            return;
        }
        while (true) {
            h h4 = h2;
            h4 = object;
            Object k2 = h4.a;
            int n2 = h4.compareTo(k2);
            if (n2 == 0) {
                throw new IllegalArgumentException("Cannot store a duplicate key (\"" + object + "\") in this Map");
            }
            if (n2 < 0) {
                if (org.valkyrienskies.core.impl.shadow.gr$h.a(h2, org.valkyrienskies.core.impl.shadow.gr$a.KEY) != null) {
                    h2 = org.valkyrienskies.core.impl.shadow.gr$h.a(h2, org.valkyrienskies.core.impl.shadow.gr$a.KEY);
                    continue;
                }
                object = new h<K, V>(object, v);
                this.b((h<K, V>)object);
                h2.c[org.valkyrienskies.core.impl.shadow.gr$a.KEY.ordinal()] = (h)object;
                ((h)object).e[org.valkyrienskies.core.impl.shadow.gr$a.KEY.ordinal()] = h2;
                this.o((h<K, V>)object, org.valkyrienskies.core.impl.shadow.gr$a.KEY);
                this.i();
                return;
            }
            if (org.valkyrienskies.core.impl.shadow.gr$h.b(h2, org.valkyrienskies.core.impl.shadow.gr$a.KEY) == null) break;
            h2 = org.valkyrienskies.core.impl.shadow.gr$h.b(h2, org.valkyrienskies.core.impl.shadow.gr$a.KEY);
        }
        object = new h<K, V>(object, v);
        this.b((h<K, V>)object);
        h2.d[org.valkyrienskies.core.impl.shadow.gr$a.KEY.ordinal()] = (h)object;
        ((h)object).e[org.valkyrienskies.core.impl.shadow.gr$a.KEY.ordinal()] = h2;
        this.o((h<K, V>)object, org.valkyrienskies.core.impl.shadow.gr$a.KEY);
        this.i();
    }

    V i(Object h2) {
        if ((h2 = this.l(h2)) == null) {
            return null;
        }
        this.a(h2);
        return h2.b;
    }

    K j(Object h2) {
        if ((h2 = this.m(h2)) == null) {
            return null;
        }
        this.a(h2);
        return h2.a;
    }

    private <T extends Comparable<T>> h<K, V> b(Object object, a a2) {
        h h2 = null;
        h h3 = this.b[a2.ordinal()];
        while (h3 != null) {
            Comparable comparable = (Comparable)object;
            Comparable comparable2 = (Comparable)org.valkyrienskies.core.impl.shadow.gr$h.c(h3, a2);
            int n2 = comparable.compareTo(comparable2);
            if (n2 == 0) {
                h2 = h3;
                break;
            }
            h3 = n2 < 0 ? org.valkyrienskies.core.impl.shadow.gr$h.a(h3, a2) : org.valkyrienskies.core.impl.shadow.gr$h.b(h3, a2);
        }
        return h2;
    }

    private h<K, V> l(Object object) {
        return this.b(object, org.valkyrienskies.core.impl.shadow.gr$a.KEY);
    }

    private h<K, V> m(Object object) {
        return this.b(object, org.valkyrienskies.core.impl.shadow.gr$a.VALUE);
    }

    private h<K, V> a(h<K, V> h2, a a2) {
        if (h2 == null) {
            h2 = null;
        } else if (org.valkyrienskies.core.impl.shadow.gr$h.b(h2, a2) != null) {
            h2 = gr_2.c(org.valkyrienskies.core.impl.shadow.gr$h.b(h2, a2), a2);
        } else {
            h h3 = org.valkyrienskies.core.impl.shadow.gr$h.d(h2, a2);
            while (h3 != null && h2 == org.valkyrienskies.core.impl.shadow.gr$h.b(h3, a2)) {
                h2 = h3;
                h3 = org.valkyrienskies.core.impl.shadow.gr$h.d(h3, a2);
            }
            h2 = h3;
        }
        return h2;
    }

    private h<K, V> b(h<K, V> h2, a a2) {
        if (h2 == null) {
            h2 = null;
        } else if (org.valkyrienskies.core.impl.shadow.gr$h.a(h2, a2) != null) {
            h2 = gr_2.d(org.valkyrienskies.core.impl.shadow.gr$h.a(h2, a2), a2);
        } else {
            h h3 = org.valkyrienskies.core.impl.shadow.gr$h.d(h2, a2);
            while (h3 != null && h2 == org.valkyrienskies.core.impl.shadow.gr$h.a(h3, a2)) {
                h2 = h3;
                h3 = org.valkyrienskies.core.impl.shadow.gr$h.d(h3, a2);
            }
            h2 = h3;
        }
        return h2;
    }

    private static <T extends Comparable<T>> int c(T t, T t2) {
        return t.compareTo(t2);
    }

    private static h<K, V> c(h<K, V> h2, a a2) {
        if (h2 != null) {
            while (org.valkyrienskies.core.impl.shadow.gr$h.a(h2, a2) != null) {
                h2 = org.valkyrienskies.core.impl.shadow.gr$h.a(h2, a2);
            }
        }
        return h2;
    }

    private static h<K, V> d(h<K, V> h2, a a2) {
        if (h2 != null) {
            while (org.valkyrienskies.core.impl.shadow.gr$h.b(h2, a2) != null) {
                h2 = org.valkyrienskies.core.impl.shadow.gr$h.b(h2, a2);
            }
        }
        return h2;
    }

    private static void a(h<K, V> h2, h<K, V> h3, a a2) {
        if (h3 != null) {
            if (h2 == null) {
                h3.f[a2.ordinal()] = true;
                return;
            }
            h3.f[a2.ordinal()] = h2.f[a2.ordinal()];
        }
    }

    private static boolean e(h<?, ?> h2, a a2) {
        return h2 != null && org.valkyrienskies.core.impl.shadow.gr$h.f(h2, a2);
    }

    private static boolean f(h<?, ?> h2, a a2) {
        return h2 == null || org.valkyrienskies.core.impl.shadow.gr$h.g(h2, a2);
    }

    private static void g(h<?, ?> h2, a a2) {
        if (h2 != null) {
            ((h)h2).f[a2.ordinal()] = false;
        }
    }

    private static void h(h<?, ?> h2, a a2) {
        if (h2 != null) {
            ((h)h2).f[a2.ordinal()] = true;
        }
    }

    private h<K, V> i(h<K, V> h2, a a2) {
        return gr_2.j(gr_2.j(h2, a2), a2);
    }

    private static h<K, V> j(h<K, V> h2, a a2) {
        if (h2 == null) {
            return null;
        }
        return org.valkyrienskies.core.impl.shadow.gr$h.d(h2, a2);
    }

    private static h<K, V> k(h<K, V> h2, a a2) {
        if (h2 == null) {
            return null;
        }
        return org.valkyrienskies.core.impl.shadow.gr$h.b(h2, a2);
    }

    private static h<K, V> l(h<K, V> h2, a a2) {
        if (h2 == null) {
            return null;
        }
        return org.valkyrienskies.core.impl.shadow.gr$h.a(h2, a2);
    }

    private void m(h<K, V> h2, a a2) {
        h h3 = org.valkyrienskies.core.impl.shadow.gr$h.b(h2, a2);
        ((h)h2).d[a2.ordinal()] = org.valkyrienskies.core.impl.shadow.gr$h.a(h3, a2);
        if (org.valkyrienskies.core.impl.shadow.gr$h.a(h3, a2) != null) {
            org.valkyrienskies.core.impl.shadow.gr$h.a(h3, a2).e[a2.ordinal()] = (h)h2;
        }
        h3.e[a2.ordinal()] = org.valkyrienskies.core.impl.shadow.gr$h.d(h2, a2);
        if (org.valkyrienskies.core.impl.shadow.gr$h.d(h2, a2) == null) {
            this.b[a2.ordinal()] = h3;
        } else if (org.valkyrienskies.core.impl.shadow.gr$h.a(org.valkyrienskies.core.impl.shadow.gr$h.d(h2, a2), a2) == h2) {
            org.valkyrienskies.core.impl.shadow.gr$h.d(h2, a2).c[a2.ordinal()] = h3;
        } else {
            org.valkyrienskies.core.impl.shadow.gr$h.d(h2, a2).d[a2.ordinal()] = h3;
        }
        h3.c[a2.ordinal()] = (h)h2;
        ((h)h2).e[a2.ordinal()] = h3;
    }

    private void n(h<K, V> h2, a a2) {
        h h3 = org.valkyrienskies.core.impl.shadow.gr$h.a(h2, a2);
        ((h)h2).c[a2.ordinal()] = org.valkyrienskies.core.impl.shadow.gr$h.b(h3, a2);
        if (org.valkyrienskies.core.impl.shadow.gr$h.b(h3, a2) != null) {
            org.valkyrienskies.core.impl.shadow.gr$h.b(h3, a2).e[a2.ordinal()] = (h)h2;
        }
        h3.e[a2.ordinal()] = org.valkyrienskies.core.impl.shadow.gr$h.d(h2, a2);
        if (org.valkyrienskies.core.impl.shadow.gr$h.d(h2, a2) == null) {
            this.b[a2.ordinal()] = h3;
        } else if (org.valkyrienskies.core.impl.shadow.gr$h.b(org.valkyrienskies.core.impl.shadow.gr$h.d(h2, a2), a2) == h2) {
            org.valkyrienskies.core.impl.shadow.gr$h.d(h2, a2).d[a2.ordinal()] = h3;
        } else {
            org.valkyrienskies.core.impl.shadow.gr$h.d(h2, a2).c[a2.ordinal()] = h3;
        }
        h3.d[a2.ordinal()] = (h)h2;
        ((h)h2).e[a2.ordinal()] = h3;
    }

    private void o(h<K, V> h2, a a2) {
        gr_2.g(h2, a2);
        while (h2 != null && h2 != this.b[a2.ordinal()] && gr_2.e(org.valkyrienskies.core.impl.shadow.gr$h.d(h2, a2), a2)) {
            h<K, V> h3;
            if (org.valkyrienskies.core.impl.shadow.gr$h.i(h2, a2)) {
                h3 = gr_2.k(this.i(h2, a2), a2);
                if (gr_2.e(h3, a2)) {
                    gr_2.h(gr_2.j(h2, a2), a2);
                    gr_2.h(h3, a2);
                    gr_2.g(this.i(h2, a2), a2);
                    h2 = this.i(h2, a2);
                    continue;
                }
                if (org.valkyrienskies.core.impl.shadow.gr$h.j(h2, a2)) {
                    h2 = gr_2.j(h2, a2);
                    this.m(h2, a2);
                }
                gr_2.h(gr_2.j(h2, a2), a2);
                gr_2.g(this.i(h2, a2), a2);
                if (this.i(h2, a2) == null) continue;
                gr_2 gr_22 = this;
                gr_22.n(gr_22.i(h2, a2), a2);
                continue;
            }
            h3 = gr_2.l(this.i(h2, a2), a2);
            if (gr_2.e(h3, a2)) {
                gr_2.h(gr_2.j(h2, a2), a2);
                gr_2.h(h3, a2);
                gr_2.g(this.i(h2, a2), a2);
                h2 = this.i(h2, a2);
                continue;
            }
            if (org.valkyrienskies.core.impl.shadow.gr$h.i(h2, a2)) {
                h2 = gr_2.j(h2, a2);
                this.n(h2, a2);
            }
            gr_2.h(gr_2.j(h2, a2), a2);
            gr_2.g(this.i(h2, a2), a2);
            if (this.i(h2, a2) == null) continue;
            gr_2 gr_23 = this;
            gr_23.m(gr_23.i(h2, a2), a2);
        }
        gr_2.h(this.b[a2.ordinal()], a2);
    }

    private void a(h<K, V> h2) {
        for (a a2 : org.valkyrienskies.core.impl.shadow.gr$a.values()) {
            h h3;
            if (org.valkyrienskies.core.impl.shadow.gr$h.a(h2, a2) != null && org.valkyrienskies.core.impl.shadow.gr$h.b(h2, a2) != null) {
                gr_2 gr_22 = this;
                gr_22.b(gr_22.a(h2, a2), h2, a2);
            }
            if ((h3 = org.valkyrienskies.core.impl.shadow.gr$h.a(h2, a2) != null ? org.valkyrienskies.core.impl.shadow.gr$h.a(h2, a2) : org.valkyrienskies.core.impl.shadow.gr$h.b(h2, a2)) != null) {
                h3.e[a2.ordinal()] = org.valkyrienskies.core.impl.shadow.gr$h.d(h2, a2);
                if (org.valkyrienskies.core.impl.shadow.gr$h.d(h2, a2) == null) {
                    this.b[a2.ordinal()] = h3;
                } else {
                    h<K, V> h4 = h2;
                    if (h4 == org.valkyrienskies.core.impl.shadow.gr$h.a(org.valkyrienskies.core.impl.shadow.gr$h.d(h4, a2), a2)) {
                        org.valkyrienskies.core.impl.shadow.gr$h.d(h2, a2).c[a2.ordinal()] = h3;
                    } else {
                        org.valkyrienskies.core.impl.shadow.gr$h.d(h2, a2).d[a2.ordinal()] = h3;
                    }
                }
                ((h)h2).c[a2.ordinal()] = null;
                ((h)h2).d[a2.ordinal()] = null;
                ((h)h2).e[a2.ordinal()] = null;
                if (!gr_2.f(h2, a2)) continue;
                this.p(h3, a2);
                continue;
            }
            if (org.valkyrienskies.core.impl.shadow.gr$h.d(h2, a2) == null) {
                this.b[a2.ordinal()] = null;
                continue;
            }
            if (gr_2.f(h2, a2)) {
                this.p(h2, a2);
            }
            if (org.valkyrienskies.core.impl.shadow.gr$h.d(h2, a2) == null) continue;
            h<K, V> h5 = h2;
            if (h5 == org.valkyrienskies.core.impl.shadow.gr$h.a(org.valkyrienskies.core.impl.shadow.gr$h.d(h5, a2), a2)) {
                org.valkyrienskies.core.impl.shadow.gr$h.d(h2, a2).c[a2.ordinal()] = null;
            } else {
                org.valkyrienskies.core.impl.shadow.gr$h.d(h2, a2).d[a2.ordinal()] = null;
            }
            ((h)h2).e[a2.ordinal()] = null;
        }
        this.j();
    }

    private void p(h<K, V> h2, a a2) {
        while (h2 != this.b[a2.ordinal()] && gr_2.f(h2, a2)) {
            h<K, V> h3;
            if (org.valkyrienskies.core.impl.shadow.gr$h.i(h2, a2)) {
                h3 = gr_2.k(gr_2.j(h2, a2), a2);
                if (gr_2.e(h3, a2)) {
                    gr_2.h(h3, a2);
                    gr_2.g(gr_2.j(h2, a2), a2);
                    this.m(gr_2.j(h2, a2), a2);
                    h3 = gr_2.k(gr_2.j(h2, a2), a2);
                }
                if (gr_2.f(gr_2.l(h3, a2), a2) && gr_2.f(gr_2.k(h3, a2), a2)) {
                    gr_2.g(h3, a2);
                    h2 = gr_2.j(h2, a2);
                    continue;
                }
                if (gr_2.f(gr_2.k(h3, a2), a2)) {
                    gr_2.h(gr_2.l(h3, a2), a2);
                    gr_2.g(h3, a2);
                    this.n(h3, a2);
                    h3 = gr_2.k(gr_2.j(h2, a2), a2);
                }
                gr_2.a(gr_2.j(h2, a2), h3, a2);
                gr_2.h(gr_2.j(h2, a2), a2);
                gr_2.h(gr_2.k(h3, a2), a2);
                this.m(gr_2.j(h2, a2), a2);
                h2 = this.b[a2.ordinal()];
                continue;
            }
            h3 = gr_2.l(gr_2.j(h2, a2), a2);
            if (gr_2.e(h3, a2)) {
                gr_2.h(h3, a2);
                gr_2.g(gr_2.j(h2, a2), a2);
                this.n(gr_2.j(h2, a2), a2);
                h3 = gr_2.l(gr_2.j(h2, a2), a2);
            }
            if (gr_2.f(gr_2.k(h3, a2), a2) && gr_2.f(gr_2.l(h3, a2), a2)) {
                gr_2.g(h3, a2);
                h2 = gr_2.j(h2, a2);
                continue;
            }
            if (gr_2.f(gr_2.l(h3, a2), a2)) {
                gr_2.h(gr_2.k(h3, a2), a2);
                gr_2.g(h3, a2);
                this.m(h3, a2);
                h3 = gr_2.l(gr_2.j(h2, a2), a2);
            }
            gr_2.a(gr_2.j(h2, a2), h3, a2);
            gr_2.h(gr_2.j(h2, a2), a2);
            gr_2.h(gr_2.l(h3, a2), a2);
            this.n(gr_2.j(h2, a2), a2);
            h2 = this.b[a2.ordinal()];
        }
        gr_2.h(h2, a2);
    }

    /*
     * Unable to fully structure code
     */
    private void b(h<K, V> var1_1, h<K, V> var2_2, a var3_3) {
        var4_4 = org.valkyrienskies.core.impl.shadow.gr$h.d(var1_1, var3_3);
        var5_5 = org.valkyrienskies.core.impl.shadow.gr$h.a(var1_1, var3_3);
        var6_6 = org.valkyrienskies.core.impl.shadow.gr$h.b(var1_1, var3_3);
        var7_7 = org.valkyrienskies.core.impl.shadow.gr$h.d(var2_2, var3_3);
        var8_8 = org.valkyrienskies.core.impl.shadow.gr$h.a(var2_2, var3_3);
        var9_9 = org.valkyrienskies.core.impl.shadow.gr$h.b(var2_2, var3_3);
        if (org.valkyrienskies.core.impl.shadow.gr$h.d(var1_1, var3_3) == null) ** GOTO lbl-1000
        v0 = var1_1;
        if (v0 == org.valkyrienskies.core.impl.shadow.gr$h.a(org.valkyrienskies.core.impl.shadow.gr$h.d(v0, var3_3), var3_3)) {
            v1 = true;
        } else lbl-1000:
        // 2 sources

        {
            v1 = var10_10 = false;
        }
        if (org.valkyrienskies.core.impl.shadow.gr$h.d(var2_2, var3_3) == null) ** GOTO lbl-1000
        v2 = var2_2;
        if (v2 == org.valkyrienskies.core.impl.shadow.gr$h.a(org.valkyrienskies.core.impl.shadow.gr$h.d(v2, var3_3), var3_3)) {
            v3 = true;
        } else lbl-1000:
        // 2 sources

        {
            v3 = var11_11 = false;
        }
        if (var1_1 == var7_7) {
            org.valkyrienskies.core.impl.shadow.gr$h.b(var1_1, var2_2, var3_3);
            if (var11_11) {
                org.valkyrienskies.core.impl.shadow.gr$h.a(var2_2, var1_1, var3_3);
                org.valkyrienskies.core.impl.shadow.gr$h.c(var2_2, var6_6, var3_3);
            } else {
                org.valkyrienskies.core.impl.shadow.gr$h.c(var2_2, var1_1, var3_3);
                org.valkyrienskies.core.impl.shadow.gr$h.a(var2_2, var5_5, var3_3);
            }
        } else {
            org.valkyrienskies.core.impl.shadow.gr$h.b(var1_1, var7_7, var3_3);
            if (var7_7 != null) {
                if (var11_11) {
                    org.valkyrienskies.core.impl.shadow.gr$h.a(var7_7, var1_1, var3_3);
                } else {
                    org.valkyrienskies.core.impl.shadow.gr$h.c(var7_7, var1_1, var3_3);
                }
            }
            org.valkyrienskies.core.impl.shadow.gr$h.a(var2_2, var5_5, var3_3);
            org.valkyrienskies.core.impl.shadow.gr$h.c(var2_2, var6_6, var3_3);
        }
        if (var2_2 == var4_4) {
            org.valkyrienskies.core.impl.shadow.gr$h.b(var2_2, var1_1, var3_3);
            if (var10_10) {
                org.valkyrienskies.core.impl.shadow.gr$h.a(var1_1, var2_2, var3_3);
                org.valkyrienskies.core.impl.shadow.gr$h.c(var1_1, var9_9, var3_3);
            } else {
                org.valkyrienskies.core.impl.shadow.gr$h.c(var1_1, var2_2, var3_3);
                org.valkyrienskies.core.impl.shadow.gr$h.a(var1_1, var8_8, var3_3);
            }
        } else {
            org.valkyrienskies.core.impl.shadow.gr$h.b(var2_2, var4_4, var3_3);
            if (var4_4 != null) {
                if (var10_10) {
                    org.valkyrienskies.core.impl.shadow.gr$h.a(var4_4, var2_2, var3_3);
                } else {
                    org.valkyrienskies.core.impl.shadow.gr$h.c(var4_4, var2_2, var3_3);
                }
            }
            org.valkyrienskies.core.impl.shadow.gr$h.a(var1_1, var8_8, var3_3);
            org.valkyrienskies.core.impl.shadow.gr$h.c(var1_1, var9_9, var3_3);
        }
        if (org.valkyrienskies.core.impl.shadow.gr$h.a(var1_1, var3_3) != null) {
            org.valkyrienskies.core.impl.shadow.gr$h.b(org.valkyrienskies.core.impl.shadow.gr$h.a(var1_1, var3_3), var1_1, var3_3);
        }
        if (org.valkyrienskies.core.impl.shadow.gr$h.b(var1_1, var3_3) != null) {
            org.valkyrienskies.core.impl.shadow.gr$h.b(org.valkyrienskies.core.impl.shadow.gr$h.b(var1_1, var3_3), var1_1, var3_3);
        }
        if (org.valkyrienskies.core.impl.shadow.gr$h.a(var2_2, var3_3) != null) {
            org.valkyrienskies.core.impl.shadow.gr$h.b(org.valkyrienskies.core.impl.shadow.gr$h.a(var2_2, var3_3), var2_2, var3_3);
        }
        if (org.valkyrienskies.core.impl.shadow.gr$h.b(var2_2, var3_3) != null) {
            org.valkyrienskies.core.impl.shadow.gr$h.b(org.valkyrienskies.core.impl.shadow.gr$h.b(var2_2, var3_3), var2_2, var3_3);
        }
        org.valkyrienskies.core.impl.shadow.gr$h.e(var1_1, var2_2, var3_3);
        if (this.b[var3_3.ordinal()] == var1_1) {
            this.b[var3_3.ordinal()] = var2_2;
            return;
        }
        if (this.b[var3_3.ordinal()] == var2_2) {
            this.b[var3_3.ordinal()] = var1_1;
        }
    }

    private static void c(Object object, a a2) {
        if (object == null) {
            throw new NullPointerException((Object)((Object)a2) + " cannot be null");
        }
        if (!(object instanceof Comparable)) {
            throw new ClassCastException((Object)((Object)a2) + " must be Comparable");
        }
    }

    private static void n(Object object) {
        gr_2.c(object, org.valkyrienskies.core.impl.shadow.gr$a.KEY);
    }

    private static void o(Object object) {
        gr_2.c(object, org.valkyrienskies.core.impl.shadow.gr$a.VALUE);
    }

    private static void a(Object object, Object object2) {
        gr_2.c(object, org.valkyrienskies.core.impl.shadow.gr$a.KEY);
        object = object2;
        gr_2.c(object, org.valkyrienskies.core.impl.shadow.gr$a.VALUE);
    }

    private void h() {
        ++this.d;
    }

    private void i() {
        this.h();
        ++this.c;
    }

    private void j() {
        this.h();
        --this.c;
    }

    private void b(h<K, V> h2) {
        h h3 = this.b[org.valkyrienskies.core.impl.shadow.gr$a.VALUE.ordinal()];
        while (true) {
            h<K, V> h4 = h2;
            h4 = h3;
            h4 = h4.b;
            Object v = h4.b;
            int n2 = h4.compareTo(v);
            if (n2 == 0) {
                throw new IllegalArgumentException("Cannot store a duplicate value (\"" + org.valkyrienskies.core.impl.shadow.gr$h.c(h2, org.valkyrienskies.core.impl.shadow.gr$a.VALUE) + "\") in this Map");
            }
            if (n2 < 0) {
                if (org.valkyrienskies.core.impl.shadow.gr$h.a(h3, org.valkyrienskies.core.impl.shadow.gr$a.VALUE) != null) {
                    h3 = org.valkyrienskies.core.impl.shadow.gr$h.a(h3, org.valkyrienskies.core.impl.shadow.gr$a.VALUE);
                    continue;
                }
                h3.c[org.valkyrienskies.core.impl.shadow.gr$a.VALUE.ordinal()] = (h)h2;
                ((h)h2).e[org.valkyrienskies.core.impl.shadow.gr$a.VALUE.ordinal()] = h3;
                this.o(h2, org.valkyrienskies.core.impl.shadow.gr$a.VALUE);
                return;
            }
            if (org.valkyrienskies.core.impl.shadow.gr$h.b(h3, org.valkyrienskies.core.impl.shadow.gr$a.VALUE) == null) break;
            h3 = org.valkyrienskies.core.impl.shadow.gr$h.b(h3, org.valkyrienskies.core.impl.shadow.gr$a.VALUE);
        }
        h3.d[org.valkyrienskies.core.impl.shadow.gr$a.VALUE.ordinal()] = (h)h2;
        ((h)h2).e[org.valkyrienskies.core.impl.shadow.gr$a.VALUE.ordinal()] = h3;
        this.o(h2, org.valkyrienskies.core.impl.shadow.gr$a.VALUE);
    }

    private boolean d(Object object, a object2) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof Map)) {
            return false;
        }
        if ((object = (Map)object).size() != this.size()) {
            return false;
        }
        if (this.c > 0) {
            try {
                object2 = this.c((a)((Object)object2));
                while (object2.hasNext()) {
                    Object k2 = object2.next();
                    Object v = object2.b();
                    if (v.equals(object.get(k2))) continue;
                    return false;
                }
            }
            catch (ClassCastException classCastException) {
                return false;
            }
            catch (NullPointerException nullPointerException) {
                return false;
            }
        }
        return true;
    }

    private int a(a object) {
        int n2 = 0;
        if (this.c > 0) {
            object = this.c((a)((Object)object));
            while (object.hasNext()) {
                Object k2 = object.next();
                Object v = object.b();
                n2 += k2.hashCode() ^ v.hashCode();
            }
        }
        return n2;
    }

    private String b(a object) {
        if (this.c == 0) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(this.c << 5);
        stringBuilder.append('{');
        object = this.c((a)((Object)object));
        boolean bl = object.hasNext();
        while (bl) {
            Object k2 = object.next();
            Object v = object.b();
            stringBuilder.append((Object)(k2 == this ? "(this Map)" : k2)).append('=').append((Object)(v == this ? "(this Map)" : v));
            bl = object.hasNext();
            if (!bl) continue;
            stringBuilder.append(", ");
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    @Override
    private fu_2<?, ?> c(a a2) {
        switch (a2) {
            case KEY: {
                return new m(this, org.valkyrienskies.core.impl.shadow.gr$a.KEY);
            }
            case VALUE: {
                return new f(this, org.valkyrienskies.core.impl.shadow.gr$a.VALUE);
            }
        }
        throw new IllegalArgumentException();
    }

    private void a(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.b = new h[2];
        int n2 = objectInputStream.readInt();
        for (int i2 = 0; i2 < n2; ++i2) {
            Comparable comparable = (Comparable)objectInputStream.readObject();
            Comparable comparable2 = (Comparable)objectInputStream.readObject();
            this.a(comparable, comparable2);
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
    public final /* synthetic */ ey_1 a() {
        return this.d();
    }

    @Override
    public final /* synthetic */ Object b(Object object) {
        Object object2 = object;
        object = this;
        return ((gr_2)object).j(object2);
    }

    @Override
    public final /* synthetic */ Object a(Object object) {
        return this.g(object);
    }

    @Override
    public final /* synthetic */ Object put(Object object, Object object2) {
        return this.a((Comparable)object, (Comparable)object2);
    }

    @Override
    public final /* synthetic */ Collection values() {
        return this.b();
    }

    @Override
    public final /* synthetic */ Object remove(Object object) {
        Object object2 = object;
        object = this;
        return ((gr_2)object).i(object2);
    }

    @Override
    public final /* synthetic */ Object get(Object object) {
        return this.e(object);
    }

    @Override
    public final /* synthetic */ fu_2 c() {
        return this.e();
    }

    @Override
    public final /* synthetic */ Object d(Object h2) {
        Comparable comparable = (Comparable)((Object)h2);
        h2 = this;
        Object object = comparable;
        gr_2.c(object, org.valkyrienskies.core.impl.shadow.gr$a.KEY);
        h<K, V> h3 = h2;
        h2 = super.b(super.l(comparable), org.valkyrienskies.core.impl.shadow.gr$a.KEY);
        if (h2 == null) {
            return null;
        }
        object = h2;
        return ((h)object).a;
    }

    @Override
    public final /* synthetic */ Object c(Object h2) {
        Comparable comparable = (Comparable)((Object)h2);
        h2 = this;
        Object object = comparable;
        gr_2.c(object, org.valkyrienskies.core.impl.shadow.gr$a.KEY);
        h<K, V> h3 = h2;
        h2 = super.a(super.l(comparable), org.valkyrienskies.core.impl.shadow.gr$a.KEY);
        if (h2 == null) {
            return null;
        }
        object = h2;
        return ((h)object).a;
    }

    @Override
    public final /* synthetic */ Object lastKey() {
        Object object = this;
        if (((gr_2)object).c == 0) {
            throw new NoSuchElementException("Map is empty");
        }
        object = gr_2.d(((gr_2)object).b[org.valkyrienskies.core.impl.shadow.gr$a.KEY.ordinal()], org.valkyrienskies.core.impl.shadow.gr$a.KEY);
        return ((h)object).a;
    }

    @Override
    public final /* synthetic */ Object firstKey() {
        Object object = this;
        if (((gr_2)object).c == 0) {
            throw new NoSuchElementException("Map is empty");
        }
        object = gr_2.c(((gr_2)object).b[org.valkyrienskies.core.impl.shadow.gr$a.KEY.ordinal()], org.valkyrienskies.core.impl.shadow.gr$a.KEY);
        return ((h)object).a;
    }

    static /* synthetic */ void a(Object object, a a2) {
        gr_2.c(object, a2);
    }

    static /* synthetic */ h a(gr_2 gr_22, Object object) {
        return gr_22.l(object);
    }

    static /* synthetic */ Comparable b(gr_2 gr_22, Object object) {
        return gr_22.i(object);
    }

    static /* synthetic */ h c(gr_2 gr_22, Object object) {
        return gr_22.m(object);
    }

    static /* synthetic */ Comparable d(gr_2 gr_22, Object object) {
        return gr_22.j(object);
    }

    static /* synthetic */ void a(gr_2 gr_22, h h2) {
        gr_22.a(h2);
    }

    static /* synthetic */ int a(gr_2 gr_22) {
        return gr_22.d;
    }

    static /* synthetic */ h[] b(gr_2 gr_22) {
        return gr_22.b;
    }

    static /* synthetic */ h a(gr_2 gr_22, h h2, a a2) {
        return gr_2.c(h2, a2);
    }

    static /* synthetic */ h b(gr_2 gr_22, h h2, a a2) {
        return gr_22.a(h2, a2);
    }

    static /* synthetic */ h c(gr_2 gr_22, h h2, a a2) {
        return gr_22.b(h2, a2);
    }

    static /* synthetic */ h d(gr_2 gr_22, h h2, a a2) {
        return gr_2.d(h2, a2);
    }

    static /* synthetic */ int c(gr_2 gr_22) {
        return gr_22.c;
    }

    static /* synthetic */ void k(Object object) {
        gr_2.c(object, org.valkyrienskies.core.impl.shadow.gr$a.KEY);
    }

    static /* synthetic */ h a(gr_2 gr_22, Object object, a a2) {
        return gr_22.b(object, a2);
    }

    static /* synthetic */ void a(gr_2 gr_22, Comparable comparable, Comparable comparable2) {
        gr_22.b(comparable, comparable2);
    }

    static /* synthetic */ boolean b(gr_2 gr_22, Object object, a a2) {
        return gr_22.d(object, a2);
    }

    static /* synthetic */ int a(gr_2 gr_22, a a2) {
        return gr_22.a(a2);
    }

    static /* synthetic */ String b(gr_2 gr_22, a a2) {
        return gr_22.b(a2);
    }

    final class c
    implements fb_1<V, K> {
        private Set<V> a;
        private Set<K> b;
        private Set<Map.Entry<V, K>> c;
        private /* synthetic */ gr_2 d;

        c(gr_2 gr_22) {
            this.d = gr_22;
        }

        @Override
        public final int size() {
            return this.d.size();
        }

        @Override
        public final boolean isEmpty() {
            return this.d.isEmpty();
        }

        private K e(Object object) {
            return this.d.g(object);
        }

        private V f(Object object) {
            return this.d.e(object);
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public final boolean containsKey(Object key) {
            void var1_1;
            return this.d.containsValue(var1_1);
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public final boolean containsValue(Object value) {
            void var1_1;
            return this.d.containsKey(var1_1);
        }

        private V f() {
            if (gr.c((gr_2)this.d) == 0) {
                throw new NoSuchElementException("Map is empty");
            }
            h h2 = gr.a((gr_2)this.d, (h)gr.b((gr_2)this.d)[org.valkyrienskies.core.impl.shadow.gr$a.VALUE.ordinal()], (a)org.valkyrienskies.core.impl.shadow.gr$a.VALUE);
            return h2.b;
        }

        private V g() {
            if (gr.c((gr_2)this.d) == 0) {
                throw new NoSuchElementException("Map is empty");
            }
            h h2 = gr.d((gr_2)this.d, (h)gr.b((gr_2)this.d)[org.valkyrienskies.core.impl.shadow.gr$a.VALUE.ordinal()], (a)org.valkyrienskies.core.impl.shadow.gr$a.VALUE);
            return h2.b;
        }

        @Override
        private V a(V object) {
            gr.k(object);
            object = gr.b((gr_2)this.d, (h)gr.a((gr_2)this.d, object, (a)org.valkyrienskies.core.impl.shadow.gr$a.VALUE), (a)org.valkyrienskies.core.impl.shadow.gr$a.VALUE);
            if (object == null) {
                return null;
            }
            return ((h)object).b;
        }

        @Override
        private V b(V object) {
            gr.k(object);
            object = gr.c((gr_2)this.d, (h)gr.a((gr_2)this.d, object, (a)org.valkyrienskies.core.impl.shadow.gr$a.VALUE), (a)org.valkyrienskies.core.impl.shadow.gr$a.VALUE);
            if (object == null) {
                return null;
            }
            return ((h)object).b;
        }

        private K a(V v, K k2) {
            Object k3 = this.e(v);
            gr.a((gr_2)this.d, k2, v);
            return k3;
        }

        @Override
        public final void putAll(Map<? extends V, ? extends K> map2) {
            for (Map.Entry entry : map2.entrySet()) {
                this.a((Comparable)entry.getKey(), (Comparable)entry.getValue());
            }
        }

        private K g(Object object) {
            Object object2 = object;
            object = this.d;
            return object.j(object2);
        }

        private V h(Object object) {
            Object object2 = object;
            object = this.d;
            return object.i(object2);
        }

        @Override
        public final void clear() {
            this.d.clear();
        }

        @Override
        public final Set<V> keySet() {
            if (this.a == null) {
                this.a = new i(this.d, org.valkyrienskies.core.impl.shadow.gr$a.VALUE);
            }
            return this.a;
        }

        @Override
        public final Set<K> b() {
            if (this.b == null) {
                this.b = new g(this.d, org.valkyrienskies.core.impl.shadow.gr$a.VALUE);
            }
            return this.b;
        }

        @Override
        public final Set<Map.Entry<V, K>> entrySet() {
            if (this.c == null) {
                this.c = new d(this.d);
            }
            return this.c;
        }

        @Override
        public final fe_1<V, K> e() {
            if (this.isEmpty()) {
                return ia_2.d();
            }
            return new f(this.d, org.valkyrienskies.core.impl.shadow.gr$a.VALUE);
        }

        @Override
        public final fb_1<K, V> d() {
            return this.d;
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public final boolean equals(Object obj) {
            void var1_1;
            return gr.b((gr_2)this.d, (Object)var1_1, (a)org.valkyrienskies.core.impl.shadow.gr$a.VALUE);
        }

        @Override
        public final int hashCode() {
            return gr.a((gr_2)this.d, (a)org.valkyrienskies.core.impl.shadow.gr$a.VALUE);
        }

        public final String toString() {
            return gr.b((gr_2)this.d, (a)org.valkyrienskies.core.impl.shadow.gr$a.VALUE);
        }

        @Override
        public final /* synthetic */ Object b(Object object) {
            Object object2 = object;
            object = this;
            object = ((c)object).d;
            return object.i(object2);
        }

        @Override
        public final /* synthetic */ Object a(Object object) {
            Object object2 = object;
            object = this;
            return ((c)object).d.e(object2);
        }

        @Override
        public final /* synthetic */ Object put(Object object, Object object2) {
            return this.a((Comparable)object, (Comparable)object2);
        }

        @Override
        public final /* synthetic */ Collection values() {
            return this.b();
        }

        @Override
        public final /* synthetic */ Object remove(Object object) {
            Object object2 = object;
            object = this;
            object = ((c)object).d;
            return object.j(object2);
        }

        @Override
        public final /* synthetic */ Object get(Object object) {
            return this.e(object);
        }

        @Override
        public final /* synthetic */ fu_2 c() {
            return this.e();
        }

        @Override
        public final /* synthetic */ Object d(Object object) {
            Comparable comparable = (Comparable)object;
            object = this;
            gr.k((Object)comparable);
            object = gr.c((gr_2)((c)object).d, (h)gr.a((gr_2)((c)object).d, (Object)comparable, (a)org.valkyrienskies.core.impl.shadow.gr$a.VALUE), (a)org.valkyrienskies.core.impl.shadow.gr$a.VALUE);
            if (object == null) {
                return null;
            }
            return ((h)object).b;
        }

        @Override
        public final /* synthetic */ Object c(Object object) {
            Comparable comparable = (Comparable)object;
            object = this;
            gr.k((Object)comparable);
            object = gr.b((gr_2)((c)object).d, (h)gr.a((gr_2)((c)object).d, (Object)comparable, (a)org.valkyrienskies.core.impl.shadow.gr$a.VALUE), (a)org.valkyrienskies.core.impl.shadow.gr$a.VALUE);
            if (object == null) {
                return null;
            }
            return ((h)object).b;
        }

        @Override
        public final /* synthetic */ Object lastKey() {
            Object object = this;
            if (gr.c((gr_2)((c)object).d) == 0) {
                throw new NoSuchElementException("Map is empty");
            }
            object = gr.d((gr_2)((c)object).d, (h)gr.b((gr_2)((c)object).d)[org.valkyrienskies.core.impl.shadow.gr$a.VALUE.ordinal()], (a)org.valkyrienskies.core.impl.shadow.gr$a.VALUE);
            return ((h)object).b;
        }

        @Override
        public final /* synthetic */ Object firstKey() {
            Object object = this;
            if (gr.c((gr_2)((c)object).d) == 0) {
                throw new NoSuchElementException("Map is empty");
            }
            object = gr.a((gr_2)((c)object).d, (h)gr.b((gr_2)((c)object).d)[org.valkyrienskies.core.impl.shadow.gr$a.VALUE.ordinal()], (a)org.valkyrienskies.core.impl.shadow.gr$a.VALUE);
            return ((h)object).b;
        }
    }

    static final class h<K extends Comparable<K>, V extends Comparable<V>>
    implements Map.Entry<K, V>,
    fr_2<K, V> {
        final K a;
        final V b;
        private final h<K, V>[] c;
        private final h<K, V>[] d;
        private final h<K, V>[] e;
        private final boolean[] f;
        private int g;
        private boolean h;

        h(K k2, V v) {
            this.a = k2;
            this.b = v;
            this.c = new h[2];
            this.d = new h[2];
            this.e = new h[2];
            this.f = new boolean[]{true, true};
            this.h = false;
        }

        private Object a(a object) {
            switch (object) {
                case KEY: {
                    object = this;
                    return ((h)object).a;
                }
                case VALUE: {
                    object = this;
                    return ((h)object).b;
                }
            }
            throw new IllegalArgumentException();
        }

        private void k(h<K, V> h2, a a2) {
            this.c[a2.ordinal()] = h2;
        }

        private h<K, V> b(a a2) {
            return this.c[a2.ordinal()];
        }

        private void l(h<K, V> h2, a a2) {
            this.d[a2.ordinal()] = h2;
        }

        private h<K, V> c(a a2) {
            return this.d[a2.ordinal()];
        }

        private void m(h<K, V> h2, a a2) {
            this.e[a2.ordinal()] = h2;
        }

        private h<K, V> d(a a2) {
            return this.e[a2.ordinal()];
        }

        private void n(h<K, V> h2, a a2) {
            int n2 = a2.ordinal();
            this.f[n2] = this.f[n2] ^ h2.f[a2.ordinal()];
            int n3 = a2.ordinal();
            h2.f[n3] = h2.f[n3] ^ this.f[a2.ordinal()];
            int n4 = a2.ordinal();
            this.f[n4] = this.f[n4] ^ h2.f[a2.ordinal()];
        }

        private boolean e(a a2) {
            return this.f[a2.ordinal()];
        }

        private boolean f(a a2) {
            return !this.f[a2.ordinal()];
        }

        private void g(a a2) {
            this.f[a2.ordinal()] = true;
        }

        private void h(a a2) {
            this.f[a2.ordinal()] = false;
        }

        private void o(h<K, V> h2, a a2) {
            this.f[a2.ordinal()] = h2.f[a2.ordinal()];
        }

        private boolean i(a a2) {
            return this.e[a2.ordinal()] != null && this.e[a2.ordinal()].c[a2.ordinal()] == this;
        }

        private boolean j(a a2) {
            return this.e[a2.ordinal()] != null && this.e[a2.ordinal()].d[a2.ordinal()] == this;
        }

        public final K a() {
            return this.a;
        }

        public final V b() {
            return this.b;
        }

        private static V c() {
            throw new UnsupportedOperationException("Map.Entry.setValue is not supported");
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
            h h2 = this;
            if (h2.a.equals(entry.getKey())) {
                h2 = this;
                if (h2.b.equals(entry.getValue())) {
                    return true;
                }
            }
            return false;
        }

        @Override
        public final int hashCode() {
            if (!this.h) {
                h h2 = this;
                h h3 = h2;
                h3 = this;
                h2.g = h2.a.hashCode() ^ h3.b.hashCode();
                this.h = true;
            }
            return this.g;
        }

        @Override
        public final /* synthetic */ Object setValue(Object object) {
            Comparable cfr_ignored_0 = (Comparable)object;
            throw new UnsupportedOperationException("Map.Entry.setValue is not supported");
        }

        static /* synthetic */ h a(h h2, a a2) {
            return h2.c[a2.ordinal()];
        }

        static /* synthetic */ h b(h h2, a a2) {
            return h2.d[a2.ordinal()];
        }

        static /* synthetic */ Object c(h h2, a a2) {
            switch (a2) {
                case KEY: {
                    return h2.a;
                }
                case VALUE: {
                    return h2.b;
                }
            }
            throw new IllegalArgumentException();
        }

        static /* synthetic */ h d(h h2, a a2) {
            return h2.e[a2.ordinal()];
        }

        static /* synthetic */ boolean f(h h2, a a2) {
            return !h2.f[a2.ordinal()];
        }

        static /* synthetic */ boolean g(h h2, a a2) {
            return h2.f[a2.ordinal()];
        }

        static /* synthetic */ boolean i(h h2, a a2) {
            return h2.e[a2.ordinal()] != null && h2.e[a2.ordinal()].c[a2.ordinal()] == h2;
        }

        static /* synthetic */ boolean j(h h2, a a2) {
            return h2.e[a2.ordinal()] != null && h2.e[a2.ordinal()].d[a2.ordinal()] == h2;
        }

        static /* synthetic */ void e(h h2, h h3, a a2) {
            int n2 = a2.ordinal();
            h2.f[n2] = h2.f[n2] ^ h3.f[a2.ordinal()];
            int n3 = a2.ordinal();
            h3.f[n3] = h3.f[n3] ^ h2.f[a2.ordinal()];
            int n4 = a2.ordinal();
            h2.f[n4] = h2.f[n4] ^ h3.f[a2.ordinal()];
        }
    }

    final class e
    extends k
    implements fc_1<Map.Entry<V, K>> {
        private /* synthetic */ gr_2 b;

        e(gr_2 gr_22) {
            this.b = gr_22;
            super(gr_22, org.valkyrienskies.core.impl.shadow.gr$a.VALUE);
        }

        private Map.Entry<V, K> a() {
            return org.valkyrienskies.core.impl.shadow.gr$e.a(this.c());
        }

        private Map.Entry<V, K> b() {
            return org.valkyrienskies.core.impl.shadow.gr$e.a(this.d());
        }

        private static Map.Entry<V, K> a(h<K, V> h2) {
            h h3 = h2;
            h h4 = h3;
            h4 = h2;
            return new il_1(h3.b, h4.a);
        }

        @Override
        public final /* synthetic */ Object previous() {
            e e2 = this;
            return org.valkyrienskies.core.impl.shadow.gr$e.a(e2.d());
        }

        @Override
        public final /* synthetic */ Object next() {
            e e2 = this;
            return org.valkyrienskies.core.impl.shadow.gr$e.a(e2.c());
        }
    }

    final class l
    extends k
    implements fc_1<Map.Entry<K, V>> {
        private /* synthetic */ gr_2 b;

        l(gr_2 gr_22) {
            this.b = gr_22;
            super(gr_22, org.valkyrienskies.core.impl.shadow.gr$a.KEY);
        }

        private Map.Entry<K, V> a() {
            return this.c();
        }

        private Map.Entry<K, V> b() {
            return this.d();
        }

        @Override
        public final /* synthetic */ Object previous() {
            l l2 = this;
            return l2.d();
        }

        @Override
        public final /* synthetic */ Object next() {
            l l2 = this;
            return l2.c();
        }
    }

    final class f
    extends k
    implements fe_1<V, K> {
        private /* synthetic */ gr_2 b;

        public f(gr_2 gr_22, a a2) {
            this.b = gr_22;
            super(gr_22, a2);
        }

        private V e() {
            if (this.a == null) {
                throw new IllegalStateException("Iterator getKey() can only be called after next() and before remove()");
            }
            h h2 = this.a;
            return h2.b;
        }

        private K f() {
            if (this.a == null) {
                throw new IllegalStateException("Iterator getValue() can only be called after next() and before remove()");
            }
            h h2 = this.a;
            return h2.a;
        }

        private static K g() {
            throw new UnsupportedOperationException();
        }

        private V h() {
            h h2 = this.c();
            return h2.b;
        }

        private V i() {
            h h2 = this.d();
            return h2.b;
        }

        @Override
        public final /* synthetic */ Object previous() {
            Object object = this;
            object = ((k)object).d();
            return ((h)object).b;
        }

        @Override
        public final /* synthetic */ Object a(Object object) {
            Comparable cfr_ignored_0 = (Comparable)object;
            throw new UnsupportedOperationException();
        }

        @Override
        public final /* synthetic */ Object b() {
            Object object = this;
            if (((k)object).a == null) {
                throw new IllegalStateException("Iterator getValue() can only be called after next() and before remove()");
            }
            object = ((k)object).a;
            return ((h)object).a;
        }

        @Override
        public final /* synthetic */ Object a() {
            Object object = this;
            if (((k)object).a == null) {
                throw new IllegalStateException("Iterator getKey() can only be called after next() and before remove()");
            }
            object = ((k)object).a;
            return ((h)object).b;
        }

        @Override
        public final /* synthetic */ Object next() {
            Object object = this;
            object = ((k)object).c();
            return ((h)object).b;
        }
    }

    final class m
    extends k
    implements fe_1<K, V> {
        private /* synthetic */ gr_2 b;

        m(gr_2 gr_22, a a2) {
            this.b = gr_22;
            super(gr_22, a2);
        }

        private K e() {
            if (this.a == null) {
                throw new IllegalStateException("Iterator getKey() can only be called after next() and before remove()");
            }
            h h2 = this.a;
            return h2.a;
        }

        private V f() {
            if (this.a == null) {
                throw new IllegalStateException("Iterator getValue() can only be called after next() and before remove()");
            }
            h h2 = this.a;
            return h2.b;
        }

        private static V g() {
            throw new UnsupportedOperationException();
        }

        private K h() {
            h h2 = this.c();
            return h2.a;
        }

        private K i() {
            h h2 = this.d();
            return h2.a;
        }

        @Override
        public final /* synthetic */ Object previous() {
            Object object = this;
            object = ((k)object).d();
            return ((h)object).a;
        }

        @Override
        public final /* synthetic */ Object a(Object object) {
            Comparable cfr_ignored_0 = (Comparable)object;
            throw new UnsupportedOperationException();
        }

        @Override
        public final /* synthetic */ Object b() {
            Object object = this;
            if (((k)object).a == null) {
                throw new IllegalStateException("Iterator getValue() can only be called after next() and before remove()");
            }
            object = ((k)object).a;
            return ((h)object).b;
        }

        @Override
        public final /* synthetic */ Object a() {
            Object object = this;
            if (((k)object).a == null) {
                throw new IllegalStateException("Iterator getKey() can only be called after next() and before remove()");
            }
            object = ((k)object).a;
            return ((h)object).a;
        }

        @Override
        public final /* synthetic */ Object next() {
            Object object = this;
            object = ((k)object).c();
            return ((h)object).a;
        }
    }

    abstract class k {
        private final a b;
        h<K, V> a;
        private h<K, V> c;
        private h<K, V> d;
        private int e;
        private /* synthetic */ gr_2 f;

        k(gr_2 gr_22, a a2) {
            this.f = gr_22;
            this.b = a2;
            this.e = gr.a((gr_2)gr_22);
            gr_2 gr_23 = gr_22;
            this.c = gr.a((gr_2)gr_23, (h)gr.b((gr_2)gr_23)[a2.ordinal()], (a)a2);
            this.a = null;
            this.d = null;
        }

        public final boolean hasNext() {
            return this.c != null;
        }

        protected final h<K, V> c() {
            if (this.c == null) {
                throw new NoSuchElementException();
            }
            if (gr.a((gr_2)this.f) != this.e) {
                throw new ConcurrentModificationException();
            }
            this.a = this.c;
            this.d = this.c;
            this.c = gr.b((gr_2)this.f, this.c, (a)this.b);
            return this.a;
        }

        public boolean hasPrevious() {
            return this.d != null;
        }

        protected final h<K, V> d() {
            if (this.d == null) {
                throw new NoSuchElementException();
            }
            if (gr.a((gr_2)this.f) != this.e) {
                throw new ConcurrentModificationException();
            }
            this.c = this.a;
            if (this.c == null) {
                this.c = gr.b((gr_2)this.f, this.d, (a)this.b);
            }
            this.a = this.d;
            this.d = gr.c((gr_2)this.f, this.d, (a)this.b);
            return this.a;
        }

        public final void remove() {
            if (this.a == null) {
                throw new IllegalStateException();
            }
            if (gr.a((gr_2)this.f) != this.e) {
                throw new ConcurrentModificationException();
            }
            gr.a((gr_2)this.f, this.a);
            ++this.e;
            this.a = null;
            if (this.c == null) {
                this.d = gr.d((gr_2)this.f, (h)gr.b((gr_2)this.f)[this.b.ordinal()], (a)this.b);
                return;
            }
            this.d = gr.c((gr_2)this.f, this.c, (a)this.b);
        }
    }

    final class d
    extends j<Map.Entry<V, K>> {
        private /* synthetic */ gr_2 b;

        d(gr_2 gr_22) {
            this.b = gr_22;
            super(gr_22, org.valkyrienskies.core.impl.shadow.gr$a.VALUE);
        }

        @Override
        public final boolean contains(Object obj) {
            Map.Entry entry;
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            entry = entry;
            Object v = entry.getValue();
            return (entry = gr.c((gr_2)this.b, entry.getKey())) != null && ((h)entry).a.equals(v);
        }

        @Override
        public final boolean remove(Object obj) {
            Map.Entry entry;
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            entry = entry;
            Object v = entry.getValue();
            if ((entry = gr.c((gr_2)this.b, entry.getKey())) != null) {
                Map.Entry entry2 = entry;
                if (((h)entry2).a.equals(v)) {
                    gr.a((gr_2)this.b, (h)entry);
                    return true;
                }
            }
            return false;
        }

        @Override
        public final Iterator<Map.Entry<V, K>> iterator() {
            return new e(this.b);
        }
    }

    final class b
    extends j<Map.Entry<K, V>> {
        private /* synthetic */ gr_2 b;

        b(gr_2 gr_22) {
            this.b = gr_22;
            super(gr_22, org.valkyrienskies.core.impl.shadow.gr$a.KEY);
        }

        @Override
        public final boolean contains(Object obj) {
            Map.Entry entry;
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            entry = entry;
            Object v = entry.getValue();
            return (entry = gr.a((gr_2)this.b, entry.getKey())) != null && ((h)entry).b.equals(v);
        }

        @Override
        public final boolean remove(Object obj) {
            Map.Entry entry;
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            entry = entry;
            Object v = entry.getValue();
            if ((entry = gr.a((gr_2)this.b, entry.getKey())) != null) {
                Map.Entry entry2 = entry;
                if (((h)entry2).b.equals(v)) {
                    gr.a((gr_2)this.b, (h)entry);
                    return true;
                }
            }
            return false;
        }

        @Override
        public final Iterator<Map.Entry<K, V>> iterator() {
            return new l(this.b);
        }
    }

    final class i
    extends j<V> {
        private /* synthetic */ gr_2 b;

        public i(gr_2 gr_22, a a2) {
            this.b = gr_22;
            super(gr_22, a2);
        }

        @Override
        public final Iterator<V> iterator() {
            return new f(this.b, this.a);
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public final boolean contains(Object obj) {
            void var1_1;
            gr.a((Object)obj, (a)org.valkyrienskies.core.impl.shadow.gr$a.VALUE);
            return gr.c((gr_2)this.b, (Object)var1_1) != null;
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public final boolean remove(Object o) {
            void var1_1;
            return gr.d((gr_2)this.b, (Object)var1_1) != null;
        }
    }

    final class g
    extends j<K> {
        private /* synthetic */ gr_2 b;

        public g(gr_2 gr_22, a a2) {
            this.b = gr_22;
            super(gr_22, a2);
        }

        @Override
        public final Iterator<K> iterator() {
            return new m(this.b, this.a);
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public final boolean contains(Object obj) {
            void var1_1;
            gr.a((Object)obj, (a)org.valkyrienskies.core.impl.shadow.gr$a.KEY);
            return gr.a((gr_2)this.b, (Object)var1_1) != null;
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public final boolean remove(Object o) {
            void var1_1;
            return gr.b((gr_2)this.b, (Object)var1_1) != null;
        }
    }

    abstract class j<E>
    extends AbstractSet<E> {
        final a a;
        private /* synthetic */ gr_2 b;

        j(gr_2 gr_22, a a2) {
            this.b = gr_22;
            this.a = a2;
        }

        @Override
        public int size() {
            return this.b.size();
        }

        @Override
        public void clear() {
            this.b.clear();
        }
    }

    static enum a {
        KEY("key"),
        VALUE("value");

        private final String description;

        private a(String string2) {
            this.description = string2;
        }

        public final String toString() {
            return this.description;
        }
    }
}

