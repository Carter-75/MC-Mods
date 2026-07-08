/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import org.valkyrienskies.core.impl.shadow.fc_1;
import org.valkyrienskies.core.impl.shadow.fd_2;
import org.valkyrienskies.core.impl.shadow.gv_2;
import org.valkyrienskies.core.impl.shadow.hj_1;
import org.valkyrienskies.core.impl.shadow.hn_1;
import org.valkyrienskies.core.impl.shadow.iy_0;
import org.valkyrienskies.core.impl.shadow.kp_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.kt
 */
public final class kt_0<E>
extends kp_0<E> {
    private static final long a = -228664372470420141L;
    private final List<E> b;

    private static <E> kt_0<E> a(Set<E> set, List<E> list) {
        if (set == null) {
            throw new NullPointerException("Set must not be null");
        }
        if (list == null) {
            throw new NullPointerException("List must not be null");
        }
        if (set.size() > 0 || list.size() > 0) {
            throw new IllegalArgumentException("Set and List must be empty");
        }
        return new kt_0<E>(set, list);
    }

    public static <E> kt_0<E> a(Set<E> set) {
        return new kt_0<E>(set);
    }

    private static <E> kt_0<E> a(List<E> list) {
        if (list == null) {
            throw new NullPointerException("List must not be null");
        }
        fd_2.a(list, new hj_1());
        HashSet<E> hashSet = new HashSet<E>(list);
        return new kt_0<E>(hashSet, list);
    }

    public kt_0() {
        super(new HashSet());
        this.b = new ArrayList();
    }

    private kt_0(Set<E> set) {
        super(set);
        this.b = new ArrayList<E>(set);
    }

    private kt_0(Set<E> set, List<E> list) {
        super(set);
        if (list == null) {
            throw new NullPointerException("List must not be null");
        }
        this.b = list;
    }

    private List<E> a() {
        return iy_0.a(this.b);
    }

    @Override
    public final void clear() {
        this.c().clear();
        this.b.clear();
    }

    private fc_1<E> b() {
        return new a(this.b.listIterator(), this.c(), 0);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final boolean add(E object) {
        if (this.c().add(object)) {
            void var1_1;
            this.b.add(var1_1);
            return true;
        }
        return false;
    }

    @Override
    public final boolean addAll(Collection<? extends E> coll) {
        Iterator iterator2;
        boolean bl = false;
        iterator2 = iterator2.iterator();
        while (iterator2.hasNext()) {
            Object e2 = iterator2.next();
            bl |= ((gv_2)this).add(e2);
        }
        return bl;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final boolean remove(Object object) {
        boolean bl = this.c().remove(object);
        if (bl) {
            void var1_1;
            this.b.remove(var1_1);
        }
        return bl;
    }

    @Override
    public final boolean removeAll(Collection<?> coll) {
        Iterator iterator2;
        boolean bl = false;
        iterator2 = iterator2.iterator();
        while (iterator2.hasNext()) {
            Object e2 = iterator2.next();
            bl |= ((gv_2)this).remove(e2);
        }
        return bl;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final boolean retainAll(Collection<?> coll) {
        void var1_1;
        boolean bl = this.c().retainAll((Collection<?>)var1_1);
        if (!bl) {
            return false;
        }
        if (this.c().size() == 0) {
            this.b.clear();
        } else {
            Iterator<E> iterator2 = this.b.iterator();
            while (iterator2.hasNext()) {
                if (this.c().contains(iterator2.next())) continue;
                iterator2.remove();
            }
        }
        return bl;
    }

    @Override
    public final Object[] toArray() {
        return this.b.toArray();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final <T> T[] toArray(T[] a2) {
        void var1_1;
        return this.b.toArray((T[])var1_1);
    }

    private E a(int n2) {
        return this.b.get(n2);
    }

    private int a(Object object) {
        return this.b.indexOf(object);
    }

    private void a(int n2, E e2) {
        if (!this.contains(e2)) {
            this.c().add(e2);
            this.b.add(n2, e2);
        }
    }

    private boolean a(int n2, Collection<? extends E> object) {
        boolean bl = false;
        ArrayList arrayList = new ArrayList();
        object = object.iterator();
        while (object.hasNext()) {
            Object e2 = object.next();
            if (this.contains(e2)) continue;
            this.c().add(e2);
            arrayList.add(e2);
            bl = true;
        }
        if (bl) {
            this.b.addAll(n2, arrayList);
        }
        return bl;
    }

    private E b(int n2) {
        E e2 = this.b.remove(n2);
        ((gv_2)this).remove(e2);
        return e2;
    }

    @Override
    public final String toString() {
        return this.b.toString();
    }

    @Override
    public final /* synthetic */ Iterator iterator() {
        kt_0 kt_02 = this;
        return new a(kt_02.b.listIterator(), kt_02.c(), 0);
    }

    static final class a<E>
    extends hn_1<E>
    implements fc_1<E> {
        private final Collection<E> a;
        private E b;

        private a(ListIterator<E> listIterator, Collection<E> collection) {
            super(listIterator);
            this.a = collection;
        }

        @Override
        public final E next() {
            this.b = this.a().next();
            return this.b;
        }

        @Override
        public final void remove() {
            this.a.remove(this.b);
            this.a().remove();
            this.b = null;
        }

        @Override
        public final boolean hasPrevious() {
            return ((ListIterator)this.a()).hasPrevious();
        }

        @Override
        public final E previous() {
            this.b = ((ListIterator)this.a()).previous();
            return this.b;
        }

        /* synthetic */ a(ListIterator listIterator, Collection collection, byte by) {
            this(listIterator, collection);
        }
    }
}

