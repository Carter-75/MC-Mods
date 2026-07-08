/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import org.valkyrienskies.core.impl.shadow.fs_2;
import org.valkyrienskies.core.impl.shadow.ft_2;
import org.valkyrienskies.core.impl.shadow.jK;

public abstract class jJ<K, V>
extends jK<K, V>
implements ft_2<K, V> {
    protected jJ() {
    }

    protected jJ(Map<K, ? extends List<V>> map2) {
        super(map2);
    }

    @Override
    protected final Map<K, List<V>> j() {
        return super.j();
    }

    protected abstract List<V> k();

    @Override
    public final List<V> a(K k2) {
        return this.h(k2);
    }

    private List<V> h(K k2) {
        return new b(this, k2);
    }

    @Override
    public final List<V> b(Object object) {
        jJ jJ2 = this;
        return fs_2.a((List)super.j().remove(object));
    }

    @Override
    public final /* synthetic */ Collection f(Object object) {
        return this.b(object);
    }

    @Override
    final /* synthetic */ Collection g(Object object) {
        return this.h(object);
    }

    @Override
    public final /* synthetic */ Collection e(Object object) {
        Object object2 = object;
        object = this;
        return object.h(object2);
    }

    @Override
    protected /* synthetic */ Collection l() {
        return this.k();
    }

    final class a
    implements ListIterator<V> {
        private final K a;
        private List<V> b;
        private ListIterator<V> c;
        private /* synthetic */ jJ d;

        public a(jJ jJ2, K k2) {
            this.d = jJ2;
            this.a = k2;
            this.b = fs_2.a(jJ2.j().get(k2));
            this.c = this.b.listIterator();
        }

        public a(jJ jJ2, K k2, int n2) {
            this.d = jJ2;
            this.a = k2;
            this.b = fs_2.a(jJ2.j().get(k2));
            this.c = this.b.listIterator(n2);
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public final void add(V value) {
            void var1_1;
            if (this.d.j().get(this.a) == null) {
                List list = this.d.k();
                this.d.j().put(this.a, list);
                this.b = list;
                this.c = list.listIterator();
            }
            this.c.add(var1_1);
        }

        @Override
        public final boolean hasNext() {
            return this.c.hasNext();
        }

        @Override
        public final boolean hasPrevious() {
            return this.c.hasPrevious();
        }

        @Override
        public final V next() {
            return this.c.next();
        }

        @Override
        public final int nextIndex() {
            return this.c.nextIndex();
        }

        @Override
        public final V previous() {
            return this.c.previous();
        }

        @Override
        public final int previousIndex() {
            return this.c.previousIndex();
        }

        @Override
        public final void remove() {
            this.c.remove();
            if (this.b.isEmpty()) {
                this.d.j().remove(this.a);
            }
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public final void set(V value) {
            void var1_1;
            this.c.set(var1_1);
        }
    }

    final class b
    extends jK.h
    implements List<V> {
        private /* synthetic */ jJ b;

        public b(jJ jJ2, K k2) {
            this.b = jJ2;
            super(jJ2, k2);
        }

        private List<V> b() {
            return this.b.j().get(this.a);
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public final void add(int index, V value) {
            void var2_2;
            void var1_1;
            List list = this.b();
            if (list == null) {
                list = this.b.k();
                this.b.j().put(this.a, list);
            }
            list.add((int)var1_1, var2_2);
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public final boolean addAll(int index, Collection<? extends V> c2) {
            void var2_2;
            boolean bl;
            List list = this.b();
            if (list == null) {
                list = this.b.k();
                bl = list.addAll(index, c2);
                if (bl) {
                    this.b.j().put(this.a, list);
                }
                return bl;
            }
            return list.addAll(bl ? 1 : 0, (Collection)var2_2);
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public final V get(int index) {
            void var1_1;
            List list = fs_2.a(this.b());
            return list.get((int)var1_1);
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public final int indexOf(Object o) {
            void var1_1;
            List list = fs_2.a(this.b());
            return list.indexOf(var1_1);
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public final int lastIndexOf(Object o) {
            void var1_1;
            List list = fs_2.a(this.b());
            return list.lastIndexOf(var1_1);
        }

        @Override
        public final ListIterator<V> listIterator() {
            return new a(this.b, this.a);
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public final ListIterator<V> listIterator(int index) {
            void var1_1;
            return new a(this.b, this.a, (int)var1_1);
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public final V remove(int index) {
            void var1_1;
            List list = fs_2.a(this.b());
            Object v = list.remove((int)var1_1);
            if (list.isEmpty()) {
                this.b.b(this.a);
            }
            return v;
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public final V set(int index, V value) {
            void var2_2;
            void var1_1;
            List list = fs_2.a(this.b());
            return list.set((int)var1_1, var2_2);
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public final List<V> subList(int fromIndex, int toIndex) {
            void var2_2;
            void var1_1;
            List list = fs_2.a(this.b());
            return list.subList((int)var1_1, (int)var2_2);
        }

        @Override
        public final boolean equals(Object other) {
            Object object;
            Object object2 = this.b();
            if (object2 == null) {
                return Collections.emptyList().equals(other);
            }
            if (!(other instanceof List)) {
                return false;
            }
            object = (List)object;
            List list = object2;
            object2 = object;
            object = list;
            if (list == object2) {
                return true;
            }
            if (object == null || object2 == null || object.size() != object2.size()) {
                return false;
            }
            object = object.iterator();
            object2 = object2.iterator();
            while (object.hasNext() && object2.hasNext()) {
                Object e2 = object.next();
                Object e3 = object2.next();
                if (e2 != null ? e2.equals(e3) : e3 == null) continue;
                return false;
            }
            return !object.hasNext() && !object2.hasNext();
        }

        @Override
        public final int hashCode() {
            List list = this.b();
            Object object = list;
            object = list;
            if (list == null) {
                return 0;
            }
            int n2 = 1;
            object = object.iterator();
            while (object.hasNext()) {
                Object e2 = object.next();
                n2 = n2 * 31 + (e2 == null ? 0 : e2.hashCode());
            }
            return n2;
        }

        protected final /* synthetic */ Collection a() {
            return this.b();
        }
    }
}

