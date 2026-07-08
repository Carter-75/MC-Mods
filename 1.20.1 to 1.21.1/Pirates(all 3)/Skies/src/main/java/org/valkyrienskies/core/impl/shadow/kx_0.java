/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Collection;
import java.util.Comparator;
import java.util.Set;
import java.util.SortedSet;
import org.valkyrienskies.core.impl.shadow.ff_1;
import org.valkyrienskies.core.impl.shadow.kw_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.kx
 */
public class kx_0<E>
extends kw_0<E>
implements SortedSet<E> {
    private static final long b = -9110948148132275052L;

    public static <E> kx_0<E> a(SortedSet<E> sortedSet, ff_1<? super E> ff_12) {
        return new kx_0<E>(sortedSet, ff_12);
    }

    protected kx_0(SortedSet<E> sortedSet, ff_1<? super E> ff_12) {
        super(sortedSet, ff_12);
    }

    protected SortedSet<E> a() {
        return (SortedSet)super.b();
    }

    @Override
    public Comparator<? super E> comparator() {
        return this.a().comparator();
    }

    @Override
    public E first() {
        return this.a().first();
    }

    @Override
    public E last() {
        return this.a().last();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public SortedSet<E> subSet(E fromElement, E toElement) {
        void var2_2;
        SortedSet<void> sortedSet;
        sortedSet = this.a().subSet((void)sortedSet, var2_2);
        return new kx_0(sortedSet, this.a);
    }

    @Override
    public SortedSet<E> headSet(E toElement) {
        SortedSet<void> sortedSet;
        sortedSet = this.a().headSet((void)sortedSet);
        return new kx_0(sortedSet, this.a);
    }

    @Override
    public SortedSet<E> tailSet(E fromElement) {
        SortedSet<void> sortedSet;
        sortedSet = this.a().tailSet((void)sortedSet);
        return new kx_0(sortedSet, this.a);
    }

    @Override
    protected /* synthetic */ Set b() {
        return this.a();
    }

    @Override
    public /* synthetic */ Collection f() {
        return this.a();
    }
}

