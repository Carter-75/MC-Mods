/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import org.valkyrienskies.core.impl.shadow.ez_1;
import org.valkyrienskies.core.impl.shadow.ho_1;
import org.valkyrienskies.core.impl.shadow.io_1;
import org.valkyrienskies.core.impl.shadow.iz_1;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.iQ
 */
public final class iq_0<E>
extends io_1<E>
implements ez_1<E> {
    private static final long a = -2218010673611160319L;

    public static <E> iq_0<E> a(List<E> list) {
        return new iq_0<E>(list);
    }

    private iq_0(List<E> list) {
        super(list);
    }

    @Override
    public final boolean add(E object) {
        throw new UnsupportedOperationException("List is fixed size");
    }

    @Override
    public final void add(int index, E object) {
        throw new UnsupportedOperationException("List is fixed size");
    }

    @Override
    public final boolean addAll(Collection<? extends E> coll) {
        throw new UnsupportedOperationException("List is fixed size");
    }

    @Override
    public final boolean addAll(int index, Collection<? extends E> coll) {
        throw new UnsupportedOperationException("List is fixed size");
    }

    @Override
    public final void clear() {
        throw new UnsupportedOperationException("List is fixed size");
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final E get(int index) {
        void var1_1;
        return this.c().get((int)var1_1);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final int indexOf(Object object) {
        void var1_1;
        return this.c().indexOf(var1_1);
    }

    @Override
    public final Iterator<E> iterator() {
        return iz_1.a(this.c().iterator());
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final int lastIndexOf(Object object) {
        void var1_1;
        return this.c().lastIndexOf(var1_1);
    }

    @Override
    public final ListIterator<E> listIterator() {
        iq_0 iq_02 = this;
        return new a(iq_02, iq_02.c().listIterator(0));
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final ListIterator<E> listIterator(int index) {
        void var1_1;
        iq_0 iq_02 = this;
        return new a(iq_02, iq_02.c().listIterator((int)var1_1));
    }

    @Override
    public final E remove(int index) {
        throw new UnsupportedOperationException("List is fixed size");
    }

    @Override
    public final boolean remove(Object object) {
        throw new UnsupportedOperationException("List is fixed size");
    }

    @Override
    public final boolean removeAll(Collection<?> coll) {
        throw new UnsupportedOperationException("List is fixed size");
    }

    @Override
    public final boolean retainAll(Collection<?> coll) {
        throw new UnsupportedOperationException("List is fixed size");
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final E set(int index, E object) {
        void var2_2;
        void var1_1;
        return this.c().set((int)var1_1, var2_2);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final List<E> subList(int fromIndex, int toIndex) {
        void var2_3;
        void var1_1;
        List list = this.c().subList((int)var1_1, (int)var2_3);
        return new iq_0(list);
    }

    @Override
    public final boolean a() {
        return true;
    }

    @Override
    public final int b() {
        return this.size();
    }

    final class a
    extends ho_1<E> {
        private /* synthetic */ iq_0 a;

        protected a(iq_0 iq_02, ListIterator<E> listIterator) {
            this.a = iq_02;
            super(listIterator);
        }

        @Override
        public final void remove() {
            throw new UnsupportedOperationException("List is fixed size");
        }

        @Override
        public final void add(Object object) {
            throw new UnsupportedOperationException("List is fixed size");
        }
    }
}

