/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import org.valkyrienskies.core.impl.shadow.fb_2;
import org.valkyrienskies.core.impl.shadow.fk_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.gY
 */
public final class gy_1<E>
implements Serializable,
fb_2<E> {
    private static final long a = 7179106032121985545L;
    private static gy_1 b = new gy_1();

    public static <E> fb_2<E> a() {
        return b;
    }

    private gy_1() {
    }

    @Override
    public final void a(E e2) {
        throw new fk_2("ExceptionClosure invoked");
    }

    private static fb_2 b() {
        return b;
    }
}

