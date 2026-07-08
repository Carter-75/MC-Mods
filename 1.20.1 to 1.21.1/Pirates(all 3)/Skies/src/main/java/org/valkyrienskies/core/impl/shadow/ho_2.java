/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import org.valkyrienskies.core.impl.shadow.fb_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.ho
 */
public final class ho_2<E>
implements Serializable,
fb_2<E> {
    private static final long a = 3518477308466486130L;
    private static ho_2 b = new ho_2();

    public static <E> fb_2<E> a() {
        return b;
    }

    private ho_2() {
    }

    @Override
    public final void a(E e2) {
    }

    private static fb_2 b() {
        return b;
    }
}

