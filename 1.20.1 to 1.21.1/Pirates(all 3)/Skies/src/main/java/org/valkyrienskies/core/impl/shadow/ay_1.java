/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.function.Supplier;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.aY
 */
public final class ay_1<T> {
    private final Supplier<? extends T> a;
    private boolean b;
    private T c;

    public ay_1(Supplier<? extends T> supplier) {
        this.a = supplier;
        this.b = true;
    }

    public final T a() {
        if (this.b) {
            this.c = this.a.get();
            this.b = false;
        }
        return this.c;
    }
}

