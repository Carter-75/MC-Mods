/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.valkyrienskies.core.impl.shadow.iZ
 *  org.valkyrienskies.core.impl.shadow.jf$a
 *  org.valkyrienskies.core.impl.shadow.jf$b
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.valkyrienskies.core.impl.shadow.fu_2;
import org.valkyrienskies.core.impl.shadow.iZ;
import org.valkyrienskies.core.impl.shadow.ii_1;
import org.valkyrienskies.core.impl.shadow.iz_0;
import org.valkyrienskies.core.impl.shadow.jf;
import org.valkyrienskies.core.impl.shadow.jf_0;

/*
 * Signature claims super is org.valkyrienskies.core.impl.shadow.iz_0<K, V>, not org.valkyrienskies.core.impl.shadow.iZ - discarding signature.
 * Renamed from org.valkyrienskies.core.impl.shadow.jf
 */
public abstract class jf_0
extends iZ {
    private h j;
    private h k;
    private boolean l;
    private transient ReferenceQueue<Object> m;

    protected jf_0() {
    }

    protected jf_0(h h2, h h3, int n2, float f2, boolean bl) {
        super(n2, f2);
        this.j = h2;
        this.k = h3;
        this.l = bl;
    }

    protected final void d() {
        this.m = new ReferenceQueue();
    }

    public int size() {
        jf_0 jf_02 = this;
        jf_02.e();
        return super.size();
    }

    public boolean isEmpty() {
        jf_0 jf_02 = this;
        jf_02.e();
        return super.isEmpty();
    }

    public boolean containsKey(Object key) {
        iz_0.c c2;
        jf_0 jf_02 = this;
        jf_02.e();
        c2 = this.e(c2);
        if (c2 == null) {
            return false;
        }
        return c2.getValue() != null;
    }

    /*
     * WARNING - void declaration
     */
    public boolean containsValue(Object value) {
        void var1_1;
        jf_0 jf_02 = this;
        jf_02.e();
        if (value == null) {
            return false;
        }
        return super.containsValue((Object)var1_1);
    }

    public V get(Object key) {
        iz_0.c c2;
        jf_0 jf_02 = this;
        jf_02.e();
        c2 = this.e(c2);
        if (c2 == null) {
            return null;
        }
        return c2.getValue();
    }

    /*
     * WARNING - void declaration
     */
    public V put(K key, V value) {
        void var2_2;
        void var1_1;
        if (key == null) {
            throw new NullPointerException("null keys not allowed");
        }
        if (value == null) {
            throw new NullPointerException("null values not allowed");
        }
        jf_0 jf_02 = this;
        jf_02.e();
        return super.put((Object)var1_1, (Object)var2_2);
    }

    /*
     * WARNING - void declaration
     */
    public V remove(Object key) {
        void var1_1;
        if (key == null) {
            return null;
        }
        jf_0 jf_02 = this;
        jf_02.e();
        return super.remove((Object)var1_1);
    }

    public void clear() {
        super.clear();
        while (this.m.poll() != null) {
        }
    }

    public final fu_2<K, V> c() {
        return new g(this);
    }

    public Set<Map.Entry<K, V>> entrySet() {
        if (this.g == null) {
            this.g = new c(this);
        }
        return this.g;
    }

    public Set<K> keySet() {
        if (this.h == null) {
            this.h = new e(this);
        }
        return this.h;
    }

    public Collection<V> values() {
        if (this.i == null) {
            this.i = new i(this);
        }
        return this.i;
    }

    private void a() {
        this.e();
    }

    private void b() {
        this.e();
    }

    private void e() {
        Reference<Object> reference = this.m.poll();
        while (reference != null) {
            this.a(reference);
            reference = this.m.poll();
        }
    }

    private void a(Reference<?> reference) {
        int n2 = reference.hashCode();
        int n3 = n2;
        int n4 = this.d.length;
        n3 = n2;
        n3 = n2 & n4 - 1;
        iz_0.c c2 = null;
        iz_0.c c3 = this.d[n3];
        while (c3 != null) {
            if (((jf.b)c3).a(reference)) {
                if (c2 == null) {
                    this.d[n3] = c3.a;
                } else {
                    c2.a = c3.a;
                }
                --this.c;
                return;
            }
            c2 = c3;
            c3 = c3.a;
        }
    }

    protected final iz_0.c<K, V> e(Object object) {
        if (object == null) {
            return null;
        }
        return super.e(object);
    }

    protected int c(Object object, Object object2) {
        return (object == null ? 0 : object.hashCode()) ^ (object2 == null ? 0 : object2.hashCode());
    }

    protected boolean a(Object object, Object object2) {
        Object object3 = object2 = this.j == h.HARD ? object2 : ((Reference)object2).get();
        return object == object2 || object.equals(object2);
    }

    private b_0<K, V> b(iz_0.c<K, V> c2, int n2, K k2, V v) {
        return new jf.b(this, c2, n2, k2, v);
    }

    protected final Iterator<Map.Entry<K, V>> f() {
        return new d(this);
    }

    protected final Iterator<K> g() {
        return new f(this);
    }

    protected final Iterator<V> h() {
        return new j(this);
    }

    protected final void a(ObjectOutputStream objectOutputStream) {
        objectOutputStream.writeInt(this.j.value);
        objectOutputStream.writeInt(this.k.value);
        objectOutputStream.writeBoolean(this.l);
        objectOutputStream.writeFloat(this.b);
        objectOutputStream.writeInt(this.d.length);
        fu_2 fu_22 = this.c();
        while (fu_22.hasNext()) {
            objectOutputStream.writeObject(fu_22.next());
            objectOutputStream.writeObject(fu_22.b());
        }
        objectOutputStream.writeObject(null);
    }

    protected final void a(ObjectInputStream objectInputStream) {
        Object object;
        this.j = h.a(objectInputStream.readInt());
        this.k = h.a(objectInputStream.readInt());
        this.l = objectInputStream.readBoolean();
        this.b = objectInputStream.readFloat();
        int n2 = objectInputStream.readInt();
        this.d();
        this.d = new iz_0.c[n2];
        float f2 = this.b;
        n2 = this.d.length;
        this.e = (int)((float)n2 * f2);
        while ((object = objectInputStream.readObject()) != null) {
            Object object2 = objectInputStream.readObject();
            this.put(object, object2);
        }
    }

    protected final boolean a(h h2) {
        return this.j == h2;
    }

    protected final /* synthetic */ iz_0.c a(iz_0.c object, int n2, Object object2, Object object3) {
        Object object4 = object3;
        object3 = object2;
        int n3 = n2;
        iz_0.c c2 = object;
        object = this;
        return new jf.b((jf_0)((Object)object), c2, n3, object3, object4);
    }

    static /* synthetic */ h a(jf_0 jf_02) {
        return jf_02.j;
    }

    static /* synthetic */ h b(jf_0 jf_02) {
        return jf_02.k;
    }

    static /* synthetic */ ReferenceQueue c(jf_0 jf_02) {
        return jf_02.m;
    }

    static /* synthetic */ boolean d(jf_0 jf_02) {
        return jf_02.l;
    }

    static final class l<T>
    extends WeakReference<T> {
        private final int a;

        public l(int n2, T t, ReferenceQueue<? super T> referenceQueue) {
            super(t, referenceQueue);
            this.a = n2;
        }

        public final int hashCode() {
            return this.a;
        }
    }

    static final class k<T>
    extends SoftReference<T> {
        private final int a;

        public k(int n2, T t, ReferenceQueue<? super T> referenceQueue) {
            super(t, referenceQueue);
            this.a = n2;
        }

        public final int hashCode() {
            return this.a;
        }
    }

    /*
     * Signature claims super is org.valkyrienskies.core.impl.shadow.jf$a_0<K, V>, not org.valkyrienskies.core.impl.shadow.jf$a - discarding signature.
     */
    static final class g
    extends jf.a
    implements fu_2 {
        protected g(jf_0<K, V> jf_02) {
            super(jf_02);
        }

        @Override
        public final K next() {
            return ((iz_0.c)this.c()).getKey();
        }

        @Override
        public final K a() {
            b_0 b_02 = this.d();
            if (b_02 == null) {
                throw new IllegalStateException("getKey() can only be called after next() and before remove()");
            }
            return ((iz_0.c)b_02).getKey();
        }

        @Override
        public final V b() {
            b_0 b_02 = this.d();
            if (b_02 == null) {
                throw new IllegalStateException("getValue() can only be called after next() and before remove()");
            }
            return ((iz_0.c)b_02).getValue();
        }

        @Override
        public final V a(V v) {
            b_0 b_02 = this.d();
            if (b_02 == null) {
                throw new IllegalStateException("setValue() can only be called after next() and before remove()");
            }
            return ((iz_0.c)b_02).setValue(v);
        }
    }

    /*
     * Signature claims super is org.valkyrienskies.core.impl.shadow.jf$a_0<java.lang.Object, V>, not org.valkyrienskies.core.impl.shadow.jf$a - discarding signature.
     */
    static final class j
    extends jf.a
    implements Iterator {
        j(jf_0<?, V> jf_02) {
            super(jf_02);
        }

        public final V next() {
            return ((iz_0.c)this.c()).getValue();
        }
    }

    /*
     * Signature claims super is org.valkyrienskies.core.impl.shadow.jf$a_0<K, java.lang.Object>, not org.valkyrienskies.core.impl.shadow.jf$a - discarding signature.
     */
    static final class f
    extends jf.a
    implements Iterator {
        f(jf_0<K, ?> jf_02) {
            super(jf_02);
        }

        public final K next() {
            return ((iz_0.c)this.c()).getKey();
        }
    }

    /*
     * Signature claims super is org.valkyrienskies.core.impl.shadow.jf$a_0<K, V>, not org.valkyrienskies.core.impl.shadow.jf$a - discarding signature.
     */
    static final class d
    extends jf.a
    implements Iterator {
        public d(jf_0<K, V> jf_02) {
            super(jf_02);
        }

        private Map.Entry<K, V> a() {
            return this.c();
        }

        public final /* synthetic */ Object next() {
            d d2 = this;
            return d2.c();
        }
    }

    static final class i<V>
    extends iz_0.h<V> {
        /*
         * Ignored method signature, as it can't be verified against descriptor
         */
        protected i(jf_0 jf_02) {
            super(jf_02);
        }

        @Override
        public final Object[] toArray() {
            i i2 = this;
            return i2.toArray(new Object[i2.size()]);
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public final <T> T[] toArray(T[] arr) {
            void var1_1;
            ArrayList arrayList = new ArrayList(this.size());
            for (Object v : this) {
                arrayList.add(v);
            }
            return arrayList.toArray((T[])var1_1);
        }
    }

    static final class e<K>
    extends iz_0.f<K> {
        /*
         * Ignored method signature, as it can't be verified against descriptor
         */
        protected e(jf_0 jf_02) {
            super(jf_02);
        }

        @Override
        public final Object[] toArray() {
            e e2 = this;
            return e2.toArray(new Object[e2.size()]);
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public final <T> T[] toArray(T[] arr) {
            void var1_1;
            ArrayList arrayList = new ArrayList(this.size());
            for (Object k2 : this) {
                arrayList.add(k2);
            }
            return arrayList.toArray((T[])var1_1);
        }
    }

    static final class c<K, V>
    extends iz_0.a<K, V> {
        /*
         * Ignored method signature, as it can't be verified against descriptor
         */
        protected c(jf_0 jf_02) {
            super(jf_02);
        }

        @Override
        public final Object[] toArray() {
            c c2 = this;
            return c2.toArray(new Object[c2.size()]);
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public final <T> T[] toArray(T[] arr) {
            void var1_1;
            ArrayList arrayList = new ArrayList(this.size());
            for (Map.Entry entry : this) {
                arrayList.add(new ii_1(entry));
            }
            return arrayList.toArray((T[])var1_1);
        }
    }

    public static enum h {
        HARD(0),
        SOFT(1),
        WEAK(2);

        public final int value;

        public static h a(int n2) {
            switch (n2) {
                case 0: {
                    return HARD;
                }
                case 1: {
                    return SOFT;
                }
                case 2: {
                    return WEAK;
                }
            }
            throw new IllegalArgumentException();
        }

        private h(int n3) {
            this.value = n3;
        }
    }
}

