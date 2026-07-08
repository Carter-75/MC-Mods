/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import org.valkyrienskies.core.impl.shadow.ff_1;
import org.valkyrienskies.core.impl.shadow.fg_2;
import org.valkyrienskies.core.impl.shadow.hw_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.gX
 */
public final class gx_1<T>
implements Serializable,
ff_1<T> {
    private static final long a = 5633766978029907089L;
    private final T b;
    private final fg_2<T> c;

    public static <T> ff_1<T> b(T t) {
        if (t == null) {
            return hw_2.a();
        }
        return new gx_1<T>(t);
    }

    public static <T> ff_1<T> a(T t, fg_2<T> fg_22) {
        if (t == null) {
            return hw_2.a();
        }
        return new gx_1<T>(t, fg_22);
    }

    private gx_1(T t) {
        this(t, null);
    }

    private gx_1(T t, fg_2<T> fg_22) {
        this.b = t;
        this.c = fg_22;
    }

    @Override
    public final boolean a(T t) {
        if (this.c != null) {
            return this.c.a(this.b, t);
        }
        return this.b.equals(t);
    }

    private Object a() {
        return this.b;
    }
}

