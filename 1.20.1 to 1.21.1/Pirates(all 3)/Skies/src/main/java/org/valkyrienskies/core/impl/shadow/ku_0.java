/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.ku
 */
public final class ku_0<E, V>
implements Serializable,
Set<E> {
    private static final long a = 6723912213766056587L;
    private final Map<E, ? super V> b;
    private final V c;

    private static <E, V> ku_0<E, V> a(Map<E, ? super V> map2) {
        Map<E, ? super V> map3 = map2;
        map2 = null;
        map2 = map3;
        return new ku_0<E, Object>(map2, null);
    }

    private static <E, V> ku_0<E, V> a(Map<E, ? super V> map2, V v) {
        return new ku_0<E, Object>(map2, null);
    }

    private ku_0(Map<E, ? super V> map2, V v) {
        if (map2 == null) {
            throw new NullPointerException("The map must not be null");
        }
        this.b = map2;
        this.c = v;
    }

    @Override
    public final int size() {
        return this.b.size();
    }

    @Override
    public final boolean isEmpty() {
        return this.b.isEmpty();
    }

    @Override
    public final Iterator<E> iterator() {
        return this.b.keySet().iterator();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final boolean contains(Object obj) {
        void var1_1;
        return this.b.containsKey(var1_1);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final boolean containsAll(Collection<?> coll) {
        void var1_1;
        return this.b.keySet().containsAll((Collection<?>)var1_1);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final boolean add(E obj) {
        void var1_1;
        int n2 = this.b.size();
        this.b.put(var1_1, this.c);
        return this.b.size() != n2;
    }

    @Override
    public final boolean addAll(Collection<? extends E> coll) {
        Iterator iterator2;
        int n2 = this.b.size();
        iterator2 = iterator2.iterator();
        while (iterator2.hasNext()) {
            Object e2 = iterator2.next();
            this.b.put(e2, this.c);
        }
        return this.b.size() != n2;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final boolean remove(Object obj) {
        void var1_1;
        int n2 = this.b.size();
        this.b.remove(var1_1);
        return this.b.size() != n2;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final boolean removeAll(Collection<?> coll) {
        void var1_1;
        return this.b.keySet().removeAll((Collection<?>)var1_1);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final boolean retainAll(Collection<?> coll) {
        void var1_1;
        return this.b.keySet().retainAll((Collection<?>)var1_1);
    }

    @Override
    public final void clear() {
        this.b.clear();
    }

    @Override
    public final Object[] toArray() {
        return this.b.keySet().toArray();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final <T> T[] toArray(T[] array) {
        void var1_1;
        return this.b.keySet().toArray((T[])var1_1);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final boolean equals(Object obj) {
        void var1_1;
        return this.b.keySet().equals(var1_1);
    }

    @Override
    public final int hashCode() {
        return this.b.keySet().hashCode();
    }
}

