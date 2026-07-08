/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.valkyrienskies.core.impl.shadow.ed$a
 *  org.valkyrienskies.core.impl.shadow.et
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Provider;
import org.valkyrienskies.core.impl.shadow.dt_1;
import org.valkyrienskies.core.impl.shadow.ed;
import org.valkyrienskies.core.impl.shadow.ed_2;
import org.valkyrienskies.core.impl.shadow.eg_2;
import org.valkyrienskies.core.impl.shadow.et;
import org.valkyrienskies.core.impl.shadow.ew_2;
import org.valkyrienskies.core.impl.shadow.ey_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.et
 */
public final class et_2<K, V>
extends ed_2<K, V, ew_2<V>>
implements dt_1<Map<K, ew_2<V>>> {
    private static <K, V> a<K, V> a(int size) {
        return new a(size, 0);
    }

    private et_2(Map<K, ew_2<V>> contributingMap) {
        super(contributingMap);
    }

    private Map<K, ew_2<V>> b() {
        return this.a();
    }

    @Override
    public final /* synthetic */ Object get() {
        et_2 et_22 = this;
        return et_22.a();
    }

    /* synthetic */ et_2(Map map2, byte by) {
        this(map2);
    }

    /*
     * Signature claims super is org.valkyrienskies.core.impl.shadow.ed$a_0<K, V, org.valkyrienskies.core.impl.shadow.ew_2<V>>, not org.valkyrienskies.core.impl.shadow.ed$a - discarding signature.
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

        private a<K, V> b(ew_2<Map<K, ew_2<V>>> mapProviderFactory) {
            super.a(mapProviderFactory);
            return this;
        }

        @Deprecated
        private a<K, V> a(Provider<Map<K, Provider<V>>> mapProviderFactory) {
            ew_2 ew_22 = new ew_2<Map<K, ew_2<V>>>(){
                private /* synthetic */ Provider a;
                private /* synthetic */ a b;
                {
                    this.b = this$0;
                    this.a = val$mapProviderFactory;
                }

                private Map<K, ew_2<V>> a() {
                    Map map2 = (Map)this.a.get();
                    if (map2.isEmpty()) {
                        return Collections.emptyMap();
                    }
                    LinkedHashMap linkedHashMap = eg_2.c(map2.size());
                    for (Map.Entry entry : map2.entrySet()) {
                        linkedHashMap.put(entry.getKey(), ey_2.a((Provider)((Provider)entry.getValue())));
                    }
                    return Collections.unmodifiableMap(linkedHashMap);
                }

                @Override
                public final /* synthetic */ Object get() {
                    Object object = this;
                    object = (Map)object.a.get();
                    if (object.isEmpty()) {
                        return Collections.emptyMap();
                    }
                    LinkedHashMap linkedHashMap = eg_2.c(object.size());
                    for (Map.Entry entry : object.entrySet()) {
                        linkedHashMap.put(entry.getKey(), ey_2.a((Provider)((Provider)entry.getValue())));
                    }
                    return Collections.unmodifiableMap(linkedHashMap);
                }
            };
            mapProviderFactory = this;
            super.a(ew_22);
            return mapProviderFactory;
        }

        private et_2<K, V> a() {
            return new et((Map)this.a, 0);
        }

        public final /* synthetic */ ed_2.a_0 a(Object key, ew_2 providerOfValue) {
            return this.b(key, providerOfValue);
        }

        /* synthetic */ a(int n2, byte by) {
            this(n2);
        }
    }
}

