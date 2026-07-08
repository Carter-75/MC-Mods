/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import java.util.Map;
import org.valkyrienskies.core.impl.shadow.fq_1;
import org.valkyrienskies.core.impl.shadow.gv_1;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.hn
 */
public final class hn_2<I, O>
implements Serializable,
fq_1<I, O> {
    private static final long a = 862391807045468939L;
    private final Map<? super I, ? extends O> b;

    public static <I, O> fq_1<I, O> a(Map<? super I, ? extends O> map2) {
        if (map2 == null) {
            return gv_1.a();
        }
        return new hn_2<I, O>(map2);
    }

    private hn_2(Map<? super I, ? extends O> map2) {
        this.b = map2;
    }

    @Override
    public final O a(I i2) {
        return this.b.get(i2);
    }

    private Map<? super I, ? extends O> a() {
        return this.b;
    }
}

