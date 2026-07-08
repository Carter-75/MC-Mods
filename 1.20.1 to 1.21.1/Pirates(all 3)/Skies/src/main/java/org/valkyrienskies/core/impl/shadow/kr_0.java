/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Collection;
import java.util.Comparator;
import java.util.Set;
import java.util.SortedSet;
import org.valkyrienskies.core.impl.shadow.kq_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.kr
 */
public abstract class kr_0<E>
extends kq_0<E>
implements SortedSet<E> {
    private static final long a = -3462240946294214398L;

    protected kr_0() {
    }

    protected kr_0(Set<E> set) {
        super(set);
    }

    protected SortedSet<E> b() {
        return (SortedSet)super.c();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public SortedSet<E> subSet(E fromElement, E toElement) {
        void var2_2;
        void var1_1;
        return this.b().subSet(var1_1, var2_2);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public SortedSet<E> headSet(E toElement) {
        void var1_1;
        return this.b().headSet(var1_1);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public SortedSet<E> tailSet(E fromElement) {
        void var1_1;
        return this.b().tailSet(var1_1);
    }

    @Override
    public E first() {
        return this.b().first();
    }

    @Override
    public E last() {
        return this.b().last();
    }

    @Override
    public Comparator<? super E> comparator() {
        return this.b().comparator();
    }

    @Override
    protected /* synthetic */ Set c() {
        return this.b();
    }

    @Override
    public /* synthetic */ Collection f() {
        return this.b();
    }
}

