/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.valkyrienskies.core.impl.shadow.iZ
 *  org.valkyrienskies.core.impl.shadow.jc$a
 *  org.valkyrienskies.core.impl.shadow.jc$b
 *  org.valkyrienskies.core.impl.shadow.jc$c
 *  org.valkyrienskies.core.impl.shadow.jc$e
 *  org.valkyrienskies.core.impl.shadow.jc$f
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import org.valkyrienskies.core.impl.shadow.fd_1;
import org.valkyrienskies.core.impl.shadow.fe_1;
import org.valkyrienskies.core.impl.shadow.fu_2;
import org.valkyrienskies.core.impl.shadow.hz_1;
import org.valkyrienskies.core.impl.shadow.iZ;
import org.valkyrienskies.core.impl.shadow.ia_2;
import org.valkyrienskies.core.impl.shadow.iz_0;
import org.valkyrienskies.core.impl.shadow.jc;
import org.valkyrienskies.core.impl.shadow.jc_0;

/*
 * Signature claims super is org.valkyrienskies.core.impl.shadow.iz_0<K, V>, not org.valkyrienskies.core.impl.shadow.iZ - discarding signature.
 * Renamed from org.valkyrienskies.core.impl.shadow.jc
 */
public abstract class jc_0
extends iZ
implements fd_1 {
    transient c_0<K, V> j;

    protected jc_0() {
    }

    protected jc_0(int n2, float f2, int n3) {
        super(16, 0.75f, 12);
    }

    protected jc_0(int n2) {
        super(n2);
    }

    protected jc_0(int n2, float f2) {
        super(n2, f2);
    }

    protected jc_0(Map<? extends K, ? extends V> map2) {
        super(map2);
    }

    protected final void d() {
        ((jc.c)this.j).e = ((jc.c)this.j).f = (this.j = this.b(null, -1, null, null));
    }

    @Override
    public boolean containsValue(Object value) {
        if (value == null) {
            c_0 c_02 = ((jc.c)this.j).f;
            while (c_02 != this.j) {
                if (c_02.getValue() == null) {
                    return true;
                }
                c_02 = ((jc.c)c_02).f;
            }
        } else {
            c_0 c_03 = ((jc.c)this.j).f;
            while (c_03 != this.j) {
                if (this.b(value, c_03.getValue())) {
                    return true;
                }
                c_03 = ((jc.c)c_03).f;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        super.clear();
        ((jc.c)this.j).e = ((jc.c)this.j).f = this.j;
    }

    @Override
    public K firstKey() {
        if (this.c == 0) {
            throw new NoSuchElementException("Map is empty");
        }
        return ((jc.c)this.j).f.getKey();
    }

    @Override
    public K lastKey() {
        if (this.c == 0) {
            throw new NoSuchElementException("Map is empty");
        }
        return ((jc.c)this.j).e.getKey();
    }

    public final K c(Object c_02) {
        if ((c_02 = this.f(c_02)) == null || ((jc.c)c_02).f == this.j) {
            return null;
        }
        return ((jc.c)c_02).f.getKey();
    }

    protected final c_0<K, V> f(Object object) {
        return (jc.c)super.e(object);
    }

    public final K d(Object c_02) {
        if ((c_02 = this.f(c_02)) == null || ((jc.c)c_02).e == this.j) {
            return null;
        }
        return ((jc.c)c_02).e.getKey();
    }

    protected final c_0<K, V> a(int n2) {
        c_0 c_02;
        if (n2 < 0) {
            throw new IndexOutOfBoundsException("Index " + n2 + " is less than zero");
        }
        if (n2 >= this.c) {
            throw new IndexOutOfBoundsException("Index " + n2 + " is invalid for size " + this.c);
        }
        if (n2 < this.c / 2) {
            c_02 = ((jc.c)this.j).f;
            for (int i2 = 0; i2 < n2; ++i2) {
                c_02 = ((jc.c)c_02).f;
            }
        } else {
            c_02 = this.j;
            for (int i3 = this.c; i3 > n2; --i3) {
                c_02 = ((jc.c)c_02).e;
            }
        }
        return c_02;
    }

    protected final void a(iz_0.c<K, V> c2, int n2) {
        c2 = c2;
        v0.f = this.j;
        c2.e = ((jc.c)this.j).e;
        ((jc.c)((jc.c)this.j).e).f = c2;
        ((jc.c)this.j).e = c2;
        this.d[n2] = c2;
    }

    private c_0<K, V> b(iz_0.c<K, V> c2, int n2, K k2, V v) {
        return new jc.c(c2, n2, this.a(k2), v);
    }

    protected final void b(iz_0.c<K, V> c2, int n2, iz_0.c<K, V> c3) {
        jc.c c4 = (jc.c)c2;
        ((jc.c)((jc.c)c2).e).f = c4.f;
        ((jc.c)c4.f).e = c4.e;
        c4.f = null;
        c4.e = null;
        super.b(c2, n2, c3);
    }

    private static c_0<K, V> a(c_0<K, V> c_02) {
        return ((jc.c)c_02).e;
    }

    private static c_0<K, V> b(c_0<K, V> c_02) {
        return ((jc.c)c_02).f;
    }

    @Override
    public final fe_1<K, V> e() {
        if (this.c == 0) {
            return ia_2.d();
        }
        return new jc.e(this);
    }

    protected final Iterator<Map.Entry<K, V>> f() {
        if (this.size() == 0) {
            return hz_1.a();
        }
        return new jc.a(this);
    }

    protected final Iterator<K> g() {
        if (this.size() == 0) {
            return hz_1.a();
        }
        return new jc.b(this);
    }

    protected final Iterator<V> h() {
        if (this.size() == 0) {
            return hz_1.a();
        }
        return new jc.f(this);
    }

    @Override
    public final /* synthetic */ fu_2 c() {
        return this.e();
    }

    protected final /* synthetic */ iz_0.c a(iz_0.c c2, int n2, Object object, Object object2) {
        return this.b(c2, n2, object, object2);
    }

    protected final /* synthetic */ iz_0.c e(Object object) {
        return this.f(object);
    }
}

