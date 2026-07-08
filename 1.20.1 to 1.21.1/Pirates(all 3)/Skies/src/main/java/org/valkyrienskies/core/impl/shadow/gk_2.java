/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.valkyrienskies.core.impl.shadow.ey_1;
import org.valkyrienskies.core.impl.shadow.fu_2;
import org.valkyrienskies.core.impl.shadow.jd_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.gk
 */
public abstract class gk_2<K, V>
extends jd_0<K, V>
implements ey_1<K, V> {
    protected gk_2(ey_1<K, V> ey_12) {
        super(ey_12);
    }

    protected ey_1<K, V> h() {
        return (ey_1)super.i();
    }

    @Override
    public fu_2<K, V> c() {
        return this.h().c();
    }

    @Override
    public final K a(Object object) {
        return this.h().a(object);
    }

    @Override
    public K b(Object object) {
        return this.h().b(object);
    }

    @Override
    public ey_1<V, K> a() {
        return this.h().a();
    }

    @Override
    public Set<V> b() {
        return this.h().b();
    }

    @Override
    public /* synthetic */ Collection values() {
        return this.b();
    }

    @Override
    public /* synthetic */ Map i() {
        return this.h();
    }
}

