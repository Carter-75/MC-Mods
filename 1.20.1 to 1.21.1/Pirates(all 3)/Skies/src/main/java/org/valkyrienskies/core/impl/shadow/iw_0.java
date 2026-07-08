/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.valkyrienskies.core.impl.shadow.iW
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import org.valkyrienskies.core.impl.shadow.fq_1;
import org.valkyrienskies.core.impl.shadow.ga_1;
import org.valkyrienskies.core.impl.shadow.ho_1;
import org.valkyrienskies.core.impl.shadow.iW;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.iW
 */
public final class iw_0<E>
extends ga_1<E>
implements List<E> {
    private static final long b = 1077193035000013141L;

    public static <E> iw_0<E> a(List<E> list, fq_1<? super E, ? extends E> fq_12) {
        return new iw_0<E>(list, fq_12);
    }

    private static <E> iw_0<E> b(List<E> objectArray, fq_1<? super E, ? extends E> fq_12) {
        iw_0<E> iw_02 = new iw_0<E>(objectArray, fq_12);
        if (objectArray.size() > 0) {
            Object[] objectArray2 = objectArray.toArray();
            objectArray.clear();
            objectArray = objectArray2;
            int n2 = objectArray2.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                Object object = objectArray[i2];
                iw_02.f().add(fq_12.a(object));
            }
        }
        return iw_02;
    }

    private iw_0(List<E> list, fq_1<? super E, ? extends E> fq_12) {
        super(list, fq_12);
    }

    private List<E> a() {
        return (List)this.f();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final boolean equals(Object object) {
        void var1_1;
        return object == this || this.f().equals(var1_1);
    }

    @Override
    public final int hashCode() {
        return this.f().hashCode();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final E get(int index) {
        void var1_1;
        iw_0 iw_02 = this;
        return ((List)iw_02.f()).get((int)var1_1);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final int indexOf(Object object) {
        void var1_1;
        iw_0 iw_02 = this;
        return ((List)iw_02.f()).indexOf(var1_1);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final int lastIndexOf(Object object) {
        void var1_1;
        iw_0 iw_02 = this;
        return ((List)iw_02.f()).lastIndexOf(var1_1);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final E remove(int index) {
        void var1_1;
        iw_0 iw_02 = this;
        return ((List)iw_02.f()).remove((int)var1_1);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final void add(int index, E object) {
        void var2_2;
        void var1_1;
        object = this.b(object);
        iw_0 iw_02 = this;
        ((List)iw_02.f()).add((int)var1_1, var2_2);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final boolean addAll(int index, Collection<? extends E> coll) {
        void var2_2;
        void var1_1;
        coll = this.b(coll);
        iw_0 iw_02 = this;
        return ((List)iw_02.f()).addAll((int)var1_1, var2_2);
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
        iw_0 iw_02 = this;
        return new a(iw_02, ((List)iw_02.f()).listIterator((int)var1_1));
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final E set(int index, E object) {
        void var2_2;
        void var1_1;
        object = this.b(object);
        iw_0 iw_02 = this;
        return ((List)iw_02.f()).set((int)var1_1, var2_2);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final List<E> subList(int fromIndex, int toIndex) {
        void var2_3;
        void var1_1;
        iw_0 iw_02 = this;
        List list = ((List)iw_02.f()).subList((int)var1_1, (int)var2_3);
        return new iw_0(list, this.a);
    }

    static /* synthetic */ Object a(iw_0 iw_02, Object object) {
        return iw_02.b(object);
    }

    static /* synthetic */ Object b(iw_0 iw_02, Object object) {
        return iw_02.b(object);
    }

    protected final class a
    extends ho_1<E> {
        private /* synthetic */ iw_0 a;

        protected a(iw_0 iw_02, ListIterator<E> listIterator) {
            this.a = iw_02;
            super(listIterator);
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public final void add(E object) {
            void var1_1;
            object = iW.a((iw_0)this.a, object);
            this.a().add(var1_1);
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public final void set(E object) {
            void var1_1;
            object = iW.b((iw_0)this.a, object);
            this.a().set(var1_1);
        }
    }
}

