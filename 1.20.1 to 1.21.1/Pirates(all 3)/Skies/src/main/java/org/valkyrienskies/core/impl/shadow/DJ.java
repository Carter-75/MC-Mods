/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import org.valkyrienskies.core.impl.shadow.DH;
import org.valkyrienskies.core.impl.shadow.DK;

public final class DJ<T>
extends AbstractList<T> {
    final DK<T> a = new DK<Object>(null);
    DK<T> b;

    public DJ() {
        this.b = this.a;
    }

    private DJ(Collection<? extends T> object) {
        ArrayList arrayList = new ArrayList(object.size());
        object = object.iterator();
        while (object.hasNext()) {
            Object e2 = object.next();
            arrayList.add(new DK(e2));
        }
        this.b = DH.a(arrayList, this.a);
    }

    DK<T> a(int n2) {
        if (n2 < 0 || n2 >= this.b.b) {
            throw new IndexOutOfBoundsException("Index " + n2 + " is not in the range [0, " + this.b.b + ")");
        }
        DK dK = this.b;
        while (n2 != ((DK)dK.j).b) {
            if (n2 < ((DK)dK.j).b) {
                dK = (DK)dK.j;
                continue;
            }
            n2 -= ((DK)dK.j).b + 1;
            dK = (DK)dK.k;
        }
        return dK;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final T get(int index) {
        void var1_1;
        return this.a((int)var1_1).a;
    }

    @Override
    public final int size() {
        return this.b.b;
    }

    @Override
    public final boolean isEmpty() {
        return this.b == this.a;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final T set(int index, T value) {
        void var2_3;
        void var1_1;
        ++this.modCount;
        DK<T> dK = this.a((int)var1_1);
        Object t = dK.a;
        dK.a = var2_3;
        return t;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final void add(int index, T value) {
        DK<void> dK;
        if (index < 0 || index > this.b.b) {
            throw new IndexOutOfBoundsException("Index " + index + " is not in the range [0, " + this.b.b + "]");
        }
        ++this.modCount;
        dK = new DK<void>((void)dK);
        v0.j = this.a;
        dK.k = this.a;
        if (this.b.d()) {
            this.b = dK;
            dK.l = false;
            return;
        }
        dK.l = true;
        if (index < this.b.b) {
            void var1_1;
            DK dK2 = this.a((int)var1_1);
            if (((DK)dK2.j).d()) {
                dK2.j = dK;
                dK.i = dK2;
            } else {
                dK2 = (DK)dK2.h();
                v1.k = dK;
                dK.i = dK2;
            }
        } else {
            DK dK3 = (DK)this.b.g();
            ((DK)this.b.g()).k = dK;
            dK.i = dK3;
        }
        this.b = (DK)dK.j();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final T remove(int index) {
        void var1_1;
        DK<T> dK = this.a((int)var1_1);
        ++this.modCount;
        this.b = (DK)dK.l();
        return dK.a;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final boolean addAll(int index, Collection<? extends T> values2) {
        void var1_1;
        DK[] dKArray;
        if (index < 0 || index > this.b.b) {
            throw new IndexOutOfBoundsException("Index " + index + " is not in the range [0, " + this.b.b + "]");
        }
        if (index >= this.b.b) {
            return this.addAll((Collection<? extends T>)values2);
        }
        ++this.modCount;
        int n2 = values2.size();
        if (n2 == 0) {
            return false;
        }
        ArrayList arrayList = new ArrayList(n2);
        for (Object object : dKArray) {
            arrayList.add(new DK(object));
        }
        dKArray = (DK[])this.b.a(this.a((int)var1_1));
        if (n2 == 1) {
            this.b = dKArray[0].a(dKArray[1], (DK)arrayList.get(0));
        } else {
            DK<T> dK = DK.a(arrayList.subList(1, n2 - 1), this.a);
            this.b = dKArray[0].a(dK, (DK)arrayList.get(0)).a(dKArray[1], (DK)arrayList.get(n2 - 1));
        }
        return true;
    }

    @Override
    public final boolean addAll(Collection<? extends T> values2) {
        Object object;
        ++this.modCount;
        int n2 = values2.size();
        if (n2 == 0) {
            return false;
        }
        ArrayList arrayList = new ArrayList(n2);
        object = object.iterator();
        while (object.hasNext()) {
            Object e2 = object.next();
            arrayList.add(new DK(e2));
        }
        object = DK.a(arrayList.subList(1, n2), this.a);
        this.b = this.b.a(object, (DK)arrayList.get(0));
        return true;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    protected final void removeRange(int startIndex, int endIndex) {
        if (startIndex != endIndex) {
            void var1_1;
            Object object;
            DK dK;
            ++this.modCount;
            if (endIndex == this.b.b) {
                dK = this.a;
            } else {
                void var2_3;
                object = (DK[])this.b.a(this.a((int)var2_3));
                this.b = object[0];
                dK = object[1];
            }
            if (startIndex == 0) {
                this.b = dK;
                return;
            }
            object = this.a((int)(var1_1 - true));
            DK dK2 = this.b.a(object)[0];
            this.b = (DK)dK2.a(dK, object);
        }
    }

    @Override
    public final void clear() {
        ++this.modCount;
        this.b = this.a;
    }

    @Override
    public final Iterator<T> iterator() {
        return new a(this);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final ListIterator<T> listIterator(int index) {
        void var1_1;
        if (index < 0 || index > this.b.b) {
            throw new IndexOutOfBoundsException("Index " + index + " is not in the range [0, " + this.b.b + "]");
        }
        return new b(this, (int)var1_1);
    }

    final class a
    implements Iterator<T> {
        private int a;
        private DK<T> b;
        private DK<T> c;
        private boolean d;
        private /* synthetic */ DJ e;

        a(DJ dJ) {
            this.e = dJ;
            this.a = this.e.modCount;
            if (dJ.b.d()) {
                this.c = null;
                return;
            }
            this.c = (DK)dJ.b.f();
        }

        @Override
        public final boolean hasNext() {
            return this.c != null;
        }

        @Override
        public final T next() {
            if (this.c == null) {
                throw new NoSuchElementException("Reached the end of the list");
            }
            if (this.e.modCount != this.a) {
                throw new ConcurrentModificationException();
            }
            this.d = true;
            this.b = this.c;
            this.c = (DK)this.c.i();
            return this.b.a;
        }

        @Override
        public final void remove() {
            if (this.b == null) {
                if (!this.d) {
                    throw new IllegalStateException("Must call next() before calling remove()");
                }
                throw new IllegalStateException("Already removed this element");
            }
            if (this.e.modCount != this.a) {
                throw new ConcurrentModificationException();
            }
            this.e.b = (DK)this.b.l();
            this.b = null;
            this.e.modCount++;
            this.a = this.e.modCount;
        }
    }

    final class b
    implements ListIterator<T> {
        private int a;
        private int b;
        private DK<T> c;
        private DK<T> d;
        private boolean e;
        private boolean f;
        private boolean g;
        private /* synthetic */ DJ h;

        b(DJ dJ, int n2) {
            this.h = dJ;
            this.a = this.h.modCount;
            this.b = n2;
            if (n2 > 0) {
                this.d = dJ.a(n2 - 1);
                this.c = (DK)this.d.i();
                return;
            }
            this.d = null;
            if (dJ.b.b > 0) {
                this.c = (DK)dJ.b.f();
                return;
            }
            this.c = null;
        }

        @Override
        public final boolean hasNext() {
            if (this.a != this.h.modCount) {
                throw new ConcurrentModificationException();
            }
            return this.c != null;
        }

        @Override
        public final T next() {
            if (this.c == null) {
                throw new NoSuchElementException("Reached the end of the list");
            }
            if (this.a != this.h.modCount) {
                throw new ConcurrentModificationException();
            }
            this.e = true;
            this.f = true;
            this.g = false;
            ++this.b;
            this.d = this.c;
            this.c = (DK)this.c.i();
            return this.d.a;
        }

        @Override
        public final int nextIndex() {
            if (this.a != this.h.modCount) {
                throw new ConcurrentModificationException();
            }
            return this.b;
        }

        @Override
        public final boolean hasPrevious() {
            if (this.a != this.h.modCount) {
                throw new ConcurrentModificationException();
            }
            return this.d != null;
        }

        @Override
        public final T previous() {
            if (this.d == null) {
                throw new NoSuchElementException("Reached the beginning of the list");
            }
            if (this.a != this.h.modCount) {
                throw new ConcurrentModificationException();
            }
            this.e = true;
            this.f = false;
            this.g = false;
            --this.b;
            this.c = this.d;
            this.d = (DK)this.d.h();
            return this.c.a;
        }

        @Override
        public final int previousIndex() {
            return this.b - 1;
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public final void set(T value) {
            if (!this.e) {
                throw new IllegalStateException("Must call next() or previous() before calling \"set\"");
            }
            if (this.g) {
                throw new IllegalStateException("Already modified the list at this position");
            }
            if (this.a != this.h.modCount) {
                throw new ConcurrentModificationException();
            }
            if (this.f) {
                this.d.a = value;
            } else {
                void var1_1;
                this.c.a = var1_1;
            }
            this.h.modCount++;
            this.a = this.h.modCount;
        }

        @Override
        public final void add(T value) {
            DK<void> dK;
            if (this.g) {
                throw new IllegalStateException("Already modified the list at this position");
            }
            if (this.a != this.h.modCount) {
                throw new ConcurrentModificationException();
            }
            dK = new DK<void>((void)dK);
            v0.j = this.h.a;
            dK.k = this.h.a;
            dK.l = true;
            if (this.c != null && ((DK)this.c.j).d()) {
                this.c.j = dK;
                dK.i = this.c;
            } else if (this.d != null) {
                this.d.k = dK;
                dK.i = this.d;
            } else {
                this.h.b = dK;
            }
            this.d = dK;
            this.h.b = (DK)dK.j();
            ++this.b;
            this.g = true;
            this.h.modCount++;
            this.a = this.h.modCount;
        }

        @Override
        public final void remove() {
            if (!this.e) {
                throw new IllegalStateException("Must call next() or previous() before calling remove()");
            }
            if (this.g) {
                throw new IllegalStateException("Already modified the list at this position");
            }
            if (this.a != this.h.modCount) {
                throw new ConcurrentModificationException();
            }
            if (this.f) {
                DK dK = (DK)this.d.h();
                this.h.b = (DK)this.d.l();
                this.d = dK;
            } else {
                DK dK = (DK)this.c.i();
                this.h.b = (DK)this.c.l();
                this.c = dK;
            }
            this.g = true;
            this.h.modCount++;
            this.a = this.h.modCount;
        }
    }
}

