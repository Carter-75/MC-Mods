/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.valkyrienskies.core.impl.shadow.fy
 *  org.valkyrienskies.core.impl.shadow.fy$a
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.AbstractCollection;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import org.valkyrienskies.core.impl.shadow.fq_1;
import org.valkyrienskies.core.impl.shadow.fq_2;
import org.valkyrienskies.core.impl.shadow.fy;
import org.valkyrienskies.core.impl.shadow.fy_2;

public abstract class jS<E>
extends AbstractCollection<E>
implements fy_2<E> {
    private transient Set<E> a;
    private transient Set<fy_2.a_0<E>> b;

    @Override
    public int size() {
        int n2 = 0;
        for (fy.a a2 : this.b()) {
            n2 += a2.b();
        }
        return n2;
    }

    @Override
    public int a(Object object) {
        for (fy.a a2 : this.b()) {
            Object object2 = a2.a();
            if (object2 != object && (object2 == null || !object2.equals(object))) continue;
            return a2.b();
        }
        return 0;
    }

    @Override
    public final int a(E e2, int n2) {
        if (n2 < 0) {
            throw new IllegalArgumentException("Count must not be negative.");
        }
        int n3 = this.a(e2);
        if (n3 < n2) {
            this.b(e2, n2 - n3);
        } else {
            this.c(e2, n3 - n2);
        }
        return n3;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public boolean contains(Object object) {
        void var1_1;
        return this.a(var1_1) > 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new c(this);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public boolean add(E object) {
        void var1_1;
        this.b(var1_1, 1);
        return true;
    }

    @Override
    public int b(E e2, int n2) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        Iterator<fy_2.a_0<E>> iterator2 = this.b().iterator();
        while (iterator2.hasNext()) {
            iterator2.next();
            iterator2.remove();
        }
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public boolean remove(Object object) {
        void var1_1;
        return this.c(var1_1, 1) != 0;
    }

    @Override
    public int c(Object object, int n2) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection<?> coll) {
        Iterator iterator2;
        boolean bl = false;
        iterator2 = iterator2.iterator();
        while (iterator2.hasNext()) {
            Object e2 = iterator2.next();
            boolean bl2 = this.c(e2, this.a(e2)) != 0;
            bl = bl || bl2;
        }
        return bl;
    }

    @Override
    public final Set<E> a() {
        if (this.a == null) {
            jS jS2 = this;
            this.a = new d(jS2);
        }
        return this.a;
    }

    private Set<E> f() {
        return new d(this);
    }

    protected Iterator<E> e() {
        fq_1 fq_12 = new fq_1<fy_2.a_0<E>, E>(this){
            private /* synthetic */ jS a;
            {
                this.a = jS2;
            }

            private static E a(fy_2.a_0<E> a_02) {
                return a_02.a();
            }
        };
        return fq_2.a(this.b().iterator(), (fq_1)fq_12);
    }

    @Override
    public final Set<fy_2.a_0<E>> b() {
        if (this.b == null) {
            jS jS2 = this;
            this.b = new b(jS2);
        }
        return this.b;
    }

    private Set<fy_2.a_0<E>> g() {
        return new b(this);
    }

    protected abstract int c();

    protected abstract Iterator<fy_2.a_0<E>> d();

    protected void a(ObjectOutputStream objectOutputStream) {
        objectOutputStream.writeInt(this.b().size());
        for (fy.a a2 : this.b()) {
            objectOutputStream.writeObject(a2.a());
            objectOutputStream.writeInt(a2.b());
        }
    }

    protected void a(ObjectInputStream objectInputStream) {
        int n2 = objectInputStream.readInt();
        for (int i2 = 0; i2 < n2; ++i2) {
            Object object = objectInputStream.readObject();
            int n3 = objectInputStream.readInt();
            this.a(object, n3);
        }
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
        if ((fy2 = (fy)fy2).size() != this.size()) {
            return false;
        }
        for (fy.a a2 : this.b()) {
            if (fy2.a(a2.a()) == this.a(a2.a())) continue;
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return this.b().hashCode();
    }

    @Override
    public String toString() {
        return this.b().toString();
    }

    public static abstract class a<E>
    implements fy_2.a_0<E> {
        @Override
        public boolean equals(Object object) {
            if (object instanceof fy.a) {
                fy.a a2;
                a2 = a2;
                Object e2 = this.a();
                Object object2 = a2.a();
                return this.b() == a2.b() && (e2 == object2 || e2 != null && e2.equals(object2));
            }
            return false;
        }

        @Override
        public int hashCode() {
            Object e2 = this.a();
            return (e2 == null ? 0 : e2.hashCode()) ^ this.b();
        }

        public String toString() {
            return String.format("%s:%d", this.a(), this.b());
        }
    }

    protected static final class b<E>
    extends AbstractSet<fy_2.a_0<E>> {
        private final jS<E> a;

        protected b(jS<E> jS2) {
            this.a = jS2;
        }

        @Override
        public final int size() {
            return this.a.c();
        }

        @Override
        public final Iterator<fy_2.a_0<E>> iterator() {
            return this.a.d();
        }

        @Override
        public final boolean contains(Object obj) {
            fy.a a2;
            if (!(obj instanceof fy.a)) {
                return false;
            }
            Object object = (a2 = (fy.a)a2).a();
            return this.a.a(object) == a2.b();
        }

        @Override
        public final boolean remove(Object obj) {
            fy.a a2;
            if (!(obj instanceof fy.a)) {
                return false;
            }
            Object object = (a2 = (fy.a)a2).a();
            if (this.a.contains(object)) {
                int n2 = this.a.a(object);
                if (a2.b() == n2) {
                    this.a.c(object, n2);
                    return true;
                }
            }
            return false;
        }
    }

    protected static final class d<E>
    extends AbstractSet<E> {
        private jS<E> a;

        protected d(jS<E> jS2) {
            this.a = jS2;
        }

        @Override
        public final Iterator<E> iterator() {
            return this.a.e();
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public final boolean contains(Object key) {
            void var1_1;
            return this.a.contains(var1_1);
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public final boolean containsAll(Collection<?> coll) {
            void var1_1;
            return this.a.containsAll((Collection<?>)var1_1);
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public final boolean remove(Object key) {
            void var1_1;
            return this.a.c(key, this.a.a(var1_1)) != 0;
        }

        @Override
        public final int size() {
            return this.a.c();
        }

        @Override
        public final void clear() {
            this.a.clear();
        }
    }

    static final class c<E>
    implements Iterator<E> {
        private final jS<E> a;
        private final Iterator<fy_2.a_0<E>> b;
        private fy_2.a_0<E> c;
        private int d;
        private boolean e;

        public c(jS<E> jS2) {
            this.a = jS2;
            this.b = jS2.b().iterator();
            this.c = null;
            this.e = false;
        }

        @Override
        public final boolean hasNext() {
            return this.d > 0 || this.b.hasNext();
        }

        @Override
        public final E next() {
            if (this.d == 0) {
                this.c = (fy.a)this.b.next();
                this.d = this.c.b();
            }
            this.e = true;
            --this.d;
            return (E)this.c.a();
        }

        @Override
        public final void remove() {
            if (!this.e) {
                throw new IllegalStateException();
            }
            int n2 = this.c.b();
            if (n2 > 1) {
                this.a.remove(this.c.a());
            } else {
                this.b.remove();
            }
            this.e = false;
        }
    }
}

