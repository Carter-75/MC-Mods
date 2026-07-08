/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import org.valkyrienskies.core.impl.shadow.ff_1;
import org.valkyrienskies.core.impl.shadow.fk_2;
import org.valkyrienskies.core.impl.shadow.fq_1;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.hH
 */
public final class hh_1<T>
implements Serializable,
ff_1<T> {
    private static final long a = -2407966402920578741L;
    private final fq_1<? super T, Boolean> b;

    public static <T> ff_1<T> a(fq_1<? super T, Boolean> fq_12) {
        if (fq_12 == null) {
            throw new NullPointerException("The transformer to call must not be null");
        }
        return new hh_1<T>(fq_12);
    }

    private hh_1(fq_1<? super T, Boolean> fq_12) {
        this.b = fq_12;
    }

    @Override
    public final boolean a(T object) {
        if ((object = this.b.a(object)) == null) {
            throw new fk_2("Transformer must return an instanceof Boolean, it was a null object");
        }
        return (Boolean)object;
    }

    private fq_1<? super T, Boolean> a() {
        return this.b;
    }
}

