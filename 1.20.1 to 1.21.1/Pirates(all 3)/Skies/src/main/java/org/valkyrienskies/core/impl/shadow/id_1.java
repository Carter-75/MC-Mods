/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.valkyrienskies.core.impl.shadow.fj_2;
import org.valkyrienskies.core.impl.shadow.fp_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.iD
 */
public final class id_1<E>
implements Iterator<E> {
    private final Iterator<Iterator<? extends E>> a;
    private Iterator<? extends E> b = null;
    private Iterator<? extends E> c = null;

    public id_1(Iterator<? extends E> iterator2, Iterator<? extends E> iterator3) {
        this(new Iterator[]{iterator2, iterator3});
    }

    public id_1(Iterator<? extends E> iterator2, Iterator<? extends E> iterator3, Iterator<? extends E> iterator4) {
        this(new Iterator[]{iterator2, iterator3, iterator4});
    }

    public id_1(Iterator<? extends E> ... object) {
        ArrayList<Object> arrayList = new ArrayList<Object>();
        for (Object object2 : object) {
            if (object2 == null) {
                throw new NullPointerException("Iterator must not be null.");
            }
            arrayList.add(object2);
        }
        fj_2 fj_22 = fj_2.a(arrayList);
        this.a = fj_2.a(fp_2.a(fj_22.a)).iterator();
    }

    @Override
    public final boolean hasNext() {
        if (this.b != null) {
            return true;
        }
        while (this.a.hasNext()) {
            Iterator<E> iterator2 = this.a.next();
            if (iterator2.hasNext()) {
                this.b = iterator2;
                return true;
            }
            this.a.remove();
        }
        return false;
    }

    @Override
    public final E next() {
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        E e2 = this.b.next();
        this.c = this.b;
        this.b = null;
        return e2;
    }

    @Override
    public final void remove() {
        if (this.c == null) {
            throw new IllegalStateException("No value can be removed at present");
        }
        this.c.remove();
        this.c = null;
    }
}

