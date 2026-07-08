/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.valkyrienskies.core.impl.shadow.fu_1;
import org.valkyrienskies.core.impl.shadow.hn_1;
import org.valkyrienskies.core.impl.shadow.ig_1;
import org.valkyrienskies.core.impl.shadow.kq_0;

public final class jF<K, V>
extends kq_0<Map.Entry<K, V>>
implements fu_1 {
    private static final long a = 1678353579659253473L;

    public static <K, V> Set<Map.Entry<K, V>> a(Set<Map.Entry<K, V>> set) {
        if (set instanceof fu_1) {
            return set;
        }
        return new jF<K, V>(set);
    }

    private jF(Set<Map.Entry<K, V>> set) {
        super(set);
    }

    private static boolean a() {
        throw new UnsupportedOperationException();
    }

    @Override
    public final boolean addAll(Collection<? extends Map.Entry<K, V>> coll) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override
    public final boolean remove(Object object) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final boolean removeAll(Collection<?> coll) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final boolean retainAll(Collection<?> coll) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final Iterator<Map.Entry<K, V>> iterator() {
        jF jF2 = this;
        return new b(jF2, jF2.c().iterator());
    }

    @Override
    public final Object[] toArray() {
        Object[] objectArray = this.c().toArray();
        for (int i2 = 0; i2 < objectArray.length; ++i2) {
            objectArray[i2] = new a(this, (Map.Entry)objectArray[i2]);
        }
        return objectArray;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final <T> T[] toArray(T[] array) {
        void var1_1;
        Object[] objectArray = array;
        if (array.length > 0) {
            objectArray = (Object[])Array.newInstance(array.getClass().getComponentType(), 0);
        }
        objectArray = this.c().toArray(objectArray);
        for (int i2 = 0; i2 < objectArray.length; ++i2) {
            objectArray[i2] = new a(this, (Map.Entry)objectArray[i2]);
        }
        if (objectArray.length > array.length) {
            return objectArray;
        }
        System.arraycopy(objectArray, 0, array, 0, objectArray.length);
        if (array.length > objectArray.length) {
            array[objectArray.length] = null;
        }
        return var1_1;
    }

    @Override
    public final /* synthetic */ boolean add(Object object) {
        Map.Entry cfr_ignored_0 = (Map.Entry)object;
        throw new UnsupportedOperationException();
    }

    final class a
    extends ig_1<K, V> {
        private /* synthetic */ jF a;

        protected a(jF jF2, Map.Entry<K, V> entry) {
            this.a = jF2;
            super(entry);
        }

        @Override
        public final V setValue(V obj) {
            throw new UnsupportedOperationException();
        }
    }

    final class b
    extends hn_1<Map.Entry<K, V>> {
        private /* synthetic */ jF a;

        protected b(jF jF2, Iterator<Map.Entry<K, V>> iterator2) {
            this.a = jF2;
            super(iterator2);
        }

        private Map.Entry<K, V> b() {
            return new a(this.a, (Map.Entry)this.a().next());
        }

        @Override
        public final void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public final /* synthetic */ Object next() {
            b b2 = this;
            return new a(b2.a, (Map.Entry)b2.a().next());
        }
    }
}

