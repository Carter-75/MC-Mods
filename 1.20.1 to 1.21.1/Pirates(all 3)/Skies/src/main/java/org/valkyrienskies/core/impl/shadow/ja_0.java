/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.valkyrienskies.core.impl.shadow.hn_1;
import org.valkyrienskies.core.impl.shadow.ig_1;
import org.valkyrienskies.core.impl.shadow.jd_0;
import org.valkyrienskies.core.impl.shadow.kq_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.ja
 */
abstract class ja_0<K, V>
extends jd_0<K, V> {
    protected ja_0() {
    }

    protected ja_0(Map<K, V> map2) {
        super(map2);
    }

    protected abstract V a(V var1);

    protected boolean a() {
        return true;
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.a()) {
            ja_0 ja_02 = this;
            return new a(ja_02, ja_02.a.entrySet(), this);
        }
        return this.a.entrySet();
    }

    final class c
    extends ig_1<K, V> {
        private final ja_0<K, V> a;
        private /* synthetic */ ja_0 b;

        protected c(ja_0 ja_02, Map.Entry<K, V> entry, ja_0<K, V> ja_03) {
            this.b = ja_02;
            super(entry);
            this.a = ja_03;
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public final V setValue(V value) {
            void var1_1;
            value = this.a.a(value);
            return this.a().setValue(var1_1);
        }
    }

    final class b
    extends hn_1<Map.Entry<K, V>> {
        private final ja_0<K, V> a;
        private /* synthetic */ ja_0 b;

        protected b(ja_0 ja_02, Iterator<Map.Entry<K, V>> iterator2, ja_0<K, V> ja_03) {
            this.b = ja_02;
            super(iterator2);
            this.a = ja_03;
        }

        private Map.Entry<K, V> b() {
            Map.Entry entry = (Map.Entry)this.a().next();
            return new c(this.b, entry, this.a);
        }

        @Override
        public final /* synthetic */ Object next() {
            b b2 = this;
            Map.Entry entry = (Map.Entry)b2.a().next();
            return new c(b2.b, entry, b2.a);
        }
    }

    final class a
    extends kq_0<Map.Entry<K, V>> {
        private static final long a = 4354731610923110264L;
        private final ja_0<K, V> b;
        private /* synthetic */ ja_0 c;

        protected a(ja_0 ja_02, Set<Map.Entry<K, V>> set, ja_0<K, V> ja_03) {
            this.c = ja_02;
            super(set);
            this.b = ja_03;
        }

        @Override
        public final Iterator<Map.Entry<K, V>> iterator() {
            return new b(this.c, this.c().iterator(), this.b);
        }

        @Override
        public final Object[] toArray() {
            Object[] objectArray = this.c().toArray();
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                objectArray[i2] = new c(this.c, (Map.Entry)objectArray[i2], this.b);
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
                objectArray[i2] = new c(this.c, (Map.Entry)objectArray[i2], this.b);
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
    }
}

