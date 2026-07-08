/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import org.valkyrienskies.core.impl.shadow.gv_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.iN
 */
public abstract class in_1<E>
extends gv_2<E>
implements List<E> {
    private static final long a = 4500739654952315623L;

    protected in_1() {
    }

    protected in_1(List<E> list) {
        super(list);
    }

    protected final List<E> c() {
        return (List)super.f();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public boolean equals(Object object) {
        void var1_1;
        in_1 in_12;
        return object == this || ((List)super.f()).equals(var1_1);
    }

    @Override
    public int hashCode() {
        in_1 in_12 = this;
        return ((List)super.f()).hashCode();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public void add(int index, E object) {
        void var2_2;
        void var1_1;
        in_1 in_12 = this;
        ((List)super.f()).add((int)var1_1, var2_2);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public boolean addAll(int index, Collection<? extends E> coll) {
        void var2_2;
        void var1_1;
        in_1 in_12 = this;
        return ((List)super.f()).addAll((int)var1_1, var2_2);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public E get(int index) {
        void var1_1;
        in_1 in_12 = this;
        return ((List)super.f()).get((int)var1_1);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public int indexOf(Object object) {
        void var1_1;
        in_1 in_12 = this;
        return ((List)super.f()).indexOf(var1_1);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public int lastIndexOf(Object object) {
        void var1_1;
        in_1 in_12 = this;
        return ((List)super.f()).lastIndexOf(var1_1);
    }

    @Override
    public ListIterator<E> listIterator() {
        in_1 in_12 = this;
        return ((List)super.f()).listIterator();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public ListIterator<E> listIterator(int index) {
        void var1_1;
        in_1 in_12 = this;
        return ((List)super.f()).listIterator((int)var1_1);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public E remove(int index) {
        void var1_1;
        in_1 in_12 = this;
        return ((List)super.f()).remove((int)var1_1);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public E set(int index, E object) {
        void var2_2;
        void var1_1;
        in_1 in_12 = this;
        return ((List)super.f()).set((int)var1_1, var2_2);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        void var2_2;
        void var1_1;
        in_1 in_12 = this;
        return ((List)super.f()).subList((int)var1_1, (int)var2_2);
    }
}

