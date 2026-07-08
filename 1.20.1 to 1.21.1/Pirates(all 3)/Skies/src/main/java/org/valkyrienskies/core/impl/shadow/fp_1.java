/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.valkyrienskies.core.impl.shadow.fh_1;
import org.valkyrienskies.core.impl.shadow.fl_2;
import org.valkyrienskies.core.impl.shadow.fm_2;
import org.valkyrienskies.core.impl.shadow.fn_2;
import org.valkyrienskies.core.impl.shadow.fu_1;
import org.valkyrienskies.core.impl.shadow.fu_2;
import org.valkyrienskies.core.impl.shadow.fv_2;
import org.valkyrienskies.core.impl.shadow.gc_1;
import org.valkyrienskies.core.impl.shadow.ib_1;
import org.valkyrienskies.core.impl.shadow.jF;
import org.valkyrienskies.core.impl.shadow.jk_0;
import org.valkyrienskies.core.impl.shadow.kC;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.fP
 */
public final class fp_1 {
    private fp_1() {
    }

    private static <K, V> fn_2<K, V> a(fl_2<K, V> fl_22) {
        if (fl_22 == null) {
            throw new NullPointerException("Get must not be null");
        }
        if (fl_22 instanceof Map) {
            if (fl_22 instanceof fn_2) {
                return (fn_2)fl_22;
            }
            return fv_2.a((Map)((Object)fl_22));
        }
        return new a(fl_22, 0);
    }

    private static <K, V> Map<K, V> a(fh_1<K, V> fh_12) {
        if (fh_12 == null) {
            throw new NullPointerException("Put must not be null");
        }
        if (fh_12 instanceof Map) {
            return (Map)((Object)fh_12);
        }
        return new b(fh_12, 0);
    }

    static final class b<K, V>
    implements Map<K, V>,
    fh_1<K, V> {
        private final fh_1<K, V> a;

        private b(fh_1<K, V> fh_12) {
            this.a = fh_12;
        }

        @Override
        public final void clear() {
            this.a.clear();
        }

        @Override
        public final boolean containsKey(Object key) {
            throw new UnsupportedOperationException();
        }

        @Override
        public final boolean containsValue(Object value) {
            throw new UnsupportedOperationException();
        }

        @Override
        public final Set<Map.Entry<K, V>> entrySet() {
            throw new UnsupportedOperationException();
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public final boolean equals(Object obj) {
            void var1_1;
            if (obj == this) {
                return true;
            }
            return obj instanceof b && ((b)var1_1).a.equals(this.a);
        }

        @Override
        public final V get(Object key) {
            throw new UnsupportedOperationException();
        }

        @Override
        public final int hashCode() {
            return "WrappedPut".hashCode() << 4 | this.a.hashCode();
        }

        @Override
        public final boolean isEmpty() {
            throw new UnsupportedOperationException();
        }

        @Override
        public final Set<K> keySet() {
            throw new UnsupportedOperationException();
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public final V put(K key, V value) {
            void var2_2;
            void var1_1;
            return (V)this.a.put(var1_1, var2_2);
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public final void putAll(Map<? extends K, ? extends V> t) {
            void var1_1;
            this.a.putAll((Map<K, V>)var1_1);
        }

        @Override
        public final V remove(Object key) {
            throw new UnsupportedOperationException();
        }

        @Override
        public final int size() {
            throw new UnsupportedOperationException();
        }

        @Override
        public final Collection<V> values() {
            throw new UnsupportedOperationException();
        }

        /* synthetic */ b(fh_1 fh_12, byte by) {
            this(fh_12);
        }
    }

    static final class a<K, V>
    implements fu_1,
    fn_2<K, V> {
        private final fl_2<K, V> a;

        private a(fl_2<K, V> fl_22) {
            this.a = fl_22;
        }

        @Override
        public final void clear() {
            throw new UnsupportedOperationException();
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public final boolean containsKey(Object key) {
            void var1_1;
            return this.a.containsKey(var1_1);
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public final boolean containsValue(Object value) {
            void var1_1;
            return this.a.containsValue(var1_1);
        }

        @Override
        public final Set<Map.Entry<K, V>> entrySet() {
            return jF.a(this.a.entrySet());
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public final boolean equals(Object arg0) {
            void var1_1;
            if (arg0 == this) {
                return true;
            }
            return arg0 instanceof a && ((a)var1_1).a.equals(this.a);
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public final V get(Object key) {
            void var1_1;
            return this.a.get(var1_1);
        }

        @Override
        public final int hashCode() {
            return "WrappedGet".hashCode() << 4 | this.a.hashCode();
        }

        @Override
        public final boolean isEmpty() {
            return this.a.isEmpty();
        }

        @Override
        public final Set<K> keySet() {
            return kC.a(this.a.keySet());
        }

        @Override
        public final V put(K key, V value) {
            throw new UnsupportedOperationException();
        }

        @Override
        public final void putAll(Map<? extends K, ? extends V> t) {
            throw new UnsupportedOperationException();
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public final V remove(Object key) {
            void var1_1;
            return this.a.remove(var1_1);
        }

        @Override
        public final int size() {
            return this.a.size();
        }

        @Override
        public final Collection<V> values() {
            return gc_1.b(this.a.values());
        }

        @Override
        public final fu_2<K, V> c() {
            fu_2 fu_22 = this.a instanceof fm_2 ? ((fm_2)this.a).c() : new jk_0<K, V>(this.a.entrySet());
            return ib_1.a(fu_22);
        }

        /* synthetic */ a(fl_2 fl_22, byte by) {
            this(fl_22);
        }
    }
}

