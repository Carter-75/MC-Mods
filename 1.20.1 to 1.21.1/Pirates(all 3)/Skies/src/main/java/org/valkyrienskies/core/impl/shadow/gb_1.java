/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Collection;
import java.util.Iterator;
import org.valkyrienskies.core.impl.shadow.ez_1;
import org.valkyrienskies.core.impl.shadow.fu_1;
import org.valkyrienskies.core.impl.shadow.gv_2;
import org.valkyrienskies.core.impl.shadow.gz_2;
import org.valkyrienskies.core.impl.shadow.iz_1;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.gB
 */
public final class gb_1<E>
extends gv_2<E>
implements ez_1<E>,
fu_1 {
    private static final long a = -7112672385450340330L;

    private static <E> ez_1<E> a(ez_1<? extends E> ez_12) {
        if (ez_12 instanceof fu_1) {
            return ez_12;
        }
        return new gb_1<E>(ez_12);
    }

    public static <E> ez_1<E> b(Collection<? extends E> collection) {
        if (collection == null) {
            throw new NullPointerException("Collection must not be null.");
        }
        for (int i2 = 0; i2 < 1000 && !(collection instanceof ez_1); ++i2) {
            if (collection instanceof gv_2) {
                collection = ((gv_2)collection).f();
                continue;
            }
            if (!(collection instanceof gz_2)) continue;
            collection = ((gz_2)collection).e();
        }
        if (!(collection instanceof ez_1)) {
            throw new IllegalArgumentException("Collection is not a bounded collection.");
        }
        return new gb_1<E>((ez_1)collection);
    }

    private gb_1(ez_1<? extends E> ez_12) {
        super(ez_12);
    }

    @Override
    public final Iterator<E> iterator() {
        gb_1 gb_12 = this;
        return iz_1.a(((ez_1)super.f()).iterator());
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
    public final boolean a() {
        gb_1 gb_12 = this;
        return ((ez_1)super.f()).a();
    }

    @Override
    public final int b() {
        gb_1 gb_12 = this;
        return ((ez_1)super.f()).b();
    }

    private ez_1<E> c() {
        return (ez_1)super.f();
    }
}

