/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Comparator;
import java.util.SortedSet;
import org.valkyrienskies.core.impl.shadow.fq_1;
import org.valkyrienskies.core.impl.shadow.kz_0;

public class kA<E>
extends kz_0<E>
implements SortedSet<E> {
    private static final long b = -1675486811351124386L;

    public static <E> kA<E> a(SortedSet<E> sortedSet, fq_1<? super E, ? extends E> fq_12) {
        return new kA<E>(sortedSet, fq_12);
    }

    private static <E> kA<E> b(SortedSet<E> objectArray, fq_1<? super E, ? extends E> fq_12) {
        kA<E> kA2 = new kA<E>(objectArray, fq_12);
        if (objectArray.size() > 0) {
            Object[] objectArray2 = objectArray.toArray();
            objectArray.clear();
            objectArray = objectArray2;
            int n2 = objectArray2.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                Object object = objectArray[i2];
                kA2.f().add(fq_12.a(object));
            }
        }
        return kA2;
    }

    protected kA(SortedSet<E> sortedSet, fq_1<? super E, ? extends E> fq_12) {
        super(sortedSet, fq_12);
    }

    private SortedSet<E> a() {
        return (SortedSet)this.f();
    }

    @Override
    public E first() {
        kA kA2 = this;
        return ((SortedSet)kA2.f()).first();
    }

    @Override
    public E last() {
        kA kA2 = this;
        return ((SortedSet)kA2.f()).last();
    }

    @Override
    public Comparator<? super E> comparator() {
        kA kA2 = this;
        return ((SortedSet)kA2.f()).comparator();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public SortedSet<E> subSet(E fromElement, E toElement) {
        void var2_2;
        SortedSet<void> sortedSet;
        kA kA2 = this;
        sortedSet = ((SortedSet)kA2.f()).subSet(sortedSet, var2_2);
        return new kA(sortedSet, this.a);
    }

    @Override
    public SortedSet<E> headSet(E toElement) {
        SortedSet<void> sortedSet;
        kA kA2 = this;
        sortedSet = ((SortedSet)kA2.f()).headSet(sortedSet);
        return new kA(sortedSet, this.a);
    }

    @Override
    public SortedSet<E> tailSet(E fromElement) {
        SortedSet<void> sortedSet;
        kA kA2 = this;
        sortedSet = ((SortedSet)kA2.f()).tailSet(sortedSet);
        return new kA(sortedSet, this.a);
    }
}

