/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.valkyrienskies.core.impl.shadow.fW
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.valkyrienskies.core.impl.shadow.ew_1;
import org.valkyrienskies.core.impl.shadow.fW;
import org.valkyrienskies.core.impl.shadow.ga_2;
import org.valkyrienskies.core.impl.shadow.kC;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.fW
 */
public abstract class fw_1<E>
implements ew_1<E> {
    private transient Map<E, b> a;
    private int b;
    private transient int c;
    private transient Set<E> d;

    protected fw_1() {
    }

    protected fw_1(Map<E, b> map2) {
        this.a = map2;
    }

    protected Map<E, b> e() {
        return this.a;
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
            return ((b)object).a;
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

    /*
     * WARNING - void declaration
     */
    @Override
    public boolean containsAll(Collection<?> coll) {
        void var1_1;
        if (coll instanceof ew_1) {
            return this.a((ew_1)coll);
        }
        return this.a(new ga_2(var1_1));
    }

    private boolean a(ew_1<?> ew_12) {
        for (Object obj : ew_12.a()) {
            if (this.a(obj) >= ew_12.a(obj)) continue;
            return false;
        }
        return true;
    }

    @Override
    public Iterator<E> iterator() {
        return new a(this);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public boolean add(E object) {
        void var1_1;
        return this.a(var1_1, 1);
    }

    @Override
    public final boolean a(E e2, int n2) {
        ++this.c;
        if (n2 > 0) {
            b b2 = this.a.get(e2);
            this.b += n2;
            if (b2 == null) {
                this.a.put(e2, new b(n2));
                return true;
            }
            b2.a += n2;
            return false;
        }
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> coll) {
        Iterator iterator2;
        boolean bl = false;
        iterator2 = iterator2.iterator();
        while (iterator2.hasNext()) {
            boolean bl2 = this.add(iterator2.next());
            bl = bl || bl2;
        }
        return bl;
    }

    @Override
    public void clear() {
        ++this.c;
        this.a.clear();
        this.b = 0;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public boolean remove(Object object) {
        void var1_1;
        b b2 = this.a.get(object);
        if (b2 == null) {
            return false;
        }
        ++this.c;
        this.a.remove(var1_1);
        this.b -= b2.a;
        return true;
    }

    @Override
    public final boolean b(Object object, int n2) {
        b b2 = this.a.get(object);
        if (b2 == null) {
            return false;
        }
        if (n2 <= 0) {
            return false;
        }
        ++this.c;
        if (n2 < b2.a) {
            b2.a -= n2;
            this.b -= n2;
        } else {
            this.a.remove(object);
            this.b -= b2.a;
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> coll) {
        boolean bl = false;
        if (coll != null) {
            Iterator iterator2;
            iterator2 = iterator2.iterator();
            while (iterator2.hasNext()) {
                boolean bl2 = this.b(iterator2.next(), 1);
                bl = bl || bl2;
            }
        }
        return bl;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public boolean retainAll(Collection<?> coll) {
        void var1_1;
        if (coll instanceof ew_1) {
            return this.b((ew_1)coll);
        }
        return this.b(new ga_2(var1_1));
    }

    private boolean b(ew_1<?> ew_12) {
        boolean bl = false;
        ga_2<E> ga_22 = new ga_2<E>();
        for (E e2 : this.a()) {
            int n2 = this.a(e2);
            int n3 = ew_12.a(e2);
            if (n3 > 0 && n3 <= n2) {
                ga_22.a(e2, n2 - n3);
                continue;
            }
            ga_22.a(e2, n2);
        }
        if (!ga_22.isEmpty()) {
            bl = this.removeAll(ga_22);
        }
        return bl;
    }

    @Override
    public Object[] toArray() {
        Object[] objectArray = new Object[this.size()];
        int n2 = 0;
        for (E e2 : this.a.keySet()) {
            for (int i2 = this.a(e2); i2 > 0; --i2) {
                objectArray[n2++] = e2;
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
        int n2 = this.size();
        if (array.length < n2) {
            Object[] objectArray = (Object[])Array.newInstance(array.getClass().getComponentType(), n2);
            array = objectArray;
        }
        n2 = 0;
        for (E e2 : this.a.keySet()) {
            for (int i2 = this.a(e2); i2 > 0; --i2) {
                E e3 = e2;
                array[n2++] = e3;
            }
        }
        while (n2 < array.length) {
            array[n2++] = null;
        }
        return var1_1;
    }

    @Override
    public final Set<E> a() {
        if (this.d == null) {
            this.d = kC.a(this.a.keySet());
        }
        return this.d;
    }

    protected final void a(ObjectOutputStream objectOutputStream) {
        objectOutputStream.writeInt(this.a.size());
        for (Map.Entry<E, b> entry : this.a.entrySet()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeInt(entry.getValue().a);
        }
    }

    protected final void a(Map<E, b> map2, ObjectInputStream objectInputStream) {
        this.a = map2;
        int n2 = objectInputStream.readInt();
        for (int i2 = 0; i2 < n2; ++i2) {
            Object object = objectInputStream.readObject();
            int n3 = objectInputStream.readInt();
            map2.put(object, new b(n3));
            this.b += n3;
        }
    }

    @Override
    public boolean equals(Object object) {
        ew_1 ew_12;
        if (object == this) {
            return true;
        }
        if (!(object instanceof ew_1)) {
            return false;
        }
        if ((ew_12 = (ew_1)ew_12).size() != this.size()) {
            return false;
        }
        for (E e2 : this.a.keySet()) {
            if (ew_12.a(e2) == this.a(e2)) continue;
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int n2 = 0;
        for (Map.Entry<E, b> entry : this.a.entrySet()) {
            E e2 = entry.getKey();
            b object = entry.getValue();
            n2 += (e2 == null ? 0 : e2.hashCode()) ^ object.a;
        }
        return n2;
    }

    public String toString() {
        if (this.size() == 0) {
            return "[]";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('[');
        Iterator<E> iterator2 = this.a().iterator();
        while (iterator2.hasNext()) {
            E e2 = iterator2.next();
            int n2 = this.a(e2);
            stringBuilder.append(n2);
            stringBuilder.append(':');
            stringBuilder.append(e2);
            if (!iterator2.hasNext()) continue;
            stringBuilder.append(',');
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    static /* synthetic */ Map a(fw_1 fw_12) {
        return fw_12.a;
    }

    static /* synthetic */ int b(fw_1 fw_12) {
        return fw_12.c;
    }

    static /* synthetic */ int c(fw_1 fw_12) {
        return fw_12.b--;
    }

    protected static final class b {
        protected int a;

        b(int n2) {
            this.a = n2;
        }

        /*
         * WARNING - void declaration
         */
        public final boolean equals(Object obj) {
            void var1_1;
            if (!(obj instanceof b)) {
                return false;
            }
            return ((b)var1_1).a == this.a;
        }

        public final int hashCode() {
            return this.a;
        }
    }

    static final class a<E>
    implements Iterator<E> {
        private final fw_1<E> a;
        private final Iterator<Map.Entry<E, b>> b;
        private Map.Entry<E, b> c;
        private int d;
        private final int e;
        private boolean f;

        public a(fw_1<E> fw_12) {
            this.a = fw_12;
            this.b = fW.a(fw_12).entrySet().iterator();
            this.c = null;
            this.e = fW.b(fw_12);
            this.f = false;
        }

        @Override
        public final boolean hasNext() {
            return this.d > 0 || this.b.hasNext();
        }

        @Override
        public final E next() {
            if (fW.b(this.a) != this.e) {
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
            if (fW.b(this.a) != this.e) {
                throw new ConcurrentModificationException();
            }
            if (!this.f) {
                throw new IllegalStateException();
            }
            b b2 = this.c.getValue();
            if (b2.a > 1) {
                --b2.a;
            } else {
                this.b.remove();
            }
            fW.c(this.a);
            this.f = false;
        }
    }
}

