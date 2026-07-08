/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.valkyrienskies.core.impl.shadow.fy
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import org.valkyrienskies.core.impl.shadow.fy;
import org.valkyrienskies.core.impl.shadow.fy_2;
import org.valkyrienskies.core.impl.shadow.hn_1;
import org.valkyrienskies.core.impl.shadow.jS;

public abstract class jR<E>
extends jS<E> {
    private transient Map<E, d> a;
    private transient int b;
    private transient int c;

    protected jR() {
    }

    protected jR(Map<E, d> map2) {
        this.a = map2;
    }

    private Map<E, d> f() {
        return this.a;
    }

    protected final void a(Map<E, d> map2) {
        this.a = map2;
    }

    @Override
    public int size() {
        return this.b;
    }

    @Override
    public boolean isEmpty() {
        return this.a.isEmpty();
    }

    @Override
    public final int a(Object object) {
        if ((object = this.a.get(object)) != null) {
            return ((d)object).a;
        }
        return 0;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public boolean contains(Object object) {
        void var1_1;
        return this.a.containsKey(var1_1);
    }

    @Override
    public Iterator<E> iterator() {
        return new b(this);
    }

    @Override
    public final int b(E e2, int n2) {
        int n3;
        if (n2 < 0) {
            throw new IllegalArgumentException("Occurrences must not be negative.");
        }
        d d2 = this.a.get(e2);
        int n4 = n3 = d2 != null ? d2.a : 0;
        if (n2 > 0) {
            ++this.c;
            this.b += n2;
            if (d2 == null) {
                this.a.put(e2, new d(n2));
            } else {
                d2.a += n2;
            }
        }
        return n3;
    }

    @Override
    public void clear() {
        ++this.c;
        this.a.clear();
        this.b = 0;
    }

    @Override
    public final int c(Object object, int n2) {
        if (n2 < 0) {
            throw new IllegalArgumentException("Occurrences must not be negative.");
        }
        d d2 = this.a.get(object);
        if (d2 == null) {
            return 0;
        }
        int n3 = d2.a;
        if (n2 > 0) {
            ++this.c;
            if (n2 < d2.a) {
                d2.a -= n2;
                this.b -= n2;
            } else {
                this.a.remove(object);
                this.b -= d2.a;
            }
        }
        return n3;
    }

    @Override
    protected final Iterator<E> e() {
        jR jR2 = this;
        return new e<E>(jR2.a.keySet().iterator(), this);
    }

    @Override
    protected final int c() {
        return this.a.size();
    }

    @Override
    protected final Iterator<fy_2.a_0<E>> d() {
        return new a<E>(this.a.entrySet().iterator(), this);
    }

    @Override
    protected final void a(ObjectOutputStream objectOutputStream) {
        objectOutputStream.writeInt(this.a.size());
        for (Map.Entry<E, d> entry : this.a.entrySet()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeInt(entry.getValue().a);
        }
    }

    @Override
    protected final void a(ObjectInputStream objectInputStream) {
        int n2 = objectInputStream.readInt();
        for (int i2 = 0; i2 < n2; ++i2) {
            Object object = objectInputStream.readObject();
            int n3 = objectInputStream.readInt();
            this.a.put(object, new d(n3));
            this.b += n3;
        }
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public Object[] toArray() {
        Object[] objectArray = new Object[((jS)this).size()];
        int n2 = 0;
        for (Map.Entry<E, d> object : this.a.entrySet()) {
            void i2;
            E e2 = object.getKey();
            d d2 = object.getValue();
            int n3 = d2.a;
            while (i2 > 0) {
                objectArray[n2++] = e2;
                --i2;
            }
        }
        return objectArray;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public <T> T[] toArray(T[] array) {
        void var1_1;
        int n2 = ((jS)this).size();
        if (array.length < n2) {
            Object[] objectArray = (Object[])Array.newInstance(array.getClass().getComponentType(), n2);
            array = objectArray;
        }
        n2 = 0;
        for (Map.Entry<E, d> object : this.a.entrySet()) {
            void i2;
            E e2 = object.getKey();
            d d2 = object.getValue();
            int n3 = d2.a;
            while (i2 > 0) {
                E e3 = e2;
                array[n2++] = e3;
                --i2;
            }
        }
        while (n2 < array.length) {
            array[n2++] = null;
        }
        return var1_1;
    }

    @Override
    public boolean equals(Object object) {
        fy fy2;
        if (object == this) {
            return true;
        }
        if (!(object instanceof fy)) {
            return false;
        }
        if ((fy2 = (fy)fy2).size() != ((jS)this).size()) {
            return false;
        }
        for (E e2 : this.a.keySet()) {
            if (fy2.a(e2) == ((jS)this).a(e2)) continue;
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int n2 = 0;
        for (Map.Entry<E, d> entry : this.a.entrySet()) {
            E e2 = entry.getKey();
            d object = entry.getValue();
            n2 += (e2 == null ? 0 : e2.hashCode()) ^ object.a;
        }
        return n2;
    }

    protected static final class c<E>
    extends jS.a<E> {
        private Map.Entry<E, d> a;

        protected c(Map.Entry<E, d> entry) {
            this.a = entry;
        }

        @Override
        public final E a() {
            return this.a.getKey();
        }

        @Override
        public final int b() {
            return this.a.getValue().a;
        }
    }

    protected static final class a<E>
    implements Iterator<fy_2.a_0<E>> {
        private jR<E> a;
        private Iterator<Map.Entry<E, d>> b;
        private fy_2.a_0<E> c = null;
        private boolean d = false;

        protected a(Iterator<Map.Entry<E, d>> iterator2, jR<E> jR2) {
            this.b = iterator2;
            this.a = jR2;
        }

        @Override
        public final boolean hasNext() {
            return this.b.hasNext();
        }

        private fy_2.a_0<E> a() {
            this.c = new c<E>(this.b.next());
            this.d = true;
            return this.c;
        }

        @Override
        public final void remove() {
            if (!this.d) {
                throw new IllegalStateException("Iterator remove() can only be called once after next()");
            }
            this.b.remove();
            this.c = null;
            this.d = false;
        }

        @Override
        public final /* synthetic */ Object next() {
            a a2 = this;
            this.c = new c<E>(a2.b.next());
            a2.d = true;
            return a2.c;
        }
    }

    protected static final class e<E>
    extends hn_1<E> {
        private jR<E> a;
        private E b = null;
        private boolean c = false;

        protected e(Iterator<E> iterator2, jR<E> jR2) {
            super(iterator2);
            this.a = jR2;
        }

        @Override
        public final E next() {
            this.b = super.next();
            this.c = true;
            return this.b;
        }

        @Override
        public final void remove() {
            if (!this.c) {
                throw new IllegalStateException("Iterator remove() can only be called once after next()");
            }
            int n2 = ((jS)this.a).a(this.b);
            super.remove();
            ((jS)this.a).c(this.b, n2);
            this.b = null;
            this.c = false;
        }
    }

    protected static final class d {
        protected int a;

        d(int n2) {
            this.a = n2;
        }

        /*
         * WARNING - void declaration
         */
        public final boolean equals(Object obj) {
            void var1_1;
            if (!(obj instanceof d)) {
                return false;
            }
            return ((d)var1_1).a == this.a;
        }

        public final int hashCode() {
            return this.a;
        }
    }

    static final class b<E>
    implements Iterator<E> {
        private final jR<E> a;
        private final Iterator<Map.Entry<E, d>> b;
        private Map.Entry<E, d> c;
        private int d;
        private final int e;
        private boolean f;

        public b(jR<E> jR2) {
            this.a = jR2;
            this.b = ((jR)jR2).a.entrySet().iterator();
            this.c = null;
            this.e = ((jR)jR2).c;
            this.f = false;
        }

        @Override
        public final boolean hasNext() {
            return this.d > 0 || this.b.hasNext();
        }

        @Override
        public final E next() {
            if (((jR)this.a).c != this.e) {
                throw new ConcurrentModificationException();
            }
            if (this.d == 0) {
                this.c = this.b.next();
                this.d = this.c.getValue().a;
            }
            this.f = true;
            --this.d;
            return this.c.getKey();
        }

        @Override
        public final void remove() {
            if (((jR)this.a).c != this.e) {
                throw new ConcurrentModificationException();
            }
            if (!this.f) {
                throw new IllegalStateException();
            }
            d d2 = this.c.getValue();
            if (d2.a > 1) {
                --d2.a;
            } else {
                this.b.remove();
            }
            ((jR)this.a).b--;
            this.f = false;
        }
    }
}

