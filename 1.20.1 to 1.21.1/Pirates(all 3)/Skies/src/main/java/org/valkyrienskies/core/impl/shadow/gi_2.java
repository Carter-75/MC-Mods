/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import org.valkyrienskies.core.impl.shadow.ew_1;
import org.valkyrienskies.core.impl.shadow.fu_1;
import org.valkyrienskies.core.impl.shadow.fv_1;
import org.valkyrienskies.core.impl.shadow.iz_1;
import org.valkyrienskies.core.impl.shadow.kC;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.gi
 */
public final class gi_2<E>
extends fv_1<E>
implements fu_1 {
    private static final long a = -1873799975157099624L;

    public static <E> ew_1<E> a(ew_1<? extends E> ew_12) {
        if (ew_12 instanceof fu_1) {
            return ew_12;
        }
        return new gi_2<E>(ew_12);
    }

    private gi_2(ew_1<? extends E> ew_12) {
        super(ew_12);
    }

    private void a(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.e());
    }

    private void a(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.a((Collection)objectInputStream.readObject());
    }

    @Override
    public final Iterator<E> iterator() {
        return iz_1.a(this.e().iterator());
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

    @Override
    public final boolean a(E e2, int n2) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final boolean b(Object object, int n2) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final Set<E> a() {
        Set set = this.e().a();
        return kC.a(set);
    }
}

