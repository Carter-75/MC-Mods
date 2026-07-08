/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import org.valkyrienskies.core.impl.shadow.fb_2;
import org.valkyrienskies.core.impl.shadow.fq_1;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.gS
 */
public final class gs_1<T>
implements Serializable,
fq_1<T, T> {
    private static final long a = 478466901448617286L;
    private final fb_2<? super T> b;

    public static <T> fq_1<T, T> a(fb_2<? super T> fb_22) {
        if (fb_22 == null) {
            throw new NullPointerException("Closure must not be null");
        }
        return new gs_1<T>(fb_22);
    }

    private gs_1(fb_2<? super T> fb_22) {
        this.b = fb_22;
    }

    @Override
    public final T a(T t) {
        this.b.a(t);
        return t;
    }

    private fb_2<? super T> a() {
        return this.b;
    }
}

