/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import org.valkyrienskies.core.impl.shadow.fh_2;
import org.valkyrienskies.core.impl.shadow.fq_1;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.hc
 */
public final class hc_2<I, O>
implements Serializable,
fq_1<I, O> {
    private static final long a = -6817674502475353160L;
    private final fh_2<? extends O> b;

    public static <I, O> fq_1<I, O> a(fh_2<? extends O> fh_22) {
        if (fh_22 == null) {
            throw new NullPointerException("Factory must not be null");
        }
        return new hc_2<I, O>(fh_22);
    }

    private hc_2(fh_2<? extends O> fh_22) {
        this.b = fh_22;
    }

    @Override
    public final O a(I i2) {
        return this.b.a();
    }

    private fh_2<? extends O> a() {
        return this.b;
    }
}

