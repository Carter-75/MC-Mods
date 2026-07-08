/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Iterator;
import java.util.NavigableSet;
import org.valkyrienskies.core.impl.shadow.fq_1;
import org.valkyrienskies.core.impl.shadow.kA;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.ky
 */
public final class ky_0<E>
extends kA<E>
implements NavigableSet<E> {
    private static final long b = 20150528L;

    public static <E> ky_0<E> a(NavigableSet<E> navigableSet, fq_1<? super E, ? extends E> fq_12) {
        return new ky_0<E>(navigableSet, fq_12);
    }

    private static <E> ky_0<E> b(NavigableSet<E> objectArray, fq_1<? super E, ? extends E> fq_12) {
        ky_0<? extends E> ky_02 = new ky_0<E>(objectArray, fq_12);
        if (objectArray.size() > 0) {
            Object[] objectArray2 = objectArray.toArray();
            objectArray.clear();
            objectArray = objectArray2;
            int n2 = objectArray2.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                Object object = objectArray[i2];
                ky_0<? extends E> ky_03 = ky_02;
                ((NavigableSet)super.f()).add(fq_12.a(object));
            }
        }
        return ky_02;
    }

    private ky_0(NavigableSet<E> navigableSet, fq_1<? super E, ? extends E> fq_12) {
        super(navigableSet, fq_12);
    }

    private NavigableSet<E> a() {
        return (NavigableSet)super.f();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final E lower(E e2) {
        void var1_1;
        ky_0 ky_02 = this;
        return ((NavigableSet)super.f()).lower(var1_1);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final E floor(E e2) {
        void var1_1;
        ky_0 ky_02 = this;
        return ((NavigableSet)super.f()).floor(var1_1);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final E ceiling(E e2) {
        void var1_1;
        ky_0 ky_02 = this;
        return ((NavigableSet)super.f()).ceiling(var1_1);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final E higher(E e2) {
        void var1_1;
        ky_0 ky_02 = this;
        return ((NavigableSet)super.f()).higher(var1_1);
    }

    @Override
    public final E pollFirst() {
        ky_0 ky_02 = this;
        return ((NavigableSet)super.f()).pollFirst();
    }

    @Override
    public final E pollLast() {
        ky_0 ky_02 = this;
        return ((NavigableSet)super.f()).pollLast();
    }

    @Override
    public final NavigableSet<E> descendingSet() {
        ky_0 ky_02 = this;
        return ky_0.a(((NavigableSet)super.f()).descendingSet(), this.a);
    }

    @Override
    public final Iterator<E> descendingIterator() {
        ky_0 ky_02 = this;
        return ((NavigableSet)super.f()).descendingIterator();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final NavigableSet<E> subSet(E fromElement, boolean fromInclusive, E toElement, boolean toInclusive) {
        void var3_3;
        void var2_2;
        NavigableSet<void> navigableSet;
        ky_0 ky_02 = this;
        navigableSet = ((NavigableSet)super.f()).subSet(navigableSet, (boolean)var2_2, var3_3, toInclusive);
        return ky_0.a(navigableSet, this.a);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final NavigableSet<E> headSet(E toElement, boolean inclusive) {
        void var2_2;
        NavigableSet<void> navigableSet;
        ky_0 ky_02 = this;
        navigableSet = ((NavigableSet)super.f()).headSet(navigableSet, (boolean)var2_2);
        return ky_0.a(navigableSet, this.a);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final NavigableSet<E> tailSet(E fromElement, boolean inclusive) {
        void var2_2;
        NavigableSet<void> navigableSet;
        ky_0 ky_02 = this;
        navigableSet = ((NavigableSet)super.f()).tailSet(navigableSet, (boolean)var2_2);
        return ky_0.a(navigableSet, this.a);
    }
}

