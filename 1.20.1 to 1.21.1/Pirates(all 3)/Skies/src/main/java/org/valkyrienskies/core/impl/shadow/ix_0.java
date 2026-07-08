/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.valkyrienskies.core.impl.shadow.iX
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.AbstractList;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import org.valkyrienskies.core.impl.shadow.fc_1;
import org.valkyrienskies.core.impl.shadow.iX;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.iX
 */
public final class ix_0<E>
extends AbstractList<E> {
    private a<E> a;
    private int b;

    public ix_0() {
    }

    private ix_0(Collection<? extends E> collection) {
        if (!collection.isEmpty()) {
            this.a = new a(collection, 0);
            this.b = collection.size();
        }
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final E get(int index) {
        void var1_1;
        this.a(index, 0, this.size() - 1);
        a<E> a2 = this.a.a((int)var1_1);
        return a2.g;
    }

    @Override
    public final int size() {
        return this.b;
    }

    @Override
    public final Iterator<E> iterator() {
        return this.listIterator(0);
    }

    @Override
    public final ListIterator<E> listIterator() {
        return this.listIterator(0);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final ListIterator<E> listIterator(int fromIndex) {
        void var1_1;
        this.a(fromIndex, 0, this.size());
        return new b(this, (int)var1_1);
    }

    @Override
    public final int indexOf(Object object) {
        a<E> a2;
        if (this.a == null) {
            return -1;
        }
        void v0 = a2;
        a2 = this.a;
        return this.a.a(v0, a2.f);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final boolean contains(Object object) {
        void var1_1;
        return this.indexOf(var1_1) >= 0;
    }

    @Override
    public final Object[] toArray() {
        Object[] objectArray = new Object[this.size()];
        if (this.a != null) {
            a<E> a2 = this.a;
            this.a.a(objectArray, a2.f);
        }
        return objectArray;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final void add(int index, E obj) {
        void var2_2;
        void var1_1;
        ++this.modCount;
        this.a(index, 0, this.size());
        this.a = this.a == null ? new a(index, obj, null, null, 0) : this.a.a((int)var1_1, var2_2);
        ++this.b;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final boolean addAll(Collection<? extends E> c2) {
        void var1_1;
        a a2;
        if (c2.isEmpty()) {
            return false;
        }
        this.modCount += c2.size();
        a a3 = new a(c2, 0);
        if (this.a == null) {
            a2 = a3;
        } else {
            a<E> a4 = this.a;
            int n2 = this.b;
            a a5 = a3;
            a3 = a4;
            a3 = a4;
            a a6 = a4.d();
            a a7 = a5.e();
            if (a5.e > a3.e) {
                a a8 = a3.f();
                a3 = new ArrayDeque();
                a a9 = a5;
                int n3 = a9.f + n2;
                int n4 = 0;
                while (a9 != null && a9.e > org.valkyrienskies.core.impl.shadow.iX$a.a(a8)) {
                    n4 = n3;
                    a3.push(a9);
                    a9 = a9.a;
                    if (a9 == null) continue;
                    n3 += a9.f;
                }
                a6.a(a8, null);
                a6.b(a9, a7);
                if (a8 != null) {
                    a8.d().b(null, a6);
                    a8.f -= n2 - 1;
                }
                if (a9 != null) {
                    a9.e().a(null, a6);
                    a9.f = n3 - n2 + 1;
                }
                a6.f = n2 - 1 - n4;
                a5.f += n2;
                a9 = a6;
                while (!a3.isEmpty()) {
                    a5 = (a)a3.pop();
                    a5.a(a9, null);
                    a9 = a5.h();
                }
                a2 = a9;
            } else {
                a5 = a5.g();
                ArrayDeque arrayDeque = new ArrayDeque();
                int n5 = a3.f;
                int n6 = 0;
                while (a3 != null && a3.e > org.valkyrienskies.core.impl.shadow.iX$a.a(a5)) {
                    n6 = n5;
                    arrayDeque.push(a3);
                    a3 = a3.c;
                    if (a3 == null) continue;
                    n5 += a3.f;
                }
                a7.b(a5, null);
                a7.a(a3, a6);
                if (a5 != null) {
                    a5.e().a(null, a7);
                    ++a5.f;
                }
                if (a3 != null) {
                    a3.d().b(null, a7);
                    a3.f = n5 - n2;
                }
                a7.f = n2 - n6;
                a3 = a7;
                while (!arrayDeque.isEmpty()) {
                    a a10 = (a)arrayDeque.pop();
                    a10.b(a3, null);
                    a3 = a10.h();
                }
                a2 = a3;
            }
        }
        this.a = a2;
        this.b += var1_1.size();
        return true;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final E set(int index, E obj) {
        void var2_3;
        void var1_1;
        a<E> a2;
        this.a(index, 0, this.size() - 1);
        a<E> a3 = a2 = this.a.a((int)var1_1);
        a3 = a2.g;
        v0.g = var2_3;
        return (E)a3;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final E remove(int index) {
        void var1_1;
        ++this.modCount;
        this.a(index, 0, this.size() - 1);
        E e2 = this.get(index);
        this.a = this.a.b((int)var1_1);
        --this.b;
        return e2;
    }

    @Override
    public final void clear() {
        ++this.modCount;
        this.a = null;
        this.b = 0;
    }

    private void a(int n2, int n3, int n4) {
        if (n2 < 0 || n2 > n4) {
            throw new IndexOutOfBoundsException("Invalid index:" + n2 + ", size=" + this.size());
        }
    }

    static /* synthetic */ int a(ix_0 ix_02) {
        return ix_02.modCount;
    }

    static /* synthetic */ a b(ix_0 ix_02) {
        return ix_02.a;
    }

    static /* synthetic */ int c(ix_0 ix_02) {
        return ix_02.modCount;
    }

    static final class b<E>
    implements ListIterator<E>,
    fc_1<E> {
        private final ix_0<E> a;
        private a<E> b;
        private int c;
        private a<E> d;
        private int e;
        private int f;

        protected b(ix_0<E> ix_02, int n2) {
            this.a = ix_02;
            this.f = iX.a(ix_02);
            this.b = iX.b(ix_02) == null ? null : iX.b(ix_02).a(n2);
            this.c = n2;
            this.e = -1;
        }

        private void a() {
            if (iX.c(this.a) != this.f) {
                throw new ConcurrentModificationException();
            }
        }

        @Override
        public final boolean hasNext() {
            return this.c < this.a.size();
        }

        @Override
        public final E next() {
            this.a();
            if (!this.hasNext()) {
                throw new NoSuchElementException("No element at index " + this.c + ".");
            }
            if (this.b == null) {
                this.b = iX.b(this.a).a(this.c);
            }
            a<E> a2 = this.b;
            a2 = a2.g;
            this.d = this.b;
            this.e = this.c++;
            a<E> a3 = this.b;
            this.b = a3.d || a3.c == null ? a3.c : a3.c.e();
            return (E)a2;
        }

        @Override
        public final boolean hasPrevious() {
            return this.c > 0;
        }

        @Override
        public final E previous() {
            a<E> a2;
            a a3;
            b b2;
            this.a();
            if (!this.hasPrevious()) {
                throw new NoSuchElementException("Already at start of list.");
            }
            if (this.b == null) {
                b b3 = this;
                b2 = b3;
                a3 = iX.b(b3.a).a(this.c - 1);
            } else {
                b b4 = this;
                b2 = b4;
                a2 = b4.b;
                a3 = a2.b || a2.a == null ? a2.a : a2.a.d();
            }
            b2.b = a3;
            a2 = this.b;
            a2 = a2.g;
            this.d = this.b;
            this.e = --this.c;
            return (E)a2;
        }

        @Override
        public final int nextIndex() {
            return this.c;
        }

        @Override
        public final int previousIndex() {
            return this.nextIndex() - 1;
        }

        @Override
        public final void remove() {
            this.a();
            if (this.e == -1) {
                throw new IllegalStateException();
            }
            this.a.remove(this.e);
            if (this.c != this.e) {
                --this.c;
            }
            this.b = null;
            this.d = null;
            this.e = -1;
            ++this.f;
        }

        @Override
        public final void set(E obj) {
            a<E> a2;
            this.a();
            if (this.d == null) {
                throw new IllegalStateException();
            }
            void var2_2 = a2;
            a2 = this.d;
            this.d.g = var2_2;
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public final void add(E obj) {
            void var1_1;
            this.a();
            this.a.add(this.c, var1_1);
            this.d = null;
            this.e = -1;
            ++this.c;
            ++this.f;
        }
    }

    static final class a<E> {
        a<E> a;
        boolean b;
        a<E> c;
        boolean d;
        int e;
        int f;
        E g;

        private a(int n2, E e2, a<E> a2, a<E> a3) {
            this.f = n2;
            this.g = e2;
            this.d = true;
            this.b = true;
            this.c = a2;
            this.a = a3;
        }

        private a(Collection<? extends E> collection) {
            this(collection.iterator(), 0, collection.size() - 1, 0, null, null);
        }

        private a(Iterator<? extends E> iterator2, int n2, int n3, int n4, a<E> a2, a<E> a3) {
            int n5 = n2 + (n3 - n2) / 2;
            if (n2 < n5) {
                this.a = new a<E>(iterator2, n2, n5 - 1, n5, a2, this);
            } else {
                this.b = true;
                this.a = a2;
            }
            this.g = iterator2.next();
            this.f = n5 - n4;
            if (n5 < n3) {
                this.c = new a<E>(iterator2, n5 + 1, n3, n5, this, a3);
            } else {
                this.d = true;
                this.c = a3;
            }
            this.l();
        }

        final E a() {
            return this.g;
        }

        final void a(E e2) {
            this.g = e2;
        }

        final a<E> a(int n2) {
            while ((n2 -= a3.f) != 0) {
                a<E> a2 = n2 < 0 ? a3.i() : a3.j();
                if (a2 == null) {
                    return null;
                }
                a<E> a3 = a2;
            }
            return a3;
        }

        final int a(Object object, int n2) {
            while (true) {
                int n3;
                if (a2.i() != null && (n3 = a2.a.a(object, n2 + a2.a.f)) != -1) {
                    return n3;
                }
                if (a2.g == null ? a2.g == object : a2.g.equals(object)) {
                    return n2;
                }
                if (a2.j() == null) break;
                n2 += a2.c.f;
                a<E> a2 = a2.c;
            }
            return -1;
        }

        final void a(Object[] objectArray, int n2) {
            while (true) {
                objectArray[n2] = a2.g;
                if (a2.i() != null) {
                    a2.a.a(objectArray, n2 + a2.a.f);
                }
                if (a2.j() == null) break;
                n2 += a2.c.f;
                a<E> a2 = a2.c;
            }
        }

        final a<E> b() {
            if (this.d || this.c == null) {
                return this.c;
            }
            return this.c.e();
        }

        final a<E> c() {
            if (this.b || this.a == null) {
                return this.a;
            }
            return this.a.d();
        }

        final a<E> a(int n2, E e2) {
            if ((n2 -= this.f) <= 0) {
                return this.b(n2, e2);
            }
            return this.c(n2, e2);
        }

        private a<E> b(int n2, E e2) {
            if (this.i() == null) {
                a a2 = this;
                this.a(new a<E>(-1, e2, a2, a2.a), null);
            } else {
                a a3 = this;
                a3.a(a3.a.a(n2, e2), null);
            }
            if (this.f >= 0) {
                ++this.f;
            }
            a<E> a4 = this.h();
            this.l();
            return a4;
        }

        private a<E> c(int n2, E e2) {
            if (this.j() == null) {
                this.b(new a<E>(1, e2, this.c, this), null);
            } else {
                a a2 = this;
                a2.b(a2.c.a(n2, e2), null);
            }
            if (this.f < 0) {
                --this.f;
            }
            a<E> a3 = this.h();
            this.l();
            return a3;
        }

        private a<E> i() {
            if (this.b) {
                return null;
            }
            return this.a;
        }

        private a<E> j() {
            if (this.d) {
                return null;
            }
            return this.c;
        }

        a<E> d() {
            while (a2.j() != null) {
                a<E> a2 = a2.c;
            }
            return a2;
        }

        a<E> e() {
            while (a2.i() != null) {
                a<E> a2 = a2.a;
            }
            return a2;
        }

        final a<E> b(int n2) {
            if ((n2 -= this.f) == 0) {
                return this.k();
            }
            if (n2 > 0) {
                a a2 = this;
                a2.b(a2.c.b(n2), this.c.c);
                if (this.f < 0) {
                    ++this.f;
                }
            } else {
                a a3 = this;
                a3.a(a3.a.b(n2), this.a.a);
                if (this.f > 0) {
                    --this.f;
                }
            }
            this.l();
            return this.h();
        }

        a<E> f() {
            if (this.j() == null) {
                return this.k();
            }
            a a2 = this;
            a2.b(a2.c.f(), this.c.c);
            if (this.f < 0) {
                ++this.f;
            }
            this.l();
            return this.h();
        }

        a<E> g() {
            if (this.i() == null) {
                return this.k();
            }
            a a2 = this;
            a2.a(a2.a.g(), this.a.a);
            if (this.f > 0) {
                --this.f;
            }
            this.l();
            return this.h();
        }

        private a<E> k() {
            if (this.j() == null && this.i() == null) {
                return null;
            }
            if (this.j() == null) {
                if (this.f > 0) {
                    this.a.f += this.f;
                }
                this.a.d().b(null, this.c);
                return this.a;
            }
            if (this.i() == null) {
                this.c.f = this.c.f + (this.f - (this.f < 0 ? 0 : 1));
                this.c.e().a(null, this.a);
                return this.c;
            }
            if (this.m() > 0) {
                a<E> a2 = this.c.e();
                this.g = a2.g;
                if (this.b) {
                    this.a = a2.a;
                }
                this.c = this.c.g();
                if (this.f < 0) {
                    ++this.f;
                }
            } else {
                a<E> a3 = this.a.d();
                this.g = a3.g;
                if (this.d) {
                    this.c = a3.c;
                }
                a3 = this.a.a;
                this.a = this.a.f();
                if (this.a == null) {
                    this.a = a3;
                    this.b = true;
                }
                if (this.f > 0) {
                    --this.f;
                }
            }
            this.l();
            return this;
        }

        a<E> h() {
            switch (this.m()) {
                case -1: 
                case 0: 
                case 1: {
                    return this;
                }
                case -2: {
                    if (super.m() > 0) {
                        a a2 = this;
                        a2.a(super.n(), null);
                    }
                    return this.o();
                }
                case 2: {
                    if (super.m() < 0) {
                        a a3 = this;
                        a3.b(super.o(), null);
                    }
                    return this.n();
                }
            }
            throw new RuntimeException("tree inconsistent!");
        }

        private static int d(a<E> a2) {
            if (a2 == null) {
                return 0;
            }
            return a2.f;
        }

        private int a(a<E> a2, int n2) {
            if (a2 == null) {
                return 0;
            }
            int n3 = org.valkyrienskies.core.impl.shadow.iX$a.d(a2);
            a2.f = n2;
            return n3;
        }

        private void l() {
            this.e = Math.max(this.i() == null ? -1 : this.i().e, this.j() == null ? -1 : this.j().e) + 1;
        }

        static int a(a<E> a2) {
            if (a2 == null) {
                return -1;
            }
            return a2.e;
        }

        private int m() {
            return org.valkyrienskies.core.impl.shadow.iX$a.a(this.j()) - org.valkyrienskies.core.impl.shadow.iX$a.a(this.i());
        }

        private a<E> n() {
            a<E> a2 = this.c;
            a<E> a3 = super.i();
            int n2 = this.f + org.valkyrienskies.core.impl.shadow.iX$a.d(a2);
            int n3 = -a2.f;
            int n4 = org.valkyrienskies.core.impl.shadow.iX$a.d(a2) + org.valkyrienskies.core.impl.shadow.iX$a.d(a3);
            this.b(a3, a2);
            a2.a(this, null);
            this.a(a2, n2);
            a a4 = this;
            a4.a(a4, n3);
            this.a(a3, n4);
            return a2;
        }

        private a<E> o() {
            a<E> a2 = this.a;
            a<E> a3 = super.j();
            int n2 = this.f + org.valkyrienskies.core.impl.shadow.iX$a.d(a2);
            int n3 = -a2.f;
            int n4 = org.valkyrienskies.core.impl.shadow.iX$a.d(a2) + org.valkyrienskies.core.impl.shadow.iX$a.d(a3);
            this.a(a3, a2);
            a2.b(this, null);
            this.a(a2, n2);
            a a4 = this;
            a4.a(a4, n3);
            this.a(a3, n4);
            return a2;
        }

        void a(a<E> a2, a<E> a3) {
            this.b = a2 == null;
            this.a = this.b ? a3 : a2;
            this.l();
        }

        void b(a<E> a2, a<E> a3) {
            this.d = a2 == null;
            this.c = this.d ? a3 : a2;
            this.l();
        }

        private a<E> b(a<E> a2, int n2) {
            a<E> a3 = this.d();
            a<E> a4 = a2.e();
            if (a2.e > this.e) {
                a<E> a5 = this.f();
                ArrayDeque<a<E>> arrayDeque = new ArrayDeque<a<E>>();
                a<E> a6 = a2;
                int n3 = a6.f + n2;
                int n4 = 0;
                while (a6 != null && a6.e > org.valkyrienskies.core.impl.shadow.iX$a.a(a5)) {
                    n4 = n3;
                    arrayDeque.push(a6);
                    a6 = a6.a;
                    if (a6 == null) continue;
                    n3 += a6.f;
                }
                a3.a(a5, null);
                a3.b(a6, a4);
                if (a5 != null) {
                    a5.d().b(null, a3);
                    a5.f -= n2 - 1;
                }
                if (a6 != null) {
                    a6.e().a(null, a3);
                    a6.f = n3 - n2 + 1;
                }
                a3.f = n2 - 1 - n4;
                a2.f += n2;
                a6 = a3;
                while (!arrayDeque.isEmpty()) {
                    a2 = (a<E>)arrayDeque.pop();
                    a2.a(a6, null);
                    a6 = a2.h();
                }
                return a6;
            }
            a2 = a2.g();
            ArrayDeque<a<E>> arrayDeque = new ArrayDeque<a<E>>();
            a<E> a7 = this;
            int n5 = a7.f;
            int n6 = 0;
            while (a7 != null && a7.e > org.valkyrienskies.core.impl.shadow.iX$a.a(a2)) {
                n6 = n5;
                arrayDeque.push(a7);
                a7 = a7.c;
                if (a7 == null) continue;
                n5 += a7.f;
            }
            a4.b(a2, null);
            a4.a(a7, a3);
            if (a2 != null) {
                a2.e().a(null, a4);
                ++a2.f;
            }
            if (a7 != null) {
                a7.d().b(null, a4);
                a7.f = n5 - n2;
            }
            a4.f = n2 - n6;
            a7 = a4;
            while (!arrayDeque.isEmpty()) {
                a a8 = (a)arrayDeque.pop();
                a8.b(a7, null);
                a7 = a8.h();
            }
            return a7;
        }

        public final String toString() {
            return "AVLNode(" + this.f + ',' + (this.a != null) + ',' + this.g + ',' + (this.j() != null) + ", faedelung " + this.d + " )";
        }

        /* synthetic */ a(Collection collection, byte by) {
            this(collection);
        }

        static /* synthetic */ int b(a a2) {
            return a2.f;
        }

        /* synthetic */ a(int n2, Object object, a a2, a a3, byte by) {
            this(n2, object, null, null);
        }

        static /* synthetic */ a a(a a2, a a3, int n2) {
            return a2.b(a3, n2);
        }

        static /* synthetic */ Object c(a a2) {
            return a2.g;
        }
    }
}

