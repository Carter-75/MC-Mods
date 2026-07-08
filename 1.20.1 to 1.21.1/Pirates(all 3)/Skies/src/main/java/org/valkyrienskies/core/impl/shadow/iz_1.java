/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Iterator;
import org.valkyrienskies.core.impl.shadow.fu_1;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.iz
 */
public final class iz_1<E>
implements Iterator<E>,
fu_1 {
    private final Iterator<? extends E> a;

    public static <E> Iterator<E> a(Iterator<? extends E> iterator2) {
        if (iterator2 == null) {
            throw new NullPointerException("Iterator must not be null");
        }
        if (iterator2 instanceof fu_1) {
            return iterator2;
        }
        return new iz_1<E>(iterator2);
    }

    private iz_1(Iterator<? extends E> iterator2) {
        this.a = iterator2;
    }

    @Override
    public final boolean hasNext() {
        return this.a.hasNext();
    }

    @Override
    public final E next() {
        return this.a.next();
    }

    @Override
    public final void remove() {
        throw new UnsupportedOperationException("remove() is not supported");
    }
}

