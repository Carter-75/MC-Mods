/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.valkyrienskies.core.impl.shadow.iM
 *  org.valkyrienskies.core.impl.shadow.iP
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import org.valkyrienskies.core.impl.shadow.iM;
import org.valkyrienskies.core.impl.shadow.iP;
import org.valkyrienskies.core.impl.shadow.im_1;

/*
 * Signature claims super is org.valkyrienskies.core.impl.shadow.im_1<E>, not org.valkyrienskies.core.impl.shadow.iM - discarding signature.
 * Renamed from org.valkyrienskies.core.impl.shadow.iP
 */
public final class ip_1
extends iM
implements Serializable {
    private static final long e = 8836393098519411393L;
    transient List<WeakReference<a<E>>> d;

    public ip_1() {
        this.a();
    }

    private ip_1(Collection<? extends E> collection) {
        super(collection);
    }

    protected final void a() {
        super.a();
        this.d = new ArrayList();
    }

    public final Iterator<E> iterator() {
        return super.listIterator(0);
    }

    public final ListIterator<E> listIterator() {
        return this.a(0);
    }

    /*
     * WARNING - void declaration
     */
    public final ListIterator<E> listIterator(int fromIndex) {
        void var1_1;
        return this.a((int)var1_1);
    }

    private a<E> c() {
        return this.a(0);
    }

    private a<E> a(int n2) {
        a a2 = new a(this, n2);
        this.b(a2);
        return a2;
    }

    protected final void a(im_1.d<E> iterator2, E object) {
        super.a(iterator2, object);
        iterator2 = this;
        iterator2 = ((ip_1)((Object)iterator2)).d.iterator();
        while (iterator2.hasNext()) {
            object = iterator2.next();
            if ((object = (a)((Reference)object).get()) != null) continue;
            iterator2.remove();
        }
    }

    protected final void a(im_1.d<E> iterator2, im_1.d<E> d2) {
        super.a(iterator2, d2);
        d2 = iterator2;
        iterator2 = this;
        iterator2 = ((ip_1)((Object)iterator2)).d.iterator();
        while (iterator2.hasNext()) {
            Object object = iterator2.next();
            if ((object = (a)((Reference)object).get()) == null) {
                iterator2.remove();
                continue;
            }
            ((a)object).b(d2);
        }
    }

    protected final void a(im_1.d<E> iterator2) {
        super.a(iterator2);
        im_1.d d2 = iterator2;
        iterator2 = this;
        iterator2 = ((ip_1)((Object)iterator2)).d.iterator();
        while (iterator2.hasNext()) {
            Object object = iterator2.next();
            if ((object = (a)((Reference)object).get()) == null) {
                iterator2.remove();
                continue;
            }
            ((a)object).a(d2);
        }
    }

    protected final void b() {
        if (this.size() > 0) {
            Iterator iterator2 = this.iterator();
            while (iterator2.hasNext()) {
                iterator2.next();
                iterator2.remove();
            }
        }
    }

    private void b(a<E> a2) {
        Iterator iterator2 = this.d.iterator();
        while (iterator2.hasNext()) {
            WeakReference weakReference = iterator2.next();
            if (weakReference.get() != null) continue;
            iterator2.remove();
        }
        this.d.add(new WeakReference(a2));
    }

    protected final void a(a<E> a2) {
        Iterator iterator2 = this.d.iterator();
        while (iterator2.hasNext()) {
            WeakReference weakReference = iterator2.next();
            a a3 = (a)weakReference.get();
            if (a3 == null) {
                iterator2.remove();
                continue;
            }
            if (a3 != a2) continue;
            weakReference.clear();
            iterator2.remove();
            return;
        }
    }

    private void b(im_1.d<E> object) {
        object = this.d.iterator();
        while (object.hasNext()) {
            Object object2 = (WeakReference)object.next();
            if ((object2 = (a)((Reference)object2).get()) != null) continue;
            object.remove();
        }
    }

    private void c(im_1.d<E> d2) {
        Iterator iterator2 = this.d.iterator();
        while (iterator2.hasNext()) {
            Object object = iterator2.next();
            if ((object = (a)((Reference)object).get()) == null) {
                iterator2.remove();
                continue;
            }
            ((a)object).a(d2);
        }
    }

    private void d(im_1.d<E> d2) {
        Iterator iterator2 = this.d.iterator();
        while (iterator2.hasNext()) {
            Object object = iterator2.next();
            if ((object = (a)((Reference)object).get()) == null) {
                iterator2.remove();
                continue;
            }
            ((a)object).b(d2);
        }
    }

    private void b(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        this.a(objectOutputStream);
    }

    private void b(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.a(objectInputStream);
    }

    protected final ListIterator<E> a(im_1.b<E> object, int n2) {
        object = new b(object, n2);
        this.b((a)object);
        return object;
    }

    protected static final class b<E>
    extends a<E> {
        private im_1.b<E> e;

        protected b(im_1.b<E> b2, int n2) {
            super((iP)b2.a, n2 + b2.b);
            this.e = b2;
        }

        @Override
        public final boolean hasNext() {
            return ((im_1.a)this).nextIndex() < this.e.c;
        }

        @Override
        public final boolean hasPrevious() {
            return ((im_1.a)this).previousIndex() >= 0;
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

    public static class a<E>
    extends im_1.a<E> {
        private boolean e = true;
        private boolean f = true;
        private boolean g = false;

        protected a(ip_1<E> ip_12, int n2) {
            super(ip_12, n2);
        }

        @Override
        public void remove() {
            if (this.d != null || !this.g) {
                this.a();
                this.a.a(this.b());
            }
            this.g = false;
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public void add(E obj) {
            void var1_1;
            super.add(var1_1);
            this.b = this.b.b;
        }

        @Override
        public int nextIndex() {
            if (!this.f) {
                if (this.b == ((iM)this.a).a) {
                    this.c = this.a.size();
                } else {
                    int n2 = 0;
                    im_1.d d2 = ((iM)this.a).a.b;
                    while (d2 != this.b) {
                        ++n2;
                        d2 = d2.b;
                    }
                    this.c = n2;
                }
                this.f = true;
            }
            return this.c;
        }

        protected static void c() {
        }

        protected final void a(im_1.d<E> d2) {
            if (d2 == this.b && d2 == this.d) {
                this.b = d2.b;
                this.d = null;
                this.g = true;
                return;
            }
            if (d2 == this.b) {
                this.b = d2.b;
                this.g = false;
                return;
            }
            if (d2 == this.d) {
                this.d = null;
                this.g = true;
                --this.c;
                return;
            }
            this.f = false;
            this.g = false;
        }

        protected final void b(im_1.d<E> d2) {
            if (d2.a == this.d) {
                this.b = d2;
                return;
            }
            if (this.b.a == d2) {
                this.b = d2;
                return;
            }
            this.f = false;
        }

        @Override
        protected final void a() {
            if (!this.e) {
                throw new ConcurrentModificationException("Cursor closed");
            }
        }

        private void d() {
            if (this.e) {
                a a2 = this;
                Object object = (iP)this.a;
                object = ((iP)object).d.iterator();
                while (object.hasNext()) {
                    WeakReference weakReference = (WeakReference)object.next();
                    a a3 = (a)weakReference.get();
                    if (a3 == null) {
                        object.remove();
                        continue;
                    }
                    if (a3 != a2) continue;
                    weakReference.clear();
                    object.remove();
                    break;
                }
                this.e = false;
            }
        }
    }
}

