/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

final class DI<T> {
    private final T a;

    public DI(T t) {
        this.a = t;
    }

    public final boolean equals(Object obj) {
        DI dI;
        if (!(obj instanceof DI)) {
            return false;
        }
        dI = dI;
        return this.a == dI.a;
    }

    public final int hashCode() {
        return System.identityHashCode(this.a);
    }
}

