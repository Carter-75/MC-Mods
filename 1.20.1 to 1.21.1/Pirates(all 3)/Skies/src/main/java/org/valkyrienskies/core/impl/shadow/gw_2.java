/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.valkyrienskies.core.impl.shadow.hw_1;
import org.valkyrienskies.core.impl.shadow.if_2;
import org.valkyrienskies.core.impl.shadow.iy_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.gw
 */
public final class gw_2<E>
implements Serializable,
Collection<E> {
    private static final long a = 8417515734108306801L;
    private a<E> b;
    private final List<Collection<E>> c = new ArrayList<Collection<E>>();

    public gw_2() {
    }

    private gw_2(Collection<E> collection) {
        this.a(collection);
    }

    private gw_2(Collection<E> gw_22, Collection<E> collection) {
        Collection<E> collection2 = collection;
        collection = gw_22;
        gw_22 = this;
        gw_22.c.add(collection);
        gw_22.c.add(collection2);
    }

    private gw_2(Collection<E> ... object) {
        Collection<E>[] collectionArray = object;
        object = this;
        object.c.addAll(Arrays.asList(collectionArray));
    }

    @Override
    public final int size() {
        int n2 = 0;
        for (Collection<E> collection : this.c) {
            n2 += collection.size();
        }
        return n2;
    }

    @Override
    public final boolean isEmpty() {
        for (Collection<E> collection : this.c) {
            if (collection.isEmpty()) continue;
            return false;
        }
        return true;
    }

    @Override
    public final boolean contains(Object obj) {
        for (Collection<E> collection : this.c) {
            if (!collection.contains(obj)) continue;
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
        for (Collection<E> collection : this.c) {
            if_22.a(collection.iterator());
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
        for (Collection<E> collection : this.c) {
            for (E e2 : collection) {
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
            throw new UnsupportedOperationException("add() is not supported on CompositeCollection without a CollectionMutator strategy");
        }
        return this.b.a();
    }

    @Override
    public final boolean remove(Object obj) {
        if (this.b == null) {
            throw new UnsupportedOperationException("remove() is not supported on CompositeCollection without a CollectionMutator strategy");
        }
        return this.b.c();
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
            throw new UnsupportedOperationException("addAll() is not supported on CompositeCollection without a CollectionMutator strategy");
        }
        return this.b.b();
    }

    @Override
    public final boolean removeAll(Collection<?> coll) {
        if (coll.size() == 0) {
            return false;
        }
        boolean bl = false;
        for (Collection<E> collection : this.c) {
            bl |= collection.removeAll(coll);
        }
        return bl;
    }

    @Override
    public final boolean retainAll(Collection<?> coll) {
        boolean bl = false;
        for (Collection<E> collection : this.c) {
            bl |= collection.retainAll(coll);
        }
        return bl;
    }

    @Override
    public final void clear() {
        for (Collection<E> collection : this.c) {
            collection.clear();
        }
    }

    private void a(a<E> a2) {
        this.b = a2;
    }

    public final void a(Collection<E> collection) {
        this.c.add(collection);
    }

    private void a(Collection<E> collection, Collection<E> collection2) {
        this.c.add(collection);
        this.c.add(collection2);
    }

    private void a(Collection<E> ... collectionArray) {
        this.c.addAll(Arrays.asList(collectionArray));
    }

    private void b(Collection<E> collection) {
        this.c.remove(collection);
    }

    private Collection<E> a() {
        return new ArrayList(this);
    }

    private List<Collection<E>> b() {
        return iy_0.a(this.c);
    }

    private a<E> c() {
        return this.b;
    }

    public static interface a<E>
    extends Serializable {
        public boolean a();

        public boolean b();

        public boolean c();
    }
}

