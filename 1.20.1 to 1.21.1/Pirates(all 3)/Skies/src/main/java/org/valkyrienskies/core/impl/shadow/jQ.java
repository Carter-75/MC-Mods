/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.valkyrienskies.core.impl.shadow.fa_1;
import org.valkyrienskies.core.impl.shadow.fu_1;
import org.valkyrienskies.core.impl.shadow.fu_2;
import org.valkyrienskies.core.impl.shadow.fy_2;
import org.valkyrienskies.core.impl.shadow.gc_1;
import org.valkyrienskies.core.impl.shadow.ib_1;
import org.valkyrienskies.core.impl.shadow.jG;
import org.valkyrienskies.core.impl.shadow.jL;
import org.valkyrienskies.core.impl.shadow.jX;
import org.valkyrienskies.core.impl.shadow.kC;

public final class jQ<K, V>
extends jL<K, V>
implements fu_1 {
    private static final long a = 20150612L;

    public static <K, V> jQ<K, V> b(fa_1<? extends K, ? extends V> fa_12) {
        if (fa_12 instanceof fu_1) {
            return (jQ)fa_12;
        }
        return new jQ<K, V>(fa_12);
    }

    private jQ(fa_1<? extends K, ? extends V> fa_12) {
        super(fa_12);
    }

    @Override
    public final Collection<V> f(Object object) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final boolean c(Object object, Object object2) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final void c() {
        throw new UnsupportedOperationException();
    }

    @Override
    public final Collection<V> e(K k2) {
        return gc_1.b(this.j().e(k2));
    }

    @Override
    public final boolean b(K k2, V v) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final Set<K> f() {
        return kC.a(this.j().f());
    }

    @Override
    public final Collection<Map.Entry<K, V>> d() {
        return gc_1.b(this.j().d());
    }

    @Override
    public final fy_2<K> e() {
        return jX.a(this.j().e());
    }

    @Override
    public final Collection<V> g() {
        return gc_1.b(this.j().g());
    }

    @Override
    public final Map<K, Collection<V>> h() {
        return jG.a(this.j().h());
    }

    @Override
    public final fu_2<K, V> i() {
        return ib_1.a(this.j().i());
    }

    @Override
    public final boolean a(K k2, Iterable<? extends V> iterable) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final boolean a(Map<? extends K, ? extends V> map2) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final boolean a(fa_1<? extends K, ? extends V> fa_12) {
        throw new UnsupportedOperationException();
    }
}

