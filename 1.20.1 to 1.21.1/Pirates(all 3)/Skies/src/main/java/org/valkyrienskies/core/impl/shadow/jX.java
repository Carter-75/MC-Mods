/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import org.valkyrienskies.core.impl.shadow.fu_1;
import org.valkyrienskies.core.impl.shadow.fy_2;
import org.valkyrienskies.core.impl.shadow.iz_1;
import org.valkyrienskies.core.impl.shadow.jT;
import org.valkyrienskies.core.impl.shadow.kC;

public final class jX<E>
extends jT<E>
implements fu_1 {
    private static final long a = 20150611L;

    public static <E> fy_2<E> a(fy_2<? extends E> fy_22) {
        if (fy_22 instanceof fu_1) {
            return fy_22;
        }
        return new jX<E>(fy_22);
    }

    private jX(fy_2<? extends E> fy_22) {
        super(fy_22);
    }

    private void a(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.c());
    }

    private void a(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.a((Collection)objectInputStream.readObject());
    }

    @Override
    public final Iterator<E> iterator() {
        return iz_1.a(this.c().iterator());
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
    public final int a(E e2, int n2) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final int b(E e2, int n2) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final int c(Object object, int n2) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final Set<E> a() {
        Set set = this.c().a();
        return kC.a(set);
    }

    @Override
    public final Set<fy_2.a_0<E>> b() {
        Set set = this.c().b();
        return kC.a(set);
    }
}

