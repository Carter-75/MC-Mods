/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.fq_1;
import org.valkyrienskies.core.impl.shadow.hb_1;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.gR
 */
public final class gr_1<T>
implements fq_1<T, T> {
    private static gr_1 a = new gr_1();

    public static <T> fq_1<T, T> a() {
        return a;
    }

    private gr_1() {
    }

    @Override
    public final T a(T t) {
        if (t == null) {
            return null;
        }
        return hb_1.a(t).a();
    }
}

