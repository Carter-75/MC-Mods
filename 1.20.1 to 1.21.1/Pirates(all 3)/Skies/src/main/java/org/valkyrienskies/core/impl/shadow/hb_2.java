/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import org.valkyrienskies.core.impl.shadow.fk_2;
import org.valkyrienskies.core.impl.shadow.fq_1;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.hb
 */
public final class hb_2<I, O>
implements Serializable,
fq_1<I, O> {
    private static final long a = 7179106032121985545L;
    private static hb_2 b = new hb_2();

    public static <I, O> fq_1<I, O> a() {
        return b;
    }

    private hb_2() {
    }

    @Override
    public final O a(I i2) {
        throw new fk_2("ExceptionTransformer invoked");
    }

    private static fq_1 b() {
        return b;
    }
}

