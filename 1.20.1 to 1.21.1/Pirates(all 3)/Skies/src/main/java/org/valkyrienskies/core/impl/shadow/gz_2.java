/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.gz
 */
public class gz_2<E>
implements Serializable,
Collection<E> {
    private static final long b = 2412805092710877986L;
    private final Collection<E> c;
    protected final Object a;

    public static <T> gz_2<T> a(Collection<T> collection) {
        return new gz_2<T>(collection);
    }

    public gz_2(Collection<E> collection) {
        if (collection == null) {
            throw new NullPointerException("Collection must not be null.");
        }
        this.c = collection;
        this.a = this;
    }

    public gz_2(Collection<E> collection, Object object) {
        if (collection == null) {
            throw new NullPointerException("Collection must not be null.");
        }
        if (object == null) {
            throw new NullPointerException("Lock must not be null.");
        }
        this.c = collection;
        this.a = object;
    }

    public Collection<E> e() {
        return this.c;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public boolean add(E object) {
        Object object2 = this.a;
        synchronized (object2) {
            void var1_1;
            return this.e().add(var1_1);
        }
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public boolean addAll(Collection<? extends E> coll) {
        Object object = this.a;
        synchronized (object) {
            void var1_1;
            return this.e().addAll((Collection<E>)var1_1);
        }
    }

    @Override
    public void clear() {
        Object object = this.a;
        synchronized (object) {
            this.e().clear();
            return;
        }
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public boolean contains(Object object) {
        Object object2 = this.a;
        synchronized (object2) {
            void var1_1;
            return this.e().contains(var1_1);
        }
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public boolean containsAll(Collection<?> coll) {
        Object object = this.a;
        synchronized (object) {
            void var1_1;
            return this.e().containsAll((Collection<?>)var1_1);
        }
    }

    @Override
    public boolean isEmpty() {
        Object object = this.a;
        synchronized (object) {
            return this.e().isEmpty();
        }
    }

    @Override
    public Iterator<E> iterator() {
        return this.e().iterator();
    }

    @Override
    public Object[] toArray() {
        Object object = this.a;
        synchronized (object) {
            return this.e().toArray();
        }
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public <T> T[] toArray(T[] object) {
        Object object2 = this.a;
        synchronized (object2) {
            void var1_1;
            return this.e().toArray((T[])var1_1);
        }
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public boolean remove(Object object) {
        Object object2 = this.a;
        synchronized (object2) {
            void var1_1;
            return this.e().remove(var1_1);
        }
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public boolean removeAll(Collection<?> coll) {
        Object object = this.a;
        synchronized (object) {
            void var1_1;
            return this.e().removeAll((Collection<?>)var1_1);
        }
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public boolean retainAll(Collection<?> coll) {
        Object object = this.a;
        synchronized (object) {
            void var1_1;
            return this.e().retainAll((Collection<?>)var1_1);
        }
    }

    @Override
    public int size() {
        Object object = this.a;
        synchronized (object) {
            return this.e().size();
        }
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public boolean equals(Object object) {
        Object object2 = this.a;
        synchronized (object2) {
            void var1_1;
            if (object == this) {
                return true;
            }
            return object == this || this.e().equals(var1_1);
        }
    }

    @Override
    public int hashCode() {
        Object object = this.a;
        synchronized (object) {
            return this.e().hashCode();
        }
    }

    public String toString() {
        Object object = this.a;
        synchronized (object) {
            return this.e().toString();
        }
    }
}

