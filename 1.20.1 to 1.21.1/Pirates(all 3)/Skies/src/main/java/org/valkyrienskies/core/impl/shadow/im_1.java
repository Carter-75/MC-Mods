/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.valkyrienskies.core.impl.shadow.iM
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import org.valkyrienskies.core.impl.shadow.fc_1;
import org.valkyrienskies.core.impl.shadow.iM;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.iM
 */
public abstract class im_1<E>
implements List<E> {
    transient d<E> a;
    transient int b;
    transient int c;

    protected im_1() {
    }

    protected im_1(Collection<? extends E> collection) {
        this.a();
        this.addAll(collection);
    }

    protected void a() {
        this.a = new d();
    }

    @Override
    public int size() {
        return this.b;
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public E get(int index) {
        void var1_1;
        d<E> d2 = this.a((int)var1_1, false);
        return d2.a();
    }

    @Override
    public Iterator<E> iterator() {
        return this.listIterator();
    }

    @Override
    public ListIterator<E> listIterator() {
        return new a(this, 0);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public ListIterator<E> listIterator(int fromIndex) {
        void var1_1;
        return new a(this, (int)var1_1);
    }

    @Override
    public int indexOf(Object value) {
        int n2 = 0;
        d d2 = this.a.b;
        while (d2 != this.a) {
            if (im_1.a(d2.a(), value)) {
                return n2;
            }
            ++n2;
            d2 = d2.b;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object value) {
        int n2 = this.b - 1;
        d d2 = this.a.a;
        while (d2 != this.a) {
            if (im_1.a(d2.a(), value)) {
                return n2;
            }
            --n2;
            d2 = d2.a;
        }
        return -1;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public boolean contains(Object value) {
        void var1_1;
        return this.indexOf(var1_1) != -1;
    }

    @Override
    public boolean containsAll(Collection<?> coll) {
        for (Object obj : coll) {
            if (this.contains(obj)) continue;
            return false;
        }
        return true;
    }

    @Override
    public Object[] toArray() {
        im_1 im_12 = this;
        return im_12.toArray(new Object[im_12.b]);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public <T> T[] toArray(T[] array) {
        void var1_1;
        if (array.length < this.b) {
            Class<?> clazz = array.getClass().getComponentType();
            array = (Object[])Array.newInstance(clazz, this.b);
        }
        int n2 = 0;
        d d2 = this.a.b;
        while (d2 != this.a) {
            array[n2] = d2.a();
            d2 = d2.b;
            ++n2;
        }
        if (array.length > this.b) {
            array[this.b] = null;
        }
        return var1_1;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public List<E> subList(int fromIndexInclusive, int toIndexExclusive) {
        void var2_2;
        void var1_1;
        return new b(this, (int)var1_1, (int)var2_2);
    }

    @Override
    public boolean add(E value) {
        im_1 im_12;
        void var2_2 = im_12;
        im_12 = this;
        im_12.b(im_12.a, var2_2);
        return true;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public void add(int index, E value) {
        void var2_3;
        void var1_1;
        d<E> d2 = this.a((int)var1_1, true);
        this.b(d2, var2_3);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public boolean addAll(Collection<? extends E> coll) {
        void var1_1;
        im_1 im_12 = this;
        return im_12.addAll(im_12.b, (Collection<? extends E>)var1_1);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public boolean addAll(int index, Collection<? extends E> coll) {
        Iterator iterator2;
        void var1_1;
        d<E> d2 = this.a((int)var1_1, true);
        iterator2 = iterator2.iterator();
        while (iterator2.hasNext()) {
            Object e2 = iterator2.next();
            this.b(d2, e2);
        }
        return true;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public E remove(int index) {
        void var1_1;
        d<E> d2 = this.a((int)var1_1, false);
        E e2 = d2.a();
        this.a(d2);
        return e2;
    }

    @Override
    public boolean remove(Object value) {
        d d2 = this.a.b;
        while (d2 != this.a) {
            if (im_1.a(d2.a(), value)) {
                this.a(d2);
                return true;
            }
            d2 = d2.b;
        }
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> coll) {
        boolean bl = false;
        Iterator<E> iterator2 = this.iterator();
        while (iterator2.hasNext()) {
            if (!coll.contains(iterator2.next())) continue;
            iterator2.remove();
            bl = true;
        }
        return bl;
    }

    @Override
    public boolean retainAll(Collection<?> coll) {
        boolean bl = false;
        Iterator<E> iterator2 = this.iterator();
        while (iterator2.hasNext()) {
            if (coll.contains(iterator2.next())) continue;
            iterator2.remove();
            bl = true;
        }
        return bl;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public E set(int index, E value) {
        void var2_3;
        void var1_1;
        d<E> d2 = this.a((int)var1_1, false);
        E e2 = d2.a();
        this.a(d2, var2_3);
        return e2;
    }

    @Override
    public void clear() {
        this.b();
    }

    private E c() {
        d d2 = this.a.b;
        if (d2 == this.a) {
            throw new NoSuchElementException();
        }
        return d2.a();
    }

    private E d() {
        d d2 = this.a.a;
        if (d2 == this.a) {
            throw new NoSuchElementException();
        }
        return d2.a();
    }

    private boolean b(E object) {
        im_1 im_12 = this;
        Object object2 = object;
        d<E> d2 = im_12.a;
        object = im_12;
        object2 = im_12.a(object2);
        ((im_1)object).a((d<E>)object2, d2.b);
        return true;
    }

    private boolean c(E e2) {
        im_1 im_12 = this;
        im_12.b(im_12.a, e2);
        return true;
    }

    private E e() {
        d d2 = this.a.b;
        if (d2 == this.a) {
            throw new NoSuchElementException();
        }
        Object e2 = d2.a();
        this.a(d2);
        return e2;
    }

    private E f() {
        d d2 = this.a.a;
        if (d2 == this.a) {
            throw new NoSuchElementException();
        }
        Object e2 = d2.a();
        this.a(d2);
        return e2;
    }

    @Override
    public boolean equals(Object obj) {
        Object object;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        if ((object = (List)object).size() != this.size()) {
            return false;
        }
        ListIterator<E> listIterator = this.listIterator();
        object = object.listIterator();
        while (listIterator.hasNext() && object.hasNext()) {
            E e2 = listIterator.next();
            Object e3 = object.next();
            if (e2 != null ? e2.equals(e3) : e3 == null) continue;
            return false;
        }
        return !listIterator.hasNext() && !object.hasNext();
    }

    @Override
    public int hashCode() {
        int n2 = 1;
        for (E e2 : this) {
            n2 = n2 * 31 + (e2 == null ? 0 : e2.hashCode());
        }
        return n2;
    }

    public String toString() {
        if (this.size() == 0) {
            return "[]";
        }
        StringBuilder stringBuilder = new StringBuilder(16 * this.size());
        stringBuilder.append('[');
        Iterator<E> iterator2 = this.iterator();
        boolean bl = iterator2.hasNext();
        while (bl) {
            E e2 = iterator2.next();
            stringBuilder.append((Object)(e2 == this ? "(this Collection)" : e2));
            bl = iterator2.hasNext();
            if (!bl) continue;
            stringBuilder.append(", ");
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    private static boolean a(Object object, Object object2) {
        return object == object2 || object != null && object.equals(object2);
    }

    protected void a(d<E> d2, E e2) {
        d2.a(e2);
    }

    private static d<E> g() {
        return new d();
    }

    protected d<E> a(E e2) {
        return new d<E>(e2);
    }

    protected final void b(d<E> d2, E object) {
        object = this.a(object);
        this.a((d<E>)object, d2);
    }

    private void c(d<E> d2, E object) {
        object = this.a(object);
        this.a((d<E>)object, d2.b);
    }

    protected void a(d<E> d2, d<E> d3) {
        d2.b = d3;
        d2.a = d3.a;
        d3.a.b = d2;
        d3.a = d2;
        ++this.b;
        ++this.c;
    }

    protected void a(d<E> d2) {
        d2.a.b = d2.b;
        d2.b.a = d2.a;
        --this.b;
        ++this.c;
    }

    protected void b() {
        this.a.b = this.a;
        this.a.a = this.a;
        this.b = 0;
        ++this.c;
    }

    protected final d<E> a(int n2, boolean bl) {
        d<E> d2;
        if (n2 < 0) {
            throw new IndexOutOfBoundsException("Couldn't get the node: index (" + n2 + ") less than zero.");
        }
        if (!bl && n2 == this.b) {
            throw new IndexOutOfBoundsException("Couldn't get the node: index (" + n2 + ") is the size of the list.");
        }
        if (n2 > this.b) {
            throw new IndexOutOfBoundsException("Couldn't get the node: index (" + n2 + ") greater than the size of the list (" + this.b + ").");
        }
        if (n2 < this.b / 2) {
            d2 = this.a.b;
            for (int i2 = 0; i2 < n2; ++i2) {
                d2 = d2.b;
            }
        } else {
            d2 = this.a;
            for (int i3 = this.b; i3 > n2; --i3) {
                d2 = d2.a;
            }
        }
        return d2;
    }

    protected final Iterator<E> a(b<E> b2) {
        return this.a(b2, 0);
    }

    protected ListIterator<E> a(b<E> b2, int n2) {
        return new c<E>(b2, n2);
    }

    protected final void a(ObjectOutputStream objectOutputStream) {
        objectOutputStream.writeInt(this.size());
        for (E e2 : this) {
            objectOutputStream.writeObject(e2);
        }
    }

    protected final void a(ObjectInputStream objectInputStream) {
        this.a();
        int n2 = objectInputStream.readInt();
        for (int i2 = 0; i2 < n2; ++i2) {
            this.add(objectInputStream.readObject());
        }
    }

    protected static final class b<E>
    extends AbstractList<E> {
        im_1<E> a;
        int b;
        int c;
        int d;

        protected b(im_1<E> im_12, int n2, int n3) {
            if (n2 < 0) {
                throw new IndexOutOfBoundsException("fromIndex = " + n2);
            }
            if (n3 > im_12.size()) {
                throw new IndexOutOfBoundsException("toIndex = " + n3);
            }
            if (n2 > n3) {
                throw new IllegalArgumentException("fromIndex(" + n2 + ") > toIndex(" + n3 + ")");
            }
            this.a = im_12;
            this.b = n2;
            this.c = n3 - n2;
            this.d = ((iM)im_12).c;
        }

        @Override
        public final int size() {
            this.a();
            return this.c;
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public final E get(int index) {
            void var1_1;
            this.a(index, this.c);
            this.a();
            return (E)this.a.get((int)(var1_1 + this.b));
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public final void add(int index, E obj) {
            void var2_2;
            void var1_1;
            this.a(index, this.c + 1);
            this.a();
            this.a.add((int)(var1_1 + this.b), var2_2);
            this.d = ((iM)this.a).c;
            ++this.c;
            ++this.modCount;
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public final E remove(int index) {
            void var1_1;
            this.a(index, this.c);
            this.a();
            Object object = this.a.remove((int)(var1_1 + this.b));
            this.d = ((iM)this.a).c;
            --this.c;
            ++this.modCount;
            return (E)object;
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public final boolean addAll(Collection<? extends E> coll) {
            void var1_1;
            b b2 = this;
            return b2.addAll(b2.c, (Collection<? extends E>)var1_1);
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public final boolean addAll(int index, Collection<? extends E> coll) {
            void var2_2;
            void var1_1;
            this.a(index, this.c + 1);
            int n2 = coll.size();
            if (n2 == 0) {
                return false;
            }
            this.a();
            this.a.addAll(this.b + var1_1, (Collection)var2_2);
            this.d = ((iM)this.a).c;
            this.c += n2;
            ++this.modCount;
            return true;
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public final E set(int index, E obj) {
            void var2_2;
            void var1_1;
            this.a(index, this.c);
            this.a();
            return (E)this.a.set((int)(var1_1 + this.b), var2_2);
        }

        @Override
        public final void clear() {
            this.a();
            Iterator<E> iterator2 = this.iterator();
            while (iterator2.hasNext()) {
                iterator2.next();
                iterator2.remove();
            }
        }

        @Override
        public final Iterator<E> iterator() {
            this.a();
            return this.a.a(this);
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public final ListIterator<E> listIterator(int index) {
            void var1_1;
            this.a(index, this.c + 1);
            this.a();
            return this.a.a(this, (int)var1_1);
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public final List<E> subList(int fromIndexInclusive, int toIndexExclusive) {
            void var2_2;
            void var1_1;
            return new b<E>(this.a, (int)(var1_1 + this.b), (int)(var2_2 + this.b));
        }

        private void a(int n2, int n3) {
            if (n2 < 0 || n2 >= n3) {
                throw new IndexOutOfBoundsException("Index '" + n2 + "' out of bounds for size '" + this.c + "'");
            }
        }

        private void a() {
            if (((iM)this.a).c != this.d) {
                throw new ConcurrentModificationException();
            }
        }
    }

    protected static final class c<E>
    extends a<E> {
        private b<E> e;

        protected c(b<E> b2, int n2) {
            super(b2.a, n2 + b2.b);
            this.e = b2;
        }

        @Override
        public final boolean hasNext() {
            return ((a)this).nextIndex() < this.e.c;
        }

        @Override
        public final boolean hasPrevious() {
            return this.previousIndex() >= 0;
        }

        @Override
        public final int nextIndex() {
            return super.nextIndex() - this.e.b;
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public final void add(E obj) {
            void var1_1;
            super.add(var1_1);
            this.e.d = ((iM)this.a).c;
            ++this.e.c;
        }

        @Override
        public final void remove() {
            super.remove();
            this.e.d = ((iM)this.a).c;
            --this.e.c;
        }
    }

    protected static class a<E>
    implements ListIterator<E>,
    fc_1<E> {
        protected final im_1<E> a;
        protected d<E> b;
        protected int c;
        protected d<E> d;
        private int e;

        protected a(im_1<E> im_12, int n2) {
            this.a = im_12;
            this.e = ((iM)im_12).c;
            this.b = im_12.a(n2, true);
            this.c = n2;
        }

        protected void a() {
            if (((iM)this.a).c != this.e) {
                throw new ConcurrentModificationException();
            }
        }

        protected final d<E> b() {
            if (this.d == null) {
                throw new IllegalStateException();
            }
            return this.d;
        }

        @Override
        public boolean hasNext() {
            return this.b != ((iM)this.a).a;
        }

        @Override
        public E next() {
            this.a();
            if (!this.hasNext()) {
                throw new NoSuchElementException("No element at index " + this.c + ".");
            }
            E e2 = this.b.a();
            this.d = this.b;
            this.b = this.b.b;
            ++this.c;
            return e2;
        }

        @Override
        public boolean hasPrevious() {
            return this.b.a != ((iM)this.a).a;
        }

        @Override
        public E previous() {
            this.a();
            if (!this.hasPrevious()) {
                throw new NoSuchElementException("Already at start of list.");
            }
            this.b = this.b.a;
            E e2 = this.b.a();
            this.d = this.b;
            --this.c;
            return e2;
        }

        @Override
        public int nextIndex() {
            return this.c;
        }

        @Override
        public int previousIndex() {
            return this.nextIndex() - 1;
        }

        @Override
        public void remove() {
            this.a();
            if (this.d == this.b) {
                this.b = this.b.b;
                this.a.a(this.b());
            } else {
                this.a.a(this.b());
                --this.c;
            }
            this.d = null;
            ++this.e;
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public void set(E obj) {
            void var1_1;
            this.a();
            this.b().a(var1_1);
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public void add(E obj) {
            void var1_1;
            this.a();
            this.a.b(this.b, var1_1);
            this.d = null;
            ++this.c;
            ++this.e;
        }
    }

    protected static final class d<E> {
        protected d<E> a;
        protected d<E> b;
        private E c;

        protected d() {
            this.a = this;
            this.b = this;
        }

        protected d(E e2) {
            this.c = e2;
        }

        private d(d<E> d2, d<E> d3, E e2) {
            this.a = d2;
            this.b = d3;
            this.c = e2;
        }

        protected final E a() {
            return this.c;
        }

        protected final void a(E e2) {
            this.c = e2;
        }

        private d<E> b() {
            return this.a;
        }

        private void a(d<E> d2) {
            this.a = d2;
        }

        private d<E> c() {
            return this.b;
        }

        private void b(d<E> d2) {
            this.b = d2;
        }
    }
}

