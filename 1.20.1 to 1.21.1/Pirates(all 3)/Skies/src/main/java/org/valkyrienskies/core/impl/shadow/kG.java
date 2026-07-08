/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Map;
import org.valkyrienskies.core.impl.shadow.fs_1;
import org.valkyrienskies.core.impl.shadow.kI;

public abstract class kG<K, V>
extends AbstractMap<K, V>
implements Serializable,
fs_1<K, V> {
    private static final long b = 5826987063535505652L;
    final kI<? super K> a;

    protected kG(kI<? super K> kI2) {
        if (kI2 == null) {
            throw new NullPointerException("keyAnalyzer");
        }
        this.a = kI2;
    }

    protected final kI<? super K> a() {
        return this.a;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Trie[").append(this.size()).append("]={\n");
        for (Map.Entry entry : this.entrySet()) {
            stringBuilder.append("  ").append(entry).append("\n");
        }
        stringBuilder.append("}\n");
        return stringBuilder.toString();
    }

    static K b(Object object) {
        return object;
    }

    final int e(K k2) {
        if (k2 == null) {
            return 0;
        }
        return this.a.a(k2);
    }

    private int b() {
        return this.a.a();
    }

    final boolean a(K k2, int n2, int n3) {
        if (k2 == null) {
            return false;
        }
        return this.a.a(k2, n2, n3);
    }

    final int a(K k2, K k3) {
        return this.a.a(k2, 0, this.e(k2), k3, 0, this.e(k3));
    }

    final boolean b(K k2, K k3) {
        if (k2 == null) {
            return k3 == null;
        }
        if (k3 == null) {
            return false;
        }
        return this.a.compare(k2, k3) == 0;
    }

    static boolean c(Object object, Object object2) {
        if (object == null) {
            return object2 == null;
        }
        return object.equals(object2);
    }

    static abstract class a<K, V>
    implements Serializable,
    Map.Entry<K, V> {
        private static final long c = -944364551314110330L;
        protected K a;
        protected V b;

        private a(K k2) {
            this.a = k2;
        }

        public a(K k2, V v) {
            this.a = k2;
            this.b = v;
        }

        public final V a(K k2, V v) {
            this.a = k2;
            return this.setValue(v);
        }

        @Override
        public K getKey() {
            return this.a;
        }

        @Override
        public V getValue() {
            return this.b;
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public V setValue(V value) {
            void var1_1;
            V v = this.b;
            this.b = var1_1;
            return v;
        }

        @Override
        public int hashCode() {
            return (this.getKey() == null ? 0 : this.getKey().hashCode()) ^ (this.getValue() == null ? 0 : this.getValue().hashCode());
        }

        @Override
        public boolean equals(Object o) {
            Map.Entry entry;
            if (o == this) {
                return true;
            }
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            return kG.c(this.a, (entry = (Map.Entry)entry).getKey()) && kG.c(this.b, entry.getValue());
        }

        public String toString() {
            return this.a + "=" + this.b;
        }
    }
}

