/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.Co
 */
public class co_0<K, V> {
    public final K a;
    public final V b;

    public co_0(K k2, V v) {
        this.a = k2;
        this.b = v;
    }

    private co_0(co_0<? extends K, ? extends V> co_02) {
        co_0<K, V> co_03 = co_02;
        this(co_03.a, co_02.c());
    }

    public final K e() {
        return this.a;
    }

    public V c() {
        return this.b;
    }

    public final K f() {
        return this.a;
    }

    public final V g() {
        return this.b;
    }

    public boolean equals(Object o) {
        co_0 co_02;
        if (this == o) {
            return true;
        }
        if (!(o instanceof co_0)) {
            return false;
        }
        co_02 = co_02;
        return (this.a == null ? co_02.a == null : this.a.equals(co_02.a)) && (this.b == null ? co_02.b == null : this.b.equals(co_02.b));
    }

    public int hashCode() {
        int n2 = this.a == null ? 0 : this.a.hashCode();
        int n3 = this.b == null ? 0 : this.b.hashCode();
        n2 = n2 * 37 + n3 ^ n3 >>> 16;
        return n2;
    }

    public String toString() {
        co_0 co_02 = this;
        return "[" + co_02.a + ", " + this.c() + "]";
    }

    private static <K, V> co_0<K, V> a(K k2, V v) {
        return new co_0<K, V>(k2, v);
    }
}

