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
import org.valkyrienskies.core.impl.shadow.gv_2;
import org.valkyrienskies.core.impl.shadow.hn_1;
import org.valkyrienskies.core.impl.shadow.ho_1;
import org.valkyrienskies.core.impl.shadow.in_1;
import org.valkyrienskies.core.impl.shadow.io_1;
import org.valkyrienskies.core.impl.shadow.iy_0;
import org.valkyrienskies.core.impl.shadow.kC;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.iV
 */
public final class iv_0<E>
extends io_1<E> {
    private static final long a = 7196982186153478694L;
    private final Set<E> b;

    private static <E> iv_0<E> a(List<E> list) {
        if (list == null) {
            throw new NullPointerException("List must not be null");
        }
        if (list.isEmpty()) {
            return new iv_0<E>(list, new HashSet());
        }
        ArrayList<E> arrayList = new ArrayList<E>(list);
        list.clear();
        list = new iv_0<E>(list, new HashSet());
        ((gv_2)((Object)list)).addAll(arrayList);
        return list;
    }

    private iv_0(List<E> list, Set<E> set) {
        super(list);
        if (set == null) {
            throw new NullPointerException("Set must not be null");
        }
        this.b = set;
    }

    private Set<E> a() {
        return kC.a(this.b);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final boolean add(E object) {
        void var1_1;
        int n2 = this.size();
        iv_0 iv_02 = this;
        ((in_1)iv_02).add(iv_02.size(), var1_1);
        return n2 != this.size();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final void add(int index, E object) {
        if (!this.b.contains(object)) {
            void var2_2;
            void var1_1;
            super.add((int)var1_1, object);
            this.b.add(var2_2);
        }
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final boolean addAll(Collection<? extends E> coll) {
        void var1_1;
        iv_0 iv_02 = this;
        return ((in_1)iv_02).addAll(iv_02.size(), var1_1);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final boolean addAll(int index, Collection<? extends E> coll) {
        void var1_1;
        Iterator iterator2;
        ArrayList arrayList = new ArrayList();
        iterator2 = iterator2.iterator();
        while (iterator2.hasNext()) {
            Object e2 = iterator2.next();
            if (!this.b.add(e2)) continue;
            arrayList.add(e2);
        }
        return super.addAll((int)var1_1, arrayList);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final E set(int index, E object) {
        void var2_2;
        void var1_1;
        int n2 = this.indexOf(object);
        E e2 = super.set(index, object);
        if (n2 != -1 && n2 != var1_1) {
            super.remove(n2);
        }
        this.b.remove(e2);
        this.b.add(var2_2);
        return e2;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final boolean remove(Object object) {
        boolean bl = this.b.remove(object);
        if (bl) {
            void var1_1;
            super.remove(var1_1);
        }
        return bl;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final E remove(int index) {
        void var1_1;
        Object e2 = super.remove((int)var1_1);
        this.b.remove(e2);
        return e2;
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
        boolean bl = this.b.retainAll((Collection<?>)var1_1);
        if (!bl) {
            return false;
        }
        if (this.b.size() == 0) {
            super.clear();
        } else {
            iv_0 iv_02 = this;
            super.retainAll(iv_02.b);
        }
        return bl;
    }

    @Override
    public final void clear() {
        super.clear();
        this.b.clear();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final boolean contains(Object object) {
        void var1_1;
        return this.b.contains(var1_1);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final boolean containsAll(Collection<?> coll) {
        void var1_1;
        return this.b.containsAll((Collection<?>)var1_1);
    }

    @Override
    public final Iterator<E> iterator() {
        return new a(super.iterator(), this.b);
    }

    @Override
    public final ListIterator<E> listIterator() {
        return new b(super.listIterator(), this.b);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final ListIterator<E> listIterator(int index) {
        void var1_1;
        return new b(super.listIterator((int)var1_1), this.b);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final List<E> subList(int fromIndex, int toIndex) {
        void var2_3;
        void var1_1;
        List list = super.subList((int)var1_1, (int)var2_3);
        Set<E> set = iv_0.a(this.b, list);
        list = new iv_0(list, set);
        return iy_0.a(list);
    }

    private static Set<E> a(Set<E> hashSet, List<E> list) {
        if (hashSet.getClass().equals(HashSet.class)) {
            hashSet = new HashSet(list.size());
        } else {
            try {
                hashSet = (HashSet)hashSet.getClass().newInstance();
            }
            catch (InstantiationException instantiationException) {
                hashSet = new HashSet();
            }
            catch (IllegalAccessException illegalAccessException) {
                hashSet = new HashSet();
            }
        }
        hashSet.addAll(list);
        return hashSet;
    }

    static final class b<E>
    extends ho_1<E> {
        private final Set<E> a;
        private E b = null;

        protected b(ListIterator<E> listIterator, Set<E> set) {
            super(listIterator);
            this.a = set;
        }

        @Override
        public final E next() {
            this.b = super.next();
            return this.b;
        }

        @Override
        public final E previous() {
            this.b = super.previous();
            return this.b;
        }

        @Override
        public final void remove() {
            super.remove();
            this.a.remove(this.b);
            this.b = null;
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public final void add(E object) {
            if (!this.a.contains(object)) {
                void var1_1;
                super.add(object);
                this.a.add(var1_1);
            }
        }

        @Override
        public final void set(E object) {
            throw new UnsupportedOperationException("ListIterator does not support set");
        }
    }

    static final class a<E>
    extends hn_1<E> {
        private final Set<E> a;
        private E b = null;

        protected a(Iterator<E> iterator2, Set<E> set) {
            super(iterator2);
            this.a = set;
        }

        @Override
        public final E next() {
            this.b = super.next();
            return this.b;
        }

        @Override
        public final void remove() {
            super.remove();
            this.a.remove(this.b);
            this.b = null;
        }
    }
}

