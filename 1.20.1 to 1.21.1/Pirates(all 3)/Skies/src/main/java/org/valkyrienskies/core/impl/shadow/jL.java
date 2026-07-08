/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.valkyrienskies.core.impl.shadow.fa_1;
import org.valkyrienskies.core.impl.shadow.fu_2;
import org.valkyrienskies.core.impl.shadow.fy_2;

public abstract class jL<K, V>
implements Serializable,
fa_1<K, V> {
    private static final long a = 20150612L;
    private final fa_1<K, V> b;

    protected jL(fa_1<K, V> fa_12) {
        if (fa_12 == null) {
            throw new NullPointerException("MultiValuedMap must not be null.");
        }
        this.b = fa_12;
    }

    protected final fa_1<K, V> j() {
        return this.b;
    }

    @Override
    public final int a() {
        jL jL2 = this;
        return jL2.b.a();
    }

    @Override
    public final boolean b() {
        jL jL2 = this;
        return jL2.b.b();
    }

    @Override
    public final boolean c(Object object) {
        jL jL2 = this;
        return jL2.b.c(object);
    }

    @Override
    public final boolean d(Object object) {
        jL jL2 = this;
        return jL2.b.d(object);
    }

    @Override
    public final boolean a(Object object, Object object2) {
        jL jL2 = this;
        return jL2.b.a(object, object2);
    }

    @Override
    public Collection<V> e(K k2) {
        jL jL2 = this;
        return jL2.b.e(k2);
    }

    @Override
    public Collection<V> f(Object object) {
        jL jL2 = this;
        return jL2.b.f(object);
    }

    @Override
    public boolean c(Object object, Object object2) {
        jL jL2 = this;
        return jL2.b.c(object, object2);
    }

    @Override
    public void c() {
        jL jL2 = this;
        jL2.b.c();
    }

    @Override
    public boolean b(K k2, V v) {
        jL jL2 = this;
        return jL2.b.b(k2, v);
    }

    @Override
    public Set<K> f() {
        jL jL2 = this;
        return jL2.b.f();
    }

    @Override
    public Collection<Map.Entry<K, V>> d() {
        jL jL2 = this;
        return jL2.b.d();
    }

    @Override
    public fy_2<K> e() {
        jL jL2 = this;
        return jL2.b.e();
    }

    @Override
    public Collection<V> g() {
        jL jL2 = this;
        return jL2.b.g();
    }

    @Override
    public Map<K, Collection<V>> h() {
        jL jL2 = this;
        return jL2.b.h();
    }

    @Override
    public boolean a(K k2, Iterable<? extends V> iterable) {
        jL jL2 = this;
        return jL2.b.a(k2, iterable);
    }

    @Override
    public boolean a(Map<? extends K, ? extends V> map2) {
        jL jL2 = this;
        return jL2.b.a(map2);
    }

    @Override
    public boolean a(fa_1<? extends K, ? extends V> fa_12) {
        jL jL2 = this;
        return jL2.b.a(fa_12);
    }

    @Override
    public fu_2<K, V> i() {
        jL jL2 = this;
        return jL2.b.i();
    }

    /*
     * WARNING - void declaration
     */
    public boolean equals(Object object) {
        void var1_1;
        if (object == this) {
            return true;
        }
        jL jL2 = this;
        return jL2.b.equals(var1_1);
    }

    public int hashCode() {
        jL jL2 = this;
        return jL2.b.hashCode();
    }

    public String toString() {
        jL jL2 = this;
        return jL2.b.toString();
    }
}

