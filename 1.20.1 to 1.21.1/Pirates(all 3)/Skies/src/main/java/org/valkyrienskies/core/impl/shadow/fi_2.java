/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.fh_2;
import org.valkyrienskies.core.impl.shadow.gu_1;
import org.valkyrienskies.core.impl.shadow.gz_1;
import org.valkyrienskies.core.impl.shadow.hb_1;
import org.valkyrienskies.core.impl.shadow.hk_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.fi
 */
public final class fi_2 {
    private fi_2() {
    }

    private static <T> fh_2<T> a() {
        return gz_1.b();
    }

    private static <T> fh_2<T> b() {
        return gu_1.a(null);
    }

    private static <T> fh_2<T> a(T t) {
        return gu_1.a(t);
    }

    private static <T> fh_2<T> b(T t) {
        return hb_1.a(t);
    }

    public static <T> fh_2<T> a(Class<T> clazz) {
        return hk_2.a(clazz, null, null);
    }

    private static <T> fh_2<T> a(Class<T> clazz, Class<?>[] classArray, Object[] objectArray) {
        return hk_2.a(clazz, (Class[])classArray, (Object[])objectArray);
    }
}

