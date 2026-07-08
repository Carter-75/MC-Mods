/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import org.valkyrienskies.core.impl.shadow.fn_1;
import org.valkyrienskies.core.impl.shadow.fu_1;
import org.valkyrienskies.core.impl.shadow.fx_1;
import org.valkyrienskies.core.impl.shadow.iz_1;
import org.valkyrienskies.core.impl.shadow.kC;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.gj
 */
public final class gj_2<E>
extends fx_1<E>
implements fu_1 {
    private static final long a = -3190437252665717841L;

    public static <E> fn_1<E> a(fn_1<E> fn_12) {
        if (fn_12 instanceof fu_1) {
            return fn_12;
        }
        return new gj_2<E>(fn_12);
    }

    private gj_2(fn_1<E> fn_12) {
        super(fn_12);
    }

    private void a(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.g());
    }

    private void a(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.a((Collection)objectInputStream.readObject());
    }

    @Override
    public final Iterator<E> iterator() {
        return iz_1.a(this.g().iterator());
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
        Set set = this.g().a();
        return kC.a(set);
    }
}

