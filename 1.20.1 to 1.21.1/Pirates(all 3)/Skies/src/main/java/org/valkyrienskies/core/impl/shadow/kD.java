/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.SortedSet;
import org.valkyrienskies.core.impl.shadow.fu_1;
import org.valkyrienskies.core.impl.shadow.iz_1;
import org.valkyrienskies.core.impl.shadow.kr_0;

public final class kD<E>
extends kr_0<E>
implements fu_1 {
    private static final long a = -725356885467962424L;

    public static <E> SortedSet<E> a(SortedSet<E> sortedSet) {
        if (sortedSet instanceof fu_1) {
            return sortedSet;
        }
        return new kD<E>(sortedSet);
    }

    private kD(SortedSet<E> sortedSet) {
        super(sortedSet);
    }

    @Override
    public final Iterator<E> iterator() {
        return iz_1.a(this.b().iterator());
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
        sortedSet = this.b().subSet((void)sortedSet, var2_2);
        return kD.a(sortedSet);
    }

    @Override
    public final SortedSet<E> headSet(E toElement) {
        SortedSet<void> sortedSet;
        sortedSet = this.b().headSet((void)sortedSet);
        return kD.a(sortedSet);
    }

    @Override
    public final SortedSet<E> tailSet(E fromElement) {
        SortedSet<void> sortedSet;
        sortedSet = this.b().tailSet((void)sortedSet);
        return kD.a(sortedSet);
    }

    private void a(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.b());
    }

    private void a(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.a((Collection)objectInputStream.readObject());
    }
}

