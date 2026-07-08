/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import org.valkyrienskies.core.impl.shadow.fl_1;
import org.valkyrienskies.core.impl.shadow.fm_1;
import org.valkyrienskies.core.impl.shadow.jK;

public abstract class jM<K, V>
extends jK<K, V>
implements fm_1<K, V> {
    protected jM() {
    }

    protected jM(Map<K, ? extends Set<V>> map2) {
        super(map2);
    }

    @Override
    protected final Map<K, Set<V>> j() {
        return super.j();
    }

    protected abstract Set<V> k();

    @Override
    public final Set<V> a(K k2) {
        return this.h(k2);
    }

    private Set<V> h(K k2) {
        return new a(this, k2);
    }

    @Override
    public final Set<V> b(Object object) {
        jM jM2 = this;
        return fl_1.a((Set)super.j().remove(object));
    }

    @Override
    public final /* synthetic */ Collection f(Object object) {
        jM jM2 = this;
        Object object2 = object;
        object = jM2;
        object = jM2;
        return fl_1.a((Set)super.j().remove(object2));
    }

    @Override
    final /* synthetic */ Collection g(Object object) {
        return this.h(object);
    }

    @Override
    public final /* synthetic */ Collection e(Object object) {
        Object object2 = object;
        object = this;
        return object.h(object2);
    }

    @Override
    protected /* synthetic */ Collection l() {
        return this.k();
    }

    final class a
    extends jK.h
    implements Set<V> {
        private /* synthetic */ jM b;

        public a(jM jM2, K k2) {
            this.b = jM2;
            super(jM2, k2);
        }

        @Override
        public final boolean equals(Object other) {
            Set set;
            Set set2 = (Set)this.a();
            if (set2 == null) {
                return Collections.emptySet().equals(other);
            }
            if (!(other instanceof Set)) {
                return false;
            }
            set = set;
            return fl_1.a(set2, set);
        }

        @Override
        public final int hashCode() {
            Set set = (Set)this.a();
            return fl_1.a(set);
        }
    }
}

