/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import org.valkyrienskies.core.impl.shadow.fh_2;
import org.valkyrienskies.core.impl.shadow.fk_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.gZ
 */
public final class gz_1<T>
implements Serializable,
fh_2<T> {
    private static final long a = 7179106032121985545L;
    private static gz_1 b = new gz_1();

    public static <T> fh_2<T> b() {
        return b;
    }

    private gz_1() {
    }

    @Override
    public final T a() {
        throw new fk_2("ExceptionFactory invoked");
    }

    private static fh_2 c() {
        return b;
    }
}

