/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedSet;
import org.valkyrienskies.core.impl.shadow.fu_1;
import org.valkyrienskies.core.impl.shadow.iz_1;
import org.valkyrienskies.core.impl.shadow.kD;
import org.valkyrienskies.core.impl.shadow.ko_0;

public final class kB<E>
extends ko_0<E>
implements fu_1 {
    private static final long a = 20150528L;

    public static <E> NavigableSet<E> a(NavigableSet<E> navigableSet) {
        if (navigableSet instanceof fu_1) {
            return navigableSet;
        }
        return new kB<E>(navigableSet);
    }

    private kB(NavigableSet<E> navigableSet) {
        super(navigableSet);
    }

    @Override
    public final Iterator<E> iterator() {
        return iz_1.a(this.a().iterator());
    }

    @Override
    public final boolean add(E object) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final boolean addAll(Collection<? extends E> coll) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override
    public final boolean remove(Object object) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final boolean removeAll(Collection<?> coll) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final boolean retainAll(Collection<?> coll) {
        throw new UnsupportedOperationException();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final SortedSet<E> subSet(E fromElement, E toElement) {
        void var2_2;
        SortedSet<void> sortedSet;
        sortedSet = this.a().subSet((void)sortedSet, var2_2);
        return kD.a(sortedSet);
    }

    @Override
    public final SortedSet<E> headSet(E toElement) {
        SortedSet<void> sortedSet;
        sortedSet = this.a().headSet((void)sortedSet);
        return kD.a(sortedSet);
    }

    @Override
    public final SortedSet<E> tailSet(E fromElement) {
        SortedSet<void> sortedSet;
        sortedSet = this.a().tailSet((void)sortedSet);
        return kD.a(sortedSet);
    }

    @Override
    public final NavigableSet<E> descendingSet() {
        return kB.a(this.a().descendingSet());
    }

    @Override
    public final Iterator<E> descendingIterator() {
        return iz_1.a(this.a().descendingIterator());
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final NavigableSet<E> subSet(E fromElement, boolean fromInclusive, E toElement, boolean toInclusive) {
        void var3_3;
        void var2_2;
        NavigableSet<void> navigableSet;
        navigableSet = this.a().subSet((void)navigableSet, (boolean)var2_2, var3_3, toInclusive);
        return kB.a(navigableSet);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final NavigableSet<E> headSet(E toElement, boolean inclusive) {
        void var2_2;
        NavigableSet<void> navigableSet;
        navigableSet = this.a().headSet((void)navigableSet, (boolean)var2_2);
        return kB.a(navigableSet);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final NavigableSet<E> tailSet(E fromElement, boolean inclusive) {
        void var2_2;
        NavigableSet<void> navigableSet;
        navigableSet = this.a().tailSet((void)navigableSet, (boolean)var2_2);
        return kB.a(navigableSet);
    }

    private void a(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.a());
    }

    private void a(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.a((Collection)objectInputStream.readObject());
    }
}

