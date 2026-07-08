/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.valkyrienskies.core.impl.shadow.eq
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.valkyrienskies.core.impl.shadow.cx_0;
import org.valkyrienskies.core.impl.shadow.ek_2;
import org.valkyrienskies.core.impl.shadow.eq;
import org.valkyrienskies.core.impl.shadow.ew_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.eq
 */
public final class eq_2<V>
implements Map<Class<?>, V> {
    private final Map<String, V> a;

    public static <V> Map<Class<?>, V> a(Map<String, V> delegate) {
        return new eq_2<V>(delegate);
    }

    private eq_2(Map<String, V> delegate) {
        this.a = delegate;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final V get(@cx_0 Object key) {
        void var1_1;
        if (!(key instanceof Class)) {
            throw new IllegalArgumentException("Key must be a class");
        }
        return this.a.get(((Class)var1_1).getName());
    }

    @Override
    public final Set<Class<?>> keySet() {
        throw new UnsupportedOperationException("Maps created with @LazyClassKey do not support usage of keySet(). Consider @ClassKey instead.");
    }

    @Override
    public final Collection<V> values() {
        return this.a.values();
    }

    @Override
    public final boolean isEmpty() {
        return this.a.isEmpty();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final boolean containsKey(@cx_0 Object key) {
        void var1_1;
        if (!(key instanceof Class)) {
            throw new IllegalArgumentException("Key must be a class");
        }
        return this.a.containsKey(((Class)var1_1).getName());
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final boolean containsValue(@cx_0 Object value) {
        void var1_1;
        return this.a.containsValue(var1_1);
    }

    @Override
    public final int size() {
        return this.a.size();
    }

    @Override
    public final Set<Map.Entry<Class<?>, V>> entrySet() {
        throw new UnsupportedOperationException("Maps created with @LazyClassKey do not support usage of entrySet(). Consider @ClassKey instead.");
    }

    @Override
    public final V remove(@cx_0 Object key) {
        throw new UnsupportedOperationException("Dagger map bindings are immutable");
    }

    @Override
    public final void clear() {
        throw new UnsupportedOperationException("Dagger map bindings are immutable");
    }

    private static V a() {
        throw new UnsupportedOperationException("Dagger map bindings are immutable");
    }

    @Override
    public final void putAll(Map<? extends Class<?>, ? extends V> map2) {
        throw new UnsupportedOperationException("Dagger map bindings are immutable");
    }

    @Override
    public final /* synthetic */ Object put(Object key, Object value) {
        Class cfr_ignored_0 = (Class)key;
        throw new UnsupportedOperationException("Dagger map bindings are immutable");
    }

    public static final class b<V>
    implements ek_2<Map<Class<?>, ew_2<V>>> {
        private ek_2<Map<String, ew_2<V>>> a;

        private static <V> b<V> a(ek_2<Map<String, ew_2<V>>> delegate) {
            return new b<V>(delegate);
        }

        private b(ek_2<Map<String, ew_2<V>>> delegate) {
            this.a = delegate;
        }

        private Map<Class<?>, ew_2<V>> a() {
            return eq.a((Map)((Map)this.a.get()));
        }

        @Override
        public final /* synthetic */ Object get() {
            b b2 = this;
            return eq.a((Map)((Map)b2.a.get()));
        }
    }

    public static final class a<V>
    implements ek_2<Map<Class<?>, V>> {
        private ek_2<Map<String, V>> a;

        private static <V> a<V> a(ek_2<Map<String, V>> delegate) {
            return new a<V>(delegate);
        }

        private a(ek_2<Map<String, V>> delegate) {
            this.a = delegate;
        }

        private Map<Class<?>, V> a() {
            return eq.a((Map)((Map)this.a.get()));
        }

        @Override
        public final /* synthetic */ Object get() {
            a a2 = this;
            return eq.a((Map)((Map)a2.a.get()));
        }
    }
}

