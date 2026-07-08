/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Collection;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;
import org.valkyrienskies.core.impl.shadow.ff_1;
import org.valkyrienskies.core.impl.shadow.kx_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.kv
 */
public final class kv_0<E>
extends kx_0<E>
implements NavigableSet<E> {
    private static final long b = 20150528L;

    public static <E> kv_0<E> a(NavigableSet<E> navigableSet, ff_1<? super E> ff_12) {
        return new kv_0<E>(navigableSet, ff_12);
    }

    private kv_0(NavigableSet<E> navigableSet, ff_1<? super E> ff_12) {
        super(navigableSet, ff_12);
    }

    private NavigableSet<E> c() {
        return (NavigableSet)super.a();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final E lower(E e2) {
        void var1_1;
        kv_0 kv_02 = this;
        return ((NavigableSet)super.a()).lower(var1_1);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final E floor(E e2) {
        void var1_1;
        kv_0 kv_02 = this;
        return ((NavigableSet)super.a()).floor(var1_1);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final E ceiling(E e2) {
        void var1_1;
        kv_0 kv_02 = this;
        return ((NavigableSet)super.a()).ceiling(var1_1);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final E higher(E e2) {
        void var1_1;
        kv_0 kv_02 = this;
        return ((NavigableSet)super.a()).higher(var1_1);
    }

    @Override
    public final E pollFirst() {
        kv_0 kv_02 = this;
        return ((NavigableSet)super.a()).pollFirst();
    }

    @Override
    public final E pollLast() {
        kv_0 kv_02 = this;
        return ((NavigableSet)super.a()).pollLast();
    }

    @Override
    public final NavigableSet<E> descendingSet() {
        kv_0 kv_02 = this;
        return kv_0.a(((NavigableSet)super.a()).descendingSet(), this.a);
    }

    @Override
    public final Iterator<E> descendingIterator() {
        kv_0 kv_02 = this;
        return ((NavigableSet)super.a()).descendingIterator();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final NavigableSet<E> subSet(E fromElement, boolean fromInclusive, E toElement, boolean toInclusive) {
        void var3_3;
        void var2_2;
        NavigableSet<void> navigableSet;
        kv_0 kv_02 = this;
        navigableSet = ((NavigableSet)super.a()).subSet(navigableSet, (boolean)var2_2, var3_3, toInclusive);
        return kv_0.a(navigableSet, this.a);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final NavigableSet<E> headSet(E toElement, boolean inclusive) {
        void var2_2;
        NavigableSet<void> navigableSet;
        kv_0 kv_02 = this;
        navigableSet = ((NavigableSet)super.a()).headSet(navigableSet, (boolean)var2_2);
        return kv_0.a(navigableSet, this.a);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final NavigableSet<E> tailSet(E fromElement, boolean inclusive) {
        void var2_2;
        NavigableSet<void> navigableSet;
        kv_0 kv_02 = this;
        navigableSet = ((NavigableSet)super.a()).tailSet(navigableSet, (boolean)var2_2);
        return kv_0.a(navigableSet, this.a);
    }

    @Override
    protected final /* synthetic */ Set b() {
        kv_0 kv_02 = this;
        return (NavigableSet)super.a();
    }

    @Override
    public final /* synthetic */ Collection f() {
        kv_0 kv_02 = this;
        return (NavigableSet)super.a();
    }
}

