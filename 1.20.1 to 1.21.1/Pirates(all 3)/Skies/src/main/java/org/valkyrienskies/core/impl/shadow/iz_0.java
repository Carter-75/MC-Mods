/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.valkyrienskies.core.impl.shadow.iZ
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import org.valkyrienskies.core.impl.shadow.fn_2;
import org.valkyrienskies.core.impl.shadow.fr_2;
import org.valkyrienskies.core.impl.shadow.fu_2;
import org.valkyrienskies.core.impl.shadow.hw_1;
import org.valkyrienskies.core.impl.shadow.hy_1;
import org.valkyrienskies.core.impl.shadow.iZ;
import org.valkyrienskies.core.impl.shadow.jc_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.iZ
 */
public class iz_0<K, V>
extends AbstractMap<K, V>
implements fn_2<K, V> {
    private static String j = "No next() entry in the iteration";
    private static String k = "No previous() entry in the iteration";
    private static String l = "remove() can only be called once after next()";
    private static String m = "getKey() can only be called after next() and before remove()";
    private static String n = "getValue() can only be called after next() and before remove()";
    private static String o = "setValue() can only be called after next() and before remove()";
    private static int p = 16;
    private static int q = 12;
    private static float r = 0.75f;
    private static int s = 0x40000000;
    protected static final Object a = new Object();
    transient float b;
    transient int c;
    transient c<K, V>[] d;
    transient int e;
    transient int f;
    transient a<K, V> g;
    transient f<K> h;
    transient h<V> i;

    protected iz_0() {
    }

    protected iz_0(int n2, float f2, int n3) {
        this.b = f2;
        this.d = new c[n2];
        this.e = n3;
        this.d();
    }

    protected iz_0(int n2) {
        this(n2, 0.75f);
    }

    protected iz_0(int n2, float f2) {
        if (n2 < 0) {
            throw new IllegalArgumentException("Initial capacity must be a non negative number");
        }
        if (f2 <= 0.0f || Float.isNaN(f2)) {
            throw new IllegalArgumentException("Load factor must be greater than 0");
        }
        this.b = f2;
        n2 = iz_0.b(n2);
        float f3 = f2;
        int n3 = n2;
        this.e = (int)((float)n3 * f3);
        this.d = new c[n2];
        this.d();
    }

    protected iz_0(Map<? extends K, ? extends V> map2) {
        this(Math.max(2 * map2.size(), 16), 0.75f);
        super.a(map2);
    }

    protected void d() {
    }

    @Override
    public V get(Object key) {
        key = this.a(key);
        int n2 = this.b(key);
        int n3 = this.d.length;
        int n4 = n2;
        c<K, V> c2 = this.d[n4 & n3 - 1];
        while (c2 != null) {
            if (c2.b == n2 && this.a(key, c2.c)) {
                return c2.getValue();
            }
            c2 = c2.a;
        }
        return null;
    }

    @Override
    public int size() {
        return this.c;
    }

    @Override
    public boolean isEmpty() {
        return this.c == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        key = this.a(key);
        int n2 = this.b(key);
        int n3 = this.d.length;
        int n4 = n2;
        c<K, V> c2 = this.d[n4 & n3 - 1];
        while (c2 != null) {
            if (c2.b == n2 && this.a(key, c2.c)) {
                return true;
            }
            c2 = c2.a;
        }
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        if (value == null) {
            c<K, V>[] cArray = this.d;
            int n2 = this.d.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                c<K, V> c2 = cArray[i2];
                while (c2 != null) {
                    if (c2.getValue() == null) {
                        return true;
                    }
                    c2 = c2.a;
                }
            }
        } else {
            c<K, V>[] cArray = this.d;
            int n3 = this.d.length;
            for (int i3 = 0; i3 < n3; ++i3) {
                c<K, V> c3 = cArray[i3];
                while (c3 != null) {
                    if (this.b(value, c3.getValue())) {
                        return true;
                    }
                    c3 = c3.a;
                }
            }
        }
        return false;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public V put(K key, V value) {
        void var2_2;
        V v;
        Object object = this.a(key);
        int n2 = this.b(object);
        int n3 = this.d.length;
        int n4 = n2;
        n4 = n2 & n3 - 1;
        c<K, V> c2 = this.d[n4];
        while (c2 != null) {
            if (c2.b == n2 && this.a(object, c2.c)) {
                v = c2.getValue();
                this.a(c2, value);
                return v;
            }
            c2 = c2.a;
        }
        this.a(n4, n2, v, var2_2);
        return null;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public void putAll(Map<? extends K, ? extends V> map2) {
        void var1_1;
        this.a((Map<? extends K, ? extends V>)var1_1);
    }

    private void a(Map<? extends K, ? extends V> object) {
        int n2 = object.size();
        if (n2 == 0) {
            return;
        }
        int entry = (int)((float)(this.c + n2) / this.b + 1.0f);
        this.a(iz_0.b(entry));
        for (Map.Entry entry2 : object.entrySet()) {
            this.put(entry2.getKey(), entry2.getValue());
        }
    }

    @Override
    public V remove(Object key) {
        key = this.a(key);
        int n2 = this.b(key);
        int n3 = this.d.length;
        int n4 = n2;
        n4 = n2 & n3 - 1;
        c<K, V> c2 = this.d[n4];
        c<K, V> c3 = null;
        while (c2 != null) {
            if (c2.b == n2 && this.a(key, c2.c)) {
                V v = c2.getValue();
                this.a(c2, n4, c3);
                return v;
            }
            c3 = c2;
            c2 = c2.a;
        }
        return null;
    }

    @Override
    public void clear() {
        ++this.f;
        c<K, V>[] cArray = this.d;
        for (int i2 = this.d.length - 1; i2 >= 0; --i2) {
            cArray[i2] = null;
        }
        this.c = 0;
    }

    protected Object a(Object object) {
        if (object == null) {
            return a;
        }
        return object;
    }

    protected int b(Object object) {
        int n2 = object.hashCode();
        n2 += ~(n2 << 9);
        n2 ^= n2 >>> 14;
        n2 += n2 << 4;
        n2 ^= n2 >>> 10;
        return n2;
    }

    protected boolean a(Object object, Object object2) {
        return object == object2 || object.equals(object2);
    }

    protected boolean b(Object object, Object object2) {
        return object == object2 || object.equals(object2);
    }

    protected static int a(int n2, int n3) {
        return n2 & n3 - 1;
    }

    protected c<K, V> e(Object object) {
        object = this.a(object);
        int n2 = this.b(object);
        int n3 = this.d.length;
        int n4 = n2;
        c<K, V> c2 = this.d[n4 & n3 - 1];
        while (c2 != null) {
            if (c2.b == n2 && this.a(object, c2.c)) {
                return c2;
            }
            c2 = c2.a;
        }
        return null;
    }

    protected void a(c<K, V> c2, V v) {
        c2.setValue(v);
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    protected final void a(jc_0.c_0 c_02, int n2, int n3, Object object, Object object2) {
        c_02.a = this.d[n2];
        c_02.b = n3;
        c_02.c = object;
        c_02.d = object2;
    }

    protected void a(int n2, int n3, K k2, V v) {
        int n4;
        ++this.f;
        iz_0 iz_02 = this;
        c<K, V> c2 = iz_02.a(iz_02.d[n2], n3, k2, v);
        this.a(c2, n2);
        ++this.c;
        iz_0 iz_03 = this;
        if (iz_03.c >= iz_03.e && (n4 = iz_03.d.length << 1) <= 0x40000000) {
            iz_03.a(n4);
        }
    }

    protected c<K, V> a(c<K, V> c2, int n2, K k2, V v) {
        return new c<K, V>(c2, n2, this.a(k2), v);
    }

    protected void a(c<K, V> c2, int n2) {
        this.d[n2] = c2;
    }

    protected final void a(c<K, V> c2, int n2, c<K, V> c3) {
        ++this.f;
        this.b(c2, n2, c3);
        --this.c;
        iz_0.a(c2);
    }

    protected void b(c<K, V> c2, int n2, c<K, V> c3) {
        if (c3 == null) {
            this.d[n2] = c2.a;
            return;
        }
        c3.a = c2.a;
    }

    private static void a(c<K, V> c2) {
        c2.a = null;
        c2.c = null;
        c2.d = null;
    }

    private void a() {
        int n2;
        if (this.c >= this.e && (n2 = this.d.length << 1) <= 0x40000000) {
            this.a(n2);
        }
    }

    private void a(int n2) {
        int n3;
        int n4 = this.d.length;
        if (n2 <= n4) {
            return;
        }
        if (this.c == 0) {
            float f2 = this.b;
            int n5 = n2;
            this.e = (int)((float)n5 * f2);
            this.d = new c[n2];
            return;
        }
        c<K, V>[] cArray = this.d;
        c[] cArray2 = new c[n2];
        ++this.f;
        --n4;
        while (n4 >= 0) {
            c<K, V> c2 = cArray[n4];
            if (c2 != null) {
                c c3;
                cArray[n4] = null;
                do {
                    c3 = c2.a;
                    int n6 = n2;
                    n3 = c2.b;
                    c2.a = cArray2[n3 &= n6 - 1];
                    cArray2[n3] = c2;
                } while ((c2 = c3) != null);
            }
            --n4;
        }
        float f3 = this.b;
        n3 = n2;
        this.e = (int)((float)n3 * f3);
        this.d = cArray2;
    }

    private static int b(int n2) {
        int n3;
        if (n2 > 0x40000000) {
            n3 = 0x40000000;
        } else {
            for (n3 = 1; n3 < n2; n3 <<= 1) {
            }
            if (n3 > 0x40000000) {
                n3 = 0x40000000;
            }
        }
        return n3;
    }

    protected static int a(int n2, float f2) {
        return (int)((float)n2 * f2);
    }

    private static c<K, V> b(c<K, V> c2) {
        return c2.a;
    }

    private static int c(c<K, V> c2) {
        return c2.b;
    }

    private static K d(c<K, V> c2) {
        return c2.getKey();
    }

    private static V e(c<K, V> c2) {
        return c2.getValue();
    }

    @Override
    public fu_2<K, V> c() {
        if (this.c == 0) {
            return hy_1.d();
        }
        return new e(this);
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.g == null) {
            this.g = new a(this);
        }
        return this.g;
    }

    protected Iterator<Map.Entry<K, V>> f() {
        if (this.size() == 0) {
            return hw_1.b();
        }
        return new b(this);
    }

    @Override
    public Set<K> keySet() {
        if (this.h == null) {
            this.h = new f(this);
        }
        return this.h;
    }

    protected Iterator<K> g() {
        if (this.size() == 0) {
            return hw_1.b();
        }
        return new g(this);
    }

    @Override
    public Collection<V> values() {
        if (this.i == null) {
            this.i = new h(this);
        }
        return this.i;
    }

    protected Iterator<V> h() {
        if (this.size() == 0) {
            return hw_1.b();
        }
        return new i(this);
    }

    protected void a(ObjectOutputStream objectOutputStream) {
        objectOutputStream.writeFloat(this.b);
        objectOutputStream.writeInt(this.d.length);
        objectOutputStream.writeInt(this.c);
        fu_2<K, V> fu_22 = this.c();
        while (fu_22.hasNext()) {
            objectOutputStream.writeObject(fu_22.next());
            objectOutputStream.writeObject(fu_22.b());
        }
    }

    protected void a(ObjectInputStream objectInputStream) {
        this.b = objectInputStream.readFloat();
        int n2 = objectInputStream.readInt();
        int n3 = objectInputStream.readInt();
        this.d();
        float f2 = this.b;
        int n4 = n2;
        this.e = (int)((float)n4 * f2);
        this.d = new c[n2];
        for (n2 = 0; n2 < n3; ++n2) {
            Object object = objectInputStream.readObject();
            Object object2 = objectInputStream.readObject();
            this.put(object, object2);
        }
    }

    protected iz_0<K, V> i() {
        try {
            iz_0 iz_02 = (iz_0)super.clone();
            ((iz_0)super.clone()).d = new c[this.d.length];
            iz_02.g = null;
            iz_02.h = null;
            iz_02.i = null;
            iz_02.f = 0;
            iz_02.c = 0;
            iz_02.d();
            iz_02.putAll(this);
            return iz_02;
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            throw new InternalError();
        }
    }

    @Override
    public boolean equals(Object obj) {
        Map map2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        if ((map2 = (Map)map2).size() != this.size()) {
            return false;
        }
        fu_2<K, V> fu_22 = this.c();
        try {
            while (fu_22.hasNext()) {
                K k2 = fu_22.next();
                V v = fu_22.b();
                if (!(v == null ? map2.get(k2) != null || !map2.containsKey(k2) : !v.equals(map2.get(k2)))) continue;
                return false;
            }
        }
        catch (ClassCastException classCastException) {
            return false;
        }
        catch (NullPointerException nullPointerException) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int n2 = 0;
        Iterator<Map.Entry<K, V>> iterator2 = this.f();
        while (iterator2.hasNext()) {
            n2 += iterator2.next().hashCode();
        }
        return n2;
    }

    @Override
    public String toString() {
        if (this.size() == 0) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(32 * this.size());
        stringBuilder.append('{');
        fu_2<K, V> fu_22 = this.c();
        boolean bl = fu_22.hasNext();
        while (bl) {
            K k2 = fu_22.next();
            V v = fu_22.b();
            stringBuilder.append((Object)(k2 == this ? "(this Map)" : k2)).append('=').append((Object)(v == this ? "(this Map)" : v));
            bl = fu_22.hasNext();
            if (!bl) continue;
            stringBuilder.append(',').append(' ');
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    @Override
    protected /* synthetic */ Object clone() {
        return this.i();
    }

    protected static abstract class d<K, V> {
        private final iz_0<K, V> a;
        private int b;
        private c<K, V> c;
        private c<K, V> d;
        private int e;

        protected d(iz_0<K, V> iz_02) {
            this.a = iz_02;
            c[] cArray = ((iZ)iz_02).d;
            int n2 = ((iZ)iz_02).d.length;
            c c2 = null;
            while (n2 > 0 && c2 == null) {
                c2 = cArray[--n2];
            }
            this.d = c2;
            this.b = n2;
            this.e = ((iZ)iz_02).f;
        }

        public boolean hasNext() {
            return this.d != null;
        }

        protected final c<K, V> c() {
            if (((iZ)this.a).f != this.e) {
                throw new ConcurrentModificationException();
            }
            c<K, V> c2 = this.d;
            if (c2 == null) {
                throw new NoSuchElementException("No next() entry in the iteration");
            }
            c[] cArray = ((iZ)this.a).d;
            int n2 = this.b;
            c c3 = c2.a;
            while (c3 == null && n2 > 0) {
                c3 = cArray[--n2];
            }
            this.d = c3;
            this.b = n2;
            this.c = c2;
            return c2;
        }

        protected final c<K, V> d() {
            return this.c;
        }

        public void remove() {
            if (this.c == null) {
                throw new IllegalStateException("remove() can only be called once after next()");
            }
            if (((iZ)this.a).f != this.e) {
                throw new ConcurrentModificationException();
            }
            this.a.remove(this.c.getKey());
            this.c = null;
            this.e = ((iZ)this.a).f;
        }

        public String toString() {
            if (this.c != null) {
                return "Iterator[" + this.c.getKey() + "=" + this.c.getValue() + "]";
            }
            return "Iterator[]";
        }
    }

    protected static class c<K, V>
    implements Map.Entry<K, V>,
    fr_2<K, V> {
        protected c<K, V> a;
        protected int b;
        protected Object c;
        protected Object d;

        protected c(c<K, V> c2, int n2, Object object, V v) {
            this.a = c2;
            this.b = n2;
            this.c = object;
            this.d = v;
        }

        @Override
        public K getKey() {
            if (this.c == iZ.a) {
                return null;
            }
            return (K)this.c;
        }

        @Override
        public V getValue() {
            return (V)this.d;
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public V setValue(V value) {
            void var1_1;
            Object object = this.d;
            this.d = var1_1;
            return (V)object;
        }

        @Override
        public boolean equals(Object obj) {
            Map.Entry entry;
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            entry = entry;
            return (this.getKey() == null ? entry.getKey() == null : this.getKey().equals(entry.getKey())) && (this.getValue() == null ? entry.getValue() == null : this.getValue().equals(entry.getValue()));
        }

        @Override
        public int hashCode() {
            return (this.getKey() == null ? 0 : this.getKey().hashCode()) ^ (this.getValue() == null ? 0 : this.getValue().hashCode());
        }

        public String toString() {
            return "" + this.getKey() + '=' + this.getValue();
        }
    }

    protected static final class i<V>
    extends d<Object, V>
    implements Iterator<V> {
        protected i(iz_0<?, V> iz_02) {
            super(iz_02);
        }

        @Override
        public final V next() {
            return super.c().getValue();
        }
    }

    protected static class h<V>
    extends AbstractCollection<V> {
        private final iz_0<?, V> a;

        protected h(iz_0<?, V> iz_02) {
            this.a = iz_02;
        }

        @Override
        public int size() {
            return this.a.size();
        }

        @Override
        public void clear() {
            this.a.clear();
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public boolean contains(Object value) {
            void var1_1;
            return this.a.containsValue(var1_1);
        }

        @Override
        public Iterator<V> iterator() {
            return this.a.h();
        }
    }

    protected static final class g<K>
    extends d<K, Object>
    implements Iterator<K> {
        protected g(iz_0<K, ?> iz_02) {
            super(iz_02);
        }

        @Override
        public final K next() {
            return super.c().getKey();
        }
    }

    protected static class f<K>
    extends AbstractSet<K> {
        private final iz_0<K, ?> a;

        protected f(iz_0<K, ?> iz_02) {
            this.a = iz_02;
        }

        @Override
        public int size() {
            return this.a.size();
        }

        @Override
        public void clear() {
            this.a.clear();
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public boolean contains(Object key) {
            void var1_1;
            return this.a.containsKey(var1_1);
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public boolean remove(Object key) {
            void var1_1;
            boolean bl = this.a.containsKey(key);
            this.a.remove(var1_1);
            return bl;
        }

        @Override
        public Iterator<K> iterator() {
            return this.a.g();
        }
    }

    protected static final class b<K, V>
    extends d<K, V>
    implements Iterator<Map.Entry<K, V>> {
        protected b(iz_0<K, V> iz_02) {
            super(iz_02);
        }

        private Map.Entry<K, V> a() {
            return super.c();
        }

        @Override
        public final /* synthetic */ Object next() {
            b b2 = this;
            return super.c();
        }
    }

    protected static class a<K, V>
    extends AbstractSet<Map.Entry<K, V>> {
        private final iz_0<K, V> a;

        protected a(iz_0<K, V> iz_02) {
            this.a = iz_02;
        }

        @Override
        public int size() {
            return this.a.size();
        }

        @Override
        public void clear() {
            this.a.clear();
        }

        @Override
        public boolean contains(Object entry) {
            if (entry instanceof Map.Entry) {
                Map.Entry entry2;
                c c2 = this.a.e((entry2 = (Map.Entry)entry2).getKey());
                return c2 != null && c2.equals(entry2);
            }
            return false;
        }

        @Override
        public boolean remove(Object obj) {
            Map.Entry entry;
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            if (!this.contains(obj)) {
                return false;
            }
            entry = entry;
            this.a.remove(entry.getKey());
            return true;
        }

        @Override
        public Iterator<Map.Entry<K, V>> iterator() {
            return this.a.f();
        }
    }

    protected static final class e<K, V>
    extends d<K, V>
    implements fu_2<K, V> {
        protected e(iz_0<K, V> iz_02) {
            super(iz_02);
        }

        @Override
        public final K next() {
            return super.c().getKey();
        }

        @Override
        public final K a() {
            c c2 = this.d();
            if (c2 == null) {
                throw new IllegalStateException("getKey() can only be called after next() and before remove()");
            }
            return c2.getKey();
        }

        @Override
        public final V b() {
            c c2 = this.d();
            if (c2 == null) {
                throw new IllegalStateException("getValue() can only be called after next() and before remove()");
            }
            return c2.getValue();
        }

        @Override
        public final V a(V v) {
            c c2 = this.d();
            if (c2 == null) {
                throw new IllegalStateException("setValue() can only be called after next() and before remove()");
            }
            return c2.setValue(v);
        }
    }
}

