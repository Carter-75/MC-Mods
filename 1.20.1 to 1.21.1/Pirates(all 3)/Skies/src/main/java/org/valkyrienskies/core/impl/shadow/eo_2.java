/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.cx_0;
import org.valkyrienskies.core.impl.shadow.dt_1;
import org.valkyrienskies.core.impl.shadow.ek_2;
import org.valkyrienskies.core.impl.shadow.ev_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.eo
 */
public final class eo_2<T>
implements dt_1<T>,
ek_2<T> {
    private static final eo_2<@cx_0 Object> a = new eo_2<Object>(null);
    private final T b;

    public static <T> ek_2<T> a(T instance) {
        return new eo_2<T>(ev_2.a(instance, "instance cannot be null"));
    }

    private static <T> ek_2<T> b(T instance) {
        if (instance == null) {
            return a;
        }
        return new eo_2<T>(instance);
    }

    private static <T> eo_2<T> a() {
        return a;
    }

    private eo_2(T instance) {
        this.b = instance;
    }

    @Override
    public final T get() {
        return this.b;
    }
}

