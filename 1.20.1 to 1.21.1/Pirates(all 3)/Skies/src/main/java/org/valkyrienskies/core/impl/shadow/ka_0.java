/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;
import org.valkyrienskies.core.impl.shadow.ez_1;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.ka
 */
public final class ka_0<E>
extends AbstractCollection<E>
implements Serializable,
Queue<E>,
ez_1<E> {
    private static final long a = -8423413834657610406L;
    private transient E[] b;
    private transient int c = 0;
    private transient int d = 0;
    private transient boolean e = false;
    private final int f;

    public ka_0() {
        this(32);
    }

    private ka_0(int n2) {
        if (n2 <= 0) {
            throw new IllegalArgumentException("The size must be greater than 0");
        }
        this.b = new Object[n2];
        this.f = this.b.length;
    }

    private ka_0(Collection<? extends E> collection) {
        this(collection.size());
        this.addAll(collection);
    }

    private void a(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(this.size());
        for (E e2 : this) {
            objectOutputStream.writeObject(e2);
        }
    }

    private void a(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.b = new Object[this.f];
        int n2 = objectInputStream.readInt();
        for (int i2 = 0; i2 < n2; ++i2) {
            this.b[i2] = objectInputStream.readObject();
        }
        this.c = 0;
        boolean bl = this.e = n2 == this.f;
        if (this.e) {
            this.d = 0;
            return;
        }
        this.d = n2;
    }

    @Override
    public final int size() {
        int n2 = this.d < this.c ? this.f - this.c + this.d : (this.d == this.c ? (this.e ? this.f : 0) : this.d - this.c);
        return n2;
    }

    @Override
    public final boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public final boolean a() {
        return false;
    }

    private boolean c() {
        return this.size() == this.f;
    }

    @Override
    public final int b() {
        return this.f;
    }

    @Override
    public final void clear() {
        this.e = false;
        this.c = 0;
        this.d = 0;
        Arrays.fill(this.b, null);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final boolean add(E element) {
        void var1_1;
        if (element == null) {
            throw new NullPointerException("Attempted to add null object to queue");
        }
        ka_0 ka_02 = this;
        if (ka_02.size() == ka_02.f) {
            this.remove();
        }
        this.b[this.d++] = var1_1;
        if (this.d >= this.f) {
            this.d = 0;
        }
        if (this.d == this.c) {
            this.e = true;
        }
        return true;
    }

    private E a(int n2) {
        int n3 = this.size();
        if (n2 < 0 || n2 >= n3) {
            throw new NoSuchElementException(String.format("The specified index (%1$d) is outside the available range [0, %2$d)", n2, n3));
        }
        n2 = (this.c + n2) % this.f;
        return this.b[n2];
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final boolean offer(E element) {
        void var1_1;
        return this.add(var1_1);
    }

    @Override
    public final E poll() {
        if (this.isEmpty()) {
            return null;
        }
        return this.remove();
    }

    @Override
    public final E element() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("queue is empty");
        }
        return this.peek();
    }

    @Override
    public final E peek() {
        if (this.isEmpty()) {
            return null;
        }
        return this.b[this.c];
    }

    @Override
    public final E remove() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("queue is empty");
        }
        E e2 = this.b[this.c];
        if (e2 != null) {
            this.b[this.c++] = null;
            if (this.c >= this.f) {
                this.c = 0;
            }
            this.e = false;
        }
        return e2;
    }

    private int b(int n2) {
        if (++n2 >= this.f) {
            n2 = 0;
        }
        return n2;
    }

    private int c(int n2) {
        if (--n2 < 0) {
            n2 = this.f - 1;
        }
        return n2;
    }

    @Override
    public final Iterator<E> iterator() {
        return new Iterator<E>(this){
            private int a;
            private int b;
            private boolean c;
            private /* synthetic */ ka_0 d;
            {
                this.d = ka_02;
                this.a = this.d.c;
                this.b = -1;
                this.c = this.d.e;
            }

            @Override
            public final boolean hasNext() {
                return this.c || this.a != this.d.d;
            }

            @Override
            public final E next() {
                if (!this.hasNext()) {
                    throw new NoSuchElementException();
                }
                this.c = false;
                this.b = this.a;
                this.a = ka_0.a(this.d, this.a);
                return this.d.b[this.b];
            }

            @Override
            public final void remove() {
                if (this.b == -1) {
                    throw new IllegalStateException();
                }
                if (this.b == this.d.c) {
                    this.d.remove();
                    this.b = -1;
                    return;
                }
                int n2 = this.b + 1;
                if (this.d.c < this.b && n2 < this.d.d) {
                    System.arraycopy(this.d.b, n2, this.d.b, this.b, this.d.d - n2);
                } else {
                    while (n2 != this.d.d) {
                        if (n2 >= this.d.f) {
                            ((ka_0)this.d).b[n2 - 1] = this.d.b[0];
                            n2 = 0;
                            continue;
                        }
                        ((ka_0)this.d).b[ka_0.b((ka_0)this.d, (int)n2)] = this.d.b[n2];
                        n2 = ka_0.a(this.d, n2);
                    }
                }
                this.b = -1;
                this.d.d = ka_0.b(this.d, this.d.d);
                ((ka_0)this.d).b[((ka_0)this.d).d] = null;
                ka_0.a(this.d, false);
                this.a = ka_0.b(this.d, this.a);
            }
        };
    }

    static /* synthetic */ int a(ka_0 ka_02, int n2) {
        if (++n2 >= ka_02.f) {
            n2 = 0;
        }
        return n2;
    }

    static /* synthetic */ int b(ka_0 ka_02, int n2) {
        if (--n2 < 0) {
            n2 = ka_02.f - 1;
        }
        return n2;
    }

    static /* synthetic */ boolean a(ka_0 ka_02, boolean bl) {
        ka_02.e = false;
        return false;
    }
}

