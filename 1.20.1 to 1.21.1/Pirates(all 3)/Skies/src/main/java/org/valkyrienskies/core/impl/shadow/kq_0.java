/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Collection;
import java.util.Set;
import org.valkyrienskies.core.impl.shadow.gv_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.kq
 */
public abstract class kq_0<E>
extends gv_2<E>
implements Set<E> {
    private static final long a = -4678668309576958546L;

    protected kq_0() {
    }

    public kq_0(Set<E> set) {
        super(set);
    }

    protected Set<E> c() {
        return (Set)super.f();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public boolean equals(Object object) {
        void var1_1;
        return object == this || this.c().equals(var1_1);
    }

    @Override
    public int hashCode() {
        return this.c().hashCode();
    }

    @Override
    public /* synthetic */ Collection f() {
        return this.c();
    }
}

