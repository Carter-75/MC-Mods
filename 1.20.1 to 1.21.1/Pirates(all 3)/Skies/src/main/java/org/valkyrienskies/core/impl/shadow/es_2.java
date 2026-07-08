/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.valkyrienskies.core.impl.shadow.ed$a
 *  org.valkyrienskies.core.impl.shadow.es
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Provider;
import org.valkyrienskies.core.impl.shadow.ed;
import org.valkyrienskies.core.impl.shadow.ed_2;
import org.valkyrienskies.core.impl.shadow.eg_2;
import org.valkyrienskies.core.impl.shadow.eo_2;
import org.valkyrienskies.core.impl.shadow.es;
import org.valkyrienskies.core.impl.shadow.ew_2;
import org.valkyrienskies.core.impl.shadow.ey_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.es
 */
public final class es_2<K, V>
extends ed_2<K, V, V> {
    private static final ew_2<Map<Object, Object>> a = eo_2.a(Collections.emptyMap());

    private static <K, V> a<K, V> a(int size) {
        return new a(size, 0);
    }

    private static <K, V> ew_2<Map<K, V>> b() {
        return a;
    }

    private es_2(Map<K, ew_2<V>> map2) {
        super(map2);
    }

    private Map<K, V> c() {
        LinkedHashMap linkedHashMap = eg_2.c(this.a().size());
        for (Map.Entry entry : this.a().entrySet()) {
            linkedHashMap.put(entry.getKey(), entry.getValue().get());
        }
        return Collections.unmodifiableMap(linkedHashMap);
    }

    @Override
    public final /* synthetic */ Object get() {
        es_2 es_22 = this;
        LinkedHashMap linkedHashMap = eg_2.c(es_22.a().size());
        for (Map.Entry entry : es_22.a().entrySet()) {
            linkedHashMap.put(entry.getKey(), ((ew_2)entry.getValue()).get());
        }
        return Collections.unmodifiableMap(linkedHashMap);
    }

    /* synthetic */ es_2(Map map2, byte by) {
        this(map2);
    }

    /*
     * Signature claims super is org.valkyrienskies.core.impl.shadow.ed$a_0<K, V, V>, not org.valkyrienskies.core.impl.shadow.ed$a - discarding signature.
     */
    public static final class a
    extends ed.a {
        private a(int size) {
            super(size);
        }

        private a<K, V> b(K key, ew_2<V> providerOfValue) {
            super.a(key, providerOfValue);
            return this;
        }

        @Deprecated
        private a<K, V> a(K key, Provider<V> providerOfValue) {
            return this.b(key, ey_2.a(providerOfValue));
        }

        private a<K, V> b(ew_2<Map<K, V>> mapFactory) {
            super.a(mapFactory);
            return this;
        }

        @Deprecated
        private a<K, V> a(Provider<Map<K, V>> mapFactory) {
            ey_2.1 var2_2 = ey_2.a(mapFactory);
            mapFactory = this;
            super.a((ew_2)var2_2);
            return mapFactory;
        }

        private es_2<K, V> a() {
            return new es((Map)this.a, 0);
        }

        public final /* synthetic */ ed_2.a_0 a(Object key, ew_2 providerOfValue) {
            return this.b(key, providerOfValue);
        }

        /* synthetic */ a(int n2, byte by) {
            this(n2);
        }
    }
}

