/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.valkyrienskies.core.impl.shadow.iU
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import org.valkyrienskies.core.impl.shadow.ff_1;
import org.valkyrienskies.core.impl.shadow.gy_2;
import org.valkyrienskies.core.impl.shadow.ho_1;
import org.valkyrienskies.core.impl.shadow.iU;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.iU
 */
public final class iu_0<E>
extends gy_2<E>
implements List<E> {
    private static final long b = -5722039223898659102L;

    public static <T> iu_0<T> a(List<T> list, ff_1<? super T> ff_12) {
        return new iu_0<T>(list, ff_12);
    }

    private iu_0(List<E> list, ff_1<? super E> ff_12) {
        super(list, ff_12);
    }

    private List<E> a() {
        return (List)super.f();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final boolean equals(Object object) {
        void var1_1;
        iu_0 iu_02;
        return object == this || ((List)super.f()).equals(var1_1);
    }

    @Override
    public final int hashCode() {
        iu_0 iu_02 = this;
        return ((List)super.f()).hashCode();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final E get(int index) {
        void var1_1;
        iu_0 iu_02 = this;
        return ((List)super.f()).get((int)var1_1);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final int indexOf(Object object) {
        void var1_1;
        iu_0 iu_02 = this;
        return ((List)super.f()).indexOf(var1_1);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final int lastIndexOf(Object object) {
        void var1_1;
        iu_0 iu_02 = this;
        return ((List)super.f()).lastIndexOf(var1_1);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final E remove(int index) {
        void var1_1;
        iu_0 iu_02 = this;
        return ((List)super.f()).remove((int)var1_1);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final void add(int index, E object) {
        void var2_2;
        void var1_1;
        this.b(object);
        iu_0 iu_02 = this;
        ((List)super.f()).add((int)var1_1, var2_2);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final boolean addAll(int index, Collection<? extends E> coll) {
        void var2_2;
        void var1_1;
        for (E e2 : coll) {
            this.b(e2);
        }
        iu_0 iu_02 = this;
        return ((List)super.f()).addAll((int)var1_1, var2_2);
    }

    @Override
    public final ListIterator<E> listIterator() {
        return this.listIterator(0);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final ListIterator<E> listIterator(int i2) {
        void var1_1;
        iu_0 iu_02 = this;
        return new a(iu_02, ((List)super.f()).listIterator((int)var1_1));
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final E set(int index, E object) {
        void var2_2;
        void var1_1;
        this.b(object);
        iu_0 iu_02 = this;
        return ((List)super.f()).set((int)var1_1, var2_2);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final List<E> subList(int fromIndex, int toIndex) {
        void var2_3;
        void var1_1;
        iu_0 iu_02 = this;
        List list = ((List)super.f()).subList((int)var1_1, (int)var2_3);
        return new iu_0(list, this.a);
    }

    static /* synthetic */ void a(iu_0 iu_02, Object object) {
        iu_02.b(object);
    }

    static /* synthetic */ void b(iu_0 iu_02, Object object) {
        iu_02.b(object);
    }

    protected final class a
    extends ho_1<E> {
        private /* synthetic */ iu_0 a;

        protected a(iu_0 iu_02, ListIterator<E> listIterator) {
            this.a = iu_02;
            super(listIterator);
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public final void add(E object) {
            void var1_1;
            iU.a((iu_0)this.a, object);
            this.a().add(var1_1);
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public final void set(E object) {
            void var1_1;
            iU.b((iu_0)this.a, object);
            this.a().set(var1_1);
        }
    }
}

