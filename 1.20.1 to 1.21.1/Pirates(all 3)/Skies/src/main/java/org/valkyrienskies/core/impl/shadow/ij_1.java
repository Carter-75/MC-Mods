/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import java.util.Arrays;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.iJ
 */
public final class ij_1<K>
implements Serializable {
    private static final long b = 4465448607415788805L;
    public final K[] a;
    private transient int c;

    public ij_1(K k2, K k3) {
        this(new Object[]{k2, k3}, false);
    }

    public ij_1(K k2, K k3, K k4) {
        this(new Object[]{k2, k3, k4}, false);
    }

    public ij_1(K k2, K k3, K k4, K k5) {
        this(new Object[]{k2, k3, k4, k5}, false);
    }

    public ij_1(K k2, K k3, K k4, K k5, K k6) {
        this(new Object[]{k2, k3, k4, k5, k6}, false);
    }

    private ij_1(K[] KArray) {
        this(KArray, true);
    }

    private ij_1(K[] KArray, boolean bl) {
        if (KArray == null) {
            throw new IllegalArgumentException("The array of keys must not be null");
        }
        this.a = bl ? (Object[])KArray.clone() : KArray;
        this.a(KArray);
    }

    private K[] b() {
        return (Object[])this.a.clone();
    }

    public final K a(int n2) {
        return this.a[n2];
    }

    public final int a() {
        return this.a.length;
    }

    public final boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (other instanceof ij_1) {
            ij_1 ij_12;
            ij_12 = ij_12;
            return Arrays.equals(this.a, ij_12.a);
        }
        return false;
    }

    public final int hashCode() {
        return this.c;
    }

    public final String toString() {
        return "MultiKey" + Arrays.toString(this.a);
    }

    private void a(Object[] objectArray) {
        int n2 = 0;
        for (Object object : objectArray) {
            if (object == null) continue;
            n2 ^= object.hashCode();
        }
        this.c = n2;
    }

    private ij_1 c() {
        ij_1 ij_12 = this;
        ij_12.a(ij_12.a);
        return this;
    }
}

