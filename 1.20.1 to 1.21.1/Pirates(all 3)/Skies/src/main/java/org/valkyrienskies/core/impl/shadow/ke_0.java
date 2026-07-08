/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import org.valkyrienskies.core.impl.shadow.fu_1;
import org.valkyrienskies.core.impl.shadow.iz_1;
import org.valkyrienskies.core.impl.shadow.jZ;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.ke
 */
public final class ke_0<E>
extends jZ<E>
implements fu_1 {
    private static final long a = 1832948656215393357L;

    public static <E> Queue<E> a(Queue<? extends E> queue) {
        if (queue instanceof fu_1) {
            return queue;
        }
        return new ke_0<E>(queue);
    }

    private ke_0(Queue<? extends E> queue) {
        super(queue);
    }

    private void a(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.a());
    }

    private void a(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.a((Collection)objectInputStream.readObject());
    }

    @Override
    public final Iterator<E> iterator() {
        return iz_1.a(this.a().iterator());
    }

    @Override
    public final boolean add(Object object) {
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

    @Override
    public final boolean offer(E obj) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final E poll() {
        throw new UnsupportedOperationException();
    }

    @Override
    public final E remove() {
        throw new UnsupportedOperationException();
    }
}

