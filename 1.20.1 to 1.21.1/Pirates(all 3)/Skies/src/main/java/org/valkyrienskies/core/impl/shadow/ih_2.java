/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Iterator;
import org.valkyrienskies.core.impl.shadow.fj_1;
import org.valkyrienskies.core.impl.shadow.ij_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.ih
 */
public final class ih_2<E>
implements Iterable<E> {
    private final Iterator<? extends E> a;
    private final Iterator<E> b;

    private static <E> Iterator<E> a(Iterator<? extends E> iterator2) {
        return new Iterator<E>(iterator2){
            private /* synthetic */ Iterator a;
            {
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
                this.a.remove();
            }
        };
    }

    private ih_2(Iterator<? extends E> iterator2) {
        this(iterator2, false);
    }

    public ih_2(Iterator<? extends E> iterator2, boolean bl) {
        this.a = bl && !(iterator2 instanceof fj_1) ? new ij_2<E>(iterator2) : iterator2;
        iterator2 = this.a;
        this.b = new /* invalid duplicate definition of identical inner class */;
    }

    @Override
    public final Iterator<E> iterator() {
        if (this.a instanceof fj_1) {
            ((fj_1)this.a).c();
        }
        return this.b;
    }
}

