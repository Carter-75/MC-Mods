/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Collection;
import org.valkyrienskies.core.impl.shadow.ff_1;
import org.valkyrienskies.core.impl.shadow.gk_1;
import org.valkyrienskies.core.impl.shadow.hf_2;
import org.valkyrienskies.core.impl.shadow.hi_1;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.hq
 */
public final class hq_2<T>
extends gk_1<T> {
    private static final long b = 2007613066565892961L;

    public static <T> ff_1<T> a(ff_1<? super T> ... ff_1Array) {
        hf_2.b(ff_1Array);
        if (ff_1Array.length == 0) {
            return hi_1.a();
        }
        return new hq_2<T>(hf_2.a(ff_1Array));
    }

    public static <T> ff_1<T> a(Collection<? extends ff_1<? super T>> ff_1Array) {
        if ((ff_1Array = hf_2.a(ff_1Array)).length == 0) {
            return hi_1.a();
        }
        return new hq_2(ff_1Array);
    }

    private hq_2(ff_1<? super T> ... ff_1Array) {
        super(ff_1Array);
    }

    @Override
    public final boolean a(T t) {
        ff_1<? super T>[] ff_1Array = this.a;
        int n2 = this.a.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            ff_1<T> ff_12 = ff_1Array[i2];
            if (!ff_12.a(t)) continue;
            return false;
        }
        return true;
    }
}

