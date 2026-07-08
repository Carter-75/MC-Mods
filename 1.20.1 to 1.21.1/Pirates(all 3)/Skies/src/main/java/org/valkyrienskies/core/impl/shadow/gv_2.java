/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.gv
 */
public abstract class gv_2<E>
implements Serializable,
Collection<E> {
    private static final long a = 6249888059822088500L;
    private Collection<E> b;

    public gv_2() {
    }

    public gv_2(Collection<E> collection) {
        if (collection == null) {
            throw new NullPointerException("Collection must not be null.");
        }
        this.b = collection;
    }

    public Collection<E> f() {
        return this.b;
    }

    protected final void a(Collection<E> collection) {
        this.b = collection;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public boolean add(E object) {
        void var1_1;
        return this.f().add(var1_1);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public boolean addAll(Collection<? extends E> coll) {
        void var1_1;
        return this.f().addAll((Collection<E>)var1_1);
    }

    @Override
    public void clear() {
        this.f().clear();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public boolean contains(Object object) {
        void var1_1;
        return this.f().contains(var1_1);
    }

    @Override
    public boolean isEmpty() {
        return this.f().isEmpty();
    }

    @Override
    public Iterator<E> iterator() {
        return this.f().iterator();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public boolean remove(Object object) {
        void var1_1;
        return this.f().remove(var1_1);
    }

    @Override
    public int size() {
        return this.f().size();
    }

    @Override
    public Object[] toArray() {
        return this.f().toArray();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public <T> T[] toArray(T[] object) {
        void var1_1;
        return this.f().toArray((T[])var1_1);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public boolean containsAll(Collection<?> coll) {
        void var1_1;
        return this.f().containsAll((Collection<?>)var1_1);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public boolean removeAll(Collection<?> coll) {
        void var1_1;
        return this.f().removeAll((Collection<?>)var1_1);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public boolean retainAll(Collection<?> coll) {
        void var1_1;
        return this.f().retainAll((Collection<?>)var1_1);
    }

    public String toString() {
        return this.f().toString();
    }
}

