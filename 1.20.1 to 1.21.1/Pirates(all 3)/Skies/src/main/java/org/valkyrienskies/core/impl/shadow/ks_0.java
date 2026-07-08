/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.valkyrienskies.core.impl.shadow.fd_2;
import org.valkyrienskies.core.impl.shadow.hw_1;
import org.valkyrienskies.core.impl.shadow.if_2;
import org.valkyrienskies.core.impl.shadow.iy_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.ks
 */
public final class ks_0<E>
implements Serializable,
Set<E> {
    private static final long a = 5185069727540378940L;
    private a<E> b;
    private final List<Set<E>> c = new ArrayList<Set<E>>();

    public ks_0() {
    }

    private ks_0(Set<E> set) {
        this.a(set);
    }

    private ks_0(Set<E> ... object) {
        Set<E>[] setArray = object;
        object = this;
        for (Set<E> set : setArray) {
            ((ks_0)object).a(set);
        }
    }

    @Override
    public final int size() {
        int n2 = 0;
        for (Set<E> set : this.c) {
            n2 += set.size();
        }
        return n2;
    }

    @Override
    public final boolean isEmpty() {
        for (Set<E> set : this.c) {
            if (set.isEmpty()) continue;
            return false;
        }
        return true;
    }

    @Override
    public final boolean contains(Object obj) {
        for (Set<E> set : this.c) {
            if (!set.contains(obj)) continue;
            return true;
        }
        return false;
    }

    @Override
    public final Iterator<E> iterator() {
        if (this.c.isEmpty()) {
            return hw_1.b();
        }
        if_2<E> if_22 = new if_2<E>();
        for (Set<E> set : this.c) {
            if_22.a(set.iterator());
        }
        return if_22;
    }

    @Override
    public final Object[] toArray() {
        Object[] objectArray = new Object[this.size()];
        int n2 = 0;
        Iterator<E> iterator2 = this.iterator();
        while (iterator2.hasNext()) {
            objectArray[n2] = iterator2.next();
            ++n2;
        }
        return objectArray;
    }

    @Override
    public final <T> T[] toArray(T[] array) {
        Object[] objectArray;
        int n2 = this.size();
        objectArray = array.length >= n2 ? array : (Object[])Array.newInstance(objectArray.getClass().getComponentType(), n2);
        int n3 = 0;
        for (Collection collection : this.c) {
            for (Object e2 : collection) {
                objectArray[n3++] = e2;
            }
        }
        if (objectArray.length > n2) {
            objectArray[n2] = null;
        }
        return objectArray;
    }

    @Override
    public final boolean add(E obj) {
        if (this.b == null) {
            throw new UnsupportedOperationException("add() is not supported on CompositeSet without a SetMutator strategy");
        }
        return this.b.a();
    }

    @Override
    public final boolean remove(Object obj) {
        ks_0 ks_02 = this;
        for (Set set : iy_0.a(ks_02.c)) {
            if (!set.contains(obj)) continue;
            return set.remove(obj);
        }
        return false;
    }

    @Override
    public final boolean containsAll(Collection<?> coll) {
        for (Object obj : coll) {
            if (this.contains(obj)) continue;
            return false;
        }
        return true;
    }

    @Override
    public final boolean addAll(Collection<? extends E> coll) {
        if (this.b == null) {
            throw new UnsupportedOperationException("addAll() is not supported on CompositeSet without a SetMutator strategy");
        }
        return this.b.b();
    }

    @Override
    public final boolean removeAll(Collection<?> coll) {
        if (coll.size() == 0) {
            return false;
        }
        boolean bl = false;
        for (Collection collection : this.c) {
            bl |= collection.removeAll(coll);
        }
        return bl;
    }

    @Override
    public final boolean retainAll(Collection<?> coll) {
        boolean bl = false;
        for (Collection collection : this.c) {
            bl |= collection.retainAll(coll);
        }
        return bl;
    }

    @Override
    public final void clear() {
        for (Collection collection : this.c) {
            collection.clear();
        }
    }

    private void a(a<E> a2) {
        this.b = a2;
    }

    public final synchronized void a(Set<E> set) {
        ks_0 ks_02 = this;
        for (Set set2 : iy_0.a(ks_02.c)) {
            ks_0 ks_03 = fd_2.a(set2, set);
            if (ks_03.size() <= 0) continue;
            if (this.b == null) {
                throw new UnsupportedOperationException("Collision adding composited set with no SetMutator set");
            }
            ks_03 = this;
            a<E> cfr_ignored_0 = ks_03.b;
            if (fd_2.a(set2, set).size() <= 0) continue;
            throw new IllegalArgumentException("Attempt to add illegal entry unresolved by SetMutator.resolveCollision()");
        }
        this.c.add(set);
    }

    private void a(Set<E> set, Set<E> set2) {
        this.a(set);
        this.a(set2);
    }

    private void a(Set<E> ... setArray) {
        for (Set<E> set : setArray) {
            this.a(set);
        }
    }

    private void b(Set<E> set) {
        this.c.remove(set);
    }

    private Set<E> a() {
        return new HashSet(this);
    }

    private List<Set<E>> b() {
        return iy_0.a(this.c);
    }

    private a<E> c() {
        return this.b;
    }

    @Override
    public final boolean equals(Object obj) {
        if (obj instanceof Set) {
            Set set;
            return (set = (Set)set).size() == this.size() && set.containsAll(this);
        }
        return false;
    }

    @Override
    public final int hashCode() {
        int n2 = 0;
        for (E e2 : this) {
            n2 += e2 == null ? 0 : e2.hashCode();
        }
        return n2;
    }

    public static interface a<E>
    extends Serializable {
        public boolean a();

        public boolean b();

        public void c();
    }
}

