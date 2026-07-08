/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Collection;
import java.util.Set;
import org.valkyrienskies.core.impl.shadow.ff_1;
import org.valkyrienskies.core.impl.shadow.gy_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.kw
 */
public class kw_0<E>
extends gy_2<E>
implements Set<E> {
    private static final long b = -684521469108685117L;

    public static <E> kw_0<E> a(Set<E> set, ff_1<? super E> ff_12) {
        return new kw_0<E>(set, ff_12);
    }

    protected kw_0(Set<E> set, ff_1<? super E> ff_12) {
        super(set, ff_12);
    }

    protected Set<E> b() {
        return (Set)super.f();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public boolean equals(Object object) {
        void var1_1;
        return object == this || this.b().equals(var1_1);
    }

    @Override
    public int hashCode() {
        return this.b().hashCode();
    }

    @Override
    public /* synthetic */ Collection f() {
        return this.b();
    }
}

