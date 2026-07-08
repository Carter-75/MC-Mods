/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import org.valkyrienskies.core.impl.shadow.fb_2;
import org.valkyrienskies.core.impl.shadow.fq_1;
import org.valkyrienskies.core.impl.shadow.ho_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.hG
 */
public final class hg_1<E>
implements Serializable,
fb_2<E> {
    private static final long a = -5194992589193388969L;
    private final fq_1<? super E, ?> b;

    public static <E> fb_2<E> a(fq_1<? super E, ?> fq_12) {
        if (fq_12 == null) {
            return ho_2.a();
        }
        return new hg_1<E>(fq_12);
    }

    private hg_1(fq_1<? super E, ?> fq_12) {
        this.b = fq_12;
    }

    @Override
    public final void a(E e2) {
        this.b.a(e2);
    }

    private fq_1<? super E, ?> a() {
        return this.b;
    }
}

